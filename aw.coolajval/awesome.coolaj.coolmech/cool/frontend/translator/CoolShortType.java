package cool.frontend.translator;

public class CoolShortType extends CoolPrimType {

	public CoolShortType() {
		super("short");
	}

	@Override
	public boolean isWiderThan(CoolPrimType type) {
	
		return (type instanceof CoolBooleanType)
				|| (type instanceof CoolByteType);
				//|| (type instanceof CoolCharType);
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