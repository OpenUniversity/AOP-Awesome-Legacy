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

import java.util.Collections;
import java.util.List;

import ajdi.ArrayReference;
import ajdi.ArrayType;
import ajdi.Method;
import ajdi.Type;

import com.sun.jdi.ClassNotLoadedException;

public class ArrayTypeImpl extends AbstractReferenceTypeImpl<com.sun.jdi.ArrayType> implements ArrayType {

	public ArrayTypeImpl(com.sun.jdi.ArrayType base, ShadowMaster master) {
		super(base, master);
	}

	@Override
	public List<Method> allMethods() {
		return Collections.emptyList();
	}

	public String componentSignature() {
		return unwrap().componentSignature();
	}

	public Type componentType() throws ClassNotLoadedException {
		return master.wrap(unwrap().componentType());
	}

	public String componentTypeName() {
		return unwrap().componentTypeName();
	}

	public ArrayReference newInstance(int length) {
		return new ArrayReferenceImpl(this,length);
	}

}
