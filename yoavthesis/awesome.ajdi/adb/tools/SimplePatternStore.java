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
package adb.tools;

import java.util.LinkedList;
import java.util.List;

public class SimplePatternStore<T extends Pattern> implements PatternStore<T> {

	private List<T> store = new LinkedList<T>(); 
	
	
	public void add(T pat) {
		store.add(pat);
	}

	public T remove(T pat) {
		if(!store.remove(pat))
			return null;
		return pat;
	}
	
	public List<T> match(String in) {
		List<T> out = new LinkedList<T>();
		main:
		for (T t : store) {
			List<String> posfs = t.getFilter();
			for (String posf : posfs) {
				if(!in.matches(posf))
					continue main;
			}
			List<String> negfs = t.getExclusionFilter();
			for (String negf : negfs) {
				if(in.matches(negf))
					continue main;
			}
			out.add(t);
		}
		return out;
	}

	
	

}
