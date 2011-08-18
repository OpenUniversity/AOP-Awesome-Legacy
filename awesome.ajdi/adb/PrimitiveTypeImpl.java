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
package adb;

import com.sun.jdi.BooleanValue;
import com.sun.jdi.ByteValue;
import com.sun.jdi.CharValue;
import com.sun.jdi.DoubleValue;
import com.sun.jdi.FloatValue;
import com.sun.jdi.IntegerValue;
import com.sun.jdi.LongValue;
import com.sun.jdi.PrimitiveValue;
import com.sun.jdi.ShortValue;
import com.sun.jdi.VirtualMachine;

import ajdi.BooleanType;
import ajdi.ByteType;
import ajdi.CharType;
import ajdi.DoubleType;
import ajdi.FloatType;
import ajdi.IntegerType;
import ajdi.LongType;
import ajdi.PrimitiveType;
import ajdi.ShortType;
import ajdi.Type;
import ajdi.Value;
import ajdi.VoidType;
import ajdi.VoidValue;

public abstract class PrimitiveTypeImpl implements PrimitiveType {
	
	private ShadowMaster master;

	public PrimitiveTypeImpl(ShadowMaster master) {
		super();
		this.master = master;
	}

	public VirtualMachine virtualMachine() {
		return master.getVirtualMachine();
	}

	public ShadowMaster shadowMaster() {
		return master;
	}
	
	private static class VoidTypeImpl implements VoidType{
		
		private ShadowMaster master;

		public String name() {
			return "void";
		}

		public String signature() {
			return "V";
		}

		public ShadowMaster shadowMaster() {
			return master;
		}

		public VirtualMachine virtualMachine() {
			return master.getVirtualMachine();
		}

		public VoidTypeImpl(ShadowMaster master) {
			super();
			this.master = master;
		}
		
	}
	
	public static class VoidValueImpl implements VoidValue{

		private VoidType type;

		public Type type() {
			return type;
		}

		public ShadowMaster shadowMaster() {
			return type.shadowMaster();
		}

		public VirtualMachine virtualMachine() {
			return shadowMaster().getVirtualMachine();
		}

		public VoidValueImpl(VoidType type) {
			super();
			this.type = type;
		}
		
	}
	
	private static class BooleanTypeImpl extends PrimitiveTypeImpl implements BooleanType{

		public BooleanTypeImpl(ShadowMaster master) {
			super(master);
		}

		public String name() {
			return "boolean";
		}

		public String signature() {
			return "Z";
		}
		
	}
	
	private static class ByteTypeImpl extends PrimitiveTypeImpl implements ByteType{

		public ByteTypeImpl(ShadowMaster master) {
			super(master);
		}

		public String name() {
			return "byte";
		}

		public String signature() {
			return "B";
		}
		
	}
	
	private static class CharTypeImpl extends PrimitiveTypeImpl implements CharType{

		public CharTypeImpl(ShadowMaster master) {
			super(master);
		}

		public String name() {
			return "char";
		}

		public String signature() {
			return "C";
		}
		
	}
	
	private static class ShortTypeImpl extends PrimitiveTypeImpl implements ShortType{

		public ShortTypeImpl(ShadowMaster master) {
			super(master);
		}

		public String name() {
			return "short";
		}

		public String signature() {
			return "S";
		}
		
	}
	
	private static class IntegerTypeImpl extends PrimitiveTypeImpl implements IntegerType{

		public IntegerTypeImpl(ShadowMaster master) {
			super(master);
		}

		public String name() {
			return "int";
		}

		public String signature() {
			return "I";
		}
		
	}
	
	private static class LongTypeImpl extends PrimitiveTypeImpl implements LongType{

		public LongTypeImpl(ShadowMaster master) {
			super(master);
		}

		public String name() {
			return "long";
		}

		public String signature() {
			return "J";
		}
		
	}
	
	private static class FloatTypeImpl extends PrimitiveTypeImpl implements FloatType{

		public FloatTypeImpl(ShadowMaster master) {
			super(master);
		}

		public String name() {
			return "float";
		}

		public String signature() {
			return "F";
		}
		
	}
	
	private static class DoubleTypeImpl extends PrimitiveTypeImpl implements DoubleType{

		public DoubleTypeImpl(ShadowMaster master) {
			super(master);
		}

		public String name() {
			return "double";
		}

		public String signature() {
			return "D";
		}
		
	}
	
	public static Primitives getPrimitivesFor(ShadowMaster shm){
		return new Primitives(shm);
	}
	
	public static class Primitives {

		private BooleanType booleanType;
		private DoubleType doubleType;
		private CharType charType;
		private ByteType byteType;
		private FloatType floatType;
		private LongType longType;
		private IntegerType integerType;
		private ShortType shortType;
		private VoidType voidType;
		private VoidValue voidValue;
		private ShadowMaster master;

		public Primitives(ShadowMaster shm) {
			booleanType = new BooleanTypeImpl(shm);
			byteType = new ByteTypeImpl(shm);
			charType = new CharTypeImpl(shm);
			doubleType = new DoubleTypeImpl(shm);
			floatType = new FloatTypeImpl(shm);
			integerType = new IntegerTypeImpl(shm);
			longType = new LongTypeImpl(shm);
			shortType = new ShortTypeImpl(shm);
			voidType = new VoidTypeImpl(shm);
			voidValue = new VoidValueImpl(voidType);
			master = shm;
		}

		public BooleanType getBooleanType() {
			return booleanType;
		}
		
		public ShortType getShortType() {
			return shortType;
		}

		public DoubleType getDoubleType() {
			return doubleType;
		}

		public CharType getCharType() {
			return charType;
		}

		public ByteType getByteType() {
			return byteType;
		}

		public FloatType getFloatType() {
			return floatType;
		}

		public LongType getLongType() {
			return longType;
		}

		public IntegerType getIntegerType() {
			return integerType;
		}

		public VoidType getVoidType() {
			return voidType;
		}

		public VoidValue getVoidValue() {
			return voidValue;
		}

		public Type wrap(com.sun.jdi.PrimitiveType type) {
			if(type instanceof com.sun.jdi.BooleanType)
				return getBooleanType();
			else if(type instanceof com.sun.jdi.ByteType)
				return getByteType();
			else if(type instanceof com.sun.jdi.CharType)
				return getCharType();
			else if(type instanceof com.sun.jdi.DoubleType)
				return getDoubleType();
			else if(type instanceof com.sun.jdi.FloatType)
				return getFloatType();
			else if(type instanceof com.sun.jdi.IntegerType)
				return getIntegerType();
			else if(type instanceof com.sun.jdi.LongType)
				return getLongType();
			else if(type instanceof com.sun.jdi.ShortType)
				return getShortType();
			else
				throw new InternalDebuggerException("Unknow primitive type");
		}

		public Value wrap(PrimitiveValue in) {
			if(in instanceof com.sun.jdi.BooleanValue)
				return new BooleanValueImpl(master,(BooleanValue) in);
			else if(in instanceof com.sun.jdi.ByteValue)
				return new ByteValueImpl(master,(ByteValue) in);
			else if(in instanceof com.sun.jdi.CharValue)
				return new CharValueImpl(master,(CharValue) in);
			else if(in instanceof com.sun.jdi.DoubleValue)
				return new DoubleValueImpl(master,(DoubleValue) in);
			else if(in instanceof com.sun.jdi.FloatValue)
				return new FloatValueImpl(master,(FloatValue) in);
			else if(in instanceof com.sun.jdi.IntegerValue)
				return new IntegerValueImpl(master,(IntegerValue) in);
			else if(in instanceof com.sun.jdi.LongValue)
				return new LongValueImpl(master,(LongValue) in);
			else if(in instanceof com.sun.jdi.ShortValue)
				return new ShortValueImpl(master,(ShortValue) in);
			else
				throw new InternalDebuggerException("Unknow primitive value");
		}

	}


}
