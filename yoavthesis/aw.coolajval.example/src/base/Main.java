package base;

public class Main 
{
	Stack stack;
	
	public void doExample()
	{
		stack = new BoundedStack(50000);
		GoodWriter gw  = new GoodWriter(stack);
		Thread t1 = new Thread(gw, "GoodWriter");
		t1.start();
		
		BadWriter bw  = new BadWriter(stack);
		Thread t2 = new Thread(bw, "BadWriter");
		t2.start();
		
		
		
		
	}
	
	public static void main(String[] args) 
	{
		Main m  = new Main();
		m.doExample();		
	}

}
