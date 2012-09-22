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
 * @(#)Event.java	1.22 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ajdi.event;

import ajdi.*;
import ajdi.request.EventRequest;

/**
 * An occurrence in a target VM that is of interest to a debugger. Event is
 * the common superinterface for all events (examples include 
 * {@link BreakpointEvent}, {@link ExceptionEvent}, 
 * {@link ClassPrepareEvent}). 
 * When an event occurs, an instance of Event as a component of
 * an {@link EventSet} is enqueued in the
 * {@link VirtualMachine}'s {@link EventQueue}. 
 *
 * @see EventSet
 * @see EventQueue
 *
 * @author Robert Field
 * @since  1.3
 */
public interface Event extends Mirror {

    /**
     * @return The {@link EventRequest} that requested this event.
     * Some events (eg. {@link VMDeathEvent}) may not have
     * a cooresponding request and thus will return null.
     */
    EventRequest request();
}
