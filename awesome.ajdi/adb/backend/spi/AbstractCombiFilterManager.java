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
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.sun.jdi.Location;
import com.sun.jdi.Method;

import adb.AdviceApplicationImpl;
import adb.HookFrameImpl;
import adb.InternalDebuggerException;
import adb.NotAnAspectException;
import adb.ShadowMaster;
import adb.StackFrameImpl;
import adb.backend.AdviceDescriptor;
import adb.backend.AspectInfoProvider;
import adb.backend.FilterManager;
import adb.backend.MethodIdentifier;
import adb.backend.StackFilterManager;
import ajdi.AdviceApplication;
import ajdi.StackFrame;

public abstract class AbstractCombiFilterManager extends AbstractFilterManager implements
		FilterManager, StackFilterManager {

	private AspectInfoProvider aip;


	public List<StackFrame> filterFrames(List<com.sun.jdi.StackFrame> frames) {
		List<StackFrame> out = new LinkedList<StackFrame>();

		HookFrameImpl lastHook = null;

		// possible actions:
		// non advice, non aspect functionality: wrap
		// advice: add hook
		// aspect func; acessor: drop
		ListIterator<com.sun.jdi.StackFrame> it = frames.listIterator(frames.size());
		
		doSkips(it);
		
		main: for (; it.hasPrevious();) {
			com.sun.jdi.StackFrame frame = it.previous();
			com.sun.jdi.Method method = frame.location().method();
			if (filterMethod(method)==null)
				continue;
			AdviceDescriptor ad = getAdvice(method);
			if (ad != null) {
				if (lastHook != null) {
					List<AdviceApplication> advices = lastHook.thisJoinPoint()
							.advices();
					for (AdviceApplication adviceApplication : advices) {
						AdviceApplicationImpl aapl = (AdviceApplicationImpl) adviceApplication;
						if (aapl.getAdviceMethodName().equals(method.name())
								&& aapl.getAdviceMethodSig().equals(
										method.signature())) {
							out.add(wrap(frame));
							continue main;
						}
					}
				}
			}
			
			lastHook = makeHook(it);
			it.next();
			out.add(wrap(it.previous()));
			if(lastHook != null)
				out.add(lastHook);
			
			
		}

		Collections.reverse(out);
		return out;
	}
	
	
	protected abstract void doSkips(ListIterator<com.sun.jdi.StackFrame> it);

	protected AdviceDescriptor getAdvice(Method method) {
		if (aip.isAspect(method.declaringType().name())) {
			try {
				List<AdviceDescriptor> descr = aip.getAdvicesFor(method
						.declaringType().name());
				for (AdviceDescriptor adviceDescriptor : descr) {
					MethodIdentifier meth = adviceDescriptor.getContainer();
					if (meth.getMethodname().equals(method.name())
							&& meth.getMethodsig().equals(method
									.signature()))
						return adviceDescriptor;
				}
			} catch (NotAnAspectException e) {
				throw new InternalDebuggerException(
						"is an aspect, but is not an aspect: "
								+ method.declaringType().name());
			}

		}
		return null;
	}

	protected abstract HookFrameImpl makeHook(ListIterator<com.sun.jdi.StackFrame> it);

	private StackFrame wrap(com.sun.jdi.StackFrame frame) {
		return new StackFrameImpl(frame, master);
	}
}
