package cool.frontend.translator;
import java.util.*;

/**
 * Variable environment for the type checker.
 * @author Sergei
 *
 */
public class CoolVarEnv {
	private CoolVarEnv enclEnv;
	private Map<String, CoolVar> vars;
	
	public CoolVarEnv(CoolVarEnv enclEnv) {
		this.enclEnv=enclEnv;
		this.vars = new HashMap<String, CoolVar>();
	}
	
	/**
	 * Adds a variable to the variable environment.
	 * Throws exception if the variable is already 
	 * in the environment.
	 * @param var
	 */
	public void addCoolVar(CoolVar var) throws Exception  {
		if (var==null) return;
		String name = var.getName();
		if (vars.containsKey(name))
			throw new Exception("variable "+var+" already declared.");
		//System.out.println("adding a variable to "+this+":"+name);
		vars.put(name, var);
	}
	
	/**
	 * Searches for a variable named  <code>name</name> in the environment.
	 * @param name
	 * @return identified variable
	 * @throws Exception if the variable is not found in the environment
	 */
	public CoolVar lookupCoordVar(String name)throws Exception {
		CoolVar result = vars.get(name);
		if (result==null) 
			if (enclEnv!=null)
				result = enclEnv.lookupCoordVar(name);
			else
		  	    throw new Exception("Variable "+name+" is not found!");
		return result;
	}
	
	protected List<CoolVar> getCoolVars() {
		List<CoolVar> result = new ArrayList<CoolVar>();
		result.addAll(vars.values());
		if (enclEnv!=null)
			result.addAll(enclEnv.getCoolVars());
		return result;
	}
	
	//for debugging purposes
	/*
	public void printCoolVars() {
		System.out.println("Printing venv "+this+" vars:");
		for (CoolVar var:getCoolVars())
			System.out.println("var: "+var.getName()+", isCondition="+var.isCondition());
		
	}*/
	
}
