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

import ajdi.ShortValue;
import ajdi.Type;

public class ShortValueImpl extends PrimitiveValueImpl<com.sun.jdi.ShortValue> implements
		ShortValue {

	public ShortValueImpl(ShadowMaster master, com.sun.jdi.ShortValue base) {
		super(master, base);
	}

	@Override
	public Type type() {
		return shadowMaster().getPrimitives().getShortType();
	}

	public short value() {
		return base.value();
	}
	
	public int compareTo(ShortValue o) {
		return base.compareTo((com.sun.jdi.ShortValue) shadowMaster().unwrap(o));
	}

}
