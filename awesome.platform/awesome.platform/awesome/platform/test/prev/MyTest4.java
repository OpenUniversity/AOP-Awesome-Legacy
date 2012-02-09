package awesome.platform.test.prev;

import awesome.platform.annotations.prev.AwAdviceExecution;
import awesome.platform.annotations.prev.AwSuppressReify;


public class MyTest4 {
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
}
