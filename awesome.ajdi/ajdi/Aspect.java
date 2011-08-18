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
package ajdi;

import java.util.List;

import com.sun.jdi.IncompatibleThreadStateException;

public interface Aspect extends ClassType, Shadow{
	
	public static final int PER_SINGLETON = 0x01;
	public static final int PER_OBJECT = 0x02;
	public static final int PER_CLASS = 0x04;
	/**
	 * per object per joinpoint
	 */
	public static final int PER_JOINPOINT = 0x08;
	
	public static final int PER_VM_JOINPOINT =  PER_JOINPOINT + PER_SINGLETON;
	public static final int PER_OBJECT_JOINPOINT =  PER_JOINPOINT + PER_OBJECT;
	public static final int PER_CLASS_JOINPOINT = PER_JOINPOINT + PER_CLASS;
	
	
	/**
	 * @return all advises defined in this aspect and all of it's ancestors
	 */
	public List<Advice> allAdvices();
	
	/**
	 * @return all advises defined directly in this aspect
	 */
	public List<Advice> advices();
	
	/**
	 * @param sig the advice signature of the advice, no regex
	 * @return a list of advises having this signature
	 */
	public List<Advice> advicesBySignature(String sig);
	
	/**
	 * @param sig the advice signature of the advice
	 * @return the concrete version of the advice having this signature
	 */
	//TODO onnozele semantiek
	//denk aan de binding,....
	public Advice concreteAdviceBySignature(String sig);
	
	public boolean isPerSingleton();
	public boolean isPerObject();
	public int getPer();
	
	
//	/**
//	 * @return
//	 */
//	public List<AspectInstance> allInstances();
	
	
	//geen singleton: error
	/**
	 * if this aspect is not a singleton, an  is thrown,
	 * otherwise the worker thread is used to invoke the needed commands to retrieve the instance
	 * 
	 * this call may use jdi.classType.invokeMethod, causing VM resumption
	 * 
	 * @param worker
	 * @throws IncompatibleThreadStateException if the specified thread has not been suspended by an event.
	 * @throws IncompatibleAspectTypeException if this aspect is not a singleton
	 * @throws AspectInitialisationException an exception occurred in the target VM
	 */
	public AspectInstance getInstance(ThreadReference worker) throws IncompatibleAspectTypeException,IncompatibleThreadStateException, AspectInitialisationException;
	
//	//singleton: werkt
//	//CFLOW: werkt
//	//Obj: error
//	public AspectInstance getInstanceFor(ThreadReference thread);
	
	//singleton: werkt
	//CFLOW: error
	//Obj: werkt
	/**
	 * @param worker
	 * @param object the object the instance is bound to
	 * @return
	 * @throws IncompatibleThreadStateException if the specified thread has not been suspended by an event.
	 * @throws IncompatibleAspectTypeException if this aspect is not a singleton or a per object aspect
	 * @throws AspectInitialisationException an exception occurred in the target VM
	 * @throws IllegalArgumentException this object can not be linked to an instance
	 */
	public AspectInstance getInstanceFor(ThreadReference worker,ObjectReference object) throws IncompatibleThreadStateException, AspectInitialisationException,IncompatibleAspectTypeException;
	
	/* (non-Javadoc)
	 *  kan wel eens problemen gaan geven
	 * @see com.sun.jdi.ReferenceType#classObject()
	 */
	//public ClassObjectReference classObject();
	
	public List<Aspect> subAspects();
	
	public String mechanismName();
	
}
