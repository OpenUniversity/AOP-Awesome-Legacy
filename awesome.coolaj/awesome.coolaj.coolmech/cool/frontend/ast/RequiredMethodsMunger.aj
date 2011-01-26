package cool.frontend.ast;

public aspect RequiredMethodsMunger {
private String ASTAtom.value;
public void ASTAtom.setValue(String value) {this.value = value;}
public String ASTAtom.getValue() {return value;}

private boolean ASTCaseBlock.def=false;
public void ASTCaseBlock.setDefault(boolean value) {this.def = value;}
public boolean ASTCaseBlock.isDefault() {return def;}

private String ASTAssignExpr.assignType;
public void ASTAssignExpr.setAssignType(String value) {this.assignType = value;}
public String ASTAssignExpr.getAssignType() {return assignType;}

private boolean ASTGranularity.isClass=false;
public void ASTGranularity.setIsClass(boolean value) {this.isClass = value;}
public boolean ASTGranularity.isClass() {return isClass;}

private boolean ASTType.isPrimitive=true;
public void ASTType.setPrimitive(boolean value) {this.isPrimitive = value;}
public boolean ASTType.isPrimitive() {return isPrimitive;}

private int ASTType.dimensions=0;
public void ASTType.addDimension() {this.dimensions++;}
public int ASTType.getDimensionsNum() {return dimensions;}

private int ASTVarInit.dimensions=0;
public void ASTVarInit.addDimension() {this.dimensions++;}
public int ASTVarInit.getDimensionsNum() {return dimensions;}

private boolean ASTForStmnt.hasConditionExpr=false;
public void ASTForStmnt.setHasConditionExpr(boolean value) {this.hasConditionExpr = value;}
public boolean ASTForStmnt.hasConditionExpr() {return hasConditionExpr;}

private boolean ASTVarRef.complexExpr=false;
public void ASTVarRef.setComplex(boolean value) {this.complexExpr = value;}
public boolean ASTVarRef.isComplex() {return complexExpr;}

private boolean ASTImportDecl.hasTrailingStar=false;
public void ASTImportDecl.setTrailingStar(boolean value) {this.hasTrailingStar = value;}
public boolean ASTImportDecl.hasTrailingStar() {return hasTrailingStar;}

}
