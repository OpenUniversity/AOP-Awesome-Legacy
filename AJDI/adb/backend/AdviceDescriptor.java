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
package adb.backend;

import ajdi.Binding;

/**
 * @author wouter
 *
 */
public class AdviceDescriptor {
	public static final int TYPE_AFTER = 1;
	public static final int TYPE_AROUND = 2;
	public static final int TYPE_BEFORE = 4;
	public static final int TYPE_AFTER_RETURN = 8;
	public static final int TYPE_AFTER_THROWING = 16;

	protected final int type;
	
	protected final MethodIdentifier container;
	
	/**
	 * aspect fully qualified name 
	 */
	protected String aspect;
	
	protected final BindingDescriptor[] bindings;
	
	protected final SourceLocationDescriptor location;
	
	
	/**
	 * indices and names of non synthetic arguments
	 * 
	 *  names: null for original name
	 */
	protected int[] argIndices;
	protected String[] argNames;
	
	protected String effectType;

	
	
	
	public AdviceDescriptor(int type, String file,int startln, int endln, String aspect,String container, 
			String methodname, String methodsig, String effectType, int[] argIndices,String[] argNames,BindingDescriptor[] bindings) {
		super();
		this.type = type;
		this.location = new SourceLocationDescriptor(file,startln,endln);
		this.aspect = aspect;
		this.container = new MethodIdentifier(container,methodname,methodsig);
		this.bindings = bindings;
		this.argIndices = argIndices;
		this.argNames = argNames;
		this.effectType = effectType;
	}


	/**
	 * 
	 * DANGER: INCOMPLETE STATE: NEEDS: ASPECT, CONTAINER
	 */
	public AdviceDescriptor(int type,String file, int startln, int endln, String methodname, String methodsig, 
			String effectType, int[] argIndices,String[] argNames,BindingDescriptor[] bindings) {
		super();
		this.location = new SourceLocationDescriptor(file,startln,endln);
		this.type = type;
		this.container = new MethodIdentifier(methodname,methodsig);
		this.bindings = bindings;
		this.argIndices = argIndices;
		this.argNames = argNames;
		this.effectType = effectType;
	}

	public void complete(String aspect,String container){
		this.container.complete(container);
		this.aspect = aspect;
	}

	/**
	 * DANGER: Binding location is a just the first line of the advice
	 * DANGER: INCOMPLETE STATE: NEEDS: ASPECT, CONTAINER
	 */
	public AdviceDescriptor(int type, String file, int startline, int endLine,
			String methodName, String methodSig, int[] indices,
			String[] argNames, String pointCut, String effectType) {
		this.location = new SourceLocationDescriptor(file,startline,endLine);
		this.type = type;
		this.container = new MethodIdentifier(methodName,methodSig);
		this.bindings = new BindingDescriptor[]{new BindingDescriptor(Binding.DEFAULT_NAME,file,startline,startline,pointCut,container)};
		this.argIndices = indices;
		this.argNames = argNames;
		this.effectType = effectType;
	}
	
	public String getEffectType()
	{
		return effectType;
	}
	
	public int getType() {
		return type;
	}


	public MethodIdentifier getContainer() {
		return container;
	}


	public String getAspect() {
		return aspect;
	}


	public BindingDescriptor[] getBindings() {
		return bindings;
	}


	public SourceLocationDescriptor getLocation() {
		return location;
	}


	public int[] getArgIndices() {
		return argIndices;
	}


	public String[] getArgNames() {
		return argNames;
	}
	
	
}
