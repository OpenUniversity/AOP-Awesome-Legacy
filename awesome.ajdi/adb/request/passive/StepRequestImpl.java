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
package adb.request.passive;

import adb.ShadowMaster;

import com.sun.jdi.request.StepRequest;

class StepRequestImpl extends EventRequestImpl<com.sun.jdi.request.StepRequest> implements ajdi.request.StepRequest {

	public StepRequestImpl(StepRequest base, ShadowMaster master) {
		super(base, master);
	}

	public ajdi.ThreadReference thread() {
		return shadowMaster().wrap(base.thread());
	}

	public int size() {
		return base.size();
	}

	public int depth() {
		return base.depth();
	}

	public void addClassFilter(ajdi.ReferenceType var0) {
		base.addClassFilter(shadowMaster().unwrap(var0));
	}

	public void addClassFilter(java.lang.String var0) {
		base.addClassFilter(var0);
	}

	public void addClassExclusionFilter(java.lang.String var0) {
		base.addClassExclusionFilter(var0);
	}

	public void addInstanceFilter(ajdi.ObjectReference var0) {
		base.addInstanceFilter(shadowMaster().unwrap(var0));
	}
}