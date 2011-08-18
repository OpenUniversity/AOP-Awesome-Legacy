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

import ajdi.ReferenceType;
import ajdi.Shadow;
import ajdi.SourceLocation;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.VirtualMachine;

public class FieldImpl implements ajdi.Field {
	
	com.sun.jdi.Field base;
	private ShadowMaster master;
	private ReferenceType parent;

	public FieldImpl(com.sun.jdi.Field base,ajdi.ReferenceType parent, ShadowMaster master) {
		super();
		this.base = base;
		this.master = master;
		this.parent = parent;
	}

	public boolean isEnumConstant() {
		return base.isEnumConstant();
	}

	public boolean isTransient() {
		return base.isTransient();
	}

	public boolean isVolatile() {
		return base.isVolatile();
	}

	public ajdi.Type type() throws ClassNotLoadedException {
		return master.wrap(base.type());
	}

	public String typeName() {
		return base.typeName();
	}

	public ReferenceType declaringType() {
		return parent;
	}

	public String genericSignature() {
		return base.genericSignature();
	}

	public boolean isFinal() {
		return base.isFinal();
	}

	public boolean isStatic() {
		return base.isStatic();
	}

	public boolean isSynthetic() {
		return base.isSynthetic();
	}

	public String name() {
		return base.name();
	}

	public String signature() {
		return base.signature();
	}

	public VirtualMachine virtualMachine() {
		return base.virtualMachine();
	}

	public boolean isPackagePrivate() {
		return base.isPackagePrivate();
	}

	public boolean isPrivate() {
		return base.isPrivate();
	}

	public boolean isProtected() {
		return base.isProtected();
	}

	public boolean isPublic() {
		return base.isPublic();
	}

	public int modifiers() {
		return base.modifiers();
	}

	private SourceLocation loc;
	
	public SourceLocation location() throws AbsentInformationException {
		if(loc == null)
			loc = shadowMaster().getFieldLocation(this);
		return loc;
	}

	public int compareTo(ajdi.Field o) {
		return base.compareTo(shadowMaster().unwrap(o));
	}

	public ShadowMaster shadowMaster() {
		return master;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((base == null) ? 0 : base.hashCode());
		result = prime * result + ((master == null) ? 0 : master.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FieldImpl))
			return false;
		final FieldImpl other = (FieldImpl) obj;
		if (base == null) {
			if (other.base != null)
				return false;
		} else if (!base.equals(other.base))
			return false;
		if (master == null) {
			if (other.master != null)
				return false;
		} else if (!master.equals(other.master))
			return false;
		return true;
	}

	
	public String toString(){
		return base.toString();
	}

}
