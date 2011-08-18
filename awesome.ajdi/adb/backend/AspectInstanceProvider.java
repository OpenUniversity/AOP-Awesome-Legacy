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
package adb.backend;

import adb.ShadowMaster;
import adb.ClassBasedAspectImpl.PerObjectAspect;
import adb.ClassBasedAspectImpl.PerSingletonAspect;
import adb.ClassBasedAspectImpl.PerObjectAspect.PerObjectInstance;
import adb.ClassBasedAspectImpl.PerSingletonAspect.SingletonInstance;
import ajdi.AspectInitialisationException;
import ajdi.AspectInstance;

import com.sun.jdi.ClassType;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.Type;
import com.sun.jdi.VirtualMachine;

/**
 * @author wouter
 *
 * This interface defines the factory that instantiates aspect instances
 * 
 * if methods are called using invokeMethod, please make sure you can use INVOKE_SINGLE_THREADED and use it.
 */
public interface AspectInstanceProvider extends InfoProvider{
	

	/**
	 * @param vm the vm containing this aspect
	 * @param master the master containing this aspect
	 * @param base the class underlying the aspect 
	 * @param worker the thread used to execute statements necessary to retrieve the instance, it must be suspended by an event in that thread, while the VM itself is not suspended 
	 * @throws IncompatibleThreadStateException if the specified thread has not been suspended by an event.
	 * @throws AspectInitialisationException the aspect could not be initialised 
	 */
	public SingletonInstance getPerSingletonInstanceFor(VirtualMachine vm,
			ShadowMaster master,ClassType base, ThreadReference worker) throws IncompatibleThreadStateException, AspectInitialisationException;

	/**
	 * @param vm the vm containing this aspect
	 * @param master the master containing this aspect
	 * @param base the class underlying the aspect 
	 * @param object the object related to this instance
	 * @param worker the thread used to execute statements necessary to retrieve the instance, it must be suspended by an event in that thread, while the VM itself is not suspended
	 * @throws IncompatibleThreadStateException if the specified thread has not been suspended by an event.
	 * @throws AspectInitialisationException the aspect could not be initialised 
	 */
	public PerObjectInstance getPerObjectInstanceFor(VirtualMachine vm,
			ShadowMaster master, ClassType base, ajdi.ObjectReference object, ThreadReference worker) throws AspectInitialisationException, IncompatibleThreadStateException;

	/**
	 * @param vm the vm containing this aspect
	 * @param master the master containing this aspect
	 * @param base the class underlying the aspect 
	 * @param ref the base instance
	 * @return
	 */
	public SingletonInstance getPerSingletonInstanceFor(VirtualMachine vm,
			ShadowMaster shadowMaster, ClassType base, ObjectReference ref);

	public PerObjectInstance getPerObjectInstanceFor(VirtualMachine vm,
			ShadowMaster shadowMaster, ClassType unwrap, ObjectReference ref,
			ajdi.ObjectReference owner);

	public com.sun.jdi.ObjectReference getOwnerForPerObjectAspectInstance(
			PerObjectAspect perObjectAspect, ObjectReference ref);

	
//	//REVERT
//	
//	/**
//	 * @param vm the vm containing this aspect
//	 * @param master the master containing this aspect
//	 * @param perObjectInstance perObjectInstance backing class 
//	 * @param worker the thread used to execute statements necessary to retrieve the instance, it must be suspended by an event in that thread, while the VM itself is not suspended
//	 * @throws IncompatibleThreadStateException if the specified thread has not been suspended by an event.
//	 */
//	public AspectInstance getObjectForInstance(VirtualMachine vm,ShadowMaster master, com.sun.jdi.ObjectReference perObjectInstance, ThreadReference worker) throws IncompatibleThreadStateException;
}
