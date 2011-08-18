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
package adb;

import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import adb.backend.MethodIdentifier;
import adb.tools.InterList;
import ajdi.InitJoinPoint;
import ajdi.JoinPoint;
import ajdi.LocalVariable;
import ajdi.Location;
import ajdi.Method;
import ajdi.MethodExecutionJoinPoint;
import ajdi.PInitJointPoint;
import ajdi.ReferenceType;
import ajdi.SInitJointPoint;
import ajdi.SourceLocation;
import ajdi.StmtJoinPoint;
import ajdi.Type;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.VirtualMachine;

/**
 * @author wouter
 *
 * JPI loaded lazy, primary storage
 */
public class MethodImpl implements Method {
	
	public static class JoinPointInfo{
		//all StmtJoinPoint
		private List<StmtJoinPoint> sjps;
		// single and one joinpoint declared execution(...)
		// or on <clinit> a SinitJoinPoint
		private MethodExecutionJoinPoint jp;
		// if there is an initJoinpoint or a PinitJoinpoint 
		//the MethodExecutionJoinPoint is here and the inits
		private List<MethodExecutionJoinPoint> mjps = null;
		
		public JoinPointInfo(List<StmtJoinPoint> sjps, MethodExecutionJoinPoint jp) {
			super();
			this.sjps = Collections.unmodifiableList(sjps);
			this.jp = jp;
		}
		
		public JoinPointInfo(List<StmtJoinPoint> sjps, List<MethodExecutionJoinPoint> mjps,MethodExecutionJoinPoint jp) {
			this(sjps,jp);
			this.mjps = Collections.unmodifiableList(mjps);
		}
	}

	
	com.sun.jdi.Method base;
	private ShadowMaster master;
	private ReferenceType parent;
	private SoftReference<JoinPointInfo> jpi;

	com.sun.jdi.Method getBase() {
		return base;
	}

	public MethodImpl(com.sun.jdi.Method base, ReferenceType parent, ShadowMaster master) {
		super();
		this.base = base;
		this.master = master;
		this.parent = parent;
	}

	public List<Location> allLineLocations() throws AbsentInformationException {
		return new InterList<com.sun.jdi.Location, Location>(getBase().allLineLocations(),master.getLocationConverter());
	}

//	public List<Location> allLineLocations(String stratum, String sourceName)
//			throws AbsentInformationException {
//		return base.allLineLocations(stratum, sourceName);
//	}

	public List<String> argumentTypeNames() {
		return getBase().argumentTypeNames();
	}

	public List<Type> argumentTypes() throws ClassNotLoadedException {
		return new InterList<com.sun.jdi.Type, Type>(getBase().argumentTypes(),master.getTypeConverter());
	}

	public List<LocalVariable> arguments() throws AbsentInformationException {
		return new InterList<com.sun.jdi.LocalVariable, LocalVariable>(getBase().arguments(),master.getVariableConverter());
	}

//	public byte[] bytecodes() {
//		return base.bytecodes();
//	}

	public List<StmtJoinPoint> containedJoinPoints() {
		return getJPI().sjps;
	}

	public MethodExecutionJoinPoint executionJoinPoint() {
		return getJPI().jp;
	}
	
	public List<JoinPoint> allJoinPoints() {
		LinkedList<JoinPoint> out = new LinkedList<JoinPoint>();
		out.addAll(containedJoinPoints());
		out.addAll(executionJoinPoints());
		return Collections.unmodifiableList(out);
	}

	public List<MethodExecutionJoinPoint> executionJoinPoints() {
		JoinPointInfo jpi = getJPI();
		List<MethodExecutionJoinPoint> jps = jpi.mjps;
		if(jps != null)
			return jps;
		else
			if(jpi.jp != null)
				return Collections.singletonList(jpi.jp);
			else
				return Collections.emptyList();
	}

	private JoinPointInfo getJPI() {
		JoinPointInfo out;
		
		if(jpi == null){
			out = shadowMaster().getJoinPointInfoFor(this);
			jpi = new SoftReference<JoinPointInfo>(out);
		}else{
			out = jpi.get();
			if(out == null){
				out = shadowMaster().getJoinPointInfoFor(this);
				jpi = new SoftReference<JoinPointInfo>(out);
			}
		}
			
		return out;
	}

	public boolean isAbstract() {
		return getBase().isAbstract();
	}

	public boolean isBridge() {
		return getBase().isBridge();
	}

	public boolean isConstructor() {
		return getBase().isConstructor();
	}

	public boolean isNative() {
		return getBase().isNative();
	}

	public boolean isObsolete() {
		return getBase().isObsolete();
	}

	public boolean isStaticInitializer() {
		return getBase().isStaticInitializer();
	}

	public boolean isSynchronized() {
		return getBase().isSynchronized();
	}

	public boolean isVarArgs() {
		return getBase().isVarArgs();
	}

	public SourceLocation location() {
		return master.convertSourceLineLocation(getBase().location());
	}

	public Location locationOfCodeIndex(long codeIndex) {
		return master.wrap(getBase().locationOfCodeIndex(codeIndex));
	}

	public List<Location> locationsOfLine(int lineNumber)
			throws AbsentInformationException {
		return new InterList<com.sun.jdi.Location, Location>(getBase().locationsOfLine(lineNumber),master.getLocationConverter());
	}

//	public List<Location> locationsOfLine(String stratum, String sourceName,
//			int lineNumber) throws AbsentInformationException {
//		return base.locationsOfLine(stratum, sourceName, lineNumber);
//	}

	public Type returnType() throws ClassNotLoadedException {
		return master.wrap(getBase().returnType());
	}

	public String returnTypeName() {
		return getBase().returnTypeName();
	}

	public List<LocalVariable> variables() throws AbsentInformationException {
		return new InterList<com.sun.jdi.LocalVariable, LocalVariable>(getBase().variables(),master.getVariableConverter());
	}

	public List<LocalVariable> variablesByName(String name)
			throws AbsentInformationException {
		return new InterList<com.sun.jdi.LocalVariable, LocalVariable>(getBase().variablesByName(name),master.getVariableConverter());
	}

	public ReferenceType declaringType() {
		return parent;
	}

	public String genericSignature() {
		return getBase().genericSignature();
	}

	public boolean isFinal() {
		return getBase().isFinal();
	}

	public boolean isStatic() {
		return getBase().isStatic();
	}

	public boolean isSynthetic() {
		return getBase().isSynthetic();
	}

	public String name() {
		return getBase().name();
	}

	public String signature() {
		return getBase().signature();
	}

	public VirtualMachine virtualMachine() {
		return getBase().virtualMachine();
	}

	public boolean isPackagePrivate() {
		return getBase().isPackagePrivate();
	}

	public boolean isPrivate() {
		return getBase().isPrivate();
	}

	public boolean isProtected() {
		return getBase().isProtected();
	}

	public boolean isPublic() {
		return getBase().isPublic();
	}

	public int modifiers() {
		return getBase().modifiers();
	}

	public int compareTo(Method o) {
		return getBase().compareTo(shadowMaster().unwrap(o));
	}

	public ShadowMaster shadowMaster() {
		return master;
	}
	
	public String toString(){
		return declaringType().toString() + "." + name();
	}

	@Override
	public List<JoinPoint> joinPointsAt(Location loc) {
		List<JoinPoint> out = new LinkedList<JoinPoint>();
		for (JoinPoint joinPoint : allJoinPoints()) {
			if(joinPoint.location().contains(loc)){
				out.add(joinPoint);
			}
		}
		return out;
	}

	public void flushJoinpoints() {
		jpi=null;
	}

	public boolean is(MethodIdentifier method) {
		if(!master.unwrap(parent).name().equals(method.getClazz()))
			return false;
		return name().equals(method.getMethodname()) && signature().equals(method.getMethodsig());
	}
	
}
