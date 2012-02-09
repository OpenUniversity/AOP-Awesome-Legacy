package cool.frontend.translator;

public class CoolBooleanType extends CoolPrimType {
	public CoolBooleanType() {
		super("boolean");
	}
	
	public boolean isInteger() {
		return false;
	}
	public boolean isNumber() {
		return false;
	}
	
	public boolean isBoolean() {
		return true;
	}
	public boolean isArray() {
		return false;
	}
	
	public boolean isWiderThan(CoolPrimType type) {
		return false;
	}

}
