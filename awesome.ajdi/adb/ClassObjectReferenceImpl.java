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

import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.InvocationException;

import ajdi.ClassObjectReference;
import ajdi.Field;
import ajdi.Method;
import ajdi.ReferenceType;
import ajdi.ThreadReference;
import ajdi.Value;

public class ClassObjectReferenceImpl extends AbstractObjectReference<com.sun.jdi.ClassObjectReference> implements
		ClassObjectReference {

	public ClassObjectReferenceImpl(com.sun.jdi.ClassObjectReference base,
			ShadowMaster master) {
		super(base, master);
	}

	public ReferenceType reflectedType() {
		return shadowMaster().wrap(base.reflectedType());
	}

}
