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

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import adb.backend.AdviceDescriptor;
import adb.backend.NoSuchAdviceException;
import adb.tools.InterList;
import adb.tools.ValueCache;
import ajdi.Advice;
import ajdi.Aspect;
import ajdi.AspectInitialisationException;
import ajdi.AspectInstance;
import ajdi.IncompatibleAspectTypeException;
import ajdi.Method;
import ajdi.ObjectReference;
import ajdi.ThreadReference;
import ajdi.Value;

import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.ClassType;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InconsistentDebugInfoException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.InvocationException;

/**
 * @author wouter
 * 
 *         aspects are created on class load by the Master aspects are cached
 *         and thus not collected advices are added and propagated by the Master
 *         aspects are prime data store for aspect data
 */
public abstract class ClassBasedAspectImpl extends ClassBasedClassTypeImpl
		implements AspectImpl, ajdi.Aspect {

	public ClassBasedAspectImpl(String aspectName, com.sun.jdi.ClassType base,
			boolean dynamic, ShadowMaster master) {
		super(base, master);
		if (dynamic == true)
			new IllegalArgumentException(
					"class based Aspects can not be dynamic");
		advices = new AdviceContainerDelegate(this);
		name = aspectName;
	}

	private String name;
	private String mechName;
	
	public String mechanismName()
	{
		return mechName;
	}
	
	public void setMechanismName(String mechName)
	{
		this.mechName = mechName;
	}

	public String name() {
		return name;
	}

	public String signature() {
		return "L" + name().replace(".", "/") + ":";
	}

	public String genericSignature() {
		return signature();
	}

	// LAZY unmodifyable
	private AdviceContainerDelegate advices;
	private List<Advice> alladvices;

	public synchronized List<Advice> advices() {
		return advices.advices();
	}

	public synchronized List<Advice> allAdvices() {
		if (alladvices == null) {
			LinkedList<Advice> advices = new LinkedList<Advice>();
			advices.addAll(advices());

			ajdi.ClassType supert = superclass();
			if (supert instanceof Aspect) {
				Aspect supera = ((Aspect) supert);
				advices.addAll((Collection<Advice>) supera.allAdvices());
			}

			alladvices = Collections.unmodifiableList(advices);
		}
		return alladvices;
	}
	
	public void remove(AdviceDescriptor add){
		advices.remove(add);
		alladvices = null;
	}
	
	public void add(AdviceDescriptor add){
		advices.add(add);
		alladvices = null;
	}

	public synchronized void flushAllAdvices(){
		alladvices = null;
	}

	public synchronized List<Advice> advicesBySignature(String sig) {
		return advices.advicesBySignature(sig);
	}

	public synchronized Advice concreteAdviceBySignature(String sig) {
		return advices.concreteAdviceBySignature(sig);
	}

	public synchronized AdviceImpl getAdvice(String methodname, String methodsig) throws NoSuchAdviceException {
		return advices.getAdvice(methodname, methodsig);
	}

	public synchronized List<Advice> getAdvice(String methodname) {
		return advices.getAdvice(methodname);
	}
	
	public synchronized MethodImpl wrap(com.sun.jdi.Method method){
		AdviceImpl advice = advices.wrap(method);
		if(advice != null)
			return advice;
		else
			return super.wrap(method);
	}

	public List<Aspect> subAspects() {
		return new InterList<com.sun.jdi.ClassType, Aspect>(unwrap()
				.subclasses(), master.getAspectConverter());
	}

	// public abstract List<AspectInstance> allInstances();
	public abstract AspectInstance getInstanceFor(ThreadReference worker,
			ObjectReference object) throws IncompatibleThreadStateException,
			AspectInitialisationException, IncompatibleAspectTypeException;

	public abstract AspectInstance getInstance(ThreadReference thread)
			throws IncompatibleThreadStateException,
			AspectInitialisationException;

	public abstract int getPer();

	public abstract boolean isPerObject();

	public abstract boolean isPerSingleton();

	public ObjectReferenceImpl newInstance(ThreadReference thread,
			Method method, List<? extends Value> arguments, int options)
			throws InvalidTypeException, ClassNotLoadedException,
			IncompatibleThreadStateException, InvocationException {
		throw new UnsupportedOperationException("aspects are self initialising");
	}

	public static class AbstractAspect extends ClassBasedAspectImpl {

		public AbstractAspect(String aspectName, ClassType base,
				boolean dynamic, ShadowMaster master) {
			super(aspectName, base, dynamic, master);
		}

		// @Override
		// public List<AspectInstance> allInstances() {
		// return Collections.emptyList();
		// }

		@Override
		public AspectInstance getInstance(ThreadReference thread)
				throws IncompatibleThreadStateException,
				AspectInitialisationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public AspectInstance getInstanceFor(ThreadReference thread,
				ObjectReference object)
				throws IncompatibleThreadStateException,
				AspectInitialisationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public int getPer() {
			return 0;
		}

		@Override
		public boolean isPerObject() {
			return false;
		}

		@Override
		public boolean isPerSingleton() {
			return false;
		}

		@Override
		public boolean isAbstract() {
			return true;
		}

		public AspectInstance wrap(com.sun.jdi.ObjectReference ref) {
			throw new InternalDebuggerException(
					"tried to wrap instance of abstract aspect");
		}

	}

	public static abstract class AbstractAspectInstance extends
			adb.ObjectReferenceImpl implements AspectInstance {
		public AbstractAspectInstance(com.sun.jdi.ObjectReference base,
				ShadowMaster master) {
			super(base, master);
		}

		private Aspect type;

		public Aspect referenceType() {
			return type;
		}

		public void setType(Aspect type) {
			this.type = type;
		}
	}

	public static class PerSingletonAspect extends ClassBasedAspectImpl {

		public PerSingletonAspect(String name, com.sun.jdi.ClassType base,
				boolean dynamic, ShadowMaster master) {
			super(name, base, dynamic, master);
		}

		public static class SingletonInstance extends AbstractAspectInstance
				implements AspectInstance {

			public SingletonInstance(com.sun.jdi.ObjectReference base,
					ShadowMaster master) {
				super(base, master);
			}

			public ObjectReference owner() {
				return null;
			}

			public int getPer() {
				return ClassBasedAspectImpl.PER_SINGLETON;
			}

			public boolean isPerObject() {
				return false;
			}

			public boolean isPerSingleton() {
				return true;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (!super.equals(obj))
					return false;
				if (getClass() != obj.getClass())
					return false;
				return true;
			}
		}

		private SingletonInstance instance;

		@Override
		public AspectInstance getInstance(ThreadReference thread)
				throws IncompatibleThreadStateException,
				AspectInitialisationException {
			if (instance == null) {
				instance = (SingletonInstance) shadowMaster().getInstanceFor(
						thread, this);
			}
			return instance;
		}

		@Override
		public AspectInstance getInstanceFor(ThreadReference thread,
				ObjectReference object)
				throws IncompatibleThreadStateException,
				AspectInitialisationException {
			return getInstance(thread);
		}

		// public List<AspectInstance> allInstances(){
		// try {
		// AspectInstance aspi =
		// getShadowMaster().getSingletonInstance(PerSingletonAspect.this);
		// if(aspi == null) {
		// return Collections.emptyList();
		// }
		// return Collections.singletonList(aspi);
		// } catch (AspectInitialisationException e) {
		// return Collections.emptyList();
		// }
		// }

		@Override
		public int getPer() {
			return ClassBasedAspectImpl.PER_SINGLETON;
		}

		@Override
		public boolean isPerObject() {
			return false;
		}

		@Override
		public boolean isPerSingleton() {
			return true;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			return true;
		}

		public AspectInstance wrap(com.sun.jdi.ObjectReference ref) {
			if (instance == null)
				instance = shadowMaster().createSingletonInstance(
						PerSingletonAspect.this, ref);
			if (!instance.base.equals(ref))
				throw new InconsistentDebugInfoException(
						"singleton is not a singleton,... " + ref);
			return instance;
		}

	}

	public static class PerObjectAspect extends ClassBasedAspectImpl {
		public PerObjectAspect(String name, com.sun.jdi.ClassType base,
				boolean dynamic, ShadowMaster master) {
			super(name, base, dynamic, master);
		}

		public static class PerObjectInstance extends AbstractAspectInstance
				implements AspectInstance {

			private ObjectReference owner;

			public PerObjectInstance(com.sun.jdi.ObjectReference base,
					ObjectReference owner, ShadowMaster master) {
				super(base, master);
				this.owner = owner;
			}

			public ObjectReference owner() {
				return owner;
			}

			public int getPer() {
				return ClassBasedAspectImpl.PER_OBJECT;
			}

			public boolean isPerObject() {
				return true;
			}

			public boolean isPerSingleton() {
				return false;
			}

			public Aspect referenceType() {
				try {
					return shadowMaster().getAspectFor(
							(ClassType) base.referenceType());
				} catch (NotAnAspectException e) {
					throw new InternalDebuggerException(
							"aspect exists, but exception received", e);
				}
			}

			@Override
			public int hashCode() {
				final int PRIME = 31;
				int result = 1;
				result = PRIME * result
						+ ((owner == null) ? 0 : owner.hashCode());
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				final PerObjectInstance other = (PerObjectInstance) obj;
				if (owner == null) {
					if (other.owner != null)
						return false;
				} else if (!owner.equals(other.owner))
					return false;
				return true;
			}

		}

		// @Override
		// public List<AspectInstance> allInstances() {
		// return new InterList<com.sun.jdi.ObjectReference,
		// AspectInstance>(base
		// .instances(Integer.MAX_VALUE), getConvert());
		// }

		public AspectInstance getInstance(ThreadReference thread) {
			throw new UnsupportedOperationException();
		}

		private ValueCache<ObjectReference, AspectInstance> ownerToInstance = new ValueCache<ObjectReference, AspectInstance>();

		@Override
		public AspectInstance getInstanceFor(ThreadReference thread,
				ObjectReference object)
				throws IncompatibleThreadStateException,
				AspectInitialisationException {
			AspectInstance out = ownerToInstance.get(object);
			if (out == null) {
				out = shadowMaster().getInstanceFor(thread,
						PerObjectAspect.this, object);
				ownerToInstance.put(object, out);
			}
			return out;
		}

		public AspectInstance wrap(com.sun.jdi.ObjectReference ref) {
			ObjectReference owner = shadowMaster().getOwnerFor(this, ref);
			AspectInstance inst = ownerToInstance.get(owner);
			if (inst != null)
				return inst;
			inst = shadowMaster().createPreObjectInstanceFor(
					PerObjectAspect.this, ref, owner);
			ownerToInstance.put(owner, inst);
			return inst;
		}

		// private final Converter<com.sun.jdi.ObjectReference, AspectInstance>
		// converter = new Converter<com.sun.jdi.ObjectReference,
		// AspectInstance>() {
		//
		// public AspectInstance convert(com.sun.jdi.ObjectReference object) {
		// return getShadowMaster().getInstanceForObject(PerObjectAspect.this,
		// object);
		// }
		// };
		//
		// private Converter<com.sun.jdi.ObjectReference, AspectInstance>
		// getConvert() {
		// return converter;
		// }

		@Override
		public int getPer() {
			return ClassBasedAspectImpl.PER_OBJECT;
		}

		@Override
		public boolean isPerObject() {
			return true;
		}

		@Override
		public boolean isPerSingleton() {
			return false;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (!(obj instanceof PerObjectAspect))
				return false;
			return true;
		}

	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ClassBasedAspectImpl))
			return false;
		final ClassBasedAspectImpl other = (ClassBasedAspectImpl) obj;
		if (advices == null) {
			if (other.advices != null)
				return false;
		} else if (!advices.equals(other.advices))
			return false;
		return true;
	}
	
	@Override
	public Method concreteMemberByName(String name, String signature) {
		Method m = super.concreteMemberByName(name, signature);
		if(m != null)
			return m;
		try {
			return getAdvice(name, signature);
		} catch (NoSuchAdviceException e) {
			return null;
		}
	}
}
