/*
* generated by Xtext
*/
package xtext.comprendo.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import xtext.comprendo.services.ComprendoGrammarAccess;

public class ComprendoParser extends AbstractContentAssistParser {
	
	@Inject
	private ComprendoGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected xtext.comprendo.ui.contentassist.antlr.internal.InternalComprendoParser createParser() {
		xtext.comprendo.ui.contentassist.antlr.internal.InternalComprendoParser result = new xtext.comprendo.ui.contentassist.antlr.internal.InternalComprendoParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getCommandAccess().getIdAlternatives_0_0(), "rule__Command__IdAlternatives_0_0");
					put(grammarAccess.getComprendoAccess().getGroup(), "rule__Comprendo__Group__0");
					put(grammarAccess.getScopeAccess().getGroup(), "rule__Scope__Group__0");
					put(grammarAccess.getCommandAccess().getGroup(), "rule__Command__Group__0");
					put(grammarAccess.getCommandAccess().getGroup_1(), "rule__Command__Group_1__0");
					put(grammarAccess.getOutdirAccess().getGroup(), "rule__Outdir__Group__0");
					put(grammarAccess.getComprendoDSALAccess().getComprendoAssignment(), "rule__ComprendoDSAL__ComprendoAssignment");
					put(grammarAccess.getComprendoAccess().getNameAssignment_1(), "rule__Comprendo__NameAssignment_1");
					put(grammarAccess.getComprendoAccess().getScopeAssignment_3(), "rule__Comprendo__ScopeAssignment_3");
					put(grammarAccess.getComprendoAccess().getOutdirAssignment_4(), "rule__Comprendo__OutdirAssignment_4");
					put(grammarAccess.getComprendoAccess().getCommandsAssignment_5(), "rule__Comprendo__CommandsAssignment_5");
					put(grammarAccess.getScopeAccess().getValueAssignment_2(), "rule__Scope__ValueAssignment_2");
					put(grammarAccess.getCommandAccess().getIdAssignment_0(), "rule__Command__IdAssignment_0");
					put(grammarAccess.getCommandAccess().getSummaryAssignment_1_1(), "rule__Command__SummaryAssignment_1_1");
					put(grammarAccess.getOutdirAccess().getValueAssignment_2(), "rule__Outdir__ValueAssignment_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			xtext.comprendo.ui.contentassist.antlr.internal.InternalComprendoParser typedParser = (xtext.comprendo.ui.contentassist.antlr.internal.InternalComprendoParser) parser;
			typedParser.entryRuleComprendoDSAL();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public ComprendoGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ComprendoGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
