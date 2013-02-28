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
 * A representation of the model object '<em><b>Or Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xtext.cool.cool.OrExpression#getBasicExpressions <em>Basic Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see xtext.cool.cool.CoolPackage#getOrExpression()
 * @model
 * @generated
 */
public interface OrExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Basic Expressions</b></em>' containment reference list.
   * The list contents are of type {@link xtext.cool.cool.BasicExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Basic Expressions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Basic Expressions</em>' containment reference list.
   * @see xtext.cool.cool.CoolPackage#getOrExpression_BasicExpressions()
   * @model containment="true"
   * @generated
   */
  EList<BasicExpression> getBasicExpressions();

} // OrExpression
