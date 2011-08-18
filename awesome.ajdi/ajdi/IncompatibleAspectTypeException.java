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

public class IncompatibleAspectTypeException extends Exception {
	
	private int is;
	private int shouldBe;

	public IncompatibleAspectTypeException(int is,int shouldBe){
		this.is = is;
		this.shouldBe = shouldBe;
	}
	
	public String toString(){
		return "expected: " + getPer(shouldBe) + "but got " + getPer(is); 
	}

	private String getPer(int code) {
		switch(code){
			case Aspect.PER_OBJECT: return "Per Object";
			case Aspect.PER_SINGLETON: return "Singleton";
			default: return ""+code;
		}
	}

}
