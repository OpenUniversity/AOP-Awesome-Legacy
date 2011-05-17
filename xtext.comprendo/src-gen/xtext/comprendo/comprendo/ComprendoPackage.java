/**
 * <copyright>
 * </copyright>
 *

 */
package xtext.comprendo.comprendo;

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
 * @see xtext.comprendo.comprendo.ComprendoFactory
 * @model kind="package"
 * @generated
 */
public interface ComprendoPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "comprendo";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.comprendo.xtext/Comprendo";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "comprendo";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ComprendoPackage eINSTANCE = xtext.comprendo.comprendo.impl.ComprendoPackageImpl.init();

  /**
   * The meta object id for the '{@link xtext.comprendo.comprendo.impl.ComprendoDSALImpl <em>DSAL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.comprendo.comprendo.impl.ComprendoDSALImpl
   * @see xtext.comprendo.comprendo.impl.ComprendoPackageImpl#getComprendoDSAL()
   * @generated
   */
  int COMPRENDO_DSAL = 0;

  /**
   * The feature id for the '<em><b>Comprendo</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPRENDO_DSAL__COMPRENDO = 0;

  /**
   * The number of structural features of the '<em>DSAL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPRENDO_DSAL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link xtext.comprendo.comprendo.impl.ComprendoImpl <em>Comprendo</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.comprendo.comprendo.impl.ComprendoImpl
   * @see xtext.comprendo.comprendo.impl.ComprendoPackageImpl#getComprendo()
   * @generated
   */
  int COMPRENDO = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPRENDO__NAME = 0;

  /**
   * The feature id for the '<em><b>Scope</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPRENDO__SCOPE = 1;

  /**
   * The feature id for the '<em><b>Outdir</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPRENDO__OUTDIR = 2;

  /**
   * The feature id for the '<em><b>Commands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPRENDO__COMMANDS = 3;

  /**
   * The number of structural features of the '<em>Comprendo</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPRENDO_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link xtext.comprendo.comprendo.impl.ScopeImpl <em>Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.comprendo.comprendo.impl.ScopeImpl
   * @see xtext.comprendo.comprendo.impl.ComprendoPackageImpl#getScope()
   * @generated
   */
  int SCOPE = 2;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPE__VALUE = 0;

  /**
   * The number of structural features of the '<em>Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link xtext.comprendo.comprendo.impl.CommandImpl <em>Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.comprendo.comprendo.impl.CommandImpl
   * @see xtext.comprendo.comprendo.impl.ComprendoPackageImpl#getCommand()
   * @generated
   */
  int COMMAND = 3;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND__ID = 0;

  /**
   * The feature id for the '<em><b>Summary</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND__SUMMARY = 1;

  /**
   * The number of structural features of the '<em>Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link xtext.comprendo.comprendo.impl.OutdirImpl <em>Outdir</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see xtext.comprendo.comprendo.impl.OutdirImpl
   * @see xtext.comprendo.comprendo.impl.ComprendoPackageImpl#getOutdir()
   * @generated
   */
  int OUTDIR = 4;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTDIR__VALUE = 0;

  /**
   * The number of structural features of the '<em>Outdir</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTDIR_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link xtext.comprendo.comprendo.ComprendoDSAL <em>DSAL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DSAL</em>'.
   * @see xtext.comprendo.comprendo.ComprendoDSAL
   * @generated
   */
  EClass getComprendoDSAL();

  /**
   * Returns the meta object for the containment reference '{@link xtext.comprendo.comprendo.ComprendoDSAL#getComprendo <em>Comprendo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Comprendo</em>'.
   * @see xtext.comprendo.comprendo.ComprendoDSAL#getComprendo()
   * @see #getComprendoDSAL()
   * @generated
   */
  EReference getComprendoDSAL_Comprendo();

  /**
   * Returns the meta object for class '{@link xtext.comprendo.comprendo.Comprendo <em>Comprendo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Comprendo</em>'.
   * @see xtext.comprendo.comprendo.Comprendo
   * @generated
   */
  EClass getComprendo();

  /**
   * Returns the meta object for the attribute '{@link xtext.comprendo.comprendo.Comprendo#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see xtext.comprendo.comprendo.Comprendo#getName()
   * @see #getComprendo()
   * @generated
   */
  EAttribute getComprendo_Name();

  /**
   * Returns the meta object for the containment reference '{@link xtext.comprendo.comprendo.Comprendo#getScope <em>Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Scope</em>'.
   * @see xtext.comprendo.comprendo.Comprendo#getScope()
   * @see #getComprendo()
   * @generated
   */
  EReference getComprendo_Scope();

  /**
   * Returns the meta object for the containment reference '{@link xtext.comprendo.comprendo.Comprendo#getOutdir <em>Outdir</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Outdir</em>'.
   * @see xtext.comprendo.comprendo.Comprendo#getOutdir()
   * @see #getComprendo()
   * @generated
   */
  EReference getComprendo_Outdir();

  /**
   * Returns the meta object for the containment reference list '{@link xtext.comprendo.comprendo.Comprendo#getCommands <em>Commands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Commands</em>'.
   * @see xtext.comprendo.comprendo.Comprendo#getCommands()
   * @see #getComprendo()
   * @generated
   */
  EReference getComprendo_Commands();

  /**
   * Returns the meta object for class '{@link xtext.comprendo.comprendo.Scope <em>Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scope</em>'.
   * @see xtext.comprendo.comprendo.Scope
   * @generated
   */
  EClass getScope();

  /**
   * Returns the meta object for the attribute '{@link xtext.comprendo.comprendo.Scope#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see xtext.comprendo.comprendo.Scope#getValue()
   * @see #getScope()
   * @generated
   */
  EAttribute getScope_Value();

  /**
   * Returns the meta object for class '{@link xtext.comprendo.comprendo.Command <em>Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Command</em>'.
   * @see xtext.comprendo.comprendo.Command
   * @generated
   */
  EClass getCommand();

  /**
   * Returns the meta object for the attribute '{@link xtext.comprendo.comprendo.Command#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see xtext.comprendo.comprendo.Command#getId()
   * @see #getCommand()
   * @generated
   */
  EAttribute getCommand_Id();

  /**
   * Returns the meta object for the attribute '{@link xtext.comprendo.comprendo.Command#isSummary <em>Summary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Summary</em>'.
   * @see xtext.comprendo.comprendo.Command#isSummary()
   * @see #getCommand()
   * @generated
   */
  EAttribute getCommand_Summary();

  /**
   * Returns the meta object for class '{@link xtext.comprendo.comprendo.Outdir <em>Outdir</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Outdir</em>'.
   * @see xtext.comprendo.comprendo.Outdir
   * @generated
   */
  EClass getOutdir();

  /**
   * Returns the meta object for the attribute '{@link xtext.comprendo.comprendo.Outdir#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see xtext.comprendo.comprendo.Outdir#getValue()
   * @see #getOutdir()
   * @generated
   */
  EAttribute getOutdir_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ComprendoFactory getComprendoFactory();

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
     * The meta object literal for the '{@link xtext.comprendo.comprendo.impl.ComprendoDSALImpl <em>DSAL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.comprendo.comprendo.impl.ComprendoDSALImpl
     * @see xtext.comprendo.comprendo.impl.ComprendoPackageImpl#getComprendoDSAL()
     * @generated
     */
    EClass COMPRENDO_DSAL = eINSTANCE.getComprendoDSAL();

    /**
     * The meta object literal for the '<em><b>Comprendo</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPRENDO_DSAL__COMPRENDO = eINSTANCE.getComprendoDSAL_Comprendo();

    /**
     * The meta object literal for the '{@link xtext.comprendo.comprendo.impl.ComprendoImpl <em>Comprendo</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.comprendo.comprendo.impl.ComprendoImpl
     * @see xtext.comprendo.comprendo.impl.ComprendoPackageImpl#getComprendo()
     * @generated
     */
    EClass COMPRENDO = eINSTANCE.getComprendo();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPRENDO__NAME = eINSTANCE.getComprendo_Name();

    /**
     * The meta object literal for the '<em><b>Scope</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPRENDO__SCOPE = eINSTANCE.getComprendo_Scope();

    /**
     * The meta object literal for the '<em><b>Outdir</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPRENDO__OUTDIR = eINSTANCE.getComprendo_Outdir();

    /**
     * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPRENDO__COMMANDS = eINSTANCE.getComprendo_Commands();

    /**
     * The meta object literal for the '{@link xtext.comprendo.comprendo.impl.ScopeImpl <em>Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.comprendo.comprendo.impl.ScopeImpl
     * @see xtext.comprendo.comprendo.impl.ComprendoPackageImpl#getScope()
     * @generated
     */
    EClass SCOPE = eINSTANCE.getScope();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCOPE__VALUE = eINSTANCE.getScope_Value();

    /**
     * The meta object literal for the '{@link xtext.comprendo.comprendo.impl.CommandImpl <em>Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.comprendo.comprendo.impl.CommandImpl
     * @see xtext.comprendo.comprendo.impl.ComprendoPackageImpl#getCommand()
     * @generated
     */
    EClass COMMAND = eINSTANCE.getCommand();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMAND__ID = eINSTANCE.getCommand_Id();

    /**
     * The meta object literal for the '<em><b>Summary</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMAND__SUMMARY = eINSTANCE.getCommand_Summary();

    /**
     * The meta object literal for the '{@link xtext.comprendo.comprendo.impl.OutdirImpl <em>Outdir</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see xtext.comprendo.comprendo.impl.OutdirImpl
     * @see xtext.comprendo.comprendo.impl.ComprendoPackageImpl#getOutdir()
     * @generated
     */
    EClass OUTDIR = eINSTANCE.getOutdir();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OUTDIR__VALUE = eINSTANCE.getOutdir_Value();

  }

} //ComprendoPackage
