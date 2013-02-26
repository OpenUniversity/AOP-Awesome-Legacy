package xtext.cool.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import xtext.cool.cool.CondVar;
import xtext.cool.cool.CoolPackage;
import xtext.cool.cool.CoordinatorBody;
import xtext.cool.cool.CoordinatorDeclaration;
import xtext.cool.cool.MutexSet;
import xtext.cool.cool.OrdVar;
import xtext.cool.services.CoolGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractCoolSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected CoolGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == CoolPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case CoolPackage.COND_VAR:
				if(context == grammarAccess.getCondVarRule()) {
					sequence_CondVar(context, (CondVar) semanticObject); 
					return; 
				}
				else break;
			case CoolPackage.COORDINATOR_BODY:
				if(context == grammarAccess.getCoordinatorBodyRule()) {
					sequence_CoordinatorBody(context, (CoordinatorBody) semanticObject); 
					return; 
				}
				else break;
			case CoolPackage.COORDINATOR_DECLARATION:
				if(context == grammarAccess.getCoordinatorDeclarationRule()) {
					sequence_CoordinatorDeclaration(context, (CoordinatorDeclaration) semanticObject); 
					return; 
				}
				else break;
			case CoolPackage.MUTEX_SET:
				if(context == grammarAccess.getMutexSetRule()) {
					sequence_MutexSet(context, (MutexSet) semanticObject); 
					return; 
				}
				else break;
			case CoolPackage.ORD_VAR:
				if(context == grammarAccess.getOrdVarRule()) {
					sequence_OrdVar(context, (OrdVar) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID value=BooleanVal)
	 */
	protected void sequence_CondVar(EObject context, CondVar semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CoolPackage.Literals.COND_VAR__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CoolPackage.Literals.COND_VAR__NAME));
			if(transientValues.isValueTransient(semanticObject, CoolPackage.Literals.COND_VAR__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CoolPackage.Literals.COND_VAR__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCondVarAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getCondVarAccess().getValueBooleanValParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (condVars+=CondVar condVars+=CondVar*)* 
	 *         (ordVars+=OrdVar ordVars+=OrdVar*)* 
	 *         (selfexMethods+=QualifiedName selfexMethods+=QualifiedName*)? 
	 *         mutexSets+=MutexSet*
	 *     )
	 */
	protected void sequence_CoordinatorBody(EObject context, CoordinatorBody semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (granularity='per_class'? className=QualifiedName body=CoordinatorBody?)
	 */
	protected void sequence_CoordinatorDeclaration(EObject context, CoordinatorDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (methods+=QualifiedName methods+=QualifiedName+)
	 */
	protected void sequence_MutexSet(EObject context, MutexSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID value=INT)
	 */
	protected void sequence_OrdVar(EObject context, OrdVar semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CoolPackage.Literals.ORD_VAR__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CoolPackage.Literals.ORD_VAR__NAME));
			if(transientValues.isValueTransient(semanticObject, CoolPackage.Literals.ORD_VAR__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CoolPackage.Literals.ORD_VAR__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOrdVarAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getOrdVarAccess().getValueINTTerminalRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
}
