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
 * @(#)ExceptionEvent.java	1.17 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ajdi.event;

import ajdi.*;

/**
 * Notification of an exception in the target VM. When an exception
 * is thrown which satisfies a currently enabled 
 * {@link com.sun.jdi.request.ExceptionRequest exception request}, 
 * an {@link EventSet event set}
 * containing an instance of this class will be added
 * to the VM's event queue. 
 * If the exception is thrown from a non-native method, 
 * the exception event is generated at the location where the 
 * exception is thrown.
 * If the exception is thrown from a native method, the exception event
 * is generated at the first non-native location reached after the exception
 * is thrown.
 *
 * @author Robert Field
 * @since  1.3
 */
public interface ExceptionEvent extends LocatableEvent {

    /**
     * Gets the thrown exception object. The exception object is 
     * an instance of {@link java.lang.Throwable} or a subclass in the 
     * target VM.
     *
     * @return an {@link ObjectReference} which mirrors the thrown object in
     * the target VM. 
     */
    public ObjectReference exception();
    
    /**
     * Gets the location where the exception will be caught. An exception
     * is considered to be caught if, at the point of the throw, the
     * current location is dynamically enclosed in a try statement that
     * handles the exception. (See the JVM specification for details).
     * If there is such a try statement, the catch location is the 
     * first code index of the appropriate catch clause.
     * <p>
     * If there are native methods in the call stack at the time of the
     * exception, there are important restrictions to note about the 
     * returned catch location. In such cases,
     * it is not possible to predict whether an exception will be handled
     * by some native method on the call stack.
     * Thus, it is possible that exceptions considered uncaught
     * here will, in fact, be handled by a native method and not cause 
     * termination of the target VM. Furthermore, it cannot be assumed that the 
     * catch location returned here will ever be reached by the throwing 
     * thread. If there is 
     * a native frame between the current location and the catch location,
     * the exception might be handled and cleared in that native method 
     * instead.
     * <p>
     * Note that the compiler can generate try-catch blocks in some cases
     * where they are not explicit in the source code; for example, 
     * the code generated for <code>synchronized</code> and 
     * <code>finally</code> blocks can contain implicit try-catch blocks. 
     * If such an implicitly generated try-catch is 
     * present on the call stack at the time of the throw, the exception
     * will be considered caught even though it appears to be uncaught from
     * examination of the source code.
     * 
     * @return the {@link Location} where the exception will be caught or null if
     * the exception is uncaught.
     */
    public Location catchLocation();
}
