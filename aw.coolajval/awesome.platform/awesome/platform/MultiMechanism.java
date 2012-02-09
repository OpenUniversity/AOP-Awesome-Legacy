package awesome.platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.aspectj.apache.bcel.Constants;
import org.aspectj.apache.bcel.classfile.Attribute;
import org.aspectj.apache.bcel.classfile.Code;
import org.aspectj.apache.bcel.classfile.ConstantPool;
import org.aspectj.apache.bcel.classfile.Method;
import org.aspectj.apache.bcel.generic.FieldInstruction;
import org.aspectj.apache.bcel.generic.Instruction;
import org.aspectj.apache.bcel.generic.InstructionHandle;
import org.aspectj.apache.bcel.generic.InstructionList;
import org.aspectj.apache.bcel.generic.InstructionTargeter;
import org.aspectj.apache.bcel.generic.InvokeInstruction;
import org.aspectj.apache.bcel.generic.MULTIANEWARRAY;
import org.aspectj.bridge.context.CompilationAndWeavingContext;
import org.aspectj.bridge.context.ContextToken;
import org.aspectj.weaver.AjAttribute;
import org.aspectj.weaver.IClassFileProvider;
import org.aspectj.weaver.Member;
import org.aspectj.weaver.NameMangler;
import org.aspectj.weaver.ResolvedMember;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.BcelWorld;
import org.aspectj.weaver.bcel.ExceptionRange;
import org.aspectj.weaver.bcel.LazyClassGen;
import org.aspectj.weaver.bcel.LazyMethodGen;
import org.aspectj.weaver.bcel.Utility;

import ajplugin.AJWeaver;
import awesome.config.spec.FeatureInteractions;
import awesome.platform.adb.tagkit.JoinPointGranularityAttribute;
import awesome.platform.adb.tagkit.CrossCuttingAttribute;
import awesome.platform.adb.tagkit.EffectApplication;
import awesome.platform.adb.tagkit.JoinPointDescriptor;
import awesome.platform.adb.tagkit.ShadowAttribute;
public class MultiMechanism 
{
	
	private BcelWorld world;
	private List<IMechanism> mechanisms;
	private List<String> names = null;

	private Map<LazyMethodGen, List<BcelShadow>> methodShadows = new HashMap<LazyMethodGen, List<BcelShadow>>();

	public MultiMechanism(BcelWorld world) {
		System.out.println("MultiMechanism: "+this);
		this.world = world;
		this.mechanisms = new ArrayList<IMechanism>();
	}
	
	public List<String> getNames()
	{
		if(null == names)
		{
			names = new LinkedList<String>();
			for(IMechanism m : mechanisms)
			{
				names.add(m.getName());
			}
		}
		
		return names;
	}
	

	public void setInputFiles(IClassFileProvider input) {
		for (IMechanism mech:mechanisms) 
			mech.setInputFiles(input);
	}
	
	public void addMechanism(IMechanism mechanism) {
		mechanisms.add(mechanism);
	}
	
	public List<BcelShadow> reify(LazyClassGen clazz) {
		List<LazyMethodGen> methods = new ArrayList(clazz.getMethodGens());
		List<BcelShadow> result = new ArrayList<BcelShadow>();
		for (LazyMethodGen mg : methods) {
			// continue if method has @AwSuppressReify annotation:
			if(AwesomeCore.hasAnnotation(mg, "awesome.platform.annotations.AwSuppressReify"))
				continue;
			
			List<BcelShadow> methShadows = null;
			methShadows = reify(mg);
			if (methShadows != null) {
				methodShadows.put(mg, methShadows);
				result.addAll(methShadows);
			}
		}
		return result;
	}

	public List<BcelShadow> reify(LazyMethodGen mg) {
		if (!mg.hasBody()) return null;
		BcelShadow enclosingShadow;
		if (mg.getName().equals("<init>")) {
			InstructionHandle superOrThisCall = findSuperOrThisCall(mg);
			// we don't walk bodies of things where it's a wrong constructor
			// thingie
			if (superOrThisCall == null) return null;
			enclosingShadow = BcelShadow.makeConstructorExecution(world, mg, superOrThisCall);
			// TODO:I'm not sure what this statement does. Should it be here?
			if (mg.getEffectiveSignature() != null)
				enclosingShadow.setMatchingSignature(mg.getEffectiveSignature()
						.getEffectiveSignature());
		} else if (mg.getName().equals("<clinit>")) {
			enclosingShadow = BcelShadow.makeStaticInitialization(world, mg);
			// System.err.println(enclosingShadow);
		} else {
			enclosingShadow = BcelShadow.makeMethodExecution(world, mg, false);
		}
		List<BcelShadow> result = reify(mg.getBody(), mg, enclosingShadow);
		enclosingShadow.init();
		result.add(enclosingShadow);
		return result;
	}

	public List<BcelShadow> reify(InstructionList il, LazyMethodGen mg, BcelShadow enclosing) {
		List<BcelShadow> result = new ArrayList<BcelShadow>();
		// ===== Special treatment of init methods
		boolean inEnclosing = true;
		InstructionHandle superOrThisCall = null;
		Shadow.Kind encKind = (enclosing!=null) ? enclosing.getKind() : null;
		if (encKind!=null && encKind == Shadow.ConstructorExecution) {
			inEnclosing = false;
			superOrThisCall = findSuperOrThisCall(mg);
			// enclosing.getRange().getStart().getPrev();
		}
		
        InstructionHandle last = il.getEnd();
        if (last!=null) last = last.getNext();
		for (InstructionHandle h = il.getStart(); h != last; h = h.getNext()) {
			List<BcelShadow> instrShadows = null;
			// Only for init methods
			if (!inEnclosing && encKind!=null && encKind == Shadow.ConstructorExecution
					&& h == superOrThisCall) {
				inEnclosing = true;
				continue; // We are skipping the super/this call instruction.
			}
  		   instrShadows = reify(h, mg, inEnclosing ? enclosing : null);
		   if (instrShadows != null) result.addAll(instrShadows);
		}
		return result;
	}

	/**
	 * SK: The method is designed to identify instruction-level shadows, rather
	 * than method-level shadows.
	 * 
	 * According to the type of instruction, this method invokes specialized
	 * match method (e.g., matchInvokeInstruction). The specialized method
	 * constructs a shadow (by invoking a static make method on the BcelShadow
	 * class that corresponds to the instruction's type), and adds the shadow to
	 * the shadowAccumulator list.
	 * 
	 * The original method was using a bunch of canMatch calls, that I replaced
	 * with truth values. Uses assumptions:
	 * assert(mg.getEnclosingClass()==BcelClassWeaver.clazz);
	 * assert(mg.getEnclosingClass().getConstantPoolGen()==BcelClassWeaver.cpg);
	 * 
	 * @param mg
	 * @param ih
	 * @param enclosingShadow
	 * @param shadowAccumulator
	 */
	public List<BcelShadow> reify(InstructionHandle ih, LazyMethodGen mg,
			BcelShadow enclosingShadow) {
		List<BcelShadow> result = new ArrayList<BcelShadow>();
		// assumption:
		LazyClassGen clazz = mg.getEnclosingClass();
		ConstantPool cpg = clazz.getConstantPool();

		Instruction i = ih.getInstruction();
		if ((i instanceof FieldInstruction)) {
			FieldInstruction fi = (FieldInstruction) i;
			
			Member field = BcelWorld.makeFieldJoinPointSignature(clazz, fi);
			ResolvedMember resolvedField = field.resolve(world);
			
			if (resolvedField == null) {
				// we can't find the field, so it's not a join point.
				return null;
			}				
			if (fi.opcode == Constants.PUTFIELD || fi.opcode == Constants.PUTSTATIC) {
				result.add(BcelShadow.makeFieldSet(world, resolvedField, mg, ih,
						enclosingShadow));
			} else {
				BcelShadow bs = BcelShadow.makeFieldGet(world, mg, ih,
						enclosingShadow);
				
				//bs.setOriginalPositions();
				
				String cname = fi.getClassName(cpg);
				// TODO: was different. Check if semantics is preserved.
				// !resolvedField.getDeclaringType().getName().equals(cname))
				if (bs.getSignature().getDeclaringType().getName()
						.equals(cname))
					bs.setActualTargetType(cname);
				result.add(bs);
			}
		} else if (i instanceof InvokeInstruction) {
			InvokeInstruction ii = (InvokeInstruction) i;
			if (ii.getMethodName(clazz.getConstantPool()).equals("<init>")) {
				result.add(BcelShadow.makeConstructorCall(world, mg, ih,
						enclosingShadow));
			} else
				result.add(BcelShadow.makeMethodCall(world, mg, ih,
						enclosingShadow));
		} else
		// TODO: I need to make it shared amongst all the mechanisms,
		// BUT I don't know how it will affect the AJC
		// world.isJoinpointArrayConstructionEnabled() &&
		// if ((i instanceof NEWARRAY || i instanceof ANEWARRAY || i instanceof
		// MULTIANEWARRAY)) {
		if (i.opcode == Constants.ANEWARRAY && world.isJoinpointArrayConstructionEnabled()) {
			//System.out.println("CREATING AN ARRAY CONSTRUCTOR CALL!, isJPARRCONSTRENABLED?="+world.isJoinpointArrayConstructionEnabled());
			result.add(BcelShadow.makeArrayConstructorCall(world, mg, ih,
					enclosingShadow));
		} else if (i.opcode == Constants.NEWARRAY && world.isJoinpointArrayConstructionEnabled()) {
			result.add(BcelShadow.makeArrayConstructorCall(world, mg, ih,
					enclosingShadow));
		} else if (i instanceof MULTIANEWARRAY && world.isJoinpointArrayConstructionEnabled()) {
			result.add(BcelShadow.makeArrayConstructorCall(world, mg, ih,
					enclosingShadow));
		}
		// }
		// performance optimization... we only actually care about ASTORE
		// instructions,
		// since that's what every javac type thing ever uses to start a
		// handler, but for
		// now we'll do this for everybody.
		// TODO: This piece is still AJ-contaminated.
		// Clean it later.
		InstructionTargeter[] targeters = ih.getTargetersArray();
		if (targeters != null) {
			for (int j = 0; j < targeters.length; j++) {
				InstructionTargeter t = targeters[j];
				if (t instanceof ExceptionRange) {
					// assert t.getHandler() == ih
					ExceptionRange er = (ExceptionRange) t;
					if (er.getCatchType() == null)
						continue;
					if (isInitFailureHandler(ih, mg))
						return result;
					result.add(BcelShadow.makeExceptionHandler(world, er, mg,
							ih, enclosingShadow));
				}
			}
		}
		return result;
	}
		
	Map<LazyMethodGen, ShadowAttribute> bodyToShadowAtt = 
		new HashMap<LazyMethodGen, awesome.platform.adb.tagkit.ShadowAttribute>();
	
	protected void generateShadowTags(LazyClassGen clazz, CrossCuttingAttribute cct,
			Code codeAttribute)
	{
		bodyToShadowAtt.clear();
		
		for(JoinPointDescriptor jpd : cct.getJoinpoints())
		{
			LazyMethodGen target = jpd.shadowMethod;
			ShadowAttribute tag = bodyToShadowAtt.get(target);
			
			if (tag == null) 
			{
				tag = new ShadowAttribute();
																
				bodyToShadowAtt.put(target, tag);			
			}
			
			tag.add(jpd);
			
		}
		
		for(LazyMethodGen target : bodyToShadowAtt.keySet())
		{
			ShadowAttribute tag = bodyToShadowAtt.get(target);
			
			Attribute shadowAttribute = Utility.bcelAttribute(tag, 
					clazz.getConstantPool());
			
			Attribute[] attrs = codeAttribute.getAttributes();
			Attribute[] extAttrs = new Attribute[attrs.length+1];
			
			System.arraycopy(attrs, 0, extAttrs, 0, attrs.length);
			extAttrs[attrs.length] = shadowAttribute;
								
			codeAttribute.setAttributes(extAttrs);			
		}
	
	}
	
	/*
	protected void printAttributes(LazyClassGen clazz)
	{
	
		
		List <LazyMethodGen> methods = clazz.getMethodGens();
		
		for(LazyMethodGen m : methods)
		{
			List attributes = m.getAttributes();
			
			if(null == attributes)
			{
				return;
			}
			
			System.out.println("method  " + m.getName());
			
			Attribute[] ats = m.getMethod().getCode().getAttributes();
			for(Attribute a : ats)
			{
				System.out.println("a  " + a.getName());
			}
		}		
	}
	*/
	
	private void genereteAllJPsTag(LazyClassGen clazz)
	{
		awesome.platform.adb.util.log.logger.logLn("generating AllJPsTag for " + 
				clazz.getName());
		
		List<LazyMethodGen> methods = clazz.getMethodGens();
		
		for(LazyMethodGen m : methods)
		{
			if(m.isAbstract() )
				continue;
			
			List<BcelShadow> shadowList = allShadows.get(m.getName());
			if(null == shadowList)
				continue;
			
			JoinPointGranularityAttribute ajpa = new JoinPointGranularityAttribute(this, shadowList);
			
			Attribute ccAttribute;
			ccAttribute = Utility.bcelAttribute(ajpa, 
							clazz.getConstantPool());
					
			
			Attribute[] ats = m.getMethod().getAttributes();
			for(Attribute a : ats)
			{
				if(a instanceof Code)
				{
					Code c = (Code) a;
					Attribute[] attrs = c.getAttributes();
					Attribute[] extAttrs = new Attribute[attrs.length+1];
					System.arraycopy(attrs, 0, extAttrs, 0, attrs.length);
					extAttrs[attrs.length] = ccAttribute;	
					c.setAttributes(extAttrs);
				}				
			}
		}
		
	}
	
	/*
	private void addAttribute(AjAttribute attribute, LazyClassGen clazz, LazyMethodGen m)
	{
		Attribute ccAttribute;
		ccAttribute = Utility.bcelAttribute(attribute, 
						clazz.getConstantPool());
						
		Attribute[] ats = m.getMethod().getAttributes();
		for(Attribute a : ats)
		{
			if(a instanceof Code)
			{
				Code c = (Code) a;
				Attribute[] attrs = c.getAttributes();
				Attribute[] extAttrs = new Attribute[attrs.length+1];
				System.arraycopy(attrs, 0, extAttrs, 0, attrs.length);
				extAttrs[attrs.length] = ccAttribute;	
				c.setAttributes(extAttrs);				
			}				
		}
	}*/
	
	protected void generateCrossCuttingTag(LazyClassGen clazz)
	{
		if(clazz.isInterface())
			return;
		
		List<LazyMethodGen> methods = clazz.getMethodGens();
		
		awesome.platform.adb.util.log.logger.logLn("generating cross cutting tag for " + 
				clazz.getName());
		
		for(LazyMethodGen m : methods)
		{
			if(m.isAbstract())
				continue;
		
			awesome.platform.adb.util.log.logger.logLn("generating cross cutting tag for " + 
					m.getName());
			
			List<EffectApplication> effectList = methodNameToEffect.get(m.getName());
	    	if(null == effectList || effectList.size() == 0)
	    	{
	    		continue;
	    	}
	    							
	    	CrossCuttingAttribute xctAttr = new CrossCuttingAttribute(effectList);
			Attribute ccAttribute;
			ccAttribute = Utility.bcelAttribute(xctAttr, 
							clazz.getConstantPool());
					
			
			Attribute[] ats = m.getMethod().getAttributes();
			for(Attribute a : ats)
			{
				if(a instanceof Code)
				{
					Code c = (Code) a;
					Attribute[] attrs = c.getAttributes();
					Attribute[] extAttrs = new Attribute[attrs.length+1];
					System.arraycopy(attrs, 0, extAttrs, 0, attrs.length);
					extAttrs[attrs.length] = ccAttribute;	
					c.setAttributes(extAttrs);
					generateShadowTags(clazz, xctAttr, c);
				}				
			}
			
			//Attribute[] as = m.getMethod().getCode().getAttributes();
							
			//changedMethods.add(m);
			
			//MethodGen mGen = m.pack();			
			//mGen.addCodeAttribute(ccAttribute);																
		}
	/*	
		for(LazyMethodGen m : changedMethods)
		{
			clazz.removeMethodGen(m);
			clazz.addMethodGen(m);
		}
		*/				
		//clazz.getJavaClass(world);
		//printAttributes(clazz);
	}
	
	private IMechanism getHandlingMechanism(LazyClassGen clazz)
	{
		IMechanism m =  null;
		for(IMechanism m2 : mechanisms)
		{
			if(m2.getClass() == AJWeaver.class)
				continue;
			
			if(m2.handledByMe(clazz))
			{				
				m = m2;
				break;
			}
		}
		
		if(m == null)
			m = getMechanism(AJWeaver.class);
			
		return m;		
	}
	
	protected void generateAspectTag(LazyClassGen clazz) 
	{		
		
		if(clazz.getType().isAspect())
		{
			IMechanism m = getHandlingMechanism(clazz);
			
			//if(m.getClass() == COOLWeaver.class)
			//	return; /// TEMP
				
			Attribute aspectAttribute;
			aspectAttribute = Utility.bcelAttribute(new awesome.platform.adb.tagkit.AspectAttribute(world, m, clazz), 
					clazz.getConstantPool());
							
			clazz.addAttribute(aspectAttribute);
		}		
	}
	
	protected void generateFieldNumberTag(LazyClassGen clazz) 
	{		
			if(clazz.isAbstract())
				return;
			
			Attribute fieldLineNoAttribute;
			fieldLineNoAttribute = Utility.bcelAttribute(new awesome.platform.adb.tagkit.FieldLineNumberAttribute(world, clazz), 
					clazz.getConstantPool());
							
			clazz.addAttribute(fieldLineNoAttribute);
	}

	private Map<String, List<EffectApplication>> methodNameToEffect;
	
	private Map<String, List<BcelShadow>> allShadows;
	
	
	
	
	
	public boolean transform(LazyClassGen clazz) 
	{
		awesome.platform.adb.util.log.logger.logLn("transforming class: " + clazz);
		
		boolean isChanged = false;
		
		generateAspectTag(clazz);		

		 // need to prepare a list of effects for each method
		methodNameToEffect = new HashMap<String, List<EffectApplication>>();	
		allShadows = new HashMap<String, List<BcelShadow>>();
		
        List<BcelShadow> shadows = reify(clazz);
        for (BcelShadow shadow:shadows)
        {        	              
        	awesome.platform.adb.util.log.logger.logLn("\ttransforming shadow: " + 
        			shadow.getEnclosingMethod().getName() + " line " + shadow.getSourceLine() + 
        			" kind " + shadow.getKind());
        	if (transform(shadow)) 
        		isChanged=true;     	
        }
               
        genereteAllJPsTag(clazz);
        
        // call after the transformation
        generateCrossCuttingTag(clazz);
        //printAttributes(clazz);
        generateFieldNumberTag(clazz);
		
		return isChanged;
	}

	public boolean transform(BcelShadow shadow) 
	{
		//System.out.println("Transforming a shadow:"+shadow+", "+shadow.getSourceLocation());
		
		boolean isChanged = false;
		ContextToken tok = CompilationAndWeavingContext.enteringPhase(
				CompilationAndWeavingContext.IMPLEMENTING_ON_SHADOW, shadow);
		
		if(FeatureInteractions.instance().isInEMJPG(shadow.getKind().getName()))
    	{
			List<BcelShadow> shadowList = allShadows.get(shadow.getEnclosingMethod().getName());
			if(null == shadowList)
			{
				shadowList = new ArrayList<BcelShadow>();
				allShadows.put(shadow.getEnclosingMethod().getName(), shadowList);
			}
			
			shadowList.add(shadow);
    	}
		
		List<List<IEffect>> multiEffects = match(shadow);
		List<IEffect> effects = multiOrder(multiEffects, shadow);
		
		List<EffectApplication> effectList = methodNameToEffect.get(shadow.getEnclosingMethod().getName());
    	if(null == effectList)
    	{
    		effectList = new ArrayList<EffectApplication>();
    		methodNameToEffect.put(shadow.getEnclosingMethod().getName(), effectList);
    	}
    	
    	
    	    	
    	for(IEffect e : effects)
    	{
    		// TEMP handle only BcelAdvice
    		//if(e instanceof BcelAdvice)    			
    		effectList.add(new EffectApplication(e, shadow));
    	}
		
 
		if (effects != null && effects.size() > 0) {
			isChanged = true;
			mix(effects, shadow);
		}
				
		CompilationAndWeavingContext.leavingPhase(tok);
		return isChanged;
	}

	public List<List<IEffect>> match(BcelShadow shadow) {
		List<List<IEffect>> result = new ArrayList<List<IEffect>>(mechanisms.size());
		for (IMechanism mechanism : mechanisms) {
			List<IEffect> effects = 
				mechanism.order(shadow, mechanism.match(shadow));
			result.add(effects);
		}
		return result;
	}
	
    public List<IEffect> multiOrder(List<List<IEffect>> effects, BcelShadow shadow) {
		List<IEffect> result = new ArrayList<IEffect>();
		for (List<IEffect> eff : effects) 
		  if (eff!=null) result.addAll(eff);
		return result;
    }


	public void mix(List<IEffect> effects, BcelShadow shadow) {
		shadow.prepareForMungers(effects);
		for (IEffect effect : effects)
			effect.transform(shadow);		
	}
	
	public List<BcelShadow> getMethodShadows(LazyMethodGen mg) {
		return methodShadows.get(mg);
	}
	
	/** Mechanisms might use it to add their own associations */
	public void addMethodShadow(LazyMethodGen mg, BcelShadow shadow) {
		List<BcelShadow> shadows = methodShadows.get(mg);
		if (shadows ==null) {
			shadows = new ArrayList<BcelShadow>();
			methodShadows.put(mg, shadows);
		}
		if (!shadows.contains(shadow)) shadows.add(shadow);
	}
	
	/** Mechanisms might use it to remove associations */
	public void removeMethodShadow(LazyMethodGen mg, BcelShadow shadow) {
		List<BcelShadow> shadows = methodShadows.get(mg);
		if (shadows ==null) {
			shadows = new ArrayList<BcelShadow>();
			methodShadows.put(mg, shadows);
		}
		shadows.remove(shadow);
	}
	

	public BcelWorld getWorld() {
		return world;
	}
	
	
	public int getMechanismPos(Class clazz) {
		for (int i=0;i<mechanisms.size();i++)
			if(mechanisms.get(i).getClass()==clazz)
				return i;
		return -1;
	}

	public IMechanism getMechanism(Class clazz) {
		for(IMechanism mech:mechanisms)
			if (mech.getClass()==clazz)
				return mech;
		return null;
	}
	
	
	/**
	 * SK: this method is a filter of synthetic handlers, generated by the
	 * <code>AspectClinit.generatePostSyntheticCode()</code>
	 * 
	 * @param ih
	 * @return
	 */
	private boolean isInitFailureHandler(InstructionHandle ih, LazyMethodGen mg) {
		ConstantPool cpg = mg.getEnclosingClass().getConstantPool();
		// Skip the astore_0 and aload_0 at the start of the handler and
		// then check if the instruction following these is
		// 'putstatic ajc$initFailureCause'. If it is then we are
		// in the handler we created in AspectClinit.generatePostSyntheticCode()
		InstructionHandle twoInstructionsAway = ih.getNext().getNext();
		if (twoInstructionsAway.getInstruction().opcode == Constants.PUTSTATIC) {
			String name = ((FieldInstruction) twoInstructionsAway.getInstruction())
			.getFieldName(cpg);
			if (name.equals(NameMangler.INITFAILURECAUSE_FIELD_NAME))
				return true;
		}
		return false;
	}
	
	/**
	 * TODO: figure out where it should be.
	 * 
	 * @return <code>null</code> if <code>mg</code> does not represent a
	 *         Java constructor. (and then weaver ignores <code>mg</code>).
	 *         Otherwise returns the first super or this call instruction within
	 *         the constructor. The body of the constructor then starts AFTER
	 *         this instruction. Uses assumption
	 *         mg.getEnclosingClass().getConstantPoolGen() = BcelClassWeaver.cpg
	 */
	public static InstructionHandle findSuperOrThisCall(LazyMethodGen mg) {
		int depth = 1;
		InstructionHandle start = mg.getBody().getStart();
		ConstantPool cpg = mg.getEnclosingClass().getConstantPool();
		while (true) {
			if (start == null)
				return null;
			Instruction inst = start.getInstruction();
			if (inst.opcode == Constants.INVOKESPECIAL 
					&& ((InvokeInstruction) inst).getName(cpg).equals("<init>")) {
				depth--;
				if (depth == 0)
					return start;
			} else if (inst.opcode == Constants.NEW) {
				depth++;
			}
			start = start.getNext();
		}
	}

	
}