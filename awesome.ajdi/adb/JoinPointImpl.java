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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.sun.jdi.VirtualMachine;

import adb.backend.AdviceApplicationDescriptor;
import adb.backend.JoinPointDescriptor;
import adb.backend.LocationDescriptor;
import ajdi.AdviceApplication;
import ajdi.JoinPoint;

public abstract class JoinPointImpl implements JoinPoint {

	private final VirtualMachine vm;
	private ShadowMaster master;
	
	private final List<AdviceApplication> aps;
	private final RangeImpl loc;
	private LocationDescriptor shadow;

	public JoinPointImpl(VirtualMachine vm,ShadowMaster master, List<AdviceApplicationImpl> apls, RangeImpl loc, LocationDescriptor shadow) {
		this.vm = vm;
		this.aps = new ArrayList<AdviceApplication>(apls.size());
		this.loc = loc;
		this.shadow = shadow;
		this.master = master;
		
		for (AdviceApplicationImpl application : apls) {
			add(application);
		}
	}
	
	public void add(AdviceApplicationImpl application) {
		application.setJoinpoint(this);
		aps.add(application);
	}

	public List<AdviceApplication> advices() {
		return Collections.unmodifiableList(aps);
	}

	public VirtualMachine virtualMachine() {
		return vm;
	}

	public RangeImpl location() {
		return loc;
	}
	
	
	//return method shadow start location
	public LocationDescriptor shadow() {
		return shadow;
	}
	
	public ShadowMaster shadowMaster(){
		return master;
	}
	
	public String toString(){
		return "JoinPoint: " + location();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loc == null) ? 0 : loc.hashCode());
		result = prime * result + ((master == null) ? 0 : master.hashCode());
		return result;
	}

	public void remove(AdviceApplicationDescriptor aapld) {
		for(Iterator<AdviceApplication> aaplIt = aps.iterator();aaplIt.hasNext();){
			AdviceApplicationImpl current = (AdviceApplicationImpl) aaplIt.next();
			if(current.is(aapld))
				aaplIt.remove();
		}
	}
	
	public AdviceApplication get(AdviceApplicationDescriptor aapld) {
		for(Iterator<AdviceApplication> aaplIt = aps.iterator();aaplIt.hasNext();){
			AdviceApplicationImpl current = (AdviceApplicationImpl) aaplIt.next();
			if(current.is(aapld))
				return current;
		}
		return null;
	}

	public boolean is(JoinPointDescriptor joinpoint) {
		return loc.is(joinpoint.getRange());
	}

	

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		return true;
//	}
	
	
}
