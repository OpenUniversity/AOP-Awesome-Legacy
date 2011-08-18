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

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import adb.ShadowImpl;
import adb.ShadowMaster;
import ajdi.event.EventSet;

import com.sun.jdi.VirtualMachine;
import com.sun.jdi.event.EventQueue;

public class EventQueueImpl extends ShadowImpl implements ajdi.event.EventQueue {
	
	public EventQueueImpl(ShadowMaster master) {
		super(master);
	}

	private Queue<EventSet> evts = new LinkedList<EventSet>();

	@Override
	public EventSet remove() throws InterruptedException {
		synchronized (evts) {
			if(evts.isEmpty())
				evts.wait();
			return evts.remove();
		}
	}

	@Override
	public EventSet remove(long timeout) throws InterruptedException {
		synchronized (evts) {
			if(evts.isEmpty()){
				evts.wait(timeout);
				if(evts.isEmpty())
					return null;
			}
			return evts.remove();
		}
	}
	
	public void add(EventSet evt){
		synchronized (evts) {
			evts.add(evt);
			evts.notify();
		}
	}
	
	

}
