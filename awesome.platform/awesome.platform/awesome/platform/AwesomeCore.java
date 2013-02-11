package awesome.platform;

import org.aspectj.apache.bcel.classfile.JavaClass;
import org.aspectj.apache.bcel.classfile.annotation.AnnotationGen;
import org.aspectj.apache.bcel.classfile.annotation.ElementNameValuePairGen;
import org.aspectj.weaver.AnnotationAJ;
import org.aspectj.weaver.ResolvedType;
import org.aspectj.weaver.UnresolvedType;
import org.aspectj.weaver.bcel.LazyClassGen;
import org.aspectj.weaver.bcel.LazyMethodGen;
import org.aspectj.weaver.bcel.UnwovenClassFile;

public class AwesomeCore {
	private static final String AJ_ANNOTATION = "org.aspectj.lang.annotation.Aspect";
	public static final String ASPECT_MECHANISM_ANNOTATION = "awesome.platform.annotations.AwAspectMechanism";
	private static final String AW_REIFY_ANNOTATION = "awesome.platform.annotations.AwReify";
	
	/**
	 * 
	 * @param classFile
	 * @return true if the given class has an annotation @Aspect
	 * (i.e., org.aspectj.lang.annotation.Aspect)
	 */
	public static boolean hasAspectAnnotation(UnwovenClassFile classFile) {
		AnnotationGen[] annotations = classFile.getJavaClass().getAnnotations();
		
		for(AnnotationGen annot : annotations)
			if(annot.getTypeName().equals(AJ_ANNOTATION))
				return true;
		
		return false;
	}
	
	/**
	 * Returns true if the given aspect has an @AwAspectMechanism annotation with
	 * value id=aspectMechanismId, or if @AwAspectMechanism is not present but the
	 * mechanism is AspectJ.
	 * @param classFile Assumed to be an aspect!
	 * @param mechId 
	 */
	public static boolean belongsToAspectMechanism(JavaClass classFile, String mechId) {
		AnnotationGen[] annotations = classFile.getAnnotations();
		boolean awAnnotation = false;
		
		for(AnnotationGen annot : annotations)
			if(annot.getTypeName().equals(ASPECT_MECHANISM_ANNOTATION)){
				awAnnotation = true;
				ElementNameValuePairGen elem = (ElementNameValuePairGen) annot.getValues().get(0);
				String id = elem.getValue().stringifyValue();
				if(id.equals(mechId))
					return true;
			}
		// AspectJ check
		if(!awAnnotation && mechId.equals(AwesomeMechanism.ASPECTJ_MECHANISM_ID))
			return true;
		
		return false;
	}
	
	public static AspectClass create(UnwovenClassFile classFile) {
		AspectClass result = new AspectClass(classFile);
		return result;
	}

	/**
	 * @return true if the method has the specified annotation
	 * @param method
	 * @param annotation e.g., AwesomeCore.SUPPRESS_REIFY_ANNOTATION
	 */
	public static boolean hasAnnotation(LazyMethodGen method, String annotation) {
		AnnotationGen[] annotations = method.getMethod().getAnnotations();
		for(AnnotationGen annot : annotations){
			if(annot.getTypeName().equals(annotation))
				return true;
		}	
		return false;
	}
	public static boolean hasAnnotation(JavaClass clazz, String annotName) {
		AnnotationGen[] annotations = clazz.getAnnotations();
		for(AnnotationGen annot : annotations){
			if(annot.getTypeName().equals(annotName))
				return true;
		}	
		return false;
	}
	public static String getReifyStrategy(LazyClassGen clazz) {
		String value = getAnnotationValue(clazz.getType(), AW_REIFY_ANNOTATION, "value");
		if(value == null)
			return ReifyStrategy.NONE;
		else
			return value;
	}
	public static String getReifyStrategy(LazyMethodGen method) {
		String value = getAnnotationValue(method, AW_REIFY_ANNOTATION);
		if(value == null)
			return ReifyStrategy.NONE;
		else
			return value;
	}
	private static String getAnnotationValue(LazyMethodGen method, String annotation) {
		AnnotationGen[] annotations = method.getMethod().getAnnotations();
		for(AnnotationGen annot : annotations){
			if(annot.getTypeName().equals(annotation)) {
				String res = ((ElementNameValuePairGen) annot.getValues().get(0)).getValue().stringifyValue();
				return res;
			}
		}	
		return null;
	}
	private static String getAnnotationValue(ResolvedType type, String annotation, String val) {
		AnnotationAJ[] annotations = type.getAnnotations();
		for(AnnotationAJ annot : annotations){
			if(annot.getTypeName().equals(annotation)) {
				String res = annot.getStringFormOfValue(val); 
				return res;
			}
		}	
		return null;
	}
	/**
	 * Returns the id of the mechanism as specified by the @AwAspectMechanism annotation.
	 * In case the annotation is not present, the aspect is reported as belonging
	 * to "aspectj".
	 * @param type assumed to be an aspect type.
	 * @return
	 */
	public static String getMechanismId(ResolvedType type) {
		String result = getAnnotationValue(type, ASPECT_MECHANISM_ANNOTATION, "id");
		return (result!=null)? result : "aspectj";
	}
	public static String getMechanismId(UnresolvedType type) {
		ResolvedType resType = MultiMechanism.getInstance().getWorld().resolve(type);
		String result = getAnnotationValue(resType, ASPECT_MECHANISM_ANNOTATION, "id");
		return (result!=null)? result : "aspectj";
	}
}
