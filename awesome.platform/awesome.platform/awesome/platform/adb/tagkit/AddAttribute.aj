package awesome.platform.adb.tagkit;

import org.aspectj.weaver.bcel.LazyClassGen;
import awesome.platform.MultiMechanism;

public abstract aspect AddAttribute {
	pointcut transform(LazyClassGen clazz): 
		execution(* MultiMechanism.transform(LazyClassGen)) && args(clazz);
}
