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
package adb.backend;

import adb.ShadowMaster;
import adb.event.JDIEventTransformer;

public interface EventManager extends InfoProvider{

	public void setEventBaseRequestManager(com.sun.jdi.request.EventRequestManager manager);
	
	public void setEventRequestManager(ajdi.request.EventRequestManager manager);
	
	public void setEventManager(adb.event.EventManager manager);
	
	public void setShadowMaster(ShadowMaster master);
	
	/**
	 * called after the setters
	 */
	public void init();	
	
	
	/**
	 * add a listener that will be notified of creation and destruction of an aspect in any way other than class loading or unloading. 
	 * 
	 * @param list the listener
	 */
	public void setHaltVmOnEntry(boolean halt);
	
	
	public void setBeforeAspectEventListener(BeforeAspectEventListener list);
	public void setAfterAspectEventListener(AfterAspectEventListener list);
	
	public void setBeforeBindingListener(BeforeBindingEventListener list);
	public void setAfterBindingListener(AfterBindingEventListener list);
	
	
		
}
