package awesome.tracing.weaving;

import java.util.List;

import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.LazyClassGen;

import awesome.platform.MultiMechanism;


public aspect WeavingTracer {
	private WeavingTraceWriter logger = new WeavingTraceWriter();
	private String enabled = System.getenv().get("ENABLE_WEAVING_TRACE");

	pointcut transform(LazyClassGen clazz):
		execution(boolean MultiMechanism.transform(LazyClassGen)) && args(clazz);
	pointcut reify(LazyClassGen clazz) :
		execution(List<BcelShadow> MultiMechanism.reify(LazyClassGen)) && args(clazz);
	
	// notifying the logger upon entering the weaving process of a new class
	before(LazyClassGen clazz) : transform(clazz) {
		if(enabled.equals("1")) {
			logger.beginWeaving(clazz.getClassName());			
		}
	}
	// notifying the logger that the weaving ended
	after(LazyClassGen clazz) : transform(clazz) {
		if(enabled.equals("1")) {
			logger.endWeaving();			
		}
	}
	
	// providing the logger with data about the reify process
	after(LazyClassGen clazz) returning(List<BcelShadow> shadows) : reify(clazz) {
		if(enabled.equals("1")) {
			logger.numOfReifiedShadows(shadows.size());			
		}
	}
}
