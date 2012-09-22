package org.aspectj.weaver.bcel;

import org.aspectj.apache.bcel.Constants;
import org.aspectj.apache.bcel.generic.*;
import org.aspectj.bridge.ISourceLocation;
import org.aspectj.weaver.AjcMemberMaker;
import org.aspectj.weaver.BCException;
import org.aspectj.weaver.IntMap;
import org.aspectj.weaver.Member;
import org.aspectj.weaver.MemberImpl;
import org.aspectj.weaver.NameMangler;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.ResolvedMember;
import org.aspectj.weaver.ResolvedType;
import org.aspectj.weaver.ShadowMunger;
import org.aspectj.weaver.UnresolvedType;
import org.aspectj.weaver.WeaverMessages;
import org.aspectj.weaver.Shadow.Kind;
import org.aspectj.weaver.ast.Var;
import org.aspectj.weaver.patterns.AndPointcut;
import org.aspectj.weaver.patterns.NotPointcut;
import org.aspectj.weaver.patterns.OrPointcut;
import org.aspectj.weaver.patterns.ThisOrTargetPointcut;

import java.lang.reflect.Modifier;
import java.util.*;

public class ProceedComputation {
	// Associated Shadow
	private BcelShadow shadow;
    //Keep this for convenience. Can be obtained via shadow.
	private BcelWorld world;

	//Computed fields.
	private LazyMethodGen computationMethod;
	private LazyClassGen closureClass;
	private InstructionList computation;
	//this will likely be removed later.
	//quick fix.
	private BcelVar closureHolder;

	public ProceedComputation(BcelShadow shadow, IntMap proceedMap) {
		this.shadow = shadow;
		this.world = shadow.getWorld();
		
		computationMethod = extractMethod();
		shadow.setComputationMethod(computationMethod);
		
		String closureClassName =     		
			NameMangler.makeClosureClassName(
    			shadow.getEnclosingClass().getType(),
    			shadow.getEnclosingClass().getNewGeneratedNameTag());	
		computation = genComputation(closureClassName);		
		closureClass = makeClosureClass(closureClassName, computationMethod, proceedMap);
	}

	
	public InstructionList getComputation() {
		return computation;
	}
	
	public LazyMethodGen getComputationMethod() {
		return computationMethod;
	}

	public LazyClassGen getClosureClass() {
		return closureClass;
	}

	public BcelVar getClosureHolder() {
		return closureHolder;
	}

	/**
	 * Constructs a list of instructions that instantiate the closure class.
	 * The instructions form an array of arguments to be passed to 
	 * the clousure class's constructor. The array packs context objects 
	 * (this, target, thisJoinPoint, and arguments) that are stored in
	 * the temp variables in the frame of the shadow's enclosing method.
	 * These instructions can only be introduced instead of the shadow 
	 * (into the enclosing method of the shadow), or be preprocessed, 
	 * if they are to be introduced anywhere else.
	 * 
	 *  
	 * @param closureClassName
	 *            a name of the closure class
	 *            
	 * @return a list of instructions that call the constructor method by
	 *         passing it a shadow's context (e.g., this, target, args, tjp) as
	 *         an object array.
	 */
	private InstructionList genComputation(String closureClassName) {
		Kind kind = shadow.getKind();
		BcelVar thisVar = shadow.getThisVarField();
		BcelVar targetVar = shadow.getTargetVarField();
		BcelVar[] argVars = shadow.getArgVarsField();
		// TODO: AJ-specific. To be removed later.
		BcelVar thisJoinPointVar = (BcelVar) shadow.getThisJoinPointVar();
		BcelVar arrayVar = shadow.genTempVar(UnresolvedType.OBJECTARRAY);
		int argCount = shadow.getArgCount();
		InstructionFactory fact = shadow.getFactory();

		final InstructionList il = new InstructionList();

		//constructor for a new class.		
    	Member constructor = new MemberImpl(Member.CONSTRUCTOR, 
    								UnresolvedType.forName(closureClassName), 0, "<init>", 
    								"([Ljava/lang/Object;)V");
    	//BcelVar holder = null;
    	// AJ GUYS: This is not being used currently since getKind() == preinitializaiton
    	// cannot happen in around advice
    	if (kind == Shadow.PreInitialization) {
    		closureHolder = shadow.genTempVar(AjcMemberMaker.AROUND_CLOSURE_TYPE);
    	}

		
		
		// TODO: thisJoinPoint is AJ-specific. Should be removed later.
		int alen = argCount + (thisVar == null ? 0 : 1)
				+ ((targetVar != null && targetVar != thisVar) ? 1 : 0)
				+ (thisJoinPointVar == null ? 0 : 1);

		il.append(Utility.createConstant(fact, alen));
		il.append((Instruction) fact.createNewArray(Type.OBJECT, (short) 1));
		arrayVar.appendStore(il, fact);

		int stateIndex = 0;
		if (thisVar != null) {
			arrayVar.appendConvertableArrayStore(il, fact, stateIndex, thisVar);
			thisVar.setPositionInAroundState(stateIndex);
			stateIndex++;
		}
		if (targetVar != null && targetVar != thisVar) {
			arrayVar.appendConvertableArrayStore(il, fact, stateIndex,
					targetVar);
			targetVar.setPositionInAroundState(stateIndex);
			stateIndex++;
		}
		for (int i = 0, len = argCount; i < len; i++) {
			arrayVar.appendConvertableArrayStore(il, fact, stateIndex,
					argVars[i]);
			argVars[i].setPositionInAroundState(stateIndex);
			stateIndex++;
		}
		// TODO: thisJoinPoint is AJ-specific. Should be removed later.
		if (thisJoinPointVar != null) {
			arrayVar.appendConvertableArrayStore(il, fact, stateIndex,
					thisJoinPointVar);
			thisJoinPointVar.setPositionInAroundState(stateIndex);
			stateIndex++;
		}

		// SK: adds instruction that creates a new object
		il.append(fact.createNew(new ObjectType(constructor.getDeclaringType()
				.getName())));
		il.append(InstructionFactory.DUP);
		// SK: the array is loaded on the stack
		arrayVar.appendLoad(il, fact);
		// SK: constructor is invoked (and the result is placed on the stack)
		il.append(Utility.createInvoke(fact, world, constructor));

		// TODO: figure out if this is necessary:
		if (kind == Shadow.PreInitialization) {
			il.append(InstructionConstants.DUP);
			closureHolder.appendStore(il, fact);
		}
		return il;
	}

	
	/**
	 * Creates a closure class as an inner class of the shadow's enclosing class. 
	 * The closure class is a subclass of the abstract 
	 * <code>org.aspectj.runtime.internal.AroundClosure</code>
	 * class. 
	 * The closure class implements a new constructor, and a run method
	 * (that is abstract in the superclass).
	 * 
	 * The constructor takes an array of shadow's context objects as an argument. 
	 * We call this array a state array. The constructor stores the state array 
	 * in the state of a closure object.
	 * 
	 * The run method basically wraps around the computation method.
	 * The run method takes as argument another array of context objects
	 * that we call a proceed array.
	 * A responsibility of the run method is to pass proper context objects 
	 * to the computation method. It draws the context objects from both 
	 * state and proceed arrays as follows: 
	 *   first, an attempt is made to assign a computation method argument 
	 *   an object from the proceed array. 
	 *   If proceed array does not provide an object for this particular 
	 *   argument, then this object is taken from the state array.
	 * 	 * 
	 * 
	 * @param callbackMethod
	 *            the computation method that is wrapped by the run method.
	 * 
	 * @param proceedMap
	 *            A map from state position to proceed argument position. 
	 *            May not cover all state positions.
	 */

	private LazyClassGen makeClosureClass(
			String closureClassName, LazyMethodGen callbackMethod,
			IntMap proceedMap) {
		LazyClassGen enclosingClass = shadow.getEnclosingClass();
		Kind kind = shadow.getKind();
		
		String superClassName = "org.aspectj.runtime.internal.AroundClosure";
		Type objectArrayType = new ArrayType(Type.OBJECT, 1);
		LazyClassGen closureClass = 
			new LazyClassGen(closureClassName,
				superClassName, enclosingClass.getFileName(), 
				Modifier.PUBLIC, new String[] {}, world);

		InstructionFactory fact = new InstructionFactory(closureClass.getConstantPool());
		// constructor
		LazyMethodGen constructor = new LazyMethodGen(Modifier.PUBLIC,
				Type.VOID, "<init>", new Type[] { objectArrayType },
				new String[] {}, closureClass);
		InstructionList cbody = constructor.getBody();
		// SK: loading on the stack this closure object
		cbody.append(InstructionFactory.createLoad(Type.OBJECT, 0));
		// SK: loading the object array (with shadow context) on the stack
		cbody.append(InstructionFactory.createLoad(objectArrayType, 1));
		// SK: invoking super class constructor
		cbody.append(fact.createInvoke(superClassName, "<init>", Type.VOID,
				new Type[] { objectArrayType }, Constants.INVOKESPECIAL));
		// SK: return ???
		cbody.append(InstructionFactory.createReturn(Type.VOID));

		closureClass.addMethodGen(constructor);

		LazyMethodGen runMethod = new LazyMethodGen(Modifier.PUBLIC,
				Type.OBJECT, "run", new Type[] { objectArrayType },
				new String[] {}, closureClass);
		InstructionList mbody = runMethod.getBody();
		// SK: variable that holds an array passed to the run method as an
		// argument.
		// Array objects are new argument values that are passed to proceed
		BcelVar proceedVar = new BcelVar(UnresolvedType.OBJECTARRAY
				.resolve(world), 1);
		// int proceedVarIndex = 1;
		// SK: this guy is supposed to refer to the AroundClosure.state field
		// It contains arguments that are passed to the around advice method
		BcelVar stateVar = new BcelVar(UnresolvedType.OBJECTARRAY
				.resolve(world), runMethod.allocateLocal(1));
		// int stateVarIndex = runMethod.allocateLocal(1);
		// SK: "stateVar = this.state"
		mbody.append(InstructionFactory.createThis());
		mbody.append(fact.createGetField(superClassName, "state",
				objectArrayType));
		mbody.append(stateVar.createStore(fact));
		// mbody.append(fact.createStore(objectArrayType, stateVarIndex));
		// SK: callbackMethod.getArgTypes() = argTypes + targetType + thisType +
		// tjpType
		Type[] stateTypes = callbackMethod.getArgumentTypes();
		// SK: loading on the stack shadow's context?
		// SK: proceedMap maps indeces of this/target/args/jp
		// objects in the AroundClosure.state array
		// (that are the same as numbers of corresponding formals of the
		// callBackMethod)
		// to indeces of corresponding objects in the argument proceedVar array.
		// The proceedVar objects replace the stateVar objects as arguments
		// to the callBackMethod
		for (int i = 0, len = stateTypes.length; i < len; i++) {
			Type stateType = stateTypes[i];
			ResolvedType stateTypeX = BcelWorld.fromBcel(stateType).resolve(
					world);
			if (proceedMap.hasKey(i)) {
				mbody.append(
				// loading on the stack the following:
						// "(StateTypeX)proceedVar[proceedMap.get(i)]"
						// where stateTypeX is a type of i'th argument of the
						// callback method
						proceedVar.createConvertableArrayLoad(fact, proceedMap
								.get(i), stateTypeX));
			} else {
				mbody
						.append(
						// "(StateTypeX)stateVar[i]"
						stateVar
								.createConvertableArrayLoad(fact, i, stateTypeX));
			}
		}

		// SK: once all context objects are on the stack, the callBackMethod is
		// invoked.
		mbody.append(Utility.createInvoke(fact, callbackMethod));

		if (kind == Shadow.PreInitialization) {
			mbody.append(Utility.createSet(fact, AjcMemberMaker
					.aroundClosurePreInitializationField()));
			mbody.append(InstructionConstants.ACONST_NULL);
		} else {
			// converts the computation's result (that can be primitive) 
			// to java.lang.Object
			mbody.append(Utility.createConversion(fact, callbackMethod
					.getReturnType(), Type.OBJECT));
		}
		// And finally the return instruction (that returns Object)
		mbody.append(InstructionFactory.createReturn(Type.OBJECT));

		closureClass.addMethodGen(runMethod);
		enclosingClass.addGeneratedInner(closureClass);
		return closureClass;
	}

	// ====== Extracts the shadow into a method =================
	private LazyMethodGen extractMethod() {
		LazyClassGen enclosingClass = shadow.getEnclosingClass();
		Member signature = shadow.getSignature();
		//String methodName = NameMangler.aroundCallbackMethodName(signature,
		//		enclosingClass);
		
		String methodName = NameMangler.aroundShadowMethodName(signature, 
				enclosingClass.getNewGeneratedNameTag());

		return extractMethod(methodName, 0);
	}

	/**
	 * Copied from the BcelShadow class.
	 * 
	 * Extracts the shadow's "meat" instructions into a new method. Invokation
	 * of the new method thus runs the shadow's computation. The method is
	 * passed this, target, args, and thisJoinPoint objects, and returns the
	 * result of the computation. The return type of the new method is normally
	 * the same as the return type of the shadow's signature.
	 * 
	 * The new method is introduced into the enclosingType class. The body of
	 * the method contains the original content of the shadow. After the
	 * extraction, the extracted instructions are deleted from the body of the
	 * range. However, range is still associated with the same start and end
	 * instructions, AND it is physically located in the same enclosingMethod as
	 * before. All shadows that were associated with the extracted instructions
	 * are retargeted to corresponding instructions within the new method. (@see
	 * ShadowRange.extractInstructionsInto)
	 */
	private LazyMethodGen extractMethod(String newMethodName,
			int visibilityModifier) {
		ShadowRange range = shadow.getRange();
		Kind kind = shadow.getKind();
		LazyClassGen enclosingClass = shadow.getEnclosingClass();
		LazyMethodGen freshMethod = createMethodGen(newMethodName,
				visibilityModifier);

		boolean addReturn = (kind != Shadow.PreInitialization)
				&& (range.getRealNext() != null);

		range.extractInstructionsInto(freshMethod, makeRemap(), addReturn);

		if (kind == Shadow.PreInitialization)
			addPreInitializationReturnCode(freshMethod);

		enclosingClass.addMethodGen(freshMethod);
		return freshMethod;
	}

	/**
	 * Taken from the BcelShadow class.
	 * 
	 * Creates a new method in the enclosingClass of the shadow. Mostly
	 * responsible for creating a right signature for this method. The signature
	 * comprises this, target, arguments, and thisJoinPoint as formals. For most
	 * shadows, the return type is the same as the return type of the shadow's
	 * signature.
	 */
	private LazyMethodGen createMethodGen(String newMethodName,
			int visibilityModifier) {
		Kind kind = shadow.getKind();
		Member signature = shadow.getSignature();
		BcelVar thisVar = shadow.getThisVarField();
		BcelVar targetVar = shadow.getTargetVarField();
		// TODO: AJ-specific. To be removed later.
		BcelVar thisJoinPointVar = (BcelVar) shadow.getThisJoinPointVar();
		UnresolvedType[] argTypes = shadow.getArgTypes();
		LazyClassGen enclosingClass = shadow.getEnclosingClass();
		UnresolvedType thisType;;

		Type[] parameterTypes = BcelWorld.makeBcelTypes(argTypes);
		int modifiers = Modifier.FINAL | visibilityModifier | Modifier.STATIC;


		if (targetVar != null && targetVar != thisVar) {
			UnresolvedType targetType = signature.getDeclaringType();
			// TODO: the following takes care of problem that occurs
			// when a clone method is called on an array object.
			// It is actually important, and needs to be revisited later
			// targetType = ensureTargetTypeIsCorrect(targetType);

			// TODO: take care of that later.
			// see pr109728 - this fixes the case when the declaring class is
			// sometype 'X' but the getfield
			// in the bytecode refers to a subtype of 'X'. This makes sure we
			// use the type originally
			// mentioned in the fieldget instruction as the method parameter and
			// *not* the type upon which the
			// field is declared because when the instructions are extracted
			// into the new around body,
			// they will still refer to the subtype.
			/*
			 * if (kind==Shadow.FieldGet && getActualTargetType()!=null &&
			 * !getActualTargetType().equals(targetType.getName())) { targetType =
			 * UnresolvedType.forName(getActualTargetType()).resolve(world); }
			 */

			ResolvedMember resolvedMember = signature.resolve(world);
			

			if (resolvedMember != null
					&& Modifier.isProtected(resolvedMember.getModifiers())
					&& !samePackage(targetType.getPackageName(), enclosingClass
							.getType().getPackageName())
					&& !resolvedMember.getName().equals("clone")) {
				thisType = shadow.getThisType();
				//System.out.println("shadow:"+shadow);
				//System.out.println("thisType:"+thisType);
				//System.out.println("targetType:"+targetType);
				//System.out.println("targetType.resolve(world)." +
				//		"isAssignableFrom("+
				//		"thisType.resolve(world))="+
				//		targetType.resolve(world).isAssignableFrom(thisType.resolve(world))
				//		);
				

				if (!targetType.resolve(world).isAssignableFrom(
						thisType.resolve(world)))
					throw new BCException("bad bytecode");
				targetType = thisType;
			}
			parameterTypes = addType(BcelWorld.makeBcelType(targetType),
					parameterTypes);
		}

		if (thisVar != null) {
			thisType = shadow.getThisType();
			parameterTypes = addType(BcelWorld.makeBcelType(thisType),
					parameterTypes);
		}

		// TODO: thisJoinPoint is AJ-specific. Should be removed later.
		// We always want to pass down thisJoinPoint in case we have already
		// woven some advice in here. If we only have a single piece of around
		// advice
		// on a join point, it is unnecessary to accept (and pass) tjp.
		if (thisJoinPointVar != null)
			parameterTypes = addTypeToEnd(LazyClassGen.tjpType, parameterTypes);

		UnresolvedType returnType;
		if (kind == Shadow.PreInitialization) {
			returnType = UnresolvedType.OBJECTARRAY;
		} else {
			if (kind == Shadow.ConstructorCall)
				returnType = signature.getDeclaringType();
			else if (kind == Shadow.FieldSet)
				returnType = ResolvedType.VOID;
			else
				returnType = signature.getReturnType().resolve(world);
		}
		return new LazyMethodGen(modifiers, BcelWorld.makeBcelType(returnType),
				newMethodName, parameterTypes, new String[0], enclosingClass);
	}

	/**
	 * make a map from old frame location to new frame location. Any unkeyed
	 * frame location picks out a copied local SK: Maps slot numbers of argVars,
	 * tjpvar, thisVar, targetVar (in the caller frame) to positions of
	 * corresponding vars in a new frame.
	 * 
	 */
	private IntMap makeRemap() {
		Kind kind = shadow.getKind();
		BcelVar thisVar = shadow.getThisVarField();
		BcelVar targetVar = shadow.getTargetVarField();
		BcelVar[] argVars = shadow.getArgVarsField();
		// TODO: AJ-specific. To be removed later.
		BcelVar thisJoinPointVar = (BcelVar) shadow.getThisJoinPointVar();

		IntMap ret = new IntMap(5);
		int reti = 0;
		if (thisVar != null) {
			ret.put(0, reti++); // thisVar guaranteed to be 0
		}
		if (targetVar != null && targetVar != thisVar) {
			ret.put(targetVar.getSlot(), reti++);
		}
		for (int i = 0, len = argVars.length; i < len; i++) {
			ret.put(argVars[i].getSlot(), reti);
			reti += argVars[i].getType().getSize();
		}

		// TODO: thisJoinPoint is AJ-specific. Should be removed later.
		if (thisJoinPointVar != null) {
			ret.put(thisJoinPointVar.getSlot(), reti++);
		}

		// we not only need to put the arguments, we also need to remap their
		// aliases, which we so helpfully put into temps at the beginning of
		// this join point.
		// SK: this thing basically fills the ret map with (0,0),
		// (1,1),...,(n,n)
		// pairs for this and arguments. Why?
		if (!kind.argsOnStack()) { // if this==target
			int oldi = 0;
			int newi = 0;
			// if we're passing in a this and we're not argsOnStack we're always
			// passing in a target too
			if (shadow.arg0HoldsThis()) {
				ret.put(0, 0);
				oldi++;
				newi += 1;
			}
			// assert targetVar == thisVar
			UnresolvedType[] argTypes = shadow.getArgTypes();
			for (int i = 0; i < argTypes.length; i++) {
				UnresolvedType type = argTypes[i];
				ret.put(oldi, newi);
				oldi += type.getSize();
				newi += type.getSize();
			}
		}
		return ret;
	}

	/**
	 * Appends extra instructions to the extractedMethod's body that are only
	 * required for PreInitialization shadows.
	 * 
	 * @param extractedMethod
	 */
	private void addPreInitializationReturnCode(LazyMethodGen extractedMethod) {
		if (shadow.getKind() != Shadow.PreInitialization)
			return;
		ShadowRange range = shadow.getRange();
		LazyClassGen enclosingClass = shadow.getEnclosingClass();
		InstructionFactory fact = shadow.getFactory();

		InstructionHandle superCallHandle = range.getEnd().getNext();
		InvokeInstruction superCallInstruction = (InvokeInstruction) superCallHandle
				.getInstruction();
		Type[] superConstructorTypes = superCallInstruction
				.getArgumentTypes(enclosingClass.getConstantPool());

		InstructionList body = extractedMethod.getBody();
		BcelVar arrayVar = new BcelVar(world
				.getCoreType(UnresolvedType.OBJECTARRAY), extractedMethod
				.allocateLocal(1));
		// appending to the method this:
		// "Object[] arrayVar = new Object[superConstructorTypes.length];"
		int len = superConstructorTypes.length;
		body.append(Utility.createConstant(fact, len));
		body.append((Instruction) fact.createNewArray(Type.OBJECT, (short) 1));
		arrayVar.appendStore(body, fact);

		// generating:
		// "for (int i=0;i<superConstructorTypes.length;i++)
		// arrayVar[i] = (Object)valuesPassedToASuperConstructor[i]"
		// where valuesPassedToASuperConstructor are values on the
		// stack that are ready to be passed to the super constructor.
		for (int i = len - 1; i >= 0; i++) {
			// convert thing on top of stack to object
			body.append(Utility.createConversion(fact,
					superConstructorTypes[i], Type.OBJECT));
			// push object array
			arrayVar.appendLoad(body, fact);
			// swap
			body.append(InstructionConstants.SWAP);
			// do object array store.
			body.append(Utility.createConstant(fact, i));
			body.append(InstructionConstants.SWAP);
			body.append(InstructionFactory.createArrayStore(Type.OBJECT));
		}
		// "return arrayVar;"
		arrayVar.appendLoad(body, fact);
		body.append(InstructionConstants.ARETURN);
	}

	// /======================== Dumb methods
	// Do we need it?
	private boolean samePackage(String p1, String p2) {
		if (p1 == null)
			return p2 == null;
		if (p2 == null)
			return false;
		return p1.equals(p2);
	}

	private Type[] addType(Type type, Type[] types) {
		int len = types.length;
		Type[] ret = new Type[len + 1];
		ret[0] = type;
		System.arraycopy(types, 0, ret, 1, len);
		return ret;
	}

	private Type[] addTypeToEnd(Type type, Type[] types) {
		int len = types.length;
		Type[] ret = new Type[len + 1];
		ret[len] = type;
		System.arraycopy(types, 0, ret, 0, len);
		return ret;
	}

}
