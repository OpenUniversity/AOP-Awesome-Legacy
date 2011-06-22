package cool.frontend.translator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import org.aspectj.weaver.Member;
import org.aspectj.weaver.ResolvedMember;
import org.aspectj.weaver.ResolvedType;

import cool.frontend.ast.Node;
import cool.frontend.ast.ASTAtom;

public class Utils {

	public static List<Node> getChildren(Node parent) {
		int chNum = parent.jjtGetNumChildren();
		return getChildren(parent, 0, chNum);
	}

	public static List<Node> getChildren(Node parent, int start, int end) {
		List<Node> result = new ArrayList<Node>();
		for (int i = start; i < end; i++) {
			result.add(parent.jjtGetChild(i));
		}
		return result;
	}

	public static String render(Node node) {
		try{
			StringBuffer out = new StringBuffer();
			NodePrinter.render(node, out, "");
			return out.toString();
		} catch (Exception e) {
			return node.toString();
		}
	}
	
	public static String getAtomVal(Node atomNode) throws Exception {
		if (!(atomNode instanceof ASTAtom))
			throw new Exception("Error in "+render(atomNode)+": not an atom node.");
		return ((ASTAtom)atomNode).getValue();
	}

}
