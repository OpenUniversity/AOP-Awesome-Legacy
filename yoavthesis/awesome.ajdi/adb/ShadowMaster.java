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
import java.util.Vector;

import adb.ClassBasedAspectImpl.AbstractAspectInstance;
import adb.ClassBasedAspectImpl.PerObjectAspect;
import adb.ClassBasedAspectImpl.PerSingletonAspect;
import adb.ClassBasedAspectImpl.PerObjectAspect.PerObjectInstance;
import adb.ClassBasedAspectImpl.PerSingletonAspect.SingletonInstance;
import adb.PrimitiveTypeImpl.Primitives;
import adb.backend.AdviceApplicationDescriptor;
import adb.backend.AdviceDescriptor;
import adb.backend.AfterAspectEventListener;
import adb.backend.AfterBindingEventListener;
import adb.backend.AspectInfoProvider;
import adb.backend.AspectInstanceProvider;
import adb.backend.BindingDescriptor;
import adb.backend.CrossCuttingInfoProvider;
import adb.backend.EventManager;
import adb.backend.FieldLocationProvider;
import adb.backend.FilterManager;
import adb.backend.JoinPointDescriptor;
import adb.backend.JoinPointComputation;
import adb.backend.MethodIdentifier;
import adb.backend.NoSuchAdviceException;
import adb.backend.NoSuchBindingException;
import adb.backend.NotAnAspectContainerException;
import adb.backend.SourceLocationDescriptor;
import adb.backend.StackFilterManager;
import adb.backend.spi.NullAspectInfoProvider;
import adb.backend.spi.NullAspectInstanceProvider;
import adb.backend.spi.NullCrosscuttingProvider;
import adb.backend.spi.NullEventManager;
import adb.backend.spi.NullFieldLocationProvider;
import adb.backend.spi.NullFilter;
import adb.backend.spi.NullStackFrameFilter;
import adb.event.DynAopEventManager;
import adb.event.TransparentEventManager;
import adb.event.state.StateManager;
import adb.request.passive.EventRequestManagerImpl;
import adb.tools.Converter;
import adb.tools.InterList;
import adb.tools.ValueCache;
import ajdi.Advice;
import ajdi.AdviceApplication;
import ajdi.Aspect;
import ajdi.AspectInitialisationException;
import ajdi.AspectInstance;
import ajdi.Binding;
import ajdi.ClassObjectReference;
import ajdi.ClassType;
import ajdi.Field;
import ajdi.InterfaceType;
import ajdi.JoinPoint;
import ajdi.LocalVariable;
import ajdi.Method;
import ajdi.MethodExecutionJoinPoint;
import ajdi.ObjectReference;
import ajdi.Pointcut;
import ajdi.ReferenceType;
import ajdi.Residue;
import ajdi.Shadow;
import ajdi.SourceLocation;
import ajdi.StackFrame;
import ajdi.StmtJoinPoint;
import ajdi.ThreadGroupReference;
import ajdi.ThreadReference;
import ajdi.Type;
import ajdi.Value;
import ajdi.VoidValue;
import ajdi.event.EventQueue;
import ajdi.request.EventRequestManager;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.ClassNotPreparedException;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InconsistentDebugInfoException;
import com.sun.jdi.StringReference;
import com.sun.jdi.VMMismatchException;
import com.sun.jdi.VirtualMachine;

/**
 * @author wouter
 * 
 *         primary store for aspect
 */
public class ShadowMaster {

	private DynAopEventManager dynMgr;

	/***************************************************************************
	 * OVERALL SETUP
	 **************************************************************************/

	public ShadowMaster(VirtualMachine vm, FieldLocationProvider fieldLP, AspectInfoProvider aspectIP,
			CrossCuttingInfoProvider aspectCCIP, AspectInstanceProvider aspectInsP, FilterManager fm, StackFilterManager sfm,
			EventManager em, boolean tracing) {
		super();
		this.vm = vm;

		if (fieldLP != null)
			this.fieldLP = fieldLP;
		else
			this.fieldLP = new NullFieldLocationProvider();

		if (aspectIP != null)
			this.aspectIP = aspectIP;
		else
			this.aspectIP = new NullAspectInfoProvider();

		if (aspectCCIP != null)
			this.aspectCCIP = aspectCCIP;
		else
			this.aspectCCIP = new NullCrosscuttingProvider();

		if (aspectInsP != null)
			this.aspectInsP = aspectInsP;
		else
			this.aspectInsP = new NullAspectInstanceProvider();

		if (sfm != null)
			this.sfm = sfm;
		else
			this.sfm = new NullStackFrameFilter();
		this.sfm.setShadowMaster(this);

		if (fm != null)
			this.fm = fm;
		else
			this.fm = new NullFilter();

		// setup passive systems
		this.jpMgr = new JoinPointManager(this);
		this.primitives = new Primitives(this);

		// setup active systems

		// used as mutex in active systems, instantiate first
		if (tracing)
			this.state = new StateManager();

		this.event = new TransparentEventManager(this);
		this.req = new EventRequestManagerImpl(this, vm.eventRequestManager(), event);

		// active backend
		if (em != null) {
			this.em = em;
			em.setEventBaseRequestManager(vm.eventRequestManager());
			em.setEventRequestManager(req);
			em.setEventManager(event);
			em.setShadowMaster(this);

			CacheMaster cm = new CacheMaster();
			em.setAfterAspectEventListener(cm);
			em.setAfterBindingListener(cm);

			dynMgr = new DynAopEventManager(req);
			em.setBeforeAspectEventListener(dynMgr);
			em.setBeforeBindingListener(dynMgr);

		} else {
			this.em = new NullEventManager();
		}

		if (tracing) {
			// bind state manager
			this.state.setEventManager(this.event);
			this.state.setEventRequestManager(vm.eventRequestManager(), this.req);
			this.state.setShadowMaster(this);

			// init requests and transformers
			this.state.init();
		}
		this.em.init();

		// start handler loop
		this.event.start();

	}

	private VirtualMachine vm;

	private AspectInfoProvider aspectIP;

	private FieldLocationProvider fieldLP;

	private CrossCuttingInfoProvider aspectCCIP;

	private AspectInstanceProvider aspectInsP;

	private JoinPointManager jpMgr;

	private EventRequestManagerImpl req;
	private TransparentEventManager event;

	private StackFilterManager sfm;

	private FilterManager fm;

	private EventManager em;

	/***************************************************************************
	 * EVTS
	 **************************************************************************/
	public EventRequestManager getEventRequestManager() {
		return req;
	}

	public EventQueue getEventQueue() {
		return event.outQueue();
	}

	/***************************************************************************
	 * ASPECTS
	 **************************************************************************/

	private ValueCache<String, AspectImpl> aspects = new ValueCache<String, AspectImpl>();

	public AspectImpl getAspectFor(com.sun.jdi.ClassType in) throws NotAnAspectException {
		checkVM(in);
		try {
			if (!aspectIP.isAspectContainer(in.name()))
				throw new NotAnAspectException("This class is not an aspect container");
			return getAspectByName(aspectIP.getAspectNameFor(in.name()));
		} catch (ClassNotPreparedException e) {
			throw new InternalDebuggerException("class available but not Prepared?",e);
		} catch (NotAnAspectContainerException e) {
			throw new InternalDebuggerException("should be a container, but exception raised", e);
		}
	}

	private Converter<com.sun.jdi.ClassType, Aspect> ac = new Converter<com.sun.jdi.ClassType, Aspect>() {

		public Aspect convert(com.sun.jdi.ClassType source) {
			try {
				return getAspectFor(source);
			} catch (NotAnAspectException e) {
				throw new InternalDebuggerException("Aspect supertype is not an aspect");
			}
		}
	};

	public Converter<com.sun.jdi.ClassType, Aspect> getAspectConverter() {
		return ac;
	}

	public AspectImpl getAspectByName(String aspectName) throws ClassNotPreparedException, NotAnAspectException {
		AspectImpl out = aspects.get(aspectName);
		if (out == null) {
			out = createAspect(aspectName);
			out.setMechanismName(aspectIP.getMechNameForAspect(aspectName));
			aspects.put(aspectName, out);
		}
		return out;
	}

	private AspectImpl getLazyAspectByName(String aspectName) {
		AspectImpl out = aspects.get(aspectName);
		return out;
	}

	private AspectImpl getLazyAspectByClazz(String clazzName) throws NotAnAspectContainerException {
		String aspectName;
		aspectName = aspectIP.getAspectNameFor(clazzName);
		return getLazyAspectByName(aspectName);
	}

	private AspectImpl createAspect(String aspectName) throws NotAnAspectException {
		if (!aspectIP.isAspect(aspectName))
			throw new NotAnAspectException(aspectName);
		// if(aspectIP.isClassBasedAspect(aspectName))
		return createClassBasedAspect(aspectName);
	}

	private AspectImpl createClassBasedAspect(String aspectName) throws ClassNotPreparedException, NotAnAspectException {
		com.sun.jdi.ClassType base = getBaseClassFor(aspectIP.getClassNameFor(aspectName));
		if (base.isAbstract())
			return createClassBasedAbstractAspect(aspectName, base);

		int per = aspectIP.getPerFor(aspectName);
		switch (per) {
		case Aspect.PER_SINGLETON:
			return createClassBasedSingletonAspect(aspectName, base);
		case Aspect.PER_OBJECT:
			return createClassBasedPerObjectAspect(aspectName, base);
		default:
			throw new InternalDebuggerException("unkown per code: " + per);
		}

	}

	private ClassBasedAspectImpl createClassBasedAbstractAspect(String aspectName, com.sun.jdi.ClassType base) {
		return new ClassBasedAspectImpl.AbstractAspect(aspectName, base, false, this);
	}

	private ClassBasedAspectImpl createClassBasedPerObjectAspect(String aspectName, com.sun.jdi.ClassType base) {
		return new ClassBasedAspectImpl.PerObjectAspect(aspectName, base, false, this);
	}

	private ClassBasedAspectImpl createClassBasedSingletonAspect(String aspectName, com.sun.jdi.ClassType base) {
		return new ClassBasedAspectImpl.PerSingletonAspect(aspectName, base, false, this);
	}

	/***************************************************************************
	 * CLASSES
	 **************************************************************************/
	// TODO 1 cache regel voor type -> name -> type chains
	public com.sun.jdi.ClassType getBaseClassFor(String fcname) throws ClassNotPreparedException {
		List<com.sun.jdi.ReferenceType> bases = vm.classesByName(fcname);
		if (bases.isEmpty())
			throw new ClassNotPreparedException(fcname);
		if (bases.size() > 1)
			throw new InternalDebuggerException("More than one class matched name " + fcname + " should not occur");
		com.sun.jdi.ReferenceType out = bases.get(0);
		if (!(out instanceof com.sun.jdi.ClassType))
			throw new InternalDebuggerException("Should be class but is not: " + fcname + "," + out.getClass().getName()
					+ " should not occure");
		return (com.sun.jdi.ClassType) out;
	}

	private ValueCache<com.sun.jdi.ClassType, ClassTypeImpl> classes = new ValueCache<com.sun.jdi.ClassType, ClassTypeImpl>();

	/**
	 * @param in
	 * @return kan aspect zijn,...
	 */
	public ClassTypeImpl getClassFor(com.sun.jdi.ClassType in) {
		checkVM(in);
		ClassTypeImpl out = classes.get(in);
		if (out == null) {
			try {
				out = getAspectFor(in);
			} catch (NotAnAspectException e) {
				out = createClass(in);
			}
		}
		classes.put(in, out);
		return out;
	}

	/**
	 * zeker geen aspects invoegen
	 * 
	 * @param in
	 * @return
	 */
	private ClassTypeImpl createClass(com.sun.jdi.ClassType in) {
		return new ClassBasedClassTypeImpl(in, this);
	}

	private Converter<com.sun.jdi.ClassType, ajdi.ClassType> cc = new Converter<com.sun.jdi.ClassType, ajdi.ClassType>() {

		public ajdi.ClassType convert(com.sun.jdi.ClassType source) {
			return getClassFor(source);
		}
	};

	public Converter<com.sun.jdi.ClassType, ajdi.ClassType> getClassConverter() {
		return cc;
	}

	// public SInitJointPoint getJoinPointInfoFor(adb.ClassTypeImpl classType) {
	// checkMaster(classType);
	// JoinPointDescriptor jpd =
	// aspectCCIP.getJoinPointForClass(classType.name());
	//		
	// try {
	// JoinPointImpl jp = jpMgr.getJoinPoint(jpd);
	// if(jp instanceof SInitJointPoint)
	// return (SInitJointPoint)jp;
	// else
	// throw new InconsistentDebugInfoException("class can only have
	// SInitJoinpoits
	// but found: " + jp.toString());
	// } catch (ClassNotLoadedException e) {
	// throw new InternalDebuggerException(
	// "class not loaded, but should be");
	// }
	//
	// }

	public AspectInstance getInstanceFor(ThreadReference thread, PerObjectAspect perObjectAspect, ajdi.ObjectReference target)
			throws AspectInitialisationException, IncompatibleThreadStateException {
		checkMaster(thread);
		AbstractAspectInstance ains = aspectInsP.getPerObjectInstanceFor(vm, this, perObjectAspect.unwrap(), target,
				((ThreadReferenceImpl) thread).base);
		ains.setType(perObjectAspect);
		return ains;
	}

	public AspectInstance getInstanceFor(ThreadReference thread, PerSingletonAspect perSingletonAspect)
			throws IncompatibleThreadStateException, AspectInitialisationException {
		AbstractAspectInstance ains = aspectInsP
				.getPerSingletonInstanceFor(vm, this, perSingletonAspect.unwrap(), unwrap(thread));
		ains.setType(perSingletonAspect);
		return ains;
	}

	/**
	 * @param perSingletonAspect
	 * @param ref
	 *            the base object for the instance
	 * @return
	 */
	SingletonInstance createSingletonInstance(PerSingletonAspect perSingletonAspect, com.sun.jdi.ObjectReference ref) {
		SingletonInstance ains = aspectInsP.getPerSingletonInstanceFor(vm, this, perSingletonAspect.unwrap(), ref);
		ains.setType(perSingletonAspect);
		return ains;
	}

	AspectInstance createPreObjectInstanceFor(PerObjectAspect perObjectAspect, com.sun.jdi.ObjectReference ref,
			ObjectReference owner) {
		PerObjectInstance ains = aspectInsP.getPerObjectInstanceFor(vm, this, perObjectAspect.unwrap(), ref, owner);
		ains.setType(perObjectAspect);
		return ains;
	}

	ObjectReference getOwnerFor(PerObjectAspect perObjectAspect, com.sun.jdi.ObjectReference ref) {
		return wrap(aspectInsP.getOwnerForPerObjectAspectInstance(perObjectAspect, ref));
	}

	// public AspectInstance getSingletonInstance(PerSingletonAspect aspect)
	// throws
	// AspectInitialisationException {
	// vm.suspend();
	// AspectInstance aspi;
	// try {
	// aspi = getInstanceFor(vm.allThreads().get(0), aspect);
	// } catch (IncompatibleThreadStateException e) {
	// throw new InternalDebuggerException("Vm suspended, but thread still
	// running");
	// }
	// vm.resume();
	// return aspi;
	// }
	//
	// public AspectInstance getInstanceForObject(PerObjectAspect aspect,
	// com.sun.jdi.ObjectReference base) {
	// vm.suspend();
	// AspectInstance aspi;
	// try {
	// AspectInstance owner =
	// aspectInsP.getObjectForInstance(vm,this,base,vm.allThreads().get(0));
	// aspi = new PerObjectAspect.PerObjectInstance(base,owner,this);
	// } catch (IncompatibleThreadStateException e) {
	// throw new InternalDebuggerException("Vm suspended, but thread still
	// running");
	// }
	// vm.resume();
	// return aspi;
	// }

	public ClassTypeImpl getClassForName(String name) throws ClassNotPreparedException {
		return getClassFor(getBaseClassFor(name));
	}

	/***************************************************************************
	 * INTERFACES
	 **************************************************************************/

	private ValueCache<com.sun.jdi.InterfaceType, InterfaceTypeImpl> interfaces = new ValueCache<com.sun.jdi.InterfaceType, InterfaceTypeImpl>();

	private InterfaceTypeImpl getInterfaceFor(com.sun.jdi.InterfaceType in) {
		checkVM(in);
		InterfaceTypeImpl out = interfaces.get(in);
		if (out == null) {
			out = createInterFaceFor(in);
		}
		interfaces.put(in, out);
		return out;
	}

	private InterfaceTypeImpl createInterFaceFor(com.sun.jdi.InterfaceType in) {
		return new InterfaceTypeImpl(in, this);
	}

	private Converter<com.sun.jdi.InterfaceType, ajdi.InterfaceType> ic = new Converter<com.sun.jdi.InterfaceType, InterfaceType>() {

		public InterfaceType convert(com.sun.jdi.InterfaceType source) {
			return convert(source);
		}
	};

	public Converter<com.sun.jdi.InterfaceType, ajdi.InterfaceType> getInterfaceConverter() {
		return ic;
	}

	/***************************************************************************
	 * REFERENCETYPES
	 **************************************************************************/

	private ReferenceTypeImpl getReferenceTypeFor(com.sun.jdi.ReferenceType type) {
		checkVM(type);
		if (type instanceof com.sun.jdi.ArrayType)
			return new ArrayTypeImpl((com.sun.jdi.ArrayType) type, this);
		if (type instanceof com.sun.jdi.InterfaceType)
			return getInterfaceFor((com.sun.jdi.InterfaceType) type);
		return getClassFor((com.sun.jdi.ClassType) type);
	}

	private Converter<com.sun.jdi.ReferenceType, ajdi.ReferenceType> rc = new Converter<com.sun.jdi.ReferenceType, ajdi.ReferenceType>() {

		public ajdi.ReferenceType convert(com.sun.jdi.ReferenceType source) {
			return getReferenceTypeFor(source);
		}
	};

	public Converter<com.sun.jdi.ReferenceType, ajdi.ReferenceType> getReferenceTypeConverter() {
		return rc;
	}

	/***************************************************************************
	 * FIELDS
	 **************************************************************************/

	/**
	 * ONLY CALL FROM <code>ClassType.getExternalField</code>
	 * 
	 * @param referenceTypeImpl
	 * 
	 * @param field
	 * @return
	 */

	Field createField(ReferenceType referenceTypeImpl, com.sun.jdi.Field field) {
		checkVM(field);
		if (fm.filterField(field) == null)
			return null;
		return new FieldImpl(field, referenceTypeImpl, this);
	}

	public SourceLocation getFieldLocation(Field field) throws AbsentInformationException {
		checkMaster(field);
		SourceLocationDescriptor desc = fieldLP.getLocationFor(field.declaringType().name(), field.name());
		return new LineRange(vm, this, desc);
	}

	public com.sun.jdi.Field unwrap(Field arg0) {
		if (!(arg0 instanceof FieldImpl))
			throw new IllegalArgumentException("non ADB field: " + arg0.toString());
		FieldImpl field = (FieldImpl) arg0;
		checkMaster(field);
		return field.base;
	}

	public Field wrap(com.sun.jdi.Field in) {
		checkVM(in);
		return wrap(in.declaringType()).wrap(in);
	}

	/***************************************************************************
	 * METHODS
	 **************************************************************************/

	/**
	 * ONLY CALL FROM <code>ClassType.wrap(com.sun.jdi.Method method)</code>
	 * 
	 * @param method
	 * @return
	 */
	MethodImpl createMethod(ReferenceType referenceTypeImpl, com.sun.jdi.Method method) {
		if (fm.filterMethod(method) == null)
			return null;
		return new MethodImpl(method, referenceTypeImpl, this);
	}

	public JoinPoint getJoinPointFor(JoinPointDescriptor descr) {
		return jpMgr.getJoinPoint(descr);
	}

	public List<JoinPointComputation> getExposedJoinPointComputations(MethodImpl in)
	{
		List<JoinPointComputation> jpcs = aspectCCIP.getExposedJoinPointComputations(in.getBase().declaringType().name(), 
				in.getBase().name(), in.getBase().signature());
		
		return jpcs;		
	}
	
	// lazy init JP
	public MethodImpl.JoinPointInfo getJoinPointInfoFor(MethodImpl in) {
		List<JoinPointDescriptor> pcs = aspectCCIP.getJoinpointsForMethod(in.getBase().declaringType().name(), in.getBase()
				.name(), in.getBase().signature());

		MethodExecutionJoinPoint mexJP = null;

		Vector<StmtJoinPoint> others = new Vector<StmtJoinPoint>(pcs.size());
		Vector<MethodExecutionJoinPoint> inits = new Vector<MethodExecutionJoinPoint>();

		for (JoinPointDescriptor pc : pcs) {
			try {
				switch (pc.getType()) {
				case JoinPointDescriptor.TYPE_METHOD_EXECUTION:
				case JoinPointDescriptor.TYPE_SINIT:
					mexJP = (MethodExecutionJoinPoint) jpMgr.getJoinPoint(pc);
					break;
				case JoinPointDescriptor.TYPE_STATEMENT:
					others.add((StmtJoinPoint) jpMgr.getJoinPoint(pc));
					break;
				case JoinPointDescriptor.TYPE_INIT:
				case JoinPointDescriptor.TYPE_PINIT:
					inits.add((MethodExecutionJoinPoint) jpMgr.getJoinPoint(pc));
					break;
				default:
					throw new InternalDebuggerException("Unknow type of pointcut: " + pc.getType());
				}
			} catch (ClassNotPreparedException e) {
				throw new InternalDebuggerException("class not prepared, but should be");
			}
		}

		others.trimToSize();

		if (inits.isEmpty()) {
			return new MethodImpl.JoinPointInfo(others, mexJP);
		} else {
			inits.add(mexJP);
			return new MethodImpl.JoinPointInfo(others, inits, mexJP);
		}

	}

	public com.sun.jdi.Method unwrap(Method arg1) {
		checkMaster(arg1);
		if (!(arg1 instanceof MethodImpl))
			throw new IllegalArgumentException("non ADB method: " + arg1.toString());
		MethodImpl method = (MethodImpl) arg1;
		return method.getBase();
	}

	/***************************************************************************
	 * ADVICEAPPLICATION
	 * 
	 * @throws NotAnAspectException
	 * @throws NoSuchAdviceException
	 **************************************************************************/

	public List<AdviceApplication> getApplicationsFor(AdviceImpl advice) throws NotAnAspectException, NoSuchAdviceException {
		checkMaster(advice);
		List<AdviceApplicationDescriptor> aps;
		aps = aspectCCIP.getApplicationsFor(advice.declaringType().name(), advice.getBase().name(), advice.getBase().signature());

		List<AdviceApplication> out = new LinkedList<AdviceApplication>();
		for (AdviceApplicationDescriptor pc : aps) {
			try {
				out.add(jpMgr.getAdviceApplication(pc));
			} catch (ClassNotPreparedException e) {
				// OK, normal
				// No caching, so no worries
			}
		}
		return Collections.unmodifiableList(out);
	}

	Residue getResidue(String residu) {
		return new ResidueImpl(residu);
	}

	/***************************************************************************
	 * ADVICE
	 **************************************************************************/

	/**
	 * @param parent
	 * @return never null
	 */
	public List<Advice> createAdvicesFor(Aspect parent) {
		checkMaster(parent);

		List<AdviceDescriptor> ads;
		try {
			ads = aspectIP.getAdvicesFor(parent.name());
		} catch (NotAnAspectException e) {
			throw new InternalDebuggerException("trying to fetch advices for a normal class: " + parent.name());
		}

		List<Advice> out = new LinkedList<Advice>();

		for (AdviceDescriptor ad : ads) {
			out.add(createAdvice(parent, ad));
		}

		return Collections.unmodifiableList(out);
	}

	public AdviceImpl createAdvice(Aspect parent, AdviceDescriptor ad) {
		LineRange range = new LineRange(vm, this, ad.getLocation());

		/*
		 * if(ad.startln == -1) range = null;
		 */

		try {
			MethodIdentifier meth = ad.getContainer();
			com.sun.jdi.ClassType container = getBaseClassFor(meth.getClazz());
			com.sun.jdi.Method m = container.concreteMethodByName(meth.getMethodname(), meth.getMethodsig());
			if (m == null)
				throw new InternalDebuggerException("advice method " + meth
						+ " not found, advice inlining not supported; compile with -O0");
			return (new AdviceImpl(parent, getBindings(ad.getBindings()), ad.getType(), m, this, range, ad.getArgIndices(), ad
					.getArgNames(), ad.getEffectType(), ad.getSourceLines()));

		} catch (ClassNotPreparedException e) {
			return (new PartialAdviceImpl(parent, getBindings(ad.getBindings()), ad.getType(), ad.getContainer(), this, range, ad
					.getArgIndices(), ad.getArgNames(), ad.getEffectType(), ad.getSourceLines()));
		}
	}

	private Converter<MethodIdentifier, Advice> af = new Converter<MethodIdentifier, Advice>() {

		@Override
		public Advice convert(MethodIdentifier source) {
			try {
				return getAdviceForID(source);
			} catch (ClassNotPreparedException e) {
				throw new InternalDebuggerException("advice used, class not loaded",e);
			} catch (NoSuchAdviceException e) {
				throw new InternalDebuggerException("advice used, class not loaded",e);
			}
		}
	};

	public Converter<MethodIdentifier, Advice> getAdviceFinder() {
		return af;
	}

	public Advice getAdviceForID(MethodIdentifier source) throws NoSuchAdviceException, ClassNotPreparedException {
		try {
			AspectImpl asp = getAspectFor(getBaseClassFor(source.getClazz()));
			return asp.getAdvice(source.getMethodname(), source.getMethodsig());
		} catch (NotAnAspectException e) {
			throw new NoSuchAdviceException(e);
		}
		
	}
	
	public Method getConcreteMemberForID(MethodIdentifier source) throws ClassNotPreparedException {
		ClassTypeImpl asp = getClassForName(source.getClazz());
		return asp.concreteMemberByName(source.getMethodname(), source.getMethodsig());
	}

	private List<Binding> getBindings(BindingDescriptor[] bindingDescriptors) {
		List<Binding> bindings = new ArrayList<Binding>(bindingDescriptors.length);
		for (int i = 0; i < bindingDescriptors.length; i++) {
			bindings.add(getBinding(bindingDescriptors[i]));
		}
		return bindings;
	}

	
	public Binding findBinding(BindingDescriptor bindingDescriptor) throws ClassNotPreparedException, NoSuchAdviceException{
		if (bindingDescriptor.isManaged())
			return getManagedBinding(bindingDescriptor);
		else{
			return getAdviceForID(bindingDescriptor.getAdvices().get(0)).bindings().get(0);
		}
			
			
		
	}
	private ValueCache<String, Binding> bindings = new ValueCache<String, Binding>();

	private Binding getBinding(BindingDescriptor bindingDescriptor) {
		if (bindingDescriptor.isManaged())
			return getManagedBinding(bindingDescriptor);
		else
			return createBinding(bindingDescriptor);
	}

	private Binding getManagedBinding(BindingDescriptor bindingDescriptor) {
		Binding b = bindings.get(bindingDescriptor.getName());
		if (b == null) {
			b = createManagedBinding(bindingDescriptor);
			bindings.put(bindingDescriptor.getName(), b);
		}
		return b;
	}

	private Binding createManagedBinding(BindingDescriptor des) {
		return new ManagedBindingImp(this.vm, this, createPointCut(des.getPointcut()), des.getName(), new LineRange(this.vm,
				this, des.getLocation()), des.getAdvices());
	}

	private Binding createBinding(BindingDescriptor des) {
		return new BindingImpl(this.vm, this, createPointCut(des.getPointcut()), des.getName(), new LineRange(this.vm, this, des
				.getLocation()));
	}

	private Pointcut createPointCut(String pointcut) {
		return new PointcutImpl(pointcut);
	}

	/***************************************************************************
	 * TYPE
	 **************************************************************************/
	public Type wrap(com.sun.jdi.Type in) {
		checkVM(in);
		if (in instanceof com.sun.jdi.PrimitiveType)
			return primitives.wrap((com.sun.jdi.PrimitiveType) in);
		else if (in instanceof com.sun.jdi.ReferenceType)
			return getReferenceTypeFor((com.sun.jdi.ReferenceType) in);
		else if (in instanceof com.sun.jdi.VoidType)
			return primitives.getVoidType();
		else
			throw new InternalDebuggerException("unknown type");

	}

	public Converter<com.sun.jdi.Type, Type> tc = new Converter<com.sun.jdi.Type, Type>() {

		public Type convert(com.sun.jdi.Type source) {
			return wrap(source);
		}
	};

	public Converter<com.sun.jdi.Type, Type> getTypeConverter() {
		return tc;
	}

	public ReferenceTypeImpl wrap(com.sun.jdi.ReferenceType in) {
		checkVM(in);
		return getReferenceTypeFor(in);
	}

	public com.sun.jdi.ReferenceType unwrap(ReferenceType in) {
		checkMaster(in);
		return ((AbstractReferenceTypeImpl) in).unwrap();
	}

	/***************************************************************************
	 * VALUE
	 **************************************************************************/

	public Value wrap(com.sun.jdi.Value in) {
		if (in == null)
			return null;
		checkVM(in);
		if (in instanceof com.sun.jdi.PrimitiveValue)
			return primitives.wrap((com.sun.jdi.PrimitiveValue) in);
		else if (in instanceof com.sun.jdi.ObjectReference)
			return wrap((com.sun.jdi.ObjectReference) in);
		else if (in instanceof com.sun.jdi.Value)
			return primitives.getVoidValue();
		else
			throw new InternalDebuggerException("unknown type");
	}

	private Converter<com.sun.jdi.Value, Value> vc = new Converter<com.sun.jdi.Value, Value>() {

		public Value convert(com.sun.jdi.Value source) {
			return wrap(source);
		}
	};

	public Converter<com.sun.jdi.Value, Value> getValueConverter() {
		return vc;
	}

	/***************************************************************************
	 * Location
	 **************************************************************************/

	private Converter<com.sun.jdi.Location, ajdi.Location> lc = new Converter<com.sun.jdi.Location, ajdi.Location>() {

		public ajdi.Location convert(com.sun.jdi.Location source) {
			return wrap(source);
		}
	};

	private Converter<com.sun.jdi.Location, ajdi.SourceLocation> slc = new Converter<com.sun.jdi.Location, ajdi.SourceLocation>() {

		public ajdi.SourceLocation convert(com.sun.jdi.Location source) {
			return convertSourceLineLocation(source);
		}
	};

	private Primitives primitives;

	public Converter<com.sun.jdi.Location, ajdi.Location> getLocationConverter() {
		return lc;
	}

	public Converter<com.sun.jdi.Location, ajdi.SourceLocation> getSourceLocationConverter() {
		return slc;
	}

	public SourceLocation convertSourceLineLocation(com.sun.jdi.Location location) {
		try {
			return new SourceLocationImpl(vm, this, location.sourcePath(), location.lineNumber());
		} catch (AbsentInformationException e) {
			throw new InternalDebuggerException("no sourcepath in JDI provided location: " + location.toString());
		}
	}

	/**
	 * containing method is always concrete and existing or a target that can be replaced
	 * 
	 * @param location
	 * @return
	 * @throws AbsentInformationException 
	 */
	public ajdi.Location wrap(com.sun.jdi.Location location)  {
		com.sun.jdi.Method m = location.method();
		ajdi.ReferenceType clazz = getReferenceTypeFor(location.declaringType());
		// clazz kan een interface zijn,....
		// de Sinit kan code bevatten,...
		// dus zoeken maar, helaas
		Method out = null;

		if (clazz instanceof AspectImpl) {
			try {
				out = ((AspectImpl) clazz).getAdvice(m.name(), m.signature());
			} catch (NoSuchAdviceException e) {
				// its OK
			}
		}

		if (out == null)
			for (Method method : clazz.methods()) {
				if (method.name().equals(m.name()) && method.signature().equals(m.signature())) {
					out = method;
					break;
				}
			}

		if (out == null) {
			MethodIdentifier alternate = aspectCCIP.isTargetMethod(clazz.name(), m.name(), m.signature());
			if(alternate == null)
				throw new InternalDebuggerException("method for location not found: " + location.toString());
			out = getConcreteMemberForID(alternate);
			if(out == null)
				throw new InternalDebuggerException("alternate method for location not found: " + alternate.toString());
		}

		try {
			return new LocationImpl(vm, this, location.sourcePath(), location.lineNumber(), clazz, out, location.codeIndex());
		} catch (AbsentInformationException e) {
			throw new InternalDebuggerException("no sourcepath in JDI provided location: " + location.toString());
		}
	}

	public com.sun.jdi.Location unwrap(ajdi.Location location) {
		checkMaster(location);

		com.sun.jdi.Method method = unwrap(location.method());
		return method.locationOfCodeIndex(location.codeIndex());
	}

	/***************************************************************************
	 * Objects
	 **************************************************************************/
	ValueCache<com.sun.jdi.ObjectReference, ObjectReference> objects = new ValueCache<com.sun.jdi.ObjectReference, ObjectReference>();

	void addObjectReference(com.sun.jdi.ObjectReference in, ObjectReference out) {
		objects.put(in, out);
	}

	public ObjectReference wrap(com.sun.jdi.ObjectReference oref) {
		checkVM(oref);
		ObjectReference out = objects.get(oref);
		if (out == null)
			return createObjectReference(oref);
		return out;
	}

	public ClassObjectReference wrap(com.sun.jdi.ClassObjectReference in) {
		checkVM(in);
		ObjectReference out = objects.get(in);
		if (out == null)
			return createClassObjectReference(in);
		if (!(out instanceof ClassObjectReference))
			throw new InternalDebuggerException("class change,....");
		return (ClassObjectReference) out;
	}

	public ajdi.ThreadGroupReference wrap(com.sun.jdi.ThreadGroupReference in) {
		checkVM(in);
		ObjectReference out = objects.get(in);
		if (out == null)
			return createThreadGroupReference(in);
		if (!(out instanceof ThreadGroupReference))
			throw new InternalDebuggerException("class change,....");
		return (ThreadGroupReference) out;
	}

	public ThreadReference wrap(com.sun.jdi.ThreadReference in) {
		checkVM(in);
		ObjectReference out = objects.get(in);
		if (out == null)
			return createThreadReference(in);
		if (!(out instanceof ThreadReference))
			throw new InternalDebuggerException("class change,....");
		return (ThreadReference) out;
	}

	private ObjectReference createObjectReference(com.sun.jdi.ObjectReference in) {
		if (in instanceof com.sun.jdi.ArrayReference)
			return new ArrayReferenceImpl(this, (com.sun.jdi.ArrayReference) in);
		if (in instanceof com.sun.jdi.ClassLoaderReference)
			return new ClassLoaderReferenceImpl((com.sun.jdi.ClassLoaderReference) in, this);
		if (in instanceof com.sun.jdi.ClassObjectReference)
			return createClassObjectReference((com.sun.jdi.ClassObjectReference) in);
		if (in instanceof com.sun.jdi.StringReference)
			return new StringReferenceImpl((StringReference) in, this);
		if (in instanceof com.sun.jdi.ThreadGroupReference)
			return createThreadGroupReference((com.sun.jdi.ThreadGroupReference) in);
		if (in instanceof com.sun.jdi.ThreadReference)
			return createThreadReference((com.sun.jdi.ThreadReference) in);
		return createPlainObjectReference(in);
	}

	private ObjectReference createPlainObjectReference(com.sun.jdi.ObjectReference in) {
		ReferenceType type = wrap(in.referenceType());
		if (type instanceof AspectImpl) {
			return ((AspectImpl) type).wrap(in);
		} else
			return new ObjectReferenceImpl(in, this);
	}

	private ClassObjectReference createClassObjectReference(com.sun.jdi.ClassObjectReference in) {
		return new ClassObjectReferenceImpl(in, this);
	}

	private ThreadGroupReference createThreadGroupReference(com.sun.jdi.ThreadGroupReference in) {
		return new ThreadGroupReferenceImpl(in, this);
	}

	private ThreadReference createThreadReference(com.sun.jdi.ThreadReference in) {
		return new ThreadReferenceImpl(in, this);
	}

	private Converter<com.sun.jdi.ThreadReference, ThreadReference> thc = new Converter<com.sun.jdi.ThreadReference, ThreadReference>() {

		public ThreadReference convert(com.sun.jdi.ThreadReference source) {
			return wrap(source);
		}
	};

	public Converter<com.sun.jdi.ThreadReference, ThreadReference> getThreadConverter() {
		return thc;
	}

	private Converter<com.sun.jdi.ThreadGroupReference, ThreadGroupReference> thgc = new Converter<com.sun.jdi.ThreadGroupReference, ThreadGroupReference>() {

		public ThreadGroupReference convert(com.sun.jdi.ThreadGroupReference source) {
			return wrap(source);
		}
	};

	public Converter<com.sun.jdi.ThreadGroupReference, ajdi.ThreadGroupReference> getThreadGroupConverter() {
		return thgc;
	}

	private Converter<com.sun.jdi.ObjectReference, ObjectReference> oc = new Converter<com.sun.jdi.ObjectReference, ObjectReference>() {

		public ObjectReference convert(com.sun.jdi.ObjectReference source) {
			return wrap(source);
		}
	};

	public Converter<com.sun.jdi.ObjectReference, ObjectReference> getObjectConverter() {
		return oc;
	}

	/***************************************************************************
	 * UNWRAP
	 **************************************************************************/

	public com.sun.jdi.ObjectReference unwrap(ajdi.ObjectReference object) {
		if (!(object instanceof ObjectReferenceImpl))
			throw new IllegalArgumentException("non ADB object: " + object.toString());
		ObjectReferenceImpl field = (ObjectReferenceImpl) object;
		checkMaster(field);
		return field.base;
	}

	public com.sun.jdi.ThreadReference unwrap(ajdi.ThreadReference object) {
		if (!(object instanceof ThreadReferenceImpl))
			throw new IllegalArgumentException("non ADB object: " + object.toString());
		ThreadReferenceImpl field = (ThreadReferenceImpl) object;
		checkMaster(field);
		return field.base;
	}

	@SuppressWarnings("unchecked")
	public com.sun.jdi.Value unwrap(Value value) {
		checkMaster(value);
		if ((value instanceof PrimitiveValueImpl)) {
			return ((PrimitiveValueImpl) value).base;
		} else if (value instanceof VoidValue) {
			return vm.mirrorOfVoid();
		} else if (value instanceof AbstractObjectReference) {
			return ((AbstractObjectReference) value).base;
		} else
			throw new IllegalArgumentException("non ADB object: " + value.toString());
	}

	public com.sun.jdi.StackFrame unwrap(ajdi.StackFrame object) {
		checkMaster(object);
		if (!(object instanceof StackFrameImpl))
			throw new IllegalArgumentException("non ADB object: " + object.toString());
		StackFrameImpl field = (StackFrameImpl) object;
		return field.base;
	}

	public com.sun.jdi.LocalVariable unwrap(ajdi.LocalVariable object) {
		if (!(object instanceof LocalVariableImpl))
			throw new IllegalArgumentException("non ADB object: " + object.toString());
		LocalVariableImpl field = (LocalVariableImpl) object;
		checkMaster(field);
		return field.base;
	}

	private Converter<Value, com.sun.jdi.Value> vuc = new Converter<Value, com.sun.jdi.Value>() {

		public com.sun.jdi.Value convert(Value source) {
			return unwrap(source);
		}
	};

	public Converter<Value, com.sun.jdi.Value> getValueUnwrapper() {
		return vuc;
	}

	private Converter<com.sun.jdi.LocalVariable, ajdi.LocalVariable> lvc = new Converter<com.sun.jdi.LocalVariable, LocalVariable>() {

		public LocalVariable convert(com.sun.jdi.LocalVariable source) {
			return wrap(source);
		}
	};

	public Converter<com.sun.jdi.LocalVariable, ajdi.LocalVariable> getVariableConverter() {
		return lvc;
	}

	public ajdi.LocalVariable wrap(com.sun.jdi.LocalVariable base) {
		return new LocalVariableImpl(base, this);
	}

	public List<StackFrame> wrap(List<com.sun.jdi.StackFrame> frames) {
		return sfm.filterFrames(frames);
	}

	public ajdi.StackFrame wrap(com.sun.jdi.StackFrame frame) {
		return new StackFrameImpl(frame, this);
	}

	private Converter<com.sun.jdi.StackFrame, ajdi.StackFrame> fc = new Converter<com.sun.jdi.StackFrame, ajdi.StackFrame>() {

		public StackFrame convert(com.sun.jdi.StackFrame source) {
			return wrap(source);
		}
	};

	public Converter<com.sun.jdi.StackFrame, ajdi.StackFrame> getFrameConverter() {
		return fc;
	}

	Primitives getPrimitives() {
		return primitives;
	}

	public VirtualMachine getVirtualMachine() {
		return vm;
	}

	public void checkMaster(Shadow sh) {
		if (this != sh.shadowMaster())
			throw new VMMismatchException("object came form different master");
	}

	protected void checkVM(com.sun.jdi.Mirror in) {
		if (!in.virtualMachine().equals(vm))
			throw new VMMismatchException();
	}

	public AspectInfoProvider getAspectInfoProvider() {
		return aspectIP;
	}

	public CrossCuttingInfoProvider getCrossCuttingInfoProvider() {
		return aspectCCIP;
	}

	public void checkLookThrough() {
		// TODO
	}

	// ActiveEventManager getEventSystem(){
	// return event;
	// }

	public Method wrap(com.sun.jdi.Method method) {
		ReferenceTypeImpl parent = wrap(method.declaringType());
		return parent.wrap(method);
	}

	public List<ThreadReference> allThreads() {
		return new InterList<com.sun.jdi.ThreadReference, ThreadReference>(vm.allThreads(), getThreadConverter());
	}

	public FilterManager getFilterManager() {
		return fm;
	}

	/*********************************************************
	 * Cache
	 *********************************************************/
	public class CacheMaster implements AfterAspectEventListener, AfterBindingEventListener {

		/*
		 * private void flushAapls(List<AdviceApplicationDescriptor> aapls) {
		 * for (AdviceApplicationDescriptor aapl : aapls) { flushAapl(aapl); } }
		 * 
		 * private void flushAapl(AdviceApplicationDescriptor aapl) { JoinPoint
		 * jp = jpMgr.flush(aapl.getJoinpoint()); if (jp == null) return;
		 * ((MethodImpl) jp.location().method()).flushJoinpoints(); }
		 */

		@Override
		public void afterAdviceAdded(AdviceDescriptor add) {
			// flush aspect advice cache
			AspectImpl a = getLazyAspectByName(add.getAspect());

			if (a == null)
				return;

			a.add(add);

			for (Aspect child : a.subAspects()) {
				((AspectImpl) child).flushAllAdvices();
			}
			try {
				jpMgr.addAdvice(add, aspectCCIP.getApplicationsFor(add.getAspect(), add.getContainer().getMethodname(), add
						.getContainer().getMethodsig()));
			} catch (NotAnAspectException e) {
				throw new InconsistentDebugInfoException();
			} catch (NoSuchAdviceException e) {
				throw new InconsistentDebugInfoException();
			}

		}

		@Override
		public void afterAdviceRemoved(AdviceDescriptor add) {
			// flush aspect advice cache
			AspectImpl a = getLazyAspectByName(add.getAspect());

			if (a == null)
				return;

			a.remove(add);

			for (Aspect child : a.subAspects()) {
				((AspectImpl) child).flushAllAdvices();
			}

			jpMgr.removeAdvice(add);

		}

		@Override
		public void afterAspectCreated(String aspectName) {
			String clazz;
			try {
				clazz = aspectIP.getClassNameFor(aspectName);
				classes.remove(getBaseClassFor(clazz));

			} catch (NotAnAspectException e) {
				throw new InternalDebuggerException("aspect created but not existing", e);
			}
			// super class not cached
		}

		@Override
		public void afterAspectRemoved(String aspectName) {
			AspectImpl a = aspects.remove(aspectName);
			if (a != null)
				classes.remove((com.sun.jdi.ClassType) unwrap(a));

			// super class not cached
		}

		@Override
		public void afterBindingAdded(BindingDescriptor bind) {
			Binding binding = createBinding(bind);
			for (MethodIdentifier mid : bind.getAdvices()) {
				try {
					AspectImpl aspect = getLazyAspectByClazz(mid.getClazz());
					
					if (aspect == null)
						continue;
					
					AdviceImpl adv = (AdviceImpl) aspect.getAdvice(mid.getMethodname(), mid.getMethodsig());
 
					adv.addBinding(binding);
				} catch (NoSuchAdviceException e) {
					throw new InternalDebuggerException("should be an advice", e);
				} catch (NotAnAspectContainerException e) {
					throw new InternalDebuggerException("should be an aspectcontainer", e);
				}

			}

			try {
				jpMgr.addBinding(bind, aspectCCIP.getApplicationsFor(bind.getName()));
			} catch (NoSuchBindingException e) {
				throw new InternalDebuggerException("binding added, but not existing", e);
			}

		}

		@Override
		public void afterBindingRemoved(BindingDescriptor bind) {
			Binding binding = bindings.remove(bind.getName());

			for (Advice advice : binding.advices()) {
				((AdviceImpl) advice).removeBinding(bind.getName());
			}

			// FIXME EAGER IN allApplications
			for (AdviceApplication aapl : binding.allApplications()) {
				((MethodImpl) aapl.joinPoint().location().method()).flushJoinpoints();
			}
		}

	}

	/*********************************************************
	 * STATE
	 *********************************************************/
	public StateManager state;

	/*
	 * //lock on state private List<SoftReference<VMStateListener>> listeners =
	 * new LinkedList<SoftReference<VMStateListener>>(); private boolean
	 * running;
	 */

	/*
	 * void notifyResume() { synchronized (state) { if(!running){ running =
	 * true; for (ListIterator<SoftReference<VMStateListener>> itrl =
	 * listeners.listIterator();itrl.hasNext();) { VMStateListener list =
	 * itrl.next().get(); if(list == null || !list.unSuspended(this))
	 * itrl.remove(); } running = false; } System.out.println("resume vm"); } }
	 */

	public void resume() {
		vm.resume();
		// notifyResume();
	}

	/*
	 * void addListener(VMStateListener list){ synchronized(state){
	 * listeners.add(new SoftReference<VMStateListener>(list)); } }
	 * 
	 * @Override public boolean threadResumed(ThreadReference thread) {
	 * //state.threadResumed(thread); //notifyResume(); return true; }
	 */
	/*
	 * public StateManager state(){ return state; }
	 */

}
