package awesome.platform;

import static org.junit.Assert.*;

import java.util.List;

import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.bcel.BcelObjectType;
import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.BcelWorld;
import org.aspectj.weaver.bcel.LazyClassGen;
import org.junit.Test;

import awesome.platform.annotations.AwSuppressReify;


public class MultiMechanismTest {
	private String cp = System.getProperty("java.class.path");
	private BcelWorld world = new BcelWorld(cp);
	private MultiMechanism mm = new MultiMechanism(world);
	
	/**
	 * MyTest1 has no annotations:
	 * <pre>public class MyTest1 {
	private int x = 0;
	
	public MyTest1(){
	}
	
	public void foo(){
		boo();
	}
	public void boo(){
		goo();
	}
	public void goo(){
	}
}</pre>
	 */
	@Test
	public void testReify1(){
		LazyClassGen clazz = getLazyClassGen("awesome.platform.test.MyTest1");
		assertEquals(7, mm.reify(clazz).size());
	}
	/**
	 * MyTest2:
	 * <pre>public class MyTest2 {
	private int x = 0;
	
	@SuppressReify
	public MyTest2(){
	}
	public void foo(){
		boo();
	}
	@SuppressReify
	public void boo(){
		goo();
	}
	public void goo(){
	}
}
	 * </pre>
	 */
	@Test
	public void testReify2(){
		LazyClassGen clazz = getLazyClassGen("awesome.platform.test.MyTest2");
		// Note: field-set x=0 is also suppressed because it is
		// part of the constructor
		assertEquals(3, mm.reify(clazz).size());
	}
	/**
	 * MyTest3:
	 * <pre>public class MyTest2 {
	private int x = 0;
	
	public MyTest3(){
	}
	@AwSuppressInternalReify
	public void foo(){
		boo();
	}
	@AwSuppressInternalReify
	public void boo(){
		goo();
	}
	public void goo(){
	}
}</pre>
	 */
	@Test
	public void testReify3(){
		LazyClassGen clazz = getLazyClassGen("awesome.platform.test.MyTest3");
		assertEquals(5, mm.reify(clazz).size());
	}
	
	/**
	 * MyTest4:
	 * <pre>public class MyTest4 {
	private int x = 0;
	
	@AwSuppressReify
	public MyTest4(){
	}
	@AwSuppressReify
	public void foo(){
		boo();
	}
	@AwAdviceExecution
	public void boo(){
		goo();
	}
	@AwSuppressReify
	public void goo(){
	}
}</pre>
	 */
	@Test
	public void testReify4(){
		LazyClassGen clazz = getLazyClassGen("awesome.platform.test.MyTest4");
		List<BcelShadow> shadows = mm.reify(clazz);
		assertEquals(2, shadows.size());
		BcelShadow shadow = shadows.get(1);
		assertEquals(Shadow.AdviceExecution, shadow.getKind());
	}

	
	private LazyClassGen getLazyClassGen(String className) {
		BcelObjectType bcelType = BcelWorld.getBcelObjectType(world.resolve(className));
		return bcelType.getLazyClassGen();
	}
}
