package aspects.aspectj;

import org.aspectj.lang.*;
import java.io.*;

public aspect LogAllToFile {
	private PrintStream out = null;
	private boolean caughtException = false;
	protected String indent="";

	pointcut scope(): !within(LogAllToFile) && !cflow(within(LogAllToFile));
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
		indent = indent + "  ";
		try{
		return proceed();
		} finally {
			indent = indent.substring(2);
		}
	}

	after() : everythingAfter() && scopeAfter() {
		log("after", thisJoinPoint);
	}
	/*before(): execution(* base.BoundedStack.getBuffer()) {
		log("before", thisJoinPoint);
	}*/

	
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
