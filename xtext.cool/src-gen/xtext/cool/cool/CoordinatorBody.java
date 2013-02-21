/**
 * <copyright>
 * </copyright>
 *
 */
package xtext.cool.cool;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Coordinator Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xtext.cool.cool.CoordinatorBody#getCondVars <em>Cond Vars</em>}</li>
 *   <li>{@link xtext.cool.cool.CoordinatorBody#getOrdVars <em>Ord Vars</em>}</li>
 *   <li>{@link xtext.cool.cool.CoordinatorBody#getSelfexMethods <em>Selfex Methods</em>}</li>
 * </ul>
 * </p>
 *
 * @see xtext.cool.cool.CoolPackage#getCoordinatorBody()
 * @model
 * @generated
 */
public interface CoordinatorBody extends EObject
{
  /**
   * Returns the value of the '<em><b>Cond Vars</b></em>' containment reference list.
   * The list contents are of type {@link xtext.cool.cool.CondVar}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cond Vars</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cond Vars</em>' containment reference list.
   * @see xtext.cool.cool.CoolPackage#getCoordinatorBody_CondVars()
   * @model containment="true"
   * @generated
   */
  EList<CondVar> getCondVars();

  /**
   * Returns the value of the '<em><b>Ord Vars</b></em>' containment reference list.
   * The list contents are of type {@link xtext.cool.cool.OrdVar}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ord Vars</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ord Vars</em>' containment reference list.
   * @see xtext.cool.cool.CoolPackage#getCoordinatorBody_OrdVars()
   * @model containment="true"
   * @generated
   */
  EList<OrdVar> getOrdVars();

  /**
   * Returns the value of the '<em><b>Selfex Methods</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Selfex Methods</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Selfex Methods</em>' attribute list.
   * @see xtext.cool.cool.CoolPackage#getCoordinatorBody_SelfexMethods()
   * @model unique="false"
   * @generated
   */
  EList<String> getSelfexMethods();

} // CoordinatorBody
