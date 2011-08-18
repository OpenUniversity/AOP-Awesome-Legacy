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
import ajdi.AdviceApplication;
import ajdi.StmtJoinPoint;

public class StmtJoinPointImpl extends JoinPointImpl implements StmtJoinPoint {

	public StmtJoinPointImpl(VirtualMachine vm, ShadowMaster master,List<AdviceApplicationImpl> apls, RangeImpl loc,LocationDescriptor shadow) {
		super(vm, master,apls, loc,shadow);
	}
	
	public String toString(){
		return "Stmt Joinpoint on: (" + location() + ")";
	}

}
