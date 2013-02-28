/**
 * <copyright>
 * </copyright>
 *
 */
package xtext.cool.cool.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import xtext.cool.cool.CoolPackage;
import xtext.cool.cool.Guard;
import xtext.cool.cool.Requires;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link xtext.cool.cool.impl.GuardImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link xtext.cool.cool.impl.GuardImpl#getRequires <em>Requires</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GuardImpl extends MinimalEObjectImpl.Container implements Guard
{
  /**
   * The cached value of the '{@link #getMethods() <em>Methods</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethods()
   * @generated
   * @ordered
   */
  protected EList<String> methods;

  /**
   * The cached value of the '{@link #getRequires() <em>Requires</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequires()
   * @generated
   * @ordered
   */
  protected Requires requires;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GuardImpl()
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
    return CoolPackage.Literals.GUARD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getMethods()
  {
    if (methods == null)
    {
      methods = new EDataTypeEList<String>(String.class, this, CoolPackage.GUARD__METHODS);
    }
    return methods;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Requires getRequires()
  {
    return requires;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRequires(Requires newRequires, NotificationChain msgs)
  {
    Requires oldRequires = requires;
    requires = newRequires;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CoolPackage.GUARD__REQUIRES, oldRequires, newRequires);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRequires(Requires newRequires)
  {
    if (newRequires != requires)
    {
      NotificationChain msgs = null;
      if (requires != null)
        msgs = ((InternalEObject)requires).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CoolPackage.GUARD__REQUIRES, null, msgs);
      if (newRequires != null)
        msgs = ((InternalEObject)newRequires).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CoolPackage.GUARD__REQUIRES, null, msgs);
      msgs = basicSetRequires(newRequires, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoolPackage.GUARD__REQUIRES, newRequires, newRequires));
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
      case CoolPackage.GUARD__REQUIRES:
        return basicSetRequires(null, msgs);
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
      case CoolPackage.GUARD__METHODS:
        return getMethods();
      case CoolPackage.GUARD__REQUIRES:
        return getRequires();
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
      case CoolPackage.GUARD__METHODS:
        getMethods().clear();
        getMethods().addAll((Collection<? extends String>)newValue);
        return;
      case CoolPackage.GUARD__REQUIRES:
        setRequires((Requires)newValue);
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
      case CoolPackage.GUARD__METHODS:
        getMethods().clear();
        return;
      case CoolPackage.GUARD__REQUIRES:
        setRequires((Requires)null);
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
      case CoolPackage.GUARD__METHODS:
        return methods != null && !methods.isEmpty();
      case CoolPackage.GUARD__REQUIRES:
        return requires != null;
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
    result.append(" (methods: ");
    result.append(methods);
    result.append(')');
    return result.toString();
  }

} //GuardImpl
