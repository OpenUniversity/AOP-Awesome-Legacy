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
 * @(#)WatchpointEvent.java	1.15 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ajdi.event;

import ajdi.*;

/**
 * Notification of a field triggered event encountered by a thread in the 
 * target VM.
 *
 * @see EventQueue
 * @see VirtualMachine
 *
 * @author Robert Field
 * @since  1.3
 */
public interface WatchpointEvent extends LocatableEvent {

    /**
     * Returns the field that is about to be accessed/modified. 
     *
     * @return a {@link Field} which mirrors the field
     * in the target VM.
     * @throws ObjectCollectedException may be thrown if class 
     * has been garbage collected.
     */
    Field field();

    /**
     * Returns the object whose field is about to be accessed/modified. 
     * Return null is the access is to a static field.
     *
     * @return a {@link ObjectReference} which mirrors the event's 
     * object in the target VM.
     */
    ObjectReference object();

    /**
     * Current value of the field.
     * @throws ObjectCollectedException if object or class have been 
     * garbage collected.
     */
    Value valueCurrent();
}
    

