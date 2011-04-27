package awesome.comprendo;

import java.util.ArrayList;
import java.util.Collections;
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
	
	public void printPrivateExecutions(boolean summary){
		System.out.println("*** Comprendo Report -- Private Method Executions");
		
		if(summary) 
			printSummarizedExecutions(privateExecutions);
		else 
			printAllExecutions(privateExecutions);
		
		System.out.println("*** End of Comprendo Report -- Private Method Executions");
	}
	private void printSummarizedExecutions(List<String> methods) {
		Collections.sort(methods);
		
		int count = 0;
		String previousMethod = methods.get(0);
		for(String method : methods) {
			if(!method.equals(previousMethod)) {
				System.out.println(previousMethod + " (" + count + ")");
				previousMethod = method;
				count = 1;
				continue;
			}
			count++;
		}
		System.out.println(previousMethod + " (" + count + ")");
	}
	
	public void printPublicExecutions(boolean summary){
		System.out.println("*** Comprendo Report -- Public Method Executions");
		
		if(summary) 
			printSummarizedExecutions(publicExecutions);
		else 
			printAllExecutions(publicExecutions);
		
		System.out.println("*** End of Comprendo Report -- Public Method Executions");
	}
	
	private void printAllExecutions(List<String> methods) {
		for(String method : methods){
			System.out.println(method);
		}
	}
}
