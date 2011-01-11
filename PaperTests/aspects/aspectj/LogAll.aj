package aspects.aspectj;
import org.aspectj.lang.JoinPoint;

/** This is just for testing runing time */
public aspect LogAll {

	pointcut scope(): !within(LogAll) && !cflow(within(LogAll));
	pointcut scopeBefore(): scope();
	pointcut scopeAround(): scope();
	pointcut scopeAfter(): scope();

	
	public pointcut everything() :
		(call(* *.*(..)) ||
		 execution(* *.*(..)) ||
		 get(* *.*) ||
		 set(* *.*) ||
		 call(*.new(..)) ||
		 execution(*.new(..)) ||
		 initialization(*.new(..)) ||
		 preinitialization(*.new(..)) ||
		 staticinitialization(*) ||
		 adviceexecution() ||
		 handler(*));

	public pointcut everythingAround() : 
		everything() &&
		!initialization(*.new(..)) &&
		!preinitialization(*.new(..)) &&
		!staticinitialization(*) &&
		!handler(*);

	public pointcut everythingAfter() : 
		everything() &&
		!handler(*);
	
	before() : everything() && scopeBefore() {
		log("before", thisJoinPoint);
	}

	Object around() : everythingAround() && scopeAround() {
		log("around", thisJoinPoint);
		return proceed();
	}

	after() : everythingAfter() && scopeAfter() {
		log("after", thisJoinPoint);
	}
	
	protected void log(String advType, JoinPoint jp) {
		return;
	}

}
