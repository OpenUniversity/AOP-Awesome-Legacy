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
import com.sun.jdi.VirtualMachine;

import ajdi.LocalVariable;
import ajdi.StackFrame;
import ajdi.Type;

public class LocalVariableImpl implements LocalVariable {
	
	com.sun.jdi.LocalVariable base;
	private ShadowMaster master;
	private String name;
	
	public LocalVariableImpl(com.sun.jdi.LocalVariable base,ShadowMaster master){
		this.base = base;
		this.master = master;
		this.name = base.name();
	}

	public LocalVariableImpl(com.sun.jdi.LocalVariable base,ShadowMaster master,String name){
		this.base = base;
		this.master = master;
		this.name = name;
	}

	public String genericSignature() {
		return base.genericSignature();
	}

	public boolean isArgument() {
		return base.isArgument();
	}

	public boolean isVisible(StackFrame frame) {
		return base.isVisible(master.unwrap(frame));
	}

	public String name() {
		return name;
	}

	public String signature() {
		return base.signature();
	}

	public Type type() throws ClassNotLoadedException {
		return master.wrap(base.type());
	}

	public String typeName() {
		return base.typeName();
	}

	public VirtualMachine virtualMachine() {
		return base.virtualMachine();
	}

	public int compareTo(LocalVariable arg0) {
		return base.compareTo(master.unwrap(arg0));
	}

	public ShadowMaster shadowMaster() {
		return master;
	}

}
