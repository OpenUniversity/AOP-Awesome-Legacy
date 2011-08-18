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
package adb.event.passive;

import com.sun.jdi.VirtualMachine;
import com.sun.jdi.event.BreakpointEvent;

import adb.ShadowMaster;
import ajdi.JoinPoint;
import ajdi.Location;
import ajdi.ThreadReference;
import ajdi.event.JoinPointEvent;
import ajdi.request.EventRequest;

public abstract class StmtJoinPointEventImpl extends LocatableEventImpl< com.sun.jdi.event.BreakpointEvent> implements
		JoinPointEvent {
	
	
	public StmtJoinPointEventImpl(BreakpointEvent base, ShadowMaster master) {
		super(base, master);
	}

	@Override
	public abstract JoinPoint joinPoint();


	public abstract EventRequest request();
}
