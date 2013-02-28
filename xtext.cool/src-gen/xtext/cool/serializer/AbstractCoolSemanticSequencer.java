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
import xtext.cool.cool.AndExpression;
import xtext.cool.cool.AssignStatement;
import xtext.cool.cool.AssignedValue;
import xtext.cool.cool.BasicExpression;
import xtext.cool.cool.CondVar;
import xtext.cool.cool.CoolPackage;
import xtext.cool.cool.CoordinatorBody;
import xtext.cool.cool.CoordinatorDeclaration;
import xtext.cool.cool.Guard;
import xtext.cool.cool.IfExpression;
import xtext.cool.cool.IfStatement;
import xtext.cool.cool.MutexSet;
import xtext.cool.cool.OrExpression;
import xtext.cool.cool.OrdVar;
import xtext.cool.cool.Requires;
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
			case CoolPackage.AND_EXPRESSION:
				if(context == grammarAccess.getAndExpressionRule()) {
					sequence_AndExpression(context, (AndExpression) semanticObject); 
					return; 
				}
				else break;
			case CoolPackage.ASSIGN_STATEMENT:
				if(context == grammarAccess.getAssignStatementRule()) {
					sequence_AssignStatement(context, (AssignStatement) semanticObject); 
					return; 
				}
				else break;
			case CoolPackage.ASSIGNED_VALUE:
				if(context == grammarAccess.getAssignedValueRule()) {
					sequence_AssignedValue(context, (AssignedValue) semanticObject); 
					return; 
				}
				else break;
			case CoolPackage.BASIC_EXPRESSION:
				if(context == grammarAccess.getBasicExpressionRule()) {
					sequence_BasicExpression(context, (BasicExpression) semanticObject); 
					return; 
				}
				else break;
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
			case CoolPackage.GUARD:
				if(context == grammarAccess.getGuardRule()) {
					sequence_Guard(context, (Guard) semanticObject); 
					return; 
				}
				else break;
			case CoolPackage.IF_EXPRESSION:
				if(context == grammarAccess.getIfExpressionRule()) {
					sequence_IfExpression(context, (IfExpression) semanticObject); 
					return; 
				}
				else break;
			case CoolPackage.IF_STATEMENT:
				if(context == grammarAccess.getIfStatementRule()) {
					sequence_IfStatement(context, (IfStatement) semanticObject); 
					return; 
				}
				else break;
			case CoolPackage.MUTEX_SET:
				if(context == grammarAccess.getMutexSetRule()) {
					sequence_MutexSet(context, (MutexSet) semanticObject); 
					return; 
				}
				else break;
			case CoolPackage.OR_EXPRESSION:
				if(context == grammarAccess.getOrExpressionRule()) {
					sequence_OrExpression(context, (OrExpression) semanticObject); 
					return; 
				}
				else break;
			case CoolPackage.ORD_VAR:
				if(context == grammarAccess.getOrdVarRule()) {
					sequence_OrdVar(context, (OrdVar) semanticObject); 
					return; 
				}
				else break;
			case CoolPackage.REQUIRES:
				if(context == grammarAccess.getRequiresRule()) {
					sequence_Requires(context, (Requires) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (orExpressions+=OrExpression orExpressions+=OrExpression*)
	 */
	protected void sequence_AndExpression(EObject context, AndExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (var=[CondVar|ID] value=BooleanVal)
	 */
	protected void sequence_AssignStatement(EObject context, AssignStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CoolPackage.Literals.ASSIGN_STATEMENT__VAR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CoolPackage.Literals.ASSIGN_STATEMENT__VAR));
			if(transientValues.isValueTransient(semanticObject, CoolPackage.Literals.ASSIGN_STATEMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CoolPackage.Literals.ASSIGN_STATEMENT__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAssignStatementAccess().getVarCondVarIDTerminalRuleCall_0_0_1(), semanticObject.getVar());
		feeder.accept(grammarAccess.getAssignStatementAccess().getValueBooleanValParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (intval=INT | boolval='true' | boolval='false')
	 */
	protected void sequence_AssignedValue(EObject context, AssignedValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (negated?='!'? expr=[CondVar|ID])
	 */
	protected void sequence_BasicExpression(EObject context, BasicExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
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
	 *         guards+=Guard*
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
	 *     (
	 *         methods+=ID 
	 *         methods+=ID* 
	 *         requires=Requires? 
	 *         (onEntryIfStatements+=IfStatement | onEntryAssignStatements+=AssignStatement)* 
	 *         (onExitIfStatements+=IfStatement | onExitAssignStatements+=AssignStatement)*
	 *     )
	 */
	protected void sequence_Guard(EObject context, Guard semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (var=ID (op='==' | op='!=') assignment=AssignedValue)
	 */
	protected void sequence_IfExpression(EObject context, IfExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression=IfExpression statement=AssignStatement)
	 */
	protected void sequence_IfStatement(EObject context, IfStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CoolPackage.Literals.IF_STATEMENT__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CoolPackage.Literals.IF_STATEMENT__EXPRESSION));
			if(transientValues.isValueTransient(semanticObject, CoolPackage.Literals.IF_STATEMENT__STATEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CoolPackage.Literals.IF_STATEMENT__STATEMENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIfStatementAccess().getExpressionIfExpressionParserRuleCall_2_0(), semanticObject.getExpression());
		feeder.accept(grammarAccess.getIfStatementAccess().getStatementAssignStatementParserRuleCall_4_0(), semanticObject.getStatement());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (methods+=ID methods+=ID+)
	 */
	protected void sequence_MutexSet(EObject context, MutexSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (basicExpressions+=BasicExpression basicExpressions+=BasicExpression*)
	 */
	protected void sequence_OrExpression(EObject context, OrExpression semanticObject) {
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
	
	
	/**
	 * Constraint:
	 *     andExpression=AndExpression
	 */
	protected void sequence_Requires(EObject context, Requires semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CoolPackage.Literals.REQUIRES__AND_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CoolPackage.Literals.REQUIRES__AND_EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRequiresAccess().getAndExpressionAndExpressionParserRuleCall_1_0(), semanticObject.getAndExpression());
		feeder.finish();
	}
}
