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
 * @(#)BreakpointEvent.java	1.18 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ajdi.event;

import ajdi.*;

import java.util.List;

/**
 * Notification of a breakpoint in the target VM. 
 * The breakpoint event 
 * is generated before the code at its location is executed. 
 * When a location
 * is reached which satisfies a currently enabled 
 * {@link com.sun.jdi.request.BreakpointRequest breakpoint request}, 
 * an {@link EventSet event set}
 * containing an instance of this class will be added
 * to the VM's event queue. 
 *
 * @see EventQueue
 * @see VirtualMachine
 * @see com.sun.jdi.request.BreakpointRequest
 *
 * @author Robert Field
 * @since  1.3
 */
public interface BreakpointEvent extends LocatableEvent {

}
    

