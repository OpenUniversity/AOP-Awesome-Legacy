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

import static adb.backend.spi.AbstractFilterManager.mergeRemove;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import com.sun.jdi.Field;
import com.sun.jdi.Method;

import adb.ShadowMaster;
import adb.backend.FilterManager;

public abstract class AbstractFilterManager implements FilterManager {

	protected ShadowMaster master;

	public abstract Field filterField(Field field);

	public List<Field> filterFields(List<Field> fields) {
		List<Field> remove = new LinkedList<Field>();
		for (Field field : fields) {
			if (filterField(field) == null)
				remove.add(field);
		}

		if (remove.isEmpty())
			return fields;
		return mergeRemove(fields, remove);
	}

	public List<Method> filterMethods(List<Method> methods) {
		List<Method> remove = new LinkedList<Method>();
		for (Method method : methods) {
			if (filterMethod(method) == null)
				remove.add(method);
		}

		if (remove.isEmpty())
			return methods;
		return mergeRemove(methods, remove);
	}

	public abstract Method filterMethod(Method method);

	public void setShadowMaster(ShadowMaster shadowMaster){
		this.master = shadowMaster;
	}

	/**
	 * @param <T>
	 * @param orig
	 *            :original list
	 * @param remove
	 *            :items to be removed, in the order off occurrence; all items
	 *            are present
	 * @return
	 */
	protected static <T> List<T> mergeRemove(List<T> orig, List<T> remove) {
		int size = orig.size() - remove.size();

		ArrayList<T> out = new ArrayList<T>(size);

		if (size == 0)
			return out;

		Iterator<T> in = orig.iterator();
		Iterator<T> rem = remove.iterator();

		T rmc = rem.next();

		try {
			while (true) {
				T c = in.next();
				if (rmc == c) {
					rmc = rem.next();
				} else {
					out.add(c);
				}
			}
		} catch (NoSuchElementException e) {
			// break loop
		}

		while (in.hasNext()) {
			T c = in.next();
			out.add(c);
		}

		return out;
	}

}
