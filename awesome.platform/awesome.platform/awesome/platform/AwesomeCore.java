package awesome.platform;

import org.aspectj.apache.bcel.classfile.JavaClass;
import org.aspectj.apache.bcel.classfile.annotation.AnnotationGen;
import org.aspectj.apache.bcel.classfile.annotation.ElementNameValuePairGen;
import org.aspectj.weaver.AnnotationAJ;
import org.aspectj.weaver.bcel.LazyClassGen;
import org.aspectj.weaver.bcel.LazyMethodGen;
import org.aspectj.weaver.bcel.UnwovenClassFile;

public class AwesomeCore {
	private static final String AJ_ANNOTATION = "org.aspectj.lang.annotation.Aspect";
	public static final String ASPECT_MECHANISM_ANNOTATION = "awesome.platform.annotations.AwAspectMechanism";
	public static final String SUPPRESS_REIFY_ANNOTATION = "awesome.platform.annotations.AwSuppressReify";
	
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
	 * @param classFile
	 * @param aspectMechanismId
	 * @return true if the given class has an @AwAspectMechanism annotation with
	 * value id=aspectMechanismId 
	 */
	public static boolean belongsToAspectMechanism(JavaClass classFile, String aspectMechanismId) {
		AnnotationGen[] annotations = classFile.getAnnotations();
				
		for(AnnotationGen annot : annotations)
			if(annot.getTypeName().equals(ASPECT_MECHANISM_ANNOTATION)){
				ElementNameValuePairGen elem = (ElementNameValuePairGen) annot.getValues().get(0);
				String id = elem.getValue().stringifyValue();
				if(id.equals(aspectMechanismId))
					return true;
				else
					return false;
			}
		
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
	/**
	 * @return true if the annotation exists and it has an element with the specified name and value.
	 */
	public static boolean hasAnnotation(LazyMethodGen method, String annotation, String name, String value) {
		AnnotationGen[] annotations = method.getMethod().getAnnotations();
		for(AnnotationGen annot : annotations){
			if(annot.getTypeName().equals(annotation) && annot.hasNameValuePair(name, value))
				return true;
		}	
		return false;
	}
	/**
	 * @return true if the annotation exists and it has an element with the specified name and value.
	 */
	public static boolean hasAnnotation(LazyClassGen clazz, String annotation, String name, String value) {
		AnnotationAJ[] annotations = clazz.getType().getAnnotations();
		for(AnnotationAJ annot : annotations){
			if(annot.getTypeName().equals(annotation) && annot.hasNameValuePair(name, value))
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
}
