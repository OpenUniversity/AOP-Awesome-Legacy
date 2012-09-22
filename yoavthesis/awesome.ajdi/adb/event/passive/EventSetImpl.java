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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import com.sun.jdi.InternalException;
import com.sun.jdi.VirtualMachine;

import adb.ShadowMaster;
import ajdi.ThreadReference;
import ajdi.event.Event;
import ajdi.event.EventIterator;
import ajdi.request.EventRequest;


public class EventSetImpl extends ArrayList<Event> implements ajdi.event.EventSet {

	private class Itr implements EventIterator {

		int cursor = 0;

		public boolean hasNext() {
			return cursor != size();
		}

		public Event next() {
			try {
				Event nxt = get(cursor);
				++cursor;
				return nxt;
			} catch (IndexOutOfBoundsException e) {
				throw new NoSuchElementException();
			}
		}

		public Event nextEvent() {
			return (Event) next();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	private final int suspendPolicy;
	private final ShadowMaster master;
	private final VirtualMachine vm;

	public EventSetImpl(ShadowMaster master, int suspendPolicy) {
		super();
		this.master = master;
		vm=master.getVirtualMachine();
		this.suspendPolicy = suspendPolicy;
	}

	public EventSetImpl(ShadowMaster master, int suspendPolicy,	List<Event> evts) {
		this(master,suspendPolicy);
		addAll(evts);
	}

	public Iterator<Event> iterator() {
		return new Itr();
	}

	public EventIterator eventIterator() {
		return new Itr();
	}
	
	private ThreadReference eventThread() {
        Iterator iter = this.iterator();
        while (iter.hasNext()) {
            Event event = (Event)iter.next();
            if (event instanceof ThreadedEvent) {
                return ((ThreadedEvent)event).thread();
            }
        }
        return null;
    }

	@Override
	public void resume() {
		switch (suspendPolicy()) {
		case EventRequest.SUSPEND_ALL:
			shadowMaster().resume();
			break;
		case EventRequest.SUSPEND_EVENT_THREAD:
			ThreadReference thread = eventThread();
			if (thread == null) {
				throw new InternalException("Inconsistent suspend policy");
			}
			thread.resume();
			break;
		case EventRequest.SUSPEND_NONE:
			// Do nothing
			break;
		default:
			throw new InternalException("Invalid suspend policy");
		}
	}

	@Override
	public int suspendPolicy() {
		return suspendPolicy;
	}

	@Override
	public ShadowMaster shadowMaster() {
		return master;
	}

	@Override
	public VirtualMachine virtualMachine() {
		return vm;
	}

}
