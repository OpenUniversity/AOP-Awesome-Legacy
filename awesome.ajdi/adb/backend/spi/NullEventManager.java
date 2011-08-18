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
package adb.backend.spi;

import com.sun.jdi.request.EventRequestManager;

import adb.ShadowMaster;
import adb.backend.AfterAspectEventListener;
import adb.backend.BeforeAspectEventListener;
import adb.backend.AfterBindingEventListener;
import adb.backend.BeforeBindingEventListener;
import adb.backend.EventManager;

public class NullEventManager implements EventManager {

	@Override
	public void init() {
	}

	@Override
	public void setEventBaseRequestManager(EventRequestManager manager) {
	}

	@Override
	public void setEventManager(adb.event.EventManager manager) {
	}

	@Override
	public void setEventRequestManager(ajdi.request.EventRequestManager manager) {
	}

	@Override
	public void setShadowMaster(ShadowMaster master) {
	}

	@Override
	public void setAfterAspectEventListener(AfterAspectEventListener list) {
	}

	@Override
	public void setAfterBindingListener(AfterBindingEventListener list) {
	}

	@Override
	public void setBeforeAspectEventListener(BeforeAspectEventListener list) {
	}

	@Override
	public void setBeforeBindingListener(BeforeBindingEventListener list) {
	}

	@Override
	public void setHaltVmOnEntry(boolean halt) {
	}

}
