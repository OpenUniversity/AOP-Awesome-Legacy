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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.InvocationException;
import com.sun.jdi.VirtualMachine;

import adb.tools.InterList;
import ajdi.Advice;
import ajdi.AdviceInvocationException;
import ajdi.ClassType;
import ajdi.Field;
import ajdi.Method;
import ajdi.ObjectReference;
import ajdi.ReferenceType;
import ajdi.ThreadReference;
import ajdi.Type;
import ajdi.Value;

public abstract class AbstractObjectReference<T extends com.sun.jdi.ObjectReference> implements ObjectReference {

	T base;
	private ShadowMaster master;

	public AbstractObjectReference(T base, ShadowMaster master) {
		super();
		master.addObjectReference(base,this);
		this.base = base;
		this.master = master;
	}

	public void disableCollection() {
		base.disableCollection();

	}

	public void enableCollection() {
		base.enableCollection();

	}

	public int entryCount() throws IncompatibleThreadStateException {
		return base.entryCount();
	}

	public Value getValue(Field arg0) { 
		return master.wrap(base.getValue(master.unwrap(arg0)));
	}

	public Map<Field, Value> getValues(List<? extends Field> arg0) {
		Map<Field,Value> vals = new HashMap<Field, Value>();
		
		for (Field field : arg0) {
			vals.put(field, getValue(field));
		}
		
		return Collections.unmodifiableMap(vals);
	}

	
	public Value invokeMethod(ThreadReference thread, Method arg1,
			List<? extends Value> arg2, int options) throws InvalidTypeException,
			ClassNotLoadedException, IncompatibleThreadStateException,
			InvocationException {
		if(arg1 instanceof Advice)
			throw new AdviceInvocationException((Advice)arg1);
		Value val = master.wrap(base.invokeMethod(master.unwrap(thread), master.unwrap(arg1), new InterList<Value, com.sun.jdi.Value>((List<Value>)arg2,master.getValueUnwrapper()), options));
		//notifyResume(thread, options);
		return val;
	}
	
	/*private void notifyResume(ThreadReference thread, int options) {
		if((options & ClassType.INVOKE_SINGLE_THREADED) == 0)
			shadowMaster().notifyResume();
		else
			((ThreadReferenceImpl)thread).notifyResume();
	}*/

	public boolean isCollected() {
		return base.isCollected();
	}

	public ThreadReference owningThread()
			throws IncompatibleThreadStateException {
		return master.wrap(base.owningThread());
	}

	public ReferenceType referenceType() {
		return shadowMaster().getClassFor((com.sun.jdi.ClassType)base.referenceType());
	}

//	public List<com.sun.jdi.ObjectReference> referringObjects(long arg0) {
//		return base.referringObjects(arg0);
//	}

	public void setValue(Field arg0, Value arg1) throws InvalidTypeException,
			ClassNotLoadedException {
		base.setValue(shadowMaster().unwrap(arg0), master.unwrap(arg1));
	}

	public long uniqueID() {
		return base.uniqueID();
	}

	public List<ThreadReference> waitingThreads()
			throws IncompatibleThreadStateException {
		return new InterList<com.sun.jdi.ThreadReference, ThreadReference>(base.waitingThreads(),master.getThreadConverter());
	}

	public Type type() {
		return referenceType();
	}

	public VirtualMachine virtualMachine() {
		return base.virtualMachine();
	}

	public ShadowMaster shadowMaster() {
		return master;
	}

}
