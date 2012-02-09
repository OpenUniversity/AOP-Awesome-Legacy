package cool.frontend.translator;

public class CoolBooleanTypeRestriction implements CoolTypeRestriction {

	public boolean satisfies(CoolType type) {
		return (type instanceof CoolUnknownType) || type.isBoolean(); 
	}

	public CoolType getWidestAllowedType() {
		return CoolType.BOOLEAN;
	}

	public String toString() {
		return "boolean";
	}
}
