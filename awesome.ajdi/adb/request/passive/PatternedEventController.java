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

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import adb.ShadowMaster;
import adb.tools.PatternStore;
import adb.tools.SimplePatternStore;

public class PatternedEventController<T extends PatternedEventRequestImpl<T>> {
	
	
	
	public PatternedEventController(ShadowMaster master) {
		super();
		this.master = master;
	}

	public PatternStore<PatternedEventRequestImpl<T>> store = new SimplePatternStore<PatternedEventRequestImpl<T>>();
	public List<PatternedEventRequestImpl<T>> counters = new LinkedList<PatternedEventRequestImpl<T>>() ;
	public ShadowMaster master;
	public int now;
	public List<PatternedEventRequestImpl<T>> all = new LinkedList<PatternedEventRequestImpl<T>>();

	public synchronized List<PatternedEventRequestImpl<T>> fire(String prm){
		now++;
		fireTimed();
		return store.match(prm);
	}
	
	private void fireTimed() {
		while(counters.size() > 0){
			PatternedEventRequestImpl<T> item = counters.get(0);
			if(item.getEndTime() <= now)
				item.file();
			else
				return;
		}
	}

	public synchronized void fileTimed(PatternedEventRequestImpl<T> item){
		int idx =  Collections.binarySearch(counters, item,new Comparator<PatternedEventRequestImpl<T>>(){

			@Override
			public int compare(PatternedEventRequestImpl<T> o1, PatternedEventRequestImpl<T> o2) {
				return o1.getEndTime()-o2.getEndTime();
			}});
		if(idx < 0)
			idx = -(idx) + 1;
	
		counters.add(idx, item);			
	}

	
	
}
