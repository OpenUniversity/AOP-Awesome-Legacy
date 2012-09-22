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
package adb.event;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JDialog;

import adb.InternalDebuggerException;
import adb.ShadowMaster;
import adb.backend.AspectInfoProvider;
import adb.backend.FilterManager;
import adb.event.passive.AccessWatchpointEventImpl;
import adb.event.passive.BreakpointEventImpl;
import adb.event.passive.ClassPrepareEventImpl;
import adb.event.passive.ClassUnloadEventImpl;
import adb.event.passive.EventQueueImpl;
import adb.event.passive.EventSetImpl;
import adb.event.passive.ExceptionEventImpl;
import adb.event.passive.MethodEntryEventImpl;
import adb.event.passive.MethodExitEventImpl;
import adb.event.passive.ModificationWatchpointEventImpl;
import adb.event.passive.StepEventImpl;
import adb.event.passive.ThreadDeathEventImpl;
import adb.event.passive.ThreadStartEventImpl;
import adb.event.passive.ThreadedEvent;
import adb.event.passive.VMDeathEventImpl;
import adb.event.passive.VMDisconnectEventImpl;
import adb.event.passive.VMStartEventImpl;

import adb.tools.Pair;

import com.sun.jdi.Method;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.event.BreakpointEvent;
import com.sun.jdi.event.ClassPrepareEvent;
import com.sun.jdi.event.ClassUnloadEvent;
import com.sun.jdi.event.Event;
import com.sun.jdi.event.EventQueue;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.event.ExceptionEvent;
import com.sun.jdi.event.LocatableEvent;
import com.sun.jdi.event.MethodEntryEvent;
import com.sun.jdi.event.MethodExitEvent;
import com.sun.jdi.event.ThreadDeathEvent;
import com.sun.jdi.event.ThreadStartEvent;
import com.sun.jdi.event.VMStartEvent;
import com.sun.jdi.event.WatchpointEvent;
import com.sun.jdi.request.EventRequest;

public class TransparentEventManager implements EventManager {

	
	private final Object transformerHandle = new Object();
	private final Object internalHandle = new Object();
	public final Object ignoreHandle = new Object();
	
	private final EventRequest vmRequestHandle;

	public void setTransformer(EventRequest req, JDIEventTransformer trans) {
		req.putProperty(transformerHandle, trans);
		req.putProperty(ignoreHandle, ignoreHandle);
	}
	
	public void setActor(com.sun.jdi.request.EventRequest req, JDIEventActor trans) {
		req.putProperty(transformerHandle, trans);
		req.putProperty(ignoreHandle, ignoreHandle);
	}

	public void setActor(ajdi.request.EventRequest req, AJDIEventActor trans) {
		req.putProperty(internalHandle, trans);
		req.putProperty(ignoreHandle, ignoreHandle);
	}

	public void setTransformer(ajdi.request.EventRequest req,
			AJDIEventTransformer trans) {
		req.putProperty(internalHandle, trans);
		req.putProperty(ignoreHandle, ignoreHandle);
	}

	private ShadowMaster master;
	private com.sun.jdi.request.EventRequestManager inReq;
	// private adb.request.passive.EventRequestManagerImpl outReq;
	private EventQueue inQ;
	private EventQueueImpl outQ = new EventQueueImpl(master);
	
	private List<JDIEventTransformer> startUpTransformers = new LinkedList<JDIEventTransformer>();

	public TransparentEventManager(ShadowMaster master) {
		this.master = master;
		
		this.inQ = master.getVirtualMachine().eventQueue();
		// this.outReq = outReq;
		this.inReq = master.getVirtualMachine().eventRequestManager();
		vmRequestHandle = new EventRequest(){

			

			@Override
			public void addCountFilter(int count) {
			}

			@Override
			public void disable() {
			}

			@Override
			public void enable() {
			}

			@Override
			public Object getProperty(Object key) {
				return null;
			}

			@Override
			public boolean isEnabled() {
				return true;
			}

			@Override
			public void putProperty(Object key, Object value) {
				if(key == ignoreHandle)
					return;
				if(key == transformerHandle)
					if(!(value instanceof JDIEventTransformer)){
						startUpTransformers.add((JDIEventTransformer)value);
						return;
					}else{
						throw new InternalDebuggerException("can't be reached");
					}
				throw new UnsupportedOperationException("don't, this is a placeholder to request transformation");
			}

			@Override
			public void setEnabled(boolean val) {
			}

			@Override
			public void setSuspendPolicy(int policy) {
			}

			@Override
			public int suspendPolicy() {
				throw new UnsupportedOperationException("don't, this is a placeholder to request transformation");
			}

			@Override
			public VirtualMachine virtualMachine() {
				return TransparentEventManager.this.master.getVirtualMachine();
			}};
	}

	public void start() {
		JDIstart();
	}

	public void stop() {
		JDIstop();
	}

	// jdi action loop

	private Thread worker;

	// private boolean running;

	private synchronized void JDIstart() {
		if (worker != null)
			return;
		worker = new Thread(new MainLoop(), "active event system driver");
		worker.start();
	}

	private synchronized void JDIstop() {
		worker.interrupt();
		worker = null;
	}

	public class MainLoop implements Runnable {

		public void run() {
			try {
				boolean running = true;
				while (running) {
					List<ajdi.event.Event> out = new LinkedList<ajdi.event.Event>();
					List<Pair<adb.event.AJDIEventActor, ajdi.event.Event>> actors = new LinkedList<Pair<adb.event.AJDIEventActor, ajdi.event.Event>>();
					List<Pair<adb.event.JDIEventActor, com.sun.jdi.event.Event>> jActors = new LinkedList<Pair<adb.event.JDIEventActor, com.sun.jdi.event.Event>>();

					// get set
					EventSet inset = inQ.remove();
					// clear hesitant state
					// master.state.push();

					// loop through
					for (Event event : inset) {
						current = getThread(event);
						
						// break?
						if (event instanceof com.sun.jdi.event.VMDisconnectEvent)
							running = false;
						
						if (event.request() == null){
							// not requested, spill and emit if needed
							if(event instanceof com.sun.jdi.event.VMStartEvent){
								emitStartUp(out, actors, event);
							}
							// not requested, spill
							ajdi.event.Event wrapped = wrap(event);
							if(wrapped != null)
								out.add(wrapped);
						} else {
							// requested
							Object trans = event.request().getProperty(
									transformerHandle);
							if (trans == null) {
								// normal wrap
								ajdi.event.Event wrapped = wrap(event);
								if(wrapped != null)
									transform(out, actors, wrapped);
							} else {
								
								// special transform
								if(trans instanceof JDIEventActor)
									jActors.add(new Pair<JDIEventActor, Event>((JDIEventActor)trans,event));
								else{
									List<ajdi.event.Event> evts = ((JDIEventTransformer)trans).receive(event, inReq);
									for (ajdi.event.Event event2 : evts) {
										transform(out, actors, event2);
									}
								}
							}

						}
					}
					if(!jActors.isEmpty() || !actors.isEmpty())
						exec(jActors,actors);
					
					if(current != null){
						last = current;
					}
					current = null;
					
					if (!out.isEmpty())
						spill(inset, out);
					else
						// TODO test dit maar goed
						inset.resume();
				}
			} catch (InterruptedException e) {
				// loop broken
			}

		}

	}
	
	private void emitStartUp(List<ajdi.event.Event> out,
			List<Pair<adb.event.AJDIEventActor, ajdi.event.Event>> actors,
			Event event) {
		for(JDIEventTransformer trans:startUpTransformers){
			List<ajdi.event.Event> evts = trans.receive(event, inReq);
			for (ajdi.event.Event event2 : evts) {
				transform(out, actors, event2);
			}
		}
	}

	private void exec(List<Pair<JDIEventActor, Event>> jActors, List<Pair<AJDIEventActor, ajdi.event.Event>> actors) {
		if(jActors.isEmpty() && actors.isEmpty())
			return;
		
		Collections.sort(actors, new Comparator<Pair<AJDIEventActor, ajdi.event.Event>>(){

			@Override
			public int compare(Pair<AJDIEventActor, ajdi.event.Event> o1,
					Pair<AJDIEventActor, ajdi.event.Event> o2) {
				return o1.getFirst().priority() - o2.getFirst().priority();
			}});
		
		Collections.sort(jActors, new Comparator<Pair<JDIEventActor, Event>>(){

			@Override
			public int compare(Pair<JDIEventActor, Event> o1,
					Pair<JDIEventActor, Event> o2) {
				return o1.getFirst().priority() - o2.getFirst().priority();
			}});
		
		Iterator<Pair<AJDIEventActor, ajdi.event.Event>> aIt = actors.iterator();
		Iterator<Pair<JDIEventActor, Event>> jIt = jActors.iterator();
		
		Pair<AJDIEventActor, ajdi.event.Event> aCur = aIt.hasNext()?aIt.next():null;
		Pair<JDIEventActor, Event> jCur = jIt.hasNext()?jIt.next():null;
	
		while(aCur != null && jCur != null){
			if(aCur.getFirst().priority() < jCur.getFirst().priority()){
				aCur.getFirst().receive(aCur.getSecond());
				aCur = aIt.hasNext()?aIt.next():null;
			}else{
				jCur.getFirst().receive(jCur.getSecond());
				jCur = jIt.hasNext()?jIt.next():null;
			}
		}
		
		while(aCur != null){
			aCur.getFirst().receive(aCur.getSecond());
			aCur = aIt.hasNext()?aIt.next():null;
		}
		
		while(jCur != null){
			jCur.getFirst().receive(jCur.getSecond());
			jCur = jIt.hasNext()?jIt.next():null;
		}
		
	}

	private void transform(List<ajdi.event.Event> out,
			List<Pair<AJDIEventActor, ajdi.event.Event>> actors,
			ajdi.event.Event inevt) {
		Object prop = inevt.request().getProperty(internalHandle);
		if (prop != null) {
			if (prop instanceof AJDIEventTransformer) {
				// internal transform
				List<ajdi.event.Event> spill = (((AJDIEventTransformer) prop)
						.receive(inevt));

				// retransform output if any
				for (ajdi.event.Event event : spill) {
					transform(out, actors, event);
				}

			}else{
				actors.add(new Pair<AJDIEventActor, ajdi.event.Event>((AJDIEventActor)prop,inevt));
			}
		} else {
			// no internal transform, just file
			out.add(inevt);
		}

	}

	private void spill(EventSet inset, List<ajdi.event.Event> nrest) {
		EventSetImpl evts = new EventSetImpl(master, inset.suspendPolicy());

		for (ajdi.event.Event event : nrest) {
			evts.add(event);
		}
		outQ.add(evts);
	}

	private ajdi.event.Event wrap(com.sun.jdi.event.Event event) {
		if(event instanceof LocatableEvent && dropEvent((LocatableEvent)event))
			return null;
		if(event instanceof WatchpointEvent && master.wrap(((WatchpointEvent)event).field()) == null)
			return null;
		if (event instanceof ClassPrepareEvent)
			return new ClassPrepareEventImpl((ClassPrepareEvent) event, master);
		if (event instanceof ClassPrepareEvent)
			return new ClassPrepareEventImpl((ClassPrepareEvent) event, master);

		if (event instanceof ClassUnloadEvent)
			return new ClassUnloadEventImpl((ClassUnloadEvent) event, master);

		if (event instanceof BreakpointEvent)
			return new BreakpointEventImpl((BreakpointEvent) event, master);

		if (event instanceof ExceptionEvent)
			return new ExceptionEventImpl((ExceptionEvent) event, master);

		if (event instanceof MethodEntryEvent)
			return new MethodEntryEventImpl((MethodEntryEvent) event, master);

		if (event instanceof MethodExitEvent)
			return new MethodExitEventImpl((MethodExitEvent) event, master);

		if (event instanceof com.sun.jdi.event.StepEvent)
			return new StepEventImpl((com.sun.jdi.event.StepEvent) event,
					master);

		if (event instanceof com.sun.jdi.event.AccessWatchpointEvent)
			return new AccessWatchpointEventImpl(
					(com.sun.jdi.event.AccessWatchpointEvent) event, master);

		if (event instanceof com.sun.jdi.event.ModificationWatchpointEvent)
			return new ModificationWatchpointEventImpl(
					(com.sun.jdi.event.ModificationWatchpointEvent) event,
					master);

		if (event instanceof com.sun.jdi.event.ThreadDeathEvent)
			return new ThreadDeathEventImpl(
					(com.sun.jdi.event.ThreadDeathEvent) event, master);

		if (event instanceof com.sun.jdi.event.ThreadStartEvent)
			return new ThreadStartEventImpl(
					(com.sun.jdi.event.ThreadStartEvent) event, master);

		if (event instanceof com.sun.jdi.event.VMDeathEvent)
			return new VMDeathEventImpl((com.sun.jdi.event.VMDeathEvent) event,
					master);

		if (event instanceof com.sun.jdi.event.VMStartEvent)
			return new VMStartEventImpl((com.sun.jdi.event.VMStartEvent) event,
					master);

		if (event instanceof com.sun.jdi.event.VMDisconnectEvent)
			return new VMDisconnectEventImpl(
					(com.sun.jdi.event.VMDisconnectEvent) event, master);

		throw new InternalDebuggerException("unknown event type: " + event);

	}

	private boolean dropEvent(LocatableEvent event) {
		Method m = event.location().method();
		
		return master.wrap(m)==null && master.getCrossCuttingInfoProvider().isTargetMethod(m.declaringType().name(), m.name(), m.signature()) == null;
			
	}
	

	private ThreadReference getThread(Event event) {
		if(event instanceof com.sun.jdi.event.ClassPrepareEvent)
			return ((com.sun.jdi.event.ClassPrepareEvent)event).thread();
		if(event instanceof com.sun.jdi.event.LocatableEvent)
			return ((com.sun.jdi.event.LocatableEvent)event).thread();
		if(event instanceof com.sun.jdi.event.ThreadDeathEvent)
			return ((com.sun.jdi.event.ThreadDeathEvent)event).thread();
		if(event instanceof com.sun.jdi.event.ThreadDeathEvent)
			return ((com.sun.jdi.event.ThreadStartEvent)event).thread();
		if(event instanceof com.sun.jdi.event.VMStartEvent)
			return ((com.sun.jdi.event.VMStartEvent)event).thread();
		
		return null;
	}

	public EventQueueImpl outQueue() {
		return outQ;
	}

	@Override
	public EventRequest getVMStartEvent() {
		return null;
	}
	
	private ThreadReference current;
	
	public ThreadReference getCurrentThread(){
		return current;
	}
	private ThreadReference last;

}
