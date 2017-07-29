/*
* generated by Xtext
*/
grammar InternalCool;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package xtext.cool.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package xtext.cool.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import xtext.cool.services.CoolGrammarAccess;

}

@parser::members {

 	private CoolGrammarAccess grammarAccess;
 	
    public InternalCoolParser(TokenStream input, CoolGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "CoordinatorDeclaration";	
   	}
   	
   	@Override
   	protected CoolGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleCoordinatorDeclaration
entryRuleCoordinatorDeclaration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCoordinatorDeclarationRule()); }
	 iv_ruleCoordinatorDeclaration=ruleCoordinatorDeclaration 
	 { $current=$iv_ruleCoordinatorDeclaration.current; } 
	 EOF 
;

// Rule CoordinatorDeclaration
ruleCoordinatorDeclaration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_granularity_0_0=	'per_class' 
    {
        newLeafNode(lv_granularity_0_0, grammarAccess.getCoordinatorDeclarationAccess().getGranularityPer_classKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getCoordinatorDeclarationRule());
	        }
       		setWithLastConsumed($current, "granularity", lv_granularity_0_0, "per_class");
	    }

)
)?	otherlv_1='coordinator' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getCoordinatorDeclarationAccess().getCoordinatorKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCoordinatorDeclarationAccess().getClassNameQualifiedNameParserRuleCall_2_0()); 
	    }
		lv_className_2_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCoordinatorDeclarationRule());
	        }
       		set(
       			$current, 
       			"className",
        		lv_className_2_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getCoordinatorDeclarationAccess().getBodyCoordinatorBodyParserRuleCall_3_0()); 
	    }
		lv_body_3_0=ruleCoordinatorBody		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCoordinatorDeclarationRule());
	        }
       		set(
       			$current, 
       			"body",
        		lv_body_3_0, 
        		"CoordinatorBody");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;





// Entry rule entryRuleCoordinatorBody
entryRuleCoordinatorBody returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCoordinatorBodyRule()); }
	 iv_ruleCoordinatorBody=ruleCoordinatorBody 
	 { $current=$iv_ruleCoordinatorBody.current; } 
	 EOF 
;

// Rule CoordinatorBody
ruleCoordinatorBody returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='{' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getCoordinatorBodyAccess().getLeftCurlyBracketKeyword_0());
    }
(
    {
        $current = forceCreateModelElement(
            grammarAccess.getCoordinatorBodyAccess().getCoordinatorBodyAction_1(),
            $current);
    }
)(	otherlv_2='condition' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getCoordinatorBodyAccess().getConditionKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCoordinatorBodyAccess().getCondVarsCondVarParserRuleCall_2_1_0()); 
	    }
		lv_condVars_3_0=ruleCondVar		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCoordinatorBodyRule());
	        }
       		add(
       			$current, 
       			"condVars",
        		lv_condVars_3_0, 
        		"CondVar");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4=',' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_2_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCoordinatorBodyAccess().getCondVarsCondVarParserRuleCall_2_2_1_0()); 
	    }
		lv_condVars_5_0=ruleCondVar		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCoordinatorBodyRule());
	        }
       		add(
       			$current, 
       			"condVars",
        		lv_condVars_5_0, 
        		"CondVar");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_6=';' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_2_3());
    }
)*(	otherlv_7='int' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getCoordinatorBodyAccess().getIntKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCoordinatorBodyAccess().getOrdVarsOrdVarParserRuleCall_3_1_0()); 
	    }
		lv_ordVars_8_0=ruleOrdVar		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCoordinatorBodyRule());
	        }
       		add(
       			$current, 
       			"ordVars",
        		lv_ordVars_8_0, 
        		"OrdVar");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_9=',' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_3_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCoordinatorBodyAccess().getOrdVarsOrdVarParserRuleCall_3_2_1_0()); 
	    }
		lv_ordVars_10_0=ruleOrdVar		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCoordinatorBodyRule());
	        }
       		add(
       			$current, 
       			"ordVars",
        		lv_ordVars_10_0, 
        		"OrdVar");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_11=';' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_3_3());
    }
)*(	otherlv_12='selfex' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getCoordinatorBodyAccess().getSelfexKeyword_4_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsQualifiedNameParserRuleCall_4_1_0()); 
	    }
		lv_selfexMethods_13_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCoordinatorBodyRule());
	        }
       		add(
       			$current, 
       			"selfexMethods",
        		lv_selfexMethods_13_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_14=',' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_4_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsQualifiedNameParserRuleCall_4_2_1_0()); 
	    }
		lv_selfexMethods_15_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCoordinatorBodyRule());
	        }
       		add(
       			$current, 
       			"selfexMethods",
        		lv_selfexMethods_15_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_16=';' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_4_3());
    }
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getCoordinatorBodyAccess().getMutexSetsMutexSetParserRuleCall_5_0()); 
	    }
		lv_mutexSets_17_0=ruleMutexSet		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCoordinatorBodyRule());
	        }
       		add(
       			$current, 
       			"mutexSets",
        		lv_mutexSets_17_0, 
        		"MutexSet");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getCoordinatorBodyAccess().getGuardsGuardParserRuleCall_6_0()); 
	    }
		lv_guards_18_0=ruleGuard		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCoordinatorBodyRule());
	        }
       		add(
       			$current, 
       			"guards",
        		lv_guards_18_0, 
        		"Guard");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_19='}' 
    {
    	newLeafNode(otherlv_19, grammarAccess.getCoordinatorBodyAccess().getRightCurlyBracketKeyword_7());
    }
)
;





// Entry rule entryRuleGuard
entryRuleGuard returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getGuardRule()); }
	 iv_ruleGuard=ruleGuard 
	 { $current=$iv_ruleGuard.current; } 
	 EOF 
;

// Rule Guard
ruleGuard returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((	otherlv_0='guard' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getGuardAccess().getGuardKeyword_0());
    }
)?(
(
		lv_methods_1_0=RULE_ID
		{
			newLeafNode(lv_methods_1_0, grammarAccess.getGuardAccess().getMethodsIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGuardRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"methods",
        		lv_methods_1_0, 
        		"ID");
	    }

)
)(	otherlv_2=',' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getGuardAccess().getCommaKeyword_2_0());
    }
(
(
		lv_methods_3_0=RULE_ID
		{
			newLeafNode(lv_methods_3_0, grammarAccess.getGuardAccess().getMethodsIDTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGuardRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"methods",
        		lv_methods_3_0, 
        		"ID");
	    }

)
))*	otherlv_4=':' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getGuardAccess().getColonKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGuardAccess().getRequiresRequiresParserRuleCall_4_0()); 
	    }
		lv_requires_5_0=ruleRequires		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGuardRule());
	        }
       		set(
       			$current, 
       			"requires",
        		lv_requires_5_0, 
        		"Requires");
	        afterParserOrEnumRuleCall();
	    }

)
)?(	otherlv_6='on_entry' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getGuardAccess().getOn_entryKeyword_5_0());
    }
	otherlv_7='{' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getGuardAccess().getLeftCurlyBracketKeyword_5_1());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getGuardAccess().getOnEntryIfStatementsIfStatementParserRuleCall_5_2_0_0()); 
	    }
		lv_onEntryIfStatements_8_0=ruleIfStatement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGuardRule());
	        }
       		add(
       			$current, 
       			"onEntryIfStatements",
        		lv_onEntryIfStatements_8_0, 
        		"IfStatement");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getGuardAccess().getOnEntryAssignStatementsAssignStatementParserRuleCall_5_2_1_0()); 
	    }
		lv_onEntryAssignStatements_9_0=ruleAssignStatement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGuardRule());
	        }
       		add(
       			$current, 
       			"onEntryAssignStatements",
        		lv_onEntryAssignStatements_9_0, 
        		"AssignStatement");
	        afterParserOrEnumRuleCall();
	    }

)
))+	otherlv_10='}' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getGuardAccess().getRightCurlyBracketKeyword_5_3());
    }
)?(	otherlv_11='on_exit' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getGuardAccess().getOn_exitKeyword_6_0());
    }
	otherlv_12='{' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getGuardAccess().getLeftCurlyBracketKeyword_6_1());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getGuardAccess().getOnExitIfStatementsIfStatementParserRuleCall_6_2_0_0()); 
	    }
		lv_onExitIfStatements_13_0=ruleIfStatement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGuardRule());
	        }
       		add(
       			$current, 
       			"onExitIfStatements",
        		lv_onExitIfStatements_13_0, 
        		"IfStatement");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |(
(
		{ 
	        newCompositeNode(grammarAccess.getGuardAccess().getOnExitAssignStatementsAssignStatementParserRuleCall_6_2_1_0()); 
	    }
		lv_onExitAssignStatements_14_0=ruleAssignStatement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGuardRule());
	        }
       		add(
       			$current, 
       			"onExitAssignStatements",
        		lv_onExitAssignStatements_14_0, 
        		"AssignStatement");
	        afterParserOrEnumRuleCall();
	    }

)
))+	otherlv_15='}' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getGuardAccess().getRightCurlyBracketKeyword_6_3());
    }
)?)
;





// Entry rule entryRuleIfStatement
entryRuleIfStatement returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getIfStatementRule()); }
	 iv_ruleIfStatement=ruleIfStatement 
	 { $current=$iv_ruleIfStatement.current; } 
	 EOF 
;

// Rule IfStatement
ruleIfStatement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='if' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
    }
	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getIfStatementAccess().getExpressionIfExpressionParserRuleCall_2_0()); 
	    }
		lv_expression_2_0=ruleIfExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIfStatementRule());
	        }
       		set(
       			$current, 
       			"expression",
        		lv_expression_2_0, 
        		"IfExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=')' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getIfStatementAccess().getStatementAssignStatementParserRuleCall_4_0()); 
	    }
		lv_statement_4_0=ruleAssignStatement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIfStatementRule());
	        }
       		set(
       			$current, 
       			"statement",
        		lv_statement_4_0, 
        		"AssignStatement");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleIfExpression
entryRuleIfExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getIfExpressionRule()); }
	 iv_ruleIfExpression=ruleIfExpression 
	 { $current=$iv_ruleIfExpression.current; } 
	 EOF 
;

// Rule IfExpression
ruleIfExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_var_0_0=RULE_ID
		{
			newLeafNode(lv_var_0_0, grammarAccess.getIfExpressionAccess().getVarIDTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getIfExpressionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"var",
        		lv_var_0_0, 
        		"ID");
	    }

)
)(
(
(
		lv_op_1_1=	'==' 
    {
        newLeafNode(lv_op_1_1, grammarAccess.getIfExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getIfExpressionRule());
	        }
       		setWithLastConsumed($current, "op", lv_op_1_1, null);
	    }

    |		lv_op_1_2=	'!=' 
    {
        newLeafNode(lv_op_1_2, grammarAccess.getIfExpressionAccess().getOpExclamationMarkEqualsSignKeyword_1_0_1());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getIfExpressionRule());
	        }
       		setWithLastConsumed($current, "op", lv_op_1_2, null);
	    }

)

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getIfExpressionAccess().getAssignmentAssignedValueParserRuleCall_2_0()); 
	    }
		lv_assignment_2_0=ruleAssignedValue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIfExpressionRule());
	        }
       		set(
       			$current, 
       			"assignment",
        		lv_assignment_2_0, 
        		"AssignedValue");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleAssignedValue
entryRuleAssignedValue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAssignedValueRule()); }
	 iv_ruleAssignedValue=ruleAssignedValue 
	 { $current=$iv_ruleAssignedValue.current; } 
	 EOF 
;

// Rule AssignedValue
ruleAssignedValue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_intval_0_0=RULE_INT
		{
			newLeafNode(lv_intval_0_0, grammarAccess.getAssignedValueAccess().getIntvalINTTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssignedValueRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"intval",
        		lv_intval_0_0, 
        		"INT");
	    }

)
)
    |(
(
(
		lv_boolval_1_1=	'true' 
    {
        newLeafNode(lv_boolval_1_1, grammarAccess.getAssignedValueAccess().getBoolvalTrueKeyword_1_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssignedValueRule());
	        }
       		setWithLastConsumed($current, "boolval", lv_boolval_1_1, null);
	    }

    |		lv_boolval_1_2=	'false' 
    {
        newLeafNode(lv_boolval_1_2, grammarAccess.getAssignedValueAccess().getBoolvalFalseKeyword_1_0_1());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssignedValueRule());
	        }
       		setWithLastConsumed($current, "boolval", lv_boolval_1_2, null);
	    }

)

)
))
;





// Entry rule entryRuleAssignStatement
entryRuleAssignStatement returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAssignStatementRule()); }
	 iv_ruleAssignStatement=ruleAssignStatement 
	 { $current=$iv_ruleAssignStatement.current; } 
	 EOF 
;

// Rule AssignStatement
ruleAssignStatement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssignStatementRule());
	        }
        }
	otherlv_0=RULE_ID
	{
		newLeafNode(otherlv_0, grammarAccess.getAssignStatementAccess().getVarCondVarCrossReference_0_0()); 
	}

)
)	otherlv_1='=' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getAssignStatementAccess().getEqualsSignKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAssignStatementAccess().getValueBooleanValParserRuleCall_2_0()); 
	    }
		lv_value_2_0=ruleBooleanVal		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAssignStatementRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_2_0, 
        		"BooleanVal");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=';' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getAssignStatementAccess().getSemicolonKeyword_3());
    }
)
;





// Entry rule entryRuleRequires
entryRuleRequires returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRequiresRule()); }
	 iv_ruleRequires=ruleRequires 
	 { $current=$iv_ruleRequires.current; } 
	 EOF 
;

// Rule Requires
ruleRequires returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='requires' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getRequiresAccess().getRequiresKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getRequiresAccess().getAndExpressionAndExpressionParserRuleCall_1_0()); 
	    }
		lv_andExpression_1_0=ruleAndExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRequiresRule());
	        }
       		set(
       			$current, 
       			"andExpression",
        		lv_andExpression_1_0, 
        		"AndExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2=';' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getRequiresAccess().getSemicolonKeyword_2());
    }
)
;





// Entry rule entryRuleAndExpression
entryRuleAndExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAndExpressionRule()); }
	 iv_ruleAndExpression=ruleAndExpression 
	 { $current=$iv_ruleAndExpression.current; } 
	 EOF 
;

// Rule AndExpression
ruleAndExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getAndExpressionAccess().getOrExpressionsOrExpressionParserRuleCall_0_0()); 
	    }
		lv_orExpressions_0_0=ruleOrExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAndExpressionRule());
	        }
       		add(
       			$current, 
       			"orExpressions",
        		lv_orExpressions_0_0, 
        		"OrExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='&&' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAndExpressionAccess().getOrExpressionsOrExpressionParserRuleCall_1_1_0()); 
	    }
		lv_orExpressions_2_0=ruleOrExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAndExpressionRule());
	        }
       		add(
       			$current, 
       			"orExpressions",
        		lv_orExpressions_2_0, 
        		"OrExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleOrExpression
entryRuleOrExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getOrExpressionRule()); }
	 iv_ruleOrExpression=ruleOrExpression 
	 { $current=$iv_ruleOrExpression.current; } 
	 EOF 
;

// Rule OrExpression
ruleOrExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getOrExpressionAccess().getBasicExpressionsBasicExpressionParserRuleCall_0_0()); 
	    }
		lv_basicExpressions_0_0=ruleBasicExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getOrExpressionRule());
	        }
       		add(
       			$current, 
       			"basicExpressions",
        		lv_basicExpressions_0_0, 
        		"BasicExpression");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1='||' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getOrExpressionAccess().getBasicExpressionsBasicExpressionParserRuleCall_1_1_0()); 
	    }
		lv_basicExpressions_2_0=ruleBasicExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getOrExpressionRule());
	        }
       		add(
       			$current, 
       			"basicExpressions",
        		lv_basicExpressions_2_0, 
        		"BasicExpression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleBasicExpression
entryRuleBasicExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getBasicExpressionRule()); }
	 iv_ruleBasicExpression=ruleBasicExpression 
	 { $current=$iv_ruleBasicExpression.current; } 
	 EOF 
;

// Rule BasicExpression
ruleBasicExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_negated_0_0=	'!' 
    {
        newLeafNode(lv_negated_0_0, grammarAccess.getBasicExpressionAccess().getNegatedExclamationMarkKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getBasicExpressionRule());
	        }
       		setWithLastConsumed($current, "negated", true, "!");
	    }

)
)?(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getBasicExpressionRule());
	        }
        }
	otherlv_1=RULE_ID
	{
		newLeafNode(otherlv_1, grammarAccess.getBasicExpressionAccess().getExprCondVarCrossReference_1_0()); 
	}

)
))
;





// Entry rule entryRuleMutexSet
entryRuleMutexSet returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMutexSetRule()); }
	 iv_ruleMutexSet=ruleMutexSet 
	 { $current=$iv_ruleMutexSet.current; } 
	 EOF 
;

// Rule MutexSet
ruleMutexSet returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='mutex' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getMutexSetAccess().getMutexKeyword_0());
    }
	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getMutexSetAccess().getLeftCurlyBracketKeyword_1());
    }
(
(
		lv_methods_2_0=RULE_ID
		{
			newLeafNode(lv_methods_2_0, grammarAccess.getMutexSetAccess().getMethodsIDTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMutexSetRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"methods",
        		lv_methods_2_0, 
        		"ID");
	    }

)
)(	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getMutexSetAccess().getCommaKeyword_3_0());
    }
(
(
		lv_methods_4_0=RULE_ID
		{
			newLeafNode(lv_methods_4_0, grammarAccess.getMutexSetAccess().getMethodsIDTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMutexSetRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"methods",
        		lv_methods_4_0, 
        		"ID");
	    }

)
))+	otherlv_5='};' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getMutexSetAccess().getRightCurlyBracketSemicolonKeyword_4());
    }
)
;





// Entry rule entryRuleCondVar
entryRuleCondVar returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCondVarRule()); }
	 iv_ruleCondVar=ruleCondVar 
	 { $current=$iv_ruleCondVar.current; } 
	 EOF 
;

// Rule CondVar
ruleCondVar returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=RULE_ID
		{
			newLeafNode(lv_name_0_0, grammarAccess.getCondVarAccess().getNameIDTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getCondVarRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"ID");
	    }

)
)	otherlv_1='=' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getCondVarAccess().getEqualsSignKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCondVarAccess().getValueBooleanValParserRuleCall_2_0()); 
	    }
		lv_value_2_0=ruleBooleanVal		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCondVarRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_2_0, 
        		"BooleanVal");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleOrdVar
entryRuleOrdVar returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getOrdVarRule()); }
	 iv_ruleOrdVar=ruleOrdVar 
	 { $current=$iv_ruleOrdVar.current; } 
	 EOF 
;

// Rule OrdVar
ruleOrdVar returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=RULE_ID
		{
			newLeafNode(lv_name_0_0, grammarAccess.getOrdVarAccess().getNameIDTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getOrdVarRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"ID");
	    }

)
)	otherlv_1='=' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getOrdVarAccess().getEqualsSignKeyword_1());
    }
(
(
		lv_value_2_0=RULE_INT
		{
			newLeafNode(lv_value_2_0, grammarAccess.getOrdVarAccess().getValueINTTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getOrdVarRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"value",
        		lv_value_2_0, 
        		"INT");
	    }

)
))
;





// Entry rule entryRuleBooleanVal
entryRuleBooleanVal returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getBooleanValRule()); } 
	 iv_ruleBooleanVal=ruleBooleanVal 
	 { $current=$iv_ruleBooleanVal.current.getText(); }  
	 EOF 
;

// Rule BooleanVal
ruleBooleanVal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='true' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getBooleanValAccess().getTrueKeyword_0()); 
    }

    |
	kw='false' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getBooleanValAccess().getFalseKeyword_1()); 
    }
)
    ;





// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); } 
	 iv_ruleQualifiedName=ruleQualifiedName 
	 { $current=$iv_ruleQualifiedName.current.getText(); }  
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
    }
    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
    }
)*)
    ;





RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;

