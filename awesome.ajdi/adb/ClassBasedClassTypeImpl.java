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

import adb.backend.FilterManager;
import adb.tools.InterList;
import ajdi.ClassType;
import ajdi.Field;
import ajdi.InterfaceType;
import ajdi.Method;
import ajdi.SInitJointPoint;
import ajdi.Shadow;
import ajdi.ThreadReference;
import ajdi.Value;

import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.InvocationException;

/**
 * @author wouter
 *
 * primary storage for methods, caches
 */
public class ClassBasedClassTypeImpl extends AbstractReferenceTypeImpl<com.sun.jdi.ClassType> implements ClassTypeImpl {
	


	public ClassBasedClassTypeImpl(com.sun.jdi.ClassType base, ShadowMaster master) {
		super(base, master);
	}


	public SInitJointPoint staticInitialisationJoinPoint() {
		try{
		return (SInitJointPoint) concreteMethodByName("<cinit>", "()V").executionJoinPoint();
		}catch(Exception e){
			throw new InternalDebuggerException("Sinitjoinpoint exctraction failed",e);
		}
	}


	public List<InterfaceType> allInterfaces() {
		return new InterList<com.sun.jdi.InterfaceType, InterfaceType>(unwrap().allInterfaces(),master.getInterfaceConverter());
	}

	public List<InterfaceType> interfaces() {
		return new InterList<com.sun.jdi.InterfaceType, InterfaceType>(unwrap().interfaces(),master.getInterfaceConverter());
	}

	
	public Method concreteMethodByName(String name, String signature) {
		com.sun.jdi.Method method = unwrap().concreteMethodByName(name, signature);
		if(method == null)
			return null;
		
		FilterManager fm = shadowMaster().getFilterManager();
		method = fm.filterMethod(method);
		
		if(method == null)
			return null;
		
		return wrap(method);
	}

	public Value invokeMethod(ThreadReference thread, Method method,
			List<? extends Value> arguments, int options)
			throws InvalidTypeException, ClassNotLoadedException,
			IncompatibleThreadStateException, InvocationException {
		Value val =  master.wrap(unwrap().invokeMethod(shadowMaster().unwrap(thread), unwrap(method), new InterList<Value, com.sun.jdi.Value>((List<Value>) arguments,master.getValueUnwrapper()), options));
		//notifyResume(thread, options);
		return val;
	}


	/*private void notifyResume(ThreadReference thread, int options) {
		if((options & ClassType.INVOKE_SINGLE_THREADED) == 0)
			shadowMaster().notifyResume();
		else
			((ThreadReferenceImpl)thread).notifyResume();
	}
*/
	public boolean isEnum() {
		return unwrap().isEnum();
	}

	public ObjectReferenceImpl newInstance(ThreadReference thread, Method method,
			List<? extends Value> arguments, int options)
			throws InvalidTypeException, ClassNotLoadedException,
			IncompatibleThreadStateException, InvocationException {
		ObjectReferenceImpl ret =  new ObjectReferenceImpl(unwrap().newInstance(shadowMaster().unwrap(thread), unwrap(method), new InterList<Value, com.sun.jdi.Value>((List<Value>) arguments,master.getValueUnwrapper()), options),master);
		//notifyResume(thread, options);
		return ret;
	}

	public void setValue(Field field, Value value) throws InvalidTypeException,
			ClassNotLoadedException {
		unwrap().setValue(unwrap(field), shadowMaster().unwrap(value));
	}

	public List<ajdi.ClassType> subclasses() {
		return new InterList<com.sun.jdi.ClassType, ajdi.ClassType>(unwrap().subclasses(),shadowMaster().getClassConverter());
	}
	
	public ClassType superclass() {
		com.sun.jdi.ClassType parent = unwrap().superclass();
		if(parent == null)
			return null;
		return shadowMaster().getClassFor(parent);
	}

	public List<Method> allMethods() {
		List<Method> out = new LinkedList<Method>();
		out.addAll(methods());
		if(superclass() != null)
			out.addAll(superclass().allMethods());
		return out;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((unwrap() == null) ? 0 : unwrap().hashCode());
		result = prime * result + ((master == null) ? 0 : master.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ClassBasedClassTypeImpl))
			return false;
		final ClassBasedClassTypeImpl other = (ClassBasedClassTypeImpl) obj;
		if (unwrap() == null) {
			if (other.unwrap() != null)
				return false;
		} else if (!unwrap().equals(other.unwrap()))
			return false;
		if (master == null) {
			if (other.master != null)
				return false;
		} else if (!master.equals(other.master))
			return false;
		return true;
	}


	@Override
	public Method concreteMemberByName(String name, String signature) {
		return concreteMethodByName(name, signature);
	}

	
	
}
