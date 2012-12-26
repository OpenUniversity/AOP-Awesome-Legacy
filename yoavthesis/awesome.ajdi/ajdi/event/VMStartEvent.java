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
 * @(#)VMStartEvent.java	1.10 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ajdi.event;

import ajdi.*;

/**
 * Notification of initialization of a target VM.  This event is
 * received before the main thread is started and before any 
 * application code has been executed. Before this event occurs
 * a significant amount of system code has executed and a number 
 * of system classes have been loaded. 
 * This event is always generated by the target VM, even 
 * if not explicitly requested.
 *
 * @see VMDeathEvent
 * @see EventQueue
 * @see VirtualMachine
 *
 * @author Robert Field
 * @since  1.3
 */
public interface VMStartEvent extends Event {
    /**
     * Returns the initial thread of the VM which has started.
     *
     * @return a {@link ThreadReference} which mirrors the event's thread in 
     * the target VM.
     */
    public ThreadReference thread();
}
