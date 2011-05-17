/**
 * <copyright>
 * </copyright>
 *

 */
package xtext.comprendo.comprendo.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import xtext.comprendo.comprendo.Command;
import xtext.comprendo.comprendo.Comprendo;
import xtext.comprendo.comprendo.ComprendoPackage;
import xtext.comprendo.comprendo.Outdir;
import xtext.comprendo.comprendo.Scope;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Comprendo</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link xtext.comprendo.comprendo.impl.ComprendoImpl#getName <em>Name</em>}</li>
 *   <li>{@link xtext.comprendo.comprendo.impl.ComprendoImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link xtext.comprendo.comprendo.impl.ComprendoImpl#getOutdir <em>Outdir</em>}</li>
 *   <li>{@link xtext.comprendo.comprendo.impl.ComprendoImpl#getCommands <em>Commands</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComprendoImpl extends MinimalEObjectImpl.Container implements Comprendo
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getScope() <em>Scope</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScope()
   * @generated
   * @ordered
   */
  protected Scope scope;

  /**
   * The cached value of the '{@link #getOutdir() <em>Outdir</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutdir()
   * @generated
   * @ordered
   */
  protected Outdir outdir;

  /**
   * The cached value of the '{@link #getCommands() <em>Commands</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCommands()
   * @generated
   * @ordered
   */
  protected EList<Command> commands;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComprendoImpl()
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
    return ComprendoPackage.Literals.COMPRENDO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ComprendoPackage.COMPRENDO__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scope getScope()
  {
    return scope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetScope(Scope newScope, NotificationChain msgs)
  {
    Scope oldScope = scope;
    scope = newScope;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComprendoPackage.COMPRENDO__SCOPE, oldScope, newScope);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScope(Scope newScope)
  {
    if (newScope != scope)
    {
      NotificationChain msgs = null;
      if (scope != null)
        msgs = ((InternalEObject)scope).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComprendoPackage.COMPRENDO__SCOPE, null, msgs);
      if (newScope != null)
        msgs = ((InternalEObject)newScope).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComprendoPackage.COMPRENDO__SCOPE, null, msgs);
      msgs = basicSetScope(newScope, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ComprendoPackage.COMPRENDO__SCOPE, newScope, newScope));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Outdir getOutdir()
  {
    return outdir;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOutdir(Outdir newOutdir, NotificationChain msgs)
  {
    Outdir oldOutdir = outdir;
    outdir = newOutdir;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComprendoPackage.COMPRENDO__OUTDIR, oldOutdir, newOutdir);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutdir(Outdir newOutdir)
  {
    if (newOutdir != outdir)
    {
      NotificationChain msgs = null;
      if (outdir != null)
        msgs = ((InternalEObject)outdir).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComprendoPackage.COMPRENDO__OUTDIR, null, msgs);
      if (newOutdir != null)
        msgs = ((InternalEObject)newOutdir).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComprendoPackage.COMPRENDO__OUTDIR, null, msgs);
      msgs = basicSetOutdir(newOutdir, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ComprendoPackage.COMPRENDO__OUTDIR, newOutdir, newOutdir));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Command> getCommands()
  {
    if (commands == null)
    {
      commands = new EObjectContainmentEList<Command>(Command.class, this, ComprendoPackage.COMPRENDO__COMMANDS);
    }
    return commands;
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
      case ComprendoPackage.COMPRENDO__SCOPE:
        return basicSetScope(null, msgs);
      case ComprendoPackage.COMPRENDO__OUTDIR:
        return basicSetOutdir(null, msgs);
      case ComprendoPackage.COMPRENDO__COMMANDS:
        return ((InternalEList<?>)getCommands()).basicRemove(otherEnd, msgs);
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
      case ComprendoPackage.COMPRENDO__NAME:
        return getName();
      case ComprendoPackage.COMPRENDO__SCOPE:
        return getScope();
      case ComprendoPackage.COMPRENDO__OUTDIR:
        return getOutdir();
      case ComprendoPackage.COMPRENDO__COMMANDS:
        return getCommands();
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
      case ComprendoPackage.COMPRENDO__NAME:
        setName((String)newValue);
        return;
      case ComprendoPackage.COMPRENDO__SCOPE:
        setScope((Scope)newValue);
        return;
      case ComprendoPackage.COMPRENDO__OUTDIR:
        setOutdir((Outdir)newValue);
        return;
      case ComprendoPackage.COMPRENDO__COMMANDS:
        getCommands().clear();
        getCommands().addAll((Collection<? extends Command>)newValue);
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
      case ComprendoPackage.COMPRENDO__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ComprendoPackage.COMPRENDO__SCOPE:
        setScope((Scope)null);
        return;
      case ComprendoPackage.COMPRENDO__OUTDIR:
        setOutdir((Outdir)null);
        return;
      case ComprendoPackage.COMPRENDO__COMMANDS:
        getCommands().clear();
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
      case ComprendoPackage.COMPRENDO__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ComprendoPackage.COMPRENDO__SCOPE:
        return scope != null;
      case ComprendoPackage.COMPRENDO__OUTDIR:
        return outdir != null;
      case ComprendoPackage.COMPRENDO__COMMANDS:
        return commands != null && !commands.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ComprendoImpl
