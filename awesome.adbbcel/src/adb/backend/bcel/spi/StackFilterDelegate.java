/**
 * AODA - Aspect Oriented Debugging Architecture, BCEL/AspectJ component
 * Copyright (C) 2007-2009 Wouter De Borger
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package adb.backend.bcel.spi;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import adb.AdviceImpl;
import adb.HookFrameImpl;
import adb.InternalDebuggerException;
import adb.PastAdviceImpl;
import adb.ShadowMaster;
import adb.event.state.StackFormatException;
import adb.tools.InterList;
import adb.tools.Pair;
import adb.tools.SelectiveList;
import ajdi.Advice;
import ajdi.AdviceApplication;
import ajdi.AspectInstance;
import ajdi.Method;
import ajdi.ObjectReference;
import ajdi.PastAdvice;
import ajdi.StackFrame;
import ajdi.Value;

import com.sun.jdi.ClassNotPreparedException;

/**
 * @author wouterdb
 * 
 */
public class StackFilterDelegate {

	private FilterManager owner;
	private ShadowMaster master;

	public StackFilterDelegate(FilterManager owner) {
		this.owner = owner;
	}

	boolean isAjcConstruct(com.sun.jdi.Method method)
	{
		if (method.name().contains("ajc$around$"))
			return true;
		if (method.name().contains("aroundBody0"))
			return true;
		if (method.declaringType().name().contains("$AjcClosure"))
			return true;
		
		return false;		
	}
	
	/**
	 * @param frames
	 *            non emtpy, in list, traverse backward
	 * @param out
	 *            output
	 * @param state
	 *            current state, non empty traverse forward
	 * @throws StackFormatException
	 * @throws StaleDataException
	 */
	public void filter(ListIterator<com.sun.jdi.StackFrame> frames,
			List<StackFrame> out, List<adb.event.state.JoinPoint> state)
			throws StackFormatException, StaleDataException {
		ListIterator<adb.event.state.JoinPoint> stateIt = state.listIterator();
		while (frames.hasPrevious()) {
			com.sun.jdi.StackFrame frame = frames.previous();
			com.sun.jdi.Method method = frame.location().method();

			// drop constructs
			if (owner.isConstruct(method) || isAjcConstruct(method))
				continue;
			
			

			boolean found = processJoinpointIfAny(frames, out, stateIt, frame,new Stack<AdviceApplication>());

			if (!found)
				out.add(wrap(frame));
		}

		// Collections.reverse(out);
	}

	/**
	 * if joinpoint => push entry + hook
	 * if !joinpoint => niks
	 * 
	 * @param frames
	 * @param out
	 * @param state
	 * @param frame
	 * @return
	 * @throws StackFormatException
	 * @throws StaleDataException
	 */
	private boolean processJoinpointIfAny(
			ListIterator<com.sun.jdi.StackFrame> frames, List<StackFrame> out,
			ListIterator<adb.event.state.JoinPoint> state,
			com.sun.jdi.StackFrame frame,Stack<AdviceApplication> depth) throws StackFormatException,
			StaleDataException {

		if (!state.hasNext())
			return false;
		// find next joinpoint
		adb.event.state.JoinPoint nextJP = state.next();
		//FIXME: potentieel fout: 2 keer zelfde methode, een keer met adv een keer zonder
		if (master.unwrap(nextJP.jpd.location().method()).equals(
				frame.location().method())) {
			// found; should do
			pushHookFrame(frames, out, frame, nextJP, state,depth);
			return true;
		}
		state.previous();
		return false;
	}

	private void pushHookFrame(ListIterator<com.sun.jdi.StackFrame> frames,
			List<StackFrame> out, com.sun.jdi.StackFrame entry,
			adb.event.state.JoinPoint jp,
			ListIterator<adb.event.state.JoinPoint> state, Stack<AdviceApplication> depth)
			throws StackFormatException, StaleDataException {

		if (!jp.validate())
			throw new InternalDebuggerException("invalid joinpoint state");

		// add entry
		//out.add(wrap(entry));

		List<PastAdvice> pas = new LinkedList<PastAdvice>();

		ListIterator<AdviceApplication> aaplIt = jp.jpd.advices()
				.listIterator();
		ListIterator<Pair<Advice, AspectInstance>> stateIt = jp.advs
				.listIterator();

		boolean seenAfter = false;
		

		while (stateIt.hasNext()) {
			Pair<Advice, AspectInstance> nextRanAdviceP = stateIt.next();
			Advice nextRanAdvice = nextRanAdviceP.getFirst();
			if (nextRanAdvice.isAfter())
				seenAfter = true;
			boolean foundIt = false;
			while (aaplIt.hasNext() && !foundIt) {
				AdviceApplication aapl = aaplIt.next();

				if (aapl.advice().equals(nextRanAdvice)) {
					foundIt = true;
					makeHitPastAdvice(pas, aapl, frames, state, nextRanAdviceP
							.getSecond(),depth,!aaplIt.hasNext(),!stateIt.hasNext(),jp.complete,jp.hit);
				} else {
					makePassedPastAdvice(pas, aapl, frames,depth);
				}
			}
		}

		boolean inTarget = false;
		while (aaplIt.hasNext()) {
			// some advices left unhandled
			if (jp.complete) {
				if (jp.hit) {
					// all done, so they didn't evaluate
					try {
						// still on stack
						makePassedPastAdvice(pas, aaplIt.next(), frames,depth);
					} catch (StackFormatException e) {
						// joinpoint no longer on stack, failed on first frame,
						// report
						throw new StaleDataException(e);
					}
				} else {
					// broken control flow, proceed not called
					makeSkippedPastAdvice(pas, aaplIt.next());
				}
			} else {
				AdviceApplication aaplt = aaplIt.next();
				try {
					if (jp.hit) {
						// after target
						if (!aaplt.advice().isAfter()) {
							makePassedPastAdvice(pas, aaplt, frames,depth);
						} else {
							if (!seenAfter) {
								// first after advice
								seenAfter = true;
								if (frames.hasPrevious())
									// more frames to come, hit target and
									// haven't left it => in target
									inTarget = true;
							}
							// after advices, can be skipped, can be unreached,
							// unimportant distinction
						}
					} else {
						// before target
						if (aaplt.advice().isAfter()) {
							// after advices, not yet reachable
							break;
						} else {
							// not yet reached, do nothing
						}
					}
				} catch (ClassNotPreparedException e) {
					// aspect not there, so not yet reached
				}
			}

		}

		out.add(new HookFrameImpl(master, wrap(entry), jp.jpd, pas, jp.hit));
	}

	private StackFrame wrap(com.sun.jdi.StackFrame entry) {
		return owner.wrap(entry);
	}

	/**
	 * hit past advice
	 * 
	 * -still on stack 
	 * 	-and executing (top) 
	 * 	-and not executing (not top)
	 * 
	 * -gone
	 * 
	 * @param pas
	 *            current list of past advices
	 * @param aapl
	 *            the related AAPL
	 * @param frames
	 *            stack trace, travers backwards
	 * @param state
	 *            state
	 * @param ai
	 *            aspect instance
	 * @param depth 
	 * @throws StackFormatException
	 */
	private void makeHitPastAdvice(List<PastAdvice> pas,
			AdviceApplication aapl,
			ListIterator<com.sun.jdi.StackFrame> frames,
			ListIterator<adb.event.state.JoinPoint> state, 
			AspectInstance ai, 
			Stack<AdviceApplication> depth,
			boolean lastInChain,
			boolean lastRan,
			boolean chainComplete,
			boolean hitTarget
			)
			throws StackFormatException {
		

		/**
		 * -still on stack(subchain?, next frame)
		 * 	-and executing (subchain?,top) 
		 * 	-and not executing (subchain?,not top, around: Shadow/Entry [around] [Shadow/Taget] )
		 * 
		 * -gone (fell back to target (top); part of erased subchain (chain on non around);before|after and (not last or top))
		 **/
		
		
		
		if (!frames.hasPrevious()) {
			// on top of the stack, advice is gone: before or after or (arround and no proceed)
			pas.add(new PastAdviceImpl(aapl, ai, 
					Collections.<Value> emptyList(), 
					Collections.<StackFrame> emptyList()));
			
			return;
		}
		
		/**
		 * -still on stack(subchain?, next frame)
		 * 	-and executing (subchain?,top) 
		 * 	-and not executing (subchain?,not top, around: Shadow/Entry [around] [Shadow/Target] )
		 * 
		 * -gone (part of erased subchain (chain on non around)); before|after and not last)
		 **/
		
		if(depth.size() > 1 && !depth.peek().advice().isAround()){
			pas.add(new PastAdviceImpl(aapl, ai, 
					Collections.<Value> emptyList(), 
					Collections.<StackFrame> emptyList()));
			return;
		}
		
		/**
		 * -still on stack(subchain?, next frame)
		 * 	-and executing (subchain?,top) 
		 * 	-and not executing (subchain?,not top, around: Shadow/Entry [around] [Shadow/Target] )
		 * 
		 * -gone (before|after and not last)
		 **/
		
		if((aapl.advice().isBefore() || aapl.advice().isAfter()) && !lastRan ){
			pas.add(new PastAdviceImpl(aapl, ai, 
					Collections.<Value> emptyList(), 
					Collections.<StackFrame> emptyList()));
			return;
		}
		
		/**
		 * -still on stack(subchain?, next frame)
		 * 	-and executing (subchain?,top) 
		 * 	-and not executing (subchain?,not top, around: Shadow/Entry [around] [Shadow/Target] )
		 **/
		
		com.sun.jdi.StackFrame current = frames.previous();
		
		
		List<StackFrame> out = new LinkedList<StackFrame>();

		
		try {
			depth.push(aapl);
			if(!processJoinpointIfAny(frames, out, state, current,depth))
				//add entry
				out.add(wrap(current));
			depth.pop();
		} catch (StaleDataException e) {
			new StackFormatException("stale data lower than top level", e);
		}
		
		/**
		 * -still on stack (current frame) {and pushed into out}
		 * 	-and executing (top) 
		 * 	-and not executing (not top, around: Shadow/Entry [around] [Shadow/Target] )
		 **/

		//assert current frame
		
		Method m = master.wrap(current.location().method());
		if (!(m instanceof Advice))
			throw new InternalDebuggerException("not an advice: " + m);
		if(! aapl.advice().equals(m))
			throw new InternalDebuggerException("wrong advice; got: " + m +" but expected: " + aapl.advice());

		/**
		 * -still on stack {and pushed into out}
		 * 	-and executing (top) 
		 * 	-and not executing (not top, around)
		 **/
		
		List<Value> args = new InterList<com.sun.jdi.Value, Value>(
				new SelectiveList<com.sun.jdi.Value>(current.getArgumentValues(),
						((AdviceImpl) m).argIndices), master
						.getValueConverter());
		pas.add(new PastAdviceImpl(aapl, ai, args, out));
		
		if (aapl.advice().isAround()) {
			if (frames.hasPrevious())
				assertProceed(frames);
			if (frames.hasPrevious())
				assertShadow(frames);
		}

	}

	private void makePassedPastAdvice(List<PastAdvice> pas,
			AdviceApplication aapl, ListIterator<com.sun.jdi.StackFrame> frames,Stack<AdviceApplication> depth)
			throws StackFormatException {
		if (aapl.advice().isAround()) {
			if (frames.hasPrevious())
				assertProceed(frames);
			if (frames.hasPrevious())
				assertShadow(frames);
		}

		pas.add(new PastAdviceImpl(aapl, false));

	}

	private void makeSkippedPastAdvice(List<PastAdvice> pas,
			AdviceApplication aapl) {
		pas.add(new PastAdviceImpl(aapl, true));

	}

	private void assertShadow(ListIterator<com.sun.jdi.StackFrame> frames)
			throws StackFormatException {
		/*com.sun.jdi.StackFrame sf = frames.previous();
		String name = sf.location().method().name();
		if (!(name.contains("shadow$") || !name.contains("$")))
			throw new StackFormatException("no proceed: "
					+ sf.location().method());*/
		// TBD see if relevant for AJC
		

	}

	private void assertProceed(ListIterator<com.sun.jdi.StackFrame> frames)
			throws StackFormatException 
	{
		/*
		com.sun.jdi.StackFrame sf = frames.previous();
		if (!sf.location().method().name().contains("$proceed$"))
			throw new StackFormatException("no proceed: "
					+ sf.location().method());
		*/
		// TBD see if relevant for AJC
	}

	/*
	 * private void unAssertAdvice(ListIterator<com.sun.jdi.StackFrame> frames)
	 * throws StackFormatException { com.sun.jdi.StackFrame sf =
	 * frames.previous(); if (master.wrap(sf.location().method()) instanceof
	 * Advice) throw new StackFormatException("advice instead of proceed: " +
	 * sf.location().method());
	 * 
	 * }
	 */

	public void setShadowMaster(ShadowMaster master) {
		this.master = master;

	}

}
