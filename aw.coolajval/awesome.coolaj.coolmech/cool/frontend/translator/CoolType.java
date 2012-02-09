package cool.frontend.translator;

public interface CoolType {
	public static final CoolBooleanType BOOLEAN = new CoolBooleanType();
	public static final CoolByteType BYTE = new CoolByteType();
	public static final CoolCharType CHAR = new CoolCharType();
	public static final CoolShortType SHORT = new CoolShortType();
	public static final CoolIntType INT = new CoolIntType();
	public static final CoolLongType LONG = new CoolLongType();
	public static final CoolFloatType FLOAT = new CoolFloatType();
	public static final CoolDoubleType DOUBLE = new CoolDoubleType();
	public static final CoolUnknownType UNKNOWN = new CoolUnknownType();
	

	public boolean isInteger();
	public boolean isNumber();
	public boolean isBoolean();
	public boolean isArray();
	public String getJavaName();
	

}
