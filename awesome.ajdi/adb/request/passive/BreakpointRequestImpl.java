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

import com.sun.jdi.request.BreakpointRequest;

class BreakpointRequestImpl extends EventRequestImpl<com.sun.jdi.request.BreakpointRequest> implements ajdi.request.BreakpointRequest {
	
	public BreakpointRequestImpl(BreakpointRequest base, ShadowMaster master) {
		super(base, master);
	}

	private com.sun.jdi.request.BreakpointRequest base;

	public ajdi.Location location() {
		return shadowMaster().wrap(base.location());
	}

	public void addThreadFilter(ajdi.ThreadReference var0) {
		base.addThreadFilter(shadowMaster().unwrap(var0));
	}

	public void addInstanceFilter(ajdi.ObjectReference var0) {
		base.addInstanceFilter(shadowMaster().unwrap(var0));
	}

}
