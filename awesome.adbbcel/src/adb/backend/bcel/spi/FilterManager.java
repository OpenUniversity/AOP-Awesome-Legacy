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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import com.sun.jdi.Field;
import com.sun.jdi.InconsistentDebugInfoException;
import com.sun.jdi.Location;
import com.sun.jdi.Method;

import adb.AdviceApplicationImpl;
import adb.HookFrameImpl;
import adb.InternalDebuggerException;
import adb.NotAnAspectException;
import adb.ShadowMaster;
import adb.StackFrameImpl;
import adb.backend.AdviceDescriptor;
import adb.backend.bcel.BCELBackend;
import adb.backend.bcel.CrossCuttingAttribute;
import adb.backend.bcel.JoinPointDescriptor;
import adb.backend.spi.AbstractFilterManager;
import adb.event.state.StackFormatException;
import adb.event.state.StateManager;
import ajdi.Advice;
import ajdi.AdviceApplication;
import ajdi.HookFrame;
import ajdi.JoinPoint;
import ajdi.StackFrame;
import ajdi.ThreadReference;

public class FilterManager extends AbstractFilterManager implements
		adb.backend.StackFilterManager, adb.backend.FilterManager {

	private AspectInfoProvider aip;
	private StackFilterDelegate sfd;

	public FilterManager(BCELBackend back, AspectInfoProvider aip) {
		super();
		this.aip = aip;
		this.sfd = new StackFilterDelegate(this);
	}

	public void setShadowMaster(ShadowMaster master) {
		super.setShadowMaster(master);
		sfd.setShadowMaster(master);
	}

	// TODO incremental works
	public List<StackFrame> filterFrames(List<com.sun.jdi.StackFrame> frames) {
		List<StackFrame> out = new LinkedList<StackFrame>();

		if (frames.isEmpty())
			return out;

		StateManager gstate = master.state;

		com.sun.jdi.ThreadReference jthread = frames.get(0).thread();
		ThreadReference athread = master.wrap(jthread);

		ListIterator<com.sun.jdi.StackFrame> framesIt = frames
				.listIterator(frames.size());

		synchronized (gstate) {
			Stack<adb.event.state.JoinPoint> state = gstate
					.getStateFor(athread);
			/*
			 * if(state != null){ StateManager.check(master, frames, state); }
			 */
			if (state != null && !state.isEmpty()) {
				try {
					sfd.filter(framesIt, out, state);
				} catch (StackFormatException e) {
					throw new InternalDebuggerException("Stack Format failed",
							e);
				} catch (StaleDataException e) {
					state.pop();
					System.out.println("stale date");
					try {
						sfd.filter(framesIt, out, state);
					} catch (StackFormatException e1) {
						throw new InternalDebuggerException("Stack Format failed",
								e);
					} catch (StaleDataException e1) {
						throw new InternalDebuggerException("Double stale data",
								e);
					}

				}
			} else {

				while (framesIt.hasPrevious()) {
					out.add(wrap(framesIt.previous()));
				}
			}
		}
		Collections.reverse(out);
		return out;
	}

	StackFrame wrap(com.sun.jdi.StackFrame frame) {
		return new StackFrameImpl(frame, master);
	}

	AdviceDescriptor getAdvice(Method method) {
		if (aip.isAspect(method.declaringType().name())) {
			try {
				List<AdviceDescriptor> descr = aip.getAdvicesFor(method
						.declaringType().name());
				for (AdviceDescriptor adviceDescriptor : descr) {
					if (adviceDescriptor.getContainer().getMethodname().equals(method.name())
							&& adviceDescriptor.getContainer().getMethodsig().equals(method
									.signature()))
						return adviceDescriptor;
				}
			} catch (NotAnAspectException e) {
				throw new InternalDebuggerException(
						"is an aspect, but is not an aspect: "
								+ method.declaringType().name());
			}

		}
		return null;
	}

	boolean isConstruct(Method method) {
		if (method.name().contains("et$accessor$"))
			return true;
		if (method.name().contains("abc$"))
			return true;
		if (method.name().contains("proceed$"))
			return true;
		if (method.name().contains("if$"))
			return true;
		if (method.name().contains("shadow$"))
			return true;
		if (method.declaringType().name().startsWith("org.aspectbench."))
			return true;
		
		// AJC 
		//if (method.name().contains("ajc$around$"))
		//	return true;
		//if (method.name().contains("aroundBody0"))
		//	return true;
		//

		if (aip.isAspect(method.declaringType().name())) {
			if (method.name().equals("hasAspect")
					|| method.name().equals("aspectOf"))
				return true;
		}

		return false;
	}

	public Field filterField(Field field) {
		if (field.name().contains("abc$"))
			return null;
		return field;
	}

	public Method filterMethod(Method method) {
		if (isConstruct(method))
			return null;
		if (getAdvice(method) != null)
			return null;
		return method;
	}

}
