/* *******************************************************************
 * Copyright (c) 2002 Palo Alto Research Center, Incorporated (PARC).
 * All rights reserved.
 * This program and the accompanying materials are made available
 * under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     PARC     initial implementation
 *     Alexandre Vasseur    support for @AJ aspects
 * ******************************************************************/

package org.aspectj.weaver.bcel;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.aspectj.apache.bcel.Constants;
import org.aspectj.apache.bcel.classfile.LocalVariable;
import org.aspectj.apache.bcel.generic.ArrayType;
import org.aspectj.apache.bcel.classfile.LocalVariableTable;
import org.aspectj.apache.bcel.generic.Instruction;
import org.aspectj.apache.bcel.generic.InstructionBranch;
import org.aspectj.apache.bcel.generic.InstructionConstants;
import org.aspectj.apache.bcel.generic.InstructionFactory;
import org.aspectj.apache.bcel.generic.InstructionHandle;
import org.aspectj.apache.bcel.generic.InstructionList;
import org.aspectj.apache.bcel.generic.InvokeInstruction;
import org.aspectj.apache.bcel.generic.ObjectType;
import org.aspectj.apache.bcel.generic.LineNumberTag;
import org.aspectj.apache.bcel.generic.LocalVariableTag;
import org.aspectj.apache.bcel.generic.Type;
import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.ISourceLocation;
import org.aspectj.bridge.Message;
import org.aspectj.weaver.Advice;
import org.aspectj.weaver.AdviceKind;
import org.aspectj.weaver.AjAttribute;
import org.aspectj.weaver.AjcMemberMaker;
import org.aspectj.weaver.model.AsmRelationshipProvider;
import org.aspectj.weaver.BCException;
import org.aspectj.weaver.IEclipseSourceContext;
import org.aspectj.weaver.ISourceContext;
import org.aspectj.weaver.IntMap;
import org.aspectj.weaver.Member;
import org.aspectj.weaver.MemberImpl;
import org.aspectj.weaver.ReferenceType;
import org.aspectj.weaver.NameMangler;
import org.aspectj.weaver.ReferenceTypeDelegate;
import org.aspectj.weaver.ResolvedMember;
import org.aspectj.weaver.ResolvedMemberImpl;
import org.aspectj.weaver.ResolvedType;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.ShadowMunger;
import org.aspectj.weaver.UnresolvedType;
import org.aspectj.weaver.WeaverMessages;
import org.aspectj.weaver.World;
import org.aspectj.weaver.Shadow.Kind;
import org.aspectj.weaver.ast.Literal;
import org.aspectj.weaver.ast.Test;
import org.aspectj.weaver.patterns.ExactTypePattern;
import org.aspectj.weaver.patterns.ExposedState;
import org.aspectj.weaver.patterns.PerClause;
import org.aspectj.weaver.patterns.Pointcut;

import platform.IEffect;

/**
 * Advice implemented for bcel.
 * 
 * @author Erik Hilsdale
 * @author Jim Hugunin
 */
public class BcelAdvice extends Advice implements IEffect {
	private Test pointcutTest;
	private ExposedState exposedState;

	public BcelAdvice(AjAttribute.AdviceAttribute attribute, Pointcut pointcut, Member signature, ResolvedType concreteAspect) {
		super(attribute, pointcut, shrink(attribute.getKind(), concreteAspect, signature));// (signature==null?null:signature.slimline
		// ()));
		this.concreteAspect = concreteAspect;
	}

	/**
	 * We don't always need to represent the signature with a heavyweight BcelMethod object - only if its around advice and inlining
	 * is active
	 * 
	 * @param concreteAspect
	 * @param attribute
	 */
	private static Member shrink(AdviceKind kind, ResolvedType concreteAspect, Member m) {
		if (m == null)
			return null;
		UnresolvedType dType = m.getDeclaringType();
		// if it isnt around advice or it is but inlining is turned off then shrink it to a ResolvedMemberImpl
		if (kind != AdviceKind.Around || ((dType instanceof ResolvedType) && ((ResolvedType) dType).getWorld().isXnoInline())) {
			if (m instanceof BcelMethod) {
				BcelMethod bm = (BcelMethod) m;
				if (bm.getMethod() != null && bm.getMethod().getAnnotations() != null)
					return m;
				ResolvedMemberImpl simplermember = new ResolvedMemberImpl(bm.getKind(), bm.getDeclaringType(), bm.getModifiers(),
						bm.getReturnType(), bm.getName(), bm.getParameterTypes());// ,bm.getExceptions(),bm.getBackingGenericMember()
				// );
				simplermember.setParameterNames(bm.getParameterNames());
				return simplermember;
			}
		}
		return m;
	}

	/**
	 * For testing only
	 */
	public BcelAdvice(AdviceKind kind, Pointcut pointcut, Member signature, int extraArgumentFlags, int start, int end,
			ISourceContext sourceContext, ResolvedType concreteAspect) {
		this(new AjAttribute.AdviceAttribute(kind, pointcut, extraArgumentFlags, start, end, sourceContext), pointcut, signature,
				concreteAspect);
		thrownExceptions = Collections.EMPTY_LIST; // !!! interaction with unit tests
	}

	// ---- implementations of ShadowMunger's methods

	public ShadowMunger concretize(ResolvedType fromType, World world, PerClause clause) {
		suppressLintWarnings(world);
		ShadowMunger ret = super.concretize(fromType, world, clause);
		clearLintSuppressions(world, this.suppressedLintKinds);
		IfFinder ifinder = new IfFinder();
		ret.getPointcut().accept(ifinder, null);
		boolean hasGuardTest = ifinder.hasIf && getKind() != AdviceKind.Around;
		boolean isAround = getKind() == AdviceKind.Around;
		if ((getExtraParameterFlags() & ThisJoinPoint) != 0) {
			if (!isAround && !hasGuardTest && world.getLint().noGuardForLazyTjp.isEnabled()) {
				// can't build tjp lazily, no suitable test...
				// ... only want to record it once against the advice(bug 133117)
				world.getLint().noGuardForLazyTjp.signal("", getSourceLocation());
			}
		}
		return ret;
	}

	public ShadowMunger parameterizeWith(ResolvedType declaringType, Map typeVariableMap) {
		Pointcut pc = getPointcut().parameterizeWith(typeVariableMap, declaringType.getWorld());

		BcelAdvice ret = null;
		Member adviceSignature = signature;
		// allows for around advice where the return value is a type variable (see pr115250)
		if (signature instanceof ResolvedMember && signature.getDeclaringType().isGenericType()) {
			adviceSignature = ((ResolvedMember) signature).parameterizedWith(declaringType.getTypeParameters(), declaringType,
					declaringType.isParameterizedType());
		}
		ret = new BcelAdvice(this.attribute, pc, adviceSignature, this.concreteAspect);
		return ret;
	}

	public boolean match(Shadow shadow, World world) {
		suppressLintWarnings(world);
		boolean ret = super.match(shadow, world);
		clearLintSuppressions(world, this.suppressedLintKinds);
		return ret;
	}

	public void specializeOn(Shadow shadow) {
		if (getKind() == AdviceKind.Around) {
			((BcelShadow) shadow).initializeForAroundClosure();
		}

		// XXX this case is just here for supporting lazy test code
		if (getKind() == null) {
			exposedState = new ExposedState(0);
			return;
		}
		if (getKind().isPerEntry()) {
			exposedState = new ExposedState(0);
		} else if (getKind().isCflow()) {
			exposedState = new ExposedState(nFreeVars);
		} else if (getSignature() != null) {
			exposedState = new ExposedState(getSignature());
		} else {
			exposedState = new ExposedState(0);
			return; // XXX this case is just here for supporting lazy test code
		}

		World world = shadow.getIWorld();
		suppressLintWarnings(world);
		pointcutTest = getPointcut().findResidue(shadow, exposedState);
		clearLintSuppressions(world, this.suppressedLintKinds);

		// these initializations won't be performed by findResidue, but need to be
		// so that the joinpoint is primed for weaving
		if (getKind() == AdviceKind.PerThisEntry) {
			shadow.getThisVar();
		} else if (getKind() == AdviceKind.PerTargetEntry) {
			shadow.getTargetVar();
		}

		// make sure thisJoinPoint parameters are initialized
		if ((getExtraParameterFlags() & ThisJoinPointStaticPart) != 0) {
			((BcelShadow) shadow).getThisJoinPointStaticPartVar();
			((BcelShadow) shadow).getEnclosingClass().warnOnAddedStaticInitializer(shadow, getSourceLocation());
		}

		if ((getExtraParameterFlags() & ThisJoinPoint) != 0) {
			boolean hasGuardTest = pointcutTest != Literal.TRUE && getKind() != AdviceKind.Around;
			boolean isAround = getKind() == AdviceKind.Around;
			((BcelShadow) shadow).requireThisJoinPoint(hasGuardTest, isAround);
			((BcelShadow) shadow).getEnclosingClass().warnOnAddedStaticInitializer(shadow, getSourceLocation());
			if (!hasGuardTest && world.getLint().multipleAdviceStoppingLazyTjp.isEnabled()) {
				// collect up the problematic advice
				((BcelShadow) shadow).addAdvicePreventingLazyTjp(this);
			}
		}

		if ((getExtraParameterFlags() & ThisEnclosingJoinPointStaticPart) != 0) {
			((BcelShadow) shadow).getThisEnclosingJoinPointStaticPartVar();
			((BcelShadow) shadow).getEnclosingClass().warnOnAddedStaticInitializer(shadow, getSourceLocation());
		}
	}

	private boolean canInline(Shadow s) {
		if (attribute.isProceedInInners())
			return false;
		// XXX this guard seems to only be needed for bad test cases
		if (concreteAspect == null || concreteAspect.isMissing())
			return false;

		if (concreteAspect.getWorld().isXnoInline())
			return false;
		// System.err.println("isWoven? " + ((BcelObjectType)concreteAspect).getLazyClassGen().getWeaverState());
		BcelObjectType boType = BcelWorld.getBcelObjectType(concreteAspect);
		if (boType == null) {
			// Could be a symptom that the aspect failed to build last build... return the default answer of false
			return false;
		}
		return boType.getLazyClassGen().isWoven();
	}

	public boolean implementOn(Shadow s) {
		hasMatchedAtLeastOnce = true;
		BcelShadow shadow = (BcelShadow) s;

		// pr263323 - if the aspect is broken then the delegate will not be usable for weaving
		if (concreteAspect instanceof ReferenceType) {
			ReferenceTypeDelegate rtDelegate = ((ReferenceType) concreteAspect).getDelegate();
			if (!(rtDelegate instanceof BcelObjectType)) {
				return false;
			}
		}

		// remove any unnecessary exceptions if the compiler option is set to
		// error or warning and if this piece of advice throws exceptions
		// (bug 129282). This may be expanded to include other compiler warnings
		// at the moment it only deals with 'declared exception is not thrown'
		if (!shadow.getWorld().isIgnoringUnusedDeclaredThrownException() && !getThrownExceptions().isEmpty()) {
			Member member = shadow.getSignature();
			if (member instanceof BcelMethod) {
				removeUnnecessaryProblems((BcelMethod) member, ((BcelMethod) member).getDeclarationLineNumber());
			} else {
				// we're in a call shadow therefore need the line number of the
				// declared method (which may be in a different type). However,
				// we want to remove the problems from the CompilationResult
				// held within the current type's EclipseSourceContext so need
				// the enclosing shadow too
				ResolvedMember resolvedMember = shadow.getSignature().resolve(shadow.getWorld());
				if (resolvedMember instanceof BcelMethod && shadow.getEnclosingShadow() instanceof BcelShadow) {
					Member enclosingMember = shadow.getEnclosingShadow().getSignature();
					if (enclosingMember instanceof BcelMethod) {
						removeUnnecessaryProblems((BcelMethod) enclosingMember, ((BcelMethod) resolvedMember)
								.getDeclarationLineNumber());
					}
				}
			}
		}

		if (shadow.getIWorld().isJoinpointSynchronizationEnabled() && shadow.getKind() == Shadow.MethodExecution
				&& (s.getSignature().getModifiers() & Modifier.SYNCHRONIZED) != 0) {
			shadow.getIWorld().getLint().advisingSynchronizedMethods.signal(new String[] { shadow.toString() }, shadow
					.getSourceLocation(), new ISourceLocation[] { getSourceLocation() });
		}

		// FIXME AV - see #75442, this logic is not enough so for now comment it out until we fix the bug
		// // callback for perObject AJC MightHaveAspect postMunge (#75442)
		// if (getConcreteAspect() != null
		// && getConcreteAspect().getPerClause() != null
		// && PerClause.PEROBJECT.equals(getConcreteAspect().getPerClause().getKind())) {
		// final PerObject clause;
		// if (getConcreteAspect().getPerClause() instanceof PerFromSuper) {
		// clause = (PerObject)((PerFromSuper) getConcreteAspect().getPerClause()).lookupConcretePerClause(getConcreteAspect());
		// } else {
		// clause = (PerObject) getConcreteAspect().getPerClause();
		// }
		// if (clause.isThis()) {
		// PerObjectInterfaceTypeMunger.registerAsAdvisedBy(s.getThisVar().getType(), getConcreteAspect());
		// } else {
		// PerObjectInterfaceTypeMunger.registerAsAdvisedBy(s.getTargetVar().getType(), getConcreteAspect());
		// }
		// }
		if (pointcutTest == Literal.FALSE) { // not usually allowed, except in one case (260384)
			Member sig = shadow.getSignature();
			if (sig.getArity() == 0 && shadow.getKind() == Shadow.MethodCall && sig.getName().charAt(0) == 'c'
					&& sig.getReturnType().equals(ResolvedType.OBJECT) && sig.getName().equals("clone")) {
				return false;
			}
		}

		if (getKind() == AdviceKind.Before) {
			weaveBefore(shadow);
		} else if (getKind() == AdviceKind.AfterReturning) {
			weaveAfterReturning(shadow);
		} else if (getKind() == AdviceKind.AfterThrowing) {
			UnresolvedType catchType = hasExtraParameter() ? getExtraParameterType() : UnresolvedType.THROWABLE;
			weaveAfterThrowing(shadow, catchType);
		} else if (getKind() == AdviceKind.After) {
			weaveAfter(shadow);
		} else if (getKind() == AdviceKind.Around) {
			// Note: under regular LTW the aspect is usually loaded after the first use of any class affecteted by it
			// This means that as long as the aspect has not been thru the LTW, it's woven state is unknown
			// and thus canInline(s) will return false.
			// To force inlining (test), ones can do Class aspect = FQNAspect.class in the clinit of the target class
			// FIXME AV : for AJC compiled @AJ aspect (or any code style aspect), the woven state can never be known
			// if the aspect belongs to a parent classloader. In that case the aspect will never be inlined.
			// It might be dangerous to change that especially for @AJ aspect non compiled with AJC since if those
			// are not weaved (f.e. use of some limiteed LTW etc) then they cannot be prepared for inlining.
			// One solution would be to flag @AJ aspect with an annotation as "prepared" and query that one.
			LazyClassGen enclosingClass = shadow.getEnclosingClass();
			if (enclosingClass != null && enclosingClass.isInterface() && shadow.getEnclosingMethod().getName().charAt(0) == '<') {
				// Do not add methods with bodies to an interface (252198, 163005)
				shadow.getWorld().getLint().cannotAdviseJoinpointInInterfaceWithAroundAdvice.signal(shadow.toString(), shadow
						.getSourceLocation());
				return false;
			}
			if (!canInline(s)) {
				weaveAroundClosure(shadow, hasDynamicTests());
			} else {
				//weaveAroundInline(shadow, hasDynamicTests());
        		weaveAroundClosure(shadow, hasDynamicTests());
			}
		} else if (getKind() == AdviceKind.InterInitializer) {
			weaveAfterReturning(shadow);
		} else if (getKind().isCflow()) {
			weaveCflowEntry(shadow, getSignature());
		} else if (getKind() == AdviceKind.PerThisEntry) {
			weavePerObjectEntry(shadow, (BcelVar) shadow.getThisVar());
		} else if (getKind() == AdviceKind.PerTargetEntry) {
			weavePerObjectEntry(shadow, (BcelVar) shadow.getTargetVar());
		} else if (getKind() == AdviceKind.Softener) {
			weaveSoftener(shadow, ((ExactTypePattern) exceptionType).getType());
		} else if (getKind() == AdviceKind.PerTypeWithinEntry) {
			// PTWIMPL Entry to ptw is the static initialization of a type that matched the ptw type pattern
			weavePerTypeWithinAspectInitialization(shadow, shadow.getEnclosingType());
		} else {
			throw new BCException("unimplemented kind: " + getKind());
		}
		return true;
	}

	private void removeUnnecessaryProblems(BcelMethod method, int problemLineNumber) {
		ISourceContext sourceContext = method.getSourceContext();
		if (sourceContext instanceof IEclipseSourceContext) {
			((IEclipseSourceContext) sourceContext).removeUnnecessaryProblems(method, problemLineNumber);
		}
	}

	// ---- implementations

	private Collection collectCheckedExceptions(UnresolvedType[] excs) {
		if (excs == null || excs.length == 0)
			return Collections.EMPTY_LIST;

		Collection ret = new ArrayList();
		World world = concreteAspect.getWorld();
		ResolvedType runtimeException = world.getCoreType(UnresolvedType.RUNTIME_EXCEPTION);
		ResolvedType error = world.getCoreType(UnresolvedType.ERROR);

		for (int i = 0, len = excs.length; i < len; i++) {
			ResolvedType t = world.resolve(excs[i], true);
			if (t.isMissing()) {
				world.getLint().cantFindType.signal(WeaverMessages.format(WeaverMessages.CANT_FIND_TYPE_EXCEPTION_TYPE, excs[i]
						.getName()), getSourceLocation());
				// IMessage msg = new Message(
				// WeaverMessages.format(WeaverMessages.CANT_FIND_TYPE_EXCEPTION_TYPE,excs[i].getName()),
				// "",IMessage.ERROR,getSourceLocation(),null,null);
				// world.getMessageHandler().handleMessage(msg);
			}
			if (!(runtimeException.isAssignableFrom(t) || error.isAssignableFrom(t))) {
				ret.add(t);
			}
		}

		return ret;
	}

	private Collection thrownExceptions = null;

	public Collection getThrownExceptions() {
		if (thrownExceptions == null) {
			// ??? can we really lump in Around here, how does this interact with Throwable
			if (concreteAspect != null && concreteAspect.getWorld() != null && // null tests for test harness
					(getKind().isAfter() || getKind() == AdviceKind.Before || getKind() == AdviceKind.Around)) {
				World world = concreteAspect.getWorld();
				ResolvedMember m = world.resolve(signature);
				if (m == null) {
					thrownExceptions = Collections.EMPTY_LIST;
				} else {
					thrownExceptions = collectCheckedExceptions(m.getExceptions());
				}
			} else {
				thrownExceptions = Collections.EMPTY_LIST;
			}
		}
		return thrownExceptions;
	}

	/**
	 * The munger must not check for the advice exceptions to be declared by the shadow in the case of @AJ aspects so that around
	 * can throws Throwable
	 * 
	 * @return
	 */
	public boolean mustCheckExceptions() {
		if (getConcreteAspect() == null) {
			return true;
		}
		return !getConcreteAspect().isAnnotationStyleAspect();
	}

	// only call me after prepare has been called
	public boolean hasDynamicTests() {
		// if (hasExtraParameter() && getKind() == AdviceKind.AfterReturning) {
		// UnresolvedType extraParameterType = getExtraParameterType();
		// if (! extraParameterType.equals(UnresolvedType.OBJECT)
		// && ! extraParameterType.isPrimitive())
		// return true;
		// }

		return pointcutTest != null && !(pointcutTest == Literal.TRUE);// || pointcutTest == Literal.NO_TEST);
	}

	/**
	 * get the instruction list for the really simple version of this advice. Is broken apart for other advice, but if you want it
	 * in one block, this is the method to call.
	 * 
	 * @param s The shadow around which these instructions will eventually live.
	 * @param extraArgVar The var that will hold the return value or thrown exception for afterX advice
	 * @param ifNoAdvice The instructionHandle to jump to if the dynamic tests for this munger fails.
	 */
	InstructionList getAdviceInstructions(BcelShadow s, BcelVar extraArgVar, InstructionHandle ifNoAdvice) {
		BcelShadow shadow = s;
		InstructionFactory fact = shadow.getFactory();
		BcelWorld world = shadow.getWorld();

		InstructionList il = new InstructionList();

		// we test to see if we have the right kind of thing...
		// after throwing does this just by the exception mechanism.
		if (hasExtraParameter() && getKind() == AdviceKind.AfterReturning) {
			UnresolvedType extraParameterType = getExtraParameterType();
			if (!extraParameterType.equals(UnresolvedType.OBJECT) && !extraParameterType.isPrimitiveType()) {
				il.append(BcelRenderer.renderTest(fact, world, Test.makeInstanceof(extraArgVar, getExtraParameterType().resolve(
						world)), null, ifNoAdvice, null));
			}
		}
		il.append(getAdviceArgSetup(shadow, extraArgVar, null));
		il.append(getNonTestAdviceInstructions(shadow));

		InstructionHandle ifYesAdvice = il.getStart();
		il.insert(getTestInstructions(shadow, ifYesAdvice, ifNoAdvice, ifYesAdvice));

		// If inserting instructions at the start of a method, we need a nice line number for this entry
		// in the stack trace
		if (shadow.getKind() == Shadow.MethodExecution && getKind() == AdviceKind.Before) {
			int lineNumber = 0;
			// Uncomment this code if you think we should use the method decl line number when it exists...
			// // If the advised join point is in a class built by AspectJ, we can use the declaration line number
			// boolean b = shadow.getEnclosingMethod().getMemberView().hasDeclarationLineNumberInfo();
			// if (b) {
			// lineNumber = shadow.getEnclosingMethod().getMemberView().getDeclarationLineNumber();
			// } else { // If it wasn't, the best we can do is the line number of the first instruction in the method
			lineNumber = shadow.getEnclosingMethod().getMemberView().getLineNumberOfFirstInstruction();
			// }
			InstructionHandle start = il.getStart();
			if (lineNumber > 0) {
				start.addTargeter(new LineNumberTag(lineNumber));
			}
			// Fix up the local variables: find any that have a startPC of 0 and ensure they target the new start of the method
			LocalVariableTable lvt = shadow.getEnclosingMethod().getMemberView().getMethod().getLocalVariableTable();
			if (lvt != null) {
				LocalVariable[] lvTable = lvt.getLocalVariableTable();
				for (int i = 0; i < lvTable.length; i++) {
					LocalVariable lv = lvTable[i];
					if (lv.getStartPC() == 0) {
						start.addTargeter(new LocalVariableTag(lv.getSignature(), lv.getName(), lv.getIndex(), 0));
					}
				}
			}
		}

		return il;
	}

	public InstructionList getAdviceArgSetup(BcelShadow shadow, BcelVar extraVar, InstructionList closureInstantiation) {
		InstructionFactory fact = shadow.getFactory();
		BcelWorld world = shadow.getWorld();
		InstructionList il = new InstructionList();

		// if (targetAspectField != null) {
		// il.append(fact.createFieldAccess(
		// targetAspectField.getDeclaringType().getName(),
		// targetAspectField.getName(),
		// BcelWorld.makeBcelType(targetAspectField.getType()),
		// Constants.GETSTATIC));
		// }
		//        
		// System.err.println("BcelAdvice: " + exposedState);

		if (exposedState.getAspectInstance() != null) {
			il.append(BcelRenderer.renderExpr(fact, world, exposedState.getAspectInstance()));
		}
		// pr121385
		boolean x = this.getDeclaringAspect().resolve(world).isAnnotationStyleAspect();
		final boolean isAnnotationStyleAspect = getConcreteAspect() != null && getConcreteAspect().isAnnotationStyleAspect() && x;
		boolean previousIsClosure = false;
		for (int i = 0, len = exposedState.size(); i < len; i++) {
			if (exposedState.isErroneousVar(i))
				continue; // Erroneous vars have already had error msgs reported!
			BcelVar v = (BcelVar) exposedState.get(i);

			if (v == null) {
				// if not @AJ aspect, go on with the regular binding handling
				if (!isAnnotationStyleAspect) {

				} else {
					// ATAJ: for @AJ aspects, handle implicit binding of xxJoinPoint
					// if (getKind() == AdviceKind.Around) {
					// previousIsClosure = true;
					// il.append(closureInstantiation);
					if ("Lorg/aspectj/lang/ProceedingJoinPoint;".equals(getSignature().getParameterTypes()[i].getSignature())) {
						// make sure we are in an around, since we deal with the closure, not the arg here
						if (getKind() != AdviceKind.Around) {
							previousIsClosure = false;
							getConcreteAspect().getWorld().getMessageHandler().handleMessage(
									new Message("use of ProceedingJoinPoint is allowed only on around advice (" + "arg " + i
											+ " in " + toString() + ")", this.getSourceLocation(), true));
							// try to avoid verify error and pass in null
							il.append(InstructionConstants.ACONST_NULL);
						} else {
							if (previousIsClosure) {
								il.append(InstructionConstants.DUP);
							} else {
								previousIsClosure = true;
								il.append(closureInstantiation.copy());
							}
						}
					} else if ("Lorg/aspectj/lang/JoinPoint$StaticPart;".equals(getSignature().getParameterTypes()[i]
							.getSignature())) {
						previousIsClosure = false;
						if ((getExtraParameterFlags() & ThisJoinPointStaticPart) != 0) {
							shadow.getThisJoinPointStaticPartBcelVar().appendLoad(il, fact);
						}
					} else if ("Lorg/aspectj/lang/JoinPoint;".equals(getSignature().getParameterTypes()[i].getSignature())) {
						previousIsClosure = false;
						if ((getExtraParameterFlags() & ThisJoinPoint) != 0) {
							il.append(shadow.loadThisJoinPoint());
						}
					} else if ("Lorg/aspectj/lang/JoinPoint$EnclosingStaticPart;".equals(getSignature().getParameterTypes()[i]
							.getSignature())) {
						previousIsClosure = false;
						if ((getExtraParameterFlags() & ThisEnclosingJoinPointStaticPart) != 0) {
							shadow.getThisEnclosingJoinPointStaticPartBcelVar().appendLoad(il, fact);
						}
					} else if (hasExtraParameter()) {
						previousIsClosure = false;
						extraVar.appendLoadAndConvert(il, fact, getExtraParameterType().resolve(world));
					} else {
						previousIsClosure = false;
						getConcreteAspect().getWorld().getMessageHandler().handleMessage(
								new Message("use of ProceedingJoinPoint is allowed only on around advice (" + "arg " + i + " in "
										+ toString() + ")", this.getSourceLocation(), true));
						// try to avoid verify error and pass in null
						il.append(InstructionConstants.ACONST_NULL);
					}
				}
			} else {
				UnresolvedType desiredTy = getBindingParameterTypes()[i];
				v.appendLoadAndConvert(il, fact, desiredTy.resolve(world));
			}
		}

		// ATAJ: for code style aspect, handles the extraFlag as usual ie not
		// in the middle of the formal bindings but at the end, in a rock solid ordering
		if (!isAnnotationStyleAspect) {
			if (getKind() == AdviceKind.Around) {
				il.append(closureInstantiation);
			} else if (hasExtraParameter()) {
				extraVar.appendLoadAndConvert(il, fact, getExtraParameterType().resolve(world));
			}

			// handle thisJoinPoint parameters
			// these need to be in that same order as parameters in
			// org.aspectj.ajdt.internal.compiler.ast.AdviceDeclaration
			if ((getExtraParameterFlags() & ThisJoinPointStaticPart) != 0) {
				shadow.getThisJoinPointStaticPartBcelVar().appendLoad(il, fact);
			}

			if ((getExtraParameterFlags() & ThisJoinPoint) != 0) {
				il.append(shadow.loadThisJoinPoint());
			}

			if ((getExtraParameterFlags() & ThisEnclosingJoinPointStaticPart) != 0) {
				shadow.getThisEnclosingJoinPointStaticPartBcelVar().appendLoad(il, fact);
			}
		}

		return il;
	}

	public InstructionList getNonTestAdviceInstructions(BcelShadow shadow) {
		return new InstructionList(Utility.createInvoke(shadow.getFactory(), shadow.getWorld(), getOriginalSignature()));
	}

	public Member getOriginalSignature() {
		Member sig = getSignature();
		if (sig instanceof ResolvedMember) {
			ResolvedMember rsig = (ResolvedMember) sig;
			if (rsig.hasBackingGenericMember())
				return rsig.getBackingGenericMember();
		}
		return sig;
	}

	public InstructionList getTestInstructions(BcelShadow shadow, InstructionHandle sk, InstructionHandle fk, InstructionHandle next) {
		// System.err.println("test: " + pointcutTest);
		return BcelRenderer.renderTest(shadow.getFactory(), shadow.getWorld(), pointcutTest, sk, fk, next);
	}

	public int compareTo(Object other) {
		if (!(other instanceof BcelAdvice))
			return 0;
		BcelAdvice o = (BcelAdvice) other;

		// System.err.println("compareTo: " + this + ", " + o);
		if (kind.getPrecedence() != o.kind.getPrecedence()) {
			if (kind.getPrecedence() > o.kind.getPrecedence())
				return +1;
			else
				return -1;
		}

		if (kind.isCflow()) {
			// System.err.println("sort: " + this + " innerCflowEntries " + innerCflowEntries);
			// System.err.println("      " + o + " innerCflowEntries " + o.innerCflowEntries);
			boolean isBelow = (kind == AdviceKind.CflowBelowEntry);

			if (this.innerCflowEntries.contains(o))
				return isBelow ? +1 : -1;
			else if (o.innerCflowEntries.contains(this))
				return isBelow ? -1 : +1;
			else
				return 0;
		}

		if (kind.isPerEntry() || kind == AdviceKind.Softener) {
			return 0;
		}

		// System.out.println("compare: " + this + " with " + other);
		World world = concreteAspect.getWorld();

		int ret = concreteAspect.getWorld().compareByPrecedence(concreteAspect, o.concreteAspect);
		if (ret != 0)
			return ret;

		ResolvedType declaringAspect = getDeclaringAspect().resolve(world);
		ResolvedType o_declaringAspect = o.getDeclaringAspect().resolve(world);

		if (declaringAspect == o_declaringAspect) {
			if (kind.isAfter() || o.kind.isAfter()) {
				return this.getStart() < o.getStart() ? -1 : +1;
			} else {
				return this.getStart() < o.getStart() ? +1 : -1;
			}
		} else if (declaringAspect.isAssignableFrom(o_declaringAspect)) {
			return -1;
		} else if (o_declaringAspect.isAssignableFrom(declaringAspect)) {
			return +1;
		} else {
			return 0;
		}
	}

	public BcelVar[] getExposedStateAsBcelVars(boolean isAround) {
		// ATAJ aspect
		if (isAround) {
			// the closure instantiation has the same mapping as the extracted method from wich it is called
			if (getConcreteAspect() != null && getConcreteAspect().isAnnotationStyleAspect()) {
				return BcelVar.NONE;
			}
		}

		// System.out.println("vars: " + Arrays.asList(exposedState.vars));
		if (exposedState == null)
			return BcelVar.NONE;
		int len = exposedState.vars.length;
		BcelVar[] ret = new BcelVar[len];
		for (int i = 0; i < len; i++) {
			ret[i] = (BcelVar) exposedState.vars[i];
		}
		return ret; // (BcelVar[]) exposedState.vars;
	}

	protected void suppressLintWarnings(World inWorld) {
		if (suppressedLintKinds == null) {
			if (signature instanceof BcelMethod) {
				this.suppressedLintKinds = Utility.getSuppressedWarnings(signature.getAnnotations(), inWorld.getLint());
			} else {
				this.suppressedLintKinds = Collections.EMPTY_LIST;
			}
		}
		inWorld.getLint().suppressKinds(suppressedLintKinds);
	}

	protected void clearLintSuppressions(World inWorld, Collection toClear) {
		inWorld.getLint().clearSuppressions(toClear);
	}
	
    public void transform(BcelShadow shadow) {
    	implementOn(shadow);
    	//This is copied here from Shadow class.
    	reportAfterWeaving(shadow);
    }
    
    private void reportAfterWeaving(BcelShadow shadow) {
		BcelWorld world = shadow.getWorld();
		if (world.getCrossReferenceHandler() != null) {
			world.getCrossReferenceHandler().addCrossReference(
					this.getSourceLocation(), // What is being applied
					shadow.getSourceLocation(), // Where is it being												// applied
					determineRelKind().getName(), // What kind of advice?
					((BcelAdvice) this).hasDynamicTests() // Is a
															// runtime
															// test
															// being
															// stuffed
															// in the
															// code?
					);
		}

		// TAG: WeavingMessage
		if (!world.getMessageHandler().isIgnoring(
				IMessage.WEAVEINFO)) {
			reportWeavingMessage(shadow);
		}

		if (world.getModel() != null) {
			// System.err.println("munger: " + munger + " on " + this);
			AsmRelationshipProvider.addAdvisedRelationship(world.getModelAsAsmManager(), shadow, this);
		}

    }
    
	
  //================== All these guys came from BcelShadow =======	

  	void weaveBefore(BcelShadow shadow) {
  	    shadow.range.insert(
  	        getAdviceInstructions(shadow, null, shadow.range.getRealStart()), 
  	        Range.InsideBefore);
  	}

  	public void weaveAfter(BcelShadow shadow) {
  	    weaveAfterThrowing(shadow, UnresolvedType.THROWABLE);
  	    weaveAfterReturning(shadow);
  	}

  	/**
  	 * The basic strategy here is to add a set of instructions at the end of 
  	 * the shadow range that dispatch the advice, and then return whatever the
  	 * shadow was going to return anyway.
  	 * 
  	 * To achieve this, we note all the return statements in the advice, and 
  	 * replace them with code that:
  	 * 1) stores the return value on top of the stack in a temp var
  	 * 2) jumps to the start of our advice block
  	 * 3) restores the return value at the end of the advice block before
  	 * ultimately returning
  	 * 
  	 * We also need to bind the return value into a returning parameter, if the
  	 * advice specified one.
  	 * @param shadow TODO
  	 */
  	public void weaveAfterReturning(BcelShadow shadow) {
  	    List returns = findReturnInstructions(shadow);
  	    boolean hasReturnInstructions = !returns.isEmpty();
  	    
  	    // list of instructions that handle the actual return from the join point
  	    InstructionList retList = new InstructionList();
  	            
  	    // variable that holds the return value
  	    BcelVar returnValueVar = null;
  	    
  	    if (hasReturnInstructions) {
  	    	returnValueVar = generateReturnInstructions(shadow, returns,retList);
  	    } else  {
  	    	// we need at least one instruction, as the target for jumps
  	        retList.append(InstructionConstants.NOP);            
  	    }
  	
  	    // list of instructions for dispatching to the advice itself
  	    InstructionList advice = getAfterReturningAdviceDispatchInstructions(
  	    		shadow, retList.getStart());            
  	    
  	    if (hasReturnInstructions) {
  	        InstructionHandle gotoTarget = advice.getStart();           
  			for (Iterator i = returns.iterator(); i.hasNext();) {
  				InstructionHandle ih = (InstructionHandle) i.next();
  				retargetReturnInstruction(shadow, hasExtraParameter(), returnValueVar, gotoTarget, ih);
  			}
  	    }            
  	     
  	    shadow.range.append(advice);
  	    shadow.range.append(retList);
  	}

  	/**
  	 * Get the list of instructions used to dispatch to the after advice
  	 * @param shadow TODO
  	 * @param firstInstructionInReturnSequence
  	 * @return
  	 */
  	InstructionList getAfterReturningAdviceDispatchInstructions(BcelShadow shadow, InstructionHandle firstInstructionInReturnSequence) {
  		InstructionList advice = new InstructionList();
  	    
  	    BcelVar tempVar = null;
  	    if (hasExtraParameter()) {
  	        tempVar = insertAdviceInstructionsForBindingReturningParameter(shadow,advice);
  	    }
  	    advice.append(getAdviceInstructions(shadow, tempVar, firstInstructionInReturnSequence));
  		return advice;
  	}

  	public void weaveAfterThrowing(BcelShadow shadow, UnresolvedType catchType) {
  		// a good optimization would be not to generate anything here
  		// if the shadow is GUARANTEED empty (i.e., there's NOTHING, not even
  		// a shadow, inside me).
  		if (shadow.getRange().getStart().getNext() == shadow.getRange().getEnd()) return;
  	    InstructionFactory fact = shadow.getFactory();        
  	    InstructionList handler = new InstructionList();        
  	    BcelVar exceptionVar = shadow.genTempVar(catchType);
  	    exceptionVar.appendStore(handler, fact);
  	
  	    // pr62642
  	    // I will now jump through some firey BCEL hoops to generate a trivial bit of code:
  	    // if (exc instanceof ExceptionInInitializerError) 
  	    //    throw (ExceptionInInitializerError)exc;
  	    if (shadow.getEnclosingMethod().getName().equals("<clinit>")) {
  	        ResolvedType eiieType = shadow.world.resolve("java.lang.ExceptionInInitializerError");
  	        ObjectType eiieBcelType = (ObjectType)BcelWorld.makeBcelType(eiieType);
  	    	InstructionList ih = new InstructionList(InstructionConstants.NOP);
  	    	handler.append(exceptionVar.createLoad(fact));
  	    	handler.append(fact.createInstanceOf(eiieBcelType));
  	    	InstructionBranch bi = 
  	            InstructionFactory.createBranchInstruction(Constants.IFEQ,ih.getStart());
  	    	handler.append(bi);
  	    	handler.append(exceptionVar.createLoad(fact));
  	    	handler.append(fact.createCheckCast(eiieBcelType));
  	    	handler.append(InstructionConstants.ATHROW);
  	    	handler.append(ih);
  	    }
  	    
  	    InstructionList endHandler = new InstructionList(
  	        exceptionVar.createLoad(fact));
  	    handler.append(getAdviceInstructions(shadow, exceptionVar, endHandler.getStart()));
  	    handler.append(endHandler);
  	    handler.append(InstructionConstants.ATHROW);        
  	    InstructionHandle handlerStart = handler.getStart();
  	                                
  	    if (shadow.isFallsThrough()) {
  	        InstructionHandle jumpTarget = handler.append(InstructionConstants.NOP);
  	        handler.insert(InstructionFactory.createBranchInstruction(Constants.GOTO, jumpTarget));
  	    }
  		InstructionHandle protectedEnd = handler.getStart();
  	    shadow.range.insert(handler, Range.InsideAfter);       
  	
  	    shadow.enclosingMethod.addExceptionHandler(shadow.range.getStart().getNext(), protectedEnd.getPrev(),
  	                             handlerStart, (ObjectType)BcelWorld.makeBcelType(catchType), //???Type.THROWABLE, 
  	                             // high priority if our args are on the stack
  	                             shadow.getKind().hasHighPriorityExceptions());
  	}

  	public void weaveSoftener(BcelShadow shadow, UnresolvedType catchType) {
  		// a good optimization would be not to generate anything here
  		// if the shadow is GUARANTEED empty (i.e., there's NOTHING, not even
  		// a shadow, inside me).
  		if (shadow.getRange().getStart().getNext() == shadow.getRange().getEnd()) return;
  				
  	    InstructionFactory fact = shadow.getFactory();
  	    InstructionList handler = new InstructionList();        
  		InstructionList rtExHandler = new InstructionList();
  	    BcelVar exceptionVar = shadow.genTempVar(catchType);
  		        
  		handler.append(fact.createNew(NameMangler.SOFT_EXCEPTION_TYPE));
  		handler.append(InstructionFactory.createDup(1));   
  	    handler.append(exceptionVar.createLoad(fact));
  	    handler.append(fact.createInvoke(NameMangler.SOFT_EXCEPTION_TYPE, "<init>", 
  	    					Type.VOID, new Type[] { Type.THROWABLE }, Constants.INVOKESPECIAL));  //??? special
  	    handler.append(InstructionConstants.ATHROW);        
  	
  		// ENH 42737
  	    exceptionVar.appendStore(rtExHandler, fact);
  		// aload_1
  		rtExHandler.append(exceptionVar.createLoad(fact));
  		// instanceof class java/lang/RuntimeException
  		rtExHandler.append(fact.createInstanceOf(new ObjectType("java.lang.RuntimeException")));
  		// ifeq go to new SOFT_EXCEPTION_TYPE instruction
  		rtExHandler.append(InstructionFactory.createBranchInstruction(Constants.IFEQ,handler.getStart()));
  		// aload_1
  		rtExHandler.append(exceptionVar.createLoad(fact));
  		// athrow
  		rtExHandler.append(InstructionFactory.ATHROW);
  	
  		InstructionHandle handlerStart = rtExHandler.getStart();
  	
  		if (shadow.isFallsThrough()) {
  	        InstructionHandle jumpTarget = shadow.range.getEnd();//handler.append(fact.NOP);
  	        rtExHandler.insert(InstructionFactory.createBranchInstruction(Constants.GOTO, jumpTarget));
  	    }
  	
  		rtExHandler.append(handler);
  	
  		InstructionHandle protectedEnd = rtExHandler.getStart();
  	    shadow.range.insert(rtExHandler, Range.InsideAfter);    
  		
  	    shadow.enclosingMethod.addExceptionHandler(shadow.range.getStart().getNext(), protectedEnd.getPrev(),
  	                             handlerStart, (ObjectType)BcelWorld.makeBcelType(catchType), 
  	                             // high priority if our args are on the stack
  	                             shadow.getKind().hasHighPriorityExceptions());    
  	}

  	public void weavePerObjectEntry(BcelShadow shadow, final BcelVar onVar) {
  	    final InstructionFactory fact = shadow.getFactory();        
  	
  	
  		InstructionList entryInstructions = new InstructionList();
  		InstructionList entrySuccessInstructions = new InstructionList();
  		onVar.appendLoad(entrySuccessInstructions, fact);
  	
  		entrySuccessInstructions.append(
  			Utility.createInvoke(fact, shadow.world, 
  				AjcMemberMaker.perObjectBind(getConcreteAspect())));
  		
  		InstructionList testInstructions = 
  			getTestInstructions(shadow, entrySuccessInstructions.getStart(), 
  								shadow.range.getRealStart(), 
  								entrySuccessInstructions.getStart());
  					
  		entryInstructions.append(testInstructions);
  		entryInstructions.append(entrySuccessInstructions);
  		
  		shadow.range.insert(entryInstructions, Range.InsideBefore);
  	}

  	/**
  	 * Causes the aspect instance to be *set* for later retrievable through localAspectof()/aspectOf()
  	 * @param shadow TODO
  	 * @param t TODO
  	 */
  	public void weavePerTypeWithinAspectInitialization(BcelShadow shadow, UnresolvedType t) {
  		
  		if (t.resolve(shadow.world).isInterface()) return; // Don't initialize statics in 
  	    final InstructionFactory fact = shadow.getFactory();        
  	
  		InstructionList entryInstructions = new InstructionList();
  		InstructionList entrySuccessInstructions = new InstructionList();
  		
  		BcelWorld.getBcelObjectType(getConcreteAspect());
  		String aspectname = getConcreteAspect().getName();
  		
  		String ptwField = NameMangler.perTypeWithinFieldForTarget(getConcreteAspect());
  		entrySuccessInstructions.append(InstructionFactory.PUSH(fact.getConstantPool(),t.getName()));
  		
  		entrySuccessInstructions.append(fact.createInvoke(aspectname,"ajc$createAspectInstance",new ObjectType(aspectname),
  				new Type[]{new ObjectType("java.lang.String")},Constants.INVOKESTATIC));
  		entrySuccessInstructions.append(fact.createPutStatic(t.getName(),ptwField,
  				new ObjectType(aspectname)));
  		
  		entryInstructions.append(entrySuccessInstructions);
  		
  		shadow.range.insert(entryInstructions, Range.InsideBefore);
  	}

  	/** Wraps a shadow with entry and exit instructions that
  	 * push and pop cflow stack (or increment/decrement cflow counter).
  	 * Thus, cflow is implemented as advice.
  	 * @param shadow
  	 * @param cflowField
  	 */
  	public void weaveCflowEntry(BcelShadow shadow, final Member cflowField) {
  		final boolean isPer = getKind() == AdviceKind.PerCflowBelowEntry || 
  								getKind() == AdviceKind.PerCflowEntry;
  		
  		final Type objectArrayType = new ArrayType(Type.OBJECT, 1);
  	    final InstructionFactory fact = shadow.getFactory();        
  	
  		final BcelVar testResult = shadow.genTempVar(ResolvedType.BOOLEAN);
  	
  		InstructionList entryInstructions = new InstructionList();
  		{
  			InstructionList entrySuccessInstructions = new InstructionList();
  			
  			if (hasDynamicTests()) {
  				entryInstructions.append(Utility.createConstant(fact, 0));
  				testResult.appendStore(entryInstructions, fact);
  			
  				entrySuccessInstructions.append(Utility.createConstant(fact, 1));
  				testResult.appendStore(entrySuccessInstructions, fact);
  			}
  	
  			if (isPer) {
  	      		entrySuccessInstructions.append(
  	      			fact.createInvoke(getConcreteAspect().getName(), 
  	      						NameMangler.PERCFLOW_PUSH_METHOD, 
  	      						Type.VOID, 
  	      						new Type[] { }, 
  	      						Constants.INVOKESTATIC));
  			} else {
  				BcelVar[] cflowStateVars = getExposedStateAsBcelVars(false);
  	
  				if (cflowStateVars.length == 0) {
  					// This should be getting managed by a counter - lets make sure.
  					if (!cflowField.getType().getName().endsWith("CFlowCounter")) 
  						throw new RuntimeException("Incorrectly attempting counter operation on stacked cflow");
  					entrySuccessInstructions.append(
  			      			Utility.createGet(fact, cflowField));
  					//arrayVar.appendLoad(entrySuccessInstructions, fact);
  					entrySuccessInstructions.append(fact.createInvoke(NameMangler.CFLOW_COUNTER_TYPE,"inc",Type.VOID,new Type[] { },Constants.INVOKEVIRTUAL));
  				} else {
  				    BcelVar arrayVar = shadow.genTempVar(UnresolvedType.OBJECTARRAY);
  	
  				    int alen = cflowStateVars.length;
  				    entrySuccessInstructions.append(Utility.createConstant(fact, alen));
  				    entrySuccessInstructions.append(
  				    		(Instruction) fact.createNewArray(Type.OBJECT, (short) 1));
  				    arrayVar.appendStore(entrySuccessInstructions, fact);
  		 
  				    for (int i = 0; i < alen; i++) {
  				    	arrayVar.appendConvertableArrayStore(
  				    			entrySuccessInstructions,
  								fact,
  								i,
  								cflowStateVars[i]);
  				    }		
  	
  				    entrySuccessInstructions.append(
  				    		Utility.createGet(fact, cflowField));
  				    arrayVar.appendLoad(entrySuccessInstructions, fact);
  	
  				    entrySuccessInstructions.append(
  				    		fact.createInvoke(NameMangler.CFLOW_STACK_TYPE, "push", Type.VOID, 
  	      						new Type[] { objectArrayType }, 
  	      					Constants.INVOKEVIRTUAL));
  				}
  			}
  	
  			
  			InstructionList testInstructions = 
  				getTestInstructions(shadow, entrySuccessInstructions.getStart(), 
  									shadow.range.getRealStart(), 
  									entrySuccessInstructions.getStart());
  			entryInstructions.append(testInstructions);
  			entryInstructions.append(entrySuccessInstructions);
  		}
  		
  		// this is the same for both per and non-per
  		new BcelAdvice(null, null, null, 0, 0, 0, null, null) {
  			public InstructionList getAdviceInstructions(
  				BcelShadow s,
  				BcelVar extraArgVar,
  				InstructionHandle ifNoAdvice) {
  				InstructionList exitInstructions = new InstructionList();
  				if (hasDynamicTests()) {
  					testResult.appendLoad(exitInstructions, fact);
  					exitInstructions.append(
  						InstructionFactory.createBranchInstruction(
  							Constants.IFEQ,
  							ifNoAdvice));
  				}
  				exitInstructions.append(Utility.createGet(fact, cflowField));
  				if (getKind() != AdviceKind.PerCflowEntry &&
  					getKind() != AdviceKind.PerCflowBelowEntry &&
  					getExposedStateAsBcelVars(false).length==0) {
  					exitInstructions
  					.append(
  						fact
  						.createInvoke(
  							NameMangler.CFLOW_COUNTER_TYPE,
  							"dec",
  							Type.VOID,
  							new Type[] {
  				}, Constants.INVOKEVIRTUAL));
  				} else {
  				exitInstructions
  					.append(
  						fact
  						.createInvoke(
  							NameMangler.CFLOW_STACK_TYPE,
  							"pop",
  							Type.VOID,
  							new Type[] {
  				}, Constants.INVOKEVIRTUAL));
  				}
  				return exitInstructions;
  			}
  		}.weaveAfter(shadow);
  		
  		
  		shadow.range.insert(entryInstructions, Range.InsideBefore);
  	}

  	/**
  	 *  SK: weaves around advice.
  	 *  (1) First it creates a new method, and copies there an original shadow's body 
  	 *      (without extra stuff that is added recently).
  	 *      This method is called callbackMethod.
  	 *  (2) Then it creates a closure class with a constructor that takes the shadow's context,
  	 *      and run method that basically runs the callbackMethod 
  	 *  (3) Finally, it inserts (instead of original shadow) call to the advice method.
  	 *      The advice method takes all the context vars, and also callback object.
  	 *      Plus, if there is a dynamic checking, then guard code first inserted,
  	 *      then call to advice method, and then (if jp doesn't match) call to the callbackMethod. 
  	 * @param transformer TODO
  	 * @param hasDynamicTest
  	 */
  	public void weaveAroundClosure(BcelShadow shadow, boolean hasDynamicTest) {
  		InstructionFactory fact = shadow.getEnclosingClass().getFactory();
  		Kind kind = shadow.getKind();
  		ShadowRange range = shadow.getRange();
  		BcelWorld world = shadow.getWorld();
  	
  		//Don't know what that would mean, but anyway
  		shadow.getEnclosingMethod().setCanInline(false);
  	    			    
  		
  		BcelVar[] adviceVars = getExposedStateAsBcelVars(true);
  		IntMap state2proceed = makeProceedArgumentMap(adviceVars);
  		   	
  		ProceedComputation compShadow = new ProceedComputation(shadow, state2proceed);
  		BcelVar closureHolder = compShadow.getClosureHolder();
  		LazyMethodGen callbackMethod = compShadow.getComputationMethod();
  		InstructionList closureInstantiation = compShadow.getComputation();
  		
  	
  	    InstructionList returnConversionCode;
  	    //TODO: find out if PreInitialization shadows can be advised
  	    //with around advise. For now I ignore this option
  		if (kind == Shadow.PreInitialization) {
  			returnConversionCode = new InstructionList();
  			
  			BcelVar stateTempVar = shadow.genTempVar(UnresolvedType.OBJECTARRAY);
  			closureHolder.appendLoad(returnConversionCode, fact);
  			
  			returnConversionCode.append(
  				Utility.createInvoke(
  					fact, 
  					world, 
  					AjcMemberMaker.aroundClosurePreInitializationGetter()));
  			stateTempVar.appendStore(returnConversionCode, fact);
  			
  			Type[] stateTypes = getSuperConstructorParameterTypes(shadow);
  			
  			returnConversionCode.append(InstructionConstants.ALOAD_0); // put "this" back on the stack
  			for (int i = 0, len = stateTypes.length; i < len; i++) {
  	            UnresolvedType bcelTX = BcelWorld.fromBcel(stateTypes[i]);
  	            ResolvedType stateRTX = world.resolve(bcelTX,true);
  	            if (stateRTX.isMissing()) {
  	            		world.getLint().cantFindType.signal(
  	            				new String[] {WeaverMessages.format(WeaverMessages.CANT_FIND_TYPE_DURING_AROUND_WEAVE_PREINIT,bcelTX.getClassName())},
  	            				shadow.getSourceLocation(),
  	            				new ISourceLocation[]{ getSourceLocation()}
  	            				);
  	//                    IMessage msg = new Message(
  	//                             WeaverMessages.format(WeaverMessages.CANT_FIND_TYPE_DURING_AROUND_WEAVE_PREINIT,bcelTX.getClassName()),
  	//                              "",IMessage.ERROR,getSourceLocation(),null,
  	//                              new ISourceLocation[]{ munger.getSourceLocation()});
  	//                    world.getMessageHandler().handleMessage(msg);
  	            }
  				stateTempVar.appendConvertableArrayLoad(
  					returnConversionCode, 
  					fact, 
  					i, 
  					stateRTX);
  			}
  		} else { 
  	        //generates a type-cast instruction that 
  	        //converts a value returned from the advice method 
  	        //from the return type of the advice method 
  	        //to the return type of the callback proceed method 
  	        //(which is the return type of the shadow)
  	        returnConversionCode = 
  	            Utility.createConversion(
  	                fact, 
  	                BcelWorld.makeBcelType(getSignature().getReturnType()), 
  	                callbackMethod.getReturnType(),world.isInJava5Mode());
  	        //if terminates with return
  	        //generates an instruction that returns whatever is on the top of the stack
  			if (range.getRealNext() == null) {
  				returnConversionCode.append(
  					InstructionFactory.createReturn(callbackMethod.getReturnType()));
  			}
  	 	} 
  	
  		// initialize the bit flags for this shadow
  		int bitflags                                 =0x000000;
  		if (kind.isTargetSameAsThis()) bitflags|=0x010000;
  		if (shadow.hasThis())                      bitflags|=0x001000;
  		if (shadow.bindsThis(this))              bitflags|=0x000100;
  		if (shadow.hasTarget())                    bitflags|=0x000010;
  		if (shadow.bindsTarget(this))            bitflags|=0x000001;
  		
  		//SK: this is a real magic, and it is AJ-specific, which is OK for AJ transformers
  	    // ATAJ for @AJ aspect we need to link the closure with the joinpoint instance
  	    if (getConcreteAspect()!=null && getConcreteAspect().isAnnotationStyleAspect() 
  	       && getDeclaringAspect()!=null && getDeclaringAspect().resolve(world).isAnnotationStyleAspect()) {
  	    	// stick the bitflags on the stack and call the variant of linkClosureAndJoinPoint that takes an int
  	    	closureInstantiation.append(fact.createConstant(new Integer(bitflags)));
  	        closureInstantiation.append(Utility.createInvoke(
  	                fact,
  	                world,
  	                new MemberImpl(
  	                        Member.METHOD,
  	                        UnresolvedType.forName("org.aspectj.runtime.internal.AroundClosure"),
  	                        Modifier.PUBLIC,
  	                        "linkClosureAndJoinPoint",
  	                        "(I)Lorg/aspectj/lang/ProceedingJoinPoint;"
  	                        )
  	        ));
  	    }
  	
  	    InstructionList advice = new InstructionList();
  	    //TODO: this canot be passed to this advice, because it
  	    //wants BcelShadow, not ComputationShadow. Resolve it later, if necessary.
  	    //SK: appends to advice instructions that
  	    //(1) load exposedState vars on the stack 
  	    //(2) create closure object 
  	    //(3) load tjpsp, tjp, tencljpsp objects
  	    advice.append(getAdviceArgSetup(shadow, null, closureInstantiation));
  	
  	    // invoke the advice
  	    //SK: appends an instruction that invokes advice method (???) 
  	    // I guess, the latter is created at the preprocessing stage...
  	    // It should take the closure object for proceed.
  	    //    (that is static, if I remember correcrly)
  	    advice.append(new InstructionList(
  	            Utility.createInvoke(fact, world, 
  	            		getOriginalSignature())));
  	    //SK: only for PreInitialization shadows.
  	    advice.append(returnConversionCode);
  	    
  	    //SK: I assume, that the advice invokation code replaces
  	    //     the original shadow code.
  	    //     Thus, nex application of around advice would treat 
  	    //      this advice instructions as an original shadow code,
  	    //      and will weave around it!
  		if (!hasDynamicTest) {
  			//SK: if no dynamic tests -> we run the advice body (that invokes the advice method)
  			range.append(advice);
  		} else {
  			//
  			InstructionList callback = makeCallToCallback(shadow, callbackMethod);
  			InstructionList postCallback = new InstructionList();
  			if (range.getRealNext() == null) {
  				callback.append(
  					InstructionFactory.createReturn(callbackMethod.getReturnType()));
  			} else {
  				advice.append(
  					InstructionFactory.createBranchInstruction(
  						Constants.GOTO,
  						postCallback.append(InstructionConstants.NOP)));
  			}
  			//SK: here the guard is introduced
  			range.append(
  				getTestInstructions(
  					shadow,
  					advice.getStart(),
  					callback.getStart(),
  					advice.getStart()));
  			//SK: if the guard permits -> run advice -> and GOTO to the postCallBack
  			range.append(advice);
  			//SK: if guard doesn't permit -> run callback method 
  			range.append(callback);
  			//SK: return the result.
  			range.append(postCallback);
  		}
  	}
  	
      // exposed for testing
  	//Loads all the variables on the stack, and calls the callBackMethod
      InstructionList makeCallToCallback(BcelShadow shadow, LazyMethodGen callbackMethod) {
  		BcelVar thisVar = shadow.getThisVarField();
  		BcelVar targetVar = shadow.getTargetVarField();
  		BcelVar[] argVars = shadow.getArgVarsField();
  		BcelWorld world = shadow.getWorld();
  		// TODO: AJ-specific. To be removed later.
  		BcelVar thisJoinPointVar = (BcelVar) shadow.getThisJoinPointVar();

      	InstructionFactory fact = shadow.getFactory();
          InstructionList callback = new InstructionList();
          if (thisVar != null) {
          	callback.append(InstructionConstants.ALOAD_0); 
          }
          if (targetVar != null && targetVar != thisVar) {
              callback.append(BcelRenderer.renderExpr(fact, world, targetVar));
          }
          callback.append(BcelRenderer.renderExprs(fact, world, argVars));
          //TODO: resolve this later
          // remember to render tjps
          if (thisJoinPointVar != null) {
          	callback.append(BcelRenderer.renderExpr(fact, world, thisJoinPointVar));
          } 
          callback.append(Utility.createInvoke(fact, callbackMethod));
          return callback;
      }

      /**
       * Each non-null variable in the adviceArg array is also 
       * stored in the state array of the closure object.
       * For each such a variable, the method maps its position
       * in the state array to the position in the adviceArgs array.
       * 
       * @see BcelVar.setPositionInAroundState
       * @see ProceedComputation.makeClosureClass
       * @see BcelAdvice.specializeOn 
       * 
       * Maps positions of actually exposed adviceArgs in the
       * @param adviceArgs
       * @return
       */
      IntMap makeProceedArgumentMap(BcelVar[] adviceArgs) {
          //System.err.println("coming in with " + Arrays.asList(adviceArgs));

          IntMap state2proceed = new IntMap();
          for(int i = 0, len = adviceArgs.length; i < len; i++) {
              BcelVar v = (BcelVar) adviceArgs[i];
              if (v == null) continue; // XXX we don't know why this is required
              int pos = v.getPositionInAroundState();
              if (pos >= 0) {  // need this test to avoid args bound via cflow
              	state2proceed.put(pos, i);
              }
          }     
          return state2proceed;
      }
      
  	Type[] getSuperConstructorParameterTypes(BcelShadow shadow) {
  		ShadowRange range = shadow.getRange();
  		LazyClassGen enclosingClass = shadow.getEnclosingClass();
  		// assert getKind() == PreInitialization	
  		InstructionHandle superCallHandle = range.getEnd().getNext();
  		InvokeInstruction superCallInstruction = 
  			(InvokeInstruction) superCallHandle.getInstruction();
  		return superCallInstruction.getArgumentTypes(
  			enclosingClass.getConstantPool());
  	}

      /**
  	 * @return a list of all the return instructions in the range of this shadow
  	 */
  	List findReturnInstructions(BcelShadow shadow) {
  		ShadowRange range = shadow.getRange();
  		List returns = new ArrayList();
          for (InstructionHandle ih = range.getStart(); ih != range.getEnd(); ih = ih.getNext()) {
              if (ih.getInstruction().isReturnInstruction()) {
                  returns.add(ih);
              }
          }
  		return returns;
  	}
  	
  	/**
  	 * Given a list containing all the return instruction handles for this shadow,
  	 * finds the last return instruction and copies it, making this the ultimate
  	 * return. If the shadow has a non-void return type, we also create a temporary
  	 * variable to hold the return value, and load the value from this var before
  	 * returning (see pr148007 for why we do this - it works around a JRockit bug,
  	 * and is also closer to what javac generates)
  	 * @param returns list of all the return instructions in the shadow
  	 * @param returnInstructions instruction list into which the return instructions should
  	 * be generated
  	 * @return the variable holding the return value, if needed
  	 */
  	BcelVar generateReturnInstructions(BcelShadow shadow, List returns, InstructionList returnInstructions) {
  		BcelVar returnValueVar = null;
      	InstructionHandle lastReturnHandle = (InstructionHandle)returns.get(returns.size() - 1);
      	Instruction newReturnInstruction = Utility.copyInstruction(lastReturnHandle.getInstruction());
      	if (hasANonVoidReturnType(shadow)) {
          	returnValueVar = shadow.genTempVar(shadow.getReturnType());
              returnValueVar.appendLoad(returnInstructions,shadow.getFactory());
      	} else {
      		returnInstructions.append(newReturnInstruction);
      	}
      	returnInstructions.append(newReturnInstruction);
      	return returnValueVar;
  	}
  	
  	/**
  	 * @return true, iff this shadow returns a value
  	 */
  	private boolean hasANonVoidReturnType(BcelShadow shadow) {
  		return shadow.getReturnType() != ResolvedType.VOID;
  	}
  	
  	/**
  	 * If the after() returning(Foo f) form is used, bind the return value to the parameter.
  	 * If the shadow returns void, bind null.
  	 * @param advice
  	 * @return
  	 */
  	BcelVar insertAdviceInstructionsForBindingReturningParameter(BcelShadow shadow, InstructionList advice) {
  		BcelVar tempVar;
  		UnresolvedType tempVarType = shadow.getReturnType();
  		if (tempVarType.equals(ResolvedType.VOID)) {
  			tempVar = shadow.genTempVar(UnresolvedType.OBJECT);
  			advice.append(InstructionConstants.ACONST_NULL);
  			tempVar.appendStore(advice, shadow.getFactory());
  		} else {
  		    tempVar = shadow.genTempVar(tempVarType);
  		    advice.append(InstructionFactory.createDup(tempVarType.getSize()));
  		    tempVar.appendStore(advice, shadow.getFactory());
  		}
  		return tempVar;
  	}
  	
  	/**
  	 * Helper method for weaveAfterReturning
  	 * 
  	 * Each return instruction in the method body is retargeted by calling this method.
  	 * The return instruction is replaced by up to three instructions:
  	 * 1) if the shadow returns a value, and that value is bound to an after returning
  	 * parameter, then we DUP the return value on the top of the stack
  	 * 2) if the shadow returns a value, we store it in the returnValueVar (it will
  	 * be retrieved from here when we ultimately return after the advice dispatch)
  	 * 3) if the return was the last instruction, we add a NOP (it will fall through
  	 * to the advice dispatch), otherwise we add a GOTO that branches to the
  	 * supplied gotoTarget (start of the advice dispatch)
  	 */
  	void retargetReturnInstruction(BcelShadow shadow, boolean hasReturningParameter, BcelVar returnValueVar, InstructionHandle gotoTarget, InstructionHandle returnHandle) {
  		// pr148007, work around JRockit bug
  		// replace ret with store into returnValueVar, followed by goto if not
  		// at the end of the instruction list...
  		InstructionList newInstructions = new InstructionList();
  		if (returnValueVar != null) {
  		    if (hasReturningParameter) {
  		    	// we have to dup the return val before consuming it...
  		    	newInstructions.append(InstructionFactory.createDup(shadow.getReturnType().getSize()));
  		    }
  			// store the return value into this var
  			returnValueVar.appendStore(newInstructions, shadow.getFactory());
  		}
  		if (!isLastInstructionInRange(returnHandle,shadow.getRange())) {
  			newInstructions.append(InstructionFactory.createBranchInstruction(
  					Constants.GOTO,
  					gotoTarget));
  		}
  		if (newInstructions.isEmpty()) {
  			newInstructions.append(InstructionConstants.NOP);
  		}
  		Utility.replaceInstruction(returnHandle,newInstructions,shadow.getEnclosingMethod());
  	}

      private boolean isLastInstructionInRange(InstructionHandle ih, ShadowRange aRange) {
      	return ih.getNext() == aRange.getEnd();
      }
  	
  	
  	/*
  	public void weaveAroundInline(BcelShadow shadow, boolean hasDynamicTest) {
  		 
  		// !!! THIS BLOCK OF CODE SHOULD BE IN A METHOD CALLED weaveAround(...);
  	    Member mungerSig = getSignature();
  	    //Member originalSig = mungerSig; // If mungerSig is on a parameterized type, originalSig is the member on the generic type
  	    if (mungerSig instanceof ResolvedMember) {
  	    	ResolvedMember rm = (ResolvedMember)mungerSig;
  	    	if (rm.hasBackingGenericMember()) mungerSig = rm.getBackingGenericMember();
  	    }
  	    ResolvedType declaringType = shadow.world.resolve(mungerSig.getDeclaringType(),true);
  	    if (declaringType.isMissing()) {
  	    	shadow.world.getLint().cantFindType.signal(
  	    			new String[] {WeaverMessages.format(WeaverMessages.CANT_FIND_TYPE_DURING_AROUND_WEAVE,declaringType.getClassName())},
  	    			shadow.getSourceLocation(),
  	    			new ISourceLocation[]{ getSourceLocation()}
  	    			);
  	//          IMessage msg = new Message(
  	//                WeaverMessages.format(WeaverMessages.CANT_FIND_TYPE_DURING_AROUND_WEAVE,declaringType.getClassName()),
  	//                "",IMessage.ERROR,getSourceLocation(),null,
  	//                new ISourceLocation[]{ munger.getSourceLocation()});
  	//          world.getMessageHandler().handleMessage(msg);
  	    }
  	    //??? might want some checks here to give better errors
  	    ResolvedType rt = (declaringType.isParameterizedType()?declaringType.getGenericType():declaringType);
  	    BcelObjectType ot = BcelWorld.getBcelObjectType(rt); 
  	//        if (ot==null) {
  	//        	world.getMessageHandler().handleMessage(
  	//        	  MessageUtil.warn("Unable to find modifiable delegate for the aspect '"+rt.getName()+"' containing around advice - cannot implement inlining",munger.getSourceLocation()));
  	//        	weaveAroundClosure(munger, hasDynamicTest);
  	//			return;
  	//        }
  		LazyMethodGen adviceMethod = ot.getLazyClassGen().getLazyMethodGen(mungerSig);
  		if (!adviceMethod.getCanInline()) {
  			weaveAroundClosure(shadow, hasDynamicTest);
  			return;
  		}
  	
  	    // specific test for @AJ proceedInInners
  	    if (getConcreteAspect().isAnnotationStyleAspect()) {
  	        // if we can't find one proceed() we suspect that the call 
  	    	// is happening in an inner class so we don't inline it.
  	        // Note: for code style, this is done at Aspect compilation time.
  	        boolean canSeeProceedPassedToOther = false;
  	        InstructionHandle curr = adviceMethod.getBody().getStart();
  	        InstructionHandle end = adviceMethod.getBody().getEnd();
  	        ConstantPoolGen cpg = adviceMethod.getEnclosingClass().getConstantPoolGen();
  	        while (curr != end) {
  	            InstructionHandle next = curr.getNext();
  	            Instruction inst = curr.getInstruction();
  	            if ((inst instanceof InvokeInstruction)
  	                && ((InvokeInstruction)inst).getSignature(cpg).indexOf("Lorg/aspectj/lang/ProceedingJoinPoint;") > 0) {
  	                // we may want to refine to exclude stuff returning jp ?
  	                // does code style skip inline if i write dump(thisJoinPoint) ?
  	                canSeeProceedPassedToOther = true;// we see one pjp passed around - dangerous
  	                break;
  	            }
  	            curr = next;
  	        }
  	        if (canSeeProceedPassedToOther) {
  	            // remember this decision to avoid re-analysis
  	            adviceMethod.setCanInline(false);
  	            weaveAroundClosure(shadow, hasDynamicTest);
  	            return;
  	        }
  	    }
  	
  	
  	
  		// We can't inline around methods if they have around advice on them, this
  		// is because the weaving will extract the body and hence the proceed call.
  		//??? should consider optimizations to recognize simple cases that don't require body extraction
  		shadow.enclosingMethod.setCanInline(false);
  		
  		// start by exposing various useful things into the frame
  		final InstructionFactory fact = shadow.getFactory();
  		
  		// now generate the aroundBody method
  		// eg. "private static final void method_aroundBody0(M, M, String, org.aspectj.lang.JoinPoint)"
  	    LazyMethodGen extractedMethod = 
  	    	extractMethod(
  	    		NameMangler.aroundCallbackMethodName(shadow.getSignature(),shadow.getEnclosingClass()),
  				Modifier.PRIVATE,
  				this);
  	    			
  	    // now extract the advice into its own method
  	    String adviceMethodName =
  			NameMangler.aroundCallbackMethodName(shadow.getSignature(),shadow.getEnclosingClass()) + "$advice";
  	    
  		List argVarList      = new ArrayList();
  		List proceedVarList  = new ArrayList();
  		int extraParamOffset = 0;
  		
  		// Create the extra parameters that are needed for passing to proceed
  		// This code is very similar to that found in makeCallToCallback and should
  		// be rationalized in the future
  		
  		if (shadow.thisVar != null) {
  			argVarList.add(shadow.thisVar);
  			proceedVarList.add(new BcelVar(shadow.thisVar.getType(), extraParamOffset));
  			extraParamOffset += shadow.thisVar.getType().getSize();
  		}
  		
  		if (shadow.targetVar != null && shadow.targetVar != shadow.thisVar) {
  			argVarList.add(shadow.targetVar);
  			proceedVarList.add(new BcelVar(shadow.targetVar.getType(), extraParamOffset));
  			extraParamOffset += shadow.targetVar.getType().getSize();
  		}
  		for (int i = 0, len = shadow.getArgCount(); i < len; i++) {
  			argVarList.add(shadow.argVars[i]);
  			proceedVarList.add(new BcelVar(shadow.argVars[i].getType(), extraParamOffset));
  			extraParamOffset += shadow.argVars[i].getType().getSize();
  		}
  		if (shadow.thisJoinPointVar != null) {
  			argVarList.add(shadow.thisJoinPointVar);
  			proceedVarList.add(new BcelVar(shadow.thisJoinPointVar.getType(), extraParamOffset));
  			extraParamOffset += shadow.thisJoinPointVar.getType().getSize();
  		}
  	    
  	    Type[] adviceParameterTypes = adviceMethod.getArgumentTypes();
  	    Type[] extractedMethodParameterTypes = extractedMethod.getArgumentTypes();
  		Type[] parameterTypes =
  			new Type[extractedMethodParameterTypes.length
  				+ adviceParameterTypes.length
  				+ 1];
  		int parameterIndex = 0;
  		System.arraycopy(
  			extractedMethodParameterTypes,
  			0,
  			parameterTypes,
  			parameterIndex,
  			extractedMethodParameterTypes.length);
  		parameterIndex += extractedMethodParameterTypes.length;
  	
  		parameterTypes[parameterIndex++] =
  			BcelWorld.makeBcelType(adviceMethod.getEnclosingClass().getType());
  		System.arraycopy(
  			adviceParameterTypes,
  			0,
  			parameterTypes,
  			parameterIndex,
  			adviceParameterTypes.length);
  	
  	    LazyMethodGen localAdviceMethod =
  					new LazyMethodGen(
  						Modifier.PRIVATE | Modifier.FINAL | Modifier.STATIC, 
  						BcelWorld.makeBcelType(mungerSig.getReturnType()), 
  						adviceMethodName,
  						parameterTypes,
  						new String[0],
  						shadow.getEnclosingClass());
  	 
  		String donorFileName = adviceMethod.getEnclosingClass().getInternalFileName();
  		String recipientFileName = shadow.getEnclosingClass().getInternalFileName();
  	//		System.err.println("donor " + donorFileName);
  	//		System.err.println("recip " + recipientFileName);
  		if (! donorFileName.equals(recipientFileName)) {
  			localAdviceMethod.fromFilename = donorFileName;
  			shadow.getEnclosingClass().addInlinedSourceFileInfo(
  				donorFileName,
  				adviceMethod.highestLineNumber);
  		}
  	
  		shadow.getEnclosingClass().addMethodGen(localAdviceMethod);
  		
  		// create a map that will move all slots in advice method forward by extraParamOffset
  		// in order to make room for the new proceed-required arguments that are added at
  		// the beginning of the parameter list
  		int nVars = adviceMethod.getMaxLocals() + extraParamOffset;
  		IntMap varMap = IntMap.idMap(nVars);
  		for (int i=extraParamOffset; i < nVars; i++) {
  			varMap.put(i-extraParamOffset, i);
  		}
  	
  		localAdviceMethod.getBody().insert(
  			BcelClassWeaver.genInlineInstructions(adviceMethod,
  					localAdviceMethod, varMap, fact, true));
  	
  	
  					
  		localAdviceMethod.setMaxLocals(nVars);
  					
  		//System.err.println(localAdviceMethod);
  		
  	
  		// the shadow is now empty.  First, create a correct call
  		// to the around advice.  This includes both the call (which may involve 
  		// value conversion of the advice arguments) and the return
  		// (which may involve value conversion of the return value).  Right now
  		// we push a null for the unused closure.  It's sad, but there it is.
  		    	
  		InstructionList advice = new InstructionList();
  	    // InstructionHandle adviceMethodInvocation;
  	    {
  			for (Iterator i = argVarList.iterator(); i.hasNext(); ) {
  				BcelVar var = (BcelVar)i.next();
  				var.appendLoad(advice, fact);
  			}       	
  	    	// ??? we don't actually need to push NULL for the closure if we take care
  			advice.append(
  				getAdviceArgSetup(
  					shadow,
  					null,
  	                (getConcreteAspect().isAnnotationStyleAspect() && getDeclaringAspect()!=null && getDeclaringAspect().resolve(shadow.world).isAnnotationStyleAspect())?
  	                    shadow.loadThisJoinPoint():
  					    new InstructionList(InstructionConstants.ACONST_NULL)));
  		    // adviceMethodInvocation =
  		        advice.append(
  		        	Utility.createInvoke(fact, localAdviceMethod)); //(fact, getWorld(), munger.getSignature()));
  			advice.append(
  		        Utility.createConversion(
  		            shadow.getFactory(), 
  		            BcelWorld.makeBcelType(mungerSig.getReturnType()), 
  		            extractedMethod.getReturnType(),shadow.world.isInJava5Mode()));
  		    if (! shadow.isFallsThrough()) {
  		        advice.append(InstructionFactory.createReturn(extractedMethod.getReturnType()));
  		    }
  	    }
  	    
  		// now, situate the call inside the possible dynamic tests,
  		// and actually add the whole mess to the shadow
  	    if (! hasDynamicTest) {
  	        shadow.range.append(advice);
  	    } else {
  	    	InstructionList afterThingie = new InstructionList(InstructionConstants.NOP);
  	        InstructionList callback = shadow.makeCallToCallback(extractedMethod);
  			if (shadow.terminatesWithReturn()) {
  				callback.append(
  					InstructionFactory.createReturn(extractedMethod.getReturnType()));
  			} else {
  				//InstructionHandle endNop = range.insert(fact.NOP, Range.InsideAfter);
  				advice.append(
  					InstructionFactory.createBranchInstruction(
  						Constants.GOTO,
  						afterThingie.getStart()));
  			}
  			shadow.range.append(
  				getTestInstructions(
  					shadow,
  					advice.getStart(),
  					callback.getStart(),
  					advice.getStart()));
  	        shadow.range.append(advice);
  	        shadow.range.append(callback);
  	        shadow.range.append(afterThingie);          
  	    }        
  	
  	
  	    // now search through the advice, looking for a call to PROCEED.  
  	    // Then we replace the call to proceed with some argument setup, and a 
  	    // call to the extracted method.
  	
  	    // inlining support for code style aspects
  	    if (!getConcreteAspect().isAnnotationStyleAspect()) {
  	        String proceedName =
  	            NameMangler.proceedMethodName(getSignature().getName());
  	
  	        InstructionHandle curr = localAdviceMethod.getBody().getStart();
  	        InstructionHandle end = localAdviceMethod.getBody().getEnd();
  	        ConstantPoolGen cpg = localAdviceMethod.getEnclosingClass().getConstantPoolGen();
  	        while (curr != end) {
  	            InstructionHandle next = curr.getNext();
  	            Instruction inst = curr.getInstruction();
  	            if ((inst instanceof INVOKESTATIC)
  	                && proceedName.equals(((INVOKESTATIC) inst).getMethodName(cpg))) {
  	
  	                localAdviceMethod.getBody().append(
  	                    curr,
  	                    getRedoneProceedCall(
  	                        fact,
  	                        extractedMethod,
  	                        shadow,
  	                        localAdviceMethod,
  	                        proceedVarList));
  	                Utility.deleteInstruction(curr, localAdviceMethod);
  	            }
  	            curr = next;
  	        }
  	        // and that's it.
  	    } else {
  	        //ATAJ inlining support for @AJ aspects
  	        // [TODO document @AJ code rule: don't manipulate 2 jps proceed at the same time.. in an advice body]
  	        InstructionHandle curr = localAdviceMethod.getBody().getStart();
  	        InstructionHandle end = localAdviceMethod.getBody().getEnd();
  	        ConstantPoolGen cpg = localAdviceMethod.getEnclosingClass().getConstantPoolGen();
  	        while (curr != end) {
  	            InstructionHandle next = curr.getNext();
  	            Instruction inst = curr.getInstruction();
  	            if ((inst instanceof INVOKEINTERFACE)
  	                && "proceed".equals(((INVOKEINTERFACE) inst).getMethodName(cpg))) {
  	                final boolean isProceedWithArgs;
  	                if (((INVOKEINTERFACE) inst).getArgumentTypes(cpg).length == 1) {
  	                    // proceed with args as a boxed Object[]
  	                    isProceedWithArgs = true;
  	                } else {
  	                    isProceedWithArgs = false;
  	                }
  	                InstructionList insteadProceedIl = getRedoneProceedCallForAnnotationStyle(
  	                        fact,
  	                        extractedMethod,
  	                        shadow,
  	                        localAdviceMethod,
  	                        proceedVarList,
  	                        isProceedWithArgs
  	                );
  	                localAdviceMethod.getBody().append(curr, insteadProceedIl);
  	                Utility.deleteInstruction(curr, localAdviceMethod);
  	            }
  	            curr = next;
  	        }
  	    }
  	}

  	InstructionList getRedoneProceedCall(
  	InstructionFactory fact, LazyMethodGen callbackMethod, BcelShadow shadow, LazyMethodGen localAdviceMethod, List argVarList) 
  	{
  	InstructionList ret = new InstructionList();
  	// we have on stack all the arguments for the ADVICE call.
  	// we have in frame somewhere all the arguments for the non-advice call.
  	
  	BcelVar[] adviceVars = getExposedStateAsBcelVars(true);
  	IntMap proceedMap =  shadow.makeProceedArgumentMap(adviceVars);
  	
  	//		System.out.println(proceedMap + " for " + this);
  	//		System.out.println(argVarList);
  	
  	ResolvedType[] proceedParamTypes =
  		shadow.world.resolve(getSignature().getParameterTypes());
  	// remove this*JoinPoint* as arguments to proceed
  	if (getBaseParameterCount()+1 < proceedParamTypes.length) {
  		int len = getBaseParameterCount()+1;
  		ResolvedType[] newTypes = new ResolvedType[len];
  		System.arraycopy(proceedParamTypes, 0, newTypes, 0, len);
  		proceedParamTypes = newTypes;
  	}
  	
  	//System.out.println("stateTypes: " + Arrays.asList(stateTypes));
  	BcelVar[] proceedVars =
  		Utility.pushAndReturnArrayOfVars(proceedParamTypes, ret, fact, localAdviceMethod);
  	
  	Type[] stateTypes = callbackMethod.getArgumentTypes();
  	//		System.out.println("stateTypes: " + Arrays.asList(stateTypes));
  	
  	for (int i=0, len=stateTypes.length; i < len; i++) {
  	    Type stateType = stateTypes[i];
  	    ResolvedType stateTypeX = BcelWorld.fromBcel(stateType).resolve(shadow.world);
  	    if (proceedMap.hasKey(i)) {
  	    	//throw new RuntimeException("unimplemented");
  			proceedVars[proceedMap.get(i)].appendLoadAndConvert(ret, fact, stateTypeX);
  	    } else {
  			((BcelVar) argVarList.get(i)).appendLoad(ret, fact);
  	    }
  	}
  			
  	ret.append(Utility.createInvoke(fact, callbackMethod));
  	ret.append(Utility.createConversion(fact, callbackMethod.getReturnType(), 
  			BcelWorld.makeBcelType(getSignature().getReturnType())));
  	return ret;
  	}
     */
  	/**
  	 * ATAJ Handle the inlining for @AJ aspects
  	 * @param fact TODO
  	 * @param callbackMethod TODO
  	 * @param shadow TODO
  	 * @param localAdviceMethod TODO
  	 * @param argVarList TODO
  	 * @param isProceedWithArgs TODO
  	 *
  	 */
  	/*
  	InstructionList getRedoneProceedCallForAnnotationStyle(
  	    InstructionFactory fact, LazyMethodGen callbackMethod, BcelShadow shadow, LazyMethodGen localAdviceMethod, List argVarList, boolean isProceedWithArgs)
  	{
  	    // Notes:
  	    // proceedingjp is on stack (since user was calling pjp.proceed(...)
  	
  	    // new Object[]{new Integer(argAdvice1-1)};// arg of proceed
  	    // call to proceed(..) is NOT made
  	    // instead we do
  	    // itar callback args i
  	    //     get from array i, convert it to the callback arg i
  	    //     if ask for JP, push the one we got on the stack
  	    // invoke callback, create conversion back to Object/Integer
  	
  	    // rest of method -- (hence all those conversions)
  	    // intValue() from original code
  	    // int res = .. from original code
  	
  	    //Note: we just don't care about the proceed map etc
  		// (we would need to care if we allow repositioning of arguments in advice signature)
  	
  	    InstructionList ret = new InstructionList();
  	
  	    // store the Object[] array on stack if proceed with args
  	    if (isProceedWithArgs) {
  	    	
  	    	// STORE the Object[] into a local variable
  	        Type objectArrayType = Type.getType("[Ljava/lang/Object;");
  	        int localProceedArgArray = localAdviceMethod.allocateLocal(objectArrayType);
  	        ret.append(InstructionFactory.createStore(objectArrayType, localProceedArgArray));
  	
  	        // STORE the ProceedingJoinPoint instance into a local variable
  	        Type proceedingJpType = Type.getType("Lorg/aspectj/lang/ProceedingJoinPoint;");
  	        int localJp = localAdviceMethod.allocateLocal(proceedingJpType);
  	        ret.append(InstructionFactory.createStore(proceedingJpType, localJp));
  	
  	        // push on stack each element of the object array
  	        // that is assumed to be consistent with the callback argument (ie munger args)
  	        // TODO do we want to try catch ClassCast and AOOBE exception ?
  	
  	        // special logic when withincode is static or not
  	        
  	        // This next bit of code probably makes more sense if you read its implementation for
  	        // weaveAroundClosure() - see JoinPointImpl.proceed(Object[]).  Basically depending
  	        // on whether the join point has a this/target and whether the pointcut binds this/target
  	        // then the arguments to the 'new' proceed call need to be reorganized. (pr126167)
  	    	boolean relatedPointcutBindsThis = shadow.bindsThis(this);
  	    	boolean relatedPointcutBindsTarget = shadow.bindsTarget(this);
  	    	boolean targetIsSameAsThis = shadow.getKind().isTargetSameAsThis();
  	    	
  	    	// two numbers can differ because a pointcut may bind both this/target and yet at the
  	    	// join point this and target are the same (eg. call)
  	        int indexIntoObjectArrayForArguments=0;
  	        int indexIntoCallbackMethodForArguments = 0;
  	        if (shadow.hasThis()) {
  	        	if (relatedPointcutBindsThis) {
  	        		if (!(relatedPointcutBindsTarget && targetIsSameAsThis)) {
  	            		// they have supplied new this as first entry in object array
  	            		 ret.append(InstructionFactory.createLoad(objectArrayType, localProceedArgArray));
  	                     ret.append(Utility.createConstant(fact, 0));
  	                     ret.append(InstructionFactory.createArrayLoad(Type.OBJECT));
  	                     ret.append(Utility.createConversion(fact,Type.OBJECT,callbackMethod.getArgumentTypes()[0]));
  	                     indexIntoCallbackMethodForArguments++;
  	        		 }
  	                indexIntoObjectArrayForArguments=1;
  	        	} else {
  	        		// use local variable 0 (which is 'this' for a non-static method)
  	        		ret.append(new ALOAD(0));
  	            	indexIntoCallbackMethodForArguments++;
  	        	}
  	        }
  	        
  	        if (shadow.hasTarget()) {
  	        	if (relatedPointcutBindsTarget) {
  	        		if (shadow.getKind().isTargetSameAsThis()) {
  	        			 ret.append(InstructionFactory.createLoad(objectArrayType, localProceedArgArray));
  	                     ret.append(Utility.createConstant(fact, relatedPointcutBindsThis?1:0));
  	                     ret.append(InstructionFactory.createArrayLoad(Type.OBJECT));
  	                     ret.append(Utility.createConversion(fact,Type.OBJECT,callbackMethod.getArgumentTypes()[0]));
  	                     indexIntoObjectArrayForArguments++;
  	                     indexIntoCallbackMethodForArguments++;
  	        		} else {
  	        			 int position =(shadow.hasThis()&& relatedPointcutBindsThis?1:0);
  	           			 ret.append(InstructionFactory.createLoad(objectArrayType, localProceedArgArray));
  	                     ret.append(Utility.createConstant(fact, position));
  	                     ret.append(InstructionFactory.createArrayLoad(Type.OBJECT));
  	                     ret.append(Utility.createConversion(fact,Type.OBJECT,callbackMethod.getArgumentTypes()[position]));
  	                     indexIntoObjectArrayForArguments=position+1;
  	             		 indexIntoCallbackMethodForArguments++;
  	        		}
  	        	} else {
  	            	if (shadow.getKind().isTargetSameAsThis()) {
  	            		//ret.append(new ALOAD(0));
  	            	} else {
  	            		ret.append(InstructionFactory.createLoad(localAdviceMethod.getArgumentTypes()[0],shadow.hasThis()?1:0));
  	            		indexIntoCallbackMethodForArguments++;
  	            	}
  	        	}
  	        }
  	        
  	        
  	        for (int i = indexIntoCallbackMethodForArguments, len=callbackMethod.getArgumentTypes().length; i < len; i++) {
  	            Type stateType = callbackMethod.getArgumentTypes()[i];
  	            BcelWorld.fromBcel(stateType).resolve(shadow.world);
  	            if ("Lorg/aspectj/lang/JoinPoint;".equals(stateType.getSignature())) {
  	                ret.append(new ALOAD(localJp));// from localAdvice signature
  	            } else {
  	                ret.append(InstructionFactory.createLoad(objectArrayType, localProceedArgArray));
  	                ret.append(Utility.createConstant(fact, i-indexIntoCallbackMethodForArguments +indexIntoObjectArrayForArguments));
  	                ret.append(InstructionFactory.createArrayLoad(Type.OBJECT));
  	                ret.append(Utility.createConversion(
  	                        fact,
  	                        Type.OBJECT,
  	                        stateType
  	                ));
  	            }
  	        }
  	
  	    } else {
  	        Type proceedingJpType = Type.getType("Lorg/aspectj/lang/ProceedingJoinPoint;");
  	        int localJp = localAdviceMethod.allocateLocal(proceedingJpType);
  	        ret.append(InstructionFactory.createStore(proceedingJpType, localJp));
  	
  	        for (int i = 0, len=callbackMethod.getArgumentTypes().length; i < len; i++) {
  	            Type stateType = callbackMethod.getArgumentTypes()[i];
  	            BcelWorld.fromBcel(stateType).resolve(shadow.world);
  	            if ("Lorg/aspectj/lang/JoinPoint;".equals(stateType.getSignature())) {
  	                ret.append(new ALOAD(localJp));// from localAdvice signature
  	//                } else if ("Lorg/aspectj/lang/ProceedingJoinPoint;".equals(stateType.getSignature())) {
  	//                    //FIXME ALEX?
  	//                        ret.append(new ALOAD(localJp));// from localAdvice signature
  	////                        ret.append(fact.createCheckCast(
  	////                                (ReferenceType) BcelWorld.makeBcelType(stateTypeX)
  	////                    ));
  	//                        // cast ?
  	//
  	            } else {
  	                ret.append(InstructionFactory.createLoad(stateType, i));
  	            }
  	        }
  	    }
  	
  	    // do the callback invoke
  	    ret.append(Utility.createInvoke(fact, callbackMethod));
  	
  	    // box it again. Handles cases where around advice does return something else than Object
  	    if (!UnresolvedType.OBJECT.equals(getSignature().getReturnType())) {
  	        ret.append(Utility.createConversion(
  	                fact,
  	                callbackMethod.getReturnType(),
  	                Type.OBJECT
  	        ));
  	    }
  	    ret.append(Utility.createConversion(
  	            fact,
  	            callbackMethod.getReturnType(),
  	            BcelWorld.makeBcelType(getSignature().getReturnType())
  	    ));
  	
  	    return ret;
  	
  	//
  	//
  	//
  	//            if (proceedMap.hasKey(i)) {
  	//                ret.append(new ALOAD(i));
  	//                //throw new RuntimeException("unimplemented");
  	//                //proceedVars[proceedMap.get(i)].appendLoadAndConvert(ret, fact, stateTypeX);
  	//            } else {
  	//                //((BcelVar) argVarList.get(i)).appendLoad(ret, fact);
  	//                //ret.append(new ALOAD(i));
  	//                if ("Lorg/aspectj/lang/JoinPoint;".equals(stateType.getSignature())) {
  	//                    ret.append(new ALOAD(i));
  	//                } else {
  	//                    ret.append(new ALOAD(i));
  	//                }
  	//            }
  	//        }
  	//
  	//        ret.append(Utility.createInvoke(fact, callbackMethod));
  	//        ret.append(Utility.createConversion(fact, callbackMethod.getReturnType(),
  	//                BcelWorld.makeBcelType(munger.getSignature().getReturnType())));
  	//
  	//        //ret.append(new ACONST_NULL());//will be POPed
  	//        if (true) return ret;
  	//
  	//
  	//
  	//        // we have on stack all the arguments for the ADVICE call.
  	//        // we have in frame somewhere all the arguments for the non-advice call.
  	//
  	//        BcelVar[] adviceVars = munger.getExposedStateAsBcelVars();
  	//        IntMap proceedMap =  makeProceedArgumentMap(adviceVars);
  	//
  	//        System.out.println(proceedMap + " for " + this);
  	//        System.out.println(argVarList);
  	//
  	//        ResolvedType[] proceedParamTypes =
  	//            world.resolve(munger.getSignature().getParameterTypes());
  	//        // remove this*JoinPoint* as arguments to proceed
  	//        if (munger.getBaseParameterCount()+1 < proceedParamTypes.length) {
  	//            int len = munger.getBaseParameterCount()+1;
  	//            ResolvedType[] newTypes = new ResolvedType[len];
  	//            System.arraycopy(proceedParamTypes, 0, newTypes, 0, len);
  	//            proceedParamTypes = newTypes;
  	//        }
  	//
  	//        //System.out.println("stateTypes: " + Arrays.asList(stateTypes));
  	//        BcelVar[] proceedVars =
  	//            Utility.pushAndReturnArrayOfVars(proceedParamTypes, ret, fact, localAdviceMethod);
  	//
  	//        Type[] stateTypes = callbackMethod.getArgumentTypes();
  	////		System.out.println("stateTypes: " + Arrays.asList(stateTypes));
  	//
  	//        for (int i=0, len=stateTypes.length; i < len; i++) {
  	//            Type stateType = stateTypes[i];
  	//            ResolvedType stateTypeX = BcelWorld.fromBcel(stateType).resolve(world);
  	//            if (proceedMap.hasKey(i)) {
  	//                //throw new RuntimeException("unimplemented");
  	//                proceedVars[proceedMap.get(i)].appendLoadAndConvert(ret, fact, stateTypeX);
  	//            } else {
  	//                ((BcelVar) argVarList.get(i)).appendLoad(ret, fact);
  	//            }
  	//        }
  	//
  	//        ret.append(Utility.createInvoke(fact, callbackMethod));
  	//        ret.append(Utility.createConversion(fact, callbackMethod.getReturnType(),
  	//                BcelWorld.makeBcelType(munger.getSignature().getReturnType())));
  	//        return ret;
  	}

  */

  	
  	


	
	
}