/**
 * <copyright>
 * </copyright>
 *
 */
package xtext.cool.cool;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see xtext.cool.cool.CoolPackage
 * @generated
 */
public interface CoolFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CoolFactory eINSTANCE = xtext.cool.cool.impl.CoolFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Coordinator Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Coordinator Declaration</em>'.
   * @generated
   */
  CoordinatorDeclaration createCoordinatorDeclaration();

  /**
   * Returns a new object of class '<em>Coordinator Body</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Coordinator Body</em>'.
   * @generated
   */
  CoordinatorBody createCoordinatorBody();

  /**
   * Returns a new object of class '<em>Mutex Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mutex Set</em>'.
   * @generated
   */
  MutexSet createMutexSet();

  /**
   * Returns a new object of class '<em>Cond Var</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cond Var</em>'.
   * @generated
   */
  CondVar createCondVar();

  /**
   * Returns a new object of class '<em>Ord Var</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ord Var</em>'.
   * @generated
   */
  OrdVar createOrdVar();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  CoolPackage getCoolPackage();

} //CoolFactory
