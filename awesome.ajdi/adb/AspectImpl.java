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

import adb.backend.AdviceDescriptor;
import adb.backend.NoSuchAdviceException;
import ajdi.Advice;
import ajdi.Aspect;
import ajdi.AspectInstance;

public interface AspectImpl extends Aspect,ClassTypeImpl {
	//noodzakelijk omdat advices geen naam hebben
	//gevaar met containers
	public Advice getAdvice(String methodname,String methodsig) throws NoSuchAdviceException;
	
	/**
	 * @return list of advices implemented by the methods with name: methodName
	 */
	public java.util.List<Advice> getAdvice(String methodname);
	
	public AspectInstance wrap(com.sun.jdi.ObjectReference ref);

	public void flushAllAdvices();

	public void remove(AdviceDescriptor add);

	public void add(AdviceDescriptor add);
	
	public void setMechanismName(String mechName);

}
