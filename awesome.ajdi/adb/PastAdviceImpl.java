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
import java.util.List;

import ajdi.Advice;
import ajdi.AdviceApplication;
import ajdi.AspectInstance;
import ajdi.Binding;
import ajdi.PastAdvice;
import ajdi.StackFrame;
import ajdi.Value;

public class PastAdviceImpl implements PastAdvice {

	public PastAdviceImpl(AdviceApplication aapl, AspectInstance ai,
			List<Value> args, List<StackFrame> frames) {
		super();
		this.aapl = aapl;
		this.ai = ai;
		this.args = args;
		this.frames = frames;
		this.residue = true;
	}
	
	public PastAdviceImpl(AdviceApplication aapl,boolean skipped) {
		super();
		this.aapl = aapl;
		this.frames = Collections.emptyList();
		this.args = Collections.emptyList();
		this.skipped = skipped;
		this.residue = skipped;
	}

	
	private AdviceApplication aapl;
	private List<StackFrame> frames;
	private AspectInstance ai;
	private List<Value> args;
	private boolean skipped;
	private boolean residue;
	private boolean executing = false;

	@Override
	public Advice advice() {
		return adviceApplication().advice();
	}

	@Override
	public AdviceApplication adviceApplication() {
		return aapl;
	}

	@Override
	public Binding binding() {
		return adviceApplication().binding();
	}

	@Override
	public List<StackFrame> frames() {
		return frames;
	}

	@Override
	public AspectInstance getAspectInstance() {
		return ai;
	}

/*	@Override
	public List<Value> getBoundArguments() {
		return args;
	}*/

	@Override
	public boolean isSkipped() {
		return skipped;
	}

	@Override
	public boolean residue() {
		return residue;
	}

	@Override
	public boolean isExecuting() {
		return executing;
	}

	public void setExecuting(){
		executing = true;
	}
	
	public String toString(){
		return advice().declaringType().name() +"." + advice().name() + (residue()?"R":"!R") + (isSkipped()?"S":""); 
	}
}
