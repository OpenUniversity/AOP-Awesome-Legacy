package awesome.platform;

import org.aspectj.apache.bcel.classfile.annotation.AnnotationGen;
import org.aspectj.apache.bcel.classfile.annotation.ElementNameValuePairGen;
import org.aspectj.weaver.bcel.LazyMethodGen;
import org.aspectj.weaver.bcel.UnwovenClassFile;

public class AwesomeCore {
	private static final String AJ_ANNOTATION = "org.aspectj.lang.annotation.Aspect";
	
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
	public static boolean belongsToAspectMechanism(UnwovenClassFile classFile, String aspectMechanismId) {
		AnnotationGen[] annotations = classFile.getJavaClass().getAnnotations();
		
		for(AnnotationGen annot : annotations)
			if(annot.getTypeName().equals("awesome.platform.annotations.AwAspectMechanism")){
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

	public static boolean hasAnnotation(LazyMethodGen mg, String annotName) {
		AnnotationGen[] annotations = mg.getMethod().getAnnotations();
		for(AnnotationGen annot : annotations){
			if(annot.getTypeName().equals(annotName))
				return true;
		}	
		return false;
	}
}
