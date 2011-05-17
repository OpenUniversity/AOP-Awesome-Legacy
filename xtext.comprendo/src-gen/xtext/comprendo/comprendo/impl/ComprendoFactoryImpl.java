/**
 * <copyright>
 * </copyright>
 *

 */
package xtext.comprendo.comprendo.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import xtext.comprendo.comprendo.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComprendoFactoryImpl extends EFactoryImpl implements ComprendoFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ComprendoFactory init()
  {
    try
    {
      ComprendoFactory theComprendoFactory = (ComprendoFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.comprendo.xtext/Comprendo"); 
      if (theComprendoFactory != null)
      {
        return theComprendoFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ComprendoFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComprendoFactoryImpl()
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
      case ComprendoPackage.COMPRENDO_DSAL: return createComprendoDSAL();
      case ComprendoPackage.COMPRENDO: return createComprendo();
      case ComprendoPackage.SCOPE: return createScope();
      case ComprendoPackage.COMMAND: return createCommand();
      case ComprendoPackage.OUTDIR: return createOutdir();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComprendoDSAL createComprendoDSAL()
  {
    ComprendoDSALImpl comprendoDSAL = new ComprendoDSALImpl();
    return comprendoDSAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Comprendo createComprendo()
  {
    ComprendoImpl comprendo = new ComprendoImpl();
    return comprendo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scope createScope()
  {
    ScopeImpl scope = new ScopeImpl();
    return scope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Command createCommand()
  {
    CommandImpl command = new CommandImpl();
    return command;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Outdir createOutdir()
  {
    OutdirImpl outdir = new OutdirImpl();
    return outdir;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComprendoPackage getComprendoPackage()
  {
    return (ComprendoPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ComprendoPackage getPackage()
  {
    return ComprendoPackage.eINSTANCE;
  }

} //ComprendoFactoryImpl
