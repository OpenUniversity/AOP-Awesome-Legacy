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
import java.util.LinkedList;
import java.util.List;

import org.apache.bcel.classfile.ConstantPool;

import adb.backend.AdviceDescriptor;
import adb.backend.bcel.SourceLineContainingAttributeReader.LineInformation;
import adb.backend.bcel.SourceLineContainingAttributeReader.LinePartDecoder;

public class AspectAttribute extends Attribute {
	
	public static class AspectAttributeReader extends SourceLineContainingAttributeReader {

		@Override
		protected Attribute decode(String name, String[] lines, LinePartDecoder decoder,int name_index, int length, DataInputStream file,
				ConstantPool pool){
			if(!name.equals(getName()))
				return null;
			String[] strings = lines[0].split(" ");
			int per = Integer.parseInt(strings[0]);
			LineInformation slnr = decoder.decode(strings[1]);
			LineInformation elnr = decoder.decode(strings[2]);
			
			String mechName = strings[3];
			
			List<AdviceDescriptor> adv = new LinkedList<AdviceDescriptor>();
			for (int i = 1; i < lines.length; i++) {
				adv.add(decodeAdvice(lines[i],decoder));
			}
			return new AspectAttribute(mechName, per,adv,slnr,elnr,name_index,length,pool);
		}

		public static AdviceDescriptor decodeAdvice(String data, LinePartDecoder decoder) {
//			AdviceFormat extends SourceLineContainingFormat
//
//			Body :=	
//				[typeID] [LinePart]<slnr> [LinePart]<elnr> [aspect] [methodname] [methodsig] [pointcut] [ArgsSection]*
//
//			ArgSection :=
//				[name] [index]

			String[] parts = data.split(" ");
			
			int typeId = Integer.parseInt(parts[0]);
			LineInformation slnr = decoder.decode(parts[1]);
			LineInformation elnr = decoder.decode(parts[2]);
			String methodName = parts[3];
			String methodSig = parts[4];
			String pointCut = parts[5];
			String effectType = parts[6];
			
			String[] argNames = new String[(parts.length - 7)/2];
			int[] indices = new int[argNames.length];
			
			for (int i = 0; i < indices.length; i++) {
				argNames[i] = parts[i*2+7];
				indices[i] = Integer.parseInt(parts[i*2+8]);
			}
			
			return new AdviceDescriptor(typeId,slnr.path,slnr.lnr,elnr.lnr,methodName,methodSig,indices,argNames,pointCut,
					effectType);
		}

		@Override
		public String getName() {
			return AspectAttribute.name;
		}

	}

	public static final String name = "Aspect";

	private int per;
	private List<AdviceDescriptor> advices;

	private LineInformation slnr;

	private LineInformation elnr;
	
	private String mechName;

	public String getMechName()
	{
		return mechName;
	}
	
	public LineInformation getSlnr() {
		return slnr;
	}

	public LineInformation getElnr() {
		return elnr;
	}

	public List<AdviceDescriptor> getAdvices() {
		return advices;
	}

	public int getPer() {
		return per;
	}

	public AspectAttribute(String mechName, int per, List<AdviceDescriptor> adv,LineInformation slnr, LineInformation elnr, int name_index, int length, ConstantPool pool) {
		super(name_index,length,pool);
		this.per = per;
		this.slnr =slnr;
		this.elnr = elnr;
		this.advices = adv;
		this.mechName = mechName;
	}

	@Override
	public AspectAttribute copy(ConstantPool _constant_pool) {
		return new AspectAttribute(getMechName(), getPer(),getAdvices(),getSlnr(),getElnr(),getNameIndex(),getLength(),_constant_pool);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public AspectAttribute clone(){
		return new AspectAttribute(getMechName(), getPer(),getAdvices(),getSlnr(),getElnr(),getNameIndex(),getLength(),constant_pool);
	}
	
}
