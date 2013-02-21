/**
 * <copyright>
 * </copyright>
 *
 */
package xtext.cool.cool.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import xtext.cool.cool.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see xtext.cool.cool.CoolPackage
 * @generated
 */
public class CoolAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static CoolPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CoolAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = CoolPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CoolSwitch<Adapter> modelSwitch =
    new CoolSwitch<Adapter>()
    {
      @Override
      public Adapter caseCoordinatorDeclaration(CoordinatorDeclaration object)
      {
        return createCoordinatorDeclarationAdapter();
      }
      @Override
      public Adapter caseCoordinatorBody(CoordinatorBody object)
      {
        return createCoordinatorBodyAdapter();
      }
      @Override
      public Adapter caseCondVar(CondVar object)
      {
        return createCondVarAdapter();
      }
      @Override
      public Adapter caseOrdVar(OrdVar object)
      {
        return createOrdVarAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link xtext.cool.cool.CoordinatorDeclaration <em>Coordinator Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see xtext.cool.cool.CoordinatorDeclaration
   * @generated
   */
  public Adapter createCoordinatorDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link xtext.cool.cool.CoordinatorBody <em>Coordinator Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see xtext.cool.cool.CoordinatorBody
   * @generated
   */
  public Adapter createCoordinatorBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link xtext.cool.cool.CondVar <em>Cond Var</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see xtext.cool.cool.CondVar
   * @generated
   */
  public Adapter createCondVarAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link xtext.cool.cool.OrdVar <em>Ord Var</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see xtext.cool.cool.OrdVar
   * @generated
   */
  public Adapter createOrdVarAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //CoolAdapterFactory
