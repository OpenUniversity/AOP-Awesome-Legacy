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

public class SourceLocationDescriptor {
	
	protected String infile;
	protected int slnr,elnr;
	
	public SourceLocationDescriptor(String infile, int slnr,int elnr) {
		this.infile = infile;
		this.elnr = elnr;
		this.slnr = slnr;
	}

	
	/**
	 * DANGER INCOMPLETE
	 */
	protected SourceLocationDescriptor(int slnr, int elnr) {
		this.elnr = elnr;
		this.slnr = slnr;
	}

	protected void complete(String infile){
		this.infile = infile;
	}
	
	/**
	 * DANGER INCOMPLETE
	 */
	public SourceLocationDescriptor() {
	}
	
	public void complete(String infile, int slnr,int elnr) {
		this.infile = infile;
		this.elnr = elnr;
		this.slnr = slnr;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + elnr;
		result = prime * result + ((infile == null) ? 0 : infile.hashCode());
		result = prime * result + slnr;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SourceLocationDescriptor other = (SourceLocationDescriptor) obj;
		if (elnr != other.elnr)
			return false;
		if (infile == null) {
			if (other.infile != null)
				return false;
		} else if (!infile.equals(other.infile))
			return false;
		if (slnr != other.slnr)
			return false;
		return true;
	}

	public String getInfile() {
		return infile;
	}

	public int getSlnr() {
		return slnr;
	}

	public int getElnr() {
		return elnr;
	}

	
	

}
