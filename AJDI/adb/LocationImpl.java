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
/*
 * @(#)LocationImpl.java	1.28 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package adb;

import sun.security.action.GetLongAction;
import adb.backend.LocationDescriptor;
import ajdi.ClassType;
import ajdi.Location;
import ajdi.Method;
import ajdi.ReferenceType;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.VirtualMachine;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class LocationImpl extends SourceLocationImpl implements Location {

	private ReferenceType declaringType;

	private long cid;

	private Method method;

	public LocationImpl(ShadowMaster master, String sourcefile, int lnr,
			ReferenceType declaringType, Method method, long cid) {
		this(master.getVirtualMachine(),master,sourcefile,lnr,declaringType,method,cid);
	}
	
	/**
	 * @param vm
	 * @param master
	 * @param sourcefile 
	 * @param lnr
	 * @param declaringType
	 * @param method
	 * @param cid
	 * 
	 * sourcefile = sourcefile!=null?sourcefile:method.shadowMaster().unwrap(method).location().sourcePath()
	 */
	public LocationImpl(VirtualMachine vm,ShadowMaster master, String sourcefile, int lnr,
			ReferenceType declaringType, Method method, long cid) {
		super(vm, master, sourcefile!=null?sourcefile:findSourceFile(method), lnr!=LocationDescriptor.DEFAULT_INDEX?lnr:findLnr(method));
		if(method == null)
			throw new IllegalArgumentException("method must not be null");
		if(declaringType == null)
			throw new IllegalArgumentException("declaringType must not be null");
		this.declaringType = declaringType;
		this.method = method;
		if(cid < -1)
			throw new IllegalArgumentException("cid must not be positive");
		this.cid = cid;
	}


	private static int findLnr(Method method) {
		return method.shadowMaster().unwrap(method).location().lineNumber();
	}

	private static String findSourceFile(Method method) {
		if(method == null)
			throw new IllegalArgumentException("method must not be null");
				
		try {
			return method.shadowMaster().unwrap(method).location().sourcePath();
		} catch (AbsentInformationException e) {
			return null;
		}
	}

	public long codeIndex() {
		return cid;
	}

	public ReferenceType declaringType() {
		return declaringType;
	}

	public Method method() {
		return method;
	}

	public int compareTo(Location other) {
		int rc = method().compareTo(other.method());
		if (rc == 0) {
			long diff = codeIndex() - other.codeIndex();
			return ( diff < 0 ) ? -1 : (diff > 0) ? 1 : 0;
		}
		return rc;
	}

	public String toString() {
		if (lineNumber() == -1) {
			return method().toString() + "+" + codeIndex();
		} else {
			try {
				return sourcePath() + ":" + lineNumber() + " ("+ method().toString() +")";
			} catch (AbsentInformationException e) {
				return "UNKNOWN FILE" + ":" + lineNumber();
			}
		}
	}

	public boolean is(LocationDescriptor range) {
		if(!((MethodImpl)method).is(range.getMethod()))
			return false;

		if(!(range.getSlnr() == lineNumber() || (range.getSlnr() == LocationDescriptor.DEFAULT_INDEX && lineNumber() == findLnr(method))) )
			return false;
		
		return (cid == range.getStartCodeIndex());	
	}

}
