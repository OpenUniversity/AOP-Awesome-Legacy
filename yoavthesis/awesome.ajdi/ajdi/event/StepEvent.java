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
 * @(#)StepEvent.java	1.18 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ajdi.event;

import ajdi.*;

/**
 * Notification of step completion in the target VM. 
 * The step event 
 * is generated immediately before the code at its location is executed;
 * thus, if the step is entering a new method (as might occur with
 * {@link com.sun.jdi.request.StepRequest#STEP_INTO StepRequest.STEP_INTO})
 * the location of the event is the first instruction of the method.
 * When a step leaves a method, the location of the event will be the
 * first instruction after the call in the calling method; note that
 * this location may not be at a line boundary, even if 
 * {@link com.sun.jdi.request.StepRequest#STEP_LINE StepRequest.STEP_LINE}
 * was used.
 *
 * @see com.sun.jdi.request.StepRequest
 * @see EventQueue
 *
 * @author Robert Field
 * @since  1.3
 */
public interface StepEvent extends LocatableEvent {

}
    

