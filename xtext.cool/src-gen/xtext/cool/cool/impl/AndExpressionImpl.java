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

import xtext.cool.cool.AndExpression;
import xtext.cool.cool.CoolPackage;
import xtext.cool.cool.OrExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>And Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link xtext.cool.cool.impl.AndExpressionImpl#getOrExpressions <em>Or Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AndExpressionImpl extends MinimalEObjectImpl.Container implements AndExpression
{
  /**
   * The cached value of the '{@link #getOrExpressions() <em>Or Expressions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrExpressions()
   * @generated
   * @ordered
   */
  protected EList<OrExpression> orExpressions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AndExpressionImpl()
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
    return CoolPackage.Literals.AND_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<OrExpression> getOrExpressions()
  {
    if (orExpressions == null)
    {
      orExpressions = new EObjectContainmentEList<OrExpression>(OrExpression.class, this, CoolPackage.AND_EXPRESSION__OR_EXPRESSIONS);
    }
    return orExpressions;
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
      case CoolPackage.AND_EXPRESSION__OR_EXPRESSIONS:
        return ((InternalEList<?>)getOrExpressions()).basicRemove(otherEnd, msgs);
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
      case CoolPackage.AND_EXPRESSION__OR_EXPRESSIONS:
        return getOrExpressions();
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
      case CoolPackage.AND_EXPRESSION__OR_EXPRESSIONS:
        getOrExpressions().clear();
        getOrExpressions().addAll((Collection<? extends OrExpression>)newValue);
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
      case CoolPackage.AND_EXPRESSION__OR_EXPRESSIONS:
        getOrExpressions().clear();
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
      case CoolPackage.AND_EXPRESSION__OR_EXPRESSIONS:
        return orExpressions != null && !orExpressions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AndExpressionImpl
