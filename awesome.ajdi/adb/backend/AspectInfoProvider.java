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

import java.util.List;

import adb.NotAnAspectException;

public interface AspectInfoProvider extends InfoProvider{
	
	/**
	 * @param aspectName name of the aspect for which we search. 
	 * @return per code for the classname aspect as described in ajdi.Aspect 
	 * @throws NotAnAspectException the given aspect does not exist
	 */
	public int getPerFor(String aspectName) throws NotAnAspectException;
	
	/**
	 * @param aspectName name of the aspect. 
	 * @return true if there is an aspect with this name
	 */
	public boolean isAspect(String aspectName);
	
	
	/**
	 * @param className name of the class containing an aspect
	 * @return true if there is an aspect in this class
	 */
	public boolean isAspectContainer(String className);
	
	//public boolean isClassBasedAspect(String aspectName) throws NotAnAspectException;;
	
	public String getAspectNameFor(String ClassName) throws NotAnAspectContainerException;;
	public String getClassNameFor(String AspectName) throws NotAnAspectException;;
 
//	/**
//	 * aspects containing advices are not singaled by this call
//	 *  
//	 * @param className name of the class
//	 * @return whether the given class is an advice container 
//	 */
//	//TODO perhaps value + events
//	public boolean isAdviceContainer(String className);
	
//	/**
//	 * @param containerName container class
//	 * @return the list of all contained advises
//	 * @throws NotAnAdviceContainerException if the class is not actually an advice container
//	 */
//	public List<AdviceDescriptor> getAdvicesIn(String containerName) throws NotAnAdviceContainerException;
	
//	/**
//	 * @return an unmodifiable list containing all currently existing aspects, the list may or may not be updated
//	 */
//	public List<String> getAllAspects();
	
	/**
	 * @return descriptors for all advices
	 * @throws NotAnAspectException the given aspect does not exist
	 */
	public List<AdviceDescriptor> getAdvicesFor(String aspectName) throws NotAnAspectException;
	
	/**
	 * @return the location where this aspect is declared or null if it was formed by aspect reflection
	 * @throws NotAnAspectException 
	 * @throws NotAnAspectException the given aspect does not exist
	 */
	public SourceLocationDescriptor getSourceLocationFor(String aspectName) throws NotAnAspectException;
	
	
	/**
	 * @param aspectName
	 * @return whether this aspect can 'change' 
	 * @throws NotAnAspectException 
	 */
	public boolean isDynamic(String aspectName) throws NotAnAspectException;
	
	public String getMechNameForAspect(String aspectName) throws NotAnAspectException;


}
