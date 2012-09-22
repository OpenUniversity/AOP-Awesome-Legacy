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

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import adb.backend.AdviceDescriptor;
import adb.backend.MethodIdentifier;
import adb.backend.NoSuchAdviceException;
import ajdi.Advice;
import ajdi.Aspect;

import com.sun.jdi.InconsistentDebugInfoException;
import com.sun.jdi.Method;

public class AdviceContainerDelegate {

	public AdviceContainerDelegate(Aspect owner) {
		super();
		this.owner = owner;
	}

	// LAZY unmodifyable
	private List<Advice> advices;

	private Aspect owner;

	public List<Advice> advices() {
		if (advices == null) {
			advices = getShadowMaster().createAdvicesFor(owner);
		}
		return advices;
	}

	public List<Advice> advicesBySignature(String sig) {
		LinkedList<Advice> out = new LinkedList<Advice>();
		for (Advice advice : owner.allAdvices()) {
			if (sig.equals(advice.signature())) {
				out.add(advice);
			}
		}
		return Collections.unmodifiableList(out);

	}

	public Advice concreteAdviceBySignature(String sig) {
		for (Advice advice : advices()) {
			if (sig.equals(advice.signature())) {
				return advice;
			}
		}
		return null;
	}

	public AdviceImpl getAdvice(String methodname, String methodsig) throws NoSuchAdviceException {
		for (Advice padvice : owner.allAdvices()) {
			AdviceImpl advice = (AdviceImpl) padvice;
			com.sun.jdi.Method base = advice.getBase();
			if (methodname.equals(base.name()) && base.signature().equals(methodsig)) {
				return advice;
			}
		}
		throw new NoSuchAdviceException(aspect(),new MethodIdentifier(owner.shadowMaster().unwrap(owner).name(),methodname,methodsig));
	}

	public List<Advice> getAdvice(String methodname) {
		List<Advice> out = new LinkedList<Advice>();
		for (Advice padvice : owner.allAdvices()) {
			AdviceImpl advice = (AdviceImpl) padvice;
			com.sun.jdi.Method base = advice.getBase();
			if (methodname.equals(base.name())) {
				out.add(advice);
			}
		}
		if (out.size() > 0)
			return out;
		throw new InconsistentDebugInfoException("In: " + aspect() + " :Advice " + methodname + "not found;");
	}

	private String aspect() {
		return owner.name();
	}

	private ShadowMaster getShadowMaster() {
		return owner.shadowMaster();
	}

	public AdviceImpl wrap(Method method) {
		for (Advice padvice : owner.allAdvices()) {
			AdviceImpl advice = (AdviceImpl) padvice;
			com.sun.jdi.Method base = advice.getBase();
			if (method.equals(base)) {
				return advice;
			}
		}
		return null;
	}

	public void flush() {
		advices = null;
	}

	public void remove(AdviceDescriptor add) {
		if(advices == null)
			return;
		for (Iterator<Advice> adviceit = advices.iterator();adviceit.hasNext();) {
			AdviceImpl advice = (AdviceImpl) adviceit.next();
			if(advice.is(add.getContainer())){
				adviceit.remove();
			}	
		}
		throw new InconsistentDebugInfoException("In: " + aspect() + " :Advice " + add.getContainer().getMethodname() + "(" + add.getContainer().getMethodsig() + ")"
				+ "not found;");

	}

	public void add(AdviceDescriptor add) {
		if(advices == null)
			return;
		advices.add(owner.shadowMaster().createAdvice(owner, add));
	}

}
