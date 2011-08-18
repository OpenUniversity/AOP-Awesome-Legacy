/**
 * AODA - Aspect Oriented Debugging Architecture, BCEL/AspectJ component
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
package adb.backend.bcel;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.Code;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.util.ClassPath;
import org.apache.bcel.util.SyntheticRepository;

import adb.backend.bcel.AspectAttribute.AspectAttributeReader;
import adb.backend.bcel.CrossCuttingAttribute.CrossCuttingAttributeReader;
import adb.backend.bcel.FieldLineNumberAttribute.FieldLineNumberAttributeReader;
import adb.backend.bcel.ShadowAttribute.ShadowAttributeReader;
import adb.tools.Triple;

public class BCELBackend {
	
	public static final char NAME_SIG_SEPARATOR = '%';//not used in java names, no part of a sig


	public BCELBackend(String repo){
		Repository.setRepository(SyntheticRepository.getInstance(new ClassPath(repo)));
		
		FieldLineNumberAttributeReader flr = new FieldLineNumberAttributeReader();
		org.apache.bcel.classfile.Attribute.addAttributeReader(flr.getName(), flr);
		
		AspectAttributeReader ar = new AspectAttributeReader();
		org.apache.bcel.classfile.Attribute.addAttributeReader(ar.getName(),ar);
		
		CrossCuttingAttributeReader cr = new CrossCuttingAttributeReader();
		org.apache.bcel.classfile.Attribute.addAttributeReader(cr.getName(),cr);
		
		ShadowAttributeReader sr = new ShadowAttributeReader();
		org.apache.bcel.classfile.Attribute.addAttributeReader(sr.getName(),sr);
	}
	
	private Map<String,Map<String,Attribute>> classAttributes = new HashMap<String, Map<String,Attribute>>();
	private Map<String,Map<String,Map<String,Attribute>>> methodAttributes = new HashMap<String, Map<String,Map<String,Attribute>>>();
	
	
	public Attribute getClassAttribute(String clazz,String name){
		Map<String,Attribute> atts = classAttributes.get(clazz);
		
		if(atts == null){
			load(clazz);
			atts = classAttributes.get(clazz);
		}
		
		return atts.get(name);
	}
	
	public Attribute getMethodAttribute(String clazz,String methodname,String methodsig,String attname){
		Map<String, Map<String, Attribute>> methods = getPerClassMethodMap(clazz);
		if(methods.isEmpty())
			return null;
		
		Map<String,Attribute> atts = methods.get(methodname + NAME_SIG_SEPARATOR +methodsig);
		
		if(atts == null || atts.isEmpty())
			return null;
		
		return atts.get(attname);
	}

	private Map<String, Map<String, Attribute>> getPerClassMethodMap(
			String clazz) {
		Map<String,Map<String,Attribute>> methods = methodAttributes.get(clazz);
		
		if(methods == null){
			load(clazz);
			methods = methodAttributes.get(clazz);
		}
		return methods;
	}
	
	public List<Triple<String, String, Attribute>> getAllMethodAttributesInClass(String clazz,String name){
		LinkedList<Triple<String, String, Attribute>> out = new LinkedList<Triple<String, String, Attribute>>();
		
		
		Map<String, Map<String, Attribute>> methods = getPerClassMethodMap(clazz);
		
		if(methods.isEmpty())
			return Collections.emptyList();
		
		for (Map.Entry<String,Map<String, Attribute>> tagAttMap : methods.entrySet()) {
			Attribute att = tagAttMap.getValue().get(name);
			String meth = tagAttMap.getKey();
			String[] methpartss = meth.split(""+NAME_SIG_SEPARATOR);
			if(att != null)
				out.add(new Triple<String, String, Attribute>(methpartss[0],methpartss[1],att));
		}
		
		return out;
	}


	private void load(String clazzname) {
		JavaClass clazz;
		try {
			clazz = Repository.lookupClass(clazzname);
		} catch (ClassNotFoundException e) {
			classAttributes.put(clazzname, Collections.<String,Attribute>emptyMap());
			methodAttributes.put(clazzname, Collections.<String,Map<String,Attribute>>emptyMap());
			return;
		}
		
		Map<String,Attribute> attMap = new HashMap<String, Attribute>();
		
		org.apache.bcel.classfile.Attribute[] ats = clazz.getAttributes();
		for (org.apache.bcel.classfile.Attribute attribute : ats) {
			if(attribute instanceof Attribute){
				Attribute at = (Attribute) attribute;
				attMap.put(at.getName(),at);
			}		
		}
		
		if(attMap.isEmpty())
			classAttributes.put(clazzname, Collections.<String,Attribute>emptyMap());
		else
			classAttributes.put(clazzname, attMap);
		
		Map<String,Map<String,Attribute>> methodMap = new HashMap<String, Map<String,Attribute>>();
		
		for (Method meth : clazz.getMethods()) {
			ats = meth.getAttributes();
			attMap = new HashMap<String, Attribute>();
			
			for (org.apache.bcel.classfile.Attribute attribute : ats) {
				if(attribute instanceof Attribute){
					Attribute at = (Attribute) attribute;
					attMap.put(at.getName(),at);
				} if(attribute instanceof Code){
					for (org.apache.bcel.classfile.Attribute attribute2 : ((Code)attribute).getAttributes()) {
						if(attribute2 instanceof Attribute){
							Attribute at = (Attribute) attribute2;
							attMap.put(at.getName(),at);
						} 
					}
				}
			}
			
			if(attMap.isEmpty())
				methodMap.put(meth.getName() +NAME_SIG_SEPARATOR + meth.getSignature(), Collections.<String,Attribute>emptyMap());
			else
				methodMap.put(meth.getName() +NAME_SIG_SEPARATOR + meth.getSignature(), attMap);
		}
		
		if(methodMap.isEmpty())
			methodAttributes.put(clazzname, Collections.<String,Map<String,Attribute>>emptyMap());
		else
			methodAttributes.put(clazzname, methodMap);
			
		
		
	}
	
	
	//TODO ontcruften
	public String getPathFor(String clazzname) {
		JavaClass clazz;
		try {
			clazz = Repository.lookupClass(clazzname);
			String sourceFile = clazz.getSourceFileName();
			if(sourceFile.endsWith(".VIRT"))
				sourceFile = sourceFile.substring(0,sourceFile.length()-5);
			return clazz.getPackageName().replaceAll("[.]", "/")+"/" + sourceFile;
		} catch (ClassNotFoundException e) {
			return clazzname;
		}
	}
	

}
