/**
 * <copyright>
 * </copyright>
 *
 */
package xtext.cool.cool.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import xtext.cool.cool.BasicExpression;
import xtext.cool.cool.CoolPackage;
import xtext.cool.cool.OrExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Or Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link xtext.cool.cool.impl.OrExpressionImpl#getBasicExpressions <em>Basic Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrExpressionImpl extends MinimalEObjectImpl.Container implements OrExpression
{
  /**
   * The cached value of the '{@link #getBasicExpressions() <em>Basic Expressions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBasicExpressions()
   * @generated
   * @ordered
   */
  protected EList<BasicExpression> basicExpressions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OrExpressionImpl()
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
    return CoolPackage.Literals.OR_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<BasicExpression> getBasicExpressions()
  {
    if (basicExpressions == null)
    {
      basicExpressions = new EObjectContainmentEList<BasicExpression>(BasicExpression.class, this, CoolPackage.OR_EXPRESSION__BASIC_EXPRESSIONS);
    }
    return basicExpressions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case CoolPackage.OR_EXPRESSION__BASIC_EXPRESSIONS:
        return ((InternalEList<?>)getBasicExpressions()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case CoolPackage.OR_EXPRESSION__BASIC_EXPRESSIONS:
        return getBasicExpressions();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CoolPackage.OR_EXPRESSION__BASIC_EXPRESSIONS:
        getBasicExpressions().clear();
        getBasicExpressions().addAll((Collection<? extends BasicExpression>)newValue);
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
      case CoolPackage.OR_EXPRESSION__BASIC_EXPRESSIONS:
        getBasicExpressions().clear();
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
      case CoolPackage.OR_EXPRESSION__BASIC_EXPRESSIONS:
        return basicExpressions != null && !basicExpressions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //OrExpressionImpl
