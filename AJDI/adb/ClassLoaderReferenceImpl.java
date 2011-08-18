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

import adb.tools.InterList;
import ajdi.ClassLoaderReference;
import ajdi.ReferenceType;

public class ClassLoaderReferenceImpl extends AbstractObjectReference<com.sun.jdi.ClassLoaderReference> implements
		ClassLoaderReference {

	public ClassLoaderReferenceImpl(com.sun.jdi.ClassLoaderReference base,ShadowMaster master) {
		super(base, master);
	}

	public List<ReferenceType> definedClasses() {
		return new InterList<com.sun.jdi.ReferenceType, ReferenceType>(base.definedClasses(),shadowMaster().getReferenceTypeConverter());
	}

	public List<ReferenceType> visibleClasses() {
		return new InterList<com.sun.jdi.ReferenceType, ReferenceType>(base.visibleClasses(),shadowMaster().getReferenceTypeConverter());
	}

}
