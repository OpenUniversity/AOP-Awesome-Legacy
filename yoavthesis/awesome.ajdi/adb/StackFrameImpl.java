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
import java.util.Map;
import java.util.TreeMap;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.VirtualMachine;

import adb.tools.InterList;
import ajdi.Field;
import ajdi.LocalVariable;
import ajdi.Location;
import ajdi.ObjectReference;
import ajdi.StackFrame;
import ajdi.ThreadReference;
import ajdi.Value;

public class StackFrameImpl implements StackFrame {

	com.sun.jdi.StackFrame base;
	private ShadowMaster master;

	public StackFrameImpl(com.sun.jdi.StackFrame frame,ShadowMaster master) {
		this.base = frame;
		this.master = master;
	}

	public List<Value> getArgumentValues() {
		return new InterList<com.sun.jdi.Value, Value>(base.getArgumentValues(),master.getValueConverter());
	}

	public Value getValue(LocalVariable variable) {
		return master.wrap(base.getValue(master.unwrap(variable)));
	}

	public Map<LocalVariable, Value> getValues(
			List<? extends LocalVariable> variables) {
		Map<LocalVariable, Value> map = new TreeMap<LocalVariable, Value>();
		for (LocalVariable field : variables) {
			map.put(field, getValue(field));
		}
		return map;
	}

	public Location location() {
		return master.wrap(base.location());
	}

	public void setValue(LocalVariable variable, Value value)
			throws InvalidTypeException, ClassNotLoadedException {
		base.setValue(master.unwrap(variable), master.unwrap(value));
	}

	public ObjectReference thisObject() {
		if(base.thisObject() == null)
			return null;
		return master.wrap(base.thisObject());
	}

	public ThreadReference thread() {
		return master.wrap(base.thread());
	}

	public LocalVariable visibleVariableByName(String name)
			throws AbsentInformationException {
		return master.wrap(base.visibleVariableByName(name));
	}

	public List<LocalVariable> visibleVariables()
			throws AbsentInformationException {
		return new InterList<com.sun.jdi.LocalVariable, LocalVariable>(base.visibleVariables(),master.getVariableConverter());
	}

	public VirtualMachine virtualMachine() {
		return base.virtualMachine();
	}

	public ShadowMaster shadowMaster() {
		return master;
	}
	
	public String toString(){
		try{
			return location().toString();
		}catch( com.sun.jdi.InvalidStackFrameException e){
			return "InvalidStackFrame";
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((base == null) ? 0 : base.hashCode());
		result = prime * result + ((master == null) ? 0 : master.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof StackFrameImpl))
			return false;
		final StackFrameImpl other = (StackFrameImpl) obj;
		if (base == null) {
			if (other.base != null)
				return false;
		} else if (!base.equals(other.base))
			return false;
		if (master == null) {
			if (other.master != null)
				return false;
		} else if (!master.equals(other.master))
			return false;
		return true;
	}

}
