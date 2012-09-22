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

import ajdi.ByteValue;
import ajdi.Type;

public class ByteValueImpl extends PrimitiveValueImpl<com.sun.jdi.ByteValue> implements
		ByteValue {

	public ByteValueImpl(ShadowMaster master, com.sun.jdi.ByteValue base) {
		super(master, base);
	}

	@Override
	public Type type() {
		return shadowMaster().getPrimitives().getByteType();
	}

	public byte value() {
		return base.value();
	}
	
	public int compareTo(ByteValue o) {
		return base.compareTo((com.sun.jdi.ByteValue) shadowMaster().unwrap(o));
	}

}
