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

import java.util.List;

import adb.tools.InterList;
import ajdi.ThreadGroupReference;
import ajdi.ThreadReference;

public class ThreadGroupReferenceImpl extends AbstractObjectReference<com.sun.jdi.ThreadGroupReference> implements
		ThreadGroupReference {

	public ThreadGroupReferenceImpl(com.sun.jdi.ThreadGroupReference base,
			ShadowMaster master) {
		super(base, master);
	}

	public String name() {
		return base.name();
	}

	public ThreadGroupReference parent() {
		return shadowMaster().wrap(base.parent());
	}

	public void resume() {
		base.resume();
	}

	public void suspend() {
		base.suspend();
	}

	public List<ThreadGroupReference> threadGroups() {
		return new InterList<com.sun.jdi.ThreadGroupReference, ThreadGroupReference>(base.threadGroups(),shadowMaster().getThreadGroupConverter());
	}

	public List<ThreadReference> threads() {
		return new InterList<com.sun.jdi.ThreadReference, ThreadReference>(base.threads(),shadowMaster().getThreadConverter());
	}
}