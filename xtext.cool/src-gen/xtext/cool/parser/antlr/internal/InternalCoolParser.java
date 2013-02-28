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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'per_class'", "'coordinator'", "'{'", "'condition'", "','", "';'", "'int'", "'selfex'", "'}'", "'guard'", "':'", "'on_entry'", "'on_exit'", "'if'", "'('", "')'", "'=='", "'!='", "'true'", "'false'", "'='", "'requires'", "'&&'", "'||'", "'!'", "'mutex'", "'};'", "'.'"
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
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__12=12;
    public static final int T__38=38;
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

                if ( (LA9_0==36) ) {
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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:367:1: ruleGuard returns [EObject current=null] : ( (otherlv_0= 'guard' )? ( (lv_methods_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_methods_3_0= RULE_ID ) ) )* otherlv_4= ':' ( (lv_requires_5_0= ruleRequires ) )? (otherlv_6= 'on_entry' otherlv_7= '{' ( ( (lv_onEntryIfStatements_8_0= ruleIfStatement ) ) | ( (lv_onEntryAssignStatements_9_0= ruleAssignStatement ) ) )+ otherlv_10= '}' )? (otherlv_11= 'on_exit' otherlv_12= '{' ( ( (lv_onExitIfStatements_13_0= ruleIfStatement ) ) | ( (lv_onExitAssignStatements_14_0= ruleAssignStatement ) ) )+ otherlv_15= '}' )? ) ;
    public final EObject ruleGuard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_methods_1_0=null;
        Token otherlv_2=null;
        Token lv_methods_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        EObject lv_requires_5_0 = null;

        EObject lv_onEntryIfStatements_8_0 = null;

        EObject lv_onEntryAssignStatements_9_0 = null;

        EObject lv_onExitIfStatements_13_0 = null;

        EObject lv_onExitAssignStatements_14_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:370:28: ( ( (otherlv_0= 'guard' )? ( (lv_methods_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_methods_3_0= RULE_ID ) ) )* otherlv_4= ':' ( (lv_requires_5_0= ruleRequires ) )? (otherlv_6= 'on_entry' otherlv_7= '{' ( ( (lv_onEntryIfStatements_8_0= ruleIfStatement ) ) | ( (lv_onEntryAssignStatements_9_0= ruleAssignStatement ) ) )+ otherlv_10= '}' )? (otherlv_11= 'on_exit' otherlv_12= '{' ( ( (lv_onExitIfStatements_13_0= ruleIfStatement ) ) | ( (lv_onExitAssignStatements_14_0= ruleAssignStatement ) ) )+ otherlv_15= '}' )? ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:371:1: ( (otherlv_0= 'guard' )? ( (lv_methods_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_methods_3_0= RULE_ID ) ) )* otherlv_4= ':' ( (lv_requires_5_0= ruleRequires ) )? (otherlv_6= 'on_entry' otherlv_7= '{' ( ( (lv_onEntryIfStatements_8_0= ruleIfStatement ) ) | ( (lv_onEntryAssignStatements_9_0= ruleAssignStatement ) ) )+ otherlv_10= '}' )? (otherlv_11= 'on_exit' otherlv_12= '{' ( ( (lv_onExitIfStatements_13_0= ruleIfStatement ) ) | ( (lv_onExitAssignStatements_14_0= ruleAssignStatement ) ) )+ otherlv_15= '}' )? )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:371:1: ( (otherlv_0= 'guard' )? ( (lv_methods_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_methods_3_0= RULE_ID ) ) )* otherlv_4= ':' ( (lv_requires_5_0= ruleRequires ) )? (otherlv_6= 'on_entry' otherlv_7= '{' ( ( (lv_onEntryIfStatements_8_0= ruleIfStatement ) ) | ( (lv_onEntryAssignStatements_9_0= ruleAssignStatement ) ) )+ otherlv_10= '}' )? (otherlv_11= 'on_exit' otherlv_12= '{' ( ( (lv_onExitIfStatements_13_0= ruleIfStatement ) ) | ( (lv_onExitAssignStatements_14_0= ruleAssignStatement ) ) )+ otherlv_15= '}' )? )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:371:2: (otherlv_0= 'guard' )? ( (lv_methods_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_methods_3_0= RULE_ID ) ) )* otherlv_4= ':' ( (lv_requires_5_0= ruleRequires ) )? (otherlv_6= 'on_entry' otherlv_7= '{' ( ( (lv_onEntryIfStatements_8_0= ruleIfStatement ) ) | ( (lv_onEntryAssignStatements_9_0= ruleAssignStatement ) ) )+ otherlv_10= '}' )? (otherlv_11= 'on_exit' otherlv_12= '{' ( ( (lv_onExitIfStatements_13_0= ruleIfStatement ) ) | ( (lv_onExitAssignStatements_14_0= ruleAssignStatement ) ) )+ otherlv_15= '}' )?
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

            if ( (LA13_0==32) ) {
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

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:437:3: (otherlv_6= 'on_entry' otherlv_7= '{' ( ( (lv_onEntryIfStatements_8_0= ruleIfStatement ) ) | ( (lv_onEntryAssignStatements_9_0= ruleAssignStatement ) ) )+ otherlv_10= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:437:5: otherlv_6= 'on_entry' otherlv_7= '{' ( ( (lv_onEntryIfStatements_8_0= ruleIfStatement ) ) | ( (lv_onEntryAssignStatements_9_0= ruleAssignStatement ) ) )+ otherlv_10= '}'
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_22_in_ruleGuard789); 

                        	newLeafNode(otherlv_6, grammarAccess.getGuardAccess().getOn_entryKeyword_5_0());
                        
                    otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleGuard801); 

                        	newLeafNode(otherlv_7, grammarAccess.getGuardAccess().getLeftCurlyBracketKeyword_5_1());
                        
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:445:1: ( ( (lv_onEntryIfStatements_8_0= ruleIfStatement ) ) | ( (lv_onEntryAssignStatements_9_0= ruleAssignStatement ) ) )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=3;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==24) ) {
                            alt14=1;
                        }
                        else if ( (LA14_0==RULE_ID) ) {
                            alt14=2;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:445:2: ( (lv_onEntryIfStatements_8_0= ruleIfStatement ) )
                    	    {
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:445:2: ( (lv_onEntryIfStatements_8_0= ruleIfStatement ) )
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:446:1: (lv_onEntryIfStatements_8_0= ruleIfStatement )
                    	    {
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:446:1: (lv_onEntryIfStatements_8_0= ruleIfStatement )
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:447:3: lv_onEntryIfStatements_8_0= ruleIfStatement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getGuardAccess().getOnEntryIfStatementsIfStatementParserRuleCall_5_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleIfStatement_in_ruleGuard823);
                    	    lv_onEntryIfStatements_8_0=ruleIfStatement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getGuardRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"onEntryIfStatements",
                    	            		lv_onEntryIfStatements_8_0, 
                    	            		"IfStatement");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:464:6: ( (lv_onEntryAssignStatements_9_0= ruleAssignStatement ) )
                    	    {
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:464:6: ( (lv_onEntryAssignStatements_9_0= ruleAssignStatement ) )
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:465:1: (lv_onEntryAssignStatements_9_0= ruleAssignStatement )
                    	    {
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:465:1: (lv_onEntryAssignStatements_9_0= ruleAssignStatement )
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:466:3: lv_onEntryAssignStatements_9_0= ruleAssignStatement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getGuardAccess().getOnEntryAssignStatementsAssignStatementParserRuleCall_5_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAssignStatement_in_ruleGuard850);
                    	    lv_onEntryAssignStatements_9_0=ruleAssignStatement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getGuardRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"onEntryAssignStatements",
                    	            		lv_onEntryAssignStatements_9_0, 
                    	            		"AssignStatement");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);

                    otherlv_10=(Token)match(input,19,FOLLOW_19_in_ruleGuard864); 

                        	newLeafNode(otherlv_10, grammarAccess.getGuardAccess().getRightCurlyBracketKeyword_5_3());
                        

                    }
                    break;

            }

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:486:3: (otherlv_11= 'on_exit' otherlv_12= '{' ( ( (lv_onExitIfStatements_13_0= ruleIfStatement ) ) | ( (lv_onExitAssignStatements_14_0= ruleAssignStatement ) ) )+ otherlv_15= '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==23) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:486:5: otherlv_11= 'on_exit' otherlv_12= '{' ( ( (lv_onExitIfStatements_13_0= ruleIfStatement ) ) | ( (lv_onExitAssignStatements_14_0= ruleAssignStatement ) ) )+ otherlv_15= '}'
                    {
                    otherlv_11=(Token)match(input,23,FOLLOW_23_in_ruleGuard879); 

                        	newLeafNode(otherlv_11, grammarAccess.getGuardAccess().getOn_exitKeyword_6_0());
                        
                    otherlv_12=(Token)match(input,13,FOLLOW_13_in_ruleGuard891); 

                        	newLeafNode(otherlv_12, grammarAccess.getGuardAccess().getLeftCurlyBracketKeyword_6_1());
                        
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:494:1: ( ( (lv_onExitIfStatements_13_0= ruleIfStatement ) ) | ( (lv_onExitAssignStatements_14_0= ruleAssignStatement ) ) )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=3;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==24) ) {
                            alt16=1;
                        }
                        else if ( (LA16_0==RULE_ID) ) {
                            alt16=2;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:494:2: ( (lv_onExitIfStatements_13_0= ruleIfStatement ) )
                    	    {
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:494:2: ( (lv_onExitIfStatements_13_0= ruleIfStatement ) )
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:495:1: (lv_onExitIfStatements_13_0= ruleIfStatement )
                    	    {
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:495:1: (lv_onExitIfStatements_13_0= ruleIfStatement )
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:496:3: lv_onExitIfStatements_13_0= ruleIfStatement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getGuardAccess().getOnExitIfStatementsIfStatementParserRuleCall_6_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleIfStatement_in_ruleGuard913);
                    	    lv_onExitIfStatements_13_0=ruleIfStatement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getGuardRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"onExitIfStatements",
                    	            		lv_onExitIfStatements_13_0, 
                    	            		"IfStatement");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:513:6: ( (lv_onExitAssignStatements_14_0= ruleAssignStatement ) )
                    	    {
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:513:6: ( (lv_onExitAssignStatements_14_0= ruleAssignStatement ) )
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:514:1: (lv_onExitAssignStatements_14_0= ruleAssignStatement )
                    	    {
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:514:1: (lv_onExitAssignStatements_14_0= ruleAssignStatement )
                    	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:515:3: lv_onExitAssignStatements_14_0= ruleAssignStatement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getGuardAccess().getOnExitAssignStatementsAssignStatementParserRuleCall_6_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAssignStatement_in_ruleGuard940);
                    	    lv_onExitAssignStatements_14_0=ruleAssignStatement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getGuardRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"onExitAssignStatements",
                    	            		lv_onExitAssignStatements_14_0, 
                    	            		"AssignStatement");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);

                    otherlv_15=(Token)match(input,19,FOLLOW_19_in_ruleGuard954); 

                        	newLeafNode(otherlv_15, grammarAccess.getGuardAccess().getRightCurlyBracketKeyword_6_3());
                        

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


    // $ANTLR start "entryRuleIfStatement"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:543:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:544:2: (iv_ruleIfStatement= ruleIfStatement EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:545:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
             newCompositeNode(grammarAccess.getIfStatementRule()); 
            pushFollow(FOLLOW_ruleIfStatement_in_entryRuleIfStatement992);
            iv_ruleIfStatement=ruleIfStatement();

            state._fsp--;

             current =iv_ruleIfStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfStatement1002); 

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
    // $ANTLR end "entryRuleIfStatement"


    // $ANTLR start "ruleIfStatement"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:552:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_expression_2_0= ruleIfExpression ) ) otherlv_3= ')' ( (lv_statement_4_0= ruleAssignStatement ) ) ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expression_2_0 = null;

        EObject lv_statement_4_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:555:28: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_expression_2_0= ruleIfExpression ) ) otherlv_3= ')' ( (lv_statement_4_0= ruleAssignStatement ) ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:556:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expression_2_0= ruleIfExpression ) ) otherlv_3= ')' ( (lv_statement_4_0= ruleAssignStatement ) ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:556:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expression_2_0= ruleIfExpression ) ) otherlv_3= ')' ( (lv_statement_4_0= ruleAssignStatement ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:556:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_expression_2_0= ruleIfExpression ) ) otherlv_3= ')' ( (lv_statement_4_0= ruleAssignStatement ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleIfStatement1039); 

                	newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
                
            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleIfStatement1051); 

                	newLeafNode(otherlv_1, grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_1());
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:564:1: ( (lv_expression_2_0= ruleIfExpression ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:565:1: (lv_expression_2_0= ruleIfExpression )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:565:1: (lv_expression_2_0= ruleIfExpression )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:566:3: lv_expression_2_0= ruleIfExpression
            {
             
            	        newCompositeNode(grammarAccess.getIfStatementAccess().getExpressionIfExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleIfExpression_in_ruleIfStatement1072);
            lv_expression_2_0=ruleIfExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIfStatementRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_2_0, 
                    		"IfExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleIfStatement1084); 

                	newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_3());
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:586:1: ( (lv_statement_4_0= ruleAssignStatement ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:587:1: (lv_statement_4_0= ruleAssignStatement )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:587:1: (lv_statement_4_0= ruleAssignStatement )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:588:3: lv_statement_4_0= ruleAssignStatement
            {
             
            	        newCompositeNode(grammarAccess.getIfStatementAccess().getStatementAssignStatementParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleAssignStatement_in_ruleIfStatement1105);
            lv_statement_4_0=ruleAssignStatement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIfStatementRule());
            	        }
                   		set(
                   			current, 
                   			"statement",
                    		lv_statement_4_0, 
                    		"AssignStatement");
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
    // $ANTLR end "ruleIfStatement"


    // $ANTLR start "entryRuleIfExpression"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:612:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:613:2: (iv_ruleIfExpression= ruleIfExpression EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:614:2: iv_ruleIfExpression= ruleIfExpression EOF
            {
             newCompositeNode(grammarAccess.getIfExpressionRule()); 
            pushFollow(FOLLOW_ruleIfExpression_in_entryRuleIfExpression1141);
            iv_ruleIfExpression=ruleIfExpression();

            state._fsp--;

             current =iv_ruleIfExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfExpression1151); 

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
    // $ANTLR end "entryRuleIfExpression"


    // $ANTLR start "ruleIfExpression"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:621:1: ruleIfExpression returns [EObject current=null] : ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' ) ) ) ( (lv_assignment_2_0= ruleAssignedValue ) ) ) ;
    public final EObject ruleIfExpression() throws RecognitionException {
        EObject current = null;

        Token lv_var_0_0=null;
        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_assignment_2_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:624:28: ( ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' ) ) ) ( (lv_assignment_2_0= ruleAssignedValue ) ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:625:1: ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' ) ) ) ( (lv_assignment_2_0= ruleAssignedValue ) ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:625:1: ( ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' ) ) ) ( (lv_assignment_2_0= ruleAssignedValue ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:625:2: ( (lv_var_0_0= RULE_ID ) ) ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' ) ) ) ( (lv_assignment_2_0= ruleAssignedValue ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:625:2: ( (lv_var_0_0= RULE_ID ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:626:1: (lv_var_0_0= RULE_ID )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:626:1: (lv_var_0_0= RULE_ID )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:627:3: lv_var_0_0= RULE_ID
            {
            lv_var_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIfExpression1193); 

            			newLeafNode(lv_var_0_0, grammarAccess.getIfExpressionAccess().getVarIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIfExpressionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"var",
                    		lv_var_0_0, 
                    		"ID");
            	    

            }


            }

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:643:2: ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:644:1: ( (lv_op_1_1= '==' | lv_op_1_2= '!=' ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:644:1: ( (lv_op_1_1= '==' | lv_op_1_2= '!=' ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:645:1: (lv_op_1_1= '==' | lv_op_1_2= '!=' )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:645:1: (lv_op_1_1= '==' | lv_op_1_2= '!=' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            else if ( (LA18_0==28) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:646:3: lv_op_1_1= '=='
                    {
                    lv_op_1_1=(Token)match(input,27,FOLLOW_27_in_ruleIfExpression1218); 

                            newLeafNode(lv_op_1_1, grammarAccess.getIfExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIfExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:658:8: lv_op_1_2= '!='
                    {
                    lv_op_1_2=(Token)match(input,28,FOLLOW_28_in_ruleIfExpression1247); 

                            newLeafNode(lv_op_1_2, grammarAccess.getIfExpressionAccess().getOpExclamationMarkEqualsSignKeyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIfExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_2, null);
                    	    

                    }
                    break;

            }


            }


            }

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:673:2: ( (lv_assignment_2_0= ruleAssignedValue ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:674:1: (lv_assignment_2_0= ruleAssignedValue )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:674:1: (lv_assignment_2_0= ruleAssignedValue )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:675:3: lv_assignment_2_0= ruleAssignedValue
            {
             
            	        newCompositeNode(grammarAccess.getIfExpressionAccess().getAssignmentAssignedValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleAssignedValue_in_ruleIfExpression1284);
            lv_assignment_2_0=ruleAssignedValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIfExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"assignment",
                    		lv_assignment_2_0, 
                    		"AssignedValue");
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
    // $ANTLR end "ruleIfExpression"


    // $ANTLR start "entryRuleAssignedValue"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:699:1: entryRuleAssignedValue returns [EObject current=null] : iv_ruleAssignedValue= ruleAssignedValue EOF ;
    public final EObject entryRuleAssignedValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignedValue = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:700:2: (iv_ruleAssignedValue= ruleAssignedValue EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:701:2: iv_ruleAssignedValue= ruleAssignedValue EOF
            {
             newCompositeNode(grammarAccess.getAssignedValueRule()); 
            pushFollow(FOLLOW_ruleAssignedValue_in_entryRuleAssignedValue1320);
            iv_ruleAssignedValue=ruleAssignedValue();

            state._fsp--;

             current =iv_ruleAssignedValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignedValue1330); 

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
    // $ANTLR end "entryRuleAssignedValue"


    // $ANTLR start "ruleAssignedValue"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:708:1: ruleAssignedValue returns [EObject current=null] : ( ( (lv_intval_0_0= RULE_INT ) ) | ( ( (lv_boolval_1_1= 'true' | lv_boolval_1_2= 'false' ) ) ) ) ;
    public final EObject ruleAssignedValue() throws RecognitionException {
        EObject current = null;

        Token lv_intval_0_0=null;
        Token lv_boolval_1_1=null;
        Token lv_boolval_1_2=null;

         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:711:28: ( ( ( (lv_intval_0_0= RULE_INT ) ) | ( ( (lv_boolval_1_1= 'true' | lv_boolval_1_2= 'false' ) ) ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:712:1: ( ( (lv_intval_0_0= RULE_INT ) ) | ( ( (lv_boolval_1_1= 'true' | lv_boolval_1_2= 'false' ) ) ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:712:1: ( ( (lv_intval_0_0= RULE_INT ) ) | ( ( (lv_boolval_1_1= 'true' | lv_boolval_1_2= 'false' ) ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_INT) ) {
                alt20=1;
            }
            else if ( ((LA20_0>=29 && LA20_0<=30)) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:712:2: ( (lv_intval_0_0= RULE_INT ) )
                    {
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:712:2: ( (lv_intval_0_0= RULE_INT ) )
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:713:1: (lv_intval_0_0= RULE_INT )
                    {
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:713:1: (lv_intval_0_0= RULE_INT )
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:714:3: lv_intval_0_0= RULE_INT
                    {
                    lv_intval_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAssignedValue1372); 

                    			newLeafNode(lv_intval_0_0, grammarAccess.getAssignedValueAccess().getIntvalINTTerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAssignedValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"intval",
                            		lv_intval_0_0, 
                            		"INT");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:731:6: ( ( (lv_boolval_1_1= 'true' | lv_boolval_1_2= 'false' ) ) )
                    {
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:731:6: ( ( (lv_boolval_1_1= 'true' | lv_boolval_1_2= 'false' ) ) )
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:732:1: ( (lv_boolval_1_1= 'true' | lv_boolval_1_2= 'false' ) )
                    {
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:732:1: ( (lv_boolval_1_1= 'true' | lv_boolval_1_2= 'false' ) )
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:733:1: (lv_boolval_1_1= 'true' | lv_boolval_1_2= 'false' )
                    {
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:733:1: (lv_boolval_1_1= 'true' | lv_boolval_1_2= 'false' )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==29) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==30) ) {
                        alt19=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:734:3: lv_boolval_1_1= 'true'
                            {
                            lv_boolval_1_1=(Token)match(input,29,FOLLOW_29_in_ruleAssignedValue1403); 

                                    newLeafNode(lv_boolval_1_1, grammarAccess.getAssignedValueAccess().getBoolvalTrueKeyword_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getAssignedValueRule());
                            	        }
                                   		setWithLastConsumed(current, "boolval", lv_boolval_1_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:746:8: lv_boolval_1_2= 'false'
                            {
                            lv_boolval_1_2=(Token)match(input,30,FOLLOW_30_in_ruleAssignedValue1432); 

                                    newLeafNode(lv_boolval_1_2, grammarAccess.getAssignedValueAccess().getBoolvalFalseKeyword_1_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getAssignedValueRule());
                            	        }
                                   		setWithLastConsumed(current, "boolval", lv_boolval_1_2, null);
                            	    

                            }
                            break;

                    }


                    }


                    }


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
    // $ANTLR end "ruleAssignedValue"


    // $ANTLR start "entryRuleAssignStatement"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:769:1: entryRuleAssignStatement returns [EObject current=null] : iv_ruleAssignStatement= ruleAssignStatement EOF ;
    public final EObject entryRuleAssignStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignStatement = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:770:2: (iv_ruleAssignStatement= ruleAssignStatement EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:771:2: iv_ruleAssignStatement= ruleAssignStatement EOF
            {
             newCompositeNode(grammarAccess.getAssignStatementRule()); 
            pushFollow(FOLLOW_ruleAssignStatement_in_entryRuleAssignStatement1484);
            iv_ruleAssignStatement=ruleAssignStatement();

            state._fsp--;

             current =iv_ruleAssignStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignStatement1494); 

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
    // $ANTLR end "entryRuleAssignStatement"


    // $ANTLR start "ruleAssignStatement"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:778:1: ruleAssignStatement returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) ) otherlv_3= ';' ) ;
    public final EObject ruleAssignStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:781:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) ) otherlv_3= ';' ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:782:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) ) otherlv_3= ';' )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:782:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) ) otherlv_3= ';' )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:782:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) ) otherlv_3= ';'
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:782:2: ( (otherlv_0= RULE_ID ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:783:1: (otherlv_0= RULE_ID )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:783:1: (otherlv_0= RULE_ID )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:784:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAssignStatementRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignStatement1539); 

            		newLeafNode(otherlv_0, grammarAccess.getAssignStatementAccess().getVarCondVarCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleAssignStatement1551); 

                	newLeafNode(otherlv_1, grammarAccess.getAssignStatementAccess().getEqualsSignKeyword_1());
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:799:1: ( (lv_value_2_0= ruleBooleanVal ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:800:1: (lv_value_2_0= ruleBooleanVal )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:800:1: (lv_value_2_0= ruleBooleanVal )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:801:3: lv_value_2_0= ruleBooleanVal
            {
             
            	        newCompositeNode(grammarAccess.getAssignStatementAccess().getValueBooleanValParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleBooleanVal_in_ruleAssignStatement1572);
            lv_value_2_0=ruleBooleanVal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAssignStatementRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"BooleanVal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleAssignStatement1584); 

                	newLeafNode(otherlv_3, grammarAccess.getAssignStatementAccess().getSemicolonKeyword_3());
                

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
    // $ANTLR end "ruleAssignStatement"


    // $ANTLR start "entryRuleRequires"
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:829:1: entryRuleRequires returns [EObject current=null] : iv_ruleRequires= ruleRequires EOF ;
    public final EObject entryRuleRequires() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequires = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:830:2: (iv_ruleRequires= ruleRequires EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:831:2: iv_ruleRequires= ruleRequires EOF
            {
             newCompositeNode(grammarAccess.getRequiresRule()); 
            pushFollow(FOLLOW_ruleRequires_in_entryRuleRequires1620);
            iv_ruleRequires=ruleRequires();

            state._fsp--;

             current =iv_ruleRequires; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequires1630); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:838:1: ruleRequires returns [EObject current=null] : (otherlv_0= 'requires' ( (lv_andExpression_1_0= ruleAndExpression ) ) otherlv_2= ';' ) ;
    public final EObject ruleRequires() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_andExpression_1_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:841:28: ( (otherlv_0= 'requires' ( (lv_andExpression_1_0= ruleAndExpression ) ) otherlv_2= ';' ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:842:1: (otherlv_0= 'requires' ( (lv_andExpression_1_0= ruleAndExpression ) ) otherlv_2= ';' )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:842:1: (otherlv_0= 'requires' ( (lv_andExpression_1_0= ruleAndExpression ) ) otherlv_2= ';' )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:842:3: otherlv_0= 'requires' ( (lv_andExpression_1_0= ruleAndExpression ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleRequires1667); 

                	newLeafNode(otherlv_0, grammarAccess.getRequiresAccess().getRequiresKeyword_0());
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:846:1: ( (lv_andExpression_1_0= ruleAndExpression ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:847:1: (lv_andExpression_1_0= ruleAndExpression )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:847:1: (lv_andExpression_1_0= ruleAndExpression )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:848:3: lv_andExpression_1_0= ruleAndExpression
            {
             
            	        newCompositeNode(grammarAccess.getRequiresAccess().getAndExpressionAndExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAndExpression_in_ruleRequires1688);
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

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleRequires1700); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:876:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:877:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:878:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
             newCompositeNode(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_ruleAndExpression_in_entryRuleAndExpression1736);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;

             current =iv_ruleAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndExpression1746); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:885:1: ruleAndExpression returns [EObject current=null] : ( ( (lv_orExpressions_0_0= ruleOrExpression ) ) (otherlv_1= '&&' ( (lv_orExpressions_2_0= ruleOrExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_orExpressions_0_0 = null;

        EObject lv_orExpressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:888:28: ( ( ( (lv_orExpressions_0_0= ruleOrExpression ) ) (otherlv_1= '&&' ( (lv_orExpressions_2_0= ruleOrExpression ) ) )* ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:889:1: ( ( (lv_orExpressions_0_0= ruleOrExpression ) ) (otherlv_1= '&&' ( (lv_orExpressions_2_0= ruleOrExpression ) ) )* )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:889:1: ( ( (lv_orExpressions_0_0= ruleOrExpression ) ) (otherlv_1= '&&' ( (lv_orExpressions_2_0= ruleOrExpression ) ) )* )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:889:2: ( (lv_orExpressions_0_0= ruleOrExpression ) ) (otherlv_1= '&&' ( (lv_orExpressions_2_0= ruleOrExpression ) ) )*
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:889:2: ( (lv_orExpressions_0_0= ruleOrExpression ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:890:1: (lv_orExpressions_0_0= ruleOrExpression )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:890:1: (lv_orExpressions_0_0= ruleOrExpression )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:891:3: lv_orExpressions_0_0= ruleOrExpression
            {
             
            	        newCompositeNode(grammarAccess.getAndExpressionAccess().getOrExpressionsOrExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleOrExpression_in_ruleAndExpression1792);
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

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:907:2: (otherlv_1= '&&' ( (lv_orExpressions_2_0= ruleOrExpression ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==33) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:907:4: otherlv_1= '&&' ( (lv_orExpressions_2_0= ruleOrExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleAndExpression1805); 

            	        	newLeafNode(otherlv_1, grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_0());
            	        
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:911:1: ( (lv_orExpressions_2_0= ruleOrExpression ) )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:912:1: (lv_orExpressions_2_0= ruleOrExpression )
            	    {
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:912:1: (lv_orExpressions_2_0= ruleOrExpression )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:913:3: lv_orExpressions_2_0= ruleOrExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAndExpressionAccess().getOrExpressionsOrExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleOrExpression_in_ruleAndExpression1826);
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
            	    break loop21;
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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:937:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:938:2: (iv_ruleOrExpression= ruleOrExpression EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:939:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
             newCompositeNode(grammarAccess.getOrExpressionRule()); 
            pushFollow(FOLLOW_ruleOrExpression_in_entryRuleOrExpression1864);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;

             current =iv_ruleOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrExpression1874); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:946:1: ruleOrExpression returns [EObject current=null] : ( ( (lv_basicExpressions_0_0= ruleBasicExpression ) ) (otherlv_1= '||' ( (lv_basicExpressions_2_0= ruleBasicExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_basicExpressions_0_0 = null;

        EObject lv_basicExpressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:949:28: ( ( ( (lv_basicExpressions_0_0= ruleBasicExpression ) ) (otherlv_1= '||' ( (lv_basicExpressions_2_0= ruleBasicExpression ) ) )* ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:950:1: ( ( (lv_basicExpressions_0_0= ruleBasicExpression ) ) (otherlv_1= '||' ( (lv_basicExpressions_2_0= ruleBasicExpression ) ) )* )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:950:1: ( ( (lv_basicExpressions_0_0= ruleBasicExpression ) ) (otherlv_1= '||' ( (lv_basicExpressions_2_0= ruleBasicExpression ) ) )* )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:950:2: ( (lv_basicExpressions_0_0= ruleBasicExpression ) ) (otherlv_1= '||' ( (lv_basicExpressions_2_0= ruleBasicExpression ) ) )*
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:950:2: ( (lv_basicExpressions_0_0= ruleBasicExpression ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:951:1: (lv_basicExpressions_0_0= ruleBasicExpression )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:951:1: (lv_basicExpressions_0_0= ruleBasicExpression )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:952:3: lv_basicExpressions_0_0= ruleBasicExpression
            {
             
            	        newCompositeNode(grammarAccess.getOrExpressionAccess().getBasicExpressionsBasicExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleBasicExpression_in_ruleOrExpression1920);
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

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:968:2: (otherlv_1= '||' ( (lv_basicExpressions_2_0= ruleBasicExpression ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==34) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:968:4: otherlv_1= '||' ( (lv_basicExpressions_2_0= ruleBasicExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleOrExpression1933); 

            	        	newLeafNode(otherlv_1, grammarAccess.getOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_0());
            	        
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:972:1: ( (lv_basicExpressions_2_0= ruleBasicExpression ) )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:973:1: (lv_basicExpressions_2_0= ruleBasicExpression )
            	    {
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:973:1: (lv_basicExpressions_2_0= ruleBasicExpression )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:974:3: lv_basicExpressions_2_0= ruleBasicExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOrExpressionAccess().getBasicExpressionsBasicExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleBasicExpression_in_ruleOrExpression1954);
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
            	    break loop22;
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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:998:1: entryRuleBasicExpression returns [EObject current=null] : iv_ruleBasicExpression= ruleBasicExpression EOF ;
    public final EObject entryRuleBasicExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicExpression = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:999:2: (iv_ruleBasicExpression= ruleBasicExpression EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1000:2: iv_ruleBasicExpression= ruleBasicExpression EOF
            {
             newCompositeNode(grammarAccess.getBasicExpressionRule()); 
            pushFollow(FOLLOW_ruleBasicExpression_in_entryRuleBasicExpression1992);
            iv_ruleBasicExpression=ruleBasicExpression();

            state._fsp--;

             current =iv_ruleBasicExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicExpression2002); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1007:1: ruleBasicExpression returns [EObject current=null] : ( ( (lv_negated_0_0= '!' ) )? ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleBasicExpression() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1010:28: ( ( ( (lv_negated_0_0= '!' ) )? ( (otherlv_1= RULE_ID ) ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1011:1: ( ( (lv_negated_0_0= '!' ) )? ( (otherlv_1= RULE_ID ) ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1011:1: ( ( (lv_negated_0_0= '!' ) )? ( (otherlv_1= RULE_ID ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1011:2: ( (lv_negated_0_0= '!' ) )? ( (otherlv_1= RULE_ID ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1011:2: ( (lv_negated_0_0= '!' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==35) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1012:1: (lv_negated_0_0= '!' )
                    {
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1012:1: (lv_negated_0_0= '!' )
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1013:3: lv_negated_0_0= '!'
                    {
                    lv_negated_0_0=(Token)match(input,35,FOLLOW_35_in_ruleBasicExpression2045); 

                            newLeafNode(lv_negated_0_0, grammarAccess.getBasicExpressionAccess().getNegatedExclamationMarkKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBasicExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "negated", true, "!");
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1026:3: ( (otherlv_1= RULE_ID ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1027:1: (otherlv_1= RULE_ID )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1027:1: (otherlv_1= RULE_ID )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1028:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getBasicExpressionRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBasicExpression2079); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1047:1: entryRuleMutexSet returns [EObject current=null] : iv_ruleMutexSet= ruleMutexSet EOF ;
    public final EObject entryRuleMutexSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMutexSet = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1048:2: (iv_ruleMutexSet= ruleMutexSet EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1049:2: iv_ruleMutexSet= ruleMutexSet EOF
            {
             newCompositeNode(grammarAccess.getMutexSetRule()); 
            pushFollow(FOLLOW_ruleMutexSet_in_entryRuleMutexSet2115);
            iv_ruleMutexSet=ruleMutexSet();

            state._fsp--;

             current =iv_ruleMutexSet; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMutexSet2125); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1056:1: ruleMutexSet returns [EObject current=null] : (otherlv_0= 'mutex' otherlv_1= '{' ( (lv_methods_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_methods_4_0= RULE_ID ) ) )+ otherlv_5= '};' ) ;
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
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1059:28: ( (otherlv_0= 'mutex' otherlv_1= '{' ( (lv_methods_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_methods_4_0= RULE_ID ) ) )+ otherlv_5= '};' ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1060:1: (otherlv_0= 'mutex' otherlv_1= '{' ( (lv_methods_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_methods_4_0= RULE_ID ) ) )+ otherlv_5= '};' )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1060:1: (otherlv_0= 'mutex' otherlv_1= '{' ( (lv_methods_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_methods_4_0= RULE_ID ) ) )+ otherlv_5= '};' )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1060:3: otherlv_0= 'mutex' otherlv_1= '{' ( (lv_methods_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_methods_4_0= RULE_ID ) ) )+ otherlv_5= '};'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleMutexSet2162); 

                	newLeafNode(otherlv_0, grammarAccess.getMutexSetAccess().getMutexKeyword_0());
                
            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleMutexSet2174); 

                	newLeafNode(otherlv_1, grammarAccess.getMutexSetAccess().getLeftCurlyBracketKeyword_1());
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1068:1: ( (lv_methods_2_0= RULE_ID ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1069:1: (lv_methods_2_0= RULE_ID )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1069:1: (lv_methods_2_0= RULE_ID )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1070:3: lv_methods_2_0= RULE_ID
            {
            lv_methods_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMutexSet2191); 

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

            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1086:2: (otherlv_3= ',' ( (lv_methods_4_0= RULE_ID ) ) )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==15) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1086:4: otherlv_3= ',' ( (lv_methods_4_0= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleMutexSet2209); 

            	        	newLeafNode(otherlv_3, grammarAccess.getMutexSetAccess().getCommaKeyword_3_0());
            	        
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1090:1: ( (lv_methods_4_0= RULE_ID ) )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1091:1: (lv_methods_4_0= RULE_ID )
            	    {
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1091:1: (lv_methods_4_0= RULE_ID )
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1092:3: lv_methods_4_0= RULE_ID
            	    {
            	    lv_methods_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMutexSet2226); 

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
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            otherlv_5=(Token)match(input,37,FOLLOW_37_in_ruleMutexSet2245); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1120:1: entryRuleCondVar returns [EObject current=null] : iv_ruleCondVar= ruleCondVar EOF ;
    public final EObject entryRuleCondVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondVar = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1121:2: (iv_ruleCondVar= ruleCondVar EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1122:2: iv_ruleCondVar= ruleCondVar EOF
            {
             newCompositeNode(grammarAccess.getCondVarRule()); 
            pushFollow(FOLLOW_ruleCondVar_in_entryRuleCondVar2281);
            iv_ruleCondVar=ruleCondVar();

            state._fsp--;

             current =iv_ruleCondVar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCondVar2291); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1129:1: ruleCondVar returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) ) ) ;
    public final EObject ruleCondVar() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1132:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1133:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1133:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1133:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleBooleanVal ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1133:2: ( (lv_name_0_0= RULE_ID ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1134:1: (lv_name_0_0= RULE_ID )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1134:1: (lv_name_0_0= RULE_ID )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1135:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCondVar2333); 

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

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleCondVar2350); 

                	newLeafNode(otherlv_1, grammarAccess.getCondVarAccess().getEqualsSignKeyword_1());
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1155:1: ( (lv_value_2_0= ruleBooleanVal ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1156:1: (lv_value_2_0= ruleBooleanVal )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1156:1: (lv_value_2_0= ruleBooleanVal )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1157:3: lv_value_2_0= ruleBooleanVal
            {
             
            	        newCompositeNode(grammarAccess.getCondVarAccess().getValueBooleanValParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleBooleanVal_in_ruleCondVar2371);
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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1181:1: entryRuleOrdVar returns [EObject current=null] : iv_ruleOrdVar= ruleOrdVar EOF ;
    public final EObject entryRuleOrdVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrdVar = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1182:2: (iv_ruleOrdVar= ruleOrdVar EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1183:2: iv_ruleOrdVar= ruleOrdVar EOF
            {
             newCompositeNode(grammarAccess.getOrdVarRule()); 
            pushFollow(FOLLOW_ruleOrdVar_in_entryRuleOrdVar2407);
            iv_ruleOrdVar=ruleOrdVar();

            state._fsp--;

             current =iv_ruleOrdVar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrdVar2417); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1190:1: ruleOrdVar returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_INT ) ) ) ;
    public final EObject ruleOrdVar() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1193:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_INT ) ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1194:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_INT ) ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1194:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_INT ) ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1194:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_INT ) )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1194:2: ( (lv_name_0_0= RULE_ID ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1195:1: (lv_name_0_0= RULE_ID )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1195:1: (lv_name_0_0= RULE_ID )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1196:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOrdVar2459); 

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

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleOrdVar2476); 

                	newLeafNode(otherlv_1, grammarAccess.getOrdVarAccess().getEqualsSignKeyword_1());
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1216:1: ( (lv_value_2_0= RULE_INT ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1217:1: (lv_value_2_0= RULE_INT )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1217:1: (lv_value_2_0= RULE_INT )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1218:3: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleOrdVar2493); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1242:1: entryRuleBooleanVal returns [String current=null] : iv_ruleBooleanVal= ruleBooleanVal EOF ;
    public final String entryRuleBooleanVal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBooleanVal = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1243:2: (iv_ruleBooleanVal= ruleBooleanVal EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1244:2: iv_ruleBooleanVal= ruleBooleanVal EOF
            {
             newCompositeNode(grammarAccess.getBooleanValRule()); 
            pushFollow(FOLLOW_ruleBooleanVal_in_entryRuleBooleanVal2535);
            iv_ruleBooleanVal=ruleBooleanVal();

            state._fsp--;

             current =iv_ruleBooleanVal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanVal2546); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1251:1: ruleBooleanVal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleBooleanVal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1254:28: ( (kw= 'true' | kw= 'false' ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1255:1: (kw= 'true' | kw= 'false' )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1255:1: (kw= 'true' | kw= 'false' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==29) ) {
                alt25=1;
            }
            else if ( (LA25_0==30) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1256:2: kw= 'true'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleBooleanVal2584); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBooleanValAccess().getTrueKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1263:2: kw= 'false'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleBooleanVal2603); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1276:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1277:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1278:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2644);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2655); 

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
    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1285:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1288:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1289:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1289:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1289:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2695); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1296:1: (kw= '.' this_ID_2= RULE_ID )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==38) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../xtext.cool/src-gen/xtext/cool/parser/antlr/internal/InternalCool.g:1297:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,38,FOLLOW_38_in_ruleQualifiedName2714); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2729); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop26;
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
    public static final BitSet FOLLOW_13_in_ruleCoordinatorBody280 = new BitSet(new long[]{0x00000010001E4010L});
    public static final BitSet FOLLOW_14_in_ruleCoordinatorBody302 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCondVar_in_ruleCoordinatorBody323 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleCoordinatorBody336 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCondVar_in_ruleCoordinatorBody357 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_ruleCoordinatorBody371 = new BitSet(new long[]{0x00000010001E4010L});
    public static final BitSet FOLLOW_17_in_ruleCoordinatorBody386 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleOrdVar_in_ruleCoordinatorBody407 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleCoordinatorBody420 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleOrdVar_in_ruleCoordinatorBody441 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_ruleCoordinatorBody455 = new BitSet(new long[]{0x00000010001E0010L});
    public static final BitSet FOLLOW_18_in_ruleCoordinatorBody470 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCoordinatorBody491 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleCoordinatorBody504 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCoordinatorBody525 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_ruleCoordinatorBody539 = new BitSet(new long[]{0x0000001000180010L});
    public static final BitSet FOLLOW_ruleMutexSet_in_ruleCoordinatorBody562 = new BitSet(new long[]{0x0000001000180010L});
    public static final BitSet FOLLOW_ruleGuard_in_ruleCoordinatorBody584 = new BitSet(new long[]{0x0000000000180010L});
    public static final BitSet FOLLOW_19_in_ruleCoordinatorBody597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_entryRuleGuard633 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuard643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleGuard681 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGuard700 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_15_in_ruleGuard718 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGuard735 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_21_in_ruleGuard754 = new BitSet(new long[]{0x0000000100C00002L});
    public static final BitSet FOLLOW_ruleRequires_in_ruleGuard775 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_22_in_ruleGuard789 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleGuard801 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_ruleIfStatement_in_ruleGuard823 = new BitSet(new long[]{0x0000000001080010L});
    public static final BitSet FOLLOW_ruleAssignStatement_in_ruleGuard850 = new BitSet(new long[]{0x0000000001080010L});
    public static final BitSet FOLLOW_19_in_ruleGuard864 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleGuard879 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleGuard891 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_ruleIfStatement_in_ruleGuard913 = new BitSet(new long[]{0x0000000001080010L});
    public static final BitSet FOLLOW_ruleAssignStatement_in_ruleGuard940 = new BitSet(new long[]{0x0000000001080010L});
    public static final BitSet FOLLOW_19_in_ruleGuard954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_entryRuleIfStatement992 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfStatement1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleIfStatement1039 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleIfStatement1051 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIfExpression_in_ruleIfStatement1072 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleIfStatement1084 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_ruleAssignStatement_in_ruleIfStatement1105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpression_in_entryRuleIfExpression1141 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfExpression1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIfExpression1193 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleIfExpression1218 = new BitSet(new long[]{0x0000000060000020L});
    public static final BitSet FOLLOW_28_in_ruleIfExpression1247 = new BitSet(new long[]{0x0000000060000020L});
    public static final BitSet FOLLOW_ruleAssignedValue_in_ruleIfExpression1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignedValue_in_entryRuleAssignedValue1320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignedValue1330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAssignedValue1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleAssignedValue1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleAssignedValue1432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignStatement_in_entryRuleAssignStatement1484 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignStatement1494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignStatement1539 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleAssignStatement1551 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_ruleBooleanVal_in_ruleAssignStatement1572 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleAssignStatement1584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequires_in_entryRuleRequires1620 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequires1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleRequires1667 = new BitSet(new long[]{0x0000000800000010L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleRequires1688 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleRequires1700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_entryRuleAndExpression1736 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndExpression1746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_ruleAndExpression1792 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleAndExpression1805 = new BitSet(new long[]{0x0000000800000010L});
    public static final BitSet FOLLOW_ruleOrExpression_in_ruleAndExpression1826 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_entryRuleOrExpression1864 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrExpression1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicExpression_in_ruleOrExpression1920 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleOrExpression1933 = new BitSet(new long[]{0x0000000800000010L});
    public static final BitSet FOLLOW_ruleBasicExpression_in_ruleOrExpression1954 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ruleBasicExpression_in_entryRuleBasicExpression1992 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicExpression2002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleBasicExpression2045 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBasicExpression2079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMutexSet_in_entryRuleMutexSet2115 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMutexSet2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleMutexSet2162 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleMutexSet2174 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMutexSet2191 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleMutexSet2209 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMutexSet2226 = new BitSet(new long[]{0x0000002000008000L});
    public static final BitSet FOLLOW_37_in_ruleMutexSet2245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondVar_in_entryRuleCondVar2281 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCondVar2291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCondVar2333 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleCondVar2350 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_ruleBooleanVal_in_ruleCondVar2371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrdVar_in_entryRuleOrdVar2407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrdVar2417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOrdVar2459 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleOrdVar2476 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleOrdVar2493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanVal_in_entryRuleBooleanVal2535 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanVal2546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleBooleanVal2584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleBooleanVal2603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2695 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleQualifiedName2714 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2729 = new BitSet(new long[]{0x0000004000000002L});

}