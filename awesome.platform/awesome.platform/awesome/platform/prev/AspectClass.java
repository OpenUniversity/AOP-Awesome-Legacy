package awesome.platform.prev;

import java.util.List;

import org.aspectj.apache.bcel.classfile.annotation.AnnotationGen;
import org.aspectj.apache.bcel.classfile.annotation.ElementNameValuePairGen;
import org.aspectj.weaver.bcel.UnwovenClassFile;

public class AspectClass {
	private UnwovenClassFile classFile;
	
	AspectClass(UnwovenClassFile classFile) {
		this.classFile = classFile;
	}
	public UnwovenClassFile getClassFile() {
		return classFile;
	}
	public String getName() {
		return classFile.getClassName();
	}
	
	/**
	 * E.g., hasAnnotation("awesome.comprendo.ComprendoScope")
	 */
	public boolean hasAnnotation(String typeName) {
		AnnotationGen[] annotations = classFile.getJavaClass().getAnnotations();
		
		for(AnnotationGen annot : annotations)
			if(annot.getTypeName().equals(typeName))
				return true;
			
		return false;
	}
	
	/**
	 * E.g., getAnnotationValue("awesome.comprendo.ComprendoScope", "scope")
	 */
	public String getAnnotationValue(String typeName, String element) {
		AnnotationGen[] annotations = classFile.getJavaClass().getAnnotations();
		
		for(AnnotationGen annot : annotations) {
			if(annot.getTypeName().equals(typeName)){
				List elemValPairs = annot.getValues();
				for(Object obj: elemValPairs ) {
					ElementNameValuePairGen elemVal = (ElementNameValuePairGen) obj;
					if (elemVal.getNameString().equals(element))
							return elemVal.getValue().stringifyValue();
				}
			}
		}
		return null;
	}
}
