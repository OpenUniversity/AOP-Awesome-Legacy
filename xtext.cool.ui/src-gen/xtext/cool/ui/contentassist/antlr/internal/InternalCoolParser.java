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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'coordinator'", "'{'", "'}'", "'condition'", "';'", "','", "'int'", "'selfex'", "'mutex'", "'};'", "'='", "'.'", "'per_class'"
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


    // $ANTLR start "entryRuleMutexSet"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:116:1: entryRuleMutexSet : ruleMutexSet EOF ;
    public final void entryRuleMutexSet() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:117:1: ( ruleMutexSet EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:118:1: ruleMutexSet EOF
            {
             before(grammarAccess.getMutexSetRule()); 
            pushFollow(FOLLOW_ruleMutexSet_in_entryRuleMutexSet181);
            ruleMutexSet();

            state._fsp--;

             after(grammarAccess.getMutexSetRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMutexSet188); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:125:1: ruleMutexSet : ( ( rule__MutexSet__Group__0 ) ) ;
    public final void ruleMutexSet() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:129:2: ( ( ( rule__MutexSet__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:130:1: ( ( rule__MutexSet__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:130:1: ( ( rule__MutexSet__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:131:1: ( rule__MutexSet__Group__0 )
            {
             before(grammarAccess.getMutexSetAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:132:1: ( rule__MutexSet__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:132:2: rule__MutexSet__Group__0
            {
            pushFollow(FOLLOW_rule__MutexSet__Group__0_in_ruleMutexSet214);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:144:1: entryRuleCondVar : ruleCondVar EOF ;
    public final void entryRuleCondVar() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:145:1: ( ruleCondVar EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:146:1: ruleCondVar EOF
            {
             before(grammarAccess.getCondVarRule()); 
            pushFollow(FOLLOW_ruleCondVar_in_entryRuleCondVar241);
            ruleCondVar();

            state._fsp--;

             after(grammarAccess.getCondVarRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCondVar248); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:153:1: ruleCondVar : ( ( rule__CondVar__Group__0 ) ) ;
    public final void ruleCondVar() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:157:2: ( ( ( rule__CondVar__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:158:1: ( ( rule__CondVar__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:158:1: ( ( rule__CondVar__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:159:1: ( rule__CondVar__Group__0 )
            {
             before(grammarAccess.getCondVarAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:160:1: ( rule__CondVar__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:160:2: rule__CondVar__Group__0
            {
            pushFollow(FOLLOW_rule__CondVar__Group__0_in_ruleCondVar274);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:172:1: entryRuleOrdVar : ruleOrdVar EOF ;
    public final void entryRuleOrdVar() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:173:1: ( ruleOrdVar EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:174:1: ruleOrdVar EOF
            {
             before(grammarAccess.getOrdVarRule()); 
            pushFollow(FOLLOW_ruleOrdVar_in_entryRuleOrdVar301);
            ruleOrdVar();

            state._fsp--;

             after(grammarAccess.getOrdVarRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrdVar308); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:181:1: ruleOrdVar : ( ( rule__OrdVar__Group__0 ) ) ;
    public final void ruleOrdVar() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:185:2: ( ( ( rule__OrdVar__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:186:1: ( ( rule__OrdVar__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:186:1: ( ( rule__OrdVar__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:187:1: ( rule__OrdVar__Group__0 )
            {
             before(grammarAccess.getOrdVarAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:188:1: ( rule__OrdVar__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:188:2: rule__OrdVar__Group__0
            {
            pushFollow(FOLLOW_rule__OrdVar__Group__0_in_ruleOrdVar334);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:200:1: entryRuleBooleanVal : ruleBooleanVal EOF ;
    public final void entryRuleBooleanVal() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:201:1: ( ruleBooleanVal EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:202:1: ruleBooleanVal EOF
            {
             before(grammarAccess.getBooleanValRule()); 
            pushFollow(FOLLOW_ruleBooleanVal_in_entryRuleBooleanVal361);
            ruleBooleanVal();

            state._fsp--;

             after(grammarAccess.getBooleanValRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanVal368); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:209:1: ruleBooleanVal : ( ( rule__BooleanVal__Alternatives ) ) ;
    public final void ruleBooleanVal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:213:2: ( ( ( rule__BooleanVal__Alternatives ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:214:1: ( ( rule__BooleanVal__Alternatives ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:214:1: ( ( rule__BooleanVal__Alternatives ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:215:1: ( rule__BooleanVal__Alternatives )
            {
             before(grammarAccess.getBooleanValAccess().getAlternatives()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:216:1: ( rule__BooleanVal__Alternatives )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:216:2: rule__BooleanVal__Alternatives
            {
            pushFollow(FOLLOW_rule__BooleanVal__Alternatives_in_ruleBooleanVal394);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:228:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:229:1: ( ruleQualifiedName EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:230:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName421);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName428); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:237:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:241:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:242:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:242:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:243:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:244:1: ( rule__QualifiedName__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:244:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName454);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:256:1: rule__BooleanVal__Alternatives : ( ( 'true' ) | ( 'false' ) );
    public final void rule__BooleanVal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:260:1: ( ( 'true' ) | ( 'false' ) )
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
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:261:1: ( 'true' )
                    {
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:261:1: ( 'true' )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:262:1: 'true'
                    {
                     before(grammarAccess.getBooleanValAccess().getTrueKeyword_0()); 
                    match(input,11,FOLLOW_11_in_rule__BooleanVal__Alternatives491); 
                     after(grammarAccess.getBooleanValAccess().getTrueKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:269:6: ( 'false' )
                    {
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:269:6: ( 'false' )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:270:1: 'false'
                    {
                     before(grammarAccess.getBooleanValAccess().getFalseKeyword_1()); 
                    match(input,12,FOLLOW_12_in_rule__BooleanVal__Alternatives511); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:284:1: rule__CoordinatorDeclaration__Group__0 : rule__CoordinatorDeclaration__Group__0__Impl rule__CoordinatorDeclaration__Group__1 ;
    public final void rule__CoordinatorDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:288:1: ( rule__CoordinatorDeclaration__Group__0__Impl rule__CoordinatorDeclaration__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:289:2: rule__CoordinatorDeclaration__Group__0__Impl rule__CoordinatorDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__0__Impl_in_rule__CoordinatorDeclaration__Group__0543);
            rule__CoordinatorDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__1_in_rule__CoordinatorDeclaration__Group__0546);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:296:1: rule__CoordinatorDeclaration__Group__0__Impl : ( ( rule__CoordinatorDeclaration__GranularityAssignment_0 )? ) ;
    public final void rule__CoordinatorDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:300:1: ( ( ( rule__CoordinatorDeclaration__GranularityAssignment_0 )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:301:1: ( ( rule__CoordinatorDeclaration__GranularityAssignment_0 )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:301:1: ( ( rule__CoordinatorDeclaration__GranularityAssignment_0 )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:302:1: ( rule__CoordinatorDeclaration__GranularityAssignment_0 )?
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getGranularityAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:303:1: ( rule__CoordinatorDeclaration__GranularityAssignment_0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==25) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:303:2: rule__CoordinatorDeclaration__GranularityAssignment_0
                    {
                    pushFollow(FOLLOW_rule__CoordinatorDeclaration__GranularityAssignment_0_in_rule__CoordinatorDeclaration__Group__0__Impl573);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:313:1: rule__CoordinatorDeclaration__Group__1 : rule__CoordinatorDeclaration__Group__1__Impl rule__CoordinatorDeclaration__Group__2 ;
    public final void rule__CoordinatorDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:317:1: ( rule__CoordinatorDeclaration__Group__1__Impl rule__CoordinatorDeclaration__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:318:2: rule__CoordinatorDeclaration__Group__1__Impl rule__CoordinatorDeclaration__Group__2
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__1__Impl_in_rule__CoordinatorDeclaration__Group__1604);
            rule__CoordinatorDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__2_in_rule__CoordinatorDeclaration__Group__1607);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:325:1: rule__CoordinatorDeclaration__Group__1__Impl : ( 'coordinator' ) ;
    public final void rule__CoordinatorDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:329:1: ( ( 'coordinator' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:330:1: ( 'coordinator' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:330:1: ( 'coordinator' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:331:1: 'coordinator'
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getCoordinatorKeyword_1()); 
            match(input,13,FOLLOW_13_in_rule__CoordinatorDeclaration__Group__1__Impl635); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:344:1: rule__CoordinatorDeclaration__Group__2 : rule__CoordinatorDeclaration__Group__2__Impl rule__CoordinatorDeclaration__Group__3 ;
    public final void rule__CoordinatorDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:348:1: ( rule__CoordinatorDeclaration__Group__2__Impl rule__CoordinatorDeclaration__Group__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:349:2: rule__CoordinatorDeclaration__Group__2__Impl rule__CoordinatorDeclaration__Group__3
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__2__Impl_in_rule__CoordinatorDeclaration__Group__2666);
            rule__CoordinatorDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__3_in_rule__CoordinatorDeclaration__Group__2669);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:356:1: rule__CoordinatorDeclaration__Group__2__Impl : ( ( rule__CoordinatorDeclaration__ClassNameAssignment_2 ) ) ;
    public final void rule__CoordinatorDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:360:1: ( ( ( rule__CoordinatorDeclaration__ClassNameAssignment_2 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:361:1: ( ( rule__CoordinatorDeclaration__ClassNameAssignment_2 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:361:1: ( ( rule__CoordinatorDeclaration__ClassNameAssignment_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:362:1: ( rule__CoordinatorDeclaration__ClassNameAssignment_2 )
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getClassNameAssignment_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:363:1: ( rule__CoordinatorDeclaration__ClassNameAssignment_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:363:2: rule__CoordinatorDeclaration__ClassNameAssignment_2
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__ClassNameAssignment_2_in_rule__CoordinatorDeclaration__Group__2__Impl696);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:373:1: rule__CoordinatorDeclaration__Group__3 : rule__CoordinatorDeclaration__Group__3__Impl ;
    public final void rule__CoordinatorDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:377:1: ( rule__CoordinatorDeclaration__Group__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:378:2: rule__CoordinatorDeclaration__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__3__Impl_in_rule__CoordinatorDeclaration__Group__3726);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:384:1: rule__CoordinatorDeclaration__Group__3__Impl : ( ( rule__CoordinatorDeclaration__BodyAssignment_3 )? ) ;
    public final void rule__CoordinatorDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:388:1: ( ( ( rule__CoordinatorDeclaration__BodyAssignment_3 )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:389:1: ( ( rule__CoordinatorDeclaration__BodyAssignment_3 )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:389:1: ( ( rule__CoordinatorDeclaration__BodyAssignment_3 )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:390:1: ( rule__CoordinatorDeclaration__BodyAssignment_3 )?
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getBodyAssignment_3()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:391:1: ( rule__CoordinatorDeclaration__BodyAssignment_3 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:391:2: rule__CoordinatorDeclaration__BodyAssignment_3
                    {
                    pushFollow(FOLLOW_rule__CoordinatorDeclaration__BodyAssignment_3_in_rule__CoordinatorDeclaration__Group__3__Impl753);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:409:1: rule__CoordinatorBody__Group__0 : rule__CoordinatorBody__Group__0__Impl rule__CoordinatorBody__Group__1 ;
    public final void rule__CoordinatorBody__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:413:1: ( rule__CoordinatorBody__Group__0__Impl rule__CoordinatorBody__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:414:2: rule__CoordinatorBody__Group__0__Impl rule__CoordinatorBody__Group__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__0__Impl_in_rule__CoordinatorBody__Group__0792);
            rule__CoordinatorBody__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__1_in_rule__CoordinatorBody__Group__0795);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:421:1: rule__CoordinatorBody__Group__0__Impl : ( '{' ) ;
    public final void rule__CoordinatorBody__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:425:1: ( ( '{' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:426:1: ( '{' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:426:1: ( '{' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:427:1: '{'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,14,FOLLOW_14_in_rule__CoordinatorBody__Group__0__Impl823); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:440:1: rule__CoordinatorBody__Group__1 : rule__CoordinatorBody__Group__1__Impl rule__CoordinatorBody__Group__2 ;
    public final void rule__CoordinatorBody__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:444:1: ( rule__CoordinatorBody__Group__1__Impl rule__CoordinatorBody__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:445:2: rule__CoordinatorBody__Group__1__Impl rule__CoordinatorBody__Group__2
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__1__Impl_in_rule__CoordinatorBody__Group__1854);
            rule__CoordinatorBody__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__2_in_rule__CoordinatorBody__Group__1857);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:452:1: rule__CoordinatorBody__Group__1__Impl : ( () ) ;
    public final void rule__CoordinatorBody__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:456:1: ( ( () ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:457:1: ( () )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:457:1: ( () )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:458:1: ()
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCoordinatorBodyAction_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:459:1: ()
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:461:1: 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:471:1: rule__CoordinatorBody__Group__2 : rule__CoordinatorBody__Group__2__Impl rule__CoordinatorBody__Group__3 ;
    public final void rule__CoordinatorBody__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:475:1: ( rule__CoordinatorBody__Group__2__Impl rule__CoordinatorBody__Group__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:476:2: rule__CoordinatorBody__Group__2__Impl rule__CoordinatorBody__Group__3
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__2__Impl_in_rule__CoordinatorBody__Group__2915);
            rule__CoordinatorBody__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__3_in_rule__CoordinatorBody__Group__2918);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:483:1: rule__CoordinatorBody__Group__2__Impl : ( ( rule__CoordinatorBody__Group_2__0 )* ) ;
    public final void rule__CoordinatorBody__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:487:1: ( ( ( rule__CoordinatorBody__Group_2__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:488:1: ( ( rule__CoordinatorBody__Group_2__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:488:1: ( ( rule__CoordinatorBody__Group_2__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:489:1: ( rule__CoordinatorBody__Group_2__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:490:1: ( rule__CoordinatorBody__Group_2__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:490:2: rule__CoordinatorBody__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__0_in_rule__CoordinatorBody__Group__2__Impl945);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:500:1: rule__CoordinatorBody__Group__3 : rule__CoordinatorBody__Group__3__Impl rule__CoordinatorBody__Group__4 ;
    public final void rule__CoordinatorBody__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:504:1: ( rule__CoordinatorBody__Group__3__Impl rule__CoordinatorBody__Group__4 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:505:2: rule__CoordinatorBody__Group__3__Impl rule__CoordinatorBody__Group__4
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__3__Impl_in_rule__CoordinatorBody__Group__3976);
            rule__CoordinatorBody__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__4_in_rule__CoordinatorBody__Group__3979);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:512:1: rule__CoordinatorBody__Group__3__Impl : ( ( rule__CoordinatorBody__Group_3__0 )* ) ;
    public final void rule__CoordinatorBody__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:516:1: ( ( ( rule__CoordinatorBody__Group_3__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:517:1: ( ( rule__CoordinatorBody__Group_3__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:517:1: ( ( rule__CoordinatorBody__Group_3__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:518:1: ( rule__CoordinatorBody__Group_3__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_3()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:519:1: ( rule__CoordinatorBody__Group_3__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:519:2: rule__CoordinatorBody__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__0_in_rule__CoordinatorBody__Group__3__Impl1006);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:529:1: rule__CoordinatorBody__Group__4 : rule__CoordinatorBody__Group__4__Impl rule__CoordinatorBody__Group__5 ;
    public final void rule__CoordinatorBody__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:533:1: ( rule__CoordinatorBody__Group__4__Impl rule__CoordinatorBody__Group__5 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:534:2: rule__CoordinatorBody__Group__4__Impl rule__CoordinatorBody__Group__5
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__4__Impl_in_rule__CoordinatorBody__Group__41037);
            rule__CoordinatorBody__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__5_in_rule__CoordinatorBody__Group__41040);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:541:1: rule__CoordinatorBody__Group__4__Impl : ( ( rule__CoordinatorBody__Group_4__0 )? ) ;
    public final void rule__CoordinatorBody__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:545:1: ( ( ( rule__CoordinatorBody__Group_4__0 )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:546:1: ( ( rule__CoordinatorBody__Group_4__0 )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:546:1: ( ( rule__CoordinatorBody__Group_4__0 )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:547:1: ( rule__CoordinatorBody__Group_4__0 )?
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_4()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:548:1: ( rule__CoordinatorBody__Group_4__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:548:2: rule__CoordinatorBody__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__0_in_rule__CoordinatorBody__Group__4__Impl1067);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:558:1: rule__CoordinatorBody__Group__5 : rule__CoordinatorBody__Group__5__Impl rule__CoordinatorBody__Group__6 ;
    public final void rule__CoordinatorBody__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:562:1: ( rule__CoordinatorBody__Group__5__Impl rule__CoordinatorBody__Group__6 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:563:2: rule__CoordinatorBody__Group__5__Impl rule__CoordinatorBody__Group__6
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__5__Impl_in_rule__CoordinatorBody__Group__51098);
            rule__CoordinatorBody__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__6_in_rule__CoordinatorBody__Group__51101);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:570:1: rule__CoordinatorBody__Group__5__Impl : ( ( rule__CoordinatorBody__MutexSetsAssignment_5 )* ) ;
    public final void rule__CoordinatorBody__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:574:1: ( ( ( rule__CoordinatorBody__MutexSetsAssignment_5 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:575:1: ( ( rule__CoordinatorBody__MutexSetsAssignment_5 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:575:1: ( ( rule__CoordinatorBody__MutexSetsAssignment_5 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:576:1: ( rule__CoordinatorBody__MutexSetsAssignment_5 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getMutexSetsAssignment_5()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:577:1: ( rule__CoordinatorBody__MutexSetsAssignment_5 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:577:2: rule__CoordinatorBody__MutexSetsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__MutexSetsAssignment_5_in_rule__CoordinatorBody__Group__5__Impl1128);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:587:1: rule__CoordinatorBody__Group__6 : rule__CoordinatorBody__Group__6__Impl ;
    public final void rule__CoordinatorBody__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:591:1: ( rule__CoordinatorBody__Group__6__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:592:2: rule__CoordinatorBody__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__6__Impl_in_rule__CoordinatorBody__Group__61159);
            rule__CoordinatorBody__Group__6__Impl();

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:598:1: rule__CoordinatorBody__Group__6__Impl : ( '}' ) ;
    public final void rule__CoordinatorBody__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:602:1: ( ( '}' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:603:1: ( '}' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:603:1: ( '}' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:604:1: '}'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getRightCurlyBracketKeyword_6()); 
            match(input,15,FOLLOW_15_in_rule__CoordinatorBody__Group__6__Impl1187); 
             after(grammarAccess.getCoordinatorBodyAccess().getRightCurlyBracketKeyword_6()); 

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


    // $ANTLR start "rule__CoordinatorBody__Group_2__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:631:1: rule__CoordinatorBody__Group_2__0 : rule__CoordinatorBody__Group_2__0__Impl rule__CoordinatorBody__Group_2__1 ;
    public final void rule__CoordinatorBody__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:635:1: ( rule__CoordinatorBody__Group_2__0__Impl rule__CoordinatorBody__Group_2__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:636:2: rule__CoordinatorBody__Group_2__0__Impl rule__CoordinatorBody__Group_2__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__0__Impl_in_rule__CoordinatorBody__Group_2__01232);
            rule__CoordinatorBody__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__1_in_rule__CoordinatorBody__Group_2__01235);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:643:1: rule__CoordinatorBody__Group_2__0__Impl : ( 'condition' ) ;
    public final void rule__CoordinatorBody__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:647:1: ( ( 'condition' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:648:1: ( 'condition' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:648:1: ( 'condition' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:649:1: 'condition'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getConditionKeyword_2_0()); 
            match(input,16,FOLLOW_16_in_rule__CoordinatorBody__Group_2__0__Impl1263); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:662:1: rule__CoordinatorBody__Group_2__1 : rule__CoordinatorBody__Group_2__1__Impl rule__CoordinatorBody__Group_2__2 ;
    public final void rule__CoordinatorBody__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:666:1: ( rule__CoordinatorBody__Group_2__1__Impl rule__CoordinatorBody__Group_2__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:667:2: rule__CoordinatorBody__Group_2__1__Impl rule__CoordinatorBody__Group_2__2
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__1__Impl_in_rule__CoordinatorBody__Group_2__11294);
            rule__CoordinatorBody__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__2_in_rule__CoordinatorBody__Group_2__11297);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:674:1: rule__CoordinatorBody__Group_2__1__Impl : ( ( rule__CoordinatorBody__CondVarsAssignment_2_1 ) ) ;
    public final void rule__CoordinatorBody__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:678:1: ( ( ( rule__CoordinatorBody__CondVarsAssignment_2_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:679:1: ( ( rule__CoordinatorBody__CondVarsAssignment_2_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:679:1: ( ( rule__CoordinatorBody__CondVarsAssignment_2_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:680:1: ( rule__CoordinatorBody__CondVarsAssignment_2_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCondVarsAssignment_2_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:681:1: ( rule__CoordinatorBody__CondVarsAssignment_2_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:681:2: rule__CoordinatorBody__CondVarsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__CondVarsAssignment_2_1_in_rule__CoordinatorBody__Group_2__1__Impl1324);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:691:1: rule__CoordinatorBody__Group_2__2 : rule__CoordinatorBody__Group_2__2__Impl rule__CoordinatorBody__Group_2__3 ;
    public final void rule__CoordinatorBody__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:695:1: ( rule__CoordinatorBody__Group_2__2__Impl rule__CoordinatorBody__Group_2__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:696:2: rule__CoordinatorBody__Group_2__2__Impl rule__CoordinatorBody__Group_2__3
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__2__Impl_in_rule__CoordinatorBody__Group_2__21354);
            rule__CoordinatorBody__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__3_in_rule__CoordinatorBody__Group_2__21357);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:703:1: rule__CoordinatorBody__Group_2__2__Impl : ( ( rule__CoordinatorBody__Group_2_2__0 )* ) ;
    public final void rule__CoordinatorBody__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:707:1: ( ( ( rule__CoordinatorBody__Group_2_2__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:708:1: ( ( rule__CoordinatorBody__Group_2_2__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:708:1: ( ( rule__CoordinatorBody__Group_2_2__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:709:1: ( rule__CoordinatorBody__Group_2_2__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_2_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:710:1: ( rule__CoordinatorBody__Group_2_2__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==18) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:710:2: rule__CoordinatorBody__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_2_2__0_in_rule__CoordinatorBody__Group_2__2__Impl1384);
            	    rule__CoordinatorBody__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:720:1: rule__CoordinatorBody__Group_2__3 : rule__CoordinatorBody__Group_2__3__Impl ;
    public final void rule__CoordinatorBody__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:724:1: ( rule__CoordinatorBody__Group_2__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:725:2: rule__CoordinatorBody__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__3__Impl_in_rule__CoordinatorBody__Group_2__31415);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:731:1: rule__CoordinatorBody__Group_2__3__Impl : ( ';' ) ;
    public final void rule__CoordinatorBody__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:735:1: ( ( ';' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:736:1: ( ';' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:736:1: ( ';' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:737:1: ';'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_2_3()); 
            match(input,17,FOLLOW_17_in_rule__CoordinatorBody__Group_2__3__Impl1443); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:758:1: rule__CoordinatorBody__Group_2_2__0 : rule__CoordinatorBody__Group_2_2__0__Impl rule__CoordinatorBody__Group_2_2__1 ;
    public final void rule__CoordinatorBody__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:762:1: ( rule__CoordinatorBody__Group_2_2__0__Impl rule__CoordinatorBody__Group_2_2__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:763:2: rule__CoordinatorBody__Group_2_2__0__Impl rule__CoordinatorBody__Group_2_2__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2_2__0__Impl_in_rule__CoordinatorBody__Group_2_2__01482);
            rule__CoordinatorBody__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2_2__1_in_rule__CoordinatorBody__Group_2_2__01485);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:770:1: rule__CoordinatorBody__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__CoordinatorBody__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:774:1: ( ( ',' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:775:1: ( ',' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:775:1: ( ',' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:776:1: ','
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_2_2_0()); 
            match(input,18,FOLLOW_18_in_rule__CoordinatorBody__Group_2_2__0__Impl1513); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:789:1: rule__CoordinatorBody__Group_2_2__1 : rule__CoordinatorBody__Group_2_2__1__Impl ;
    public final void rule__CoordinatorBody__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:793:1: ( rule__CoordinatorBody__Group_2_2__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:794:2: rule__CoordinatorBody__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2_2__1__Impl_in_rule__CoordinatorBody__Group_2_2__11544);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:800:1: rule__CoordinatorBody__Group_2_2__1__Impl : ( ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 ) ) ;
    public final void rule__CoordinatorBody__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:804:1: ( ( ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:805:1: ( ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:805:1: ( ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:806:1: ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCondVarsAssignment_2_2_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:807:1: ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:807:2: rule__CoordinatorBody__CondVarsAssignment_2_2_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__CondVarsAssignment_2_2_1_in_rule__CoordinatorBody__Group_2_2__1__Impl1571);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:821:1: rule__CoordinatorBody__Group_3__0 : rule__CoordinatorBody__Group_3__0__Impl rule__CoordinatorBody__Group_3__1 ;
    public final void rule__CoordinatorBody__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:825:1: ( rule__CoordinatorBody__Group_3__0__Impl rule__CoordinatorBody__Group_3__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:826:2: rule__CoordinatorBody__Group_3__0__Impl rule__CoordinatorBody__Group_3__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__0__Impl_in_rule__CoordinatorBody__Group_3__01605);
            rule__CoordinatorBody__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__1_in_rule__CoordinatorBody__Group_3__01608);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:833:1: rule__CoordinatorBody__Group_3__0__Impl : ( 'int' ) ;
    public final void rule__CoordinatorBody__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:837:1: ( ( 'int' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:838:1: ( 'int' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:838:1: ( 'int' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:839:1: 'int'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getIntKeyword_3_0()); 
            match(input,19,FOLLOW_19_in_rule__CoordinatorBody__Group_3__0__Impl1636); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:852:1: rule__CoordinatorBody__Group_3__1 : rule__CoordinatorBody__Group_3__1__Impl rule__CoordinatorBody__Group_3__2 ;
    public final void rule__CoordinatorBody__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:856:1: ( rule__CoordinatorBody__Group_3__1__Impl rule__CoordinatorBody__Group_3__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:857:2: rule__CoordinatorBody__Group_3__1__Impl rule__CoordinatorBody__Group_3__2
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__1__Impl_in_rule__CoordinatorBody__Group_3__11667);
            rule__CoordinatorBody__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__2_in_rule__CoordinatorBody__Group_3__11670);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:864:1: rule__CoordinatorBody__Group_3__1__Impl : ( ( rule__CoordinatorBody__OrdVarsAssignment_3_1 ) ) ;
    public final void rule__CoordinatorBody__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:868:1: ( ( ( rule__CoordinatorBody__OrdVarsAssignment_3_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:869:1: ( ( rule__CoordinatorBody__OrdVarsAssignment_3_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:869:1: ( ( rule__CoordinatorBody__OrdVarsAssignment_3_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:870:1: ( rule__CoordinatorBody__OrdVarsAssignment_3_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getOrdVarsAssignment_3_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:871:1: ( rule__CoordinatorBody__OrdVarsAssignment_3_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:871:2: rule__CoordinatorBody__OrdVarsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__OrdVarsAssignment_3_1_in_rule__CoordinatorBody__Group_3__1__Impl1697);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:881:1: rule__CoordinatorBody__Group_3__2 : rule__CoordinatorBody__Group_3__2__Impl rule__CoordinatorBody__Group_3__3 ;
    public final void rule__CoordinatorBody__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:885:1: ( rule__CoordinatorBody__Group_3__2__Impl rule__CoordinatorBody__Group_3__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:886:2: rule__CoordinatorBody__Group_3__2__Impl rule__CoordinatorBody__Group_3__3
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__2__Impl_in_rule__CoordinatorBody__Group_3__21727);
            rule__CoordinatorBody__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__3_in_rule__CoordinatorBody__Group_3__21730);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:893:1: rule__CoordinatorBody__Group_3__2__Impl : ( ( rule__CoordinatorBody__Group_3_2__0 )* ) ;
    public final void rule__CoordinatorBody__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:897:1: ( ( ( rule__CoordinatorBody__Group_3_2__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:898:1: ( ( rule__CoordinatorBody__Group_3_2__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:898:1: ( ( rule__CoordinatorBody__Group_3_2__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:899:1: ( rule__CoordinatorBody__Group_3_2__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_3_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:900:1: ( rule__CoordinatorBody__Group_3_2__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==18) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:900:2: rule__CoordinatorBody__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_3_2__0_in_rule__CoordinatorBody__Group_3__2__Impl1757);
            	    rule__CoordinatorBody__Group_3_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:910:1: rule__CoordinatorBody__Group_3__3 : rule__CoordinatorBody__Group_3__3__Impl ;
    public final void rule__CoordinatorBody__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:914:1: ( rule__CoordinatorBody__Group_3__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:915:2: rule__CoordinatorBody__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__3__Impl_in_rule__CoordinatorBody__Group_3__31788);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:921:1: rule__CoordinatorBody__Group_3__3__Impl : ( ';' ) ;
    public final void rule__CoordinatorBody__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:925:1: ( ( ';' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:926:1: ( ';' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:926:1: ( ';' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:927:1: ';'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_3_3()); 
            match(input,17,FOLLOW_17_in_rule__CoordinatorBody__Group_3__3__Impl1816); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:948:1: rule__CoordinatorBody__Group_3_2__0 : rule__CoordinatorBody__Group_3_2__0__Impl rule__CoordinatorBody__Group_3_2__1 ;
    public final void rule__CoordinatorBody__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:952:1: ( rule__CoordinatorBody__Group_3_2__0__Impl rule__CoordinatorBody__Group_3_2__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:953:2: rule__CoordinatorBody__Group_3_2__0__Impl rule__CoordinatorBody__Group_3_2__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3_2__0__Impl_in_rule__CoordinatorBody__Group_3_2__01855);
            rule__CoordinatorBody__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3_2__1_in_rule__CoordinatorBody__Group_3_2__01858);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:960:1: rule__CoordinatorBody__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__CoordinatorBody__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:964:1: ( ( ',' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:965:1: ( ',' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:965:1: ( ',' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:966:1: ','
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_3_2_0()); 
            match(input,18,FOLLOW_18_in_rule__CoordinatorBody__Group_3_2__0__Impl1886); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:979:1: rule__CoordinatorBody__Group_3_2__1 : rule__CoordinatorBody__Group_3_2__1__Impl ;
    public final void rule__CoordinatorBody__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:983:1: ( rule__CoordinatorBody__Group_3_2__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:984:2: rule__CoordinatorBody__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3_2__1__Impl_in_rule__CoordinatorBody__Group_3_2__11917);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:990:1: rule__CoordinatorBody__Group_3_2__1__Impl : ( ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 ) ) ;
    public final void rule__CoordinatorBody__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:994:1: ( ( ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:995:1: ( ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:995:1: ( ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:996:1: ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getOrdVarsAssignment_3_2_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:997:1: ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:997:2: rule__CoordinatorBody__OrdVarsAssignment_3_2_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__OrdVarsAssignment_3_2_1_in_rule__CoordinatorBody__Group_3_2__1__Impl1944);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1011:1: rule__CoordinatorBody__Group_4__0 : rule__CoordinatorBody__Group_4__0__Impl rule__CoordinatorBody__Group_4__1 ;
    public final void rule__CoordinatorBody__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1015:1: ( rule__CoordinatorBody__Group_4__0__Impl rule__CoordinatorBody__Group_4__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1016:2: rule__CoordinatorBody__Group_4__0__Impl rule__CoordinatorBody__Group_4__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__0__Impl_in_rule__CoordinatorBody__Group_4__01978);
            rule__CoordinatorBody__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__1_in_rule__CoordinatorBody__Group_4__01981);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1023:1: rule__CoordinatorBody__Group_4__0__Impl : ( 'selfex' ) ;
    public final void rule__CoordinatorBody__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1027:1: ( ( 'selfex' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1028:1: ( 'selfex' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1028:1: ( 'selfex' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1029:1: 'selfex'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexKeyword_4_0()); 
            match(input,20,FOLLOW_20_in_rule__CoordinatorBody__Group_4__0__Impl2009); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1042:1: rule__CoordinatorBody__Group_4__1 : rule__CoordinatorBody__Group_4__1__Impl rule__CoordinatorBody__Group_4__2 ;
    public final void rule__CoordinatorBody__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1046:1: ( rule__CoordinatorBody__Group_4__1__Impl rule__CoordinatorBody__Group_4__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1047:2: rule__CoordinatorBody__Group_4__1__Impl rule__CoordinatorBody__Group_4__2
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__1__Impl_in_rule__CoordinatorBody__Group_4__12040);
            rule__CoordinatorBody__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__2_in_rule__CoordinatorBody__Group_4__12043);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1054:1: rule__CoordinatorBody__Group_4__1__Impl : ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 ) ) ;
    public final void rule__CoordinatorBody__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1058:1: ( ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1059:1: ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1059:1: ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1060:1: ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsAssignment_4_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1061:1: ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1061:2: rule__CoordinatorBody__SelfexMethodsAssignment_4_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__SelfexMethodsAssignment_4_1_in_rule__CoordinatorBody__Group_4__1__Impl2070);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1071:1: rule__CoordinatorBody__Group_4__2 : rule__CoordinatorBody__Group_4__2__Impl rule__CoordinatorBody__Group_4__3 ;
    public final void rule__CoordinatorBody__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1075:1: ( rule__CoordinatorBody__Group_4__2__Impl rule__CoordinatorBody__Group_4__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1076:2: rule__CoordinatorBody__Group_4__2__Impl rule__CoordinatorBody__Group_4__3
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__2__Impl_in_rule__CoordinatorBody__Group_4__22100);
            rule__CoordinatorBody__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__3_in_rule__CoordinatorBody__Group_4__22103);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1083:1: rule__CoordinatorBody__Group_4__2__Impl : ( ( rule__CoordinatorBody__Group_4_2__0 )* ) ;
    public final void rule__CoordinatorBody__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1087:1: ( ( ( rule__CoordinatorBody__Group_4_2__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1088:1: ( ( rule__CoordinatorBody__Group_4_2__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1088:1: ( ( rule__CoordinatorBody__Group_4_2__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1089:1: ( rule__CoordinatorBody__Group_4_2__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_4_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1090:1: ( rule__CoordinatorBody__Group_4_2__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==18) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1090:2: rule__CoordinatorBody__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_4_2__0_in_rule__CoordinatorBody__Group_4__2__Impl2130);
            	    rule__CoordinatorBody__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1100:1: rule__CoordinatorBody__Group_4__3 : rule__CoordinatorBody__Group_4__3__Impl ;
    public final void rule__CoordinatorBody__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1104:1: ( rule__CoordinatorBody__Group_4__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1105:2: rule__CoordinatorBody__Group_4__3__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__3__Impl_in_rule__CoordinatorBody__Group_4__32161);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1111:1: rule__CoordinatorBody__Group_4__3__Impl : ( ';' ) ;
    public final void rule__CoordinatorBody__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1115:1: ( ( ';' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1116:1: ( ';' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1116:1: ( ';' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1117:1: ';'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_4_3()); 
            match(input,17,FOLLOW_17_in_rule__CoordinatorBody__Group_4__3__Impl2189); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1138:1: rule__CoordinatorBody__Group_4_2__0 : rule__CoordinatorBody__Group_4_2__0__Impl rule__CoordinatorBody__Group_4_2__1 ;
    public final void rule__CoordinatorBody__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1142:1: ( rule__CoordinatorBody__Group_4_2__0__Impl rule__CoordinatorBody__Group_4_2__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1143:2: rule__CoordinatorBody__Group_4_2__0__Impl rule__CoordinatorBody__Group_4_2__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4_2__0__Impl_in_rule__CoordinatorBody__Group_4_2__02228);
            rule__CoordinatorBody__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4_2__1_in_rule__CoordinatorBody__Group_4_2__02231);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1150:1: rule__CoordinatorBody__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__CoordinatorBody__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1154:1: ( ( ',' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1155:1: ( ',' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1155:1: ( ',' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1156:1: ','
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_4_2_0()); 
            match(input,18,FOLLOW_18_in_rule__CoordinatorBody__Group_4_2__0__Impl2259); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1169:1: rule__CoordinatorBody__Group_4_2__1 : rule__CoordinatorBody__Group_4_2__1__Impl ;
    public final void rule__CoordinatorBody__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1173:1: ( rule__CoordinatorBody__Group_4_2__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1174:2: rule__CoordinatorBody__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4_2__1__Impl_in_rule__CoordinatorBody__Group_4_2__12290);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1180:1: rule__CoordinatorBody__Group_4_2__1__Impl : ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 ) ) ;
    public final void rule__CoordinatorBody__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1184:1: ( ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1185:1: ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1185:1: ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1186:1: ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsAssignment_4_2_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1187:1: ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1187:2: rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1_in_rule__CoordinatorBody__Group_4_2__1__Impl2317);
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


    // $ANTLR start "rule__MutexSet__Group__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1201:1: rule__MutexSet__Group__0 : rule__MutexSet__Group__0__Impl rule__MutexSet__Group__1 ;
    public final void rule__MutexSet__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1205:1: ( rule__MutexSet__Group__0__Impl rule__MutexSet__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1206:2: rule__MutexSet__Group__0__Impl rule__MutexSet__Group__1
            {
            pushFollow(FOLLOW_rule__MutexSet__Group__0__Impl_in_rule__MutexSet__Group__02351);
            rule__MutexSet__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MutexSet__Group__1_in_rule__MutexSet__Group__02354);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1213:1: rule__MutexSet__Group__0__Impl : ( 'mutex' ) ;
    public final void rule__MutexSet__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1217:1: ( ( 'mutex' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1218:1: ( 'mutex' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1218:1: ( 'mutex' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1219:1: 'mutex'
            {
             before(grammarAccess.getMutexSetAccess().getMutexKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__MutexSet__Group__0__Impl2382); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1232:1: rule__MutexSet__Group__1 : rule__MutexSet__Group__1__Impl rule__MutexSet__Group__2 ;
    public final void rule__MutexSet__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1236:1: ( rule__MutexSet__Group__1__Impl rule__MutexSet__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1237:2: rule__MutexSet__Group__1__Impl rule__MutexSet__Group__2
            {
            pushFollow(FOLLOW_rule__MutexSet__Group__1__Impl_in_rule__MutexSet__Group__12413);
            rule__MutexSet__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MutexSet__Group__2_in_rule__MutexSet__Group__12416);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1244:1: rule__MutexSet__Group__1__Impl : ( '{' ) ;
    public final void rule__MutexSet__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1248:1: ( ( '{' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1249:1: ( '{' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1249:1: ( '{' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1250:1: '{'
            {
             before(grammarAccess.getMutexSetAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,14,FOLLOW_14_in_rule__MutexSet__Group__1__Impl2444); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1263:1: rule__MutexSet__Group__2 : rule__MutexSet__Group__2__Impl rule__MutexSet__Group__3 ;
    public final void rule__MutexSet__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1267:1: ( rule__MutexSet__Group__2__Impl rule__MutexSet__Group__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1268:2: rule__MutexSet__Group__2__Impl rule__MutexSet__Group__3
            {
            pushFollow(FOLLOW_rule__MutexSet__Group__2__Impl_in_rule__MutexSet__Group__22475);
            rule__MutexSet__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MutexSet__Group__3_in_rule__MutexSet__Group__22478);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1275:1: rule__MutexSet__Group__2__Impl : ( ( rule__MutexSet__MethodsAssignment_2 ) ) ;
    public final void rule__MutexSet__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1279:1: ( ( ( rule__MutexSet__MethodsAssignment_2 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1280:1: ( ( rule__MutexSet__MethodsAssignment_2 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1280:1: ( ( rule__MutexSet__MethodsAssignment_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1281:1: ( rule__MutexSet__MethodsAssignment_2 )
            {
             before(grammarAccess.getMutexSetAccess().getMethodsAssignment_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1282:1: ( rule__MutexSet__MethodsAssignment_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1282:2: rule__MutexSet__MethodsAssignment_2
            {
            pushFollow(FOLLOW_rule__MutexSet__MethodsAssignment_2_in_rule__MutexSet__Group__2__Impl2505);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1292:1: rule__MutexSet__Group__3 : rule__MutexSet__Group__3__Impl rule__MutexSet__Group__4 ;
    public final void rule__MutexSet__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1296:1: ( rule__MutexSet__Group__3__Impl rule__MutexSet__Group__4 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1297:2: rule__MutexSet__Group__3__Impl rule__MutexSet__Group__4
            {
            pushFollow(FOLLOW_rule__MutexSet__Group__3__Impl_in_rule__MutexSet__Group__32535);
            rule__MutexSet__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MutexSet__Group__4_in_rule__MutexSet__Group__32538);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1304:1: rule__MutexSet__Group__3__Impl : ( ( ( rule__MutexSet__Group_3__0 ) ) ( ( rule__MutexSet__Group_3__0 )* ) ) ;
    public final void rule__MutexSet__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1308:1: ( ( ( ( rule__MutexSet__Group_3__0 ) ) ( ( rule__MutexSet__Group_3__0 )* ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1309:1: ( ( ( rule__MutexSet__Group_3__0 ) ) ( ( rule__MutexSet__Group_3__0 )* ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1309:1: ( ( ( rule__MutexSet__Group_3__0 ) ) ( ( rule__MutexSet__Group_3__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1310:1: ( ( rule__MutexSet__Group_3__0 ) ) ( ( rule__MutexSet__Group_3__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1310:1: ( ( rule__MutexSet__Group_3__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1311:1: ( rule__MutexSet__Group_3__0 )
            {
             before(grammarAccess.getMutexSetAccess().getGroup_3()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1312:1: ( rule__MutexSet__Group_3__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1312:2: rule__MutexSet__Group_3__0
            {
            pushFollow(FOLLOW_rule__MutexSet__Group_3__0_in_rule__MutexSet__Group__3__Impl2567);
            rule__MutexSet__Group_3__0();

            state._fsp--;


            }

             after(grammarAccess.getMutexSetAccess().getGroup_3()); 

            }

            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1315:1: ( ( rule__MutexSet__Group_3__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1316:1: ( rule__MutexSet__Group_3__0 )*
            {
             before(grammarAccess.getMutexSetAccess().getGroup_3()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1317:1: ( rule__MutexSet__Group_3__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==18) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1317:2: rule__MutexSet__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__MutexSet__Group_3__0_in_rule__MutexSet__Group__3__Impl2579);
            	    rule__MutexSet__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1328:1: rule__MutexSet__Group__4 : rule__MutexSet__Group__4__Impl ;
    public final void rule__MutexSet__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1332:1: ( rule__MutexSet__Group__4__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1333:2: rule__MutexSet__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__MutexSet__Group__4__Impl_in_rule__MutexSet__Group__42612);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1339:1: rule__MutexSet__Group__4__Impl : ( '};' ) ;
    public final void rule__MutexSet__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1343:1: ( ( '};' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1344:1: ( '};' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1344:1: ( '};' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1345:1: '};'
            {
             before(grammarAccess.getMutexSetAccess().getRightCurlyBracketSemicolonKeyword_4()); 
            match(input,22,FOLLOW_22_in_rule__MutexSet__Group__4__Impl2640); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1368:1: rule__MutexSet__Group_3__0 : rule__MutexSet__Group_3__0__Impl rule__MutexSet__Group_3__1 ;
    public final void rule__MutexSet__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1372:1: ( rule__MutexSet__Group_3__0__Impl rule__MutexSet__Group_3__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1373:2: rule__MutexSet__Group_3__0__Impl rule__MutexSet__Group_3__1
            {
            pushFollow(FOLLOW_rule__MutexSet__Group_3__0__Impl_in_rule__MutexSet__Group_3__02681);
            rule__MutexSet__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MutexSet__Group_3__1_in_rule__MutexSet__Group_3__02684);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1380:1: rule__MutexSet__Group_3__0__Impl : ( ',' ) ;
    public final void rule__MutexSet__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1384:1: ( ( ',' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1385:1: ( ',' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1385:1: ( ',' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1386:1: ','
            {
             before(grammarAccess.getMutexSetAccess().getCommaKeyword_3_0()); 
            match(input,18,FOLLOW_18_in_rule__MutexSet__Group_3__0__Impl2712); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1399:1: rule__MutexSet__Group_3__1 : rule__MutexSet__Group_3__1__Impl ;
    public final void rule__MutexSet__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1403:1: ( rule__MutexSet__Group_3__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1404:2: rule__MutexSet__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__MutexSet__Group_3__1__Impl_in_rule__MutexSet__Group_3__12743);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1410:1: rule__MutexSet__Group_3__1__Impl : ( ( rule__MutexSet__MethodsAssignment_3_1 ) ) ;
    public final void rule__MutexSet__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1414:1: ( ( ( rule__MutexSet__MethodsAssignment_3_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1415:1: ( ( rule__MutexSet__MethodsAssignment_3_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1415:1: ( ( rule__MutexSet__MethodsAssignment_3_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1416:1: ( rule__MutexSet__MethodsAssignment_3_1 )
            {
             before(grammarAccess.getMutexSetAccess().getMethodsAssignment_3_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1417:1: ( rule__MutexSet__MethodsAssignment_3_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1417:2: rule__MutexSet__MethodsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__MutexSet__MethodsAssignment_3_1_in_rule__MutexSet__Group_3__1__Impl2770);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1431:1: rule__CondVar__Group__0 : rule__CondVar__Group__0__Impl rule__CondVar__Group__1 ;
    public final void rule__CondVar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1435:1: ( rule__CondVar__Group__0__Impl rule__CondVar__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1436:2: rule__CondVar__Group__0__Impl rule__CondVar__Group__1
            {
            pushFollow(FOLLOW_rule__CondVar__Group__0__Impl_in_rule__CondVar__Group__02804);
            rule__CondVar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CondVar__Group__1_in_rule__CondVar__Group__02807);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1443:1: rule__CondVar__Group__0__Impl : ( ( rule__CondVar__NameAssignment_0 ) ) ;
    public final void rule__CondVar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1447:1: ( ( ( rule__CondVar__NameAssignment_0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1448:1: ( ( rule__CondVar__NameAssignment_0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1448:1: ( ( rule__CondVar__NameAssignment_0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1449:1: ( rule__CondVar__NameAssignment_0 )
            {
             before(grammarAccess.getCondVarAccess().getNameAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1450:1: ( rule__CondVar__NameAssignment_0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1450:2: rule__CondVar__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__CondVar__NameAssignment_0_in_rule__CondVar__Group__0__Impl2834);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1460:1: rule__CondVar__Group__1 : rule__CondVar__Group__1__Impl rule__CondVar__Group__2 ;
    public final void rule__CondVar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1464:1: ( rule__CondVar__Group__1__Impl rule__CondVar__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1465:2: rule__CondVar__Group__1__Impl rule__CondVar__Group__2
            {
            pushFollow(FOLLOW_rule__CondVar__Group__1__Impl_in_rule__CondVar__Group__12864);
            rule__CondVar__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CondVar__Group__2_in_rule__CondVar__Group__12867);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1472:1: rule__CondVar__Group__1__Impl : ( '=' ) ;
    public final void rule__CondVar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1476:1: ( ( '=' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1477:1: ( '=' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1477:1: ( '=' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1478:1: '='
            {
             before(grammarAccess.getCondVarAccess().getEqualsSignKeyword_1()); 
            match(input,23,FOLLOW_23_in_rule__CondVar__Group__1__Impl2895); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1491:1: rule__CondVar__Group__2 : rule__CondVar__Group__2__Impl ;
    public final void rule__CondVar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1495:1: ( rule__CondVar__Group__2__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1496:2: rule__CondVar__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__CondVar__Group__2__Impl_in_rule__CondVar__Group__22926);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1502:1: rule__CondVar__Group__2__Impl : ( ( rule__CondVar__ValueAssignment_2 ) ) ;
    public final void rule__CondVar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1506:1: ( ( ( rule__CondVar__ValueAssignment_2 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1507:1: ( ( rule__CondVar__ValueAssignment_2 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1507:1: ( ( rule__CondVar__ValueAssignment_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1508:1: ( rule__CondVar__ValueAssignment_2 )
            {
             before(grammarAccess.getCondVarAccess().getValueAssignment_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1509:1: ( rule__CondVar__ValueAssignment_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1509:2: rule__CondVar__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__CondVar__ValueAssignment_2_in_rule__CondVar__Group__2__Impl2953);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1525:1: rule__OrdVar__Group__0 : rule__OrdVar__Group__0__Impl rule__OrdVar__Group__1 ;
    public final void rule__OrdVar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1529:1: ( rule__OrdVar__Group__0__Impl rule__OrdVar__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1530:2: rule__OrdVar__Group__0__Impl rule__OrdVar__Group__1
            {
            pushFollow(FOLLOW_rule__OrdVar__Group__0__Impl_in_rule__OrdVar__Group__02989);
            rule__OrdVar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OrdVar__Group__1_in_rule__OrdVar__Group__02992);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1537:1: rule__OrdVar__Group__0__Impl : ( ( rule__OrdVar__NameAssignment_0 ) ) ;
    public final void rule__OrdVar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1541:1: ( ( ( rule__OrdVar__NameAssignment_0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1542:1: ( ( rule__OrdVar__NameAssignment_0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1542:1: ( ( rule__OrdVar__NameAssignment_0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1543:1: ( rule__OrdVar__NameAssignment_0 )
            {
             before(grammarAccess.getOrdVarAccess().getNameAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1544:1: ( rule__OrdVar__NameAssignment_0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1544:2: rule__OrdVar__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__OrdVar__NameAssignment_0_in_rule__OrdVar__Group__0__Impl3019);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1554:1: rule__OrdVar__Group__1 : rule__OrdVar__Group__1__Impl rule__OrdVar__Group__2 ;
    public final void rule__OrdVar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1558:1: ( rule__OrdVar__Group__1__Impl rule__OrdVar__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1559:2: rule__OrdVar__Group__1__Impl rule__OrdVar__Group__2
            {
            pushFollow(FOLLOW_rule__OrdVar__Group__1__Impl_in_rule__OrdVar__Group__13049);
            rule__OrdVar__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OrdVar__Group__2_in_rule__OrdVar__Group__13052);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1566:1: rule__OrdVar__Group__1__Impl : ( '=' ) ;
    public final void rule__OrdVar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1570:1: ( ( '=' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1571:1: ( '=' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1571:1: ( '=' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1572:1: '='
            {
             before(grammarAccess.getOrdVarAccess().getEqualsSignKeyword_1()); 
            match(input,23,FOLLOW_23_in_rule__OrdVar__Group__1__Impl3080); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1585:1: rule__OrdVar__Group__2 : rule__OrdVar__Group__2__Impl ;
    public final void rule__OrdVar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1589:1: ( rule__OrdVar__Group__2__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1590:2: rule__OrdVar__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__OrdVar__Group__2__Impl_in_rule__OrdVar__Group__23111);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1596:1: rule__OrdVar__Group__2__Impl : ( ( rule__OrdVar__ValueAssignment_2 ) ) ;
    public final void rule__OrdVar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1600:1: ( ( ( rule__OrdVar__ValueAssignment_2 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1601:1: ( ( rule__OrdVar__ValueAssignment_2 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1601:1: ( ( rule__OrdVar__ValueAssignment_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1602:1: ( rule__OrdVar__ValueAssignment_2 )
            {
             before(grammarAccess.getOrdVarAccess().getValueAssignment_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1603:1: ( rule__OrdVar__ValueAssignment_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1603:2: rule__OrdVar__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__OrdVar__ValueAssignment_2_in_rule__OrdVar__Group__2__Impl3138);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1619:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1623:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1624:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__03174);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__03177);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1631:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1635:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1636:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1636:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1637:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl3204); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1648:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1652:1: ( rule__QualifiedName__Group__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1653:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__13233);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1659:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1663:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1664:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1664:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1665:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1666:1: ( rule__QualifiedName__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==24) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1666:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl3260);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1680:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1684:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1685:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__03295);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03298);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1692:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1696:1: ( ( '.' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1697:1: ( '.' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1697:1: ( '.' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1698:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,24,FOLLOW_24_in_rule__QualifiedName__Group_1__0__Impl3326); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1711:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1715:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1716:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__13357);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1722:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1726:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1727:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1727:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1728:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl3384); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1744:1: rule__CoordinatorDeclaration__GranularityAssignment_0 : ( ( 'per_class' ) ) ;
    public final void rule__CoordinatorDeclaration__GranularityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1748:1: ( ( ( 'per_class' ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1749:1: ( ( 'per_class' ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1749:1: ( ( 'per_class' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1750:1: ( 'per_class' )
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getGranularityPer_classKeyword_0_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1751:1: ( 'per_class' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1752:1: 'per_class'
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getGranularityPer_classKeyword_0_0()); 
            match(input,25,FOLLOW_25_in_rule__CoordinatorDeclaration__GranularityAssignment_03427); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1767:1: rule__CoordinatorDeclaration__ClassNameAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__CoordinatorDeclaration__ClassNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1771:1: ( ( ruleQualifiedName ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1772:1: ( ruleQualifiedName )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1772:1: ( ruleQualifiedName )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1773:1: ruleQualifiedName
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getClassNameQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__CoordinatorDeclaration__ClassNameAssignment_23466);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1782:1: rule__CoordinatorDeclaration__BodyAssignment_3 : ( ruleCoordinatorBody ) ;
    public final void rule__CoordinatorDeclaration__BodyAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1786:1: ( ( ruleCoordinatorBody ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1787:1: ( ruleCoordinatorBody )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1787:1: ( ruleCoordinatorBody )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1788:1: ruleCoordinatorBody
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getBodyCoordinatorBodyParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleCoordinatorBody_in_rule__CoordinatorDeclaration__BodyAssignment_33497);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1797:1: rule__CoordinatorBody__CondVarsAssignment_2_1 : ( ruleCondVar ) ;
    public final void rule__CoordinatorBody__CondVarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1801:1: ( ( ruleCondVar ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1802:1: ( ruleCondVar )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1802:1: ( ruleCondVar )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1803:1: ruleCondVar
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCondVarsCondVarParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleCondVar_in_rule__CoordinatorBody__CondVarsAssignment_2_13528);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1812:1: rule__CoordinatorBody__CondVarsAssignment_2_2_1 : ( ruleCondVar ) ;
    public final void rule__CoordinatorBody__CondVarsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1816:1: ( ( ruleCondVar ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1817:1: ( ruleCondVar )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1817:1: ( ruleCondVar )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1818:1: ruleCondVar
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCondVarsCondVarParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_ruleCondVar_in_rule__CoordinatorBody__CondVarsAssignment_2_2_13559);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1827:1: rule__CoordinatorBody__OrdVarsAssignment_3_1 : ( ruleOrdVar ) ;
    public final void rule__CoordinatorBody__OrdVarsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1831:1: ( ( ruleOrdVar ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1832:1: ( ruleOrdVar )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1832:1: ( ruleOrdVar )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1833:1: ruleOrdVar
            {
             before(grammarAccess.getCoordinatorBodyAccess().getOrdVarsOrdVarParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleOrdVar_in_rule__CoordinatorBody__OrdVarsAssignment_3_13590);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1842:1: rule__CoordinatorBody__OrdVarsAssignment_3_2_1 : ( ruleOrdVar ) ;
    public final void rule__CoordinatorBody__OrdVarsAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1846:1: ( ( ruleOrdVar ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1847:1: ( ruleOrdVar )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1847:1: ( ruleOrdVar )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1848:1: ruleOrdVar
            {
             before(grammarAccess.getCoordinatorBodyAccess().getOrdVarsOrdVarParserRuleCall_3_2_1_0()); 
            pushFollow(FOLLOW_ruleOrdVar_in_rule__CoordinatorBody__OrdVarsAssignment_3_2_13621);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1857:1: rule__CoordinatorBody__SelfexMethodsAssignment_4_1 : ( ruleQualifiedName ) ;
    public final void rule__CoordinatorBody__SelfexMethodsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1861:1: ( ( ruleQualifiedName ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1862:1: ( ruleQualifiedName )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1862:1: ( ruleQualifiedName )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1863:1: ruleQualifiedName
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsQualifiedNameParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__CoordinatorBody__SelfexMethodsAssignment_4_13652);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1872:1: rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 : ( ruleQualifiedName ) ;
    public final void rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1876:1: ( ( ruleQualifiedName ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1877:1: ( ruleQualifiedName )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1877:1: ( ruleQualifiedName )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1878:1: ruleQualifiedName
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsQualifiedNameParserRuleCall_4_2_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__CoordinatorBody__SelfexMethodsAssignment_4_2_13683);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1887:1: rule__CoordinatorBody__MutexSetsAssignment_5 : ( ruleMutexSet ) ;
    public final void rule__CoordinatorBody__MutexSetsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1891:1: ( ( ruleMutexSet ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1892:1: ( ruleMutexSet )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1892:1: ( ruleMutexSet )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1893:1: ruleMutexSet
            {
             before(grammarAccess.getCoordinatorBodyAccess().getMutexSetsMutexSetParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleMutexSet_in_rule__CoordinatorBody__MutexSetsAssignment_53714);
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


    // $ANTLR start "rule__MutexSet__MethodsAssignment_2"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1902:1: rule__MutexSet__MethodsAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__MutexSet__MethodsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1906:1: ( ( ruleQualifiedName ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1907:1: ( ruleQualifiedName )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1907:1: ( ruleQualifiedName )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1908:1: ruleQualifiedName
            {
             before(grammarAccess.getMutexSetAccess().getMethodsQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__MutexSet__MethodsAssignment_23745);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getMutexSetAccess().getMethodsQualifiedNameParserRuleCall_2_0()); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1917:1: rule__MutexSet__MethodsAssignment_3_1 : ( ruleQualifiedName ) ;
    public final void rule__MutexSet__MethodsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1921:1: ( ( ruleQualifiedName ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1922:1: ( ruleQualifiedName )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1922:1: ( ruleQualifiedName )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1923:1: ruleQualifiedName
            {
             before(grammarAccess.getMutexSetAccess().getMethodsQualifiedNameParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__MutexSet__MethodsAssignment_3_13776);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getMutexSetAccess().getMethodsQualifiedNameParserRuleCall_3_1_0()); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1932:1: rule__CondVar__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__CondVar__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1936:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1937:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1937:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1938:1: RULE_ID
            {
             before(grammarAccess.getCondVarAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__CondVar__NameAssignment_03807); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1947:1: rule__CondVar__ValueAssignment_2 : ( ruleBooleanVal ) ;
    public final void rule__CondVar__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1951:1: ( ( ruleBooleanVal ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1952:1: ( ruleBooleanVal )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1952:1: ( ruleBooleanVal )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1953:1: ruleBooleanVal
            {
             before(grammarAccess.getCondVarAccess().getValueBooleanValParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleBooleanVal_in_rule__CondVar__ValueAssignment_23838);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1962:1: rule__OrdVar__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__OrdVar__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1966:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1967:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1967:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1968:1: RULE_ID
            {
             before(grammarAccess.getOrdVarAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__OrdVar__NameAssignment_03869); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1977:1: rule__OrdVar__ValueAssignment_2 : ( RULE_INT ) ;
    public final void rule__OrdVar__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1981:1: ( ( RULE_INT ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1982:1: ( RULE_INT )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1982:1: ( RULE_INT )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1983:1: RULE_INT
            {
             before(grammarAccess.getOrdVarAccess().getValueINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__OrdVar__ValueAssignment_23900); 
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
    public static final BitSet FOLLOW_ruleMutexSet_in_entryRuleMutexSet181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMutexSet188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__0_in_ruleMutexSet214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondVar_in_entryRuleCondVar241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCondVar248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__Group__0_in_ruleCondVar274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrdVar_in_entryRuleOrdVar301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrdVar308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__0_in_ruleOrdVar334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanVal_in_entryRuleBooleanVal361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanVal368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanVal__Alternatives_in_ruleBooleanVal394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__BooleanVal__Alternatives491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__BooleanVal__Alternatives511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__0__Impl_in_rule__CoordinatorDeclaration__Group__0543 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__1_in_rule__CoordinatorDeclaration__Group__0546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__GranularityAssignment_0_in_rule__CoordinatorDeclaration__Group__0__Impl573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__1__Impl_in_rule__CoordinatorDeclaration__Group__1604 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__2_in_rule__CoordinatorDeclaration__Group__1607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__CoordinatorDeclaration__Group__1__Impl635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__2__Impl_in_rule__CoordinatorDeclaration__Group__2666 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__3_in_rule__CoordinatorDeclaration__Group__2669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__ClassNameAssignment_2_in_rule__CoordinatorDeclaration__Group__2__Impl696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__3__Impl_in_rule__CoordinatorDeclaration__Group__3726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__BodyAssignment_3_in_rule__CoordinatorDeclaration__Group__3__Impl753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__0__Impl_in_rule__CoordinatorBody__Group__0792 = new BitSet(new long[]{0x0000000000398000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__1_in_rule__CoordinatorBody__Group__0795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__CoordinatorBody__Group__0__Impl823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__1__Impl_in_rule__CoordinatorBody__Group__1854 = new BitSet(new long[]{0x0000000000398000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__2_in_rule__CoordinatorBody__Group__1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__2__Impl_in_rule__CoordinatorBody__Group__2915 = new BitSet(new long[]{0x0000000000398000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__3_in_rule__CoordinatorBody__Group__2918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__0_in_rule__CoordinatorBody__Group__2__Impl945 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__3__Impl_in_rule__CoordinatorBody__Group__3976 = new BitSet(new long[]{0x0000000000398000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__4_in_rule__CoordinatorBody__Group__3979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__0_in_rule__CoordinatorBody__Group__3__Impl1006 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__4__Impl_in_rule__CoordinatorBody__Group__41037 = new BitSet(new long[]{0x0000000000398000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__5_in_rule__CoordinatorBody__Group__41040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__0_in_rule__CoordinatorBody__Group__4__Impl1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__5__Impl_in_rule__CoordinatorBody__Group__51098 = new BitSet(new long[]{0x0000000000398000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__6_in_rule__CoordinatorBody__Group__51101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__MutexSetsAssignment_5_in_rule__CoordinatorBody__Group__5__Impl1128 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__6__Impl_in_rule__CoordinatorBody__Group__61159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__CoordinatorBody__Group__6__Impl1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__0__Impl_in_rule__CoordinatorBody__Group_2__01232 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__1_in_rule__CoordinatorBody__Group_2__01235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__CoordinatorBody__Group_2__0__Impl1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__1__Impl_in_rule__CoordinatorBody__Group_2__11294 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__2_in_rule__CoordinatorBody__Group_2__11297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__CondVarsAssignment_2_1_in_rule__CoordinatorBody__Group_2__1__Impl1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__2__Impl_in_rule__CoordinatorBody__Group_2__21354 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__3_in_rule__CoordinatorBody__Group_2__21357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2_2__0_in_rule__CoordinatorBody__Group_2__2__Impl1384 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__3__Impl_in_rule__CoordinatorBody__Group_2__31415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__CoordinatorBody__Group_2__3__Impl1443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2_2__0__Impl_in_rule__CoordinatorBody__Group_2_2__01482 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2_2__1_in_rule__CoordinatorBody__Group_2_2__01485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__CoordinatorBody__Group_2_2__0__Impl1513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2_2__1__Impl_in_rule__CoordinatorBody__Group_2_2__11544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__CondVarsAssignment_2_2_1_in_rule__CoordinatorBody__Group_2_2__1__Impl1571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__0__Impl_in_rule__CoordinatorBody__Group_3__01605 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__1_in_rule__CoordinatorBody__Group_3__01608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__CoordinatorBody__Group_3__0__Impl1636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__1__Impl_in_rule__CoordinatorBody__Group_3__11667 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__2_in_rule__CoordinatorBody__Group_3__11670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__OrdVarsAssignment_3_1_in_rule__CoordinatorBody__Group_3__1__Impl1697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__2__Impl_in_rule__CoordinatorBody__Group_3__21727 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__3_in_rule__CoordinatorBody__Group_3__21730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3_2__0_in_rule__CoordinatorBody__Group_3__2__Impl1757 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__3__Impl_in_rule__CoordinatorBody__Group_3__31788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__CoordinatorBody__Group_3__3__Impl1816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3_2__0__Impl_in_rule__CoordinatorBody__Group_3_2__01855 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3_2__1_in_rule__CoordinatorBody__Group_3_2__01858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__CoordinatorBody__Group_3_2__0__Impl1886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3_2__1__Impl_in_rule__CoordinatorBody__Group_3_2__11917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__OrdVarsAssignment_3_2_1_in_rule__CoordinatorBody__Group_3_2__1__Impl1944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__0__Impl_in_rule__CoordinatorBody__Group_4__01978 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__1_in_rule__CoordinatorBody__Group_4__01981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__CoordinatorBody__Group_4__0__Impl2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__1__Impl_in_rule__CoordinatorBody__Group_4__12040 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__2_in_rule__CoordinatorBody__Group_4__12043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__SelfexMethodsAssignment_4_1_in_rule__CoordinatorBody__Group_4__1__Impl2070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__2__Impl_in_rule__CoordinatorBody__Group_4__22100 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__3_in_rule__CoordinatorBody__Group_4__22103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4_2__0_in_rule__CoordinatorBody__Group_4__2__Impl2130 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__3__Impl_in_rule__CoordinatorBody__Group_4__32161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__CoordinatorBody__Group_4__3__Impl2189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4_2__0__Impl_in_rule__CoordinatorBody__Group_4_2__02228 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4_2__1_in_rule__CoordinatorBody__Group_4_2__02231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__CoordinatorBody__Group_4_2__0__Impl2259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4_2__1__Impl_in_rule__CoordinatorBody__Group_4_2__12290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1_in_rule__CoordinatorBody__Group_4_2__1__Impl2317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__0__Impl_in_rule__MutexSet__Group__02351 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__1_in_rule__MutexSet__Group__02354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__MutexSet__Group__0__Impl2382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__1__Impl_in_rule__MutexSet__Group__12413 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__2_in_rule__MutexSet__Group__12416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__MutexSet__Group__1__Impl2444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__2__Impl_in_rule__MutexSet__Group__22475 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__3_in_rule__MutexSet__Group__22478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__MethodsAssignment_2_in_rule__MutexSet__Group__2__Impl2505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__3__Impl_in_rule__MutexSet__Group__32535 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__4_in_rule__MutexSet__Group__32538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group_3__0_in_rule__MutexSet__Group__3__Impl2567 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group_3__0_in_rule__MutexSet__Group__3__Impl2579 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group__4__Impl_in_rule__MutexSet__Group__42612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__MutexSet__Group__4__Impl2640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group_3__0__Impl_in_rule__MutexSet__Group_3__02681 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MutexSet__Group_3__1_in_rule__MutexSet__Group_3__02684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__MutexSet__Group_3__0__Impl2712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__Group_3__1__Impl_in_rule__MutexSet__Group_3__12743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MutexSet__MethodsAssignment_3_1_in_rule__MutexSet__Group_3__1__Impl2770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__Group__0__Impl_in_rule__CondVar__Group__02804 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__CondVar__Group__1_in_rule__CondVar__Group__02807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__NameAssignment_0_in_rule__CondVar__Group__0__Impl2834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__Group__1__Impl_in_rule__CondVar__Group__12864 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__CondVar__Group__2_in_rule__CondVar__Group__12867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__CondVar__Group__1__Impl2895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__Group__2__Impl_in_rule__CondVar__Group__22926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__ValueAssignment_2_in_rule__CondVar__Group__2__Impl2953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__0__Impl_in_rule__OrdVar__Group__02989 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__1_in_rule__OrdVar__Group__02992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__NameAssignment_0_in_rule__OrdVar__Group__0__Impl3019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__1__Impl_in_rule__OrdVar__Group__13049 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__2_in_rule__OrdVar__Group__13052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__OrdVar__Group__1__Impl3080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__2__Impl_in_rule__OrdVar__Group__23111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__ValueAssignment_2_in_rule__OrdVar__Group__2__Impl3138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__03174 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__03177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl3204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__13233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl3260 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__03295 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__QualifiedName__Group_1__0__Impl3326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__13357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl3384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__CoordinatorDeclaration__GranularityAssignment_03427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__CoordinatorDeclaration__ClassNameAssignment_23466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCoordinatorBody_in_rule__CoordinatorDeclaration__BodyAssignment_33497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondVar_in_rule__CoordinatorBody__CondVarsAssignment_2_13528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondVar_in_rule__CoordinatorBody__CondVarsAssignment_2_2_13559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrdVar_in_rule__CoordinatorBody__OrdVarsAssignment_3_13590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrdVar_in_rule__CoordinatorBody__OrdVarsAssignment_3_2_13621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__CoordinatorBody__SelfexMethodsAssignment_4_13652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__CoordinatorBody__SelfexMethodsAssignment_4_2_13683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMutexSet_in_rule__CoordinatorBody__MutexSetsAssignment_53714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__MutexSet__MethodsAssignment_23745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__MutexSet__MethodsAssignment_3_13776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__CondVar__NameAssignment_03807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanVal_in_rule__CondVar__ValueAssignment_23838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__OrdVar__NameAssignment_03869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__OrdVar__ValueAssignment_23900 = new BitSet(new long[]{0x0000000000000002L});

}