/**
 * AODA - Aspect Oriented Debugging Architecture, BCEL/AspectJ component
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
package adb.backend.bcel.spi;

import adb.backend.FieldLocationProvider;
import adb.backend.LocationDescriptor;
import adb.backend.SourceLocationDescriptor;
import adb.backend.bcel.BCELBackend;
import adb.backend.bcel.FieldLineNumberAttribute;
import adb.backend.bcel.SourceLineContainingAttributeReader.LineInformation;

public class FieldLineNumberProvider implements FieldLocationProvider {
	
	private BCELBackend back;

	public FieldLineNumberProvider(BCELBackend back) {
		this.back=back;
	}

	public SourceLocationDescriptor getLocationFor(String classname, String fieldname) {
		FieldLineNumberAttribute att = (FieldLineNumberAttribute) back.getClassAttribute(classname, FieldLineNumberAttribute.name);
		LineInformation inf = att.getInfoFor(fieldname);
		return new SourceLocationDescriptor(inf.file,inf.lnr,inf.lnr);
	}

}
