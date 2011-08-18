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
 * @(#)ModificationWatchpointRequest.java	1.13 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ajdi.request;

import ajdi.*;

/**
 * Request for notification when a field is set.
 * This event will be triggered when a value is assigned to the specified
 * field with a Java<SUP><FONT SIZE="-2">TM</FONT></SUP> programming
 * language statement (assignment, increment, etc) or by a
 * Java Native Interface (JNI) set function (<code>Set&lt;Type&gt;Field,
 * SetStatic&lt;Type&gt;Field</code>).
 * Setting a field to a value which is the same as the previous value
 * still triggers this event.
 * Modification by JDI does not trigger this event.
 * When an enabled 
 * ModificationWatchpointRequest is satisfied, an
 * {@link com.sun.jdi.event.EventSet event set} containing a
 * {@link com.sun.jdi.event.ModificationWatchpointEvent ModificationWatchpointEvent}
 * will be placed on 
 * the {@link com.sun.jdi.event.EventQueue EventQueue}.
 * The collection of existing
 * watchpoints is 
 * managed by the {@link EventRequestManager}.  
 *
 * @see com.sun.jdi.event.ModificationWatchpointEvent
 * @see AccessWatchpointRequest
 * @see com.sun.jdi.event.EventQueue
 * @see EventRequestManager
 *
 * @author Robert Field
 * @since  1.3
 */
public interface ModificationWatchpointRequest extends WatchpointRequest {
}


			
