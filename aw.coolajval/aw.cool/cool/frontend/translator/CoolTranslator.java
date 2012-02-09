package cool.frontend.translator;

import java.util.*;
import cool.frontend.ast.*;

/**
 * Translates a COOL coordinator to a Java class
 * 
 * @author Sergei Kojarski
 * 
 */
public class CoolTranslator {
	private String packageDecl;

	private List<String> importDecls;

	private List<String> targetClassNames;

	private List<CoolVar> fields;

	private CoolVarEnv fieldEnv;

	private boolean isPerClass;

	private List<Set<String>> mutexSets;

	private Set<String> selfexSet;
	
	private Map<String, MethodSig> targetMethods;

	private Map<String, List<Node>> meth2req;

	private Map<String, List<Node>> meth2entry;

	private Map<String, List<Node>> meth2exit;

	private CoolTypeChecker typeChecker;

	private void init() {
		packageDecl = "";
		importDecls = new ArrayList<String>();
		targetClassNames = new ArrayList<String>();
		fields = new ArrayList<CoolVar>();
		fieldEnv = null;
		isPerClass = false;
		typeChecker = new CoolTypeChecker();
		mutexSets = new ArrayList<Set<String>>();
		selfexSet = new HashSet<String>();
		meth2req = new HashMap<String, List<Node>>();
		meth2entry = new HashMap<String, List<Node>>();
		meth2exit = new HashMap<String, List<Node>>();
		targetMethods = new HashMap<String, MethodSig>();
	}

	public StringBuffer translate(ASTCoordinatorDecl coordDecl)
			throws Exception {
		init();
		int chNum = coordDecl.jjtGetNumChildren();

		// initializing all the fields AND type-checking
		// all statements and expressions.
		for (int i = 0; i < chNum; i++) {
			Node child = coordDecl.jjtGetChild(i);
			if (child instanceof ASTCoordinationSpec)
				initEnv((ASTCoordinationSpec) child);
			else if (child instanceof ASTPackageDecl)
				packageDecl = Utils.render(child);
			else if (child instanceof ASTImportDecl)
				importDecls.add(Utils.render(child));
			else if (child instanceof ASTGranularity)
				isPerClass = ((ASTGranularity) child).isClass();
			else if (child instanceof ASTClassName)
				targetClassNames.add(Utils.render(child));			
		}

		// type checking field initialization expressions
		for (CoolVar fieldVar : fields) {
			Node initExpr = fieldVar.getInitExpr();
			if (initExpr != null) {
				typeChecker.getAssignRHSExpType(fieldVar.getType(), initExpr, fieldEnv);
			}
		}

		// at this point, all fields are properly intialized,
		// and all statements and expressions are type-checked.
		// At this point we generate a Java class code.
		StringBuffer result = new StringBuffer();
		printClass(result);
		return result;
	}
	

	private void printClass(StringBuffer out) {
		out.append(packageDecl).append("\n");
		for (String importDecl : importDecls)
			out.append(importDecl).append("\n");
		out.append("import cool.runtime.*;\n\n");
		String classNames = "";
		for (String tgtClName : targetClassNames)
			classNames = "," + tgtClName;
		classNames = classNames.substring(1);

		out.append("@COOLAspect(className=\"").append(classNames).append("\")");
		out.append("\n");
		out.append("@org.aspectj.lang.annotation.Aspect");
		out.append("\n");
		out.append("public class " + getCoordinatorClassName() + " {\n");
		renderDeclaredFields(out);
		renderSyntheticMembers(out);
		out.append("\n}");
	}

	private void renderDeclaredFields(StringBuffer out) {
		for (CoolVar field : fields) {
			if (field.isCondition())
				out.append("private @COOLConditionField ");
			else
				out.append("private @COOLCoordinatorField ");
			out.append(field.getType().toString()).append(" ");
			out.append(field.getName());
			if (field.getInitExpr()!=null)
				out.append(" = ").append(Utils.render(field.getInitExpr()));
			out.append(";\n");
		}
	}

	private void renderSyntheticMembers(StringBuffer out) {
		NodePrinter renderer = new NodePrinter(out, "  ", typeChecker, targetClassNames.get(0));
		// generating methods for all method managers, and storing
		// them in the managerMethods buffer
		StringBuffer managerMethods = new StringBuffer();
		Map<String, Map<Node, String>> reqMeths = renderMethodManagers(meth2req,
				MethodManagerType.REQUIRES, renderer, managerMethods);
		Map<String, Map<Node, String>> entryMeths = renderMethodManagers(meth2entry,
				MethodManagerType.ON_ENTRY, renderer, managerMethods);
		Map<String, Map<Node, String>> exitMeths = renderMethodManagers(meth2exit,
				MethodManagerType.ON_EXIT, renderer, managerMethods);

		// generating all MethodState fields.
		Map<String, String> meth2field = new HashMap<String, String>();
		int i = 0;
		for (String meth : targetMethods.keySet()) {
			MethodSig methSig = targetMethods.get(meth);
			String fName = "meth_" + methSig.methodName+"_"+i++;
			meth2field.put(meth, fName);
			out.append("\n  ").append("private MethodState ").append(fName);
			out.append(" = new MethodState();");
		}
		out.append("\n\n");

		// rendering lock and unlock methods
		for (String meth : targetMethods.keySet()) {
			renderLockMethod(meth, meth2field, reqMeths.get(meth), entryMeths.get(meth), renderer,
					out);
			out.append("\n");
			renderUnLockMethod(meth, meth2field, exitMeths.get(meth), renderer, out);
		}
		// adding manager methods to the output buffer
		out.append(managerMethods);
		// adding external reference methods
		out.append(renderer.getExternalRefMethods());

	}
	
	private String renderMethodSigAnnotation(String annTypeName, MethodSig methodSig) {
		StringBuffer out = new StringBuffer();
		out.append("@").append(annTypeName).append("(methodName=\"").append(methodSig.methodName).append("\"");
		out.append(", className=\"").append(methodSig.className).append("\"");
		out.append(", parameterTypes={");		
		String paramTypeList = "";
		for(String paramType:methodSig.paramTypes)
			paramTypeList=paramTypeList+",\""+paramType+"\"";
		if (paramTypeList.length()>0)
			out.append(paramTypeList.substring(1));
		out.append("})");
		return out.toString();
	}

	private StringBuffer renderLockMethod(String targetMeth,
			Map<String, String> meth2field, Map<Node, String> reqMeths,
			Map<Node, String> entryMeths, NodePrinter renderer, StringBuffer out) {
		String fName = meth2field.get(targetMeth);
		MethodSig methodSig = targetMethods.get(targetMeth);
		out.append("  ").append(renderMethodSigAnnotation("COOLLock", methodSig)).append("\n");
		out.append("  public synchronized void ").append(fName).append(
				"_lock(");
		out.append(targetClassNames.get(0)).append(" thiz) {\n");
		Set<String> mutexMeths = getMutexMethods(targetMeth);
		List<Node> reqNodes = meth2req.get(targetMeth);
		List<Node> onEntryNodes = meth2entry.get(targetMeth);
		// generating the while loop condition expression
		out.append("    while(false");
		String indent = "      ";
		// generating the selfex condition
		if (selfexSet.contains(targetMeth))
			out.append("\n").append(indent).append("|| ").append(fName).append(
					".isBusyByOtherThread()");
		// generating the mutex conditions
		if (mutexMeths != null)
			for (String mutexMeth : mutexMeths) {
				String mutexFName = meth2field.get(mutexMeth);
				out.append("\n").append(indent).append("|| ")
						.append(mutexFName).append(".isBusyByOtherThread()");
			}
		// generating the requires conditions
		if (reqNodes != null)
			for (Node reqNode : reqNodes)
				out.append("\n").append(indent).append("|| ").append("!").append(
						reqMeths.get(reqNode)).append("()");
		out.append(")");
		// the condition expression is generated. Generating the loop's body
		out.append("\n      try { wait(); } catch (InterruptedException e) {}");
		// generating on_entry method calls
		indent = "    ";
		if (onEntryNodes != null)
			for (Node node : onEntryNodes)
				out.append("\n" + indent).append(entryMeths.get(node)).append(
						"(thiz);");
		out.append("\n" + indent).append(fName).append(".in();");
		out.append("\n  }\n");
		return out;
	}

	private StringBuffer renderUnLockMethod(String targetMeth,
			Map<String, String> meth2field, Map<Node, String> exitMeths,
			NodePrinter renderer, StringBuffer out) {
		String fName = meth2field.get(targetMeth);
		MethodSig methodSig = targetMethods.get(targetMeth);
		out.append("  ").append(renderMethodSigAnnotation("COOLUnlock", methodSig)).append("\n");
		out.append("  public synchronized void ").append(fName).append(
				"_unlock(");
		out.append(targetClassNames.get(0)).append(" thiz) {");
		out.append("\n    ").append(fName).append(".out();");
		List<Node> onExitNodes = meth2exit.get(targetMeth);
		if (onExitNodes != null)
			for (Node node : onExitNodes)
				out.append("\n    ").append(exitMeths.get(node)).append(
						"(thiz);");
		out.append("\n    ").append("notifyAll();");
		out.append("\n  }\n");
		return out;
	}

	static enum MethodManagerType {
		REQUIRES("COOLRequires", "requires"), ON_ENTRY("COOLOnEntry",
				"on_entry"), ON_EXIT("COOLOnExit", "on_exit");

		private MethodManagerType(String annCName, String str) {
			this.annCName = annCName;
			this.str = str;
		}

		private final String annCName;

		private final String str;

		public String getAnnCName() {
			return annCName;
		}

		public String toString() {
			return str;
		}

	}

	/**
	 * Renders all method manager nodes (a requires expression, on_entry
	 * statement, or on_exit statement) in meth2node as Java methods in the
	 * coordinator class. Stores method declarations in the <code>out</code>
	 * buffer. Returns a map that associates the processed manager nodes with
	 * names of the generated target Java methods.
	 * 
	 * @param managerNodes
	 *            a list of source requires expressions or on_entry/on_exit
	 *            statements
	 * @param node2mname
	 * @param managerType
	 *            type of the manager node being generated.
	 * @param renderer
	 *            a renderer that translates expression nodes into strings
	 * @param out
	 *            a placeholder for the generated Java method declarations.
	 * @return mapping of the processed manager nodes to names of the
	 *         corresponding Java methods (generated in the out buffer).
	 */
	private Map<String, Map<Node, String>> renderMethodManagers(
			Map<String, List<Node>> meth2node, MethodManagerType managerType,
			NodePrinter renderer, StringBuffer out) {
		
		Map<String, Map<Node, String>> tgtMethManagers = new HashMap<String, Map<Node, String>>();
		if (meth2node == null)
			return tgtMethManagers;
		for (String tgtMName:meth2node.keySet()) {
		  //obtaining a target method signature
		  MethodSig methodSig = targetMethods.get(tgtMName);
		  Map<Node, String> node2meth = tgtMethManagers.get(tgtMName);
		  if (node2meth==null) {
			  node2meth = new IdentityHashMap<Node, String>();
			  tgtMethManagers.put(tgtMName, node2meth);
		  }
		  List<Node> nodes = meth2node.get(tgtMName);
		  renderManagerMethods(nodes, methodSig, node2meth, managerType, renderer, out);
		}
		return tgtMethManagers;
	}

	/**
	 * Renders a list of method manager nodes (a requires expression, on_entry
	 * statement, or on_exit statement) as Java methods in the coordinator
	 * class.
	 * 
	 * @param managerNodes
	 *            a list of source requires expressions or on_entry/on_exit
	 *            statements
	 * @param node2mname
	 *            already generated manager methods. The map associates the
	 *            processed manager nodes with names of the generated target
	 *            Java methods.
	 * @param managerType
	 *            type of the manager node being generated
	 * @param renderer
	 *            a renderer that translates expression nodes into strings
	 * @param out
	 *            a placeholder for the generated Java method declarations
	 */
	private void renderManagerMethods(List<Node> managerNodes,
			MethodSig methodSig,
			Map<Node, String> node2mname, MethodManagerType managerType,
			NodePrinter renderer, StringBuffer out) {
		if (managerNodes == null)
			return;
		if (managerNodes != null)
			for (Node node : managerNodes) {
				String mName = node2mname.get(node);
				if (mName == null) {
					mName = managerType.toString() + "_"+methodSig.methodName+"_"+methodSig.hashCode()+"_"+ node2mname.size();
					out.append(renderManagerMethod(node, methodSig, mName, managerType,
							renderer));
					node2mname.put(node, mName);
				}
			}
	}

	/**
	 * Renders a method manager's node (a requires expression, on_entry
	 * statement, or on_exit statement) as a Java method in the coordinator
	 * class.
	 * 
	 * @param managerNode
	 *            a source requires expression or on_entry/on_exit statement
	 * @param mName
	 *            a name of the target Java method (i.e., method being generated
	 *            in the coordinator class).
	 * @param managerType 
	 *            specifies a type of the node (e.g., requires, on_entry, ot on_exit)           
	 * @param renderer
	 *            a renderer that translates expression nodes into strings
	 * @return a buffer with a generated Java method declaration
	 */
	private StringBuffer renderManagerMethod(Node managerNode, MethodSig methodSig, String mName,
			MethodManagerType managerType, NodePrinter renderer) {
		StringBuffer out = new StringBuffer();
		boolean isRequires = (managerType == MethodManagerType.REQUIRES);
		StringBuffer nodeBuffer = new StringBuffer();
		// printing the node's string into the nodeBuffer
		renderer.renderIntoBuffer(managerNode, nodeBuffer, "  ");
		out.append("  ").append(renderMethodSigAnnotation(managerType.getAnnCName(), methodSig)).append("\n");
		if (isRequires)
			out.append("  private boolean ").append(mName).append("() ");
		else {
			out.append("  private void ").append(mName).append("(");
			out.append(targetClassNames.get(0)).append(" thiz) ");
		}
		boolean isBlockStmnt = managerNode instanceof ASTBlockStmnt;
		if (!isBlockStmnt) out.append("{\n").append("    ");
		if (isRequires)
			out.append("return ");
		out.append(nodeBuffer);
		if (!isBlockStmnt) out.append(";\n").append("  }\n");
		return out;
	}

	private Set<String> getMutexMethods(String targetMeth) {
		Set<String> mutexMeths = new HashSet<String>();
		for (Set<String> mutexSet : mutexSets)
			if (mutexSet.contains(targetMeth))
				mutexMeths.addAll(mutexSet);
		mutexMeths.remove(targetMeth);
		return mutexMeths;
	}

	public String getCoordinatorClassName() {
		StringBuffer result = new StringBuffer();
		for (String tgtClName : targetClassNames) {
			int lastDot = tgtClName.lastIndexOf(".");
			if (lastDot > 0)
				tgtClName = tgtClName.substring(lastDot + 1);
			result.append("_").append(tgtClName);
		}
		result.append("Coord");
		return result.substring(1);
	}
	
	public String getPackageName() {
		if (packageDecl==null || packageDecl.length()==0)
			return "default";
		else
		    return packageDecl.substring(8, packageDecl.length()-1);
	}

	public void checkType(Node node, CoolVarEnv venv) throws Exception {
		if (node instanceof ASTLabeledStmnt)
			checkType(node.jjtGetChild(1), venv);
		else if (node instanceof ASTBlockStmnt)
			checkType((ASTBlockStmnt) node, venv);
		else if (node instanceof ASTIfStmnt)
			checkType((ASTIfStmnt) node, venv);
		else if (node instanceof ASTSwitchStmnt)
			checkType((ASTSwitchStmnt) node, venv);
		else if (node instanceof ASTWhileStmnt)
			checkType((ASTWhileStmnt) node, venv);
		else if (node instanceof ASTDoStmnt)
			checkType((ASTDoStmnt) node, venv);
		else if (node instanceof ASTForStmnt)
			checkType((ASTForStmnt) node, venv);
		else if (node instanceof ASTAssignExpr)
			typeChecker.getType(node, venv, CoolTypeRestriction.ANY);
	}

	private void checkType(ASTForStmnt node, CoolVarEnv venv) throws Exception {
		int chNum = node.jjtGetNumChildren();
		int nextPos = 0;
		Node child = node.jjtGetChild(nextPos++);
		if (child instanceof ASTForInit) {
			int initChNum = child.jjtGetNumChildren();
			for (int i = 0; i < initChNum; i++) {
				Node forInitChild = child.jjtGetChild(i);
				if (forInitChild instanceof ASTFieldDecl) {
					venv = new CoolVarEnv(venv);
					addFields((ASTFieldDecl) forInitChild, venv);
				} else if (forInitChild instanceof ASTAssignExpr)
					typeChecker.getType(forInitChild, venv,
							CoolTypeRestriction.ANY);
			}
			child = node.jjtGetChild(nextPos++);
		}
		if (node.hasConditionExpr()) {
			typeChecker.getType(child, venv, CoolTypeRestriction.BOOLEAN);
			nextPos++;
		}
		for (int i = nextPos - 1; i < chNum - 1; i++) {
			child = node.jjtGetChild(i);
			typeChecker.getType(child, venv, CoolTypeRestriction.ANY);
		}
		checkType(node.jjtGetChild(chNum - 1), venv);
	}

	private void checkType(ASTWhileStmnt node, CoolVarEnv venv)
			throws Exception {
		int chNum = node.jjtGetNumChildren();
		typeChecker.getType(node.jjtGetChild(0), venv,
				CoolTypeRestriction.BOOLEAN);
		checkType(node.jjtGetChild(1), venv);
	}

	private void checkType(ASTDoStmnt node, CoolVarEnv venv) throws Exception {
		int chNum = node.jjtGetNumChildren();
		checkType(node.jjtGetChild(0), venv);
		typeChecker.getType(node.jjtGetChild(1), venv,
				CoolTypeRestriction.BOOLEAN);
	}

	private void checkType(ASTSwitchStmnt node, CoolVarEnv venv)
			throws Exception {
		int chNum = node.jjtGetNumChildren();
		CoolTypeRestriction switchRestr = new CoolTypesRestriction(
				new CoolPrimType[] { CoolType.BYTE, CoolType.CHAR, CoolType.SHORT,
						CoolType.INT });
		CoolType switchType = typeChecker.getType(node.jjtGetChild(0), venv,
				switchRestr);
		CoolTypeRestriction caseRestr =
			typeChecker.getRestrictionForType(switchType, CoolTypeChecker.ConversionType.NARROWER_THAN);
			//new CoolTypesRestriction(
			//	new CoolPrimType[] { switchType });
		for (int i = 1; i < chNum; i++) {
			ASTCaseBlock caseBlock = (ASTCaseBlock) node.jjtGetChild(i);
			int nextPos = 0;
			if (!caseBlock.isDefault())
				typeChecker.getType(caseBlock.jjtGetChild(nextPos++), venv,
						caseRestr);
			checkType(caseBlock.jjtGetChild(nextPos), venv);
		}
	}

	private void checkType(ASTIfStmnt node, CoolVarEnv venv) throws Exception {
		int chNum = node.jjtGetNumChildren();
		//System.out.println("checking type of "+Utils.render(node.jjtGetChild(0)));
		typeChecker.getType(node.jjtGetChild(0), venv,
				CoolTypeRestriction.BOOLEAN);
		checkType(node.jjtGetChild(1), venv);
		if (chNum == 3)
			checkType(node.jjtGetChild(2), venv);
	}

	private void checkType(ASTBlockStmnt node, CoolVarEnv venv)
			throws Exception {
		int chNum = node.jjtGetNumChildren();
		for (int i = 0; i < chNum; i++) {
			Node child = node.jjtGetChild(i);
			if (child instanceof ASTFieldDecl) {
				venv = new CoolVarEnv(venv);
				addFields((ASTFieldDecl) child, venv);
			} else {
				checkType(child, venv);
			}
		}
	}

	private void initEnv(ASTCoordinationSpec coordSpec) throws Exception {
		fieldEnv = buildFieldEnv(coordSpec);
		fields.addAll(fieldEnv.getCoolVars());

		int chNum = coordSpec.jjtGetNumChildren();
		for (int i = 0; i < chNum; i++) {
			Node child = coordSpec.jjtGetChild(i);
			if (child instanceof ASTSelfexDecl)
				selfexSet.addAll(getMethods(child));
			else if (child instanceof ASTMutexDecl)
				mutexSets.add(getMethods(child));
			else if (child instanceof ASTMethodManagerDecl)
				processMethodManagerDecl(child);
		}
	}

	private void processMethodManagerDecl(Node node) throws Exception {
		//System.out.println("in processMethodManagerDecl:");
		//fieldEnv.printCoolVars();
		int chNum = node.jjtGetNumChildren();
		Set<String> methods = new HashSet<String>();
		for (int i = 0; i < chNum; i++) {
			Node child = node.jjtGetChild(i);
			if (child instanceof ASTMethodName) {
				MethodSig methodSig = new MethodSig((ASTMethodName)child);
				targetMethods.put(methodSig.signature, methodSig);
				methods.add(methodSig.signature);
			} else if (child instanceof ASTRequires) {
				Node reqExpr = child.jjtGetChild(0);
				typeChecker.getType(reqExpr, fieldEnv,
						CoolTypeRestriction.BOOLEAN);
				mapNodeToMethods(methods, child.jjtGetChild(0), meth2req);
			} else if (child instanceof ASTOnEntry) {
				Node stmnt = child.jjtGetChild(0);
				this.checkType(stmnt, fieldEnv);
				mapNodeToMethods(methods, child.jjtGetChild(0), meth2entry);
			} else if (child instanceof ASTOnExit) {
				Node stmnt = child.jjtGetChild(0);
				this.checkType(stmnt, fieldEnv);
				mapNodeToMethods(methods, child.jjtGetChild(0), meth2exit);
			}
		}
	}

	private void mapNodeToMethods(Set<String> methods, Node node,
			Map<String, List<Node>> mapping) {
		for (String method : methods) {
			List<Node> nodes = mapping.get(method);
			if (nodes == null) {
				nodes = new ArrayList<Node>();
				mapping.put(method, nodes);
			}
			nodes.add(node);
		}
	}

	private Set<String> getMethods(Node node) throws Exception {
		Set<String> result = new HashSet<String>();
		int chNum = node.jjtGetNumChildren();
		for (int i = 0; i < chNum; i++) {
			MethodSig methodSig = new MethodSig((ASTMethodName)node.jjtGetChild(i));
			targetMethods.put(methodSig.signature, methodSig);
			result.add(methodSig.signature);
		}
		return result;
	}

	private CoolVarEnv buildFieldEnv(ASTCoordinationSpec coordSpec)
			throws Exception {
		CoolVarEnv result = new CoolVarEnv(null);
		int chNum = coordSpec.jjtGetNumChildren();
		for (int i = 0; i < chNum; i++) {
			Node child = coordSpec.jjtGetChild(i);
			if (child instanceof ASTFieldDecl) {
				addFields((ASTFieldDecl) child, result);
			} else if (child instanceof ASTCondFieldDecl) {
				addCondFields((ASTCondFieldDecl)child, result);
			}
		}
		return result;
	}

	private void addFields(ASTFieldDecl decl, CoolVarEnv venv) throws Exception {
		ASTType fieldsType = (ASTType) decl.jjtGetChild(0);
		CoolType baseType = getCoolType(fieldsType);
		int chNum = decl.jjtGetNumChildren();
		for (int i = 1; i < chNum; i++) {
			venv.addCoolVar(getCoolVar((ASTVarInit) decl.jjtGetChild(i),
					baseType));
		}
	}

	private void addCondFields(ASTCondFieldDecl decl, CoolVarEnv venv)
			throws Exception {
		CoolType baseType = CoolType.BOOLEAN;
		int chNum = decl.jjtGetNumChildren();
		for (int i = 0; i < chNum; i++) {
			CoolVar var = getCoolVar((ASTVarInit) decl.jjtGetChild(i), baseType);
			var.setIsCondition(true);
			venv.addCoolVar(var);
		}
	}

	private CoolType getCoolType(ASTType type) throws Exception {
		if (!type.isPrimitive()) {
			//System.out.println("Not primitive type:"+Utils.render(type));
			return null;
		}
		String typeName = ((ASTAtom) type.jjtGetChild(0)).getValue();
		CoolPrimType baseType = CoolPrimType.getPrimType(typeName);
		int dims = type.getDimensionsNum();
		if (dims == 0)
			return baseType;
		else
			return new CoolArrayType(baseType, dims);
	}

	private CoolVar getCoolVar(ASTVarInit vinit, CoolType baseType) {
		String varName = ((ASTAtom) vinit.jjtGetChild(0)).getValue();
		int dimsNum = vinit.getDimensionsNum();
		CoolType varType = baseType;
		if (dimsNum > 0) {
			if (baseType.isArray()) {
				CoolArrayType baseArrType = (CoolArrayType) baseType;
				varType = new CoolArrayType(baseArrType.getElType(), dimsNum
						+ baseArrType.getDimsNum());
			} else
				varType = new CoolArrayType((CoolPrimType) baseType, dimsNum);
		}
		Node init = (vinit.jjtGetNumChildren() > 1) ? vinit.jjtGetChild(1)
				: null;
		CoolVar result = new CoolVar(varType, varName, init);
		return result;
	}
	
	private static class MethodSig {
		String className;
		String methodName;
		String[] paramTypes;
		String signature;
		
		MethodSig(ASTMethodName methodNode) throws Exception {
			initNames(methodNode);
			initParamTypes(methodNode);
			signature = (className.length()>0) ? className+"." : "";
			signature = signature + methodName + "(";
			String params = "";
			for(String param:paramTypes)
				params=params+","+param;
			if (params.length()>0)
				signature=signature+params.substring(1);
			signature=signature+")";
		}
		
		private void initNames(ASTMethodName methodNode) throws Exception {
			Node node = methodNode.jjtGetChild(0);
			int chNum = node.jjtGetNumChildren();
			className ="";
			methodName = "";
			for (int i=0;i<chNum-2;i++) 
				className = className+"."+Utils.getAtomVal(node.jjtGetChild(i));
			if (className.length()>0)
				className = className.substring(1);
			methodName = Utils.getAtomVal(node.jjtGetChild(chNum-1));
		}
		
		private void initParamTypes(ASTMethodName methodNode) {
			List<String> result = new ArrayList<String>();
			int chNum = methodNode.jjtGetNumChildren();
			for (int i=1;i<chNum;i++)
				result.add(Utils.render(methodNode.jjtGetChild(i)));
			paramTypes = new String[result.size()];
			for(int i=0;i<result.size();i++) 
				paramTypes[i]=result.get(i);
		}
		
	}

}
