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

import java.util.Collections;
import java.util.List;

import adb.NotAnAspectException;
import adb.backend.AdviceApplicationDescriptor;
import adb.backend.AfterBindingEventListener;
import adb.backend.CrossCuttingInfoProvider;
import adb.backend.JoinPointDescriptor;
import adb.backend.MethodIdentifier;

public class NullCrosscuttingProvider implements CrossCuttingInfoProvider {

	public void addBindingListener(AfterBindingEventListener list) {
	}

	public List<AdviceApplicationDescriptor> getApplicationsFor(
			String aspectname, String methodname, String methodsig) throws NotAnAspectException {
		throw new NotAnAspectException(aspectname);
	}

	public List<JoinPointDescriptor> getJoinpointsForClass(String classname) {
		return Collections.emptyList();
	}

	public List<JoinPointDescriptor> getJoinpointsForMethod(String classname,
			String methodname, String methodsig) {
		return Collections.emptyList();
	}


	@Override
	public List<AdviceApplicationDescriptor> getApplicationsFor(String binding) {
		return Collections.emptyList();
	}

	@Override
	public MethodIdentifier isTargetMethod(String classname, String methodname, String methodsig) {
		return null;
	}

}
