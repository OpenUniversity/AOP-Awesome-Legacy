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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.request.EventRequest;

import adb.backend.AdviceApplicationDescriptor;
import adb.backend.AdviceDescriptor;
import adb.backend.BindingDescriptor;
import adb.backend.MethodIdentifier;
import adb.backend.NoSuchAdviceException;
import adb.event.active.ApplicationListener;
import adb.tools.InterList;
import adb.tools.SelectiveList;
import ajdi.Advice;
import ajdi.AdviceApplication;
import ajdi.AdviceExecutionJoinPoint;
import ajdi.Aspect;
import ajdi.Binding;
import ajdi.ClassType;
import ajdi.LocalVariable;
import ajdi.Location;
import ajdi.Method;
import ajdi.Pointcut;
import ajdi.SourceLocation;
import ajdi.Type;

public class AdviceImpl extends MethodImpl implements Advice {

	// LAZZY, unmodifiable
	//private List<AdviceApplication> jps;

	// NEEDED
	private Pointcut pc;
	private int type;
	SourceLocationImpl range;
	// private String method;
	private List<Binding> bindings;
	
	//AWDB
	private String effectType;
	private Integer[] sourceLines;

	// public AdviceImpl(Aspect parent, Binding binding, int type,
	// com.sun.jdi.Method base,/*String baseName,*/ShadowMaster master,LineRange
	// range,int[] args,String[] argnames) {
	// super(base,parent,master);
	// if(base == null) {
	// throw new
	// InternalDebuggerException("totaly inlined method: not supported");
	// }
	// if(binding == null){
	// this.pc = null;
	// this.bindings = Collections.emptyList();
	// }else{
	// this.pc = binding.getPointCut();
	// this.bindings = Collections.singletonList(binding);
	// }
	//			
	// this.type=type;
	// this.range = range;
	// this.argIndices = args;
	// this.argNames = argnames;
	// //method = baseName;
	// }

	public AdviceImpl(Aspect parent, List<Binding> binding, int type,
			com.sun.jdi.Method base,/* String baseName, */ShadowMaster master,
			LineRange range, int[] args, String[] argnames, String effectType,
			Integer[] sourceLines) {
		super(base, parent, master);
		if (base == null) {
			throw new InternalDebuggerException(
					"totaly inlined method: not supported");
		}
		if (binding.isEmpty()) {
			this.pc = null;
			this.bindings = Collections.emptyList();
		} else if (binding.size() == 1) {
			this.pc = binding.get(0).pointcut();
			this.bindings = Collections.singletonList(binding.get(0));
		} else {
			this.pc = new CompositePointCut(binding);
			this.bindings = Collections.unmodifiableList(binding);
		}

		for (Binding bind : bindings) {
			((BindingImpl) bind).setAdvice(this);
		}

		this.type = type;
		this.range = range;
		this.argIndices = args;
		this.argNames = argnames;
		
		
		//AWDB
		this.effectType = effectType;
		this.sourceLines = sourceLines;
		
		// method = baseName;
		// master.getEventSystem().addBindingCreationListener(new BCL());
	}

	// TODO caching weer inbouwen

	public List<AdviceApplication> allApplications() {

		try {
			/*if (jps == null) {
				jps = shadowMaster().getApplicationsFor(this);
			}*/
			return shadowMaster().getApplicationsFor(this);
			//return jps;
		} catch (NotAnAspectException e) {
			throw new InternalDebuggerException("owning aspect does not exist",
					e);
		} catch (NoSuchAdviceException e) {
			throw new InternalDebuggerException("advice does not exist", e);
		}
	}

	public Pointcut pointcut() {
		return pc;
	}

	@Override
	public AdviceExecutionJoinPoint executionJoinPoint() {
		return (AdviceExecutionJoinPoint) super.executionJoinPoint();
	}

	@Override
	public Aspect declaringType() {
		return (Aspect) super.declaringType();
	}

	// public Aspect definingType() {
	// try {
	// return getShadowMaster().getAspectFor((com.sun.jdi.ClassType)
	// base.declaringType());
	// } catch (NotAnAspectException e) {
	// throw new
	// InternalDebuggerException("Advice definded in non aspect class",e);
	// }
	// }

	public int[] argIndices;
	public String[] argNames;
	private List<LocalVariable> localVars;

	public List<String> argumentTypeNames() {
		return new SelectiveList<String>(getBase().argumentTypeNames(),
				argIndices);
	}

	public List<Type> argumentTypes() throws ClassNotLoadedException {
		return new InterList<com.sun.jdi.Type, Type>(
				new SelectiveList<com.sun.jdi.Type>(getBase().argumentTypes(),
						argIndices), shadowMaster().getTypeConverter());
	}

	public List<LocalVariable> arguments() throws AbsentInformationException {
		if (localVars == null) {
			localVars = new ArrayList<LocalVariable>(argIndices.length);
			List<com.sun.jdi.LocalVariable> oldVars = getBase().arguments();
			for (int i = 0; i < argIndices.length; i++) {
				if (argNames[i] == null)
					localVars.add(new LocalVariableImpl(oldVars
							.get(argIndices[i]), shadowMaster()));
				else
					localVars.add(new LocalVariableImpl(oldVars
							.get(argIndices[i]), shadowMaster(), argNames[i]));
			}
		}
		return localVars;
	}

	@Override
	public String genericSignature() {
		String sig = super.genericSignature();
		if (sig == null) {
			return null;
		}
		return (isBefore() ? "B" : (isAfter() ? "A" : "R")) + sig;
	}

	@Override
	public String signature() {
		return (isBefore() ? "B" : (isAfter() ? "A" : "R")) + super.signature();
	}

	@Override
	public boolean isConstructor() {
		return false;
	}

	@Override
	public boolean isNative() {
		return false;
	}

	@Override
	public boolean isStaticInitializer() {
		return false;
	}

	public boolean isAbstract() {
		return getBase().isAbstract();
	}

	@Override
	public int compareTo(Method o) {
		return getBase().compareTo(shadowMaster().unwrap(o));
	}

	public boolean isAfter() {
		return type == AdviceDescriptor.TYPE_AFTER;
	}

	public boolean isAround() {
		return type == AdviceDescriptor.TYPE_AROUND;
	}

	public boolean isBefore() {
		return type == AdviceDescriptor.TYPE_BEFORE;
	}

	public int getType() {
		return type;
	}

	@Override
	public SourceLocation location() {
		if (range == null) {
			if (getBase() != null) {
				com.sun.jdi.Location loc = getBase().location();
				try {
					range = new LineRange(virtualMachine(), shadowMaster(), loc
							.sourcePath(), loc.lineNumber(), -1);
				} catch (AbsentInformationException e) {
					range = new LineRange(virtualMachine(), shadowMaster(),
							null, loc.lineNumber(), -1);
				}
			}
		}
		return range;
	}

	public String toString() {
		return "Advice: " + declaringType().name() + " " + signature();
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((pc == null) ? 0 : pc.hashCode());
		// result = PRIME * result + ((range == null) ? 0 : range.hashCode());
		result = PRIME * result + type;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AdviceImpl))
			return false;
		final AdviceImpl other = (AdviceImpl) obj;
		if (pc == null) {
			if (other.pc != null)
				return false;
		} else if (!pc.equals(other.pc))
			return false;
		// if (range == null) {
		// if (other.range != null)
		// return false;
		// } else if (!range.equals(other.range))
		// return false;
		if (type != other.type)
			return false;
		return true;
	}

	public boolean matches(MethodIdentifier add) {
		return add.getMethodname().equals(getBase().name())
				&& add.getMethodsig().equals(getBase().signature())
				&& add.getClazz().equals(shadowMaster().unwrap(declaringType()).name());
	}

	public ClassType implementingType() {
		shadowMaster().checkLookThrough();
		return (ClassType) getBase().declaringType();
	}

	public List<Binding> bindings() {
		return bindings;
	}

	String getBaseSig() {
		return getBase().signature();
	}

	public void removeBinding(String name) {
		List<Binding> binding = new LinkedList<Binding>(bindings);
		
		for(Iterator<Binding> bit = binding.iterator();bit.hasNext();){
			Binding b = bit.next();
			if(b.name().equals(name)){
				bit.remove();
			}	
		}
		
		
		if (binding.isEmpty()) {
			this.pc = null;
			this.bindings = Collections.emptyList();
		} else if (binding.size() == 1) {
			this.pc = binding.get(0).pointcut();
			this.bindings = Collections.singletonList(binding.get(0));
		} else {
			this.pc = new CompositePointCut(binding);
			this.bindings = Collections.unmodifiableList(binding);
		}
		
	}

	public void addBinding(Binding bind) {
		if (bindings.isEmpty()) {
			this.pc = bind.pointcut();
			this.bindings = Collections.singletonList(bind);
		} else {
			List<Binding> binding = new ArrayList<Binding>(bindings);
			binding.add(bind);
			this.bindings = Collections.unmodifiableList(binding);
			this.pc = new CompositePointCut(binding);
		}

		((BindingImpl) bind).setAdvice(this);
		
		
	}
	
	//AWDB
	public String effectType()
	{
		return effectType;
	}
	
	public Integer []sourceLines()
	{
		return sourceLines;
	}
}
