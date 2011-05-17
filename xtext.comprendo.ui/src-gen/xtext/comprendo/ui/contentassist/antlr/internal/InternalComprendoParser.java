package xtext.comprendo.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import xtext.comprendo.services.ComprendoGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalComprendoParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'public-executions'", "'private-executions'", "'Comprendo'", "'{'", "'}'", "'scope'", "'='", "';'", "':'", "'outdir'", "'summary'"
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
    public String getGrammarFileName() { return "../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g"; }


     
     	private ComprendoGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ComprendoGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleComprendoDSAL
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:61:1: entryRuleComprendoDSAL : ruleComprendoDSAL EOF ;
    public final void entryRuleComprendoDSAL() throws RecognitionException {
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:62:1: ( ruleComprendoDSAL EOF )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:63:1: ruleComprendoDSAL EOF
            {
             before(grammarAccess.getComprendoDSALRule()); 
            pushFollow(FOLLOW_ruleComprendoDSAL_in_entryRuleComprendoDSAL61);
            ruleComprendoDSAL();
            _fsp--;

             after(grammarAccess.getComprendoDSALRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComprendoDSAL68); 

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
    // $ANTLR end entryRuleComprendoDSAL


    // $ANTLR start ruleComprendoDSAL
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:70:1: ruleComprendoDSAL : ( ( rule__ComprendoDSAL__ComprendoAssignment ) ) ;
    public final void ruleComprendoDSAL() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:74:2: ( ( ( rule__ComprendoDSAL__ComprendoAssignment ) ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:75:1: ( ( rule__ComprendoDSAL__ComprendoAssignment ) )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:75:1: ( ( rule__ComprendoDSAL__ComprendoAssignment ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:76:1: ( rule__ComprendoDSAL__ComprendoAssignment )
            {
             before(grammarAccess.getComprendoDSALAccess().getComprendoAssignment()); 
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:77:1: ( rule__ComprendoDSAL__ComprendoAssignment )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:77:2: rule__ComprendoDSAL__ComprendoAssignment
            {
            pushFollow(FOLLOW_rule__ComprendoDSAL__ComprendoAssignment_in_ruleComprendoDSAL94);
            rule__ComprendoDSAL__ComprendoAssignment();
            _fsp--;


            }

             after(grammarAccess.getComprendoDSALAccess().getComprendoAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleComprendoDSAL


    // $ANTLR start entryRuleComprendo
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:89:1: entryRuleComprendo : ruleComprendo EOF ;
    public final void entryRuleComprendo() throws RecognitionException {
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:90:1: ( ruleComprendo EOF )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:91:1: ruleComprendo EOF
            {
             before(grammarAccess.getComprendoRule()); 
            pushFollow(FOLLOW_ruleComprendo_in_entryRuleComprendo121);
            ruleComprendo();
            _fsp--;

             after(grammarAccess.getComprendoRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComprendo128); 

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
    // $ANTLR end entryRuleComprendo


    // $ANTLR start ruleComprendo
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:98:1: ruleComprendo : ( ( rule__Comprendo__Group__0 ) ) ;
    public final void ruleComprendo() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:102:2: ( ( ( rule__Comprendo__Group__0 ) ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:103:1: ( ( rule__Comprendo__Group__0 ) )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:103:1: ( ( rule__Comprendo__Group__0 ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:104:1: ( rule__Comprendo__Group__0 )
            {
             before(grammarAccess.getComprendoAccess().getGroup()); 
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:105:1: ( rule__Comprendo__Group__0 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:105:2: rule__Comprendo__Group__0
            {
            pushFollow(FOLLOW_rule__Comprendo__Group__0_in_ruleComprendo154);
            rule__Comprendo__Group__0();
            _fsp--;


            }

             after(grammarAccess.getComprendoAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleComprendo


    // $ANTLR start entryRuleScope
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:117:1: entryRuleScope : ruleScope EOF ;
    public final void entryRuleScope() throws RecognitionException {
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:118:1: ( ruleScope EOF )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:119:1: ruleScope EOF
            {
             before(grammarAccess.getScopeRule()); 
            pushFollow(FOLLOW_ruleScope_in_entryRuleScope181);
            ruleScope();
            _fsp--;

             after(grammarAccess.getScopeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScope188); 

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
    // $ANTLR end entryRuleScope


    // $ANTLR start ruleScope
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:126:1: ruleScope : ( ( rule__Scope__Group__0 ) ) ;
    public final void ruleScope() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:130:2: ( ( ( rule__Scope__Group__0 ) ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:131:1: ( ( rule__Scope__Group__0 ) )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:131:1: ( ( rule__Scope__Group__0 ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:132:1: ( rule__Scope__Group__0 )
            {
             before(grammarAccess.getScopeAccess().getGroup()); 
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:133:1: ( rule__Scope__Group__0 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:133:2: rule__Scope__Group__0
            {
            pushFollow(FOLLOW_rule__Scope__Group__0_in_ruleScope214);
            rule__Scope__Group__0();
            _fsp--;


            }

             after(grammarAccess.getScopeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleScope


    // $ANTLR start entryRuleCommand
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:145:1: entryRuleCommand : ruleCommand EOF ;
    public final void entryRuleCommand() throws RecognitionException {
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:146:1: ( ruleCommand EOF )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:147:1: ruleCommand EOF
            {
             before(grammarAccess.getCommandRule()); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand241);
            ruleCommand();
            _fsp--;

             after(grammarAccess.getCommandRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand248); 

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
    // $ANTLR end entryRuleCommand


    // $ANTLR start ruleCommand
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:154:1: ruleCommand : ( ( rule__Command__Group__0 ) ) ;
    public final void ruleCommand() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:158:2: ( ( ( rule__Command__Group__0 ) ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:159:1: ( ( rule__Command__Group__0 ) )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:159:1: ( ( rule__Command__Group__0 ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:160:1: ( rule__Command__Group__0 )
            {
             before(grammarAccess.getCommandAccess().getGroup()); 
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:161:1: ( rule__Command__Group__0 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:161:2: rule__Command__Group__0
            {
            pushFollow(FOLLOW_rule__Command__Group__0_in_ruleCommand274);
            rule__Command__Group__0();
            _fsp--;


            }

             after(grammarAccess.getCommandAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleCommand


    // $ANTLR start entryRuleOutdir
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:173:1: entryRuleOutdir : ruleOutdir EOF ;
    public final void entryRuleOutdir() throws RecognitionException {
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:174:1: ( ruleOutdir EOF )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:175:1: ruleOutdir EOF
            {
             before(grammarAccess.getOutdirRule()); 
            pushFollow(FOLLOW_ruleOutdir_in_entryRuleOutdir301);
            ruleOutdir();
            _fsp--;

             after(grammarAccess.getOutdirRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOutdir308); 

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
    // $ANTLR end entryRuleOutdir


    // $ANTLR start ruleOutdir
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:182:1: ruleOutdir : ( ( rule__Outdir__Group__0 ) ) ;
    public final void ruleOutdir() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:186:2: ( ( ( rule__Outdir__Group__0 ) ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:187:1: ( ( rule__Outdir__Group__0 ) )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:187:1: ( ( rule__Outdir__Group__0 ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:188:1: ( rule__Outdir__Group__0 )
            {
             before(grammarAccess.getOutdirAccess().getGroup()); 
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:189:1: ( rule__Outdir__Group__0 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:189:2: rule__Outdir__Group__0
            {
            pushFollow(FOLLOW_rule__Outdir__Group__0_in_ruleOutdir334);
            rule__Outdir__Group__0();
            _fsp--;


            }

             after(grammarAccess.getOutdirAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleOutdir


    // $ANTLR start rule__Command__IdAlternatives_0_0
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:201:1: rule__Command__IdAlternatives_0_0 : ( ( 'public-executions' ) | ( 'private-executions' ) );
    public final void rule__Command__IdAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:205:1: ( ( 'public-executions' ) | ( 'private-executions' ) )
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
                    new NoViableAltException("201:1: rule__Command__IdAlternatives_0_0 : ( ( 'public-executions' ) | ( 'private-executions' ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:206:1: ( 'public-executions' )
                    {
                    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:206:1: ( 'public-executions' )
                    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:207:1: 'public-executions'
                    {
                     before(grammarAccess.getCommandAccess().getIdPublicExecutionsKeyword_0_0_0()); 
                    match(input,11,FOLLOW_11_in_rule__Command__IdAlternatives_0_0371); 
                     after(grammarAccess.getCommandAccess().getIdPublicExecutionsKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:214:6: ( 'private-executions' )
                    {
                    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:214:6: ( 'private-executions' )
                    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:215:1: 'private-executions'
                    {
                     before(grammarAccess.getCommandAccess().getIdPrivateExecutionsKeyword_0_0_1()); 
                    match(input,12,FOLLOW_12_in_rule__Command__IdAlternatives_0_0391); 
                     after(grammarAccess.getCommandAccess().getIdPrivateExecutionsKeyword_0_0_1()); 

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
    // $ANTLR end rule__Command__IdAlternatives_0_0


    // $ANTLR start rule__Comprendo__Group__0
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:229:1: rule__Comprendo__Group__0 : rule__Comprendo__Group__0__Impl rule__Comprendo__Group__1 ;
    public final void rule__Comprendo__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:233:1: ( rule__Comprendo__Group__0__Impl rule__Comprendo__Group__1 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:234:2: rule__Comprendo__Group__0__Impl rule__Comprendo__Group__1
            {
            pushFollow(FOLLOW_rule__Comprendo__Group__0__Impl_in_rule__Comprendo__Group__0423);
            rule__Comprendo__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Comprendo__Group__1_in_rule__Comprendo__Group__0426);
            rule__Comprendo__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Comprendo__Group__0


    // $ANTLR start rule__Comprendo__Group__0__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:241:1: rule__Comprendo__Group__0__Impl : ( 'Comprendo' ) ;
    public final void rule__Comprendo__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:245:1: ( ( 'Comprendo' ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:246:1: ( 'Comprendo' )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:246:1: ( 'Comprendo' )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:247:1: 'Comprendo'
            {
             before(grammarAccess.getComprendoAccess().getComprendoKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__Comprendo__Group__0__Impl454); 
             after(grammarAccess.getComprendoAccess().getComprendoKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Comprendo__Group__0__Impl


    // $ANTLR start rule__Comprendo__Group__1
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:260:1: rule__Comprendo__Group__1 : rule__Comprendo__Group__1__Impl rule__Comprendo__Group__2 ;
    public final void rule__Comprendo__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:264:1: ( rule__Comprendo__Group__1__Impl rule__Comprendo__Group__2 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:265:2: rule__Comprendo__Group__1__Impl rule__Comprendo__Group__2
            {
            pushFollow(FOLLOW_rule__Comprendo__Group__1__Impl_in_rule__Comprendo__Group__1485);
            rule__Comprendo__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Comprendo__Group__2_in_rule__Comprendo__Group__1488);
            rule__Comprendo__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Comprendo__Group__1


    // $ANTLR start rule__Comprendo__Group__1__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:272:1: rule__Comprendo__Group__1__Impl : ( ( rule__Comprendo__NameAssignment_1 ) ) ;
    public final void rule__Comprendo__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:276:1: ( ( ( rule__Comprendo__NameAssignment_1 ) ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:277:1: ( ( rule__Comprendo__NameAssignment_1 ) )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:277:1: ( ( rule__Comprendo__NameAssignment_1 ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:278:1: ( rule__Comprendo__NameAssignment_1 )
            {
             before(grammarAccess.getComprendoAccess().getNameAssignment_1()); 
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:279:1: ( rule__Comprendo__NameAssignment_1 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:279:2: rule__Comprendo__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Comprendo__NameAssignment_1_in_rule__Comprendo__Group__1__Impl515);
            rule__Comprendo__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getComprendoAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Comprendo__Group__1__Impl


    // $ANTLR start rule__Comprendo__Group__2
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:289:1: rule__Comprendo__Group__2 : rule__Comprendo__Group__2__Impl rule__Comprendo__Group__3 ;
    public final void rule__Comprendo__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:293:1: ( rule__Comprendo__Group__2__Impl rule__Comprendo__Group__3 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:294:2: rule__Comprendo__Group__2__Impl rule__Comprendo__Group__3
            {
            pushFollow(FOLLOW_rule__Comprendo__Group__2__Impl_in_rule__Comprendo__Group__2545);
            rule__Comprendo__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Comprendo__Group__3_in_rule__Comprendo__Group__2548);
            rule__Comprendo__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Comprendo__Group__2


    // $ANTLR start rule__Comprendo__Group__2__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:301:1: rule__Comprendo__Group__2__Impl : ( '{' ) ;
    public final void rule__Comprendo__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:305:1: ( ( '{' ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:306:1: ( '{' )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:306:1: ( '{' )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:307:1: '{'
            {
             before(grammarAccess.getComprendoAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,14,FOLLOW_14_in_rule__Comprendo__Group__2__Impl576); 
             after(grammarAccess.getComprendoAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Comprendo__Group__2__Impl


    // $ANTLR start rule__Comprendo__Group__3
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:320:1: rule__Comprendo__Group__3 : rule__Comprendo__Group__3__Impl rule__Comprendo__Group__4 ;
    public final void rule__Comprendo__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:324:1: ( rule__Comprendo__Group__3__Impl rule__Comprendo__Group__4 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:325:2: rule__Comprendo__Group__3__Impl rule__Comprendo__Group__4
            {
            pushFollow(FOLLOW_rule__Comprendo__Group__3__Impl_in_rule__Comprendo__Group__3607);
            rule__Comprendo__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Comprendo__Group__4_in_rule__Comprendo__Group__3610);
            rule__Comprendo__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Comprendo__Group__3


    // $ANTLR start rule__Comprendo__Group__3__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:332:1: rule__Comprendo__Group__3__Impl : ( ( rule__Comprendo__ScopeAssignment_3 ) ) ;
    public final void rule__Comprendo__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:336:1: ( ( ( rule__Comprendo__ScopeAssignment_3 ) ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:337:1: ( ( rule__Comprendo__ScopeAssignment_3 ) )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:337:1: ( ( rule__Comprendo__ScopeAssignment_3 ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:338:1: ( rule__Comprendo__ScopeAssignment_3 )
            {
             before(grammarAccess.getComprendoAccess().getScopeAssignment_3()); 
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:339:1: ( rule__Comprendo__ScopeAssignment_3 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:339:2: rule__Comprendo__ScopeAssignment_3
            {
            pushFollow(FOLLOW_rule__Comprendo__ScopeAssignment_3_in_rule__Comprendo__Group__3__Impl637);
            rule__Comprendo__ScopeAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getComprendoAccess().getScopeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Comprendo__Group__3__Impl


    // $ANTLR start rule__Comprendo__Group__4
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:349:1: rule__Comprendo__Group__4 : rule__Comprendo__Group__4__Impl rule__Comprendo__Group__5 ;
    public final void rule__Comprendo__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:353:1: ( rule__Comprendo__Group__4__Impl rule__Comprendo__Group__5 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:354:2: rule__Comprendo__Group__4__Impl rule__Comprendo__Group__5
            {
            pushFollow(FOLLOW_rule__Comprendo__Group__4__Impl_in_rule__Comprendo__Group__4667);
            rule__Comprendo__Group__4__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Comprendo__Group__5_in_rule__Comprendo__Group__4670);
            rule__Comprendo__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Comprendo__Group__4


    // $ANTLR start rule__Comprendo__Group__4__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:361:1: rule__Comprendo__Group__4__Impl : ( ( rule__Comprendo__OutdirAssignment_4 )? ) ;
    public final void rule__Comprendo__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:365:1: ( ( ( rule__Comprendo__OutdirAssignment_4 )? ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:366:1: ( ( rule__Comprendo__OutdirAssignment_4 )? )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:366:1: ( ( rule__Comprendo__OutdirAssignment_4 )? )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:367:1: ( rule__Comprendo__OutdirAssignment_4 )?
            {
             before(grammarAccess.getComprendoAccess().getOutdirAssignment_4()); 
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:368:1: ( rule__Comprendo__OutdirAssignment_4 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==20) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:368:2: rule__Comprendo__OutdirAssignment_4
                    {
                    pushFollow(FOLLOW_rule__Comprendo__OutdirAssignment_4_in_rule__Comprendo__Group__4__Impl697);
                    rule__Comprendo__OutdirAssignment_4();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getComprendoAccess().getOutdirAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Comprendo__Group__4__Impl


    // $ANTLR start rule__Comprendo__Group__5
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:378:1: rule__Comprendo__Group__5 : rule__Comprendo__Group__5__Impl rule__Comprendo__Group__6 ;
    public final void rule__Comprendo__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:382:1: ( rule__Comprendo__Group__5__Impl rule__Comprendo__Group__6 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:383:2: rule__Comprendo__Group__5__Impl rule__Comprendo__Group__6
            {
            pushFollow(FOLLOW_rule__Comprendo__Group__5__Impl_in_rule__Comprendo__Group__5728);
            rule__Comprendo__Group__5__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Comprendo__Group__6_in_rule__Comprendo__Group__5731);
            rule__Comprendo__Group__6();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Comprendo__Group__5


    // $ANTLR start rule__Comprendo__Group__5__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:390:1: rule__Comprendo__Group__5__Impl : ( ( rule__Comprendo__CommandsAssignment_5 )* ) ;
    public final void rule__Comprendo__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:394:1: ( ( ( rule__Comprendo__CommandsAssignment_5 )* ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:395:1: ( ( rule__Comprendo__CommandsAssignment_5 )* )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:395:1: ( ( rule__Comprendo__CommandsAssignment_5 )* )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:396:1: ( rule__Comprendo__CommandsAssignment_5 )*
            {
             before(grammarAccess.getComprendoAccess().getCommandsAssignment_5()); 
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:397:1: ( rule__Comprendo__CommandsAssignment_5 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=11 && LA3_0<=12)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:397:2: rule__Comprendo__CommandsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__Comprendo__CommandsAssignment_5_in_rule__Comprendo__Group__5__Impl758);
            	    rule__Comprendo__CommandsAssignment_5();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getComprendoAccess().getCommandsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Comprendo__Group__5__Impl


    // $ANTLR start rule__Comprendo__Group__6
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:407:1: rule__Comprendo__Group__6 : rule__Comprendo__Group__6__Impl ;
    public final void rule__Comprendo__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:411:1: ( rule__Comprendo__Group__6__Impl )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:412:2: rule__Comprendo__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__Comprendo__Group__6__Impl_in_rule__Comprendo__Group__6789);
            rule__Comprendo__Group__6__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Comprendo__Group__6


    // $ANTLR start rule__Comprendo__Group__6__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:418:1: rule__Comprendo__Group__6__Impl : ( '}' ) ;
    public final void rule__Comprendo__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:422:1: ( ( '}' ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:423:1: ( '}' )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:423:1: ( '}' )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:424:1: '}'
            {
             before(grammarAccess.getComprendoAccess().getRightCurlyBracketKeyword_6()); 
            match(input,15,FOLLOW_15_in_rule__Comprendo__Group__6__Impl817); 
             after(grammarAccess.getComprendoAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Comprendo__Group__6__Impl


    // $ANTLR start rule__Scope__Group__0
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:451:1: rule__Scope__Group__0 : rule__Scope__Group__0__Impl rule__Scope__Group__1 ;
    public final void rule__Scope__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:455:1: ( rule__Scope__Group__0__Impl rule__Scope__Group__1 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:456:2: rule__Scope__Group__0__Impl rule__Scope__Group__1
            {
            pushFollow(FOLLOW_rule__Scope__Group__0__Impl_in_rule__Scope__Group__0862);
            rule__Scope__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Scope__Group__1_in_rule__Scope__Group__0865);
            rule__Scope__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Scope__Group__0


    // $ANTLR start rule__Scope__Group__0__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:463:1: rule__Scope__Group__0__Impl : ( 'scope' ) ;
    public final void rule__Scope__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:467:1: ( ( 'scope' ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:468:1: ( 'scope' )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:468:1: ( 'scope' )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:469:1: 'scope'
            {
             before(grammarAccess.getScopeAccess().getScopeKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__Scope__Group__0__Impl893); 
             after(grammarAccess.getScopeAccess().getScopeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Scope__Group__0__Impl


    // $ANTLR start rule__Scope__Group__1
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:482:1: rule__Scope__Group__1 : rule__Scope__Group__1__Impl rule__Scope__Group__2 ;
    public final void rule__Scope__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:486:1: ( rule__Scope__Group__1__Impl rule__Scope__Group__2 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:487:2: rule__Scope__Group__1__Impl rule__Scope__Group__2
            {
            pushFollow(FOLLOW_rule__Scope__Group__1__Impl_in_rule__Scope__Group__1924);
            rule__Scope__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Scope__Group__2_in_rule__Scope__Group__1927);
            rule__Scope__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Scope__Group__1


    // $ANTLR start rule__Scope__Group__1__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:494:1: rule__Scope__Group__1__Impl : ( '=' ) ;
    public final void rule__Scope__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:498:1: ( ( '=' ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:499:1: ( '=' )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:499:1: ( '=' )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:500:1: '='
            {
             before(grammarAccess.getScopeAccess().getEqualsSignKeyword_1()); 
            match(input,17,FOLLOW_17_in_rule__Scope__Group__1__Impl955); 
             after(grammarAccess.getScopeAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Scope__Group__1__Impl


    // $ANTLR start rule__Scope__Group__2
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:513:1: rule__Scope__Group__2 : rule__Scope__Group__2__Impl rule__Scope__Group__3 ;
    public final void rule__Scope__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:517:1: ( rule__Scope__Group__2__Impl rule__Scope__Group__3 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:518:2: rule__Scope__Group__2__Impl rule__Scope__Group__3
            {
            pushFollow(FOLLOW_rule__Scope__Group__2__Impl_in_rule__Scope__Group__2986);
            rule__Scope__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Scope__Group__3_in_rule__Scope__Group__2989);
            rule__Scope__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Scope__Group__2


    // $ANTLR start rule__Scope__Group__2__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:525:1: rule__Scope__Group__2__Impl : ( ( rule__Scope__ValueAssignment_2 ) ) ;
    public final void rule__Scope__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:529:1: ( ( ( rule__Scope__ValueAssignment_2 ) ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:530:1: ( ( rule__Scope__ValueAssignment_2 ) )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:530:1: ( ( rule__Scope__ValueAssignment_2 ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:531:1: ( rule__Scope__ValueAssignment_2 )
            {
             before(grammarAccess.getScopeAccess().getValueAssignment_2()); 
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:532:1: ( rule__Scope__ValueAssignment_2 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:532:2: rule__Scope__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__Scope__ValueAssignment_2_in_rule__Scope__Group__2__Impl1016);
            rule__Scope__ValueAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getScopeAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Scope__Group__2__Impl


    // $ANTLR start rule__Scope__Group__3
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:542:1: rule__Scope__Group__3 : rule__Scope__Group__3__Impl ;
    public final void rule__Scope__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:546:1: ( rule__Scope__Group__3__Impl )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:547:2: rule__Scope__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Scope__Group__3__Impl_in_rule__Scope__Group__31046);
            rule__Scope__Group__3__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Scope__Group__3


    // $ANTLR start rule__Scope__Group__3__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:553:1: rule__Scope__Group__3__Impl : ( ';' ) ;
    public final void rule__Scope__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:557:1: ( ( ';' ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:558:1: ( ';' )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:558:1: ( ';' )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:559:1: ';'
            {
             before(grammarAccess.getScopeAccess().getSemicolonKeyword_3()); 
            match(input,18,FOLLOW_18_in_rule__Scope__Group__3__Impl1074); 
             after(grammarAccess.getScopeAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Scope__Group__3__Impl


    // $ANTLR start rule__Command__Group__0
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:580:1: rule__Command__Group__0 : rule__Command__Group__0__Impl rule__Command__Group__1 ;
    public final void rule__Command__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:584:1: ( rule__Command__Group__0__Impl rule__Command__Group__1 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:585:2: rule__Command__Group__0__Impl rule__Command__Group__1
            {
            pushFollow(FOLLOW_rule__Command__Group__0__Impl_in_rule__Command__Group__01113);
            rule__Command__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Command__Group__1_in_rule__Command__Group__01116);
            rule__Command__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Command__Group__0


    // $ANTLR start rule__Command__Group__0__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:592:1: rule__Command__Group__0__Impl : ( ( rule__Command__IdAssignment_0 ) ) ;
    public final void rule__Command__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:596:1: ( ( ( rule__Command__IdAssignment_0 ) ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:597:1: ( ( rule__Command__IdAssignment_0 ) )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:597:1: ( ( rule__Command__IdAssignment_0 ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:598:1: ( rule__Command__IdAssignment_0 )
            {
             before(grammarAccess.getCommandAccess().getIdAssignment_0()); 
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:599:1: ( rule__Command__IdAssignment_0 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:599:2: rule__Command__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__Command__IdAssignment_0_in_rule__Command__Group__0__Impl1143);
            rule__Command__IdAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getCommandAccess().getIdAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Command__Group__0__Impl


    // $ANTLR start rule__Command__Group__1
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:609:1: rule__Command__Group__1 : rule__Command__Group__1__Impl rule__Command__Group__2 ;
    public final void rule__Command__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:613:1: ( rule__Command__Group__1__Impl rule__Command__Group__2 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:614:2: rule__Command__Group__1__Impl rule__Command__Group__2
            {
            pushFollow(FOLLOW_rule__Command__Group__1__Impl_in_rule__Command__Group__11173);
            rule__Command__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Command__Group__2_in_rule__Command__Group__11176);
            rule__Command__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Command__Group__1


    // $ANTLR start rule__Command__Group__1__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:621:1: rule__Command__Group__1__Impl : ( ( rule__Command__Group_1__0 )? ) ;
    public final void rule__Command__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:625:1: ( ( ( rule__Command__Group_1__0 )? ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:626:1: ( ( rule__Command__Group_1__0 )? )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:626:1: ( ( rule__Command__Group_1__0 )? )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:627:1: ( rule__Command__Group_1__0 )?
            {
             before(grammarAccess.getCommandAccess().getGroup_1()); 
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:628:1: ( rule__Command__Group_1__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:628:2: rule__Command__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Command__Group_1__0_in_rule__Command__Group__1__Impl1203);
                    rule__Command__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCommandAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Command__Group__1__Impl


    // $ANTLR start rule__Command__Group__2
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:638:1: rule__Command__Group__2 : rule__Command__Group__2__Impl ;
    public final void rule__Command__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:642:1: ( rule__Command__Group__2__Impl )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:643:2: rule__Command__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Command__Group__2__Impl_in_rule__Command__Group__21234);
            rule__Command__Group__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Command__Group__2


    // $ANTLR start rule__Command__Group__2__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:649:1: rule__Command__Group__2__Impl : ( ';' ) ;
    public final void rule__Command__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:653:1: ( ( ';' ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:654:1: ( ';' )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:654:1: ( ';' )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:655:1: ';'
            {
             before(grammarAccess.getCommandAccess().getSemicolonKeyword_2()); 
            match(input,18,FOLLOW_18_in_rule__Command__Group__2__Impl1262); 
             after(grammarAccess.getCommandAccess().getSemicolonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Command__Group__2__Impl


    // $ANTLR start rule__Command__Group_1__0
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:674:1: rule__Command__Group_1__0 : rule__Command__Group_1__0__Impl rule__Command__Group_1__1 ;
    public final void rule__Command__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:678:1: ( rule__Command__Group_1__0__Impl rule__Command__Group_1__1 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:679:2: rule__Command__Group_1__0__Impl rule__Command__Group_1__1
            {
            pushFollow(FOLLOW_rule__Command__Group_1__0__Impl_in_rule__Command__Group_1__01299);
            rule__Command__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Command__Group_1__1_in_rule__Command__Group_1__01302);
            rule__Command__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Command__Group_1__0


    // $ANTLR start rule__Command__Group_1__0__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:686:1: rule__Command__Group_1__0__Impl : ( ':' ) ;
    public final void rule__Command__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:690:1: ( ( ':' ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:691:1: ( ':' )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:691:1: ( ':' )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:692:1: ':'
            {
             before(grammarAccess.getCommandAccess().getColonKeyword_1_0()); 
            match(input,19,FOLLOW_19_in_rule__Command__Group_1__0__Impl1330); 
             after(grammarAccess.getCommandAccess().getColonKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Command__Group_1__0__Impl


    // $ANTLR start rule__Command__Group_1__1
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:705:1: rule__Command__Group_1__1 : rule__Command__Group_1__1__Impl ;
    public final void rule__Command__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:709:1: ( rule__Command__Group_1__1__Impl )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:710:2: rule__Command__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Command__Group_1__1__Impl_in_rule__Command__Group_1__11361);
            rule__Command__Group_1__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Command__Group_1__1


    // $ANTLR start rule__Command__Group_1__1__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:716:1: rule__Command__Group_1__1__Impl : ( ( rule__Command__SummaryAssignment_1_1 ) ) ;
    public final void rule__Command__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:720:1: ( ( ( rule__Command__SummaryAssignment_1_1 ) ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:721:1: ( ( rule__Command__SummaryAssignment_1_1 ) )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:721:1: ( ( rule__Command__SummaryAssignment_1_1 ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:722:1: ( rule__Command__SummaryAssignment_1_1 )
            {
             before(grammarAccess.getCommandAccess().getSummaryAssignment_1_1()); 
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:723:1: ( rule__Command__SummaryAssignment_1_1 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:723:2: rule__Command__SummaryAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Command__SummaryAssignment_1_1_in_rule__Command__Group_1__1__Impl1388);
            rule__Command__SummaryAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getCommandAccess().getSummaryAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Command__Group_1__1__Impl


    // $ANTLR start rule__Outdir__Group__0
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:737:1: rule__Outdir__Group__0 : rule__Outdir__Group__0__Impl rule__Outdir__Group__1 ;
    public final void rule__Outdir__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:741:1: ( rule__Outdir__Group__0__Impl rule__Outdir__Group__1 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:742:2: rule__Outdir__Group__0__Impl rule__Outdir__Group__1
            {
            pushFollow(FOLLOW_rule__Outdir__Group__0__Impl_in_rule__Outdir__Group__01422);
            rule__Outdir__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Outdir__Group__1_in_rule__Outdir__Group__01425);
            rule__Outdir__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Outdir__Group__0


    // $ANTLR start rule__Outdir__Group__0__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:749:1: rule__Outdir__Group__0__Impl : ( 'outdir' ) ;
    public final void rule__Outdir__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:753:1: ( ( 'outdir' ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:754:1: ( 'outdir' )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:754:1: ( 'outdir' )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:755:1: 'outdir'
            {
             before(grammarAccess.getOutdirAccess().getOutdirKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__Outdir__Group__0__Impl1453); 
             after(grammarAccess.getOutdirAccess().getOutdirKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Outdir__Group__0__Impl


    // $ANTLR start rule__Outdir__Group__1
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:768:1: rule__Outdir__Group__1 : rule__Outdir__Group__1__Impl rule__Outdir__Group__2 ;
    public final void rule__Outdir__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:772:1: ( rule__Outdir__Group__1__Impl rule__Outdir__Group__2 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:773:2: rule__Outdir__Group__1__Impl rule__Outdir__Group__2
            {
            pushFollow(FOLLOW_rule__Outdir__Group__1__Impl_in_rule__Outdir__Group__11484);
            rule__Outdir__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Outdir__Group__2_in_rule__Outdir__Group__11487);
            rule__Outdir__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Outdir__Group__1


    // $ANTLR start rule__Outdir__Group__1__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:780:1: rule__Outdir__Group__1__Impl : ( '=' ) ;
    public final void rule__Outdir__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:784:1: ( ( '=' ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:785:1: ( '=' )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:785:1: ( '=' )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:786:1: '='
            {
             before(grammarAccess.getOutdirAccess().getEqualsSignKeyword_1()); 
            match(input,17,FOLLOW_17_in_rule__Outdir__Group__1__Impl1515); 
             after(grammarAccess.getOutdirAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Outdir__Group__1__Impl


    // $ANTLR start rule__Outdir__Group__2
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:799:1: rule__Outdir__Group__2 : rule__Outdir__Group__2__Impl rule__Outdir__Group__3 ;
    public final void rule__Outdir__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:803:1: ( rule__Outdir__Group__2__Impl rule__Outdir__Group__3 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:804:2: rule__Outdir__Group__2__Impl rule__Outdir__Group__3
            {
            pushFollow(FOLLOW_rule__Outdir__Group__2__Impl_in_rule__Outdir__Group__21546);
            rule__Outdir__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Outdir__Group__3_in_rule__Outdir__Group__21549);
            rule__Outdir__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Outdir__Group__2


    // $ANTLR start rule__Outdir__Group__2__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:811:1: rule__Outdir__Group__2__Impl : ( ( rule__Outdir__ValueAssignment_2 ) ) ;
    public final void rule__Outdir__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:815:1: ( ( ( rule__Outdir__ValueAssignment_2 ) ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:816:1: ( ( rule__Outdir__ValueAssignment_2 ) )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:816:1: ( ( rule__Outdir__ValueAssignment_2 ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:817:1: ( rule__Outdir__ValueAssignment_2 )
            {
             before(grammarAccess.getOutdirAccess().getValueAssignment_2()); 
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:818:1: ( rule__Outdir__ValueAssignment_2 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:818:2: rule__Outdir__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__Outdir__ValueAssignment_2_in_rule__Outdir__Group__2__Impl1576);
            rule__Outdir__ValueAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getOutdirAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Outdir__Group__2__Impl


    // $ANTLR start rule__Outdir__Group__3
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:828:1: rule__Outdir__Group__3 : rule__Outdir__Group__3__Impl ;
    public final void rule__Outdir__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:832:1: ( rule__Outdir__Group__3__Impl )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:833:2: rule__Outdir__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Outdir__Group__3__Impl_in_rule__Outdir__Group__31606);
            rule__Outdir__Group__3__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Outdir__Group__3


    // $ANTLR start rule__Outdir__Group__3__Impl
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:839:1: rule__Outdir__Group__3__Impl : ( ';' ) ;
    public final void rule__Outdir__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:843:1: ( ( ';' ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:844:1: ( ';' )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:844:1: ( ';' )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:845:1: ';'
            {
             before(grammarAccess.getOutdirAccess().getSemicolonKeyword_3()); 
            match(input,18,FOLLOW_18_in_rule__Outdir__Group__3__Impl1634); 
             after(grammarAccess.getOutdirAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Outdir__Group__3__Impl


    // $ANTLR start rule__ComprendoDSAL__ComprendoAssignment
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:867:1: rule__ComprendoDSAL__ComprendoAssignment : ( ruleComprendo ) ;
    public final void rule__ComprendoDSAL__ComprendoAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:871:1: ( ( ruleComprendo ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:872:1: ( ruleComprendo )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:872:1: ( ruleComprendo )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:873:1: ruleComprendo
            {
             before(grammarAccess.getComprendoDSALAccess().getComprendoComprendoParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleComprendo_in_rule__ComprendoDSAL__ComprendoAssignment1678);
            ruleComprendo();
            _fsp--;

             after(grammarAccess.getComprendoDSALAccess().getComprendoComprendoParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComprendoDSAL__ComprendoAssignment


    // $ANTLR start rule__Comprendo__NameAssignment_1
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:882:1: rule__Comprendo__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Comprendo__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:886:1: ( ( RULE_ID ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:887:1: ( RULE_ID )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:887:1: ( RULE_ID )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:888:1: RULE_ID
            {
             before(grammarAccess.getComprendoAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Comprendo__NameAssignment_11709); 
             after(grammarAccess.getComprendoAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Comprendo__NameAssignment_1


    // $ANTLR start rule__Comprendo__ScopeAssignment_3
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:897:1: rule__Comprendo__ScopeAssignment_3 : ( ruleScope ) ;
    public final void rule__Comprendo__ScopeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:901:1: ( ( ruleScope ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:902:1: ( ruleScope )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:902:1: ( ruleScope )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:903:1: ruleScope
            {
             before(grammarAccess.getComprendoAccess().getScopeScopeParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleScope_in_rule__Comprendo__ScopeAssignment_31740);
            ruleScope();
            _fsp--;

             after(grammarAccess.getComprendoAccess().getScopeScopeParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Comprendo__ScopeAssignment_3


    // $ANTLR start rule__Comprendo__OutdirAssignment_4
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:912:1: rule__Comprendo__OutdirAssignment_4 : ( ruleOutdir ) ;
    public final void rule__Comprendo__OutdirAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:916:1: ( ( ruleOutdir ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:917:1: ( ruleOutdir )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:917:1: ( ruleOutdir )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:918:1: ruleOutdir
            {
             before(grammarAccess.getComprendoAccess().getOutdirOutdirParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleOutdir_in_rule__Comprendo__OutdirAssignment_41771);
            ruleOutdir();
            _fsp--;

             after(grammarAccess.getComprendoAccess().getOutdirOutdirParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Comprendo__OutdirAssignment_4


    // $ANTLR start rule__Comprendo__CommandsAssignment_5
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:927:1: rule__Comprendo__CommandsAssignment_5 : ( ruleCommand ) ;
    public final void rule__Comprendo__CommandsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:931:1: ( ( ruleCommand ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:932:1: ( ruleCommand )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:932:1: ( ruleCommand )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:933:1: ruleCommand
            {
             before(grammarAccess.getComprendoAccess().getCommandsCommandParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleCommand_in_rule__Comprendo__CommandsAssignment_51802);
            ruleCommand();
            _fsp--;

             after(grammarAccess.getComprendoAccess().getCommandsCommandParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Comprendo__CommandsAssignment_5


    // $ANTLR start rule__Scope__ValueAssignment_2
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:942:1: rule__Scope__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Scope__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:946:1: ( ( RULE_STRING ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:947:1: ( RULE_STRING )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:947:1: ( RULE_STRING )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:948:1: RULE_STRING
            {
             before(grammarAccess.getScopeAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Scope__ValueAssignment_21833); 
             after(grammarAccess.getScopeAccess().getValueSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Scope__ValueAssignment_2


    // $ANTLR start rule__Command__IdAssignment_0
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:957:1: rule__Command__IdAssignment_0 : ( ( rule__Command__IdAlternatives_0_0 ) ) ;
    public final void rule__Command__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:961:1: ( ( ( rule__Command__IdAlternatives_0_0 ) ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:962:1: ( ( rule__Command__IdAlternatives_0_0 ) )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:962:1: ( ( rule__Command__IdAlternatives_0_0 ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:963:1: ( rule__Command__IdAlternatives_0_0 )
            {
             before(grammarAccess.getCommandAccess().getIdAlternatives_0_0()); 
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:964:1: ( rule__Command__IdAlternatives_0_0 )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:964:2: rule__Command__IdAlternatives_0_0
            {
            pushFollow(FOLLOW_rule__Command__IdAlternatives_0_0_in_rule__Command__IdAssignment_01864);
            rule__Command__IdAlternatives_0_0();
            _fsp--;


            }

             after(grammarAccess.getCommandAccess().getIdAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Command__IdAssignment_0


    // $ANTLR start rule__Command__SummaryAssignment_1_1
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:973:1: rule__Command__SummaryAssignment_1_1 : ( ( 'summary' ) ) ;
    public final void rule__Command__SummaryAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:977:1: ( ( ( 'summary' ) ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:978:1: ( ( 'summary' ) )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:978:1: ( ( 'summary' ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:979:1: ( 'summary' )
            {
             before(grammarAccess.getCommandAccess().getSummarySummaryKeyword_1_1_0()); 
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:980:1: ( 'summary' )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:981:1: 'summary'
            {
             before(grammarAccess.getCommandAccess().getSummarySummaryKeyword_1_1_0()); 
            match(input,21,FOLLOW_21_in_rule__Command__SummaryAssignment_1_11902); 
             after(grammarAccess.getCommandAccess().getSummarySummaryKeyword_1_1_0()); 

            }

             after(grammarAccess.getCommandAccess().getSummarySummaryKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Command__SummaryAssignment_1_1


    // $ANTLR start rule__Outdir__ValueAssignment_2
    // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:996:1: rule__Outdir__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Outdir__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:1000:1: ( ( RULE_STRING ) )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:1001:1: ( RULE_STRING )
            {
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:1001:1: ( RULE_STRING )
            // ../xtext.comprendo.ui/src-gen/xtext/comprendo/ui/contentassist/antlr/internal/InternalComprendo.g:1002:1: RULE_STRING
            {
             before(grammarAccess.getOutdirAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Outdir__ValueAssignment_21941); 
             after(grammarAccess.getOutdirAccess().getValueSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Outdir__ValueAssignment_2


 

    public static final BitSet FOLLOW_ruleComprendoDSAL_in_entryRuleComprendoDSAL61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComprendoDSAL68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComprendoDSAL__ComprendoAssignment_in_ruleComprendoDSAL94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComprendo_in_entryRuleComprendo121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComprendo128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comprendo__Group__0_in_ruleComprendo154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScope_in_entryRuleScope181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScope188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scope__Group__0_in_ruleScope214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__Group__0_in_ruleCommand274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutdir_in_entryRuleOutdir301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOutdir308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Outdir__Group__0_in_ruleOutdir334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Command__IdAlternatives_0_0371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Command__IdAlternatives_0_0391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comprendo__Group__0__Impl_in_rule__Comprendo__Group__0423 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Comprendo__Group__1_in_rule__Comprendo__Group__0426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Comprendo__Group__0__Impl454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comprendo__Group__1__Impl_in_rule__Comprendo__Group__1485 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Comprendo__Group__2_in_rule__Comprendo__Group__1488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comprendo__NameAssignment_1_in_rule__Comprendo__Group__1__Impl515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comprendo__Group__2__Impl_in_rule__Comprendo__Group__2545 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Comprendo__Group__3_in_rule__Comprendo__Group__2548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Comprendo__Group__2__Impl576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comprendo__Group__3__Impl_in_rule__Comprendo__Group__3607 = new BitSet(new long[]{0x0000000000109800L});
    public static final BitSet FOLLOW_rule__Comprendo__Group__4_in_rule__Comprendo__Group__3610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comprendo__ScopeAssignment_3_in_rule__Comprendo__Group__3__Impl637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comprendo__Group__4__Impl_in_rule__Comprendo__Group__4667 = new BitSet(new long[]{0x0000000000009800L});
    public static final BitSet FOLLOW_rule__Comprendo__Group__5_in_rule__Comprendo__Group__4670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comprendo__OutdirAssignment_4_in_rule__Comprendo__Group__4__Impl697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comprendo__Group__5__Impl_in_rule__Comprendo__Group__5728 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Comprendo__Group__6_in_rule__Comprendo__Group__5731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comprendo__CommandsAssignment_5_in_rule__Comprendo__Group__5__Impl758 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_rule__Comprendo__Group__6__Impl_in_rule__Comprendo__Group__6789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Comprendo__Group__6__Impl817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scope__Group__0__Impl_in_rule__Scope__Group__0862 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Scope__Group__1_in_rule__Scope__Group__0865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Scope__Group__0__Impl893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scope__Group__1__Impl_in_rule__Scope__Group__1924 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Scope__Group__2_in_rule__Scope__Group__1927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Scope__Group__1__Impl955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scope__Group__2__Impl_in_rule__Scope__Group__2986 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Scope__Group__3_in_rule__Scope__Group__2989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scope__ValueAssignment_2_in_rule__Scope__Group__2__Impl1016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scope__Group__3__Impl_in_rule__Scope__Group__31046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Scope__Group__3__Impl1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__Group__0__Impl_in_rule__Command__Group__01113 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_rule__Command__Group__1_in_rule__Command__Group__01116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__IdAssignment_0_in_rule__Command__Group__0__Impl1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__Group__1__Impl_in_rule__Command__Group__11173 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Command__Group__2_in_rule__Command__Group__11176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__Group_1__0_in_rule__Command__Group__1__Impl1203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__Group__2__Impl_in_rule__Command__Group__21234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Command__Group__2__Impl1262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__Group_1__0__Impl_in_rule__Command__Group_1__01299 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Command__Group_1__1_in_rule__Command__Group_1__01302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Command__Group_1__0__Impl1330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__Group_1__1__Impl_in_rule__Command__Group_1__11361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__SummaryAssignment_1_1_in_rule__Command__Group_1__1__Impl1388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Outdir__Group__0__Impl_in_rule__Outdir__Group__01422 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Outdir__Group__1_in_rule__Outdir__Group__01425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Outdir__Group__0__Impl1453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Outdir__Group__1__Impl_in_rule__Outdir__Group__11484 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Outdir__Group__2_in_rule__Outdir__Group__11487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Outdir__Group__1__Impl1515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Outdir__Group__2__Impl_in_rule__Outdir__Group__21546 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Outdir__Group__3_in_rule__Outdir__Group__21549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Outdir__ValueAssignment_2_in_rule__Outdir__Group__2__Impl1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Outdir__Group__3__Impl_in_rule__Outdir__Group__31606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Outdir__Group__3__Impl1634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComprendo_in_rule__ComprendoDSAL__ComprendoAssignment1678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Comprendo__NameAssignment_11709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScope_in_rule__Comprendo__ScopeAssignment_31740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutdir_in_rule__Comprendo__OutdirAssignment_41771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_rule__Comprendo__CommandsAssignment_51802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Scope__ValueAssignment_21833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Command__IdAlternatives_0_0_in_rule__Command__IdAssignment_01864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Command__SummaryAssignment_1_11902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Outdir__ValueAssignment_21941 = new BitSet(new long[]{0x0000000000000002L});

}