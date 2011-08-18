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

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

import com.sun.tools.javac.util.Convert;

public class InterCollection<F,T> extends AbstractCollection<T> implements Collection<T>{

	final protected Collection<F> source;
	final protected Converter<F,T> converter;
	

	public InterCollection(Collection<F> source, Converter<F, T> converter) {
		super();
		this.source = source;
		this.converter = converter;
	}
	
	public boolean remove(Object o){
		throw new UnsupportedOperationException();
	}
	
	public boolean addAll(Collection<? extends T> c){
		throw new UnsupportedOperationException();
	}
	
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}
	
	public boolean retainAll(Collection<?> c){
		throw new UnsupportedOperationException();
	}
	
	public void clear() {
		throw new UnsupportedOperationException();
	}
	
	
	@Override
	public Iterator<T> iterator() {
		return new ConverterIterator<F, T>(source,converter);
	}

	@Override
	public int size() {
		return source.size();
	}


}
