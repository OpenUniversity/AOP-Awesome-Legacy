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
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import adb.backend.AdviceApplicationDescriptor;
import adb.backend.AfterBindingEventListener;
import adb.backend.LocationDescriptor;
import adb.backend.MethodIdentifier;
import adb.backend.bcel.BCELBackend;
import adb.backend.bcel.CrossCuttingAttribute;
import adb.backend.bcel.JoinPointDescriptor;
import adb.backend.bcel.ShadowAttribute;

import com.sun.jdi.ClassType;
import com.sun.jdi.Method;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.VirtualMachine;

public class CrossCuttingInfoProvider implements
		adb.backend.CrossCuttingInfoProvider {
	
	private BCELBackend back;
	private VirtualMachine vm;
	
	public CrossCuttingInfoProvider(BCELBackend back,VirtualMachine vm){
		this.back = back;
		this.vm=vm;
	}

//	public JoinPointDescriptor getJoinPointForClass(String classType) {
//		List<JoinPointDescriptor> out = getJoinpointsForMethod(classType, Constants.STATIC_INITIALIZER_NAME, "()V");
//		return ( out.isEmpty() ) ? null : out.get(0);
//	}

	public List<adb.backend.JoinPointDescriptor> getJoinpointsForMethod(String classname,
			String methodname,String methodsig) {
		CrossCuttingAttribute att = (CrossCuttingAttribute) back.getMethodAttribute(classname, methodname, methodsig, CrossCuttingAttribute.NAME);
		
		if(att == null)
			return Collections.emptyList();
		List<JoinPointDescriptor> out = new ArrayList<JoinPointDescriptor>(att.getJoinPoints());
		
		for (JoinPointDescriptor descriptor : out) {
			//if(descriptor.getType() == JoinPointDescriptor.TYPE_STATEMENT)
			descriptor.getTarget().merge(getShadowInfoFor(classname,descriptor));
			descriptor.complete(back.getPathFor(classname),classname,methodname,methodsig);
		}
		
		return Collections.<adb.backend.JoinPointDescriptor>unmodifiableList(out);
	}

	private LocationDescriptor getShadowInfoFor(String classname,JoinPointDescriptor descriptor) {
		MethodIdentifier method = descriptor.getTarget().getMethod();
		ShadowAttribute att = (ShadowAttribute) back.getMethodAttribute(classname,method.getMethodname(), method.getMethodsig(), ShadowAttribute.NAME);
		
		//YA
			if(null == att)
				return null;
			else
		//YA
				return att.getLocationFor(descriptor.getUid());
	}

	/* (non-Javadoc)
	 * @see adb.backend.CrossCuttingInfoProvider#getPointcutsContaining(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	//takes a LONG time
	public List<AdviceApplicationDescriptor> getApplicationsFor(
			String aspect, String methodname,
			String methodsig) {
		List<ReferenceType> allClasses = vm.allClasses();
		List<AdviceApplicationDescriptor> out = new LinkedList<AdviceApplicationDescriptor>();
		
		for (ReferenceType type : allClasses) {
			if(type instanceof ClassType){
//				JoinPointDescriptor cjp = getJoinPointForClass(type.name());
//				if(cjp != null){
//					AdviceApplicationDescriptor aapl = cjp.getApplicationFor(aspect,methodname,methodsig);
//					if(aapl != null)
//						out.add(aapl);
//				}
				
				for (Method method : type.methods()) {
					List<adb.backend.JoinPointDescriptor> jps = getJoinpointsForMethod(type.name(),method.name(),method.signature());
					for (adb.backend.JoinPointDescriptor descriptor : jps) {
						List<AdviceApplicationDescriptor> aapl = descriptor.getApplicationFor(aspect,methodname,methodsig);
						if(!aapl.isEmpty())
							out.addAll(aapl);
					}
				}
				
				
			}
				
		}
		
		return out;
	}

	public void addBindingListener(AfterBindingEventListener list) {
	}

	public void removeBindingListener(AfterBindingEventListener list) {
	}

	@Override
	public List<AdviceApplicationDescriptor> getApplicationsFor(String binding) {
		return Collections.emptyList();
	}

	@Override
	public MethodIdentifier isTargetMethod(String classname, String methodname, String methodsig) {
		ShadowAttribute att = (ShadowAttribute) back.getMethodAttribute(classname,methodname, methodsig, ShadowAttribute.NAME);
		if(att == null)
			return null;
		return att.getRangeMethod();
	}

}
