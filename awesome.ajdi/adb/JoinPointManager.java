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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import adb.backend.AdviceApplicationDescriptor;
import adb.backend.AdviceDescriptor;
import adb.backend.BindingDescriptor;
import adb.backend.JoinPointDescriptor;
import adb.backend.LocationDescriptor;
import adb.backend.MethodIdentifier;
import adb.backend.NoSuchAdviceException;
import adb.tools.ValueCache;
import ajdi.Advice;
import ajdi.AdviceApplication;
import ajdi.Binding;
import ajdi.ClassType;
import ajdi.JoinPoint;
import ajdi.Method;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.ClassNotPreparedException;
import com.sun.jdi.InconsistentDebugInfoException;

class JoinPointManager {

	private ShadowMaster master;
	private ValueCache<JoinPointDescriptor, JoinPointImpl> jps = new ValueCache<JoinPointDescriptor, JoinPointImpl>();

	public JoinPointImpl getJoinPoint(JoinPointDescriptor jpd) throws ClassNotPreparedException {
		JoinPointImpl out = jps.get(jpd);
		if (out == null) {
			out = createJoinPoint(jpd);
			jps.put(jpd, out);
		}
		return out;
	}

	private JoinPointImpl getLazyJoinPoint(JoinPointDescriptor jpd) throws ClassNotPreparedException {
		JoinPointImpl out = jps.get(jpd);
		return out;
	}

	public void removeAdvice(AdviceDescriptor desc) {
		for (Map.Entry<JoinPointDescriptor, JoinPointImpl> jpe : jps.entrySet()) {
			JoinPointDescriptor jpd = jpe.getKey();
			List<AdviceApplicationDescriptor> aaplds = jpd.getApplicationFor(desc.getContainer().getClazz(), desc.getContainer()
					.getMethodname(), desc.getContainer().getMethodsig());
			for (AdviceApplicationDescriptor aapld : aaplds){
				jpd.remove(aapld);
				jpe.getValue().remove(aapld);
			}
			if(!aaplds.isEmpty())
				flush(jpe.getValue());
		}
	}

	public void addAdvice(AdviceDescriptor desc, List<AdviceApplicationDescriptor> aapls) {
		for (AdviceApplicationDescriptor aapl : aapls) {
			JoinPointImpl jp = getLazyJoinPoint(aapl.getJoinpoint());
			if (jp == null)
				continue;
			AdviceApplication out = jp.get(aapl);
			if (out != null)
				continue;
			jp.add(createAdviceApplicationFor(aapl));
			flush(jp);
		}
	}

	public void removeBinding(BindingDescriptor desc) {
		for (Map.Entry<JoinPointDescriptor, JoinPointImpl> jpe : jps.entrySet()) {
			JoinPointDescriptor jpd = jpe.getKey();
			List<AdviceApplicationDescriptor> aaplds = jpd.getApplicationFor(desc.getName());
			for (AdviceApplicationDescriptor aapld : aaplds){
				jpd.remove(aapld);
				jpe.getValue().remove(aapld);
			}
			if(!aaplds.isEmpty())
				flush(jpe.getValue());
		}
	}
	
	public void addBinding(BindingDescriptor desc, List<AdviceApplicationDescriptor> aapls) {
		for (AdviceApplicationDescriptor aapl : aapls) {
			JoinPointImpl jp = getLazyJoinPoint(aapl.getJoinpoint());
			if (jp == null)
				continue;
			AdviceApplication out = jp.get(aapl);
			if (out != null)
				continue;
			jp.add(createAdviceApplicationFor(aapl));
			flush(jp);
		}
	}

	public void flush(JoinPointDescriptor joinpoint) {
		JoinPoint jp = jps.remove(joinpoint);
		flush(jp);
	}

	private void flush(JoinPoint jp) {
		((MethodImpl) jp.location().method()).flushJoinpoints();
	}

	private JoinPointImpl createJoinPoint(JoinPointDescriptor jpd) throws ClassNotPreparedException {
		switch (jpd.getType()) {
		case JoinPointDescriptor.TYPE_METHOD_EXECUTION:
			return createMEXJP(jpd);
		case JoinPointDescriptor.TYPE_STATEMENT:
			return createStmtJP(jpd);
		case JoinPointDescriptor.TYPE_SINIT:
			return createSinitJP(jpd);
		case JoinPointDescriptor.TYPE_INIT:
			return createInitJP(jpd);
		case JoinPointDescriptor.TYPE_PINIT:
			return createPInitJP(jpd);
		default:
			throw new InternalDebuggerException("Unknow type of pointcut: " + jpd.getType());

		}
	}

	private JoinPointImpl createPInitJP(JoinPointDescriptor jpd) throws ClassNotPreparedException {

		MethodIdentifier meth = jpd.getRange().getMethod();
		ClassType clazz = master.getClassForName(meth.getClazz());
		Method method = clazz.concreteMethodByName(meth.getMethodname(), meth.getMethodsig());
		RangeImpl loc = new RangeImpl(master, clazz, method, jpd.getRange());
		return new PinitJoinPoint(master.getVirtualMachine(), master, method, Collections
				.unmodifiableList(createAdviceApplicationFor(jpd.getAdvice())), loc, jpd.getTarget());
	}

	private JoinPointImpl createInitJP(JoinPointDescriptor jpd) throws ClassNotPreparedException {
		MethodIdentifier meth = jpd.getRange().getMethod();
		ClassType clazz = master.getClassForName(meth.getClazz());
		Method method = clazz.concreteMethodByName(meth.getMethodname(), meth.getMethodsig());
		RangeImpl loc = new RangeImpl(master, clazz, method, jpd.getRange());
		return new InitJoinPoint(master.getVirtualMachine(), master, method, Collections
				.unmodifiableList(createAdviceApplicationFor(jpd.getAdvice())), loc, jpd.getTarget());
	}

	private JoinPointImpl createSinitJP(JoinPointDescriptor jpd) throws ClassNotPreparedException {
		MethodIdentifier meth = jpd.getRange().getMethod();
		ClassType clazz = master.getClassForName(meth.getClazz());
		Method method = clazz.concreteMethodByName(meth.getMethodname(), meth.getMethodsig());
		RangeImpl loc = new RangeImpl(master, clazz, method, jpd.getRange());
		return new SInitJoinPointImpl(master.getVirtualMachine(), master, method, Collections
				.unmodifiableList(createAdviceApplicationFor(jpd.getAdvice())), loc, clazz, jpd.getTarget());
	}

	private StmtJoinPointImpl createStmtJP(JoinPointDescriptor jpd) throws ClassNotPreparedException {
		MethodIdentifier meth = jpd.getRange().getMethod();
		ClassType clazz = master.getClassForName(meth.getClazz());
		Method method = clazz.concreteMethodByName(meth.getMethodname(), meth.getMethodsig());
		RangeImpl loc = new RangeImpl(master, clazz, method, jpd.getRange());
		return new StmtJoinPointImpl(master.getVirtualMachine(), master, Collections
				.unmodifiableList(createAdviceApplicationFor(jpd.getAdvice())), loc, jpd.getTarget());
	}

	/*
	 * private Method getMethodOrAdvice(ClassType clazz, String inmethodName,
	 * String inmethodSig) { Method method =
	 * clazz.concreteMethodByName(inmethodName, inmethodSig); if(method != null)
	 * return method; if(!(clazz instanceof AspectImpl)) throw new
	 * InternalDebuggerException("method not found: " +clazz.name() + " " +
	 * inmethodName +" " + inmethodSig); AspectImpl asp = (AspectImpl)clazz;
	 * method = asp.getAdvice(inmethodName, inmethodSig); if(method == null)
	 * throw new InternalDebuggerException("method not found in aspect: "
	 * +clazz.name() + " " + inmethodName +" " + inmethodSig); return method; }
	 */

	private MethExecJPImpl createMEXJP(JoinPointDescriptor jpd) throws ClassNotPreparedException {
		RangeImpl range = createLocation(jpd.getRange());
		return new MethExecJPImpl(master.getVirtualMachine(), master, range.method(), Collections
				.unmodifiableList(createAdviceApplicationFor(jpd.getAdvice())), range, jpd.getTarget());
	}

	public RangeImpl createLocation(LocationDescriptor descr) {
		MethodIdentifier meth = descr.getMethod();
		ClassTypeImpl clazz = master.getClassForName(meth.getClazz());
		Method method = clazz.concreteMemberByName(meth.getMethodname(), meth.getMethodsig());
		
		return new RangeImpl(master, clazz, method, descr);
	}

	private List<AdviceApplicationImpl> createAdviceApplicationFor(List<AdviceApplicationDescriptor> in) {
		List<AdviceApplicationImpl> out = new Vector<AdviceApplicationImpl>(in.size());
		Iterator<AdviceApplicationDescriptor> init = in.iterator();
		while (init.hasNext()) {
			out.add(createAdviceApplicationFor(init.next()));
		}
		return out;
	}

	private AdviceApplicationImpl createAdviceApplicationFor(AdviceApplicationDescriptor descriptor) {
		try {
			MethodIdentifier meth = descriptor.getAdvice();
			return new AdviceApplicationImpl(master, master.getAdviceForID(meth), descriptor.getBindingName(), master.getResidue(descriptor.getResidue()));
		} catch (ClassNotPreparedException e) {
			// System.out.println("made lazy advice application");
			return new AdviceApplicationImpl.LazyAdviceApplicationImpl(master, descriptor.getAdvice(), descriptor.getResidue(),
					descriptor.getBindingName());
		} catch (NoSuchAdviceException e) {
			throw new InconsistentDebugInfoException(e.toString());
		}
	}

	public AdviceApplication getAdviceApplication(AdviceApplicationDescriptor aapl) throws ClassNotPreparedException {
		JoinPointImpl jp = getJoinPoint(aapl.getJoinpoint());
		AdviceApplication out = jp.get(aapl);
		if (out == null)
			throw new InternalDebuggerException("class loaded, JP found, advice missing");
		return out;
	}

	JoinPointManager(ShadowMaster master) {
		super();
		this.master = master;
	}

}
