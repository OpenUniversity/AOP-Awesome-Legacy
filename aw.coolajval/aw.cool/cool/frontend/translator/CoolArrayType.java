package cool.frontend.translator;

public class CoolArrayType implements CoolType {
	private final CoolPrimType elType;

	private final int dimsNum;

	public CoolArrayType(CoolPrimType elType, int dimsNum) {
		this.dimsNum = dimsNum;
		this.elType = elType;
	}

	public boolean isInteger() {
		return false;
	}

	public boolean isNumber() {
		return false;
	}

	public boolean isBoolean() {
		return false;
	}

	public boolean isArray() {
		return true;
	}

	public CoolPrimType getElType() {
		return elType;
	}

	public int getDimsNum() {
		return dimsNum;
	}

	public boolean isEqualTo(CoolArrayType arrType) {
		return arrType.dimsNum == dimsNum && arrType.elType.equals(elType);
	}

	public String getJavaName() {
		return toString();
	}

	public String toString() {
		String result = elType.toString();
		for (int i = 0; i < dimsNum; i++)
			result = result + "[]";
		return result;
	}
	
	public boolean isSameAs(CoolArrayType arrType) {
		return (arrType!=null 
				&& dimsNum==arrType.getDimsNum()
				&& elType.isSameAs(arrType.getElType()));
	}

}
