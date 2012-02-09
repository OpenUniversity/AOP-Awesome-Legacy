/* *******************************************************************
 * Copyright (c) 2004 IBM
 * All rights reserved. 
 * This program and the accompanying materials are made available 
 * under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *  
 * Contributors: 
 *     Andy Clement -     initial implementation {date}
 * ******************************************************************/

package org.aspectj.apache.bcel.classfile.annotation;

import java.io.DataOutputStream;
import java.io.IOException;

import org.aspectj.apache.bcel.classfile.ConstantDouble;
import org.aspectj.apache.bcel.classfile.ConstantFloat;
import org.aspectj.apache.bcel.classfile.ConstantInteger;
import org.aspectj.apache.bcel.classfile.ConstantLong;
import org.aspectj.apache.bcel.classfile.ConstantUtf8;
import org.aspectj.apache.bcel.classfile.ConstantPool;
import org.aspectj.apache.bcel.Constants;

public class SimpleElementValueGen extends ElementValueGen {	
	
	// For primitive types and string type, this points to the value entry in the cpGen
	// For 'class' this points to the class entry in the cpGen
	private int idx;
	
	
	// ctors for each supported type...  type could be inferred but for now lets
	// force it to be passed
	
	/**
	 * Protected ctor used for deserialization, doesn't *put* an entry in the constant pool,
	 * assumes the one at the supplied index is correct.
	 */
    protected SimpleElementValueGen(int type,int idx,ConstantPool cpGen) {
    	super(type,cpGen);
    	this.idx = idx;
    }
    
    public SimpleElementValueGen(int type,ConstantPool cpGen,int value) {
    	super(type,cpGen);
    	idx = cpGen.addInteger(value);
    }
    
    public SimpleElementValueGen(int type,ConstantPool cpGen,long value) {
    	super(type,cpGen);
    	idx = cpGen.addLong(value);
    }
    
    public SimpleElementValueGen(int type,ConstantPool cpGen,double value) {
    	super(type,cpGen);
    	idx = cpGen.addDouble(value);
    }
    
    public SimpleElementValueGen(int type,ConstantPool cpGen,float value) {
    	super(type,cpGen);
    	idx = cpGen.addFloat(value);
    }

    public SimpleElementValueGen(int type,ConstantPool cpGen,short value) {
    	super(type,cpGen);
    	idx = cpGen.addInteger(value);
    }

    public SimpleElementValueGen(int type,ConstantPool cpGen,byte value) {
    	super(type,cpGen);
    	idx = cpGen.addInteger(value);
    }

    public SimpleElementValueGen(int type,ConstantPool cpGen,char value) {
    	super(type,cpGen);
    	idx = cpGen.addInteger(value);
    }

    public SimpleElementValueGen(int type,ConstantPool cpGen,boolean value) {
    	super(type,cpGen);
    	if (value) idx = cpGen.addInteger(1);
    	else       idx = cpGen.addInteger(0);
    }
    
    public SimpleElementValueGen(int type,ConstantPool cpGen,String value) {
    	super(type,cpGen);
    	idx = cpGen.addUtf8(value);
    }
    

  public byte getValueByte() {
  	if (type != PRIMITIVE_BYTE) 
  		throw new RuntimeException("Dont call getValueByte() on a non BYTE ElementValue");
		ConstantInteger c = (ConstantInteger)cpGen.getConstant(idx,Constants.CONSTANT_Integer);
		return (byte)c.getBytes();
  }
  
  public char getValueChar() {
  	if (type != PRIMITIVE_CHAR) 
  		throw new RuntimeException("Dont call getValueChar() on a non CHAR ElementValue");
		ConstantInteger c = (ConstantInteger)cpGen.getConstant(idx,Constants.CONSTANT_Integer);
		return (char)c.getBytes();
  }
  
  public long getValueLong() {
  	if (type != PRIMITIVE_LONG) 
  		throw new RuntimeException("Dont call getValueLong() on a non LONG ElementValue");
  	ConstantLong j = (ConstantLong)cpGen.getConstant(idx);
  	return j.getBytes();
  }
  
  public float getValueFloat() {
  	if (type != PRIMITIVE_FLOAT)
  		throw new RuntimeException("Dont call getValueFloat() on a non FLOAT ElementValue");
  	ConstantFloat f = (ConstantFloat)cpGen.getConstant(idx);
  	return f.getBytes();
  }


  public double getValueDouble() {
  	if (type != PRIMITIVE_DOUBLE)
  		throw new RuntimeException("Dont call getValueDouble() on a non DOUBLE ElementValue");
  	ConstantDouble d = (ConstantDouble)cpGen.getConstant(idx);
  	return d.getBytes();
  }
  
  public boolean getValueBoolean() {
  	if (type != PRIMITIVE_BOOLEAN)
  		throw new RuntimeException("Dont call getValueBoolean() on a non BOOLEAN ElementValue");
  	ConstantInteger bo = (ConstantInteger)cpGen.getConstant(idx);
  	return (bo.getBytes()!=0);
  }
  
  public short getValueShort() {
  	if (type != PRIMITIVE_SHORT)
  		throw new RuntimeException("Dont call getValueShort() on a non SHORT ElementValue");
  	ConstantInteger s = (ConstantInteger)cpGen.getConstant(idx);
  	return (short)s.getBytes();
  }
    /**
     * The boolean controls whether we copy info from the 'old' constant pool
     * to the 'new'.   You need to use this ctor if the annotation is 
     * being copied from one file to another.
     */
	public SimpleElementValueGen(SimpleElementValueGen value,ConstantPool cpool,boolean copyPoolEntries) {
		super(value.getElementValueType(),cpool);
		if (!copyPoolEntries) {
			// J5ASSERT: Could assert value.stringifyValue() is the same as
			// cpool.getConstant(SimpleElementValuevalue.getIndex())
			idx = value.getIndex();
		} else {
			switch (value.getElementValueType()) {
				case STRING:          idx = cpool.addUtf8(value.getValueString()); break;
				case PRIMITIVE_INT:   idx = cpool.addInteger(value.getValueInt()); break;
				case PRIMITIVE_BYTE:  idx = cpool.addInteger(value.getValueByte()); break;
				case PRIMITIVE_CHAR:  idx = cpool.addInteger(value.getValueChar()); break;
				case PRIMITIVE_LONG:  idx = cpool.addLong(value.getValueLong()); break;
				case PRIMITIVE_FLOAT: idx = cpool.addFloat(value.getValueFloat());break;
				case PRIMITIVE_DOUBLE:idx = cpool.addDouble(value.getValueDouble());break;
				case PRIMITIVE_BOOLEAN:
					if (value.getValueBoolean()) { idx = cpool.addInteger(1);
					} else {					   idx = cpool.addInteger(0);}
					break;
				case PRIMITIVE_SHORT: idx = cpool.addInteger(value.getValueShort());break;
				default:
				  throw new RuntimeException("SimpleElementValueGen class does not know how "+
					  	                     "to copy this type "+type);
			}
		}
	}
	
	/**
     * Return immutable variant
     */
	public ElementValueGen getElementValue() {
		return new SimpleElementValueGen(type,idx,cpGen);
	}

	public int getIndex() {
    	return idx;
    }

    public String getValueString() {
    	if (type != STRING) 
    		throw new RuntimeException("Dont call getValueString() on a non STRING ElementValue");
		ConstantUtf8 c = (ConstantUtf8)cpGen.getConstant(idx);
		return c.getBytes();
    }
    
    public int getValueInt() {
    	if (type != PRIMITIVE_INT) 
    		throw new RuntimeException("Dont call getValueString() on a non STRING ElementValue");
		ConstantInteger c = (ConstantInteger)cpGen.getConstant(idx);
		return c.getBytes();
    }
    
    // Whatever kind of value it is, return it as a string
    public String stringifyValue() {
    	switch (type) {
    	  case PRIMITIVE_INT:
    	  	ConstantInteger c = (ConstantInteger)cpGen.getConstant(idx);
    		return Integer.toString(c.getBytes());
    	  case PRIMITIVE_LONG:
    	  	ConstantLong j = (ConstantLong)cpGen.getConstant(idx);
    		return Long.toString(j.getBytes());
    	  case PRIMITIVE_DOUBLE:
    	  	ConstantDouble d = (ConstantDouble)cpGen.getConstant(idx);
    		return Double.toString(d.getBytes());
    	  case PRIMITIVE_FLOAT:
    	  	ConstantFloat f = (ConstantFloat)cpGen.getConstant(idx);
    		return Float.toString(f.getBytes());
    	  case PRIMITIVE_SHORT:
    		ConstantInteger s = (ConstantInteger)cpGen.getConstant(idx);
    		return Integer.toString(s.getBytes());
    	  case PRIMITIVE_BYTE:
    		ConstantInteger b = (ConstantInteger)cpGen.getConstant(idx);
    		return Integer.toString(b.getBytes());
    	  case PRIMITIVE_CHAR:
    		ConstantInteger ch = (ConstantInteger)cpGen.getConstant(idx);
    		return new Character((char)ch.getBytes()).toString();
    	  case PRIMITIVE_BOOLEAN:
    		ConstantInteger bo = (ConstantInteger)cpGen.getConstant(idx);
    		if (bo.getBytes() == 0) return "false";
    		else return "true";
    	  case STRING:
    		ConstantUtf8 cu8 = (ConstantUtf8)cpGen.getConstant(idx);
    		return cu8.getBytes();
    		
 		  default:
   			throw new RuntimeException("SimpleElementValueGen class does not know how to stringify type "+type);
    	}
    }
    
    public void dump(DataOutputStream dos) throws IOException {
    	dos.writeByte(type); // u1 kind of value
    	switch (type) {
    		case PRIMITIVE_INT: 
    		case PRIMITIVE_BYTE:
    		case PRIMITIVE_CHAR:
    		case PRIMITIVE_FLOAT:
    		case PRIMITIVE_LONG:
    		case PRIMITIVE_BOOLEAN:
    		case PRIMITIVE_SHORT:
    		case PRIMITIVE_DOUBLE:
    		case STRING:
    			dos.writeShort(idx);
    			break;
   			default:
   				throw new RuntimeException("SimpleElementValueGen doesnt know how to write out type "+type);
    	}
    }
 
}
