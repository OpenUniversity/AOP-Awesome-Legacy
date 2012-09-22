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
import java.util.List;

import adb.InternalDebuggerException;
import adb.ShadowMaster;
import adb.ClassBasedAspectImpl.PerObjectAspect;
import adb.ClassBasedAspectImpl.PerObjectAspect.PerObjectInstance;
import adb.ClassBasedAspectImpl.PerSingletonAspect.SingletonInstance;
import ajdi.AspectInitialisationException;
import ajdi.AspectInstance;
import ajdi.ObjectReference;
import ajdi.ReferenceType;

import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.ClassType;
import com.sun.jdi.Field;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.InvocationException;
import com.sun.jdi.Method;
import com.sun.jdi.StringReference;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.Value;
import com.sun.jdi.VirtualMachine;

public class AspectInstanceProvider implements
		adb.backend.AspectInstanceProvider {

	public PerObjectInstance getPerObjectInstanceFor(VirtualMachine vm,ShadowMaster master,
			ClassType base, ObjectReference object, ThreadReference worker) throws AspectInitialisationException, IncompatibleThreadStateException {
		Method m = base.concreteMethodByName("aspectOf","(Ljava/lang/Object;)L"+base.name().replaceAll("[.]", "/")+";");
		
		if(m == null)
			return null;
		
		Value v;
		try {
			v = base.invokeMethod(worker, m, Collections.singletonList(master.unwrap(object)), 0);
			com.sun.jdi.ObjectReference orig = (com.sun.jdi.ObjectReference)v;
			
			return new adb.ClassBasedAspectImpl.PerObjectAspect.PerObjectInstance(orig,object,master);
		} catch (InvalidTypeException e) {
			throw new InternalDebuggerException("Types do not match, but should");
		} catch (ClassNotLoadedException e) {
			throw new InternalDebuggerException("class not loaded, but should be");
		}  catch (InvocationException e) {
			throw new AspectInitialisationException(e.exception()); 
		}
		

	}

	public SingletonInstance getPerSingletonInstanceFor(VirtualMachine vm,ShadowMaster master,
			ClassType base, ThreadReference worker) throws IncompatibleThreadStateException, AspectInitialisationException {
		Method m = base.concreteMethodByName("aspectOf","()L"+base.name().replaceAll("[.]", "/")+";");
		
		if(m == null)
			return null;
		
		Value v;
		try {
			v = base.invokeMethod(worker, m, Collections.EMPTY_LIST, 0);
			com.sun.jdi.ObjectReference orig = (com.sun.jdi.ObjectReference)v;
			
			return new adb.ClassBasedAspectImpl.PerSingletonAspect.SingletonInstance(orig,master);
		} catch (InvalidTypeException e) {
			throw new InternalDebuggerException("Types do not match, but should");
		} catch (ClassNotLoadedException e) {
			throw new InternalDebuggerException("class not loaded, but should be");
		}  catch (InvocationException e) {
//			System.out.println(base.isInitialized());
//			
//			ObjectReference ex = e.exception();
//			
//			Method msgMeth = ((ClassType)ex.type()).concreteMethodByName("getMessage","()Ljava/lang/String;");
//			Method exMeth = ((ClassType)ex.type()).concreteMethodByName("getCause","()Ljava/lang/Throwable;");
//			
//			try {
//				System.out.println(((StringReference)ex.invokeMethod(thread, msgMeth, Collections.<Value>emptyList(), 0)).value());
//			} catch (InvalidTypeException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (ClassNotLoadedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (InvocationException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			throw new AspectInitialisationException(e.exception()); 
		}
		
		
	}

	public SingletonInstance getPerSingletonInstanceFor(VirtualMachine vm,
			ShadowMaster master, ClassType base,
			com.sun.jdi.ObjectReference ref) {
		return new adb.ClassBasedAspectImpl.PerSingletonAspect.SingletonInstance(ref,master);
	}

	public com.sun.jdi.ObjectReference getOwnerForPerObjectAspectInstance(PerObjectAspect perObjectAspect, com.sun.jdi.ObjectReference aref) {
		String aspectName = perObjectAspect.name();
		aspectName = aspectName.replaceAll("[.]", "_");
		//ex5_Ex1$abc$PerThisField
		String fieldName = aspectName +"$abc$Per";  
		
		String perThis = fieldName+"ThisField";
		String perTarget = fieldName+"TargetField";
		
		List<com.sun.jdi.ObjectReference> refs = aref.referringObjects(0);
		
		for (com.sun.jdi.ObjectReference oref : refs) {
			com.sun.jdi.ReferenceType otype = oref.referenceType();
			Field pertf = otype.fieldByName(perThis);
			if(pertf == null)
				pertf = otype.fieldByName(perTarget);
			if(pertf == null)
				continue;
			if(oref.getValue(pertf).equals(aref))
				return oref;
		}
		
		
		
	    throw new InternalDebuggerException("no instance field found");
	}

	public PerObjectInstance getPerObjectInstanceFor(VirtualMachine vm,
			ShadowMaster master, ClassType unwrap,
			com.sun.jdi.ObjectReference ref, ObjectReference owner) {
		return new adb.ClassBasedAspectImpl.PerObjectAspect.PerObjectInstance(ref,owner,master);
	}
	
//	
//	//ABC HACK
//	//public Ex1 ex5_Ex1$abc$PerThisGet()
//	public AspectInstance getObjectForInstance(VirtualMachine vm,ShadowMaster master, com.sun.jdi.ObjectReference perObjectInstance, ThreadReference worker) throws IncompatibleThreadStateException {
//		String aspectname = perObjectInstance.referenceType().name();
//		String sig = "()L"+aspectname.replace('.', '/')+";";
//		String methodname = aspectname.replace('.', '_') + "$abc$PerThisGet";
//		
//		Method m = ((ClassType)perObjectInstance.referenceType()).concreteMethodByName(methodname, sig);
//		
//		if(m == null)
//			throw new InternalDebuggerException("could not find object for instance");
//		
//		Value owner;
//		try {
//			owner = perObjectInstance.invokeMethod(worker, m, Collections.<Value>emptyList(), 0);
//		} catch (InvalidTypeException e) {
//			throw new InternalDebuggerException("Types do not match, but should");
//		} catch (ClassNotLoadedException e) {
//			throw new InternalDebuggerException("class not loaded, but should be");
//		}  catch (InvocationException e) {
//			throw new InternalDebuggerException("method threw exception, but should not"); 
//		}
//		
//		return new adb.ClassBasedAspectImpl.PerObjectAspect.PerObjectInstance(perObjectInstance,(ObjectReference) owner,master);
//	}
}
