package base;

import java.io.PrintStream;

public class MainForAjCoolC {
	
	public static void main(String[] args) {
		// name of the file where to print the results
		// by default prints to System.out
		String outFileName = Main.getCommanLineParamVal("outFile", args);
		if (outFileName != null)
			System.setProperty("logFileName", outFileName);
		PrintStream out = Main.getOutputStream(outFileName);
		out.println("===================test start====================>");
		// name of the compiler: one of "ajc", "coolc", "ajcoolc",
		// "ajcomp", "coolcomp", "ajcoolcomp".
		// The second and the third compilers are ``virtual''.
		// if compiler is "coolc" or "ajcoolc" then the buffer is created
		// by instantiating BoundedStackAdvisedWithCoolC, otherwise,
		// instance of BoundedStack is created.
		// If not specified, exception is thrown
		String compiler = Main.getCommanLineParamVal("compiler", args);
		int bufferSize = 10000;
		Stack stack = null;
		if (compiler != null) {
			if (compiler.equals("ajcoolc")) 
				stack = new BoundedStackAdvisedWithAjCoolC(bufferSize);
		} 
		if (stack == null)
			throw new RuntimeException(
					"compiler parameter must be specified: "+ " valid value is ajcoolc");
		Main.testStack(stack, args, out);
	}
}
