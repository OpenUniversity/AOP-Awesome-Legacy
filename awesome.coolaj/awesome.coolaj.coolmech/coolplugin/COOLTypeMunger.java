package coolplugin;


import org.aspectj.weaver.*;
import org.aspectj.weaver.bcel.*;
import java.util.*;
import java.lang.reflect.Modifier;

import org.aspectj.apache.bcel.generic.InstructionFactory;
import org.aspectj.apache.bcel.generic.InstructionList;
import org.aspectj.apache.bcel.generic.InstructionHandle;
import org.aspectj.apache.bcel.generic.Type;
import org.aspectj.apache.bcel.generic.FieldGen;
import org.aspectj.apache.bcel.generic.InvokeInstruction;
import org.aspectj.apache.bcel.generic.Instruction;
import org.aspectj.apache.bcel.classfile.ConstantPool;
import org.aspectj.apache.bcel.classfile.annotation.*;


public class COOLTypeMunger {

	private final BcelWorld world;

	// maps type of a target class to a field name to a getter member
	// this specifies
	// (1) what methods should be introduced into the target class
	// (2) how to introduce external references into the aspect class
	private final Map<UnresolvedType, Map<String, Member>> getterMethods = new HashMap<UnresolvedType, Map<String, Member>>();

	/**
	 * maps aspect types to their external references as indicated by @COOLExternalRef.
	 * E.g., for a method _ref0 annotated with @COOLExternalRef(expr="buffer.length") this entry is added:</br> 
	 * ( BoundedStackCoord --> ( "_ref0" --> "buffer.length" ) )
	 */
	private final Map<UnresolvedType, Map<String, String>> extRefs = new HashMap<UnresolvedType, Map<String, String>>();

	/**
	 * maps aspect types to their external references <b>types</b> as indicated by @COOLExternalRef.
	 * E.g., for a method _ref0 that returns <b>double</b> annotated with @COOLExternalRef(expr="buffer.length") this entry is added:</br> 
	 * ( BoundedStackCoord --> ( "_ref0" --> double ) )
	 */
	private final Map<UnresolvedType, Map<String, ResolvedType>> extRefTypes = new HashMap<UnresolvedType, Map<String, ResolvedType>>();

	/**
	 * Maps between target classes and the name of their coordinator field
	 */
	private final Map<UnresolvedType, String> coordFields = new HashMap<UnresolvedType, String>();

	public COOLTypeMunger(BcelWorld world) {
		this.world = world;
	}

	public void clear() {
		this.getterMethods.clear();
		this.extRefs.clear();
		this.extRefTypes.clear();
		this.coordFields.clear();
	}

	public boolean isGetterMethod(UnresolvedType tgtUType, String mname) {
		Map<String, Member> tgtGetters = getterMethods.get(tgtUType);
		if (tgtGetters != null)
			for (Member meth : tgtGetters.values())
				if (meth.getName().equals(mname))
					return true;
		return false;
	}

	public ResolvedMember getExternalField(UnresolvedType tgtUType, String mname) {
		Map<String, Member> tgtGetters = getterMethods.get(tgtUType);
		if (tgtGetters != null)
			for (String fieldName : tgtGetters.keySet()) {
				Member meth = tgtGetters.get(fieldName);
				if (meth.getName().equals(mname))
					try {
						return getField(world.resolve(tgtUType), fieldName);
					} catch (Exception e) {
						return null;
					}
			}
		return null;
	}

	public boolean isSynthetic(LazyMethodGen mg) {
		UnresolvedType clType = Utils.getUnresolvedType(mg.getEnclosingClass());
		Map<String, Member> tgtGetterMethods = getterMethods.get(clType);
		if (tgtGetterMethods != null) {
			for (Member meth : tgtGetterMethods.values())
				if (Utils.isSameMethod(mg, meth))
					return true;
		}
		return false;
	}

	public Member getGetterMethod(UnresolvedType tgtType, String fieldName) {
		Map<String, Member> tgtGetters = getterMethods.get(tgtType);
		if (tgtGetters != null)
			return tgtGetters.get(fieldName);
		else
			return null;
	}

	public String getCoordFieldName(UnresolvedType tgtType) {
		return coordFields.get(tgtType);
	}

	// sets up the mappings that are used at munging stage
	/**
	 * The method looks for methods in the <i>aspectType</i> having the annotation @COOLExternalRef.
	 * For each method found, local fields (maps) are updated.</br>
	 * Suppose the aspect type <i>BoundedStackCoord</i> has the following method:</br>
	 * <pre>
	 * 	\@COOLExternalRef(expr="buffer.length")
	 * 	private double _ref0(base.BoundedStack thiz) {
	 * 	return 0;
	 * }
	 * </pre>
	 * <ul>
	 * <li>The map <i>extRefs</i>(&ltUnresolvedType, Map&ltString, String&gt&gt) is added the value ("ref0" --> "buffer.length") 
	 * to the key BoundedStackCoord.</li>
	 * <li>The map <i>extRefTypes</i> (&ltUnresolvedType, Map&ltString, ResolvedType&gt&gt)is added the value ("ref0" --> double) 
	 * the key BoundedStackCoord.</li>
	 * </ul>
	 * 
	 * For each annotation value, e.g., "buffer.length", the name of the field, e.g., "buffer", is locally saved. Then,
	 * this list of names is iterated and the map <i>getterMethods</i> is updated:
	 * an appropriate getter method for the field is created and the map (fieldName, method) is
	 * added to the target class key. Eventually, the name of the aspect field, e.g., _coord, is added to the field <i>coordFields</i>:
	 * coordFields.put(tgtUType, aspectFieldName);
	 * @param aspectType
	 * @param tgtType
	 * @throws Exception
	 */
	public void prepare(ResolvedType aspectType, ResolvedType tgtType)
			throws Exception {
		// clear();
		// System.out.println("Preparing for weaving aspectTYpe = "
		// +aspectType.getName()+", target type = "+tgtType.getName());
		// external fieldNames (names of the fields in the coordinated class)
		Set<String> extFieldNames = new HashSet<String>();

		// getting the right information from the aspect class
		UnresolvedType aspectUType = Utils.getUnresolvedType(aspectType);
		UnresolvedType tgtUType = Utils.getUnresolvedType(tgtType);

		Map<String, String> aspExtRefs = new HashMap<String, String>();
		extRefs.put(aspectUType, aspExtRefs);
		Map<String, ResolvedType> aspExtRefTypes = new HashMap<String, ResolvedType>();
		extRefTypes.put(aspectUType, aspExtRefTypes);

		for (ResolvedMember method : aspectType.getDeclaredMethods()) {
			AnnotationGen ann = Utils.getCOOLAnnotation(method);
			if (ann == null)
				continue;
			String typeName = ann.getTypeName();
			if (typeName.equals(Utils.COOL_ExternalRef_ANNOTATION.getName())) {
				String exprStr = Utils.getAnnotationElementValue(ann, "expr")
						.stringifyValue();
				//System.out.println("Found extRef method " + method.getName()
				//		+ " that targets field: " + getFieldName(exprStr));
				aspExtRefs.put(method.getName(), exprStr);
				ResolvedType retType = world.resolve(method.getReturnType());
				aspExtRefTypes.put(method.getName(), retType);
				extFieldNames.add(getFieldName(exprStr));
			}
		}

		Map<String, Member> tgtGetterMethods = new HashMap<String, Member>();
		getterMethods.put(tgtUType, tgtGetterMethods);

		// filling up all the getter methods
		for (String fieldName : extFieldNames) {
			Member field = getField(tgtType, fieldName);
			if (field == null)
				throw new Exception(" field " + fieldName + " in class "
						+ tgtType.getName() + " is not found!");
			if (field.isStatic())
				throw new Exception(
						"Field "
								+ field.getName()
								+ " that is accessed in the external reference expression is static. "
								+ "Non-static field is expected. ");

			// field is public, so it's OK
			if ((field.getModifiers() & Modifier.PUBLIC) != 0)
				continue;

			String methName = "_get" + fieldName.substring(0, 1).toUpperCase();
			if (fieldName.length() > 1)
				methName = methName + fieldName.substring(1);

			methName = Utils.genUniqueMethodName(tgtType, methName);

			Member method = MemberImpl.method(tgtUType, Modifier.PUBLIC, field
					.getReturnType(), methName, new UnresolvedType[0]);

			tgtGetterMethods.put(fieldName, method);

		}

		String aspectFieldName = Utils.genUniqueFieldName(tgtType, "_coord");
		coordFields.put(tgtUType, aspectFieldName);
	}

	public void transformAspectClass(LazyClassGen aspectClass,
			UnresolvedType tgtUType) throws Exception {
		InstructionFactory fact = aspectClass.getFactory();
		ConstantPool cpg = aspectClass.getConstantPool();
		UnresolvedType aspectUType = Utils.getUnresolvedType(aspectClass);

		Map<String, String> aspExtRefs = extRefs.get(aspectUType);
		// external reference method to expected external reference type
		Map<String, ResolvedType> aspExtRefTypes = extRefTypes.get(aspectUType);
		// all the manager methods in the aspect class
		Map<String, Member> tgtGetterMethods = getterMethods.get(tgtUType);

		List<LazyMethodGen> methods = aspectClass.getMethodGens();

		// transforming all manager methods by replacing
		// calls to external reference methods with
		// actual external variable reference expressions
		for (LazyMethodGen method : methods) {
			AnnotationGen ann = Utils.getCOOLAnnotation(method);
			if (ann == null)
				continue;
			String typeName = ann.getTypeName();
			if (typeName.equals(Utils.COOL_OnEntry_ANNOTATION.getName())
					|| typeName.equals(Utils.COOL_OnExit_ANNOTATION.getName())) {
				InstructionList body = method.getBody();
				InstructionHandle h = body.getStart();
				while (h != null) {
					InstructionHandle next = h.getNext();
					Instruction i = h.getInstruction();
					if (i != null && (i instanceof InvokeInstruction)) {
						InvokeInstruction inv = (InvokeInstruction) i;
						String tgtMethName = inv.getMethodName(cpg);
						String extRef = aspExtRefs.get(tgtMethName);
						if (extRef != null) {
							InstructionList extRefIL = new InstructionList();
							String fieldName = getFieldName(extRef);
							ResolvedType actualType;
							try {
								actualType = compileExternalRef(extRef, fact,
										world.resolve(tgtUType),
										tgtGetterMethods.get(fieldName),
										extRefIL);
							} catch (Exception e) {
								throw new Exception(
										"Error in the external reference expression "
												+ extRef + ": "
												+ e.getMessage());
							}
							ResolvedType expectedType = aspExtRefTypes
									.get(tgtMethName);
							if (!expectedType.isAssignableFrom(actualType))
								throw new Exception(
										"Type error in the external reference expression "
												+ extRef
												+ ": expected type of the expression ("
												+ expectedType
												+ ") is not "
												+ "assignable from its actual type ("
												+ actualType + ")");
							extRefIL.append(Utility.createConversion(fact,
									BcelWorld.makeBcelType(actualType),
									BcelWorld.makeBcelType(expectedType)));

							InstructionHandle h_load_this = h.getPrev()
									.getPrev();
							InstructionHandle extRefIH = body.append(h,
									extRefIL);
							Utility.deleteInstruction(h, extRefIH, method);
							Utility.deleteInstruction(h_load_this, extRefIH,
									method);
						}
					}
					h = next;
				}
			}

		}
	}

	/**
	 * Adds to target class a coordinator field, and getter methods.
	 * A getter method is added for each private field that is accessed
	 * by the coordinator (as marked by @COOLExternalRef)
	 * @param tgtClass
	 * @param aspectUType
	 * @return
	 * @throws Exception
	 */
	public FieldGen transformTargetClass(LazyClassGen tgtClass,
			UnresolvedType aspectUType) throws Exception {
		FieldGen coordField = addCoordinatorField(tgtClass, aspectUType);// aspectClass.getType());
		// field name accessed in an external reference to getter method for
		// that field
		UnresolvedType tgtUType = Utils.getUnresolvedType(tgtClass);
		Map<String, Member> tgtGetterMethods = getterMethods.get(tgtUType);
		if (tgtGetterMethods != null)
			// munging in the getter methods
			for (String fieldName : tgtGetterMethods.keySet()) {
				Member field = this.getField(tgtClass.getType(), fieldName);
				Member meth = tgtGetterMethods.get(fieldName);
				addFieldGetterMethod(tgtClass, field, meth);
			}
		return coordField;
	}

	/**
	 * Adds a coordinator field (of type <b>aspectType</b>) to the target class. The name
	 * of the field is retrieved from the map <b>coordFields</b>.
	 * @param tgtClass
	 * @param aspectType
	 * @return
	 */
	private FieldGen addCoordinatorField(LazyClassGen tgtClass,
			UnresolvedType aspectType) {
		// the name of the aspect field to be added is retrieved from coordFields
		String aspectFieldName = coordFields.get(Utils
				.getUnresolvedType(tgtClass));

		// an appropriate field is created (of type FieldGen)
		FieldGen field = new FieldGen(Modifier.PRIVATE, BcelWorld
				.makeBcelType(aspectType), aspectFieldName, tgtClass
				.getConstantPool());
		
		// the field is added to the target class
		tgtClass.addField(field, null);
		return field;
	}

	private LazyMethodGen addFieldGetterMethod(LazyClassGen tgtClass,
			Member field, Member meth) throws Exception {
		LazyMethodGen method = new LazyMethodGen(Modifier.PUBLIC, BcelWorld
				.makeBcelType(meth.getReturnType()), meth.getName(),
				new Type[0], new String[0], tgtClass);

		// generating the body of the method
		InstructionFactory fact = tgtClass.getFactory();
		method.getBody().append(InstructionFactory.ALOAD_0);

		method.getBody().append(Utility.createGet(fact, field));
		method.getBody().append(
				InstructionFactory.createReturn(BcelWorld.makeBcelType(meth
						.getReturnType())));
		tgtClass.addMethodGen(method);
		return method;
	}

	private ResolvedType compileExternalRef(String extRef,
			InstructionFactory fact, ResolvedType declType, Member getterMeth,
			InstructionList il) throws Exception {
		if (extRef == null || extRef.length() == 0)
			return declType;

		String fieldName = getFieldName(extRef);

		if (getterMeth != null) {

			il.append(Utility.createInvoke(fact, world, getterMeth));
			declType = world.resolve(getterMeth.getReturnType());
		} else if (declType.isArray()) {
			if (fieldName.equals("length")) {
				il.append(InstructionFactory.ARRAYLENGTH);
				declType = ResolvedType.INT;
			} else
				throw new Exception("Unknown array field: " + fieldName);
		} else {
			Member field = getField(declType, fieldName);
			if (field == null)
				throw new Exception("field " + fieldName + " in type "
						+ declType.getName() + " is not found!");
			il.append(Utility.createGet(fact, field));
			declType = world.resolve(field.getReturnType());
		}
		return compileExternalRef(getNextRef(extRef), fact, declType, null, il);
	}

	private String getFieldName(String extRef) {
		int nextDot = extRef.indexOf(".");
		return (nextDot < 0) ? extRef : extRef.substring(0, nextDot);
	}

	private String getNextRef(String extRef) {
		int nextDot = extRef.indexOf(".");
		return (nextDot < 0) ? extRef = "" : extRef.substring(nextDot + 1);
	}

	private ResolvedMember getField(ResolvedType tgtClass, String fieldName)
			throws Exception {
		// BcelObjectType clazz = tgtClass.getBcelObjectType();
		ResolvedMember[] fields = tgtClass.getDeclaredFields();
		for (ResolvedMember field : fields)
			if (field.getName().equals(fieldName))
				return field;
		ResolvedType superClass = tgtClass.getSuperclass();
		if (superClass != null)
			return getField(superClass, fieldName);
		else
			return null;
	}

}
