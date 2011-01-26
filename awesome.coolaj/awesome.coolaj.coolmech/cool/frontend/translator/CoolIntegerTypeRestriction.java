package cool.frontend.translator;

public class CoolIntegerTypeRestriction implements CoolTypeRestriction {
	
	public boolean satisfies(CoolType type) {
		return (type instanceof CoolUnknownType) || type.isInteger(); 
	}

	public CoolType getWidestAllowedType() {
		return CoolType.LONG;
	}

	public String toString() {
		return "integer(byte, char, short, int, long)";
	}
}
