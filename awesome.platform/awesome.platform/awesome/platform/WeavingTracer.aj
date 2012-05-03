package awesome.platform;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.aspectj.weaver.bcel.LazyClassGen;
import org.aspectj.weaver.bcel.BcelShadow;

public aspect WeavingTracer {
	private WeavingLogger logger = new WeavingLogger();

	pointcut transform(LazyClassGen clazz):
		execution(boolean MultiMechanism.transform(LazyClassGen)) && args(clazz);
	pointcut reify(LazyClassGen clazz) :
		execution(List<BcelShadow> MultiMechanism.reify(LazyClassGen)) && args(clazz);
	
	// notifying the logger upon entering the weaving process of a new class
	before(LazyClassGen clazz) : transform(clazz) {
		logger.beginWeaving(clazz.getClassName());
	}
	// notifying the logger that the weaving ended
	after(LazyClassGen clazz) : transform(clazz) {
		logger.endWeaving();
	}
	
	// providing the logger with data about the reify process
	after(LazyClassGen clazz) returning(List<BcelShadow> shadows) : reify(clazz) {
		logger.numOfReifiedShadows(shadows.size());
	}
}
