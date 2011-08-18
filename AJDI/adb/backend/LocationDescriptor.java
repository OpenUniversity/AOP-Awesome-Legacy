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
package adb.backend;


/**
 * @author wouter
 *
 * record class to describe a code location
 * 
 * if(getEndCodeIndex == DEFAULT_INDEX)
 * 	getEndCodeIndex = method.getBytecodes.length
 * 
 * if(getSlnr == DEFAULT_INDEX)
 * 	getSlnr = method.allLineLocations.first.lnr
 * 
 * if(getElnr == DEFAULT_INDEX)
 * 	getElnr = method..allLineLocations.last.lnr
 * 
 * if(getInfile == null)
 * 	getInfile = method.getFile
 */
public class LocationDescriptor extends SourceLocationDescriptor {//implements Comparable<LocationDescriptor>{
	
	public static final int NO_INDEX = -1;
	public static final int DEFAULT_INDEX = -2; //endCodeIndex == last instruction
	
	private long startCodeIndex = -1,endCodeIndex = -1;
	private MethodIdentifier method;
	
	
	/**
	 * Danger incomplete: file and method missing
	 */
	public LocationDescriptor(int slnr,int elnr,long scodeIndex,long ecodeIndex){
		super(slnr,elnr);
		this.startCodeIndex = scodeIndex;
		this.endCodeIndex = ecodeIndex;
	}
	
	public void complete(String pathFor, MethodIdentifier methodIdentifier) {
		infile = pathFor;
		method = methodIdentifier;
	}
	
	public LocationDescriptor(String infile,int slnr,int elnr,String clazz,String methodName,String methodSig,long scodeIndex,long ecodeIndex){
		this(infile,slnr,elnr,new MethodIdentifier(clazz,methodName,methodSig),scodeIndex,ecodeIndex);
	}
	
	public LocationDescriptor(String infile, int slnr,int elnr,MethodIdentifier method, long scodeIndex,long ecodeIndex) {
		super(infile,slnr,elnr);
		this.method = method;
		this.startCodeIndex = scodeIndex;
		this.endCodeIndex = ecodeIndex;
	}

	/**
	 * Danger incomplete: class,file and CIDs
	 */
	public LocationDescriptor(int slnr, int elnr, String shadowMethodName,
			String shadowMethodSig) {
		super(slnr,elnr);
		this.method = new MethodIdentifier(shadowMethodName,shadowMethodSig);
		this.startCodeIndex = -1;
		this.endCodeIndex = -1;
	}
	
	public void complete(String pathFor,String clazz,long scodeIndex,long ecodeIndex) {
		infile = pathFor;
		this.startCodeIndex = scodeIndex;
		this.endCodeIndex = ecodeIndex;
	}
	
	/**
	 * Danger incomplete: file
	 */
	public void merge(LocationDescriptor cids) {
		if(null == cids)
			return;
		this.startCodeIndex = cids.startCodeIndex;
		this.endCodeIndex = cids.endCodeIndex;
	}

	public void complete(String pathFor,String clazz) {
		infile = pathFor;
		method.complete(clazz);
	}
	
	/**
	 * Danger incomplete: file and lnrs
	 */
	public LocationDescriptor(MethodIdentifier mi,long rangeBegin, long rangeEnd) {
		super();
		this.method = mi;
		this.startCodeIndex = rangeBegin;
		this.endCodeIndex= rangeEnd;
	}

	
	
	
	
	/* (non-Javadoc)
	 * sort on start only
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(LocationDescriptor o) {
		int infs = o.infile.compareTo(infile);
		if(infs != 0)
			return infs;
		int lnrs = o.slnr -slnr;
		if(lnrs != 0)
			return lnrs;
		//$ANALYSIS-IGNORE,codereview.java.rules.casting.RuleCastingPrimitives
		return (int)(o.startCodeIndex - startCodeIndex);
		
	}

/*	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (endCodeIndex ^ (endCodeIndex >>> 32));
		result = prime * result + elnr;
		result = prime * result + ((infile == null) ? 0 : infile.hashCode());
		result = prime * result + (int) (startCodeIndex ^ (startCodeIndex >>> 32));
		result = prime * result + slnr;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LocationDescriptor))
			return false;
		final LocationDescriptor other = (LocationDescriptor) obj;
		if (endCodeIndex != other.endCodeIndex)
			return false;
		if (elnr != other.elnr)
			return false;
		if (infile == null) {
			if (other.infile != null)
				return false;
		} else if (!infile.equals(other.infile))
			return false;
		if (startCodeIndex != other.startCodeIndex)
			return false;
		if (slnr != other.slnr)
			return false;
		return true;
	}*/

	public long getStartCodeIndex() {
		return startCodeIndex;
	}

	public long getEndCodeIndex() {
		return endCodeIndex;
	}

	public MethodIdentifier getMethod() {
		return method;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (endCodeIndex ^ (endCodeIndex >>> 32));
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + (int) (startCodeIndex ^ (startCodeIndex >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof LocationDescriptor))
			return false;
		LocationDescriptor other = (LocationDescriptor) obj;
		if (endCodeIndex != other.endCodeIndex)
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		if (startCodeIndex != other.startCodeIndex)
			return false;
		return true;
	}

	
	
	
}
