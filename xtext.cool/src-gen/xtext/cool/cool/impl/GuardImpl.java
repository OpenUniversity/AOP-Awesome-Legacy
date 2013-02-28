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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import xtext.cool.cool.AssignStatement;
import xtext.cool.cool.CoolPackage;
import xtext.cool.cool.Guard;
import xtext.cool.cool.IfStatement;
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
 *   <li>{@link xtext.cool.cool.impl.GuardImpl#getOnEntryIfStatements <em>On Entry If Statements</em>}</li>
 *   <li>{@link xtext.cool.cool.impl.GuardImpl#getOnEntryAssignStatements <em>On Entry Assign Statements</em>}</li>
 *   <li>{@link xtext.cool.cool.impl.GuardImpl#getOnExitIfStatements <em>On Exit If Statements</em>}</li>
 *   <li>{@link xtext.cool.cool.impl.GuardImpl#getOnExitAssignStatements <em>On Exit Assign Statements</em>}</li>
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
   * The cached value of the '{@link #getOnEntryIfStatements() <em>On Entry If Statements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOnEntryIfStatements()
   * @generated
   * @ordered
   */
  protected EList<IfStatement> onEntryIfStatements;

  /**
   * The cached value of the '{@link #getOnEntryAssignStatements() <em>On Entry Assign Statements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOnEntryAssignStatements()
   * @generated
   * @ordered
   */
  protected EList<AssignStatement> onEntryAssignStatements;

  /**
   * The cached value of the '{@link #getOnExitIfStatements() <em>On Exit If Statements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOnExitIfStatements()
   * @generated
   * @ordered
   */
  protected EList<IfStatement> onExitIfStatements;

  /**
   * The cached value of the '{@link #getOnExitAssignStatements() <em>On Exit Assign Statements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOnExitAssignStatements()
   * @generated
   * @ordered
   */
  protected EList<AssignStatement> onExitAssignStatements;

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
  public EList<IfStatement> getOnEntryIfStatements()
  {
    if (onEntryIfStatements == null)
    {
      onEntryIfStatements = new EObjectContainmentEList<IfStatement>(IfStatement.class, this, CoolPackage.GUARD__ON_ENTRY_IF_STATEMENTS);
    }
    return onEntryIfStatements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AssignStatement> getOnEntryAssignStatements()
  {
    if (onEntryAssignStatements == null)
    {
      onEntryAssignStatements = new EObjectContainmentEList<AssignStatement>(AssignStatement.class, this, CoolPackage.GUARD__ON_ENTRY_ASSIGN_STATEMENTS);
    }
    return onEntryAssignStatements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<IfStatement> getOnExitIfStatements()
  {
    if (onExitIfStatements == null)
    {
      onExitIfStatements = new EObjectContainmentEList<IfStatement>(IfStatement.class, this, CoolPackage.GUARD__ON_EXIT_IF_STATEMENTS);
    }
    return onExitIfStatements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AssignStatement> getOnExitAssignStatements()
  {
    if (onExitAssignStatements == null)
    {
      onExitAssignStatements = new EObjectContainmentEList<AssignStatement>(AssignStatement.class, this, CoolPackage.GUARD__ON_EXIT_ASSIGN_STATEMENTS);
    }
    return onExitAssignStatements;
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
      case CoolPackage.GUARD__ON_ENTRY_IF_STATEMENTS:
        return ((InternalEList<?>)getOnEntryIfStatements()).basicRemove(otherEnd, msgs);
      case CoolPackage.GUARD__ON_ENTRY_ASSIGN_STATEMENTS:
        return ((InternalEList<?>)getOnEntryAssignStatements()).basicRemove(otherEnd, msgs);
      case CoolPackage.GUARD__ON_EXIT_IF_STATEMENTS:
        return ((InternalEList<?>)getOnExitIfStatements()).basicRemove(otherEnd, msgs);
      case CoolPackage.GUARD__ON_EXIT_ASSIGN_STATEMENTS:
        return ((InternalEList<?>)getOnExitAssignStatements()).basicRemove(otherEnd, msgs);
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
      case CoolPackage.GUARD__ON_ENTRY_IF_STATEMENTS:
        return getOnEntryIfStatements();
      case CoolPackage.GUARD__ON_ENTRY_ASSIGN_STATEMENTS:
        return getOnEntryAssignStatements();
      case CoolPackage.GUARD__ON_EXIT_IF_STATEMENTS:
        return getOnExitIfStatements();
      case CoolPackage.GUARD__ON_EXIT_ASSIGN_STATEMENTS:
        return getOnExitAssignStatements();
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
      case CoolPackage.GUARD__ON_ENTRY_IF_STATEMENTS:
        getOnEntryIfStatements().clear();
        getOnEntryIfStatements().addAll((Collection<? extends IfStatement>)newValue);
        return;
      case CoolPackage.GUARD__ON_ENTRY_ASSIGN_STATEMENTS:
        getOnEntryAssignStatements().clear();
        getOnEntryAssignStatements().addAll((Collection<? extends AssignStatement>)newValue);
        return;
      case CoolPackage.GUARD__ON_EXIT_IF_STATEMENTS:
        getOnExitIfStatements().clear();
        getOnExitIfStatements().addAll((Collection<? extends IfStatement>)newValue);
        return;
      case CoolPackage.GUARD__ON_EXIT_ASSIGN_STATEMENTS:
        getOnExitAssignStatements().clear();
        getOnExitAssignStatements().addAll((Collection<? extends AssignStatement>)newValue);
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
      case CoolPackage.GUARD__ON_ENTRY_IF_STATEMENTS:
        getOnEntryIfStatements().clear();
        return;
      case CoolPackage.GUARD__ON_ENTRY_ASSIGN_STATEMENTS:
        getOnEntryAssignStatements().clear();
        return;
      case CoolPackage.GUARD__ON_EXIT_IF_STATEMENTS:
        getOnExitIfStatements().clear();
        return;
      case CoolPackage.GUARD__ON_EXIT_ASSIGN_STATEMENTS:
        getOnExitAssignStatements().clear();
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
      case CoolPackage.GUARD__ON_ENTRY_IF_STATEMENTS:
        return onEntryIfStatements != null && !onEntryIfStatements.isEmpty();
      case CoolPackage.GUARD__ON_ENTRY_ASSIGN_STATEMENTS:
        return onEntryAssignStatements != null && !onEntryAssignStatements.isEmpty();
      case CoolPackage.GUARD__ON_EXIT_IF_STATEMENTS:
        return onExitIfStatements != null && !onExitIfStatements.isEmpty();
      case CoolPackage.GUARD__ON_EXIT_ASSIGN_STATEMENTS:
        return onExitAssignStatements != null && !onExitAssignStatements.isEmpty();
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
