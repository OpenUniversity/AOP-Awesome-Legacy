/**
 * <copyright>
 * </copyright>
 *

 */
package xtext.comprendo.comprendo.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import xtext.comprendo.comprendo.Command;
import xtext.comprendo.comprendo.ComprendoPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link xtext.comprendo.comprendo.impl.CommandImpl#getId <em>Id</em>}</li>
 *   <li>{@link xtext.comprendo.comprendo.impl.CommandImpl#isSummary <em>Summary</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommandImpl extends MinimalEObjectImpl.Container implements Command
{
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The default value of the '{@link #isSummary() <em>Summary</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSummary()
   * @generated
   * @ordered
   */
  protected static final boolean SUMMARY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSummary() <em>Summary</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSummary()
   * @generated
   * @ordered
   */
  protected boolean summary = SUMMARY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CommandImpl()
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
    return ComprendoPackage.Literals.COMMAND;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ComprendoPackage.COMMAND__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSummary()
  {
    return summary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSummary(boolean newSummary)
  {
    boolean oldSummary = summary;
    summary = newSummary;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ComprendoPackage.COMMAND__SUMMARY, oldSummary, summary));
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
      case ComprendoPackage.COMMAND__ID:
        return getId();
      case ComprendoPackage.COMMAND__SUMMARY:
        return isSummary();
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
      case ComprendoPackage.COMMAND__ID:
        setId((String)newValue);
        return;
      case ComprendoPackage.COMMAND__SUMMARY:
        setSummary((Boolean)newValue);
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
      case ComprendoPackage.COMMAND__ID:
        setId(ID_EDEFAULT);
        return;
      case ComprendoPackage.COMMAND__SUMMARY:
        setSummary(SUMMARY_EDEFAULT);
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
      case ComprendoPackage.COMMAND__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case ComprendoPackage.COMMAND__SUMMARY:
        return summary != SUMMARY_EDEFAULT;
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
    result.append(" (id: ");
    result.append(id);
    result.append(", summary: ");
    result.append(summary);
    result.append(')');
    return result.toString();
  }

} //CommandImpl
