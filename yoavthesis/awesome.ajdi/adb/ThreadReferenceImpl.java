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
package adb;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import adb.event.state.ThreadStateListener;
import adb.event.state.VMStateListener;
import adb.tools.InterList;
import ajdi.ObjectReference;
import ajdi.StackFrame;
import ajdi.ThreadGroupReference;
import ajdi.ThreadReference;
import ajdi.Value;

import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InvalidTypeException;

public class ThreadReferenceImpl extends AbstractObjectReference<com.sun.jdi.ThreadReference> implements ThreadReference {
	
	/*//lock on state
	private List<ThreadStateListener> listeners = new LinkedList<ThreadStateListener>();
	
	void notifyResume() {
		synchronized (shadowMaster().state) {
			for (ListIterator<ThreadStateListener> itrl = listeners.listIterator();itrl.hasNext();) {
				ThreadStateListener list = itrl.next();
				if(!list.threadResumed(this))
					itrl.remove();
			}
			//System.out.println("resume: " + this);
		}
	}
	
	private void addListener(ThreadStateListener list) {
		synchronized (shadowMaster().state) {
			listeners.add(list);
		}
	}*/


	public ThreadReferenceImpl(com.sun.jdi.ThreadReference base,
			ShadowMaster master) {
		super(base, master);

		/*master.addListener(this);
		this.addListener(master);*/
	}

	public void forceEarlyReturn(Value value) throws InvalidTypeException,
			ClassNotLoadedException, IncompatibleThreadStateException {
		base.forceEarlyReturn(shadowMaster().unwrap(value));

	}

	public StackFrame frame(int index) throws IncompatibleThreadStateException {
		return frames().get(index);
	}

	public int frameCount() throws IncompatibleThreadStateException {
		return frames().size();
	}

	public List<StackFrame> frames() throws IncompatibleThreadStateException {
		return shadowMaster().wrap(base.frames());
	}

	public List<StackFrame> frames(int start, int length)
			throws IncompatibleThreadStateException {
		return frames().subList(start, start+length);
	}

	public void interrupt() {
		base.interrupt();

	}

	public boolean isAtBreakpoint() {
		return base.isAtBreakpoint();
	}

	public boolean isSuspended() {
		return base.isSuspended();
	}

	public String name() {
		return base.name();
	}

	public List<ObjectReference> ownedMonitors()
			throws IncompatibleThreadStateException {
		return new InterList<com.sun.jdi.ObjectReference, ObjectReference>(base.ownedMonitors(),shadowMaster().getObjectConverter());
	}

	public void popFrames(StackFrame frame)
			throws IncompatibleThreadStateException {
		base.popFrames(shadowMaster().unwrap(frame));
		//notifyResume();
	}

	public void resume() {
		base.resume();
		//notifyResume();
	}


	public int status() {
		return base.status();
	}

	public void stop(ObjectReference throwable) throws InvalidTypeException {
		base.stop(shadowMaster().unwrap(throwable));
	}

	public void suspend() {
		base.suspend();
	}

	public int suspendCount() {
		return base.suspendCount();
	}

	public ThreadGroupReference threadGroup() {
		return shadowMaster().wrap(base.threadGroup());
	}


	public ObjectReference currentContendedMonitor()
			throws IncompatibleThreadStateException {
		return shadowMaster().wrap(base.currentContendedMonitor());
	}

	public String toString(){
		return base.toString();
	}

	/*@Override
	public boolean unSuspended(ShadowMaster sm) {
		if(!base.isSuspended())
			notifyResume();
		return true;
	}*/
}
