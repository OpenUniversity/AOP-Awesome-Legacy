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

import adb.ShadowMaster;
import ajdi.JoinPoint;
import ajdi.ObjectReference;
import ajdi.ThreadReference;
import ajdi.request.JoinPointEntryRequest;

import com.sun.jdi.request.MethodEntryRequest;

public class MethodJoinPointEntryRequestImpl extends EventRequestImpl<com.sun.jdi.request.MethodEntryRequest>
		implements JoinPointEntryRequest {

	private JoinPoint jp;

	public MethodJoinPointEntryRequestImpl(MethodEntryRequest merq,
			JoinPoint jp, ShadowMaster shadowMaster) {
		super(merq,shadowMaster);
		this.jp = jp;
	}

	@Override
	public void addInstanceFilter(ObjectReference instance) {
		getBase().addInstanceFilter(shadowMaster().unwrap(instance));
	}

	@Override
	public void addThreadFilter(ThreadReference thread) {
		getBase().addThreadFilter(shadowMaster().unwrap(thread));
	}

	@Override
	public JoinPoint joinPoint() {
		return jp;
	}



}
