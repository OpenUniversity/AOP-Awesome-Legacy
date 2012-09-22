package awesome.platform.adb.util;

public class Logger 
{
	private static boolean isLogOn()
	{
		return System.getenv().containsKey("DEBUG_ON");
	}
	
	public static void logLn(String s)
	{
		if(isLogOn())
			System.err.println(s);		
	}
}
