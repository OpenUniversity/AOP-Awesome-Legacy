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

import java.util.Collections;
import java.util.List;

import adb.ShadowMaster;
import adb.backend.StackFilterManager;
import adb.tools.InterList;
import ajdi.StackFrame;

public class NullStackFrameFilter implements StackFilterManager {

	private ShadowMaster master;

	public List<StackFrame> filterFrames(List<com.sun.jdi.StackFrame> frames) {
		if(frames.isEmpty())
			return Collections.emptyList();
		return new InterList<com.sun.jdi.StackFrame, StackFrame>(frames,master.getFrameConverter());
	}

	public void setShadowMaster(ShadowMaster shadowMaster) {
		this.master = shadowMaster;
	}

}
