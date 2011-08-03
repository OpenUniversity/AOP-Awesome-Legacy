package coolplugin;

import java.lang.reflect.Modifier;
import awesome.platform.AbstractWeaver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import org.aspectj.weaver.bcel.*;
import org.aspectj.weaver.Member;
import org.aspectj.weaver.ResolvedMember;
import org.aspectj.weaver.ResolvedMemberImpl;
import org.aspectj.weaver.MemberImpl;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.UnresolvedType;
import org.aspectj.weaver.ResolvedType;
import org.aspectj.apache.bcel.classfile.annotation.*;
import org.aspectj.weaver.AnnotationAJ;
import org.aspectj.weaver.bcel.BcelMethod;
import org.aspectj.weaver.bcel.BcelShadow;
import awesome.platform.IEffect;
import org.aspectj.weaver.bcel.LazyClassGen;
import org.aspectj.weaver.bcel.LazyMethodGen;
import awesome.platform.MultiMechanism;
import org.aspectj.weaver.IClassFileProvider;
import org.aspectj.weaver.bcel.UnwovenClassFile;
import org.aspectj.weaver.bcel.BcelWorld;
import org.aspectj.apache.bcel.generic.*;
import org.aspectj.apache.bcel.classfile.ConstantPool;

import org.aspectj.bridge.ISourceLocation;
import com.sun.org.apache.bcel.internal.Constants;

public privileged aspect COOLWeaver extends AbstractWeaver {

	// aspects to target classes
	private Map<UnresolvedType, UnresolvedType> aspects = new HashMap<UnresolvedType, UnresolvedType>();

	// target classes to aspect classes
	private Map<UnresolvedType, UnresolvedType> targets = new HashMap<UnresolvedType, UnresolvedType>();

	private Map<Member, IEffect> lockMapping = new HashMap<Member, IEffect>();

	private Map<Member, IEffect> unlockMapping = new HashMap<Member, IEffect>();

	// private Map<ResolvedMember, Member> targetMethods = null;
	private COOLTypeMunger typeMunger;

	Map<String, List<IEffect>> classToEffects = new HashMap<String,  List<IEffect>>();
	
	public List<IEffect> getEffects(LazyClassGen aspectClazz)
	{
		List<IEffect> effects = classToEffects.get(aspectClazz.getName());		
		return effects;
	}
	
	public boolean handledByMe(LazyClassGen aspectClazz)
	{
		return isCOOLAspect(aspectClazz.getType());
	}
	
	boolean around(MultiMechanism mm, LazyClassGen cg) :
		transformClass(mm, cg) {
		try {			
			boolean result = false;
			UnresolvedType cgUType = Utils.getUnresolvedType(cg);
			//System.out.println("around transform: type  " + cgUType);
			UnresolvedType targetType = aspects.get(cg.getType());
			UnresolvedType aspectType = targets.get(cgUType);
			if (targetType != null) { // cg is an aspect class
				//System.out.println("around transform: targetType " + targetType);
				typeMunger.transformAspectClass(cg, targetType);
				result = true;
			} else if (aspectType != null) { // cg is a target class
				//System.out.println("around transform: aspectType " + aspectType);
				typeMunger.transformTargetClass(cg, aspectType);
				result = true;
			}

			result = proceed(mm, cg) || result;
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * If cg is a COOL aspect class, then its reify process is done internally by the COOL 
	 * aspect mechanism (instead of MM.reify(..)). See the documentation of the internal
	 * reify method for details.
	 * @param mm
	 * @param cg
	 * @return
	 */
	List<BcelShadow> around(MultiMechanism mm, LazyClassGen cg) :
		reifyClass(mm, cg) {
		UnresolvedType classUType = Utils.getUnresolvedType(cg);
		UnresolvedType targetType = getTargetType(classUType);
		// System.out.println("isSpecial? target type = " + targetType);
		return (targetType == null) ? proceed(mm, cg) : reify(mm, cg);
	}

	
	/**
	 * This advice advises MM.reify(LazyMethodGen mg). If mg is a synthetic method,
	 * it is not reified. Synthetic method = a getter method added to a target class (in the
	 * first advice).
	 * @param mm
	 * @param mg
	 * @return
	 */
	List<BcelShadow> around(MultiMechanism mm, LazyMethodGen mg) :
	  reifyMethod(mm, mg) {
		if (typeMunger.isSynthetic(mg))
			return null;
		else
			return proceed(mm, mg);
	}

	List<BcelShadow> around(MultiMechanism mm, InstructionHandle ih,
			LazyMethodGen mg, BcelShadow encl) : reifyInstr(mm, ih, mg, encl) {
		LazyClassGen clazz = mg.getEnclosingClass();
		Instruction i = ih.getInstruction();
		if (getTargetType(Utils.getUnresolvedType(clazz)) != null) {
			if (mg.getName().equals("<init>")) {
				if (!((i.opcode == Constants.PUTFIELD) && 
						isAccessToCOOLField(clazz, (FieldInstruction)i)))
					return null;
			} else if (i instanceof InvokeInstruction) {
			ConstantPool cpg = clazz.getConstantPool();
			InvokeInstruction ii = (InvokeInstruction) i;
			UnresolvedType tgtType = BcelWorld.fromBcel(ii.getClassType(cpg));
			// System.out.println("Invoke instruction: target type (class):
			// "+tgtType.getSignature());
			String mname = ii.getMethodName(cpg);
			// System.out.println("Invoke instruction: target method name:
			// "+mname);
			ResolvedMember extField = typeMunger.getExternalField(tgtType,
					mname);
			if (extField != null) {
				int modifiers = extField.getModifiers();
				// if it is protected, it will cause AspectJ to throw
				// an exception in ProceedComputation.createMethodGen
				if (Modifier.isProtected(modifiers)) {
					// setting the PROTECTED bit to 0
					modifiers = Modifier.PROTECTED ^ modifiers;
					modifiers = modifiers | Modifier.PRIVATE;
						extField = new ResolvedMemberImpl(Member.FIELD,
								extField.getDeclaringType(), modifiers,
								extField.getReturnType(), extField.getName(),
								UnresolvedType.NONE, UnresolvedType.NONE);
				}
				// System.out.println("Invoke instruction targets getter
				// method.
				// " +
				// "Returning a field-get shadow that targets field
				// "+extField.getName());
				List<BcelShadow> result = new ArrayList<BcelShadow>();
				result.add(BcelShadow.makeFieldGet(world, extField, mg, ih,
						encl));
				return result;
			}
		}
		}
		return proceed(mm, ih, mg, encl);
	}

    public List<IEffect> match(BcelShadow shadow) {
		LazyClassGen enclClass = shadow.getEnclosingClass();
		UnresolvedType enclType = Utils.getUnresolvedType(enclClass);		
		UnresolvedType aspectClass = targets.get(enclType);
		//UnresolvedType aspectClass = getTargetType(enclType);
		
		//System.out.println("Matching a class "+ enclClass + " " +
		//		" aspect = " + aspectClass);
		/*
		System.out.println("baseName "+ enclClass.getName());
		System.out.println("targets :"+ targets.entrySet());
		System.out.println("targets :"+ targets.keySet());
		*/
		// not interested in non-advisable classes
		if (aspectClass == null)
		{
			return null;
		}

		//System.out.println("*** Matching a shadow "+
		//		shadow.getEnclosingMethod().getSignature()+" kind: " + shadow.getKind());
		
		// prepareForMatch();
		if (shadow.getKind() == Shadow.MethodExecution) {
			BcelMethod enclMember = shadow.getEnclosingMethod().getMemberView();
			 //System.out.println("Matching a shadow "+
			 //enclMember.getSignature()+":");
			for (Member m : unlockMapping.keySet()) {
				Member tgtMemberSig = MemberImpl.method(enclMember
						.getDeclaringType(), 0, UnresolvedType
						.forName("java.lang.Object"), enclMember.getName(),
						enclMember.getParameterTypes());

				if (tgtMemberSig.equals(m))
				// ResolvedMember rm = m.resolve(world);
				// if (rm == null) continue;
				// if (enclMember.equals(rm) || enclMember.matches(rm))
				/*
				 * || enclMember.toString().equals(rm.toString()) ||
				 * enclMember.toString().equals(m.toString()) ||
				 * (enclMember.getDeclaringType().equals( m.getDeclaringType()) &&
				 * enclMember.getName() .equals(m.getName())) ||
				 * (enclMember.getDeclaringType().equals( rm.getDeclaringType()) &&
				 * enclMember.getName() .equals(rm.getName())))
				 */{
					IEffect lockAdv = lockMapping.get(m);
					IEffect unlockAdv = unlockMapping.get(m);
					if (lockAdv == null || unlockAdv == null)
						continue;
					 //System.out.println("The shadow "+enclMember+"matches: " +
					 //lockAdv + ";"
					 //+ unlockAdv);
					List<IEffect> result = new ArrayList<IEffect>();
					result.add(lockAdv);
					result.add(unlockAdv);
					return result;					
				}
			}
		} else if (shadow.getKind() == Shadow.ConstructorExecution) {
			COOLAssociateEffect eff = new COOLAssociateEffect(aspectClass
					.getName(), enclClass.getClassName(), typeMunger.getCoordFieldName(enclType));
			List<IEffect> result = new ArrayList<IEffect>();
			result.add(eff);
			return result;			
		} else if (shadow.getKind() == Shadow.Initialization) {
			// System.out.println("INITIALIZATION SHADOW!!!");
		}
		return null;
	}	/**
		 * Nothing to be done here for a COOL mechanism.
		 * 
		 */
	public List<IEffect> order(BcelShadow shadow, List<IEffect> effects) {
		return effects;
	}

	/**
	 * clazz is an aspect class. For such a type, COOL mechanism takes control
	 * over the reify process and this method handles that process.
	 * <p>The methods of the aspect class are retrieved and iterated:
	 * <ul>
	 * <li>If the method doesn't have a COOL annotation it is skipped, i.e., not reified.</li>
	 * <li>If the method has LOCK or UNLOCK annotation, it is added to <b>result</b>
	 * (List&ltBcelShadow&gt) as an <b>advice-execution</b> shadow. The process of creating this
	 * shadow involves some lines of code, see inside.</li>
	 * <li>If the method is a constructor ("&ltinit&gt"), its body is reified using the relevant
	 * MM.reify(..) method, and the shadows added to <b>result</b>. Why? because the c'tor implicitly 
	 * holds the initialization
	 * of the private fields of the coordinator which we would like to get reified too (i.e., set-field,
	 * get-field). Note that the c'tor may not be defined by the user (as in BoundedStackCoord).</li>
	 * <li>If the method has annotation of kind REQUIRES, ON_EXIT, or ON_ENTRY, its body is reified as before.
	 * However, note that here the enclosing shadow of the internal reified shadows is set to be LOCK or
	 * UNLOCK shadow. For that, the LOCK/UNLOCK shadows were previously saved
	 * in local fields.</li>
	 * </ul></p>
	 * @param mm
	 * @param clazz an aspect class
	 * @return
	 */
	private List<BcelShadow> reify(MultiMechanism mm, LazyClassGen clazz) {
		// System.out.println("Identifying shadows for a class " + clazz);
		List<LazyMethodGen> methods = new ArrayList(clazz.getMethodGens());
		List<BcelShadow> result = new ArrayList<BcelShadow>();
		// type that is targeted by this coordinator clazz
		// this var is not strictly necessary, it simply allows
		// me to use buildTargetMember method... not more..
		UnresolvedType tgtUType = getTargetType(Utils.getUnresolvedType(clazz));
		Map<Member, BcelShadow> lockShadows = new HashMap<Member, BcelShadow>();
		Map<Member, BcelShadow> unlockShadows = new HashMap<Member, BcelShadow>();

		// first lock and unlock advice execution shadows are created
		for (LazyMethodGen mg : methods) {
			AnnotationGen ann = Utils.getCOOLAnnotation(mg);
			if (ann == null)
				continue;
			String typeName = ann.getTypeName();
			if (typeName.equals(Utils.COOL_Lock_ANNOTATION.getName())
					|| typeName.equals(Utils.COOL_Unlock_ANNOTATION.getName())) {
				BcelShadow advShadow = BcelShadow
						.makeAdviceExecution(world, mg);
				BcelMethod mgMeth = mg.getMemberView();
				ResolvedMember matchingSig = new ResolvedMemberImpl(
						Member.ADVICE, mgMeth.getDeclaringType(), mgMeth
								.getModifiers(), mgMeth.getReturnType(), mgMeth
								.getName(), mgMeth.getParameterTypes());
				// this allows other AJ advice to advise this method
				// as advice
				advShadow.setMatchingSignature(matchingSig);
				advShadow.init();
				result.add(advShadow);
				// caching lock shadows to be used as enclosing
				// for method manager shadows
				Member tgtMethod = buildTargetMember(ann, tgtUType);
				if (typeName.equals(Utils.COOL_Lock_ANNOTATION.getName()))
					lockShadows.put(tgtMethod, advShadow);
				else
					unlockShadows.put(tgtMethod, advShadow);
			}
		}

		// then
		// (1) method manager shadows are built
		// (2) field-set in the COOL field initializers are built
		for (LazyMethodGen mg : methods) {
			if (mg.getName() == "<init>") {
				result.addAll(mm.reify(mg.getBody(), mg, null));
			}
			AnnotationGen ann = Utils.getCOOLAnnotation(mg);
			if (ann == null)
				continue;
			String typeName = ann.getTypeName();
			if (typeName.equals(Utils.COOL_Requires_ANNOTATION.getName())
					|| typeName.equals(Utils.COOL_OnEntry_ANNOTATION.getName())) {
				Member tgtMethod = buildTargetMember(ann, tgtUType);
				result.addAll(mm.reify(mg.getBody(), mg, lockShadows
						.get(tgtMethod)));
			} else if (typeName.equals(Utils.COOL_OnExit_ANNOTATION.getName())) {
				Member tgtMethod = buildTargetMember(ann, tgtUType);
				result.addAll(mm.reify(mg.getBody(), mg, unlockShadows
						.get(tgtMethod)));
			}
		}
		return result;
	}

	/**
	 * Initialized in setInputFiles. Every class that arrives is added to the set.
	 */
	Set<UnresolvedType> allClasses = new HashSet<UnresolvedType>();
	
	/**
	 * Given input Java classes, identifies all COOL coordinator classes,
	 * establishes "aspect class to target class" mappings, and "advice method
	 * to target method" mappings. Specifically, identifies all COOL coordinator
	 * classes in a set of input Java classes, and stores them in the
	 * <code>aspects</code> field. For every COOL coordinator class identifies
	 * all lock (unlock) methods (by calling <code>mapAdvice</code>), and
	 * stores them in the <code>lockMapping</code> (<code>unlockMapping</code>)
	 * field.
	 */
	public void setInputFiles(IClassFileProvider input) {
		System.out.println("Begin setInputFiles...");
		
		super.setInputFiles(input);
		if (typeMunger == null)
			typeMunger = new COOLTypeMunger(world);
		else
			// this seems to be inefficient since we do the munging
			// process again for all the aspects.
			typeMunger.clear();

		for (Iterator i = input.getClassFileIterator(); i.hasNext();) {
			UnwovenClassFile classFile = (UnwovenClassFile) i.next();
			UnresolvedType clazz = Utils.getUnresolvedType(classFile);
			allClasses.add(clazz);
			System.out.println("class file " + clazz + " added to allClasses");
		}
		
		for (UnresolvedType classType : allClasses) {			
			UnresolvedType targetType = getTargetType(classType);
			if (targetType != null) {
					try {
						typeMunger.prepare(world.resolve(classType), world
								.resolve(targetType));
					} catch (Exception e) {
						e.printStackTrace();
						System.err.println(e.getMessage());
						throw new RuntimeException(e.getMessage());
					}
				mapAdvice(world.resolve(classType), targetType);
			}
		}
	}

/**
 * Adds content to the map fields <b>lockMapping</b> and <b>unlockMapping</b>.
 * Iterates all methods in the aspect class. If the method has a lock annotation,
 * a target method is created based on the annotation values, and a corresponding lock effect is created.
 * Then, <b>lockMapping</b> is added the key-value pair (target-method, lock-effect). Similarly,
 * a method with a unlock annotation is handled.
 * 
 * @param clazz
 * @param targetType
 */
private void mapAdvice(ResolvedType clazz, UnresolvedType targetType) 
{
		List<IEffect> effects = new LinkedList<IEffect>();
		classToEffects.put(clazz.getName(), effects);
		ResolvedMember[] methods = clazz.getDeclaredMethods();
		// iterate all methods in aspect class
		for (ResolvedMember mg : methods) {
			AnnotationGen ann = Utils.getCOOLAnnotation(mg);
			if (ann == null)
				continue;
			
			ISourceLocation loc = mg.getSourceLocation();
			
			String typeName = ann.getTypeName();
			// if method has lock annotation...
			if (typeName.equals(Utils.COOL_Lock_ANNOTATION.getName())) {
				Member target = buildTargetMember(ann, targetType);
				IEffect lockEffect = new COOLLockEffect(clazz.getName(),
						mg.getName(), target, typeMunger.getCoordFieldName(targetType),
						mg, loc, clazz);
				
				lockMapping.put(target, lockEffect);
				effects.add(lockEffect);
			// if method has unlock annotation...
			} else if (typeName.equals(Utils.COOL_Unlock_ANNOTATION.getName())) {
				Member target = buildTargetMember(ann, targetType);
				IEffect unlockEffect = new COOLUnlockEffect(
						clazz.getName(), mg.getName(), target, 
						typeMunger.getCoordFieldName(targetType),
						mg, loc, clazz);
				unlockMapping.put(target, unlockEffect);
				effects.add(unlockEffect);
			}
		}
	}
	
/**
 * Creates and returns a Member method that corresponds to the method in the 
 * target class that is coordinated. The method is created based on the values presented in
 * the provided lock/unlock annotation. For instance, for the annotation
 * @COOLLock(methodName="push", className="", parameterTypes={"java.lang.Object"}),
 * a member method is created with the name <b>push</b>, parameters <b>Object</b>,
 * return type <b>Object</b> (uniform), and declaring type <b>targetType</b>. 
 * @param ann
 * @param targetType
 * @return
 */
private Member buildTargetMember(AnnotationGen ann, UnresolvedType targetType) {
		ElementValueGen methodNameVal = Utils.getAnnotationElementValue(ann,
				"methodName");
		ElementValueGen paramTypesVal = Utils.getAnnotationElementValue(ann,
				"parameterTypes");
		// ElementValue returnTypeVal = getAnnotationElementValue(ann,
		// "returnType");
		if (methodNameVal == null || paramTypesVal == null
				|| paramTypesVal.getElementValueType() != ElementValueGen.ARRAY)
			return null;
		String methodName = methodNameVal.stringifyValue();
		ElementValueGen[] paramTypeVals = ((ArrayElementValueGen) paramTypesVal)
				.getElementValuesArray();
		UnresolvedType[] paramTypes = new UnresolvedType[paramTypeVals.length];
		for (int i = 0; i < paramTypes.length; i++)
			paramTypes[i] = UnresolvedType.forName(paramTypeVals[i]
					.stringifyValue());
		// UnresolvedType returnType = UnresolvedType.forName(returnTypeVal
		// .stringifyValue());
		UnresolvedType returnType = UnresolvedType.forName("java.lang.Object");
		return MemberImpl.method(targetType, 0, returnType, methodName,
				paramTypes);
	}

	public boolean isCOOLAspect(UnresolvedType type) {
		return aspects.containsKey(type);
	}

	public boolean isCoordinatorField(Member field) {
		AnnotationGen ann = getFieldAnnotation(field);
		return (ann != null && ann.getTypeName().equals(
				Utils.COOL_CoordinatorField_ANNOTATION.getName()));
	}

	public boolean isConditionField(Member field) {
		AnnotationGen ann = getFieldAnnotation(field);
		return (ann != null && ann.getTypeName().equals(
				Utils.COOL_ConditionField_ANNOTATION.getName()));
	}

	private AnnotationGen getFieldAnnotation(Member field) {
		if (field != null && field.getKind() == Member.FIELD
				&& aspects.containsKey(field.getDeclaringType()))
			return Utils.getCOOLFieldAnnotation(field.resolve(world));
		else
			return null;
	}

	private boolean isAccessToCOOLField(LazyClassGen clazz, FieldInstruction fi) {
		Member field = BcelWorld.makeFieldJoinPointSignature(clazz, fi);
		AnnotationGen ann = Utils.getCOOLFieldAnnotation(field.resolve(world));
		return ann != null;
	}

	/**
	 * If classUType is an aspect class, its corresponding target class is returned 
	 * (from the 'aspects' map). NULL is returned otherwise. If the aspect class
	 * is seen for the first time, its target class is retrieved from elsewhere 
	 * and 'aspects' and 'targets' are added the pair.
	 * 
	 * @param mg
	 * @return
	 */
private UnresolvedType getTargetType(UnresolvedType classUType) {
		UnresolvedType result = aspects.get(classUType);
		if (result == null) {
			ResolvedType cg = world.resolve(classUType);
			AnnotationAJ[] anns = cg.getAnnotations();
			if (anns==null) return null;
			for (AnnotationAJ ann : anns)
				if (ann.getTypeName().equals(Utils.COOL_ASPECT_ANNOTATION.getName())) {
					String targetTypeName = Utils.getAnnotationElementValue(
							((BcelAnnotation)ann).getBcelAnnotation(), "className")
							.stringifyValue();
					if (targetTypeName != null) {
						result = UnresolvedType.forName(targetTypeName);
						aspects.put(classUType, result);
						targets.put(result, classUType);
						System.out.println("adding to 'aspects' (" + classUType + ", " + result + ")");
						System.out.println("adding to 'targets' (" + result + ", " + classUType + ")");
						break;
					}
				}
		}
		return result;
	}}
