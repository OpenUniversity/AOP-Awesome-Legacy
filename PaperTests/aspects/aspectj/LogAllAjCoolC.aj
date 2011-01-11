package aspects.aspectj;
import org.aspectj.lang.JoinPoint;
import aspects.cool.BoundedStackAjCoolCCoord;
import aspects.cool.BoundedStackAjCoolCIntegrator;
import base.BoundedStackAdvisedWithAjCoolC;
import cool.runtime.*;

/** Version of LogAll for imitation of the AjCoolC compiler */
public aspect LogAllAjCoolC {

	pointcut loggerJPS(): within(LogAllAjCoolC) || cflow(within(LogAllAjCoolC));
	
	pointcut coordJPS() :
		within(BoundedStackAjCoolCIntegrator) ||
		within(BoundedStackAjCoolCCoord);
	
	pointcut visibleCoordJPS() :
		 (within(BoundedStackAjCoolCCoord) &&
		  (set(@COOLConditionField * BoundedStackAjCoolCCoord.*) ||
		   get(@COOLConditionField * BoundedStackAjCoolCCoord.*) ||
		   set(@COOLCoordinatorField * BoundedStackAjCoolCCoord.*) ||
		   get(@COOLCoordinatorField * BoundedStackAjCoolCCoord.*) ||
		   get(* BoundedStackAdvisedWithAjCoolC.*))) ||
		 (within(BoundedStackAjCoolCIntegrator) && 
				 adviceexecution() &&
				 !cflow(initialization(BoundedStackAdvisedWithAjCoolC.new(..))));
	
	pointcut visibleJPS(): 
		visibleCoordJPS() || !(loggerJPS() || coordJPS());
	
	pointcut advisableWithBeforeAdv(): visibleJPS();
	pointcut advisableWithAroundAdv(): 
		visibleJPS() && 
		!(adviceexecution() ||
			set(@COOLConditionField * BoundedStackAjCoolCCoord.*) ||
			get(@COOLConditionField * BoundedStackAjCoolCCoord.*));
	pointcut advisableWithAfterAdv(): visibleJPS();

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


	before() : everything() && advisableWithBeforeAdv() {
		log("before", thisJoinPoint);
	}

	Object around() : everythingAround() && advisableWithAroundAdv() {
		log("around", thisJoinPoint);
			return proceed();
	}

	after() : everythingAfter() && advisableWithAfterAdv() {
		log("after", thisJoinPoint);
	}
	
	protected void log(String advType, JoinPoint jp) {}
}
