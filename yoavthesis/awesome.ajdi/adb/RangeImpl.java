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

import adb.backend.LocationDescriptor;
import ajdi.ClassType;
import ajdi.Location;
import ajdi.Method;
import ajdi.Range;
import ajdi.ReferenceType;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.VirtualMachine;

public class RangeImpl extends LocationImpl implements Range {

	private int elnr;
	private long ecid;

	public RangeImpl(ShadowMaster master, String sourcefile, int lnr,int elnr,
			ReferenceType declaringType, Method method, long cid,long ecid) {
		this(master.getVirtualMachine(),master, sourcefile, lnr,elnr, declaringType, method, cid,ecid);
	}

	public RangeImpl(VirtualMachine vm, ShadowMaster master, String sourcefile,
			int lnr,int elnr, ReferenceType declaringType, Method method, long cid,long ecid) {
		super(vm, master, sourcefile, lnr, declaringType, method, cid);
		if(ecid == LocationDescriptor.DEFAULT_INDEX)
			ecid = master.unwrap(method).bytecodes().length;
		if(elnr == LocationDescriptor.DEFAULT_INDEX){
			List<com.sun.jdi.Location> locs;
			try {
				locs = master.unwrap(method).allLineLocations();
				elnr = locs.get(locs.size()).lineNumber();
			} catch (AbsentInformationException e) {
				//throw new IllegalArgumentException("could not fill in endlnr",e);
				elnr = -1;
			}
		}
		
		if(elnr < -1 || ecid < -1)
			throw new IllegalArgumentException();
		
		this.elnr = elnr;
		this.ecid = ecid;
	}

	public RangeImpl(ShadowMaster master, ClassType clazz, Method method,
			LocationDescriptor loc) {
		//if(loc.getInfile() == null || loc.getSlnr() < 0 || loc.getElnr() <0 ||clazz == null || method == null ||  )
		this(master,loc.getInfile(),loc.getSlnr(),loc.getElnr(),clazz,method,loc.getStartCodeIndex(),loc.getEndCodeIndex());
	}

	public long lastCodeIndex() {
		return ecid;
	}

	public int lastLine() {
		return elnr;
	}

	@Override
	public Location endLocation() {
		
		return new LocationImpl(shadowMaster(),sourcefile,lastLine(),declaringType(),method(),lastCodeIndex());
		
	}
	
	public boolean contains(Range loc) {
		if(!loc.method().equals(method()))
			return false;
		
		if(!contains((Location)loc))
			return false;
		if(!contains(loc.endLocation()))
			return false;
		return true;
	}

	@Override
	public boolean contains(Location loc) {
		if(!loc.method().equals(method()))
			return false;
		
		if(codeIndex() > loc.codeIndex())
			return false;
		
		if(ecid < loc.codeIndex())
			return false;
		
		return true;
	}

	public boolean is(LocationDescriptor range) {
		if(!super.is(range))
			return false;

		return (range.getEndCodeIndex()==LocationDescriptor.DEFAULT_INDEX||ecid==range.getEndCodeIndex()) && (range.getElnr()==LocationDescriptor.DEFAULT_INDEX||elnr==range.getElnr());
	}
}
