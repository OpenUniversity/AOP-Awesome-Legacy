package awesome.platform.test.prev;

import awesome.platform.annotations.prev.AwSuppressInternalReify;

public class MyTest3 {
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
}
