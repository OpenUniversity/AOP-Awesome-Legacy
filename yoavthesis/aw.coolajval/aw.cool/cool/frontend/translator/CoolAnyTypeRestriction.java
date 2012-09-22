package cool.frontend.translator;

public class CoolAnyTypeRestriction implements CoolTypeRestriction {

	public boolean satisfies(CoolType type) {
		return true; 
	}

	public CoolType getWidestAllowedType() {
		return CoolType.UNKNOWN;
	}

	public String toString() {
		return "any(byte, char, short, int, long, float, double, array)";
	}
		
}