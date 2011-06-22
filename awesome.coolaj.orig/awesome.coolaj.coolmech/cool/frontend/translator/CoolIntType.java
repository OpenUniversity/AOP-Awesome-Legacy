package cool.frontend.translator;

public class CoolIntType extends CoolPrimType {

	public CoolIntType() {
		super("int");
	}

	@Override
	public boolean isWiderThan(CoolPrimType type) {
		return (type instanceof CoolBooleanType)
				|| (type instanceof CoolByteType)
				|| (type instanceof CoolCharType)
				|| (type instanceof CoolShortType);
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