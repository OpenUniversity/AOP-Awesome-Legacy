/**
 * <copyright>
 * </copyright>
 *

 */
package xtext.comprendo.comprendo;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see xtext.comprendo.comprendo.ComprendoPackage
 * @generated
 */
public interface ComprendoFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ComprendoFactory eINSTANCE = xtext.comprendo.comprendo.impl.ComprendoFactoryImpl.init();

  /**
   * Returns a new object of class '<em>DSAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>DSAL</em>'.
   * @generated
   */
  ComprendoDSAL createComprendoDSAL();

  /**
   * Returns a new object of class '<em>Comprendo</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Comprendo</em>'.
   * @generated
   */
  Comprendo createComprendo();

  /**
   * Returns a new object of class '<em>Scope</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scope</em>'.
   * @generated
   */
  Scope createScope();

  /**
   * Returns a new object of class '<em>Command</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Command</em>'.
   * @generated
   */
  Command createCommand();

  /**
   * Returns a new object of class '<em>Outdir</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Outdir</em>'.
   * @generated
   */
  Outdir createOutdir();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ComprendoPackage getComprendoPackage();

} //ComprendoFactory
