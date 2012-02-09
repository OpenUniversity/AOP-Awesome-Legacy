package awesome.validator;

public class ValidationUtils {
	public static boolean string(Object obj) {
		return obj instanceof String;
	}
	public static boolean email(Object obj) {
		if( !string(obj)) return false;
		// TODO test for email pattern
		return true;
	}
}
