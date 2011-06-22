package cool.frontend.translator;

public class CoolUnknownType implements CoolType {
	

	public boolean isInteger() {
		return false;
	}

	public boolean isNumber() {
		return false;
	}

	public boolean isBoolean() {
		return false;
	}

	public boolean isArray() {
		return false;
	}
	
	public String getJavaName() {
		return "unknown";
	}
	public String toString() {
		return getJavaName();
	}
}
