package awesome.platform;

/**
 * Holds various reify strategies. Use one of the constants
 * here as the value for the {@link awesome.platform.annotations.AwReify} annotation.
 * @author oren
 *
 */
public class ReifyStrategy {
	public static final String NONE = "0";
	/**
	 * Applicable for all types (classes, methods, constructors and fields).
	 * Suppresses reify of all shadows: those in the type's level and below (if exists).
	 */
	public static final String SUPPRESS_ALL = "1";
	/**
	 * Applicable for methods and constructors.
	 * Suppresses reify of shadow within the body only.
	 */
	public static final String SUPPRESS_WITHIN = "2";
	/**
	 * Applicable for methods and constructors (TODO also classes).
	 * Suppresses reify of the outer shadow, whether it is a method-execution shadow
	 * or a constructor-execution shadows. Shadows within the body are exposed. 
	 */
	public static final String SUPPRESS_EXECUTION_SHADOW = "3";
	/**
	 * Applicable for classes. Suppresses reify of the
	 * staticinitialization shadow (the shadow and within).
	 */
	public static final String SUPPRESS_STATICINITIALIZATION = "4";
}
