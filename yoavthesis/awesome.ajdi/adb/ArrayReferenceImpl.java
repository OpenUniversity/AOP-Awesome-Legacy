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
import ajdi.ArrayReference;
import ajdi.Value;

import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.ObjectReference;

public class ArrayReferenceImpl extends AbstractObjectReference<com.sun.jdi.ArrayReference> implements ArrayReference {

	public ArrayReferenceImpl(ArrayTypeImpl arrayTypeImpl, int length) {
		this(arrayTypeImpl.shadowMaster(),arrayTypeImpl.unwrap().newInstance(length));
	}

	public ArrayReferenceImpl(ShadowMaster master,
			com.sun.jdi.ArrayReference base) {
		super(base,master);
	}

	public Value getValue(int index) {
		return shadowMaster().wrap(base.getValue(index));
	}

	public List<Value> getValues() {
		return new InterList<com.sun.jdi.Value, Value>(base.getValues(),shadowMaster().getValueConverter());
	}

	public List<Value> getValues(int index, int length) {
		return new InterList<com.sun.jdi.Value, Value>(base.getValues(index, length),shadowMaster().getValueConverter());
	}

	public int length() {
		return base.length();
	}

	public void setValue(int index, Value value) throws InvalidTypeException,
			ClassNotLoadedException {
		base.setValue(index, shadowMaster().unwrap(value));
	}

	public void setValues(List<? extends Value> values)
			throws InvalidTypeException, ClassNotLoadedException {
		base.setValues(new InterList<Value, com.sun.jdi.Value>((List<Value>)values,shadowMaster().getValueUnwrapper()));
	}

	public void setValues(int index, List<? extends Value> values,
			int srcIndex, int length) throws InvalidTypeException,
			ClassNotLoadedException {
		base.setValues(index,new InterList<Value, com.sun.jdi.Value>((List<Value>)values,shadowMaster().getValueUnwrapper()),srcIndex,length);
	}

}
