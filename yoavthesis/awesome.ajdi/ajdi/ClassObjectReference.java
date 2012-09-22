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
 * @(#)ClassObjectReference.java	1.11 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ajdi;

/**
 * An instance of java.lang.Class from the target VM.
 * Use this interface to access type information 
 * for the class, array, or interface that this object reflects.
 *
 * @see ReferenceType
 *
 * @author Gordon Hirsch
 * @since  1.3
 */
public interface ClassObjectReference extends ObjectReference {

    /**
     * Returns the {@link ReferenceType} corresponding to this 
     * class object. The returned type can be used to obtain 
     * detailed information about the class.
     *
     * @return the {@link ReferenceType} reflected by this class object.
     */
    ReferenceType reflectedType();
}

