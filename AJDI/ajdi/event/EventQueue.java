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
/*
 * @(#)EventQueue.java	1.23 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ajdi.event;

import ajdi.*;

/**
 * Manager of incoming debugger events for a target VM.
 * Events are always grouped in {@link EventSet}s.
 * EventSets generated by the debugger back end can be read
 * here. There is one instance of EventQueue assigned to a particular 
 * {@link com.sun.jdi.VirtualMachine VirtualMachine}.
 * <P>
 * Some events cause the suspension of the target VM - event requests
 * ({@link com.sun.jdi.request}) with a 
 * {@link com.sun.jdi.request.EventRequest#suspendPolicy() suspend policy}
 * of {@link com.sun.jdi.request.EventRequest#SUSPEND_ALL SUSPEND_ALL}
 * or {@link com.sun.jdi.request.EventRequest#SUSPEND_EVENT_THREAD 
 * SUSPEND_EVENT_THREAD} and sometimes 
 * {@link VMStartEvent}.
 * If these suspensions are not resumed the target VM will hang.
 * Thus, it is always good policy to 
 * {@link #remove() remove()} every EventSet from the
 * event queue until an EventSet containing a
 * {@link VMDisconnectEvent} is read.
 * Unless {@link com.sun.jdi.VirtualMachine#resume() resume} is
 * being handled in another way, each EventSet should invoke
 * {@link EventSet#resume()}.
 *
 * @see EventSet
 * @see VirtualMachine
 *
 * @author Robert Field
 * @since  1.3
 */

public interface EventQueue extends Shadow {
   
    /**
     * Waits forever for the next available event.
     * 
     * @return the next {@link EventSet}.
     * @throws InterruptedException if any thread has interrupted
     * this thread.
     * @throws com.sun.jdi.VMDisconnectedException if the connection
     * to the target VM is no longer available.  Note this will always
     * be preceded by a {@link com.sun.jdi.event.VMDisconnectEvent}.
     */
    EventSet remove() throws InterruptedException;

    /**
     * Waits a specified time for the next available event.
     * 
     * @param timeout Time in milliseconds to wait for the next event
     * @return the next {@link EventSet}, or null if there is a timeout.
     * @throws InterruptedException if any thread has interrupted
     * this thread.
     * @throws com.sun.jdi.VMDisconnectedException if the connection
     * to the target VM is no longer available.  Note this will always
     * be preceded by a {@link com.sun.jdi.event.VMDisconnectEvent}.
     * @throws IllegalArgumentException if the timeout argument
     * contains an illegal value.
     */
    EventSet remove(long timeout) throws InterruptedException;
}
