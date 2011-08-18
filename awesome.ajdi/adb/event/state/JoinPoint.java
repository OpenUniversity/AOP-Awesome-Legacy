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
package adb.event.state;

import java.util.LinkedList;
import java.util.List;

import adb.AdviceImpl;
import adb.JoinPointImpl;
import adb.tools.Pair;
import ajdi.Advice;
import ajdi.AspectInstance;

public class JoinPoint {

	//public final int high;
	public final ajdi.JoinPoint jpd;

	/**
	 * advice that were entered
	 */
	public List<Pair<Advice, AspectInstance>> advs = new LinkedList<Pair<Advice, AspectInstance>>();
	
	/**
	 * exec is complete
	 */
	public boolean complete = false;

	/**
	 * proceed has been entered
	 */
	public boolean hit;
	
	public JoinPoint(ajdi.JoinPoint jpd) {
		super();
		this.jpd = jpd;
		//this.high = high;
	}

	public boolean validate() {
		try {

			for (int i = 0, j = 0; i < advs.size(); i++) {
				Advice adv = advs.get(i).getFirst();
				boolean match = false;
				j=0; // scan jpd advice from the beginning
				do {
					Advice cadv = jpd.advices().get(j).advice();
					match = cadv.equals(adv);
					j++;
				} while (!match);
			}
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}

	}

	public void target() {
		hit = true;
	}
}
