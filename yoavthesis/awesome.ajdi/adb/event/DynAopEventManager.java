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
package adb.event;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import adb.AspectImpl;
import adb.InternalDebuggerException;
import adb.NotAnAspectException;
import adb.backend.AdviceDescriptor;
import adb.backend.BeforeAspectEventListener;
import adb.backend.BeforeBindingEventListener;
import adb.backend.BindingDescriptor;
import adb.backend.NoSuchAdviceException;
import adb.event.passive.AdviceAdditionEventImpl;
import adb.event.passive.AdviceRemovalEventImpl;
import adb.event.passive.AspectAdditionEventImpl;
import adb.event.passive.AspectRemovalEventImpl;
import adb.event.passive.BindingAdditionEventImpl;
import adb.event.passive.BindingRemovalEventImpl;
import adb.request.passive.AdviceAdditionRequestImpl;
import adb.request.passive.AdviceRemovalRequestImpl;
import adb.request.passive.AspectAdditionRequestImpl;
import adb.request.passive.AspectRemovalRequestImpl;
import adb.request.passive.BindingAdditionRequestImpl;
import adb.request.passive.BindingRemovalRequestImpl;
import adb.request.passive.EventRequestManagerImpl;
import adb.request.passive.PatternedEventRequestImpl;
import ajdi.Advice;
import ajdi.Aspect;
import ajdi.event.Event;

import com.sun.jdi.ClassNotPreparedException;
import com.sun.jdi.event.LocatableEvent;

public class DynAopEventManager implements BeforeAspectEventListener, BeforeBindingEventListener {

	private EventRequestManagerImpl req;

	public DynAopEventManager(EventRequestManagerImpl req) {
		this.req = req;
	}

	@Override
	public List<Event> beforeAdviceAdded(AdviceDescriptor id, com.sun.jdi.event.Event cause) {
		LinkedList<Event> out = new LinkedList<Event>();
		List<PatternedEventRequestImpl<AdviceAdditionRequestImpl>> aarqs = req.adarqm.fire(id.getAspect());
		try {
			Aspect aspect = req.shadowMaster().getAspectByName(id.getAspect());

			for (PatternedEventRequestImpl<AdviceAdditionRequestImpl> aarq : aarqs) {

				out.add(new AdviceAdditionEventImpl(aarq, aspect, id.getContainer().getMethodname(), id.getContainer()
						.getMethodsig(), (LocatableEvent) cause));

			}

		} catch (ClassNotPreparedException e) {
			throw new InternalDebuggerException("unexpected: aspect gets advices, but is not loaded");
		} catch (NotAnAspectException e) {
			throw new InternalDebuggerException("should not occur: aspect gets advices, but doesn't exist");
		}

		return out;
	}

	@Override
	public List<Event> beforeAdviceRemoved(AdviceDescriptor add, com.sun.jdi.event.Event cause) {
		LinkedList<Event> out = new LinkedList<Event>();
		List<PatternedEventRequestImpl<AdviceRemovalRequestImpl>> aarqs = req.adrrqm.fire(add.getAspect());
		try {
			AspectImpl aspect = req.shadowMaster().getAspectByName(add.getAspect());
			Advice adv = aspect.getAdvice(add.getContainer().getMethodname(), add.getContainer().getMethodsig());
			for (PatternedEventRequestImpl<AdviceRemovalRequestImpl> aarq : aarqs) {
				out.add(new AdviceRemovalEventImpl(aarq, adv, (LocatableEvent) cause));
			}

		} catch (ClassNotPreparedException e) {
			throw new InternalDebuggerException("unexpected: aspect gets advices, but is not loaded");
		} catch (NoSuchAdviceException e) {
			throw new InternalDebuggerException("should not occur: advices removed, but advice doesn't exist");
		} catch (NotAnAspectException e) {
			throw new InternalDebuggerException("should not occur: advices removed, but aspect doesn't exist");
		}

		return out;
	}

	@Override
	public List<Event> beforeAspectCreated(String aspectName, com.sun.jdi.event.Event cause) {
		LinkedList<Event> out = new LinkedList<Event>();
		List<PatternedEventRequestImpl<AspectAdditionRequestImpl>> aarqs = req.aarqm.fire(aspectName);

		for (PatternedEventRequestImpl<AspectAdditionRequestImpl> aarq : aarqs) {
			out.add(new AspectAdditionEventImpl(aarq, aspectName, (LocatableEvent) cause));
		}

		return out;
	}

	@Override
	public List<Event> beforeAspectRemoved(String aspectName, com.sun.jdi.event.Event cause) {
		LinkedList<Event> out = new LinkedList<Event>();
		List<PatternedEventRequestImpl<AspectRemovalRequestImpl>> aarqs = req.arrqm.fire(aspectName);

		if (aarqs.isEmpty())
			return out;

		try {
			Aspect aspect = req.shadowMaster().getAspectByName(aspectName);
			for (PatternedEventRequestImpl<AspectRemovalRequestImpl> aarq : aarqs) {
				out.add(new AspectRemovalEventImpl(aarq, aspect, (LocatableEvent) cause));
			}
			return out;
		} catch (ClassNotPreparedException e) {
			throw new InternalDebuggerException("aspect not found while being removed", e);
		} catch (NotAnAspectException e) {
			throw new InternalDebuggerException("aspect not found while being removed", e);
		}

	}

	@Override
	public List<Event> beforeBindingAdded(BindingDescriptor bind, com.sun.jdi.event.Event cause) {
		LinkedList<Event> out = new LinkedList<Event>();
		List<PatternedEventRequestImpl<BindingAdditionRequestImpl>> aarqs = req.barqm.fire(bind.getName());

		for (PatternedEventRequestImpl<BindingAdditionRequestImpl> aarq : aarqs) {
			out.add(new BindingAdditionEventImpl(aarq, bind.getName(), bind.getAdvices(), bind.getPointcut(),
					(LocatableEvent) cause));
		}

		return out;
	}

	@Override
	public List<Event> beforebindingRemoved(BindingDescriptor bind, com.sun.jdi.event.Event cause) {
		LinkedList<Event> out = new LinkedList<Event>();
		List<PatternedEventRequestImpl<BindingRemovalRequestImpl>> aarqs = req.brrqm.fire(bind.getName());

		for (PatternedEventRequestImpl<BindingRemovalRequestImpl> aarq : aarqs) {
			try {
				out.add(new BindingRemovalEventImpl(aarq, req.shadowMaster().findBinding(bind),
						(LocatableEvent) cause));
			} catch (ClassNotPreparedException e) {
				throw new InternalDebuggerException("class not prepared, binding beeing removed",e);
			} catch (NoSuchAdviceException e) {
				throw new InternalDebuggerException("advice not found, binding beeing removed",e);
			}
		}

		return out;
	}

}
