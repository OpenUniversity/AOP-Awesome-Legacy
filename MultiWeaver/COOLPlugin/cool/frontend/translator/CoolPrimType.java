package cool.frontend.translator;

public abstract class CoolPrimType implements CoolType {
	private final String javaName;

	CoolPrimType(String javaName) {
		this.javaName = javaName;
	}

	public abstract boolean isWiderThan(CoolPrimType type);

	public String getJavaName() {
		return javaName;
	}

	public String toString() {
		return javaName;
	}

	public static CoolPrimType getPrimType(String javaname) throws Exception {
		if (javaname != null) {
			if (javaname.equals("boolean"))
				return CoolType.BOOLEAN;
			if (javaname.equals("byte"))
				return CoolType.BYTE;
			if (javaname.equals("char"))
				return CoolType.CHAR;
			if (javaname.equals("int"))
				return CoolType.INT;
			if (javaname.equals("short"))
				return CoolType.SHORT;
			if (javaname.equals("float"))
				return CoolType.FLOAT;
			if (javaname.equals("long"))
				return CoolType.LONG;
			if (javaname.equals("double"))
				return CoolType.DOUBLE;
		}
		throw new Exception("Not a primitive type name: " + javaname);
	}

	boolean isSameAs(CoolPrimType primType) {
		return primType != null
				&& (this == primType || this.getClass() == primType.getClass());
	}

}
