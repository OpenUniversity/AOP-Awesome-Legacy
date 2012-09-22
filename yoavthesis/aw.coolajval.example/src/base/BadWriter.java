package base;

import java.util.Random;

public class BadWriter implements Runnable 
{

Stack stack;
	
	private static final String symbols = "abcdefghijklmnopqrstuvwxysz";

	
	public BadWriter(Stack stack)
	{
		this.stack = stack;
	}

	//@Override
	public void run() 
	{
		System.out.println("BadWriter start");
		StringBuffer randomString = new StringBuffer();
		Random r = new Random();
		
		for(int i = 0; i<10000; i++)
		{
			if(i % 10 == 0)
			{
				int ni = r.nextInt(symbols.length());
				stack.push(ni);
			}
			
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
			
			stack.push(randomString);			
		}
		
		System.out.println("BadWriter end");
		
	}


}
