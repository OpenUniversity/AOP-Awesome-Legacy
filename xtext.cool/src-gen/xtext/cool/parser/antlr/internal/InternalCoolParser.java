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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'per_class'", "'coordinator'", "'{'", "'condition'", "','", "';'", "'int'", "'selfex'", "'}'", "'guard'", "':'", "'requires'", "'&&'", "'||'", "'!'", "'mutex'", "'};'", "'='", "'true'", "'false'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
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
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:152:1: ruleCoordinatorBody returns [EObject current=null] : (otherlv_0= '{' () (otherlv_2= 'condition' ( (lv_condVars_3_0= ruleCondVar ) ) (otherlv_4= ',' ( (lv_condVars_5_0= ruleCondVar ) ) )* otherlv_6= ';' )* (otherlv_7= 'int' ( (lv_ordVars_8_0= ruleOrdVar ) ) (otherlv_9= ',' ( (lv_ordVars_10_0= ruleOrdVar ) ) )* otherlv_11= ';' )* (otherlv_12= 'selfex' ( (lv_selfexMethods_13_0= ruleQualifiedName ) ) (otherlv_14= ',' ( (lv_selfexMethods_15_0= ruleQualifiedName ) ) )* otherlv_16= ';' )? ( (lv_mutexSets_17_0= ruleMutexSet ) )* ( (lv_guards_18_0= ruleGuard ) )* otherlv_19= '}' ) ;
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
        Token otherlv_19=null;
        EObject lv_condVars_3_0 = null;

        EObject lv_condVars_5_0 = null;

        EObject lv_ordVars_8_0 = null;

        EObject lv_ordVars_10_0 = null;

        AntlrDatatypeRuleToken lv_selfexMethods_13_0 = null;

        AntlrDatatypeRuleToken lv_selfexMethods_15_0 = null;

        EObject lv_mutexSets_17_0 = null;

        EObject lv_guards_18_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:155:28: ( (otherlv_0= '{' () (otherlv_2= 'condition' ( (lv_condVars_3_0= ruleCondVar ) ) (otherlv_4= ',' ( (lv_condVars_5_0= ruleCondVar ) ) )* otherlv_6= ';' )* (otherlv_7= 'int' ( (lv_ordVars_8_0= ruleOrdVar ) ) (otherlv_9= ',' ( (lv_ordVars_10_0= ruleOrdVar ) ) )* otherlv_11= ';' )* (otherlv_12= 'selfex' ( (lv_selfexMethods_13_0= ruleQualifiedName ) ) (otherlv_14= ',' ( (lv_selfexMethods_15_0= ruleQualifiedName ) ) )* otherlv_16= ';' )? ( (lv_mutexSets_17_0= ruleMutexSet ) )* ( (lv_guards_18_0= ruleGuard ) )* otherlv_19= '}' ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:156:1: (otherlv_0= '{' () (otherlv_2= 'condition' ( (lv_condVars_3_0= ruleCondVar ) ) (otherlv_4= ',' ( (lv_condVars_5_0= ruleCondVar ) ) )* otherlv_6= ';' )* (otherlv_7= 'int' ( (lv_ordVars_8_0= ruleOrdVar ) ) (otherlv_9= ',' ( (lv_ordVars_10_0= ruleOrdVar ) ) )* otherlv_11= ';' )* (otherlv_12= 'selfex' ( (lv_selfexMethods_13_0= ruleQualifiedName ) ) (otherlv_14= ',' ( (lv_selfexMethods_15_0= ruleQualifiedName ) ) )* otherlv_16= ';' )? ( (lv_mutexSets_17_0= ruleMutexSet ) )* ( (lv_guards_18_0= ruleGuard ) )* otherlv_19= '}' )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:156:1: (otherlv_0= '{' () (otherlv_2= 'condition' ( (lv_condVars_3_0= ruleCondVar ) ) (otherlv_4= ',' ( (lv_condVars_5_0= ruleCondVar ) ) )* otherlv_6= ';' )* (otherlv_7= 'int' ( (lv_ordVars_8_0= ruleOrdVar ) ) (otherlv_9= ',' ( (lv_ordVars_10_0= ruleOrdVar ) ) )* otherlv_11= ';' )* (otherlv_12= 'selfex' ( (lv_selfexMethods_13_0= ruleQualifiedName ) ) (otherlv_14= ',' ( (lv_selfexMethods_15_0= ruleQualifiedName ) ) )* otherlv_16= ';' )? ( (lv_mutexSets_17_0= ruleMutexSet ) )* ( (lv_guards_18_0= ruleGuard ) )* otherlv_19= '}' )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:156:3: otherlv_0= '{' () (otherlv_2= 'condition' ( (lv_condVars_3_0= ruleCondVar ) ) (otherlv_4= ',' ( (lv_condVars_5_0= ruleCondVar ) ) )* otherlv_6= ';' )* (otherlv_7= 'int' ( (lv_ordVars_8_0= ruleOrdVar ) ) (otherlv_9= ',' ( (lv_ordVars_10_0= ruleOrdVar ) ) )* otherlv_11= ';' )* (otherlv_12= 'selfex' ( (lv_selfexMethods_13_0= ruleQualifiedName ) ) (otherlv_14= ',' ( (lv_selfexMethods_15_0= ruleQualifiedName ) ) )* otherlv_16= ';' )? ( (lv_mutexSets_17_0= ruleMutexSet ) )* ( (lv_guards_18_0= ruleGuard ) )* otherlv_19= '}'
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

                if ( (LA9_0==26) ) {
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

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:328:3: ( (lv_guards_18_0= ruleGuard ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID||LA10_0==20) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:329:1: (lv_guards_18_0= ruleGuard )
            	    {
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:329:1: (lv_guards_18_0= ruleGuard )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:330:3: lv_guards_18_0= ruleGuard
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCoordinatorBodyAccess().getGuardsGuardParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleGuard_in_ruleCoordinatorBody584);
            	    lv_guards_18_0=ruleGuard();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCoordinatorBodyRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"guards",
            	            		lv_guards_18_0, 
            	            		"Guard");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_19=(Token)match(input,19,FOLLOW_19_in_ruleCoordinatorBody597); 

                	newLeafNode(otherlv_19, grammarAccess.getCoordinatorBodyAccess().getRightCurlyBracketKeyword_7());
                

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


    // $ANTLR start "entryRuleGuard"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:358:1: entryRuleGuard returns [EObject current=null] : iv_ruleGuard= ruleGuard EOF ;
    public final EObject entryRuleGuard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGuard = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:359:2: (iv_ruleGuard= ruleGuard EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:360:2: iv_ruleGuard= ruleGuard EOF
            {
             newCompositeNode(grammarAccess.getGuardRule()); 
            pushFollow(FOLLOW_ruleGuard_in_entryRuleGuard633);
            iv_ruleGuard=ruleGuard();

            state._fsp--;

             current =iv_ruleGuard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuard643); 

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
    // $ANTLR end "entryRuleGuard"


    // $ANTLR start "ruleGuard"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:367:1: ruleGuard returns [EObject current=null] : ( (otherlv_0= 'guard' )? ( (lv_methods_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_methods_3_0= RULE_ID ) ) )* otherlv_4= ':' ( (lv_requires_5_0= ruleRequires ) )? ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_methods_1_0=null;
        Token otherlv_2=null;
        Token lv_methods_3_0=null;
        Token otherlv_4=null;
        EObject lv_requires_5_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:370:28: ( ( (otherlv_0= 'guard' )? ( (lv_methods_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_methods_3_0= RULE_ID ) ) )* otherlv_4= ':' ( (lv_requires_5_0= ruleRequires ) )? ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:371:1: ( (otherlv_0= 'guard' )? ( (lv_methods_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_methods_3_0= RULE_ID ) ) )* otherlv_4= ':' ( (lv_requires_5_0= ruleRequires ) )? )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:371:1: ( (otherlv_0= 'guard' )? ( (lv_methods_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_methods_3_0= RULE_ID ) ) )* otherlv_4= ':' ( (lv_requires_5_0= ruleRequires ) )? )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:371:2: (otherlv_0= 'guard' )? ( (lv_methods_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_methods_3_0= RULE_ID ) ) )* otherlv_4= ':' ( (lv_requires_5_0= ruleRequires ) )?
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:371:2: (otherlv_0= 'guard' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:371:4: otherlv_0= 'guard'
                    {
                    otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleGuard681); 

                        	newLeafNode(otherlv_0, grammarAccess.getGuardAccess().getGuardKeyword_0());
                        

                    }
                    break;

            }

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:375:3: ( (lv_methods_1_0= RULE_ID ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:376:1: (lv_methods_1_0= RULE_ID )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:376:1: (lv_methods_1_0= RULE_ID )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:377:3: lv_methods_1_0= RULE_ID
            {
            lv_methods_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGuard700); 

            			newLeafNode(lv_methods_1_0, grammarAccess.getGuardAccess().getMethodsIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getGuardRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"methods",
                    		lv_methods_1_0, 
                    		"ID");
            	    

            }


            }

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:393:2: (otherlv_2= ',' ( (lv_methods_3_0= RULE_ID ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==15) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:393:4: otherlv_2= ',' ( (lv_methods_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleGuard718); 

            	        	newLeafNode(otherlv_2, grammarAccess.getGuardAccess().getCommaKeyword_2_0());
            	        
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:397:1: ( (lv_methods_3_0= RULE_ID ) )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:398:1: (lv_methods_3_0= RULE_ID )
            	    {
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:398:1: (lv_methods_3_0= RULE_ID )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:399:3: lv_methods_3_0= RULE_ID
            	    {
            	    lv_methods_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGuard735); 

            	    			newLeafNode(lv_methods_3_0, grammarAccess.getGuardAccess().getMethodsIDTerminalRuleCall_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGuardRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"methods",
            	            		lv_methods_3_0, 
            	            		"ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleGuard754); 

                	newLeafNode(otherlv_4, grammarAccess.getGuardAccess().getColonKeyword_3());
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:419:1: ( (lv_requires_5_0= ruleRequires ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==22) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:420:1: (lv_requires_5_0= ruleRequires )
                    {
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:420:1: (lv_requires_5_0= ruleRequires )
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:421:3: lv_requires_5_0= ruleRequires
                    {
                     
                    	        newCompositeNode(grammarAccess.getGuardAccess().getRequiresRequiresParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleRequires_in_ruleGuard775);
                    lv_requires_5_0=ruleRequires();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getGuardRule());
                    	        }
                           		set(
                           			current, 
                           			"requires",
                            		lv_requires_5_0, 
                            		"Requires");
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
    // $ANTLR end "ruleGuard"


    // $ANTLR start "entryRuleRequires"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:445:1: entryRuleRequires returns [EObject current=null] : iv_ruleRequires= ruleRequires EOF ;
    public final EObject entryRuleRequires() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequires = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:446:2: (iv_ruleRequires= ruleRequires EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:447:2: iv_ruleRequires= ruleRequires EOF
            {
             newCompositeNode(grammarAccess.getRequiresRule()); 
            pushFollow(FOLLOW_ruleRequires_in_entryRuleRequires812);
            iv_ruleRequires=ruleRequires();

            state._fsp--;

             current =iv_ruleRequires; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequires822); 

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
    // $ANTLR end "entryRuleRequires"


    // $ANTLR start "ruleRequires"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:454:1: ruleRequires returns [EObject current=null] : (otherlv_0= 'requires' ( (lv_andExpression_1_0= ruleAndExpression ) ) otherlv_2= ';' ) ;
    public final EObject ruleRequires() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_andExpression_1_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:457:28: ( (otherlv_0= 'requires' ( (lv_andExpression_1_0= ruleAndExpression ) ) otherlv_2= ';' ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:458:1: (otherlv_0= 'requires' ( (lv_andExpression_1_0= ruleAndExpression ) ) otherlv_2= ';' )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:458:1: (otherlv_0= 'requires' ( (lv_andExpression_1_0= ruleAndExpression ) ) otherlv_2= ';' )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:458:3: otherlv_0= 'requires' ( (lv_andExpression_1_0= ruleAndExpression ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleRequires859); 

                	newLeafNode(otherlv_0, grammarAccess.getRequiresAccess().getRequiresKeyword_0());
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:462:1: ( (lv_andExpression_1_0= ruleAndExpression ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:463:1: (lv_andExpression_1_0= ruleAndExpression )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:463:1: (lv_andExpression_1_0= ruleAndExpression )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:464:3: lv_andExpression_1_0= ruleAndExpression
            {
             
            	        newCompositeNode(grammarAccess.getRequiresAccess().getAndExpressionAndExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAndExpression_in_ruleRequires880);
            lv_andExpression_1_0=ruleAndExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRequiresRule());
            	        }
                   		set(
                   			current, 
                   			"andExpression",
                    		lv_andExpression_1_0, 
                    		"AndExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleRequires892); 

                	newLeafNode(otherlv_2, grammarAccess.getRequiresAccess().getSemicolonKeyword_2());
                

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
    // $ANTLR end "ruleRequires"


    // $ANTLR start "entryRuleAndExpression"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:492:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:493:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:494:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
             newCompositeNode(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_ruleAndExpression_in_entryRuleAndExpression928);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;

             current =iv_ruleAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndExpression938); 

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
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:501:1: ruleAndExpression returns [EObject current=null] : ( ( (lv_orExpressions_0_0= ruleOrExpression ) ) (otherlv_1= '&&' ( (lv_orExpressions_2_0= ruleOrExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_orExpressions_0_0 = null;

        EObject lv_orExpressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:504:28: ( ( ( (lv_orExpressions_0_0= ruleOrExpression ) ) (otherlv_1= '&&' ( (lv_orExpressions_2_0= ruleOrExpression ) ) )* ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:505:1: ( ( (lv_orExpressions_0_0= ruleOrExpression ) ) (otherlv_1= '&&' ( (lv_orExpressions_2_0= ruleOrExpression ) ) )* )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:505:1: ( ( (lv_orExpressions_0_0= ruleOrExpression ) ) (otherlv_1= '&&' ( (lv_orExpressions_2_0= ruleOrExpression ) ) )* )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:505:2: ( (lv_orExpressions_0_0= ruleOrExpression ) ) (otherlv_1= '&&' ( (lv_orExpressions_2_0= ruleOrExpression ) ) )*
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:505:2: ( (lv_orExpressions_0_0= ruleOrExpression ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:506:1: (lv_orExpressions_0_0= ruleOrExpression )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:506:1: (lv_orExpressions_0_0= ruleOrExpression )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:507:3: lv_orExpressions_0_0= ruleOrExpression
            {
             
            	        newCompositeNode(grammarAccess.getAndExpressionAccess().getOrExpressionsOrExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleOrExpression_in_ruleAndExpression984);
            lv_orExpressions_0_0=ruleOrExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"orExpressions",
                    		lv_orExpressions_0_0, 
                    		"OrExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:523:2: (otherlv_1= '&&' ( (lv_orExpressions_2_0= ruleOrExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==23) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:523:4: otherlv_1= '&&' ( (lv_orExpressions_2_0= ruleOrExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleAndExpression997); 

            	        	newLeafNode(otherlv_1, grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_0());
            	        
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:527:1: ( (lv_orExpressions_2_0= ruleOrExpression ) )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:528:1: (lv_orExpressions_2_0= ruleOrExpression )
            	    {
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:528:1: (lv_orExpressions_2_0= ruleOrExpression )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:529:3: lv_orExpressions_2_0= ruleOrExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAndExpressionAccess().getOrExpressionsOrExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleOrExpression_in_ruleAndExpression1018);
            	    lv_orExpressions_2_0=ruleOrExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"orExpressions",
            	            		lv_orExpressions_2_0, 
            	            		"OrExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleOrExpression"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:553:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:554:2: (iv_ruleOrExpression= ruleOrExpression EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:555:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
             newCompositeNode(grammarAccess.getOrExpressionRule()); 
            pushFollow(FOLLOW_ruleOrExpression_in_entryRuleOrExpression1056);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;

             current =iv_ruleOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrExpression1066); 

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
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:562:1: ruleOrExpression returns [EObject current=null] : ( ( (lv_basicExpressions_0_0= ruleBasicExpression ) ) (otherlv_1= '||' ( (lv_basicExpressions_2_0= ruleBasicExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_basicExpressions_0_0 = null;

        EObject lv_basicExpressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:565:28: ( ( ( (lv_basicExpressions_0_0= ruleBasicExpression ) ) (otherlv_1= '||' ( (lv_basicExpressions_2_0= ruleBasicExpression ) ) )* ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:566:1: ( ( (lv_basicExpressions_0_0= ruleBasicExpression ) ) (otherlv_1= '||' ( (lv_basicExpressions_2_0= ruleBasicExpression ) ) )* )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:566:1: ( ( (lv_basicExpressions_0_0= ruleBasicExpression ) ) (otherlv_1= '||' ( (lv_basicExpressions_2_0= ruleBasicExpression ) ) )* )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:566:2: ( (lv_basicExpressions_0_0= ruleBasicExpression ) ) (otherlv_1= '||' ( (lv_basicExpressions_2_0= ruleBasicExpression ) ) )*
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:566:2: ( (lv_basicExpressions_0_0= ruleBasicExpression ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:567:1: (lv_basicExpressions_0_0= ruleBasicExpression )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:567:1: (lv_basicExpressions_0_0= ruleBasicExpression )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:568:3: lv_basicExpressions_0_0= ruleBasicExpression
            {
             
            	        newCompositeNode(grammarAccess.getOrExpressionAccess().getBasicExpressionsBasicExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleBasicExpression_in_ruleOrExpression1112);
            lv_basicExpressions_0_0=ruleBasicExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"basicExpressions",
                    		lv_basicExpressions_0_0, 
                    		"BasicExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:584:2: (otherlv_1= '||' ( (lv_basicExpressions_2_0= ruleBasicExpression ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==24) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:584:4: otherlv_1= '||' ( (lv_basicExpressions_2_0= ruleBasicExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleOrExpression1125); 

            	        	newLeafNode(otherlv_1, grammarAccess.getOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_0());
            	        
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:588:1: ( (lv_basicExpressions_2_0= ruleBasicExpression ) )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:589:1: (lv_basicExpressions_2_0= ruleBasicExpression )
            	    {
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:589:1: (lv_basicExpressions_2_0= ruleBasicExpression )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:590:3: lv_basicExpressions_2_0= ruleBasicExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOrExpressionAccess().getBasicExpressionsBasicExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleBasicExpression_in_ruleOrExpression1146);
            	    lv_basicExpressions_2_0=ruleBasicExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"basicExpressions",
            	            		lv_basicExpressions_2_0, 
            	            		"BasicExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleBasicExpression"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:614:1: entryRuleBasicExpression returns [EObject current=null] : iv_ruleBasicExpression= ruleBasicExpression EOF ;
    public final EObject entryRuleBasicExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicExpression = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:615:2: (iv_ruleBasicExpression= ruleBasicExpression EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:616:2: iv_ruleBasicExpression= ruleBasicExpression EOF
            {
             newCompositeNode(grammarAccess.getBasicExpressionRule()); 
            pushFollow(FOLLOW_ruleBasicExpression_in_entryRuleBasicExpression1184);
            iv_ruleBasicExpression=ruleBasicExpression();

            state._fsp--;

             current =iv_ruleBasicExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicExpression1194); 

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
    // $ANTLR end "entryRuleBasicExpression"


    // $ANTLR start "ruleBasicExpression"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:623:1: ruleBasicExpression returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleBasicExpression() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:626:28: ( ( ( (lv_negated_0_0= '!' ) )? ( (otherlv_1= RULE_ID ) ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:627:1: ( ( (lv_negated_0_0= '!' ) )? ( (otherlv_1= RULE_ID ) ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:627:1: ( ( (lv_negated_0_0= '!' ) )? ( (otherlv_1= RULE_ID ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:627:2: ( (lv_negated_0_0= '!' ) )? ( (otherlv_1= RULE_ID ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:627:2: ( (lv_negated_0_0= '!' ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==25) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:628:1: (lv_negated_0_0= '!' )
                    {
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:628:1: (lv_negated_0_0= '!' )
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:629:3: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,25,FOLLOW_25_in_ruleBasicExpression1237); 

                            newLeafNode(lv_negated_0_0, grammarAccess.getBasicExpressionAccess().getNegatedExclamationMarkKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBasicExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "negated", true, "!");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:642:3: ( (otherlv_1= RULE_ID ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:643:1: (otherlv_1= RULE_ID )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:643:1: (otherlv_1= RULE_ID )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:644:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBasicExpressionRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBasicExpression1271); 

            		newLeafNode(otherlv_1, grammarAccess.getBasicExpressionAccess().getExprCondVarCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleBasicExpression"


    // $ANTLR start "entryRuleMutexSet"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:663:1: entryRuleMutexSet returns [EObject current=null] : iv_ruleMutexSet= ruleMutexSet EOF ;
    public final EObject entryRuleMutexSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMutexSet = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:664:2: (iv_ruleMutexSet= ruleMutexSet EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:665:2: iv_ruleMutexSet= ruleMutexSet EOF
            {
             newCompositeNode(grammarAccess.getMutexSetRule()); 
            pushFollow(FOLLOW_ruleMutexSet_in_entryRuleMutexSet1307);
            iv_ruleMutexSet=ruleMutexSet();

            state._fsp--;

             current =iv_ruleMutexSet; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMutexSet1317); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:672:1: ruleMutexSet returns [EObject current=null] : (otherlv_0= 'mutex' otherlv_1= '{' ( (lv_methods_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_methods_4_0= RULE_ID ) ) )+ otherlv_5= '};' ) ;
    public final EObject ruleMutexSet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_methods_2_0=null;
        Token otherlv_3=null;
        Token lv_methods_4_0=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:675:28: ( (otherlv_0= 'mutex' otherlv_1= '{' ( (lv_methods_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_methods_4_0= RULE_ID ) ) )+ otherlv_5= '};' ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:676:1: (otherlv_0= 'mutex' otherlv_1= '{' ( (lv_methods_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_methods_4_0= RULE_ID ) ) )+ otherlv_5= '};' )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:676:1: (otherlv_0= 'mutex' otherlv_1= '{' ( (lv_methods_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_methods_4_0= RULE_ID ) ) )+ otherlv_5= '};' )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:676:3: otherlv_0= 'mutex' otherlv_1= '{' ( (lv_methods_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_methods_4_0= RULE_ID ) ) )+ otherlv_5= '};'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleMutexSet1354); 

                	newLeafNode(otherlv_0, grammarAccess.getMutexSetAccess().getMutexKeyword_0());
                
            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleMutexSet1366); 

                	newLeafNode(otherlv_1, grammarAccess.getMutexSetAccess().getLeftCurlyBracketKeyword_1());
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:684:1: ( (lv_methods_2_0= RULE_ID ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:685:1: (lv_methods_2_0= RULE_ID )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:685:1: (lv_methods_2_0= RULE_ID )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:686:3: lv_methods_2_0= RULE_ID
            {
            lv_methods_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMutexSet1383); 

            			newLeafNode(lv_methods_2_0, grammarAccess.getMutexSetAccess().getMethodsIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMutexSetRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"methods",
                    		lv_methods_2_0, 
                    		"ID");
            	    

            }


            }

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:702:2: (otherlv_3= ',' ( (lv_methods_4_0= RULE_ID ) ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==15) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:702:4: otherlv_3= ',' ( (lv_methods_4_0= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleMutexSet1401); 

            	        	newLeafNode(otherlv_3, grammarAccess.getMutexSetAccess().getCommaKeyword_3_0());
            	        
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:706:1: ( (lv_methods_4_0= RULE_ID ) )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:707:1: (lv_methods_4_0= RULE_ID )
            	    {
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:707:1: (lv_methods_4_0= RULE_ID )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:708:3: lv_methods_4_0= RULE_ID
            	    {
            	    lv_methods_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMutexSet1418); 

            	    			newLeafNode(lv_methods_4_0, grammarAccess.getMutexSetAccess().getMethodsIDTerminalRuleCall_3_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getMutexSetRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"methods",
            	            		lv_methods_4_0, 
            	            		"ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);

            otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleMutexSet1437); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:736:1: entryRuleCondVar returns [EObject current=null] : iv_ruleCondVar= ruleCondVar EOF ;
    public final EObject entryRuleCondVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondVar = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:737:2: (iv_ruleCondVar= ruleCondVar EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:738:2: iv_ruleCondVar= ruleCondVar EOF
            {
             newCompositeNode(grammarAccess.getCondVarRule()); 
            pushFollow(FOLLOW_ruleCondVar_in_entryRuleCondVar1473);
            iv_ruleCondVar=ruleCondVar();

            state._fsp--;

             current =iv_ruleCondVar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCondVar1483); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:745:1: ruleCondVar returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) ) ) ;
    public final EObject ruleCondVar() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:748:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:749:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:749:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:749:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:749:2: ( (lv_name_0_0= RULE_ID ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:750:1: (lv_name_0_0= RULE_ID )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:750:1: (lv_name_0_0= RULE_ID )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:751:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCondVar1525); 

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

            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleCondVar1542); 

                	newLeafNode(otherlv_1, grammarAccess.getCondVarAccess().getEqualsSignKeyword_1());
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:771:1: ( (lv_value_2_0= ruleBooleanVal ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:772:1: (lv_value_2_0= ruleBooleanVal )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:772:1: (lv_value_2_0= ruleBooleanVal )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:773:3: lv_value_2_0= ruleBooleanVal
            {
             
            	        newCompositeNode(grammarAccess.getCondVarAccess().getValueBooleanValParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleBooleanVal_in_ruleCondVar1563);
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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:797:1: entryRuleOrdVar returns [EObject current=null] : iv_ruleOrdVar= ruleOrdVar EOF ;
    public final EObject entryRuleOrdVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrdVar = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:798:2: (iv_ruleOrdVar= ruleOrdVar EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:799:2: iv_ruleOrdVar= ruleOrdVar EOF
            {
             newCompositeNode(grammarAccess.getOrdVarRule()); 
            pushFollow(FOLLOW_ruleOrdVar_in_entryRuleOrdVar1599);
            iv_ruleOrdVar=ruleOrdVar();

            state._fsp--;

             current =iv_ruleOrdVar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrdVar1609); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:806:1: ruleOrdVar returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_INT ) ) ) ;
    public final EObject ruleOrdVar() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:809:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_INT ) ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:810:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_INT ) ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:810:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_INT ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:810:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_INT ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:810:2: ( (lv_name_0_0= RULE_ID ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:811:1: (lv_name_0_0= RULE_ID )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:811:1: (lv_name_0_0= RULE_ID )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:812:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOrdVar1651); 

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

            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleOrdVar1668); 

                	newLeafNode(otherlv_1, grammarAccess.getOrdVarAccess().getEqualsSignKeyword_1());
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:832:1: ( (lv_value_2_0= RULE_INT ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:833:1: (lv_value_2_0= RULE_INT )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:833:1: (lv_value_2_0= RULE_INT )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:834:3: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleOrdVar1685); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:858:1: entryRuleBooleanVal returns [String current=null] : iv_ruleBooleanVal= ruleBooleanVal EOF ;
    public final String entryRuleBooleanVal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBooleanVal = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:859:2: (iv_ruleBooleanVal= ruleBooleanVal EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:860:2: iv_ruleBooleanVal= ruleBooleanVal EOF
            {
             newCompositeNode(grammarAccess.getBooleanValRule()); 
            pushFollow(FOLLOW_ruleBooleanVal_in_entryRuleBooleanVal1727);
            iv_ruleBooleanVal=ruleBooleanVal();

            state._fsp--;

             current =iv_ruleBooleanVal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanVal1738); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:867:1: ruleBooleanVal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleBooleanVal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:870:28: ( (kw= 'true' | kw= 'false' ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:871:1: (kw= 'true' | kw= 'false' )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:871:1: (kw= 'true' | kw= 'false' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==29) ) {
                alt18=1;
            }
            else if ( (LA18_0==30) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:872:2: kw= 'true'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleBooleanVal1776); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBooleanValAccess().getTrueKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:879:2: kw= 'false'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleBooleanVal1795); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:892:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:893:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:894:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1836);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1847); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:901:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:904:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:905:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:905:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:905:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName1887); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:912:1: (kw= '.' this_ID_2= RULE_ID )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==31) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:913:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,31,FOLLOW_31_in_ruleQualifiedName1906); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName1921); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop19;
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
    public static final BitSet FOLLOW_13_in_ruleCoordinatorBody280 = new BitSet(new long[]{0x00000000041E4010L});
    public static final BitSet FOLLOW_14_in_ruleCoordinatorBody302 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCondVar_in_ruleCoordinatorBody323 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleCoordinatorBody336 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCondVar_in_ruleCoordinatorBody357 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_ruleCoordinatorBody371 = new BitSet(new long[]{0x00000000041E4010L});
    public static final BitSet FOLLOW_17_in_ruleCoordinatorBody386 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleOrdVar_in_ruleCoordinatorBody407 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleCoordinatorBody420 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleOrdVar_in_ruleCoordinatorBody441 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_ruleCoordinatorBody455 = new BitSet(new long[]{0x00000000041E0010L});
    public static final BitSet FOLLOW_18_in_ruleCoordinatorBody470 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCoordinatorBody491 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleCoordinatorBody504 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCoordinatorBody525 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_ruleCoordinatorBody539 = new BitSet(new long[]{0x0000000004180010L});
    public static final BitSet FOLLOW_ruleMutexSet_in_ruleCoordinatorBody562 = new BitSet(new long[]{0x0000000004180010L});
    public static final BitSet FOLLOW_ruleGuard_in_ruleCoordinatorBody584 = new BitSet(new long[]{0x0000000000180010L});
    public static final BitSet FOLLOW_19_in_ruleCoordinatorBody597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_entryRuleGuard633 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuard643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleGuard681 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGuard700 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_15_in_ruleGuard718 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGuard735 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_21_in_ruleGuard754 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleRequires_in_ruleGuard775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequires_in_entryRuleRequires812 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequires822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleRequires859 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleRequires880 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleRequires892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_entryRuleAndExpression928 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndExpression938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_ruleAndExpression984 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleAndExpression997 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_ruleOrExpression_in_ruleAndExpression1018 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_entryRuleOrExpression1056 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrExpression1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicExpression_in_ruleOrExpression1112 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleOrExpression1125 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_ruleBasicExpression_in_ruleOrExpression1146 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ruleBasicExpression_in_entryRuleBasicExpression1184 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicExpression1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleBasicExpression1237 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBasicExpression1271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMutexSet_in_entryRuleMutexSet1307 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMutexSet1317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleMutexSet1354 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleMutexSet1366 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMutexSet1383 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleMutexSet1401 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMutexSet1418 = new BitSet(new long[]{0x0000000008008000L});
    public static final BitSet FOLLOW_27_in_ruleMutexSet1437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondVar_in_entryRuleCondVar1473 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCondVar1483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCondVar1525 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleCondVar1542 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_ruleBooleanVal_in_ruleCondVar1563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrdVar_in_entryRuleOrdVar1599 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrdVar1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOrdVar1651 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleOrdVar1668 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleOrdVar1685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanVal_in_entryRuleBooleanVal1727 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanVal1738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleBooleanVal1776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleBooleanVal1795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1836 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName1887 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleQualifiedName1906 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName1921 = new BitSet(new long[]{0x0000000080000002L});

}