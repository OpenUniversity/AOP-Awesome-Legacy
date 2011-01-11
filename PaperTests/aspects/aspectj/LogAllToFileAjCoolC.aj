package aspects.aspectj;
import java.io.*;
import org.aspectj.lang.JoinPoint;
import aspects.cool.BoundedStackAjCoolCCoord;
import aspects.cool.BoundedStackAjCoolCIntegrator;
import base.BoundedStackAdvisedWithAjCoolC;
import cool.runtime.*;


public aspect LogAllToFileAjCoolC {
	private PrintStream out = null;
	private boolean caughtException = false;
	protected String indent="";
	
	pointcut loggerJPS(): within(LogAllToFileAjCoolC) || cflow(within(LogAllToFileAjCoolC));
	
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
		indent = indent + "  ";
		try{
			return proceed();
		} finally {
			indent = indent.substring(2);
		}
	}

	after() : everythingAfter() && advisableWithAfterAdv() {
		log("after", thisJoinPoint);
	}


	protected void log(String advType, JoinPoint jp) {
		if (caughtException) 
			return;
		try {
			if (out == null) {
				String fileName = System.getProperty("logFileName");
				if (fileName == null)
					fileName = "logAllToFile.out";
				FileOutputStream fout = new FileOutputStream(fileName, true);
				out = new PrintStream(fout);
			}
			out.println(this.indent+advType+": "+jp.toLongString());
			out.flush();
		} catch (Exception e) {
			System.err.println("Error in LogAllToFile: "+e.getMessage());
			System.err.println("Logging is disabled!");
			caughtException = true;
		}
	}

}
