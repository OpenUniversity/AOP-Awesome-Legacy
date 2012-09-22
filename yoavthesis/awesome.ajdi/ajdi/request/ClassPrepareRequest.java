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
 * @(#)ClassPrepareRequest.java	1.22 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ajdi.request;

import ajdi.*;

/**
 * Request for notification when a class is prepared in the target VM.
 * When an enabled ClassPrepareRequest is satisfied, an
 * {@link com.sun.jdi.event.EventSet event set} containing a
 * {@link com.sun.jdi.event.ClassPrepareEvent ClassPrepareEvent}
 * will be placed on the 
 * {@link com.sun.jdi.event.EventQueue EventQueue}.
 * The collection of existing ClassPrepareRequests is 
 * managed by the {@link EventRequestManager}
 * <p>
 * Class preparation is defined in the Java Virtual Machine
 * Specification.
 *
 * @see com.sun.jdi.event.ClassPrepareEvent
 * @see com.sun.jdi.event.EventQueue
 * @see EventRequestManager
 *
 * @author Robert Field
 * @since  1.3
 */
public interface ClassPrepareRequest extends EventRequest {

    /**
     * Restricts the events generated by this request to be the
     * preparation of the given reference type and any subtypes. 
     * An event will be generated for any prepared reference type that can
     * be safely cast to the given reference type. 
     *
     * @param refType the reference type to filter on.
     * @throws InvalidRequestStateException if this request is currently
     * enabled or has been deleted. 
     * Filters may be added only to disabled requests.
     */
    void addClassFilter(ReferenceType refType);

    /**
     * Restricts the events generated by this request to the 
     * preparation of reference types whose name matches this restricted
     * regular expression. Regular expressions are limited 
     * to exact matches and patterns that begin with '*' or end with '*'; 
     * for example, "*.Foo" or "java.*".
     *
     * @param classPattern the pattern String to filter for.
     * @throws InvalidRequestStateException if this request is currently
     * enabled or has been deleted. 
     * Filters may be added only to disabled requests.
     */
    void addClassFilter(String classPattern);

    /**
     * Restricts the events generated by this request to the 
     * preparation of reference types whose name does <b>not</b> match
     * this restricted regular expression. Regular expressions are limited 
     * to exact matches and patterns that begin with '*' or end with '*'; 
     * for example, "*.Foo" or "java.*".
     *
     * @param classPattern the pattern String to filter against.
     * @throws InvalidRequestStateException if this request is currently
     * enabled or has been deleted. 
     * Filters may be added only to disabled requests.
     */
    void addClassExclusionFilter(String classPattern);

    /**
     * Restricts the events generated by this request to the
     * preparation of reference types for which the restricted regular
     * expression 'sourceNamePattern' matches one of the 'sourceNames' for
     * the reference type being prepared.  
     * That is, if refType is the ReferenceType being prepared,
     * then there exists at least one stratum, call it 'someStratum'
     * on the list returned by
     *     refType.availableStrata();
     * 
     * such that a name on the list returned by
     *     refType.sourceNames(someStratam)
     * 
     * matches 'sourceNamePattern'.
     * Regular expressions are limited 
     * to exact matches and patterns that begin with '*' or end with '*'; 
     * for example, "*.Foo" or "java.*".
     * <P>
     * Not all targets support this operation. 
     * Use {@link VirtualMachine#canUseSourceNameFilters()}
     * to determine if the operation is supported.
     * @since 1.6
     * @param sourceNamePattern the pattern string to filter for.
     * @throws java.lang.UnsupportedOperationException if 
     * the target virtual machine does not support this 
     * operation.
     * @throws InvalidRequestStateException if this request is currently
     * enabled or has been deleted. 
     * Filters may be added only to disabled requests.
     */
    void addSourceNameFilter(String sourceNamePattern);
}
