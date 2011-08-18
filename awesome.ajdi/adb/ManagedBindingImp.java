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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import adb.backend.AdviceDescriptor;
import adb.backend.MethodIdentifier;
import adb.backend.NoSuchAdviceException;
import ajdi.Advice;
import ajdi.Aspect;
import ajdi.Pointcut;

import com.sun.jdi.ClassNotPreparedException;
import com.sun.jdi.InconsistentDebugInfoException;
import com.sun.jdi.VirtualMachine;

public class ManagedBindingImp extends BindingImpl {
	
	//FIXME: to dynamic system?

	private List<MethodIdentifier> advices;

	public ManagedBindingImp(VirtualMachine vm, ShadowMaster master,
			Pointcut pointcut, String name, LineRange lineRange,
			List<MethodIdentifier> ads) {
		super(vm, master, pointcut, name, lineRange);
		this.advices = ads;
		advice = new LinkedList<Advice>();
		initDesc();
		//bindings are loaded eagerly, causes infinite loop
		//findAdvices();
	}

	private void findAdvices() {
		for (int i = 0; i < advices.size(); i++) {
			MethodIdentifier desc = advices.get(i);
			try {
				
				Advice advice = shadowMaster().getAdviceForID(desc);
				this.advice.add(advice);				
				advices.remove(i);
				i--;
			} catch (ClassNotPreparedException e) {
				// OK, keep lazy
			} catch (NoSuchAdviceException e) {
				throw new InconsistentDebugInfoException(
						"got 'NoSuchAdviceException' when searching for advice: "
								+ desc.toString());
			}

		}
	}

	private void initDesc() {
		adviceDesc = new ArrayList<String>(advices.size());
		for (MethodIdentifier desc : advices) {
			adviceDesc.add(desc.getClazz() + "." + desc.getMethodname() + ":"
					+ (/*(desc.methodsig == null) ? "*" : */desc.getMethodsig()));
		}
	}

	public void setAdvice(Advice advice) {
		if (this.advice.contains(advice))
			return;
		this.advice.add(advice);
		for (int i = 0; i < advices.size(); i++) {
			MethodIdentifier desc = advices.get(i);
			if (desc.getClazz().equals(shadowMaster().unwrap(advice.declaringType()).name())
					&& advice.name().equals(desc.getMethodname())) {
				if (desc.getMethodsig() == null) {
					// wildcard, can not be discarded here
					return;
				}
				if (((AdviceImpl) advice).getBaseSig().equals(desc.getMethodsig())) {
					advices.remove(i);
					return;
				}

			}
		}
		throw new InternalDebuggerException(
				"advice added to binding, but should not have been added");
	}

	public List<Advice> advices() {
		findAdvices();
		return super.advices();
	}
}
