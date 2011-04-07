package awesome.comprendo;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.aspectj.apache.bcel.classfile.annotation.AnnotationGen;
import org.aspectj.apache.bcel.classfile.annotation.ElementNameValuePairGen;
import org.aspectj.apache.bcel.generic.InstructionFactory;
import org.aspectj.apache.bcel.generic.InstructionList;
import org.aspectj.apache.bcel.generic.ReferenceType;
import org.aspectj.weaver.IClassFileProvider;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.bcel.BcelMethod;
import org.aspectj.weaver.bcel.BcelObjectType;
import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.BcelWorld;
import org.aspectj.weaver.bcel.LazyClassGen;
import org.aspectj.weaver.bcel.LazyMethodGen;
import org.aspectj.weaver.bcel.Range;
import org.aspectj.weaver.bcel.UnwovenClassFile;
import org.aspectj.weaver.bcel.Utility;

import awesome.platform.AbstractWeaver;
import awesome.platform.IEffect;

public aspect ComprendoWeaver extends AbstractWeaver {
	/**
	 * variables that keep the info extracted from the annotations.
	 * the info indicate the user request, i.e., which monitoring reports
	 * to generate
	 */
	private String _scope = null;
	private boolean _publicExecutions = false;
	private boolean _publicExecutionsSummary = false;
	private boolean _privateExecutions = false;
	private boolean _privateExecutionsSummary = false;
	
	
	/**
	 * This variable indicates whether more than one Comprendo type
	 * is found. In such a case, the found type is skipped and a message
	 * is printed.
	 */
	private boolean comprendoFound = false;
	
	/**
	 * setInputFiles init this field to hold the class found.
	 * It is used in match to extract the advice defined there.
	 */
	private LazyClassGen comprendoClass;
	
	@Override
	public List<IEffect> match(BcelShadow shadow) {
		List<IEffect> result = new ArrayList<IEffect>();
		
		if (shadow.getKind() == Shadow.MethodExecution) {
			String packageName = shadow.getEnclosingClass().getPackageName();
			BcelMethod method = shadow.getEnclosingMethod().getMemberView();
			int modifiers = method.getModifiers();
			
			// create an effect after "main". assume there is one such main.
			if(method.getName().equals("main")) {
				System.out.println("Comprendo: shadow " + shadow.getSignature() + " match");
				System.out.println("Comprendo: creating effect for shadow...");
				
				IEffect effect = createMainEffect();
				if(effect != null){
					System.out.println("Comprendo: added effect for shadow...");
					result.add(effect);
					return result;
				}
			}
			
			if( isShadowBelongToScope(packageName, modifiers) ){
				System.out.println("Comprendo: shadow " + shadow.getSignature() + " match");
				System.out.println("Comprendo: creating effect for shadow...");
				
				IEffect effect = createComprendoEffect(modifiers);
				if(effect != null){
					result.add(effect);
					System.out.println("Comprendo: added effect for shadow...");
					return result;
				}
			} else {
				System.out.println("Comprendo: shadow " + shadow.getSignature() + " doesn't match");
				return null;
			}	
		}
		return null;
	}

	@Override
	public List<IEffect> order(BcelShadow shadow, List<IEffect> effects) {
		//System.out.println("ComprendoWeaver.order called!");
		return effects;
	}
	
	@Override
	public void setInputFiles(IClassFileProvider inputClasses) {
		System.out.println("Comprendo: setInputFiles called. Input Classes:");
		super.setInputFiles(inputClasses);
		
		// iterate all classes, skip all non-comprendo files:
		for (Iterator i = inputClasses.getClassFileIterator(); i.hasNext();) {
			UnwovenClassFile classFile = (UnwovenClassFile) i.next();
			System.out.println(classFile.getClassName());
			String name = getLastToken(classFile.getClassName());
			if(!(name.startsWith("Comprendo_")))
				continue;
			
			// report & skip if already found a comprendo type:
			if(comprendoFound){
				System.out.println("Comprendo: Found an additional Comprendo type: " +
						name + ". Type is skipped.");
				continue;
			} else {
				comprendoFound = true;
			}
				
			System.out.println("Comprendo: type " + name + " found. Looking " +
					"for annotations...");
			
			AnnotationGen[] annotations = classFile.getJavaClass().getAnnotations();
			initDataStructures(annotations);
			printDataStructures();
			
			comprendoClass = getLazyClassGen(classFile.getClassName());
			// print info about comprendoClass
			List<LazyMethodGen> methods = comprendoClass.getMethodGens();
			System.out.println("Comprendo: " + methods.size() + " methods found in comprendoClass");
			for(LazyMethodGen method: methods)
				System.out.println("Comprendo: LazyMethodGen " + method.getName());
			
		}
	}
	private LazyClassGen getLazyClassGen(String className) {
		BcelObjectType bcelType = BcelWorld.getBcelObjectType(world.resolve(className));
		return bcelType.getLazyClassGen();
	}
	private LazyMethodGen getLazyMethodGen(LazyClassGen clazz, String methodName) {
		List<LazyMethodGen> methods = clazz.getMethodGens();
		for(LazyMethodGen m : methods){
			if(m.getName().equals(methodName))
				return m;
		}
		return null;
	}
	/**
	 * Gets, e.g., "org.eclipse.MyClass", and returns "MyClass"
	 * @param fullName
	 * @return
	 */
	private String getLastToken(String fullName){
		String[] splited = fullName.split("\\.");
		return splited[splited.length-1];
	}
	private void initDataStructures(AnnotationGen[] annotations){
		for(AnnotationGen annot : annotations) {
			if(annot.getTypeName().equals(Comprendo.ComprendoScope)){
				ElementNameValuePairGen elem = (ElementNameValuePairGen) annot.getValues().get(0);
				_scope = elem.getValue().stringifyValue();
			} else if(annot.getTypeName().equals(Comprendo.ComprendoPublicExecutions)){	
				_publicExecutions = true;
				ElementNameValuePairGen elem = (ElementNameValuePairGen) annot.getValues().get(0);
				String summary = elem.getValue().stringifyValue();
				if(summary.equals("true"))
					_publicExecutionsSummary = true;	
			} else if(annot.getTypeName().equals(Comprendo.ComprendoPrivateExecutions)){
				_privateExecutions = true;
				ElementNameValuePairGen elem = (ElementNameValuePairGen) annot.getValues().get(0);
				String summary = elem.getValue().stringifyValue();
				if(summary.equals("true"))
					_privateExecutionsSummary = true;
			}
		}
	}
	private void printDataStructures(){
		System.out.println("Comprendo: scope = " + _scope);
		System.out.println("Comprendo: public executions = " + _publicExecutions + " summary = " + _publicExecutionsSummary);
		System.out.println("Comprendo: private executions = " + _privateExecutions + " summary = " + _privateExecutionsSummary);
	}
	/**
	 * Returns whether the shadow, characterized by the given arguments, should
	 * be monitored. The criteria for monitoring is: 1) package name belongs to the
	 * requested scope 2) the modifier is requested to be monitored.
	 * @param packageName
	 * @param modifiers
	 * @return
	 */
	private boolean isShadowBelongToScope(String packageName, int modifiers) {		
		// currently, scope is simply a name of a package.
		if(!packageName.equals(_scope)) {
			return false;
		}
		if (Modifier.isPrivate(modifiers) && _privateExecutions) {
			return true;
		}
		if (Modifier.isPublic(modifiers) && _publicExecutions) {
			return true;
		}
		
		return false;
	}

	private IEffect createComprendoEffect(int modifiers) {
		String methodName = Modifier.isPrivate(modifiers)? "_logPrivateExecution" : "_logPublicExecution";
		LazyMethodGen method = getLazyMethodGen(comprendoClass, methodName);
		
		if(method == null)
			return null;
		else
			return new ComprendoEffect(comprendoClass, method);
	}
	
	private IEffect createMainEffect() {
		return new IEffect() {
			
			@Override
			public void transform(BcelShadow shadow) {
				InstructionList il = new InstructionList();
				InstructionFactory factory = shadow.getFactory();
				LazyMethodGen method = getLazyMethodGen(comprendoClass, "_printPrivateExecutions");
				
				il.append(Utility.createInvoke(factory, method));
				shadow.getRange().insert(il, Range.InsideBefore);
				//shadow.getRange().append(Utility.createInvoke(factory, method));
			}
			
			@Override
			public void specializeOn(Shadow shadow) {
			}
		};
	}
}
