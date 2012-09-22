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
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.StackFrame;
import com.sun.jdi.VirtualMachine;
import ajdi.Advice;
import ajdi.AdviceApplication;
import ajdi.HookFrame;
import ajdi.JoinPoint;
import ajdi.LocalVariable;
import ajdi.Location;
import ajdi.ObjectReference;
import ajdi.PastAdvice;
import ajdi.ThreadReference;
import ajdi.Value;

public class HookFrameImpl implements HookFrame {

	public HookFrameImpl(ShadowMaster master, ajdi.StackFrame entry, JoinPoint jpd) {
		super();
		this.master = master;
		this.entry = entry;
		this.jpd = jpd;
		this.pas = new LinkedList<PastAdvice>();
	}

	public HookFrameImpl(ShadowMaster master, ajdi.StackFrame entry, JoinPoint jpd, List<PastAdvice> pas, boolean target) {
		super();
		this.master = master;
		this.entry = entry;
		this.jpd = jpd;
		this.pas = pas;
		this.target = target;
	}

	private ShadowMaster master;
	private com.sun.jdi.StackFrame base;
	private JoinPoint jpd;
	private List<PastAdvice> pas;
	private ajdi.StackFrame entry;

	// frame cache, lazy
	private List<ajdi.StackFrame> frames;
	private boolean target;

	public JoinPoint thisJoinPoint() {
		return jpd;
	}

	public List<Value> getArgumentValues() {
		return Collections.emptyList();
	}

	public Value getValue(LocalVariable variable) {
		throw new IllegalArgumentException("Variable not found: " + variable);
	}

	public Map<LocalVariable, Value> getValues(List<? extends LocalVariable> variables) {
		throw new IllegalArgumentException("Variables not found");
	}

	public Location location() {
		return thisJoinPoint().location();
	}

	public void setValue(LocalVariable variable, Value value) throws InvalidTypeException, ClassNotLoadedException {
		throw new IllegalArgumentException("Variables not found");
	}

	public ObjectReference thisObject() {
		if (base.thisObject() == null)
			return null;
		return entry.thisObject();
	}

	public ThreadReference thread() {
		return entry.thread();
	}

	public LocalVariable visibleVariableByName(String name) throws AbsentInformationException {
		return null;
	}

	public List<LocalVariable> visibleVariables() throws AbsentInformationException {
		return Collections.emptyList();
	}

	public ShadowMaster shadowMaster() {
		return master;
	}

	public VirtualMachine virtualMachine() {
		return shadowMaster().getVirtualMachine();
	}

	public String toString() {
		return "HOOK: " + (hasTargetExecuted() ? "!" : "") + thisJoinPoint();
	}

	@Override
	public List<ajdi.StackFrame> frames() {
		if (frames != null)
			return frames;

		frames = new LinkedList<ajdi.StackFrame>();
		for (PastAdvice pa : pastAdvices()) {
			frames.addAll(pa.frames());
		}
		frames = Collections.unmodifiableList(frames);
		return frames;
	}

	@Override
	public List<PastAdvice> pastAdvices() {
		List<PastAdvice> out = new LinkedList<PastAdvice>();
		out.addAll(pas);
		return out;
	}

	@Override
	public boolean hasExecuted(Advice advice) {
		for (PastAdvice pa : pastAdvices()) {
			if (pa.advice().equals(advice))
				return pa.residue() && !pa.isSkipped();
		}
		return false;
	}

	@Override
	public ajdi.StackFrame topFrame() {
		return frames().get(frames().size() - 1);
	}

	@Override
	public boolean hasTargetExecuted() {
		return target;
	}

	public void add(PastAdviceImpl pa) {
		pas.add(pa);
	}

	public void skip() {
		List<AdviceApplication> aapls = thisJoinPoint().advices();

		ListIterator<AdviceApplication> aaplIt = aapls.listIterator(pas.size());

		for (AdviceApplication cur = aaplIt.next(); aaplIt.hasNext(); cur = aaplIt.next()) {
			pas.add(new PastAdviceImpl(cur, true));
		}

	}

	public AdviceApplication next() {
		return thisJoinPoint().advices().get(pas.size());
	}

	/*
	 * @Override public ajdi.StackFrame entryFrame() { return entry; }
	 */

	/*
	 * @Override public ajdi.StackFrame exitFrame() { return exit; }
	 */

}
