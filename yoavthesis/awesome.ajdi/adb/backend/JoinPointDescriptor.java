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

import java.util.LinkedList;
import java.util.List;

public class JoinPointDescriptor implements Comparable<JoinPointDescriptor> {
	
	public static final int TYPE_METHOD_EXECUTION = 0x001;
	public static final int TYPE_STATEMENT = 0x002;
	public static final int TYPE_SINIT = 0x004;
	public static final int TYPE_INIT = 0x008;
	public static final int TYPE_PINIT = 0x0010;
	
	protected final List<AdviceApplicationDescriptor> advice;
	
	protected final LocationDescriptor range;
	
	protected final LocationDescriptor target;
	
	protected final int type;

	public JoinPointDescriptor(int type,LocationDescriptor range, LocationDescriptor target, List<AdviceApplicationDescriptor> advice) {
		super();
		this.type = type;
		this.range = range;
		this.target = target;
		this.advice = advice;
		
		if(advice != null){
			for (AdviceApplicationDescriptor aapl : advice) {
				aapl.setJoinpoint(this);
			}
		}
	}

	public List<AdviceApplicationDescriptor> getApplicationFor(String clazz, String methodname, String methodsig) {
		List<AdviceApplicationDescriptor> out = new LinkedList<AdviceApplicationDescriptor>();
		for (AdviceApplicationDescriptor binder : this.advice) {
			if(binder.advice.clazz.equals(clazz) && binder.advice.methodname.equals(methodname) && binder.advice.methodsig.equals(methodsig))
				out.add(binder);
		}
		return out;
	}
	
	public List<AdviceApplicationDescriptor> getApplicationFor(String binding) {
		List<AdviceApplicationDescriptor> out = new LinkedList<AdviceApplicationDescriptor>();
		for (AdviceApplicationDescriptor binder : this.advice) {
			if(binder.bindingName.equals(binding))
				out.add(binder);
		}
		return out;
	}
	
	public AdviceApplicationDescriptor getApplicationFor(String aspect, String methodname, String methodsig,String binding) {
		for (AdviceApplicationDescriptor binder : this.advice) {
			if(binder.bindingName.equals(binding) && binder.advice.clazz.equals(aspect) && binder.advice.methodname.equals(methodname) && binder.advice.methodsig.equals(methodsig))
				return (binder);
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((advice == null) ? 0 : advice.hashCode());
		result = prime * result + ((range == null) ? 0 : range.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		result = prime * result + type;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JoinPointDescriptor other = (JoinPointDescriptor) obj;
		if (range == null) {
			if (other.range != null)
				return false;
		} else if (!range.equals(other.range))
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	public int compareTo(JoinPointDescriptor o) {
		int types =  o.type - this.type ;
		if(types != 0)
			return types;
		int range = o.range.compareTo(this.range);
		return range;
	}

	public List<AdviceApplicationDescriptor> getAdvice() {
		return advice;
	}

	public LocationDescriptor getRange() {
		return range;
	}

	public LocationDescriptor getTarget() {
		return target;
	}

	public int getType() {
		return type;
	}

	public void complete(String pathFor, String classname, String methodname,
			String methodsig) {
		range.complete(pathFor,new MethodIdentifier(classname,methodname,methodsig));
		target.complete(pathFor,classname);
	}

	public void remove(AdviceApplicationDescriptor aapld) {
		advice.remove(aapld);
	}
	
}
