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

import org.aspectj.apache.bcel.classfile.ConstantUtf8;
import org.aspectj.apache.bcel.classfile.ConstantPool;
import org.aspectj.apache.bcel.generic.ObjectType;


public class ClassElementValueGen extends ElementValueGen {	
	
	// For primitive types and string type, this points to the value entry in the cpool
	// For 'class' this points to the class entry in the cpool
	private int idx;
	
    protected ClassElementValueGen(int typeIdx,ConstantPool cpool) {
    	super(ElementValueGen.CLASS,cpool);
    	this.idx = typeIdx;
    }
    
    public ClassElementValueGen(ObjectType t,ConstantPool cpool) {
    	super(ElementValueGen.CLASS,cpool);
    	//this.idx = cpool.addClass(t);
    	idx = cpool.addUtf8(t.getSignature());
    }
	
	/**
	 * Return immutable variant of this ClassElementValueGen
	 */
//	public ElementValueGen getElementValue() {
//		return new ClassElementValueGen(type,idx,cpGen);
//	}
    
	public ClassElementValueGen(ClassElementValueGen value, ConstantPool cpool,boolean copyPoolEntries) {
		super(CLASS,cpool);
		if (copyPoolEntries) {
			//idx = cpool.addClass(value.getClassString());
			idx = cpool.addUtf8(value.getClassString());
		} else { 	
			idx = value.getIndex();
			
		}
	}

	public int getIndex() {
    	return idx;
    }
     
    public String getClassString() {
    	ConstantUtf8 cu8 = (ConstantUtf8)getConstantPool().getConstant(idx);
    	return cu8.getBytes();
//		ConstantClass c = (ConstantClass)getConstantPool().getConstant(idx);
//		ConstantUtf8 utf8 = (ConstantUtf8)getConstantPool().getConstant(c.getNameIndex());
//		return utf8.getBytes();
    }
    
    public String stringifyValue() {
    	return getClassString();
    }
    
    public void dump(DataOutputStream dos) throws IOException {
    	dos.writeByte(type); // u1 kind of value
    	dos.writeShort(idx);
    }
 
}
