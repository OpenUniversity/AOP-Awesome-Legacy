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
package adb.request.passive;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import adb.PinitJoinPoint;
import adb.ShadowImpl;
import adb.ShadowMaster;
import adb.event.JDIEventTransformer;
import adb.event.TransparentEventManager;
import adb.event.passive.AdviceApplicationEventImpl;
import adb.event.passive.JoinPointExitEventImpl;
import adb.event.passive.StmtJoinPointEntryEventImpl;
import adb.tools.Converter;
import adb.tools.InterList;
import ajdi.AdviceApplication;
import ajdi.InitJoinPoint;
import ajdi.JoinPoint;
import ajdi.MethodExecutionJoinPoint;
import ajdi.event.Event;
import ajdi.request.AccessWatchpointRequest;
import ajdi.request.AdviceAdditionRequest;
import ajdi.request.AdviceApplicationRequest;
import ajdi.request.AspectAdditionRequest;
import ajdi.request.BreakpointRequest;
import ajdi.request.ClassPrepareRequest;
import ajdi.request.ClassUnloadRequest;
import ajdi.request.ExceptionRequest;
import ajdi.request.JoinPointEntryRequest;
import ajdi.request.JoinPointExitRequest;
import ajdi.request.MethodEntryRequest;
import ajdi.request.MethodExitRequest;
import ajdi.request.ModificationWatchpointRequest;
import ajdi.request.StepRequest;
import ajdi.request.ThreadDeathRequest;
import ajdi.request.ThreadStartRequest;
import ajdi.request.VMDeathRequest;

import com.sun.jdi.request.EventRequest;
import com.sun.jdi.request.EventRequestManager;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class EventRequestManagerImpl extends ShadowImpl implements
		ajdi.request.EventRequestManager {

	
	private TransparentEventManager events;

	public EventRequestManagerImpl(ShadowMaster master,
			com.sun.jdi.request.EventRequestManager base,
			TransparentEventManager event) {
		super(master);
		this.base = base;
		this.events = event;
		initCtrls(master);
	}
	
	private com.sun.jdi.request.EventRequestManager base;

	public ajdi.request.ClassPrepareRequest createClassPrepareRequest() {
		return new ClassPrepareRequestImpl(base.createClassPrepareRequest(),
				shadowMaster());
	}

	public ajdi.request.ClassUnloadRequest createClassUnloadRequest() {
		return new ClassUnloadRequestImpl(base.createClassUnloadRequest(),
				shadowMaster());
	}

	public ajdi.request.ThreadStartRequest createThreadStartRequest() {
		return new ThreadStartRequestImpl(base.createThreadStartRequest(),
				shadowMaster());
	}

	public ajdi.request.ThreadDeathRequest createThreadDeathRequest() {
		return new ThreadDeathRequestImpl(base.createThreadDeathRequest(),
				shadowMaster());
	}

	public ajdi.request.ExceptionRequest createExceptionRequest(
			ajdi.ReferenceType var0, boolean var1, boolean var2) {
		return new ExceptionRequestImpl(base.createExceptionRequest(
				shadowMaster().unwrap(var0), var1, var2), shadowMaster());
	}

	public ajdi.request.MethodEntryRequest createMethodEntryRequest() {
		return new MethodEntryRequestImpl(base.createMethodEntryRequest(),
				shadowMaster());
	}

	public ajdi.request.MethodExitRequest createMethodExitRequest() {
		return new MethodExitRequestImpl(base.createMethodExitRequest(),
				shadowMaster());
	}

	public ajdi.request.StepRequest createStepRequest(
			ajdi.ThreadReference var0, int var1, int var2) {
		return new StepRequestImpl(base.createStepRequest(shadowMaster()
				.unwrap(var0), var1, var2), shadowMaster());
	}

	public ajdi.request.BreakpointRequest createBreakpointRequest(
			ajdi.Location var0) {
		return new BreakpointRequestImpl(base
				.createBreakpointRequest(shadowMaster().unwrap(var0)),
				shadowMaster());
	}

	public ajdi.request.AccessWatchpointRequest createAccessWatchpointRequest(
			ajdi.Field var0) {
		return new AccessWatchpointRequestImpl(base
				.createAccessWatchpointRequest(shadowMaster().unwrap(var0)),
				shadowMaster());
	}

	public ajdi.request.ModificationWatchpointRequest createModificationWatchpointRequest(
			ajdi.Field var0) {
		return new ModificationWatchpointRequestImpl(base
				.createModificationWatchpointRequest(shadowMaster()
						.unwrap(var0)), shadowMaster());
	}

	public ajdi.request.VMDeathRequest createVMDeathRequest() {
		return new VMDeathRequestImpl(base.createVMDeathRequest(),
				shadowMaster());
	}
	
	public void deleteEventRequest(ajdi.request.EventRequest var0) {
		if(var0 instanceof PatternedEventRequestImpl){
			((PatternedEventRequestImpl)var0).delete();
		}else
			base.deleteEventRequest(unwrap(var0));
	}

	private EventRequest unwrap(ajdi.request.EventRequest var0) {
		shadowMaster().checkMaster(var0);
		return ((EventRequestImpl) var0).getBase();
	}

	public void deleteEventRequests(
			java.util.List<? extends ajdi.request.EventRequest> var0) {
		for (ajdi.request.EventRequest event : var0) {
			deleteEventRequest(event);
		}
	}

	private Converter<ajdi.request.EventRequest, EventRequest> rc = new Converter<ajdi.request.EventRequest, EventRequest>() {

		@Override
		public EventRequest convert(ajdi.request.EventRequest source) {
			return unwrap(source);
		}

	};

	private Converter<ajdi.request.EventRequest, EventRequest> getRequestConverter() {
		return rc;
	}

	public void deleteAllBreakpoints() {
		for (BreakpointRequest req : breakpointRequests()) {
			deleteEventRequest(req);
		}
	}

	@Override
	public List<AccessWatchpointRequest> accessWatchpointRequests() {
		List<AccessWatchpointRequest> out = new LinkedList<AccessWatchpointRequest>();
		for (com.sun.jdi.request.AccessWatchpointRequest req : base
				.accessWatchpointRequests()) {
			Object val = req.getProperty(events.ignoreHandle);
			if (val == null)
				out.add((AccessWatchpointRequest) val);
		}
		return out;
	}

	@Override
	public List<BreakpointRequest> breakpointRequests() {
		List<BreakpointRequest> out = new LinkedList<BreakpointRequest>();
		for (com.sun.jdi.request.BreakpointRequest req : base
				.breakpointRequests()) {
			Object val = req.getProperty(events.ignoreHandle);
			if (val == null)
				out.add((BreakpointRequest) val);
		}
		return out;
	}

	@Override
	public List<ClassPrepareRequest> classPrepareRequests() {
		List<ClassPrepareRequest> out = new LinkedList<ClassPrepareRequest>();
		for (com.sun.jdi.request.ClassPrepareRequest req : base
				.classPrepareRequests()) {
			Object val = req.getProperty(events.ignoreHandle);
			if (val == null)
				out.add((ClassPrepareRequest) val);
		}
		return out;
	}

	@Override
	public List<ClassUnloadRequest> classUnloadRequests() {
		List<ClassUnloadRequest> out = new LinkedList<ClassUnloadRequest>();
		for (com.sun.jdi.request.ClassUnloadRequest req : base
				.classUnloadRequests()) {
			Object val = req.getProperty(events.ignoreHandle);
			if (val == null)
				out.add((ClassUnloadRequest) val);
		}
		return out;
	}

	@Override
	public List<ExceptionRequest> exceptionRequests() {
		List<ExceptionRequest> out = new LinkedList<ExceptionRequest>();
		for (com.sun.jdi.request.ExceptionRequest req : base
				.exceptionRequests()) {
			Object val = req.getProperty(events.ignoreHandle);
			if (val == null)
				out.add((ExceptionRequest) val);
		}
		return out;
	}

	@Override
	public List<MethodEntryRequest> methodEntryRequests() {
		List<MethodEntryRequest> out = new LinkedList<MethodEntryRequest>();
		for (com.sun.jdi.request.MethodEntryRequest req : base
				.methodEntryRequests()) {
			Object val = req.getProperty(events.ignoreHandle);
			if (val == null)
				out.add((MethodEntryRequest) val);
		}
		return out;
	}

	@Override
	public List<MethodExitRequest> methodExitRequests() {
		List<MethodExitRequest> out = new LinkedList<MethodExitRequest>();
		for (com.sun.jdi.request.MethodExitRequest req : base
				.methodExitRequests()) {
			Object val = req.getProperty(events.ignoreHandle);
			if (val == null)
				out.add((MethodExitRequest) val);
		}
		return out;
	}

	@Override
	public List<ModificationWatchpointRequest> modificationWatchpointRequests() {
		List<ModificationWatchpointRequest> out = new LinkedList<ModificationWatchpointRequest>();
		for (com.sun.jdi.request.ModificationWatchpointRequest req : base
				.modificationWatchpointRequests()) {
			Object val = req.getProperty(events.ignoreHandle);
			if (val == null)
				out.add((ModificationWatchpointRequest) val);
		}
		return out;
	}

	@Override
	public List<StepRequest> stepRequests() {
		List<StepRequest> out = new LinkedList<StepRequest>();
		for (com.sun.jdi.request.StepRequest req : base.stepRequests()) {
			Object val = req.getProperty(events.ignoreHandle);
			if (val == null)
				out.add((StepRequest) val);
		}
		return out;
	}

	@Override
	public List<ThreadDeathRequest> threadDeathRequests() {
		List<ThreadDeathRequest> out = new LinkedList<ThreadDeathRequest>();
		for (com.sun.jdi.request.ThreadDeathRequest req : base
				.threadDeathRequests()) {
			Object val = req.getProperty(events.ignoreHandle);
			if (val == null)
				out.add((ThreadDeathRequest) val);
		}
		return out;
	}

	@Override
	public List<ThreadStartRequest> threadStartRequests() {
		List<ThreadStartRequest> out = new LinkedList<ThreadStartRequest>();
		for (com.sun.jdi.request.ThreadStartRequest req : base
				.threadStartRequests()) {
			Object val = req.getProperty(events.ignoreHandle);
			if (val == null)
				out.add((ThreadStartRequest) val);
		}
		return out;
	}

	@Override
	public List<VMDeathRequest> vmDeathRequests() {
		List<VMDeathRequest> out = new LinkedList<VMDeathRequest>();
		for (com.sun.jdi.request.VMDeathRequest req : base.vmDeathRequests()) {
			Object val = req.getProperty(events.ignoreHandle);
			if (val == null)
				out.add((VMDeathRequest) val);
		}
		return out;
	}

	private List<JoinPointEntryRequest> jpe = new LinkedList<JoinPointEntryRequest>();

	@Override
	public JoinPointEntryRequest createJoinPointEntryRequest(JoinPoint jp) {
		shadowMaster().checkMaster(jp);

		if (!(jp instanceof MethodExecutionJoinPoint) && !(jp instanceof InitJoinPoint) && !(jp instanceof PinitJoinPoint)) {
			com.sun.jdi.Location loc = shadowMaster().unwrap(jp.location());

			com.sun.jdi.request.BreakpointRequest dpe = base
					.createBreakpointRequest(loc);

			JoinPointEntryRequest jpr = new StmtJoinPointEntryRequestImpl(dpe,
					jp, shadowMaster());
			jpe.add(jpr);

			events.setTransformer(dpe, new BpToJPE(jpr));

			return jpr;
		} else {
			com.sun.jdi.Location loc = shadowMaster().unwrap(jp.location());
			com.sun.jdi.Method meth = loc.method();

			com.sun.jdi.request.MethodEntryRequest merq = base
					.createMethodEntryRequest();

			merq.addClassFilter(meth.declaringType());

			JoinPointEntryRequest jpr = new MethodJoinPointEntryRequestImpl(
					merq, jp, shadowMaster());
			jpe.add(jpr);

			events.setTransformer(merq, new MeToJPE(jpr, meth));

			return jpr;
		}

	}

	public class BpToJPE implements JDIEventTransformer {

		private JoinPointEntryRequest jpr;

		public BpToJPE(JoinPointEntryRequest jpr) {
			this.jpr = jpr;
		}

		@Override
		public List<Event> receive(com.sun.jdi.event.Event event,
				EventRequestManager inReq) {
			com.sun.jdi.event.BreakpointEvent in = (com.sun.jdi.event.BreakpointEvent) event;
			return Collections
					.singletonList((Event) new StmtJoinPointEntryEventImpl(in,
							jpr));
		}

	}

	public class MeToJPE implements JDIEventTransformer {

		private JoinPointEntryRequest jpr;
		private com.sun.jdi.Method meth;

		public MeToJPE(JoinPointEntryRequest jpr, com.sun.jdi.Method meth) {
			this.jpr = jpr;
			this.meth = meth;
		}

		@Override
		public List<Event> receive(com.sun.jdi.event.Event event,
				EventRequestManager inReq) {
			com.sun.jdi.event.MethodEntryEvent e = (com.sun.jdi.event.MethodEntryEvent) event;
			if (!e.method().equals(meth))
				return Collections.emptyList();
			return Collections
					.singletonList((Event) new MethodJoinPointEntryEventImpl(e,
							jpr));
		}

	}

	@Override
	public List<JoinPointEntryRequest> joinPointEntryRequests() {
		return Collections.unmodifiableList(jpe);
	}

	private List<JoinPointExitRequest> jpex = new LinkedList<JoinPointExitRequest>();

	@Override
	public JoinPointExitRequest createJoinPointExitRequest(JoinPoint jp) {
		shadowMaster().checkMaster(jp);

		if (!(jp instanceof MethodExecutionJoinPoint) && !(jp instanceof InitJoinPoint) && !(jp instanceof PinitJoinPoint)) {
			com.sun.jdi.request.BreakpointRequest dpe = base
					.createBreakpointRequest(shadowMaster().unwrap(
							jp.location().endLocation()));

			JoinPointExitRequest jpr = new StmtJoinPointExitRequestImpl(dpe, jp,
					shadowMaster());
			jpex.add(jpr);

			events.setTransformer(dpe, new BpToJPEX(jpr));

			return jpr;
		} else {
			com.sun.jdi.Location loc = shadowMaster().unwrap(jp.location());
			com.sun.jdi.Method meth = loc.method();

			com.sun.jdi.request.MethodExitRequest merq = base
					.createMethodExitRequest();

			merq.addClassFilter(meth.declaringType());

			JoinPointExitRequest jpr = new MethodJoinPointExitRequestImpl(
					merq, jp, shadowMaster());
			jpex.add(jpr);

			events.setTransformer(merq, new MexToJPEX(jpr, meth));

			return jpr;
		}

	}

	public class BpToJPEX implements JDIEventTransformer {

		private JoinPointExitRequest jpr;

		public BpToJPEX(JoinPointExitRequest jpr) {
			this.jpr = jpr;
		}

		@Override
		public List<Event> receive(com.sun.jdi.event.Event event,
				EventRequestManager inReq) {
			com.sun.jdi.event.BreakpointEvent in = (com.sun.jdi.event.BreakpointEvent) event;
			return Collections
					.singletonList((Event) new JoinPointExitEventImpl(in, jpr));
		}

	}
	
	public class MexToJPEX implements JDIEventTransformer {

		private JoinPointExitRequest jpr;
		private com.sun.jdi.Method meth;

		public MexToJPEX(JoinPointExitRequest jpr, com.sun.jdi.Method meth) {
			this.jpr = jpr;
			this.meth = meth;
		}

		@Override
		public List<Event> receive(com.sun.jdi.event.Event event,
				EventRequestManager inReq) {
			com.sun.jdi.event.MethodExitEvent e = (com.sun.jdi.event.MethodExitEvent) event;
			if (!e.method().equals(meth))
				return Collections.emptyList();
			return Collections
					.singletonList((Event) new MethodJoinPointExitEventImpl(e,
							jpr));
		}

	}

	@Override
	public List<JoinPointExitRequest> joinPointExitRequests() {
		return Collections.unmodifiableList(jpex);
	}
	
	
	
	private List<AdviceApplicationRequest> aaplrq = new LinkedList<AdviceApplicationRequest>();
	
	@Override
	public AdviceApplicationRequest createAdviceApplicationRequest(AdviceApplication aapl) {
		shadowMaster().checkMaster(aapl);
		
		com.sun.jdi.request.MethodEntryRequest merq = base.createMethodEntryRequest();
		merq.addClassFilter(aapl.getAspectClassName());
		
		AdviceApplicationRequest aaplrq = new AdviceApplicationRequestImpl(merq,aapl);
		
		events.setTransformer(merq, new MexToAAPL(aapl));
		
		this.aaplrq.add(aaplrq);
		
		return aaplrq;
	}
	
	public class MexToAAPL implements JDIEventTransformer {

		private AdviceApplication aapl;

		public MexToAAPL(AdviceApplication aapl) {
			this.aapl = aapl;
		}

		@Override
		public List<Event> receive(com.sun.jdi.event.Event event, EventRequestManager inReq) {
			com.sun.jdi.event.MethodEntryEvent mee = (com.sun.jdi.event.MethodEntryEvent)event;
			if(mee.method().equals(shadowMaster().unwrap(aapl.advice()))){
				Stack<adb.event.state.JoinPoint> state = shadowMaster().state.getStateFor(shadowMaster().wrap(mee.thread()));
				adb.event.state.JoinPoint jp = state.peek();
				if(jp.jpd.equals(aapl.joinPoint()))
					return Collections.<Event>singletonList(new AdviceApplicationEventImpl(mee,shadowMaster()));
			}
			return Collections.emptyList();
		}

	}

	@Override
	public List<AdviceApplicationRequest> getAdviceApplicationRequests() {
		return Collections.unmodifiableList(aaplrq);
	}
	

	private void initCtrls(ShadowMaster sm){
		aarqm = new PatternedEventController<AspectAdditionRequestImpl>(sm);
		arrqm = new PatternedEventController<AspectRemovalRequestImpl>(sm);
		adarqm = new PatternedEventController<AdviceAdditionRequestImpl>(sm);
		adrrqm = new PatternedEventController<AdviceRemovalRequestImpl>(sm);
		barqm = new PatternedEventController<BindingAdditionRequestImpl>(sm);
		brrqm = new PatternedEventController<BindingRemovalRequestImpl>(sm);
	}
	
	public PatternedEventController<AspectAdditionRequestImpl> aarqm;
	@Override
	public ajdi.request.AspectAdditionRequest createAspectAdditionRequest(){
		return new AspectAdditionRequestImpl(aarqm);
	}
	@Override
	public List<ajdi.request.AspectAdditionRequest> getAspectAdditionRequests(){
		return (List<ajdi.request.AspectAdditionRequest>)(Object)Collections.unmodifiableList(aarqm.all);
	}
	
	public PatternedEventController<AspectRemovalRequestImpl> arrqm;
	@Override
	public ajdi.request.AspectRemovalRequest createAspectRemovalRequest(){
		return new AspectRemovalRequestImpl(arrqm);
	}
	@Override
	public List<ajdi.request.AspectAdditionRequest> getAspectRemovalRequests(){
		return (List<ajdi.request.AspectAdditionRequest>)(Object)Collections.unmodifiableList(arrqm.all);
	}
	

	public PatternedEventController<AdviceAdditionRequestImpl> adarqm;
	@Override
	public ajdi.request.AdviceAdditionRequest createAdviceAdditionRequest(){
		return new AdviceAdditionRequestImpl(adarqm);
	}
	@Override
	public List<ajdi.request.AdviceAdditionRequest> getAdviceAdditionRequests(){
		return (List<ajdi.request.AdviceAdditionRequest>)(Object)Collections.unmodifiableList(adarqm.all);
	}
	
	public PatternedEventController<AdviceRemovalRequestImpl> adrrqm;
	@Override
	public ajdi.request.AdviceRemovalRequest createAdviceRemovalRequest(){
		return new AdviceRemovalRequestImpl(adrrqm);
	}
	@Override
	public List<ajdi.request.AdviceAdditionRequest> getAdviceRemovalRequests(){
		return (List<ajdi.request.AdviceAdditionRequest>)(Object)Collections.unmodifiableList(adrrqm.all);
	}
	
	
	public PatternedEventController<BindingAdditionRequestImpl> barqm;
	@Override
	public ajdi.request.BindingAdditionRequest createBindingAdditionRequest(){
		return new BindingAdditionRequestImpl(barqm);
	}
	@Override
	public List<ajdi.request.BindingAdditionRequest> getBindingAdditionRequests(){
		return (List<ajdi.request.BindingAdditionRequest>)(Object)Collections.unmodifiableList(barqm.all);
	}
	
	public PatternedEventController<BindingRemovalRequestImpl> brrqm;
	@Override
	public ajdi.request.BindingRemovalRequest createBindingRemovalRequest(){
		return new BindingRemovalRequestImpl(brrqm);
	}
	@Override
	public List<ajdi.request.BindingRemovalRequest> getBindingRemovalRequests(){
		return (List<ajdi.request.BindingRemovalRequest>)(Object)Collections.unmodifiableList(brrqm.all);
	}


}
