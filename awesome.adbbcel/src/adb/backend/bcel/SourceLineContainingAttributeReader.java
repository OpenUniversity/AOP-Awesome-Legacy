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
import java.util.ArrayList;
import java.util.List;

import org.apache.bcel.classfile.ConstantPool;

public abstract class SourceLineContainingAttributeReader extends AttributeReader {
	
	private static class NullDecoder implements LinePartDecoder {

		public LineInformation decode(String linePart) {
			return null;
		}

	}

	private static class LineDecoder implements LinePartDecoder{
		
		private List<String> files = new ArrayList<String>();
		private List<String> paths = new ArrayList<String>();
		private int last = -1;
		
		
		public void addFile(int id,String file,String path){
			if(files.size() > id){
				files.set(id, file);
				paths.set(id, path);
			}
			while(files.size() < id){
				files.add(null);
				paths.add(null);
			}
			if(files.size() == id){
				files.add(file);
				paths.add(path);
			}
		}

		public LineInformation decode(String linePart) {
			String[] parts = linePart.split(":");
			if(parts.length == 1)
				return createInfo(last,Integer.parseInt(parts[0]));
			else{
				last = Integer.parseInt(parts[0]);
				return createInfo(last,Integer.parseInt(parts[1]));
			}
				
		}

		private LineInformation createInfo(int fileid, int line) {
			return new LineInformation(files.get(fileid),paths.get(fileid),line);
		}
		
	}
	public static class LineInformation{
		public final String file;
		public final String path;
		public final int lnr;
		
		public LineInformation(String file, String path, int lnr) {
			super();
			this.file = file;
			if(path != null)
				this.path = path;
			else
				this.path =file;
			this.lnr = lnr;
		}
		
		
	}
	
	public static interface LinePartDecoder{
		public LineInformation decode(String linePart);
	}
	

	public Attribute decode(String name,String data,int name_index, int length, DataInputStream file,
			ConstantPool pool){
			if(data.startsWith("*F\n")) {
				String[] lines = data.split("\n");
				int last = 0;
				for(;!"*B".equals( lines[last] );last++);
				String[] header = new String[last-1];
				String[] rest = new String[lines.length - last - 1];
				System.arraycopy(lines, 1, header, 0, last-1);
				System.arraycopy(lines, last+1, rest, 0,lines.length - last - 1);
				return decode(name,rest,eatheader(header),name_index,length,file,pool);
			} else
				return decode(name,data.split("\n"),new NullDecoder(),name_index,length,file,pool);
	}

	protected LinePartDecoder eatheader(String[] header) {
		LineDecoder out = new LineDecoder();
		
		for (int i = 0; i < header.length; i++) {
			if(header[i].startsWith("+")){
				String[] parts = header[i].split(" ",3);
				i++;
				out.addFile(Integer.parseInt(parts[1]), parts[2], header[i]);
			}else{
				String[] parts = header[i].split(" ",2);
				out.addFile(Integer.parseInt(parts[0]), parts[1],null);
			}
		}
		
		return out;
	}


	protected abstract Attribute decode(String name, String[] lines, LinePartDecoder decoder,int name_index, int length, DataInputStream file,
			ConstantPool pool);
}
