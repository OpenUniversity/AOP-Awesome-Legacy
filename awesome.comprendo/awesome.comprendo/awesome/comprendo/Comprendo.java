package awesome.comprendo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comprendo {
	
	public static final String ComprendoScope = "awesome.comprendo.ComprendoScope";
	public static final String ComprendoOutdir = "awesome.comprendo.ComprendoOutdir";
	public static final String ComprendoPublicExecutions = "awesome.comprendo.ComprendoPublicExecutions";
	public static final String ComprendoPrivateExecutions = "awesome.comprendo.ComprendoPrivateExecutions";
	
	private List<String> privateExecutions = new ArrayList<String>();
	private List<String> publicExecutions = new ArrayList<String>();
	
	public void logPrivateExecution(/*String className, String methodName*/String name){
		//System.out.println("logPrivateExecution called");
		//String name = className + "." + methodName;
		privateExecutions.add(name);
	}
	
	public void logPublicExecution(/*String className, String methodName*/String name){
		//System.out.println("logPublicExecution called");
		//String name = className + "." + methodName;
		publicExecutions.add(name);
	}
	
	public void printPrivateExecutions(String outdir, boolean summary){
		if(!outdir.equals(""))
			printExecutionsHTML(privateExecutions, outdir, summary, "Private");
		else
			printExecutions(privateExecutions, outdir, summary, "Private");
	}
	public void printPublicExecutions(String outdir, boolean summary){
		if(!outdir.equals(""))
			printExecutionsHTML(publicExecutions, outdir, summary, "Public");
		else
			printExecutions(publicExecutions, outdir, summary, "Public");
	}

	
	private void printExecutionsHTML(List<String> executions, String outdir, boolean summary, String modifier) {
		// TODO Auto-generated method stub
		System.out.println("printExecutionsHTML called");
	}

	private void printExecutions(List<String> executions, String outdir, boolean summary, String modifier) {
		printHeader(outdir, summary, modifier);
		
		if(summary)
			printSummarizedExecutions(executions);
		else
			printAllExecutions(executions);
		
		printFooter(outdir, summary, modifier);
		
	}

	private void printHeader(String outdir, boolean summary, String modifier) {
		System.out.println("*** Comprendo Report -- " + modifier + " Method Executions");
		System.out.println("Outdir = " + outdir);
	}
	
	private void printFooter(String outdir, boolean summary, String modifier) {
		System.out.println("*** End of Comprendo Report -- " + modifier + " Method Executions");
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
		
	private void printAllExecutions(List<String> methods) {
		for(String method : methods){
			System.out.println(method);
		}
	}
}
