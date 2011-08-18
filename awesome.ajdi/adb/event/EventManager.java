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
package adb.event;

import com.sun.jdi.ThreadReference;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.request.EventRequest;

public interface EventManager {
	
	public EventRequest getVMStartEvent();
	
	/**
	 * set the internal event transformer as transformer and remove the standard transformer
	 */
	public void setTransformer(ajdi.request.EventRequest req, AJDIEventTransformer trans);

	/**
	 * set the event transformer as transformer and remove the standard transformer
	 */
	public void setTransformer(EventRequest req, JDIEventTransformer trans);
	
	public void setActor(ajdi.request.EventRequest req, AJDIEventActor trans);
	
	public void setActor(com.sun.jdi.request.EventRequest req, JDIEventActor trans);
	
	//thread for currently proccessing events 
	public ThreadReference getCurrentThread();
}
