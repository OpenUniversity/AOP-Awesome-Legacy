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

import ajdi.Aspect;
import ajdi.ThreadReference;
import ajdi.event.AspectRemovedEvent;
import ajdi.request.EventRequest;

import com.sun.jdi.event.LocatableEvent;

public class AspectRemovalEventImpl extends EventImpl<LocatableEvent> implements AspectRemovedEvent {

	
	public AspectRemovalEventImpl(EventRequest req,Aspect name, LocatableEvent base) {
		super(base, req.shadowMaster());
		this.req = req;
		this.aspect = name;
	}

	private Aspect aspect;
	private EventRequest req;

	public ajdi.request.EventRequest request() {
		return req;
	}
	
	@Override
	public Aspect referenceType() {
		return aspect;
	}

	@Override
	public ThreadReference thread() {
		return shadowMaster().wrap(base.thread());
	}

}

