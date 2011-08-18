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
package adb.backend.spi;

import java.util.List;

import adb.NotAnAspectException;
import adb.backend.AdviceDescriptor;
import adb.backend.BeforeAspectEventListener;
import adb.backend.AspectInfoProvider;
import adb.backend.LocationDescriptor;
import adb.backend.NotAnAdviceContainerException;
import adb.backend.NotAnAspectContainerException;

public class NullAspectInfoProvider implements AspectInfoProvider {

	public void addEventListener(BeforeAspectEventListener list) {
	}

	public List<AdviceDescriptor> getAdvicesFor(String aspectName)
			throws NotAnAspectException {
		throw new NotAnAspectException(aspectName);
	}

	public List<AdviceDescriptor> getAdvicesIn(String containerName)
			throws NotAnAdviceContainerException {
		throw new NotAnAdviceContainerException(containerName);
	}

	public String getAspectNameFor(String ClassName) throws NotAnAspectContainerException {
		throw new NotAnAspectContainerException(ClassName);
	}

	public String getClassNameFor(String aspectName) throws NotAnAspectException {
		throw new NotAnAspectException(aspectName);
	}

	public int getPerFor(String aspectName) throws NotAnAspectException {
		throw new NotAnAspectException(aspectName);
	}

	public LocationDescriptor getSourceLocationFor(String aspectName) throws NotAnAspectException {
		throw new NotAnAspectException(aspectName);
	}

	public boolean isAdviceContainer(String className) {
		return false;
	}

	public boolean isAspect(String aspectName) {
		return false;
	}

	public boolean isAspectContainer(String className) {
		return false;
	}

	public boolean isClassBasedAspect(String aspectName) throws NotAnAspectException {
		throw new NotAnAspectException(aspectName);
	}

	public boolean isDynamic(String aspectName) throws NotAnAspectException {
		throw new NotAnAspectException(aspectName);
	}

	public void removeEventListener(BeforeAspectEventListener list) {
	}

	@Override
	public String getMechNameForAspect(String aspectName) throws NotAnAspectException {
		throw new NotAnAspectException(aspectName);
	}

}
