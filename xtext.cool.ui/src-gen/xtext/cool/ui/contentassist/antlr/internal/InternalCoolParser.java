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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'coordinator'", "'{'", "'}'", "'condition'", "';'", "','", "'int'", "'selfex'", "'='", "'.'", "'per_class'"
    };
    public static final int RULE_ID=4;
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


    // $ANTLR start "entryRuleCondVar"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:116:1: entryRuleCondVar : ruleCondVar EOF ;
    public final void entryRuleCondVar() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:117:1: ( ruleCondVar EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:118:1: ruleCondVar EOF
            {
             before(grammarAccess.getCondVarRule()); 
            pushFollow(FOLLOW_ruleCondVar_in_entryRuleCondVar181);
            ruleCondVar();

            state._fsp--;

             after(grammarAccess.getCondVarRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCondVar188); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:125:1: ruleCondVar : ( ( rule__CondVar__Group__0 ) ) ;
    public final void ruleCondVar() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:129:2: ( ( ( rule__CondVar__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:130:1: ( ( rule__CondVar__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:130:1: ( ( rule__CondVar__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:131:1: ( rule__CondVar__Group__0 )
            {
             before(grammarAccess.getCondVarAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:132:1: ( rule__CondVar__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:132:2: rule__CondVar__Group__0
            {
            pushFollow(FOLLOW_rule__CondVar__Group__0_in_ruleCondVar214);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:144:1: entryRuleOrdVar : ruleOrdVar EOF ;
    public final void entryRuleOrdVar() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:145:1: ( ruleOrdVar EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:146:1: ruleOrdVar EOF
            {
             before(grammarAccess.getOrdVarRule()); 
            pushFollow(FOLLOW_ruleOrdVar_in_entryRuleOrdVar241);
            ruleOrdVar();

            state._fsp--;

             after(grammarAccess.getOrdVarRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrdVar248); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:153:1: ruleOrdVar : ( ( rule__OrdVar__Group__0 ) ) ;
    public final void ruleOrdVar() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:157:2: ( ( ( rule__OrdVar__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:158:1: ( ( rule__OrdVar__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:158:1: ( ( rule__OrdVar__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:159:1: ( rule__OrdVar__Group__0 )
            {
             before(grammarAccess.getOrdVarAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:160:1: ( rule__OrdVar__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:160:2: rule__OrdVar__Group__0
            {
            pushFollow(FOLLOW_rule__OrdVar__Group__0_in_ruleOrdVar274);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:172:1: entryRuleBooleanVal : ruleBooleanVal EOF ;
    public final void entryRuleBooleanVal() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:173:1: ( ruleBooleanVal EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:174:1: ruleBooleanVal EOF
            {
             before(grammarAccess.getBooleanValRule()); 
            pushFollow(FOLLOW_ruleBooleanVal_in_entryRuleBooleanVal301);
            ruleBooleanVal();

            state._fsp--;

             after(grammarAccess.getBooleanValRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanVal308); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:181:1: ruleBooleanVal : ( ( rule__BooleanVal__Alternatives ) ) ;
    public final void ruleBooleanVal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:185:2: ( ( ( rule__BooleanVal__Alternatives ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:186:1: ( ( rule__BooleanVal__Alternatives ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:186:1: ( ( rule__BooleanVal__Alternatives ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:187:1: ( rule__BooleanVal__Alternatives )
            {
             before(grammarAccess.getBooleanValAccess().getAlternatives()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:188:1: ( rule__BooleanVal__Alternatives )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:188:2: rule__BooleanVal__Alternatives
            {
            pushFollow(FOLLOW_rule__BooleanVal__Alternatives_in_ruleBooleanVal334);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:200:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:201:1: ( ruleQualifiedName EOF )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:202:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName361);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName368); 

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:209:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:213:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:214:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:214:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:215:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:216:1: ( rule__QualifiedName__Group__0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:216:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName394);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:228:1: rule__BooleanVal__Alternatives : ( ( 'true' ) | ( 'false' ) );
    public final void rule__BooleanVal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:232:1: ( ( 'true' ) | ( 'false' ) )
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
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:233:1: ( 'true' )
                    {
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:233:1: ( 'true' )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:234:1: 'true'
                    {
                     before(grammarAccess.getBooleanValAccess().getTrueKeyword_0()); 
                    match(input,11,FOLLOW_11_in_rule__BooleanVal__Alternatives431); 
                     after(grammarAccess.getBooleanValAccess().getTrueKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:241:6: ( 'false' )
                    {
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:241:6: ( 'false' )
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:242:1: 'false'
                    {
                     before(grammarAccess.getBooleanValAccess().getFalseKeyword_1()); 
                    match(input,12,FOLLOW_12_in_rule__BooleanVal__Alternatives451); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:256:1: rule__CoordinatorDeclaration__Group__0 : rule__CoordinatorDeclaration__Group__0__Impl rule__CoordinatorDeclaration__Group__1 ;
    public final void rule__CoordinatorDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:260:1: ( rule__CoordinatorDeclaration__Group__0__Impl rule__CoordinatorDeclaration__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:261:2: rule__CoordinatorDeclaration__Group__0__Impl rule__CoordinatorDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__0__Impl_in_rule__CoordinatorDeclaration__Group__0483);
            rule__CoordinatorDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__1_in_rule__CoordinatorDeclaration__Group__0486);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:268:1: rule__CoordinatorDeclaration__Group__0__Impl : ( ( rule__CoordinatorDeclaration__GranularityAssignment_0 )? ) ;
    public final void rule__CoordinatorDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:272:1: ( ( ( rule__CoordinatorDeclaration__GranularityAssignment_0 )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:273:1: ( ( rule__CoordinatorDeclaration__GranularityAssignment_0 )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:273:1: ( ( rule__CoordinatorDeclaration__GranularityAssignment_0 )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:274:1: ( rule__CoordinatorDeclaration__GranularityAssignment_0 )?
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getGranularityAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:275:1: ( rule__CoordinatorDeclaration__GranularityAssignment_0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==23) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:275:2: rule__CoordinatorDeclaration__GranularityAssignment_0
                    {
                    pushFollow(FOLLOW_rule__CoordinatorDeclaration__GranularityAssignment_0_in_rule__CoordinatorDeclaration__Group__0__Impl513);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:285:1: rule__CoordinatorDeclaration__Group__1 : rule__CoordinatorDeclaration__Group__1__Impl rule__CoordinatorDeclaration__Group__2 ;
    public final void rule__CoordinatorDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:289:1: ( rule__CoordinatorDeclaration__Group__1__Impl rule__CoordinatorDeclaration__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:290:2: rule__CoordinatorDeclaration__Group__1__Impl rule__CoordinatorDeclaration__Group__2
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__1__Impl_in_rule__CoordinatorDeclaration__Group__1544);
            rule__CoordinatorDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__2_in_rule__CoordinatorDeclaration__Group__1547);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:297:1: rule__CoordinatorDeclaration__Group__1__Impl : ( 'coordinator' ) ;
    public final void rule__CoordinatorDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:301:1: ( ( 'coordinator' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:302:1: ( 'coordinator' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:302:1: ( 'coordinator' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:303:1: 'coordinator'
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getCoordinatorKeyword_1()); 
            match(input,13,FOLLOW_13_in_rule__CoordinatorDeclaration__Group__1__Impl575); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:316:1: rule__CoordinatorDeclaration__Group__2 : rule__CoordinatorDeclaration__Group__2__Impl rule__CoordinatorDeclaration__Group__3 ;
    public final void rule__CoordinatorDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:320:1: ( rule__CoordinatorDeclaration__Group__2__Impl rule__CoordinatorDeclaration__Group__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:321:2: rule__CoordinatorDeclaration__Group__2__Impl rule__CoordinatorDeclaration__Group__3
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__2__Impl_in_rule__CoordinatorDeclaration__Group__2606);
            rule__CoordinatorDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__3_in_rule__CoordinatorDeclaration__Group__2609);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:328:1: rule__CoordinatorDeclaration__Group__2__Impl : ( ( rule__CoordinatorDeclaration__ClassNameAssignment_2 ) ) ;
    public final void rule__CoordinatorDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:332:1: ( ( ( rule__CoordinatorDeclaration__ClassNameAssignment_2 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:333:1: ( ( rule__CoordinatorDeclaration__ClassNameAssignment_2 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:333:1: ( ( rule__CoordinatorDeclaration__ClassNameAssignment_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:334:1: ( rule__CoordinatorDeclaration__ClassNameAssignment_2 )
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getClassNameAssignment_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:335:1: ( rule__CoordinatorDeclaration__ClassNameAssignment_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:335:2: rule__CoordinatorDeclaration__ClassNameAssignment_2
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__ClassNameAssignment_2_in_rule__CoordinatorDeclaration__Group__2__Impl636);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:345:1: rule__CoordinatorDeclaration__Group__3 : rule__CoordinatorDeclaration__Group__3__Impl ;
    public final void rule__CoordinatorDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:349:1: ( rule__CoordinatorDeclaration__Group__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:350:2: rule__CoordinatorDeclaration__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorDeclaration__Group__3__Impl_in_rule__CoordinatorDeclaration__Group__3666);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:356:1: rule__CoordinatorDeclaration__Group__3__Impl : ( ( rule__CoordinatorDeclaration__BodyAssignment_3 )? ) ;
    public final void rule__CoordinatorDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:360:1: ( ( ( rule__CoordinatorDeclaration__BodyAssignment_3 )? ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:361:1: ( ( rule__CoordinatorDeclaration__BodyAssignment_3 )? )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:361:1: ( ( rule__CoordinatorDeclaration__BodyAssignment_3 )? )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:362:1: ( rule__CoordinatorDeclaration__BodyAssignment_3 )?
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getBodyAssignment_3()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:363:1: ( rule__CoordinatorDeclaration__BodyAssignment_3 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:363:2: rule__CoordinatorDeclaration__BodyAssignment_3
                    {
                    pushFollow(FOLLOW_rule__CoordinatorDeclaration__BodyAssignment_3_in_rule__CoordinatorDeclaration__Group__3__Impl693);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:381:1: rule__CoordinatorBody__Group__0 : rule__CoordinatorBody__Group__0__Impl rule__CoordinatorBody__Group__1 ;
    public final void rule__CoordinatorBody__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:385:1: ( rule__CoordinatorBody__Group__0__Impl rule__CoordinatorBody__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:386:2: rule__CoordinatorBody__Group__0__Impl rule__CoordinatorBody__Group__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__0__Impl_in_rule__CoordinatorBody__Group__0732);
            rule__CoordinatorBody__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__1_in_rule__CoordinatorBody__Group__0735);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:393:1: rule__CoordinatorBody__Group__0__Impl : ( '{' ) ;
    public final void rule__CoordinatorBody__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:397:1: ( ( '{' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:398:1: ( '{' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:398:1: ( '{' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:399:1: '{'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,14,FOLLOW_14_in_rule__CoordinatorBody__Group__0__Impl763); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:412:1: rule__CoordinatorBody__Group__1 : rule__CoordinatorBody__Group__1__Impl rule__CoordinatorBody__Group__2 ;
    public final void rule__CoordinatorBody__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:416:1: ( rule__CoordinatorBody__Group__1__Impl rule__CoordinatorBody__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:417:2: rule__CoordinatorBody__Group__1__Impl rule__CoordinatorBody__Group__2
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__1__Impl_in_rule__CoordinatorBody__Group__1794);
            rule__CoordinatorBody__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__2_in_rule__CoordinatorBody__Group__1797);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:424:1: rule__CoordinatorBody__Group__1__Impl : ( () ) ;
    public final void rule__CoordinatorBody__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:428:1: ( ( () ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:429:1: ( () )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:429:1: ( () )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:430:1: ()
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCoordinatorBodyAction_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:431:1: ()
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:433:1: 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:443:1: rule__CoordinatorBody__Group__2 : rule__CoordinatorBody__Group__2__Impl rule__CoordinatorBody__Group__3 ;
    public final void rule__CoordinatorBody__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:447:1: ( rule__CoordinatorBody__Group__2__Impl rule__CoordinatorBody__Group__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:448:2: rule__CoordinatorBody__Group__2__Impl rule__CoordinatorBody__Group__3
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__2__Impl_in_rule__CoordinatorBody__Group__2855);
            rule__CoordinatorBody__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__3_in_rule__CoordinatorBody__Group__2858);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:455:1: rule__CoordinatorBody__Group__2__Impl : ( ( rule__CoordinatorBody__Group_2__0 )* ) ;
    public final void rule__CoordinatorBody__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:459:1: ( ( ( rule__CoordinatorBody__Group_2__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:460:1: ( ( rule__CoordinatorBody__Group_2__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:460:1: ( ( rule__CoordinatorBody__Group_2__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:461:1: ( rule__CoordinatorBody__Group_2__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:462:1: ( rule__CoordinatorBody__Group_2__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:462:2: rule__CoordinatorBody__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__0_in_rule__CoordinatorBody__Group__2__Impl885);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:472:1: rule__CoordinatorBody__Group__3 : rule__CoordinatorBody__Group__3__Impl rule__CoordinatorBody__Group__4 ;
    public final void rule__CoordinatorBody__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:476:1: ( rule__CoordinatorBody__Group__3__Impl rule__CoordinatorBody__Group__4 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:477:2: rule__CoordinatorBody__Group__3__Impl rule__CoordinatorBody__Group__4
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__3__Impl_in_rule__CoordinatorBody__Group__3916);
            rule__CoordinatorBody__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__4_in_rule__CoordinatorBody__Group__3919);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:484:1: rule__CoordinatorBody__Group__3__Impl : ( ( rule__CoordinatorBody__Group_3__0 )* ) ;
    public final void rule__CoordinatorBody__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:488:1: ( ( ( rule__CoordinatorBody__Group_3__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:489:1: ( ( rule__CoordinatorBody__Group_3__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:489:1: ( ( rule__CoordinatorBody__Group_3__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:490:1: ( rule__CoordinatorBody__Group_3__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_3()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:491:1: ( rule__CoordinatorBody__Group_3__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:491:2: rule__CoordinatorBody__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__0_in_rule__CoordinatorBody__Group__3__Impl946);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:501:1: rule__CoordinatorBody__Group__4 : rule__CoordinatorBody__Group__4__Impl rule__CoordinatorBody__Group__5 ;
    public final void rule__CoordinatorBody__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:505:1: ( rule__CoordinatorBody__Group__4__Impl rule__CoordinatorBody__Group__5 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:506:2: rule__CoordinatorBody__Group__4__Impl rule__CoordinatorBody__Group__5
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__4__Impl_in_rule__CoordinatorBody__Group__4977);
            rule__CoordinatorBody__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group__5_in_rule__CoordinatorBody__Group__4980);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:513:1: rule__CoordinatorBody__Group__4__Impl : ( ( rule__CoordinatorBody__Group_4__0 )* ) ;
    public final void rule__CoordinatorBody__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:517:1: ( ( ( rule__CoordinatorBody__Group_4__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:518:1: ( ( rule__CoordinatorBody__Group_4__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:518:1: ( ( rule__CoordinatorBody__Group_4__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:519:1: ( rule__CoordinatorBody__Group_4__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_4()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:520:1: ( rule__CoordinatorBody__Group_4__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:520:2: rule__CoordinatorBody__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__0_in_rule__CoordinatorBody__Group__4__Impl1007);
            	    rule__CoordinatorBody__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:530:1: rule__CoordinatorBody__Group__5 : rule__CoordinatorBody__Group__5__Impl ;
    public final void rule__CoordinatorBody__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:534:1: ( rule__CoordinatorBody__Group__5__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:535:2: rule__CoordinatorBody__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group__5__Impl_in_rule__CoordinatorBody__Group__51038);
            rule__CoordinatorBody__Group__5__Impl();

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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:541:1: rule__CoordinatorBody__Group__5__Impl : ( '}' ) ;
    public final void rule__CoordinatorBody__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:545:1: ( ( '}' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:546:1: ( '}' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:546:1: ( '}' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:547:1: '}'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getRightCurlyBracketKeyword_5()); 
            match(input,15,FOLLOW_15_in_rule__CoordinatorBody__Group__5__Impl1066); 
             after(grammarAccess.getCoordinatorBodyAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
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


    // $ANTLR start "rule__CoordinatorBody__Group_2__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:572:1: rule__CoordinatorBody__Group_2__0 : rule__CoordinatorBody__Group_2__0__Impl rule__CoordinatorBody__Group_2__1 ;
    public final void rule__CoordinatorBody__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:576:1: ( rule__CoordinatorBody__Group_2__0__Impl rule__CoordinatorBody__Group_2__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:577:2: rule__CoordinatorBody__Group_2__0__Impl rule__CoordinatorBody__Group_2__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__0__Impl_in_rule__CoordinatorBody__Group_2__01109);
            rule__CoordinatorBody__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__1_in_rule__CoordinatorBody__Group_2__01112);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:584:1: rule__CoordinatorBody__Group_2__0__Impl : ( 'condition' ) ;
    public final void rule__CoordinatorBody__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:588:1: ( ( 'condition' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:589:1: ( 'condition' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:589:1: ( 'condition' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:590:1: 'condition'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getConditionKeyword_2_0()); 
            match(input,16,FOLLOW_16_in_rule__CoordinatorBody__Group_2__0__Impl1140); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:603:1: rule__CoordinatorBody__Group_2__1 : rule__CoordinatorBody__Group_2__1__Impl rule__CoordinatorBody__Group_2__2 ;
    public final void rule__CoordinatorBody__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:607:1: ( rule__CoordinatorBody__Group_2__1__Impl rule__CoordinatorBody__Group_2__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:608:2: rule__CoordinatorBody__Group_2__1__Impl rule__CoordinatorBody__Group_2__2
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__1__Impl_in_rule__CoordinatorBody__Group_2__11171);
            rule__CoordinatorBody__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__2_in_rule__CoordinatorBody__Group_2__11174);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:615:1: rule__CoordinatorBody__Group_2__1__Impl : ( ( rule__CoordinatorBody__CondVarsAssignment_2_1 ) ) ;
    public final void rule__CoordinatorBody__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:619:1: ( ( ( rule__CoordinatorBody__CondVarsAssignment_2_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:620:1: ( ( rule__CoordinatorBody__CondVarsAssignment_2_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:620:1: ( ( rule__CoordinatorBody__CondVarsAssignment_2_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:621:1: ( rule__CoordinatorBody__CondVarsAssignment_2_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCondVarsAssignment_2_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:622:1: ( rule__CoordinatorBody__CondVarsAssignment_2_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:622:2: rule__CoordinatorBody__CondVarsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__CondVarsAssignment_2_1_in_rule__CoordinatorBody__Group_2__1__Impl1201);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:632:1: rule__CoordinatorBody__Group_2__2 : rule__CoordinatorBody__Group_2__2__Impl rule__CoordinatorBody__Group_2__3 ;
    public final void rule__CoordinatorBody__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:636:1: ( rule__CoordinatorBody__Group_2__2__Impl rule__CoordinatorBody__Group_2__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:637:2: rule__CoordinatorBody__Group_2__2__Impl rule__CoordinatorBody__Group_2__3
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__2__Impl_in_rule__CoordinatorBody__Group_2__21231);
            rule__CoordinatorBody__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__3_in_rule__CoordinatorBody__Group_2__21234);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:644:1: rule__CoordinatorBody__Group_2__2__Impl : ( ( rule__CoordinatorBody__Group_2_2__0 )* ) ;
    public final void rule__CoordinatorBody__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:648:1: ( ( ( rule__CoordinatorBody__Group_2_2__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:649:1: ( ( rule__CoordinatorBody__Group_2_2__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:649:1: ( ( rule__CoordinatorBody__Group_2_2__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:650:1: ( rule__CoordinatorBody__Group_2_2__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_2_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:651:1: ( rule__CoordinatorBody__Group_2_2__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:651:2: rule__CoordinatorBody__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_2_2__0_in_rule__CoordinatorBody__Group_2__2__Impl1261);
            	    rule__CoordinatorBody__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:661:1: rule__CoordinatorBody__Group_2__3 : rule__CoordinatorBody__Group_2__3__Impl ;
    public final void rule__CoordinatorBody__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:665:1: ( rule__CoordinatorBody__Group_2__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:666:2: rule__CoordinatorBody__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2__3__Impl_in_rule__CoordinatorBody__Group_2__31292);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:672:1: rule__CoordinatorBody__Group_2__3__Impl : ( ';' ) ;
    public final void rule__CoordinatorBody__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:676:1: ( ( ';' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:677:1: ( ';' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:677:1: ( ';' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:678:1: ';'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_2_3()); 
            match(input,17,FOLLOW_17_in_rule__CoordinatorBody__Group_2__3__Impl1320); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:699:1: rule__CoordinatorBody__Group_2_2__0 : rule__CoordinatorBody__Group_2_2__0__Impl rule__CoordinatorBody__Group_2_2__1 ;
    public final void rule__CoordinatorBody__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:703:1: ( rule__CoordinatorBody__Group_2_2__0__Impl rule__CoordinatorBody__Group_2_2__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:704:2: rule__CoordinatorBody__Group_2_2__0__Impl rule__CoordinatorBody__Group_2_2__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2_2__0__Impl_in_rule__CoordinatorBody__Group_2_2__01359);
            rule__CoordinatorBody__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2_2__1_in_rule__CoordinatorBody__Group_2_2__01362);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:711:1: rule__CoordinatorBody__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__CoordinatorBody__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:715:1: ( ( ',' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:716:1: ( ',' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:716:1: ( ',' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:717:1: ','
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_2_2_0()); 
            match(input,18,FOLLOW_18_in_rule__CoordinatorBody__Group_2_2__0__Impl1390); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:730:1: rule__CoordinatorBody__Group_2_2__1 : rule__CoordinatorBody__Group_2_2__1__Impl ;
    public final void rule__CoordinatorBody__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:734:1: ( rule__CoordinatorBody__Group_2_2__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:735:2: rule__CoordinatorBody__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_2_2__1__Impl_in_rule__CoordinatorBody__Group_2_2__11421);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:741:1: rule__CoordinatorBody__Group_2_2__1__Impl : ( ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 ) ) ;
    public final void rule__CoordinatorBody__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:745:1: ( ( ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:746:1: ( ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:746:1: ( ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:747:1: ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCondVarsAssignment_2_2_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:748:1: ( rule__CoordinatorBody__CondVarsAssignment_2_2_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:748:2: rule__CoordinatorBody__CondVarsAssignment_2_2_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__CondVarsAssignment_2_2_1_in_rule__CoordinatorBody__Group_2_2__1__Impl1448);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:762:1: rule__CoordinatorBody__Group_3__0 : rule__CoordinatorBody__Group_3__0__Impl rule__CoordinatorBody__Group_3__1 ;
    public final void rule__CoordinatorBody__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:766:1: ( rule__CoordinatorBody__Group_3__0__Impl rule__CoordinatorBody__Group_3__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:767:2: rule__CoordinatorBody__Group_3__0__Impl rule__CoordinatorBody__Group_3__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__0__Impl_in_rule__CoordinatorBody__Group_3__01482);
            rule__CoordinatorBody__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__1_in_rule__CoordinatorBody__Group_3__01485);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:774:1: rule__CoordinatorBody__Group_3__0__Impl : ( 'int' ) ;
    public final void rule__CoordinatorBody__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:778:1: ( ( 'int' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:779:1: ( 'int' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:779:1: ( 'int' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:780:1: 'int'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getIntKeyword_3_0()); 
            match(input,19,FOLLOW_19_in_rule__CoordinatorBody__Group_3__0__Impl1513); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:793:1: rule__CoordinatorBody__Group_3__1 : rule__CoordinatorBody__Group_3__1__Impl rule__CoordinatorBody__Group_3__2 ;
    public final void rule__CoordinatorBody__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:797:1: ( rule__CoordinatorBody__Group_3__1__Impl rule__CoordinatorBody__Group_3__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:798:2: rule__CoordinatorBody__Group_3__1__Impl rule__CoordinatorBody__Group_3__2
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__1__Impl_in_rule__CoordinatorBody__Group_3__11544);
            rule__CoordinatorBody__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__2_in_rule__CoordinatorBody__Group_3__11547);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:805:1: rule__CoordinatorBody__Group_3__1__Impl : ( ( rule__CoordinatorBody__OrdVarsAssignment_3_1 ) ) ;
    public final void rule__CoordinatorBody__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:809:1: ( ( ( rule__CoordinatorBody__OrdVarsAssignment_3_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:810:1: ( ( rule__CoordinatorBody__OrdVarsAssignment_3_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:810:1: ( ( rule__CoordinatorBody__OrdVarsAssignment_3_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:811:1: ( rule__CoordinatorBody__OrdVarsAssignment_3_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getOrdVarsAssignment_3_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:812:1: ( rule__CoordinatorBody__OrdVarsAssignment_3_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:812:2: rule__CoordinatorBody__OrdVarsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__OrdVarsAssignment_3_1_in_rule__CoordinatorBody__Group_3__1__Impl1574);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:822:1: rule__CoordinatorBody__Group_3__2 : rule__CoordinatorBody__Group_3__2__Impl rule__CoordinatorBody__Group_3__3 ;
    public final void rule__CoordinatorBody__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:826:1: ( rule__CoordinatorBody__Group_3__2__Impl rule__CoordinatorBody__Group_3__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:827:2: rule__CoordinatorBody__Group_3__2__Impl rule__CoordinatorBody__Group_3__3
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__2__Impl_in_rule__CoordinatorBody__Group_3__21604);
            rule__CoordinatorBody__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__3_in_rule__CoordinatorBody__Group_3__21607);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:834:1: rule__CoordinatorBody__Group_3__2__Impl : ( ( rule__CoordinatorBody__Group_3_2__0 )* ) ;
    public final void rule__CoordinatorBody__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:838:1: ( ( ( rule__CoordinatorBody__Group_3_2__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:839:1: ( ( rule__CoordinatorBody__Group_3_2__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:839:1: ( ( rule__CoordinatorBody__Group_3_2__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:840:1: ( rule__CoordinatorBody__Group_3_2__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_3_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:841:1: ( rule__CoordinatorBody__Group_3_2__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==18) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:841:2: rule__CoordinatorBody__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_3_2__0_in_rule__CoordinatorBody__Group_3__2__Impl1634);
            	    rule__CoordinatorBody__Group_3_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:851:1: rule__CoordinatorBody__Group_3__3 : rule__CoordinatorBody__Group_3__3__Impl ;
    public final void rule__CoordinatorBody__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:855:1: ( rule__CoordinatorBody__Group_3__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:856:2: rule__CoordinatorBody__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3__3__Impl_in_rule__CoordinatorBody__Group_3__31665);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:862:1: rule__CoordinatorBody__Group_3__3__Impl : ( ';' ) ;
    public final void rule__CoordinatorBody__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:866:1: ( ( ';' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:867:1: ( ';' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:867:1: ( ';' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:868:1: ';'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_3_3()); 
            match(input,17,FOLLOW_17_in_rule__CoordinatorBody__Group_3__3__Impl1693); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:889:1: rule__CoordinatorBody__Group_3_2__0 : rule__CoordinatorBody__Group_3_2__0__Impl rule__CoordinatorBody__Group_3_2__1 ;
    public final void rule__CoordinatorBody__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:893:1: ( rule__CoordinatorBody__Group_3_2__0__Impl rule__CoordinatorBody__Group_3_2__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:894:2: rule__CoordinatorBody__Group_3_2__0__Impl rule__CoordinatorBody__Group_3_2__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3_2__0__Impl_in_rule__CoordinatorBody__Group_3_2__01732);
            rule__CoordinatorBody__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3_2__1_in_rule__CoordinatorBody__Group_3_2__01735);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:901:1: rule__CoordinatorBody__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__CoordinatorBody__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:905:1: ( ( ',' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:906:1: ( ',' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:906:1: ( ',' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:907:1: ','
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_3_2_0()); 
            match(input,18,FOLLOW_18_in_rule__CoordinatorBody__Group_3_2__0__Impl1763); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:920:1: rule__CoordinatorBody__Group_3_2__1 : rule__CoordinatorBody__Group_3_2__1__Impl ;
    public final void rule__CoordinatorBody__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:924:1: ( rule__CoordinatorBody__Group_3_2__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:925:2: rule__CoordinatorBody__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_3_2__1__Impl_in_rule__CoordinatorBody__Group_3_2__11794);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:931:1: rule__CoordinatorBody__Group_3_2__1__Impl : ( ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 ) ) ;
    public final void rule__CoordinatorBody__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:935:1: ( ( ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:936:1: ( ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:936:1: ( ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:937:1: ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getOrdVarsAssignment_3_2_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:938:1: ( rule__CoordinatorBody__OrdVarsAssignment_3_2_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:938:2: rule__CoordinatorBody__OrdVarsAssignment_3_2_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__OrdVarsAssignment_3_2_1_in_rule__CoordinatorBody__Group_3_2__1__Impl1821);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:952:1: rule__CoordinatorBody__Group_4__0 : rule__CoordinatorBody__Group_4__0__Impl rule__CoordinatorBody__Group_4__1 ;
    public final void rule__CoordinatorBody__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:956:1: ( rule__CoordinatorBody__Group_4__0__Impl rule__CoordinatorBody__Group_4__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:957:2: rule__CoordinatorBody__Group_4__0__Impl rule__CoordinatorBody__Group_4__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__0__Impl_in_rule__CoordinatorBody__Group_4__01855);
            rule__CoordinatorBody__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__1_in_rule__CoordinatorBody__Group_4__01858);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:964:1: rule__CoordinatorBody__Group_4__0__Impl : ( 'selfex' ) ;
    public final void rule__CoordinatorBody__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:968:1: ( ( 'selfex' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:969:1: ( 'selfex' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:969:1: ( 'selfex' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:970:1: 'selfex'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexKeyword_4_0()); 
            match(input,20,FOLLOW_20_in_rule__CoordinatorBody__Group_4__0__Impl1886); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:983:1: rule__CoordinatorBody__Group_4__1 : rule__CoordinatorBody__Group_4__1__Impl rule__CoordinatorBody__Group_4__2 ;
    public final void rule__CoordinatorBody__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:987:1: ( rule__CoordinatorBody__Group_4__1__Impl rule__CoordinatorBody__Group_4__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:988:2: rule__CoordinatorBody__Group_4__1__Impl rule__CoordinatorBody__Group_4__2
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__1__Impl_in_rule__CoordinatorBody__Group_4__11917);
            rule__CoordinatorBody__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__2_in_rule__CoordinatorBody__Group_4__11920);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:995:1: rule__CoordinatorBody__Group_4__1__Impl : ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 ) ) ;
    public final void rule__CoordinatorBody__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:999:1: ( ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1000:1: ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1000:1: ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1001:1: ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsAssignment_4_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1002:1: ( rule__CoordinatorBody__SelfexMethodsAssignment_4_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1002:2: rule__CoordinatorBody__SelfexMethodsAssignment_4_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__SelfexMethodsAssignment_4_1_in_rule__CoordinatorBody__Group_4__1__Impl1947);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1012:1: rule__CoordinatorBody__Group_4__2 : rule__CoordinatorBody__Group_4__2__Impl rule__CoordinatorBody__Group_4__3 ;
    public final void rule__CoordinatorBody__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1016:1: ( rule__CoordinatorBody__Group_4__2__Impl rule__CoordinatorBody__Group_4__3 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1017:2: rule__CoordinatorBody__Group_4__2__Impl rule__CoordinatorBody__Group_4__3
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__2__Impl_in_rule__CoordinatorBody__Group_4__21977);
            rule__CoordinatorBody__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__3_in_rule__CoordinatorBody__Group_4__21980);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1024:1: rule__CoordinatorBody__Group_4__2__Impl : ( ( rule__CoordinatorBody__Group_4_2__0 )* ) ;
    public final void rule__CoordinatorBody__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1028:1: ( ( ( rule__CoordinatorBody__Group_4_2__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1029:1: ( ( rule__CoordinatorBody__Group_4_2__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1029:1: ( ( rule__CoordinatorBody__Group_4_2__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1030:1: ( rule__CoordinatorBody__Group_4_2__0 )*
            {
             before(grammarAccess.getCoordinatorBodyAccess().getGroup_4_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1031:1: ( rule__CoordinatorBody__Group_4_2__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==18) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1031:2: rule__CoordinatorBody__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_rule__CoordinatorBody__Group_4_2__0_in_rule__CoordinatorBody__Group_4__2__Impl2007);
            	    rule__CoordinatorBody__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1041:1: rule__CoordinatorBody__Group_4__3 : rule__CoordinatorBody__Group_4__3__Impl ;
    public final void rule__CoordinatorBody__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1045:1: ( rule__CoordinatorBody__Group_4__3__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1046:2: rule__CoordinatorBody__Group_4__3__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4__3__Impl_in_rule__CoordinatorBody__Group_4__32038);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1052:1: rule__CoordinatorBody__Group_4__3__Impl : ( ';' ) ;
    public final void rule__CoordinatorBody__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1056:1: ( ( ';' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1057:1: ( ';' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1057:1: ( ';' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1058:1: ';'
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSemicolonKeyword_4_3()); 
            match(input,17,FOLLOW_17_in_rule__CoordinatorBody__Group_4__3__Impl2066); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1079:1: rule__CoordinatorBody__Group_4_2__0 : rule__CoordinatorBody__Group_4_2__0__Impl rule__CoordinatorBody__Group_4_2__1 ;
    public final void rule__CoordinatorBody__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1083:1: ( rule__CoordinatorBody__Group_4_2__0__Impl rule__CoordinatorBody__Group_4_2__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1084:2: rule__CoordinatorBody__Group_4_2__0__Impl rule__CoordinatorBody__Group_4_2__1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4_2__0__Impl_in_rule__CoordinatorBody__Group_4_2__02105);
            rule__CoordinatorBody__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4_2__1_in_rule__CoordinatorBody__Group_4_2__02108);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1091:1: rule__CoordinatorBody__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__CoordinatorBody__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1095:1: ( ( ',' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1096:1: ( ',' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1096:1: ( ',' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1097:1: ','
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCommaKeyword_4_2_0()); 
            match(input,18,FOLLOW_18_in_rule__CoordinatorBody__Group_4_2__0__Impl2136); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1110:1: rule__CoordinatorBody__Group_4_2__1 : rule__CoordinatorBody__Group_4_2__1__Impl ;
    public final void rule__CoordinatorBody__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1114:1: ( rule__CoordinatorBody__Group_4_2__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1115:2: rule__CoordinatorBody__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__Group_4_2__1__Impl_in_rule__CoordinatorBody__Group_4_2__12167);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1121:1: rule__CoordinatorBody__Group_4_2__1__Impl : ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 ) ) ;
    public final void rule__CoordinatorBody__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1125:1: ( ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1126:1: ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1126:1: ( ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1127:1: ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 )
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsAssignment_4_2_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1128:1: ( rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1128:2: rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1
            {
            pushFollow(FOLLOW_rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1_in_rule__CoordinatorBody__Group_4_2__1__Impl2194);
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


    // $ANTLR start "rule__CondVar__Group__0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1142:1: rule__CondVar__Group__0 : rule__CondVar__Group__0__Impl rule__CondVar__Group__1 ;
    public final void rule__CondVar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1146:1: ( rule__CondVar__Group__0__Impl rule__CondVar__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1147:2: rule__CondVar__Group__0__Impl rule__CondVar__Group__1
            {
            pushFollow(FOLLOW_rule__CondVar__Group__0__Impl_in_rule__CondVar__Group__02228);
            rule__CondVar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CondVar__Group__1_in_rule__CondVar__Group__02231);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1154:1: rule__CondVar__Group__0__Impl : ( ( rule__CondVar__NameAssignment_0 ) ) ;
    public final void rule__CondVar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1158:1: ( ( ( rule__CondVar__NameAssignment_0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1159:1: ( ( rule__CondVar__NameAssignment_0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1159:1: ( ( rule__CondVar__NameAssignment_0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1160:1: ( rule__CondVar__NameAssignment_0 )
            {
             before(grammarAccess.getCondVarAccess().getNameAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1161:1: ( rule__CondVar__NameAssignment_0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1161:2: rule__CondVar__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__CondVar__NameAssignment_0_in_rule__CondVar__Group__0__Impl2258);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1171:1: rule__CondVar__Group__1 : rule__CondVar__Group__1__Impl rule__CondVar__Group__2 ;
    public final void rule__CondVar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1175:1: ( rule__CondVar__Group__1__Impl rule__CondVar__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1176:2: rule__CondVar__Group__1__Impl rule__CondVar__Group__2
            {
            pushFollow(FOLLOW_rule__CondVar__Group__1__Impl_in_rule__CondVar__Group__12288);
            rule__CondVar__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CondVar__Group__2_in_rule__CondVar__Group__12291);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1183:1: rule__CondVar__Group__1__Impl : ( '=' ) ;
    public final void rule__CondVar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1187:1: ( ( '=' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1188:1: ( '=' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1188:1: ( '=' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1189:1: '='
            {
             before(grammarAccess.getCondVarAccess().getEqualsSignKeyword_1()); 
            match(input,21,FOLLOW_21_in_rule__CondVar__Group__1__Impl2319); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1202:1: rule__CondVar__Group__2 : rule__CondVar__Group__2__Impl ;
    public final void rule__CondVar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1206:1: ( rule__CondVar__Group__2__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1207:2: rule__CondVar__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__CondVar__Group__2__Impl_in_rule__CondVar__Group__22350);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1213:1: rule__CondVar__Group__2__Impl : ( ( rule__CondVar__ValueAssignment_2 ) ) ;
    public final void rule__CondVar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1217:1: ( ( ( rule__CondVar__ValueAssignment_2 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1218:1: ( ( rule__CondVar__ValueAssignment_2 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1218:1: ( ( rule__CondVar__ValueAssignment_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1219:1: ( rule__CondVar__ValueAssignment_2 )
            {
             before(grammarAccess.getCondVarAccess().getValueAssignment_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1220:1: ( rule__CondVar__ValueAssignment_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1220:2: rule__CondVar__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__CondVar__ValueAssignment_2_in_rule__CondVar__Group__2__Impl2377);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1236:1: rule__OrdVar__Group__0 : rule__OrdVar__Group__0__Impl rule__OrdVar__Group__1 ;
    public final void rule__OrdVar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1240:1: ( rule__OrdVar__Group__0__Impl rule__OrdVar__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1241:2: rule__OrdVar__Group__0__Impl rule__OrdVar__Group__1
            {
            pushFollow(FOLLOW_rule__OrdVar__Group__0__Impl_in_rule__OrdVar__Group__02413);
            rule__OrdVar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OrdVar__Group__1_in_rule__OrdVar__Group__02416);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1248:1: rule__OrdVar__Group__0__Impl : ( ( rule__OrdVar__NameAssignment_0 ) ) ;
    public final void rule__OrdVar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1252:1: ( ( ( rule__OrdVar__NameAssignment_0 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1253:1: ( ( rule__OrdVar__NameAssignment_0 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1253:1: ( ( rule__OrdVar__NameAssignment_0 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1254:1: ( rule__OrdVar__NameAssignment_0 )
            {
             before(grammarAccess.getOrdVarAccess().getNameAssignment_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1255:1: ( rule__OrdVar__NameAssignment_0 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1255:2: rule__OrdVar__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__OrdVar__NameAssignment_0_in_rule__OrdVar__Group__0__Impl2443);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1265:1: rule__OrdVar__Group__1 : rule__OrdVar__Group__1__Impl rule__OrdVar__Group__2 ;
    public final void rule__OrdVar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1269:1: ( rule__OrdVar__Group__1__Impl rule__OrdVar__Group__2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1270:2: rule__OrdVar__Group__1__Impl rule__OrdVar__Group__2
            {
            pushFollow(FOLLOW_rule__OrdVar__Group__1__Impl_in_rule__OrdVar__Group__12473);
            rule__OrdVar__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OrdVar__Group__2_in_rule__OrdVar__Group__12476);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1277:1: rule__OrdVar__Group__1__Impl : ( '=' ) ;
    public final void rule__OrdVar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1281:1: ( ( '=' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1282:1: ( '=' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1282:1: ( '=' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1283:1: '='
            {
             before(grammarAccess.getOrdVarAccess().getEqualsSignKeyword_1()); 
            match(input,21,FOLLOW_21_in_rule__OrdVar__Group__1__Impl2504); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1296:1: rule__OrdVar__Group__2 : rule__OrdVar__Group__2__Impl ;
    public final void rule__OrdVar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1300:1: ( rule__OrdVar__Group__2__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1301:2: rule__OrdVar__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__OrdVar__Group__2__Impl_in_rule__OrdVar__Group__22535);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1307:1: rule__OrdVar__Group__2__Impl : ( ( rule__OrdVar__ValueAssignment_2 ) ) ;
    public final void rule__OrdVar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1311:1: ( ( ( rule__OrdVar__ValueAssignment_2 ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1312:1: ( ( rule__OrdVar__ValueAssignment_2 ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1312:1: ( ( rule__OrdVar__ValueAssignment_2 ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1313:1: ( rule__OrdVar__ValueAssignment_2 )
            {
             before(grammarAccess.getOrdVarAccess().getValueAssignment_2()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1314:1: ( rule__OrdVar__ValueAssignment_2 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1314:2: rule__OrdVar__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__OrdVar__ValueAssignment_2_in_rule__OrdVar__Group__2__Impl2562);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1330:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1334:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1335:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02598);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02601);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1342:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1346:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1347:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1347:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1348:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl2628); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1359:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1363:1: ( rule__QualifiedName__Group__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1364:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12657);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1370:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1374:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1375:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1375:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1376:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1377:1: ( rule__QualifiedName__Group_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==22) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1377:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl2684);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1391:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1395:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1396:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__02719);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__02722);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1403:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1407:1: ( ( '.' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1408:1: ( '.' )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1408:1: ( '.' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1409:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,22,FOLLOW_22_in_rule__QualifiedName__Group_1__0__Impl2750); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1422:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1426:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1427:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__12781);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1433:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1437:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1438:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1438:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1439:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl2808); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1455:1: rule__CoordinatorDeclaration__GranularityAssignment_0 : ( ( 'per_class' ) ) ;
    public final void rule__CoordinatorDeclaration__GranularityAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1459:1: ( ( ( 'per_class' ) ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1460:1: ( ( 'per_class' ) )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1460:1: ( ( 'per_class' ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1461:1: ( 'per_class' )
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getGranularityPer_classKeyword_0_0()); 
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1462:1: ( 'per_class' )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1463:1: 'per_class'
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getGranularityPer_classKeyword_0_0()); 
            match(input,23,FOLLOW_23_in_rule__CoordinatorDeclaration__GranularityAssignment_02851); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1478:1: rule__CoordinatorDeclaration__ClassNameAssignment_2 : ( ruleQualifiedName ) ;
    public final void rule__CoordinatorDeclaration__ClassNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1482:1: ( ( ruleQualifiedName ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1483:1: ( ruleQualifiedName )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1483:1: ( ruleQualifiedName )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1484:1: ruleQualifiedName
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getClassNameQualifiedNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__CoordinatorDeclaration__ClassNameAssignment_22890);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1493:1: rule__CoordinatorDeclaration__BodyAssignment_3 : ( ruleCoordinatorBody ) ;
    public final void rule__CoordinatorDeclaration__BodyAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1497:1: ( ( ruleCoordinatorBody ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1498:1: ( ruleCoordinatorBody )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1498:1: ( ruleCoordinatorBody )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1499:1: ruleCoordinatorBody
            {
             before(grammarAccess.getCoordinatorDeclarationAccess().getBodyCoordinatorBodyParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleCoordinatorBody_in_rule__CoordinatorDeclaration__BodyAssignment_32921);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1508:1: rule__CoordinatorBody__CondVarsAssignment_2_1 : ( ruleCondVar ) ;
    public final void rule__CoordinatorBody__CondVarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1512:1: ( ( ruleCondVar ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1513:1: ( ruleCondVar )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1513:1: ( ruleCondVar )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1514:1: ruleCondVar
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCondVarsCondVarParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleCondVar_in_rule__CoordinatorBody__CondVarsAssignment_2_12952);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1523:1: rule__CoordinatorBody__CondVarsAssignment_2_2_1 : ( ruleCondVar ) ;
    public final void rule__CoordinatorBody__CondVarsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1527:1: ( ( ruleCondVar ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1528:1: ( ruleCondVar )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1528:1: ( ruleCondVar )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1529:1: ruleCondVar
            {
             before(grammarAccess.getCoordinatorBodyAccess().getCondVarsCondVarParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_ruleCondVar_in_rule__CoordinatorBody__CondVarsAssignment_2_2_12983);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1538:1: rule__CoordinatorBody__OrdVarsAssignment_3_1 : ( ruleOrdVar ) ;
    public final void rule__CoordinatorBody__OrdVarsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1542:1: ( ( ruleOrdVar ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1543:1: ( ruleOrdVar )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1543:1: ( ruleOrdVar )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1544:1: ruleOrdVar
            {
             before(grammarAccess.getCoordinatorBodyAccess().getOrdVarsOrdVarParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleOrdVar_in_rule__CoordinatorBody__OrdVarsAssignment_3_13014);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1553:1: rule__CoordinatorBody__OrdVarsAssignment_3_2_1 : ( ruleOrdVar ) ;
    public final void rule__CoordinatorBody__OrdVarsAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1557:1: ( ( ruleOrdVar ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1558:1: ( ruleOrdVar )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1558:1: ( ruleOrdVar )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1559:1: ruleOrdVar
            {
             before(grammarAccess.getCoordinatorBodyAccess().getOrdVarsOrdVarParserRuleCall_3_2_1_0()); 
            pushFollow(FOLLOW_ruleOrdVar_in_rule__CoordinatorBody__OrdVarsAssignment_3_2_13045);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1568:1: rule__CoordinatorBody__SelfexMethodsAssignment_4_1 : ( ruleQualifiedName ) ;
    public final void rule__CoordinatorBody__SelfexMethodsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1572:1: ( ( ruleQualifiedName ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1573:1: ( ruleQualifiedName )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1573:1: ( ruleQualifiedName )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1574:1: ruleQualifiedName
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsQualifiedNameParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__CoordinatorBody__SelfexMethodsAssignment_4_13076);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1583:1: rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1 : ( ruleQualifiedName ) ;
    public final void rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1587:1: ( ( ruleQualifiedName ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1588:1: ( ruleQualifiedName )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1588:1: ( ruleQualifiedName )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1589:1: ruleQualifiedName
            {
             before(grammarAccess.getCoordinatorBodyAccess().getSelfexMethodsQualifiedNameParserRuleCall_4_2_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__CoordinatorBody__SelfexMethodsAssignment_4_2_13107);
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


    // $ANTLR start "rule__CondVar__NameAssignment_0"
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1598:1: rule__CondVar__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__CondVar__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1602:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1603:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1603:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1604:1: RULE_ID
            {
             before(grammarAccess.getCondVarAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__CondVar__NameAssignment_03138); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1613:1: rule__CondVar__ValueAssignment_2 : ( ruleBooleanVal ) ;
    public final void rule__CondVar__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1617:1: ( ( ruleBooleanVal ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1618:1: ( ruleBooleanVal )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1618:1: ( ruleBooleanVal )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1619:1: ruleBooleanVal
            {
             before(grammarAccess.getCondVarAccess().getValueBooleanValParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleBooleanVal_in_rule__CondVar__ValueAssignment_23169);
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1628:1: rule__OrdVar__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__OrdVar__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1632:1: ( ( RULE_ID ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1633:1: ( RULE_ID )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1633:1: ( RULE_ID )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1634:1: RULE_ID
            {
             before(grammarAccess.getOrdVarAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__OrdVar__NameAssignment_03200); 
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
    // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1643:1: rule__OrdVar__ValueAssignment_2 : ( RULE_INT ) ;
    public final void rule__OrdVar__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1647:1: ( ( RULE_INT ) )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1648:1: ( RULE_INT )
            {
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1648:1: ( RULE_INT )
            // ../xtext.cool.ui/src-gen/xtext/cool/ui/contentassist/antlr/internal/InternalCool.g:1649:1: RULE_INT
            {
             before(grammarAccess.getOrdVarAccess().getValueINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__OrdVar__ValueAssignment_23231); 
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
    public static final BitSet FOLLOW_ruleCondVar_in_entryRuleCondVar181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCondVar188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__Group__0_in_ruleCondVar214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrdVar_in_entryRuleOrdVar241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrdVar248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__0_in_ruleOrdVar274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanVal_in_entryRuleBooleanVal301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanVal308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanVal__Alternatives_in_ruleBooleanVal334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__BooleanVal__Alternatives431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__BooleanVal__Alternatives451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__0__Impl_in_rule__CoordinatorDeclaration__Group__0483 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__1_in_rule__CoordinatorDeclaration__Group__0486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__GranularityAssignment_0_in_rule__CoordinatorDeclaration__Group__0__Impl513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__1__Impl_in_rule__CoordinatorDeclaration__Group__1544 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__2_in_rule__CoordinatorDeclaration__Group__1547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__CoordinatorDeclaration__Group__1__Impl575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__2__Impl_in_rule__CoordinatorDeclaration__Group__2606 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__3_in_rule__CoordinatorDeclaration__Group__2609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__ClassNameAssignment_2_in_rule__CoordinatorDeclaration__Group__2__Impl636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__Group__3__Impl_in_rule__CoordinatorDeclaration__Group__3666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorDeclaration__BodyAssignment_3_in_rule__CoordinatorDeclaration__Group__3__Impl693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__0__Impl_in_rule__CoordinatorBody__Group__0732 = new BitSet(new long[]{0x0000000000198000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__1_in_rule__CoordinatorBody__Group__0735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__CoordinatorBody__Group__0__Impl763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__1__Impl_in_rule__CoordinatorBody__Group__1794 = new BitSet(new long[]{0x0000000000198000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__2_in_rule__CoordinatorBody__Group__1797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__2__Impl_in_rule__CoordinatorBody__Group__2855 = new BitSet(new long[]{0x0000000000198000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__3_in_rule__CoordinatorBody__Group__2858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__0_in_rule__CoordinatorBody__Group__2__Impl885 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__3__Impl_in_rule__CoordinatorBody__Group__3916 = new BitSet(new long[]{0x0000000000198000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__4_in_rule__CoordinatorBody__Group__3919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__0_in_rule__CoordinatorBody__Group__3__Impl946 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__4__Impl_in_rule__CoordinatorBody__Group__4977 = new BitSet(new long[]{0x0000000000198000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__5_in_rule__CoordinatorBody__Group__4980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__0_in_rule__CoordinatorBody__Group__4__Impl1007 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group__5__Impl_in_rule__CoordinatorBody__Group__51038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__CoordinatorBody__Group__5__Impl1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__0__Impl_in_rule__CoordinatorBody__Group_2__01109 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__1_in_rule__CoordinatorBody__Group_2__01112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__CoordinatorBody__Group_2__0__Impl1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__1__Impl_in_rule__CoordinatorBody__Group_2__11171 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__2_in_rule__CoordinatorBody__Group_2__11174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__CondVarsAssignment_2_1_in_rule__CoordinatorBody__Group_2__1__Impl1201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__2__Impl_in_rule__CoordinatorBody__Group_2__21231 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__3_in_rule__CoordinatorBody__Group_2__21234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2_2__0_in_rule__CoordinatorBody__Group_2__2__Impl1261 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2__3__Impl_in_rule__CoordinatorBody__Group_2__31292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__CoordinatorBody__Group_2__3__Impl1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2_2__0__Impl_in_rule__CoordinatorBody__Group_2_2__01359 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2_2__1_in_rule__CoordinatorBody__Group_2_2__01362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__CoordinatorBody__Group_2_2__0__Impl1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_2_2__1__Impl_in_rule__CoordinatorBody__Group_2_2__11421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__CondVarsAssignment_2_2_1_in_rule__CoordinatorBody__Group_2_2__1__Impl1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__0__Impl_in_rule__CoordinatorBody__Group_3__01482 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__1_in_rule__CoordinatorBody__Group_3__01485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__CoordinatorBody__Group_3__0__Impl1513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__1__Impl_in_rule__CoordinatorBody__Group_3__11544 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__2_in_rule__CoordinatorBody__Group_3__11547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__OrdVarsAssignment_3_1_in_rule__CoordinatorBody__Group_3__1__Impl1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__2__Impl_in_rule__CoordinatorBody__Group_3__21604 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__3_in_rule__CoordinatorBody__Group_3__21607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3_2__0_in_rule__CoordinatorBody__Group_3__2__Impl1634 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3__3__Impl_in_rule__CoordinatorBody__Group_3__31665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__CoordinatorBody__Group_3__3__Impl1693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3_2__0__Impl_in_rule__CoordinatorBody__Group_3_2__01732 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3_2__1_in_rule__CoordinatorBody__Group_3_2__01735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__CoordinatorBody__Group_3_2__0__Impl1763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_3_2__1__Impl_in_rule__CoordinatorBody__Group_3_2__11794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__OrdVarsAssignment_3_2_1_in_rule__CoordinatorBody__Group_3_2__1__Impl1821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__0__Impl_in_rule__CoordinatorBody__Group_4__01855 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__1_in_rule__CoordinatorBody__Group_4__01858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__CoordinatorBody__Group_4__0__Impl1886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__1__Impl_in_rule__CoordinatorBody__Group_4__11917 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__2_in_rule__CoordinatorBody__Group_4__11920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__SelfexMethodsAssignment_4_1_in_rule__CoordinatorBody__Group_4__1__Impl1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__2__Impl_in_rule__CoordinatorBody__Group_4__21977 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__3_in_rule__CoordinatorBody__Group_4__21980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4_2__0_in_rule__CoordinatorBody__Group_4__2__Impl2007 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4__3__Impl_in_rule__CoordinatorBody__Group_4__32038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__CoordinatorBody__Group_4__3__Impl2066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4_2__0__Impl_in_rule__CoordinatorBody__Group_4_2__02105 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4_2__1_in_rule__CoordinatorBody__Group_4_2__02108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__CoordinatorBody__Group_4_2__0__Impl2136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__Group_4_2__1__Impl_in_rule__CoordinatorBody__Group_4_2__12167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CoordinatorBody__SelfexMethodsAssignment_4_2_1_in_rule__CoordinatorBody__Group_4_2__1__Impl2194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__Group__0__Impl_in_rule__CondVar__Group__02228 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__CondVar__Group__1_in_rule__CondVar__Group__02231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__NameAssignment_0_in_rule__CondVar__Group__0__Impl2258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__Group__1__Impl_in_rule__CondVar__Group__12288 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_rule__CondVar__Group__2_in_rule__CondVar__Group__12291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__CondVar__Group__1__Impl2319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__Group__2__Impl_in_rule__CondVar__Group__22350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CondVar__ValueAssignment_2_in_rule__CondVar__Group__2__Impl2377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__0__Impl_in_rule__OrdVar__Group__02413 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__1_in_rule__OrdVar__Group__02416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__NameAssignment_0_in_rule__OrdVar__Group__0__Impl2443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__1__Impl_in_rule__OrdVar__Group__12473 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__2_in_rule__OrdVar__Group__12476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__OrdVar__Group__1__Impl2504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__Group__2__Impl_in_rule__OrdVar__Group__22535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrdVar__ValueAssignment_2_in_rule__OrdVar__Group__2__Impl2562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02598 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl2628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl2684 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__02719 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__02722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__QualifiedName__Group_1__0__Impl2750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__12781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl2808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__CoordinatorDeclaration__GranularityAssignment_02851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__CoordinatorDeclaration__ClassNameAssignment_22890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCoordinatorBody_in_rule__CoordinatorDeclaration__BodyAssignment_32921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondVar_in_rule__CoordinatorBody__CondVarsAssignment_2_12952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondVar_in_rule__CoordinatorBody__CondVarsAssignment_2_2_12983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrdVar_in_rule__CoordinatorBody__OrdVarsAssignment_3_13014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrdVar_in_rule__CoordinatorBody__OrdVarsAssignment_3_2_13045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__CoordinatorBody__SelfexMethodsAssignment_4_13076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__CoordinatorBody__SelfexMethodsAssignment_4_2_13107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__CondVar__NameAssignment_03138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanVal_in_rule__CondVar__ValueAssignment_23169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__OrdVar__NameAssignment_03200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__OrdVar__ValueAssignment_23231 = new BitSet(new long[]{0x0000000000000002L});

}