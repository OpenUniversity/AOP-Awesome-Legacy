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

import com.sun.jdi.VirtualMachine;

import ajdi.DoubleValue;
import ajdi.PrimitiveValue;
import ajdi.Type;

public abstract class PrimitiveValueImpl<T extends com.sun.jdi.PrimitiveValue> implements PrimitiveValue {
	
	private ShadowMaster master;
	protected T base;

	public PrimitiveValueImpl(ShadowMaster master,
			T base) {
		super();
		this.master = master;
		this.base = base;
	}

	public boolean booleanValue() {
		return base.booleanValue();
	}

	public byte byteValue() {
		return base.byteValue();
	}

	public char charValue() {
		return base.charValue();
	}

	public double doubleValue() {
		return base.doubleValue();
	}

	public float floatValue() {
		return base.floatValue();
	}

	public int intValue() {
		return base.intValue();
	}

	public long longValue() {
		return base.longValue();
	}

	public short shortValue() {
		return base.shortValue();
	}

	public abstract Type type();

	public ShadowMaster shadowMaster() {
		return master;
	}

	public VirtualMachine virtualMachine() {
		return base.virtualMachine();
	}
	
	public String toString(){
		return base.toString();
	}

}
