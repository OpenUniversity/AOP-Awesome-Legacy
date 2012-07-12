package awesome.platform.adb.tagkit;

import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.LazyClassGen;
import awesome.platform.MultiMechanism;

public abstract aspect AddAttribute {
	pointcut transformClass(LazyClassGen clazz): 
		execution(* MultiMechanism.transform(LazyClassGen)) && args(clazz);
	pointcut transformShadow(BcelShadow shadow): 
		execution(* MultiMechanism.transform(BcelShadow)) && args(shadow);
}
