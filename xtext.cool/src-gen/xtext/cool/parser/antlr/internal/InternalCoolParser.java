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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCoolParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'per_class'", "'coordinator'", "'{'", "'condition'", "','", "';'", "'int'", "'selfex'", "'}'", "'mutex'", "'};'", "'='", "'true'", "'false'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalCoolParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCoolParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCoolParser.tokenNames; }
    public String getGrammarFileName() { return "../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g"; }



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



    // $ANTLR start "entryRuleCoordinatorDeclaration"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:67:1: entryRuleCoordinatorDeclaration returns [EObject current=null] : iv_ruleCoordinatorDeclaration= ruleCoordinatorDeclaration EOF ;
    public final EObject entryRuleCoordinatorDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCoordinatorDeclaration = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:68:2: (iv_ruleCoordinatorDeclaration= ruleCoordinatorDeclaration EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:69:2: iv_ruleCoordinatorDeclaration= ruleCoordinatorDeclaration EOF
            {
             newCompositeNode(grammarAccess.getCoordinatorDeclarationRule()); 
            pushFollow(FOLLOW_ruleCoordinatorDeclaration_in_entryRuleCoordinatorDeclaration75);
            iv_ruleCoordinatorDeclaration=ruleCoordinatorDeclaration();

            state._fsp--;

             current =iv_ruleCoordinatorDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCoordinatorDeclaration85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCoordinatorDeclaration"


    // $ANTLR start "ruleCoordinatorDeclaration"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:76:1: ruleCoordinatorDeclaration returns [EObject current=null] : ( ( (lv_granularity_0_0= 'per_class' ) )? otherlv_1= 'coordinator' ( (lv_className_2_0= ruleQualifiedName ) ) ( (lv_body_3_0= ruleCoordinatorBody ) )? ) ;
    public final EObject ruleCoordinatorDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_granularity_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_className_2_0 = null;

        EObject lv_body_3_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:79:28: ( ( ( (lv_granularity_0_0= 'per_class' ) )? otherlv_1= 'coordinator' ( (lv_className_2_0= ruleQualifiedName ) ) ( (lv_body_3_0= ruleCoordinatorBody ) )? ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:80:1: ( ( (lv_granularity_0_0= 'per_class' ) )? otherlv_1= 'coordinator' ( (lv_className_2_0= ruleQualifiedName ) ) ( (lv_body_3_0= ruleCoordinatorBody ) )? )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:80:1: ( ( (lv_granularity_0_0= 'per_class' ) )? otherlv_1= 'coordinator' ( (lv_className_2_0= ruleQualifiedName ) ) ( (lv_body_3_0= ruleCoordinatorBody ) )? )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:80:2: ( (lv_granularity_0_0= 'per_class' ) )? otherlv_1= 'coordinator' ( (lv_className_2_0= ruleQualifiedName ) ) ( (lv_body_3_0= ruleCoordinatorBody ) )?
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:80:2: ( (lv_granularity_0_0= 'per_class' ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:81:1: (lv_granularity_0_0= 'per_class' )
                    {
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:81:1: (lv_granularity_0_0= 'per_class' )
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:82:3: lv_granularity_0_0= 'per_class'
                    {
                    lv_granularity_0_0=(Token)match(input,11,FOLLOW_11_in_ruleCoordinatorDeclaration128); 

                            newLeafNode(lv_granularity_0_0, grammarAccess.getCoordinatorDeclarationAccess().getGranularityPer_classKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCoordinatorDeclarationRule());
                    	        }
                           		setWithLastConsumed(current, "granularity", lv_granularity_0_0, "per_class");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleCoordinatorDeclaration154); 

                	newLeafNode(otherlv_1, grammarAccess.getCoordinatorDeclarationAccess().getCoordinatorKeyword_1());
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:99:1: ( (lv_className_2_0= ruleQualifiedName ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:100:1: (lv_className_2_0= ruleQualifiedName )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:100:1: (lv_className_2_0= ruleQualifiedName )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:101:3: lv_className_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getCoordinatorDeclarationAccess().getClassNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleCoordinatorDeclaration175);
            lv_className_2_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCoordinatorDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"className",
                    		lv_className_2_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:117:2: ( (lv_body_3_0= ruleCoordinatorBody ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:118:1: (lv_body_3_0= ruleCoordinatorBody )
                    {
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:118:1: (lv_body_3_0= ruleCoordinatorBody )
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:119:3: lv_body_3_0= ruleCoordinatorBody
                    {
                     
                    	        newCompositeNode(grammarAccess.getCoordinatorDeclarationAccess().getBodyCoordinatorBodyParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCoordinatorBody_in_ruleCoordinatorDeclaration196);
                    lv_body_3_0=ruleCoordinatorBody();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCoordinatorDeclarationRule());
                    	        }
                           		set(
                           			current, 
                           			"body",
                            		lv_body_3_0, 
                            		"CoordinatorBody");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCoordinatorDeclaration"


    // $ANTLR start "entryRuleCoordinatorBody"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:143:1: entryRuleCoordinatorBody returns [EObject current=null] : iv_ruleCoordinatorBody= ruleCoordinatorBody EOF ;
    public final EObject entryRuleCoordinatorBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCoordinatorBody = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:144:2: (iv_ruleCoordinatorBody= ruleCoordinatorBody EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:145:2: iv_ruleCoordinatorBody= ruleCoordinatorBody EOF
            {
             newCompositeNode(grammarAccess.getCoordinatorBodyRule()); 
            pushFollow(FOLLOW_ruleCoordinatorBody_in_entryRuleCoordinatorBody233);
            iv_ruleCoordinatorBody=ruleCoordinatorBody();

            state._fsp--;

             current =iv_ruleCoordinatorBody; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCoordinatorBody243); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCoordinatorBody"


    // $ANTLR start "ruleCoordinatorBody"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:152:1: ruleCoordinatorBody returns [EObject current=null] : (otherlv_0= '{' () (otherlv_2= 'condition' ( (lv_condVars_3_0= ruleCondVar ) ) (otherlv_4= ',' ( (lv_condVars_5_0= ruleCondVar ) ) )* otherlv_6= ';' )* (otherlv_7= 'int' ( (lv_ordVars_8_0= ruleOrdVar ) ) (otherlv_9= ',' ( (lv_ordVars_10_0= ruleOrdVar ) ) )* otherlv_11= ';' )* (otherlv_12= 'selfex' ( (lv_selfexMethods_13_0= ruleQualifiedName ) ) (otherlv_14= ',' ( (lv_selfexMethods_15_0= ruleQualifiedName ) ) )* otherlv_16= ';' )? ( (lv_mutexSets_17_0= ruleMutexSet ) )* otherlv_18= '}' ) ;
    public final EObject ruleCoordinatorBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        EObject lv_condVars_3_0 = null;

        EObject lv_condVars_5_0 = null;

        EObject lv_ordVars_8_0 = null;

        EObject lv_ordVars_10_0 = null;

        AntlrDatatypeRuleToken lv_selfexMethods_13_0 = null;

        AntlrDatatypeRuleToken lv_selfexMethods_15_0 = null;

        EObject lv_mutexSets_17_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:155:28: ( (otherlv_0= '{' () (otherlv_2= 'condition' ( (lv_condVars_3_0= ruleCondVar ) ) (otherlv_4= ',' ( (lv_condVars_5_0= ruleCondVar ) ) )* otherlv_6= ';' )* (otherlv_7= 'int' ( (lv_ordVars_8_0= ruleOrdVar ) ) (otherlv_9= ',' ( (lv_ordVars_10_0= ruleOrdVar ) ) )* otherlv_11= ';' )* (otherlv_12= 'selfex' ( (lv_selfexMethods_13_0= ruleQualifiedName ) ) (otherlv_14= ',' ( (lv_selfexMethods_15_0= ruleQualifiedName ) ) )* otherlv_16= ';' )? ( (lv_mutexSets_17_0= ruleMutexSet ) )* otherlv_18= '}' ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:156:1: (otherlv_0= '{' () (otherlv_2= 'condition' ( (lv_condVars_3_0= ruleCondVar ) ) (otherlv_4= ',' ( (lv_condVars_5_0= ruleCondVar ) ) )* otherlv_6= ';' )* (otherlv_7= 'int' ( (lv_ordVars_8_0= ruleOrdVar ) ) (otherlv_9= ',' ( (lv_ordVars_10_0= ruleOrdVar ) ) )* otherlv_11= ';' )* (otherlv_12= 'selfex' ( (lv_selfexMethods_13_0= ruleQualifiedName ) ) (otherlv_14= ',' ( (lv_selfexMethods_15_0= ruleQualifiedName ) ) )* otherlv_16= ';' )? ( (lv_mutexSets_17_0= ruleMutexSet ) )* otherlv_18= '}' )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:156:1: (otherlv_0= '{' () (otherlv_2= 'condition' ( (lv_condVars_3_0= ruleCondVar ) ) (otherlv_4= ',' ( (lv_condVars_5_0= ruleCondVar ) ) )* otherlv_6= ';' )* (otherlv_7= 'int' ( (lv_ordVars_8_0= ruleOrdVar ) ) (otherlv_9= ',' ( (lv_ordVars_10_0= ruleOrdVar ) ) )* otherlv_11= ';' )* (otherlv_12= 'selfex' ( (lv_selfexMethods_13_0= ruleQualifiedName ) ) (otherlv_14= ',' ( (lv_selfexMethods_15_0= ruleQualifiedName ) ) )* otherlv_16= ';' )? ( (lv_mutexSets_17_0= ruleMutexSet ) )* otherlv_18= '}' )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:156:3: otherlv_0= '{' () (otherlv_2= 'condition' ( (lv_condVars_3_0= ruleCondVar ) ) (otherlv_4= ',' ( (lv_condVars_5_0= ruleCondVar ) ) )* otherlv_6= ';' )* (otherlv_7= 'int' ( (lv_ordVars_8_0= ruleOrdVar ) ) (otherlv_9= ',' ( (lv_ordVars_10_0= ruleOrdVar ) ) )* otherlv_11= ';' )* (otherlv_12= 'selfex' ( (lv_selfexMethods_13_0= ruleQualifiedName ) ) (otherlv_14= ',' ( (lv_selfexMethods_15_0= ruleQualifiedName ) ) )* otherlv_16= ';' )? ( (lv_mutexSets_17_0= ruleMutexSet ) )* otherlv_18= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleCoordinatorBody280); 

                	newLeafNode(otherlv_0, grammarAccess.getCoordinatorBodyAccess().getLeftCurlyBracketKeyword_0());
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:160:1: ()
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:161:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCoordinatorBodyAccess().getCoordinatorBodyAction_1(),
                        current);
                

            }

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:166:2: (otherlv_2= 'condition' ( (lv_condVars_3_0= ruleCondVar ) ) (otherlv_4= ',' ( (lv_condVars_5_0= ruleCondVar ) ) )* otherlv_6= ';' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:166:4: otherlv_2= 'condition' ( (lv_condVars_3_0= ruleCondVar ) ) (otherlv_4= ',' ( (lv_condVars_5_0= ruleCondVar ) ) )* otherlv_6= ';'
            	    {
            	    otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleCoordinatorBody302); 

            	        	newLeafNode(otherlv_2, grammarAccess.getCoordinatorBodyAccess().getConditionKeyword_2_0());
            	        
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:170:1: ( (lv_condVars_3_0= ruleCondVar ) )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:171:1: (lv_condVars_3_0= ruleCondVar )
            	    {
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:171:1: (lv_condVars_3_0= ruleCondVar )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:172:3: lv_condVars_3_0= ruleCondVar
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCoordinatorBodyAccess().getCondVarsCondVarParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCondVar_in_ruleCoordinatorBody323);
            	    lv_condVars_3_0=ruleCondVar();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCoordinatorBodyRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"condVars",
            	            		lv_condVars_3_0, 
            	            		"CondVar");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:188:2: (otherlv_4= ',' ( (lv_condVars_5_0= ruleCondVar ) ) )*
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==15) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:188:4: otherlv_4= ',' ( (lv_condVars_5_0= ruleCondVar ) )
            	    	    {
            	    	    otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleCoordinatorBody336); 

            	    	        	newLeafNode(otherlv_4, grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_2_2_0());
            	    	        
            	    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:192:1: ( (lv_condVars_5_0= ruleCondVar ) )
            	    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:193:1: (lv_condVars_5_0= ruleCondVar )
            	    	    {
            	    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:193:1: (lv_condVars_5_0= ruleCondVar )
            	    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:194:3: lv_condVars_5_0= ruleCondVar
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getCoordinatorBodyAccess().getCondVarsCondVarParserRuleCall_2_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleCondVar_in_ruleCoordinatorBody357);
            	    	    lv_condVars_5_0=ruleCondVar();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getCoordinatorBodyRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"condVars",
            	    	            		lv_condVars_5_0, 
            	    	            		"CondVar");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop3;
            	        }
            	    } while (true);

            	    otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleCoordinatorBody371); 

            	        	newLeafNode(otherlv_6, grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_2_3());
            	        

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:214:3: (otherlv_7= 'int' ( (lv_ordVars_8_0= ruleOrdVar ) ) (otherlv_9= ',' ( (lv_ordVars_10_0= ruleOrdVar ) ) )* otherlv_11= ';' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:214:5: otherlv_7= 'int' ( (lv_ordVars_8_0= ruleOrdVar ) ) (otherlv_9= ',' ( (lv_ordVars_10_0= ruleOrdVar ) ) )* otherlv_11= ';'
            	    {
            	    otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleCoordinatorBody386); 

            	        	newLeafNode(otherlv_7, grammarAccess.getCoordinatorBodyAccess().getIntKeyword_3_0());
            	        
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:218:1: ( (lv_ordVars_8_0= ruleOrdVar ) )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:219:1: (lv_ordVars_8_0= ruleOrdVar )
            	    {
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:219:1: (lv_ordVars_8_0= ruleOrdVar )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:220:3: lv_ordVars_8_0= ruleOrdVar
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCoordinatorBodyAccess().getOrdVarsOrdVarParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleOrdVar_in_ruleCoordinatorBody407);
            	    lv_ordVars_8_0=ruleOrdVar();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCoordinatorBodyRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ordVars",
            	            		lv_ordVars_8_0, 
            	            		"OrdVar");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:236:2: (otherlv_9= ',' ( (lv_ordVars_10_0= ruleOrdVar ) ) )*
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==15) ) {
            	            alt5=1;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:236:4: otherlv_9= ',' ( (lv_ordVars_10_0= ruleOrdVar ) )
            	    	    {
            	    	    otherlv_9=(Token)match(input,15,FOLLOW_15_in_ruleCoordinatorBody420); 

            	    	        	newLeafNode(otherlv_9, grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_3_2_0());
            	    	        
            	    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:240:1: ( (lv_ordVars_10_0= ruleOrdVar ) )
            	    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:241:1: (lv_ordVars_10_0= ruleOrdVar )
            	    	    {
            	    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:241:1: (lv_ordVars_10_0= ruleOrdVar )
            	    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:242:3: lv_ordVars_10_0= ruleOrdVar
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getCoordinatorBodyAccess().getOrdVarsOrdVarParserRuleCall_3_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleOrdVar_in_ruleCoordinatorBody441);
            	    	    lv_ordVars_10_0=ruleOrdVar();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getCoordinatorBodyRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"ordVars",
            	    	            		lv_ordVars_10_0, 
            	    	            		"OrdVar");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop5;
            	        }
            	    } while (true);

            	    otherlv_11=(Token)match(input,16,FOLLOW_16_in_ruleCoordinatorBody455); 

            	        	newLeafNode(otherlv_11, grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_3_3());
            	        

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:262:3: (otherlv_12= 'selfex' ( (lv_selfexMethods_13_0= ruleQualifiedName ) ) (otherlv_14= ',' ( (lv_selfexMethods_15_0= ruleQualifiedName ) ) )* otherlv_16= ';' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:262:5: otherlv_12= 'selfex' ( (lv_selfexMethods_13_0= ruleQualifiedName ) ) (otherlv_14= ',' ( (lv_selfexMethods_15_0= ruleQualifiedName ) ) )* otherlv_16= ';'
                    {
                    otherlv_12=(Token)match(input,18,FOLLOW_18_in_ruleCoordinatorBody470); 

                        	newLeafNode(otherlv_12, grammarAccess.getCoordinatorBodyAccess().getSelfexKeyword_4_0());
                        
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:266:1: ( (lv_selfexMethods_13_0= ruleQualifiedName ) )
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:267:1: (lv_selfexMethods_13_0= ruleQualifiedName )
                    {
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:267:1: (lv_selfexMethods_13_0= ruleQualifiedName )
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:268:3: lv_selfexMethods_13_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsQualifiedNameParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleCoordinatorBody491);
                    lv_selfexMethods_13_0=ruleQualifiedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCoordinatorBodyRule());
                    	        }
                           		add(
                           			current, 
                           			"selfexMethods",
                            		lv_selfexMethods_13_0, 
                            		"QualifiedName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:284:2: (otherlv_14= ',' ( (lv_selfexMethods_15_0= ruleQualifiedName ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==15) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:284:4: otherlv_14= ',' ( (lv_selfexMethods_15_0= ruleQualifiedName ) )
                    	    {
                    	    otherlv_14=(Token)match(input,15,FOLLOW_15_in_ruleCoordinatorBody504); 

                    	        	newLeafNode(otherlv_14, grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_4_2_0());
                    	        
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:288:1: ( (lv_selfexMethods_15_0= ruleQualifiedName ) )
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:289:1: (lv_selfexMethods_15_0= ruleQualifiedName )
                    	    {
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:289:1: (lv_selfexMethods_15_0= ruleQualifiedName )
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:290:3: lv_selfexMethods_15_0= ruleQualifiedName
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsQualifiedNameParserRuleCall_4_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleCoordinatorBody525);
                    	    lv_selfexMethods_15_0=ruleQualifiedName();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getCoordinatorBodyRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"selfexMethods",
                    	            		lv_selfexMethods_15_0, 
                    	            		"QualifiedName");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,16,FOLLOW_16_in_ruleCoordinatorBody539); 

                        	newLeafNode(otherlv_16, grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_4_3());
                        

                    }
                    break;

            }

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:310:3: ( (lv_mutexSets_17_0= ruleMutexSet ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==20) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:311:1: (lv_mutexSets_17_0= ruleMutexSet )
            	    {
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:311:1: (lv_mutexSets_17_0= ruleMutexSet )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:312:3: lv_mutexSets_17_0= ruleMutexSet
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCoordinatorBodyAccess().getMutexSetsMutexSetParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMutexSet_in_ruleCoordinatorBody562);
            	    lv_mutexSets_17_0=ruleMutexSet();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCoordinatorBodyRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"mutexSets",
            	            		lv_mutexSets_17_0, 
            	            		"MutexSet");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_18=(Token)match(input,19,FOLLOW_19_in_ruleCoordinatorBody575); 

                	newLeafNode(otherlv_18, grammarAccess.getCoordinatorBodyAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCoordinatorBody"


    // $ANTLR start "entryRuleMutexSet"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:340:1: entryRuleMutexSet returns [EObject current=null] : iv_ruleMutexSet= ruleMutexSet EOF ;
    public final EObject entryRuleMutexSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMutexSet = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:341:2: (iv_ruleMutexSet= ruleMutexSet EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:342:2: iv_ruleMutexSet= ruleMutexSet EOF
            {
             newCompositeNode(grammarAccess.getMutexSetRule()); 
            pushFollow(FOLLOW_ruleMutexSet_in_entryRuleMutexSet611);
            iv_ruleMutexSet=ruleMutexSet();

            state._fsp--;

             current =iv_ruleMutexSet; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMutexSet621); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMutexSet"


    // $ANTLR start "ruleMutexSet"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:349:1: ruleMutexSet returns [EObject current=null] : (otherlv_0= 'mutex' otherlv_1= '{' ( (lv_methods_2_0= ruleQualifiedName ) ) (otherlv_3= ',' ( (lv_methods_4_0= ruleQualifiedName ) ) )+ otherlv_5= '};' ) ;
    public final EObject ruleMutexSet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_methods_2_0 = null;

        AntlrDatatypeRuleToken lv_methods_4_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:352:28: ( (otherlv_0= 'mutex' otherlv_1= '{' ( (lv_methods_2_0= ruleQualifiedName ) ) (otherlv_3= ',' ( (lv_methods_4_0= ruleQualifiedName ) ) )+ otherlv_5= '};' ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:353:1: (otherlv_0= 'mutex' otherlv_1= '{' ( (lv_methods_2_0= ruleQualifiedName ) ) (otherlv_3= ',' ( (lv_methods_4_0= ruleQualifiedName ) ) )+ otherlv_5= '};' )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:353:1: (otherlv_0= 'mutex' otherlv_1= '{' ( (lv_methods_2_0= ruleQualifiedName ) ) (otherlv_3= ',' ( (lv_methods_4_0= ruleQualifiedName ) ) )+ otherlv_5= '};' )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:353:3: otherlv_0= 'mutex' otherlv_1= '{' ( (lv_methods_2_0= ruleQualifiedName ) ) (otherlv_3= ',' ( (lv_methods_4_0= ruleQualifiedName ) ) )+ otherlv_5= '};'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleMutexSet658); 

                	newLeafNode(otherlv_0, grammarAccess.getMutexSetAccess().getMutexKeyword_0());
                
            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleMutexSet670); 

                	newLeafNode(otherlv_1, grammarAccess.getMutexSetAccess().getLeftCurlyBracketKeyword_1());
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:361:1: ( (lv_methods_2_0= ruleQualifiedName ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:362:1: (lv_methods_2_0= ruleQualifiedName )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:362:1: (lv_methods_2_0= ruleQualifiedName )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:363:3: lv_methods_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getMutexSetAccess().getMethodsQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleMutexSet691);
            lv_methods_2_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMutexSetRule());
            	        }
                   		add(
                   			current, 
                   			"methods",
                    		lv_methods_2_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:379:2: (otherlv_3= ',' ( (lv_methods_4_0= ruleQualifiedName ) ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==15) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:379:4: otherlv_3= ',' ( (lv_methods_4_0= ruleQualifiedName ) )
            	    {
            	    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleMutexSet704); 

            	        	newLeafNode(otherlv_3, grammarAccess.getMutexSetAccess().getCommaKeyword_3_0());
            	        
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:383:1: ( (lv_methods_4_0= ruleQualifiedName ) )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:384:1: (lv_methods_4_0= ruleQualifiedName )
            	    {
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:384:1: (lv_methods_4_0= ruleQualifiedName )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:385:3: lv_methods_4_0= ruleQualifiedName
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMutexSetAccess().getMethodsQualifiedNameParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleMutexSet725);
            	    lv_methods_4_0=ruleQualifiedName();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMutexSetRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"methods",
            	            		lv_methods_4_0, 
            	            		"QualifiedName");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            otherlv_5=(Token)match(input,21,FOLLOW_21_in_ruleMutexSet739); 

                	newLeafNode(otherlv_5, grammarAccess.getMutexSetAccess().getRightCurlyBracketSemicolonKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMutexSet"


    // $ANTLR start "entryRuleCondVar"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:413:1: entryRuleCondVar returns [EObject current=null] : iv_ruleCondVar= ruleCondVar EOF ;
    public final EObject entryRuleCondVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondVar = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:414:2: (iv_ruleCondVar= ruleCondVar EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:415:2: iv_ruleCondVar= ruleCondVar EOF
            {
             newCompositeNode(grammarAccess.getCondVarRule()); 
            pushFollow(FOLLOW_ruleCondVar_in_entryRuleCondVar775);
            iv_ruleCondVar=ruleCondVar();

            state._fsp--;

             current =iv_ruleCondVar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCondVar785); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondVar"


    // $ANTLR start "ruleCondVar"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:422:1: ruleCondVar returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) ) ) ;
    public final EObject ruleCondVar() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:425:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:426:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:426:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:426:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:426:2: ( (lv_name_0_0= RULE_ID ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:427:1: (lv_name_0_0= RULE_ID )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:427:1: (lv_name_0_0= RULE_ID )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:428:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCondVar827); 

            			newLeafNode(lv_name_0_0, grammarAccess.getCondVarAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCondVarRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleCondVar844); 

                	newLeafNode(otherlv_1, grammarAccess.getCondVarAccess().getEqualsSignKeyword_1());
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:448:1: ( (lv_value_2_0= ruleBooleanVal ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:449:1: (lv_value_2_0= ruleBooleanVal )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:449:1: (lv_value_2_0= ruleBooleanVal )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:450:3: lv_value_2_0= ruleBooleanVal
            {
             
            	        newCompositeNode(grammarAccess.getCondVarAccess().getValueBooleanValParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleBooleanVal_in_ruleCondVar865);
            lv_value_2_0=ruleBooleanVal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCondVarRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"BooleanVal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondVar"


    // $ANTLR start "entryRuleOrdVar"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:474:1: entryRuleOrdVar returns [EObject current=null] : iv_ruleOrdVar= ruleOrdVar EOF ;
    public final EObject entryRuleOrdVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrdVar = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:475:2: (iv_ruleOrdVar= ruleOrdVar EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:476:2: iv_ruleOrdVar= ruleOrdVar EOF
            {
             newCompositeNode(grammarAccess.getOrdVarRule()); 
            pushFollow(FOLLOW_ruleOrdVar_in_entryRuleOrdVar901);
            iv_ruleOrdVar=ruleOrdVar();

            state._fsp--;

             current =iv_ruleOrdVar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrdVar911); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrdVar"


    // $ANTLR start "ruleOrdVar"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:483:1: ruleOrdVar returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_INT ) ) ) ;
    public final EObject ruleOrdVar() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:486:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_INT ) ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:487:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_INT ) ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:487:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_INT ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:487:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_INT ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:487:2: ( (lv_name_0_0= RULE_ID ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:488:1: (lv_name_0_0= RULE_ID )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:488:1: (lv_name_0_0= RULE_ID )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:489:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOrdVar953); 

            			newLeafNode(lv_name_0_0, grammarAccess.getOrdVarAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOrdVarRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleOrdVar970); 

                	newLeafNode(otherlv_1, grammarAccess.getOrdVarAccess().getEqualsSignKeyword_1());
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:509:1: ( (lv_value_2_0= RULE_INT ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:510:1: (lv_value_2_0= RULE_INT )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:510:1: (lv_value_2_0= RULE_INT )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:511:3: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleOrdVar987); 

            			newLeafNode(lv_value_2_0, grammarAccess.getOrdVarAccess().getValueINTTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOrdVarRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"INT");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrdVar"


    // $ANTLR start "entryRuleBooleanVal"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:535:1: entryRuleBooleanVal returns [String current=null] : iv_ruleBooleanVal= ruleBooleanVal EOF ;
    public final String entryRuleBooleanVal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBooleanVal = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:536:2: (iv_ruleBooleanVal= ruleBooleanVal EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:537:2: iv_ruleBooleanVal= ruleBooleanVal EOF
            {
             newCompositeNode(grammarAccess.getBooleanValRule()); 
            pushFollow(FOLLOW_ruleBooleanVal_in_entryRuleBooleanVal1029);
            iv_ruleBooleanVal=ruleBooleanVal();

            state._fsp--;

             current =iv_ruleBooleanVal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanVal1040); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanVal"


    // $ANTLR start "ruleBooleanVal"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:544:1: ruleBooleanVal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleBooleanVal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:547:28: ( (kw= 'true' | kw= 'false' ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:548:1: (kw= 'true' | kw= 'false' )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:548:1: (kw= 'true' | kw= 'false' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            else if ( (LA11_0==24) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:549:2: kw= 'true'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleBooleanVal1078); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBooleanValAccess().getTrueKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:556:2: kw= 'false'
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleBooleanVal1097); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBooleanValAccess().getFalseKeyword_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanVal"


    // $ANTLR start "entryRuleQualifiedName"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:569:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:570:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:571:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1138);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1149); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:578:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:581:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:582:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:582:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:582:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName1189); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:589:1: (kw= '.' this_ID_2= RULE_ID )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==25) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:590:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,25,FOLLOW_25_in_ruleQualifiedName1208); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName1223); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleCoordinatorDeclaration_in_entryRuleCoordinatorDeclaration75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCoordinatorDeclaration85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleCoordinatorDeclaration128 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleCoordinatorDeclaration154 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCoordinatorDeclaration175 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleCoordinatorBody_in_ruleCoordinatorDeclaration196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCoordinatorBody_in_entryRuleCoordinatorBody233 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCoordinatorBody243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleCoordinatorBody280 = new BitSet(new long[]{0x00000000001E4000L});
    public static final BitSet FOLLOW_14_in_ruleCoordinatorBody302 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCondVar_in_ruleCoordinatorBody323 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleCoordinatorBody336 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCondVar_in_ruleCoordinatorBody357 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_ruleCoordinatorBody371 = new BitSet(new long[]{0x00000000001E4000L});
    public static final BitSet FOLLOW_17_in_ruleCoordinatorBody386 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleOrdVar_in_ruleCoordinatorBody407 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleCoordinatorBody420 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleOrdVar_in_ruleCoordinatorBody441 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_ruleCoordinatorBody455 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_18_in_ruleCoordinatorBody470 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCoordinatorBody491 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleCoordinatorBody504 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCoordinatorBody525 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_ruleCoordinatorBody539 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_ruleMutexSet_in_ruleCoordinatorBody562 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_19_in_ruleCoordinatorBody575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMutexSet_in_entryRuleMutexSet611 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMutexSet621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleMutexSet658 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleMutexSet670 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleMutexSet691 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleMutexSet704 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleMutexSet725 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_21_in_ruleMutexSet739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondVar_in_entryRuleCondVar775 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCondVar785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCondVar827 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleCondVar844 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_ruleBooleanVal_in_ruleCondVar865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrdVar_in_entryRuleOrdVar901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrdVar911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOrdVar953 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleOrdVar970 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleOrdVar987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanVal_in_entryRuleBooleanVal1029 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanVal1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleBooleanVal1078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleBooleanVal1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1138 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName1189 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleQualifiedName1208 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName1223 = new BitSet(new long[]{0x0000000002000002L});

}