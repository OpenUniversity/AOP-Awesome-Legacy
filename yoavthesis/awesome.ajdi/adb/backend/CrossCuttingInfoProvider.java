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

public interface CrossCuttingInfoProvider extends InfoProvider 
{
	public List<JoinPointComputation> getExposedJoinPointComputations(String classname,
			String methodname, String methodsig);
	
	/**
	 * @param classname class containing the method 
	 * @param methodname method name
	 * @param methodsig method signature
	 * @return the list of joinpoint descriptors
	 */
	public List<JoinPointDescriptor> getJoinpointsForMethod(String classname,String methodname,String methodsig);
	
	/**
	 * @param classname
	 * @param methodname
	 * @param methodsig
	 * @return method originaly containing the code this method contains
	 */
	public MethodIdentifier isTargetMethod(String classname,String methodname,String methodsig);
	
//	/**
//	 * @param classname
//	 * @return list of joinpoints for all methods in this class
//	 */
//	public List<JoinPointDescriptor> getJoinpointsForClass(String classname);

	/**
	 * @param aspectname name of the aspect 
	 * @param containerClass name of the class containing the implementation
	 * @param methodname name of the method containing the advice
	 * @param methodsig signature of that method
	 * @return
	 * @throws NotAnAspectException 
	 */
	public List<AdviceApplicationDescriptor> getApplicationsFor(String aspectname,String methodname,String methodsig) throws NotAnAspectException,NoSuchAdviceException;

	public List<AdviceApplicationDescriptor> getApplicationsFor(String binding) throws NoSuchBindingException;

}
