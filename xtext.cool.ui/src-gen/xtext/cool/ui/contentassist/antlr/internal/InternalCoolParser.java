package xtext.cool.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import xtext.cool.services.CoolGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCoolParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'coordinator'", "'{'", "'}'", "'condition'", "';'", "','", "'int'", "'selfex'", "'guard'", "':'", "'requires'", "'&&'", "'||'", "'mutex'", "'};'", "'='", "'.'", "'per_class'", "'!'"
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
    public String getGrammarFileName() { return "../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g"; }


     
     	private CoolGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(CoolGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleCoordinatorDeclaration"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:60:1: entryRuleCoordinatorDeclaration : ruleCoordinatorDeclaration EOF ;
    public final void entryRuleCoordinatorDeclaration() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:61:1: ( ruleCoordinatorDeclaration EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:62:1: ruleCoordinatorDeclaration EOF
            {
             before(grammarAccess.getCoordinatorDeclarationRule()); 
            pushFollow(FOLLOW_ruleCoordinatorDeclaration_in_entryRuleCoordinatorDeclaration61);
            ruleCoordinatorDeclaration();

            state._fsp--;

             after(grammarAccess.getCoordinatorDeclarationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCoordinatorDeclaration68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCoordinatorDeclaration"


    // $ANTLR start "ruleCoordinatorDeclaration"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:69:1: ruleCoordinatorDeclaration : ( ( rule__CoordinatorDeclaration__Group__0 ) ) ;
    public final void ruleCoordinatorDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:73:2: ( ( ( rule__CoordinatorDeclaration__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:74:1: ( ( rule__CoordinatorDeclaration__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:74:1: ( ( rule__CoordinatorDeclaration__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:75:1: ( rule__CoordinatorDeclaration__Group__0 )
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:76:1: ( rule__CoordinatorDeclaration__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:76:2: rule__CoordinatorDeclaration__Group__0
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__0_in_ruleCoordinatorDeclaration94);
            rule__CoordinatorDeclaration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCoordinatorDeclarationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCoordinatorDeclaration"


    // $ANTLR start "entryRuleCoordinatorBody"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:88:1: entryRuleCoordinatorBody : ruleCoordinatorBody EOF ;
    public final void entryRuleCoordinatorBody() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:89:1: ( ruleCoordinatorBody EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:90:1: ruleCoordinatorBody EOF
            {
             before(grammarAccess.getCoordinatorBodyRule()); 
            pushFollow(FOLLOW_ruleCoordinatorBody_in_entryRuleCoordinatorBody121);
            ruleCoordinatorBody();

            state._fsp--;

             after(grammarAccess.getCoordinatorBodyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCoordinatorBody128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCoordinatorBody"


    // $ANTLR start "ruleCoordinatorBody"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:97:1: ruleCoordinatorBody : ( ( rule__CoordinatorBody__Group__0 ) ) ;
    public final void ruleCoordinatorBody() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:101:2: ( ( ( rule__CoordinatorBody__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:102:1: ( ( rule__CoordinatorBody__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:102:1: ( ( rule__CoordinatorBody__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:103:1: ( rule__CoordinatorBody__Group__0 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:104:1: ( rule__CoordinatorBody__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:104:2: rule__CoordinatorBody__Group__0
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__0_in_ruleCoordinatorBody154);
            rule__CoordinatorBody__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCoordinatorBodyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCoordinatorBody"


    // $ANTLR start "entryRuleGuard"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:116:1: entryRuleGuard : ruleGuard EOF ;
    public final void entryRuleGuard() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:117:1: ( ruleGuard EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:118:1: ruleGuard EOF
            {
             before(grammarAccess.getGuardRule()); 
            pushFollow(FOLLOW_ruleGuard_in_entryRuleGuard181);
            ruleGuard();

            state._fsp--;

             after(grammarAccess.getGuardRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGuard188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGuard"


    // $ANTLR start "ruleGuard"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:125:1: ruleGuard : ( ( rule__Guard__Group__0 ) ) ;
    public final void ruleGuard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:129:2: ( ( ( rule__Guard__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:130:1: ( ( rule__Guard__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:130:1: ( ( rule__Guard__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:131:1: ( rule__Guard__Group__0 )
            {
             before(grammarAccess.getGuardAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:132:1: ( rule__Guard__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:132:2: rule__Guard__Group__0
            {
            pushFollow(FOLLOW_rule__Guard__Group__0_in_ruleGuard214);
            rule__Guard__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGuardAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGuard"


    // $ANTLR start "entryRuleRequires"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:144:1: entryRuleRequires : ruleRequires EOF ;
    public final void entryRuleRequires() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:145:1: ( ruleRequires EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:146:1: ruleRequires EOF
            {
             before(grammarAccess.getRequiresRule()); 
            pushFollow(FOLLOW_ruleRequires_in_entryRuleRequires241);
            ruleRequires();

            state._fsp--;

             after(grammarAccess.getRequiresRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequires248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRequires"


    // $ANTLR start "ruleRequires"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:153:1: ruleRequires : ( ( rule__Requires__Group__0 ) ) ;
    public final void ruleRequires() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:157:2: ( ( ( rule__Requires__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:158:1: ( ( rule__Requires__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:158:1: ( ( rule__Requires__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:159:1: ( rule__Requires__Group__0 )
            {
             before(grammarAccess.getRequiresAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:160:1: ( rule__Requires__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:160:2: rule__Requires__Group__0
            {
            pushFollow(FOLLOW_rule__Requires__Group__0_in_ruleRequires274);
            rule__Requires__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRequiresAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRequires"


    // $ANTLR start "entryRuleAndExpression"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:172:1: entryRuleAndExpression : ruleAndExpression EOF ;
    public final void entryRuleAndExpression() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:173:1: ( ruleAndExpression EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:174:1: ruleAndExpression EOF
            {
             before(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_ruleAndExpression_in_entryRuleAndExpression301);
            ruleAndExpression();

            state._fsp--;

             after(grammarAccess.getAndExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndExpression308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:181:1: ruleAndExpression : ( ( rule__AndExpression__Group__0 ) ) ;
    public final void ruleAndExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:185:2: ( ( ( rule__AndExpression__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:186:1: ( ( rule__AndExpression__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:186:1: ( ( rule__AndExpression__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:187:1: ( rule__AndExpression__Group__0 )
            {
             before(grammarAccess.getAndExpressionAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:188:1: ( rule__AndExpression__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:188:2: rule__AndExpression__Group__0
            {
            pushFollow(FOLLOW_rule__AndExpression__Group__0_in_ruleAndExpression334);
            rule__AndExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAndExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleOrExpression"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:200:1: entryRuleOrExpression : ruleOrExpression EOF ;
    public final void entryRuleOrExpression() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:201:1: ( ruleOrExpression EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:202:1: ruleOrExpression EOF
            {
             before(grammarAccess.getOrExpressionRule()); 
            pushFollow(FOLLOW_ruleOrExpression_in_entryRuleOrExpression361);
            ruleOrExpression();

            state._fsp--;

             after(grammarAccess.getOrExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrExpression368); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:209:1: ruleOrExpression : ( ( rule__OrExpression__Group__0 ) ) ;
    public final void ruleOrExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:213:2: ( ( ( rule__OrExpression__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:214:1: ( ( rule__OrExpression__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:214:1: ( ( rule__OrExpression__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:215:1: ( rule__OrExpression__Group__0 )
            {
             before(grammarAccess.getOrExpressionAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:216:1: ( rule__OrExpression__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:216:2: rule__OrExpression__Group__0
            {
            pushFollow(FOLLOW_rule__OrExpression__Group__0_in_ruleOrExpression394);
            rule__OrExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleBasicExpression"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:228:1: entryRuleBasicExpression : ruleBasicExpression EOF ;
    public final void entryRuleBasicExpression() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:229:1: ( ruleBasicExpression EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:230:1: ruleBasicExpression EOF
            {
             before(grammarAccess.getBasicExpressionRule()); 
            pushFollow(FOLLOW_ruleBasicExpression_in_entryRuleBasicExpression421);
            ruleBasicExpression();

            state._fsp--;

             after(grammarAccess.getBasicExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicExpression428); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBasicExpression"


    // $ANTLR start "ruleBasicExpression"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:237:1: ruleBasicExpression : ( ( rule__BasicExpression__Group__0 ) ) ;
    public final void ruleBasicExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:241:2: ( ( ( rule__BasicExpression__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:242:1: ( ( rule__BasicExpression__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:242:1: ( ( rule__BasicExpression__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:243:1: ( rule__BasicExpression__Group__0 )
            {
             before(grammarAccess.getBasicExpressionAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:244:1: ( rule__BasicExpression__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:244:2: rule__BasicExpression__Group__0
            {
            pushFollow(FOLLOW_rule__BasicExpression__Group__0_in_ruleBasicExpression454);
            rule__BasicExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBasicExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBasicExpression"


    // $ANTLR start "entryRuleMutexSet"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:256:1: entryRuleMutexSet : ruleMutexSet EOF ;
    public final void entryRuleMutexSet() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:257:1: ( ruleMutexSet EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:258:1: ruleMutexSet EOF
            {
             before(grammarAccess.getMutexSetRule()); 
            pushFollow(FOLLOW_ruleMutexSet_in_entryRuleMutexSet481);
            ruleMutexSet();

            state._fsp--;

             after(grammarAccess.getMutexSetRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMutexSet488); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMutexSet"


    // $ANTLR start "ruleMutexSet"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:265:1: ruleMutexSet : ( ( rule__MutexSet__Group__0 ) ) ;
    public final void ruleMutexSet() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:269:2: ( ( ( rule__MutexSet__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:270:1: ( ( rule__MutexSet__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:270:1: ( ( rule__MutexSet__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:271:1: ( rule__MutexSet__Group__0 )
            {
             before(grammarAccess.getMutexSetAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:272:1: ( rule__MutexSet__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:272:2: rule__MutexSet__Group__0
            {
            pushFollow(FOLLOW_rule__MutexSet__Group__0_in_ruleMutexSet514);
            rule__MutexSet__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMutexSetAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMutexSet"


    // $ANTLR start "entryRuleCondVar"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:284:1: entryRuleCondVar : ruleCondVar EOF ;
    public final void entryRuleCondVar() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:285:1: ( ruleCondVar EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:286:1: ruleCondVar EOF
            {
             before(grammarAccess.getCondVarRule()); 
            pushFollow(FOLLOW_ruleCondVar_in_entryRuleCondVar541);
            ruleCondVar();

            state._fsp--;

             after(grammarAccess.getCondVarRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCondVar548); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCondVar"


    // $ANTLR start "ruleCondVar"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:293:1: ruleCondVar : ( ( rule__CondVar__Group__0 ) ) ;
    public final void ruleCondVar() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:297:2: ( ( ( rule__CondVar__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:298:1: ( ( rule__CondVar__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:298:1: ( ( rule__CondVar__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:299:1: ( rule__CondVar__Group__0 )
            {
             before(grammarAccess.getCondVarAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:300:1: ( rule__CondVar__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:300:2: rule__CondVar__Group__0
            {
            pushFollow(FOLLOW_rule__CondVar__Group__0_in_ruleCondVar574);
            rule__CondVar__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCondVarAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCondVar"


    // $ANTLR start "entryRuleOrdVar"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:312:1: entryRuleOrdVar : ruleOrdVar EOF ;
    public final void entryRuleOrdVar() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:313:1: ( ruleOrdVar EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:314:1: ruleOrdVar EOF
            {
             before(grammarAccess.getOrdVarRule()); 
            pushFollow(FOLLOW_ruleOrdVar_in_entryRuleOrdVar601);
            ruleOrdVar();

            state._fsp--;

             after(grammarAccess.getOrdVarRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrdVar608); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOrdVar"


    // $ANTLR start "ruleOrdVar"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:321:1: ruleOrdVar : ( ( rule__OrdVar__Group__0 ) ) ;
    public final void ruleOrdVar() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:325:2: ( ( ( rule__OrdVar__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:326:1: ( ( rule__OrdVar__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:326:1: ( ( rule__OrdVar__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:327:1: ( rule__OrdVar__Group__0 )
            {
             before(grammarAccess.getOrdVarAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:328:1: ( rule__OrdVar__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:328:2: rule__OrdVar__Group__0
            {
            pushFollow(FOLLOW_rule__OrdVar__Group__0_in_ruleOrdVar634);
            rule__OrdVar__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrdVarAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrdVar"


    // $ANTLR start "entryRuleBooleanVal"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:340:1: entryRuleBooleanVal : ruleBooleanVal EOF ;
    public final void entryRuleBooleanVal() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:341:1: ( ruleBooleanVal EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:342:1: ruleBooleanVal EOF
            {
             before(grammarAccess.getBooleanValRule()); 
            pushFollow(FOLLOW_ruleBooleanVal_in_entryRuleBooleanVal661);
            ruleBooleanVal();

            state._fsp--;

             after(grammarAccess.getBooleanValRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanVal668); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanVal"


    // $ANTLR start "ruleBooleanVal"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:349:1: ruleBooleanVal : ( ( rule__BooleanVal__Alternatives ) ) ;
    public final void ruleBooleanVal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:353:2: ( ( ( rule__BooleanVal__Alternatives ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:354:1: ( ( rule__BooleanVal__Alternatives ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:354:1: ( ( rule__BooleanVal__Alternatives ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:355:1: ( rule__BooleanVal__Alternatives )
            {
             before(grammarAccess.getBooleanValAccess().getAlternatives()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:356:1: ( rule__BooleanVal__Alternatives )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:356:2: rule__BooleanVal__Alternatives
            {
            pushFollow(FOLLOW_rule__BooleanVal__Alternatives_in_ruleBooleanVal694);
            rule__BooleanVal__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBooleanValAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanVal"


    // $ANTLR start "entryRuleQualifiedName"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:368:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:369:1: ( ruleQualifiedName EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:370:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName721);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName728); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:377:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:381:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:382:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:382:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:383:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:384:1: ( rule__QualifiedName__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:384:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName754);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "rule__BooleanVal__Alternatives"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:396:1: rule__BooleanVal__Alternatives : ( ( 'true' ) | ( 'false' ) );
    public final void rule__BooleanVal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:400:1: ( ( 'true' ) | ( 'false' ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            else if ( (LA1_0==12) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:401:1: ( 'true' )
                    {
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:401:1: ( 'true' )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:402:1: 'true'
                    {
                     before(grammarAccess.getBooleanValAccess().getTrueKeyword_0()); 
                    match(input,11,FOLLOW_11_in_rule__BooleanVal__Alternatives791); 
                     after(grammarAccess.getBooleanValAccess().getTrueKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:409:6: ( 'false' )
                    {
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:409:6: ( 'false' )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:410:1: 'false'
                    {
                     before(grammarAccess.getBooleanValAccess().getFalseKeyword_1()); 
                    match(input,12,FOLLOW_12_in_rule__BooleanVal__Alternatives811); 
                     after(grammarAccess.getBooleanValAccess().getFalseKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanVal__Alternatives"


    // $ANTLR start "rule__CoordinatorDeclaration__Group__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:424:1: rule__CoordinatorDeclaration__Group__0 : rule__CoordinatorDeclaration__Group__0__Impl rule__CoordinatorDeclaration__Group__1 ;
    public final void rule__CoordinatorDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:428:1: ( rule__CoordinatorDeclaration__Group__0__Impl rule__CoordinatorDeclaration__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:429:2: rule__CoordinatorDeclaration__Group__0__Impl rule__CoordinatorDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__0__Impl_in_rule__CoordinatorDeclaration__Group__0843);
            rule__CoordinatorDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__1_in_rule__CoordinatorDeclaration__Group__0846);
            rule__CoordinatorDeclaration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorDeclaration__Group__0"


    // $ANTLR start "rule__CoordinatorDeclaration__Group__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:436:1: rule__CoordinatorDeclaration__Group__0__Impl : ( ( rule__CoordinatorDeclaration__GranularityAssignment_0 )? ) ;
    public final void rule__CoordinatorDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:440:1: ( ( ( rule__CoordinatorDeclaration__GranularityAssignment_0 )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:441:1: ( ( rule__CoordinatorDeclaration__GranularityAssignment_0 )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:441:1: ( ( rule__CoordinatorDeclaration__GranularityAssignment_0 )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:442:1: ( rule__CoordinatorDeclaration__GranularityAssignment_0 )?
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getGranularityAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:443:1: ( rule__CoordinatorDeclaration__GranularityAssignment_0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==30) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:443:2: rule__CoordinatorDeclaration__GranularityAssignment_0
                    {
                    pushFollow(FOLLOW_rule__CoordinatorDeclaration__GranularityAssignment_0_in_rule__CoordinatorDeclaration__Group__0__Impl873);
                    rule__CoordinatorDeclaration__GranularityAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCoordinatorDeclarationAccess().getGranularityAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorDeclaration__Group__0__Impl"


    // $ANTLR start "rule__CoordinatorDeclaration__Group__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:453:1: rule__CoordinatorDeclaration__Group__1 : rule__CoordinatorDeclaration__Group__1__Impl rule__CoordinatorDeclaration__Group__2 ;
    public final void rule__CoordinatorDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:457:1: ( rule__CoordinatorDeclaration__Group__1__Impl rule__CoordinatorDeclaration__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:458:2: rule__CoordinatorDeclaration__Group__1__Impl rule__CoordinatorDeclaration__Group__2
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__1__Impl_in_rule__CoordinatorDeclaration__Group__1904);
            rule__CoordinatorDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__2_in_rule__CoordinatorDeclaration__Group__1907);
            rule__CoordinatorDeclaration__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorDeclaration__Group__1"


    // $ANTLR start "rule__CoordinatorDeclaration__Group__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:465:1: rule__CoordinatorDeclaration__Group__1__Impl : ( 'coordinator' ) ;
    public final void rule__CoordinatorDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:469:1: ( ( 'coordinator' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:470:1: ( 'coordinator' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:470:1: ( 'coordinator' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:471:1: 'coordinator'
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getCoordinatorKeyword_1()); 
            match(input,13,FOLLOW_13_in_rule__CoordinatorDeclaration__Group__1__Impl935); 
             after(grammarAccess.getCoordinatorDeclarationAccess().getCoordinatorKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorDeclaration__Group__1__Impl"


    // $ANTLR start "rule__CoordinatorDeclaration__Group__2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:484:1: rule__CoordinatorDeclaration__Group__2 : rule__CoordinatorDeclaration__Group__2__Impl rule__CoordinatorDeclaration__Group__3 ;
    public final void rule__CoordinatorDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:488:1: ( rule__CoordinatorDeclaration__Group__2__Impl rule__CoordinatorDeclaration__Group__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:489:2: rule__CoordinatorDeclaration__Group__2__Impl rule__CoordinatorDeclaration__Group__3
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__2__Impl_in_rule__CoordinatorDeclaration__Group__2966);
            rule__CoordinatorDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__3_in_rule__CoordinatorDeclaration__Group__2969);
            rule__CoordinatorDeclaration__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorDeclaration__Group__2"


    // $ANTLR start "rule__CoordinatorDeclaration__Group__2__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:496:1: rule__CoordinatorDeclaration__Group__2__Impl : ( ( rule__CoordinatorDeclaration__ClassNameAssignment_2 ) ) ;
    public final void rule__CoordinatorDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:500:1: ( ( ( rule__CoordinatorDeclaration__ClassNameAssignment_2 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:501:1: ( ( rule__CoordinatorDeclaration__ClassNameAssignment_2 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:501:1: ( ( rule__CoordinatorDeclaration__ClassNameAssignment_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:502:1: ( rule__CoordinatorDeclaration__ClassNameAssignment_2 )
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getClassNameAssignment_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:503:1: ( rule__CoordinatorDeclaration__ClassNameAssignment_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:503:2: rule__CoordinatorDeclaration__ClassNameAssignment_2
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__ClassNameAssignment_2_in_rule__CoordinatorDeclaration__Group__2__Impl996);
            rule__CoordinatorDeclaration__ClassNameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCoordinatorDeclarationAccess().getClassNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorDeclaration__Group__2__Impl"


    // $ANTLR start "rule__CoordinatorDeclaration__Group__3"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:513:1: rule__CoordinatorDeclaration__Group__3 : rule__CoordinatorDeclaration__Group__3__Impl ;
    public final void rule__CoordinatorDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:517:1: ( rule__CoordinatorDeclaration__Group__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:518:2: rule__CoordinatorDeclaration__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__3__Impl_in_rule__CoordinatorDeclaration__Group__31026);
            rule__CoordinatorDeclaration__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorDeclaration__Group__3"


    // $ANTLR start "rule__CoordinatorDeclaration__Group__3__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:524:1: rule__CoordinatorDeclaration__Group__3__Impl : ( ( rule__CoordinatorDeclaration__BodyAssignment_3 )? ) ;
    public final void rule__CoordinatorDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:528:1: ( ( ( rule__CoordinatorDeclaration__BodyAssignment_3 )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:529:1: ( ( rule__CoordinatorDeclaration__BodyAssignment_3 )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:529:1: ( ( rule__CoordinatorDeclaration__BodyAssignment_3 )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:530:1: ( rule__CoordinatorDeclaration__BodyAssignment_3 )?
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getBodyAssignment_3()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:531:1: ( rule__CoordinatorDeclaration__BodyAssignment_3 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:531:2: rule__CoordinatorDeclaration__BodyAssignment_3
                    {
                    pushFollow(FOLLOW_rule__CoordinatorDeclaration__BodyAssignment_3_in_rule__CoordinatorDeclaration__Group__3__Impl1053);
                    rule__CoordinatorDeclaration__BodyAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCoordinatorDeclarationAccess().getBodyAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorDeclaration__Group__3__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:549:1: rule__CoordinatorBody__Group__0 : rule__CoordinatorBody__Group__0__Impl rule__CoordinatorBody__Group__1 ;
    public final void rule__CoordinatorBody__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:553:1: ( rule__CoordinatorBody__Group__0__Impl rule__CoordinatorBody__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:554:2: rule__CoordinatorBody__Group__0__Impl rule__CoordinatorBody__Group__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__0__Impl_in_rule__CoordinatorBody__Group__01092);
            rule__CoordinatorBody__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__1_in_rule__CoordinatorBody__Group__01095);
            rule__CoordinatorBody__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group__0"


    // $ANTLR start "rule__CoordinatorBody__Group__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:561:1: rule__CoordinatorBody__Group__0__Impl : ( '{' ) ;
    public final void rule__CoordinatorBody__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:565:1: ( ( '{' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:566:1: ( '{' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:566:1: ( '{' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:567:1: '{'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,14,FOLLOW_14_in_rule__CoordinatorBody__Group__0__Impl1123); 
             after(grammarAccess.getCoordinatorBodyAccess().getLeftCurlyBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group__0__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:580:1: rule__CoordinatorBody__Group__1 : rule__CoordinatorBody__Group__1__Impl rule__CoordinatorBody__Group__2 ;
    public final void rule__CoordinatorBody__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:584:1: ( rule__CoordinatorBody__Group__1__Impl rule__CoordinatorBody__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:585:2: rule__CoordinatorBody__Group__1__Impl rule__CoordinatorBody__Group__2
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__1__Impl_in_rule__CoordinatorBody__Group__11154);
            rule__CoordinatorBody__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__2_in_rule__CoordinatorBody__Group__11157);
            rule__CoordinatorBody__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group__1"


    // $ANTLR start "rule__CoordinatorBody__Group__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:592:1: rule__CoordinatorBody__Group__1__Impl : ( () ) ;
    public final void rule__CoordinatorBody__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:596:1: ( ( () ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:597:1: ( () )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:597:1: ( () )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:598:1: ()
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCoordinatorBodyAction_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:599:1: ()
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:601:1: 
            {
            }

             after(grammarAccess.getCoordinatorBodyAccess().getCoordinatorBodyAction_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group__1__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group__2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:611:1: rule__CoordinatorBody__Group__2 : rule__CoordinatorBody__Group__2__Impl rule__CoordinatorBody__Group__3 ;
    public final void rule__CoordinatorBody__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:615:1: ( rule__CoordinatorBody__Group__2__Impl rule__CoordinatorBody__Group__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:616:2: rule__CoordinatorBody__Group__2__Impl rule__CoordinatorBody__Group__3
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__2__Impl_in_rule__CoordinatorBody__Group__21215);
            rule__CoordinatorBody__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__3_in_rule__CoordinatorBody__Group__21218);
            rule__CoordinatorBody__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group__2"


    // $ANTLR start "rule__CoordinatorBody__Group__2__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:623:1: rule__CoordinatorBody__Group__2__Impl : ( ( rule__CoordinatorBody__Group_2__0 )* ) ;
    public final void rule__CoordinatorBody__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:627:1: ( ( ( rule__CoordinatorBody__Group_2__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:628:1: ( ( rule__CoordinatorBody__Group_2__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:628:1: ( ( rule__CoordinatorBody__Group_2__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:629:1: ( rule__CoordinatorBody__Group_2__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:630:1: ( rule__CoordinatorBody__Group_2__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:630:2: rule__CoordinatorBody__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__0_in_rule__CoordinatorBody__Group__2__Impl1245);
            	    rule__CoordinatorBody__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getCoordinatorBodyAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group__2__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group__3"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:640:1: rule__CoordinatorBody__Group__3 : rule__CoordinatorBody__Group__3__Impl rule__CoordinatorBody__Group__4 ;
    public final void rule__CoordinatorBody__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:644:1: ( rule__CoordinatorBody__Group__3__Impl rule__CoordinatorBody__Group__4 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:645:2: rule__CoordinatorBody__Group__3__Impl rule__CoordinatorBody__Group__4
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__3__Impl_in_rule__CoordinatorBody__Group__31276);
            rule__CoordinatorBody__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__4_in_rule__CoordinatorBody__Group__31279);
            rule__CoordinatorBody__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group__3"


    // $ANTLR start "rule__CoordinatorBody__Group__3__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:652:1: rule__CoordinatorBody__Group__3__Impl : ( ( rule__CoordinatorBody__Group_3__0 )* ) ;
    public final void rule__CoordinatorBody__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:656:1: ( ( ( rule__CoordinatorBody__Group_3__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:657:1: ( ( rule__CoordinatorBody__Group_3__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:657:1: ( ( rule__CoordinatorBody__Group_3__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:658:1: ( rule__CoordinatorBody__Group_3__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_3()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:659:1: ( rule__CoordinatorBody__Group_3__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:659:2: rule__CoordinatorBody__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__0_in_rule__CoordinatorBody__Group__3__Impl1306);
            	    rule__CoordinatorBody__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getCoordinatorBodyAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group__3__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group__4"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:669:1: rule__CoordinatorBody__Group__4 : rule__CoordinatorBody__Group__4__Impl rule__CoordinatorBody__Group__5 ;
    public final void rule__CoordinatorBody__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:673:1: ( rule__CoordinatorBody__Group__4__Impl rule__CoordinatorBody__Group__5 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:674:2: rule__CoordinatorBody__Group__4__Impl rule__CoordinatorBody__Group__5
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__4__Impl_in_rule__CoordinatorBody__Group__41337);
            rule__CoordinatorBody__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__5_in_rule__CoordinatorBody__Group__41340);
            rule__CoordinatorBody__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group__4"


    // $ANTLR start "rule__CoordinatorBody__Group__4__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:681:1: rule__CoordinatorBody__Group__4__Impl : ( ( rule__CoordinatorBody__Group_4__0 )? ) ;
    public final void rule__CoordinatorBody__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:685:1: ( ( ( rule__CoordinatorBody__Group_4__0 )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:686:1: ( ( rule__CoordinatorBody__Group_4__0 )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:686:1: ( ( rule__CoordinatorBody__Group_4__0 )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:687:1: ( rule__CoordinatorBody__Group_4__0 )?
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_4()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:688:1: ( rule__CoordinatorBody__Group_4__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:688:2: rule__CoordinatorBody__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__0_in_rule__CoordinatorBody__Group__4__Impl1367);
                    rule__CoordinatorBody__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCoordinatorBodyAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group__4__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group__5"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:698:1: rule__CoordinatorBody__Group__5 : rule__CoordinatorBody__Group__5__Impl rule__CoordinatorBody__Group__6 ;
    public final void rule__CoordinatorBody__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:702:1: ( rule__CoordinatorBody__Group__5__Impl rule__CoordinatorBody__Group__6 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:703:2: rule__CoordinatorBody__Group__5__Impl rule__CoordinatorBody__Group__6
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__5__Impl_in_rule__CoordinatorBody__Group__51398);
            rule__CoordinatorBody__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__6_in_rule__CoordinatorBody__Group__51401);
            rule__CoordinatorBody__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group__5"


    // $ANTLR start "rule__CoordinatorBody__Group__5__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:710:1: rule__CoordinatorBody__Group__5__Impl : ( ( rule__CoordinatorBody__MutexSetsAssignment_5 )* ) ;
    public final void rule__CoordinatorBody__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:714:1: ( ( ( rule__CoordinatorBody__MutexSetsAssignment_5 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:715:1: ( ( rule__CoordinatorBody__MutexSetsAssignment_5 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:715:1: ( ( rule__CoordinatorBody__MutexSetsAssignment_5 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:716:1: ( rule__CoordinatorBody__MutexSetsAssignment_5 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getMutexSetsAssignment_5()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:717:1: ( rule__CoordinatorBody__MutexSetsAssignment_5 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==26) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:717:2: rule__CoordinatorBody__MutexSetsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__MutexSetsAssignment_5_in_rule__CoordinatorBody__Group__5__Impl1428);
            	    rule__CoordinatorBody__MutexSetsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getCoordinatorBodyAccess().getMutexSetsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group__5__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group__6"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:727:1: rule__CoordinatorBody__Group__6 : rule__CoordinatorBody__Group__6__Impl rule__CoordinatorBody__Group__7 ;
    public final void rule__CoordinatorBody__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:731:1: ( rule__CoordinatorBody__Group__6__Impl rule__CoordinatorBody__Group__7 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:732:2: rule__CoordinatorBody__Group__6__Impl rule__CoordinatorBody__Group__7
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__6__Impl_in_rule__CoordinatorBody__Group__61459);
            rule__CoordinatorBody__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__7_in_rule__CoordinatorBody__Group__61462);
            rule__CoordinatorBody__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group__6"


    // $ANTLR start "rule__CoordinatorBody__Group__6__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:739:1: rule__CoordinatorBody__Group__6__Impl : ( ( rule__CoordinatorBody__GuardsAssignment_6 )* ) ;
    public final void rule__CoordinatorBody__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:743:1: ( ( ( rule__CoordinatorBody__GuardsAssignment_6 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:744:1: ( ( rule__CoordinatorBody__GuardsAssignment_6 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:744:1: ( ( rule__CoordinatorBody__GuardsAssignment_6 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:745:1: ( rule__CoordinatorBody__GuardsAssignment_6 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGuardsAssignment_6()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:746:1: ( rule__CoordinatorBody__GuardsAssignment_6 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID||LA8_0==21) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:746:2: rule__CoordinatorBody__GuardsAssignment_6
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__GuardsAssignment_6_in_rule__CoordinatorBody__Group__6__Impl1489);
            	    rule__CoordinatorBody__GuardsAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getCoordinatorBodyAccess().getGuardsAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group__6__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group__7"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:756:1: rule__CoordinatorBody__Group__7 : rule__CoordinatorBody__Group__7__Impl ;
    public final void rule__CoordinatorBody__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:760:1: ( rule__CoordinatorBody__Group__7__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:761:2: rule__CoordinatorBody__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__7__Impl_in_rule__CoordinatorBody__Group__71520);
            rule__CoordinatorBody__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group__7"


    // $ANTLR start "rule__CoordinatorBody__Group__7__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:767:1: rule__CoordinatorBody__Group__7__Impl : ( '}' ) ;
    public final void rule__CoordinatorBody__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:771:1: ( ( '}' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:772:1: ( '}' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:772:1: ( '}' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:773:1: '}'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getRightCurlyBracketKeyword_7()); 
            match(input,15,FOLLOW_15_in_rule__CoordinatorBody__Group__7__Impl1548); 
             after(grammarAccess.getCoordinatorBodyAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group__7__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group_2__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:802:1: rule__CoordinatorBody__Group_2__0 : rule__CoordinatorBody__Group_2__0__Impl rule__CoordinatorBody__Group_2__1 ;
    public final void rule__CoordinatorBody__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:806:1: ( rule__CoordinatorBody__Group_2__0__Impl rule__CoordinatorBody__Group_2__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:807:2: rule__CoordinatorBody__Group_2__0__Impl rule__CoordinatorBody__Group_2__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__0__Impl_in_rule__CoordinatorBody__Group_2__01595);
            rule__CoordinatorBody__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__1_in_rule__CoordinatorBody__Group_2__01598);
            rule__CoordinatorBody__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_2__0"


    // $ANTLR start "rule__CoordinatorBody__Group_2__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:814:1: rule__CoordinatorBody__Group_2__0__Impl : ( 'condition' ) ;
    public final void rule__CoordinatorBody__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:818:1: ( ( 'condition' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:819:1: ( 'condition' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:819:1: ( 'condition' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:820:1: 'condition'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getConditionKeyword_2_0()); 
            match(input,16,FOLLOW_16_in_rule__CoordinatorBody__Group_2__0__Impl1626); 
             after(grammarAccess.getCoordinatorBodyAccess().getConditionKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_2__0__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group_2__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:833:1: rule__CoordinatorBody__Group_2__1 : rule__CoordinatorBody__Group_2__1__Impl rule__CoordinatorBody__Group_2__2 ;
    public final void rule__CoordinatorBody__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:837:1: ( rule__CoordinatorBody__Group_2__1__Impl rule__CoordinatorBody__Group_2__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:838:2: rule__CoordinatorBody__Group_2__1__Impl rule__CoordinatorBody__Group_2__2
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__1__Impl_in_rule__CoordinatorBody__Group_2__11657);
            rule__CoordinatorBody__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__2_in_rule__CoordinatorBody__Group_2__11660);
            rule__CoordinatorBody__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_2__1"


    // $ANTLR start "rule__CoordinatorBody__Group_2__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:845:1: rule__CoordinatorBody__Group_2__1__Impl : ( ( rule__CoordinatorBody__CondVarsAssignment_2_1 ) ) ;
    public final void rule__CoordinatorBody__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:849:1: ( ( ( rule__CoordinatorBody__CondVarsAssignment_2_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:850:1: ( ( rule__CoordinatorBody__CondVarsAssignment_2_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:850:1: ( ( rule__CoordinatorBody__CondVarsAssignment_2_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:851:1: ( rule__CoordinatorBody__CondVarsAssignment_2_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCondVarsAssignment_2_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:852:1: ( rule__CoordinatorBody__CondVarsAssignment_2_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:852:2: rule__CoordinatorBody__CondVarsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__CondVarsAssignment_2_1_in_rule__CoordinatorBody__Group_2__1__Impl1687);
            rule__CoordinatorBody__CondVarsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getCoordinatorBodyAccess().getCondVarsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_2__1__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group_2__2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:862:1: rule__CoordinatorBody__Group_2__2 : rule__CoordinatorBody__Group_2__2__Impl rule__CoordinatorBody__Group_2__3 ;
    public final void rule__CoordinatorBody__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:866:1: ( rule__CoordinatorBody__Group_2__2__Impl rule__CoordinatorBody__Group_2__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:867:2: rule__CoordinatorBody__Group_2__2__Impl rule__CoordinatorBody__Group_2__3
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__2__Impl_in_rule__CoordinatorBody__Group_2__21717);
            rule__CoordinatorBody__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__3_in_rule__CoordinatorBody__Group_2__21720);
            rule__CoordinatorBody__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_2__2"


    // $ANTLR start "rule__CoordinatorBody__Group_2__2__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:874:1: rule__CoordinatorBody__Group_2__2__Impl : ( ( rule__CoordinatorBody__Group_2_2__0 )* ) ;
    public final void rule__CoordinatorBody__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:878:1: ( ( ( rule__CoordinatorBody__Group_2_2__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:879:1: ( ( rule__CoordinatorBody__Group_2_2__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:879:1: ( ( rule__CoordinatorBody__Group_2_2__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:880:1: ( rule__CoordinatorBody__Group_2_2__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_2_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:881:1: ( rule__CoordinatorBody__Group_2_2__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==18) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:881:2: rule__CoordinatorBody__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_2_2__0_in_rule__CoordinatorBody__Group_2__2__Impl1747);
            	    rule__CoordinatorBody__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getCoordinatorBodyAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_2__2__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group_2__3"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:891:1: rule__CoordinatorBody__Group_2__3 : rule__CoordinatorBody__Group_2__3__Impl ;
    public final void rule__CoordinatorBody__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:895:1: ( rule__CoordinatorBody__Group_2__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:896:2: rule__CoordinatorBody__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__3__Impl_in_rule__CoordinatorBody__Group_2__31778);
            rule__CoordinatorBody__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_2__3"


    // $ANTLR start "rule__CoordinatorBody__Group_2__3__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:902:1: rule__CoordinatorBody__Group_2__3__Impl : ( ';' ) ;
    public final void rule__CoordinatorBody__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:906:1: ( ( ';' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:907:1: ( ';' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:907:1: ( ';' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:908:1: ';'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_2_3()); 
            match(input,17,FOLLOW_17_in_rule__CoordinatorBody__Group_2__3__Impl1806); 
             after(grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_2__3__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group_2_2__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:929:1: rule__CoordinatorBody__Group_2_2__0 : rule__CoordinatorBody__Group_2_2__0__Impl rule__CoordinatorBody__Group_2_2__1 ;
    public final void rule__CoordinatorBody__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:933:1: ( rule__CoordinatorBody__Group_2_2__0__Impl rule__CoordinatorBody__Group_2_2__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:934:2: rule__CoordinatorBody__Group_2_2__0__Impl rule__CoordinatorBody__Group_2_2__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2_2__0__Impl_in_rule__CoordinatorBody__Group_2_2__01845);
            rule__CoordinatorBody__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2_2__1_in_rule__CoordinatorBody__Group_2_2__01848);
            rule__CoordinatorBody__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_2_2__0"


    // $ANTLR start "rule__CoordinatorBody__Group_2_2__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:941:1: rule__CoordinatorBody__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__CoordinatorBody__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:945:1: ( ( ',' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:946:1: ( ',' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:946:1: ( ',' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:947:1: ','
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_2_2_0()); 
            match(input,18,FOLLOW_18_in_rule__CoordinatorBody__Group_2_2__0__Impl1876); 
             after(grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_2_2__0__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group_2_2__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:960:1: rule__CoordinatorBody__Group_2_2__1 : rule__CoordinatorBody__Group_2_2__1__Impl ;
    public final void rule__CoordinatorBody__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:964:1: ( rule__CoordinatorBody__Group_2_2__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:965:2: rule__CoordinatorBody__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2_2__1__Impl_in_rule__CoordinatorBody__Group_2_2__11907);
            rule__CoordinatorBody__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_2_2__1"


    // $ANTLR start "rule__CoordinatorBody__Group_2_2__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:971:1: rule__CoordinatorBody__Group_2_2__1__Impl : ( ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 ) ) ;
    public final void rule__CoordinatorBody__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:975:1: ( ( ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:976:1: ( ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:976:1: ( ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:977:1: ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCondVarsAssignment_2_2_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:978:1: ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:978:2: rule__CoordinatorBody__CondVarsAssignment_2_2_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__CondVarsAssignment_2_2_1_in_rule__CoordinatorBody__Group_2_2__1__Impl1934);
            rule__CoordinatorBody__CondVarsAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getCoordinatorBodyAccess().getCondVarsAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_2_2__1__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group_3__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:992:1: rule__CoordinatorBody__Group_3__0 : rule__CoordinatorBody__Group_3__0__Impl rule__CoordinatorBody__Group_3__1 ;
    public final void rule__CoordinatorBody__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:996:1: ( rule__CoordinatorBody__Group_3__0__Impl rule__CoordinatorBody__Group_3__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:997:2: rule__CoordinatorBody__Group_3__0__Impl rule__CoordinatorBody__Group_3__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__0__Impl_in_rule__CoordinatorBody__Group_3__01968);
            rule__CoordinatorBody__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__1_in_rule__CoordinatorBody__Group_3__01971);
            rule__CoordinatorBody__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_3__0"


    // $ANTLR start "rule__CoordinatorBody__Group_3__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1004:1: rule__CoordinatorBody__Group_3__0__Impl : ( 'int' ) ;
    public final void rule__CoordinatorBody__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1008:1: ( ( 'int' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1009:1: ( 'int' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1009:1: ( 'int' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1010:1: 'int'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getIntKeyword_3_0()); 
            match(input,19,FOLLOW_19_in_rule__CoordinatorBody__Group_3__0__Impl1999); 
             after(grammarAccess.getCoordinatorBodyAccess().getIntKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_3__0__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group_3__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1023:1: rule__CoordinatorBody__Group_3__1 : rule__CoordinatorBody__Group_3__1__Impl rule__CoordinatorBody__Group_3__2 ;
    public final void rule__CoordinatorBody__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1027:1: ( rule__CoordinatorBody__Group_3__1__Impl rule__CoordinatorBody__Group_3__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1028:2: rule__CoordinatorBody__Group_3__1__Impl rule__CoordinatorBody__Group_3__2
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__1__Impl_in_rule__CoordinatorBody__Group_3__12030);
            rule__CoordinatorBody__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__2_in_rule__CoordinatorBody__Group_3__12033);
            rule__CoordinatorBody__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_3__1"


    // $ANTLR start "rule__CoordinatorBody__Group_3__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1035:1: rule__CoordinatorBody__Group_3__1__Impl : ( ( rule__CoordinatorBody__OrdVarsAssignment_3_1 ) ) ;
    public final void rule__CoordinatorBody__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1039:1: ( ( ( rule__CoordinatorBody__OrdVarsAssignment_3_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1040:1: ( ( rule__CoordinatorBody__OrdVarsAssignment_3_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1040:1: ( ( rule__CoordinatorBody__OrdVarsAssignment_3_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1041:1: ( rule__CoordinatorBody__OrdVarsAssignment_3_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getOrdVarsAssignment_3_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1042:1: ( rule__CoordinatorBody__OrdVarsAssignment_3_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1042:2: rule__CoordinatorBody__OrdVarsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__OrdVarsAssignment_3_1_in_rule__CoordinatorBody__Group_3__1__Impl2060);
            rule__CoordinatorBody__OrdVarsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getCoordinatorBodyAccess().getOrdVarsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_3__1__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group_3__2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1052:1: rule__CoordinatorBody__Group_3__2 : rule__CoordinatorBody__Group_3__2__Impl rule__CoordinatorBody__Group_3__3 ;
    public final void rule__CoordinatorBody__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1056:1: ( rule__CoordinatorBody__Group_3__2__Impl rule__CoordinatorBody__Group_3__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1057:2: rule__CoordinatorBody__Group_3__2__Impl rule__CoordinatorBody__Group_3__3
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__2__Impl_in_rule__CoordinatorBody__Group_3__22090);
            rule__CoordinatorBody__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__3_in_rule__CoordinatorBody__Group_3__22093);
            rule__CoordinatorBody__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_3__2"


    // $ANTLR start "rule__CoordinatorBody__Group_3__2__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1064:1: rule__CoordinatorBody__Group_3__2__Impl : ( ( rule__CoordinatorBody__Group_3_2__0 )* ) ;
    public final void rule__CoordinatorBody__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1068:1: ( ( ( rule__CoordinatorBody__Group_3_2__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1069:1: ( ( rule__CoordinatorBody__Group_3_2__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1069:1: ( ( rule__CoordinatorBody__Group_3_2__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1070:1: ( rule__CoordinatorBody__Group_3_2__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_3_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1071:1: ( rule__CoordinatorBody__Group_3_2__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==18) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1071:2: rule__CoordinatorBody__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_3_2__0_in_rule__CoordinatorBody__Group_3__2__Impl2120);
            	    rule__CoordinatorBody__Group_3_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getCoordinatorBodyAccess().getGroup_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_3__2__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group_3__3"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1081:1: rule__CoordinatorBody__Group_3__3 : rule__CoordinatorBody__Group_3__3__Impl ;
    public final void rule__CoordinatorBody__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1085:1: ( rule__CoordinatorBody__Group_3__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1086:2: rule__CoordinatorBody__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__3__Impl_in_rule__CoordinatorBody__Group_3__32151);
            rule__CoordinatorBody__Group_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_3__3"


    // $ANTLR start "rule__CoordinatorBody__Group_3__3__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1092:1: rule__CoordinatorBody__Group_3__3__Impl : ( ';' ) ;
    public final void rule__CoordinatorBody__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1096:1: ( ( ';' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1097:1: ( ';' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1097:1: ( ';' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1098:1: ';'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_3_3()); 
            match(input,17,FOLLOW_17_in_rule__CoordinatorBody__Group_3__3__Impl2179); 
             after(grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_3__3__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group_3_2__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1119:1: rule__CoordinatorBody__Group_3_2__0 : rule__CoordinatorBody__Group_3_2__0__Impl rule__CoordinatorBody__Group_3_2__1 ;
    public final void rule__CoordinatorBody__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1123:1: ( rule__CoordinatorBody__Group_3_2__0__Impl rule__CoordinatorBody__Group_3_2__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1124:2: rule__CoordinatorBody__Group_3_2__0__Impl rule__CoordinatorBody__Group_3_2__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3_2__0__Impl_in_rule__CoordinatorBody__Group_3_2__02218);
            rule__CoordinatorBody__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3_2__1_in_rule__CoordinatorBody__Group_3_2__02221);
            rule__CoordinatorBody__Group_3_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_3_2__0"


    // $ANTLR start "rule__CoordinatorBody__Group_3_2__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1131:1: rule__CoordinatorBody__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__CoordinatorBody__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1135:1: ( ( ',' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1136:1: ( ',' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1136:1: ( ',' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1137:1: ','
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_3_2_0()); 
            match(input,18,FOLLOW_18_in_rule__CoordinatorBody__Group_3_2__0__Impl2249); 
             after(grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_3_2__0__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group_3_2__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1150:1: rule__CoordinatorBody__Group_3_2__1 : rule__CoordinatorBody__Group_3_2__1__Impl ;
    public final void rule__CoordinatorBody__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1154:1: ( rule__CoordinatorBody__Group_3_2__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1155:2: rule__CoordinatorBody__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3_2__1__Impl_in_rule__CoordinatorBody__Group_3_2__12280);
            rule__CoordinatorBody__Group_3_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_3_2__1"


    // $ANTLR start "rule__CoordinatorBody__Group_3_2__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1161:1: rule__CoordinatorBody__Group_3_2__1__Impl : ( ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 ) ) ;
    public final void rule__CoordinatorBody__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1165:1: ( ( ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1166:1: ( ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1166:1: ( ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1167:1: ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getOrdVarsAssignment_3_2_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1168:1: ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1168:2: rule__CoordinatorBody__OrdVarsAssignment_3_2_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__OrdVarsAssignment_3_2_1_in_rule__CoordinatorBody__Group_3_2__1__Impl2307);
            rule__CoordinatorBody__OrdVarsAssignment_3_2_1();

            state._fsp--;


            }

             after(grammarAccess.getCoordinatorBodyAccess().getOrdVarsAssignment_3_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_3_2__1__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group_4__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1182:1: rule__CoordinatorBody__Group_4__0 : rule__CoordinatorBody__Group_4__0__Impl rule__CoordinatorBody__Group_4__1 ;
    public final void rule__CoordinatorBody__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1186:1: ( rule__CoordinatorBody__Group_4__0__Impl rule__CoordinatorBody__Group_4__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1187:2: rule__CoordinatorBody__Group_4__0__Impl rule__CoordinatorBody__Group_4__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__0__Impl_in_rule__CoordinatorBody__Group_4__02341);
            rule__CoordinatorBody__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__1_in_rule__CoordinatorBody__Group_4__02344);
            rule__CoordinatorBody__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_4__0"


    // $ANTLR start "rule__CoordinatorBody__Group_4__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1194:1: rule__CoordinatorBody__Group_4__0__Impl : ( 'selfex' ) ;
    public final void rule__CoordinatorBody__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1198:1: ( ( 'selfex' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1199:1: ( 'selfex' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1199:1: ( 'selfex' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1200:1: 'selfex'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexKeyword_4_0()); 
            match(input,20,FOLLOW_20_in_rule__CoordinatorBody__Group_4__0__Impl2372); 
             after(grammarAccess.getCoordinatorBodyAccess().getSelfexKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_4__0__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group_4__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1213:1: rule__CoordinatorBody__Group_4__1 : rule__CoordinatorBody__Group_4__1__Impl rule__CoordinatorBody__Group_4__2 ;
    public final void rule__CoordinatorBody__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1217:1: ( rule__CoordinatorBody__Group_4__1__Impl rule__CoordinatorBody__Group_4__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1218:2: rule__CoordinatorBody__Group_4__1__Impl rule__CoordinatorBody__Group_4__2
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__1__Impl_in_rule__CoordinatorBody__Group_4__12403);
            rule__CoordinatorBody__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__2_in_rule__CoordinatorBody__Group_4__12406);
            rule__CoordinatorBody__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_4__1"


    // $ANTLR start "rule__CoordinatorBody__Group_4__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1225:1: rule__CoordinatorBody__Group_4__1__Impl : ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 ) ) ;
    public final void rule__CoordinatorBody__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1229:1: ( ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1230:1: ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1230:1: ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1231:1: ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsAssignment_4_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1232:1: ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1232:2: rule__CoordinatorBody__SelfexMethodsAssignment_4_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__SelfexMethodsAssignment_4_1_in_rule__CoordinatorBody__Group_4__1__Impl2433);
            rule__CoordinatorBody__SelfexMethodsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_4__1__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group_4__2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1242:1: rule__CoordinatorBody__Group_4__2 : rule__CoordinatorBody__Group_4__2__Impl rule__CoordinatorBody__Group_4__3 ;
    public final void rule__CoordinatorBody__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1246:1: ( rule__CoordinatorBody__Group_4__2__Impl rule__CoordinatorBody__Group_4__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1247:2: rule__CoordinatorBody__Group_4__2__Impl rule__CoordinatorBody__Group_4__3
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__2__Impl_in_rule__CoordinatorBody__Group_4__22463);
            rule__CoordinatorBody__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__3_in_rule__CoordinatorBody__Group_4__22466);
            rule__CoordinatorBody__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_4__2"


    // $ANTLR start "rule__CoordinatorBody__Group_4__2__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1254:1: rule__CoordinatorBody__Group_4__2__Impl : ( ( rule__CoordinatorBody__Group_4_2__0 )* ) ;
    public final void rule__CoordinatorBody__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1258:1: ( ( ( rule__CoordinatorBody__Group_4_2__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1259:1: ( ( rule__CoordinatorBody__Group_4_2__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1259:1: ( ( rule__CoordinatorBody__Group_4_2__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1260:1: ( rule__CoordinatorBody__Group_4_2__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_4_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1261:1: ( rule__CoordinatorBody__Group_4_2__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==18) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1261:2: rule__CoordinatorBody__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_4_2__0_in_rule__CoordinatorBody__Group_4__2__Impl2493);
            	    rule__CoordinatorBody__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getCoordinatorBodyAccess().getGroup_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_4__2__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group_4__3"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1271:1: rule__CoordinatorBody__Group_4__3 : rule__CoordinatorBody__Group_4__3__Impl ;
    public final void rule__CoordinatorBody__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1275:1: ( rule__CoordinatorBody__Group_4__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1276:2: rule__CoordinatorBody__Group_4__3__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__3__Impl_in_rule__CoordinatorBody__Group_4__32524);
            rule__CoordinatorBody__Group_4__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_4__3"


    // $ANTLR start "rule__CoordinatorBody__Group_4__3__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1282:1: rule__CoordinatorBody__Group_4__3__Impl : ( ';' ) ;
    public final void rule__CoordinatorBody__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1286:1: ( ( ';' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1287:1: ( ';' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1287:1: ( ';' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1288:1: ';'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_4_3()); 
            match(input,17,FOLLOW_17_in_rule__CoordinatorBody__Group_4__3__Impl2552); 
             after(grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_4__3__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group_4_2__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1309:1: rule__CoordinatorBody__Group_4_2__0 : rule__CoordinatorBody__Group_4_2__0__Impl rule__CoordinatorBody__Group_4_2__1 ;
    public final void rule__CoordinatorBody__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1313:1: ( rule__CoordinatorBody__Group_4_2__0__Impl rule__CoordinatorBody__Group_4_2__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1314:2: rule__CoordinatorBody__Group_4_2__0__Impl rule__CoordinatorBody__Group_4_2__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4_2__0__Impl_in_rule__CoordinatorBody__Group_4_2__02591);
            rule__CoordinatorBody__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4_2__1_in_rule__CoordinatorBody__Group_4_2__02594);
            rule__CoordinatorBody__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_4_2__0"


    // $ANTLR start "rule__CoordinatorBody__Group_4_2__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1321:1: rule__CoordinatorBody__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__CoordinatorBody__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1325:1: ( ( ',' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1326:1: ( ',' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1326:1: ( ',' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1327:1: ','
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_4_2_0()); 
            match(input,18,FOLLOW_18_in_rule__CoordinatorBody__Group_4_2__0__Impl2622); 
             after(grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_4_2__0__Impl"


    // $ANTLR start "rule__CoordinatorBody__Group_4_2__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1340:1: rule__CoordinatorBody__Group_4_2__1 : rule__CoordinatorBody__Group_4_2__1__Impl ;
    public final void rule__CoordinatorBody__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1344:1: ( rule__CoordinatorBody__Group_4_2__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1345:2: rule__CoordinatorBody__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4_2__1__Impl_in_rule__CoordinatorBody__Group_4_2__12653);
            rule__CoordinatorBody__Group_4_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_4_2__1"


    // $ANTLR start "rule__CoordinatorBody__Group_4_2__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1351:1: rule__CoordinatorBody__Group_4_2__1__Impl : ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 ) ) ;
    public final void rule__CoordinatorBody__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1355:1: ( ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1356:1: ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1356:1: ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1357:1: ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsAssignment_4_2_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1358:1: ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1358:2: rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1_in_rule__CoordinatorBody__Group_4_2__1__Impl2680);
            rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__Group_4_2__1__Impl"


    // $ANTLR start "rule__Guard__Group__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1372:1: rule__Guard__Group__0 : rule__Guard__Group__0__Impl rule__Guard__Group__1 ;
    public final void rule__Guard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1376:1: ( rule__Guard__Group__0__Impl rule__Guard__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1377:2: rule__Guard__Group__0__Impl rule__Guard__Group__1
            {
            pushFollow(FOLLOW_rule__Guard__Group__0__Impl_in_rule__Guard__Group__02714);
            rule__Guard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Guard__Group__1_in_rule__Guard__Group__02717);
            rule__Guard__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group__0"


    // $ANTLR start "rule__Guard__Group__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1384:1: rule__Guard__Group__0__Impl : ( ( 'guard' )? ) ;
    public final void rule__Guard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1388:1: ( ( ( 'guard' )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1389:1: ( ( 'guard' )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1389:1: ( ( 'guard' )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1390:1: ( 'guard' )?
            {
             before(grammarAccess.getGuardAccess().getGuardKeyword_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1391:1: ( 'guard' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==21) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1392:2: 'guard'
                    {
                    match(input,21,FOLLOW_21_in_rule__Guard__Group__0__Impl2746); 

                    }
                    break;

            }

             after(grammarAccess.getGuardAccess().getGuardKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group__0__Impl"


    // $ANTLR start "rule__Guard__Group__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1403:1: rule__Guard__Group__1 : rule__Guard__Group__1__Impl rule__Guard__Group__2 ;
    public final void rule__Guard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1407:1: ( rule__Guard__Group__1__Impl rule__Guard__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1408:2: rule__Guard__Group__1__Impl rule__Guard__Group__2
            {
            pushFollow(FOLLOW_rule__Guard__Group__1__Impl_in_rule__Guard__Group__12779);
            rule__Guard__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Guard__Group__2_in_rule__Guard__Group__12782);
            rule__Guard__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group__1"


    // $ANTLR start "rule__Guard__Group__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1415:1: rule__Guard__Group__1__Impl : ( ( rule__Guard__MethodsAssignment_1 ) ) ;
    public final void rule__Guard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1419:1: ( ( ( rule__Guard__MethodsAssignment_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1420:1: ( ( rule__Guard__MethodsAssignment_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1420:1: ( ( rule__Guard__MethodsAssignment_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1421:1: ( rule__Guard__MethodsAssignment_1 )
            {
             before(grammarAccess.getGuardAccess().getMethodsAssignment_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1422:1: ( rule__Guard__MethodsAssignment_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1422:2: rule__Guard__MethodsAssignment_1
            {
            pushFollow(FOLLOW_rule__Guard__MethodsAssignment_1_in_rule__Guard__Group__1__Impl2809);
            rule__Guard__MethodsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGuardAccess().getMethodsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group__1__Impl"


    // $ANTLR start "rule__Guard__Group__2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1432:1: rule__Guard__Group__2 : rule__Guard__Group__2__Impl rule__Guard__Group__3 ;
    public final void rule__Guard__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1436:1: ( rule__Guard__Group__2__Impl rule__Guard__Group__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1437:2: rule__Guard__Group__2__Impl rule__Guard__Group__3
            {
            pushFollow(FOLLOW_rule__Guard__Group__2__Impl_in_rule__Guard__Group__22839);
            rule__Guard__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Guard__Group__3_in_rule__Guard__Group__22842);
            rule__Guard__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group__2"


    // $ANTLR start "rule__Guard__Group__2__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1444:1: rule__Guard__Group__2__Impl : ( ( rule__Guard__Group_2__0 )* ) ;
    public final void rule__Guard__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1448:1: ( ( ( rule__Guard__Group_2__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1449:1: ( ( rule__Guard__Group_2__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1449:1: ( ( rule__Guard__Group_2__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1450:1: ( rule__Guard__Group_2__0 )*
            {
             before(grammarAccess.getGuardAccess().getGroup_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1451:1: ( rule__Guard__Group_2__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==18) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1451:2: rule__Guard__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Guard__Group_2__0_in_rule__Guard__Group__2__Impl2869);
            	    rule__Guard__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getGuardAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group__2__Impl"


    // $ANTLR start "rule__Guard__Group__3"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1461:1: rule__Guard__Group__3 : rule__Guard__Group__3__Impl rule__Guard__Group__4 ;
    public final void rule__Guard__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1465:1: ( rule__Guard__Group__3__Impl rule__Guard__Group__4 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1466:2: rule__Guard__Group__3__Impl rule__Guard__Group__4
            {
            pushFollow(FOLLOW_rule__Guard__Group__3__Impl_in_rule__Guard__Group__32900);
            rule__Guard__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Guard__Group__4_in_rule__Guard__Group__32903);
            rule__Guard__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group__3"


    // $ANTLR start "rule__Guard__Group__3__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1473:1: rule__Guard__Group__3__Impl : ( ':' ) ;
    public final void rule__Guard__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1477:1: ( ( ':' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1478:1: ( ':' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1478:1: ( ':' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1479:1: ':'
            {
             before(grammarAccess.getGuardAccess().getColonKeyword_3()); 
            match(input,22,FOLLOW_22_in_rule__Guard__Group__3__Impl2931); 
             after(grammarAccess.getGuardAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group__3__Impl"


    // $ANTLR start "rule__Guard__Group__4"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1492:1: rule__Guard__Group__4 : rule__Guard__Group__4__Impl ;
    public final void rule__Guard__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1496:1: ( rule__Guard__Group__4__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1497:2: rule__Guard__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Guard__Group__4__Impl_in_rule__Guard__Group__42962);
            rule__Guard__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group__4"


    // $ANTLR start "rule__Guard__Group__4__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1503:1: rule__Guard__Group__4__Impl : ( ( rule__Guard__RequiresAssignment_4 )? ) ;
    public final void rule__Guard__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1507:1: ( ( ( rule__Guard__RequiresAssignment_4 )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1508:1: ( ( rule__Guard__RequiresAssignment_4 )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1508:1: ( ( rule__Guard__RequiresAssignment_4 )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1509:1: ( rule__Guard__RequiresAssignment_4 )?
            {
             before(grammarAccess.getGuardAccess().getRequiresAssignment_4()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1510:1: ( rule__Guard__RequiresAssignment_4 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==23) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1510:2: rule__Guard__RequiresAssignment_4
                    {
                    pushFollow(FOLLOW_rule__Guard__RequiresAssignment_4_in_rule__Guard__Group__4__Impl2989);
                    rule__Guard__RequiresAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGuardAccess().getRequiresAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group__4__Impl"


    // $ANTLR start "rule__Guard__Group_2__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1530:1: rule__Guard__Group_2__0 : rule__Guard__Group_2__0__Impl rule__Guard__Group_2__1 ;
    public final void rule__Guard__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1534:1: ( rule__Guard__Group_2__0__Impl rule__Guard__Group_2__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1535:2: rule__Guard__Group_2__0__Impl rule__Guard__Group_2__1
            {
            pushFollow(FOLLOW_rule__Guard__Group_2__0__Impl_in_rule__Guard__Group_2__03030);
            rule__Guard__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Guard__Group_2__1_in_rule__Guard__Group_2__03033);
            rule__Guard__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group_2__0"


    // $ANTLR start "rule__Guard__Group_2__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1542:1: rule__Guard__Group_2__0__Impl : ( ',' ) ;
    public final void rule__Guard__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1546:1: ( ( ',' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1547:1: ( ',' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1547:1: ( ',' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1548:1: ','
            {
             before(grammarAccess.getGuardAccess().getCommaKeyword_2_0()); 
            match(input,18,FOLLOW_18_in_rule__Guard__Group_2__0__Impl3061); 
             after(grammarAccess.getGuardAccess().getCommaKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group_2__0__Impl"


    // $ANTLR start "rule__Guard__Group_2__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1561:1: rule__Guard__Group_2__1 : rule__Guard__Group_2__1__Impl ;
    public final void rule__Guard__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1565:1: ( rule__Guard__Group_2__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1566:2: rule__Guard__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Guard__Group_2__1__Impl_in_rule__Guard__Group_2__13092);
            rule__Guard__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group_2__1"


    // $ANTLR start "rule__Guard__Group_2__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1572:1: rule__Guard__Group_2__1__Impl : ( ( rule__Guard__MethodsAssignment_2_1 ) ) ;
    public final void rule__Guard__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1576:1: ( ( ( rule__Guard__MethodsAssignment_2_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1577:1: ( ( rule__Guard__MethodsAssignment_2_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1577:1: ( ( rule__Guard__MethodsAssignment_2_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1578:1: ( rule__Guard__MethodsAssignment_2_1 )
            {
             before(grammarAccess.getGuardAccess().getMethodsAssignment_2_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1579:1: ( rule__Guard__MethodsAssignment_2_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1579:2: rule__Guard__MethodsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Guard__MethodsAssignment_2_1_in_rule__Guard__Group_2__1__Impl3119);
            rule__Guard__MethodsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getGuardAccess().getMethodsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__Group_2__1__Impl"


    // $ANTLR start "rule__Requires__Group__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1593:1: rule__Requires__Group__0 : rule__Requires__Group__0__Impl rule__Requires__Group__1 ;
    public final void rule__Requires__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1597:1: ( rule__Requires__Group__0__Impl rule__Requires__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1598:2: rule__Requires__Group__0__Impl rule__Requires__Group__1
            {
            pushFollow(FOLLOW_rule__Requires__Group__0__Impl_in_rule__Requires__Group__03153);
            rule__Requires__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Requires__Group__1_in_rule__Requires__Group__03156);
            rule__Requires__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Requires__Group__0"


    // $ANTLR start "rule__Requires__Group__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1605:1: rule__Requires__Group__0__Impl : ( 'requires' ) ;
    public final void rule__Requires__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1609:1: ( ( 'requires' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1610:1: ( 'requires' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1610:1: ( 'requires' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1611:1: 'requires'
            {
             before(grammarAccess.getRequiresAccess().getRequiresKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__Requires__Group__0__Impl3184); 
             after(grammarAccess.getRequiresAccess().getRequiresKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Requires__Group__0__Impl"


    // $ANTLR start "rule__Requires__Group__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1624:1: rule__Requires__Group__1 : rule__Requires__Group__1__Impl rule__Requires__Group__2 ;
    public final void rule__Requires__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1628:1: ( rule__Requires__Group__1__Impl rule__Requires__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1629:2: rule__Requires__Group__1__Impl rule__Requires__Group__2
            {
            pushFollow(FOLLOW_rule__Requires__Group__1__Impl_in_rule__Requires__Group__13215);
            rule__Requires__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Requires__Group__2_in_rule__Requires__Group__13218);
            rule__Requires__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Requires__Group__1"


    // $ANTLR start "rule__Requires__Group__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1636:1: rule__Requires__Group__1__Impl : ( ( rule__Requires__AndExpressionAssignment_1 ) ) ;
    public final void rule__Requires__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1640:1: ( ( ( rule__Requires__AndExpressionAssignment_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1641:1: ( ( rule__Requires__AndExpressionAssignment_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1641:1: ( ( rule__Requires__AndExpressionAssignment_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1642:1: ( rule__Requires__AndExpressionAssignment_1 )
            {
             before(grammarAccess.getRequiresAccess().getAndExpressionAssignment_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1643:1: ( rule__Requires__AndExpressionAssignment_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1643:2: rule__Requires__AndExpressionAssignment_1
            {
            pushFollow(FOLLOW_rule__Requires__AndExpressionAssignment_1_in_rule__Requires__Group__1__Impl3245);
            rule__Requires__AndExpressionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRequiresAccess().getAndExpressionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Requires__Group__1__Impl"


    // $ANTLR start "rule__Requires__Group__2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1653:1: rule__Requires__Group__2 : rule__Requires__Group__2__Impl ;
    public final void rule__Requires__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1657:1: ( rule__Requires__Group__2__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1658:2: rule__Requires__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Requires__Group__2__Impl_in_rule__Requires__Group__23275);
            rule__Requires__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Requires__Group__2"


    // $ANTLR start "rule__Requires__Group__2__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1664:1: rule__Requires__Group__2__Impl : ( ';' ) ;
    public final void rule__Requires__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1668:1: ( ( ';' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1669:1: ( ';' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1669:1: ( ';' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1670:1: ';'
            {
             before(grammarAccess.getRequiresAccess().getSemicolonKeyword_2()); 
            match(input,17,FOLLOW_17_in_rule__Requires__Group__2__Impl3303); 
             after(grammarAccess.getRequiresAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Requires__Group__2__Impl"


    // $ANTLR start "rule__AndExpression__Group__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1689:1: rule__AndExpression__Group__0 : rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1 ;
    public final void rule__AndExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1693:1: ( rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1694:2: rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1
            {
            pushFollow(FOLLOW_rule__AndExpression__Group__0__Impl_in_rule__AndExpression__Group__03340);
            rule__AndExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AndExpression__Group__1_in_rule__AndExpression__Group__03343);
            rule__AndExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__0"


    // $ANTLR start "rule__AndExpression__Group__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1701:1: rule__AndExpression__Group__0__Impl : ( ( rule__AndExpression__OrExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1705:1: ( ( ( rule__AndExpression__OrExpressionsAssignment_0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1706:1: ( ( rule__AndExpression__OrExpressionsAssignment_0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1706:1: ( ( rule__AndExpression__OrExpressionsAssignment_0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1707:1: ( rule__AndExpression__OrExpressionsAssignment_0 )
            {
             before(grammarAccess.getAndExpressionAccess().getOrExpressionsAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1708:1: ( rule__AndExpression__OrExpressionsAssignment_0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1708:2: rule__AndExpression__OrExpressionsAssignment_0
            {
            pushFollow(FOLLOW_rule__AndExpression__OrExpressionsAssignment_0_in_rule__AndExpression__Group__0__Impl3370);
            rule__AndExpression__OrExpressionsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAndExpressionAccess().getOrExpressionsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__0__Impl"


    // $ANTLR start "rule__AndExpression__Group__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1718:1: rule__AndExpression__Group__1 : rule__AndExpression__Group__1__Impl ;
    public final void rule__AndExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1722:1: ( rule__AndExpression__Group__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1723:2: rule__AndExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AndExpression__Group__1__Impl_in_rule__AndExpression__Group__13400);
            rule__AndExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__1"


    // $ANTLR start "rule__AndExpression__Group__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1729:1: rule__AndExpression__Group__1__Impl : ( ( rule__AndExpression__Group_1__0 )* ) ;
    public final void rule__AndExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1733:1: ( ( ( rule__AndExpression__Group_1__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1734:1: ( ( rule__AndExpression__Group_1__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1734:1: ( ( rule__AndExpression__Group_1__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1735:1: ( rule__AndExpression__Group_1__0 )*
            {
             before(grammarAccess.getAndExpressionAccess().getGroup_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1736:1: ( rule__AndExpression__Group_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==24) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1736:2: rule__AndExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AndExpression__Group_1__0_in_rule__AndExpression__Group__1__Impl3427);
            	    rule__AndExpression__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getAndExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__1__Impl"


    // $ANTLR start "rule__AndExpression__Group_1__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1750:1: rule__AndExpression__Group_1__0 : rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1 ;
    public final void rule__AndExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1754:1: ( rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1755:2: rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__AndExpression__Group_1__0__Impl_in_rule__AndExpression__Group_1__03462);
            rule__AndExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AndExpression__Group_1__1_in_rule__AndExpression__Group_1__03465);
            rule__AndExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__0"


    // $ANTLR start "rule__AndExpression__Group_1__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1762:1: rule__AndExpression__Group_1__0__Impl : ( '&&' ) ;
    public final void rule__AndExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1766:1: ( ( '&&' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1767:1: ( '&&' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1767:1: ( '&&' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1768:1: '&&'
            {
             before(grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_0()); 
            match(input,24,FOLLOW_24_in_rule__AndExpression__Group_1__0__Impl3493); 
             after(grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__0__Impl"


    // $ANTLR start "rule__AndExpression__Group_1__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1781:1: rule__AndExpression__Group_1__1 : rule__AndExpression__Group_1__1__Impl ;
    public final void rule__AndExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1785:1: ( rule__AndExpression__Group_1__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1786:2: rule__AndExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AndExpression__Group_1__1__Impl_in_rule__AndExpression__Group_1__13524);
            rule__AndExpression__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__1"


    // $ANTLR start "rule__AndExpression__Group_1__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1792:1: rule__AndExpression__Group_1__1__Impl : ( ( rule__AndExpression__OrExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1796:1: ( ( ( rule__AndExpression__OrExpressionsAssignment_1_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1797:1: ( ( rule__AndExpression__OrExpressionsAssignment_1_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1797:1: ( ( rule__AndExpression__OrExpressionsAssignment_1_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1798:1: ( rule__AndExpression__OrExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getAndExpressionAccess().getOrExpressionsAssignment_1_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1799:1: ( rule__AndExpression__OrExpressionsAssignment_1_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1799:2: rule__AndExpression__OrExpressionsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__AndExpression__OrExpressionsAssignment_1_1_in_rule__AndExpression__Group_1__1__Impl3551);
            rule__AndExpression__OrExpressionsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAndExpressionAccess().getOrExpressionsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__1__Impl"


    // $ANTLR start "rule__OrExpression__Group__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1813:1: rule__OrExpression__Group__0 : rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1 ;
    public final void rule__OrExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1817:1: ( rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1818:2: rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1
            {
            pushFollow(FOLLOW_rule__OrExpression__Group__0__Impl_in_rule__OrExpression__Group__03585);
            rule__OrExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OrExpression__Group__1_in_rule__OrExpression__Group__03588);
            rule__OrExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group__0"


    // $ANTLR start "rule__OrExpression__Group__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1825:1: rule__OrExpression__Group__0__Impl : ( ( rule__OrExpression__BasicExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1829:1: ( ( ( rule__OrExpression__BasicExpressionsAssignment_0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1830:1: ( ( rule__OrExpression__BasicExpressionsAssignment_0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1830:1: ( ( rule__OrExpression__BasicExpressionsAssignment_0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1831:1: ( rule__OrExpression__BasicExpressionsAssignment_0 )
            {
             before(grammarAccess.getOrExpressionAccess().getBasicExpressionsAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1832:1: ( rule__OrExpression__BasicExpressionsAssignment_0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1832:2: rule__OrExpression__BasicExpressionsAssignment_0
            {
            pushFollow(FOLLOW_rule__OrExpression__BasicExpressionsAssignment_0_in_rule__OrExpression__Group__0__Impl3615);
            rule__OrExpression__BasicExpressionsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOrExpressionAccess().getBasicExpressionsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group__0__Impl"


    // $ANTLR start "rule__OrExpression__Group__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1842:1: rule__OrExpression__Group__1 : rule__OrExpression__Group__1__Impl ;
    public final void rule__OrExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1846:1: ( rule__OrExpression__Group__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1847:2: rule__OrExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__OrExpression__Group__1__Impl_in_rule__OrExpression__Group__13645);
            rule__OrExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group__1"


    // $ANTLR start "rule__OrExpression__Group__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1853:1: rule__OrExpression__Group__1__Impl : ( ( rule__OrExpression__Group_1__0 )* ) ;
    public final void rule__OrExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1857:1: ( ( ( rule__OrExpression__Group_1__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1858:1: ( ( rule__OrExpression__Group_1__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1858:1: ( ( rule__OrExpression__Group_1__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1859:1: ( rule__OrExpression__Group_1__0 )*
            {
             before(grammarAccess.getOrExpressionAccess().getGroup_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1860:1: ( rule__OrExpression__Group_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==25) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1860:2: rule__OrExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__OrExpression__Group_1__0_in_rule__OrExpression__Group__1__Impl3672);
            	    rule__OrExpression__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getOrExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group__1__Impl"


    // $ANTLR start "rule__OrExpression__Group_1__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1874:1: rule__OrExpression__Group_1__0 : rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1 ;
    public final void rule__OrExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1878:1: ( rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1879:2: rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__OrExpression__Group_1__0__Impl_in_rule__OrExpression__Group_1__03707);
            rule__OrExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OrExpression__Group_1__1_in_rule__OrExpression__Group_1__03710);
            rule__OrExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__0"


    // $ANTLR start "rule__OrExpression__Group_1__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1886:1: rule__OrExpression__Group_1__0__Impl : ( '||' ) ;
    public final void rule__OrExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1890:1: ( ( '||' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1891:1: ( '||' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1891:1: ( '||' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1892:1: '||'
            {
             before(grammarAccess.getOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_0()); 
            match(input,25,FOLLOW_25_in_rule__OrExpression__Group_1__0__Impl3738); 
             after(grammarAccess.getOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__0__Impl"


    // $ANTLR start "rule__OrExpression__Group_1__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1905:1: rule__OrExpression__Group_1__1 : rule__OrExpression__Group_1__1__Impl ;
    public final void rule__OrExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1909:1: ( rule__OrExpression__Group_1__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1910:2: rule__OrExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__OrExpression__Group_1__1__Impl_in_rule__OrExpression__Group_1__13769);
            rule__OrExpression__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__1"


    // $ANTLR start "rule__OrExpression__Group_1__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1916:1: rule__OrExpression__Group_1__1__Impl : ( ( rule__OrExpression__BasicExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1920:1: ( ( ( rule__OrExpression__BasicExpressionsAssignment_1_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1921:1: ( ( rule__OrExpression__BasicExpressionsAssignment_1_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1921:1: ( ( rule__OrExpression__BasicExpressionsAssignment_1_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1922:1: ( rule__OrExpression__BasicExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getOrExpressionAccess().getBasicExpressionsAssignment_1_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1923:1: ( rule__OrExpression__BasicExpressionsAssignment_1_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1923:2: rule__OrExpression__BasicExpressionsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__OrExpression__BasicExpressionsAssignment_1_1_in_rule__OrExpression__Group_1__1__Impl3796);
            rule__OrExpression__BasicExpressionsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getOrExpressionAccess().getBasicExpressionsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__1__Impl"


    // $ANTLR start "rule__BasicExpression__Group__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1937:1: rule__BasicExpression__Group__0 : rule__BasicExpression__Group__0__Impl rule__BasicExpression__Group__1 ;
    public final void rule__BasicExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1941:1: ( rule__BasicExpression__Group__0__Impl rule__BasicExpression__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1942:2: rule__BasicExpression__Group__0__Impl rule__BasicExpression__Group__1
            {
            pushFollow(FOLLOW_rule__BasicExpression__Group__0__Impl_in_rule__BasicExpression__Group__03830);
            rule__BasicExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BasicExpression__Group__1_in_rule__BasicExpression__Group__03833);
            rule__BasicExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicExpression__Group__0"


    // $ANTLR start "rule__BasicExpression__Group__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1949:1: rule__BasicExpression__Group__0__Impl : ( ( rule__BasicExpression__NegatedAssignment_0 )? ) ;
    public final void rule__BasicExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1953:1: ( ( ( rule__BasicExpression__NegatedAssignment_0 )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1954:1: ( ( rule__BasicExpression__NegatedAssignment_0 )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1954:1: ( ( rule__BasicExpression__NegatedAssignment_0 )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1955:1: ( rule__BasicExpression__NegatedAssignment_0 )?
            {
             before(grammarAccess.getBasicExpressionAccess().getNegatedAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1956:1: ( rule__BasicExpression__NegatedAssignment_0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==31) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1956:2: rule__BasicExpression__NegatedAssignment_0
                    {
                    pushFollow(FOLLOW_rule__BasicExpression__NegatedAssignment_0_in_rule__BasicExpression__Group__0__Impl3860);
                    rule__BasicExpression__NegatedAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBasicExpressionAccess().getNegatedAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicExpression__Group__0__Impl"


    // $ANTLR start "rule__BasicExpression__Group__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1966:1: rule__BasicExpression__Group__1 : rule__BasicExpression__Group__1__Impl ;
    public final void rule__BasicExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1970:1: ( rule__BasicExpression__Group__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1971:2: rule__BasicExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BasicExpression__Group__1__Impl_in_rule__BasicExpression__Group__13891);
            rule__BasicExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicExpression__Group__1"


    // $ANTLR start "rule__BasicExpression__Group__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1977:1: rule__BasicExpression__Group__1__Impl : ( ( rule__BasicExpression__ExprAssignment_1 ) ) ;
    public final void rule__BasicExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1981:1: ( ( ( rule__BasicExpression__ExprAssignment_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1982:1: ( ( rule__BasicExpression__ExprAssignment_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1982:1: ( ( rule__BasicExpression__ExprAssignment_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1983:1: ( rule__BasicExpression__ExprAssignment_1 )
            {
             before(grammarAccess.getBasicExpressionAccess().getExprAssignment_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1984:1: ( rule__BasicExpression__ExprAssignment_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1984:2: rule__BasicExpression__ExprAssignment_1
            {
            pushFollow(FOLLOW_rule__BasicExpression__ExprAssignment_1_in_rule__BasicExpression__Group__1__Impl3918);
            rule__BasicExpression__ExprAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBasicExpressionAccess().getExprAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicExpression__Group__1__Impl"


    // $ANTLR start "rule__MutexSet__Group__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1998:1: rule__MutexSet__Group__0 : rule__MutexSet__Group__0__Impl rule__MutexSet__Group__1 ;
    public final void rule__MutexSet__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2002:1: ( rule__MutexSet__Group__0__Impl rule__MutexSet__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2003:2: rule__MutexSet__Group__0__Impl rule__MutexSet__Group__1
            {
            pushFollow(FOLLOW_rule__MutexSet__Group__0__Impl_in_rule__MutexSet__Group__03952);
            rule__MutexSet__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MutexSet__Group__1_in_rule__MutexSet__Group__03955);
            rule__MutexSet__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutexSet__Group__0"


    // $ANTLR start "rule__MutexSet__Group__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2010:1: rule__MutexSet__Group__0__Impl : ( 'mutex' ) ;
    public final void rule__MutexSet__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2014:1: ( ( 'mutex' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2015:1: ( 'mutex' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2015:1: ( 'mutex' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2016:1: 'mutex'
            {
             before(grammarAccess.getMutexSetAccess().getMutexKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__MutexSet__Group__0__Impl3983); 
             after(grammarAccess.getMutexSetAccess().getMutexKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutexSet__Group__0__Impl"


    // $ANTLR start "rule__MutexSet__Group__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2029:1: rule__MutexSet__Group__1 : rule__MutexSet__Group__1__Impl rule__MutexSet__Group__2 ;
    public final void rule__MutexSet__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2033:1: ( rule__MutexSet__Group__1__Impl rule__MutexSet__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2034:2: rule__MutexSet__Group__1__Impl rule__MutexSet__Group__2
            {
            pushFollow(FOLLOW_rule__MutexSet__Group__1__Impl_in_rule__MutexSet__Group__14014);
            rule__MutexSet__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MutexSet__Group__2_in_rule__MutexSet__Group__14017);
            rule__MutexSet__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutexSet__Group__1"


    // $ANTLR start "rule__MutexSet__Group__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2041:1: rule__MutexSet__Group__1__Impl : ( '{' ) ;
    public final void rule__MutexSet__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2045:1: ( ( '{' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2046:1: ( '{' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2046:1: ( '{' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2047:1: '{'
            {
             before(grammarAccess.getMutexSetAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,14,FOLLOW_14_in_rule__MutexSet__Group__1__Impl4045); 
             after(grammarAccess.getMutexSetAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutexSet__Group__1__Impl"


    // $ANTLR start "rule__MutexSet__Group__2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2060:1: rule__MutexSet__Group__2 : rule__MutexSet__Group__2__Impl rule__MutexSet__Group__3 ;
    public final void rule__MutexSet__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2064:1: ( rule__MutexSet__Group__2__Impl rule__MutexSet__Group__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2065:2: rule__MutexSet__Group__2__Impl rule__MutexSet__Group__3
            {
            pushFollow(FOLLOW_rule__MutexSet__Group__2__Impl_in_rule__MutexSet__Group__24076);
            rule__MutexSet__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MutexSet__Group__3_in_rule__MutexSet__Group__24079);
            rule__MutexSet__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutexSet__Group__2"


    // $ANTLR start "rule__MutexSet__Group__2__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2072:1: rule__MutexSet__Group__2__Impl : ( ( rule__MutexSet__MethodsAssignment_2 ) ) ;
    public final void rule__MutexSet__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2076:1: ( ( ( rule__MutexSet__MethodsAssignment_2 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2077:1: ( ( rule__MutexSet__MethodsAssignment_2 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2077:1: ( ( rule__MutexSet__MethodsAssignment_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2078:1: ( rule__MutexSet__MethodsAssignment_2 )
            {
             before(grammarAccess.getMutexSetAccess().getMethodsAssignment_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2079:1: ( rule__MutexSet__MethodsAssignment_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2079:2: rule__MutexSet__MethodsAssignment_2
            {
            pushFollow(FOLLOW_rule__MutexSet__MethodsAssignment_2_in_rule__MutexSet__Group__2__Impl4106);
            rule__MutexSet__MethodsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMutexSetAccess().getMethodsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutexSet__Group__2__Impl"


    // $ANTLR start "rule__MutexSet__Group__3"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2089:1: rule__MutexSet__Group__3 : rule__MutexSet__Group__3__Impl rule__MutexSet__Group__4 ;
    public final void rule__MutexSet__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2093:1: ( rule__MutexSet__Group__3__Impl rule__MutexSet__Group__4 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2094:2: rule__MutexSet__Group__3__Impl rule__MutexSet__Group__4
            {
            pushFollow(FOLLOW_rule__MutexSet__Group__3__Impl_in_rule__MutexSet__Group__34136);
            rule__MutexSet__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MutexSet__Group__4_in_rule__MutexSet__Group__34139);
            rule__MutexSet__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutexSet__Group__3"


    // $ANTLR start "rule__MutexSet__Group__3__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2101:1: rule__MutexSet__Group__3__Impl : ( ( ( rule__MutexSet__Group_3__0 ) ) ( ( rule__MutexSet__Group_3__0 )* ) ) ;
    public final void rule__MutexSet__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2105:1: ( ( ( ( rule__MutexSet__Group_3__0 ) ) ( ( rule__MutexSet__Group_3__0 )* ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2106:1: ( ( ( rule__MutexSet__Group_3__0 ) ) ( ( rule__MutexSet__Group_3__0 )* ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2106:1: ( ( ( rule__MutexSet__Group_3__0 ) ) ( ( rule__MutexSet__Group_3__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2107:1: ( ( rule__MutexSet__Group_3__0 ) ) ( ( rule__MutexSet__Group_3__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2107:1: ( ( rule__MutexSet__Group_3__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2108:1: ( rule__MutexSet__Group_3__0 )
            {
             before(grammarAccess.getMutexSetAccess().getGroup_3()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2109:1: ( rule__MutexSet__Group_3__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2109:2: rule__MutexSet__Group_3__0
            {
            pushFollow(FOLLOW_rule__MutexSet__Group_3__0_in_rule__MutexSet__Group__3__Impl4168);
            rule__MutexSet__Group_3__0();

            state._fsp--;


            }

             after(grammarAccess.getMutexSetAccess().getGroup_3()); 

            }

            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2112:1: ( ( rule__MutexSet__Group_3__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2113:1: ( rule__MutexSet__Group_3__0 )*
            {
             before(grammarAccess.getMutexSetAccess().getGroup_3()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2114:1: ( rule__MutexSet__Group_3__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==18) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2114:2: rule__MutexSet__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__MutexSet__Group_3__0_in_rule__MutexSet__Group__3__Impl4180);
            	    rule__MutexSet__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getMutexSetAccess().getGroup_3()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutexSet__Group__3__Impl"


    // $ANTLR start "rule__MutexSet__Group__4"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2125:1: rule__MutexSet__Group__4 : rule__MutexSet__Group__4__Impl ;
    public final void rule__MutexSet__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2129:1: ( rule__MutexSet__Group__4__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2130:2: rule__MutexSet__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__MutexSet__Group__4__Impl_in_rule__MutexSet__Group__44213);
            rule__MutexSet__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutexSet__Group__4"


    // $ANTLR start "rule__MutexSet__Group__4__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2136:1: rule__MutexSet__Group__4__Impl : ( '};' ) ;
    public final void rule__MutexSet__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2140:1: ( ( '};' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2141:1: ( '};' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2141:1: ( '};' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2142:1: '};'
            {
             before(grammarAccess.getMutexSetAccess().getRightCurlyBracketSemicolonKeyword_4()); 
            match(input,27,FOLLOW_27_in_rule__MutexSet__Group__4__Impl4241); 
             after(grammarAccess.getMutexSetAccess().getRightCurlyBracketSemicolonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutexSet__Group__4__Impl"


    // $ANTLR start "rule__MutexSet__Group_3__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2165:1: rule__MutexSet__Group_3__0 : rule__MutexSet__Group_3__0__Impl rule__MutexSet__Group_3__1 ;
    public final void rule__MutexSet__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2169:1: ( rule__MutexSet__Group_3__0__Impl rule__MutexSet__Group_3__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2170:2: rule__MutexSet__Group_3__0__Impl rule__MutexSet__Group_3__1
            {
            pushFollow(FOLLOW_rule__MutexSet__Group_3__0__Impl_in_rule__MutexSet__Group_3__04282);
            rule__MutexSet__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MutexSet__Group_3__1_in_rule__MutexSet__Group_3__04285);
            rule__MutexSet__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutexSet__Group_3__0"


    // $ANTLR start "rule__MutexSet__Group_3__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2177:1: rule__MutexSet__Group_3__0__Impl : ( ',' ) ;
    public final void rule__MutexSet__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2181:1: ( ( ',' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2182:1: ( ',' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2182:1: ( ',' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2183:1: ','
            {
             before(grammarAccess.getMutexSetAccess().getCommaKeyword_3_0()); 
            match(input,18,FOLLOW_18_in_rule__MutexSet__Group_3__0__Impl4313); 
             after(grammarAccess.getMutexSetAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutexSet__Group_3__0__Impl"


    // $ANTLR start "rule__MutexSet__Group_3__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2196:1: rule__MutexSet__Group_3__1 : rule__MutexSet__Group_3__1__Impl ;
    public final void rule__MutexSet__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2200:1: ( rule__MutexSet__Group_3__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2201:2: rule__MutexSet__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__MutexSet__Group_3__1__Impl_in_rule__MutexSet__Group_3__14344);
            rule__MutexSet__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutexSet__Group_3__1"


    // $ANTLR start "rule__MutexSet__Group_3__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2207:1: rule__MutexSet__Group_3__1__Impl : ( ( rule__MutexSet__MethodsAssignment_3_1 ) ) ;
    public final void rule__MutexSet__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2211:1: ( ( ( rule__MutexSet__MethodsAssignment_3_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2212:1: ( ( rule__MutexSet__MethodsAssignment_3_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2212:1: ( ( rule__MutexSet__MethodsAssignment_3_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2213:1: ( rule__MutexSet__MethodsAssignment_3_1 )
            {
             before(grammarAccess.getMutexSetAccess().getMethodsAssignment_3_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2214:1: ( rule__MutexSet__MethodsAssignment_3_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2214:2: rule__MutexSet__MethodsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__MutexSet__MethodsAssignment_3_1_in_rule__MutexSet__Group_3__1__Impl4371);
            rule__MutexSet__MethodsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getMutexSetAccess().getMethodsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutexSet__Group_3__1__Impl"


    // $ANTLR start "rule__CondVar__Group__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2228:1: rule__CondVar__Group__0 : rule__CondVar__Group__0__Impl rule__CondVar__Group__1 ;
    public final void rule__CondVar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2232:1: ( rule__CondVar__Group__0__Impl rule__CondVar__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2233:2: rule__CondVar__Group__0__Impl rule__CondVar__Group__1
            {
            pushFollow(FOLLOW_rule__CondVar__Group__0__Impl_in_rule__CondVar__Group__04405);
            rule__CondVar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CondVar__Group__1_in_rule__CondVar__Group__04408);
            rule__CondVar__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CondVar__Group__0"


    // $ANTLR start "rule__CondVar__Group__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2240:1: rule__CondVar__Group__0__Impl : ( ( rule__CondVar__NameAssignment_0 ) ) ;
    public final void rule__CondVar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2244:1: ( ( ( rule__CondVar__NameAssignment_0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2245:1: ( ( rule__CondVar__NameAssignment_0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2245:1: ( ( rule__CondVar__NameAssignment_0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2246:1: ( rule__CondVar__NameAssignment_0 )
            {
             before(grammarAccess.getCondVarAccess().getNameAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2247:1: ( rule__CondVar__NameAssignment_0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2247:2: rule__CondVar__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__CondVar__NameAssignment_0_in_rule__CondVar__Group__0__Impl4435);
            rule__CondVar__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getCondVarAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CondVar__Group__0__Impl"


    // $ANTLR start "rule__CondVar__Group__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2257:1: rule__CondVar__Group__1 : rule__CondVar__Group__1__Impl rule__CondVar__Group__2 ;
    public final void rule__CondVar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2261:1: ( rule__CondVar__Group__1__Impl rule__CondVar__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2262:2: rule__CondVar__Group__1__Impl rule__CondVar__Group__2
            {
            pushFollow(FOLLOW_rule__CondVar__Group__1__Impl_in_rule__CondVar__Group__14465);
            rule__CondVar__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CondVar__Group__2_in_rule__CondVar__Group__14468);
            rule__CondVar__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CondVar__Group__1"


    // $ANTLR start "rule__CondVar__Group__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2269:1: rule__CondVar__Group__1__Impl : ( '=' ) ;
    public final void rule__CondVar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2273:1: ( ( '=' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2274:1: ( '=' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2274:1: ( '=' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2275:1: '='
            {
             before(grammarAccess.getCondVarAccess().getEqualsSignKeyword_1()); 
            match(input,28,FOLLOW_28_in_rule__CondVar__Group__1__Impl4496); 
             after(grammarAccess.getCondVarAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CondVar__Group__1__Impl"


    // $ANTLR start "rule__CondVar__Group__2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2288:1: rule__CondVar__Group__2 : rule__CondVar__Group__2__Impl ;
    public final void rule__CondVar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2292:1: ( rule__CondVar__Group__2__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2293:2: rule__CondVar__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__CondVar__Group__2__Impl_in_rule__CondVar__Group__24527);
            rule__CondVar__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CondVar__Group__2"


    // $ANTLR start "rule__CondVar__Group__2__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2299:1: rule__CondVar__Group__2__Impl : ( ( rule__CondVar__ValueAssignment_2 ) ) ;
    public final void rule__CondVar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2303:1: ( ( ( rule__CondVar__ValueAssignment_2 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2304:1: ( ( rule__CondVar__ValueAssignment_2 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2304:1: ( ( rule__CondVar__ValueAssignment_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2305:1: ( rule__CondVar__ValueAssignment_2 )
            {
             before(grammarAccess.getCondVarAccess().getValueAssignment_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2306:1: ( rule__CondVar__ValueAssignment_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2306:2: rule__CondVar__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__CondVar__ValueAssignment_2_in_rule__CondVar__Group__2__Impl4554);
            rule__CondVar__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCondVarAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CondVar__Group__2__Impl"


    // $ANTLR start "rule__OrdVar__Group__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2322:1: rule__OrdVar__Group__0 : rule__OrdVar__Group__0__Impl rule__OrdVar__Group__1 ;
    public final void rule__OrdVar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2326:1: ( rule__OrdVar__Group__0__Impl rule__OrdVar__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2327:2: rule__OrdVar__Group__0__Impl rule__OrdVar__Group__1
            {
            pushFollow(FOLLOW_rule__OrdVar__Group__0__Impl_in_rule__OrdVar__Group__04590);
            rule__OrdVar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OrdVar__Group__1_in_rule__OrdVar__Group__04593);
            rule__OrdVar__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrdVar__Group__0"


    // $ANTLR start "rule__OrdVar__Group__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2334:1: rule__OrdVar__Group__0__Impl : ( ( rule__OrdVar__NameAssignment_0 ) ) ;
    public final void rule__OrdVar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2338:1: ( ( ( rule__OrdVar__NameAssignment_0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2339:1: ( ( rule__OrdVar__NameAssignment_0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2339:1: ( ( rule__OrdVar__NameAssignment_0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2340:1: ( rule__OrdVar__NameAssignment_0 )
            {
             before(grammarAccess.getOrdVarAccess().getNameAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2341:1: ( rule__OrdVar__NameAssignment_0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2341:2: rule__OrdVar__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__OrdVar__NameAssignment_0_in_rule__OrdVar__Group__0__Impl4620);
            rule__OrdVar__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOrdVarAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrdVar__Group__0__Impl"


    // $ANTLR start "rule__OrdVar__Group__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2351:1: rule__OrdVar__Group__1 : rule__OrdVar__Group__1__Impl rule__OrdVar__Group__2 ;
    public final void rule__OrdVar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2355:1: ( rule__OrdVar__Group__1__Impl rule__OrdVar__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2356:2: rule__OrdVar__Group__1__Impl rule__OrdVar__Group__2
            {
            pushFollow(FOLLOW_rule__OrdVar__Group__1__Impl_in_rule__OrdVar__Group__14650);
            rule__OrdVar__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OrdVar__Group__2_in_rule__OrdVar__Group__14653);
            rule__OrdVar__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrdVar__Group__1"


    // $ANTLR start "rule__OrdVar__Group__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2363:1: rule__OrdVar__Group__1__Impl : ( '=' ) ;
    public final void rule__OrdVar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2367:1: ( ( '=' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2368:1: ( '=' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2368:1: ( '=' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2369:1: '='
            {
             before(grammarAccess.getOrdVarAccess().getEqualsSignKeyword_1()); 
            match(input,28,FOLLOW_28_in_rule__OrdVar__Group__1__Impl4681); 
             after(grammarAccess.getOrdVarAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrdVar__Group__1__Impl"


    // $ANTLR start "rule__OrdVar__Group__2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2382:1: rule__OrdVar__Group__2 : rule__OrdVar__Group__2__Impl ;
    public final void rule__OrdVar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2386:1: ( rule__OrdVar__Group__2__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2387:2: rule__OrdVar__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__OrdVar__Group__2__Impl_in_rule__OrdVar__Group__24712);
            rule__OrdVar__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrdVar__Group__2"


    // $ANTLR start "rule__OrdVar__Group__2__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2393:1: rule__OrdVar__Group__2__Impl : ( ( rule__OrdVar__ValueAssignment_2 ) ) ;
    public final void rule__OrdVar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2397:1: ( ( ( rule__OrdVar__ValueAssignment_2 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2398:1: ( ( rule__OrdVar__ValueAssignment_2 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2398:1: ( ( rule__OrdVar__ValueAssignment_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2399:1: ( rule__OrdVar__ValueAssignment_2 )
            {
             before(grammarAccess.getOrdVarAccess().getValueAssignment_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2400:1: ( rule__OrdVar__ValueAssignment_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2400:2: rule__OrdVar__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__OrdVar__ValueAssignment_2_in_rule__OrdVar__Group__2__Impl4739);
            rule__OrdVar__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOrdVarAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrdVar__Group__2__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2416:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2420:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2421:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__04775);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__04778);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2428:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2432:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2433:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2433:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2434:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl4805); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2445:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2449:1: ( rule__QualifiedName__Group__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2450:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__14834);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2456:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2460:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2461:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2461:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2462:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2463:1: ( rule__QualifiedName__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==29) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2463:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl4861);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2477:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2481:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2482:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__04896);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__04899);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2489:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2493:1: ( ( '.' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2494:1: ( '.' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2494:1: ( '.' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2495:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,29,FOLLOW_29_in_rule__QualifiedName__Group_1__0__Impl4927); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2508:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2512:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2513:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__14958);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2519:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2523:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2524:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2524:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2525:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl4985); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__CoordinatorDeclaration__GranularityAssignment_0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2541:1: rule__CoordinatorDeclaration__GranularityAssignment_0 : ( ( 'per_class' ) ) ;
    public final void rule__CoordinatorDeclaration__GranularityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2545:1: ( ( ( 'per_class' ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2546:1: ( ( 'per_class' ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2546:1: ( ( 'per_class' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2547:1: ( 'per_class' )
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getGranularityPer_classKeyword_0_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2548:1: ( 'per_class' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2549:1: 'per_class'
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getGranularityPer_classKeyword_0_0()); 
            match(input,30,FOLLOW_30_in_rule__CoordinatorDeclaration__GranularityAssignment_05028); 
             after(grammarAccess.getCoordinatorDeclarationAccess().getGranularityPer_classKeyword_0_0()); 

            }

             after(grammarAccess.getCoordinatorDeclarationAccess().getGranularityPer_classKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorDeclaration__GranularityAssignment_0"


    // $ANTLR start "rule__CoordinatorDeclaration__ClassNameAssignment_2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2564:1: rule__CoordinatorDeclaration__ClassNameAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__CoordinatorDeclaration__ClassNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2568:1: ( ( ruleQualifiedName ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2569:1: ( ruleQualifiedName )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2569:1: ( ruleQualifiedName )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2570:1: ruleQualifiedName
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getClassNameQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__CoordinatorDeclaration__ClassNameAssignment_25067);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getCoordinatorDeclarationAccess().getClassNameQualifiedNameParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorDeclaration__ClassNameAssignment_2"


    // $ANTLR start "rule__CoordinatorDeclaration__BodyAssignment_3"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2579:1: rule__CoordinatorDeclaration__BodyAssignment_3 : ( ruleCoordinatorBody ) ;
    public final void rule__CoordinatorDeclaration__BodyAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2583:1: ( ( ruleCoordinatorBody ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2584:1: ( ruleCoordinatorBody )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2584:1: ( ruleCoordinatorBody )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2585:1: ruleCoordinatorBody
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getBodyCoordinatorBodyParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleCoordinatorBody_in_rule__CoordinatorDeclaration__BodyAssignment_35098);
            ruleCoordinatorBody();

            state._fsp--;

             after(grammarAccess.getCoordinatorDeclarationAccess().getBodyCoordinatorBodyParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorDeclaration__BodyAssignment_3"


    // $ANTLR start "rule__CoordinatorBody__CondVarsAssignment_2_1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2594:1: rule__CoordinatorBody__CondVarsAssignment_2_1 : ( ruleCondVar ) ;
    public final void rule__CoordinatorBody__CondVarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2598:1: ( ( ruleCondVar ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2599:1: ( ruleCondVar )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2599:1: ( ruleCondVar )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2600:1: ruleCondVar
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCondVarsCondVarParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleCondVar_in_rule__CoordinatorBody__CondVarsAssignment_2_15129);
            ruleCondVar();

            state._fsp--;

             after(grammarAccess.getCoordinatorBodyAccess().getCondVarsCondVarParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__CondVarsAssignment_2_1"


    // $ANTLR start "rule__CoordinatorBody__CondVarsAssignment_2_2_1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2609:1: rule__CoordinatorBody__CondVarsAssignment_2_2_1 : ( ruleCondVar ) ;
    public final void rule__CoordinatorBody__CondVarsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2613:1: ( ( ruleCondVar ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2614:1: ( ruleCondVar )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2614:1: ( ruleCondVar )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2615:1: ruleCondVar
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCondVarsCondVarParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_ruleCondVar_in_rule__CoordinatorBody__CondVarsAssignment_2_2_15160);
            ruleCondVar();

            state._fsp--;

             after(grammarAccess.getCoordinatorBodyAccess().getCondVarsCondVarParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__CondVarsAssignment_2_2_1"


    // $ANTLR start "rule__CoordinatorBody__OrdVarsAssignment_3_1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2624:1: rule__CoordinatorBody__OrdVarsAssignment_3_1 : ( ruleOrdVar ) ;
    public final void rule__CoordinatorBody__OrdVarsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2628:1: ( ( ruleOrdVar ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2629:1: ( ruleOrdVar )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2629:1: ( ruleOrdVar )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2630:1: ruleOrdVar
            {
             before(grammarAccess.getCoordinatorBodyAccess().getOrdVarsOrdVarParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleOrdVar_in_rule__CoordinatorBody__OrdVarsAssignment_3_15191);
            ruleOrdVar();

            state._fsp--;

             after(grammarAccess.getCoordinatorBodyAccess().getOrdVarsOrdVarParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__OrdVarsAssignment_3_1"


    // $ANTLR start "rule__CoordinatorBody__OrdVarsAssignment_3_2_1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2639:1: rule__CoordinatorBody__OrdVarsAssignment_3_2_1 : ( ruleOrdVar ) ;
    public final void rule__CoordinatorBody__OrdVarsAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2643:1: ( ( ruleOrdVar ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2644:1: ( ruleOrdVar )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2644:1: ( ruleOrdVar )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2645:1: ruleOrdVar
            {
             before(grammarAccess.getCoordinatorBodyAccess().getOrdVarsOrdVarParserRuleCall_3_2_1_0()); 
            pushFollow(FOLLOW_ruleOrdVar_in_rule__CoordinatorBody__OrdVarsAssignment_3_2_15222);
            ruleOrdVar();

            state._fsp--;

             after(grammarAccess.getCoordinatorBodyAccess().getOrdVarsOrdVarParserRuleCall_3_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__OrdVarsAssignment_3_2_1"


    // $ANTLR start "rule__CoordinatorBody__SelfexMethodsAssignment_4_1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2654:1: rule__CoordinatorBody__SelfexMethodsAssignment_4_1 : ( ruleQualifiedName ) ;
    public final void rule__CoordinatorBody__SelfexMethodsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2658:1: ( ( ruleQualifiedName ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2659:1: ( ruleQualifiedName )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2659:1: ( ruleQualifiedName )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2660:1: ruleQualifiedName
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsQualifiedNameParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__CoordinatorBody__SelfexMethodsAssignment_4_15253);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsQualifiedNameParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__SelfexMethodsAssignment_4_1"


    // $ANTLR start "rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2669:1: rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 : ( ruleQualifiedName ) ;
    public final void rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2673:1: ( ( ruleQualifiedName ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2674:1: ( ruleQualifiedName )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2674:1: ( ruleQualifiedName )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2675:1: ruleQualifiedName
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsQualifiedNameParserRuleCall_4_2_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__CoordinatorBody__SelfexMethodsAssignment_4_2_15284);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsQualifiedNameParserRuleCall_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1"


    // $ANTLR start "rule__CoordinatorBody__MutexSetsAssignment_5"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2684:1: rule__CoordinatorBody__MutexSetsAssignment_5 : ( ruleMutexSet ) ;
    public final void rule__CoordinatorBody__MutexSetsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2688:1: ( ( ruleMutexSet ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2689:1: ( ruleMutexSet )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2689:1: ( ruleMutexSet )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2690:1: ruleMutexSet
            {
             before(grammarAccess.getCoordinatorBodyAccess().getMutexSetsMutexSetParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleMutexSet_in_rule__CoordinatorBody__MutexSetsAssignment_55315);
            ruleMutexSet();

            state._fsp--;

             after(grammarAccess.getCoordinatorBodyAccess().getMutexSetsMutexSetParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__MutexSetsAssignment_5"


    // $ANTLR start "rule__CoordinatorBody__GuardsAssignment_6"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2699:1: rule__CoordinatorBody__GuardsAssignment_6 : ( ruleGuard ) ;
    public final void rule__CoordinatorBody__GuardsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2703:1: ( ( ruleGuard ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2704:1: ( ruleGuard )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2704:1: ( ruleGuard )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2705:1: ruleGuard
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGuardsGuardParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleGuard_in_rule__CoordinatorBody__GuardsAssignment_65346);
            ruleGuard();

            state._fsp--;

             after(grammarAccess.getCoordinatorBodyAccess().getGuardsGuardParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CoordinatorBody__GuardsAssignment_6"


    // $ANTLR start "rule__Guard__MethodsAssignment_1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2714:1: rule__Guard__MethodsAssignment_1 : ( RULE_ID ) ;
    public final void rule__Guard__MethodsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2718:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2719:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2719:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2720:1: RULE_ID
            {
             before(grammarAccess.getGuardAccess().getMethodsIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Guard__MethodsAssignment_15377); 
             after(grammarAccess.getGuardAccess().getMethodsIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__MethodsAssignment_1"


    // $ANTLR start "rule__Guard__MethodsAssignment_2_1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2729:1: rule__Guard__MethodsAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Guard__MethodsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2733:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2734:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2734:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2735:1: RULE_ID
            {
             before(grammarAccess.getGuardAccess().getMethodsIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Guard__MethodsAssignment_2_15408); 
             after(grammarAccess.getGuardAccess().getMethodsIDTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__MethodsAssignment_2_1"


    // $ANTLR start "rule__Guard__RequiresAssignment_4"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2744:1: rule__Guard__RequiresAssignment_4 : ( ruleRequires ) ;
    public final void rule__Guard__RequiresAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2748:1: ( ( ruleRequires ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2749:1: ( ruleRequires )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2749:1: ( ruleRequires )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2750:1: ruleRequires
            {
             before(grammarAccess.getGuardAccess().getRequiresRequiresParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleRequires_in_rule__Guard__RequiresAssignment_45439);
            ruleRequires();

            state._fsp--;

             after(grammarAccess.getGuardAccess().getRequiresRequiresParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Guard__RequiresAssignment_4"


    // $ANTLR start "rule__Requires__AndExpressionAssignment_1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2759:1: rule__Requires__AndExpressionAssignment_1 : ( ruleAndExpression ) ;
    public final void rule__Requires__AndExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2763:1: ( ( ruleAndExpression ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2764:1: ( ruleAndExpression )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2764:1: ( ruleAndExpression )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2765:1: ruleAndExpression
            {
             before(grammarAccess.getRequiresAccess().getAndExpressionAndExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleAndExpression_in_rule__Requires__AndExpressionAssignment_15470);
            ruleAndExpression();

            state._fsp--;

             after(grammarAccess.getRequiresAccess().getAndExpressionAndExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Requires__AndExpressionAssignment_1"


    // $ANTLR start "rule__AndExpression__OrExpressionsAssignment_0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2774:1: rule__AndExpression__OrExpressionsAssignment_0 : ( ruleOrExpression ) ;
    public final void rule__AndExpression__OrExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2778:1: ( ( ruleOrExpression ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2779:1: ( ruleOrExpression )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2779:1: ( ruleOrExpression )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2780:1: ruleOrExpression
            {
             before(grammarAccess.getAndExpressionAccess().getOrExpressionsOrExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleOrExpression_in_rule__AndExpression__OrExpressionsAssignment_05501);
            ruleOrExpression();

            state._fsp--;

             after(grammarAccess.getAndExpressionAccess().getOrExpressionsOrExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__OrExpressionsAssignment_0"


    // $ANTLR start "rule__AndExpression__OrExpressionsAssignment_1_1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2789:1: rule__AndExpression__OrExpressionsAssignment_1_1 : ( ruleOrExpression ) ;
    public final void rule__AndExpression__OrExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2793:1: ( ( ruleOrExpression ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2794:1: ( ruleOrExpression )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2794:1: ( ruleOrExpression )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2795:1: ruleOrExpression
            {
             before(grammarAccess.getAndExpressionAccess().getOrExpressionsOrExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleOrExpression_in_rule__AndExpression__OrExpressionsAssignment_1_15532);
            ruleOrExpression();

            state._fsp--;

             after(grammarAccess.getAndExpressionAccess().getOrExpressionsOrExpressionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__OrExpressionsAssignment_1_1"


    // $ANTLR start "rule__OrExpression__BasicExpressionsAssignment_0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2804:1: rule__OrExpression__BasicExpressionsAssignment_0 : ( ruleBasicExpression ) ;
    public final void rule__OrExpression__BasicExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2808:1: ( ( ruleBasicExpression ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2809:1: ( ruleBasicExpression )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2809:1: ( ruleBasicExpression )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2810:1: ruleBasicExpression
            {
             before(grammarAccess.getOrExpressionAccess().getBasicExpressionsBasicExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleBasicExpression_in_rule__OrExpression__BasicExpressionsAssignment_05563);
            ruleBasicExpression();

            state._fsp--;

             after(grammarAccess.getOrExpressionAccess().getBasicExpressionsBasicExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__BasicExpressionsAssignment_0"


    // $ANTLR start "rule__OrExpression__BasicExpressionsAssignment_1_1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2819:1: rule__OrExpression__BasicExpressionsAssignment_1_1 : ( ruleBasicExpression ) ;
    public final void rule__OrExpression__BasicExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2823:1: ( ( ruleBasicExpression ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2824:1: ( ruleBasicExpression )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2824:1: ( ruleBasicExpression )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2825:1: ruleBasicExpression
            {
             before(grammarAccess.getOrExpressionAccess().getBasicExpressionsBasicExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleBasicExpression_in_rule__OrExpression__BasicExpressionsAssignment_1_15594);
            ruleBasicExpression();

            state._fsp--;

             after(grammarAccess.getOrExpressionAccess().getBasicExpressionsBasicExpressionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__BasicExpressionsAssignment_1_1"


    // $ANTLR start "rule__BasicExpression__NegatedAssignment_0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2834:1: rule__BasicExpression__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__BasicExpression__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2838:1: ( ( ( '!' ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2839:1: ( ( '!' ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2839:1: ( ( '!' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2840:1: ( '!' )
            {
             before(grammarAccess.getBasicExpressionAccess().getNegatedExclamationMarkKeyword_0_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2841:1: ( '!' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2842:1: '!'
            {
             before(grammarAccess.getBasicExpressionAccess().getNegatedExclamationMarkKeyword_0_0()); 
            match(input,31,FOLLOW_31_in_rule__BasicExpression__NegatedAssignment_05630); 
             after(grammarAccess.getBasicExpressionAccess().getNegatedExclamationMarkKeyword_0_0()); 

            }

             after(grammarAccess.getBasicExpressionAccess().getNegatedExclamationMarkKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicExpression__NegatedAssignment_0"


    // $ANTLR start "rule__BasicExpression__ExprAssignment_1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2857:1: rule__BasicExpression__ExprAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__BasicExpression__ExprAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2861:1: ( ( ( RULE_ID ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2862:1: ( ( RULE_ID ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2862:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2863:1: ( RULE_ID )
            {
             before(grammarAccess.getBasicExpressionAccess().getExprCondVarCrossReference_1_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2864:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2865:1: RULE_ID
            {
             before(grammarAccess.getBasicExpressionAccess().getExprCondVarIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__BasicExpression__ExprAssignment_15673); 
             after(grammarAccess.getBasicExpressionAccess().getExprCondVarIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getBasicExpressionAccess().getExprCondVarCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicExpression__ExprAssignment_1"


    // $ANTLR start "rule__MutexSet__MethodsAssignment_2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2876:1: rule__MutexSet__MethodsAssignment_2 : ( RULE_ID ) ;
    public final void rule__MutexSet__MethodsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2880:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2881:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2881:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2882:1: RULE_ID
            {
             before(grammarAccess.getMutexSetAccess().getMethodsIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MutexSet__MethodsAssignment_25708); 
             after(grammarAccess.getMutexSetAccess().getMethodsIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutexSet__MethodsAssignment_2"


    // $ANTLR start "rule__MutexSet__MethodsAssignment_3_1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2891:1: rule__MutexSet__MethodsAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__MutexSet__MethodsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2895:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2896:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2896:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2897:1: RULE_ID
            {
             before(grammarAccess.getMutexSetAccess().getMethodsIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MutexSet__MethodsAssignment_3_15739); 
             after(grammarAccess.getMutexSetAccess().getMethodsIDTerminalRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutexSet__MethodsAssignment_3_1"


    // $ANTLR start "rule__CondVar__NameAssignment_0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2906:1: rule__CondVar__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__CondVar__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2910:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2911:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2911:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2912:1: RULE_ID
            {
             before(grammarAccess.getCondVarAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__CondVar__NameAssignment_05770); 
             after(grammarAccess.getCondVarAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CondVar__NameAssignment_0"


    // $ANTLR start "rule__CondVar__ValueAssignment_2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2921:1: rule__CondVar__ValueAssignment_2 : ( ruleBooleanVal ) ;
    public final void rule__CondVar__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2925:1: ( ( ruleBooleanVal ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2926:1: ( ruleBooleanVal )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2926:1: ( ruleBooleanVal )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2927:1: ruleBooleanVal
            {
             before(grammarAccess.getCondVarAccess().getValueBooleanValParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleBooleanVal_in_rule__CondVar__ValueAssignment_25801);
            ruleBooleanVal();

            state._fsp--;

             after(grammarAccess.getCondVarAccess().getValueBooleanValParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CondVar__ValueAssignment_2"


    // $ANTLR start "rule__OrdVar__NameAssignment_0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2936:1: rule__OrdVar__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__OrdVar__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2940:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2941:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2941:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2942:1: RULE_ID
            {
             before(grammarAccess.getOrdVarAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__OrdVar__NameAssignment_05832); 
             after(grammarAccess.getOrdVarAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrdVar__NameAssignment_0"


    // $ANTLR start "rule__OrdVar__ValueAssignment_2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2951:1: rule__OrdVar__ValueAssignment_2 : ( RULE_INT ) ;
    public final void rule__OrdVar__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2955:1: ( ( RULE_INT ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2956:1: ( RULE_INT )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2956:1: ( RULE_INT )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2957:1: RULE_INT
            {
             before(grammarAccess.getOrdVarAccess().getValueINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__OrdVar__ValueAssignment_25863); 
             after(grammarAccess.getOrdVarAccess().getValueINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrdVar__ValueAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleCoordinatorDeclaration_in_entryRuleCoordinatorDeclaration61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCoordinatorDeclaration68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__0_in_ruleCoordinatorDeclaration94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCoordinatorBody_in_entryRuleCoordinatorBody121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCoordinatorBody128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__0_in_ruleCoordinatorBody154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_entryRuleGuard181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGuard188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group__0_in_ruleGuard214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequires_in_entryRuleRequires241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequires248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Requires__Group__0_in_ruleRequires274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_entryRuleAndExpression301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndExpression308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group__0_in_ruleAndExpression334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_entryRuleOrExpression361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrExpression368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group__0_in_ruleOrExpression394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicExpression_in_entryRuleBasicExpression421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicExpression428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicExpression__Group__0_in_ruleBasicExpression454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMutexSet_in_entryRuleMutexSet481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMutexSet488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__0_in_ruleMutexSet514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondVar_in_entryRuleCondVar541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCondVar548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__Group__0_in_ruleCondVar574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrdVar_in_entryRuleOrdVar601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrdVar608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__0_in_ruleOrdVar634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanVal_in_entryRuleBooleanVal661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanVal668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanVal__Alternatives_in_ruleBooleanVal694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__BooleanVal__Alternatives791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__BooleanVal__Alternatives811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__0__Impl_in_rule__CoordinatorDeclaration__Group__0843 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__1_in_rule__CoordinatorDeclaration__Group__0846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__GranularityAssignment_0_in_rule__CoordinatorDeclaration__Group__0__Impl873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__1__Impl_in_rule__CoordinatorDeclaration__Group__1904 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__2_in_rule__CoordinatorDeclaration__Group__1907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__CoordinatorDeclaration__Group__1__Impl935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__2__Impl_in_rule__CoordinatorDeclaration__Group__2966 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__3_in_rule__CoordinatorDeclaration__Group__2969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__ClassNameAssignment_2_in_rule__CoordinatorDeclaration__Group__2__Impl996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__3__Impl_in_rule__CoordinatorDeclaration__Group__31026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__BodyAssignment_3_in_rule__CoordinatorDeclaration__Group__3__Impl1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__0__Impl_in_rule__CoordinatorBody__Group__01092 = new BitSet(new long[]{0x0000000004398010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__1_in_rule__CoordinatorBody__Group__01095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__CoordinatorBody__Group__0__Impl1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__1__Impl_in_rule__CoordinatorBody__Group__11154 = new BitSet(new long[]{0x0000000004398010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__2_in_rule__CoordinatorBody__Group__11157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__2__Impl_in_rule__CoordinatorBody__Group__21215 = new BitSet(new long[]{0x0000000004398010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__3_in_rule__CoordinatorBody__Group__21218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__0_in_rule__CoordinatorBody__Group__2__Impl1245 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__3__Impl_in_rule__CoordinatorBody__Group__31276 = new BitSet(new long[]{0x0000000004398010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__4_in_rule__CoordinatorBody__Group__31279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__0_in_rule__CoordinatorBody__Group__3__Impl1306 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__4__Impl_in_rule__CoordinatorBody__Group__41337 = new BitSet(new long[]{0x0000000004398010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__5_in_rule__CoordinatorBody__Group__41340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__0_in_rule__CoordinatorBody__Group__4__Impl1367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__5__Impl_in_rule__CoordinatorBody__Group__51398 = new BitSet(new long[]{0x0000000004398010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__6_in_rule__CoordinatorBody__Group__51401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__MutexSetsAssignment_5_in_rule__CoordinatorBody__Group__5__Impl1428 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__6__Impl_in_rule__CoordinatorBody__Group__61459 = new BitSet(new long[]{0x0000000004398010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__7_in_rule__CoordinatorBody__Group__61462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__GuardsAssignment_6_in_rule__CoordinatorBody__Group__6__Impl1489 = new BitSet(new long[]{0x0000000000200012L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__7__Impl_in_rule__CoordinatorBody__Group__71520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__CoordinatorBody__Group__7__Impl1548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__0__Impl_in_rule__CoordinatorBody__Group_2__01595 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__1_in_rule__CoordinatorBody__Group_2__01598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__CoordinatorBody__Group_2__0__Impl1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__1__Impl_in_rule__CoordinatorBody__Group_2__11657 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__2_in_rule__CoordinatorBody__Group_2__11660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__CondVarsAssignment_2_1_in_rule__CoordinatorBody__Group_2__1__Impl1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__2__Impl_in_rule__CoordinatorBody__Group_2__21717 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__3_in_rule__CoordinatorBody__Group_2__21720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2_2__0_in_rule__CoordinatorBody__Group_2__2__Impl1747 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__3__Impl_in_rule__CoordinatorBody__Group_2__31778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__CoordinatorBody__Group_2__3__Impl1806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2_2__0__Impl_in_rule__CoordinatorBody__Group_2_2__01845 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2_2__1_in_rule__CoordinatorBody__Group_2_2__01848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__CoordinatorBody__Group_2_2__0__Impl1876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2_2__1__Impl_in_rule__CoordinatorBody__Group_2_2__11907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__CondVarsAssignment_2_2_1_in_rule__CoordinatorBody__Group_2_2__1__Impl1934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__0__Impl_in_rule__CoordinatorBody__Group_3__01968 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__1_in_rule__CoordinatorBody__Group_3__01971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__CoordinatorBody__Group_3__0__Impl1999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__1__Impl_in_rule__CoordinatorBody__Group_3__12030 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__2_in_rule__CoordinatorBody__Group_3__12033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__OrdVarsAssignment_3_1_in_rule__CoordinatorBody__Group_3__1__Impl2060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__2__Impl_in_rule__CoordinatorBody__Group_3__22090 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__3_in_rule__CoordinatorBody__Group_3__22093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3_2__0_in_rule__CoordinatorBody__Group_3__2__Impl2120 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__3__Impl_in_rule__CoordinatorBody__Group_3__32151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__CoordinatorBody__Group_3__3__Impl2179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3_2__0__Impl_in_rule__CoordinatorBody__Group_3_2__02218 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3_2__1_in_rule__CoordinatorBody__Group_3_2__02221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__CoordinatorBody__Group_3_2__0__Impl2249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3_2__1__Impl_in_rule__CoordinatorBody__Group_3_2__12280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__OrdVarsAssignment_3_2_1_in_rule__CoordinatorBody__Group_3_2__1__Impl2307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__0__Impl_in_rule__CoordinatorBody__Group_4__02341 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__1_in_rule__CoordinatorBody__Group_4__02344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__CoordinatorBody__Group_4__0__Impl2372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__1__Impl_in_rule__CoordinatorBody__Group_4__12403 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__2_in_rule__CoordinatorBody__Group_4__12406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__SelfexMethodsAssignment_4_1_in_rule__CoordinatorBody__Group_4__1__Impl2433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__2__Impl_in_rule__CoordinatorBody__Group_4__22463 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__3_in_rule__CoordinatorBody__Group_4__22466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4_2__0_in_rule__CoordinatorBody__Group_4__2__Impl2493 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__3__Impl_in_rule__CoordinatorBody__Group_4__32524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__CoordinatorBody__Group_4__3__Impl2552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4_2__0__Impl_in_rule__CoordinatorBody__Group_4_2__02591 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4_2__1_in_rule__CoordinatorBody__Group_4_2__02594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__CoordinatorBody__Group_4_2__0__Impl2622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4_2__1__Impl_in_rule__CoordinatorBody__Group_4_2__12653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1_in_rule__CoordinatorBody__Group_4_2__1__Impl2680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group__0__Impl_in_rule__Guard__Group__02714 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_rule__Guard__Group__1_in_rule__Guard__Group__02717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Guard__Group__0__Impl2746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group__1__Impl_in_rule__Guard__Group__12779 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_rule__Guard__Group__2_in_rule__Guard__Group__12782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__MethodsAssignment_1_in_rule__Guard__Group__1__Impl2809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group__2__Impl_in_rule__Guard__Group__22839 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_rule__Guard__Group__3_in_rule__Guard__Group__22842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group_2__0_in_rule__Guard__Group__2__Impl2869 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__Guard__Group__3__Impl_in_rule__Guard__Group__32900 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Guard__Group__4_in_rule__Guard__Group__32903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Guard__Group__3__Impl2931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group__4__Impl_in_rule__Guard__Group__42962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__RequiresAssignment_4_in_rule__Guard__Group__4__Impl2989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group_2__0__Impl_in_rule__Guard__Group_2__03030 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Guard__Group_2__1_in_rule__Guard__Group_2__03033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Guard__Group_2__0__Impl3061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group_2__1__Impl_in_rule__Guard__Group_2__13092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__MethodsAssignment_2_1_in_rule__Guard__Group_2__1__Impl3119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Requires__Group__0__Impl_in_rule__Requires__Group__03153 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_rule__Requires__Group__1_in_rule__Requires__Group__03156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Requires__Group__0__Impl3184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Requires__Group__1__Impl_in_rule__Requires__Group__13215 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Requires__Group__2_in_rule__Requires__Group__13218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Requires__AndExpressionAssignment_1_in_rule__Requires__Group__1__Impl3245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Requires__Group__2__Impl_in_rule__Requires__Group__23275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Requires__Group__2__Impl3303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group__0__Impl_in_rule__AndExpression__Group__03340 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__AndExpression__Group__1_in_rule__AndExpression__Group__03343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__OrExpressionsAssignment_0_in_rule__AndExpression__Group__0__Impl3370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group__1__Impl_in_rule__AndExpression__Group__13400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group_1__0_in_rule__AndExpression__Group__1__Impl3427 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group_1__0__Impl_in_rule__AndExpression__Group_1__03462 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_rule__AndExpression__Group_1__1_in_rule__AndExpression__Group_1__03465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__AndExpression__Group_1__0__Impl3493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group_1__1__Impl_in_rule__AndExpression__Group_1__13524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__OrExpressionsAssignment_1_1_in_rule__AndExpression__Group_1__1__Impl3551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group__0__Impl_in_rule__OrExpression__Group__03585 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__OrExpression__Group__1_in_rule__OrExpression__Group__03588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__BasicExpressionsAssignment_0_in_rule__OrExpression__Group__0__Impl3615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group__1__Impl_in_rule__OrExpression__Group__13645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group_1__0_in_rule__OrExpression__Group__1__Impl3672 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group_1__0__Impl_in_rule__OrExpression__Group_1__03707 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_rule__OrExpression__Group_1__1_in_rule__OrExpression__Group_1__03710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__OrExpression__Group_1__0__Impl3738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group_1__1__Impl_in_rule__OrExpression__Group_1__13769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__BasicExpressionsAssignment_1_1_in_rule__OrExpression__Group_1__1__Impl3796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicExpression__Group__0__Impl_in_rule__BasicExpression__Group__03830 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_rule__BasicExpression__Group__1_in_rule__BasicExpression__Group__03833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicExpression__NegatedAssignment_0_in_rule__BasicExpression__Group__0__Impl3860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicExpression__Group__1__Impl_in_rule__BasicExpression__Group__13891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicExpression__ExprAssignment_1_in_rule__BasicExpression__Group__1__Impl3918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__0__Impl_in_rule__MutexSet__Group__03952 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__1_in_rule__MutexSet__Group__03955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__MutexSet__Group__0__Impl3983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__1__Impl_in_rule__MutexSet__Group__14014 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__2_in_rule__MutexSet__Group__14017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__MutexSet__Group__1__Impl4045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__2__Impl_in_rule__MutexSet__Group__24076 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__3_in_rule__MutexSet__Group__24079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__MethodsAssignment_2_in_rule__MutexSet__Group__2__Impl4106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__3__Impl_in_rule__MutexSet__Group__34136 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__4_in_rule__MutexSet__Group__34139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group_3__0_in_rule__MutexSet__Group__3__Impl4168 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group_3__0_in_rule__MutexSet__Group__3__Impl4180 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__4__Impl_in_rule__MutexSet__Group__44213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__MutexSet__Group__4__Impl4241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group_3__0__Impl_in_rule__MutexSet__Group_3__04282 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MutexSet__Group_3__1_in_rule__MutexSet__Group_3__04285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__MutexSet__Group_3__0__Impl4313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group_3__1__Impl_in_rule__MutexSet__Group_3__14344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__MethodsAssignment_3_1_in_rule__MutexSet__Group_3__1__Impl4371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__Group__0__Impl_in_rule__CondVar__Group__04405 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__CondVar__Group__1_in_rule__CondVar__Group__04408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__NameAssignment_0_in_rule__CondVar__Group__0__Impl4435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__Group__1__Impl_in_rule__CondVar__Group__14465 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__CondVar__Group__2_in_rule__CondVar__Group__14468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__CondVar__Group__1__Impl4496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__Group__2__Impl_in_rule__CondVar__Group__24527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__ValueAssignment_2_in_rule__CondVar__Group__2__Impl4554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__0__Impl_in_rule__OrdVar__Group__04590 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__1_in_rule__OrdVar__Group__04593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__NameAssignment_0_in_rule__OrdVar__Group__0__Impl4620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__1__Impl_in_rule__OrdVar__Group__14650 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__2_in_rule__OrdVar__Group__14653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__OrdVar__Group__1__Impl4681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__2__Impl_in_rule__OrdVar__Group__24712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__ValueAssignment_2_in_rule__OrdVar__Group__2__Impl4739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__04775 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__04778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl4805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__14834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl4861 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__04896 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__04899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__QualifiedName__Group_1__0__Impl4927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__14958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl4985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__CoordinatorDeclaration__GranularityAssignment_05028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__CoordinatorDeclaration__ClassNameAssignment_25067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCoordinatorBody_in_rule__CoordinatorDeclaration__BodyAssignment_35098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondVar_in_rule__CoordinatorBody__CondVarsAssignment_2_15129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondVar_in_rule__CoordinatorBody__CondVarsAssignment_2_2_15160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrdVar_in_rule__CoordinatorBody__OrdVarsAssignment_3_15191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrdVar_in_rule__CoordinatorBody__OrdVarsAssignment_3_2_15222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__CoordinatorBody__SelfexMethodsAssignment_4_15253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__CoordinatorBody__SelfexMethodsAssignment_4_2_15284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMutexSet_in_rule__CoordinatorBody__MutexSetsAssignment_55315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_rule__CoordinatorBody__GuardsAssignment_65346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Guard__MethodsAssignment_15377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Guard__MethodsAssignment_2_15408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequires_in_rule__Guard__RequiresAssignment_45439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_rule__Requires__AndExpressionAssignment_15470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_rule__AndExpression__OrExpressionsAssignment_05501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_rule__AndExpression__OrExpressionsAssignment_1_15532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicExpression_in_rule__OrExpression__BasicExpressionsAssignment_05563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicExpression_in_rule__OrExpression__BasicExpressionsAssignment_1_15594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__BasicExpression__NegatedAssignment_05630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__BasicExpression__ExprAssignment_15673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MutexSet__MethodsAssignment_25708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MutexSet__MethodsAssignment_3_15739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__CondVar__NameAssignment_05770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanVal_in_rule__CondVar__ValueAssignment_25801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__OrdVar__NameAssignment_05832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__OrdVar__ValueAssignment_25863 = new BitSet(new long[]{0x0000000000000002L});

}