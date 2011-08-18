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

import java.util.Collections;
import java.util.List;

public class BindingDescriptor {

	private final SourceLocationDescriptor location;
	
	private final String pointcut;
	private final String name;
	
	private List<MethodIdentifier> advices;

	private boolean managed;

	/**
	 * unmanaged
	 * 
	 * @param name
	 * @param file
	 * @param startln
	 * @param endln
	 * @param pointcut
	 * @param advice
	 */
	public BindingDescriptor(String name,String file, int startln, int endln,
			String pointcut,MethodIdentifier advice) {
		super();
		this.name = name;
		this.location = new SourceLocationDescriptor(file,startln,endln);
		this.pointcut = pointcut;
		this.advices = Collections.singletonList(advice);
		managed = false;
	}
	
	/**
	 * managed
	 * 
	 * @param name
	 * @param file
	 * @param startln
	 * @param endln
	 * @param pointcut
	 * @param advices
	 */
	public BindingDescriptor(String name,String file, int startln, int endln,
			String pointcut,List<MethodIdentifier> advices){
		this.name = name;
		this.location = new SourceLocationDescriptor(file,startln,endln);
		this.pointcut = pointcut;
		this.advices = advices;
		managed = true;
	}
	
	/**
	 * a binding is managed if it has a unique name and may contain multiple advices
	 */
	public boolean isManaged(){
		return managed;
	}
	
	
	public SourceLocationDescriptor getLocation() {
		return location;
	}

	public String getPointcut() {
		return pointcut;
	}

	public String getName() {
		return name;
	}

	public List<MethodIdentifier> getAdvices() {
		return advices;
	}
	
	

}
