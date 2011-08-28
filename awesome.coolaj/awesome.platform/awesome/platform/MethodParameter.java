package awesome.platform;

public class MethodParameter {
	private Type type;
	private Object value;
	
	public enum Type {
		EnclosingClassName,
		EnclosingMethodName,
		Primitive,
		ALOAD1,
		ALOAD0
	}
	public MethodParameter(MethodParameter.Type type) {
		this.type = type;
	}
	public MethodParameter(String str) {
		type = Type.Primitive;
		value = str;
	}
	public MethodParameter(Boolean bool) {
		type = Type.Primitive;
		value = bool;
	}
	public Type getType() {
		return type;
	}
	public Object getValue() {
		return value;
	}
}
