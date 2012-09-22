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
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.bcel.classfile.ConstantPool;
import org.apache.bcel.classfile.Visitor;

import adb.backend.bcel.SourceLineContainingAttributeReader.LineInformation;


public class FieldLineNumberAttribute extends Attribute{

	

	public static class FieldLineNumberAttributeReader extends SourceLineContainingAttributeReader {

		@Override
		protected Attribute decode(String name, String[] lines, LinePartDecoder decoder, int name_index, int length, DataInputStream file, ConstantPool pool) {
			if(!FieldLineNumberAttribute.name.equals( name ))
				return null;
			FieldLineNumberAttribute attr = new FieldLineNumberAttribute(name_index,length,pool);
			
			if(lines[0].length() == 0)
				return attr; // no fields
			
			for (int i = 0; i < lines.length; i++) {
				String[] parts = lines[i].split(" ",2);
				attr.addfield(parts[0],decoder.decode(parts[1]));
			}
			return attr;
		}
		
		public String getName(){
			return name;
		}



}

	public static final String name = "FieldLineNumber";

	private Map<String,LineInformation> fields = new TreeMap<String, LineInformation>();
	
	protected FieldLineNumberAttribute(int name_index, int length, ConstantPool constant_pool) {
		super( name_index, length, constant_pool);
	}

	public FieldLineNumberAttribute(FieldLineNumberAttribute o, ConstantPool cp) {
		super( o.getNameIndex(), o.getLength(), cp);
		fields.putAll(o.fields);
	}

	public void addfield(String name, LineInformation information) {
		fields.put(name,information);
	}

	@Override
	public void accept(Visitor v) {
		//Tja, niet veel aan te doen
	}

	@Override
	public FieldLineNumberAttribute copy(ConstantPool cp) {
		return new FieldLineNumberAttribute(this,cp);
	}
	
	public Set<String> getFields(){
		return fields.keySet();
	}
	
	public LineInformation getInfoFor(String field){
		return fields.get(field);
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public FieldLineNumberAttribute clone(){
		return copy(getConstantPool());
	}
}