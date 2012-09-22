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
/**
 * 
 */
package adb.tools;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.naming.OperationNotSupportedException;

class ConvertListIterator<F, T> implements ListIterator<T>{ 

	final protected List<F> source;
	final protected Converter<F, T> converter;
	final protected ListIterator<F> iterator;
	
	
	public ConvertListIterator(List<F> source, Converter<F, T> converter) {
		this.source = source;
		this.converter = converter;
		this.iterator = source.listIterator();
	}

	public ConvertListIterator(List<F> source, Converter<F, T> converter,
			int index) {
		this.source = source;
		this.converter = converter;
		this.iterator = source.listIterator(index);
	}

	public void add(T o) {
		throw new UnsupportedOperationException();
	}

	public boolean hasNext() {
		return iterator.hasNext();
	}

	public T next() {
		return converter.convert(iterator.next());
	}

	public boolean hasPrevious() {
		return iterator.hasPrevious();
	}

	public int nextIndex() {
		return iterator.nextIndex();
	}

	public T previous() {
		return converter.convert(iterator.previous());
	}

	public int previousIndex() {
		return iterator.previousIndex();
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	public void set(T o) {
		throw new UnsupportedOperationException();

	}



}