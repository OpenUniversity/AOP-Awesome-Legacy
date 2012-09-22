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
 * @(#)VMDeathRequest.java	1.5 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ajdi.request;

import ajdi.*;

/**
 * Request for notification when the target VM terminates.
 * When an enabled VMDeathRequest is satisfied, an
 * {@link com.sun.jdi.event.EventSet event set} containing a
 * {@link com.sun.jdi.event.VMDeathEvent VMDeathEvent}
 * will be placed on the
 * {@link com.sun.jdi.event.EventQueue EventQueue}.
 * The collection of existing VMDeathRequests is 
 * managed by the {@link EventRequestManager}
 * <P>
 * Even without creating a VMDeathRequest, a single 
 * unsolicited VMDeathEvent will be sent with a 
 * {@link EventRequest#suspendPolicy() suspend policy} 
 * of {@link EventRequest#SUSPEND_NONE SUSPEND_NONE}.
 * This request would typically be created so that a
 * VMDeathEvent with a suspend policy of
 * {@link EventRequest#SUSPEND_ALL SUSPEND_ALL}
 * will be sent.  This event can be used to assure
 * completion of any processing which requires the VM
 * to be alive (e.g. event processing).  Note: the 
 * unsolicited VMDeathEvent will still be sent.
 *
 * @see com.sun.jdi.event.VMDeathEvent
 * @see com.sun.jdi.event.EventQueue
 * @see EventRequestManager
 *
 * @author Robert Field
 * @since  1.4
 */
public interface VMDeathRequest extends EventRequest {

}


			
