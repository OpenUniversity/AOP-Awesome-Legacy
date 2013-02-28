/**
 * <copyright>
 * </copyright>
 *
 */
package xtext.cool.cool;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see xtext.cool.cool.CoolFactory
 * @model kind="package"
 * @generated
 */
public interface CoolPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "cool";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.cool.xtext/Cool";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "cool";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CoolPackage eINSTANCE = xtext.cool.cool.impl.CoolPackageImpl.init();

  /**
   * The meta object id for the '{@link xtext.cool.cool.impl.CoordinatorDeclarationImpl <em>Coordinator Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.cool.cool.impl.CoordinatorDeclarationImpl
   * @see xtext.cool.cool.impl.CoolPackageImpl#getCoordinatorDeclaration()
   * @generated
   */
  int COORDINATOR_DECLARATION = 0;

  /**
   * The feature id for the '<em><b>Granularity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COORDINATOR_DECLARATION__GRANULARITY = 0;

  /**
   * The feature id for the '<em><b>Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COORDINATOR_DECLARATION__CLASS_NAME = 1;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COORDINATOR_DECLARATION__BODY = 2;

  /**
   * The number of structural features of the '<em>Coordinator Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COORDINATOR_DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link xtext.cool.cool.impl.CoordinatorBodyImpl <em>Coordinator Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.cool.cool.impl.CoordinatorBodyImpl
   * @see xtext.cool.cool.impl.CoolPackageImpl#getCoordinatorBody()
   * @generated
   */
  int COORDINATOR_BODY = 1;

  /**
   * The feature id for the '<em><b>Cond Vars</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COORDINATOR_BODY__COND_VARS = 0;

  /**
   * The feature id for the '<em><b>Ord Vars</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COORDINATOR_BODY__ORD_VARS = 1;

  /**
   * The feature id for the '<em><b>Selfex Methods</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COORDINATOR_BODY__SELFEX_METHODS = 2;

  /**
   * The feature id for the '<em><b>Mutex Sets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COORDINATOR_BODY__MUTEX_SETS = 3;

  /**
   * The feature id for the '<em><b>Guards</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COORDINATOR_BODY__GUARDS = 4;

  /**
   * The number of structural features of the '<em>Coordinator Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COORDINATOR_BODY_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link xtext.cool.cool.impl.GuardImpl <em>Guard</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.cool.cool.impl.GuardImpl
   * @see xtext.cool.cool.impl.CoolPackageImpl#getGuard()
   * @generated
   */
  int GUARD = 2;

  /**
   * The feature id for the '<em><b>Methods</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD__METHODS = 0;

  /**
   * The feature id for the '<em><b>Requires</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD__REQUIRES = 1;

  /**
   * The feature id for the '<em><b>On Entry If Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD__ON_ENTRY_IF_STATEMENTS = 2;

  /**
   * The feature id for the '<em><b>On Entry Assign Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD__ON_ENTRY_ASSIGN_STATEMENTS = 3;

  /**
   * The feature id for the '<em><b>On Exit If Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD__ON_EXIT_IF_STATEMENTS = 4;

  /**
   * The feature id for the '<em><b>On Exit Assign Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD__ON_EXIT_ASSIGN_STATEMENTS = 5;

  /**
   * The number of structural features of the '<em>Guard</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link xtext.cool.cool.impl.IfStatementImpl <em>If Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.cool.cool.impl.IfStatementImpl
   * @see xtext.cool.cool.impl.CoolPackageImpl#getIfStatement()
   * @generated
   */
  int IF_STATEMENT = 3;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__EXPRESSION = 0;

  /**
   * The feature id for the '<em><b>Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__STATEMENT = 1;

  /**
   * The number of structural features of the '<em>If Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link xtext.cool.cool.impl.IfExpressionImpl <em>If Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.cool.cool.impl.IfExpressionImpl
   * @see xtext.cool.cool.impl.CoolPackageImpl#getIfExpression()
   * @generated
   */
  int IF_EXPRESSION = 4;

  /**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPRESSION__VAR = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPRESSION__OP = 1;

  /**
   * The feature id for the '<em><b>Assignment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPRESSION__ASSIGNMENT = 2;

  /**
   * The number of structural features of the '<em>If Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPRESSION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link xtext.cool.cool.impl.AssignedValueImpl <em>Assigned Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.cool.cool.impl.AssignedValueImpl
   * @see xtext.cool.cool.impl.CoolPackageImpl#getAssignedValue()
   * @generated
   */
  int ASSIGNED_VALUE = 5;

  /**
   * The feature id for the '<em><b>Intval</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNED_VALUE__INTVAL = 0;

  /**
   * The feature id for the '<em><b>Boolval</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNED_VALUE__BOOLVAL = 1;

  /**
   * The number of structural features of the '<em>Assigned Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNED_VALUE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link xtext.cool.cool.impl.AssignStatementImpl <em>Assign Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.cool.cool.impl.AssignStatementImpl
   * @see xtext.cool.cool.impl.CoolPackageImpl#getAssignStatement()
   * @generated
   */
  int ASSIGN_STATEMENT = 6;

  /**
   * The feature id for the '<em><b>Var</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN_STATEMENT__VAR = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN_STATEMENT__VALUE = 1;

  /**
   * The number of structural features of the '<em>Assign Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN_STATEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link xtext.cool.cool.impl.RequiresImpl <em>Requires</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.cool.cool.impl.RequiresImpl
   * @see xtext.cool.cool.impl.CoolPackageImpl#getRequires()
   * @generated
   */
  int REQUIRES = 7;

  /**
   * The feature id for the '<em><b>And Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIRES__AND_EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Requires</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIRES_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link xtext.cool.cool.impl.AndExpressionImpl <em>And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.cool.cool.impl.AndExpressionImpl
   * @see xtext.cool.cool.impl.CoolPackageImpl#getAndExpression()
   * @generated
   */
  int AND_EXPRESSION = 8;

  /**
   * The feature id for the '<em><b>Or Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__OR_EXPRESSIONS = 0;

  /**
   * The number of structural features of the '<em>And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link xtext.cool.cool.impl.OrExpressionImpl <em>Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.cool.cool.impl.OrExpressionImpl
   * @see xtext.cool.cool.impl.CoolPackageImpl#getOrExpression()
   * @generated
   */
  int OR_EXPRESSION = 9;

  /**
   * The feature id for the '<em><b>Basic Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION__BASIC_EXPRESSIONS = 0;

  /**
   * The number of structural features of the '<em>Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link xtext.cool.cool.impl.BasicExpressionImpl <em>Basic Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.cool.cool.impl.BasicExpressionImpl
   * @see xtext.cool.cool.impl.CoolPackageImpl#getBasicExpression()
   * @generated
   */
  int BASIC_EXPRESSION = 10;

  /**
   * The feature id for the '<em><b>Negated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_EXPRESSION__NEGATED = 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_EXPRESSION__EXPR = 1;

  /**
   * The number of structural features of the '<em>Basic Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link xtext.cool.cool.impl.MutexSetImpl <em>Mutex Set</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.cool.cool.impl.MutexSetImpl
   * @see xtext.cool.cool.impl.CoolPackageImpl#getMutexSet()
   * @generated
   */
  int MUTEX_SET = 11;

  /**
   * The feature id for the '<em><b>Methods</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUTEX_SET__METHODS = 0;

  /**
   * The number of structural features of the '<em>Mutex Set</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUTEX_SET_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link xtext.cool.cool.impl.CondVarImpl <em>Cond Var</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.cool.cool.impl.CondVarImpl
   * @see xtext.cool.cool.impl.CoolPackageImpl#getCondVar()
   * @generated
   */
  int COND_VAR = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COND_VAR__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COND_VAR__VALUE = 1;

  /**
   * The number of structural features of the '<em>Cond Var</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COND_VAR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link xtext.cool.cool.impl.OrdVarImpl <em>Ord Var</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.cool.cool.impl.OrdVarImpl
   * @see xtext.cool.cool.impl.CoolPackageImpl#getOrdVar()
   * @generated
   */
  int ORD_VAR = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORD_VAR__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORD_VAR__VALUE = 1;

  /**
   * The number of structural features of the '<em>Ord Var</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORD_VAR_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link xtext.cool.cool.CoordinatorDeclaration <em>Coordinator Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Coordinator Declaration</em>'.
   * @see xtext.cool.cool.CoordinatorDeclaration
   * @generated
   */
  EClass getCoordinatorDeclaration();

  /**
   * Returns the meta object for the attribute '{@link xtext.cool.cool.CoordinatorDeclaration#getGranularity <em>Granularity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Granularity</em>'.
   * @see xtext.cool.cool.CoordinatorDeclaration#getGranularity()
   * @see #getCoordinatorDeclaration()
   * @generated
   */
  EAttribute getCoordinatorDeclaration_Granularity();

  /**
   * Returns the meta object for the attribute '{@link xtext.cool.cool.CoordinatorDeclaration#getClassName <em>Class Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Class Name</em>'.
   * @see xtext.cool.cool.CoordinatorDeclaration#getClassName()
   * @see #getCoordinatorDeclaration()
   * @generated
   */
  EAttribute getCoordinatorDeclaration_ClassName();

  /**
   * Returns the meta object for the containment reference '{@link xtext.cool.cool.CoordinatorDeclaration#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see xtext.cool.cool.CoordinatorDeclaration#getBody()
   * @see #getCoordinatorDeclaration()
   * @generated
   */
  EReference getCoordinatorDeclaration_Body();

  /**
   * Returns the meta object for class '{@link xtext.cool.cool.CoordinatorBody <em>Coordinator Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Coordinator Body</em>'.
   * @see xtext.cool.cool.CoordinatorBody
   * @generated
   */
  EClass getCoordinatorBody();

  /**
   * Returns the meta object for the containment reference list '{@link xtext.cool.cool.CoordinatorBody#getCondVars <em>Cond Vars</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Cond Vars</em>'.
   * @see xtext.cool.cool.CoordinatorBody#getCondVars()
   * @see #getCoordinatorBody()
   * @generated
   */
  EReference getCoordinatorBody_CondVars();

  /**
   * Returns the meta object for the containment reference list '{@link xtext.cool.cool.CoordinatorBody#getOrdVars <em>Ord Vars</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ord Vars</em>'.
   * @see xtext.cool.cool.CoordinatorBody#getOrdVars()
   * @see #getCoordinatorBody()
   * @generated
   */
  EReference getCoordinatorBody_OrdVars();

  /**
   * Returns the meta object for the attribute list '{@link xtext.cool.cool.CoordinatorBody#getSelfexMethods <em>Selfex Methods</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Selfex Methods</em>'.
   * @see xtext.cool.cool.CoordinatorBody#getSelfexMethods()
   * @see #getCoordinatorBody()
   * @generated
   */
  EAttribute getCoordinatorBody_SelfexMethods();

  /**
   * Returns the meta object for the containment reference list '{@link xtext.cool.cool.CoordinatorBody#getMutexSets <em>Mutex Sets</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Mutex Sets</em>'.
   * @see xtext.cool.cool.CoordinatorBody#getMutexSets()
   * @see #getCoordinatorBody()
   * @generated
   */
  EReference getCoordinatorBody_MutexSets();

  /**
   * Returns the meta object for the containment reference list '{@link xtext.cool.cool.CoordinatorBody#getGuards <em>Guards</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Guards</em>'.
   * @see xtext.cool.cool.CoordinatorBody#getGuards()
   * @see #getCoordinatorBody()
   * @generated
   */
  EReference getCoordinatorBody_Guards();

  /**
   * Returns the meta object for class '{@link xtext.cool.cool.Guard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Guard</em>'.
   * @see xtext.cool.cool.Guard
   * @generated
   */
  EClass getGuard();

  /**
   * Returns the meta object for the attribute list '{@link xtext.cool.cool.Guard#getMethods <em>Methods</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Methods</em>'.
   * @see xtext.cool.cool.Guard#getMethods()
   * @see #getGuard()
   * @generated
   */
  EAttribute getGuard_Methods();

  /**
   * Returns the meta object for the containment reference '{@link xtext.cool.cool.Guard#getRequires <em>Requires</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Requires</em>'.
   * @see xtext.cool.cool.Guard#getRequires()
   * @see #getGuard()
   * @generated
   */
  EReference getGuard_Requires();

  /**
   * Returns the meta object for the containment reference list '{@link xtext.cool.cool.Guard#getOnEntryIfStatements <em>On Entry If Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>On Entry If Statements</em>'.
   * @see xtext.cool.cool.Guard#getOnEntryIfStatements()
   * @see #getGuard()
   * @generated
   */
  EReference getGuard_OnEntryIfStatements();

  /**
   * Returns the meta object for the containment reference list '{@link xtext.cool.cool.Guard#getOnEntryAssignStatements <em>On Entry Assign Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>On Entry Assign Statements</em>'.
   * @see xtext.cool.cool.Guard#getOnEntryAssignStatements()
   * @see #getGuard()
   * @generated
   */
  EReference getGuard_OnEntryAssignStatements();

  /**
   * Returns the meta object for the containment reference list '{@link xtext.cool.cool.Guard#getOnExitIfStatements <em>On Exit If Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>On Exit If Statements</em>'.
   * @see xtext.cool.cool.Guard#getOnExitIfStatements()
   * @see #getGuard()
   * @generated
   */
  EReference getGuard_OnExitIfStatements();

  /**
   * Returns the meta object for the containment reference list '{@link xtext.cool.cool.Guard#getOnExitAssignStatements <em>On Exit Assign Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>On Exit Assign Statements</em>'.
   * @see xtext.cool.cool.Guard#getOnExitAssignStatements()
   * @see #getGuard()
   * @generated
   */
  EReference getGuard_OnExitAssignStatements();

  /**
   * Returns the meta object for class '{@link xtext.cool.cool.IfStatement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Statement</em>'.
   * @see xtext.cool.cool.IfStatement
   * @generated
   */
  EClass getIfStatement();

  /**
   * Returns the meta object for the containment reference '{@link xtext.cool.cool.IfStatement#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see xtext.cool.cool.IfStatement#getExpression()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_Expression();

  /**
   * Returns the meta object for the containment reference '{@link xtext.cool.cool.IfStatement#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Statement</em>'.
   * @see xtext.cool.cool.IfStatement#getStatement()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_Statement();

  /**
   * Returns the meta object for class '{@link xtext.cool.cool.IfExpression <em>If Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Expression</em>'.
   * @see xtext.cool.cool.IfExpression
   * @generated
   */
  EClass getIfExpression();

  /**
   * Returns the meta object for the attribute '{@link xtext.cool.cool.IfExpression#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var</em>'.
   * @see xtext.cool.cool.IfExpression#getVar()
   * @see #getIfExpression()
   * @generated
   */
  EAttribute getIfExpression_Var();

  /**
   * Returns the meta object for the attribute '{@link xtext.cool.cool.IfExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see xtext.cool.cool.IfExpression#getOp()
   * @see #getIfExpression()
   * @generated
   */
  EAttribute getIfExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link xtext.cool.cool.IfExpression#getAssignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Assignment</em>'.
   * @see xtext.cool.cool.IfExpression#getAssignment()
   * @see #getIfExpression()
   * @generated
   */
  EReference getIfExpression_Assignment();

  /**
   * Returns the meta object for class '{@link xtext.cool.cool.AssignedValue <em>Assigned Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assigned Value</em>'.
   * @see xtext.cool.cool.AssignedValue
   * @generated
   */
  EClass getAssignedValue();

  /**
   * Returns the meta object for the attribute '{@link xtext.cool.cool.AssignedValue#getIntval <em>Intval</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Intval</em>'.
   * @see xtext.cool.cool.AssignedValue#getIntval()
   * @see #getAssignedValue()
   * @generated
   */
  EAttribute getAssignedValue_Intval();

  /**
   * Returns the meta object for the attribute '{@link xtext.cool.cool.AssignedValue#getBoolval <em>Boolval</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Boolval</em>'.
   * @see xtext.cool.cool.AssignedValue#getBoolval()
   * @see #getAssignedValue()
   * @generated
   */
  EAttribute getAssignedValue_Boolval();

  /**
   * Returns the meta object for class '{@link xtext.cool.cool.AssignStatement <em>Assign Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assign Statement</em>'.
   * @see xtext.cool.cool.AssignStatement
   * @generated
   */
  EClass getAssignStatement();

  /**
   * Returns the meta object for the reference '{@link xtext.cool.cool.AssignStatement#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Var</em>'.
   * @see xtext.cool.cool.AssignStatement#getVar()
   * @see #getAssignStatement()
   * @generated
   */
  EReference getAssignStatement_Var();

  /**
   * Returns the meta object for the attribute '{@link xtext.cool.cool.AssignStatement#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see xtext.cool.cool.AssignStatement#getValue()
   * @see #getAssignStatement()
   * @generated
   */
  EAttribute getAssignStatement_Value();

  /**
   * Returns the meta object for class '{@link xtext.cool.cool.Requires <em>Requires</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Requires</em>'.
   * @see xtext.cool.cool.Requires
   * @generated
   */
  EClass getRequires();

  /**
   * Returns the meta object for the containment reference '{@link xtext.cool.cool.Requires#getAndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>And Expression</em>'.
   * @see xtext.cool.cool.Requires#getAndExpression()
   * @see #getRequires()
   * @generated
   */
  EReference getRequires_AndExpression();

  /**
   * Returns the meta object for class '{@link xtext.cool.cool.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Expression</em>'.
   * @see xtext.cool.cool.AndExpression
   * @generated
   */
  EClass getAndExpression();

  /**
   * Returns the meta object for the containment reference list '{@link xtext.cool.cool.AndExpression#getOrExpressions <em>Or Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Or Expressions</em>'.
   * @see xtext.cool.cool.AndExpression#getOrExpressions()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_OrExpressions();

  /**
   * Returns the meta object for class '{@link xtext.cool.cool.OrExpression <em>Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Expression</em>'.
   * @see xtext.cool.cool.OrExpression
   * @generated
   */
  EClass getOrExpression();

  /**
   * Returns the meta object for the containment reference list '{@link xtext.cool.cool.OrExpression#getBasicExpressions <em>Basic Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Basic Expressions</em>'.
   * @see xtext.cool.cool.OrExpression#getBasicExpressions()
   * @see #getOrExpression()
   * @generated
   */
  EReference getOrExpression_BasicExpressions();

  /**
   * Returns the meta object for class '{@link xtext.cool.cool.BasicExpression <em>Basic Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Basic Expression</em>'.
   * @see xtext.cool.cool.BasicExpression
   * @generated
   */
  EClass getBasicExpression();

  /**
   * Returns the meta object for the attribute '{@link xtext.cool.cool.BasicExpression#isNegated <em>Negated</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Negated</em>'.
   * @see xtext.cool.cool.BasicExpression#isNegated()
   * @see #getBasicExpression()
   * @generated
   */
  EAttribute getBasicExpression_Negated();

  /**
   * Returns the meta object for the reference '{@link xtext.cool.cool.BasicExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Expr</em>'.
   * @see xtext.cool.cool.BasicExpression#getExpr()
   * @see #getBasicExpression()
   * @generated
   */
  EReference getBasicExpression_Expr();

  /**
   * Returns the meta object for class '{@link xtext.cool.cool.MutexSet <em>Mutex Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mutex Set</em>'.
   * @see xtext.cool.cool.MutexSet
   * @generated
   */
  EClass getMutexSet();

  /**
   * Returns the meta object for the attribute list '{@link xtext.cool.cool.MutexSet#getMethods <em>Methods</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Methods</em>'.
   * @see xtext.cool.cool.MutexSet#getMethods()
   * @see #getMutexSet()
   * @generated
   */
  EAttribute getMutexSet_Methods();

  /**
   * Returns the meta object for class '{@link xtext.cool.cool.CondVar <em>Cond Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cond Var</em>'.
   * @see xtext.cool.cool.CondVar
   * @generated
   */
  EClass getCondVar();

  /**
   * Returns the meta object for the attribute '{@link xtext.cool.cool.CondVar#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see xtext.cool.cool.CondVar#getName()
   * @see #getCondVar()
   * @generated
   */
  EAttribute getCondVar_Name();

  /**
   * Returns the meta object for the attribute '{@link xtext.cool.cool.CondVar#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see xtext.cool.cool.CondVar#getValue()
   * @see #getCondVar()
   * @generated
   */
  EAttribute getCondVar_Value();

  /**
   * Returns the meta object for class '{@link xtext.cool.cool.OrdVar <em>Ord Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ord Var</em>'.
   * @see xtext.cool.cool.OrdVar
   * @generated
   */
  EClass getOrdVar();

  /**
   * Returns the meta object for the attribute '{@link xtext.cool.cool.OrdVar#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see xtext.cool.cool.OrdVar#getName()
   * @see #getOrdVar()
   * @generated
   */
  EAttribute getOrdVar_Name();

  /**
   * Returns the meta object for the attribute '{@link xtext.cool.cool.OrdVar#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see xtext.cool.cool.OrdVar#getValue()
   * @see #getOrdVar()
   * @generated
   */
  EAttribute getOrdVar_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  CoolFactory getCoolFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link xtext.cool.cool.impl.CoordinatorDeclarationImpl <em>Coordinator Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.cool.cool.impl.CoordinatorDeclarationImpl
     * @see xtext.cool.cool.impl.CoolPackageImpl#getCoordinatorDeclaration()
     * @generated
     */
    EClass COORDINATOR_DECLARATION = eINSTANCE.getCoordinatorDeclaration();

    /**
     * The meta object literal for the '<em><b>Granularity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COORDINATOR_DECLARATION__GRANULARITY = eINSTANCE.getCoordinatorDeclaration_Granularity();

    /**
     * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COORDINATOR_DECLARATION__CLASS_NAME = eINSTANCE.getCoordinatorDeclaration_ClassName();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COORDINATOR_DECLARATION__BODY = eINSTANCE.getCoordinatorDeclaration_Body();

    /**
     * The meta object literal for the '{@link xtext.cool.cool.impl.CoordinatorBodyImpl <em>Coordinator Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.cool.cool.impl.CoordinatorBodyImpl
     * @see xtext.cool.cool.impl.CoolPackageImpl#getCoordinatorBody()
     * @generated
     */
    EClass COORDINATOR_BODY = eINSTANCE.getCoordinatorBody();

    /**
     * The meta object literal for the '<em><b>Cond Vars</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COORDINATOR_BODY__COND_VARS = eINSTANCE.getCoordinatorBody_CondVars();

    /**
     * The meta object literal for the '<em><b>Ord Vars</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COORDINATOR_BODY__ORD_VARS = eINSTANCE.getCoordinatorBody_OrdVars();

    /**
     * The meta object literal for the '<em><b>Selfex Methods</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COORDINATOR_BODY__SELFEX_METHODS = eINSTANCE.getCoordinatorBody_SelfexMethods();

    /**
     * The meta object literal for the '<em><b>Mutex Sets</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COORDINATOR_BODY__MUTEX_SETS = eINSTANCE.getCoordinatorBody_MutexSets();

    /**
     * The meta object literal for the '<em><b>Guards</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COORDINATOR_BODY__GUARDS = eINSTANCE.getCoordinatorBody_Guards();

    /**
     * The meta object literal for the '{@link xtext.cool.cool.impl.GuardImpl <em>Guard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.cool.cool.impl.GuardImpl
     * @see xtext.cool.cool.impl.CoolPackageImpl#getGuard()
     * @generated
     */
    EClass GUARD = eINSTANCE.getGuard();

    /**
     * The meta object literal for the '<em><b>Methods</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GUARD__METHODS = eINSTANCE.getGuard_Methods();

    /**
     * The meta object literal for the '<em><b>Requires</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GUARD__REQUIRES = eINSTANCE.getGuard_Requires();

    /**
     * The meta object literal for the '<em><b>On Entry If Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GUARD__ON_ENTRY_IF_STATEMENTS = eINSTANCE.getGuard_OnEntryIfStatements();

    /**
     * The meta object literal for the '<em><b>On Entry Assign Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GUARD__ON_ENTRY_ASSIGN_STATEMENTS = eINSTANCE.getGuard_OnEntryAssignStatements();

    /**
     * The meta object literal for the '<em><b>On Exit If Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GUARD__ON_EXIT_IF_STATEMENTS = eINSTANCE.getGuard_OnExitIfStatements();

    /**
     * The meta object literal for the '<em><b>On Exit Assign Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GUARD__ON_EXIT_ASSIGN_STATEMENTS = eINSTANCE.getGuard_OnExitAssignStatements();

    /**
     * The meta object literal for the '{@link xtext.cool.cool.impl.IfStatementImpl <em>If Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.cool.cool.impl.IfStatementImpl
     * @see xtext.cool.cool.impl.CoolPackageImpl#getIfStatement()
     * @generated
     */
    EClass IF_STATEMENT = eINSTANCE.getIfStatement();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__EXPRESSION = eINSTANCE.getIfStatement_Expression();

    /**
     * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__STATEMENT = eINSTANCE.getIfStatement_Statement();

    /**
     * The meta object literal for the '{@link xtext.cool.cool.impl.IfExpressionImpl <em>If Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.cool.cool.impl.IfExpressionImpl
     * @see xtext.cool.cool.impl.CoolPackageImpl#getIfExpression()
     * @generated
     */
    EClass IF_EXPRESSION = eINSTANCE.getIfExpression();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IF_EXPRESSION__VAR = eINSTANCE.getIfExpression_Var();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IF_EXPRESSION__OP = eINSTANCE.getIfExpression_Op();

    /**
     * The meta object literal for the '<em><b>Assignment</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_EXPRESSION__ASSIGNMENT = eINSTANCE.getIfExpression_Assignment();

    /**
     * The meta object literal for the '{@link xtext.cool.cool.impl.AssignedValueImpl <em>Assigned Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.cool.cool.impl.AssignedValueImpl
     * @see xtext.cool.cool.impl.CoolPackageImpl#getAssignedValue()
     * @generated
     */
    EClass ASSIGNED_VALUE = eINSTANCE.getAssignedValue();

    /**
     * The meta object literal for the '<em><b>Intval</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNED_VALUE__INTVAL = eINSTANCE.getAssignedValue_Intval();

    /**
     * The meta object literal for the '<em><b>Boolval</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNED_VALUE__BOOLVAL = eINSTANCE.getAssignedValue_Boolval();

    /**
     * The meta object literal for the '{@link xtext.cool.cool.impl.AssignStatementImpl <em>Assign Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.cool.cool.impl.AssignStatementImpl
     * @see xtext.cool.cool.impl.CoolPackageImpl#getAssignStatement()
     * @generated
     */
    EClass ASSIGN_STATEMENT = eINSTANCE.getAssignStatement();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGN_STATEMENT__VAR = eINSTANCE.getAssignStatement_Var();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGN_STATEMENT__VALUE = eINSTANCE.getAssignStatement_Value();

    /**
     * The meta object literal for the '{@link xtext.cool.cool.impl.RequiresImpl <em>Requires</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.cool.cool.impl.RequiresImpl
     * @see xtext.cool.cool.impl.CoolPackageImpl#getRequires()
     * @generated
     */
    EClass REQUIRES = eINSTANCE.getRequires();

    /**
     * The meta object literal for the '<em><b>And Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIRES__AND_EXPRESSION = eINSTANCE.getRequires_AndExpression();

    /**
     * The meta object literal for the '{@link xtext.cool.cool.impl.AndExpressionImpl <em>And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.cool.cool.impl.AndExpressionImpl
     * @see xtext.cool.cool.impl.CoolPackageImpl#getAndExpression()
     * @generated
     */
    EClass AND_EXPRESSION = eINSTANCE.getAndExpression();

    /**
     * The meta object literal for the '<em><b>Or Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPRESSION__OR_EXPRESSIONS = eINSTANCE.getAndExpression_OrExpressions();

    /**
     * The meta object literal for the '{@link xtext.cool.cool.impl.OrExpressionImpl <em>Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.cool.cool.impl.OrExpressionImpl
     * @see xtext.cool.cool.impl.CoolPackageImpl#getOrExpression()
     * @generated
     */
    EClass OR_EXPRESSION = eINSTANCE.getOrExpression();

    /**
     * The meta object literal for the '<em><b>Basic Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPRESSION__BASIC_EXPRESSIONS = eINSTANCE.getOrExpression_BasicExpressions();

    /**
     * The meta object literal for the '{@link xtext.cool.cool.impl.BasicExpressionImpl <em>Basic Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.cool.cool.impl.BasicExpressionImpl
     * @see xtext.cool.cool.impl.CoolPackageImpl#getBasicExpression()
     * @generated
     */
    EClass BASIC_EXPRESSION = eINSTANCE.getBasicExpression();

    /**
     * The meta object literal for the '<em><b>Negated</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASIC_EXPRESSION__NEGATED = eINSTANCE.getBasicExpression_Negated();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASIC_EXPRESSION__EXPR = eINSTANCE.getBasicExpression_Expr();

    /**
     * The meta object literal for the '{@link xtext.cool.cool.impl.MutexSetImpl <em>Mutex Set</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.cool.cool.impl.MutexSetImpl
     * @see xtext.cool.cool.impl.CoolPackageImpl#getMutexSet()
     * @generated
     */
    EClass MUTEX_SET = eINSTANCE.getMutexSet();

    /**
     * The meta object literal for the '<em><b>Methods</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MUTEX_SET__METHODS = eINSTANCE.getMutexSet_Methods();

    /**
     * The meta object literal for the '{@link xtext.cool.cool.impl.CondVarImpl <em>Cond Var</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.cool.cool.impl.CondVarImpl
     * @see xtext.cool.cool.impl.CoolPackageImpl#getCondVar()
     * @generated
     */
    EClass COND_VAR = eINSTANCE.getCondVar();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COND_VAR__NAME = eINSTANCE.getCondVar_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COND_VAR__VALUE = eINSTANCE.getCondVar_Value();

    /**
     * The meta object literal for the '{@link xtext.cool.cool.impl.OrdVarImpl <em>Ord Var</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.cool.cool.impl.OrdVarImpl
     * @see xtext.cool.cool.impl.CoolPackageImpl#getOrdVar()
     * @generated
     */
    EClass ORD_VAR = eINSTANCE.getOrdVar();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ORD_VAR__NAME = eINSTANCE.getOrdVar_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ORD_VAR__VALUE = eINSTANCE.getOrdVar_Value();

  }

} //CoolPackage
