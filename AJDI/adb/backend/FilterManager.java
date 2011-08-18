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

import java.util.List;

import adb.MethodImpl;
import adb.ShadowMaster;
import ajdi.Method;

public interface FilterManager extends InfoProvider {
	
	//public void setShadowMaster(ShadowMaster shadowMaster);
	
	public List<com.sun.jdi.Method> filterMethods(List<com.sun.jdi.Method> methods); 
	
	public List<com.sun.jdi.Field> filterFields(List<com.sun.jdi.Field> fields); 

	/**
	 * @param immutable list of methods
	 */
	public com.sun.jdi.Method filterMethod(com.sun.jdi.Method method);
	/**
	 * @param immutable list of methods
	 */
	public com.sun.jdi.Field filterField(com.sun.jdi.Field field);

}
