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

import com.sun.jdi.event.WatchpointEvent;

public class WatchpointEventImpl<T extends com.sun.jdi.event.WatchpointEvent> extends LocatableEventImpl<T> implements ajdi.event.WatchpointEvent {

	public WatchpointEventImpl(T base, ShadowMaster master) {
		super(base, master);
	}

	public ajdi.Field field() {
		return shadowMaster().wrap(base.field());
	}

	public ajdi.ObjectReference object() {
		return shadowMaster().wrap(base.object());
	}

	public ajdi.Value valueCurrent() {
		return shadowMaster().wrap(base.valueCurrent());
	}

}