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
 * ******************************************************************/

package org.aspectj.weaver.bcel;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.aspectj.apache.bcel.Constants;
import org.aspectj.apache.bcel.classfile.Field;
import org.aspectj.apache.bcel.classfile.ConstantPool;
import org.aspectj.apache.bcel.classfile.Method;
import org.aspectj.apache.bcel.classfile.annotation.AnnotationGen;
import org.aspectj.apache.bcel.generic.FieldGen;
import org.aspectj.apache.bcel.generic.FieldInstruction;
import org.aspectj.apache.bcel.generic.Instruction;
import org.aspectj.apache.bcel.generic.InstructionBranch;
import org.aspectj.apache.bcel.generic.InstructionCP;
import org.aspectj.apache.bcel.generic.InstructionConstants;
import org.aspectj.apache.bcel.generic.InstructionFactory;
import org.aspectj.apache.bcel.generic.InstructionHandle;
import org.aspectj.apache.bcel.generic.InstructionLV;
import org.aspectj.apache.bcel.generic.InstructionList;
import org.aspectj.apache.bcel.generic.InstructionSelect;
import org.aspectj.apache.bcel.generic.InstructionTargeter;
import org.aspectj.apache.bcel.generic.InvokeInstruction;
import org.aspectj.apache.bcel.generic.LineNumberTag;
import org.aspectj.apache.bcel.generic.LocalVariableTag;
import org.aspectj.apache.bcel.generic.MULTIANEWARRAY;
import org.aspectj.apache.bcel.generic.MethodGen;
import org.aspectj.apache.bcel.generic.ObjectType;
import org.aspectj.apache.bcel.generic.RET;
import org.aspectj.apache.bcel.generic.Tag;
import org.aspectj.apache.bcel.generic.Type;
import org.aspectj.asm.AsmManager;
import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.ISourceLocation;
import org.aspectj.bridge.Message;
import org.aspectj.bridge.MessageUtil;
import org.aspectj.bridge.WeaveMessage;
import org.aspectj.bridge.context.CompilationAndWeavingContext;
import org.aspectj.bridge.context.ContextToken;
import org.aspectj.util.PartialOrder;
import org.aspectj.weaver.AjAttribute;
import org.aspectj.weaver.AjcMemberMaker;
import org.aspectj.weaver.AnnotationAJ;
import org.aspectj.weaver.BCException;
import org.aspectj.weaver.ConcreteTypeMunger;
import org.aspectj.weaver.IClassWeaver;
import org.aspectj.weaver.IntMap;
import org.aspectj.weaver.Member;
import org.aspectj.weaver.MissingResolvedTypeWithKnownSignature;
import org.aspectj.weaver.NameMangler;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.aspectj.weaver.NewFieldTypeMunger;
import org.aspectj.weaver.NewMethodTypeMunger;
import org.aspectj.weaver.ResolvedMember;
import org.aspectj.weaver.ResolvedMemberImpl;
import org.aspectj.weaver.ResolvedType;
import org.aspectj.weaver.ResolvedTypeMunger;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.ShadowMunger;
import org.aspectj.weaver.UnresolvedType;
import org.aspectj.weaver.WeaverMessages;
import org.aspectj.weaver.WeaverStateInfo;
import org.aspectj.weaver.World;
import org.aspectj.weaver.model.AsmRelationshipProvider;
import org.aspectj.weaver.patterns.DeclareAnnotation;
import org.aspectj.weaver.patterns.ExactTypePattern;
import org.aspectj.weaver.tools.Trace;
import org.aspectj.weaver.tools.TraceFactory;

public class BcelClassWeaver implements IClassWeaver {

	private static Trace trace = TraceFactory.getTraceFactory().getTrace(BcelClassWeaver.class);

	
	
	public static boolean weave(BcelWorld world, LazyClassGen clazz)
	{
		BcelClassWeaver classWeavernew = new BcelClassWeaver(world, clazz);
		boolean b =  classWeavernew.weave();
		//System.out.println(clazz.getClassName() + ", " + clazz.getType().getWeaverState());
		//clazz.print();
		return b;
	}
	


	// --------------------------------------------

	private final LazyClassGen clazz;
	//private final List shadowMungers;
	private final List typeMungers;
	private final List lateTypeMungers;

	private final BcelObjectType ty; // alias of clazz.getType()
	private final BcelWorld world; // alias of ty.getWorld()
	private final ConstantPool cpg; // alias of clazz.getConstantPoolGen()
	private final InstructionFactory fact; // alias of clazz.getFactory();

	private final List addedLazyMethodGens = new ArrayList();
	private final Set addedDispatchTargets = new HashSet();

	public static boolean inReweavableMode = false;
    
	private List addedSuperInitializersAsList = null; // List<IfaceInitList>
	private final Map addedSuperInitializers = new HashMap(); // Interface ->
	// IfaceInitList
	private final List addedThisInitializers = new ArrayList(); // List<NewFieldMunger>
	private final List addedClassInitializers = new ArrayList(); // List<NewFieldMunger
	// >

	private Set aspectsAffectingType = new HashSet();
	
	private final Map mapToAnnotations = new HashMap();

	// private BcelShadow clinitShadow = null;

	/**
	 * This holds the initialization and pre-initialization shadows for this class that were actually matched by mungers (if no
	 * match, then we don't even create the shadows really).
	 */
	//private final List initializationShadows = new ArrayList(1);

	public BcelClassWeaver(BcelWorld world, 
			                LazyClassGen clazz) {
		super();
		// assert world == clazz.getType().getWorld()
		this.world = world;
		this.clazz = clazz;
		//this.shadowMungers = shadowMungers;
		this.typeMungers = clazz.getBcelObjectType().getResolvedTypeX().getInterTypeMungers();
        this.lateTypeMungers = world.getCrosscuttingMembersSet().getLateTypeMungers();

		this.ty = clazz.getBcelObjectType();
		this.cpg = clazz.getConstantPool();
		this.fact = clazz.getFactory();

		//fastMatchShadowMungers(shadowMungers);

		initializeSuperInitializerMap(ty.getResolvedTypeX());
		if (!checkedXsetForLowLevelContextCapturing) {
			Properties p = world.getExtraConfiguration();
			if (p != null) {
				String s = p.getProperty(World.xsetCAPTURE_ALL_CONTEXT, "false");
				captureLowLevelContext = s.equalsIgnoreCase("true");
				if (captureLowLevelContext)
					world.getMessageHandler().handleMessage(
							MessageUtil.info("[" + World.xsetCAPTURE_ALL_CONTEXT
									+ "=true] Enabling collection of low level context for debug/crash messages"));
			}
			checkedXsetForLowLevelContextCapturing = true;
		}
	}

    public Set getAspectsAffectingType() {
    	return this.aspectsAffectingType;
    }
    
    public List getAddedSuperInitializersAsList() {
    	return this.addedSuperInitializersAsList;
    }
    
    public List getAddedThisInitializers() {
    	return this.addedThisInitializers;
    }

    // ----
    /** SK: Actually, some interesting weaving happens here.
     *  (1) ITDs are weaved (typeMungers apply).
     *  (2) Identify shadows for each method, and match advice
     *       against each shadow
     *  (3) Weave advice into all methods (constructors/initializers)
     *  (4) apply late ITDs (whatever it means). 
     *  The last step seem to only add new methods.
     *       
     *  */
	//not to be called...
    public boolean weave() {
        //AJM.init(this.addedSuperInitializersAsList, this.addedThisInitializers, aspectsAffectingType);
        //COOLM.init();
        //return MM.transform(clazz);
    	return false;
    }


    /** To be called by the AJ weaver before 
     * weaving advice.
     * @return
     */
	public boolean weaveNormalITDs() {
    	
    	//SK: some bullshit
    	//==============================================
        if (clazz.isWoven() && !clazz.isReweavable()) {
        	world.showMessage(IMessage.ERROR, 
        		  WeaverMessages.format(WeaverMessages.ALREADY_WOVEN,clazz.getType().getName()),
				ty.getSourceLocation(), null);
        	return false;
        }
       

        aspectsAffectingType = null;
        if (inReweavableMode || clazz.getType().isAspect()) aspectsAffectingType = new HashSet();
        
        boolean isChanged = false;
        
        // we want to "touch" all aspects
        if (clazz.getType().isAspect()) isChanged = true;

        //SK: (1) applying ITDs
        //      ==============================================
        // start by munging all typeMungers
        for (Iterator i = typeMungers.iterator(); i.hasNext(); ) {
        	Object o = i.next();
        	if ( !(o instanceof BcelTypeMunger) ) {
        		//???System.err.println("surprising: " + o);
        		continue;
        	}
        	BcelTypeMunger munger = (BcelTypeMunger)o;
        	//SK: NOTE: At this point initializers lists are filled with mungers,
        	// namely addedClassInitializers, addedThisInitializers, and 
        	// addedSuperInitializers.get(munger's type).list
        	//
        	//More specifically: 
        	//munger.munge(this) -> munger.mungeNewField(this, munger) -> 
        	//-> this.addInitializer(munger) ->  add the munger into 
        	// one of the three list.
        	
        	boolean typeMungerAffectedType = munger.munge(this);
        	if (typeMungerAffectedType) {
        		isChanged = true;
        		if (inReweavableMode || clazz.getType().isAspect()) aspectsAffectingType.add(munger.getAspectType().getName());
        	}
        }


        //SK: (1.1) Seems like these add annotations to class members
        //      ==============================================
        // Weave special half type/half shadow mungers... 
        isChanged = weaveDeclareAtMethodCtor(clazz) || isChanged;
        isChanged = weaveDeclareAtField(clazz)      || isChanged;
        

        // XXX do major sort of stuff
        // sort according to:  Major:  type hierarchy
        //                     within each list:  dominates
        // don't forget to sort addedThisInitialiers according to dominates
        addedSuperInitializersAsList = new ArrayList(addedSuperInitializers.values());
        addedSuperInitializersAsList = PartialOrder.sort(addedSuperInitializersAsList);        
        if (addedSuperInitializersAsList == null) {
        	throw new BCException("circularity in inter-types");
        }
        //SK: Preparing class for weaving.
        // For now I'll ignore this part. 
        // I need to consider if this part is actually 
        // part of MM weaving preparation process.
        //      ==============================================      
        // this will create a static initializer if there isn't one
        // this is in just as bad taste as NOPs
        LazyMethodGen staticInit = clazz.getStaticInitializer();
        staticInit.getBody().insert(genInitInstructions(addedClassInitializers, true));
        
        //SK: That's where the MM should go (for  now).
        // Later, the MM should be expanded to cover previous
        // actions too, and allow collaborative program preparation,
        // and collaborative ITDs changes.
        // Right now I'm concerned with collaborative advice weaving.
        return isChanged;
	}

	/** To be called by the AJ weaver after weaving advice.
	 * 
	 * @param isChanged specifies whether class is changed at previous weaving stages.
	 * @return
	 */
	public boolean weaveLateITDs(boolean isChanged) {
       //SK: (4) late type mungers.
		// Seem to add stuff into aspects to achieve PerCflow, PerObject, PerTypeWithn, and PerSingleton
		// semantics of aspect creation, and also extra methods (e.g., aspectOf()).
		// Not really advice weaving.
       //      ==============================================
	
       // now proceed with late type mungers
       if (lateTypeMungers != null) {
           for (Iterator i = lateTypeMungers.iterator(); i.hasNext(); ) {
               BcelTypeMunger munger = (BcelTypeMunger)i.next();
               if (munger.matches(clazz.getType())) {
                   boolean typeMungerAffectedType = munger.munge(this);
                   if (typeMungerAffectedType) {
                       isChanged = true;
                       if (inReweavableMode || clazz.getType().isAspect()) aspectsAffectingType.add(munger.getAspectType().getName());
                   }
               }
           }
       }

       //FIXME AV - see #75442, for now this is not enough to fix the bug, comment that out until we really fix it
//       // flush to save some memory
//       PerObjectInterfaceTypeMunger.unregisterFromAsAdvisedBy(clazz.getType());

		// finally, if we changed, we add in the introduced methods.
       if (isChanged) {
       	clazz.getOrCreateWeaverStateInfo(inReweavableMode);
			weaveInAddedMethods(); // FIXME asc are these potentially affected by declare annotation?
       }
       
       if (inReweavableMode) {
       	WeaverStateInfo wsi = clazz.getOrCreateWeaverStateInfo(true);
       	wsi.addAspectsAffectingType(aspectsAffectingType);
       	wsi.setUnwovenClassFileData(ty.getJavaClass().getBytes());
       	wsi.setReweavable(true);
       } else {
       	clazz.getOrCreateWeaverStateInfo(false).setReweavable(false);
       }
       
       return isChanged;

	}
   
    /** SK: Given a type <code>child</code>, the method  
     * (1) identifies ALL interface types that this type implements (incl. recursively)
     * (2) for every interface checks if the the type transformed by this BcelClassWeaver
     * object is the top-most implementor of the interface.
     * If it is, then the interface is added into the <code>addedSuperInitializers</code> map.
     */
	private void initializeSuperInitializerMap(ResolvedType child) {
		ResolvedType[] superInterfaces = child.getDeclaredInterfaces();
		for (int i=0, len=superInterfaces.length; i < len; i++) {
			if (ty.getResolvedTypeX().isTopmostImplementor(superInterfaces[i])) {
				//the guard returns true iff the interface is just added to the 
				//addedSuperInitializers list
				if (addSuperInitializer(superInterfaces[i])) {
					initializeSuperInitializerMap(superInterfaces[i]);
				}
			}
		}
	}

	/** SK: this method is always applied on interface types.
	 * It wraps the interface type as adds interface type to the <code>addedSuperInitializers</code> map.
	 * Returns <code>false</code>, if the interface type is already in the map.
	 * Returns <code>true</code>, if the interface was just added to the map.
	 * The map's keys are ResolvedType objects. The map's values are IfaceInitList objects.
	 * An IfaceInitList object is a wrapper around the ResolvedType object. */
	private boolean addSuperInitializer(ResolvedType onType) {
		if (onType.isRawType() || onType.isParameterizedType()) onType = onType.getGenericType();
		IfaceInitList l = (IfaceInitList) addedSuperInitializers.get(onType);
		if (l != null) return false;
		l = new IfaceInitList(onType);
		addedSuperInitializers.put(onType, l);
		return true;
	}
   
	/** This method adds the <code>cm</code> argument into 
	 * <code>addedClassInitializers</code> (if cm.getMunger().getSignature().isStatic())
	 * OR into addedThisInitializers 
	 * (if  cm.getMunger().getSignature().getDeclaringType() = this BcelClassWeaver's class),
	 * OR into addedSuperInitializer.get(cm.getMunger().getSignature().getDeclaringType()).list 
	 * @param cm 
	 */
	public void addInitializer(ConcreteTypeMunger cm) {
		NewFieldTypeMunger m = (NewFieldTypeMunger) cm.getMunger();
		ResolvedType onType = m.getSignature().getDeclaringType().resolve(world);
		if (onType.isRawType()) onType = onType.getGenericType();

		if (m.getSignature().isStatic()) {
			addedClassInitializers.add(cm);
		} else {
			if (onType == ty.getResolvedTypeX()) {
				addedThisInitializers.add(cm);
			} else {
				IfaceInitList l = (IfaceInitList) addedSuperInitializers.get(onType);
				l.list.add(cm);
			}
		}
	}
    
	/** SK: Wrapper for a type 
	 * 
	 * 
	 *
	 */ 
    public static class IfaceInitList implements PartialOrder.PartialComparable {
    	public final ResolvedType onType;
    	public List list = new ArrayList();
    	IfaceInitList(ResolvedType onType) {
    		this.onType = onType;
    	}
    	
		public int compareTo(Object other) {
			IfaceInitList o = (IfaceInitList)other;
			if (onType.isAssignableFrom(o.onType)) return +1;
			else if (o.onType.isAssignableFrom(onType)) return -1;
			else return 0;
		}

		public int fallbackCompareTo(Object other) {
			return 0;
		}
    }
    
    // XXX this is being called, but the result doesn't seem to be being used
    public boolean addDispatchTarget(ResolvedMember m) {
    	return addedDispatchTargets.add(m);
    }
    
    public void addLazyMethodGen(LazyMethodGen gen) {
    	addedLazyMethodGens.add(gen);
    }
    	
	public void addOrReplaceLazyMethodGen(LazyMethodGen mg) {
		if (alreadyDefined(clazz, mg)) return;
		
		for (Iterator i = addedLazyMethodGens.iterator(); i.hasNext(); ) {
			LazyMethodGen existing = (LazyMethodGen)i.next();
			if (signaturesMatch(mg, existing)) {
				if (existing.definingType == null) {
					// this means existing was introduced on the class itself
					return;
				} else if (mg.definingType.isAssignableFrom(existing.definingType)) {
					// existing is mg's subtype and dominates mg
					return;
				} else if (existing.definingType.isAssignableFrom(mg.definingType)) {
					// mg is existing's subtype and dominates existing
					i.remove();
					addedLazyMethodGens.add(mg);
					return;
				} else {
					throw new BCException("conflict between: " + mg + " and " + existing);
				}
			} 
		}
		addedLazyMethodGens.add(mg);
	}

	private boolean alreadyDefined(LazyClassGen clazz, LazyMethodGen mg) {
		for (Iterator i = clazz.getMethodGens().iterator(); i.hasNext(); ) {
			LazyMethodGen existing = (LazyMethodGen)i.next();
			if (signaturesMatch(mg, existing)) {
				if (!mg.isAbstract() && existing.isAbstract()) {
					i.remove();
					return false;
				}
				return true;
			}
		}
		return false;
	}

	private boolean signaturesMatch(LazyMethodGen mg, LazyMethodGen existing) {
		return mg.getName().equals(existing.getName()) &&
			mg.getSignature().equals(existing.getSignature());
	}    	
    
	
	protected static LazyMethodGen makeBridgeMethod(LazyClassGen gen, ResolvedMember member) {

		// remove abstract modifier
		int mods = member.getModifiers();
		if (Modifier.isAbstract(mods)) mods = mods - Modifier.ABSTRACT;
		
		LazyMethodGen ret = new LazyMethodGen(
			mods,
			BcelWorld.makeBcelType(member.getReturnType()),
			member.getName(),
			BcelWorld.makeBcelTypes(member.getParameterTypes()),
			UnresolvedType.getNames(member.getExceptions()),
			gen);
        
        // 43972 : Static crosscutting makes interfaces unusable for javac
        // ret.makeSynthetic();    
		return ret;
	}
	
	
	/**
	 * Create a single bridge method called 'theBridgeMethod' that bridges to 'whatToBridgeTo'
	 */
	private static void createBridgeMethod(BcelWorld world, LazyMethodGen whatToBridgeToMethodGen, LazyClassGen clazz,ResolvedMember theBridgeMethod) {
		InstructionList body;
		InstructionFactory fact;
		int pos = 0;

		ResolvedMember whatToBridgeTo = whatToBridgeToMethodGen.getMemberView();
		
		if (whatToBridgeTo==null) {
			whatToBridgeTo = 
			  new ResolvedMemberImpl(Member.METHOD,
				whatToBridgeToMethodGen.getEnclosingClass().getType(),
				whatToBridgeToMethodGen.getAccessFlags(),
				whatToBridgeToMethodGen.getName(),
				whatToBridgeToMethodGen.getSignature());
		}
		LazyMethodGen bridgeMethod = makeBridgeMethod(clazz,theBridgeMethod); // The bridge method in this type will have the same signature as the one in the supertype
		bridgeMethod.setAccessFlags(bridgeMethod.getAccessFlags() | 0x00000040 /*BRIDGE    = 0x00000040*/ );
		Type returnType   = BcelWorld.makeBcelType(theBridgeMethod.getReturnType());
		Type[] paramTypes = BcelWorld.makeBcelTypes(theBridgeMethod.getParameterTypes());
		Type[] newParamTypes=whatToBridgeToMethodGen.getArgumentTypes();
		body = bridgeMethod.getBody();
		fact = clazz.getFactory();

		if (!whatToBridgeToMethodGen.isStatic()) {
		   body.append(InstructionFactory.createThis());
		   pos++;
		}
		for (int i = 0, len = paramTypes.length; i < len; i++) {
		  Type paramType = paramTypes[i];
		  body.append(InstructionFactory.createLoad(paramType, pos));
		  if (!newParamTypes[i].equals(paramTypes[i])) {
			  if (world.forDEBUG_bridgingCode) System.err.println("Bridging: Cast "+newParamTypes[i]+" from "+paramTypes[i]);
			  body.append(fact.createCast(paramTypes[i],newParamTypes[i]));
		  }
		  pos+=paramType.getSize();
		}

		body.append(Utility.createInvoke(fact, world,whatToBridgeTo));
		body.append(InstructionFactory.createReturn(returnType));
		clazz.addMethodGen(bridgeMethod);
	}
	    
    
    // **************************** start of bridge method creation code *****************
    
	// FIXME asc tidy this lot up !!

	// FIXME asc refactor into ResolvedType or even ResolvedMember?
	/**
	 * Check if a particular method is overriding another - refactored into this helper so it can be used from multiple places.
	 */
	private static ResolvedMember isOverriding(ResolvedType typeToCheck, ResolvedMember methodThatMightBeGettingOverridden,
			String mname, String mrettype, int mmods, boolean inSamePackage, UnresolvedType[] methodParamsArray) {
		// Check if we can be an override...
		if (methodThatMightBeGettingOverridden.isStatic())
			return null; // we can't be overriding a static method
		if (methodThatMightBeGettingOverridden.isPrivate())
			return null; // we can't be overriding a private method
		if (!methodThatMightBeGettingOverridden.getName().equals(mname))
			return null; // names dont match (this will also skip <init> and
		// <clinit> too)
		if (methodThatMightBeGettingOverridden.getParameterTypes().length != methodParamsArray.length)
			return null; // check same number of parameters
		if (!isVisibilityOverride(mmods, methodThatMightBeGettingOverridden, inSamePackage))
			return null;

		if (typeToCheck.getWorld().forDEBUG_bridgingCode)
			System.err.println("  Bridging:seriously considering this might be getting overridden '"
					+ methodThatMightBeGettingOverridden + "'");

		// Look at erasures of parameters (List<String> erased is List)
		boolean sameParams = true;
		for (int p = 0; p < methodThatMightBeGettingOverridden.getParameterTypes().length; p++) {
			if (!methodThatMightBeGettingOverridden.getParameterTypes()[p].getErasureSignature().equals(
					methodParamsArray[p].getErasureSignature()))
				sameParams = false;
		}

		// If the 'typeToCheck' represents a parameterized type then the method
		// will be the parameterized form of the
		// generic method in the generic type. So if the method was 'void
		// m(List<T> lt, T t)' and the parameterized type here
		// is I<String> then the method we are looking at will be 'void
		// m(List<String> lt, String t)' which when erased
		// is 'void m(List lt,String t)' - so if the parameters *do* match then
		// there is a generic method we are
		// overriding

		if (sameParams) {
			// check for covariance
			if (typeToCheck.isParameterizedType()) {
				return methodThatMightBeGettingOverridden.getBackingGenericMember();
			} else if (!methodThatMightBeGettingOverridden.getReturnType().getErasureSignature().equals(mrettype)) {
				// addressing the wierd situation from bug 147801
				// just check whether these things are in the right relationship
				// for covariance...
				ResolvedType superReturn = typeToCheck.getWorld().resolve(
						UnresolvedType.forSignature(methodThatMightBeGettingOverridden.getReturnType().getErasureSignature()));
				ResolvedType subReturn = typeToCheck.getWorld().resolve(UnresolvedType.forSignature(mrettype));
				if (superReturn.isAssignableFrom(subReturn))
					return methodThatMightBeGettingOverridden;
			}
		}
		return null;
	}

	/**
	 * Looks at the visibility modifiers between two methods, and knows whether they are from classes in the same package, and
	 * decides whether one overrides the other.
	 * 
	 * @return true if there is an overrides rather than a 'hides' relationship
	 */
	static boolean isVisibilityOverride(int methodMods, ResolvedMember inheritedMethod, boolean inSamePackage) {
		if (inheritedMethod.isStatic())
			return false;
		if (methodMods == inheritedMethod.getModifiers())
			return true;

		if (inheritedMethod.isPrivate())
			return false;

		boolean isPackageVisible = !inheritedMethod.isPrivate() && !inheritedMethod.isProtected() && !inheritedMethod.isPublic();
		if (isPackageVisible && !inSamePackage)
			return false;

		return true;
	}
    
	/**
	 * This method recurses up a specified type looking for a method that overrides the one passed in.
	 * 
	 * @return the method being overridden or null if none is found
	 */
	public static ResolvedMember checkForOverride(ResolvedType typeToCheck, String mname, String mparams, String mrettype,
			int mmods, String mpkg, UnresolvedType[] methodParamsArray) {

		if (typeToCheck == null)
			return null;
		if (typeToCheck instanceof MissingResolvedTypeWithKnownSignature)
			return null; // we just can't tell !

		if (typeToCheck.getWorld().forDEBUG_bridgingCode)
			System.err.println("  Bridging:checking for override of " + mname + " in " + typeToCheck);

		String packageName = typeToCheck.getPackageName();
		if (packageName == null)
			packageName = "";
		boolean inSamePackage = packageName.equals(mpkg); // used when looking
		// at visibility
		// rules

		ResolvedMember[] methods = typeToCheck.getDeclaredMethods();
		for (int ii = 0; ii < methods.length; ii++) {
			ResolvedMember methodThatMightBeGettingOverridden = methods[ii]; // the
			// method
			// we
			// are
			// going
			// to
			// check
			ResolvedMember isOverriding = isOverriding(typeToCheck, methodThatMightBeGettingOverridden, mname, mrettype, mmods,
					inSamePackage, methodParamsArray);
			if (isOverriding != null)
				return isOverriding;
		}
		List l = typeToCheck.getInterTypeMungers();
		for (Iterator iterator = l.iterator(); iterator.hasNext();) {
			Object o = iterator.next();
			// FIXME asc if its not a BcelTypeMunger then its an
			// EclipseTypeMunger ... do I need to worry about that?
			if (o instanceof BcelTypeMunger) {
				BcelTypeMunger element = (BcelTypeMunger) o;
				if (element.getMunger() instanceof NewMethodTypeMunger) {
					if (typeToCheck.getWorld().forDEBUG_bridgingCode)
						System.err.println("Possible ITD candidate " + element);
					ResolvedMember aMethod = element.getSignature();
					ResolvedMember isOverriding = isOverriding(typeToCheck, aMethod, mname, mrettype, mmods, inSamePackage,
							methodParamsArray);
					if (isOverriding != null)
						return isOverriding;
				}
			}
		}

		if (typeToCheck.equals(UnresolvedType.OBJECT))
			return null;

		ResolvedType superclass = typeToCheck.getSuperclass();
		ResolvedMember overriddenMethod = checkForOverride(superclass, mname, mparams, mrettype, mmods, mpkg, methodParamsArray);
		if (overriddenMethod != null)
			return overriddenMethod;

		ResolvedType[] interfaces = typeToCheck.getDeclaredInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			ResolvedType anInterface = interfaces[i];
			overriddenMethod = checkForOverride(anInterface, mname, mparams, mrettype, mmods, mpkg, methodParamsArray);
			if (overriddenMethod != null)
				return overriddenMethod;
		}
		return null;
	}

	/**
	 * We need to determine if any methods in this type require bridge methods - this method should only be called if necessary to
	 * do this calculation, i.e. we are on a 1.5 VM (where covariance/generics exist) and the type hierarchy for the specified class
	 * has changed (via decp/itd).
	 * 
	 * See pr108101
	 */
	public static boolean calculateAnyRequiredBridgeMethods(BcelWorld world, LazyClassGen clazz) {
		world.ensureAdvancedConfigurationProcessed();
		if (!world.isInJava5Mode())
			return false; // just double check... the caller should have already
		// verified this
		if (clazz.isInterface())
			return false; // dont bother if we're an interface
		boolean didSomething = false; // set if we build any bridge methods

		// So what methods do we have right now in this class?
		List /* LazyMethodGen */methods = clazz.getMethodGens();

		// Keep a set of all methods from this type - it'll help us to check if
		// bridge methods
		// have already been created, we don't want to do it twice!
		Set methodsSet = new HashSet();
		for (int i = 0; i < methods.size(); i++) {
			LazyMethodGen aMethod = (LazyMethodGen) methods.get(i);
			methodsSet.add(aMethod.getName() + aMethod.getSignature()); // e.g.
			// "foo(Ljava/lang/String;)V"
		}

		// Now go through all the methods in this type
		for (int i = 0; i < methods.size(); i++) {

			// This is the local method that we *might* have to bridge to
			LazyMethodGen bridgeToCandidate = (LazyMethodGen) methods.get(i);
			if (bridgeToCandidate.isBridgeMethod())
				continue; // Doh!
			String name = bridgeToCandidate.getName();
			String psig = bridgeToCandidate.getParameterSignature();
			String rsig = bridgeToCandidate.getReturnType().getSignature();

			// if (bridgeToCandidate.isAbstract()) continue;
			if (bridgeToCandidate.isStatic())
				continue; // ignore static methods
			if (name.endsWith("init>"))
				continue; // Skip constructors and static initializers

			if (world.forDEBUG_bridgingCode)
				System.err.println("Bridging: Determining if we have to bridge to " + clazz.getName() + "." + name + ""
						+ bridgeToCandidate.getSignature());

			// Let's take a look at the superclass
			ResolvedType theSuperclass = clazz.getSuperClass();
			if (world.forDEBUG_bridgingCode) {
				System.err.println("Bridging: Checking supertype " + theSuperclass);
			}
			String pkgName = clazz.getPackageName();
			UnresolvedType[] bm = BcelWorld.fromBcel(bridgeToCandidate.getArgumentTypes());
			ResolvedMember overriddenMethod = checkForOverride(theSuperclass, name, psig, rsig, bridgeToCandidate.getAccessFlags(),
					pkgName, bm);
			if (overriddenMethod != null) {
				String key = new StringBuffer().append(overriddenMethod.getName()).append(overriddenMethod.getSignatureErased())
						.toString(); // pr237419
				boolean alreadyHaveABridgeMethod = methodsSet.contains(key);
				if (!alreadyHaveABridgeMethod) {
					if (world.forDEBUG_bridgingCode) {
						System.err.println("Bridging:bridging to '" + overriddenMethod + "'");
					}
					createBridgeMethod(world, bridgeToCandidate, clazz, overriddenMethod);
					methodsSet.add(key);
					didSomething = true;
					continue; // look at the next method
				}
			}

			// Check superinterfaces
			String[] interfaces = clazz.getInterfaceNames();
			for (int j = 0; j < interfaces.length; j++) {
				if (world.forDEBUG_bridgingCode)
					System.err.println("Bridging:checking superinterface " + interfaces[j]);
				ResolvedType interfaceType = world.resolve(interfaces[j]);
				overriddenMethod = checkForOverride(interfaceType, name, psig, rsig, bridgeToCandidate.getAccessFlags(), clazz
						.getPackageName(), bm);
				if (overriddenMethod != null) {
					String key = new StringBuffer().append(overriddenMethod.getName())
							.append(overriddenMethod.getSignatureErased()).toString(); // pr
					// 237419
					boolean alreadyHaveABridgeMethod = methodsSet.contains(key);
					if (!alreadyHaveABridgeMethod) {
						createBridgeMethod(world, bridgeToCandidate, clazz, overriddenMethod);
						methodsSet.add(key);
						didSomething = true;
						if (world.forDEBUG_bridgingCode)
							System.err.println("Bridging:bridging to " + overriddenMethod);
						continue; // look at the next method
					}
				}
			}
		}

		return didSomething;
	}

	// **************************** end of bridge method creation code
	// *****************

	/**
	 * Weave any declare @method/@ctor statements into the members of the supplied class
	 */
	private boolean weaveDeclareAtMethodCtor(LazyClassGen clazz) {
		List reportedProblems = new ArrayList();

		List allDecams = world.getDeclareAnnotationOnMethods();
		if (allDecams.isEmpty())
			return false; // nothing to do

		boolean isChanged = false;

		// deal with ITDs
		List itdMethodsCtors = getITDSubset(clazz, ResolvedTypeMunger.Method);
		itdMethodsCtors.addAll(getITDSubset(clazz, ResolvedTypeMunger.Constructor));
		if (!itdMethodsCtors.isEmpty()) {
			// Can't use the subset called 'decaMs' as it won't be right for
			// ITDs...
			isChanged = weaveAtMethodOnITDSRepeatedly(allDecams, itdMethodsCtors, reportedProblems);
		}

		// deal with all the other methods...
		List members = clazz.getMethodGens();
		List decaMs = getMatchingSubset(allDecams, clazz.getType());
		if (decaMs.isEmpty())
			return false; // nothing to do
		if (!members.isEmpty()) {
			Set unusedDecams = new HashSet();
			unusedDecams.addAll(decaMs);
			for (int memberCounter = 0; memberCounter < members.size(); memberCounter++) {
				LazyMethodGen mg = (LazyMethodGen) members.get(memberCounter);
				if (!mg.getName().startsWith(NameMangler.PREFIX)) {

					// Single first pass
					List worthRetrying = new ArrayList();
					boolean modificationOccured = false;
					List /* AnnotationGen */annotationsToAdd = null;
					for (Iterator iter = decaMs.iterator(); iter.hasNext();) {
						DeclareAnnotation decaM = (DeclareAnnotation) iter.next();

						if (decaM.matches(mg.getMemberView(), world)) {
							if (doesAlreadyHaveAnnotation(mg.getMemberView(), decaM, reportedProblems)) {
								// remove the declare @method since don't want
								// an error when the annotation is already there
								unusedDecams.remove(decaM);
								continue; // skip this one...
							}

							if (annotationsToAdd == null)
								annotationsToAdd = new ArrayList();
							AnnotationGen a = ((BcelAnnotation) decaM.getAnnotationX()).getBcelAnnotation();
							AnnotationGen ag = new AnnotationGen(a, clazz.getConstantPool(), true);
							annotationsToAdd.add(ag);
							mg.addAnnotation(decaM.getAnnotationX());

							AsmRelationshipProvider.addDeclareAnnotationMethodRelationship(decaM.getSourceLocation(), clazz
									.getName(), mg.getMemberView(), world.getModelAsAsmManager());// getMethod());
							reportMethodCtorWeavingMessage(clazz, mg.getMemberView(), decaM, mg.getDeclarationLineNumber());
							isChanged = true;
							modificationOccured = true;
							// remove the declare @method since have matched
							// against it
							unusedDecams.remove(decaM);
						} else {
							if (!decaM.isStarredAnnotationPattern())
								worthRetrying.add(decaM); // an annotation is
							// specified that
							// might be put on
							// by a subsequent
							// decaf
						}
					}

					// Multiple secondary passes
					while (!worthRetrying.isEmpty() && modificationOccured) {
						modificationOccured = false;
						// lets have another go
						List forRemoval = new ArrayList();
						for (Iterator iter = worthRetrying.iterator(); iter.hasNext();) {
							DeclareAnnotation decaM = (DeclareAnnotation) iter.next();
							if (decaM.matches(mg.getMemberView(), world)) {
								if (doesAlreadyHaveAnnotation(mg.getMemberView(), decaM, reportedProblems)) {
									// remove the declare @method since don't
									// want an error when
									// the annotation is already there
									unusedDecams.remove(decaM);
									continue; // skip this one...
								}

								if (annotationsToAdd == null) {
									annotationsToAdd = new ArrayList();
								}
								AnnotationGen a = ((BcelAnnotation) decaM.getAnnotationX()).getBcelAnnotation();
								// create copy to get the annotation type into the right constant pool
								AnnotationGen ag = new AnnotationGen(a, clazz.getConstantPool(), true);
								annotationsToAdd.add(ag);
								mg.addAnnotation(decaM.getAnnotationX());
								AsmRelationshipProvider.addDeclareAnnotationMethodRelationship(decaM.getSourceLocation(), clazz
										.getName(), mg.getMemberView(), world.getModelAsAsmManager());// getMethod());
								isChanged = true;
								modificationOccured = true;
								forRemoval.add(decaM);
								// remove the declare @method since have matched
								// against it
								unusedDecams.remove(decaM);
							}
						}
						worthRetrying.removeAll(forRemoval);
					}
					if (annotationsToAdd != null) {
						Method oldMethod = mg.getMethod();
						MethodGen myGen = new MethodGen(oldMethod, clazz.getClassName(), clazz.getConstantPool(), false);
						for (Iterator iter = annotationsToAdd.iterator(); iter.hasNext();) {
							AnnotationGen a = (AnnotationGen) iter.next();
							myGen.addAnnotation(a);
						}
						Method newMethod = myGen.getMethod();
						members.set(memberCounter, new LazyMethodGen(newMethod, clazz));
					}

				}
			}
			checkUnusedDeclareAtTypes(unusedDecams, false);
		}
		return isChanged;
    }

	
	// TAG: WeavingMessage
	private void reportMethodCtorWeavingMessage(LazyClassGen clazz, ResolvedMember member, DeclareAnnotation decaM,
			int memberLineNumber) {
		if (!getWorld().getMessageHandler().isIgnoring(IMessage.WEAVEINFO)) {
			StringBuffer parmString = new StringBuffer("(");
			UnresolvedType[] paramTypes = member.getParameterTypes();
			for (int i = 0; i < paramTypes.length; i++) {
				UnresolvedType type = paramTypes[i];
				String s = org.aspectj.apache.bcel.classfile.Utility.signatureToString(type.getSignature());
				if (s.lastIndexOf('.') != -1)
					s = s.substring(s.lastIndexOf('.') + 1);
				parmString.append(s);
				if ((i + 1) < paramTypes.length)
					parmString.append(",");
			}
			parmString.append(")");
			String methodName = member.getName();
			StringBuffer sig = new StringBuffer();
			sig.append(org.aspectj.apache.bcel.classfile.Utility.accessToString(member.getModifiers()));
			sig.append(" ");
			sig.append(member.getReturnType().toString());
			sig.append(" ");
			sig.append(member.getDeclaringType().toString());
			sig.append(".");
			sig.append(methodName.equals("<init>") ? "new" : methodName);
			sig.append(parmString);

			StringBuffer loc = new StringBuffer();
			if (clazz.getFileName() == null) {
				loc.append("no debug info available");
			} else {
				loc.append(clazz.getFileName());
				if (memberLineNumber != -1) {
					loc.append(":" + memberLineNumber);
				}
			}
			getWorld().getMessageHandler().handleMessage(
					WeaveMessage.constructWeavingMessage(WeaveMessage.WEAVEMESSAGE_ANNOTATES, new String[] { sig.toString(),
							loc.toString(), decaM.getAnnotationString(),
							methodName.startsWith("<init>") ? "constructor" : "method", decaM.getAspect().toString(),
							Utility.beautifyLocation(decaM.getSourceLocation()) }));
		}
	}
    
	/**
	 * Looks through a list of declare annotation statements and only returns
	 * those that could possibly match on a field/method/ctor in type.
	 */
	private List getMatchingSubset(List declareAnnotations, ResolvedType type) {
	    List subset = new ArrayList();
	    for (Iterator iter = declareAnnotations.iterator(); iter.hasNext();) {
			DeclareAnnotation da = (DeclareAnnotation) iter.next();
			if (da.couldEverMatch(type)) {
				subset.add(da);
			}
		}
		return subset;
	}

	
    /**
     * Get a subset of all the type mungers defined on this aspect
     */
	private List getITDSubset(LazyClassGen clazz,ResolvedTypeMunger.Kind wantedKind) {
		List subset = new ArrayList();
		Collection c = clazz.getBcelObjectType().getTypeMungers();
		for (Iterator iter = c.iterator();iter.hasNext();) {
			BcelTypeMunger typeMunger = (BcelTypeMunger)iter.next();
			if (typeMunger.getMunger().getKind()==wantedKind) 
				subset.add(typeMunger);
		}
		return subset;
	}
	
	public LazyMethodGen locateAnnotationHolderForFieldMunger(LazyClassGen clazz,BcelTypeMunger fieldMunger) {
		NewFieldTypeMunger nftm = (NewFieldTypeMunger)fieldMunger.getMunger();
		ResolvedMember lookingFor =AjcMemberMaker.interFieldInitializer(nftm.getSignature(),clazz.getType());
		List meths = clazz.getMethodGens();
		for (Iterator iter = meths.iterator(); iter.hasNext();) {
			LazyMethodGen element = (LazyMethodGen) iter.next();
			if (element.getName().equals(lookingFor.getName())) return element;
		}
		return null;
	}
	
	// FIXME asc refactor this to neaten it up
	public LazyMethodGen locateAnnotationHolderForMethodCtorMunger(LazyClassGen clazz, BcelTypeMunger methodCtorMunger) {
		ResolvedTypeMunger rtMunger = methodCtorMunger.getMunger();
		ResolvedMember lookingFor = null;
		if (rtMunger instanceof NewMethodTypeMunger) {
			NewMethodTypeMunger nftm = (NewMethodTypeMunger) rtMunger;
			lookingFor = AjcMemberMaker.interMethodDispatcher(nftm.getSignature(), methodCtorMunger.getAspectType());
		} else if (rtMunger instanceof NewConstructorTypeMunger) {
			NewConstructorTypeMunger nftm = (NewConstructorTypeMunger) rtMunger;
			lookingFor = AjcMemberMaker.postIntroducedConstructor(methodCtorMunger.getAspectType(), nftm.getSignature()
					.getDeclaringType(), nftm.getSignature().getParameterTypes());
		} else {
			throw new BCException("Not sure what this is: " + methodCtorMunger);
		}
		List meths = clazz.getMethodGens();
		String name = lookingFor.getName();
		String paramSignature = lookingFor.getParameterSignature();
		for (Iterator iter = meths.iterator(); iter.hasNext();) {
			LazyMethodGen element = (LazyMethodGen) iter.next();
			if (element.getName().equals(name) && element.getParameterSignature().equals(paramSignature)) {
				return element;
			}
		}
		return null;

	}

	/**
	 * Applies some set of declare @field constructs (List<DeclareAnnotation>) to some bunch of ITDfields (List<BcelTypeMunger>. It
	 * will iterate over the fields repeatedly until everything has been applied.
	 * 
	 */
	private boolean weaveAtFieldRepeatedly(List decaFs, List itdFields, List reportedErrors) {
		boolean isChanged = false;
		for (Iterator iter = itdFields.iterator(); iter.hasNext();) {
			BcelTypeMunger fieldMunger = (BcelTypeMunger) iter.next();
			ResolvedMember itdIsActually = fieldMunger.getSignature();
			List worthRetrying = new ArrayList();
			boolean modificationOccured = false;

			for (Iterator iter2 = decaFs.iterator(); iter2.hasNext();) {
				DeclareAnnotation decaF = (DeclareAnnotation) iter2.next();

				if (decaF.matches(itdIsActually, world)) {
					LazyMethodGen annotationHolder = locateAnnotationHolderForFieldMunger(clazz, fieldMunger);
					if (doesAlreadyHaveAnnotation(annotationHolder, itdIsActually, decaF, reportedErrors))
						continue; // skip this one...
					annotationHolder.addAnnotation(decaF.getAnnotationX());
					AsmRelationshipProvider.addDeclareAnnotationRelationship(world.getModelAsAsmManager(), decaF
							.getSourceLocation(), itdIsActually.getSourceLocation());
					isChanged = true;
					modificationOccured = true;

				} else {
					if (!decaF.isStarredAnnotationPattern())
						worthRetrying.add(decaF); // an annotation is specified
					// that might be put on by a
					// subsequent decaf
				}
			}

			while (!worthRetrying.isEmpty() && modificationOccured) {
				modificationOccured = false;
				List forRemoval = new ArrayList();
				for (Iterator iter2 = worthRetrying.iterator(); iter2.hasNext();) {
					DeclareAnnotation decaF = (DeclareAnnotation) iter2.next();
					if (decaF.matches(itdIsActually, world)) {
						LazyMethodGen annotationHolder = locateAnnotationHolderForFieldMunger(clazz, fieldMunger);
						if (doesAlreadyHaveAnnotation(annotationHolder, itdIsActually, decaF, reportedErrors))
							continue; // skip this one...
						annotationHolder.addAnnotation(decaF.getAnnotationX());
						AsmRelationshipProvider.addDeclareAnnotationRelationship(world.getModelAsAsmManager(), decaF
								.getSourceLocation(), itdIsActually.getSourceLocation());
						isChanged = true;
						modificationOccured = true;
						forRemoval.add(decaF);
					}
					worthRetrying.removeAll(forRemoval);
				}
			}
		}
		return isChanged;
	}
	
	
	/**
	 * Applies some set of declare @method/@ctor constructs (List<DeclareAnnotation>) to some bunch of ITDmembers
	 * (List<BcelTypeMunger>. It will iterate over the fields repeatedly until everything has been applied.
	 */
	private boolean weaveAtMethodOnITDSRepeatedly(List decaMCs, List itdsForMethodAndConstructor, List reportedErrors) {
		boolean isChanged = false;
		AsmManager asmManager = world.getModelAsAsmManager();
		for (Iterator iter = itdsForMethodAndConstructor.iterator(); iter.hasNext();) {
			BcelTypeMunger methodctorMunger = (BcelTypeMunger) iter.next();
			ResolvedMember unMangledInterMethod = methodctorMunger.getSignature();
			List worthRetrying = new ArrayList();
			boolean modificationOccured = false;

			for (Iterator iter2 = decaMCs.iterator(); iter2.hasNext();) {
				DeclareAnnotation decaMC = (DeclareAnnotation) iter2.next();
				if (decaMC.matches(unMangledInterMethod, world)) {
					LazyMethodGen annotationHolder = locateAnnotationHolderForMethodCtorMunger(clazz, methodctorMunger);
					if (annotationHolder == null
							|| doesAlreadyHaveAnnotation(annotationHolder, unMangledInterMethod, decaMC, reportedErrors)) {
						continue; // skip this one...
					}
					annotationHolder.addAnnotation(decaMC.getAnnotationX());
					isChanged = true;
					AsmRelationshipProvider.addDeclareAnnotationRelationship(asmManager, decaMC.getSourceLocation(),
							unMangledInterMethod.getSourceLocation());
					reportMethodCtorWeavingMessage(clazz, unMangledInterMethod, decaMC, -1);
					modificationOccured = true;
				} else {
					// If an annotation is specified, it might be added by one of the other declare annotation statements
					if (!decaMC.isStarredAnnotationPattern()) {
						worthRetrying.add(decaMC);
					}
				}
			}

			while (!worthRetrying.isEmpty() && modificationOccured) {
				modificationOccured = false;
				List forRemoval = new ArrayList();
				for (Iterator iter2 = worthRetrying.iterator(); iter2.hasNext();) {
					DeclareAnnotation decaMC = (DeclareAnnotation) iter2.next();
					if (decaMC.matches(unMangledInterMethod, world)) {
						LazyMethodGen annotationHolder = locateAnnotationHolderForFieldMunger(clazz, methodctorMunger);
						if (doesAlreadyHaveAnnotation(annotationHolder, unMangledInterMethod, decaMC, reportedErrors))
							continue; // skip this one...
						annotationHolder.addAnnotation(decaMC.getAnnotationX());
						unMangledInterMethod.addAnnotation(decaMC.getAnnotationX());
						AsmRelationshipProvider.addDeclareAnnotationRelationship(asmManager, decaMC.getSourceLocation(),
								unMangledInterMethod.getSourceLocation());
						isChanged = true;
						modificationOccured = true;
						forRemoval.add(decaMC);
					}
					worthRetrying.removeAll(forRemoval);
				}
			}
		}
		return isChanged;
	}
	
	private boolean dontAddTwice(DeclareAnnotation decaF, AnnotationAJ[] dontAddMeTwice) {
		for (int i = 0; i < dontAddMeTwice.length; i++){
			AnnotationAJ ann = dontAddMeTwice[i];
			if (ann != null && decaF.getAnnotationX().getTypeName().equals(ann.getTypeName())){
				//dontAddMeTwice[i] = null; // incase it really has been added twice!
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Weave any declare @field statements into the fields of the supplied class
	 * 
	 * Interesting case relating to public ITDd fields.  The annotations are really stored against
     * the interfieldinit method in the aspect, but the public field is placed in the target
     * type and then is processed in the 2nd pass over fields that occurs.  I think it would be
     * more expensive to avoid putting the annotation on that inserted public field than just to
     * have it put there as well as on the interfieldinit method.
	 */
	private boolean weaveDeclareAtField(LazyClassGen clazz) {
	  
        // BUGWARNING not getting enough warnings out on declare @field ?
        // There is a potential problem here with warnings not coming out - this
        // will occur if they are created on the second iteration round this loop.
        // We currently deactivate error reporting for the second time round.
        // A possible solution is to record what annotations were added by what
        // decafs and check that to see if an error needs to be reported - this
        // would be expensive so lets skip it for now

		List reportedProblems = new ArrayList();

		List allDecafs = world.getDeclareAnnotationOnFields();
		if (allDecafs.isEmpty())
			return false; // nothing to do

		boolean isChanged = false;
		List itdFields = getITDSubset(clazz,ResolvedTypeMunger.Field);
		if (itdFields!=null) {
			isChanged = weaveAtFieldRepeatedly(allDecafs,itdFields,reportedProblems);
		}

		List decaFs = getMatchingSubset(allDecafs, clazz.getType());
		if (decaFs.isEmpty())
			return false; // nothing more to do
		List fields = clazz.getFieldGens();
		if (fields != null) {
			Set unusedDecafs = new HashSet();
			unusedDecafs.addAll(decaFs);
			for (int fieldCounter = 0; fieldCounter < fields.size(); fieldCounter++) {
				BcelField aBcelField = (BcelField) fields.get(fieldCounter);// new
				// BcelField(clazz.getBcelObjectType(),fields[fieldCounter
				// ]);
				if (!aBcelField.getName().startsWith(NameMangler.PREFIX)) {
					// Single first pass
					List worthRetrying = new ArrayList();
					boolean modificationOccured = false;

					AnnotationAJ[] dontAddMeTwice = aBcelField.getAnnotations();

					// go through all the declare @field statements
					for (Iterator iter = decaFs.iterator(); iter.hasNext();) {
						DeclareAnnotation decaF = (DeclareAnnotation) iter.next();
						if (decaF.getAnnotationX() == null) {
							return false;
						}
						if (decaF.matches(aBcelField, world)) {

							if (!dontAddTwice(decaF, dontAddMeTwice)) {
								if (doesAlreadyHaveAnnotation(aBcelField, decaF, reportedProblems)) {
									// remove the declare @field since don't
									// want an error when
									// the annotation is already there
									unusedDecafs.remove(decaF);
									continue;
								}

								if (decaF.getAnnotationX().isRuntimeVisible()) { // isAnnotationWithRuntimeRetention
									// (
									// clazz
									// .
									// getJavaClass(world))){
									// if(decaF.getAnnotationTypeX().
									// isAnnotationWithRuntimeRetention(world)){
									// it should be runtime visible, so put it
									// on the Field
									// Annotation a =
									// decaF.getAnnotationX().getBcelAnnotation
									// ();
									// AnnotationGen ag = new
									// AnnotationGen(a,clazz
									// .getConstantPoolGen(),true);
									// FieldGen myGen = new
									// FieldGen(fields[fieldCounter
									// ],clazz.getConstantPoolGen());
									// myGen.addAnnotation(ag);
									// Field newField = myGen.getField();

									aBcelField.addAnnotation(decaF.getAnnotationX());
									// clazz.replaceField(fields[fieldCounter],
									// newField);
									// fields[fieldCounter]=newField;

								} else {
									aBcelField.addAnnotation(decaF.getAnnotationX());
								}
							}

							AsmRelationshipProvider.addDeclareAnnotationFieldRelationship(world.getModelAsAsmManager(), decaF
									.getSourceLocation(), clazz.getName(), aBcelField);
							reportFieldAnnotationWeavingMessage(clazz, fields, fieldCounter, decaF);
							isChanged = true;
							modificationOccured = true;
							// remove the declare @field since have matched
							// against it
							unusedDecafs.remove(decaF);
						} else {
							if (!decaF.isStarredAnnotationPattern())
								worthRetrying.add(decaF); // an annotation is
							// specified that
							// might be put on
							// by a subsequent
							// decaf
						}
					}

					// Multiple secondary passes
					while (!worthRetrying.isEmpty() && modificationOccured) {
						modificationOccured = false;
						// lets have another go
						List forRemoval = new ArrayList();
						for (Iterator iter = worthRetrying.iterator(); iter.hasNext();) {
							DeclareAnnotation decaF = (DeclareAnnotation) iter.next();
							if (decaF.matches(aBcelField, world)) {
								// below code is for recursive things
								if (doesAlreadyHaveAnnotation(aBcelField, decaF, reportedProblems)) {
									// remove the declare @field since don't
									// want an error when
									// the annotation is already there
									unusedDecafs.remove(decaF);
									continue; // skip this one...
								}
								aBcelField.addAnnotation(decaF.getAnnotationX());
								AsmRelationshipProvider.addDeclareAnnotationFieldRelationship(world.getModelAsAsmManager(), decaF
										.getSourceLocation(), clazz.getName(), aBcelField);
								isChanged = true;
								modificationOccured = true;
								forRemoval.add(decaF);
								// remove the declare @field since have matched
								// against it
								unusedDecafs.remove(decaF);
							}
						}
						worthRetrying.removeAll(forRemoval);
					}
				}
			}
			checkUnusedDeclareAtTypes(unusedDecafs, true);
		}
		return isChanged;
	}

	// bug 99191 - put out an error message if the type doesn't exist
	/**
	 * Report an error if the reason a "declare @method/ctor/field" was not used was because the member
	 * specified does not exist.  This method is passed some set of declare statements that didn't
	 * match and a flag indicating whether the set contains declare @field or declare @method/ctor
	 * entries.
	 */
	private void checkUnusedDeclareAtTypes(Set unusedDecaTs, boolean isDeclareAtField) {
		for (Iterator iter = unusedDecaTs.iterator(); iter.hasNext();) {
	  		DeclareAnnotation declA = (DeclareAnnotation) iter.next();
	  		
	  		// Error if an exact type pattern was specified 
	  		if ((declA.isExactPattern() || 
					(declA.getSignaturePattern().getDeclaringType() instanceof ExactTypePattern))
					&& (!declA.getSignaturePattern().getName().isAny()
							|| (declA.getKind() == DeclareAnnotation.AT_CONSTRUCTOR))) {
	  			
	  			// Quickly check if an ITD meets supplies the 'missing' member
	  			boolean itdMatch = false;
	  			List lst = clazz.getType().getInterTypeMungers();
	  			for (Iterator iterator = lst.iterator(); iterator.hasNext() && !itdMatch;) {
					BcelTypeMunger element = (BcelTypeMunger) iterator.next();
					if (element.getMunger() instanceof NewFieldTypeMunger) { 
						NewFieldTypeMunger nftm = (NewFieldTypeMunger)element.getMunger();
						itdMatch = declA.getSignaturePattern().matches(nftm.getSignature(),world,false);
	  				}else if (element.getMunger() instanceof NewMethodTypeMunger) {
						NewMethodTypeMunger nmtm = (NewMethodTypeMunger)element.getMunger();
						itdMatch = declA.getSignaturePattern().matches(nmtm.getSignature(),world,false);							
					} else if (element.getMunger() instanceof NewConstructorTypeMunger) {
						NewConstructorTypeMunger nctm = (NewConstructorTypeMunger)element.getMunger();
						itdMatch = declA.getSignaturePattern().matches(nctm.getSignature(),world,false);							
					}
				}
	  			if (!itdMatch) {
	  				IMessage message = null;
	  				if (isDeclareAtField) {
	  					message = new Message(
								"The field '"+ declA.getSignaturePattern().toString() + 
								"' does not exist", declA.getSourceLocation() , true);
					} else { 
						message = new Message(
								"The method '"+ declA.getSignaturePattern().toString() + 
								"' does not exist", declA.getSourceLocation() , true);
					}
					world.getMessageHandler().handleMessage(message);					
				}
	  		}
	  	}
	}
	
	// TAG: WeavingMessage
	private void reportFieldAnnotationWeavingMessage(LazyClassGen clazz, List fields, int fieldCounter, DeclareAnnotation decaF) {
		if (!getWorld().getMessageHandler().isIgnoring(IMessage.WEAVEINFO)) {
			BcelField theField = (BcelField) fields.get(fieldCounter);
			world.getMessageHandler().handleMessage(
					WeaveMessage.constructWeavingMessage(WeaveMessage.WEAVEMESSAGE_ANNOTATES, new String[] {
							theField.getFieldAsIs().toString() + "' of type '" + clazz.getName(), clazz.getFileName(),
							decaF.getAnnotationString(), "field", decaF.getAspect().toString(),
							Utility.beautifyLocation(decaF.getSourceLocation()) }));
		}
	}

	/**
	 * Check if a resolved member (field/method/ctor) already has an annotation, if it does then put out a warning and return true
	 */
	private boolean doesAlreadyHaveAnnotation(ResolvedMember rm, DeclareAnnotation deca, List reportedProblems) {
		if (rm.hasAnnotation(deca.getAnnotationTypeX())) {
			if (world.getLint().elementAlreadyAnnotated.isEnabled()) {
				Integer uniqueID = new Integer(rm.hashCode() * deca.hashCode());
				if (!reportedProblems.contains(uniqueID)) {
					reportedProblems.add(uniqueID);
					world.getLint().elementAlreadyAnnotated.signal(new String[] { rm.toString(),
							deca.getAnnotationTypeX().toString() }, rm.getSourceLocation(), new ISourceLocation[] { deca
							.getSourceLocation() });
				}
			}
			return true;
		}
		return false;
	}

	private boolean doesAlreadyHaveAnnotation(LazyMethodGen rm, ResolvedMember itdfieldsig, DeclareAnnotation deca,
			List reportedProblems) {
		if (rm != null && rm.hasAnnotation(deca.getAnnotationTypeX())) {
			if (world.getLint().elementAlreadyAnnotated.isEnabled()) {
				Integer uniqueID = new Integer(rm.hashCode() * deca.hashCode());
				if (!reportedProblems.contains(uniqueID)) {
					reportedProblems.add(uniqueID);
					reportedProblems.add(new Integer(itdfieldsig.hashCode() * deca.hashCode()));
					world.getLint().elementAlreadyAnnotated.signal(new String[] { itdfieldsig.toString(),
							deca.getAnnotationTypeX().toString() }, rm.getSourceLocation(), new ISourceLocation[] { deca
							.getSourceLocation() });
				}
			}
			return true;
		}
		return false;
	}
		
	

	private void weaveInAddedMethods() {
		Collections.sort(addedLazyMethodGens, 
			new Comparator() {
				public int compare(Object a, Object b) {
					LazyMethodGen aa = (LazyMethodGen) a;
					LazyMethodGen bb = (LazyMethodGen) b;
					int i = aa.getName().compareTo(bb.getName());
					if (i != 0) return i;
					return aa.getSignature().compareTo(bb.getSignature());
				}
			}
		);
		
		for (Iterator i = addedLazyMethodGens.iterator(); i.hasNext(); ) {
			clazz.addMethodGen((LazyMethodGen)i.next());
		}
	}

    void addPerSingletonField(Member field) {
    	ObjectType aspectType = (ObjectType) BcelWorld.makeBcelType(field.getReturnType());
    	String aspectName = field.getReturnType().getName();

		LazyMethodGen clinit = clazz.getStaticInitializer();
		InstructionList setup = new InstructionList();
		InstructionFactory fact = clazz.getFactory();

		setup.append(fact.createNew(aspectType));
		setup.append(InstructionFactory.createDup(1));
		setup.append(fact.createInvoke(
			aspectName, 
			"<init>", 
			Type.VOID, 
			new Type[0], 
			Constants.INVOKESPECIAL));
		setup.append(
			fact.createFieldAccess(
				aspectName,
				field.getName(),
				aspectType,
				Constants.PUTSTATIC));
		clinit.getBody().insert(setup);
    }



	
	/**
     * For some named resolved type, this method looks for a member with a particular name -
     * it should only be used when you truly believe there is only one member with that 
     * name in the type as it returns the first one it finds.
     */
	private ResolvedMember findResolvedMemberNamed(ResolvedType type,String methodName) {
		ResolvedMember[] allMethods = type.getDeclaredMethods();
		for (int i = 0; i < allMethods.length; i++) {
			ResolvedMember member = allMethods[i];
			if (member.getName().equals(methodName)) return member;
		}
		return null;
	}
	
	/**
	 * For a given resolvedmember, this will discover the real annotations for it.
	 * <b>Should only be used when the resolvedmember is the contents of an effective signature
	 * attribute, as thats the only time when the annotations aren't stored directly in the
	 * resolvedMember</b>
	 * @param rm the sig we want it to pretend to be 'int A.m()' or somesuch ITD like thing
	 * @param declaredSig the real sig 'blah.ajc$xxx'
	 */
	private void fixAnnotationsForResolvedMember(ResolvedMember rm,ResolvedMember declaredSig) {
	  try {
		UnresolvedType memberHostType = declaredSig.getDeclaringType();
		ResolvedType[] annotations = (ResolvedType[])mapToAnnotations.get(rm);
		String methodName = declaredSig.getName();
		// FIXME asc shouldnt really rely on string names !
		if (annotations == null) {
			if (rm.getKind()==Member.FIELD) {
				if (methodName.startsWith("ajc$inlineAccessField")) {
					ResolvedMember resolvedDooberry = world.resolve(rm);
					annotations = resolvedDooberry.getAnnotationTypes();
				} else {
					ResolvedMember realthing = AjcMemberMaker.interFieldInitializer(rm,memberHostType);
					ResolvedMember resolvedDooberry = world.resolve(realthing);
					annotations = resolvedDooberry.getAnnotationTypes();
				}
			} else if (rm.getKind()==Member.METHOD && !rm.isAbstract()) {
				if (methodName.startsWith("ajc$inlineAccessMethod") || methodName.startsWith("ajc$superDispatch")) {
					ResolvedMember resolvedDooberry = world.resolve(declaredSig);
					annotations = resolvedDooberry.getAnnotationTypes();
				} else {
					ResolvedMember realthing = AjcMemberMaker.interMethodDispatcher(rm.resolve(world),memberHostType).resolve(world);
					// ResolvedMember resolvedDooberry = world.resolve(realthing);
					ResolvedMember theRealMember = findResolvedMemberNamed(memberHostType.resolve(world),realthing.getName());
					// AMC temp guard for M4
					if (theRealMember == null) {
						throw new UnsupportedOperationException("Known limitation in M4 - can't find ITD members when type variable is used as an argument and has upper bound specified");
					}
					annotations = theRealMember.getAnnotationTypes();
				}
			} else if (rm.getKind()==Member.CONSTRUCTOR) {
				ResolvedMember realThing = AjcMemberMaker.postIntroducedConstructor(memberHostType.resolve(world),rm.getDeclaringType(),rm.getParameterTypes());
				ResolvedMember resolvedDooberry = world.resolve(realThing);
				// AMC temp guard for M4
				if (resolvedDooberry == null) {
					throw new UnsupportedOperationException("Known limitation in M4 - can't find ITD members when type variable is used as an argument and has upper bound specified");
				}
				annotations = resolvedDooberry.getAnnotationTypes();
			}
			if (annotations == null) 
		      annotations = new ResolvedType[0];
			mapToAnnotations.put(rm,annotations);
		}
		rm.setAnnotationTypes(annotations);
		} 
	  	catch (UnsupportedOperationException ex) {
	  	  throw ex;	
	  	} catch (Throwable t) {
		  //FIXME asc remove this catch after more testing has confirmed the above stuff is OK
		  throw new BCException("Unexpectedly went bang when searching for annotations on "+rm,t);
		}
	}
	
	// static ... so all worlds will share the config for the first one created...
	private static boolean checkedXsetForLowLevelContextCapturing = false;
	//TODO: was private, now protected... should be moved into BM or MM
	public static boolean captureLowLevelContext = false;

    // ----
    
    /** SK: this guy simply runs <code>shadow.implement()</code> on all 
     * shadows (that are to be transformed) within the <code>mg</code> method.
     * The <code>shadow.implement()</code> sorts advice pieces associated with the 
     * shadow, prepares each shadow for weaving (plays with its instructions), 
     * and finally weaves all advice pieces.
     * (This method should belong to a multi-mechanism weaver)
     */

    private void implement_old(LazyMethodGen mg) {
    	//List shadows = mg.matchedShadows;
    	//if (shadows == null) return;
        // We depend on a partial order such that inner shadows are earlier on the list
        // than outer shadows.  That's fine.  This order is preserved if:   
        // A preceeds B iff B.getStart() is LATER THAN A.getStart().        
       // for (Iterator i = shadows.iterator(); i.hasNext(); ) {
       //     BcelShadow shadow = (BcelShadow)i.next();
       //     ContextToken tok = CompilationAndWeavingContext.enteringPhase(CompilationAndWeavingContext.IMPLEMENTING_ON_SHADOW,shadow);
       //     shadow.implement();
       //     CompilationAndWeavingContext.leavingPhase(tok);
       // }
	//	int ii = mg.getMaxLocals();
	//	mg.matchedShadows = null;
    }
    
    // ----
    
	public LazyClassGen getLazyClassGen() {
		return clazz;
	}

	/** SK: should be advice pieces that can potentially affect this class. */
//	public List getShadowMungers() {
//		return shadowMungers;
//	}

	public BcelWorld getWorld() {
		return world;
	}
	
	// Called by the BcelWeaver to let us know all BcelClassWeavers need to collect reweavable info
	public static void setReweavableMode(boolean mode) {
		inReweavableMode = mode;
	}
	
	public static boolean getReweavableMode() { 
		return inReweavableMode;
	}
	
	public String toString() {
		return "BcelClassWeaver instance for : "+clazz;
	}

	/**
	 * first sorts the mungers, then gens the initializers in the right order
	 */
	private InstructionList genInitInstructions(List list, boolean isStatic) {
		list = PartialOrder.sort(list);
        if (list == null) {
        	throw new BCException("circularity in inter-types");
        }
		
		InstructionList ret = new InstructionList();
		
		for (Iterator i = list.iterator(); i.hasNext();) {
			ConcreteTypeMunger cmunger = (ConcreteTypeMunger) i.next();
			NewFieldTypeMunger munger = (NewFieldTypeMunger) cmunger.getMunger();
			ResolvedMember initMethod = munger.getInitMethod(cmunger.getAspectType());
			if (!isStatic) ret.append(InstructionConstants.ALOAD_0);
			ret.append(Utility.createInvoke(fact, world, initMethod));
		}
		return ret;
	}
}