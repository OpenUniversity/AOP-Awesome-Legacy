package cool.frontend.translator;

public interface CoolTypeRestriction {
	public static final CoolBooleanTypeRestriction BOOLEAN = new CoolBooleanTypeRestriction();
	public static final CoolIntegerTypeRestriction INTEGER = new CoolIntegerTypeRestriction();
	public static final CoolNumberTypeRestriction NUMBER = new CoolNumberTypeRestriction();
	public static final CoolAnyTypeRestriction ANY = new CoolAnyTypeRestriction();


	public boolean satisfies(CoolType type);

	public CoolType getWidestAllowedType();
}
