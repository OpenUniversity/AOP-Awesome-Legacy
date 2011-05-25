package awesome.platform.test;

import awesome.platform.annotations.AwAdviceExecution;
import awesome.platform.annotations.AwSuppressReify;


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
