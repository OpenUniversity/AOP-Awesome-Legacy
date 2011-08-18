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

import java.util.List;


public interface BeforeAspectEventListener {
	
	//advice added, other than by aspect creation
	public List<ajdi.event.Event> beforeAdviceAdded(AdviceDescriptor id,com.sun.jdi.event.Event cause);
	//public void afterAdviceAdded(AdviceDescriptor add,Event cause);
	public List<ajdi.event.Event> beforeAdviceRemoved(AdviceDescriptor add, com.sun.jdi.event.Event cause);
	//public void afterAdviceRemoved(AdviceDescriptor add,Event cause);
	
	public List<ajdi.event.Event> beforeAspectCreated(String aspectName,com.sun.jdi.event.Event cause);
	//public void afterAspectCreated(String aspectName,Event cause);
	public List<ajdi.event.Event> beforeAspectRemoved(String aspectName,com.sun.jdi.event.Event cause);
	//public void afterAspectRemoved(String aspectName,Event cause);
}
