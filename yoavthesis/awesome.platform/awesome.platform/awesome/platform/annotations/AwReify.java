package awesome.platform.annotations;

/**
 * An annotation that controls the reify process. E.g., a user may
 * suppress the reify of certain shadows. Has a single value 
 * that is supplied 
 * by {@link awesome.platform.ReifyStrategy}
 * @author oren
 *
 */
public @interface AwReify {
	String value();
}
