package base;

import java.util.Random;

public class GoodWriter implements Runnable 
{
	Stack stack;
	
	private static final String symbols = "abcdefghijklmnopqrstuvwxysz";

	
	public GoodWriter(Stack stack)
	{
		this.stack = stack;
	}

	
	//@Override
	public void run() 
	{
		System.out.println("GoodWriter start");
		StringBuffer randomString = new StringBuffer();
		Random r = new Random();
		
		for(int i = 0; i<10000; i++)
		{
			int j;
			for(j = 0; j<5; j++)
			{
				int ni = r.nextInt(symbols.length());
				randomString.append(symbols.charAt(ni));				
			}
			
			randomString.append('@');
			
			for(j = 0; j<5; j++)
			{
				int ni = r.nextInt(symbols.length());
				randomString.append(symbols.charAt(ni));					
			}
			
			stack.push(randomString.toString());			
		}
		
		System.out.println("GoodWriter end");
		
	}
	

}
