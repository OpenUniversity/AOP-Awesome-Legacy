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
 * @(#)Field.java	1.24 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ajdi;


import com.sun.jdi.ClassNotLoadedException;

/**
 * A class or instance variable in the target VM.
 * See {@link TypeComponent}
 * for general information about Field and Method mirrors.
 *
 * @see ObjectReferenceImpl
 * @see ReferenceType
 *
 * @author Robert Field
 * @author Gordon Hirsch
 * @author James McIlree
 * @since  1.3
 */
public interface Field extends TypeComponent,Comparable<Field>,SourceLocatable{

    /**
     * Returns a text representation of the type
     * of this field. 
     * Where the type is the type specified in the declaration
     * of this field.
     * <P>
     * This type name is always available even if
     * the type has not yet been created or loaded.
     *
     * @return a String representing the
     * type of this field.
     */
    String typeName();

    /**
     * Returns the type of this field.
     * Where the type is the type specified in the declaration
     * of this field.
     * <P>
     * For example, if a target class defines:
     * <PRE>
     *    short s;
     *    Date d;
     *    byte[] ba;</PRE>
     * And the JDI client defines these <CODE>Field</CODE> objects:
     * <PRE>
     *    Field sField = targetClass.fieldByName("s");
     *    Field dField = targetClass.fieldByName("d");
     *    Field baField = targetClass.fieldByName("ba");</PRE>
     * to mirror the corresponding fields, then <CODE>sField.type()</CODE>
     * is a {@link ShortType}, <CODE>dField.type()</CODE> is the
     * {@link ReferenceType} for <CODE>java.util.Date</CODE> and
     * <CODE>((ArrayType)(baField.type())).componentType()</CODE> is a
     * {@link ByteType}.
     * <P>
     * Note: if the type of this field is a reference type (class,
     * interface, or array) and it has not been created or loaded
     * by the declaring type's class loader - that is, 
     * {@link TypeComponent#declaringType <CODE>declaringType()</CODE>}
     * <CODE>.classLoader()</CODE>, 
     * then ClassNotLoadedException will be thrown.
     * Also, a reference type may have been loaded but not yet prepared,
     * in which case the type will be returned
     * but attempts to perform some operations on the returned type
     * (e.g. {@link ReferenceType#fields() fields()}) will throw
     * a {@link ClassNotPreparedException}.
     * Use {@link ReferenceType#isPrepared()} to determine if
     * a reference type is prepared.
     *
     * @see Type
     * @return the {@link Type} of this field.
     * @throws ClassNotLoadedException if the type has not yet been loaded
     * or created through the appropriate class loader. 
     */
    Type type() throws ClassNotLoadedException;

    /**
     * Determine if this is a transient field.
     *
     * @return <code>true</code> if this field is transient; false otherwise.
     */
    boolean isTransient();

    /**
     * Determine if this is a volatile field.
     *
     * @return <code>true</code> if this field is volatile; false otherwise.
     */
    boolean isVolatile();

    /**
     * Determine if this is a field that represents an enum constant.
     * @return <code>true</code> if this field represents an enum constant;
     * false otherwise.
     */
    boolean isEnumConstant();

    /**
     * Compares the specified Object with this field for equality.
     *
     * @return true if the Object is a Field and if both
     * mirror the same field (declared in the same class or interface, in
     * the same VM).
     */
    boolean equals(Object obj);

    /**
     * Returns the hash code value for this Field.
     *
     * @return the integer hash code
     */
    int hashCode();
}

