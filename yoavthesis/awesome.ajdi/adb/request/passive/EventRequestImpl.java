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

import adb.ShadowImpl;
import adb.ShadowMaster;
import ajdi.request.EventRequest;

public abstract class EventRequestImpl<T extends com.sun.jdi.request.EventRequest>
		extends ShadowImpl implements EventRequest {

	public EventRequestImpl(T base, ShadowMaster master) {
		super(master);
		this.base = base;
		base.putProperty(resolutionKey, this);
	}

	public static final Object resolutionKey = new Object();

	protected T base;

	@Override
	public void addCountFilter(int count) {
		base.addCountFilter(count);
	}

	@Override
	public void disable() {
		base.disable();
	}

	@Override
	public void enable() {
		base.enable();
	}

	@Override
	public Object getProperty(Object key) {
		return base.getProperty(key);
	}

	@Override
	public boolean isEnabled() {
		return base.isEnabled();
	}

	@Override
	public void putProperty(Object key, Object value) {
		base.putProperty(key, value);
	}

	@Override
	public void setEnabled(boolean val) {
		base.setEnabled(val);
	}

	@Override
	public void setSuspendPolicy(int policy) {
		base.setSuspendPolicy(policy);
	}

	@Override
	public int suspendPolicy() {
		return base.suspendPolicy();
	}

	public T getBase() {
		return base;
	}

}
