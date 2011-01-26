/*******************************************************************************
 * Copyright (c) 2005 Contributors.
 * All rights reserved.
 * This program and the accompanying materials are made available
 * under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution and is available at
 * http://eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alexandre Vasseur         initial implementation
 *******************************************************************************/
package org.aspectj.weaver.loadtime.definition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A POJO that contains raw strings from the XML (sort of XMLBean for our simple LTW DTD)
 * 
 * @author <a href="mailto:alex AT gnilux DOT com">Alexandre Vasseur</a>
 */
public class Definition {

	private final StringBuffer m_weaverOptions;

	private final List m_dumpPatterns;

	private boolean m_dumpBefore;

	private boolean perClassloaderDumpDir;

	private final List m_includePatterns;

	private final List m_excludePatterns;

	private final List m_aspectClassNames;

	private final List m_aspectExcludePatterns;

	private final List m_aspectIncludePatterns;

	private final List m_concreteAspects;

	/**
	 * When aspects are defined, they can specify a scope type pattern and then will only apply to types matching that pattern.
	 */
	private final Map scopedAspects;

	public Definition() {
		m_weaverOptions = new StringBuffer();
		m_dumpBefore = false;
		perClassloaderDumpDir = false;
		m_dumpPatterns = new ArrayList(0);
		m_includePatterns = new ArrayList(0);
		m_excludePatterns = new ArrayList(0);
		m_aspectClassNames = new ArrayList();
		m_aspectExcludePatterns = new ArrayList(0);
		m_aspectIncludePatterns = new ArrayList(0);
		m_concreteAspects = new ArrayList(0);
		scopedAspects = new HashMap();
	}

	public String getWeaverOptions() {
		return m_weaverOptions.toString();
	}

	public List getDumpPatterns() {
		return m_dumpPatterns;
	}

	public void setDumpBefore(boolean b) {
		m_dumpBefore = b;
	}

	public boolean shouldDumpBefore() {
		return m_dumpBefore;
	}

	public void setCreateDumpDirPerClassloader(boolean b) {
		perClassloaderDumpDir = b;
	}

	public boolean createDumpDirPerClassloader() {
		return perClassloaderDumpDir;
	}

	public List getIncludePatterns() {
		return m_includePatterns;
	}

	public List getExcludePatterns() {
		return m_excludePatterns;
	}

	public List getAspectClassNames() {
		return m_aspectClassNames;
	}

	public List getAspectExcludePatterns() {
		return m_aspectExcludePatterns;
	}

	public List getAspectIncludePatterns() {
		return m_aspectIncludePatterns;
	}

	public List getConcreteAspects() {
		return m_concreteAspects;
	}

	public static class ConcreteAspect {
		public final String name;
		public final String extend;
		public final String precedence;
		public final List pointcuts;
		public final String perclause;

		public ConcreteAspect(String name, String extend) {
			this(name, extend, null, null);
		}

		public ConcreteAspect(String name, String extend, String precedence, String perclause) {
			this.name = name;
			// make sure extend set to null if ""
			if (extend == null || extend.length() == 0) {
				this.extend = null;
				if (precedence == null || precedence.length() == 0) {
					throw new RuntimeException("Not allowed");
				}
			} else {
				this.extend = extend;
			}
			this.precedence = precedence;
			this.pointcuts = new ArrayList();
			this.perclause = perclause;
		}
	}

	public static class Pointcut {
		public final String name;
		public final String expression;

		public Pointcut(String name, String expression) {
			this.name = name;
			this.expression = expression;
		}
	}

	public void appendWeaverOptions(String option) {
		m_weaverOptions.append(option.trim()).append(' ');
	}

	public void addScopedAspect(String name, String scopePattern) {
		scopedAspects.put(name, scopePattern);
	}

	public String getScopeForAspect(String name) {
		return (String) scopedAspects.get(name);
	}

}
