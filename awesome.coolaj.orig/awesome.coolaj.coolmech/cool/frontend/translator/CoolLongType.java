package cool.frontend.translator;

public class CoolLongType extends CoolPrimType {

	public CoolLongType() {
		super("long");
	}

	@Override
	public boolean isWiderThan(CoolPrimType type) {
		return (type instanceof CoolBooleanType)
				|| (type instanceof CoolByteType)
				|| (type instanceof CoolCharType)
				|| (type instanceof CoolShortType)
				|| (type instanceof CoolIntType);
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