/**
 * <copyright>
 * </copyright>
 *
 */
package xtext.cool.cool.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import xtext.cool.cool.BasicExpression;
import xtext.cool.cool.CondVar;
import xtext.cool.cool.CoolPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link xtext.cool.cool.impl.BasicExpressionImpl#isNegated <em>Negated</em>}</li>
 *   <li>{@link xtext.cool.cool.impl.BasicExpressionImpl#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasicExpressionImpl extends MinimalEObjectImpl.Container implements BasicExpression
{
  /**
   * The default value of the '{@link #isNegated() <em>Negated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNegated()
   * @generated
   * @ordered
   */
  protected static final boolean NEGATED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNegated() <em>Negated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNegated()
   * @generated
   * @ordered
   */
  protected boolean negated = NEGATED_EDEFAULT;

  /**
   * The cached value of the '{@link #getExpr() <em>Expr</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpr()
   * @generated
   * @ordered
   */
  protected CondVar expr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BasicExpressionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return CoolPackage.Literals.BASIC_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isNegated()
  {
    return negated;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNegated(boolean newNegated)
  {
    boolean oldNegated = negated;
    negated = newNegated;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoolPackage.BASIC_EXPRESSION__NEGATED, oldNegated, negated));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CondVar getExpr()
  {
    if (expr != null && expr.eIsProxy())
    {
      InternalEObject oldExpr = (InternalEObject)expr;
      expr = (CondVar)eResolveProxy(oldExpr);
      if (expr != oldExpr)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoolPackage.BASIC_EXPRESSION__EXPR, oldExpr, expr));
      }
    }
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CondVar basicGetExpr()
  {
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpr(CondVar newExpr)
  {
    CondVar oldExpr = expr;
    expr = newExpr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoolPackage.BASIC_EXPRESSION__EXPR, oldExpr, expr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case CoolPackage.BASIC_EXPRESSION__NEGATED:
        return isNegated();
      case CoolPackage.BASIC_EXPRESSION__EXPR:
        if (resolve) return getExpr();
        return basicGetExpr();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CoolPackage.BASIC_EXPRESSION__NEGATED:
        setNegated((Boolean)newValue);
        return;
      case CoolPackage.BASIC_EXPRESSION__EXPR:
        setExpr((CondVar)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case CoolPackage.BASIC_EXPRESSION__NEGATED:
        setNegated(NEGATED_EDEFAULT);
        return;
      case CoolPackage.BASIC_EXPRESSION__EXPR:
        setExpr((CondVar)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case CoolPackage.BASIC_EXPRESSION__NEGATED:
        return negated != NEGATED_EDEFAULT;
      case CoolPackage.BASIC_EXPRESSION__EXPR:
        return expr != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (negated: ");
    result.append(negated);
    result.append(')');
    return result.toString();
  }

} //BasicExpressionImpl
