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

import org.apache.bcel.classfile.ConstantPool;
import org.apache.bcel.classfile.Visitor;

import com.sun.org.apache.bcel.internal.Constants;

//$ANALYSIS-IGNORE,codereview.java.rules.cloneable.RuleCloneableOverrideClone
public abstract class Attribute extends org.apache.bcel.classfile.Attribute {
	protected Attribute(int name_index, int length, ConstantPool constant_pool) {
		super(Constants.ATTR_UNKNOWN, name_index, length, constant_pool);
	}

	abstract public String getName();

	@Override
	public void accept(Visitor v) {
	}
}
