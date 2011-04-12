package comprendo.gen;

import org.aspectj.lang.annotation.Aspect;
import awesome.comprendo.ComprendoScope;
import awesome.comprendo.ComprendoPrivateExecutions;
import awesome.comprendo.ComprendoPublicExecutions;
import awesome.comprendo.Comprendo;

@Aspect
@ComprendoScope (scope = "test.comprendo.types")
@ComprendoPublicExecutions (summary = true)
@ComprendoPrivateExecutions (summary = true)
public class Comprendo_PublicPrivateExecutions {
	private static Comprendo comprendo = new Comprendo();
	
	public static void _logPrivateExecution(String className, String methodName) {
		comprendo.logPrivateExecution(className, methodName);
	}
	public static void _logPublicExecution(String className, String methodName) {
		comprendo.logPublicExecution(className, methodName);
	}
	public static void _printPrivateExecutions(boolean summary) {
		comprendo.printPrivateExecutions(summary);
	}
	public static void _printPublicExecutions(boolean summary) {
		comprendo.printPublicExecutions(summary);
	}
}
