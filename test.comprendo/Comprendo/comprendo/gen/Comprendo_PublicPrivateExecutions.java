package comprendo.gen;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
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
	
	@After("execution(private * test.comprendo.types.*.*(..))")
	public /*static*/ void _logPrivateExecution(/*String className, String methodName*/JoinPoint jp) {
		comprendo.logPrivateExecution(/*className, methodName*/jp.getSignature().toString());
	}
	@After("execution(public * test.comprendo.types.*.*(..))")
	public /*static*/ void _logPublicExecution(/*String className, String methodName*/JoinPoint jp) {
		comprendo.logPublicExecution(/*className, methodName*/jp.getSignature().toString());
	}
	@After("execution(* test.comprendo.main.Main.main(..))")
	public /*static*/ void _printPrivateExecutions(/*String outdir, boolean summary*/) {
		comprendo.printPrivateExecutions(/*outdir, summary*/"", true);
	}
	@After("execution(* test.comprendo.main.Main.main(..))")
	public /*static*/ void _printPublicExecutions(/*String outdir, boolean summary*/) {
		comprendo.printPublicExecutions(/*outdir, summary*/"", false);
	}
}
