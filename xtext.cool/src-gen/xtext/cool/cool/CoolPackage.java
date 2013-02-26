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
   * The number of structural features of the '<em>Coordinator Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COORDINATOR_BODY_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link xtext.cool.cool.impl.MutexSetImpl <em>Mutex Set</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.cool.cool.impl.MutexSetImpl
   * @see xtext.cool.cool.impl.CoolPackageImpl#getMutexSet()
   * @generated
   */
  int MUTEX_SET = 2;

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
  int COND_VAR = 3;

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
  int ORD_VAR = 4;

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
