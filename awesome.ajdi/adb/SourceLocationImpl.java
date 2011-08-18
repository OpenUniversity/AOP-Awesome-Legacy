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

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.VirtualMachine;

import adb.backend.LocationDescriptor;
import ajdi.ClassType;
import ajdi.Location;
import ajdi.Method;
import ajdi.SourceLocation;

public class SourceLocationImpl implements SourceLocation {

	private VirtualMachine vm;

	private int lnr;

	protected String sourcefile;

	private ShadowMaster master;

	public SourceLocationImpl(VirtualMachine vm, ShadowMaster master,
			String sourcefile, int lnr) {
		super();
		if(vm == null || lnr < -1 || master == null)
			throw new IllegalArgumentException();
		this.vm = vm;
		this.sourcefile = sourcefile;
		this.lnr = lnr;
		this.master = master;
	}

	public SourceLocationImpl(SourceLocationImpl range, String sourcePath) {

		this(range.virtualMachine(), range.shadowMaster(), sourcePath, range
				.lineNumber());

	}

	public int lineNumber() {
		return lnr;
	}

	// public int lineNumber(String stratum) {
	// throw new InternalDebuggerException("not implented");
	// }

	public String sourceName() throws AbsentInformationException {
		return getSourcefile().substring(getSourcefile().lastIndexOf("/") + 1,
				getSourcefile().length());
	}

	// public String sourceName(String stratum) throws
	// AbsentInformationException {
	// throw new AbsentInformationException();
	// }

	public String sourcePath() throws AbsentInformationException {
		return getSourcefile();
	}

	// public String sourcePath(String stratum) throws
	// AbsentInformationException {
	// throw new AbsentInformationException();
	// }

	public VirtualMachine virtualMachine() {
		return vm;
	}

	// public int compareTo(Location other) {
	// int rc = sourcePath().compareTo(other.sourcePath());
	// if (rc == 0) {
	// long diff = codeIndex() - other.codeIndex();
	// if (diff < 0)
	// return -1;
	// else if (diff > 0)
	// return 1;
	// else
	// return 0;
	// }
	// return rc;
	// }

	public String toString() {
		try {
			return sourcePath() + ":" + lineNumber();
		} catch (Exception e) {
			return "" + lineNumber();
		}
	}

	public ShadowMaster shadowMaster() {
		return master;
	}

	private String getSourcefile() throws AbsentInformationException {
		if (sourcefile == null)
			throw new AbsentInformationException();
		return sourcefile;
	}

	public boolean is(LocationDescriptor range) {
		return range.getSlnr() == lnr;
	}
}
