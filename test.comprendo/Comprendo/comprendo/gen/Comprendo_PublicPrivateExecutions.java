package comprendo.gen;

import org.aspectj.lang.annotation.Aspect;
import awesome.platform.annotations.AwAspectMechanism;
import awesome.comprendo.ComprendoScope;
import awesome.comprendo.ComprendoOutdir;
import awesome.comprendo.ComprendoPrivateExecutions;
import awesome.comprendo.ComprendoPublicExecutions;
import awesome.comprendo.Comprendo;

@Aspect
@AwAspectMechanism(id = "Comprendo")
@ComprendoScope(scope = "test.comprendo.types")
@ComprendoOutdir(outdir = "")
@ComprendoPublicExecutions(summary = false)
@ComprendoPrivateExecutions(summary = true)
public class Comprendo_PublicPrivateExecutions {
	private static Comprendo comprendo = new Comprendo();
	
	public static void _logPrivateExecution(String className, String methodName) {
		comprendo.logPrivateExecution(className, methodName);
	}
	public static void _logPublicExecution(String className, String methodName) {
		comprendo.logPublicExecution(className, methodName);
	}
	public static void _printPrivateExecutions(String outdir, boolean summary) {
		comprendo.printPrivateExecutions(outdir, summary);
	}
	public static void _printPublicExecutions(String outdir, boolean summary) {
		comprendo.printPublicExecutions(outdir, summary);
	}
}
