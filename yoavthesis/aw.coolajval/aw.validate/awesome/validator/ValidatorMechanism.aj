package awesome.validator;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.LazyClassGen;
import org.aspectj.weaver.bcel.UnwovenClassFile;
import org.aspectj.weaver.IClassFileProvider;
import org.aspectj.weaver.Shadow;

import awesome.platform.*;
import awesome.platform.AwesomeEffect.AdviceType;
import awesome.platform.MethodParameter.Type;

public aspect ValidatorMechanism extends AbstractWeaver {
	private static final String ID = "Validator";
	private List<AspectClass> aspectClasses = new ArrayList<AspectClass>();
	private List<IEffect> effects = new  ArrayList<IEffect>();
	
	@Override
	public List<IEffect> match(BcelShadow shadow)
	{
		
		// We assume we have one aspect class. We are interested in method-execution shadows defined in
		// class @TargetClass and belongs to @TargetShadows.
		
		List<IEffect> result = new ArrayList<IEffect>();
		
		if(aspectClasses.size() == 0)
			return result;

		
		if(shadow.getKind() == Shadow.MethodExecution /*|| shadow.getKind() == Shadow.ConstructorExecution*/) {
			AspectClass ac = aspectClasses.get(0);
			String targetClass = ac.getAnnotationValue("awesome.validator.TargetClass", "className");
			String targetMethods = ac.getAnnotationValue("awesome.validator.TargetMethods", "methods");
			List<String> targetMethodsList = Arrays.asList(targetMethods.split(" "));
			String shadowClassName = shadow.getEnclosingClass().getClassName();
			String shadowMethodName = shadow.getEnclosingMethod().getName();
		
			// we are only interested in shadows in the target class that were asked for validation
			if( !shadowClassName.equals(targetClass) || !targetMethodsList.contains(shadowMethodName))
				return null;
			
			// the implementation below is specific for our Stack example! should be generalized of course.
			String effectMethodName = "validate_push"/*shadow.getKind() == Shadow.MethodExecution ? "validate_push" : "validate_Stack"*/;
			InvokeMethodsEffect effect = new InvokeMethodsEffect(shadow.getWorld(), ac);
			effect.setAdviceType(AdviceType.Before);
			effect.addMethodInvocation(effectMethodName, new MethodParameter[] {new MethodParameter(Type.ALOAD1)});
			result.add(effect);
		
			effects.add(effect);
			
			return result;
		}
		
		return null;
	}

	@Override
	public List<IEffect> order(BcelShadow shadow, List<IEffect> effects) {
		return effects;
	}
	
	//@Override
	public String getAspectMechanismId() {
		return ID;
	}
	
	@Override
	public void setInputFiles(IClassFileProvider inputClasses) {
		super.setInputFiles(inputClasses);
		
		System.out.println(getAspectMechanismId() + ".setInputFiles...");
		for (Iterator i = inputClasses.getClassFileIterator(); i.hasNext();) {
			UnwovenClassFile classFile = (UnwovenClassFile) i.next();
			 	
			if(!AwesomeCore.hasAspectAnnotation(classFile) || 
				!AwesomeCore.belongsToAspectMechanism(classFile.getJavaClass(), getAspectMechanismId())) {
				continue;
			}
			System.out.println("Found " + getAspectMechanismId() + " aspect class: " + classFile.getClassName() + ".");
			
			AspectClass ac = AwesomeCore.create(classFile);
			
			aspectClasses.add(ac);
		}
		 
		initializeUserFields();
	}
	
	private void initializeUserFields() {
		// TODO Add initialization code for user defined fields
	}

	@Override
	public boolean handledByMe(LazyClassGen aspectClazz) 
	{
		boolean handled = false;
		
		for(AspectClass c : aspectClasses)
		{
			if(c.getName() == aspectClazz.getName())
			{
				handled = true;
				break;
			}
		}
		
		return handled;
		
	}

	@Override
	public List<IEffect> getEffects(LazyClassGen aspectClazz) {
		return effects;
	}

	@Override
	public String getId() {
		return getAspectMechanismId();
	}
}