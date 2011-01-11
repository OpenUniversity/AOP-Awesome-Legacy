package cool.frontend.translator;

public class CoolCharType extends CoolPrimType {

	public CoolCharType() {
		super("char");
	}
	@Override
	public boolean isWiderThan(CoolPrimType type) {
		return 
		(type instanceof CoolBooleanType);
		//|| (type instanceof CoolByteType);
		
		
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