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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import adb.ShadowMaster;
import adb.tools.Pattern;
import ajdi.request.EventRequest;
import ajdi.request.InvalidRequestStateException;

import com.sun.jdi.VirtualMachine;

public class PatternedEventRequestImpl<T extends PatternedEventRequestImpl<T>> implements Pattern, EventRequest {

	public PatternedEventRequestImpl(PatternedEventController<T> ctrl) {
		this.ctrl = ctrl;
		synchronized (ctrl) {
			ctrl.all.add(this);
		}
	}

	private PatternedEventController<T> ctrl;

	private boolean enabled = false;
	private int time = 0;
	private int count = 0;

	@Override
	public void disable() {
		synchronized (ctrl) {
			if (!enabled)
				return;
			enabled = false;

			if (!ctrl.counters.remove(this))
				ctrl.store.remove(this);
		}
	}

	@Override
	public void enable() {
		synchronized (ctrl) {
			if (enabled)
				return;
			enabled = true;

			if (count > 0) {
				time = ctrl.now + count;
				ctrl.fileTimed(this);
			} else
				file();
		}
	}

	public int getEndTime() {
		return time;
	}

	protected void file() {
		ctrl.store.add(this);
	}

	@Override
	public void addCountFilter(int count) {
		check();
		this.count = count;
	}

	protected void check() {
		if (enabled)
			throw new InvalidRequestStateException();
		if (deleted)
			throw new InvalidRequestStateException();
	}

	private int policy = EventRequest.SUSPEND_ALL;

	@Override
	public void setSuspendPolicy(int policy) {
		check();
		this.policy = policy;
	}

	@Override
	public int suspendPolicy() {
		return policy;
	}

	private HashMap<Object, Object> props = new HashMap<Object, Object>();

	@Override
	public Object getProperty(Object key) {
		return props.get(key);
	}

	@Override
	public void putProperty(Object key, Object value) {
		props.put(key, value);
	}

	protected List<String> exc = new LinkedList<String>();
	protected List<String> inc = new LinkedList<String>();

	private boolean deleted;

	@Override
	public List<String> getExclusionFilter() {
		return exc;
	}

	@Override
	public List<String> getFilter() {
		return inc;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public void setEnabled(boolean val) {
		if (val)
			enable();
		else
			disable();
	}

	@Override
	public ShadowMaster shadowMaster() {
		return ctrl.master;
	}

	@Override
	public VirtualMachine virtualMachine() {
		return shadowMaster().getVirtualMachine();
	}

	public void delete() {

		synchronized (ctrl) {
			deleted = true;
			disable();
			ctrl.all.remove(this);
		}
	}

}
