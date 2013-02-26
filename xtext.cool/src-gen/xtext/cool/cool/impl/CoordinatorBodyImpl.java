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

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import xtext.cool.cool.CondVar;
import xtext.cool.cool.CoolPackage;
import xtext.cool.cool.CoordinatorBody;
import xtext.cool.cool.MutexSet;
import xtext.cool.cool.OrdVar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Coordinator Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link xtext.cool.cool.impl.CoordinatorBodyImpl#getCondVars <em>Cond Vars</em>}</li>
 *   <li>{@link xtext.cool.cool.impl.CoordinatorBodyImpl#getOrdVars <em>Ord Vars</em>}</li>
 *   <li>{@link xtext.cool.cool.impl.CoordinatorBodyImpl#getSelfexMethods <em>Selfex Methods</em>}</li>
 *   <li>{@link xtext.cool.cool.impl.CoordinatorBodyImpl#getMutexSets <em>Mutex Sets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CoordinatorBodyImpl extends MinimalEObjectImpl.Container implements CoordinatorBody
{
  /**
   * The cached value of the '{@link #getCondVars() <em>Cond Vars</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondVars()
   * @generated
   * @ordered
   */
  protected EList<CondVar> condVars;

  /**
   * The cached value of the '{@link #getOrdVars() <em>Ord Vars</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrdVars()
   * @generated
   * @ordered
   */
  protected EList<OrdVar> ordVars;

  /**
   * The cached value of the '{@link #getSelfexMethods() <em>Selfex Methods</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelfexMethods()
   * @generated
   * @ordered
   */
  protected EList<String> selfexMethods;

  /**
   * The cached value of the '{@link #getMutexSets() <em>Mutex Sets</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMutexSets()
   * @generated
   * @ordered
   */
  protected EList<MutexSet> mutexSets;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CoordinatorBodyImpl()
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
    return CoolPackage.Literals.COORDINATOR_BODY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CondVar> getCondVars()
  {
    if (condVars == null)
    {
      condVars = new EObjectContainmentEList<CondVar>(CondVar.class, this, CoolPackage.COORDINATOR_BODY__COND_VARS);
    }
    return condVars;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<OrdVar> getOrdVars()
  {
    if (ordVars == null)
    {
      ordVars = new EObjectContainmentEList<OrdVar>(OrdVar.class, this, CoolPackage.COORDINATOR_BODY__ORD_VARS);
    }
    return ordVars;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getSelfexMethods()
  {
    if (selfexMethods == null)
    {
      selfexMethods = new EDataTypeEList<String>(String.class, this, CoolPackage.COORDINATOR_BODY__SELFEX_METHODS);
    }
    return selfexMethods;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MutexSet> getMutexSets()
  {
    if (mutexSets == null)
    {
      mutexSets = new EObjectContainmentEList<MutexSet>(MutexSet.class, this, CoolPackage.COORDINATOR_BODY__MUTEX_SETS);
    }
    return mutexSets;
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
      case CoolPackage.COORDINATOR_BODY__COND_VARS:
        return ((InternalEList<?>)getCondVars()).basicRemove(otherEnd, msgs);
      case CoolPackage.COORDINATOR_BODY__ORD_VARS:
        return ((InternalEList<?>)getOrdVars()).basicRemove(otherEnd, msgs);
      case CoolPackage.COORDINATOR_BODY__MUTEX_SETS:
        return ((InternalEList<?>)getMutexSets()).basicRemove(otherEnd, msgs);
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
      case CoolPackage.COORDINATOR_BODY__COND_VARS:
        return getCondVars();
      case CoolPackage.COORDINATOR_BODY__ORD_VARS:
        return getOrdVars();
      case CoolPackage.COORDINATOR_BODY__SELFEX_METHODS:
        return getSelfexMethods();
      case CoolPackage.COORDINATOR_BODY__MUTEX_SETS:
        return getMutexSets();
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
      case CoolPackage.COORDINATOR_BODY__COND_VARS:
        getCondVars().clear();
        getCondVars().addAll((Collection<? extends CondVar>)newValue);
        return;
      case CoolPackage.COORDINATOR_BODY__ORD_VARS:
        getOrdVars().clear();
        getOrdVars().addAll((Collection<? extends OrdVar>)newValue);
        return;
      case CoolPackage.COORDINATOR_BODY__SELFEX_METHODS:
        getSelfexMethods().clear();
        getSelfexMethods().addAll((Collection<? extends String>)newValue);
        return;
      case CoolPackage.COORDINATOR_BODY__MUTEX_SETS:
        getMutexSets().clear();
        getMutexSets().addAll((Collection<? extends MutexSet>)newValue);
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
      case CoolPackage.COORDINATOR_BODY__COND_VARS:
        getCondVars().clear();
        return;
      case CoolPackage.COORDINATOR_BODY__ORD_VARS:
        getOrdVars().clear();
        return;
      case CoolPackage.COORDINATOR_BODY__SELFEX_METHODS:
        getSelfexMethods().clear();
        return;
      case CoolPackage.COORDINATOR_BODY__MUTEX_SETS:
        getMutexSets().clear();
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
      case CoolPackage.COORDINATOR_BODY__COND_VARS:
        return condVars != null && !condVars.isEmpty();
      case CoolPackage.COORDINATOR_BODY__ORD_VARS:
        return ordVars != null && !ordVars.isEmpty();
      case CoolPackage.COORDINATOR_BODY__SELFEX_METHODS:
        return selfexMethods != null && !selfexMethods.isEmpty();
      case CoolPackage.COORDINATOR_BODY__MUTEX_SETS:
        return mutexSets != null && !mutexSets.isEmpty();
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
    result.append(" (selfexMethods: ");
    result.append(selfexMethods);
    result.append(')');
    return result.toString();
  }

} //CoordinatorBodyImpl
