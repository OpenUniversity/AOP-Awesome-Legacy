/**
 * AODA - Aspect Oriented Debugging Architecture
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
package adb.event.state;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.sun.jdi.ClassNotPreparedException;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.Location;
import com.sun.jdi.StackFrame;

import adb.InternalDebuggerException;
import adb.JoinPointImpl;
import adb.NotAnAspectException;
import adb.RangeImpl;
import adb.ShadowMaster;
import adb.backend.LocationDescriptor;
import adb.backend.MethodIdentifier;
import adb.event.AJDIEventActor;
import adb.event.EventManager;
import adb.event.JDIEventActor;
import adb.event.JDIEventTransformer;
import adb.event.AJDIEventTransformer;
import adb.tools.InterMap;
import adb.tools.Pair;
import ajdi.Advice;
import ajdi.Aspect;
import ajdi.AspectInstance;
import ajdi.Method;
import ajdi.ObjectReference;
import ajdi.ReferenceType;
import ajdi.StmtJoinPoint;
import ajdi.ThreadReference;
import ajdi.event.BreakpointEvent;
import ajdi.event.ClassPrepareEvent;
import ajdi.event.Event;
import ajdi.event.EventSet;
import ajdi.event.JoinPointEntryEvent;
import ajdi.event.JoinPointExitEvent;
import ajdi.event.MethodEntryEvent;
import ajdi.event.ThreadDeathEvent;
import ajdi.request.BreakpointRequest;
import ajdi.request.ClassPrepareRequest;
import ajdi.request.EventRequest;
import ajdi.request.EventRequestManager;
import ajdi.request.JoinPointEntryRequest;
import ajdi.request.JoinPointExitRequest;
import ajdi.request.MethodEntryRequest;
import ajdi.request.ThreadDeathRequest;

public class StateManager {
	
	public static final int PRIO_ADVICE = 5;
	public static final int PRIO_ENTER = 1000;
	public static final int PRIO_TARGET = 10000;
	
	public static final int PRIO_EXIT = 100;
	

	public void setEventRequestManager(com.sun.jdi.request.EventRequestManager nem, EventRequestManager iem) {
		this.nativeEventRequestManager = nem;
		this.internalEventRequestManager = iem;
	}

	public void setEventManager(EventManager manager) {
		this.manager = manager;
	}

	// must synch on this
	public Stack<JoinPoint> getStateFor(ThreadReference thread) {
		return state.get(thread);
	}

	private com.sun.jdi.request.EventRequestManager nativeEventRequestManager;
	private ajdi.request.EventRequestManager internalEventRequestManager;
	private EventManager manager;
	private ShadowMaster master;

	private Map<ajdi.ThreadReference, Stack<JoinPoint>> state = new HashMap<ajdi.ThreadReference, Stack<JoinPoint>>();

	public void init() {
		ThreadDeathRequest tdr = internalEventRequestManager
				.createThreadDeathRequest();
		manager.setActor(tdr, new ThreadDeathListener());
		tdr.setSuspendPolicy(EventRequest.SUSPEND_NONE);
		tdr.enable();

		ClassPrepareRequest cpr = internalEventRequestManager
				.createClassPrepareRequest();
		cpr.addClassExclusionFilter("java.*");
		cpr.addClassExclusionFilter("sun.*");
		manager.setActor(cpr, new ClassPrepareListener());
		// cpr.setSuspendPolicy(EventRequest.SUSPEND_NONE);
		cpr.enable();
	}

	public class ThreadDeathListener implements AJDIEventActor {

		@Override
		public void receive(Event event) {
			ThreadDeathEvent evt = (ThreadDeathEvent) event;
			removeThread(evt.thread());
		}

		@Override
		//notify death last
		public int priority() {
			return 10000;
		}

	}

	public class ClassPrepareListener implements AJDIEventActor {

		@Override
		public void receive(Event event) {
			ClassPrepareEvent cpe = (ClassPrepareEvent) event;
			listenFor(cpe.referenceType());
		}

		@Override
		public int priority() {
			return 10;
		}
	}

	private synchronized void removeThread(ThreadReference thread) {
		state.remove(thread);
	}

	private synchronized void listenFor(ReferenceType clazz) {
		if (clazz instanceof Aspect) {
			listenFor((Aspect) clazz);
		}

		for (Method meth : clazz.methods()) {
			for (ajdi.JoinPoint jpd : meth.allJoinPoints()) {
				listenFor(jpd);
			}
		}
	}

	private void listenFor(ajdi.JoinPoint jpd) {
		listenForEntry(jpd);
		listenForTarget(jpd);
		listenForExit(jpd);
	}

	private void listenForTarget(ajdi.JoinPoint jpd) {
		JoinPointImpl jp = (JoinPointImpl) jpd;
		LocationDescriptor shadow = jp.shadow();
		
		MethodIdentifier methodInfo = shadow.getMethod();
		
		com.sun.jdi.ClassType clazz = master.getBaseClassFor(methodInfo.getClazz());
		com.sun.jdi.Method method = clazz.concreteMethodByName(methodInfo.getMethodname(), methodInfo.getMethodsig());
		
		/*if (jpd instanceof StmtJoinPoint) {*/
			com.sun.jdi.request.BreakpointRequest bpr = nativeEventRequestManager
					.createBreakpointRequest(method.locationOfCodeIndex(shadow.getStartCodeIndex()));
			bpr.setSuspendPolicy(EventRequest.SUSPEND_NONE);
			manager.setActor(bpr, new StmtShadowListener(jpd));
			bpr.enable();
		/*}else{
			com.sun.jdi.request.MethodEntryRequest bpr = nativeEventRequestManager
			.createMethodEntryRequest();
			bpr.setSuspendPolicy(EventRequest.SUSPEND_NONE);
			bpr.addClassFilter(clazz);
			manager.setActor(bpr, new MethodShadowListener(jpd,method));
			bpr.enable();
		}*/
	}


	public class MethodShadowListener implements JDIEventActor {
		
		private ajdi.JoinPoint jpd;
		private com.sun.jdi.Method meth;

		public MethodShadowListener(ajdi.JoinPoint jpd,com.sun.jdi.Method meth) {
			this.jpd = jpd;
			this.meth = meth;
		}

		@Override
		public void receive(com.sun.jdi.event.Event event) {
			com.sun.jdi.event.MethodEntryEvent evt = (com.sun.jdi.event.MethodEntryEvent)event;
			if(evt.method().equals(meth)){
				System.out.println(evt.location().toString()+" " + evt.location().codeIndex());
				fileTarget(jpd,master.wrap(evt.thread()));
			}
				
		}

		@Override
		//target first, then next JP
		public int priority() {
			return PRIO_TARGET;
		}

	}
	
	public class StmtShadowListener implements JDIEventActor {

		private ajdi.JoinPoint jpd;

		public StmtShadowListener(ajdi.JoinPoint jpd) {
			this.jpd = jpd;
		}

		@Override
		public void receive(com.sun.jdi.event.Event event) {
			com.sun.jdi.event.BreakpointEvent evt = (com.sun.jdi.event.BreakpointEvent)event;
			//System.out.println(evt.location().toString()+" " + evt.location().codeIndex());
			fileTarget(jpd,master.wrap(evt.thread()));
		}

		@Override
		//target first, then next JP
		public int priority() {
			return PRIO_TARGET;
		}

	}
	
	private void fileTarget(ajdi.JoinPoint jpd, ThreadReference thread) {
		//System.out.println("hit target: " + jpd);
		Stack<JoinPoint> stack = state.get(thread);
		if (stack == null) {
			stack = new Stack<JoinPoint>();
			state.put(thread, stack);
		}
		try {
			JoinPoint jp = stack.peek();
			if (!jpd.equals(jp.jpd))
				throw new InternalDebuggerException("targetting wrong breakpoint");
			jp.target();
		} catch (EmptyStackException e) {
			throw new InternalDebuggerException(
					"proceed entered, but no joinpoint start received, possible inconsistent weaving");
		}
	}
	
	private void listenForExit(ajdi.JoinPoint jpd) {
		JoinPointExitRequest bpr = internalEventRequestManager
				.createJoinPointExitRequest(jpd);
		bpr.setSuspendPolicy(EventRequest.SUSPEND_NONE);
		manager.setActor(bpr, exitListener);
		bpr.enable();

	}

	private AJDIEventActor exitListener = new JPExitListener();

	public class JPExitListener implements AJDIEventActor {

		@Override
		public void receive(ajdi.event.Event event) {
			JoinPointExitEvent req = (JoinPointExitEvent) event;
			//System.out.println(req.location().toString()+" " + req.location().codeIndex());
			unfileJoinpoint(req.thread(), req.joinPoint());
		}

		@Override
		//first target, then exit, then enter
		public int priority() {
			return PRIO_EXIT;
		}

	}

	private synchronized void unfileJoinpoint(ajdi.ThreadReference thread,
			ajdi.JoinPoint jpd2) {
		//System.out.println("leave : " + jpd2);
		Stack<JoinPoint> stack = state.get(thread);
		if (stack == null) {
			throw new InternalDebuggerException(
					"joinpoint left, but thread not mapped, invalid state");
		}

		JoinPoint jpd;

		if (stack.peek().complete)
			stack.pop();

		synchronized (this) {
			if (thread.isSuspended()) {
				jpd = stack.peek();
				jpd.complete = true;
			} else
				jpd = stack.pop();
		}

		if (!jpd.jpd.equals(jpd2))
			throw new InternalDebuggerException("leaving wrong breakpoint");

	}

	private void listenForEntry(ajdi.JoinPoint jpd) {
		JoinPointEntryRequest bpr = internalEventRequestManager
				.createJoinPointEntryRequest(jpd);
		bpr.setSuspendPolicy(EventRequest.SUSPEND_NONE);
		manager.setActor(bpr, entryListener);
		bpr.enable();
	}

	private JPEntryListener entryListener = new JPEntryListener();

	public class JPEntryListener implements AJDIEventActor {

		@Override
		public void receive(ajdi.event.Event event) {
			JoinPointEntryEvent req = (JoinPointEntryEvent) event;
			//System.out.println(req.location().toString()+" " + req.location().codeIndex());
			fileJoinpoint(req.thread(), req.joinPoint());
		}

		@Override
		//first leave, mark target, then enter  
		public int priority() {
			return PRIO_ENTER;
		}

	}

	private synchronized void fileJoinpoint(ajdi.ThreadReference thread,
			ajdi.JoinPoint jpd) {
		//System.out.println("enter: " + jpd);
		Stack<JoinPoint> stack = state.get(thread);
		if (stack == null) {
			stack = new Stack<JoinPoint>();
			state.put(thread, stack);
		} else {
			check(stack);
		}
		stack.push(new JoinPoint(jpd));

	}

	private void listenFor(Aspect aspect) {
		ajdi.request.MethodEntryRequest merq = internalEventRequestManager
				.createMethodEntryRequest();
		merq.addClassFilter(aspect);
		merq.setSuspendPolicy(EventRequest.SUSPEND_EVENT_THREAD);

		manager.setActor(merq, adviceListener);
		merq.enable();
	}

	private AdviceListener adviceListener = new AdviceListener();

	private synchronized void fileAdvice(ajdi.ThreadReference thread,
			Advice advice, AspectInstance aspect) 
	{
		//System.out.println("hit advice: " +advice);
		
		/*
		try 
		{
			List<ajdi.StackFrame> frames;
			frames = thread.frames();
			System.out.println("---------------------------------------------------");
			for(ajdi.StackFrame frame : frames)
			{
				System.out.println(frame.location().method());
			}
			System.out.println("---------------------------------------------------");
			
		} catch (IncompatibleThreadStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		
		
		
		Stack<JoinPoint> stack = state.get(thread);
		if (stack == null) {
			stack = new Stack<JoinPoint>();
			state.put(thread, stack);
		}
		try {
			JoinPoint jp = stack.peek();
			
			jp.advs.add(new Pair<Advice, AspectInstance>(advice,aspect));
			try
			{
				if (!jp.validate()) {
					//System.out.println("FCK");
					throw new InternalDebuggerException(
							"advice entered, but in wrong joinpoint: " + jp.jpd);
				}
			}
			catch (ClassNotPreparedException e)
			{
				// don't fail the validation if one of the aspects advising this JP
				// is not prepared yet
				
			}

		} 
		catch (EmptyStackException e) 
		{						
			throw new InternalDebuggerException(
					"advice entered, but no joinpoint start received, possible inconsistent weaving");
		}

	}

	public class AdviceListener implements AJDIEventActor {

		@Override
		public void receive(ajdi.event.Event event) {
			MethodEntryEvent req = (MethodEntryEvent) event;			
			Method m = req.method();
			
			if (!(m instanceof Advice))
				return;
			
			try {
				com.sun.jdi.ObjectReference ref = master.unwrap(req.thread()).frame(0).thisObject();
				
				ObjectReference aref = master.wrap(ref);

				if(!(aref instanceof AspectInstance))
					throw new InternalDebuggerException("this is not an aspect instance:" + aref);			
				//System.out.println(req.location().toString()+" " + req.location().codeIndex());
				fileAdvice(req.thread(), (Advice) m,(AspectInstance)aref);
			} catch (IncompatibleThreadStateException e) {
				throw new InternalDebuggerException("thread not halted" ,e);	
			}
			
		}

		@Override
		//first advice, then target, then exit, then enter
		public int priority() {
			return PRIO_ADVICE;
		}

	}

	private void check(Stack<JoinPoint> stack) {
		try {
			JoinPoint jp = stack.peek();
			if (jp.complete) {
				stack.pop();
			}
		} catch (EmptyStackException e) {

		}
	}

	public static void check(ShadowMaster master, List<StackFrame> frames,
			Stack<JoinPoint> stack) {
		try {
			JoinPoint jp = stack.peek();
			if (!jp.complete)
				return;
			StackFrame top = frames.get(0);
			Location topl = top.location();
			Location jpdl = master.unwrap(jp.jpd.location());
			if (!topl.method().equals(jpdl.method())) {
				stack.pop();
				return;
			}
			if (topl.codeIndex() != jpdl.codeIndex()) {
				stack.pop();
			}

		} catch (EmptyStackException e) {

		}
	}

	/*
	 * @Override public synchronized boolean threadResumed(ThreadReference
	 * thread) { Stack<JoinPoint> stack = state.get(thread); if (stack == null)
	 * { return true; } try { JoinPoint jp = stack.peek(); if (jp.complete) {
	 * stack.pop(); } } catch (EmptyStackException e) {
	 * 
	 * }
	 * 
	 * return true; }
	 */

	public void check(ShadowMaster master, List<StackFrame> frames,
			ThreadReference thread) {
		check(master, frames, getStateFor(thread));
	}

	public void setShadowMaster(ShadowMaster shadowMaster) {
		this.master = shadowMaster;
	}

	/*
	 * public void push() { for (Stack<JoinPoint> jps : state.values()) { try {
	 * if (jps.peek().complete) jps.pop(); } catch (EmptyStackException e) {
	 * 
	 * } } }
	 */

}
