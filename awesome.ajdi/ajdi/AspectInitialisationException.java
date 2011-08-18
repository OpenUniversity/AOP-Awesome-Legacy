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
package ajdi;

import com.sun.jdi.ObjectReference;

public class AspectInitialisationException extends Exception {

	static final long serialVersionUID = 51656621865612346L;
	private ObjectReference exception;

	public AspectInitialisationException(ObjectReference reference) {
		super("Aspect could not be initialised: " + reference.toString());
		this.exception = reference;
	}

	public ObjectReference getException(){
		return exception;
	}
}
