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

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class InterMap<KF,KT,VF,VT> extends AbstractMap<KT, VT> implements Map<KT, VT> {

	protected Converter<KF, KT> kconverter;
	protected Converter<VF,VT> vconverter;
	protected Map<KF,VF> source;
	private Converter<java.util.Map.Entry<KF, VF>,java.util.Map.Entry<KT, VT>> converter;
	
	public class EntryConverter implements Converter<java.util.Map.Entry<KF, VF>,java.util.Map.Entry<KT, VT>> {

		public java.util.Map.Entry<KT, VT> convert(
				java.util.Map.Entry<KF, VF> source) {
			return new ConvertEntry(source);
		}
	}
	
	public class ConvertEntry implements Entry<KT, VT> {

		private Entry<KF, VF> source;

		public ConvertEntry(Entry<KF, VF> source) {
			this.source = source;
		}

		public KT getKey() {
			return kconverter.convert(source.getKey());
		}

		public VT getValue() {
			return vconverter.convert(source.getValue());
		}

		public VT setValue(VT value) {
			throw new UnsupportedOperationException();
		}

	}

	
	public InterMap(Map<KF, VF> source, Converter<KF, KT> kconverter,
			Converter<VF, VT> vconverter) {
		super();
		this.source = source;
		this.kconverter = kconverter;
		this.vconverter = vconverter;
	}

	public void clear() {
		throw new UnsupportedOperationException();
		
	}

	public VT put(Object key, Object value) {
		throw new UnsupportedOperationException();
	}

	public void putAll(Map t) {
		throw new UnsupportedOperationException();
		
	}

	public VT remove(Object key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<java.util.Map.Entry<KT, VT>> entrySet() {
		return new InterSet<java.util.Map.Entry<KF, VF>,java.util.Map.Entry<KT, VT>>(source.entrySet(),getConverter());
	}

	private Converter<java.util.Map.Entry<KF, VF>,java.util.Map.Entry<KT, VT>> getConverter() {
		if(converter == null)
			converter = new EntryConverter();
		return converter;
	}
	

}
