package awesome.comprendo;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.aspectj.weaver.IClassFileProvider;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.bcel.BcelMethod;
import org.aspectj.weaver.bcel.BcelShadow;
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
		
	private void initializeUserFields(){
	}
	
	private boolean isShadowMethodExecutionAndInScope(BcelShadow shadow) {
		if( shadow.getKind() != Shadow.MethodExecution ) {
			return false;
		}
		
		AspectClass ac = aspectClasses.get(0);
		String packageName = shadow.getEnclosingClass().getPackageName();
		BcelMethod method = shadow.getEnclosingMethod().getMemberView();
		int modifiers = method.getModifiers();
		
		// currently, scope is simply a name of a package.
		if(!packageName.equals(ac.getAnnotationValue(Comprendo.ComprendoScope, "scope"))) {
			return false;
		}
		if (Modifier.isPrivate(modifiers) && ac.hasAnnotation(Comprendo.ComprendoPrivateExecutions)) {
			return true;
		}
		if (Modifier.isPublic(modifiers) && ac.hasAnnotation(Comprendo.ComprendoPublicExecutions)) {
			return true;
		}
		
		return false;
	}

	private IEffect createLogShadowEffect(int modifiers) {
		AspectClass ac = aspectClasses.get(0);
		String methodName = Modifier.isPrivate(modifiers)? "_logPrivateExecution" : "_logPublicExecution";
		
		InvokeMethodsEffect effect = new InvokeMethodsEffect(world, ac);
		MethodParameter[] parameters = new MethodParameter[] {new MethodParameter(Type.EnclosingClassName), new MethodParameter(Type.EnclosingMethodName)};
		effect.addMethodInvocation(methodName, parameters);
		
		return effect;
	}
	
	private IEffect createPrintReportsEffect() {
		AspectClass ac = aspectClasses.get(0);
		boolean privateExecutions = ac.hasAnnotation(Comprendo.ComprendoPrivateExecutions)? true : false;
		boolean publicExecutions = ac.hasAnnotation(Comprendo.ComprendoPublicExecutions)? true : false;
		boolean publicExecutionsSummary,privateExecutionsSummary;
		String outdir = ac.getAnnotationValue(Comprendo.ComprendoOutdir, "outdir");
		if(publicExecutions)
			publicExecutionsSummary = ac.getAnnotationValue(Comprendo.ComprendoPublicExecutions, "summary").equals("true") ? true : false;
		else
			publicExecutionsSummary = false;
		
		if(privateExecutions)
			privateExecutionsSummary = ac.getAnnotationValue(Comprendo.ComprendoPrivateExecutions, "summary").equals("true") ? true : false;
		else
			privateExecutionsSummary = false;
		
		
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
