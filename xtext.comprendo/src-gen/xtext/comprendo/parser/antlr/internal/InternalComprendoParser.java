package xtext.comprendo.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import xtext.comprendo.services.ComprendoGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalComprendoParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Comprendo'", "'{'", "'}'", "'scope'", "'='", "';'", "'public-executions'", "'private-executions'", "':'", "'summary'", "'outdir'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalComprendoParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g"; }



     	private ComprendoGrammarAccess grammarAccess;
     	
        public InternalComprendoParser(TokenStream input, IAstFactory factory, ComprendoGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("xtext/comprendo/parser/antlr/internal/InternalComprendo.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "ComprendoDSAL";	
       	}
       	
       	@Override
       	protected ComprendoGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleComprendoDSAL
    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:77:1: entryRuleComprendoDSAL returns [EObject current=null] : iv_ruleComprendoDSAL= ruleComprendoDSAL EOF ;
    public final EObject entryRuleComprendoDSAL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComprendoDSAL = null;


        try {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:78:2: (iv_ruleComprendoDSAL= ruleComprendoDSAL EOF )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:79:2: iv_ruleComprendoDSAL= ruleComprendoDSAL EOF
            {
             currentNode = createCompositeNode(grammarAccess.getComprendoDSALRule(), currentNode); 
            pushFollow(FOLLOW_ruleComprendoDSAL_in_entryRuleComprendoDSAL75);
            iv_ruleComprendoDSAL=ruleComprendoDSAL();
            _fsp--;

             current =iv_ruleComprendoDSAL; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComprendoDSAL85); 

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
    // $ANTLR end entryRuleComprendoDSAL


    // $ANTLR start ruleComprendoDSAL
    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:86:1: ruleComprendoDSAL returns [EObject current=null] : ( (lv_comprendo_0_0= ruleComprendo ) ) ;
    public final EObject ruleComprendoDSAL() throws RecognitionException {
        EObject current = null;

        EObject lv_comprendo_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:91:6: ( ( (lv_comprendo_0_0= ruleComprendo ) ) )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:92:1: ( (lv_comprendo_0_0= ruleComprendo ) )
            {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:92:1: ( (lv_comprendo_0_0= ruleComprendo ) )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:93:1: (lv_comprendo_0_0= ruleComprendo )
            {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:93:1: (lv_comprendo_0_0= ruleComprendo )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:94:3: lv_comprendo_0_0= ruleComprendo
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getComprendoDSALAccess().getComprendoComprendoParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleComprendo_in_ruleComprendoDSAL130);
            lv_comprendo_0_0=ruleComprendo();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getComprendoDSALRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"comprendo",
            	        		lv_comprendo_0_0, 
            	        		"Comprendo", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleComprendoDSAL


    // $ANTLR start entryRuleComprendo
    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:124:1: entryRuleComprendo returns [EObject current=null] : iv_ruleComprendo= ruleComprendo EOF ;
    public final EObject entryRuleComprendo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComprendo = null;


        try {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:125:2: (iv_ruleComprendo= ruleComprendo EOF )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:126:2: iv_ruleComprendo= ruleComprendo EOF
            {
             currentNode = createCompositeNode(grammarAccess.getComprendoRule(), currentNode); 
            pushFollow(FOLLOW_ruleComprendo_in_entryRuleComprendo165);
            iv_ruleComprendo=ruleComprendo();
            _fsp--;

             current =iv_ruleComprendo; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComprendo175); 

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
    // $ANTLR end entryRuleComprendo


    // $ANTLR start ruleComprendo
    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:133:1: ruleComprendo returns [EObject current=null] : ( 'Comprendo' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_scope_3_0= ruleScope ) ) ( (lv_outdir_4_0= ruleOutdir ) )? ( (lv_commands_5_0= ruleCommand ) )* '}' ) ;
    public final EObject ruleComprendo() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_scope_3_0 = null;

        EObject lv_outdir_4_0 = null;

        EObject lv_commands_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:138:6: ( ( 'Comprendo' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_scope_3_0= ruleScope ) ) ( (lv_outdir_4_0= ruleOutdir ) )? ( (lv_commands_5_0= ruleCommand ) )* '}' ) )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:139:1: ( 'Comprendo' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_scope_3_0= ruleScope ) ) ( (lv_outdir_4_0= ruleOutdir ) )? ( (lv_commands_5_0= ruleCommand ) )* '}' )
            {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:139:1: ( 'Comprendo' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_scope_3_0= ruleScope ) ) ( (lv_outdir_4_0= ruleOutdir ) )? ( (lv_commands_5_0= ruleCommand ) )* '}' )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:139:3: 'Comprendo' ( (lv_name_1_0= RULE_ID ) ) '{' ( (lv_scope_3_0= ruleScope ) ) ( (lv_outdir_4_0= ruleOutdir ) )? ( (lv_commands_5_0= ruleCommand ) )* '}'
            {
            match(input,11,FOLLOW_11_in_ruleComprendo210); 

                    createLeafNode(grammarAccess.getComprendoAccess().getComprendoKeyword_0(), null); 
                
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:143:1: ( (lv_name_1_0= RULE_ID ) )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:144:1: (lv_name_1_0= RULE_ID )
            {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:144:1: (lv_name_1_0= RULE_ID )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:145:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComprendo227); 

            			createLeafNode(grammarAccess.getComprendoAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getComprendoRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleComprendo242); 

                    createLeafNode(grammarAccess.getComprendoAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:171:1: ( (lv_scope_3_0= ruleScope ) )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:172:1: (lv_scope_3_0= ruleScope )
            {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:172:1: (lv_scope_3_0= ruleScope )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:173:3: lv_scope_3_0= ruleScope
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getComprendoAccess().getScopeScopeParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleScope_in_ruleComprendo263);
            lv_scope_3_0=ruleScope();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getComprendoRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"scope",
            	        		lv_scope_3_0, 
            	        		"Scope", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:195:2: ( (lv_outdir_4_0= ruleOutdir ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==21) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:196:1: (lv_outdir_4_0= ruleOutdir )
                    {
                    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:196:1: (lv_outdir_4_0= ruleOutdir )
                    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:197:3: lv_outdir_4_0= ruleOutdir
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getComprendoAccess().getOutdirOutdirParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleOutdir_in_ruleComprendo284);
                    lv_outdir_4_0=ruleOutdir();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getComprendoRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"outdir",
                    	        		lv_outdir_4_0, 
                    	        		"Outdir", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }

            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:219:3: ( (lv_commands_5_0= ruleCommand ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=17 && LA2_0<=18)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:220:1: (lv_commands_5_0= ruleCommand )
            	    {
            	    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:220:1: (lv_commands_5_0= ruleCommand )
            	    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:221:3: lv_commands_5_0= ruleCommand
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getComprendoAccess().getCommandsCommandParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleCommand_in_ruleComprendo306);
            	    lv_commands_5_0=ruleCommand();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getComprendoRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"commands",
            	    	        		lv_commands_5_0, 
            	    	        		"Command", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleComprendo317); 

                    createLeafNode(grammarAccess.getComprendoAccess().getRightCurlyBracketKeyword_6(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleComprendo


    // $ANTLR start entryRuleScope
    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:255:1: entryRuleScope returns [EObject current=null] : iv_ruleScope= ruleScope EOF ;
    public final EObject entryRuleScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScope = null;


        try {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:256:2: (iv_ruleScope= ruleScope EOF )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:257:2: iv_ruleScope= ruleScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getScopeRule(), currentNode); 
            pushFollow(FOLLOW_ruleScope_in_entryRuleScope353);
            iv_ruleScope=ruleScope();
            _fsp--;

             current =iv_ruleScope; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScope363); 

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
    // $ANTLR end entryRuleScope


    // $ANTLR start ruleScope
    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:264:1: ruleScope returns [EObject current=null] : ( 'scope' '=' ( (lv_value_2_0= RULE_STRING ) ) ';' ) ;
    public final EObject ruleScope() throws RecognitionException {
        EObject current = null;

        Token lv_value_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:269:6: ( ( 'scope' '=' ( (lv_value_2_0= RULE_STRING ) ) ';' ) )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:270:1: ( 'scope' '=' ( (lv_value_2_0= RULE_STRING ) ) ';' )
            {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:270:1: ( 'scope' '=' ( (lv_value_2_0= RULE_STRING ) ) ';' )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:270:3: 'scope' '=' ( (lv_value_2_0= RULE_STRING ) ) ';'
            {
            match(input,14,FOLLOW_14_in_ruleScope398); 

                    createLeafNode(grammarAccess.getScopeAccess().getScopeKeyword_0(), null); 
                
            match(input,15,FOLLOW_15_in_ruleScope408); 

                    createLeafNode(grammarAccess.getScopeAccess().getEqualsSignKeyword_1(), null); 
                
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:278:1: ( (lv_value_2_0= RULE_STRING ) )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:279:1: (lv_value_2_0= RULE_STRING )
            {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:279:1: (lv_value_2_0= RULE_STRING )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:280:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleScope425); 

            			createLeafNode(grammarAccess.getScopeAccess().getValueSTRINGTerminalRuleCall_2_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getScopeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_2_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleScope440); 

                    createLeafNode(grammarAccess.getScopeAccess().getSemicolonKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleScope


    // $ANTLR start entryRuleCommand
    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:314:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:315:2: (iv_ruleCommand= ruleCommand EOF )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:316:2: iv_ruleCommand= ruleCommand EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCommandRule(), currentNode); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand476);
            iv_ruleCommand=ruleCommand();
            _fsp--;

             current =iv_ruleCommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand486); 

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
    // $ANTLR end entryRuleCommand


    // $ANTLR start ruleCommand
    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:323:1: ruleCommand returns [EObject current=null] : ( ( ( (lv_id_0_1= 'public-executions' | lv_id_0_2= 'private-executions' ) ) ) ( ':' ( (lv_summary_2_0= 'summary' ) ) )? ';' ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_1=null;
        Token lv_id_0_2=null;
        Token lv_summary_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:328:6: ( ( ( ( (lv_id_0_1= 'public-executions' | lv_id_0_2= 'private-executions' ) ) ) ( ':' ( (lv_summary_2_0= 'summary' ) ) )? ';' ) )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:329:1: ( ( ( (lv_id_0_1= 'public-executions' | lv_id_0_2= 'private-executions' ) ) ) ( ':' ( (lv_summary_2_0= 'summary' ) ) )? ';' )
            {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:329:1: ( ( ( (lv_id_0_1= 'public-executions' | lv_id_0_2= 'private-executions' ) ) ) ( ':' ( (lv_summary_2_0= 'summary' ) ) )? ';' )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:329:2: ( ( (lv_id_0_1= 'public-executions' | lv_id_0_2= 'private-executions' ) ) ) ( ':' ( (lv_summary_2_0= 'summary' ) ) )? ';'
            {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:329:2: ( ( (lv_id_0_1= 'public-executions' | lv_id_0_2= 'private-executions' ) ) )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:330:1: ( (lv_id_0_1= 'public-executions' | lv_id_0_2= 'private-executions' ) )
            {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:330:1: ( (lv_id_0_1= 'public-executions' | lv_id_0_2= 'private-executions' ) )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:331:1: (lv_id_0_1= 'public-executions' | lv_id_0_2= 'private-executions' )
            {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:331:1: (lv_id_0_1= 'public-executions' | lv_id_0_2= 'private-executions' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            else if ( (LA3_0==18) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("331:1: (lv_id_0_1= 'public-executions' | lv_id_0_2= 'private-executions' )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:332:3: lv_id_0_1= 'public-executions'
                    {
                    lv_id_0_1=(Token)input.LT(1);
                    match(input,17,FOLLOW_17_in_ruleCommand531); 

                            createLeafNode(grammarAccess.getCommandAccess().getIdPublicExecutionsKeyword_0_0_0(), "id"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCommandRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "id", lv_id_0_1, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;
                case 2 :
                    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:350:8: lv_id_0_2= 'private-executions'
                    {
                    lv_id_0_2=(Token)input.LT(1);
                    match(input,18,FOLLOW_18_in_ruleCommand560); 

                            createLeafNode(grammarAccess.getCommandAccess().getIdPrivateExecutionsKeyword_0_0_1(), "id"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCommandRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "id", lv_id_0_2, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }


            }

            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:371:2: ( ':' ( (lv_summary_2_0= 'summary' ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:371:4: ':' ( (lv_summary_2_0= 'summary' ) )
                    {
                    match(input,19,FOLLOW_19_in_ruleCommand587); 

                            createLeafNode(grammarAccess.getCommandAccess().getColonKeyword_1_0(), null); 
                        
                    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:375:1: ( (lv_summary_2_0= 'summary' ) )
                    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:376:1: (lv_summary_2_0= 'summary' )
                    {
                    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:376:1: (lv_summary_2_0= 'summary' )
                    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:377:3: lv_summary_2_0= 'summary'
                    {
                    lv_summary_2_0=(Token)input.LT(1);
                    match(input,20,FOLLOW_20_in_ruleCommand605); 

                            createLeafNode(grammarAccess.getCommandAccess().getSummarySummaryKeyword_1_1_0(), "summary"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getCommandRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "summary", true, "summary", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,16,FOLLOW_16_in_ruleCommand630); 

                    createLeafNode(grammarAccess.getCommandAccess().getSemicolonKeyword_2(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleCommand


    // $ANTLR start entryRuleOutdir
    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:408:1: entryRuleOutdir returns [EObject current=null] : iv_ruleOutdir= ruleOutdir EOF ;
    public final EObject entryRuleOutdir() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutdir = null;


        try {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:409:2: (iv_ruleOutdir= ruleOutdir EOF )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:410:2: iv_ruleOutdir= ruleOutdir EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOutdirRule(), currentNode); 
            pushFollow(FOLLOW_ruleOutdir_in_entryRuleOutdir666);
            iv_ruleOutdir=ruleOutdir();
            _fsp--;

             current =iv_ruleOutdir; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOutdir676); 

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
    // $ANTLR end entryRuleOutdir


    // $ANTLR start ruleOutdir
    // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:417:1: ruleOutdir returns [EObject current=null] : ( 'outdir' '=' ( (lv_value_2_0= RULE_STRING ) ) ';' ) ;
    public final EObject ruleOutdir() throws RecognitionException {
        EObject current = null;

        Token lv_value_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:422:6: ( ( 'outdir' '=' ( (lv_value_2_0= RULE_STRING ) ) ';' ) )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:423:1: ( 'outdir' '=' ( (lv_value_2_0= RULE_STRING ) ) ';' )
            {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:423:1: ( 'outdir' '=' ( (lv_value_2_0= RULE_STRING ) ) ';' )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:423:3: 'outdir' '=' ( (lv_value_2_0= RULE_STRING ) ) ';'
            {
            match(input,21,FOLLOW_21_in_ruleOutdir711); 

                    createLeafNode(grammarAccess.getOutdirAccess().getOutdirKeyword_0(), null); 
                
            match(input,15,FOLLOW_15_in_ruleOutdir721); 

                    createLeafNode(grammarAccess.getOutdirAccess().getEqualsSignKeyword_1(), null); 
                
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:431:1: ( (lv_value_2_0= RULE_STRING ) )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:432:1: (lv_value_2_0= RULE_STRING )
            {
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:432:1: (lv_value_2_0= RULE_STRING )
            // ../xtext.comprendo/src-gen/xtext/comprendo/parser/antlr/internal/InternalComprendo.g:433:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleOutdir738); 

            			createLeafNode(grammarAccess.getOutdirAccess().getValueSTRINGTerminalRuleCall_2_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOutdirRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_2_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleOutdir753); 

                    createLeafNode(grammarAccess.getOutdirAccess().getSemicolonKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleOutdir


 

    public static final BitSet FOLLOW_ruleComprendoDSAL_in_entryRuleComprendoDSAL75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComprendoDSAL85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComprendo_in_ruleComprendoDSAL130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComprendo_in_entryRuleComprendo165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComprendo175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleComprendo210 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComprendo227 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleComprendo242 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleScope_in_ruleComprendo263 = new BitSet(new long[]{0x0000000000262000L});
    public static final BitSet FOLLOW_ruleOutdir_in_ruleComprendo284 = new BitSet(new long[]{0x0000000000062000L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleComprendo306 = new BitSet(new long[]{0x0000000000062000L});
    public static final BitSet FOLLOW_13_in_ruleComprendo317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScope_in_entryRuleScope353 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScope363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleScope398 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleScope408 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleScope425 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleScope440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleCommand531 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_18_in_ruleCommand560 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_19_in_ruleCommand587 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleCommand605 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleCommand630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutdir_in_entryRuleOutdir666 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOutdir676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOutdir711 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleOutdir721 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleOutdir738 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleOutdir753 = new BitSet(new long[]{0x0000000000000002L});

}