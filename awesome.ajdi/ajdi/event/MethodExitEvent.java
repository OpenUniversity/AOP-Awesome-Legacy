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
 * @(#)MethodExitEvent.java	1.13 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ajdi.event;

import ajdi.*;

/**
 * Notification of a method return in the target VM. This event
 * is generated after all code in the method has executed, but the 
 * location of this event is the last executed location in the method. 
 * Method exit events are generated for both native and non-native 
 * methods. Method exit events are not generated if the method terminates
 * with a thrown exception. 
 *
 * @see EventQueue
 *
 * @author Robert Field
 * @since  1.3
 */
public interface MethodExitEvent extends LocatableEvent {

    /**
     * Returns the method that was exited.
     *
     * @return a {@link Method} which mirrors the method that was exited.
     * @throws ObjectCollectedException may be thrown if class 
     * has been garbage collected.
     */
    public Method method();

    /**
     * Returns the value that the method will return.
     *
     * Not all target virtual machines support this operation. 
     * Use 
     * {@link VirtualMachine#canGetMethodReturnValues() canGetMethodReturnValues()}
     * to determine if this operation is supported.
     *
     * @return a {@link Value} which mirrors the value to be returned.
     *
     * @throws java.lang.UnsupportedOperationException if 
     * the target virtual machine does not support this 
     * operation - see 
     * {@link VirtualMachine#canGetMethodReturnValues() canGetMethodReturnValues()}
     *
     * @since 1.6
     */
    
    public Value returnValue();
}

