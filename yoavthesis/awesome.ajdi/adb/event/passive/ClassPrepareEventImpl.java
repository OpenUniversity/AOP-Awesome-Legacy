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

import com.sun.jdi.event.ClassPrepareEvent;

public class ClassPrepareEventImpl extends EventImpl<com.sun.jdi.event.ClassPrepareEvent> implements ThreadedEvent,ajdi.event.ClassPrepareEvent {
	

	public ClassPrepareEventImpl(ClassPrepareEvent base, ShadowMaster master) {
		super(base, master);
	}

	public ajdi.ThreadReference thread() {
		return shadowMaster().wrap(base.thread());
	}

	public ajdi.ReferenceType referenceType() {
		return shadowMaster().wrap(base.referenceType());
	}


}