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
 * @(#)AccessWatchpointRequest.java	1.14 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ajdi.request;

import ajdi.*;

/**
 * Request for notification when the contents of a field are accessed
 * in the target VM.
 * This event will be triggered when the specified field is accessed
 * by Java<SUP><FONT SIZE="-2">TM</FONT></SUP> programming
 * language code or by a
 * Java Native Interface (JNI) get function (<code>Get&lt;Type&gt;Field,
 * GetStatic&lt;Type&gt;Field</code>).
 * Access by JDI does not trigger this event.
 * When an enabled AccessWatchpointRequest is satisfied, an
 * {@link com.sun.jdi.event.EventSet event set} containing an
 * {@link com.sun.jdi.event.AccessWatchpointEvent AccessWatchpointEvent} will be placed 
 * on the {@link com.sun.jdi.event.EventQueue EventQueue}.
 * The collection of existing ExceptionRequests is 
 * managed by the {@link EventRequestManager}
 * The collection of existing
 * watchpoints is 
 * managed by the {@link EventRequestManager}.  
 * <p>
 * Note that the modification
 * of a Field is not considered an access.
 *
 * @see ModificationWatchpointRequest
 * @see com.sun.jdi.event.EventQueue
 * @see EventRequestManager
 *
 * @author Robert Field
 * @since  1.3
 */
public interface AccessWatchpointRequest extends WatchpointRequest {
}


			
