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
package adb.backend.bcel.spi;

import java.util.List;

import adb.NotAnAspectException;
import adb.backend.AdviceDescriptor;
import adb.backend.BeforeAspectEventListener;
import adb.backend.LocationDescriptor;
import adb.backend.NotAnAdviceContainerException;
import adb.backend.NotAnAspectContainerException;
import adb.backend.SourceLocationDescriptor;
import adb.backend.bcel.AspectAttribute;
import adb.backend.bcel.BCELBackend;
import adb.backend.bcel.SourceLineContainingAttributeReader.LineInformation;

public class AspectInfoProvider implements adb.backend.AspectInfoProvider {

	private BCELBackend back;

	public AspectInfoProvider(BCELBackend back) {
		this.back = back;
	}

	public List<AdviceDescriptor> getAdvicesFor(String classname)
			throws NotAnAspectException {
		try {
			List<AdviceDescriptor> out = getAttribute(classname).getAdvices();
			for (AdviceDescriptor descriptor : out) {
				descriptor.complete(classname, classname);
			}
			return out;
		} catch (NullPointerException e) {
			throw new NotAnAspectException(classname);
		}

	}

	public int getPerFor(String classname) throws NotAnAspectException {
		try {
			return getAttribute(classname).getPer();
		} catch (NullPointerException e) {
			throw new NotAnAspectException(classname);
		}
	}

	public boolean isAspect(String aspectName) {

		return getAttribute(aspectName) != null;

	}

	private AspectAttribute getAttribute(String classname) {
		
		return (AspectAttribute) back.getClassAttribute(classname,
				AspectAttribute.name);
	}
	
	public String getMechNameForAspect(String aspectName) throws NotAnAspectException
	{
		String mechName;
		AspectAttribute attr = getAttribute(aspectName);
		
		if(null == attr)
			throw new NotAnAspectException(aspectName);
		
		mechName = attr.getMechName();
		
		return mechName;
	}

	public List<AdviceDescriptor> getAdvicesIn(String containerName)
			throws NotAnAdviceContainerException {
		throw new NotAnAdviceContainerException(containerName);
	}

	public SourceLocationDescriptor getSourceLocationFor(String aspectName) throws NotAnAspectException {
		try {
			LineInformation sinf = getAttribute(aspectName).getSlnr();
			LineInformation einf = getAttribute(aspectName).getElnr();
			return new SourceLocationDescriptor(sinf.path, sinf.lnr,einf.lnr);
		} catch (NullPointerException e) {
			throw new NotAnAspectException(aspectName);
		}
	}

	// public List<String> getAllAspects() {
	// // TODO Auto-generated method stub
	// return null;
	// }

	public boolean isAdviceContainer(String className) {
		return false;
	}

	public boolean isDynamic(String aspectName) {
		return false;
	}

	public void addEventListener(BeforeAspectEventListener list) {
	}

	public void removeEventListener(BeforeAspectEventListener list) {
	}

	public String getAspectNameFor(String className) throws NotAnAspectContainerException {
		if(!isAspect(className))
			throw new NotAnAspectContainerException(className);
		return className;
	}

	public String getClassNameFor(String aspectName) throws NotAnAspectException {
		if(!isAspect(aspectName))
			throw new NotAnAspectException(aspectName);
		return aspectName;
	}

	public boolean isAspectContainer(String className) {
		return isAspect(className);
	}

	public boolean isClassBasedAspect(String aspectName) throws NotAnAspectException {
		if(!isAspect(aspectName))
			throw new NotAnAspectException(aspectName);
		return true;
	}

}
