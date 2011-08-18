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

import adb.ShadowMaster;
import ajdi.JoinPoint;
import ajdi.event.JoinPointEntryEvent;
import ajdi.request.EventRequest;
import ajdi.request.JoinPointEntryRequest;

import com.sun.jdi.event.BreakpointEvent;

public class StmtJoinPointEntryEventImpl extends StmtJoinPointEventImpl implements JoinPointEntryEvent{

	private JoinPointEntryRequest jpr;

	public StmtJoinPointEntryEventImpl(BreakpointEvent base, JoinPointEntryRequest jpr) {
		super(base, jpr.shadowMaster());
		this.jpr = jpr;
	}

	@Override
	public JoinPoint joinPoint() {
		return jpr.joinPoint();
	}

	@Override
	public EventRequest request() {
		return jpr;
	}

}
