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
package adb.backend.spi;

import java.util.List;

import com.sun.jdi.Field;

import adb.ShadowMaster;
import adb.backend.FilterManager;
import ajdi.Method;

public class NullFilter implements FilterManager {

	public com.sun.jdi.Method filterMethod(com.sun.jdi.Method method) {
		return method;
	}

	public List<com.sun.jdi.Method> filterMethods(
			List<com.sun.jdi.Method> methods) {
		return methods;
	}

	public List<Field> filterFields(List<Field> methods) {
		return methods;
	}

	public void setShadowMaster(ShadowMaster shadowMaster) {
	}

	public Field filterField(Field method) {
		return method;
	}

	

}
