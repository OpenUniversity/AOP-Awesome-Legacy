/**
 * <copyright>
 * </copyright>
 *
 */
package xtext.cool.cool;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Coordinator Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xtext.cool.cool.CoordinatorDeclaration#getGranularity <em>Granularity</em>}</li>
 *   <li>{@link xtext.cool.cool.CoordinatorDeclaration#getClassName <em>Class Name</em>}</li>
 *   <li>{@link xtext.cool.cool.CoordinatorDeclaration#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see xtext.cool.cool.CoolPackage#getCoordinatorDeclaration()
 * @model
 * @generated
 */
public interface CoordinatorDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Granularity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Granularity</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Granularity</em>' attribute.
   * @see #setGranularity(String)
   * @see xtext.cool.cool.CoolPackage#getCoordinatorDeclaration_Granularity()
   * @model
   * @generated
   */
  String getGranularity();

  /**
   * Sets the value of the '{@link xtext.cool.cool.CoordinatorDeclaration#getGranularity <em>Granularity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Granularity</em>' attribute.
   * @see #getGranularity()
   * @generated
   */
  void setGranularity(String value);

  /**
   * Returns the value of the '<em><b>Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class Name</em>' attribute.
   * @see #setClassName(String)
   * @see xtext.cool.cool.CoolPackage#getCoordinatorDeclaration_ClassName()
   * @model
   * @generated
   */
  String getClassName();

  /**
   * Sets the value of the '{@link xtext.cool.cool.CoordinatorDeclaration#getClassName <em>Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class Name</em>' attribute.
   * @see #getClassName()
   * @generated
   */
  void setClassName(String value);

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(CoordinatorBody)
   * @see xtext.cool.cool.CoolPackage#getCoordinatorDeclaration_Body()
   * @model containment="true"
   * @generated
   */
  CoordinatorBody getBody();

  /**
   * Sets the value of the '{@link xtext.cool.cool.CoordinatorDeclaration#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(CoordinatorBody value);

} // CoordinatorDeclaration
