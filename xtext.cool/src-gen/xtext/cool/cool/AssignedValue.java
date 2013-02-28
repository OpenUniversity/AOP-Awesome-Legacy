/**
 * <copyright>
 * </copyright>
 *
 */
package xtext.cool.cool;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assigned Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xtext.cool.cool.AssignedValue#getIntval <em>Intval</em>}</li>
 *   <li>{@link xtext.cool.cool.AssignedValue#getBoolval <em>Boolval</em>}</li>
 * </ul>
 * </p>
 *
 * @see xtext.cool.cool.CoolPackage#getAssignedValue()
 * @model
 * @generated
 */
public interface AssignedValue extends EObject
{
  /**
   * Returns the value of the '<em><b>Intval</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Intval</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Intval</em>' attribute.
   * @see #setIntval(int)
   * @see xtext.cool.cool.CoolPackage#getAssignedValue_Intval()
   * @model
   * @generated
   */
  int getIntval();

  /**
   * Sets the value of the '{@link xtext.cool.cool.AssignedValue#getIntval <em>Intval</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Intval</em>' attribute.
   * @see #getIntval()
   * @generated
   */
  void setIntval(int value);

  /**
   * Returns the value of the '<em><b>Boolval</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Boolval</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Boolval</em>' attribute.
   * @see #setBoolval(String)
   * @see xtext.cool.cool.CoolPackage#getAssignedValue_Boolval()
   * @model
   * @generated
   */
  String getBoolval();

  /**
   * Sets the value of the '{@link xtext.cool.cool.AssignedValue#getBoolval <em>Boolval</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Boolval</em>' attribute.
   * @see #getBoolval()
   * @generated
   */
  void setBoolval(String value);

} // AssignedValue
