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

import com.sun.jdi.VirtualMachine;

import adb.backend.LocationDescriptor;
import ajdi.ClassType;
import ajdi.Method;
import ajdi.SInitJointPoint;

public class SInitJoinPointImpl extends MethExecJPImpl implements
		SInitJointPoint {

	public SInitJoinPointImpl(VirtualMachine vm, ShadowMaster master,Method method, List<AdviceApplicationImpl> apls, RangeImpl loc,ClassType owner,LocationDescriptor shadow) {
		super(vm, master, method, apls, loc,shadow);
		this.owner = owner;
	}

	public String toString(){
		return "Static Initialisation Joinpoint on: " +owner.name() +" (" + location() + ")";
	}
	
	private ClassType owner;
	
	public ClassType owner() {
		return owner;
	}
}
