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
package adb.backend.bcel;

import java.io.DataInputStream;

import org.apache.bcel.classfile.Attribute;
import org.apache.bcel.classfile.ConstantPool;

import com.sun.org.apache.bcel.internal.Constants;

public abstract class AttributeReader implements
		org.apache.bcel.classfile.AttributeReader {

	public Attribute createAttribute(int name_index, int length, DataInputStream file,
			ConstantPool pool) {
		String name =pool.constantToString(name_index, Constants.CONSTANT_Utf8);
		byte[] content = new byte[length];
		try {
			file.readFully(content);
			String data = new String(content);
			return decode(name,data,name_index,length,file,pool);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	protected abstract Attribute decode(String name,String data,int name_index, int length, DataInputStream file,
			ConstantPool pool);

	public abstract String getName();
}
