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

import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.ClassNotPreparedException;
import com.sun.jdi.InconsistentDebugInfoException;
import com.sun.jdi.VirtualMachine;

import adb.backend.AdviceApplicationDescriptor;
import adb.backend.AdviceDescriptor;
import adb.backend.MethodIdentifier;
import adb.backend.NoSuchAdviceException;
import ajdi.Advice;
import ajdi.AdviceApplication;
import ajdi.Binding;
import ajdi.JoinPoint;
import ajdi.Residue;

/**
 * @author wouter
 *
 * implementation of the advice binding
 */
public class AdviceApplicationImpl implements AdviceApplication {
	public static class LazyAdviceApplicationImpl extends AdviceApplicationImpl {
		
		private String res;
		private MethodIdentifier descr;
		private String bind;

		public LazyAdviceApplicationImpl(ShadowMaster master, MethodIdentifier descr,
				String residue,String binding) {
			super(master, null,null, null);
			this.descr = descr;
			this.res = residue;
			this.bind = binding;
		}
	
		public Advice advice() throws ClassNotPreparedException {
			if(advice == null)
				try {
					advice = shadowMaster().getAdviceForID(descr);
				} catch (NoSuchAdviceException e) {
					throw new InternalDebuggerException("inconsistent debugging information",e);
				}
			return advice;
		}
		
		public Residue residue() {
			if(residue == null) {
				residue = shadowMaster().getResidue(res);
			}
			return residue;
		}
		
		public Binding binding() {
			if(binding == null){
				Advice ad = advice();
				for (Binding binder : ad.bindings()) {
					if(binder.name().equals(bind))
						binding = binder;
				}
			}
			return binding;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((bind == null) ? 0 : bind.hashCode());
			result = prime * result + ((descr == null) ? 0 : descr.hashCode());
			result = prime * result + ((res == null) ? 0 : res.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			return false;
		}
		
		public String getAdviceMethodName(){
			return descr.getMethodname();
		}
		
		public String getAdviceMethodSig(){
			return descr.getMethodsig();
		}
		
		public String getAspectClassName(){
			return descr.getClazz();
		}

	}

	//TO BE COMPLETED
	private JoinPoint joinpoint;
	
	//CAN BE LAZZY
	protected Advice advice;
	protected Residue residue;
	
	//IS LAZY
	private String bindingName;
	protected Binding binding;
	
	//BOUND
	private ShadowMaster master;

	

	//INCOMPLETE
	public AdviceApplicationImpl(ShadowMaster master, Advice advice,String bindingName, Residue residue) {
		super();
		this.master = master;
		this.advice = advice;
		this.residue = residue;
		this.bindingName = bindingName;
	}

	public Advice advice() throws ClassNotPreparedException {
		return advice;
	}

	//@friend(JoinPoint.new)
	public JoinPoint joinPoint() {
		//if(joinpoint == null)
		//	throw new InternalDebuggerException("AdviceApplicationImpl made, but not linked");
		return joinpoint;
	}

	public Residue residue() {
		return residue;
	}
	
	public Binding binding() {
		if(binding == null){
			Advice ad = advice();
			for (Binding binder : ad.bindings()) {
				if(binder.name().equals(bindingName))
					this.binding = binder;
			}
		}
		if(binding == null)
			throw new InconsistentDebugInfoException("no binding found");
		return binding;
	}

	void setJoinpoint(JoinPointImpl pointimpl) {
		this.joinpoint = pointimpl;
	}

	public ShadowMaster shadowMaster() {
		return master;
	}
	
	public String toString(){
		return "AdviceApplication: " + advice + " " + joinpoint;
	}

	@Override
	public int hashCode() {
		final int PRIME = 97;
		int result = 1;
		result = PRIME * result + ((advice == null) ? 0 : advice.hashCode());
		result = PRIME * result + ((joinpoint == null) ? 0 : joinpoint.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AdviceApplicationImpl))
			return false;
		final AdviceApplicationImpl other = (AdviceApplicationImpl) obj;
		if (advice == null) {
			if (other.advice != null)
				return false;
		} else if (!advice.equals(other.advice))
			return false;
		if (joinpoint == null) {
			if (other.joinpoint != null)
				return false;
		} else if (!joinpoint.equals(other.joinpoint))
			return false;
		return true;
	}

	public VirtualMachine virtualMachine() {
		return master.getVirtualMachine();
	}

	public String getAspectClassName(){
		return master.unwrap(advice().declaringType()).name();
	}
	
	public String getAdviceMethodName(){
		return advice().name();
	}
	
	public String getAdviceMethodSig(){
		return ((AdviceImpl)advice()).getBaseSig();
	}
	
	
	public boolean is(AdviceApplicationDescriptor aapld){
		MethodIdentifier advice = aapld.getAdvice();
		if(!(getAspectClassName().equals(advice.getClazz()) && getAdviceMethodName().equals(advice.getMethodname()) && getAdviceMethodSig().equals(advice.getMethodsig()))){
			return false;
		}
		
		if(!((JoinPointImpl)joinPoint()).is(aapld.getJoinpoint()))
			return false;
		
		if(!aapld.getBindingName().equals(binding().name()))
			return false;
		
		return true;
			
	}

}
