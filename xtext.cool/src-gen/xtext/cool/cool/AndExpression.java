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
 * A representation of the model object '<em><b>And Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xtext.cool.cool.AndExpression#getOrExpressions <em>Or Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see xtext.cool.cool.CoolPackage#getAndExpression()
 * @model
 * @generated
 */
public interface AndExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Or Expressions</b></em>' containment reference list.
   * The list contents are of type {@link xtext.cool.cool.OrExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Or Expressions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Or Expressions</em>' containment reference list.
   * @see xtext.cool.cool.CoolPackage#getAndExpression_OrExpressions()
   * @model containment="true"
   * @generated
   */
  EList<OrExpression> getOrExpressions();

} // AndExpression
