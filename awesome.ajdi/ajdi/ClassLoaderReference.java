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
 * @(#)ClassLoaderReference.java	1.19 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ajdi;

import java.util.List;

/**
 * A class loader object from the target VM.
 * A ClassLoaderReference is an {@link ObjectReference} with additional
 * access to classloader-specific information from the target VM. Instances
 * ClassLoaderReference are obtained through calls to
 * {@link ReferenceType#classLoader}
 *
 * @see ObjectReference
 *
 * @author Gordon Hirsch
 * @since  1.3
 */
public interface ClassLoaderReference extends ObjectReference {

    /**
     * Returns a list of all loaded classes that were defined by this
     * class loader. No ordering of this list guaranteed.
     * <P>
     * The returned list will include reference types
     * loaded at least to the point of preparation and
     * types (like array) for which preparation is
     * not defined.
     *
     * @return a List of {@link ReferenceType} objects mirroring types
     * loaded by this class loader. The list has length 0 if no types
     * have been defined by this classloader.
     */
    List<ReferenceType> definedClasses();

    /**
     * Returns a list of all classes for which this class loader has
     * been recorded as the initiating loader in the target VM.
     * The list contains ReferenceTypes defined directly by this loader
     * (as returned by {@link #definedClasses}) and any types for which
     * loading was delegated by this class loader to another class loader.
     * <p>
     * The visible class list has useful properties with respect to
     * the type namespace. A particular type name will occur at most
     * once in the list. Each field or variable declared with that
     * type name in a class defined by
     * this class loader must be resolved to that single type.
     * <p>
     * No ordering of the returned list is guaranteed.
     * <p>
     * See the revised
     * <a href="http://java.sun.com/docs/books/vmspec/">Java
     * Virtual Machine Specification</a> section
     * <a href="http://java.sun.com/docs/books/vmspec/2nd-edition/html/ConstantPool.doc.html#72007">5.3
     * Creation and Loading</a>
     * for more information on the initiating classloader.
     * <p>
     * Note that unlike {@link #definedClasses()}
     * and {@link VirtualMachine#allClasses()},
     * some of the returned reference types may not be prepared.
     * Attempts to perform some operations on unprepared reference types
     * (e.g. {@link ReferenceType#fields() fields()}) will throw
     * a {@link ClassNotPreparedException}.
     * Use {@link ReferenceType#isPrepared()} to determine if
     * a reference type is prepared.
     *
     * @return a List of {@link ReferenceType} objects mirroring classes
     * initiated by this class loader. The list has length 0 if no classes
     * are visible to this classloader.
     */
    List<ReferenceType> visibleClasses();
}

