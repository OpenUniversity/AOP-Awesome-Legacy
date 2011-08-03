package awesome.platform.adb.util.log;

public class logger 
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
