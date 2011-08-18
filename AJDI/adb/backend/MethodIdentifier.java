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

public class MethodIdentifier {
	
	public String getMethodname() {
		return methodname;
	}


	public String getMethodsig() {
		return methodsig;
	}


	public String getClazz() {
		return clazz;
	}
	protected final String methodname;
	protected final String methodsig;
	/**
	 * aspect fully qualified name (clazz name in case of aspect)
	 */
	protected String clazz;
	
	
	public MethodIdentifier(String clazz, String methodname, String methodsig) {
		super();
		if(clazz == null || methodname == null || methodsig == null)
			throw new IllegalArgumentException();
		this.clazz = clazz;
		this.methodname = methodname;
		this.methodsig = methodsig;
	}
	
	
	/**
	 * DANGER INCOMPLETE: missing clazz
	 */
	public MethodIdentifier(String methodname, String methodsig) {
		if(methodname == null || methodsig == null)
			throw new IllegalArgumentException();
		this.methodname = methodname;
		this.methodsig = methodsig;
		//YA
		//this.methodname = (methodname == null ? methodname : "<null>");
		//this.methodsig = (methodsig == null ? methodsig : "<null>");
		//YA
	}
	
	public void complete(String clazz){
		this.clazz = clazz;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
		result = prime * result
				+ ((methodname == null) ? 0 : methodname.hashCode());
		result = prime * result
				+ ((methodsig == null) ? 0 : methodsig.hashCode());
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
		MethodIdentifier other = (MethodIdentifier) obj;
		if (clazz == null) {
			if (other.clazz != null)
				return false;
		} else if (!clazz.equals(other.clazz))
			return false;
		if (methodname == null) {
			if (other.methodname != null)
				return false;
		} else if (!methodname.equals(other.methodname))
			return false;
		if (methodsig == null) {
			if (other.methodsig != null)
				return false;
		} else if (!methodsig.equals(other.methodsig))
			return false;
		return true;
	}
	
	

}
