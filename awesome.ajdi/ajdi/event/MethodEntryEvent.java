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
 * @(#)MethodEntryEvent.java	1.14 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ajdi.event;

import ajdi.*;

/**
 * Notification of a method invocation in the target VM. This event
 * occurs after entry into the invoked method and before any
 * code has executed. 
 * Method entry events are generated for both native and non-native 
 * methods.
 * <P>
 * In some VMs method entry events can occur for a particular thread
 * before its {@link ThreadStartEvent} occurs if methods are called
 * as part of the thread's initialization.
 *
 * @see EventQueue
 *
 * @author Robert Field
 * @since  1.3
 */
public interface MethodEntryEvent extends LocatableEvent {

    /**
     * Returns the method that was entered.
     *
     * @return a {@link Method} which mirrors the method that was entered.
     */
    public Method method();
}

