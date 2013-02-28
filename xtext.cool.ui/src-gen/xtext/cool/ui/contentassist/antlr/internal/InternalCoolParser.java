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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'=='", "'!='", "'true'", "'false'", "'coordinator'", "'{'", "'}'", "'condition'", "';'", "','", "'int'", "'selfex'", "'guard'", "':'", "'on_entry'", "'on_exit'", "'if'", "'('", "')'", "'='", "'requires'", "'&&'", "'||'", "'mutex'", "'};'", "'.'", "'per_class'", "'!'"
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


    // $ANTLR start "entryRuleIfStatement"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:144:1: entryRuleIfStatement : ruleIfStatement EOF ;
    public final void entryRuleIfStatement() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:145:1: ( ruleIfStatement EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:146:1: ruleIfStatement EOF
            {
             before(grammarAccess.getIfStatementRule()); 
            pushFollow(FOLLOW_ruleIfStatement_in_entryRuleIfStatement241);
            ruleIfStatement();

            state._fsp--;

             after(grammarAccess.getIfStatementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfStatement248); 

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
    // $ANTLR end "entryRuleIfStatement"


    // $ANTLR start "ruleIfStatement"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:153:1: ruleIfStatement : ( ( rule__IfStatement__Group__0 ) ) ;
    public final void ruleIfStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:157:2: ( ( ( rule__IfStatement__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:158:1: ( ( rule__IfStatement__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:158:1: ( ( rule__IfStatement__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:159:1: ( rule__IfStatement__Group__0 )
            {
             before(grammarAccess.getIfStatementAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:160:1: ( rule__IfStatement__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:160:2: rule__IfStatement__Group__0
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__0_in_ruleIfStatement274);
            rule__IfStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIfStatementAccess().getGroup()); 

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
    // $ANTLR end "ruleIfStatement"


    // $ANTLR start "entryRuleIfExpression"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:172:1: entryRuleIfExpression : ruleIfExpression EOF ;
    public final void entryRuleIfExpression() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:173:1: ( ruleIfExpression EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:174:1: ruleIfExpression EOF
            {
             before(grammarAccess.getIfExpressionRule()); 
            pushFollow(FOLLOW_ruleIfExpression_in_entryRuleIfExpression301);
            ruleIfExpression();

            state._fsp--;

             after(grammarAccess.getIfExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfExpression308); 

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
    // $ANTLR end "entryRuleIfExpression"


    // $ANTLR start "ruleIfExpression"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:181:1: ruleIfExpression : ( ( rule__IfExpression__Group__0 ) ) ;
    public final void ruleIfExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:185:2: ( ( ( rule__IfExpression__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:186:1: ( ( rule__IfExpression__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:186:1: ( ( rule__IfExpression__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:187:1: ( rule__IfExpression__Group__0 )
            {
             before(grammarAccess.getIfExpressionAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:188:1: ( rule__IfExpression__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:188:2: rule__IfExpression__Group__0
            {
            pushFollow(FOLLOW_rule__IfExpression__Group__0_in_ruleIfExpression334);
            rule__IfExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIfExpressionAccess().getGroup()); 

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
    // $ANTLR end "ruleIfExpression"


    // $ANTLR start "entryRuleAssignedValue"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:200:1: entryRuleAssignedValue : ruleAssignedValue EOF ;
    public final void entryRuleAssignedValue() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:201:1: ( ruleAssignedValue EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:202:1: ruleAssignedValue EOF
            {
             before(grammarAccess.getAssignedValueRule()); 
            pushFollow(FOLLOW_ruleAssignedValue_in_entryRuleAssignedValue361);
            ruleAssignedValue();

            state._fsp--;

             after(grammarAccess.getAssignedValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignedValue368); 

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
    // $ANTLR end "entryRuleAssignedValue"


    // $ANTLR start "ruleAssignedValue"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:209:1: ruleAssignedValue : ( ( rule__AssignedValue__Alternatives ) ) ;
    public final void ruleAssignedValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:213:2: ( ( ( rule__AssignedValue__Alternatives ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:214:1: ( ( rule__AssignedValue__Alternatives ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:214:1: ( ( rule__AssignedValue__Alternatives ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:215:1: ( rule__AssignedValue__Alternatives )
            {
             before(grammarAccess.getAssignedValueAccess().getAlternatives()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:216:1: ( rule__AssignedValue__Alternatives )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:216:2: rule__AssignedValue__Alternatives
            {
            pushFollow(FOLLOW_rule__AssignedValue__Alternatives_in_ruleAssignedValue394);
            rule__AssignedValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAssignedValueAccess().getAlternatives()); 

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
    // $ANTLR end "ruleAssignedValue"


    // $ANTLR start "entryRuleAssignStatement"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:228:1: entryRuleAssignStatement : ruleAssignStatement EOF ;
    public final void entryRuleAssignStatement() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:229:1: ( ruleAssignStatement EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:230:1: ruleAssignStatement EOF
            {
             before(grammarAccess.getAssignStatementRule()); 
            pushFollow(FOLLOW_ruleAssignStatement_in_entryRuleAssignStatement421);
            ruleAssignStatement();

            state._fsp--;

             after(grammarAccess.getAssignStatementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignStatement428); 

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
    // $ANTLR end "entryRuleAssignStatement"


    // $ANTLR start "ruleAssignStatement"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:237:1: ruleAssignStatement : ( ( rule__AssignStatement__Group__0 ) ) ;
    public final void ruleAssignStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:241:2: ( ( ( rule__AssignStatement__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:242:1: ( ( rule__AssignStatement__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:242:1: ( ( rule__AssignStatement__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:243:1: ( rule__AssignStatement__Group__0 )
            {
             before(grammarAccess.getAssignStatementAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:244:1: ( rule__AssignStatement__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:244:2: rule__AssignStatement__Group__0
            {
            pushFollow(FOLLOW_rule__AssignStatement__Group__0_in_ruleAssignStatement454);
            rule__AssignStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignStatementAccess().getGroup()); 

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
    // $ANTLR end "ruleAssignStatement"


    // $ANTLR start "entryRuleRequires"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:256:1: entryRuleRequires : ruleRequires EOF ;
    public final void entryRuleRequires() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:257:1: ( ruleRequires EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:258:1: ruleRequires EOF
            {
             before(grammarAccess.getRequiresRule()); 
            pushFollow(FOLLOW_ruleRequires_in_entryRuleRequires481);
            ruleRequires();

            state._fsp--;

             after(grammarAccess.getRequiresRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequires488); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:265:1: ruleRequires : ( ( rule__Requires__Group__0 ) ) ;
    public final void ruleRequires() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:269:2: ( ( ( rule__Requires__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:270:1: ( ( rule__Requires__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:270:1: ( ( rule__Requires__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:271:1: ( rule__Requires__Group__0 )
            {
             before(grammarAccess.getRequiresAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:272:1: ( rule__Requires__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:272:2: rule__Requires__Group__0
            {
            pushFollow(FOLLOW_rule__Requires__Group__0_in_ruleRequires514);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:284:1: entryRuleAndExpression : ruleAndExpression EOF ;
    public final void entryRuleAndExpression() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:285:1: ( ruleAndExpression EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:286:1: ruleAndExpression EOF
            {
             before(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_ruleAndExpression_in_entryRuleAndExpression541);
            ruleAndExpression();

            state._fsp--;

             after(grammarAccess.getAndExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndExpression548); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:293:1: ruleAndExpression : ( ( rule__AndExpression__Group__0 ) ) ;
    public final void ruleAndExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:297:2: ( ( ( rule__AndExpression__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:298:1: ( ( rule__AndExpression__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:298:1: ( ( rule__AndExpression__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:299:1: ( rule__AndExpression__Group__0 )
            {
             before(grammarAccess.getAndExpressionAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:300:1: ( rule__AndExpression__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:300:2: rule__AndExpression__Group__0
            {
            pushFollow(FOLLOW_rule__AndExpression__Group__0_in_ruleAndExpression574);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:312:1: entryRuleOrExpression : ruleOrExpression EOF ;
    public final void entryRuleOrExpression() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:313:1: ( ruleOrExpression EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:314:1: ruleOrExpression EOF
            {
             before(grammarAccess.getOrExpressionRule()); 
            pushFollow(FOLLOW_ruleOrExpression_in_entryRuleOrExpression601);
            ruleOrExpression();

            state._fsp--;

             after(grammarAccess.getOrExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrExpression608); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:321:1: ruleOrExpression : ( ( rule__OrExpression__Group__0 ) ) ;
    public final void ruleOrExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:325:2: ( ( ( rule__OrExpression__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:326:1: ( ( rule__OrExpression__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:326:1: ( ( rule__OrExpression__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:327:1: ( rule__OrExpression__Group__0 )
            {
             before(grammarAccess.getOrExpressionAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:328:1: ( rule__OrExpression__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:328:2: rule__OrExpression__Group__0
            {
            pushFollow(FOLLOW_rule__OrExpression__Group__0_in_ruleOrExpression634);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:340:1: entryRuleBasicExpression : ruleBasicExpression EOF ;
    public final void entryRuleBasicExpression() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:341:1: ( ruleBasicExpression EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:342:1: ruleBasicExpression EOF
            {
             before(grammarAccess.getBasicExpressionRule()); 
            pushFollow(FOLLOW_ruleBasicExpression_in_entryRuleBasicExpression661);
            ruleBasicExpression();

            state._fsp--;

             after(grammarAccess.getBasicExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicExpression668); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:349:1: ruleBasicExpression : ( ( rule__BasicExpression__Group__0 ) ) ;
    public final void ruleBasicExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:353:2: ( ( ( rule__BasicExpression__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:354:1: ( ( rule__BasicExpression__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:354:1: ( ( rule__BasicExpression__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:355:1: ( rule__BasicExpression__Group__0 )
            {
             before(grammarAccess.getBasicExpressionAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:356:1: ( rule__BasicExpression__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:356:2: rule__BasicExpression__Group__0
            {
            pushFollow(FOLLOW_rule__BasicExpression__Group__0_in_ruleBasicExpression694);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:368:1: entryRuleMutexSet : ruleMutexSet EOF ;
    public final void entryRuleMutexSet() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:369:1: ( ruleMutexSet EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:370:1: ruleMutexSet EOF
            {
             before(grammarAccess.getMutexSetRule()); 
            pushFollow(FOLLOW_ruleMutexSet_in_entryRuleMutexSet721);
            ruleMutexSet();

            state._fsp--;

             after(grammarAccess.getMutexSetRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMutexSet728); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:377:1: ruleMutexSet : ( ( rule__MutexSet__Group__0 ) ) ;
    public final void ruleMutexSet() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:381:2: ( ( ( rule__MutexSet__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:382:1: ( ( rule__MutexSet__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:382:1: ( ( rule__MutexSet__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:383:1: ( rule__MutexSet__Group__0 )
            {
             before(grammarAccess.getMutexSetAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:384:1: ( rule__MutexSet__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:384:2: rule__MutexSet__Group__0
            {
            pushFollow(FOLLOW_rule__MutexSet__Group__0_in_ruleMutexSet754);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:396:1: entryRuleCondVar : ruleCondVar EOF ;
    public final void entryRuleCondVar() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:397:1: ( ruleCondVar EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:398:1: ruleCondVar EOF
            {
             before(grammarAccess.getCondVarRule()); 
            pushFollow(FOLLOW_ruleCondVar_in_entryRuleCondVar781);
            ruleCondVar();

            state._fsp--;

             after(grammarAccess.getCondVarRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCondVar788); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:405:1: ruleCondVar : ( ( rule__CondVar__Group__0 ) ) ;
    public final void ruleCondVar() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:409:2: ( ( ( rule__CondVar__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:410:1: ( ( rule__CondVar__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:410:1: ( ( rule__CondVar__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:411:1: ( rule__CondVar__Group__0 )
            {
             before(grammarAccess.getCondVarAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:412:1: ( rule__CondVar__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:412:2: rule__CondVar__Group__0
            {
            pushFollow(FOLLOW_rule__CondVar__Group__0_in_ruleCondVar814);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:424:1: entryRuleOrdVar : ruleOrdVar EOF ;
    public final void entryRuleOrdVar() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:425:1: ( ruleOrdVar EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:426:1: ruleOrdVar EOF
            {
             before(grammarAccess.getOrdVarRule()); 
            pushFollow(FOLLOW_ruleOrdVar_in_entryRuleOrdVar841);
            ruleOrdVar();

            state._fsp--;

             after(grammarAccess.getOrdVarRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrdVar848); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:433:1: ruleOrdVar : ( ( rule__OrdVar__Group__0 ) ) ;
    public final void ruleOrdVar() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:437:2: ( ( ( rule__OrdVar__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:438:1: ( ( rule__OrdVar__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:438:1: ( ( rule__OrdVar__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:439:1: ( rule__OrdVar__Group__0 )
            {
             before(grammarAccess.getOrdVarAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:440:1: ( rule__OrdVar__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:440:2: rule__OrdVar__Group__0
            {
            pushFollow(FOLLOW_rule__OrdVar__Group__0_in_ruleOrdVar874);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:452:1: entryRuleBooleanVal : ruleBooleanVal EOF ;
    public final void entryRuleBooleanVal() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:453:1: ( ruleBooleanVal EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:454:1: ruleBooleanVal EOF
            {
             before(grammarAccess.getBooleanValRule()); 
            pushFollow(FOLLOW_ruleBooleanVal_in_entryRuleBooleanVal901);
            ruleBooleanVal();

            state._fsp--;

             after(grammarAccess.getBooleanValRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanVal908); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:461:1: ruleBooleanVal : ( ( rule__BooleanVal__Alternatives ) ) ;
    public final void ruleBooleanVal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:465:2: ( ( ( rule__BooleanVal__Alternatives ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:466:1: ( ( rule__BooleanVal__Alternatives ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:466:1: ( ( rule__BooleanVal__Alternatives ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:467:1: ( rule__BooleanVal__Alternatives )
            {
             before(grammarAccess.getBooleanValAccess().getAlternatives()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:468:1: ( rule__BooleanVal__Alternatives )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:468:2: rule__BooleanVal__Alternatives
            {
            pushFollow(FOLLOW_rule__BooleanVal__Alternatives_in_ruleBooleanVal934);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:480:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:481:1: ( ruleQualifiedName EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:482:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName961);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName968); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:489:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:493:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:494:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:494:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:495:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:496:1: ( rule__QualifiedName__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:496:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName994);
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


    // $ANTLR start "rule__Guard__Alternatives_5_2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:508:1: rule__Guard__Alternatives_5_2 : ( ( ( rule__Guard__OnEntryIfStatementsAssignment_5_2_0 ) ) | ( ( rule__Guard__OnEntryAssignStatementsAssignment_5_2_1 ) ) );
    public final void rule__Guard__Alternatives_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:512:1: ( ( ( rule__Guard__OnEntryIfStatementsAssignment_5_2_0 ) ) | ( ( rule__Guard__OnEntryAssignStatementsAssignment_5_2_1 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==27) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_ID) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:513:1: ( ( rule__Guard__OnEntryIfStatementsAssignment_5_2_0 ) )
                    {
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:513:1: ( ( rule__Guard__OnEntryIfStatementsAssignment_5_2_0 ) )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:514:1: ( rule__Guard__OnEntryIfStatementsAssignment_5_2_0 )
                    {
                     before(grammarAccess.getGuardAccess().getOnEntryIfStatementsAssignment_5_2_0()); 
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:515:1: ( rule__Guard__OnEntryIfStatementsAssignment_5_2_0 )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:515:2: rule__Guard__OnEntryIfStatementsAssignment_5_2_0
                    {
                    pushFollow(FOLLOW_rule__Guard__OnEntryIfStatementsAssignment_5_2_0_in_rule__Guard__Alternatives_5_21030);
                    rule__Guard__OnEntryIfStatementsAssignment_5_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getGuardAccess().getOnEntryIfStatementsAssignment_5_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:519:6: ( ( rule__Guard__OnEntryAssignStatementsAssignment_5_2_1 ) )
                    {
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:519:6: ( ( rule__Guard__OnEntryAssignStatementsAssignment_5_2_1 ) )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:520:1: ( rule__Guard__OnEntryAssignStatementsAssignment_5_2_1 )
                    {
                     before(grammarAccess.getGuardAccess().getOnEntryAssignStatementsAssignment_5_2_1()); 
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:521:1: ( rule__Guard__OnEntryAssignStatementsAssignment_5_2_1 )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:521:2: rule__Guard__OnEntryAssignStatementsAssignment_5_2_1
                    {
                    pushFollow(FOLLOW_rule__Guard__OnEntryAssignStatementsAssignment_5_2_1_in_rule__Guard__Alternatives_5_21048);
                    rule__Guard__OnEntryAssignStatementsAssignment_5_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getGuardAccess().getOnEntryAssignStatementsAssignment_5_2_1()); 

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
    // $ANTLR end "rule__Guard__Alternatives_5_2"


    // $ANTLR start "rule__Guard__Alternatives_6_2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:530:1: rule__Guard__Alternatives_6_2 : ( ( ( rule__Guard__OnExitIfStatementsAssignment_6_2_0 ) ) | ( ( rule__Guard__OnExitAssignStatementsAssignment_6_2_1 ) ) );
    public final void rule__Guard__Alternatives_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:534:1: ( ( ( rule__Guard__OnExitIfStatementsAssignment_6_2_0 ) ) | ( ( rule__Guard__OnExitAssignStatementsAssignment_6_2_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==27) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:535:1: ( ( rule__Guard__OnExitIfStatementsAssignment_6_2_0 ) )
                    {
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:535:1: ( ( rule__Guard__OnExitIfStatementsAssignment_6_2_0 ) )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:536:1: ( rule__Guard__OnExitIfStatementsAssignment_6_2_0 )
                    {
                     before(grammarAccess.getGuardAccess().getOnExitIfStatementsAssignment_6_2_0()); 
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:537:1: ( rule__Guard__OnExitIfStatementsAssignment_6_2_0 )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:537:2: rule__Guard__OnExitIfStatementsAssignment_6_2_0
                    {
                    pushFollow(FOLLOW_rule__Guard__OnExitIfStatementsAssignment_6_2_0_in_rule__Guard__Alternatives_6_21081);
                    rule__Guard__OnExitIfStatementsAssignment_6_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getGuardAccess().getOnExitIfStatementsAssignment_6_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:541:6: ( ( rule__Guard__OnExitAssignStatementsAssignment_6_2_1 ) )
                    {
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:541:6: ( ( rule__Guard__OnExitAssignStatementsAssignment_6_2_1 ) )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:542:1: ( rule__Guard__OnExitAssignStatementsAssignment_6_2_1 )
                    {
                     before(grammarAccess.getGuardAccess().getOnExitAssignStatementsAssignment_6_2_1()); 
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:543:1: ( rule__Guard__OnExitAssignStatementsAssignment_6_2_1 )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:543:2: rule__Guard__OnExitAssignStatementsAssignment_6_2_1
                    {
                    pushFollow(FOLLOW_rule__Guard__OnExitAssignStatementsAssignment_6_2_1_in_rule__Guard__Alternatives_6_21099);
                    rule__Guard__OnExitAssignStatementsAssignment_6_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getGuardAccess().getOnExitAssignStatementsAssignment_6_2_1()); 

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
    // $ANTLR end "rule__Guard__Alternatives_6_2"


    // $ANTLR start "rule__IfExpression__OpAlternatives_1_0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:552:1: rule__IfExpression__OpAlternatives_1_0 : ( ( '==' ) | ( '!=' ) );
    public final void rule__IfExpression__OpAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:556:1: ( ( '==' ) | ( '!=' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:557:1: ( '==' )
                    {
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:557:1: ( '==' )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:558:1: '=='
                    {
                     before(grammarAccess.getIfExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_0()); 
                    match(input,11,FOLLOW_11_in_rule__IfExpression__OpAlternatives_1_01133); 
                     after(grammarAccess.getIfExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:565:6: ( '!=' )
                    {
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:565:6: ( '!=' )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:566:1: '!='
                    {
                     before(grammarAccess.getIfExpressionAccess().getOpExclamationMarkEqualsSignKeyword_1_0_1()); 
                    match(input,12,FOLLOW_12_in_rule__IfExpression__OpAlternatives_1_01153); 
                     after(grammarAccess.getIfExpressionAccess().getOpExclamationMarkEqualsSignKeyword_1_0_1()); 

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
    // $ANTLR end "rule__IfExpression__OpAlternatives_1_0"


    // $ANTLR start "rule__AssignedValue__Alternatives"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:578:1: rule__AssignedValue__Alternatives : ( ( ( rule__AssignedValue__IntvalAssignment_0 ) ) | ( ( rule__AssignedValue__BoolvalAssignment_1 ) ) );
    public final void rule__AssignedValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:582:1: ( ( ( rule__AssignedValue__IntvalAssignment_0 ) ) | ( ( rule__AssignedValue__BoolvalAssignment_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_INT) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=13 && LA4_0<=14)) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:583:1: ( ( rule__AssignedValue__IntvalAssignment_0 ) )
                    {
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:583:1: ( ( rule__AssignedValue__IntvalAssignment_0 ) )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:584:1: ( rule__AssignedValue__IntvalAssignment_0 )
                    {
                     before(grammarAccess.getAssignedValueAccess().getIntvalAssignment_0()); 
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:585:1: ( rule__AssignedValue__IntvalAssignment_0 )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:585:2: rule__AssignedValue__IntvalAssignment_0
                    {
                    pushFollow(FOLLOW_rule__AssignedValue__IntvalAssignment_0_in_rule__AssignedValue__Alternatives1187);
                    rule__AssignedValue__IntvalAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAssignedValueAccess().getIntvalAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:589:6: ( ( rule__AssignedValue__BoolvalAssignment_1 ) )
                    {
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:589:6: ( ( rule__AssignedValue__BoolvalAssignment_1 ) )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:590:1: ( rule__AssignedValue__BoolvalAssignment_1 )
                    {
                     before(grammarAccess.getAssignedValueAccess().getBoolvalAssignment_1()); 
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:591:1: ( rule__AssignedValue__BoolvalAssignment_1 )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:591:2: rule__AssignedValue__BoolvalAssignment_1
                    {
                    pushFollow(FOLLOW_rule__AssignedValue__BoolvalAssignment_1_in_rule__AssignedValue__Alternatives1205);
                    rule__AssignedValue__BoolvalAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getAssignedValueAccess().getBoolvalAssignment_1()); 

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
    // $ANTLR end "rule__AssignedValue__Alternatives"


    // $ANTLR start "rule__AssignedValue__BoolvalAlternatives_1_0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:600:1: rule__AssignedValue__BoolvalAlternatives_1_0 : ( ( 'true' ) | ( 'false' ) );
    public final void rule__AssignedValue__BoolvalAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:604:1: ( ( 'true' ) | ( 'false' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            else if ( (LA5_0==14) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:605:1: ( 'true' )
                    {
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:605:1: ( 'true' )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:606:1: 'true'
                    {
                     before(grammarAccess.getAssignedValueAccess().getBoolvalTrueKeyword_1_0_0()); 
                    match(input,13,FOLLOW_13_in_rule__AssignedValue__BoolvalAlternatives_1_01239); 
                     after(grammarAccess.getAssignedValueAccess().getBoolvalTrueKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:613:6: ( 'false' )
                    {
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:613:6: ( 'false' )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:614:1: 'false'
                    {
                     before(grammarAccess.getAssignedValueAccess().getBoolvalFalseKeyword_1_0_1()); 
                    match(input,14,FOLLOW_14_in_rule__AssignedValue__BoolvalAlternatives_1_01259); 
                     after(grammarAccess.getAssignedValueAccess().getBoolvalFalseKeyword_1_0_1()); 

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
    // $ANTLR end "rule__AssignedValue__BoolvalAlternatives_1_0"


    // $ANTLR start "rule__BooleanVal__Alternatives"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:626:1: rule__BooleanVal__Alternatives : ( ( 'true' ) | ( 'false' ) );
    public final void rule__BooleanVal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:630:1: ( ( 'true' ) | ( 'false' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==13) ) {
                alt6=1;
            }
            else if ( (LA6_0==14) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:631:1: ( 'true' )
                    {
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:631:1: ( 'true' )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:632:1: 'true'
                    {
                     before(grammarAccess.getBooleanValAccess().getTrueKeyword_0()); 
                    match(input,13,FOLLOW_13_in_rule__BooleanVal__Alternatives1294); 
                     after(grammarAccess.getBooleanValAccess().getTrueKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:639:6: ( 'false' )
                    {
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:639:6: ( 'false' )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:640:1: 'false'
                    {
                     before(grammarAccess.getBooleanValAccess().getFalseKeyword_1()); 
                    match(input,14,FOLLOW_14_in_rule__BooleanVal__Alternatives1314); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:654:1: rule__CoordinatorDeclaration__Group__0 : rule__CoordinatorDeclaration__Group__0__Impl rule__CoordinatorDeclaration__Group__1 ;
    public final void rule__CoordinatorDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:658:1: ( rule__CoordinatorDeclaration__Group__0__Impl rule__CoordinatorDeclaration__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:659:2: rule__CoordinatorDeclaration__Group__0__Impl rule__CoordinatorDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__0__Impl_in_rule__CoordinatorDeclaration__Group__01346);
            rule__CoordinatorDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__1_in_rule__CoordinatorDeclaration__Group__01349);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:666:1: rule__CoordinatorDeclaration__Group__0__Impl : ( ( rule__CoordinatorDeclaration__GranularityAssignment_0 )? ) ;
    public final void rule__CoordinatorDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:670:1: ( ( ( rule__CoordinatorDeclaration__GranularityAssignment_0 )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:671:1: ( ( rule__CoordinatorDeclaration__GranularityAssignment_0 )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:671:1: ( ( rule__CoordinatorDeclaration__GranularityAssignment_0 )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:672:1: ( rule__CoordinatorDeclaration__GranularityAssignment_0 )?
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getGranularityAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:673:1: ( rule__CoordinatorDeclaration__GranularityAssignment_0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==37) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:673:2: rule__CoordinatorDeclaration__GranularityAssignment_0
                    {
                    pushFollow(FOLLOW_rule__CoordinatorDeclaration__GranularityAssignment_0_in_rule__CoordinatorDeclaration__Group__0__Impl1376);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:683:1: rule__CoordinatorDeclaration__Group__1 : rule__CoordinatorDeclaration__Group__1__Impl rule__CoordinatorDeclaration__Group__2 ;
    public final void rule__CoordinatorDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:687:1: ( rule__CoordinatorDeclaration__Group__1__Impl rule__CoordinatorDeclaration__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:688:2: rule__CoordinatorDeclaration__Group__1__Impl rule__CoordinatorDeclaration__Group__2
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__1__Impl_in_rule__CoordinatorDeclaration__Group__11407);
            rule__CoordinatorDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__2_in_rule__CoordinatorDeclaration__Group__11410);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:695:1: rule__CoordinatorDeclaration__Group__1__Impl : ( 'coordinator' ) ;
    public final void rule__CoordinatorDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:699:1: ( ( 'coordinator' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:700:1: ( 'coordinator' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:700:1: ( 'coordinator' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:701:1: 'coordinator'
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getCoordinatorKeyword_1()); 
            match(input,15,FOLLOW_15_in_rule__CoordinatorDeclaration__Group__1__Impl1438); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:714:1: rule__CoordinatorDeclaration__Group__2 : rule__CoordinatorDeclaration__Group__2__Impl rule__CoordinatorDeclaration__Group__3 ;
    public final void rule__CoordinatorDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:718:1: ( rule__CoordinatorDeclaration__Group__2__Impl rule__CoordinatorDeclaration__Group__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:719:2: rule__CoordinatorDeclaration__Group__2__Impl rule__CoordinatorDeclaration__Group__3
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__2__Impl_in_rule__CoordinatorDeclaration__Group__21469);
            rule__CoordinatorDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__3_in_rule__CoordinatorDeclaration__Group__21472);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:726:1: rule__CoordinatorDeclaration__Group__2__Impl : ( ( rule__CoordinatorDeclaration__ClassNameAssignment_2 ) ) ;
    public final void rule__CoordinatorDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:730:1: ( ( ( rule__CoordinatorDeclaration__ClassNameAssignment_2 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:731:1: ( ( rule__CoordinatorDeclaration__ClassNameAssignment_2 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:731:1: ( ( rule__CoordinatorDeclaration__ClassNameAssignment_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:732:1: ( rule__CoordinatorDeclaration__ClassNameAssignment_2 )
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getClassNameAssignment_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:733:1: ( rule__CoordinatorDeclaration__ClassNameAssignment_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:733:2: rule__CoordinatorDeclaration__ClassNameAssignment_2
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__ClassNameAssignment_2_in_rule__CoordinatorDeclaration__Group__2__Impl1499);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:743:1: rule__CoordinatorDeclaration__Group__3 : rule__CoordinatorDeclaration__Group__3__Impl ;
    public final void rule__CoordinatorDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:747:1: ( rule__CoordinatorDeclaration__Group__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:748:2: rule__CoordinatorDeclaration__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__3__Impl_in_rule__CoordinatorDeclaration__Group__31529);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:754:1: rule__CoordinatorDeclaration__Group__3__Impl : ( ( rule__CoordinatorDeclaration__BodyAssignment_3 )? ) ;
    public final void rule__CoordinatorDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:758:1: ( ( ( rule__CoordinatorDeclaration__BodyAssignment_3 )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:759:1: ( ( rule__CoordinatorDeclaration__BodyAssignment_3 )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:759:1: ( ( rule__CoordinatorDeclaration__BodyAssignment_3 )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:760:1: ( rule__CoordinatorDeclaration__BodyAssignment_3 )?
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getBodyAssignment_3()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:761:1: ( rule__CoordinatorDeclaration__BodyAssignment_3 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:761:2: rule__CoordinatorDeclaration__BodyAssignment_3
                    {
                    pushFollow(FOLLOW_rule__CoordinatorDeclaration__BodyAssignment_3_in_rule__CoordinatorDeclaration__Group__3__Impl1556);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:779:1: rule__CoordinatorBody__Group__0 : rule__CoordinatorBody__Group__0__Impl rule__CoordinatorBody__Group__1 ;
    public final void rule__CoordinatorBody__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:783:1: ( rule__CoordinatorBody__Group__0__Impl rule__CoordinatorBody__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:784:2: rule__CoordinatorBody__Group__0__Impl rule__CoordinatorBody__Group__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__0__Impl_in_rule__CoordinatorBody__Group__01595);
            rule__CoordinatorBody__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__1_in_rule__CoordinatorBody__Group__01598);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:791:1: rule__CoordinatorBody__Group__0__Impl : ( '{' ) ;
    public final void rule__CoordinatorBody__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:795:1: ( ( '{' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:796:1: ( '{' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:796:1: ( '{' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:797:1: '{'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__CoordinatorBody__Group__0__Impl1626); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:810:1: rule__CoordinatorBody__Group__1 : rule__CoordinatorBody__Group__1__Impl rule__CoordinatorBody__Group__2 ;
    public final void rule__CoordinatorBody__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:814:1: ( rule__CoordinatorBody__Group__1__Impl rule__CoordinatorBody__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:815:2: rule__CoordinatorBody__Group__1__Impl rule__CoordinatorBody__Group__2
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__1__Impl_in_rule__CoordinatorBody__Group__11657);
            rule__CoordinatorBody__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__2_in_rule__CoordinatorBody__Group__11660);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:822:1: rule__CoordinatorBody__Group__1__Impl : ( () ) ;
    public final void rule__CoordinatorBody__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:826:1: ( ( () ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:827:1: ( () )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:827:1: ( () )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:828:1: ()
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCoordinatorBodyAction_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:829:1: ()
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:831:1: 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:841:1: rule__CoordinatorBody__Group__2 : rule__CoordinatorBody__Group__2__Impl rule__CoordinatorBody__Group__3 ;
    public final void rule__CoordinatorBody__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:845:1: ( rule__CoordinatorBody__Group__2__Impl rule__CoordinatorBody__Group__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:846:2: rule__CoordinatorBody__Group__2__Impl rule__CoordinatorBody__Group__3
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__2__Impl_in_rule__CoordinatorBody__Group__21718);
            rule__CoordinatorBody__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__3_in_rule__CoordinatorBody__Group__21721);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:853:1: rule__CoordinatorBody__Group__2__Impl : ( ( rule__CoordinatorBody__Group_2__0 )* ) ;
    public final void rule__CoordinatorBody__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:857:1: ( ( ( rule__CoordinatorBody__Group_2__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:858:1: ( ( rule__CoordinatorBody__Group_2__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:858:1: ( ( rule__CoordinatorBody__Group_2__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:859:1: ( rule__CoordinatorBody__Group_2__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:860:1: ( rule__CoordinatorBody__Group_2__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==18) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:860:2: rule__CoordinatorBody__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__0_in_rule__CoordinatorBody__Group__2__Impl1748);
            	    rule__CoordinatorBody__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:870:1: rule__CoordinatorBody__Group__3 : rule__CoordinatorBody__Group__3__Impl rule__CoordinatorBody__Group__4 ;
    public final void rule__CoordinatorBody__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:874:1: ( rule__CoordinatorBody__Group__3__Impl rule__CoordinatorBody__Group__4 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:875:2: rule__CoordinatorBody__Group__3__Impl rule__CoordinatorBody__Group__4
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__3__Impl_in_rule__CoordinatorBody__Group__31779);
            rule__CoordinatorBody__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__4_in_rule__CoordinatorBody__Group__31782);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:882:1: rule__CoordinatorBody__Group__3__Impl : ( ( rule__CoordinatorBody__Group_3__0 )* ) ;
    public final void rule__CoordinatorBody__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:886:1: ( ( ( rule__CoordinatorBody__Group_3__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:887:1: ( ( rule__CoordinatorBody__Group_3__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:887:1: ( ( rule__CoordinatorBody__Group_3__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:888:1: ( rule__CoordinatorBody__Group_3__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_3()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:889:1: ( rule__CoordinatorBody__Group_3__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==21) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:889:2: rule__CoordinatorBody__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__0_in_rule__CoordinatorBody__Group__3__Impl1809);
            	    rule__CoordinatorBody__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:899:1: rule__CoordinatorBody__Group__4 : rule__CoordinatorBody__Group__4__Impl rule__CoordinatorBody__Group__5 ;
    public final void rule__CoordinatorBody__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:903:1: ( rule__CoordinatorBody__Group__4__Impl rule__CoordinatorBody__Group__5 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:904:2: rule__CoordinatorBody__Group__4__Impl rule__CoordinatorBody__Group__5
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__4__Impl_in_rule__CoordinatorBody__Group__41840);
            rule__CoordinatorBody__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__5_in_rule__CoordinatorBody__Group__41843);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:911:1: rule__CoordinatorBody__Group__4__Impl : ( ( rule__CoordinatorBody__Group_4__0 )? ) ;
    public final void rule__CoordinatorBody__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:915:1: ( ( ( rule__CoordinatorBody__Group_4__0 )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:916:1: ( ( rule__CoordinatorBody__Group_4__0 )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:916:1: ( ( rule__CoordinatorBody__Group_4__0 )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:917:1: ( rule__CoordinatorBody__Group_4__0 )?
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_4()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:918:1: ( rule__CoordinatorBody__Group_4__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:918:2: rule__CoordinatorBody__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__0_in_rule__CoordinatorBody__Group__4__Impl1870);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:928:1: rule__CoordinatorBody__Group__5 : rule__CoordinatorBody__Group__5__Impl rule__CoordinatorBody__Group__6 ;
    public final void rule__CoordinatorBody__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:932:1: ( rule__CoordinatorBody__Group__5__Impl rule__CoordinatorBody__Group__6 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:933:2: rule__CoordinatorBody__Group__5__Impl rule__CoordinatorBody__Group__6
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__5__Impl_in_rule__CoordinatorBody__Group__51901);
            rule__CoordinatorBody__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__6_in_rule__CoordinatorBody__Group__51904);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:940:1: rule__CoordinatorBody__Group__5__Impl : ( ( rule__CoordinatorBody__MutexSetsAssignment_5 )* ) ;
    public final void rule__CoordinatorBody__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:944:1: ( ( ( rule__CoordinatorBody__MutexSetsAssignment_5 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:945:1: ( ( rule__CoordinatorBody__MutexSetsAssignment_5 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:945:1: ( ( rule__CoordinatorBody__MutexSetsAssignment_5 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:946:1: ( rule__CoordinatorBody__MutexSetsAssignment_5 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getMutexSetsAssignment_5()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:947:1: ( rule__CoordinatorBody__MutexSetsAssignment_5 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==34) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:947:2: rule__CoordinatorBody__MutexSetsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__MutexSetsAssignment_5_in_rule__CoordinatorBody__Group__5__Impl1931);
            	    rule__CoordinatorBody__MutexSetsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:957:1: rule__CoordinatorBody__Group__6 : rule__CoordinatorBody__Group__6__Impl rule__CoordinatorBody__Group__7 ;
    public final void rule__CoordinatorBody__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:961:1: ( rule__CoordinatorBody__Group__6__Impl rule__CoordinatorBody__Group__7 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:962:2: rule__CoordinatorBody__Group__6__Impl rule__CoordinatorBody__Group__7
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__6__Impl_in_rule__CoordinatorBody__Group__61962);
            rule__CoordinatorBody__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__7_in_rule__CoordinatorBody__Group__61965);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:969:1: rule__CoordinatorBody__Group__6__Impl : ( ( rule__CoordinatorBody__GuardsAssignment_6 )* ) ;
    public final void rule__CoordinatorBody__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:973:1: ( ( ( rule__CoordinatorBody__GuardsAssignment_6 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:974:1: ( ( rule__CoordinatorBody__GuardsAssignment_6 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:974:1: ( ( rule__CoordinatorBody__GuardsAssignment_6 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:975:1: ( rule__CoordinatorBody__GuardsAssignment_6 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGuardsAssignment_6()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:976:1: ( rule__CoordinatorBody__GuardsAssignment_6 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID||LA13_0==23) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:976:2: rule__CoordinatorBody__GuardsAssignment_6
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__GuardsAssignment_6_in_rule__CoordinatorBody__Group__6__Impl1992);
            	    rule__CoordinatorBody__GuardsAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:986:1: rule__CoordinatorBody__Group__7 : rule__CoordinatorBody__Group__7__Impl ;
    public final void rule__CoordinatorBody__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:990:1: ( rule__CoordinatorBody__Group__7__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:991:2: rule__CoordinatorBody__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__7__Impl_in_rule__CoordinatorBody__Group__72023);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:997:1: rule__CoordinatorBody__Group__7__Impl : ( '}' ) ;
    public final void rule__CoordinatorBody__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1001:1: ( ( '}' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1002:1: ( '}' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1002:1: ( '}' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1003:1: '}'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getRightCurlyBracketKeyword_7()); 
            match(input,17,FOLLOW_17_in_rule__CoordinatorBody__Group__7__Impl2051); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1032:1: rule__CoordinatorBody__Group_2__0 : rule__CoordinatorBody__Group_2__0__Impl rule__CoordinatorBody__Group_2__1 ;
    public final void rule__CoordinatorBody__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1036:1: ( rule__CoordinatorBody__Group_2__0__Impl rule__CoordinatorBody__Group_2__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1037:2: rule__CoordinatorBody__Group_2__0__Impl rule__CoordinatorBody__Group_2__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__0__Impl_in_rule__CoordinatorBody__Group_2__02098);
            rule__CoordinatorBody__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__1_in_rule__CoordinatorBody__Group_2__02101);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1044:1: rule__CoordinatorBody__Group_2__0__Impl : ( 'condition' ) ;
    public final void rule__CoordinatorBody__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1048:1: ( ( 'condition' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1049:1: ( 'condition' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1049:1: ( 'condition' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1050:1: 'condition'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getConditionKeyword_2_0()); 
            match(input,18,FOLLOW_18_in_rule__CoordinatorBody__Group_2__0__Impl2129); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1063:1: rule__CoordinatorBody__Group_2__1 : rule__CoordinatorBody__Group_2__1__Impl rule__CoordinatorBody__Group_2__2 ;
    public final void rule__CoordinatorBody__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1067:1: ( rule__CoordinatorBody__Group_2__1__Impl rule__CoordinatorBody__Group_2__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1068:2: rule__CoordinatorBody__Group_2__1__Impl rule__CoordinatorBody__Group_2__2
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__1__Impl_in_rule__CoordinatorBody__Group_2__12160);
            rule__CoordinatorBody__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__2_in_rule__CoordinatorBody__Group_2__12163);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1075:1: rule__CoordinatorBody__Group_2__1__Impl : ( ( rule__CoordinatorBody__CondVarsAssignment_2_1 ) ) ;
    public final void rule__CoordinatorBody__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1079:1: ( ( ( rule__CoordinatorBody__CondVarsAssignment_2_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1080:1: ( ( rule__CoordinatorBody__CondVarsAssignment_2_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1080:1: ( ( rule__CoordinatorBody__CondVarsAssignment_2_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1081:1: ( rule__CoordinatorBody__CondVarsAssignment_2_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCondVarsAssignment_2_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1082:1: ( rule__CoordinatorBody__CondVarsAssignment_2_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1082:2: rule__CoordinatorBody__CondVarsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__CondVarsAssignment_2_1_in_rule__CoordinatorBody__Group_2__1__Impl2190);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1092:1: rule__CoordinatorBody__Group_2__2 : rule__CoordinatorBody__Group_2__2__Impl rule__CoordinatorBody__Group_2__3 ;
    public final void rule__CoordinatorBody__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1096:1: ( rule__CoordinatorBody__Group_2__2__Impl rule__CoordinatorBody__Group_2__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1097:2: rule__CoordinatorBody__Group_2__2__Impl rule__CoordinatorBody__Group_2__3
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__2__Impl_in_rule__CoordinatorBody__Group_2__22220);
            rule__CoordinatorBody__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__3_in_rule__CoordinatorBody__Group_2__22223);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1104:1: rule__CoordinatorBody__Group_2__2__Impl : ( ( rule__CoordinatorBody__Group_2_2__0 )* ) ;
    public final void rule__CoordinatorBody__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1108:1: ( ( ( rule__CoordinatorBody__Group_2_2__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1109:1: ( ( rule__CoordinatorBody__Group_2_2__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1109:1: ( ( rule__CoordinatorBody__Group_2_2__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1110:1: ( rule__CoordinatorBody__Group_2_2__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_2_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1111:1: ( rule__CoordinatorBody__Group_2_2__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==20) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1111:2: rule__CoordinatorBody__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_2_2__0_in_rule__CoordinatorBody__Group_2__2__Impl2250);
            	    rule__CoordinatorBody__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1121:1: rule__CoordinatorBody__Group_2__3 : rule__CoordinatorBody__Group_2__3__Impl ;
    public final void rule__CoordinatorBody__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1125:1: ( rule__CoordinatorBody__Group_2__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1126:2: rule__CoordinatorBody__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__3__Impl_in_rule__CoordinatorBody__Group_2__32281);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1132:1: rule__CoordinatorBody__Group_2__3__Impl : ( ';' ) ;
    public final void rule__CoordinatorBody__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1136:1: ( ( ';' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1137:1: ( ';' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1137:1: ( ';' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1138:1: ';'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_2_3()); 
            match(input,19,FOLLOW_19_in_rule__CoordinatorBody__Group_2__3__Impl2309); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1159:1: rule__CoordinatorBody__Group_2_2__0 : rule__CoordinatorBody__Group_2_2__0__Impl rule__CoordinatorBody__Group_2_2__1 ;
    public final void rule__CoordinatorBody__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1163:1: ( rule__CoordinatorBody__Group_2_2__0__Impl rule__CoordinatorBody__Group_2_2__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1164:2: rule__CoordinatorBody__Group_2_2__0__Impl rule__CoordinatorBody__Group_2_2__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2_2__0__Impl_in_rule__CoordinatorBody__Group_2_2__02348);
            rule__CoordinatorBody__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2_2__1_in_rule__CoordinatorBody__Group_2_2__02351);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1171:1: rule__CoordinatorBody__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__CoordinatorBody__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1175:1: ( ( ',' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1176:1: ( ',' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1176:1: ( ',' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1177:1: ','
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_2_2_0()); 
            match(input,20,FOLLOW_20_in_rule__CoordinatorBody__Group_2_2__0__Impl2379); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1190:1: rule__CoordinatorBody__Group_2_2__1 : rule__CoordinatorBody__Group_2_2__1__Impl ;
    public final void rule__CoordinatorBody__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1194:1: ( rule__CoordinatorBody__Group_2_2__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1195:2: rule__CoordinatorBody__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2_2__1__Impl_in_rule__CoordinatorBody__Group_2_2__12410);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1201:1: rule__CoordinatorBody__Group_2_2__1__Impl : ( ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 ) ) ;
    public final void rule__CoordinatorBody__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1205:1: ( ( ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1206:1: ( ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1206:1: ( ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1207:1: ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCondVarsAssignment_2_2_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1208:1: ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1208:2: rule__CoordinatorBody__CondVarsAssignment_2_2_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__CondVarsAssignment_2_2_1_in_rule__CoordinatorBody__Group_2_2__1__Impl2437);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1222:1: rule__CoordinatorBody__Group_3__0 : rule__CoordinatorBody__Group_3__0__Impl rule__CoordinatorBody__Group_3__1 ;
    public final void rule__CoordinatorBody__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1226:1: ( rule__CoordinatorBody__Group_3__0__Impl rule__CoordinatorBody__Group_3__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1227:2: rule__CoordinatorBody__Group_3__0__Impl rule__CoordinatorBody__Group_3__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__0__Impl_in_rule__CoordinatorBody__Group_3__02471);
            rule__CoordinatorBody__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__1_in_rule__CoordinatorBody__Group_3__02474);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1234:1: rule__CoordinatorBody__Group_3__0__Impl : ( 'int' ) ;
    public final void rule__CoordinatorBody__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1238:1: ( ( 'int' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1239:1: ( 'int' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1239:1: ( 'int' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1240:1: 'int'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getIntKeyword_3_0()); 
            match(input,21,FOLLOW_21_in_rule__CoordinatorBody__Group_3__0__Impl2502); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1253:1: rule__CoordinatorBody__Group_3__1 : rule__CoordinatorBody__Group_3__1__Impl rule__CoordinatorBody__Group_3__2 ;
    public final void rule__CoordinatorBody__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1257:1: ( rule__CoordinatorBody__Group_3__1__Impl rule__CoordinatorBody__Group_3__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1258:2: rule__CoordinatorBody__Group_3__1__Impl rule__CoordinatorBody__Group_3__2
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__1__Impl_in_rule__CoordinatorBody__Group_3__12533);
            rule__CoordinatorBody__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__2_in_rule__CoordinatorBody__Group_3__12536);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1265:1: rule__CoordinatorBody__Group_3__1__Impl : ( ( rule__CoordinatorBody__OrdVarsAssignment_3_1 ) ) ;
    public final void rule__CoordinatorBody__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1269:1: ( ( ( rule__CoordinatorBody__OrdVarsAssignment_3_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1270:1: ( ( rule__CoordinatorBody__OrdVarsAssignment_3_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1270:1: ( ( rule__CoordinatorBody__OrdVarsAssignment_3_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1271:1: ( rule__CoordinatorBody__OrdVarsAssignment_3_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getOrdVarsAssignment_3_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1272:1: ( rule__CoordinatorBody__OrdVarsAssignment_3_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1272:2: rule__CoordinatorBody__OrdVarsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__OrdVarsAssignment_3_1_in_rule__CoordinatorBody__Group_3__1__Impl2563);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1282:1: rule__CoordinatorBody__Group_3__2 : rule__CoordinatorBody__Group_3__2__Impl rule__CoordinatorBody__Group_3__3 ;
    public final void rule__CoordinatorBody__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1286:1: ( rule__CoordinatorBody__Group_3__2__Impl rule__CoordinatorBody__Group_3__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1287:2: rule__CoordinatorBody__Group_3__2__Impl rule__CoordinatorBody__Group_3__3
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__2__Impl_in_rule__CoordinatorBody__Group_3__22593);
            rule__CoordinatorBody__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__3_in_rule__CoordinatorBody__Group_3__22596);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1294:1: rule__CoordinatorBody__Group_3__2__Impl : ( ( rule__CoordinatorBody__Group_3_2__0 )* ) ;
    public final void rule__CoordinatorBody__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1298:1: ( ( ( rule__CoordinatorBody__Group_3_2__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1299:1: ( ( rule__CoordinatorBody__Group_3_2__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1299:1: ( ( rule__CoordinatorBody__Group_3_2__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1300:1: ( rule__CoordinatorBody__Group_3_2__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_3_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1301:1: ( rule__CoordinatorBody__Group_3_2__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==20) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1301:2: rule__CoordinatorBody__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_3_2__0_in_rule__CoordinatorBody__Group_3__2__Impl2623);
            	    rule__CoordinatorBody__Group_3_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1311:1: rule__CoordinatorBody__Group_3__3 : rule__CoordinatorBody__Group_3__3__Impl ;
    public final void rule__CoordinatorBody__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1315:1: ( rule__CoordinatorBody__Group_3__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1316:2: rule__CoordinatorBody__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__3__Impl_in_rule__CoordinatorBody__Group_3__32654);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1322:1: rule__CoordinatorBody__Group_3__3__Impl : ( ';' ) ;
    public final void rule__CoordinatorBody__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1326:1: ( ( ';' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1327:1: ( ';' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1327:1: ( ';' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1328:1: ';'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_3_3()); 
            match(input,19,FOLLOW_19_in_rule__CoordinatorBody__Group_3__3__Impl2682); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1349:1: rule__CoordinatorBody__Group_3_2__0 : rule__CoordinatorBody__Group_3_2__0__Impl rule__CoordinatorBody__Group_3_2__1 ;
    public final void rule__CoordinatorBody__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1353:1: ( rule__CoordinatorBody__Group_3_2__0__Impl rule__CoordinatorBody__Group_3_2__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1354:2: rule__CoordinatorBody__Group_3_2__0__Impl rule__CoordinatorBody__Group_3_2__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3_2__0__Impl_in_rule__CoordinatorBody__Group_3_2__02721);
            rule__CoordinatorBody__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3_2__1_in_rule__CoordinatorBody__Group_3_2__02724);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1361:1: rule__CoordinatorBody__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__CoordinatorBody__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1365:1: ( ( ',' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1366:1: ( ',' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1366:1: ( ',' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1367:1: ','
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_3_2_0()); 
            match(input,20,FOLLOW_20_in_rule__CoordinatorBody__Group_3_2__0__Impl2752); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1380:1: rule__CoordinatorBody__Group_3_2__1 : rule__CoordinatorBody__Group_3_2__1__Impl ;
    public final void rule__CoordinatorBody__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1384:1: ( rule__CoordinatorBody__Group_3_2__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1385:2: rule__CoordinatorBody__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3_2__1__Impl_in_rule__CoordinatorBody__Group_3_2__12783);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1391:1: rule__CoordinatorBody__Group_3_2__1__Impl : ( ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 ) ) ;
    public final void rule__CoordinatorBody__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1395:1: ( ( ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1396:1: ( ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1396:1: ( ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1397:1: ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getOrdVarsAssignment_3_2_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1398:1: ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1398:2: rule__CoordinatorBody__OrdVarsAssignment_3_2_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__OrdVarsAssignment_3_2_1_in_rule__CoordinatorBody__Group_3_2__1__Impl2810);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1412:1: rule__CoordinatorBody__Group_4__0 : rule__CoordinatorBody__Group_4__0__Impl rule__CoordinatorBody__Group_4__1 ;
    public final void rule__CoordinatorBody__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1416:1: ( rule__CoordinatorBody__Group_4__0__Impl rule__CoordinatorBody__Group_4__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1417:2: rule__CoordinatorBody__Group_4__0__Impl rule__CoordinatorBody__Group_4__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__0__Impl_in_rule__CoordinatorBody__Group_4__02844);
            rule__CoordinatorBody__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__1_in_rule__CoordinatorBody__Group_4__02847);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1424:1: rule__CoordinatorBody__Group_4__0__Impl : ( 'selfex' ) ;
    public final void rule__CoordinatorBody__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1428:1: ( ( 'selfex' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1429:1: ( 'selfex' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1429:1: ( 'selfex' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1430:1: 'selfex'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexKeyword_4_0()); 
            match(input,22,FOLLOW_22_in_rule__CoordinatorBody__Group_4__0__Impl2875); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1443:1: rule__CoordinatorBody__Group_4__1 : rule__CoordinatorBody__Group_4__1__Impl rule__CoordinatorBody__Group_4__2 ;
    public final void rule__CoordinatorBody__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1447:1: ( rule__CoordinatorBody__Group_4__1__Impl rule__CoordinatorBody__Group_4__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1448:2: rule__CoordinatorBody__Group_4__1__Impl rule__CoordinatorBody__Group_4__2
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__1__Impl_in_rule__CoordinatorBody__Group_4__12906);
            rule__CoordinatorBody__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__2_in_rule__CoordinatorBody__Group_4__12909);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1455:1: rule__CoordinatorBody__Group_4__1__Impl : ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 ) ) ;
    public final void rule__CoordinatorBody__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1459:1: ( ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1460:1: ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1460:1: ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1461:1: ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsAssignment_4_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1462:1: ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1462:2: rule__CoordinatorBody__SelfexMethodsAssignment_4_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__SelfexMethodsAssignment_4_1_in_rule__CoordinatorBody__Group_4__1__Impl2936);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1472:1: rule__CoordinatorBody__Group_4__2 : rule__CoordinatorBody__Group_4__2__Impl rule__CoordinatorBody__Group_4__3 ;
    public final void rule__CoordinatorBody__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1476:1: ( rule__CoordinatorBody__Group_4__2__Impl rule__CoordinatorBody__Group_4__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1477:2: rule__CoordinatorBody__Group_4__2__Impl rule__CoordinatorBody__Group_4__3
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__2__Impl_in_rule__CoordinatorBody__Group_4__22966);
            rule__CoordinatorBody__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__3_in_rule__CoordinatorBody__Group_4__22969);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1484:1: rule__CoordinatorBody__Group_4__2__Impl : ( ( rule__CoordinatorBody__Group_4_2__0 )* ) ;
    public final void rule__CoordinatorBody__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1488:1: ( ( ( rule__CoordinatorBody__Group_4_2__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1489:1: ( ( rule__CoordinatorBody__Group_4_2__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1489:1: ( ( rule__CoordinatorBody__Group_4_2__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1490:1: ( rule__CoordinatorBody__Group_4_2__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_4_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1491:1: ( rule__CoordinatorBody__Group_4_2__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==20) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1491:2: rule__CoordinatorBody__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_4_2__0_in_rule__CoordinatorBody__Group_4__2__Impl2996);
            	    rule__CoordinatorBody__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1501:1: rule__CoordinatorBody__Group_4__3 : rule__CoordinatorBody__Group_4__3__Impl ;
    public final void rule__CoordinatorBody__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1505:1: ( rule__CoordinatorBody__Group_4__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1506:2: rule__CoordinatorBody__Group_4__3__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__3__Impl_in_rule__CoordinatorBody__Group_4__33027);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1512:1: rule__CoordinatorBody__Group_4__3__Impl : ( ';' ) ;
    public final void rule__CoordinatorBody__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1516:1: ( ( ';' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1517:1: ( ';' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1517:1: ( ';' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1518:1: ';'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_4_3()); 
            match(input,19,FOLLOW_19_in_rule__CoordinatorBody__Group_4__3__Impl3055); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1539:1: rule__CoordinatorBody__Group_4_2__0 : rule__CoordinatorBody__Group_4_2__0__Impl rule__CoordinatorBody__Group_4_2__1 ;
    public final void rule__CoordinatorBody__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1543:1: ( rule__CoordinatorBody__Group_4_2__0__Impl rule__CoordinatorBody__Group_4_2__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1544:2: rule__CoordinatorBody__Group_4_2__0__Impl rule__CoordinatorBody__Group_4_2__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4_2__0__Impl_in_rule__CoordinatorBody__Group_4_2__03094);
            rule__CoordinatorBody__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4_2__1_in_rule__CoordinatorBody__Group_4_2__03097);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1551:1: rule__CoordinatorBody__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__CoordinatorBody__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1555:1: ( ( ',' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1556:1: ( ',' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1556:1: ( ',' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1557:1: ','
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_4_2_0()); 
            match(input,20,FOLLOW_20_in_rule__CoordinatorBody__Group_4_2__0__Impl3125); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1570:1: rule__CoordinatorBody__Group_4_2__1 : rule__CoordinatorBody__Group_4_2__1__Impl ;
    public final void rule__CoordinatorBody__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1574:1: ( rule__CoordinatorBody__Group_4_2__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1575:2: rule__CoordinatorBody__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4_2__1__Impl_in_rule__CoordinatorBody__Group_4_2__13156);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1581:1: rule__CoordinatorBody__Group_4_2__1__Impl : ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 ) ) ;
    public final void rule__CoordinatorBody__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1585:1: ( ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1586:1: ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1586:1: ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1587:1: ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsAssignment_4_2_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1588:1: ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1588:2: rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1_in_rule__CoordinatorBody__Group_4_2__1__Impl3183);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1602:1: rule__Guard__Group__0 : rule__Guard__Group__0__Impl rule__Guard__Group__1 ;
    public final void rule__Guard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1606:1: ( rule__Guard__Group__0__Impl rule__Guard__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1607:2: rule__Guard__Group__0__Impl rule__Guard__Group__1
            {
            pushFollow(FOLLOW_rule__Guard__Group__0__Impl_in_rule__Guard__Group__03217);
            rule__Guard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Guard__Group__1_in_rule__Guard__Group__03220);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1614:1: rule__Guard__Group__0__Impl : ( ( 'guard' )? ) ;
    public final void rule__Guard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1618:1: ( ( ( 'guard' )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1619:1: ( ( 'guard' )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1619:1: ( ( 'guard' )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1620:1: ( 'guard' )?
            {
             before(grammarAccess.getGuardAccess().getGuardKeyword_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1621:1: ( 'guard' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==23) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1622:2: 'guard'
                    {
                    match(input,23,FOLLOW_23_in_rule__Guard__Group__0__Impl3249); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1633:1: rule__Guard__Group__1 : rule__Guard__Group__1__Impl rule__Guard__Group__2 ;
    public final void rule__Guard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1637:1: ( rule__Guard__Group__1__Impl rule__Guard__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1638:2: rule__Guard__Group__1__Impl rule__Guard__Group__2
            {
            pushFollow(FOLLOW_rule__Guard__Group__1__Impl_in_rule__Guard__Group__13282);
            rule__Guard__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Guard__Group__2_in_rule__Guard__Group__13285);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1645:1: rule__Guard__Group__1__Impl : ( ( rule__Guard__MethodsAssignment_1 ) ) ;
    public final void rule__Guard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1649:1: ( ( ( rule__Guard__MethodsAssignment_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1650:1: ( ( rule__Guard__MethodsAssignment_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1650:1: ( ( rule__Guard__MethodsAssignment_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1651:1: ( rule__Guard__MethodsAssignment_1 )
            {
             before(grammarAccess.getGuardAccess().getMethodsAssignment_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1652:1: ( rule__Guard__MethodsAssignment_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1652:2: rule__Guard__MethodsAssignment_1
            {
            pushFollow(FOLLOW_rule__Guard__MethodsAssignment_1_in_rule__Guard__Group__1__Impl3312);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1662:1: rule__Guard__Group__2 : rule__Guard__Group__2__Impl rule__Guard__Group__3 ;
    public final void rule__Guard__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1666:1: ( rule__Guard__Group__2__Impl rule__Guard__Group__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1667:2: rule__Guard__Group__2__Impl rule__Guard__Group__3
            {
            pushFollow(FOLLOW_rule__Guard__Group__2__Impl_in_rule__Guard__Group__23342);
            rule__Guard__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Guard__Group__3_in_rule__Guard__Group__23345);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1674:1: rule__Guard__Group__2__Impl : ( ( rule__Guard__Group_2__0 )* ) ;
    public final void rule__Guard__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1678:1: ( ( ( rule__Guard__Group_2__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1679:1: ( ( rule__Guard__Group_2__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1679:1: ( ( rule__Guard__Group_2__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1680:1: ( rule__Guard__Group_2__0 )*
            {
             before(grammarAccess.getGuardAccess().getGroup_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1681:1: ( rule__Guard__Group_2__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==20) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1681:2: rule__Guard__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Guard__Group_2__0_in_rule__Guard__Group__2__Impl3372);
            	    rule__Guard__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1691:1: rule__Guard__Group__3 : rule__Guard__Group__3__Impl rule__Guard__Group__4 ;
    public final void rule__Guard__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1695:1: ( rule__Guard__Group__3__Impl rule__Guard__Group__4 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1696:2: rule__Guard__Group__3__Impl rule__Guard__Group__4
            {
            pushFollow(FOLLOW_rule__Guard__Group__3__Impl_in_rule__Guard__Group__33403);
            rule__Guard__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Guard__Group__4_in_rule__Guard__Group__33406);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1703:1: rule__Guard__Group__3__Impl : ( ':' ) ;
    public final void rule__Guard__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1707:1: ( ( ':' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1708:1: ( ':' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1708:1: ( ':' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1709:1: ':'
            {
             before(grammarAccess.getGuardAccess().getColonKeyword_3()); 
            match(input,24,FOLLOW_24_in_rule__Guard__Group__3__Impl3434); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1722:1: rule__Guard__Group__4 : rule__Guard__Group__4__Impl rule__Guard__Group__5 ;
    public final void rule__Guard__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1726:1: ( rule__Guard__Group__4__Impl rule__Guard__Group__5 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1727:2: rule__Guard__Group__4__Impl rule__Guard__Group__5
            {
            pushFollow(FOLLOW_rule__Guard__Group__4__Impl_in_rule__Guard__Group__43465);
            rule__Guard__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Guard__Group__5_in_rule__Guard__Group__43468);
            rule__Guard__Group__5();

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1734:1: rule__Guard__Group__4__Impl : ( ( rule__Guard__RequiresAssignment_4 )? ) ;
    public final void rule__Guard__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1738:1: ( ( ( rule__Guard__RequiresAssignment_4 )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1739:1: ( ( rule__Guard__RequiresAssignment_4 )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1739:1: ( ( rule__Guard__RequiresAssignment_4 )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1740:1: ( rule__Guard__RequiresAssignment_4 )?
            {
             before(grammarAccess.getGuardAccess().getRequiresAssignment_4()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1741:1: ( rule__Guard__RequiresAssignment_4 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1741:2: rule__Guard__RequiresAssignment_4
                    {
                    pushFollow(FOLLOW_rule__Guard__RequiresAssignment_4_in_rule__Guard__Group__4__Impl3495);
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


    // $ANTLR start "rule__Guard__Group__5"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1751:1: rule__Guard__Group__5 : rule__Guard__Group__5__Impl rule__Guard__Group__6 ;
    public final void rule__Guard__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1755:1: ( rule__Guard__Group__5__Impl rule__Guard__Group__6 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1756:2: rule__Guard__Group__5__Impl rule__Guard__Group__6
            {
            pushFollow(FOLLOW_rule__Guard__Group__5__Impl_in_rule__Guard__Group__53526);
            rule__Guard__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Guard__Group__6_in_rule__Guard__Group__53529);
            rule__Guard__Group__6();

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
    // $ANTLR end "rule__Guard__Group__5"


    // $ANTLR start "rule__Guard__Group__5__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1763:1: rule__Guard__Group__5__Impl : ( ( rule__Guard__Group_5__0 )? ) ;
    public final void rule__Guard__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1767:1: ( ( ( rule__Guard__Group_5__0 )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1768:1: ( ( rule__Guard__Group_5__0 )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1768:1: ( ( rule__Guard__Group_5__0 )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1769:1: ( rule__Guard__Group_5__0 )?
            {
             before(grammarAccess.getGuardAccess().getGroup_5()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1770:1: ( rule__Guard__Group_5__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==25) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1770:2: rule__Guard__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Guard__Group_5__0_in_rule__Guard__Group__5__Impl3556);
                    rule__Guard__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGuardAccess().getGroup_5()); 

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
    // $ANTLR end "rule__Guard__Group__5__Impl"


    // $ANTLR start "rule__Guard__Group__6"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1780:1: rule__Guard__Group__6 : rule__Guard__Group__6__Impl ;
    public final void rule__Guard__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1784:1: ( rule__Guard__Group__6__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1785:2: rule__Guard__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__Guard__Group__6__Impl_in_rule__Guard__Group__63587);
            rule__Guard__Group__6__Impl();

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
    // $ANTLR end "rule__Guard__Group__6"


    // $ANTLR start "rule__Guard__Group__6__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1791:1: rule__Guard__Group__6__Impl : ( ( rule__Guard__Group_6__0 )? ) ;
    public final void rule__Guard__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1795:1: ( ( ( rule__Guard__Group_6__0 )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1796:1: ( ( rule__Guard__Group_6__0 )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1796:1: ( ( rule__Guard__Group_6__0 )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1797:1: ( rule__Guard__Group_6__0 )?
            {
             before(grammarAccess.getGuardAccess().getGroup_6()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1798:1: ( rule__Guard__Group_6__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==26) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1798:2: rule__Guard__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__Guard__Group_6__0_in_rule__Guard__Group__6__Impl3614);
                    rule__Guard__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGuardAccess().getGroup_6()); 

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
    // $ANTLR end "rule__Guard__Group__6__Impl"


    // $ANTLR start "rule__Guard__Group_2__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1822:1: rule__Guard__Group_2__0 : rule__Guard__Group_2__0__Impl rule__Guard__Group_2__1 ;
    public final void rule__Guard__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1826:1: ( rule__Guard__Group_2__0__Impl rule__Guard__Group_2__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1827:2: rule__Guard__Group_2__0__Impl rule__Guard__Group_2__1
            {
            pushFollow(FOLLOW_rule__Guard__Group_2__0__Impl_in_rule__Guard__Group_2__03659);
            rule__Guard__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Guard__Group_2__1_in_rule__Guard__Group_2__03662);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1834:1: rule__Guard__Group_2__0__Impl : ( ',' ) ;
    public final void rule__Guard__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1838:1: ( ( ',' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1839:1: ( ',' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1839:1: ( ',' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1840:1: ','
            {
             before(grammarAccess.getGuardAccess().getCommaKeyword_2_0()); 
            match(input,20,FOLLOW_20_in_rule__Guard__Group_2__0__Impl3690); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1853:1: rule__Guard__Group_2__1 : rule__Guard__Group_2__1__Impl ;
    public final void rule__Guard__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1857:1: ( rule__Guard__Group_2__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1858:2: rule__Guard__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Guard__Group_2__1__Impl_in_rule__Guard__Group_2__13721);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1864:1: rule__Guard__Group_2__1__Impl : ( ( rule__Guard__MethodsAssignment_2_1 ) ) ;
    public final void rule__Guard__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1868:1: ( ( ( rule__Guard__MethodsAssignment_2_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1869:1: ( ( rule__Guard__MethodsAssignment_2_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1869:1: ( ( rule__Guard__MethodsAssignment_2_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1870:1: ( rule__Guard__MethodsAssignment_2_1 )
            {
             before(grammarAccess.getGuardAccess().getMethodsAssignment_2_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1871:1: ( rule__Guard__MethodsAssignment_2_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1871:2: rule__Guard__MethodsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Guard__MethodsAssignment_2_1_in_rule__Guard__Group_2__1__Impl3748);
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


    // $ANTLR start "rule__Guard__Group_5__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1885:1: rule__Guard__Group_5__0 : rule__Guard__Group_5__0__Impl rule__Guard__Group_5__1 ;
    public final void rule__Guard__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1889:1: ( rule__Guard__Group_5__0__Impl rule__Guard__Group_5__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1890:2: rule__Guard__Group_5__0__Impl rule__Guard__Group_5__1
            {
            pushFollow(FOLLOW_rule__Guard__Group_5__0__Impl_in_rule__Guard__Group_5__03782);
            rule__Guard__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Guard__Group_5__1_in_rule__Guard__Group_5__03785);
            rule__Guard__Group_5__1();

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
    // $ANTLR end "rule__Guard__Group_5__0"


    // $ANTLR start "rule__Guard__Group_5__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1897:1: rule__Guard__Group_5__0__Impl : ( 'on_entry' ) ;
    public final void rule__Guard__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1901:1: ( ( 'on_entry' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1902:1: ( 'on_entry' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1902:1: ( 'on_entry' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1903:1: 'on_entry'
            {
             before(grammarAccess.getGuardAccess().getOn_entryKeyword_5_0()); 
            match(input,25,FOLLOW_25_in_rule__Guard__Group_5__0__Impl3813); 
             after(grammarAccess.getGuardAccess().getOn_entryKeyword_5_0()); 

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
    // $ANTLR end "rule__Guard__Group_5__0__Impl"


    // $ANTLR start "rule__Guard__Group_5__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1916:1: rule__Guard__Group_5__1 : rule__Guard__Group_5__1__Impl rule__Guard__Group_5__2 ;
    public final void rule__Guard__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1920:1: ( rule__Guard__Group_5__1__Impl rule__Guard__Group_5__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1921:2: rule__Guard__Group_5__1__Impl rule__Guard__Group_5__2
            {
            pushFollow(FOLLOW_rule__Guard__Group_5__1__Impl_in_rule__Guard__Group_5__13844);
            rule__Guard__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Guard__Group_5__2_in_rule__Guard__Group_5__13847);
            rule__Guard__Group_5__2();

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
    // $ANTLR end "rule__Guard__Group_5__1"


    // $ANTLR start "rule__Guard__Group_5__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1928:1: rule__Guard__Group_5__1__Impl : ( '{' ) ;
    public final void rule__Guard__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1932:1: ( ( '{' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1933:1: ( '{' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1933:1: ( '{' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1934:1: '{'
            {
             before(grammarAccess.getGuardAccess().getLeftCurlyBracketKeyword_5_1()); 
            match(input,16,FOLLOW_16_in_rule__Guard__Group_5__1__Impl3875); 
             after(grammarAccess.getGuardAccess().getLeftCurlyBracketKeyword_5_1()); 

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
    // $ANTLR end "rule__Guard__Group_5__1__Impl"


    // $ANTLR start "rule__Guard__Group_5__2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1947:1: rule__Guard__Group_5__2 : rule__Guard__Group_5__2__Impl rule__Guard__Group_5__3 ;
    public final void rule__Guard__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1951:1: ( rule__Guard__Group_5__2__Impl rule__Guard__Group_5__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1952:2: rule__Guard__Group_5__2__Impl rule__Guard__Group_5__3
            {
            pushFollow(FOLLOW_rule__Guard__Group_5__2__Impl_in_rule__Guard__Group_5__23906);
            rule__Guard__Group_5__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Guard__Group_5__3_in_rule__Guard__Group_5__23909);
            rule__Guard__Group_5__3();

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
    // $ANTLR end "rule__Guard__Group_5__2"


    // $ANTLR start "rule__Guard__Group_5__2__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1959:1: rule__Guard__Group_5__2__Impl : ( ( ( rule__Guard__Alternatives_5_2 ) ) ( ( rule__Guard__Alternatives_5_2 )* ) ) ;
    public final void rule__Guard__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1963:1: ( ( ( ( rule__Guard__Alternatives_5_2 ) ) ( ( rule__Guard__Alternatives_5_2 )* ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1964:1: ( ( ( rule__Guard__Alternatives_5_2 ) ) ( ( rule__Guard__Alternatives_5_2 )* ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1964:1: ( ( ( rule__Guard__Alternatives_5_2 ) ) ( ( rule__Guard__Alternatives_5_2 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1965:1: ( ( rule__Guard__Alternatives_5_2 ) ) ( ( rule__Guard__Alternatives_5_2 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1965:1: ( ( rule__Guard__Alternatives_5_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1966:1: ( rule__Guard__Alternatives_5_2 )
            {
             before(grammarAccess.getGuardAccess().getAlternatives_5_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1967:1: ( rule__Guard__Alternatives_5_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1967:2: rule__Guard__Alternatives_5_2
            {
            pushFollow(FOLLOW_rule__Guard__Alternatives_5_2_in_rule__Guard__Group_5__2__Impl3938);
            rule__Guard__Alternatives_5_2();

            state._fsp--;


            }

             after(grammarAccess.getGuardAccess().getAlternatives_5_2()); 

            }

            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1970:1: ( ( rule__Guard__Alternatives_5_2 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1971:1: ( rule__Guard__Alternatives_5_2 )*
            {
             before(grammarAccess.getGuardAccess().getAlternatives_5_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1972:1: ( rule__Guard__Alternatives_5_2 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID||LA22_0==27) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1972:2: rule__Guard__Alternatives_5_2
            	    {
            	    pushFollow(FOLLOW_rule__Guard__Alternatives_5_2_in_rule__Guard__Group_5__2__Impl3950);
            	    rule__Guard__Alternatives_5_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getGuardAccess().getAlternatives_5_2()); 

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
    // $ANTLR end "rule__Guard__Group_5__2__Impl"


    // $ANTLR start "rule__Guard__Group_5__3"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1983:1: rule__Guard__Group_5__3 : rule__Guard__Group_5__3__Impl ;
    public final void rule__Guard__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1987:1: ( rule__Guard__Group_5__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1988:2: rule__Guard__Group_5__3__Impl
            {
            pushFollow(FOLLOW_rule__Guard__Group_5__3__Impl_in_rule__Guard__Group_5__33983);
            rule__Guard__Group_5__3__Impl();

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
    // $ANTLR end "rule__Guard__Group_5__3"


    // $ANTLR start "rule__Guard__Group_5__3__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1994:1: rule__Guard__Group_5__3__Impl : ( '}' ) ;
    public final void rule__Guard__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1998:1: ( ( '}' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1999:1: ( '}' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1999:1: ( '}' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2000:1: '}'
            {
             before(grammarAccess.getGuardAccess().getRightCurlyBracketKeyword_5_3()); 
            match(input,17,FOLLOW_17_in_rule__Guard__Group_5__3__Impl4011); 
             after(grammarAccess.getGuardAccess().getRightCurlyBracketKeyword_5_3()); 

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
    // $ANTLR end "rule__Guard__Group_5__3__Impl"


    // $ANTLR start "rule__Guard__Group_6__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2021:1: rule__Guard__Group_6__0 : rule__Guard__Group_6__0__Impl rule__Guard__Group_6__1 ;
    public final void rule__Guard__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2025:1: ( rule__Guard__Group_6__0__Impl rule__Guard__Group_6__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2026:2: rule__Guard__Group_6__0__Impl rule__Guard__Group_6__1
            {
            pushFollow(FOLLOW_rule__Guard__Group_6__0__Impl_in_rule__Guard__Group_6__04050);
            rule__Guard__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Guard__Group_6__1_in_rule__Guard__Group_6__04053);
            rule__Guard__Group_6__1();

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
    // $ANTLR end "rule__Guard__Group_6__0"


    // $ANTLR start "rule__Guard__Group_6__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2033:1: rule__Guard__Group_6__0__Impl : ( 'on_exit' ) ;
    public final void rule__Guard__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2037:1: ( ( 'on_exit' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2038:1: ( 'on_exit' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2038:1: ( 'on_exit' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2039:1: 'on_exit'
            {
             before(grammarAccess.getGuardAccess().getOn_exitKeyword_6_0()); 
            match(input,26,FOLLOW_26_in_rule__Guard__Group_6__0__Impl4081); 
             after(grammarAccess.getGuardAccess().getOn_exitKeyword_6_0()); 

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
    // $ANTLR end "rule__Guard__Group_6__0__Impl"


    // $ANTLR start "rule__Guard__Group_6__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2052:1: rule__Guard__Group_6__1 : rule__Guard__Group_6__1__Impl rule__Guard__Group_6__2 ;
    public final void rule__Guard__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2056:1: ( rule__Guard__Group_6__1__Impl rule__Guard__Group_6__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2057:2: rule__Guard__Group_6__1__Impl rule__Guard__Group_6__2
            {
            pushFollow(FOLLOW_rule__Guard__Group_6__1__Impl_in_rule__Guard__Group_6__14112);
            rule__Guard__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Guard__Group_6__2_in_rule__Guard__Group_6__14115);
            rule__Guard__Group_6__2();

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
    // $ANTLR end "rule__Guard__Group_6__1"


    // $ANTLR start "rule__Guard__Group_6__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2064:1: rule__Guard__Group_6__1__Impl : ( '{' ) ;
    public final void rule__Guard__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2068:1: ( ( '{' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2069:1: ( '{' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2069:1: ( '{' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2070:1: '{'
            {
             before(grammarAccess.getGuardAccess().getLeftCurlyBracketKeyword_6_1()); 
            match(input,16,FOLLOW_16_in_rule__Guard__Group_6__1__Impl4143); 
             after(grammarAccess.getGuardAccess().getLeftCurlyBracketKeyword_6_1()); 

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
    // $ANTLR end "rule__Guard__Group_6__1__Impl"


    // $ANTLR start "rule__Guard__Group_6__2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2083:1: rule__Guard__Group_6__2 : rule__Guard__Group_6__2__Impl rule__Guard__Group_6__3 ;
    public final void rule__Guard__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2087:1: ( rule__Guard__Group_6__2__Impl rule__Guard__Group_6__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2088:2: rule__Guard__Group_6__2__Impl rule__Guard__Group_6__3
            {
            pushFollow(FOLLOW_rule__Guard__Group_6__2__Impl_in_rule__Guard__Group_6__24174);
            rule__Guard__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Guard__Group_6__3_in_rule__Guard__Group_6__24177);
            rule__Guard__Group_6__3();

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
    // $ANTLR end "rule__Guard__Group_6__2"


    // $ANTLR start "rule__Guard__Group_6__2__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2095:1: rule__Guard__Group_6__2__Impl : ( ( ( rule__Guard__Alternatives_6_2 ) ) ( ( rule__Guard__Alternatives_6_2 )* ) ) ;
    public final void rule__Guard__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2099:1: ( ( ( ( rule__Guard__Alternatives_6_2 ) ) ( ( rule__Guard__Alternatives_6_2 )* ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2100:1: ( ( ( rule__Guard__Alternatives_6_2 ) ) ( ( rule__Guard__Alternatives_6_2 )* ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2100:1: ( ( ( rule__Guard__Alternatives_6_2 ) ) ( ( rule__Guard__Alternatives_6_2 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2101:1: ( ( rule__Guard__Alternatives_6_2 ) ) ( ( rule__Guard__Alternatives_6_2 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2101:1: ( ( rule__Guard__Alternatives_6_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2102:1: ( rule__Guard__Alternatives_6_2 )
            {
             before(grammarAccess.getGuardAccess().getAlternatives_6_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2103:1: ( rule__Guard__Alternatives_6_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2103:2: rule__Guard__Alternatives_6_2
            {
            pushFollow(FOLLOW_rule__Guard__Alternatives_6_2_in_rule__Guard__Group_6__2__Impl4206);
            rule__Guard__Alternatives_6_2();

            state._fsp--;


            }

             after(grammarAccess.getGuardAccess().getAlternatives_6_2()); 

            }

            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2106:1: ( ( rule__Guard__Alternatives_6_2 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2107:1: ( rule__Guard__Alternatives_6_2 )*
            {
             before(grammarAccess.getGuardAccess().getAlternatives_6_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2108:1: ( rule__Guard__Alternatives_6_2 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_ID||LA23_0==27) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2108:2: rule__Guard__Alternatives_6_2
            	    {
            	    pushFollow(FOLLOW_rule__Guard__Alternatives_6_2_in_rule__Guard__Group_6__2__Impl4218);
            	    rule__Guard__Alternatives_6_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getGuardAccess().getAlternatives_6_2()); 

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
    // $ANTLR end "rule__Guard__Group_6__2__Impl"


    // $ANTLR start "rule__Guard__Group_6__3"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2119:1: rule__Guard__Group_6__3 : rule__Guard__Group_6__3__Impl ;
    public final void rule__Guard__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2123:1: ( rule__Guard__Group_6__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2124:2: rule__Guard__Group_6__3__Impl
            {
            pushFollow(FOLLOW_rule__Guard__Group_6__3__Impl_in_rule__Guard__Group_6__34251);
            rule__Guard__Group_6__3__Impl();

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
    // $ANTLR end "rule__Guard__Group_6__3"


    // $ANTLR start "rule__Guard__Group_6__3__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2130:1: rule__Guard__Group_6__3__Impl : ( '}' ) ;
    public final void rule__Guard__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2134:1: ( ( '}' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2135:1: ( '}' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2135:1: ( '}' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2136:1: '}'
            {
             before(grammarAccess.getGuardAccess().getRightCurlyBracketKeyword_6_3()); 
            match(input,17,FOLLOW_17_in_rule__Guard__Group_6__3__Impl4279); 
             after(grammarAccess.getGuardAccess().getRightCurlyBracketKeyword_6_3()); 

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
    // $ANTLR end "rule__Guard__Group_6__3__Impl"


    // $ANTLR start "rule__IfStatement__Group__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2157:1: rule__IfStatement__Group__0 : rule__IfStatement__Group__0__Impl rule__IfStatement__Group__1 ;
    public final void rule__IfStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2161:1: ( rule__IfStatement__Group__0__Impl rule__IfStatement__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2162:2: rule__IfStatement__Group__0__Impl rule__IfStatement__Group__1
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__0__Impl_in_rule__IfStatement__Group__04318);
            rule__IfStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__1_in_rule__IfStatement__Group__04321);
            rule__IfStatement__Group__1();

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
    // $ANTLR end "rule__IfStatement__Group__0"


    // $ANTLR start "rule__IfStatement__Group__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2169:1: rule__IfStatement__Group__0__Impl : ( 'if' ) ;
    public final void rule__IfStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2173:1: ( ( 'if' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2174:1: ( 'if' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2174:1: ( 'if' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2175:1: 'if'
            {
             before(grammarAccess.getIfStatementAccess().getIfKeyword_0()); 
            match(input,27,FOLLOW_27_in_rule__IfStatement__Group__0__Impl4349); 
             after(grammarAccess.getIfStatementAccess().getIfKeyword_0()); 

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
    // $ANTLR end "rule__IfStatement__Group__0__Impl"


    // $ANTLR start "rule__IfStatement__Group__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2188:1: rule__IfStatement__Group__1 : rule__IfStatement__Group__1__Impl rule__IfStatement__Group__2 ;
    public final void rule__IfStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2192:1: ( rule__IfStatement__Group__1__Impl rule__IfStatement__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2193:2: rule__IfStatement__Group__1__Impl rule__IfStatement__Group__2
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__1__Impl_in_rule__IfStatement__Group__14380);
            rule__IfStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__2_in_rule__IfStatement__Group__14383);
            rule__IfStatement__Group__2();

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
    // $ANTLR end "rule__IfStatement__Group__1"


    // $ANTLR start "rule__IfStatement__Group__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2200:1: rule__IfStatement__Group__1__Impl : ( '(' ) ;
    public final void rule__IfStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2204:1: ( ( '(' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2205:1: ( '(' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2205:1: ( '(' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2206:1: '('
            {
             before(grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_1()); 
            match(input,28,FOLLOW_28_in_rule__IfStatement__Group__1__Impl4411); 
             after(grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_1()); 

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
    // $ANTLR end "rule__IfStatement__Group__1__Impl"


    // $ANTLR start "rule__IfStatement__Group__2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2219:1: rule__IfStatement__Group__2 : rule__IfStatement__Group__2__Impl rule__IfStatement__Group__3 ;
    public final void rule__IfStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2223:1: ( rule__IfStatement__Group__2__Impl rule__IfStatement__Group__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2224:2: rule__IfStatement__Group__2__Impl rule__IfStatement__Group__3
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__2__Impl_in_rule__IfStatement__Group__24442);
            rule__IfStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__3_in_rule__IfStatement__Group__24445);
            rule__IfStatement__Group__3();

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
    // $ANTLR end "rule__IfStatement__Group__2"


    // $ANTLR start "rule__IfStatement__Group__2__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2231:1: rule__IfStatement__Group__2__Impl : ( ( rule__IfStatement__ExpressionAssignment_2 ) ) ;
    public final void rule__IfStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2235:1: ( ( ( rule__IfStatement__ExpressionAssignment_2 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2236:1: ( ( rule__IfStatement__ExpressionAssignment_2 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2236:1: ( ( rule__IfStatement__ExpressionAssignment_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2237:1: ( rule__IfStatement__ExpressionAssignment_2 )
            {
             before(grammarAccess.getIfStatementAccess().getExpressionAssignment_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2238:1: ( rule__IfStatement__ExpressionAssignment_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2238:2: rule__IfStatement__ExpressionAssignment_2
            {
            pushFollow(FOLLOW_rule__IfStatement__ExpressionAssignment_2_in_rule__IfStatement__Group__2__Impl4472);
            rule__IfStatement__ExpressionAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getIfStatementAccess().getExpressionAssignment_2()); 

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
    // $ANTLR end "rule__IfStatement__Group__2__Impl"


    // $ANTLR start "rule__IfStatement__Group__3"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2248:1: rule__IfStatement__Group__3 : rule__IfStatement__Group__3__Impl rule__IfStatement__Group__4 ;
    public final void rule__IfStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2252:1: ( rule__IfStatement__Group__3__Impl rule__IfStatement__Group__4 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2253:2: rule__IfStatement__Group__3__Impl rule__IfStatement__Group__4
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__3__Impl_in_rule__IfStatement__Group__34502);
            rule__IfStatement__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__4_in_rule__IfStatement__Group__34505);
            rule__IfStatement__Group__4();

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
    // $ANTLR end "rule__IfStatement__Group__3"


    // $ANTLR start "rule__IfStatement__Group__3__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2260:1: rule__IfStatement__Group__3__Impl : ( ')' ) ;
    public final void rule__IfStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2264:1: ( ( ')' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2265:1: ( ')' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2265:1: ( ')' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2266:1: ')'
            {
             before(grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_3()); 
            match(input,29,FOLLOW_29_in_rule__IfStatement__Group__3__Impl4533); 
             after(grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_3()); 

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
    // $ANTLR end "rule__IfStatement__Group__3__Impl"


    // $ANTLR start "rule__IfStatement__Group__4"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2279:1: rule__IfStatement__Group__4 : rule__IfStatement__Group__4__Impl ;
    public final void rule__IfStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2283:1: ( rule__IfStatement__Group__4__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2284:2: rule__IfStatement__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__4__Impl_in_rule__IfStatement__Group__44564);
            rule__IfStatement__Group__4__Impl();

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
    // $ANTLR end "rule__IfStatement__Group__4"


    // $ANTLR start "rule__IfStatement__Group__4__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2290:1: rule__IfStatement__Group__4__Impl : ( ( rule__IfStatement__StatementAssignment_4 ) ) ;
    public final void rule__IfStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2294:1: ( ( ( rule__IfStatement__StatementAssignment_4 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2295:1: ( ( rule__IfStatement__StatementAssignment_4 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2295:1: ( ( rule__IfStatement__StatementAssignment_4 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2296:1: ( rule__IfStatement__StatementAssignment_4 )
            {
             before(grammarAccess.getIfStatementAccess().getStatementAssignment_4()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2297:1: ( rule__IfStatement__StatementAssignment_4 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2297:2: rule__IfStatement__StatementAssignment_4
            {
            pushFollow(FOLLOW_rule__IfStatement__StatementAssignment_4_in_rule__IfStatement__Group__4__Impl4591);
            rule__IfStatement__StatementAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getIfStatementAccess().getStatementAssignment_4()); 

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
    // $ANTLR end "rule__IfStatement__Group__4__Impl"


    // $ANTLR start "rule__IfExpression__Group__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2317:1: rule__IfExpression__Group__0 : rule__IfExpression__Group__0__Impl rule__IfExpression__Group__1 ;
    public final void rule__IfExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2321:1: ( rule__IfExpression__Group__0__Impl rule__IfExpression__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2322:2: rule__IfExpression__Group__0__Impl rule__IfExpression__Group__1
            {
            pushFollow(FOLLOW_rule__IfExpression__Group__0__Impl_in_rule__IfExpression__Group__04631);
            rule__IfExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfExpression__Group__1_in_rule__IfExpression__Group__04634);
            rule__IfExpression__Group__1();

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
    // $ANTLR end "rule__IfExpression__Group__0"


    // $ANTLR start "rule__IfExpression__Group__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2329:1: rule__IfExpression__Group__0__Impl : ( ( rule__IfExpression__VarAssignment_0 ) ) ;
    public final void rule__IfExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2333:1: ( ( ( rule__IfExpression__VarAssignment_0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2334:1: ( ( rule__IfExpression__VarAssignment_0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2334:1: ( ( rule__IfExpression__VarAssignment_0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2335:1: ( rule__IfExpression__VarAssignment_0 )
            {
             before(grammarAccess.getIfExpressionAccess().getVarAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2336:1: ( rule__IfExpression__VarAssignment_0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2336:2: rule__IfExpression__VarAssignment_0
            {
            pushFollow(FOLLOW_rule__IfExpression__VarAssignment_0_in_rule__IfExpression__Group__0__Impl4661);
            rule__IfExpression__VarAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getIfExpressionAccess().getVarAssignment_0()); 

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
    // $ANTLR end "rule__IfExpression__Group__0__Impl"


    // $ANTLR start "rule__IfExpression__Group__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2346:1: rule__IfExpression__Group__1 : rule__IfExpression__Group__1__Impl rule__IfExpression__Group__2 ;
    public final void rule__IfExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2350:1: ( rule__IfExpression__Group__1__Impl rule__IfExpression__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2351:2: rule__IfExpression__Group__1__Impl rule__IfExpression__Group__2
            {
            pushFollow(FOLLOW_rule__IfExpression__Group__1__Impl_in_rule__IfExpression__Group__14691);
            rule__IfExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfExpression__Group__2_in_rule__IfExpression__Group__14694);
            rule__IfExpression__Group__2();

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
    // $ANTLR end "rule__IfExpression__Group__1"


    // $ANTLR start "rule__IfExpression__Group__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2358:1: rule__IfExpression__Group__1__Impl : ( ( rule__IfExpression__OpAssignment_1 ) ) ;
    public final void rule__IfExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2362:1: ( ( ( rule__IfExpression__OpAssignment_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2363:1: ( ( rule__IfExpression__OpAssignment_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2363:1: ( ( rule__IfExpression__OpAssignment_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2364:1: ( rule__IfExpression__OpAssignment_1 )
            {
             before(grammarAccess.getIfExpressionAccess().getOpAssignment_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2365:1: ( rule__IfExpression__OpAssignment_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2365:2: rule__IfExpression__OpAssignment_1
            {
            pushFollow(FOLLOW_rule__IfExpression__OpAssignment_1_in_rule__IfExpression__Group__1__Impl4721);
            rule__IfExpression__OpAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIfExpressionAccess().getOpAssignment_1()); 

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
    // $ANTLR end "rule__IfExpression__Group__1__Impl"


    // $ANTLR start "rule__IfExpression__Group__2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2375:1: rule__IfExpression__Group__2 : rule__IfExpression__Group__2__Impl ;
    public final void rule__IfExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2379:1: ( rule__IfExpression__Group__2__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2380:2: rule__IfExpression__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__IfExpression__Group__2__Impl_in_rule__IfExpression__Group__24751);
            rule__IfExpression__Group__2__Impl();

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
    // $ANTLR end "rule__IfExpression__Group__2"


    // $ANTLR start "rule__IfExpression__Group__2__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2386:1: rule__IfExpression__Group__2__Impl : ( ( rule__IfExpression__AssignmentAssignment_2 ) ) ;
    public final void rule__IfExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2390:1: ( ( ( rule__IfExpression__AssignmentAssignment_2 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2391:1: ( ( rule__IfExpression__AssignmentAssignment_2 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2391:1: ( ( rule__IfExpression__AssignmentAssignment_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2392:1: ( rule__IfExpression__AssignmentAssignment_2 )
            {
             before(grammarAccess.getIfExpressionAccess().getAssignmentAssignment_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2393:1: ( rule__IfExpression__AssignmentAssignment_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2393:2: rule__IfExpression__AssignmentAssignment_2
            {
            pushFollow(FOLLOW_rule__IfExpression__AssignmentAssignment_2_in_rule__IfExpression__Group__2__Impl4778);
            rule__IfExpression__AssignmentAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getIfExpressionAccess().getAssignmentAssignment_2()); 

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
    // $ANTLR end "rule__IfExpression__Group__2__Impl"


    // $ANTLR start "rule__AssignStatement__Group__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2409:1: rule__AssignStatement__Group__0 : rule__AssignStatement__Group__0__Impl rule__AssignStatement__Group__1 ;
    public final void rule__AssignStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2413:1: ( rule__AssignStatement__Group__0__Impl rule__AssignStatement__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2414:2: rule__AssignStatement__Group__0__Impl rule__AssignStatement__Group__1
            {
            pushFollow(FOLLOW_rule__AssignStatement__Group__0__Impl_in_rule__AssignStatement__Group__04814);
            rule__AssignStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssignStatement__Group__1_in_rule__AssignStatement__Group__04817);
            rule__AssignStatement__Group__1();

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
    // $ANTLR end "rule__AssignStatement__Group__0"


    // $ANTLR start "rule__AssignStatement__Group__0__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2421:1: rule__AssignStatement__Group__0__Impl : ( ( rule__AssignStatement__VarAssignment_0 ) ) ;
    public final void rule__AssignStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2425:1: ( ( ( rule__AssignStatement__VarAssignment_0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2426:1: ( ( rule__AssignStatement__VarAssignment_0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2426:1: ( ( rule__AssignStatement__VarAssignment_0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2427:1: ( rule__AssignStatement__VarAssignment_0 )
            {
             before(grammarAccess.getAssignStatementAccess().getVarAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2428:1: ( rule__AssignStatement__VarAssignment_0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2428:2: rule__AssignStatement__VarAssignment_0
            {
            pushFollow(FOLLOW_rule__AssignStatement__VarAssignment_0_in_rule__AssignStatement__Group__0__Impl4844);
            rule__AssignStatement__VarAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAssignStatementAccess().getVarAssignment_0()); 

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
    // $ANTLR end "rule__AssignStatement__Group__0__Impl"


    // $ANTLR start "rule__AssignStatement__Group__1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2438:1: rule__AssignStatement__Group__1 : rule__AssignStatement__Group__1__Impl rule__AssignStatement__Group__2 ;
    public final void rule__AssignStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2442:1: ( rule__AssignStatement__Group__1__Impl rule__AssignStatement__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2443:2: rule__AssignStatement__Group__1__Impl rule__AssignStatement__Group__2
            {
            pushFollow(FOLLOW_rule__AssignStatement__Group__1__Impl_in_rule__AssignStatement__Group__14874);
            rule__AssignStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssignStatement__Group__2_in_rule__AssignStatement__Group__14877);
            rule__AssignStatement__Group__2();

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
    // $ANTLR end "rule__AssignStatement__Group__1"


    // $ANTLR start "rule__AssignStatement__Group__1__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2450:1: rule__AssignStatement__Group__1__Impl : ( '=' ) ;
    public final void rule__AssignStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2454:1: ( ( '=' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2455:1: ( '=' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2455:1: ( '=' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2456:1: '='
            {
             before(grammarAccess.getAssignStatementAccess().getEqualsSignKeyword_1()); 
            match(input,30,FOLLOW_30_in_rule__AssignStatement__Group__1__Impl4905); 
             after(grammarAccess.getAssignStatementAccess().getEqualsSignKeyword_1()); 

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
    // $ANTLR end "rule__AssignStatement__Group__1__Impl"


    // $ANTLR start "rule__AssignStatement__Group__2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2469:1: rule__AssignStatement__Group__2 : rule__AssignStatement__Group__2__Impl rule__AssignStatement__Group__3 ;
    public final void rule__AssignStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2473:1: ( rule__AssignStatement__Group__2__Impl rule__AssignStatement__Group__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2474:2: rule__AssignStatement__Group__2__Impl rule__AssignStatement__Group__3
            {
            pushFollow(FOLLOW_rule__AssignStatement__Group__2__Impl_in_rule__AssignStatement__Group__24936);
            rule__AssignStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssignStatement__Group__3_in_rule__AssignStatement__Group__24939);
            rule__AssignStatement__Group__3();

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
    // $ANTLR end "rule__AssignStatement__Group__2"


    // $ANTLR start "rule__AssignStatement__Group__2__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2481:1: rule__AssignStatement__Group__2__Impl : ( ( rule__AssignStatement__ValueAssignment_2 ) ) ;
    public final void rule__AssignStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2485:1: ( ( ( rule__AssignStatement__ValueAssignment_2 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2486:1: ( ( rule__AssignStatement__ValueAssignment_2 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2486:1: ( ( rule__AssignStatement__ValueAssignment_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2487:1: ( rule__AssignStatement__ValueAssignment_2 )
            {
             before(grammarAccess.getAssignStatementAccess().getValueAssignment_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2488:1: ( rule__AssignStatement__ValueAssignment_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2488:2: rule__AssignStatement__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__AssignStatement__ValueAssignment_2_in_rule__AssignStatement__Group__2__Impl4966);
            rule__AssignStatement__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAssignStatementAccess().getValueAssignment_2()); 

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
    // $ANTLR end "rule__AssignStatement__Group__2__Impl"


    // $ANTLR start "rule__AssignStatement__Group__3"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2498:1: rule__AssignStatement__Group__3 : rule__AssignStatement__Group__3__Impl ;
    public final void rule__AssignStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2502:1: ( rule__AssignStatement__Group__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2503:2: rule__AssignStatement__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__AssignStatement__Group__3__Impl_in_rule__AssignStatement__Group__34996);
            rule__AssignStatement__Group__3__Impl();

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
    // $ANTLR end "rule__AssignStatement__Group__3"


    // $ANTLR start "rule__AssignStatement__Group__3__Impl"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2509:1: rule__AssignStatement__Group__3__Impl : ( ';' ) ;
    public final void rule__AssignStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2513:1: ( ( ';' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2514:1: ( ';' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2514:1: ( ';' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2515:1: ';'
            {
             before(grammarAccess.getAssignStatementAccess().getSemicolonKeyword_3()); 
            match(input,19,FOLLOW_19_in_rule__AssignStatement__Group__3__Impl5024); 
             after(grammarAccess.getAssignStatementAccess().getSemicolonKeyword_3()); 

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
    // $ANTLR end "rule__AssignStatement__Group__3__Impl"


    // $ANTLR start "rule__Requires__Group__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2536:1: rule__Requires__Group__0 : rule__Requires__Group__0__Impl rule__Requires__Group__1 ;
    public final void rule__Requires__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2540:1: ( rule__Requires__Group__0__Impl rule__Requires__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2541:2: rule__Requires__Group__0__Impl rule__Requires__Group__1
            {
            pushFollow(FOLLOW_rule__Requires__Group__0__Impl_in_rule__Requires__Group__05063);
            rule__Requires__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Requires__Group__1_in_rule__Requires__Group__05066);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2548:1: rule__Requires__Group__0__Impl : ( 'requires' ) ;
    public final void rule__Requires__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2552:1: ( ( 'requires' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2553:1: ( 'requires' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2553:1: ( 'requires' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2554:1: 'requires'
            {
             before(grammarAccess.getRequiresAccess().getRequiresKeyword_0()); 
            match(input,31,FOLLOW_31_in_rule__Requires__Group__0__Impl5094); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2567:1: rule__Requires__Group__1 : rule__Requires__Group__1__Impl rule__Requires__Group__2 ;
    public final void rule__Requires__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2571:1: ( rule__Requires__Group__1__Impl rule__Requires__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2572:2: rule__Requires__Group__1__Impl rule__Requires__Group__2
            {
            pushFollow(FOLLOW_rule__Requires__Group__1__Impl_in_rule__Requires__Group__15125);
            rule__Requires__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Requires__Group__2_in_rule__Requires__Group__15128);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2579:1: rule__Requires__Group__1__Impl : ( ( rule__Requires__AndExpressionAssignment_1 ) ) ;
    public final void rule__Requires__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2583:1: ( ( ( rule__Requires__AndExpressionAssignment_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2584:1: ( ( rule__Requires__AndExpressionAssignment_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2584:1: ( ( rule__Requires__AndExpressionAssignment_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2585:1: ( rule__Requires__AndExpressionAssignment_1 )
            {
             before(grammarAccess.getRequiresAccess().getAndExpressionAssignment_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2586:1: ( rule__Requires__AndExpressionAssignment_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2586:2: rule__Requires__AndExpressionAssignment_1
            {
            pushFollow(FOLLOW_rule__Requires__AndExpressionAssignment_1_in_rule__Requires__Group__1__Impl5155);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2596:1: rule__Requires__Group__2 : rule__Requires__Group__2__Impl ;
    public final void rule__Requires__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2600:1: ( rule__Requires__Group__2__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2601:2: rule__Requires__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Requires__Group__2__Impl_in_rule__Requires__Group__25185);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2607:1: rule__Requires__Group__2__Impl : ( ';' ) ;
    public final void rule__Requires__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2611:1: ( ( ';' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2612:1: ( ';' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2612:1: ( ';' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2613:1: ';'
            {
             before(grammarAccess.getRequiresAccess().getSemicolonKeyword_2()); 
            match(input,19,FOLLOW_19_in_rule__Requires__Group__2__Impl5213); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2632:1: rule__AndExpression__Group__0 : rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1 ;
    public final void rule__AndExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2636:1: ( rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2637:2: rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1
            {
            pushFollow(FOLLOW_rule__AndExpression__Group__0__Impl_in_rule__AndExpression__Group__05250);
            rule__AndExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AndExpression__Group__1_in_rule__AndExpression__Group__05253);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2644:1: rule__AndExpression__Group__0__Impl : ( ( rule__AndExpression__OrExpressionsAssignment_0 ) ) ;
    public final void rule__AndExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2648:1: ( ( ( rule__AndExpression__OrExpressionsAssignment_0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2649:1: ( ( rule__AndExpression__OrExpressionsAssignment_0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2649:1: ( ( rule__AndExpression__OrExpressionsAssignment_0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2650:1: ( rule__AndExpression__OrExpressionsAssignment_0 )
            {
             before(grammarAccess.getAndExpressionAccess().getOrExpressionsAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2651:1: ( rule__AndExpression__OrExpressionsAssignment_0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2651:2: rule__AndExpression__OrExpressionsAssignment_0
            {
            pushFollow(FOLLOW_rule__AndExpression__OrExpressionsAssignment_0_in_rule__AndExpression__Group__0__Impl5280);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2661:1: rule__AndExpression__Group__1 : rule__AndExpression__Group__1__Impl ;
    public final void rule__AndExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2665:1: ( rule__AndExpression__Group__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2666:2: rule__AndExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AndExpression__Group__1__Impl_in_rule__AndExpression__Group__15310);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2672:1: rule__AndExpression__Group__1__Impl : ( ( rule__AndExpression__Group_1__0 )* ) ;
    public final void rule__AndExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2676:1: ( ( ( rule__AndExpression__Group_1__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2677:1: ( ( rule__AndExpression__Group_1__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2677:1: ( ( rule__AndExpression__Group_1__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2678:1: ( rule__AndExpression__Group_1__0 )*
            {
             before(grammarAccess.getAndExpressionAccess().getGroup_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2679:1: ( rule__AndExpression__Group_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==32) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2679:2: rule__AndExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AndExpression__Group_1__0_in_rule__AndExpression__Group__1__Impl5337);
            	    rule__AndExpression__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2693:1: rule__AndExpression__Group_1__0 : rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1 ;
    public final void rule__AndExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2697:1: ( rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2698:2: rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__AndExpression__Group_1__0__Impl_in_rule__AndExpression__Group_1__05372);
            rule__AndExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AndExpression__Group_1__1_in_rule__AndExpression__Group_1__05375);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2705:1: rule__AndExpression__Group_1__0__Impl : ( '&&' ) ;
    public final void rule__AndExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2709:1: ( ( '&&' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2710:1: ( '&&' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2710:1: ( '&&' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2711:1: '&&'
            {
             before(grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_0()); 
            match(input,32,FOLLOW_32_in_rule__AndExpression__Group_1__0__Impl5403); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2724:1: rule__AndExpression__Group_1__1 : rule__AndExpression__Group_1__1__Impl ;
    public final void rule__AndExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2728:1: ( rule__AndExpression__Group_1__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2729:2: rule__AndExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AndExpression__Group_1__1__Impl_in_rule__AndExpression__Group_1__15434);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2735:1: rule__AndExpression__Group_1__1__Impl : ( ( rule__AndExpression__OrExpressionsAssignment_1_1 ) ) ;
    public final void rule__AndExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2739:1: ( ( ( rule__AndExpression__OrExpressionsAssignment_1_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2740:1: ( ( rule__AndExpression__OrExpressionsAssignment_1_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2740:1: ( ( rule__AndExpression__OrExpressionsAssignment_1_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2741:1: ( rule__AndExpression__OrExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getAndExpressionAccess().getOrExpressionsAssignment_1_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2742:1: ( rule__AndExpression__OrExpressionsAssignment_1_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2742:2: rule__AndExpression__OrExpressionsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__AndExpression__OrExpressionsAssignment_1_1_in_rule__AndExpression__Group_1__1__Impl5461);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2756:1: rule__OrExpression__Group__0 : rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1 ;
    public final void rule__OrExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2760:1: ( rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2761:2: rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1
            {
            pushFollow(FOLLOW_rule__OrExpression__Group__0__Impl_in_rule__OrExpression__Group__05495);
            rule__OrExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OrExpression__Group__1_in_rule__OrExpression__Group__05498);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2768:1: rule__OrExpression__Group__0__Impl : ( ( rule__OrExpression__BasicExpressionsAssignment_0 ) ) ;
    public final void rule__OrExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2772:1: ( ( ( rule__OrExpression__BasicExpressionsAssignment_0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2773:1: ( ( rule__OrExpression__BasicExpressionsAssignment_0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2773:1: ( ( rule__OrExpression__BasicExpressionsAssignment_0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2774:1: ( rule__OrExpression__BasicExpressionsAssignment_0 )
            {
             before(grammarAccess.getOrExpressionAccess().getBasicExpressionsAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2775:1: ( rule__OrExpression__BasicExpressionsAssignment_0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2775:2: rule__OrExpression__BasicExpressionsAssignment_0
            {
            pushFollow(FOLLOW_rule__OrExpression__BasicExpressionsAssignment_0_in_rule__OrExpression__Group__0__Impl5525);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2785:1: rule__OrExpression__Group__1 : rule__OrExpression__Group__1__Impl ;
    public final void rule__OrExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2789:1: ( rule__OrExpression__Group__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2790:2: rule__OrExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__OrExpression__Group__1__Impl_in_rule__OrExpression__Group__15555);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2796:1: rule__OrExpression__Group__1__Impl : ( ( rule__OrExpression__Group_1__0 )* ) ;
    public final void rule__OrExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2800:1: ( ( ( rule__OrExpression__Group_1__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2801:1: ( ( rule__OrExpression__Group_1__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2801:1: ( ( rule__OrExpression__Group_1__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2802:1: ( rule__OrExpression__Group_1__0 )*
            {
             before(grammarAccess.getOrExpressionAccess().getGroup_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2803:1: ( rule__OrExpression__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==33) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2803:2: rule__OrExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__OrExpression__Group_1__0_in_rule__OrExpression__Group__1__Impl5582);
            	    rule__OrExpression__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2817:1: rule__OrExpression__Group_1__0 : rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1 ;
    public final void rule__OrExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2821:1: ( rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2822:2: rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__OrExpression__Group_1__0__Impl_in_rule__OrExpression__Group_1__05617);
            rule__OrExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OrExpression__Group_1__1_in_rule__OrExpression__Group_1__05620);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2829:1: rule__OrExpression__Group_1__0__Impl : ( '||' ) ;
    public final void rule__OrExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2833:1: ( ( '||' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2834:1: ( '||' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2834:1: ( '||' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2835:1: '||'
            {
             before(grammarAccess.getOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_0()); 
            match(input,33,FOLLOW_33_in_rule__OrExpression__Group_1__0__Impl5648); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2848:1: rule__OrExpression__Group_1__1 : rule__OrExpression__Group_1__1__Impl ;
    public final void rule__OrExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2852:1: ( rule__OrExpression__Group_1__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2853:2: rule__OrExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__OrExpression__Group_1__1__Impl_in_rule__OrExpression__Group_1__15679);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2859:1: rule__OrExpression__Group_1__1__Impl : ( ( rule__OrExpression__BasicExpressionsAssignment_1_1 ) ) ;
    public final void rule__OrExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2863:1: ( ( ( rule__OrExpression__BasicExpressionsAssignment_1_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2864:1: ( ( rule__OrExpression__BasicExpressionsAssignment_1_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2864:1: ( ( rule__OrExpression__BasicExpressionsAssignment_1_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2865:1: ( rule__OrExpression__BasicExpressionsAssignment_1_1 )
            {
             before(grammarAccess.getOrExpressionAccess().getBasicExpressionsAssignment_1_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2866:1: ( rule__OrExpression__BasicExpressionsAssignment_1_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2866:2: rule__OrExpression__BasicExpressionsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__OrExpression__BasicExpressionsAssignment_1_1_in_rule__OrExpression__Group_1__1__Impl5706);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2880:1: rule__BasicExpression__Group__0 : rule__BasicExpression__Group__0__Impl rule__BasicExpression__Group__1 ;
    public final void rule__BasicExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2884:1: ( rule__BasicExpression__Group__0__Impl rule__BasicExpression__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2885:2: rule__BasicExpression__Group__0__Impl rule__BasicExpression__Group__1
            {
            pushFollow(FOLLOW_rule__BasicExpression__Group__0__Impl_in_rule__BasicExpression__Group__05740);
            rule__BasicExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BasicExpression__Group__1_in_rule__BasicExpression__Group__05743);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2892:1: rule__BasicExpression__Group__0__Impl : ( ( rule__BasicExpression__NegatedAssignment_0 )? ) ;
    public final void rule__BasicExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2896:1: ( ( ( rule__BasicExpression__NegatedAssignment_0 )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2897:1: ( ( rule__BasicExpression__NegatedAssignment_0 )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2897:1: ( ( rule__BasicExpression__NegatedAssignment_0 )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2898:1: ( rule__BasicExpression__NegatedAssignment_0 )?
            {
             before(grammarAccess.getBasicExpressionAccess().getNegatedAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2899:1: ( rule__BasicExpression__NegatedAssignment_0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==38) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2899:2: rule__BasicExpression__NegatedAssignment_0
                    {
                    pushFollow(FOLLOW_rule__BasicExpression__NegatedAssignment_0_in_rule__BasicExpression__Group__0__Impl5770);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2909:1: rule__BasicExpression__Group__1 : rule__BasicExpression__Group__1__Impl ;
    public final void rule__BasicExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2913:1: ( rule__BasicExpression__Group__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2914:2: rule__BasicExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__BasicExpression__Group__1__Impl_in_rule__BasicExpression__Group__15801);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2920:1: rule__BasicExpression__Group__1__Impl : ( ( rule__BasicExpression__ExprAssignment_1 ) ) ;
    public final void rule__BasicExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2924:1: ( ( ( rule__BasicExpression__ExprAssignment_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2925:1: ( ( rule__BasicExpression__ExprAssignment_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2925:1: ( ( rule__BasicExpression__ExprAssignment_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2926:1: ( rule__BasicExpression__ExprAssignment_1 )
            {
             before(grammarAccess.getBasicExpressionAccess().getExprAssignment_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2927:1: ( rule__BasicExpression__ExprAssignment_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2927:2: rule__BasicExpression__ExprAssignment_1
            {
            pushFollow(FOLLOW_rule__BasicExpression__ExprAssignment_1_in_rule__BasicExpression__Group__1__Impl5828);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2941:1: rule__MutexSet__Group__0 : rule__MutexSet__Group__0__Impl rule__MutexSet__Group__1 ;
    public final void rule__MutexSet__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2945:1: ( rule__MutexSet__Group__0__Impl rule__MutexSet__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2946:2: rule__MutexSet__Group__0__Impl rule__MutexSet__Group__1
            {
            pushFollow(FOLLOW_rule__MutexSet__Group__0__Impl_in_rule__MutexSet__Group__05862);
            rule__MutexSet__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MutexSet__Group__1_in_rule__MutexSet__Group__05865);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2953:1: rule__MutexSet__Group__0__Impl : ( 'mutex' ) ;
    public final void rule__MutexSet__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2957:1: ( ( 'mutex' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2958:1: ( 'mutex' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2958:1: ( 'mutex' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2959:1: 'mutex'
            {
             before(grammarAccess.getMutexSetAccess().getMutexKeyword_0()); 
            match(input,34,FOLLOW_34_in_rule__MutexSet__Group__0__Impl5893); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2972:1: rule__MutexSet__Group__1 : rule__MutexSet__Group__1__Impl rule__MutexSet__Group__2 ;
    public final void rule__MutexSet__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2976:1: ( rule__MutexSet__Group__1__Impl rule__MutexSet__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2977:2: rule__MutexSet__Group__1__Impl rule__MutexSet__Group__2
            {
            pushFollow(FOLLOW_rule__MutexSet__Group__1__Impl_in_rule__MutexSet__Group__15924);
            rule__MutexSet__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MutexSet__Group__2_in_rule__MutexSet__Group__15927);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2984:1: rule__MutexSet__Group__1__Impl : ( '{' ) ;
    public final void rule__MutexSet__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2988:1: ( ( '{' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2989:1: ( '{' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2989:1: ( '{' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:2990:1: '{'
            {
             before(grammarAccess.getMutexSetAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,16,FOLLOW_16_in_rule__MutexSet__Group__1__Impl5955); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3003:1: rule__MutexSet__Group__2 : rule__MutexSet__Group__2__Impl rule__MutexSet__Group__3 ;
    public final void rule__MutexSet__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3007:1: ( rule__MutexSet__Group__2__Impl rule__MutexSet__Group__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3008:2: rule__MutexSet__Group__2__Impl rule__MutexSet__Group__3
            {
            pushFollow(FOLLOW_rule__MutexSet__Group__2__Impl_in_rule__MutexSet__Group__25986);
            rule__MutexSet__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MutexSet__Group__3_in_rule__MutexSet__Group__25989);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3015:1: rule__MutexSet__Group__2__Impl : ( ( rule__MutexSet__MethodsAssignment_2 ) ) ;
    public final void rule__MutexSet__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3019:1: ( ( ( rule__MutexSet__MethodsAssignment_2 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3020:1: ( ( rule__MutexSet__MethodsAssignment_2 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3020:1: ( ( rule__MutexSet__MethodsAssignment_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3021:1: ( rule__MutexSet__MethodsAssignment_2 )
            {
             before(grammarAccess.getMutexSetAccess().getMethodsAssignment_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3022:1: ( rule__MutexSet__MethodsAssignment_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3022:2: rule__MutexSet__MethodsAssignment_2
            {
            pushFollow(FOLLOW_rule__MutexSet__MethodsAssignment_2_in_rule__MutexSet__Group__2__Impl6016);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3032:1: rule__MutexSet__Group__3 : rule__MutexSet__Group__3__Impl rule__MutexSet__Group__4 ;
    public final void rule__MutexSet__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3036:1: ( rule__MutexSet__Group__3__Impl rule__MutexSet__Group__4 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3037:2: rule__MutexSet__Group__3__Impl rule__MutexSet__Group__4
            {
            pushFollow(FOLLOW_rule__MutexSet__Group__3__Impl_in_rule__MutexSet__Group__36046);
            rule__MutexSet__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MutexSet__Group__4_in_rule__MutexSet__Group__36049);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3044:1: rule__MutexSet__Group__3__Impl : ( ( ( rule__MutexSet__Group_3__0 ) ) ( ( rule__MutexSet__Group_3__0 )* ) ) ;
    public final void rule__MutexSet__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3048:1: ( ( ( ( rule__MutexSet__Group_3__0 ) ) ( ( rule__MutexSet__Group_3__0 )* ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3049:1: ( ( ( rule__MutexSet__Group_3__0 ) ) ( ( rule__MutexSet__Group_3__0 )* ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3049:1: ( ( ( rule__MutexSet__Group_3__0 ) ) ( ( rule__MutexSet__Group_3__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3050:1: ( ( rule__MutexSet__Group_3__0 ) ) ( ( rule__MutexSet__Group_3__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3050:1: ( ( rule__MutexSet__Group_3__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3051:1: ( rule__MutexSet__Group_3__0 )
            {
             before(grammarAccess.getMutexSetAccess().getGroup_3()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3052:1: ( rule__MutexSet__Group_3__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3052:2: rule__MutexSet__Group_3__0
            {
            pushFollow(FOLLOW_rule__MutexSet__Group_3__0_in_rule__MutexSet__Group__3__Impl6078);
            rule__MutexSet__Group_3__0();

            state._fsp--;


            }

             after(grammarAccess.getMutexSetAccess().getGroup_3()); 

            }

            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3055:1: ( ( rule__MutexSet__Group_3__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3056:1: ( rule__MutexSet__Group_3__0 )*
            {
             before(grammarAccess.getMutexSetAccess().getGroup_3()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3057:1: ( rule__MutexSet__Group_3__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==20) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3057:2: rule__MutexSet__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__MutexSet__Group_3__0_in_rule__MutexSet__Group__3__Impl6090);
            	    rule__MutexSet__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3068:1: rule__MutexSet__Group__4 : rule__MutexSet__Group__4__Impl ;
    public final void rule__MutexSet__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3072:1: ( rule__MutexSet__Group__4__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3073:2: rule__MutexSet__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__MutexSet__Group__4__Impl_in_rule__MutexSet__Group__46123);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3079:1: rule__MutexSet__Group__4__Impl : ( '};' ) ;
    public final void rule__MutexSet__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3083:1: ( ( '};' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3084:1: ( '};' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3084:1: ( '};' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3085:1: '};'
            {
             before(grammarAccess.getMutexSetAccess().getRightCurlyBracketSemicolonKeyword_4()); 
            match(input,35,FOLLOW_35_in_rule__MutexSet__Group__4__Impl6151); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3108:1: rule__MutexSet__Group_3__0 : rule__MutexSet__Group_3__0__Impl rule__MutexSet__Group_3__1 ;
    public final void rule__MutexSet__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3112:1: ( rule__MutexSet__Group_3__0__Impl rule__MutexSet__Group_3__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3113:2: rule__MutexSet__Group_3__0__Impl rule__MutexSet__Group_3__1
            {
            pushFollow(FOLLOW_rule__MutexSet__Group_3__0__Impl_in_rule__MutexSet__Group_3__06192);
            rule__MutexSet__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MutexSet__Group_3__1_in_rule__MutexSet__Group_3__06195);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3120:1: rule__MutexSet__Group_3__0__Impl : ( ',' ) ;
    public final void rule__MutexSet__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3124:1: ( ( ',' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3125:1: ( ',' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3125:1: ( ',' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3126:1: ','
            {
             before(grammarAccess.getMutexSetAccess().getCommaKeyword_3_0()); 
            match(input,20,FOLLOW_20_in_rule__MutexSet__Group_3__0__Impl6223); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3139:1: rule__MutexSet__Group_3__1 : rule__MutexSet__Group_3__1__Impl ;
    public final void rule__MutexSet__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3143:1: ( rule__MutexSet__Group_3__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3144:2: rule__MutexSet__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__MutexSet__Group_3__1__Impl_in_rule__MutexSet__Group_3__16254);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3150:1: rule__MutexSet__Group_3__1__Impl : ( ( rule__MutexSet__MethodsAssignment_3_1 ) ) ;
    public final void rule__MutexSet__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3154:1: ( ( ( rule__MutexSet__MethodsAssignment_3_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3155:1: ( ( rule__MutexSet__MethodsAssignment_3_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3155:1: ( ( rule__MutexSet__MethodsAssignment_3_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3156:1: ( rule__MutexSet__MethodsAssignment_3_1 )
            {
             before(grammarAccess.getMutexSetAccess().getMethodsAssignment_3_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3157:1: ( rule__MutexSet__MethodsAssignment_3_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3157:2: rule__MutexSet__MethodsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__MutexSet__MethodsAssignment_3_1_in_rule__MutexSet__Group_3__1__Impl6281);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3171:1: rule__CondVar__Group__0 : rule__CondVar__Group__0__Impl rule__CondVar__Group__1 ;
    public final void rule__CondVar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3175:1: ( rule__CondVar__Group__0__Impl rule__CondVar__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3176:2: rule__CondVar__Group__0__Impl rule__CondVar__Group__1
            {
            pushFollow(FOLLOW_rule__CondVar__Group__0__Impl_in_rule__CondVar__Group__06315);
            rule__CondVar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CondVar__Group__1_in_rule__CondVar__Group__06318);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3183:1: rule__CondVar__Group__0__Impl : ( ( rule__CondVar__NameAssignment_0 ) ) ;
    public final void rule__CondVar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3187:1: ( ( ( rule__CondVar__NameAssignment_0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3188:1: ( ( rule__CondVar__NameAssignment_0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3188:1: ( ( rule__CondVar__NameAssignment_0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3189:1: ( rule__CondVar__NameAssignment_0 )
            {
             before(grammarAccess.getCondVarAccess().getNameAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3190:1: ( rule__CondVar__NameAssignment_0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3190:2: rule__CondVar__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__CondVar__NameAssignment_0_in_rule__CondVar__Group__0__Impl6345);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3200:1: rule__CondVar__Group__1 : rule__CondVar__Group__1__Impl rule__CondVar__Group__2 ;
    public final void rule__CondVar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3204:1: ( rule__CondVar__Group__1__Impl rule__CondVar__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3205:2: rule__CondVar__Group__1__Impl rule__CondVar__Group__2
            {
            pushFollow(FOLLOW_rule__CondVar__Group__1__Impl_in_rule__CondVar__Group__16375);
            rule__CondVar__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CondVar__Group__2_in_rule__CondVar__Group__16378);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3212:1: rule__CondVar__Group__1__Impl : ( '=' ) ;
    public final void rule__CondVar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3216:1: ( ( '=' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3217:1: ( '=' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3217:1: ( '=' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3218:1: '='
            {
             before(grammarAccess.getCondVarAccess().getEqualsSignKeyword_1()); 
            match(input,30,FOLLOW_30_in_rule__CondVar__Group__1__Impl6406); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3231:1: rule__CondVar__Group__2 : rule__CondVar__Group__2__Impl ;
    public final void rule__CondVar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3235:1: ( rule__CondVar__Group__2__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3236:2: rule__CondVar__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__CondVar__Group__2__Impl_in_rule__CondVar__Group__26437);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3242:1: rule__CondVar__Group__2__Impl : ( ( rule__CondVar__ValueAssignment_2 ) ) ;
    public final void rule__CondVar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3246:1: ( ( ( rule__CondVar__ValueAssignment_2 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3247:1: ( ( rule__CondVar__ValueAssignment_2 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3247:1: ( ( rule__CondVar__ValueAssignment_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3248:1: ( rule__CondVar__ValueAssignment_2 )
            {
             before(grammarAccess.getCondVarAccess().getValueAssignment_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3249:1: ( rule__CondVar__ValueAssignment_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3249:2: rule__CondVar__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__CondVar__ValueAssignment_2_in_rule__CondVar__Group__2__Impl6464);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3265:1: rule__OrdVar__Group__0 : rule__OrdVar__Group__0__Impl rule__OrdVar__Group__1 ;
    public final void rule__OrdVar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3269:1: ( rule__OrdVar__Group__0__Impl rule__OrdVar__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3270:2: rule__OrdVar__Group__0__Impl rule__OrdVar__Group__1
            {
            pushFollow(FOLLOW_rule__OrdVar__Group__0__Impl_in_rule__OrdVar__Group__06500);
            rule__OrdVar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OrdVar__Group__1_in_rule__OrdVar__Group__06503);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3277:1: rule__OrdVar__Group__0__Impl : ( ( rule__OrdVar__NameAssignment_0 ) ) ;
    public final void rule__OrdVar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3281:1: ( ( ( rule__OrdVar__NameAssignment_0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3282:1: ( ( rule__OrdVar__NameAssignment_0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3282:1: ( ( rule__OrdVar__NameAssignment_0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3283:1: ( rule__OrdVar__NameAssignment_0 )
            {
             before(grammarAccess.getOrdVarAccess().getNameAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3284:1: ( rule__OrdVar__NameAssignment_0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3284:2: rule__OrdVar__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__OrdVar__NameAssignment_0_in_rule__OrdVar__Group__0__Impl6530);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3294:1: rule__OrdVar__Group__1 : rule__OrdVar__Group__1__Impl rule__OrdVar__Group__2 ;
    public final void rule__OrdVar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3298:1: ( rule__OrdVar__Group__1__Impl rule__OrdVar__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3299:2: rule__OrdVar__Group__1__Impl rule__OrdVar__Group__2
            {
            pushFollow(FOLLOW_rule__OrdVar__Group__1__Impl_in_rule__OrdVar__Group__16560);
            rule__OrdVar__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OrdVar__Group__2_in_rule__OrdVar__Group__16563);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3306:1: rule__OrdVar__Group__1__Impl : ( '=' ) ;
    public final void rule__OrdVar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3310:1: ( ( '=' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3311:1: ( '=' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3311:1: ( '=' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3312:1: '='
            {
             before(grammarAccess.getOrdVarAccess().getEqualsSignKeyword_1()); 
            match(input,30,FOLLOW_30_in_rule__OrdVar__Group__1__Impl6591); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3325:1: rule__OrdVar__Group__2 : rule__OrdVar__Group__2__Impl ;
    public final void rule__OrdVar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3329:1: ( rule__OrdVar__Group__2__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3330:2: rule__OrdVar__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__OrdVar__Group__2__Impl_in_rule__OrdVar__Group__26622);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3336:1: rule__OrdVar__Group__2__Impl : ( ( rule__OrdVar__ValueAssignment_2 ) ) ;
    public final void rule__OrdVar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3340:1: ( ( ( rule__OrdVar__ValueAssignment_2 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3341:1: ( ( rule__OrdVar__ValueAssignment_2 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3341:1: ( ( rule__OrdVar__ValueAssignment_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3342:1: ( rule__OrdVar__ValueAssignment_2 )
            {
             before(grammarAccess.getOrdVarAccess().getValueAssignment_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3343:1: ( rule__OrdVar__ValueAssignment_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3343:2: rule__OrdVar__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__OrdVar__ValueAssignment_2_in_rule__OrdVar__Group__2__Impl6649);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3359:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3363:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3364:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__06685);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__06688);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3371:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3375:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3376:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3376:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3377:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl6715); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3388:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3392:1: ( rule__QualifiedName__Group__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3393:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__16744);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3399:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3403:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3404:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3404:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3405:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3406:1: ( rule__QualifiedName__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==36) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3406:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl6771);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3420:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3424:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3425:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__06806);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__06809);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3432:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3436:1: ( ( '.' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3437:1: ( '.' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3437:1: ( '.' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3438:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,36,FOLLOW_36_in_rule__QualifiedName__Group_1__0__Impl6837); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3451:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3455:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3456:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__16868);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3462:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3466:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3467:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3467:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3468:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl6895); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3484:1: rule__CoordinatorDeclaration__GranularityAssignment_0 : ( ( 'per_class' ) ) ;
    public final void rule__CoordinatorDeclaration__GranularityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3488:1: ( ( ( 'per_class' ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3489:1: ( ( 'per_class' ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3489:1: ( ( 'per_class' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3490:1: ( 'per_class' )
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getGranularityPer_classKeyword_0_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3491:1: ( 'per_class' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3492:1: 'per_class'
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getGranularityPer_classKeyword_0_0()); 
            match(input,37,FOLLOW_37_in_rule__CoordinatorDeclaration__GranularityAssignment_06938); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3507:1: rule__CoordinatorDeclaration__ClassNameAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__CoordinatorDeclaration__ClassNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3511:1: ( ( ruleQualifiedName ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3512:1: ( ruleQualifiedName )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3512:1: ( ruleQualifiedName )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3513:1: ruleQualifiedName
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getClassNameQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__CoordinatorDeclaration__ClassNameAssignment_26977);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3522:1: rule__CoordinatorDeclaration__BodyAssignment_3 : ( ruleCoordinatorBody ) ;
    public final void rule__CoordinatorDeclaration__BodyAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3526:1: ( ( ruleCoordinatorBody ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3527:1: ( ruleCoordinatorBody )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3527:1: ( ruleCoordinatorBody )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3528:1: ruleCoordinatorBody
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getBodyCoordinatorBodyParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleCoordinatorBody_in_rule__CoordinatorDeclaration__BodyAssignment_37008);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3537:1: rule__CoordinatorBody__CondVarsAssignment_2_1 : ( ruleCondVar ) ;
    public final void rule__CoordinatorBody__CondVarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3541:1: ( ( ruleCondVar ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3542:1: ( ruleCondVar )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3542:1: ( ruleCondVar )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3543:1: ruleCondVar
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCondVarsCondVarParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleCondVar_in_rule__CoordinatorBody__CondVarsAssignment_2_17039);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3552:1: rule__CoordinatorBody__CondVarsAssignment_2_2_1 : ( ruleCondVar ) ;
    public final void rule__CoordinatorBody__CondVarsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3556:1: ( ( ruleCondVar ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3557:1: ( ruleCondVar )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3557:1: ( ruleCondVar )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3558:1: ruleCondVar
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCondVarsCondVarParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_ruleCondVar_in_rule__CoordinatorBody__CondVarsAssignment_2_2_17070);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3567:1: rule__CoordinatorBody__OrdVarsAssignment_3_1 : ( ruleOrdVar ) ;
    public final void rule__CoordinatorBody__OrdVarsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3571:1: ( ( ruleOrdVar ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3572:1: ( ruleOrdVar )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3572:1: ( ruleOrdVar )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3573:1: ruleOrdVar
            {
             before(grammarAccess.getCoordinatorBodyAccess().getOrdVarsOrdVarParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleOrdVar_in_rule__CoordinatorBody__OrdVarsAssignment_3_17101);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3582:1: rule__CoordinatorBody__OrdVarsAssignment_3_2_1 : ( ruleOrdVar ) ;
    public final void rule__CoordinatorBody__OrdVarsAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3586:1: ( ( ruleOrdVar ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3587:1: ( ruleOrdVar )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3587:1: ( ruleOrdVar )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3588:1: ruleOrdVar
            {
             before(grammarAccess.getCoordinatorBodyAccess().getOrdVarsOrdVarParserRuleCall_3_2_1_0()); 
            pushFollow(FOLLOW_ruleOrdVar_in_rule__CoordinatorBody__OrdVarsAssignment_3_2_17132);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3597:1: rule__CoordinatorBody__SelfexMethodsAssignment_4_1 : ( ruleQualifiedName ) ;
    public final void rule__CoordinatorBody__SelfexMethodsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3601:1: ( ( ruleQualifiedName ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3602:1: ( ruleQualifiedName )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3602:1: ( ruleQualifiedName )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3603:1: ruleQualifiedName
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsQualifiedNameParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__CoordinatorBody__SelfexMethodsAssignment_4_17163);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3612:1: rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 : ( ruleQualifiedName ) ;
    public final void rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3616:1: ( ( ruleQualifiedName ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3617:1: ( ruleQualifiedName )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3617:1: ( ruleQualifiedName )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3618:1: ruleQualifiedName
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsQualifiedNameParserRuleCall_4_2_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__CoordinatorBody__SelfexMethodsAssignment_4_2_17194);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3627:1: rule__CoordinatorBody__MutexSetsAssignment_5 : ( ruleMutexSet ) ;
    public final void rule__CoordinatorBody__MutexSetsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3631:1: ( ( ruleMutexSet ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3632:1: ( ruleMutexSet )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3632:1: ( ruleMutexSet )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3633:1: ruleMutexSet
            {
             before(grammarAccess.getCoordinatorBodyAccess().getMutexSetsMutexSetParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleMutexSet_in_rule__CoordinatorBody__MutexSetsAssignment_57225);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3642:1: rule__CoordinatorBody__GuardsAssignment_6 : ( ruleGuard ) ;
    public final void rule__CoordinatorBody__GuardsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3646:1: ( ( ruleGuard ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3647:1: ( ruleGuard )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3647:1: ( ruleGuard )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3648:1: ruleGuard
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGuardsGuardParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleGuard_in_rule__CoordinatorBody__GuardsAssignment_67256);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3657:1: rule__Guard__MethodsAssignment_1 : ( RULE_ID ) ;
    public final void rule__Guard__MethodsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3661:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3662:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3662:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3663:1: RULE_ID
            {
             before(grammarAccess.getGuardAccess().getMethodsIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Guard__MethodsAssignment_17287); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3672:1: rule__Guard__MethodsAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Guard__MethodsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3676:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3677:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3677:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3678:1: RULE_ID
            {
             before(grammarAccess.getGuardAccess().getMethodsIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Guard__MethodsAssignment_2_17318); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3687:1: rule__Guard__RequiresAssignment_4 : ( ruleRequires ) ;
    public final void rule__Guard__RequiresAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3691:1: ( ( ruleRequires ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3692:1: ( ruleRequires )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3692:1: ( ruleRequires )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3693:1: ruleRequires
            {
             before(grammarAccess.getGuardAccess().getRequiresRequiresParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleRequires_in_rule__Guard__RequiresAssignment_47349);
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


    // $ANTLR start "rule__Guard__OnEntryIfStatementsAssignment_5_2_0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3702:1: rule__Guard__OnEntryIfStatementsAssignment_5_2_0 : ( ruleIfStatement ) ;
    public final void rule__Guard__OnEntryIfStatementsAssignment_5_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3706:1: ( ( ruleIfStatement ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3707:1: ( ruleIfStatement )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3707:1: ( ruleIfStatement )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3708:1: ruleIfStatement
            {
             before(grammarAccess.getGuardAccess().getOnEntryIfStatementsIfStatementParserRuleCall_5_2_0_0()); 
            pushFollow(FOLLOW_ruleIfStatement_in_rule__Guard__OnEntryIfStatementsAssignment_5_2_07380);
            ruleIfStatement();

            state._fsp--;

             after(grammarAccess.getGuardAccess().getOnEntryIfStatementsIfStatementParserRuleCall_5_2_0_0()); 

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
    // $ANTLR end "rule__Guard__OnEntryIfStatementsAssignment_5_2_0"


    // $ANTLR start "rule__Guard__OnEntryAssignStatementsAssignment_5_2_1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3717:1: rule__Guard__OnEntryAssignStatementsAssignment_5_2_1 : ( ruleAssignStatement ) ;
    public final void rule__Guard__OnEntryAssignStatementsAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3721:1: ( ( ruleAssignStatement ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3722:1: ( ruleAssignStatement )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3722:1: ( ruleAssignStatement )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3723:1: ruleAssignStatement
            {
             before(grammarAccess.getGuardAccess().getOnEntryAssignStatementsAssignStatementParserRuleCall_5_2_1_0()); 
            pushFollow(FOLLOW_ruleAssignStatement_in_rule__Guard__OnEntryAssignStatementsAssignment_5_2_17411);
            ruleAssignStatement();

            state._fsp--;

             after(grammarAccess.getGuardAccess().getOnEntryAssignStatementsAssignStatementParserRuleCall_5_2_1_0()); 

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
    // $ANTLR end "rule__Guard__OnEntryAssignStatementsAssignment_5_2_1"


    // $ANTLR start "rule__Guard__OnExitIfStatementsAssignment_6_2_0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3732:1: rule__Guard__OnExitIfStatementsAssignment_6_2_0 : ( ruleIfStatement ) ;
    public final void rule__Guard__OnExitIfStatementsAssignment_6_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3736:1: ( ( ruleIfStatement ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3737:1: ( ruleIfStatement )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3737:1: ( ruleIfStatement )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3738:1: ruleIfStatement
            {
             before(grammarAccess.getGuardAccess().getOnExitIfStatementsIfStatementParserRuleCall_6_2_0_0()); 
            pushFollow(FOLLOW_ruleIfStatement_in_rule__Guard__OnExitIfStatementsAssignment_6_2_07442);
            ruleIfStatement();

            state._fsp--;

             after(grammarAccess.getGuardAccess().getOnExitIfStatementsIfStatementParserRuleCall_6_2_0_0()); 

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
    // $ANTLR end "rule__Guard__OnExitIfStatementsAssignment_6_2_0"


    // $ANTLR start "rule__Guard__OnExitAssignStatementsAssignment_6_2_1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3747:1: rule__Guard__OnExitAssignStatementsAssignment_6_2_1 : ( ruleAssignStatement ) ;
    public final void rule__Guard__OnExitAssignStatementsAssignment_6_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3751:1: ( ( ruleAssignStatement ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3752:1: ( ruleAssignStatement )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3752:1: ( ruleAssignStatement )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3753:1: ruleAssignStatement
            {
             before(grammarAccess.getGuardAccess().getOnExitAssignStatementsAssignStatementParserRuleCall_6_2_1_0()); 
            pushFollow(FOLLOW_ruleAssignStatement_in_rule__Guard__OnExitAssignStatementsAssignment_6_2_17473);
            ruleAssignStatement();

            state._fsp--;

             after(grammarAccess.getGuardAccess().getOnExitAssignStatementsAssignStatementParserRuleCall_6_2_1_0()); 

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
    // $ANTLR end "rule__Guard__OnExitAssignStatementsAssignment_6_2_1"


    // $ANTLR start "rule__IfStatement__ExpressionAssignment_2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3762:1: rule__IfStatement__ExpressionAssignment_2 : ( ruleIfExpression ) ;
    public final void rule__IfStatement__ExpressionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3766:1: ( ( ruleIfExpression ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3767:1: ( ruleIfExpression )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3767:1: ( ruleIfExpression )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3768:1: ruleIfExpression
            {
             before(grammarAccess.getIfStatementAccess().getExpressionIfExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleIfExpression_in_rule__IfStatement__ExpressionAssignment_27504);
            ruleIfExpression();

            state._fsp--;

             after(grammarAccess.getIfStatementAccess().getExpressionIfExpressionParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__IfStatement__ExpressionAssignment_2"


    // $ANTLR start "rule__IfStatement__StatementAssignment_4"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3777:1: rule__IfStatement__StatementAssignment_4 : ( ruleAssignStatement ) ;
    public final void rule__IfStatement__StatementAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3781:1: ( ( ruleAssignStatement ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3782:1: ( ruleAssignStatement )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3782:1: ( ruleAssignStatement )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3783:1: ruleAssignStatement
            {
             before(grammarAccess.getIfStatementAccess().getStatementAssignStatementParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleAssignStatement_in_rule__IfStatement__StatementAssignment_47535);
            ruleAssignStatement();

            state._fsp--;

             after(grammarAccess.getIfStatementAccess().getStatementAssignStatementParserRuleCall_4_0()); 

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
    // $ANTLR end "rule__IfStatement__StatementAssignment_4"


    // $ANTLR start "rule__IfExpression__VarAssignment_0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3792:1: rule__IfExpression__VarAssignment_0 : ( RULE_ID ) ;
    public final void rule__IfExpression__VarAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3796:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3797:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3797:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3798:1: RULE_ID
            {
             before(grammarAccess.getIfExpressionAccess().getVarIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IfExpression__VarAssignment_07566); 
             after(grammarAccess.getIfExpressionAccess().getVarIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__IfExpression__VarAssignment_0"


    // $ANTLR start "rule__IfExpression__OpAssignment_1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3807:1: rule__IfExpression__OpAssignment_1 : ( ( rule__IfExpression__OpAlternatives_1_0 ) ) ;
    public final void rule__IfExpression__OpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3811:1: ( ( ( rule__IfExpression__OpAlternatives_1_0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3812:1: ( ( rule__IfExpression__OpAlternatives_1_0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3812:1: ( ( rule__IfExpression__OpAlternatives_1_0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3813:1: ( rule__IfExpression__OpAlternatives_1_0 )
            {
             before(grammarAccess.getIfExpressionAccess().getOpAlternatives_1_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3814:1: ( rule__IfExpression__OpAlternatives_1_0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3814:2: rule__IfExpression__OpAlternatives_1_0
            {
            pushFollow(FOLLOW_rule__IfExpression__OpAlternatives_1_0_in_rule__IfExpression__OpAssignment_17597);
            rule__IfExpression__OpAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getIfExpressionAccess().getOpAlternatives_1_0()); 

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
    // $ANTLR end "rule__IfExpression__OpAssignment_1"


    // $ANTLR start "rule__IfExpression__AssignmentAssignment_2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3823:1: rule__IfExpression__AssignmentAssignment_2 : ( ruleAssignedValue ) ;
    public final void rule__IfExpression__AssignmentAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3827:1: ( ( ruleAssignedValue ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3828:1: ( ruleAssignedValue )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3828:1: ( ruleAssignedValue )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3829:1: ruleAssignedValue
            {
             before(grammarAccess.getIfExpressionAccess().getAssignmentAssignedValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleAssignedValue_in_rule__IfExpression__AssignmentAssignment_27630);
            ruleAssignedValue();

            state._fsp--;

             after(grammarAccess.getIfExpressionAccess().getAssignmentAssignedValueParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__IfExpression__AssignmentAssignment_2"


    // $ANTLR start "rule__AssignedValue__IntvalAssignment_0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3838:1: rule__AssignedValue__IntvalAssignment_0 : ( RULE_INT ) ;
    public final void rule__AssignedValue__IntvalAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3842:1: ( ( RULE_INT ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3843:1: ( RULE_INT )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3843:1: ( RULE_INT )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3844:1: RULE_INT
            {
             before(grammarAccess.getAssignedValueAccess().getIntvalINTTerminalRuleCall_0_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AssignedValue__IntvalAssignment_07661); 
             after(grammarAccess.getAssignedValueAccess().getIntvalINTTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__AssignedValue__IntvalAssignment_0"


    // $ANTLR start "rule__AssignedValue__BoolvalAssignment_1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3853:1: rule__AssignedValue__BoolvalAssignment_1 : ( ( rule__AssignedValue__BoolvalAlternatives_1_0 ) ) ;
    public final void rule__AssignedValue__BoolvalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3857:1: ( ( ( rule__AssignedValue__BoolvalAlternatives_1_0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3858:1: ( ( rule__AssignedValue__BoolvalAlternatives_1_0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3858:1: ( ( rule__AssignedValue__BoolvalAlternatives_1_0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3859:1: ( rule__AssignedValue__BoolvalAlternatives_1_0 )
            {
             before(grammarAccess.getAssignedValueAccess().getBoolvalAlternatives_1_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3860:1: ( rule__AssignedValue__BoolvalAlternatives_1_0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3860:2: rule__AssignedValue__BoolvalAlternatives_1_0
            {
            pushFollow(FOLLOW_rule__AssignedValue__BoolvalAlternatives_1_0_in_rule__AssignedValue__BoolvalAssignment_17692);
            rule__AssignedValue__BoolvalAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getAssignedValueAccess().getBoolvalAlternatives_1_0()); 

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
    // $ANTLR end "rule__AssignedValue__BoolvalAssignment_1"


    // $ANTLR start "rule__AssignStatement__VarAssignment_0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3869:1: rule__AssignStatement__VarAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__AssignStatement__VarAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3873:1: ( ( ( RULE_ID ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3874:1: ( ( RULE_ID ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3874:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3875:1: ( RULE_ID )
            {
             before(grammarAccess.getAssignStatementAccess().getVarCondVarCrossReference_0_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3876:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3877:1: RULE_ID
            {
             before(grammarAccess.getAssignStatementAccess().getVarCondVarIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AssignStatement__VarAssignment_07729); 
             after(grammarAccess.getAssignStatementAccess().getVarCondVarIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getAssignStatementAccess().getVarCondVarCrossReference_0_0()); 

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
    // $ANTLR end "rule__AssignStatement__VarAssignment_0"


    // $ANTLR start "rule__AssignStatement__ValueAssignment_2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3888:1: rule__AssignStatement__ValueAssignment_2 : ( ruleBooleanVal ) ;
    public final void rule__AssignStatement__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3892:1: ( ( ruleBooleanVal ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3893:1: ( ruleBooleanVal )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3893:1: ( ruleBooleanVal )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3894:1: ruleBooleanVal
            {
             before(grammarAccess.getAssignStatementAccess().getValueBooleanValParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleBooleanVal_in_rule__AssignStatement__ValueAssignment_27764);
            ruleBooleanVal();

            state._fsp--;

             after(grammarAccess.getAssignStatementAccess().getValueBooleanValParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__AssignStatement__ValueAssignment_2"


    // $ANTLR start "rule__Requires__AndExpressionAssignment_1"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3903:1: rule__Requires__AndExpressionAssignment_1 : ( ruleAndExpression ) ;
    public final void rule__Requires__AndExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3907:1: ( ( ruleAndExpression ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3908:1: ( ruleAndExpression )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3908:1: ( ruleAndExpression )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3909:1: ruleAndExpression
            {
             before(grammarAccess.getRequiresAccess().getAndExpressionAndExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleAndExpression_in_rule__Requires__AndExpressionAssignment_17795);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3918:1: rule__AndExpression__OrExpressionsAssignment_0 : ( ruleOrExpression ) ;
    public final void rule__AndExpression__OrExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3922:1: ( ( ruleOrExpression ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3923:1: ( ruleOrExpression )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3923:1: ( ruleOrExpression )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3924:1: ruleOrExpression
            {
             before(grammarAccess.getAndExpressionAccess().getOrExpressionsOrExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleOrExpression_in_rule__AndExpression__OrExpressionsAssignment_07826);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3933:1: rule__AndExpression__OrExpressionsAssignment_1_1 : ( ruleOrExpression ) ;
    public final void rule__AndExpression__OrExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3937:1: ( ( ruleOrExpression ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3938:1: ( ruleOrExpression )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3938:1: ( ruleOrExpression )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3939:1: ruleOrExpression
            {
             before(grammarAccess.getAndExpressionAccess().getOrExpressionsOrExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleOrExpression_in_rule__AndExpression__OrExpressionsAssignment_1_17857);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3948:1: rule__OrExpression__BasicExpressionsAssignment_0 : ( ruleBasicExpression ) ;
    public final void rule__OrExpression__BasicExpressionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3952:1: ( ( ruleBasicExpression ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3953:1: ( ruleBasicExpression )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3953:1: ( ruleBasicExpression )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3954:1: ruleBasicExpression
            {
             before(grammarAccess.getOrExpressionAccess().getBasicExpressionsBasicExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleBasicExpression_in_rule__OrExpression__BasicExpressionsAssignment_07888);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3963:1: rule__OrExpression__BasicExpressionsAssignment_1_1 : ( ruleBasicExpression ) ;
    public final void rule__OrExpression__BasicExpressionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3967:1: ( ( ruleBasicExpression ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3968:1: ( ruleBasicExpression )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3968:1: ( ruleBasicExpression )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3969:1: ruleBasicExpression
            {
             before(grammarAccess.getOrExpressionAccess().getBasicExpressionsBasicExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleBasicExpression_in_rule__OrExpression__BasicExpressionsAssignment_1_17919);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3978:1: rule__BasicExpression__NegatedAssignment_0 : ( ( '!' ) ) ;
    public final void rule__BasicExpression__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3982:1: ( ( ( '!' ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3983:1: ( ( '!' ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3983:1: ( ( '!' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3984:1: ( '!' )
            {
             before(grammarAccess.getBasicExpressionAccess().getNegatedExclamationMarkKeyword_0_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3985:1: ( '!' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:3986:1: '!'
            {
             before(grammarAccess.getBasicExpressionAccess().getNegatedExclamationMarkKeyword_0_0()); 
            match(input,38,FOLLOW_38_in_rule__BasicExpression__NegatedAssignment_07955); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4001:1: rule__BasicExpression__ExprAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__BasicExpression__ExprAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4005:1: ( ( ( RULE_ID ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4006:1: ( ( RULE_ID ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4006:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4007:1: ( RULE_ID )
            {
             before(grammarAccess.getBasicExpressionAccess().getExprCondVarCrossReference_1_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4008:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4009:1: RULE_ID
            {
             before(grammarAccess.getBasicExpressionAccess().getExprCondVarIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__BasicExpression__ExprAssignment_17998); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4020:1: rule__MutexSet__MethodsAssignment_2 : ( RULE_ID ) ;
    public final void rule__MutexSet__MethodsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4024:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4025:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4025:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4026:1: RULE_ID
            {
             before(grammarAccess.getMutexSetAccess().getMethodsIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MutexSet__MethodsAssignment_28033); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4035:1: rule__MutexSet__MethodsAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__MutexSet__MethodsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4039:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4040:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4040:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4041:1: RULE_ID
            {
             before(grammarAccess.getMutexSetAccess().getMethodsIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MutexSet__MethodsAssignment_3_18064); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4050:1: rule__CondVar__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__CondVar__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4054:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4055:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4055:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4056:1: RULE_ID
            {
             before(grammarAccess.getCondVarAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__CondVar__NameAssignment_08095); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4065:1: rule__CondVar__ValueAssignment_2 : ( ruleBooleanVal ) ;
    public final void rule__CondVar__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4069:1: ( ( ruleBooleanVal ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4070:1: ( ruleBooleanVal )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4070:1: ( ruleBooleanVal )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4071:1: ruleBooleanVal
            {
             before(grammarAccess.getCondVarAccess().getValueBooleanValParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleBooleanVal_in_rule__CondVar__ValueAssignment_28126);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4080:1: rule__OrdVar__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__OrdVar__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4084:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4085:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4085:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4086:1: RULE_ID
            {
             before(grammarAccess.getOrdVarAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__OrdVar__NameAssignment_08157); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4095:1: rule__OrdVar__ValueAssignment_2 : ( RULE_INT ) ;
    public final void rule__OrdVar__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4099:1: ( ( RULE_INT ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4100:1: ( RULE_INT )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4100:1: ( RULE_INT )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:4101:1: RULE_INT
            {
             before(grammarAccess.getOrdVarAccess().getValueINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__OrdVar__ValueAssignment_28188); 
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
    public static final BitSet FOLLOW_ruleIfStatement_in_entryRuleIfStatement241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfStatement248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__0_in_ruleIfStatement274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpression_in_entryRuleIfExpression301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfExpression308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfExpression__Group__0_in_ruleIfExpression334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignedValue_in_entryRuleAssignedValue361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignedValue368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignedValue__Alternatives_in_ruleAssignedValue394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignStatement_in_entryRuleAssignStatement421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignStatement428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignStatement__Group__0_in_ruleAssignStatement454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequires_in_entryRuleRequires481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequires488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Requires__Group__0_in_ruleRequires514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_entryRuleAndExpression541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndExpression548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group__0_in_ruleAndExpression574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_entryRuleOrExpression601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrExpression608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group__0_in_ruleOrExpression634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicExpression_in_entryRuleBasicExpression661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicExpression668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicExpression__Group__0_in_ruleBasicExpression694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMutexSet_in_entryRuleMutexSet721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMutexSet728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__0_in_ruleMutexSet754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondVar_in_entryRuleCondVar781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCondVar788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__Group__0_in_ruleCondVar814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrdVar_in_entryRuleOrdVar841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrdVar848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__0_in_ruleOrdVar874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanVal_in_entryRuleBooleanVal901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanVal908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanVal__Alternatives_in_ruleBooleanVal934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__OnEntryIfStatementsAssignment_5_2_0_in_rule__Guard__Alternatives_5_21030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__OnEntryAssignStatementsAssignment_5_2_1_in_rule__Guard__Alternatives_5_21048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__OnExitIfStatementsAssignment_6_2_0_in_rule__Guard__Alternatives_6_21081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__OnExitAssignStatementsAssignment_6_2_1_in_rule__Guard__Alternatives_6_21099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__IfExpression__OpAlternatives_1_01133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__IfExpression__OpAlternatives_1_01153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignedValue__IntvalAssignment_0_in_rule__AssignedValue__Alternatives1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignedValue__BoolvalAssignment_1_in_rule__AssignedValue__Alternatives1205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__AssignedValue__BoolvalAlternatives_1_01239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__AssignedValue__BoolvalAlternatives_1_01259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__BooleanVal__Alternatives1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__BooleanVal__Alternatives1314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__0__Impl_in_rule__CoordinatorDeclaration__Group__01346 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__1_in_rule__CoordinatorDeclaration__Group__01349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__GranularityAssignment_0_in_rule__CoordinatorDeclaration__Group__0__Impl1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__1__Impl_in_rule__CoordinatorDeclaration__Group__11407 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__2_in_rule__CoordinatorDeclaration__Group__11410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__CoordinatorDeclaration__Group__1__Impl1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__2__Impl_in_rule__CoordinatorDeclaration__Group__21469 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__3_in_rule__CoordinatorDeclaration__Group__21472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__ClassNameAssignment_2_in_rule__CoordinatorDeclaration__Group__2__Impl1499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__3__Impl_in_rule__CoordinatorDeclaration__Group__31529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__BodyAssignment_3_in_rule__CoordinatorDeclaration__Group__3__Impl1556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__0__Impl_in_rule__CoordinatorBody__Group__01595 = new BitSet(new long[]{0x0000000400E60010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__1_in_rule__CoordinatorBody__Group__01598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__CoordinatorBody__Group__0__Impl1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__1__Impl_in_rule__CoordinatorBody__Group__11657 = new BitSet(new long[]{0x0000000400E60010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__2_in_rule__CoordinatorBody__Group__11660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__2__Impl_in_rule__CoordinatorBody__Group__21718 = new BitSet(new long[]{0x0000000400E60010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__3_in_rule__CoordinatorBody__Group__21721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__0_in_rule__CoordinatorBody__Group__2__Impl1748 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__3__Impl_in_rule__CoordinatorBody__Group__31779 = new BitSet(new long[]{0x0000000400E60010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__4_in_rule__CoordinatorBody__Group__31782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__0_in_rule__CoordinatorBody__Group__3__Impl1809 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__4__Impl_in_rule__CoordinatorBody__Group__41840 = new BitSet(new long[]{0x0000000400E60010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__5_in_rule__CoordinatorBody__Group__41843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__0_in_rule__CoordinatorBody__Group__4__Impl1870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__5__Impl_in_rule__CoordinatorBody__Group__51901 = new BitSet(new long[]{0x0000000400E60010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__6_in_rule__CoordinatorBody__Group__51904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__MutexSetsAssignment_5_in_rule__CoordinatorBody__Group__5__Impl1931 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__6__Impl_in_rule__CoordinatorBody__Group__61962 = new BitSet(new long[]{0x0000000400E60010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__7_in_rule__CoordinatorBody__Group__61965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__GuardsAssignment_6_in_rule__CoordinatorBody__Group__6__Impl1992 = new BitSet(new long[]{0x0000000000800012L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__7__Impl_in_rule__CoordinatorBody__Group__72023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__CoordinatorBody__Group__7__Impl2051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__0__Impl_in_rule__CoordinatorBody__Group_2__02098 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__1_in_rule__CoordinatorBody__Group_2__02101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__CoordinatorBody__Group_2__0__Impl2129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__1__Impl_in_rule__CoordinatorBody__Group_2__12160 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__2_in_rule__CoordinatorBody__Group_2__12163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__CondVarsAssignment_2_1_in_rule__CoordinatorBody__Group_2__1__Impl2190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__2__Impl_in_rule__CoordinatorBody__Group_2__22220 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__3_in_rule__CoordinatorBody__Group_2__22223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2_2__0_in_rule__CoordinatorBody__Group_2__2__Impl2250 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__3__Impl_in_rule__CoordinatorBody__Group_2__32281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__CoordinatorBody__Group_2__3__Impl2309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2_2__0__Impl_in_rule__CoordinatorBody__Group_2_2__02348 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2_2__1_in_rule__CoordinatorBody__Group_2_2__02351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__CoordinatorBody__Group_2_2__0__Impl2379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2_2__1__Impl_in_rule__CoordinatorBody__Group_2_2__12410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__CondVarsAssignment_2_2_1_in_rule__CoordinatorBody__Group_2_2__1__Impl2437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__0__Impl_in_rule__CoordinatorBody__Group_3__02471 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__1_in_rule__CoordinatorBody__Group_3__02474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__CoordinatorBody__Group_3__0__Impl2502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__1__Impl_in_rule__CoordinatorBody__Group_3__12533 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__2_in_rule__CoordinatorBody__Group_3__12536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__OrdVarsAssignment_3_1_in_rule__CoordinatorBody__Group_3__1__Impl2563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__2__Impl_in_rule__CoordinatorBody__Group_3__22593 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__3_in_rule__CoordinatorBody__Group_3__22596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3_2__0_in_rule__CoordinatorBody__Group_3__2__Impl2623 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__3__Impl_in_rule__CoordinatorBody__Group_3__32654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__CoordinatorBody__Group_3__3__Impl2682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3_2__0__Impl_in_rule__CoordinatorBody__Group_3_2__02721 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3_2__1_in_rule__CoordinatorBody__Group_3_2__02724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__CoordinatorBody__Group_3_2__0__Impl2752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3_2__1__Impl_in_rule__CoordinatorBody__Group_3_2__12783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__OrdVarsAssignment_3_2_1_in_rule__CoordinatorBody__Group_3_2__1__Impl2810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__0__Impl_in_rule__CoordinatorBody__Group_4__02844 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__1_in_rule__CoordinatorBody__Group_4__02847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__CoordinatorBody__Group_4__0__Impl2875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__1__Impl_in_rule__CoordinatorBody__Group_4__12906 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__2_in_rule__CoordinatorBody__Group_4__12909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__SelfexMethodsAssignment_4_1_in_rule__CoordinatorBody__Group_4__1__Impl2936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__2__Impl_in_rule__CoordinatorBody__Group_4__22966 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__3_in_rule__CoordinatorBody__Group_4__22969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4_2__0_in_rule__CoordinatorBody__Group_4__2__Impl2996 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__3__Impl_in_rule__CoordinatorBody__Group_4__33027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__CoordinatorBody__Group_4__3__Impl3055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4_2__0__Impl_in_rule__CoordinatorBody__Group_4_2__03094 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4_2__1_in_rule__CoordinatorBody__Group_4_2__03097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__CoordinatorBody__Group_4_2__0__Impl3125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4_2__1__Impl_in_rule__CoordinatorBody__Group_4_2__13156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1_in_rule__CoordinatorBody__Group_4_2__1__Impl3183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group__0__Impl_in_rule__Guard__Group__03217 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_rule__Guard__Group__1_in_rule__Guard__Group__03220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Guard__Group__0__Impl3249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group__1__Impl_in_rule__Guard__Group__13282 = new BitSet(new long[]{0x0000000001100000L});
    public static final BitSet FOLLOW_rule__Guard__Group__2_in_rule__Guard__Group__13285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__MethodsAssignment_1_in_rule__Guard__Group__1__Impl3312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group__2__Impl_in_rule__Guard__Group__23342 = new BitSet(new long[]{0x0000000001100000L});
    public static final BitSet FOLLOW_rule__Guard__Group__3_in_rule__Guard__Group__23345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group_2__0_in_rule__Guard__Group__2__Impl3372 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Guard__Group__3__Impl_in_rule__Guard__Group__33403 = new BitSet(new long[]{0x0000000086000000L});
    public static final BitSet FOLLOW_rule__Guard__Group__4_in_rule__Guard__Group__33406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Guard__Group__3__Impl3434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group__4__Impl_in_rule__Guard__Group__43465 = new BitSet(new long[]{0x0000000086000000L});
    public static final BitSet FOLLOW_rule__Guard__Group__5_in_rule__Guard__Group__43468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__RequiresAssignment_4_in_rule__Guard__Group__4__Impl3495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group__5__Impl_in_rule__Guard__Group__53526 = new BitSet(new long[]{0x0000000086000000L});
    public static final BitSet FOLLOW_rule__Guard__Group__6_in_rule__Guard__Group__53529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group_5__0_in_rule__Guard__Group__5__Impl3556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group__6__Impl_in_rule__Guard__Group__63587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group_6__0_in_rule__Guard__Group__6__Impl3614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group_2__0__Impl_in_rule__Guard__Group_2__03659 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Guard__Group_2__1_in_rule__Guard__Group_2__03662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Guard__Group_2__0__Impl3690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group_2__1__Impl_in_rule__Guard__Group_2__13721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__MethodsAssignment_2_1_in_rule__Guard__Group_2__1__Impl3748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group_5__0__Impl_in_rule__Guard__Group_5__03782 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Guard__Group_5__1_in_rule__Guard__Group_5__03785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Guard__Group_5__0__Impl3813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group_5__1__Impl_in_rule__Guard__Group_5__13844 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_rule__Guard__Group_5__2_in_rule__Guard__Group_5__13847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Guard__Group_5__1__Impl3875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group_5__2__Impl_in_rule__Guard__Group_5__23906 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Guard__Group_5__3_in_rule__Guard__Group_5__23909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Alternatives_5_2_in_rule__Guard__Group_5__2__Impl3938 = new BitSet(new long[]{0x0000000008000012L});
    public static final BitSet FOLLOW_rule__Guard__Alternatives_5_2_in_rule__Guard__Group_5__2__Impl3950 = new BitSet(new long[]{0x0000000008000012L});
    public static final BitSet FOLLOW_rule__Guard__Group_5__3__Impl_in_rule__Guard__Group_5__33983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Guard__Group_5__3__Impl4011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group_6__0__Impl_in_rule__Guard__Group_6__04050 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Guard__Group_6__1_in_rule__Guard__Group_6__04053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Guard__Group_6__0__Impl4081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group_6__1__Impl_in_rule__Guard__Group_6__14112 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_rule__Guard__Group_6__2_in_rule__Guard__Group_6__14115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Guard__Group_6__1__Impl4143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Group_6__2__Impl_in_rule__Guard__Group_6__24174 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Guard__Group_6__3_in_rule__Guard__Group_6__24177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Guard__Alternatives_6_2_in_rule__Guard__Group_6__2__Impl4206 = new BitSet(new long[]{0x0000000008000012L});
    public static final BitSet FOLLOW_rule__Guard__Alternatives_6_2_in_rule__Guard__Group_6__2__Impl4218 = new BitSet(new long[]{0x0000000008000012L});
    public static final BitSet FOLLOW_rule__Guard__Group_6__3__Impl_in_rule__Guard__Group_6__34251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Guard__Group_6__3__Impl4279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__0__Impl_in_rule__IfStatement__Group__04318 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__1_in_rule__IfStatement__Group__04321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__IfStatement__Group__0__Impl4349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__1__Impl_in_rule__IfStatement__Group__14380 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__2_in_rule__IfStatement__Group__14383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__IfStatement__Group__1__Impl4411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__2__Impl_in_rule__IfStatement__Group__24442 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__3_in_rule__IfStatement__Group__24445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__ExpressionAssignment_2_in_rule__IfStatement__Group__2__Impl4472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__3__Impl_in_rule__IfStatement__Group__34502 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__4_in_rule__IfStatement__Group__34505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__IfStatement__Group__3__Impl4533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__4__Impl_in_rule__IfStatement__Group__44564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__StatementAssignment_4_in_rule__IfStatement__Group__4__Impl4591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfExpression__Group__0__Impl_in_rule__IfExpression__Group__04631 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__IfExpression__Group__1_in_rule__IfExpression__Group__04634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfExpression__VarAssignment_0_in_rule__IfExpression__Group__0__Impl4661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfExpression__Group__1__Impl_in_rule__IfExpression__Group__14691 = new BitSet(new long[]{0x0000000000006020L});
    public static final BitSet FOLLOW_rule__IfExpression__Group__2_in_rule__IfExpression__Group__14694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfExpression__OpAssignment_1_in_rule__IfExpression__Group__1__Impl4721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfExpression__Group__2__Impl_in_rule__IfExpression__Group__24751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfExpression__AssignmentAssignment_2_in_rule__IfExpression__Group__2__Impl4778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignStatement__Group__0__Impl_in_rule__AssignStatement__Group__04814 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__AssignStatement__Group__1_in_rule__AssignStatement__Group__04817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignStatement__VarAssignment_0_in_rule__AssignStatement__Group__0__Impl4844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignStatement__Group__1__Impl_in_rule__AssignStatement__Group__14874 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_rule__AssignStatement__Group__2_in_rule__AssignStatement__Group__14877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__AssignStatement__Group__1__Impl4905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignStatement__Group__2__Impl_in_rule__AssignStatement__Group__24936 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__AssignStatement__Group__3_in_rule__AssignStatement__Group__24939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignStatement__ValueAssignment_2_in_rule__AssignStatement__Group__2__Impl4966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignStatement__Group__3__Impl_in_rule__AssignStatement__Group__34996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__AssignStatement__Group__3__Impl5024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Requires__Group__0__Impl_in_rule__Requires__Group__05063 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_rule__Requires__Group__1_in_rule__Requires__Group__05066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Requires__Group__0__Impl5094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Requires__Group__1__Impl_in_rule__Requires__Group__15125 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Requires__Group__2_in_rule__Requires__Group__15128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Requires__AndExpressionAssignment_1_in_rule__Requires__Group__1__Impl5155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Requires__Group__2__Impl_in_rule__Requires__Group__25185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Requires__Group__2__Impl5213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group__0__Impl_in_rule__AndExpression__Group__05250 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__AndExpression__Group__1_in_rule__AndExpression__Group__05253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__OrExpressionsAssignment_0_in_rule__AndExpression__Group__0__Impl5280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group__1__Impl_in_rule__AndExpression__Group__15310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group_1__0_in_rule__AndExpression__Group__1__Impl5337 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group_1__0__Impl_in_rule__AndExpression__Group_1__05372 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_rule__AndExpression__Group_1__1_in_rule__AndExpression__Group_1__05375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__AndExpression__Group_1__0__Impl5403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group_1__1__Impl_in_rule__AndExpression__Group_1__15434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__OrExpressionsAssignment_1_1_in_rule__AndExpression__Group_1__1__Impl5461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group__0__Impl_in_rule__OrExpression__Group__05495 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__OrExpression__Group__1_in_rule__OrExpression__Group__05498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__BasicExpressionsAssignment_0_in_rule__OrExpression__Group__0__Impl5525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group__1__Impl_in_rule__OrExpression__Group__15555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group_1__0_in_rule__OrExpression__Group__1__Impl5582 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group_1__0__Impl_in_rule__OrExpression__Group_1__05617 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_rule__OrExpression__Group_1__1_in_rule__OrExpression__Group_1__05620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__OrExpression__Group_1__0__Impl5648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group_1__1__Impl_in_rule__OrExpression__Group_1__15679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__BasicExpressionsAssignment_1_1_in_rule__OrExpression__Group_1__1__Impl5706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicExpression__Group__0__Impl_in_rule__BasicExpression__Group__05740 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_rule__BasicExpression__Group__1_in_rule__BasicExpression__Group__05743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicExpression__NegatedAssignment_0_in_rule__BasicExpression__Group__0__Impl5770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicExpression__Group__1__Impl_in_rule__BasicExpression__Group__15801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BasicExpression__ExprAssignment_1_in_rule__BasicExpression__Group__1__Impl5828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__0__Impl_in_rule__MutexSet__Group__05862 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__1_in_rule__MutexSet__Group__05865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__MutexSet__Group__0__Impl5893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__1__Impl_in_rule__MutexSet__Group__15924 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__2_in_rule__MutexSet__Group__15927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__MutexSet__Group__1__Impl5955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__2__Impl_in_rule__MutexSet__Group__25986 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__3_in_rule__MutexSet__Group__25989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__MethodsAssignment_2_in_rule__MutexSet__Group__2__Impl6016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__3__Impl_in_rule__MutexSet__Group__36046 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__4_in_rule__MutexSet__Group__36049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group_3__0_in_rule__MutexSet__Group__3__Impl6078 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group_3__0_in_rule__MutexSet__Group__3__Impl6090 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__4__Impl_in_rule__MutexSet__Group__46123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__MutexSet__Group__4__Impl6151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group_3__0__Impl_in_rule__MutexSet__Group_3__06192 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MutexSet__Group_3__1_in_rule__MutexSet__Group_3__06195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__MutexSet__Group_3__0__Impl6223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group_3__1__Impl_in_rule__MutexSet__Group_3__16254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__MethodsAssignment_3_1_in_rule__MutexSet__Group_3__1__Impl6281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__Group__0__Impl_in_rule__CondVar__Group__06315 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__CondVar__Group__1_in_rule__CondVar__Group__06318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__NameAssignment_0_in_rule__CondVar__Group__0__Impl6345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__Group__1__Impl_in_rule__CondVar__Group__16375 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_rule__CondVar__Group__2_in_rule__CondVar__Group__16378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__CondVar__Group__1__Impl6406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__Group__2__Impl_in_rule__CondVar__Group__26437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__ValueAssignment_2_in_rule__CondVar__Group__2__Impl6464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__0__Impl_in_rule__OrdVar__Group__06500 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__1_in_rule__OrdVar__Group__06503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__NameAssignment_0_in_rule__OrdVar__Group__0__Impl6530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__1__Impl_in_rule__OrdVar__Group__16560 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__2_in_rule__OrdVar__Group__16563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__OrdVar__Group__1__Impl6591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__2__Impl_in_rule__OrdVar__Group__26622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__ValueAssignment_2_in_rule__OrdVar__Group__2__Impl6649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__06685 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__06688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl6715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__16744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl6771 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__06806 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__06809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__QualifiedName__Group_1__0__Impl6837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__16868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl6895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__CoordinatorDeclaration__GranularityAssignment_06938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__CoordinatorDeclaration__ClassNameAssignment_26977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCoordinatorBody_in_rule__CoordinatorDeclaration__BodyAssignment_37008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondVar_in_rule__CoordinatorBody__CondVarsAssignment_2_17039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondVar_in_rule__CoordinatorBody__CondVarsAssignment_2_2_17070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrdVar_in_rule__CoordinatorBody__OrdVarsAssignment_3_17101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrdVar_in_rule__CoordinatorBody__OrdVarsAssignment_3_2_17132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__CoordinatorBody__SelfexMethodsAssignment_4_17163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__CoordinatorBody__SelfexMethodsAssignment_4_2_17194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMutexSet_in_rule__CoordinatorBody__MutexSetsAssignment_57225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGuard_in_rule__CoordinatorBody__GuardsAssignment_67256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Guard__MethodsAssignment_17287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Guard__MethodsAssignment_2_17318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequires_in_rule__Guard__RequiresAssignment_47349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_rule__Guard__OnEntryIfStatementsAssignment_5_2_07380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignStatement_in_rule__Guard__OnEntryAssignStatementsAssignment_5_2_17411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_rule__Guard__OnExitIfStatementsAssignment_6_2_07442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignStatement_in_rule__Guard__OnExitAssignStatementsAssignment_6_2_17473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpression_in_rule__IfStatement__ExpressionAssignment_27504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignStatement_in_rule__IfStatement__StatementAssignment_47535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IfExpression__VarAssignment_07566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfExpression__OpAlternatives_1_0_in_rule__IfExpression__OpAssignment_17597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignedValue_in_rule__IfExpression__AssignmentAssignment_27630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AssignedValue__IntvalAssignment_07661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignedValue__BoolvalAlternatives_1_0_in_rule__AssignedValue__BoolvalAssignment_17692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AssignStatement__VarAssignment_07729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanVal_in_rule__AssignStatement__ValueAssignment_27764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_rule__Requires__AndExpressionAssignment_17795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_rule__AndExpression__OrExpressionsAssignment_07826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_rule__AndExpression__OrExpressionsAssignment_1_17857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicExpression_in_rule__OrExpression__BasicExpressionsAssignment_07888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicExpression_in_rule__OrExpression__BasicExpressionsAssignment_1_17919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__BasicExpression__NegatedAssignment_07955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__BasicExpression__ExprAssignment_17998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MutexSet__MethodsAssignment_28033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MutexSet__MethodsAssignment_3_18064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__CondVar__NameAssignment_08095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanVal_in_rule__CondVar__ValueAssignment_28126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__OrdVar__NameAssignment_08157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__OrdVar__ValueAssignment_28188 = new BitSet(new long[]{0x0000000000000002L});

}