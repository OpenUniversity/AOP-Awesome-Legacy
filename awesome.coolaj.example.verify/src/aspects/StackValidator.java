

import org.aspectj.lang.annotation.Aspect;

import awesome.platform.annotations.AwAspectMechanism;
import awesome.validator.TargetClass;
import awesome.validator.TargetMethods;
import static awesome.validator.ValidationUtils.*;

@AwAspectMechanism(id="Validator")
@TargetClass(className="base.BoundedStack")
@TargetMethods(methods="<init> push")
@Aspect
public class StackValidator {
	public static void validate_Stack(Integer capacity) {
		if( !(capacity > 0) ) {
			throw new RuntimeException("Input Validation failed for method Stack(int capacity). Cause: !(capacity > 0)");
		}
	}
	public static void validate_push(Object obj) {
		System.out.println("validate_push");
		if( !string(obj) ) {
			throw new RuntimeException("Input Validation failed for method push(Object obj). Cause: !string(obj)");
		}
		if( !email(obj) ) {
			throw new RuntimeException("Input Validation failed for method push(Object obj). Cause: !email(obj)");
		}
	}
	
	
}
