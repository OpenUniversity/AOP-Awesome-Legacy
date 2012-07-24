package awesome.platform.annotations;

public @interface AwSuppressReify {
	/**
	 * Applicable for all types (classes, methods, constructors and fields).
	 * Suppresses reify of all shadows: those in the type's level and below (if exists).
	 */
	public static String ALL = "all";
	/**
	 * Applicable for methods and constructors.
	 * Suppresses reify of shadow within the body only.
	 */
	public static String WITHIN = "within";
	/**
	 * Applicable for methods and constructors (TODO also classes).
	 * Suppresses reify of the outer shadow, whether it is a method-execution shadow
	 * or a constructor-execution shadows. Shadows within the body are exposed. 
	 */
	public static String EXECUTION_SHADOW = "execution";
	
	String value() default ALL;
}
