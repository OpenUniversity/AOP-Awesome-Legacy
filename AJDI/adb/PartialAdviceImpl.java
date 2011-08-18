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

import java.util.List;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.ClassNotPreparedException;
import com.sun.jdi.Method;

import adb.backend.MethodIdentifier;
import ajdi.Aspect;
import ajdi.Binding;
import ajdi.Pointcut;

public class PartialAdviceImpl extends AdviceImpl {

	private MethodIdentifier container;

//	public PartialAdviceImpl(Aspect parent, Binding bind, int type, String container, String method,String methodSig,
//			ShadowMaster master, LineRange range, int[] args, String[] argnames) {
//		super(parent, bind, type, null, master, range, args, argnames);
//		this.className = container;
//		this.meth = method;
//		this.sig = methodSig;
//	}
	
	
	
	public PartialAdviceImpl(Aspect parent, List<Binding> binding, int type,
			MethodIdentifier container, ShadowMaster master, LineRange range, int[] args,
			String[] argnames, String effectType) {
		super(parent, binding, type, null, master, range, args, argnames, effectType);
		this.container = container;
	}



	com.sun.jdi.Method getBase() throws ClassNotPreparedException{
		if(super.getBase() != null)
			return super.getBase();
		try{
			com.sun.jdi.ClassType container = shadowMaster().getBaseClassFor(this.container.getClazz());
			com.sun.jdi.Method m = container.concreteMethodByName(this.container.getMethodname(), this.container.getMethodsig());
			base = m;
			try {
				range = new SourceLocationImpl(range,m.location().sourcePath());
			} catch (AbsentInformationException e) {
				//TODO pass on
				throw new InternalDebuggerException(
						"JDI provider could not suply path for: "
								+ container+" . " + this.container.getMethodname() +" " +this.container.getMethodsig());
			}
			return m;
		}catch(ClassNotPreparedException e){
			//TODO wrap
			throw e;
		}
		
	}
	
	public String name() {
		return container.getMethodname();
	}
	
	String getBaseSig(){
		return container.getMethodsig();
	}

}
