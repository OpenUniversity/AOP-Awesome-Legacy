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

import java.util.List;

public interface Binding extends SourceLocatable {
	
	public static final String DEFAULT_NAME = "default";
	
	public Pointcut pointcut();
	
	public List<AdviceApplication> allApplications();
	
	public String name();

	/**
	 * @return a list of all currently loaded advice bound by this binding
	 */
	public List<Advice> advices();
	
	/**
	 * @return a list of the descriptors of all advice bound by this binding
	 * 
	 *   the format is 
	 *   
	 *   Aspect.Advice:Signature
	 *   
	 *   and signature is the method signature of the implementing method
	 */
	//TODO signatures opkuisen
	public List<String> adviceDesciptors();
	
}
