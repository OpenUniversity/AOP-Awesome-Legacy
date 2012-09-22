package cool.frontend.translator;

public class CoolByteType extends CoolPrimType {

	public CoolByteType() {
		super("byte");
	}
	@Override
	public boolean isWiderThan(CoolPrimType type) {
		return (type instanceof CoolBooleanType);
	}

	public boolean isInteger() {
		return true;
	}

	public boolean isNumber() {
		return true;
	}

	public boolean isBoolean() {
		return false;
	}

	public boolean isArray() {
		return false;
	}

}
