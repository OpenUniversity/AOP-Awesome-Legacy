/**
 * <copyright>
 * </copyright>
 *
 */
package xtext.cool.cool;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xtext.cool.cool.BasicExpression#isNegated <em>Negated</em>}</li>
 *   <li>{@link xtext.cool.cool.BasicExpression#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see xtext.cool.cool.CoolPackage#getBasicExpression()
 * @model
 * @generated
 */
public interface BasicExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Negated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Negated</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Negated</em>' attribute.
   * @see #setNegated(boolean)
   * @see xtext.cool.cool.CoolPackage#getBasicExpression_Negated()
   * @model
   * @generated
   */
  boolean isNegated();

  /**
   * Sets the value of the '{@link xtext.cool.cool.BasicExpression#isNegated <em>Negated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Negated</em>' attribute.
   * @see #isNegated()
   * @generated
   */
  void setNegated(boolean value);

  /**
   * Returns the value of the '<em><b>Expr</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' reference.
   * @see #setExpr(CondVar)
   * @see xtext.cool.cool.CoolPackage#getBasicExpression_Expr()
   * @model
   * @generated
   */
  CondVar getExpr();

  /**
   * Sets the value of the '{@link xtext.cool.cool.BasicExpression#getExpr <em>Expr</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(CondVar value);

} // BasicExpression
