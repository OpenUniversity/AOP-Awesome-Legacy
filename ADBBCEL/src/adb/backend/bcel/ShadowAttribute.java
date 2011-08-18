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

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.bcel.classfile.AttributeReader;
import org.apache.bcel.classfile.ConstantPool;

import com.sun.org.apache.bcel.internal.Constants;

import adb.backend.LocationDescriptor;
import adb.backend.MethodIdentifier;

public class ShadowAttribute extends Attribute {

	private Map<Integer, LocationDescriptor> locs;
	private MethodIdentifier meth;

	public static final String NAME = "adb.tagkit.ASHADOW";

	public ShadowAttribute(Map<Integer, LocationDescriptor> locs,
			int name_index, int length, ConstantPool constant_pool, MethodIdentifier meth) {
		super(name_index, length, constant_pool);
		this.locs = locs;
		this.meth = meth;
	}

	// for debugging
	public Map<Integer, LocationDescriptor> getLocations()
	{
		return locs;
	}
	
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public ShadowAttribute clone() {
		return copy(getConstantPool());
	}

	@Override
	public ShadowAttribute copy(ConstantPool pool) {
		return new ShadowAttribute(locs, getNameIndex(), getLength(), pool,meth);
	}

	public LocationDescriptor getLocationFor(int uid) {
		return locs.get(uid);
	}
	
	public MethodIdentifier getRangeMethod(){
		return meth;
	}

	public static class ShadowAttributeReader implements AttributeReader {
		
		public String getName() {
			return NAME;
		}

		public Attribute createAttribute(int name_index, int length,
				DataInputStream file, ConstantPool pool) {
			String name = pool.constantToString(name_index,
					Constants.CONSTANT_Utf8);
			if (!NAME.equals(name))
				return null;

			// skip name, index and copy to make sure the length is correct
			byte[] b = new byte[length - 2];
			try {
				file.read();
				file.read();
				file.readFully(b);
				file = new DataInputStream(new ByteArrayInputStream(b));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				String[] methodparts = file.readUTF().split(" ",3);
				String clazz = methodparts[0];
				String meth = methodparts[1];
				String methsig = methodparts[2];
				
				MethodIdentifier method = new MethodIdentifier(clazz,meth,methsig);
				int reps = file.readShort();

				Map<Integer, LocationDescriptor> jpds = new HashMap<Integer, LocationDescriptor>();

				for (int i = 0; i < reps; i++) {
					readShadowSection(file,method, jpds);
				}

				return new ShadowAttribute(jpds, name_index, length, pool,method);
			} catch (IOException e) {
				e.printStackTrace();
			}

			return null;
		}

		private void readShadowSection(DataInputStream file,
				MethodIdentifier meth, Map<Integer, LocationDescriptor> jpds) throws IOException {
			int uid = file.readShort();
			int rangeBegin = file.readShort();
			int rangeEnd = file.readShort();
			jpds.put(uid, new LocationDescriptor(meth,(long) rangeBegin,
					(long) rangeEnd));

		}
	}

}
