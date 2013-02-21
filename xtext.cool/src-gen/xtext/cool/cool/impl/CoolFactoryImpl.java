/**
 * <copyright>
 * </copyright>
 *
 */
package xtext.cool.cool.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import xtext.cool.cool.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CoolFactoryImpl extends EFactoryImpl implements CoolFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CoolFactory init()
  {
    try
    {
      CoolFactory theCoolFactory = (CoolFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.cool.xtext/Cool"); 
      if (theCoolFactory != null)
      {
        return theCoolFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new CoolFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CoolFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case CoolPackage.COORDINATOR_DECLARATION: return createCoordinatorDeclaration();
      case CoolPackage.COORDINATOR_BODY: return createCoordinatorBody();
      case CoolPackage.COND_VAR: return createCondVar();
      case CoolPackage.ORD_VAR: return createOrdVar();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CoordinatorDeclaration createCoordinatorDeclaration()
  {
    CoordinatorDeclarationImpl coordinatorDeclaration = new CoordinatorDeclarationImpl();
    return coordinatorDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CoordinatorBody createCoordinatorBody()
  {
    CoordinatorBodyImpl coordinatorBody = new CoordinatorBodyImpl();
    return coordinatorBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CondVar createCondVar()
  {
    CondVarImpl condVar = new CondVarImpl();
    return condVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrdVar createOrdVar()
  {
    OrdVarImpl ordVar = new OrdVarImpl();
    return ordVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CoolPackage getCoolPackage()
  {
    return (CoolPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static CoolPackage getPackage()
  {
    return CoolPackage.eINSTANCE;
  }

} //CoolFactoryImpl
