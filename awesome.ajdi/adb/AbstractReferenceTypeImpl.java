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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.VMMismatchException;
import com.sun.jdi.VirtualMachine;

import adb.backend.FilterManager;
import adb.tools.Converter;
import adb.tools.InterList;
import ajdi.ClassLoaderReference;
import ajdi.ClassObjectReference;
import ajdi.Field;
import ajdi.Location;
import ajdi.Method;
import ajdi.ObjectReference;
import ajdi.ReferenceType;
import ajdi.Shadow;
import ajdi.Value;

//TODO field locations bij allLineLocations en LocationForLine 
public abstract class AbstractReferenceTypeImpl<T extends com.sun.jdi.ReferenceType>
		implements ReferenceTypeImpl {

	private T base;
	protected ShadowMaster master;

	public AbstractReferenceTypeImpl(T base, ShadowMaster master) {
		super();
		this.base = base;
		this.master = master;
	}

	public List<Field> allFields() {
		FilterManager fm = shadowMaster().getFilterManager();
		
		return new InterList<com.sun.jdi.Field, Field>(fm.filterFields(unwrap().allFields()),
				getFieldConverter());
	}

	public List<Location> allLineLocations() throws AbsentInformationException {
		return new InterList<com.sun.jdi.Location, Location>(unwrap()
				.allLineLocations(), master.getLocationConverter());
	}

	public abstract List<Method> allMethods();

	public Field fieldByName(String fieldName) {
		return wrap(unwrap().fieldByName(fieldName));
	}

	public List<Field> fields() {
		FilterManager fm = shadowMaster().getFilterManager();
		
		return new InterList<com.sun.jdi.Field, Field>(fm.filterFields(unwrap().fields()),
				getFieldConverter());
	}

	public Value getValue(Field field) {
		return master.wrap(unwrap().getValue(unwrap(field)));
	}

	public Map<Field, Value> getValues(List<Field> fields) {
		Map<Field, Value> map = new TreeMap<Field, Value>();
		for (Field field : fields) {
			map.put(field, getValue(field));
		}
		return map;
	}

	public List<Location> locationsOfLine(int lineNumber)
			throws AbsentInformationException {
		return new InterList<com.sun.jdi.Location, Location>(unwrap()
				.locationsOfLine(lineNumber), master.getLocationConverter());
	}

	public List<Method> methods() {
		FilterManager fm = shadowMaster().getFilterManager();
		
		return new InterList<com.sun.jdi.Method, Method>(fm.filterMethods(unwrap().methods()),getMethodConverter());
	}

	public List<Method> methodsByName(String name) {
		FilterManager fm = shadowMaster().getFilterManager();
		
		return new InterList<com.sun.jdi.Method, Method>(fm.filterMethods(unwrap().methodsByName(name)),getMethodConverter());
	}

	public List<Method> methodsByName(String name, String signature) {
		FilterManager fm = shadowMaster().getFilterManager();
		
		return new InterList<com.sun.jdi.Method, Method>(fm.filterMethods(unwrap().methodsByName(name, signature)),getMethodConverter());
	}

	public List<ReferenceType> nestedTypes() {
		return new InterList<com.sun.jdi.ReferenceType, ReferenceType>(unwrap().nestedTypes(),master.getReferenceTypeConverter());
	}

	public List<Field> visibleFields() {
		FilterManager fm = shadowMaster().getFilterManager();
		return new InterList<com.sun.jdi.Field, Field>(fm.filterFields(unwrap().visibleFields()),getFieldConverter());
	}

	public List<Method> visibleMethods() {
		FilterManager fm = shadowMaster().getFilterManager();
		
		return new InterList<com.sun.jdi.Method, Method>(fm.filterMethods(unwrap().visibleMethods()),getMethodConverter());
	}

	public ClassLoaderReference classLoader() {
		return (ClassLoaderReference) shadowMaster().wrap(unwrap().classLoader());
	}

	private ajdi.ClassObjectReference classo;
	
	public ajdi.ClassObjectReference classObject() {
		if(classo == null)
			classo = master.wrap(unwrap().classObject());
		return classo; 
	}

	public boolean failedToInitialize() {
		return unwrap().failedToInitialize();
	}

	public String genericSignature() {
		return unwrap().genericSignature();
	}

	public boolean isAbstract() {
		return unwrap().isAbstract();
	}

	public boolean isFinal() {
		return unwrap().isFinal();
	}

	public boolean isInitialized() {
		return unwrap().isInitialized();
	}

	public boolean isPrepared() {
		return unwrap().isPrepared();
	}

	public boolean isStatic() {
		return unwrap().isStatic();
	}

	public boolean isVerified() {
		return unwrap().isVerified();
	}

	public String sourceName() throws AbsentInformationException {
		return unwrap().sourceName();
	}

	public String name() {
		return unwrap().name();
	}

	public String signature() {
		return unwrap().signature();
	}

	public VirtualMachine virtualMachine() {
		return unwrap().virtualMachine();
	}

	public boolean isPackagePrivate() {
		return unwrap().isPackagePrivate();
	}

	public boolean isPrivate() {
		return unwrap().isPrivate();
	}

	public boolean isProtected() {
		return unwrap().isProtected();
	}

	public boolean isPublic() {
		return unwrap().isPublic();
	}

	public int modifiers() {
		return unwrap().modifiers();
	}
	
	//Iterne keuken
	// cache alles, zo dicht mogelijk bij de consumer
	

	com.sun.jdi.Method unwrap(Method method) {
		checkMaster(method);
		return ((MethodImpl)method).getBase();
	}
	

	private final Map<com.sun.jdi.Method, MethodImpl> methodsExt = new HashMap<com.sun.jdi.Method, MethodImpl>();
	//private final Map<Method, com.sun.jdi.Method> methodsInt = new HashMap<Method, com.sun.jdi.Method>();
		
	public MethodImpl wrap(com.sun.jdi.Method method) {
		if(!method.declaringType().equals(unwrap()))
			return master.wrap(method.declaringType()).wrap(method);
		MethodImpl meth = methodsExt.get(method);
		if(meth == null){
			meth = master.createMethod(this,method);
			if(meth != null)
				methodsExt.put(method, meth);
		}
		return meth;
	}
	
	private final Converter<com.sun.jdi.Method, Method> methodConverter = new Converter<com.sun.jdi.Method, Method>(){

		public Method convert(com.sun.jdi.Method source) {
			return wrap(source);
		}};  

	private Converter<com.sun.jdi.Method, Method> getMethodConverter() {
		return methodConverter;
	}
	
	
	private final Map<com.sun.jdi.Field,Field> fieldsExt = new HashMap<com.sun.jdi.Field, Field>();
//	private final Map<Field,com.sun.jdi.Field> fieldsInt = new HashMap<Field, com.sun.jdi.Field>();
	
	//moet public door inheritance, eigenlijk protected
	public Field wrap(com.sun.jdi.Field field) {
		if(!field.declaringType().equals(unwrap()))
			return master.wrap(field.declaringType()).wrap(field);
		Field f = fieldsExt.get(field);
		if(f == null){
			f = master.createField(this,field);
			if(field != null)
				fieldsExt.put(field, f);
//			fieldsInt.put(f, field);
		}
		return f;
	}
	
	protected com.sun.jdi.Field unwrap(Field field) {
		return ((FieldImpl)field).base;
	}

	private final Converter<com.sun.jdi.Field, Field> fieldConverter = new Converter<com.sun.jdi.Field, Field>(){

		public Field convert(com.sun.jdi.Field source) {
			return wrap(source);
		}};

	private Converter<com.sun.jdi.Field, Field> getFieldConverter() {
		return fieldConverter;
	}
	
	private void checkMaster(Shadow other) {
		if(other.shadowMaster() != master)
			throw new VMMismatchException("object came form different master");
	}
	
	public ShadowMaster shadowMaster(){
		return master;
	}

	T unwrap() {
		return base;
	}
	
	public String toString(){
		return name();
	}
}
