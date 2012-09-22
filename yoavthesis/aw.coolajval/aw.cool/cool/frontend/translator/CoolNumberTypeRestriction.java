package cool.frontend.translator;

public class CoolNumberTypeRestriction implements CoolTypeRestriction {

	public boolean satisfies(CoolType type) {
		return (type instanceof CoolUnknownType) || type.isNumber(); 
	}

	public CoolType getWidestAllowedType() {
		return CoolType.DOUBLE;
	}

	public String toString() {
		return "number(byte, char, short, int, long, float, double)";
	}
		
}
