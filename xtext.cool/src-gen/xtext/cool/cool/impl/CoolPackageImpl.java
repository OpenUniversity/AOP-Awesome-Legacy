/**
 * <copyright>
 * </copyright>
 *
 */
package xtext.cool.cool.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import xtext.cool.cool.CondVar;
import xtext.cool.cool.CoolFactory;
import xtext.cool.cool.CoolPackage;
import xtext.cool.cool.CoordinatorBody;
import xtext.cool.cool.CoordinatorDeclaration;
import xtext.cool.cool.MutexSet;
import xtext.cool.cool.OrdVar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CoolPackageImpl extends EPackageImpl implements CoolPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass coordinatorDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass coordinatorBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mutexSetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass condVarEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ordVarEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see xtext.cool.cool.CoolPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private CoolPackageImpl()
  {
    super(eNS_URI, CoolFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link CoolPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static CoolPackage init()
  {
    if (isInited) return (CoolPackage)EPackage.Registry.INSTANCE.getEPackage(CoolPackage.eNS_URI);

    // Obtain or create and register package
    CoolPackageImpl theCoolPackage = (CoolPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CoolPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CoolPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theCoolPackage.createPackageContents();

    // Initialize created meta-data
    theCoolPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theCoolPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(CoolPackage.eNS_URI, theCoolPackage);
    return theCoolPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCoordinatorDeclaration()
  {
    return coordinatorDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCoordinatorDeclaration_Granularity()
  {
    return (EAttribute)coordinatorDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCoordinatorDeclaration_ClassName()
  {
    return (EAttribute)coordinatorDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCoordinatorDeclaration_Body()
  {
    return (EReference)coordinatorDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCoordinatorBody()
  {
    return coordinatorBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCoordinatorBody_CondVars()
  {
    return (EReference)coordinatorBodyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCoordinatorBody_OrdVars()
  {
    return (EReference)coordinatorBodyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCoordinatorBody_SelfexMethods()
  {
    return (EAttribute)coordinatorBodyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCoordinatorBody_MutexSets()
  {
    return (EReference)coordinatorBodyEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMutexSet()
  {
    return mutexSetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMutexSet_Methods()
  {
    return (EAttribute)mutexSetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCondVar()
  {
    return condVarEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCondVar_Name()
  {
    return (EAttribute)condVarEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCondVar_Value()
  {
    return (EAttribute)condVarEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrdVar()
  {
    return ordVarEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOrdVar_Name()
  {
    return (EAttribute)ordVarEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOrdVar_Value()
  {
    return (EAttribute)ordVarEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CoolFactory getCoolFactory()
  {
    return (CoolFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    coordinatorDeclarationEClass = createEClass(COORDINATOR_DECLARATION);
    createEAttribute(coordinatorDeclarationEClass, COORDINATOR_DECLARATION__GRANULARITY);
    createEAttribute(coordinatorDeclarationEClass, COORDINATOR_DECLARATION__CLASS_NAME);
    createEReference(coordinatorDeclarationEClass, COORDINATOR_DECLARATION__BODY);

    coordinatorBodyEClass = createEClass(COORDINATOR_BODY);
    createEReference(coordinatorBodyEClass, COORDINATOR_BODY__COND_VARS);
    createEReference(coordinatorBodyEClass, COORDINATOR_BODY__ORD_VARS);
    createEAttribute(coordinatorBodyEClass, COORDINATOR_BODY__SELFEX_METHODS);
    createEReference(coordinatorBodyEClass, COORDINATOR_BODY__MUTEX_SETS);

    mutexSetEClass = createEClass(MUTEX_SET);
    createEAttribute(mutexSetEClass, MUTEX_SET__METHODS);

    condVarEClass = createEClass(COND_VAR);
    createEAttribute(condVarEClass, COND_VAR__NAME);
    createEAttribute(condVarEClass, COND_VAR__VALUE);

    ordVarEClass = createEClass(ORD_VAR);
    createEAttribute(ordVarEClass, ORD_VAR__NAME);
    createEAttribute(ordVarEClass, ORD_VAR__VALUE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(coordinatorDeclarationEClass, CoordinatorDeclaration.class, "CoordinatorDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCoordinatorDeclaration_Granularity(), ecorePackage.getEString(), "granularity", null, 0, 1, CoordinatorDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCoordinatorDeclaration_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, CoordinatorDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCoordinatorDeclaration_Body(), this.getCoordinatorBody(), null, "body", null, 0, 1, CoordinatorDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(coordinatorBodyEClass, CoordinatorBody.class, "CoordinatorBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCoordinatorBody_CondVars(), this.getCondVar(), null, "condVars", null, 0, -1, CoordinatorBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCoordinatorBody_OrdVars(), this.getOrdVar(), null, "ordVars", null, 0, -1, CoordinatorBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCoordinatorBody_SelfexMethods(), ecorePackage.getEString(), "selfexMethods", null, 0, -1, CoordinatorBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCoordinatorBody_MutexSets(), this.getMutexSet(), null, "mutexSets", null, 0, -1, CoordinatorBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mutexSetEClass, MutexSet.class, "MutexSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMutexSet_Methods(), ecorePackage.getEString(), "methods", null, 0, -1, MutexSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(condVarEClass, CondVar.class, "CondVar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCondVar_Name(), ecorePackage.getEString(), "name", null, 0, 1, CondVar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCondVar_Value(), ecorePackage.getEString(), "value", null, 0, 1, CondVar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ordVarEClass, OrdVar.class, "OrdVar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOrdVar_Name(), ecorePackage.getEString(), "name", null, 0, 1, OrdVar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOrdVar_Value(), ecorePackage.getEInt(), "value", null, 0, 1, OrdVar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //CoolPackageImpl
