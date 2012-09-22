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

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class InterList<F,T> extends AbstractList<T> implements List<T>{

	protected List<F> source;
	private Converter<F, T> converter;
	
	public InterList(List<F> source, Converter<F, T> converter) {
		this.converter = converter;
		this.source =source;
	}


	public boolean add(T o) {
		throw new UnsupportedOperationException();
	}

	public void add(int index, T element) {
		throw new UnsupportedOperationException();
		
	}

	public boolean addAll(int index, Collection<? extends T> c) {
		throw new UnsupportedOperationException();
	}

	public T get(int index) {
		return converter.convert(source.get(index));
	}


	public ListIterator<T> listIterator() {
		return new ConvertListIterator<F, T>(source,converter);
	}

	public ListIterator<T> listIterator(int index) {
		return new ConvertListIterator<F, T>(source,converter,index);
	}

	public T remove(int index) {
		throw new UnsupportedOperationException();
	}

	public T set(int index, T element) {
		throw new UnsupportedOperationException();
	}

	public List<T> subList(int fromIndex, int toIndex) {
		return new InterList<F, T>(source.subList(fromIndex, toIndex),converter);
	}


	@Override
	public int size() {
		return source.size();
	}

	
}
