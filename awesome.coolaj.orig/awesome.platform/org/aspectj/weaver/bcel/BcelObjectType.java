/* *******************************************************************
 * Copyright (c) 2002 Contributors
 * All rights reserved. 
 * This program and the accompanying materials are made available 
 * under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *  
 * Contributors: 
 *     PARC     initial implementation 
 *     RonBodkin/AndyClement optimizations for memory consumption/speed
 * ******************************************************************/

package org.aspectj.weaver.bcel;

import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.aspectj.apache.bcel.classfile.AttributeUtils;
import org.aspectj.apache.bcel.classfile.Field;
import org.aspectj.apache.bcel.classfile.JavaClass;
import org.aspectj.apache.bcel.classfile.Method;
import org.aspectj.apache.bcel.classfile.Signature;
import org.aspectj.apache.bcel.classfile.annotation.AnnotationGen;
import org.aspectj.apache.bcel.classfile.annotation.ElementNameValuePairGen;
import org.aspectj.apache.bcel.classfile.annotation.EnumElementValueGen;
import org.aspectj.bridge.IMessageHandler;
import org.aspectj.bridge.MessageUtil;
import org.aspectj.util.GenericSignature;
import org.aspectj.weaver.AbstractReferenceTypeDelegate;
import org.aspectj.weaver.AjAttribute;
import org.aspectj.weaver.AjcMemberMaker;
import org.aspectj.weaver.AnnotationAJ;
import org.aspectj.weaver.AnnotationTargetKind;
import org.aspectj.weaver.BCException;
import org.aspectj.weaver.BindingScope;
import org.aspectj.weaver.ISourceContext;
import org.aspectj.weaver.ReferenceType;
import org.aspectj.weaver.ResolvedMember;
import org.aspectj.weaver.ResolvedPointcutDefinition;
import org.aspectj.weaver.ResolvedType;
import org.aspectj.weaver.SourceContextImpl;
import org.aspectj.weaver.TypeVariable;
import org.aspectj.weaver.UnresolvedType;
import org.aspectj.weaver.WeaverStateInfo;
import org.aspectj.weaver.World;
import org.aspectj.weaver.bcel.BcelGenericSignatureToTypeXConverter.GenericSignatureFormatException;
import org.aspectj.weaver.patterns.Declare;
import org.aspectj.weaver.patterns.DeclareErrorOrWarning;
import org.aspectj.weaver.patterns.DeclarePrecedence;
import org.aspectj.weaver.patterns.FormalBinding;
import org.aspectj.weaver.patterns.IScope;
import org.aspectj.weaver.patterns.PerClause;

public class BcelObjectType extends AbstractReferenceTypeDelegate {
	public JavaClass javaClass;
	private LazyClassGen lazyClassGen = null; // set lazily if it's an aspect

	private int modifiers;
	private String className;

	private String superclassSignature;
	private String superclassName;
	private String[] interfaceSignatures;

	private ResolvedMember[] fields = null;
	private ResolvedMember[] methods = null;
	private ResolvedType[] annotationTypes = null;
	private AnnotationAJ[] annotations = null;
	private TypeVariable[] typeVars = null;
	private String retentionPolicy;
	private AnnotationTargetKind[] annotationTargetKinds;

	// Aspect related stuff (pointcuts *could* be in a java class)
	private AjAttribute.WeaverVersionInfo wvInfo = AjAttribute.WeaverVersionInfo.UNKNOWN;
	private ResolvedPointcutDefinition[] pointcuts = null;
	private ResolvedMember[] privilegedAccess = null;
	private WeaverStateInfo weaverState = null;
	private PerClause perClause = null;
	private List typeMungers = Collections.EMPTY_LIST;
	private List declares = Collections.EMPTY_LIST;

	private GenericSignature.FormalTypeParameter[] formalsForResolution = null;
	private String declaredSignature = null;

	private boolean hasBeenWoven = false;
	private boolean isGenericType = false;
	private boolean isInterface;
	private boolean isEnum;
	private boolean isAnnotation;
	private boolean isAnonymous;
	private boolean isNested;
	private boolean isObject = false; // set upon construction
	private boolean isAnnotationStyleAspect = false;// set upon construction
	private boolean isCodeStyleAspect = false; // not redundant with field
	// above!

	private int bitflag = 0x0000;

	// discovery bits
	private static final int DISCOVERED_ANNOTATION_RETENTION_POLICY = 0x0001;
	private static final int UNPACKED_GENERIC_SIGNATURE = 0x0002;
	private static final int UNPACKED_AJATTRIBUTES = 0x0004; // see note(1)
	// below
	private static final int DISCOVERED_ANNOTATION_TARGET_KINDS = 0x0008;
	private static final int DISCOVERED_DECLARED_SIGNATURE = 0x0010;
	private static final int DISCOVERED_WHETHER_ANNOTATION_STYLE = 0x0020;

	private static final String[] NO_INTERFACE_SIGS = new String[] {};

	/*
	 * Notes: note(1): in some cases (perclause inheritance) we encounter unpacked state when calling getPerClause
	 * 
	 * note(2): A BcelObjectType is 'damaged' if it has been modified from what was original constructed from the bytecode. This
	 * currently happens if the parents are modified or an annotation is added - ideally BcelObjectType should be immutable but
	 * that's a bigger piece of work. XXX
	 */

	// ------------------ construction and initialization
	BcelObjectType(ReferenceType resolvedTypeX, JavaClass javaClass, boolean exposedToWeaver) {
		super(resolvedTypeX, exposedToWeaver);
		this.javaClass = javaClass;
		initializeFromJavaclass();

		// ATAJ: set the delegate right now for @AJ pointcut, else it is done
		// too late to lookup
		// @AJ pc refs annotation in class hierarchy
		resolvedTypeX.setDelegate(this);

		ISourceContext sourceContext = resolvedTypeX.getSourceContext();
		if (sourceContext == SourceContextImpl.UNKNOWN_SOURCE_CONTEXT) {
			sourceContext = new SourceContextImpl(this);
			setSourceContext(sourceContext);
		}

		// this should only ever be java.lang.Object which is
		// the only class in Java-1.4 with no superclasses
		isObject = (javaClass.getSuperclassNameIndex() == 0);
		ensureAspectJAttributesUnpacked();
		// if (sourceContext instanceof SourceContextImpl) {
		// ((SourceContextImpl)sourceContext).setSourceFileName(javaClass.
		// getSourceFileName());
		// }
		setSourcefilename(javaClass.getSourceFileName());
	}

	// repeat initialization
	public void setJavaClass(JavaClass newclass) {
		this.javaClass = newclass;
		resetState();
		initializeFromJavaclass();
	}

	private void initializeFromJavaclass() {
		isInterface = javaClass.isInterface();
		isEnum = javaClass.isEnum();
		isAnnotation = javaClass.isAnnotation();
		isAnonymous = javaClass.isAnonymous();
		isNested = javaClass.isNested();
		modifiers = javaClass.getModifiers();
		superclassName = javaClass.getSuperclassName();
		className = javaClass.getClassName();
		cachedGenericClassTypeSignature = null;
	}

	// --- getters

	// Java related
	public boolean isInterface() {
		return isInterface;
	}

	public boolean isEnum() {
		return isEnum;
	}

	public boolean isAnnotation() {
		return isAnnotation;
	}

	public boolean isAnonymous() {
		return isAnonymous;
	}

	public boolean isNested() {
		return isNested;
	}

	public int getModifiers() {
		return modifiers;
	}

	/**
	 * Must take into account generic signature
	 */
	public ResolvedType getSuperclass() {
		if (isObject)
			return null;
		ensureGenericSignatureUnpacked();
		if (superclassSignature == null) {
			if (superclassName == null)
				superclassName = javaClass.getSuperclassName();
			superclassSignature = getResolvedTypeX().getWorld().resolve(UnresolvedType.forName(superclassName)).getSignature();
		}
		World world = getResolvedTypeX().getWorld();
		ResolvedType res = world.resolve(UnresolvedType.forSignature(superclassSignature));
		return res;
	}

	public World getWorld() {
		return getResolvedTypeX().getWorld();
	}

	/**
	 * Retrieves the declared interfaces - this allows for the generic signature on a type. If specified then the generic signature
	 * is used to work out the types - this gets around the results of erasure when the class was originally compiled.
	 */
	public ResolvedType[] getDeclaredInterfaces() {
		ensureGenericSignatureUnpacked();
		ResolvedType[] interfaceTypes = null;
		if (interfaceSignatures == null) {
			String[] names = javaClass.getInterfaceNames();
			if (names.length == 0) {
				interfaceSignatures = NO_INTERFACE_SIGS;
				interfaceTypes = ResolvedType.NONE;
			} else {
				interfaceSignatures = new String[names.length];
				interfaceTypes = new ResolvedType[names.length];
				for (int i = 0, len = names.length; i < len; i++) {
					interfaceTypes[i] = getResolvedTypeX().getWorld().resolve(UnresolvedType.forName(names[i]));
					interfaceSignatures[i] = interfaceTypes[i].getSignature();
				}
			}
		} else {
			interfaceTypes = new ResolvedType[interfaceSignatures.length];
			for (int i = 0, len = interfaceSignatures.length; i < len; i++) {
				if (interfaceSignatures[i] == null) { // debug for NPE
					String msg = "Null interface signature (element:" + i + " of " + interfaceSignatures.length
							+ ").  Type for which we" + "are looking at interfaces is " + this.className + ".";
					System.err.println(msg);
					throw new BCException(msg);
				}
				interfaceTypes[i] = getResolvedTypeX().getWorld().resolve(UnresolvedType.forSignature(interfaceSignatures[i]));
			}
		}

		return interfaceTypes;
	}

	public ResolvedMember[] getDeclaredMethods() {
		ensureGenericSignatureUnpacked();
		if (methods == null) {
			Method[] ms = javaClass.getMethods();
			methods = new ResolvedMember[ms.length];
			for (int i = ms.length - 1; i >= 0; i--) {
				methods[i] = new BcelMethod(this, ms[i]);
			}
		}
		return methods;
	}

	public ResolvedMember[] getDeclaredFields() {
		ensureGenericSignatureUnpacked();
		if (fields == null) {
			Field[] fs = javaClass.getFields();
			fields = new ResolvedMember[fs.length];
			for (int i = 0, len = fs.length; i < len; i++) {
				fields[i] = new BcelField(this, fs[i]);
			}
		}
		return fields;
	}

	public TypeVariable[] getTypeVariables() {
		if (!isGeneric())
			return TypeVariable.NONE;

		if (typeVars == null) {
			GenericSignature.ClassSignature classSig = getGenericClassTypeSignature();// cachedGenericClassTypeSignature
			// ;
			// /
			// /
			// javaClass
			// .
			// getGenericClassTypeSignature();
			typeVars = new TypeVariable[classSig.formalTypeParameters.length];
			for (int i = 0; i < typeVars.length; i++) {
				GenericSignature.FormalTypeParameter ftp = classSig.formalTypeParameters[i];
				try {
					typeVars[i] = BcelGenericSignatureToTypeXConverter.formalTypeParameter2TypeVariable(ftp,
							classSig.formalTypeParameters, getResolvedTypeX().getWorld());
				} catch (GenericSignatureFormatException e) {
					// this is a development bug, so fail fast with good info
					throw new IllegalStateException("While getting the type variables for type " + this.toString()
							+ " with generic signature " + classSig + " the following error condition was detected: "
							+ e.getMessage());
				}
			}
		}
		return typeVars;
	}

	// Aspect related
	public Collection getTypeMungers() {
		return typeMungers;
	}

	public Collection getDeclares() {
		return declares;
	}

	public Collection getPrivilegedAccesses() {
		if (privilegedAccess == null)
			return Collections.EMPTY_LIST;
		return Arrays.asList(privilegedAccess);
	}

	public ResolvedMember[] getDeclaredPointcuts() {
		return pointcuts;
	}

	public boolean isAspect() {
		return perClause != null;
	}

	/**
	 * Check if the type is an @AJ aspect (no matter if used from an LTW point of view). Such aspects are annotated with @Aspect
	 * 
	 * @return true for @AJ aspect
	 */
	public boolean isAnnotationStyleAspect() {
		if ((bitflag & DISCOVERED_WHETHER_ANNOTATION_STYLE) == 0) {
			bitflag |= DISCOVERED_WHETHER_ANNOTATION_STYLE;
			isAnnotationStyleAspect = !isCodeStyleAspect && hasAnnotation(AjcMemberMaker.ASPECT_ANNOTATION);
		}
		return isAnnotationStyleAspect;
	}

	/**
	 * Process any org.aspectj.weaver attributes stored against the class.
	 */
	private void ensureAspectJAttributesUnpacked() {
		if ((bitflag & UNPACKED_AJATTRIBUTES) != 0)
			return;
		bitflag |= UNPACKED_AJATTRIBUTES;
		IMessageHandler msgHandler = getResolvedTypeX().getWorld().getMessageHandler();
		// Pass in empty list that can store things for readAj5 to process
		List l = Utility.readAjAttributes(className, javaClass.getAttributes(), getResolvedTypeX().getSourceContext(),
				getResolvedTypeX().getWorld(), AjAttribute.WeaverVersionInfo.UNKNOWN);
		List pointcuts = new ArrayList();
		typeMungers = new ArrayList();
		declares = new ArrayList();
		processAttributes(l, pointcuts, false);
		l = AtAjAttributes.readAj5ClassAttributes(((BcelWorld) getResolvedTypeX().getWorld()).getModelAsAsmManager(), javaClass,
				getResolvedTypeX(), getResolvedTypeX().getSourceContext(), msgHandler, isCodeStyleAspect);
		AjAttribute.Aspect deferredAspectAttribute = processAttributes(l, pointcuts, true);

		if (pointcuts.size() == 0) {
			this.pointcuts = ResolvedPointcutDefinition.NO_POINTCUTS;
		} else {
			this.pointcuts = (ResolvedPointcutDefinition[]) pointcuts.toArray(new ResolvedPointcutDefinition[pointcuts.size()]);
		}

		resolveAnnotationDeclares(l);

		if (deferredAspectAttribute != null) {
			// we can finally process the aspect and its associated perclause...
			perClause = deferredAspectAttribute.reifyFromAtAspectJ(this.getResolvedTypeX());
		}
		if (isAspect() && !Modifier.isAbstract(getModifiers()) && isGeneric()) {
			msgHandler.handleMessage(MessageUtil.error("The generic aspect '" + getResolvedTypeX().getName()
					+ "' must be declared abstract", getResolvedTypeX().getSourceLocation()));
		}

	}

	private AjAttribute.Aspect processAttributes(List attributeList, List pointcuts, boolean fromAnnotations) {
		AjAttribute.Aspect deferredAspectAttribute = null;
		for (Iterator iter = attributeList.iterator(); iter.hasNext();) {
			AjAttribute a = (AjAttribute) iter.next();
			// System.err.println("unpacking: " + this + " and " + a);
			if (a instanceof AjAttribute.Aspect) {
				if (fromAnnotations) {
					deferredAspectAttribute = (AjAttribute.Aspect) a;
				} else {
					perClause = ((AjAttribute.Aspect) a).reify(this.getResolvedTypeX());
					isCodeStyleAspect = true;
				}
			} else if (a instanceof AjAttribute.PointcutDeclarationAttribute) {
				pointcuts.add(((AjAttribute.PointcutDeclarationAttribute) a).reify());
			} else if (a instanceof AjAttribute.WeaverState) {
				weaverState = ((AjAttribute.WeaverState) a).reify();
			} else if (a instanceof AjAttribute.TypeMunger) {
				typeMungers.add(((AjAttribute.TypeMunger) a).reify(getResolvedTypeX().getWorld(), getResolvedTypeX()));
			} else if (a instanceof AjAttribute.DeclareAttribute) {
				declares.add(((AjAttribute.DeclareAttribute) a).getDeclare());
			} else if (a instanceof AjAttribute.PrivilegedAttribute) {
				privilegedAccess = ((AjAttribute.PrivilegedAttribute) a).getAccessedMembers();
			} else if (a instanceof AjAttribute.SourceContextAttribute) {
				if (getResolvedTypeX().getSourceContext() instanceof SourceContextImpl) {
					AjAttribute.SourceContextAttribute sca = (AjAttribute.SourceContextAttribute) a;
					((SourceContextImpl) getResolvedTypeX().getSourceContext()).configureFromAttribute(sca.getSourceFileName(), sca
							.getLineBreaks());

					setSourcefilename(sca.getSourceFileName());
				}
			} else if (a instanceof AjAttribute.WeaverVersionInfo) {
				wvInfo = (AjAttribute.WeaverVersionInfo) a; // Set the weaver
				// version used to
				// build this type
			} else {
				throw new BCException("bad attribute " + a);
			}
		}
		return deferredAspectAttribute;
	}

	/**
	 * Extra processing step needed because declares that come from annotations are not pre-resolved. We can't do the resolution
	 * until *after* the pointcuts have been resolved.
	 * 
	 * @param attributeList
	 */
	private void resolveAnnotationDeclares(List attributeList) {
		FormalBinding[] bindings = new org.aspectj.weaver.patterns.FormalBinding[0];
		IScope bindingScope = new BindingScope(getResolvedTypeX(), getResolvedTypeX().getSourceContext(), bindings);
		for (Iterator iter = attributeList.iterator(); iter.hasNext();) {
			AjAttribute a = (AjAttribute) iter.next();
			if (a instanceof AjAttribute.DeclareAttribute) {
				Declare decl = (((AjAttribute.DeclareAttribute) a).getDeclare());
				if (decl instanceof DeclareErrorOrWarning) {
					decl.resolve(bindingScope);
				} else if (decl instanceof DeclarePrecedence) {
					((DeclarePrecedence) decl).setScopeForResolution(bindingScope);
				}
			}
		}
	}

	public PerClause getPerClause() {
		ensureAspectJAttributesUnpacked();
		return perClause;
	}

	public JavaClass getJavaClass() {
		return javaClass;
	}

	public void resetState() {
		if (javaClass == null) {
			// we might store the classname and allow reloading?
			// At this point we are relying on the world to not evict if it
			// might want to reweave multiple times
			throw new BCException("can't weave evicted type");
		}

		bitflag = 0x0000;

		this.annotationTypes = null;
		this.annotations = null;
		this.interfaceSignatures = null;
		this.superclassSignature = null;
		this.superclassName = null;
		this.fields = null;
		this.methods = null;
		this.pointcuts = null;
		this.perClause = null;
		this.weaverState = null;
		this.lazyClassGen = null;
		hasBeenWoven = false;

		isObject = (javaClass.getSuperclassNameIndex() == 0);
		isAnnotationStyleAspect = false;
		ensureAspectJAttributesUnpacked();
	}

	public void finishedWith() {
		// memory usage experiments....
		// this.interfaces = null;
		// this.superClass = null;
		// this.fields = null;
		// this.methods = null;
		// this.pointcuts = null;
		// this.perClause = null;
		// this.weaverState = null;
		// this.lazyClassGen = null;
		// this next line frees up memory, but need to understand incremental
		// implications
		// before leaving it in.
		// getResolvedTypeX().setSourceContext(null);
	}

	public WeaverStateInfo getWeaverState() {
		return weaverState;
	}

	void setWeaverState(WeaverStateInfo weaverState) {
		this.weaverState = weaverState;
	}

	public void printWackyStuff(PrintStream out) {
		if (typeMungers.size() > 0)
			out.println("  TypeMungers: " + typeMungers);
		if (declares.size() > 0)
			out.println("     declares: " + declares);
	}

	/**
	 * Return the lazyClassGen associated with this type. For aspect types, this value will be cached, since it is used to inline
	 * advice. For non-aspect types, this lazyClassGen is always newly constructed.
	 */
	public LazyClassGen getLazyClassGen() {
		LazyClassGen ret = lazyClassGen;
		if (ret == null) {
			// System.err.println("creating lazy class gen for: " + this);
			ret = new LazyClassGen(this);
			// ret.print(System.err);
			// System.err.println("made LCG from : " +
			// this.getJavaClass().getSuperclassName );
			if (isAspect()) {
				lazyClassGen = ret;
			}
		}
		return ret;
	}

	public boolean isSynthetic() {
		return getResolvedTypeX().isSynthetic();
	}

	public AjAttribute.WeaverVersionInfo getWeaverVersionAttribute() {
		return wvInfo;
	}

	// -- annotation related

	public ResolvedType[] getAnnotationTypes() {
		ensureAnnotationsUnpacked();
		return annotationTypes;
	}

	public AnnotationAJ[] getAnnotations() {
		ensureAnnotationsUnpacked();
		return annotations;
	}

	public boolean hasAnnotation(UnresolvedType ofType) {
		ensureAnnotationsUnpacked();
		for (int i = 0; i < annotationTypes.length; i++) {
			ResolvedType ax = annotationTypes[i];
			if (ax.equals(ofType))
				return true;
		}
		return false;
	}

	public boolean isAnnotationWithRuntimeRetention() {
		return (getRetentionPolicy() == null ? false : getRetentionPolicy().equals("RUNTIME"));
	}

	public String getRetentionPolicy() {
		if ((bitflag & DISCOVERED_ANNOTATION_RETENTION_POLICY) == 0) {
			bitflag |= DISCOVERED_ANNOTATION_RETENTION_POLICY;
			retentionPolicy = null; // null means we have no idea
			if (isAnnotation()) {
				ensureAnnotationsUnpacked();
				for (int i = annotations.length - 1; i >= 0; i--) {
					AnnotationAJ ax = annotations[i];
					if (ax.getTypeName().equals(UnresolvedType.AT_RETENTION.getName())) {
						List values = ((BcelAnnotation) ax).getBcelAnnotation().getValues();
						for (Iterator it = values.iterator(); it.hasNext();) {
							ElementNameValuePairGen element = (ElementNameValuePairGen) it.next();
							EnumElementValueGen v = (EnumElementValueGen) element.getValue();
							retentionPolicy = v.getEnumValueString();
							return retentionPolicy;
						}
					}
				}
			}
		}
		return retentionPolicy;
	}

	public boolean canAnnotationTargetType() {
		AnnotationTargetKind[] targetKinds = getAnnotationTargetKinds();
		if (targetKinds == null)
			return true;
		for (int i = 0; i < targetKinds.length; i++) {
			if (targetKinds[i].equals(AnnotationTargetKind.TYPE)) {
				return true;
			}
		}
		return false;
	}

	public AnnotationTargetKind[] getAnnotationTargetKinds() {
		if ((bitflag & DISCOVERED_ANNOTATION_TARGET_KINDS) != 0)
			return annotationTargetKinds;
		bitflag |= DISCOVERED_ANNOTATION_TARGET_KINDS;
		annotationTargetKinds = null; // null means we have no idea or the
		// @Target annotation hasn't been used
		List targetKinds = new ArrayList();
		if (isAnnotation()) {
			AnnotationAJ[] annotationsOnThisType = getAnnotations();
			for (int i = 0; i < annotationsOnThisType.length; i++) {
				AnnotationAJ a = annotationsOnThisType[i];
				if (a.getTypeName().equals(UnresolvedType.AT_TARGET.getName())) {
					Set targets = a.getTargets();
					if (targets != null) {
						for (Iterator iterator = targets.iterator(); iterator.hasNext();) {
							String targetKind = (String) iterator.next();
							if (targetKind.equals("ANNOTATION_TYPE")) {
								targetKinds.add(AnnotationTargetKind.ANNOTATION_TYPE);
							} else if (targetKind.equals("CONSTRUCTOR")) {
								targetKinds.add(AnnotationTargetKind.CONSTRUCTOR);
							} else if (targetKind.equals("FIELD")) {
								targetKinds.add(AnnotationTargetKind.FIELD);
							} else if (targetKind.equals("LOCAL_VARIABLE")) {
								targetKinds.add(AnnotationTargetKind.LOCAL_VARIABLE);
							} else if (targetKind.equals("METHOD")) {
								targetKinds.add(AnnotationTargetKind.METHOD);
							} else if (targetKind.equals("PACKAGE")) {
								targetKinds.add(AnnotationTargetKind.PACKAGE);
							} else if (targetKind.equals("PARAMETER")) {
								targetKinds.add(AnnotationTargetKind.PARAMETER);
							} else if (targetKind.equals("TYPE")) {
								targetKinds.add(AnnotationTargetKind.TYPE);
							}
						}
					}
				}
			}
			if (!targetKinds.isEmpty()) {
				annotationTargetKinds = new AnnotationTargetKind[targetKinds.size()];
				return (AnnotationTargetKind[]) targetKinds.toArray(annotationTargetKinds);
			}
		}
		return annotationTargetKinds;
	}

	// --- unpacking methods

	private void ensureAnnotationsUnpacked() {
		if (annotationTypes == null) {
			AnnotationGen annos[] = javaClass.getAnnotations();
			if (annos == null || annos.length == 0) {
				annotationTypes = ResolvedType.NONE;
				annotations = AnnotationAJ.EMPTY_ARRAY;
			} else {
				World w = getResolvedTypeX().getWorld();
				annotationTypes = new ResolvedType[annos.length];
				annotations = new AnnotationAJ[annos.length];
				for (int i = 0; i < annos.length; i++) {
					AnnotationGen annotation = annos[i];
					annotationTypes[i] = w.resolve(UnresolvedType.forSignature(annotation.getTypeSignature()));
					annotations[i] = new BcelAnnotation(annotation, w);
				}
			}
		}
	}

	// ---

	public String getDeclaredGenericSignature() {
		ensureGenericInfoProcessed();
		return declaredSignature;
	}

	private void ensureGenericSignatureUnpacked() {
		if ((bitflag & UNPACKED_GENERIC_SIGNATURE) != 0)
			return;
		bitflag |= UNPACKED_GENERIC_SIGNATURE;
		if (!getResolvedTypeX().getWorld().isInJava5Mode())
			return;
		GenericSignature.ClassSignature cSig = getGenericClassTypeSignature();
		if (cSig != null) {
			formalsForResolution = cSig.formalTypeParameters;
			if (isNested()) {
				// we have to find any type variables from the outer type before
				// proceeding with resolution.
				GenericSignature.FormalTypeParameter[] extraFormals = getFormalTypeParametersFromOuterClass();
				if (extraFormals.length > 0) {
					List allFormals = new ArrayList();
					for (int i = 0; i < formalsForResolution.length; i++) {
						allFormals.add(formalsForResolution[i]);
					}
					for (int i = 0; i < extraFormals.length; i++) {
						allFormals.add(extraFormals[i]);
					}
					formalsForResolution = new GenericSignature.FormalTypeParameter[allFormals.size()];
					allFormals.toArray(formalsForResolution);
				}
			}
			GenericSignature.ClassTypeSignature superSig = cSig.superclassSignature;
			try {
				// this.superClass =
				// BcelGenericSignatureToTypeXConverter.classTypeSignature2TypeX(
				// superSig, formalsForResolution,
				// getResolvedTypeX().getWorld());

				ResolvedType rt = BcelGenericSignatureToTypeXConverter.classTypeSignature2TypeX(superSig, formalsForResolution,
						getResolvedTypeX().getWorld());
				this.superclassSignature = rt.getSignature();
				this.superclassName = rt.getName();

			} catch (GenericSignatureFormatException e) {
				// development bug, fail fast with good info
				throw new IllegalStateException("While determining the generic superclass of " + this.className
						+ " with generic signature " + getDeclaredGenericSignature() + " the following error was detected: "
						+ e.getMessage());
			}
			// this.interfaces = new
			// ResolvedType[cSig.superInterfaceSignatures.length];
			if (cSig.superInterfaceSignatures.length == 0) {
				this.interfaceSignatures = NO_INTERFACE_SIGS;
			} else {
				this.interfaceSignatures = new String[cSig.superInterfaceSignatures.length];
				for (int i = 0; i < cSig.superInterfaceSignatures.length; i++) {
					try {
						// this.interfaces[i] =
						// BcelGenericSignatureToTypeXConverter.
						// classTypeSignature2TypeX(
						// cSig.superInterfaceSignatures[i],
						// formalsForResolution,
						// getResolvedTypeX().getWorld());
						this.interfaceSignatures[i] = BcelGenericSignatureToTypeXConverter.classTypeSignature2TypeX(
								cSig.superInterfaceSignatures[i], formalsForResolution, getResolvedTypeX().getWorld())
								.getSignature();
					} catch (GenericSignatureFormatException e) {
						// development bug, fail fast with good info
						throw new IllegalStateException("While determing the generic superinterfaces of " + this.className
								+ " with generic signature " + getDeclaredGenericSignature()
								+ " the following error was detected: " + e.getMessage());
					}
				}
			}
		}
		if (isGeneric()) {
			// update resolved typex to point at generic type not raw type.
			ReferenceType genericType = (ReferenceType) this.resolvedTypeX.getGenericType();
			// genericType.setSourceContext(this.resolvedTypeX.getSourceContext()
			// );
			genericType.setStartPos(this.resolvedTypeX.getStartPos());
			this.resolvedTypeX = genericType;
		}
	}

	public GenericSignature.FormalTypeParameter[] getAllFormals() {
		ensureGenericSignatureUnpacked();
		if (formalsForResolution == null) {
			return new GenericSignature.FormalTypeParameter[0];
		} else {
			return formalsForResolution;
		}
	}

	public ResolvedType getOuterClass() {
		if (!isNested())
			throw new IllegalStateException("Can't get the outer class of a non-nested type");
		int lastDollar = className.lastIndexOf('$');
		String superClassName = className.substring(0, lastDollar);
		UnresolvedType outer = UnresolvedType.forName(superClassName);
		return outer.resolve(getResolvedTypeX().getWorld());
	}

	private void ensureGenericInfoProcessed() {
		if ((bitflag & DISCOVERED_DECLARED_SIGNATURE) != 0)
			return;
		bitflag |= DISCOVERED_DECLARED_SIGNATURE;
		Signature sigAttr = AttributeUtils.getSignatureAttribute(javaClass.getAttributes());
		declaredSignature = (sigAttr == null ? null : sigAttr.getSignature());
		if (declaredSignature != null)
			isGenericType = (declaredSignature.charAt(0) == '<');
	}

	public boolean isGeneric() {
		ensureGenericInfoProcessed();
		return isGenericType;
	}

	public String toString() {
		return (javaClass == null ? "BcelObjectType" : "BcelObjectTypeFor:" + className);
	}

	// --- state management

	public void evictWeavingState() {
		// Can't chuck all this away
		if (getResolvedTypeX().getWorld().couldIncrementalCompileFollow())
			return;

		if (javaClass != null) {
			// Force retrieval of any lazy information
			ensureAnnotationsUnpacked();
			ensureGenericInfoProcessed();

			getDeclaredInterfaces();
			getDeclaredFields();
			getDeclaredMethods();
			// The lazyClassGen is preserved for aspects - it exists to enable
			// around advice
			// inlining since the method will need 'injecting' into the affected
			// class. If
			// XnoInline is on, we can chuck away the lazyClassGen since it
			// won't be required
			// later.
			if (getResolvedTypeX().getWorld().isXnoInline())
				lazyClassGen = null;

			// discard expensive bytecode array containing reweavable info
			if (weaverState != null) {
				weaverState.setReweavable(false);
				weaverState.setUnwovenClassFileData(null);
			}
			for (int i = methods.length - 1; i >= 0; i--)
				methods[i].evictWeavingState();
			for (int i = fields.length - 1; i >= 0; i--)
				fields[i].evictWeavingState();
			javaClass = null;
			// setSourceContext(SourceContextImpl.UNKNOWN_SOURCE_CONTEXT); //
			// bit naughty
			// interfaces=null; // force reinit - may get us the right
			// instances!
			// superClass=null;
		}
	}

	public void weavingCompleted() {
		hasBeenWoven = true;
		if (getResolvedTypeX().getWorld().isRunMinimalMemory())
			evictWeavingState();
		if (getSourceContext() != null && !getResolvedTypeX().isAspect())
			getSourceContext().tidy();
	}

	public boolean hasBeenWoven() {
		return hasBeenWoven;
	}

	public boolean copySourceContext() {
		return false;
	}
}
