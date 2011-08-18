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

import ajdi.Advice;
import ajdi.AdviceApplication;
import ajdi.Binding;
import ajdi.Pointcut;
import ajdi.SourceLocation;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.VirtualMachine;

public class BindingImpl implements Binding {

	private Pointcut pointcut;
	private LineRange range;
	private VirtualMachine vm;
	private ShadowMaster master;
	private String name;
	protected List<Advice> advice;
	protected List<String> adviceDesc;

	public BindingImpl(VirtualMachine vm, ShadowMaster master, Pointcut pointcut, String name,LineRange lineRange) {
		this.pointcut = pointcut;
		this.range = lineRange;
		this.vm = vm;
		this.master = master;
		this.name = name;
	}
	
	public void setAdvice(Advice advice) {
		if(this.advice != null)
			throw new InternalDebuggerException("setadvice called twice on unmanaged ,... this seems to be a managed advice");
		this.advice = Collections.singletonList(advice);
		String sig = ((AdviceImpl)advice).getBaseSig();
		this.adviceDesc = Collections.singletonList(advice.declaringType()+"." + advice.name() + ":" +sig );
	}

	public Pointcut pointcut() {
		return pointcut;
	}

	public SourceLocation location() throws AbsentInformationException {
		if(range==null)
			throw new AbsentInformationException();
		return range;
	}

	public ShadowMaster shadowMaster() {
		return master;
	}

	public VirtualMachine virtualMachine() {
		return vm;
	}

	public String name() {
		return name;
	}

	public List<Advice> advices() {
		return Collections.unmodifiableList(advice);
	}

	public List<String> adviceDesciptors() {
		return Collections.unmodifiableList(adviceDesc);
	}

	@Override
	public List<AdviceApplication> allApplications() {
		List<AdviceApplication> out = new LinkedList<AdviceApplication>();
		for(Advice advice:advices()){
			for(AdviceApplication aapl:advice.allApplications()){
				if(aapl.binding().equals(this))
					out.add(aapl);
			}
		}
		return out;
	}

}
