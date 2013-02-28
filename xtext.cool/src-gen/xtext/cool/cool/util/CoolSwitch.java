/**
 * <copyright>
 * </copyright>
 *
 */
package xtext.cool.cool.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import xtext.cool.cool.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see xtext.cool.cool.CoolPackage
 * @generated
 */
public class CoolSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static CoolPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CoolSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = CoolPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case CoolPackage.COORDINATOR_DECLARATION:
      {
        CoordinatorDeclaration coordinatorDeclaration = (CoordinatorDeclaration)theEObject;
        T result = caseCoordinatorDeclaration(coordinatorDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CoolPackage.COORDINATOR_BODY:
      {
        CoordinatorBody coordinatorBody = (CoordinatorBody)theEObject;
        T result = caseCoordinatorBody(coordinatorBody);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CoolPackage.GUARD:
      {
        Guard guard = (Guard)theEObject;
        T result = caseGuard(guard);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CoolPackage.REQUIRES:
      {
        Requires requires = (Requires)theEObject;
        T result = caseRequires(requires);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CoolPackage.AND_EXPRESSION:
      {
        AndExpression andExpression = (AndExpression)theEObject;
        T result = caseAndExpression(andExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CoolPackage.OR_EXPRESSION:
      {
        OrExpression orExpression = (OrExpression)theEObject;
        T result = caseOrExpression(orExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CoolPackage.BASIC_EXPRESSION:
      {
        BasicExpression basicExpression = (BasicExpression)theEObject;
        T result = caseBasicExpression(basicExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CoolPackage.MUTEX_SET:
      {
        MutexSet mutexSet = (MutexSet)theEObject;
        T result = caseMutexSet(mutexSet);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CoolPackage.COND_VAR:
      {
        CondVar condVar = (CondVar)theEObject;
        T result = caseCondVar(condVar);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CoolPackage.ORD_VAR:
      {
        OrdVar ordVar = (OrdVar)theEObject;
        T result = caseOrdVar(ordVar);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Coordinator Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Coordinator Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCoordinatorDeclaration(CoordinatorDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Coordinator Body</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Coordinator Body</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCoordinatorBody(CoordinatorBody object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Guard</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Guard</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGuard(Guard object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Requires</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Requires</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRequires(Requires object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAndExpression(AndExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrExpression(OrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Basic Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Basic Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBasicExpression(BasicExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mutex Set</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mutex Set</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMutexSet(MutexSet object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cond Var</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cond Var</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCondVar(CondVar object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ord Var</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ord Var</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrdVar(OrdVar object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //CoolSwitch
