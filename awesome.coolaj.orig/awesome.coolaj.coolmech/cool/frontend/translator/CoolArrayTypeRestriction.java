package cool.frontend.translator;

public class CoolArrayTypeRestriction implements CoolTypeRestriction {
	private final CoolPrimType elType;
	private final int dimsNum;
	private final CoolArrayType arrType;

	public CoolArrayTypeRestriction(CoolArrayType arrType) {
		this.dimsNum = arrType.getDimsNum();
		this.elType = arrType.getElType();
		this.arrType = arrType;
	}
	
	public CoolArrayTypeRestriction(CoolPrimType elType, int dimsNum) {
		this.dimsNum = dimsNum;
		this.elType = elType;
		arrType = new CoolArrayType(elType, dimsNum);
	}
	
	
	public boolean satisfies(CoolType type) {
		if (type == null)
			return false;
		else if (type instanceof CoolUnknownType) 
			return true;
		else if (type instanceof CoolArrayType) 
			return arrType.isSameAs((CoolArrayType)type);
		return false;
	}

	public CoolType getWidestAllowedType() {
		return arrType;
	}

	public CoolPrimType getElType() {
		return elType;
	}

	public int getDimsNum() {
		return dimsNum;
	}
	
	public String toString() {
		return arrType.toString();
	}
}