package awesome.comprendo;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.aspectj.weaver.IClassFileProvider;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.bcel.BcelMethod;
import org.aspectj.weaver.bcel.BcelObjectType;
import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.BcelWorld;
import org.aspectj.weaver.bcel.LazyClassGen;
import org.aspectj.weaver.bcel.UnwovenClassFile;

import awesome.platform.AbstractWeaver;
import awesome.platform.AspectClass;
import awesome.platform.AwesomeCore;
import awesome.platform.AwesomeEffect.AdviceType;
import awesome.platform.IEffect;
import awesome.platform.InvokeMethodsEffect;
import awesome.platform.MethodParameter;
import awesome.platform.MethodParameter.Type;

public aspect ComprendoWeaver extends AbstractWeaver {
	
	/**
	 * User defined fields
	 */
	private String scope = null;
	private String outdir = null;
	private boolean publicExecutions = false;
	private boolean publicExecutionsSummary = false;
	private boolean privateExecutions = false;
	private boolean privateExecutionsSummary = false;
		
	private AspectClass ac;
	private List<AspectClass> aspectClasses = new ArrayList<AspectClass>();
	
	@Override
	public List<IEffect> match(BcelShadow shadow) {
		List<IEffect> result = new ArrayList<IEffect>();
		
		if (isShadowMainMethodExecution(shadow)) {
			System.out.println("Awesome: shadow " + shadow.getSignature() + " match");
			System.out.println("Awesome: creating effect for shadow...");
			
			IEffect effect = createPrintReportsEffect();
			if(effect != null){
				System.out.println("Awesome: added effect to shadow...");
				result.add(effect);
				return result;
			}
		}
		
		if (isShadowMethodExecutionAndInScope(shadow)) {
			System.out.println("Awesome: shadow " + shadow.getSignature() + " match");
			System.out.println("Awesome: creating effect for shadow...");
			
			BcelMethod method = shadow.getEnclosingMethod().getMemberView();
			int modifiers = method.getModifiers();
			IEffect effect = createLogShadowEffect(modifiers);
			if(effect != null){
				result.add(effect);
				System.out.println("Awesome: added effect to shadow...");
				return result;
			}
		}
		
		System.out.println("Awesome: shadow " + shadow.getSignature() + " doesn't match");
		return null;
	}
	
	private boolean isShadowMainMethodExecution(BcelShadow shadow) {
		BcelMethod method = shadow.getEnclosingMethod().getMemberView();
		if (shadow.getKind() == Shadow.MethodExecution && method.getName().equals("main"))
			return true;
		
		return false;
	}

	@Override
	public List<IEffect> order(BcelShadow shadow, List<IEffect> effects) {
		return effects;
	}
	
	@Override
	public void setInputFiles(IClassFileProvider inputClasses) {
		super.setInputFiles(inputClasses);
		
		System.out.println(getAspectMechanismId() + ".setInputFiles...");
		for (Iterator i = inputClasses.getClassFileIterator(); i.hasNext();) {
			UnwovenClassFile classFile = (UnwovenClassFile) i.next();
			 	
			if(!AwesomeCore.hasAspectAnnotation(classFile) || !AwesomeCore.belongsToAspectMechanism(classFile, getAspectMechanismId())) {
				continue;
			}
			System.out.println("Found " + getAspectMechanismId() + " aspect class: " + classFile.getClassName() + ".");
			
			AspectClass ac = AwesomeCore.create(classFile);
			
			aspectClasses.add(ac);
		}
		 
		initializeUserFields();
	}
	
	public String getAspectMechanismId() {
		return "Comprendo";
	}
	
	private LazyClassGen getLazyClassGen(String className) {
		BcelObjectType bcelType = BcelWorld.getBcelObjectType(world.resolve(className));
		return bcelType.getLazyClassGen();
	}
	
	
	
	private void initializeUserFields(){
		ac = aspectClasses.get(0);
		scope = ac.getAnnotationValue(Comprendo.ComprendoScope, "scope");
		privateExecutions = ac.hasAnnotation(Comprendo.ComprendoPrivateExecutions)? true : false;
		publicExecutions = ac.hasAnnotation(Comprendo.ComprendoPublicExecutions)? true : false;
		outdir = ac.getAnnotationValue(Comprendo.ComprendoOutdir, "outdir");
		
		if(publicExecutions)
			publicExecutionsSummary = ac.getAnnotationValue(Comprendo.ComprendoPublicExecutions, "summary").equals("true") ? true : false;
		else
			publicExecutionsSummary = false;
		
		if(privateExecutions)
			privateExecutionsSummary = ac.getAnnotationValue(Comprendo.ComprendoPrivateExecutions, "summary").equals("true") ? true : false;
		else
			privateExecutionsSummary = false;
	}
	
	private boolean isShadowMethodExecutionAndInScope(BcelShadow shadow) {
		if( shadow.getKind() != Shadow.MethodExecution ) {
			return false;
		}
	
		String packageName = shadow.getEnclosingClass().getPackageName();
		BcelMethod method = shadow.getEnclosingMethod().getMemberView();
		int modifiers = method.getModifiers();
		
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

	private IEffect createLogShadowEffect(int modifiers) {
		String methodName = Modifier.isPrivate(modifiers)? "_logPrivateExecution" : "_logPublicExecution";
		
		InvokeMethodsEffect effect = new InvokeMethodsEffect(world, ac);
		MethodParameter[] parameters = new MethodParameter[] {new MethodParameter(Type.EnclosingClassName), new MethodParameter(Type.EnclosingMethodName)};
		effect.addMethodInvocation(methodName, parameters);
		
		return effect;
	}
	
	private IEffect createPrintReportsEffect() {
		InvokeMethodsEffect effect = new InvokeMethodsEffect(world, ac);
		effect.setAdviceType(AdviceType.After);
	
		if (privateExecutions) {
			effect.addMethodInvocation("_printPrivateExecutions", new MethodParameter[]{new MethodParameter(outdir), new MethodParameter(privateExecutionsSummary)});
		}
		if (publicExecutions) {
			effect.addMethodInvocation("_printPublicExecutions", new MethodParameter[]{new MethodParameter(outdir), new MethodParameter(publicExecutionsSummary)});
		}
		
		return effect;
	}
}
