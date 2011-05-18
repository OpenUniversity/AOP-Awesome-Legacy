package awesome.platform;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.apache.bcel.classfile.annotation.AnnotationGen;
import org.aspectj.apache.bcel.classfile.annotation.ElementNameValuePairGen;
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
	public static AspectClassFile create(UnwovenClassFile classFile) {
		AspectClassFile result = new AspectClassFile(classFile);
		return result;
	}
	/*public static List<Annotation> getAnnotations(UnwovenClassFile classFile) {
		AnnotationGen[] annotations = classFile.getJavaClass().getAnnotations();
		List<Annotation> result = new ArrayList<Annotation>();
		int index = 0;
		
		for(AnnotationGen annot: annotations) {
			Annotation res = new Annotation();
			String typeName = annot.getTypeName();
			String[] typeNameSplited = typeName.split("\\.");
			res.setName(typeNameSplited[typeNameSplited.length-1]);
		}
		
		return null;
	}*/
}
