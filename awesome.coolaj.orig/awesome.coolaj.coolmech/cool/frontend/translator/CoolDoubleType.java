package cool.frontend.translator;

public class CoolDoubleType extends CoolPrimType {

	public CoolDoubleType() {
		super("double");
	}

	@Override
	public boolean isWiderThan(CoolPrimType type) {
		return (type instanceof CoolBooleanType)
				|| (type instanceof CoolByteType)
				|| (type instanceof CoolCharType)
				|| (type instanceof CoolShortType)
				|| (type instanceof CoolIntType)
				|| (type instanceof CoolLongType)
				|| (type instanceof CoolFloatType);
	}

	public boolean isInteger() {
		return false;
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