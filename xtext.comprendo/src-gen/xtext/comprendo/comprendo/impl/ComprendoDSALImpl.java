/**
 * <copyright>
 * </copyright>
 *

 */
package xtext.comprendo.comprendo.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import xtext.comprendo.comprendo.Comprendo;
import xtext.comprendo.comprendo.ComprendoDSAL;
import xtext.comprendo.comprendo.ComprendoPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DSAL</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link xtext.comprendo.comprendo.impl.ComprendoDSALImpl#getComprendo <em>Comprendo</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComprendoDSALImpl extends MinimalEObjectImpl.Container implements ComprendoDSAL
{
  /**
   * The cached value of the '{@link #getComprendo() <em>Comprendo</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComprendo()
   * @generated
   * @ordered
   */
  protected Comprendo comprendo;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComprendoDSALImpl()
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
    return ComprendoPackage.Literals.COMPRENDO_DSAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Comprendo getComprendo()
  {
    return comprendo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetComprendo(Comprendo newComprendo, NotificationChain msgs)
  {
    Comprendo oldComprendo = comprendo;
    comprendo = newComprendo;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComprendoPackage.COMPRENDO_DSAL__COMPRENDO, oldComprendo, newComprendo);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComprendo(Comprendo newComprendo)
  {
    if (newComprendo != comprendo)
    {
      NotificationChain msgs = null;
      if (comprendo != null)
        msgs = ((InternalEObject)comprendo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComprendoPackage.COMPRENDO_DSAL__COMPRENDO, null, msgs);
      if (newComprendo != null)
        msgs = ((InternalEObject)newComprendo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComprendoPackage.COMPRENDO_DSAL__COMPRENDO, null, msgs);
      msgs = basicSetComprendo(newComprendo, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ComprendoPackage.COMPRENDO_DSAL__COMPRENDO, newComprendo, newComprendo));
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
      case ComprendoPackage.COMPRENDO_DSAL__COMPRENDO:
        return basicSetComprendo(null, msgs);
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
      case ComprendoPackage.COMPRENDO_DSAL__COMPRENDO:
        return getComprendo();
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
      case ComprendoPackage.COMPRENDO_DSAL__COMPRENDO:
        setComprendo((Comprendo)newValue);
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
      case ComprendoPackage.COMPRENDO_DSAL__COMPRENDO:
        setComprendo((Comprendo)null);
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
      case ComprendoPackage.COMPRENDO_DSAL__COMPRENDO:
        return comprendo != null;
    }
    return super.eIsSet(featureID);
  }

} //ComprendoDSALImpl
