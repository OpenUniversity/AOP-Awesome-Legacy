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
import ajdi.Method;
import ajdi.MethodExecutionJoinPoint;

public class MethExecJPImpl extends JoinPointImpl implements MethodExecutionJoinPoint {

	private final Method method;

	public MethExecJPImpl(VirtualMachine vm,ShadowMaster master, Method in, List<AdviceApplicationImpl> apls, RangeImpl loc, LocationDescriptor shadow) {
		super(vm, master, apls, loc,shadow);
		this.method = in;
	}

	public Method method() {
		return method;
	}
	
	public String toString(){
		return "Method Execution Joinpoint on: " +method.name() +" " + method.signature()+" (" + location() + ")";
	}
}
