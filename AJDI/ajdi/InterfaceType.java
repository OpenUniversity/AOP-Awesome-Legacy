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
 * @(#)InterfaceType.java	1.18 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ajdi;

import java.util.List;

/**
 * A mirror of an interface in the target VM. An InterfaceType is 
 * a refinement of {@link ReferenceType} that applies to true interfaces
 * in the JLS  sense of the definition (not a class, not an array type). 
 * An interface type will never be returned by 
 * {@link ObjectReference#referenceType}, but it may be in the list
 * of implemented interfaces for a {@link ClassType} that is returned 
 * by that method.
 *
 * @see ObjectReference 
 *
 * @author Robert Field
 * @author Gordon Hirsch
 * @author James McIlree
 * @since  1.3
 */
public interface InterfaceType extends ReferenceType {
    /**
     * Gets the interfaces directly extended by this interface.
     * The returned list contains only those interfaces this
     * interface has declared to be extended.
     *
     * @return a List of {@link InterfaceType} objects each mirroring
     * an interface extended by this interface.
     * If none exist, returns a zero length List.
     * @throws ClassNotPreparedException if this class not yet been 
     * prepared.
     */
    List<InterfaceType> superinterfaces();

    /**
     * Gets the currently prepared interfaces which directly extend this
     * interface. The returned list contains only those interfaces that
     * declared this interface in their "extends" clause.
     *
     * @return a List of {@link InterfaceType} objects each mirroring
     * an interface extending this interface.
     * If none exist, returns a zero length List.
     */
    List<InterfaceType> subinterfaces();

    /**
     * Gets the currently prepared classes which directly implement this
     * interface. The returned list contains only those classes that
     * declared this interface in their "implements" clause.
     *
     * @return a List of {@link ClassType} objects each mirroring
     * a class implementing this interface.
     * If none exist, returns a zero length List.
     */
    List<ClassType> implementors();
}

