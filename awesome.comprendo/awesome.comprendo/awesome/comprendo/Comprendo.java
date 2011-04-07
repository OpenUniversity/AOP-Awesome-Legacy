package awesome.comprendo;

import java.util.ArrayList;
import java.util.List;

public class Comprendo {
	
	public static final String ComprendoScope = "awesome.comprendo.ComprendoScope";
	public static final String ComprendoPublicExecutions = "awesome.comprendo.ComprendoPublicExecutions";
	public static final String ComprendoPrivateExecutions = "awesome.comprendo.ComprendoPrivateExecutions";
	
	private List<String> privateExecutions = new ArrayList<String>();
	private List<String> publicExecutions = new ArrayList<String>();
	
	public void logPrivateExecution(String className, String methodName){
		System.out.println("logPrivateExecution called");
		String name = className + "." + methodName;
		privateExecutions.add(name);
	}
	public void logPublicExecution(String className, String methodName){
		System.out.println("logPublicExecution called");
		String name = className + "." + methodName;
		publicExecutions.add(name);
	}
	public void printPrivateExecutions(){
		System.out.println("*** Comprendo Report -- Private Method Executions");
		printExecutions(privateExecutions);	
		System.out.println("*** End of Comprendo Report -- Private Method Executions");
	}
	public void printPublicExecutions(){
		System.out.println("*** Comprendo Report -- Public Method Executions");
		printExecutions(publicExecutions);
		System.out.println("*** End of Comprendo Report -- Public Method Executions");
	}
	private void printExecutions(List<String> methods) {
		for(String method : methods){
			System.out.println(method);
		}
	}
}
