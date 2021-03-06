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

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class InterSet<F,T> extends AbstractSet<T> implements Set<T> {


	final protected Collection<F> source;
	final protected Converter<F,T> converter;
	

	public InterSet(Set<F> source, Converter<F, T> converter) {
		super();
		this.source = source;
		this.converter = converter;
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
