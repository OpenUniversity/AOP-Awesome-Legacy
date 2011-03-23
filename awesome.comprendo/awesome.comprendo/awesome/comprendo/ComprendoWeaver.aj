package awesome.comprendo;

import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;

import org.aspectj.apache.bcel.classfile.annotation.AnnotationGen;
import org.aspectj.apache.bcel.classfile.annotation.ElementNameValuePairGen;
import org.aspectj.weaver.IClassFileProvider;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.bcel.BcelMethod;
import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.UnwovenClassFile;

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
	
	@Override
	public List<IEffect> match(BcelShadow shadow) {
		if (shadow.getKind() == Shadow.MethodExecution) {
			String packageName = shadow.getEnclosingClass().getPackageName();
			BcelMethod method = shadow.getEnclosingMethod().getMemberView();
			int modifiers = method.getModifiers();
			
			if(shouldShadowBeMonitored(packageName, modifiers)){
				System.out.println(shadow.getSignature());
				System.out.println(packageName);
			}
			
			// cont here with modifiers!
			System.out.println(shadow.getSignature());
			System.out.println(shadow.getEnclosingClass().getPackageName());
			if(Modifier.isPublic(modifiers))
				System.out.println("Public Modifier");
			else if(Modifier.isPrivate(modifiers))
				System.out.println("Private Modifier");
			else
				System.out.println("Other Modifier");
		}
		return null;
	}

	@Override
	public List<IEffect> order(BcelShadow shadow, List<IEffect> effects) {
		//System.out.println("ComprendoWeaver.order called!");
		return null;
	}
	
	@Override
	public void setInputFiles(IClassFileProvider inputClasses) {
		super.setInputFiles(inputClasses);
		
		// iterate all classes, skip all non-comprendo files:
		for (Iterator i = inputClasses.getClassFileIterator(); i.hasNext();) {
			UnwovenClassFile classFile = (UnwovenClassFile) i.next();
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
			
		}
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
			if(annot.getTypeName().equals("comprendo.core.ComprendoScope")){
				ElementNameValuePairGen elem = (ElementNameValuePairGen) annot.getValues().get(0);
				_scope = elem.getValue().stringifyValue();
			} else if(annot.getTypeName().equals("comprendo.core.ComprendoPublicExecutions")){	
				_publicExecutions = true;
				ElementNameValuePairGen elem = (ElementNameValuePairGen) annot.getValues().get(0);
				String summary = elem.getValue().stringifyValue();
				if(summary.equals("true"))
					_publicExecutionsSummary = true;	
			} else if(annot.getTypeName().equals("comprendo.core.ComprendoPrivateExecutions")){
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
	private boolean shouldShadowBeMonitored(String packageName, int modifiers) {
		// currently, scope is simply a name of a package.
		if(!packageName.equals(_scope))
			return false;
		if (Modifier.isPrivate(modifiers) && _privateExecutions) {
			return true;
		}
		if (Modifier.isPublic(modifiers) && _publicExecutions) {
			return true;
		}
		
		return false;
	}
}
