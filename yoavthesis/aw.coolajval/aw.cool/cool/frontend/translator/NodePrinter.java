package cool.frontend.translator;

import cool.frontend.ast.*;
import java.util.*;
import java.lang.reflect.Method;



public class NodePrinter {
	private StringBuffer out = new StringBuffer();
	private int nextRefIndx=0;
	private StringBuffer externalRefs;
	private String indent = "";
	private CoolTypeChecker typeChecker = null;
	private String tgtClassName=null;
	
	NodePrinter(StringBuffer out, String indent) {
		init(out, indent, null, null);
	}

	NodePrinter(StringBuffer out, String indent, CoolTypeChecker typeChecker, String tgtClassName) {
		init(out, indent, typeChecker, tgtClassName);
	}
	
	private void init(StringBuffer out, String indent, CoolTypeChecker typeChecker, String tgtClassName) {
		if (out==null) out = new StringBuffer();
		if (indent==null) indent = "";
		this.indent=indent;
		this.out=out;
		nextRefIndx = 0;
		this.externalRefs = new StringBuffer();
		this.typeChecker = typeChecker;
		this.tgtClassName=tgtClassName;
	}
	
	private static final NodePrinter defaultRenderer = new NodePrinter(null,null);
	public static void render(Node node, StringBuffer out, String indent) {
		defaultRenderer.renderIntoBuffer(node, out, indent);
	}
	
	public String getOutput(){
		return out.toString();
	}
	
	public String getExternalRefMethods() {
		return externalRefs.toString();
	}

	public void renderIntoBuffer(Node node, StringBuffer out, String indent) {
		StringBuffer outTmp = this.out;
		String indentTmp = this.indent;
		
		if (out!=null) this.out = out;
		if (indent!=null) this.indent=indent;
		
		render(node);
		
		this.out = outTmp;
		this.indent = indentTmp;
		
	}
	
	public void render(Node node) {
		try {
			Method method = NodePrinter.class.getDeclaredMethod("render",
					new Class[] { node.getClass() });
			if (method.getParameterTypes()[0] != Node.class)
				method.invoke(this, new Object[] { node });
			else
				renderKids(node);
		} catch (Exception e) {
			throw new RuntimeException("Unknown node: " + node);
		}
	}

	//<PACKAGE> Name() ("." Name())* ";"
	private void render(ASTPackageDecl node) {
		out.append("package ");
		renderKids(node, ".");
		out.append(";");
	}

	//<IMPORT> Name() ("." Name())* ["." "*" {jjtThis.setTrailingStar(true);}] ";"
	private void render(ASTImportDecl node) {
		out.append("import ");
		renderKids(node, ".");
		if (node.hasTrailingStar()) 
			out.append(".*");
		out.append(";");
	}	
	
	//PrimType() VarInit() ("," VarInit())*
	private void render(ASTFieldDecl node) {
		out.append("private ");
		render(node.jjtGetChild(0));
		out.append(" ");
		renderKids(node, ", ", 1);
		out.append(";");
	}

	//<CONDITION> VarInit() ("," VarInit())*
	private void render(ASTCondFieldDecl node) {
		out.append("private boolean ");
		renderKids(node, ", ");
		out.append(";");
	}
	

	// <FOR> "("[ForInit()] ";" [Expr() {jjtThis.setHasConditionExpr(true);}]
	// ";" [AssignExpr() ("," AssignExpr())*] ")" Stmnt()
	private void render(ASTForStmnt node) {
		List<Node> children = Utils.getChildren(node);
		int nextChild = 0;
		// while
		out.append("for (");
		Node child = children.get(0);
		if (child instanceof ASTForInit) {
			render((ASTForInit) child);
			nextChild++;
		}
		out.append("; ");
		if (node.hasConditionExpr()) {
			render(children.get(nextChild++));
		}
		out.append("; ");
		renderKids(node, ",", nextChild, children.size() - 2);
		out.append(") ");
		indentUp();
		out.append("\n" + indent);
		render(children.get(children.size() - 1));
		indentDown();
		out.append("\n" + indent);
	}

	// <SWITCH> "(" Expr() ")" "{" (CaseBlock())* "}"
	private void render(ASTSwitchStmnt node) {
		List<Node> children = Utils.getChildren(node);
		out.append("switch (");
		render(children.get(0));
		out.append(") {");
		indentUp();
		out.append("\n" + indent);
		this.renderKids(node, "\n" + indent, 1);
		indentDown();
		out.append("\n" + indent);
		out.append("}");
		out.append("\n" + indent);
	}

	// (<CASE> Expr() ":" {jjtThis.setDefault(false);}
	// | <DEFAULTKW> ":" {jjtThis.setDefault(true);})
	// (BlockStmntEl())*
	private void render(ASTCaseBlock node) {
		List<Node> children = Utils.getChildren(node);
		int nextChild = 0;

		if (node.isDefault()) {
			out.append("default : ");
		} else {
			out.append("case ");
			render(children.get(nextChild++));
			out.append(" : ");
		}
		renderKids(node, " ", nextChild);
	}

	// PrimType() VarInit() ("," VarInit)*
	// | VarRef() "=" Expr() ("," VarRef() "=" Expr())*
	private void render(ASTForInit node) {
		List<Node> children = Utils.getChildren(node);
		Node child1 = children.get(0);
		Node child2 = children.get(1);
		if (child1 instanceof ASTType) {
			render((ASTType) child1);
			this.renderKids(node, ",", 1);
		} else {
			render(child1);
			out.append(" = ");
			render(child2);
			for (int i = 2; i < children.size(); i = i + 2) {
				out.append(", ");
				render(children.get(i));
				out.append(" = ");
				render(children.get(i + 1));
			}
		}
	}

	// Name() ("[" "]" {jjtThis.addDimension();})* ["=" InitArr()]
	// | Name() ["=" Expr()]
	private void render(ASTVarInit node) {
		List<Node> children = Utils.getChildren(node);
		out.append(children.get(0));
		if (node.getDimensionsNum() > 0) {
			for (int i = 0; i < node.getDimensionsNum(); i++)
				out.append("[]");
		}
		if (children.size() == 1)
			return;
		out.append(" = ");
		render(children.get(1));
	}

	// "{" [(InitArr() | Expr()) ("," ( InitArr() | Expr()))*] "}"
	private void render(ASTInitArr node) {
		out.append("{");
		this.renderKids(node, ", ");
		out.append("}");
	}

	// ATOM ("[" "]" {jjtThis.addDimension();})*
	private void render(ASTType node) {
		this.renderKids(node, ".");
		for (int i = 0; i < node.getDimensionsNum(); i++)
			out.append("[]");
	}

	// <WHILE> "(" Expr() ")" Stmnt()
	private void render(ASTWhileStmnt node) {
		List<Node> children = Utils.getChildren(node);
		// while
		out.append("while (");
		render(children.get(0));
		out.append(") ");
		// body
		indentUp();
		out.append("\n" + indent);
		render(children.get(1));
		indentDown();
		out.append("\n" + indent);
	}

	// <DO> Stmnt() <WHILE> "(" Expr() ")" ";"
	private void render(ASTDoStmnt node) {
		List<Node> children = Utils.getChildren(node);
		// while
		out.append("do ");
		render(children.get(0));
		out.append(" while (");
		render(children.get(1));
		out.append(");");
	}

	// <IF> "(" Expr() ")" Stmnt() [LOOKAHEAD(1) <ELSE> Stmnt()]
	private void render(ASTIfStmnt node) {
		List<Node> children = Utils.getChildren(node);
		// if
		out.append("if (");
		render(children.get(0));
		out.append(")");
		// then
		indentUp();
		out.append("\n" + indent);
		render(children.get(1));
		indentDown();
		// else
		if (children.size() == 3) {
			out.append("\n" + indent);
			out.append("else");
			indentUp();
			out.append("\n" + indent);
			render(children.get(2));
			indentDown();
			out.append("\n" + indent);
		}
	}

	// "{" (Stmnt() | FieldDecl())* "}"
	private void render(ASTBlockStmnt node) {
		out.append("{ ");
		indentUp();
		for (Node child : Utils.getChildren(node)) {
			if (!(child instanceof ASTEmptyStmnt))
			  out.append("\n" + indent);
			render(child);
		}
		indentDown();
		out.append("\n" + indent);
		out.append("}");
		out.append("\n" + indent);
	}

	// AssignOp() VarRef() {jjtThis.setAssignType("prefix");}
	// | VarRef() AssignOp() {jjtThis.setAssignType("postfix");}
	// | VarRef() "=" Expr() {jjtThis.setAssignType("normal");}
	private void render(ASTAssignExpr node) {
		String assignType = node.getAssignType();
		Node child1 = node.jjtGetChild(0);
		Node child2 = node.jjtGetChild(1);
		if (assignType == null || assignType.equals("normal")
				|| assignType.equals("")) {
			render(child1);
			out.append(" = ");
			render(child2);
		} else {
			render(child1);
			render(child2);
		}
	}

	// Name() ("[" Expr() "]")* ["." VarRef() {jjtThis.setComplex(true);}]
	private void render(ASTVarRef node) {
		List<Node> children = Utils.getChildren(node);
		boolean isExternal = 
			(typeChecker!=null && typeChecker.isExternalRef(node));
		StringBuffer outTmp = out;
		String indentTmp = indent;
		if (isExternal) {
			out=new StringBuffer();
			indent = "";
		}
		
		render(children.get(0));
		int lastBracketPos = children.size() - 1;
		if (node.isComplex())
			lastBracketPos--;
		for (int i = 1; i <= lastBracketPos; i++) {
			out.append("[");
			render(children.get(i));
			out.append("]");
		}
		if (node.isComplex()) {
			out.append(".");
			render(children.get(children.size() - 1));
		}
		if (isExternal) {
			CoolType type = typeChecker.getExternalRefType(node);
			String refStr = out.toString();
			refStr=refStr.replaceAll("\"", "\\\"");
			String mName = " _ref"+nextRefIndx;
			nextRefIndx++;
			String returnVal = "null";
			if (type.isBoolean()) 
				returnVal="false";
			else if (type.isNumber())
				returnVal="0";
			
			externalRefs.append("  @COOLExternalRef(expr=\"").append(refStr).append("\")\n");
			externalRefs.append("  private ").append(type.toString()).append(mName);
			externalRefs.append("(").append(tgtClassName).append(" thiz) {\n");
			externalRefs.append("    return ").append(returnVal).append(";\n");
			externalRefs.append("  }\n");
			
			out=outTmp;
			indent = indentTmp;
			out.append(mName).append("(thiz)");
		}		
		
	}
	
	// <NEW> PrimTypeName() ("[" Expr() "]")+	
	private void render(ASTNewArrExpr node) {
		List<Node> children = Utils.getChildren(node);
		out.append("new ");
		render(children.get(0));
		int nodeNum = children.size();
		for (int i = 1; i < nodeNum; i++) {
			out.append("[");
			render(children.get(i));
			out.append("]");
		}
	}

	private void render(ASTCondOrExpr node) {
		renderKids(node, " || ");
	}

	private void render(ASTCondAndExpr node) {
		renderKids(node, " && ");
	}

	private void render(ASTInclOrExpr node) {
		renderKids(node, " | ");
	}

	private void render(ASTExclOrExpr node) {
		renderKids(node, " ^ ");
	}

	private void render(ASTAndExpr node) {
		renderKids(node, " & ");
	}

	private void render(ASTEqExpr node) {
		renderKids(node, " ");
	}

	private void render(ASTRelExpr node) {
		renderKids(node, " ");
	}

	private void render(ASTShiftExpr node) {
		renderKids(node, " ");
	}

	private void render(ASTAddExpr node) {
		renderKids(node, " ");
	}

	private void render(ASTMultExpr node) {
		renderKids(node, " ");
	}

	private void render(ASTUnaryExpr node) {
		renderKids(node);
	}

	private void render(ASTBracketExpr node) {
		out.append("(");
		render(node.jjtGetChild(0));
		out.append(")");
	}

	// Name() ":" Stmnt()
	private void render(ASTLabeledStmnt node) {
		renderKids(node, " : ");
	}

	// Name() ":" Stmnt()
	private void render(ASTBreakStmnt node) {
		out.append("break");
		if (node.jjtGetNumChildren() > 0) {
			out.append(" ");
			render(node.jjtGetChild(0));
		}
		out.append(";");
	}

	// Name() ":" Stmnt()
	private void render(ASTContinueStmnt node) {
		out.append("continue");
		if (node.jjtGetNumChildren() > 0) {
			out.append(" ");
			render(node.jjtGetChild(0));
		}
		out.append(";");
	}

	// ";"
	private void render(ASTEmptyStmnt node) {
		out.append(";");
	}

	private void render(ASTAtom node) {
		out.append(node.getValue());
	}
	


	private void render(ASTMethodName node) {
		render(node.jjtGetChild(0));
		out.append("(");
		renderKids(node, ",", 1);
		out.append(")");
	}		
	
	//Name() ("." Name())*
	private void render(ASTClassName node) {
		renderKids(node, ".");
	}	

	private void render(ASTReqOrExpr node) {
		renderKids(node, " || ");
	}
	
	private void render(ASTReqAndExpr node) {
		renderKids(node, " && ");
	}
	
	private void render(ASTReqEqExpr node) {
		renderKids(node, " ");
	}
	
	// Name() ("[" Expr() "]")*
	private void render(ASTReqVarRef node) {
		List<Node> children = Utils.getChildren(node);		
		render(children.get(0));
		int lastBracketPos = children.size() - 1;
		for (int i = 1; i <= lastBracketPos; i++) {
			out.append("[");
			render(children.get(i));
			out.append("]");
		}		
	}

	private void render(ASTReqBracketExpr node) {
		out.append("(");
		render(node.jjtGetChild(0));
		out.append(")");
	}	

	private void render(ASTReqNegExpr node) {
		out.append("!");
		render(node.jjtGetChild(0));
	}	

	private void renderKids(Node node) {
		renderKids(node, "");
	}

	private void renderKids(Node node, String separator) {
		renderKids(node, separator, 0);
	}

	private void renderKids(Node node, String separator, int start) {
		renderKids(node, separator, start, node.jjtGetNumChildren() - 1);
	}

	private void renderKids(Node node, String separator, int start, int end) {
		int chNum = node.jjtGetNumChildren();
		if (start >= chNum || start > end)
			return;
		if (end >= chNum)
			end = chNum - 1;
		render(node.jjtGetChild(start));
		for (int i = start + 1; i <= end; i++) {
			out.append(separator);
			render(node.jjtGetChild(i));
		}
	}

	private String indentUp() {
		String result = indent;
		indent = indent + "  ";
		return result;
	}

	private String indentDown() {
		String result = indent;
		if (indent.length() > 1) {
			indent = indent.substring(2);
		}
		return result;
	}
	

}
