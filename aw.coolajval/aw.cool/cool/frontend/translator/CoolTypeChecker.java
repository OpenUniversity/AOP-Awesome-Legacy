package cool.frontend.translator;

import java.lang.reflect.Method;
import java.util.*;
import cool.frontend.ast.*;

public class CoolTypeChecker {
	private Map<ASTVarRef, CoolTypeRestriction> externalRefs = new IdentityHashMap<ASTVarRef, CoolTypeRestriction>();

	public boolean isExternalRef(ASTVarRef ref) {
		return externalRefs.containsKey(ref);
	}

	public CoolType getExternalRefType(ASTVarRef ref) {
		return externalRefs.get(ref).getWidestAllowedType();
	}

	public Set<ASTVarRef> getExternalRefs() {
		return externalRefs.keySet();
	}

	public CoolType getType(Node node, CoolVarEnv venv,
			CoolTypeRestriction restr) throws Exception {
		CoolType result;

		if ((node instanceof ASTCondOrExpr) || (node instanceof ASTCondOrExpr)
				|| (node instanceof ASTReqOrExpr)
				|| (node instanceof ASTReqAndExpr)) {
			result = getCondExprType(node, venv);
		} else if ((node instanceof ASTInclOrExpr)
				|| (node instanceof ASTExclOrExpr)
				|| (node instanceof ASTAndExpr)) {
			result = getIntegerOrBooleanOpType(node, venv, restr);
		} else if ((node instanceof ASTEqExpr)
				|| (node instanceof ASTReqEqExpr)) {
			result = getEqExprType(node, venv);
		} else if (node instanceof ASTRelExpr) {
			result = getRelExprType(node, venv);
		} else if (node instanceof ASTShiftExpr) {
			result = getMathOpType(node, venv, CoolTypeRestriction.INTEGER);
		} else if ((node instanceof ASTAddExpr)
				|| (node instanceof ASTMultExpr)) {
			result = getMathOpType(node, venv, CoolTypeRestriction.NUMBER);
		} else if (node instanceof ASTAtom) {
			result = getConstType(node);
		} else if (node instanceof ASTUnaryExpr) {
			result = getUnaryExprType(node, venv);
		} else if ((node instanceof ASTBracketExpr)
				|| (node instanceof ASTReqBracketExpr)) {
			result = getType(node.jjtGetChild(0), venv, restr);
		} else if (node instanceof ASTVarRef) {
			result = getVarRefType((ASTVarRef) node, venv, restr);
		} else if (node instanceof ASTAssignExpr) {
			result = getAssignExprType((ASTAssignExpr) node, venv, restr);
		} else if (node instanceof ASTReqNegExpr) {
			result = getType(node.jjtGetChild(0), venv,
					CoolTypeRestriction.BOOLEAN);
		} else if (node instanceof ASTReqVarRef) {
			result = getReqVarRefType(node, venv);
		} else if (node instanceof ASTInitArr) {
			result = getInitArrType(node, venv, restr);
		} else
			throw new Exception("Unhandled node type: " + Utils.render(node));

		if (!restr.satisfies(result))
			throw new Exception("Unexpected type of: " + Utils.render(node)
					+ "," + "inferred type = " + result + ", expected type = "
					+ restr);
		return result;
	}

	private CoolType getAssignExprType(ASTAssignExpr node, CoolVarEnv venv,
			CoolTypeRestriction restr) throws Exception {
		String type = node.getAssignType();
		if (type == null)
			type = "normal";
		if (type.equals("prefix") || type.equals("postfix")) {
			Node operand = node.jjtGetChild((type.equals("prefix")) ? 0 : 1);
			return getType(operand, venv, CoolTypeRestriction.NUMBER);
		} else {
			Node varNode = node.jjtGetChild(0);
			Node valNode = node.jjtGetChild(1);
			CoolType varType = getType(varNode, venv, restr);
			// if the type of the variable is known, then...
			if (!(varType instanceof CoolUnknownType)) {
				getAssignRHSExpType(varType, valNode, venv);
			} else {
				// if variable reference is external access,
				// then we have a compile-time error!
				throw new Exception("Error in " + Utils.render(node)
						+ ": cannot assign values to external fields ");
			}
			return varType;
		}
	}

	protected CoolType getAssignRHSExpType(CoolType varType, Node valNode,
			CoolVarEnv venv) throws Exception {
		CoolTypeRestriction valRestr;
		CoolType valType;
		// the expression is not a constant
		if (!(valNode instanceof ASTAtom)) {
			// type of the variable can be wider then the type of the value
			// expression
			valRestr = getRestrictionForType(varType,
					ConversionType.NARROWER_THAN);
			valType = getType(valNode, venv, valRestr);
		} else { // if the expression is a constant
			valRestr = getRestrictionForType(varType,
					ConversionType.ASSIGN_TO_CONST);
			valType = getType(valNode, venv, valRestr);
		}
		return valType;
	}

	static enum ConversionType {
		NARROWER_THAN, WIDER_THAN, ASSIGN_TO_CONST
	}

	protected CoolTypeRestriction getRestrictionForType(CoolType type,
			ConversionType conversionType) throws Exception {
		if (type.isBoolean())
			// that is the only permitted conversion
			// independently of a conversion type
			return CoolTypeRestriction.BOOLEAN;
		else if (type.isArray())
			return new CoolArrayTypeRestriction((CoolArrayType) type);
		else if (type instanceof CoolUnknownType)
			return CoolTypeRestriction.ANY;
		else if (type instanceof CoolPrimType) {
			CoolPrimType primType = (CoolPrimType) type;
			CoolPrimType[] types = null;
			if (conversionType == ConversionType.ASSIGN_TO_CONST) {
				if (primType.isSameAs(CoolType.BYTE))
					types = new CoolPrimType[] { CoolType.BYTE, CoolType.CHAR };
				else if (primType.isSameAs(CoolType.CHAR))
					types = new CoolPrimType[] { CoolType.BYTE, CoolType.CHAR,
							CoolType.SHORT };
				else if (primType.isSameAs(CoolType.SHORT))
					types = new CoolPrimType[] { CoolType.BYTE, CoolType.CHAR,
							CoolType.SHORT };
				if (primType.isSameAs(CoolType.DOUBLE))
					types = new CoolPrimType[] { CoolType.BYTE, CoolType.CHAR,
							CoolType.SHORT, CoolType.INT, CoolType.LONG,
							CoolType.FLOAT, CoolType.DOUBLE };
				else if (primType.isSameAs(CoolType.FLOAT))
					types = new CoolPrimType[] { CoolType.BYTE, CoolType.CHAR,
							CoolType.SHORT, CoolType.INT, CoolType.LONG,
							CoolType.FLOAT };
				else if (primType.isSameAs(CoolType.LONG))
					types = new CoolPrimType[] { CoolType.BYTE, CoolType.CHAR,
							CoolType.SHORT, CoolType.INT, CoolType.LONG };
				else if (primType.isSameAs(CoolType.INT))
					types = new CoolPrimType[] { CoolType.BYTE, CoolType.CHAR,
							CoolType.SHORT, CoolType.INT };
			} else if (conversionType == ConversionType.NARROWER_THAN) {
				if (primType.isSameAs(CoolType.DOUBLE))
					types = new CoolPrimType[] { CoolType.BYTE, CoolType.CHAR,
							CoolType.SHORT, CoolType.INT, CoolType.LONG,
							CoolType.FLOAT, CoolType.DOUBLE };
				else if (primType.isSameAs(CoolType.FLOAT))
					types = new CoolPrimType[] { CoolType.BYTE, CoolType.CHAR,
							CoolType.SHORT, CoolType.INT, CoolType.LONG,
							CoolType.FLOAT };
				else if (primType.isSameAs(CoolType.LONG))
					types = new CoolPrimType[] { CoolType.BYTE, CoolType.CHAR,
							CoolType.SHORT, CoolType.INT, CoolType.LONG };
				else if (primType.isSameAs(CoolType.INT))
					types = new CoolPrimType[] { CoolType.BYTE, CoolType.CHAR,
							CoolType.SHORT, CoolType.INT };
				else if (primType.isSameAs(CoolType.SHORT))
					types = new CoolPrimType[] { CoolType.BYTE, CoolType.SHORT };
				else if (primType.isSameAs(CoolType.CHAR))
					types = new CoolPrimType[] { CoolType.CHAR };
				else if (primType.isSameAs(CoolType.BYTE))
					types = new CoolPrimType[] { CoolType.BYTE };
			} else if (conversionType == ConversionType.WIDER_THAN) {
				if (primType.isSameAs(CoolType.BYTE))
					types = new CoolPrimType[] { CoolType.BYTE, CoolType.SHORT,
							CoolType.INT, CoolType.LONG, CoolType.FLOAT,
							CoolType.DOUBLE };
				else if (primType.isSameAs(CoolType.CHAR))
					types = new CoolPrimType[] { CoolType.CHAR, CoolType.INT,
							CoolType.LONG, CoolType.FLOAT, CoolType.DOUBLE };
				else if (primType.isSameAs(CoolType.SHORT))
					types = new CoolPrimType[] { CoolType.SHORT, CoolType.INT,
							CoolType.LONG, CoolType.FLOAT, CoolType.DOUBLE };
				else if (primType.isSameAs(CoolType.INT))
					types = new CoolPrimType[] { CoolType.INT, CoolType.LONG,
							CoolType.FLOAT, CoolType.DOUBLE };
				else if (primType.isSameAs(CoolType.LONG))
					types = new CoolPrimType[] { CoolType.LONG, CoolType.FLOAT,
							CoolType.DOUBLE };
				else if (primType.isSameAs(CoolType.FLOAT))
					types = new CoolPrimType[] { CoolType.FLOAT,
							CoolType.DOUBLE };
				else if (primType.isSameAs(CoolType.DOUBLE))
					types = new CoolPrimType[] { CoolType.DOUBLE };
			}
			if (types != null)
				return new CoolTypesRestriction(types);
		}
		throw new Exception("Unknown type: " + type);
	}

	/**
	 * Computes the type of a variable reference expression, and checks types of
	 * its subexpressions. If <code>node</code> is an external variable
	 * reference (reference to a field of a coordinated object) and type
	 * restriction <code>restr</code> is <code>ANY</code>, then returns
	 * <code>CoolType.UNKNOWN</code>. Overall, for the extrnal references,
	 * the type is inferred from the restriction. This is the ONLY expression
	 * that can return UNKNOWN (except from ASTBracketExpr, that may contain
	 * this expression). In all other cases computes and returns the actual type
	 * of the variable reference expression.
	 */
	private CoolType getVarRefType(ASTVarRef node, CoolVarEnv venv,
			CoolTypeRestriction restr) throws Exception {
		CoolType result;
		String varName = ((ASTAtom) node.jjtGetChild(0)).getValue();
		// System.out.println("looking up a var:"+varName+", typeChecker =
		// "+this);
		CoolVar var;
		try {
			var = venv.lookupCoordVar(varName);
			// System.out.println("Found var:"+var.getName());
		} catch (Exception e) {
			// this is an external variable access
			externalRefs.put((ASTVarRef) node, restr);
			// ONLY HERE UNKNOWN TYPE CAN BE RETURNED, AND
			// ONLY IF restr == ANY
			return restr.getWidestAllowedType();
		}

		CoolType varType = var.getType();
		int dims = node.jjtGetNumChildren() - 1;
		if (((ASTVarRef) node).isComplex())
			dims = dims - 1;
		ASTVarRef field = null;
		if (node.isComplex())
			field = (ASTVarRef) node.jjtGetChild(node.jjtGetNumChildren() - 1);

		// Calculating the type of the prefix:
		CoolType prefixType;
		if (varType.isArray()) {
			CoolArrayType varArrType = (CoolArrayType) varType;
			if (dims < varArrType.getDimsNum()) {
				prefixType = new CoolArrayType(varArrType.getElType(), dims);
			} else if (dims == varArrType.getDimsNum()) {
				prefixType = varArrType.getElType();
			} else
				// if number of dims is more than that of declared var
				throw new Exception("Incorrect number of array dimensions "
						+ "in the variable reference expression "
						+ Utils.render(node) + " : " + varName
						+ " is defined as " + dims + "-dimentional array.");
		} else {
			if (dims > 0)
				throw new Exception("Error in " + Utils.render(node) + " : "
						+ varName + "is not an array.");
			else
				prefixType = varType;
		}

		// calculating the type of the whole expression:
		CoolType refType;

		if (field != null) {
			if (!prefixType.isArray()) {
				throw new Exception("Error in " + Utils.render(node) + " : "
						+ "a primitive type " + prefixType
						+ " cannot have a field " + Utils.render(field));
			} else {
				String fieldName = ((ASTAtom) field.jjtGetChild(0)).getValue();
				if (fieldName.equals("length")
						&& field.jjtGetNumChildren() == 1)
					refType = CoolType.INT;
				else
					throw new Exception("Error in " + Utils.render(node)
							+ " : " + "invalid array field "
							+ Utils.render(field));
			}
		} else {
			refType = prefixType;
		}
		// verifying array index expressions
		for (int i = 1; i <= dims; i++)
			// cannot return UNKNOWN
			getType(node.jjtGetChild(i), venv, CoolTypeRestriction.INTEGER);

		return refType;
	}

	private CoolType getCondExprType(Node node, CoolVarEnv venv)
			throws Exception {
		CoolType result = CoolType.BOOLEAN;
		for (int i = 0; i < node.jjtGetNumChildren(); i++)
			// cannot return UNKNOWN
			getType(node.jjtGetChild(i), venv, CoolTypeRestriction.BOOLEAN);
		return result;
	}

	private CoolType getEqExprType(Node node, CoolVarEnv venv) throws Exception {
		CoolType result = CoolType.BOOLEAN;
		// ONLY here ANY restriction is used
		CoolTypeRestriction childRestr = CoolTypeRestriction.ANY;
		for (int i = 0; i < node.jjtGetNumChildren(); i = i + 2) {
			// System.out.println("i:"+i+", i%2="+i%2+", child
			// ="+Utils.render(node.jjtGetChild(i)));
			// !!! MAY return UNKNOWN
			CoolType childType = getType(node.jjtGetChild(i), venv,
					CoolTypeRestriction.ANY);
			// We find the first one that is NOT
			if (childType != CoolType.UNKNOWN) {
				if (childType.isArray()) {
					childRestr = new CoolArrayTypeRestriction(
							(CoolArrayType) childType);
					break;
				} else if (childType.isBoolean()) {
					childRestr = CoolTypeRestriction.BOOLEAN;
					break;
				} else if (childType.isNumber()) {
					childRestr = CoolTypeRestriction.NUMBER;
					break;
				}
			}
		}

		if (childRestr == CoolTypeRestriction.ANY)
			throw new Exception(
					"Error in "
							+ Utils.render(node)
							+ ": all operands are "
							+ "of unknown types. The expression must have at least one operand"
							+ " which type is known at translation time (compiler limitation).");
		for (int i = 0; i < node.jjtGetNumChildren(); i = i + 2) {
			getType(node.jjtGetChild(i), venv, childRestr);
		}
		return result;
	}

	private CoolType getRelExprType(Node node, CoolVarEnv venv)
			throws Exception {
		CoolType result = CoolType.BOOLEAN;
		CoolTypeRestriction childRestr = CoolTypeRestriction.NUMBER;
		for (int i = 0; i < node.jjtGetNumChildren(); i = i + 2)
			// cannot return UNKNOWN
			getType(node.jjtGetChild(i), venv, childRestr);
		return result;
	}

	private CoolType getMathOpType(Node node, CoolVarEnv venv,
			CoolTypeRestriction childRestr) throws Exception {
		CoolPrimType result = CoolType.BYTE;
		for (int i = 0; i < node.jjtGetNumChildren(); i = i + 2) {
			// cannot return UNKNOWN
			CoolType type = getType(node.jjtGetChild(i), venv, childRestr);
			if (type instanceof CoolPrimType)
				if (((CoolPrimType) type).isWiderThan(result))
					result = (CoolPrimType) type;
		}
		return result;
	}

	private CoolType getUnaryExprType(Node node, CoolVarEnv venv)
			throws Exception {
		CoolType result;
		CoolTypeRestriction childRestr;
		String unOp = ((ASTAtom) node.jjtGetChild(0)).getValue();
		Node opNode = node.jjtGetChild(1);
		if (unOp.equals("-")) {
			childRestr = CoolTypeRestriction.NUMBER;
		} else if (unOp.equals("~")) {
			childRestr = CoolTypeRestriction.INTEGER;
		} else if (unOp.equals("!")) {
			childRestr = CoolTypeRestriction.BOOLEAN;
		} else
			throw new Exception("Unknown operand '" + unOp + " in "
					+ Utils.render(node));
		return getType(opNode, venv, childRestr);
	}

	private CoolType getNewArrExprType(ASTNewArrExpr node, CoolVarEnv venv)
			throws Exception {
		int dims = node.jjtGetNumChildren() - 1;
		String typeName = ((ASTAtom) node.jjtGetChild(0)).getValue();

		CoolArrayType result = new CoolArrayType(CoolPrimType
				.getPrimType(typeName), dims);
		// checking types of array index expressions
		for (int i = 1; i <= dims; i++)
			// cannot return UNKNOWN
			getType(node.jjtGetChild(0), venv, CoolTypeRestriction.INTEGER);
		return result;
	}

	private CoolType getConstType(Node node) throws Exception {
		String value = ((ASTAtom) node).getValue();
		if (value != null) {
			if (value.equals("true") || value.equals("false"))
				return CoolType.BOOLEAN;
			try {
				long v = Long.parseLong(value);
				if (v <= Byte.MAX_VALUE)
					return CoolType.BYTE;
				if (v <= Short.MAX_VALUE)
					return CoolType.SHORT;
				if (v <= Integer.MAX_VALUE)
					return CoolType.INT;
				return CoolType.LONG;
			} catch (Exception e) {
			}
			try {
				double v = Double.parseDouble(value);
				if (v <= Float.MAX_VALUE)
					return CoolType.FLOAT;
				return CoolType.DOUBLE;
			} catch (Exception e) {
			}
		}
		throw new Exception("Error in " + Utils.render(node)
				+ " : not a valid constant expression. ");
	}

	private CoolType getReqVarRefType(Node node, CoolVarEnv venv)
			throws Exception {
		CoolType result;
		String varName = ((ASTAtom) node.jjtGetChild(0)).getValue();
		CoolVar var = null;
		// try {
		var = venv.lookupCoordVar(varName);
		// } catch (Exception e) {

		// }

		if (var == null || !var.isCondition())
			throw new Exception(
					"Error in "
							+ Utils.render(node)
							+ " : "
							+ varName
							+ " is not a condition variable. Only condition"
							+ " variables can be accessed within 'requires' expressions.");

		CoolType varType = var.getType();
		int dims = node.jjtGetNumChildren() - 1;

		// Calculating the type of the reference expression:
		CoolType resultType;
		if (varType.isArray()) {
			CoolArrayType varArrType = (CoolArrayType) varType;
			if (dims < varArrType.getDimsNum()) {
				resultType = new CoolArrayType(varArrType.getElType(), dims);
			} else if (dims == varArrType.getDimsNum()) {
				resultType = varArrType.getElType();
			} else
				// if number of dims is more than that of declared var
				throw new Exception("Incorrect number of array dimensions "
						+ "in the variable reference expression "
						+ Utils.render(node) + " : " + varName
						+ " is defined as " + dims + "-dimentional array.");
		} else {
			if (dims > 0)
				throw new Exception("Error in " + Utils.render(node) + " : "
						+ varName + "is not an array.");
			else
				resultType = varType;
		}

		// verifying array index expressions
		for (int i = 1; i <= dims; i++)
			// cannot return UNKNOWN
			getType(node.jjtGetChild(i), venv, CoolTypeRestriction.INTEGER);
		return resultType;
	}

	public CoolType getInitArrType(Node node, CoolVarEnv venv,
			CoolTypeRestriction restriction) throws Exception {
		CoolArrayTypeRestriction restr = (CoolArrayTypeRestriction) restriction;
		CoolType result = new CoolArrayType(restr.getElType(), restr
				.getDimsNum());
		CoolTypeRestriction childRestr = getRestrictionForType(restr
				.getElType(), ConversionType.NARROWER_THAN);
		if (restr.getDimsNum() > 1) {
			childRestr = new CoolArrayTypeRestriction(restr.getElType(), restr
					.getDimsNum() - 1);
		}
		int chNum = node.jjtGetNumChildren();
		for (int i = 0; i < chNum; i++)
			getType(node.jjtGetChild(i), venv, childRestr);
		return result;
	}

	private CoolType getIntegerOrBooleanOpType(Node node, CoolVarEnv venv,
			CoolTypeRestriction restr) throws Exception {
		if (restr == CoolTypeRestriction.ANY) {
			int chNum = node.jjtGetNumChildren();
			for (int i = 0; i < chNum; i++) {
				Node child = node.jjtGetChild(i);
				CoolType type = getType(child, venv, restr);
				if (type != CoolType.UNKNOWN) {
					if (type.isBoolean()) {
						restr = CoolTypeRestriction.BOOLEAN;
					} else if (type.isInteger()) {
						restr = CoolTypeRestriction.INTEGER;
					} else {
						throw new Exception("Error in " + Utils.render(node)
								+ ": operand " + Utils.render(child)
								+ " has unexpected type " + type + ", while "
								+ CoolTypeRestriction.BOOLEAN + " or "
								+ CoolTypeRestriction.INTEGER + " is expected.");
					}
					break;
				}
			}
			// this is passed from the ASTEqExpr.
			// This reports back to the ASTEqExpr checker that
			// a corresponding child is not checked properly...
			if (restr == CoolTypeRestriction.ANY)
				return CoolType.UNKNOWN;
			// throw new Exception("Error in " + Utils.render(node)
			// + ": types of all operands are unknown."
			// + " The expression must have at least one operand"
			// + " which type is known at translation time.");
		}

		CoolType[] resultTypes = { CoolType.BOOLEAN, CoolType.BYTE,
				CoolType.CHAR, CoolType.SHORT, CoolType.INT, CoolType.LONG };
		this.checkRestriction(node, resultTypes, restr);
		CoolPrimType result = (restr == CoolTypeRestriction.BOOLEAN) ? CoolType.BOOLEAN
				: CoolType.BYTE;
		int chNum = node.jjtGetNumChildren();
		for (int i = 0; i < chNum; i++) {
			CoolType type = getType(node.jjtGetChild(i), venv, restr);
			if (type instanceof CoolPrimType)
				if (((CoolPrimType) type).isWiderThan(result))
					result = (CoolPrimType) type;
		}
		return result;
	}

	private void checkRestriction(Node node, CoolType[] types,
			CoolTypeRestriction restriction) throws Exception {
		if (types == null)
			return;
		boolean satisfies = false;
		String typeNames = "";
		for (CoolType type : types) {
			typeNames = typeNames + ", " + type.toString();
			if (restriction.satisfies(type))
				satisfies = true;
		}
		typeNames = typeNames.substring(2);
		if (!satisfies) {
			throw new Exception("Unexpected type of: " + Utils.render(node)
					+ ", " + "possible types = " + typeNames
					+ ", expected type = " + restriction);
		}
	}

}
