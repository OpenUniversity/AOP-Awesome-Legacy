/**
 * <copyright>
 * </copyright>
 *

 */
package xtext.comprendo.comprendo.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import xtext.comprendo.comprendo.Command;
import xtext.comprendo.comprendo.Comprendo;
import xtext.comprendo.comprendo.ComprendoDSAL;
import xtext.comprendo.comprendo.ComprendoFactory;
import xtext.comprendo.comprendo.ComprendoPackage;
import xtext.comprendo.comprendo.Outdir;
import xtext.comprendo.comprendo.Scope;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComprendoPackageImpl extends EPackageImpl implements ComprendoPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass comprendoDSALEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass comprendoEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scopeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass commandEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass outdirEClass = null;

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
   * @see xtext.comprendo.comprendo.ComprendoPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ComprendoPackageImpl()
  {
    super(eNS_URI, ComprendoFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ComprendoPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ComprendoPackage init()
  {
    if (isInited) return (ComprendoPackage)EPackage.Registry.INSTANCE.getEPackage(ComprendoPackage.eNS_URI);

    // Obtain or create and register package
    ComprendoPackageImpl theComprendoPackage = (ComprendoPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ComprendoPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ComprendoPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theComprendoPackage.createPackageContents();

    // Initialize created meta-data
    theComprendoPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theComprendoPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ComprendoPackage.eNS_URI, theComprendoPackage);
    return theComprendoPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComprendoDSAL()
  {
    return comprendoDSALEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComprendoDSAL_Comprendo()
  {
    return (EReference)comprendoDSALEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComprendo()
  {
    return comprendoEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComprendo_Name()
  {
    return (EAttribute)comprendoEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComprendo_Scope()
  {
    return (EReference)comprendoEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComprendo_Outdir()
  {
    return (EReference)comprendoEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComprendo_Commands()
  {
    return (EReference)comprendoEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScope()
  {
    return scopeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScope_Value()
  {
    return (EAttribute)scopeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCommand()
  {
    return commandEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCommand_Id()
  {
    return (EAttribute)commandEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCommand_Summary()
  {
    return (EAttribute)commandEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOutdir()
  {
    return outdirEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOutdir_Value()
  {
    return (EAttribute)outdirEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComprendoFactory getComprendoFactory()
  {
    return (ComprendoFactory)getEFactoryInstance();
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
    comprendoDSALEClass = createEClass(COMPRENDO_DSAL);
    createEReference(comprendoDSALEClass, COMPRENDO_DSAL__COMPRENDO);

    comprendoEClass = createEClass(COMPRENDO);
    createEAttribute(comprendoEClass, COMPRENDO__NAME);
    createEReference(comprendoEClass, COMPRENDO__SCOPE);
    createEReference(comprendoEClass, COMPRENDO__OUTDIR);
    createEReference(comprendoEClass, COMPRENDO__COMMANDS);

    scopeEClass = createEClass(SCOPE);
    createEAttribute(scopeEClass, SCOPE__VALUE);

    commandEClass = createEClass(COMMAND);
    createEAttribute(commandEClass, COMMAND__ID);
    createEAttribute(commandEClass, COMMAND__SUMMARY);

    outdirEClass = createEClass(OUTDIR);
    createEAttribute(outdirEClass, OUTDIR__VALUE);
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
    initEClass(comprendoDSALEClass, ComprendoDSAL.class, "ComprendoDSAL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getComprendoDSAL_Comprendo(), this.getComprendo(), null, "comprendo", null, 0, 1, ComprendoDSAL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(comprendoEClass, Comprendo.class, "Comprendo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getComprendo_Name(), ecorePackage.getEString(), "name", null, 0, 1, Comprendo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComprendo_Scope(), this.getScope(), null, "scope", null, 0, 1, Comprendo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComprendo_Outdir(), this.getOutdir(), null, "outdir", null, 0, 1, Comprendo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComprendo_Commands(), this.getCommand(), null, "commands", null, 0, -1, Comprendo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scopeEClass, Scope.class, "Scope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScope_Value(), ecorePackage.getEString(), "value", null, 0, 1, Scope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(commandEClass, Command.class, "Command", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCommand_Id(), ecorePackage.getEString(), "id", null, 0, 1, Command.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCommand_Summary(), ecorePackage.getEBoolean(), "summary", null, 0, 1, Command.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(outdirEClass, Outdir.class, "Outdir", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOutdir_Value(), ecorePackage.getEString(), "value", null, 0, 1, Outdir.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ComprendoPackageImpl
