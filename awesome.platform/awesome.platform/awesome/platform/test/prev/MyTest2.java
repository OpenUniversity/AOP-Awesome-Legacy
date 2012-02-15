package awesome.platform.test.prev;

import awesome.platform.annotations.prev.AwSuppressReify;


public class MyTest2 {
	private int x = 0;
	
	@AwSuppressReify
	public MyTest2(){
	}
	
	public void foo(){
		boo();
	}
	
	@AwSuppressReify
	public void boo(){
		goo();
	}
	public void goo(){
	}
}
