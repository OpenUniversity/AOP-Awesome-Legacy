package awesome.comprendo;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.aspectj.apache.bcel.classfile.annotation.AnnotationGen;
import org.aspectj.apache.bcel.classfile.annotation.ElementNameValuePairGen;
import org.aspectj.weaver.IClassFileProvider;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.bcel.BcelMethod;
import org.aspectj.weaver.bcel.BcelObjectType;
import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.BcelWorld;
import org.aspectj.weaver.bcel.LazyClassGen;
import org.aspectj.weaver.bcel.LazyMethodGen;
import org.aspectj.weaver.bcel.UnwovenClassFile;

import awesome.platform.AbstractWeaver;
import awesome.platform.IEffect;

public aspect ComprendoWeaver extends AbstractWeaver {
	/**
	 * variables that keep the user request, i.e., which monitoring reports
	 * to generate. Extracted from the annotations. 
	 */
	private String scope = null;
	private boolean publicExecutions = false;
	private boolean publicExecutionsSummary = false;
	private boolean privateExecutions = false;
	private boolean privateExecutionsSummary = false;
	
	/**
	 * This variable indicates whether more than one Comprendo type
	 * is found. In such a case, the found type is skipped and a message
	 * is printed.
	 */
	private boolean comprendoFound = false;
	
	/**
	 * setInputFiles init this field to hold the class found.
	 * It is used in match() to extract the advice methods defined there.
	 */
	private LazyClassGen comprendoClass;
	
	@Override
	public List<IEffect> match(BcelShadow shadow) {
		List<IEffect> result = new ArrayList<IEffect>();
		
		if (shadow.getKind() == Shadow.MethodExecution) {
			String packageName = shadow.getEnclosingClass().getPackageName();
			BcelMethod method = shadow.getEnclosingMethod().getMemberView();
			int modifiers = method.getModifiers();
			
			// create an effect after "main". We assume there is one such main.
			if(method.getName().equals("main")) {
				System.out.println("Comprendo: shadow " + shadow.getSignature() + " match");
				System.out.println("Comprendo: creating effect for shadow...");
				
				IEffect effect = createMainEffect();
				if(effect != null){
					System.out.println("Comprendo: added effect to shadow...");
					result.add(effect);
					return result;
				}
			}
			
			// create an effect before each method execution shadow that belongs to scope
			if( isShadowBelongToScope(packageName, modifiers) ){
				System.out.println("Comprendo: shadow " + shadow.getSignature() + " match");
				System.out.println("Comprendo: creating effect for shadow...");
				
				IEffect effect = createComprendoEffect(modifiers);
				if(effect != null){
					result.add(effect);
					System.out.println("Comprendo: added effect to shadow...");
					return result;
				}
			} 	
		}
		
		System.out.println("Comprendo: shadow " + shadow.getSignature() + " doesn't match");
		return null;
	}

	@Override
	public List<IEffect> order(BcelShadow shadow, List<IEffect> effects) {
		return effects;
	}
	
	@Override
	public void setInputFiles(IClassFileProvider inputClasses) {
		super.setInputFiles(inputClasses);
		
		System.out.println("Comprendo: setInputFiles called. Input Classes:");
		
		// iterate all classes, skip all non comprendo files:
		for (Iterator i = inputClasses.getClassFileIterator(); i.hasNext();) {
			UnwovenClassFile classFile = (UnwovenClassFile) i.next();
			System.out.println(classFile.getClassName());
			String name = getLastToken(classFile.getClassName());
			if(!(name.startsWith("Comprendo_")))
				continue;
			
			// report & skip if already found a comprendo type:
			if(comprendoFound){
				System.out.println("Comprendo: Found an additional Comprendo type: " + name + ". Type is skipped.");
				continue;
			} else {
				comprendoFound = true;
			}
				
			System.out.println("Comprendo: type " + name + " found. Extracting annotations...");
			AnnotationGen[] annotations = classFile.getJavaClass().getAnnotations();
			initUserRequestFields(annotations);
			printUserRequestFields();

			comprendoClass = getLazyClassGen(classFile.getClassName());
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
	
	private void initUserRequestFields(AnnotationGen[] annotations){
		for(AnnotationGen annot : annotations) {
			if(annot.getTypeName().equals(Comprendo.ComprendoScope)){
				ElementNameValuePairGen elem = (ElementNameValuePairGen) annot.getValues().get(0);
				scope = elem.getValue().stringifyValue();
				continue;
			} 
			
			if(annot.getTypeName().equals(Comprendo.ComprendoPublicExecutions)){	
				publicExecutions = true;
				ElementNameValuePairGen elem = (ElementNameValuePairGen) annot.getValues().get(0);
				String summary = elem.getValue().stringifyValue();
				if(summary.equals("true"))
					publicExecutionsSummary = true;
				continue;
			}
			
			if(annot.getTypeName().equals(Comprendo.ComprendoPrivateExecutions)){
				privateExecutions = true;
				ElementNameValuePairGen elem = (ElementNameValuePairGen) annot.getValues().get(0);
				String summary = elem.getValue().stringifyValue();
				if(summary.equals("true"))
					privateExecutionsSummary = true;
			}
		}
	}
	
	private void printUserRequestFields(){
		System.out.println("Comprendo: scope = " + scope);
		System.out.println("Comprendo: public executions = " + publicExecutions + " summary = " + publicExecutionsSummary);
		System.out.println("Comprendo: private executions = " + privateExecutions + " summary = " + privateExecutionsSummary);
	}
	/**
	 * Returns whether the shadow, characterized by the given arguments, should
	 * be monitored. The criteria for monitoring is: 1) its package belongs to the
	 * requested scope 2) the modifier is requested to be monitored.
	 * @param packageName
	 * @param modifiers
	 * @return
	 */
	private boolean isShadowBelongToScope(String packageName, int modifiers) {		
		// currently, scope is simply a name of a package.
		if(!packageName.equals(scope)) {
			return false;
		}
		if (Modifier.isPrivate(modifiers) && privateExecutions) {
			return true;
		}
		if (Modifier.isPublic(modifiers) && publicExecutions) {
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
			return new ComprendoEffect(method);
	}
	
	private IEffect createMainEffect() {
		LazyMethodGen printPrivateMethod = null;
		LazyMethodGen printPublicMethod = null;
		
		if (privateExecutions) {
			printPrivateMethod = getLazyMethodGen(comprendoClass, "_printPrivateExecutions");
		}
		if (publicExecutions) {
			printPublicMethod = getLazyMethodGen(comprendoClass, "_printPublicExecutions");
		}
		
		return new MainEffect(printPrivateMethod, privateExecutionsSummary, printPublicMethod, publicExecutionsSummary);
	}
}
