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
import java.io.EOFException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;


import org.apache.bcel.classfile.AttributeReader;
import org.apache.bcel.classfile.ConstantPool;
import org.apache.bcel.classfile.Visitor;

import adb.backend.AdviceApplicationDescriptor;
import adb.backend.AdviceDescriptor;
import adb.backend.MethodIdentifier;
import adb.backend.LocationDescriptor;

import com.sun.org.apache.bcel.internal.Constants;

public class CrossCuttingAttribute extends Attribute{
	
	private List<JoinPointDescriptor> jpds;

	public CrossCuttingAttribute(List<JoinPointDescriptor> jpds,int name_index, int length, ConstantPool constant_pool) {
		super(name_index,length,constant_pool);
		this.jpds = jpds;
	}

	public static final String NAME = "CrossCutting";

	public static class CrossCuttingAttributeReader implements AttributeReader {

		

		public Attribute createAttribute(int name_index, int length, DataInputStream file, ConstantPool pool) {
			
			//TODO no length check, too much work
			String name =pool.constantToString(name_index, Constants.CONSTANT_Utf8);
			if(!NAME.equals( name ))
				return null;
			
			//skip name, index and copy to make sure the length is correct
			byte[] b = new byte[length-2];
			try {
				file.read();
				file.read();
				file.readFully(b);
				file = new DataInputStream(new ByteArrayInputStream(b));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			int reps;
			try {
				reps = file.readShort();
				
				List<JoinPointDescriptor> jpds = new LinkedList<JoinPointDescriptor>();
				
				for (int i = 0; i < reps; i++) {
					jpds.add(readJoinPointSection(file));
				}
				
				
				return new CrossCuttingAttribute(jpds,name_index,length,pool);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return null;
		}

		//YA
		private JoinPointDescriptor readJoinPointSection(DataInputStream file) throws IOException 
		{
			int uid = 0;
			int type = 0;
			int slnr = 0;
			int elnr = 0;
			int rangeBegin = 0;
			int rangeEnd = 0;
			String[] shadowMethodparts =  new String[2];
			int n = 0;
			
			try
			{
				uid = file.readShort();
				type = file.readShort();
				slnr = file.readShort();
				elnr = file.readShort();
				rangeBegin = file.readShort();
				rangeEnd = file.readShort();
				shadowMethodparts = file.readUTF().split(" ");
				n = file.readShort();
			}
			catch(EOFException e)
			{}
						
			String shadowMethodName = shadowMethodparts[0];
			String shadowMethodSig = shadowMethodparts[1];
			
			List<AdviceApplicationDescriptor> ads = new Vector<AdviceApplicationDescriptor>(n);
			for(int i = 0;i < n;i++){
				ads.add(readAdviceApplication(file));
			}
			return new JoinPointDescriptor(uid,type,new LocationDescriptor(slnr,elnr,rangeBegin,rangeEnd),new LocationDescriptor(slnr,elnr,shadowMethodName,shadowMethodSig) ,ads);	
		}
		
		/*
		private JoinPointDescriptor readJoinPointSection(DataInputStream file) throws IOException {
			int uid = file.readShort();
			int type = file.readShort();
			int slnr = file.readShort();
			int elnr = file.readShort();
			int rangeBegin = file.readShort();
			int rangeEnd = file.readShort();
			String[] shadowMethodparts = file.readUTF().split(" ");
			String shadowMethodName = shadowMethodparts[0];
			String shadowMethodSig = shadowMethodparts[1];
			int n = file.readShort();
			List<AdviceApplicationDescriptor> ads = new Vector<AdviceApplicationDescriptor>(n);
			for(int i = 0;i < n;i++){
				ads.add(readAdviceApplication(file));
			}
			return new JoinPointDescriptor(uid,type,new LocationDescriptor(slnr,elnr,rangeBegin,rangeEnd),new LocationDescriptor(slnr,elnr,shadowMethodName,shadowMethodSig) ,ads);	
		}
		*/
		
		//YA

		private AdviceApplicationDescriptor readAdviceApplication(DataInputStream file) throws IOException {
			MethodIdentifier advice = readAdviceSection(file.readUTF());
			String res = file.readUTF();
			
			return new AdviceApplicationDescriptor(advice,res);
		}

		private MethodIdentifier readAdviceSection(String advice) {
			String[] parts = advice.split(" ");
			String aspect = parts[0];
			String methodName = parts[1];
			String methodSig = parts[2];
			
			return new MethodIdentifier(aspect,methodName,methodSig);
		}

		public String getName() {
			return NAME;
		}


		

	}

	@Override
	public void accept(Visitor v) {
	}

	@Override
	public CrossCuttingAttribute copy(ConstantPool pool) {
		return new CrossCuttingAttribute(jpds,getNameIndex(),getLength(),pool);
	}

	@Override
	public String getName() {
		return NAME;
	}

	public List<JoinPointDescriptor> getJoinPoints() {
		return jpds;
	}
	
	@Override
	public CrossCuttingAttribute clone(){
		return copy(getConstantPool());
	}

}