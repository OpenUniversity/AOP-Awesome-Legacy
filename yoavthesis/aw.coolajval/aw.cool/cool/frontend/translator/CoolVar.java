package cool.frontend.translator;
import cool.frontend.ast.Node;

public class CoolVar {
	private CoolType type;
	private String name;
	private boolean isCondition;
	private Node init;

	public CoolVar(CoolType type, String name, Node init) {
		this.type = type;
		this.name = name;
		this.init = init;
		isCondition = false;
	}
	
	public CoolVar(CoolType type, String name, Node init, boolean isCondition) {
		this.type = type;
		this.name = name;
		this.init = init;		
		this.isCondition = isCondition;
	}
	
	public String getName() {return name;}
	public String getTypeName() {return type.getJavaName();}
	public Node getInitExpr() {return init;}
	public CoolType getType() {return type;} 
	void setIsCondition(boolean isCondition) {
		this.isCondition = isCondition;
	}
	public boolean isCondition() {return isCondition;}
}
