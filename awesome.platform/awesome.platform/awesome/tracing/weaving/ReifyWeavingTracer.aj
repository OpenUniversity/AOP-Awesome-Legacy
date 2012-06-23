package awesome.tracing.weaving;

import java.util.List;

import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.LazyClassGen;

import awesome.platform.MultiMechanism;


public aspect ReifyWeavingTracer {
	WeavingTraceWriter writer;
	private static String ENABLED_VAR = System.getenv().get("ENABLE_WEAVING_TRACE");
	private boolean tracingEnabled = ENABLED_VAR.equals("1");

	pointcut transform(LazyClassGen clazz):
		execution(boolean MultiMechanism.transform(LazyClassGen)) && args(clazz);
	pointcut reify(LazyClassGen clazz) : 
		execution(List<BcelShadow> MultiMechanism.reify(LazyClassGen)) && args(clazz);
	
	// notifying the logger upon entering the weaving process of a new class
	before(LazyClassGen clazz) : transform(clazz) {
		///System.out.println("tracing enabled: " + tracingEnabled);
		if(tracingEnabled) {
			if(writer == null)
				writer = new WeavingTraceWriter();
				writer.beginWeaving(clazz.getClassName());			
		}
	}
	// notifying the logger that the weaving ended
	after(LazyClassGen clazz) : transform(clazz) {
		if(tracingEnabled) {
			writer.endWeaving();			
		}
	}
	
	// providing the logger with data about the reify process
	after(LazyClassGen clazz) returning(List<BcelShadow> shadows) : reify(clazz) {
		if(tracingEnabled) {
			writer.numOfReifiedShadows(shadows.size());
		}
	}
}
