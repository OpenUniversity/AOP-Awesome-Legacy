package awesome.tracing.weaving;

import java.util.List;

import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.LazyClassGen;

import awesome.platform.MultiMechanism;


public aspect ReifyWeavingTracer {
	private WeavingTraceWriter writer = new WeavingTraceWriter();
	private String ENABLED = System.getenv().get("ENABLE_WEAVING_TRACE");
	private boolean enabled = ENABLED.equals("1");

	pointcut transform(LazyClassGen clazz):
		execution(boolean MultiMechanism.transform(LazyClassGen)) && args(clazz);
	pointcut reify(LazyClassGen clazz) :
		execution(List<BcelShadow> MultiMechanism.reify(LazyClassGen)) && args(clazz);
	
	// notifying the logger upon entering the weaving process of a new class
	before(LazyClassGen clazz) : transform(clazz) {
		if(enabled) {
			writer.beginWeaving(clazz.getClassName());			
		}
	}
	// notifying the logger that the weaving ended
	after(LazyClassGen clazz) : transform(clazz) {
		if(enabled) {
			writer.endWeaving();			
		}
	}
	
	// providing the logger with data about the reify process
	after(LazyClassGen clazz) returning(List<BcelShadow> shadows) : reify(clazz) {
		if(enabled) {
			writer.numOfReifiedShadows(shadows.size());
		}
	}
}
