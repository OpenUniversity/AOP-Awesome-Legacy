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
 * @(#)ThreadDeathEvent.java	1.14 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ajdi.event;

import ajdi.*;

/**
 * Notification of a completed thread in the target VM. The 
 * notification is generated by the dying thread before it terminates.
 * Because of this timing, it is possible 
 * for {@link VirtualMachine#allThreads} to return this thread 
 * after this event is received. 
 * <p>
 * Note that this event gives no information
 * about the lifetime of the thread object. It may or may not be collected
 * soon depending on what references exist in the target VM.
 *
 * @see EventQueue
 * @see VirtualMachine
 * @see ThreadReference
 *
 * @author Robert Field
 * @since  1.3
 */
public interface ThreadDeathEvent extends Event {
    /**
     * Returns the thread which is terminating.
     *
     * @return a {@link ThreadReference} which mirrors the event's thread in 
     * the target VM.
     */
    public ThreadReference thread();
}
    

