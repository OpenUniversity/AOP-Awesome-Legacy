/**
 * <copyright>
 * </copyright>
 *
 */
package xtext.cool.cool;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requires</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xtext.cool.cool.Requires#getAndExpression <em>And Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see xtext.cool.cool.CoolPackage#getRequires()
 * @model
 * @generated
 */
public interface Requires extends EObject
{
  /**
   * Returns the value of the '<em><b>And Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>And Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>And Expression</em>' containment reference.
   * @see #setAndExpression(AndExpression)
   * @see xtext.cool.cool.CoolPackage#getRequires_AndExpression()
   * @model containment="true"
   * @generated
   */
  AndExpression getAndExpression();

  /**
   * Sets the value of the '{@link xtext.cool.cool.Requires#getAndExpression <em>And Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>And Expression</em>' containment reference.
   * @see #getAndExpression()
   * @generated
   */
  void setAndExpression(AndExpression value);

} // Requires
