/**
 * <copyright>
 * </copyright>
 *
 */
package xtext.cool.cool.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import xtext.cool.cool.AndExpression;
import xtext.cool.cool.CoolPackage;
import xtext.cool.cool.Requires;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requires</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link xtext.cool.cool.impl.RequiresImpl#getAndExpression <em>And Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequiresImpl extends MinimalEObjectImpl.Container implements Requires
{
  /**
   * The cached value of the '{@link #getAndExpression() <em>And Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAndExpression()
   * @generated
   * @ordered
   */
  protected AndExpression andExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RequiresImpl()
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
    return CoolPackage.Literals.REQUIRES;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndExpression getAndExpression()
  {
    return andExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAndExpression(AndExpression newAndExpression, NotificationChain msgs)
  {
    AndExpression oldAndExpression = andExpression;
    andExpression = newAndExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CoolPackage.REQUIRES__AND_EXPRESSION, oldAndExpression, newAndExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAndExpression(AndExpression newAndExpression)
  {
    if (newAndExpression != andExpression)
    {
      NotificationChain msgs = null;
      if (andExpression != null)
        msgs = ((InternalEObject)andExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CoolPackage.REQUIRES__AND_EXPRESSION, null, msgs);
      if (newAndExpression != null)
        msgs = ((InternalEObject)newAndExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CoolPackage.REQUIRES__AND_EXPRESSION, null, msgs);
      msgs = basicSetAndExpression(newAndExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoolPackage.REQUIRES__AND_EXPRESSION, newAndExpression, newAndExpression));
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
      case CoolPackage.REQUIRES__AND_EXPRESSION:
        return basicSetAndExpression(null, msgs);
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
      case CoolPackage.REQUIRES__AND_EXPRESSION:
        return getAndExpression();
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
      case CoolPackage.REQUIRES__AND_EXPRESSION:
        setAndExpression((AndExpression)newValue);
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
      case CoolPackage.REQUIRES__AND_EXPRESSION:
        setAndExpression((AndExpression)null);
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
      case CoolPackage.REQUIRES__AND_EXPRESSION:
        return andExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //RequiresImpl
