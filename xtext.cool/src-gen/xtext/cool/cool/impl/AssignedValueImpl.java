/**
 * <copyright>
 * </copyright>
 *
 */
package xtext.cool.cool.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import xtext.cool.cool.AssignedValue;
import xtext.cool.cool.CoolPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assigned Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link xtext.cool.cool.impl.AssignedValueImpl#getIntval <em>Intval</em>}</li>
 *   <li>{@link xtext.cool.cool.impl.AssignedValueImpl#getBoolval <em>Boolval</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssignedValueImpl extends MinimalEObjectImpl.Container implements AssignedValue
{
  /**
   * The default value of the '{@link #getIntval() <em>Intval</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntval()
   * @generated
   * @ordered
   */
  protected static final int INTVAL_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getIntval() <em>Intval</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntval()
   * @generated
   * @ordered
   */
  protected int intval = INTVAL_EDEFAULT;

  /**
   * The default value of the '{@link #getBoolval() <em>Boolval</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBoolval()
   * @generated
   * @ordered
   */
  protected static final String BOOLVAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBoolval() <em>Boolval</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBoolval()
   * @generated
   * @ordered
   */
  protected String boolval = BOOLVAL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssignedValueImpl()
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
    return CoolPackage.Literals.ASSIGNED_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getIntval()
  {
    return intval;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIntval(int newIntval)
  {
    int oldIntval = intval;
    intval = newIntval;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoolPackage.ASSIGNED_VALUE__INTVAL, oldIntval, intval));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBoolval()
  {
    return boolval;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBoolval(String newBoolval)
  {
    String oldBoolval = boolval;
    boolval = newBoolval;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CoolPackage.ASSIGNED_VALUE__BOOLVAL, oldBoolval, boolval));
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
      case CoolPackage.ASSIGNED_VALUE__INTVAL:
        return getIntval();
      case CoolPackage.ASSIGNED_VALUE__BOOLVAL:
        return getBoolval();
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
      case CoolPackage.ASSIGNED_VALUE__INTVAL:
        setIntval((Integer)newValue);
        return;
      case CoolPackage.ASSIGNED_VALUE__BOOLVAL:
        setBoolval((String)newValue);
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
      case CoolPackage.ASSIGNED_VALUE__INTVAL:
        setIntval(INTVAL_EDEFAULT);
        return;
      case CoolPackage.ASSIGNED_VALUE__BOOLVAL:
        setBoolval(BOOLVAL_EDEFAULT);
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
      case CoolPackage.ASSIGNED_VALUE__INTVAL:
        return intval != INTVAL_EDEFAULT;
      case CoolPackage.ASSIGNED_VALUE__BOOLVAL:
        return BOOLVAL_EDEFAULT == null ? boolval != null : !BOOLVAL_EDEFAULT.equals(boolval);
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
    result.append(" (intval: ");
    result.append(intval);
    result.append(", boolval: ");
    result.append(boolval);
    result.append(')');
    return result.toString();
  }

} //AssignedValueImpl
