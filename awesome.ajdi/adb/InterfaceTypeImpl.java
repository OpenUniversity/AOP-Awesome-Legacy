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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.sun.jdi.AbsentInformationException;

import adb.tools.InterList;
import ajdi.ClassType;
import ajdi.Field;
import ajdi.InterfaceType;
import ajdi.Method;
import ajdi.SourceLocation;
import ajdi.Value;

public class InterfaceTypeImpl extends AbstractReferenceTypeImpl<com.sun.jdi.InterfaceType> implements
		InterfaceType {

	public InterfaceTypeImpl(com.sun.jdi.InterfaceType base, ShadowMaster master) {
		super(base, master);
	}

	@Override
	public List<Method> allMethods() {
		List<Method> out = new LinkedList<Method>();
		out.addAll(methods());
		for (InterfaceType intf : superinterfaces()) {
			out.addAll(intf.allMethods());
		}
		return out;
	}

	public List<ClassType> implementors() {
		return new InterList<com.sun.jdi.ClassType, ClassType>(unwrap().implementors(),master.getClassConverter());
	}

	public List<InterfaceType> subinterfaces() {
		return new InterList<com.sun.jdi.InterfaceType, InterfaceType>(unwrap().subinterfaces(),master.getInterfaceConverter());
	}

	public List<InterfaceType> superinterfaces() {
		return new InterList<com.sun.jdi.InterfaceType, InterfaceType>(unwrap().superinterfaces(),master.getInterfaceConverter());
	}

}
