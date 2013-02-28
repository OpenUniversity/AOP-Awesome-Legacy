/**
 * <copyright>
 * </copyright>
 *
 */
package xtext.cool.cool;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xtext.cool.cool.Guard#getMethods <em>Methods</em>}</li>
 *   <li>{@link xtext.cool.cool.Guard#getRequires <em>Requires</em>}</li>
 *   <li>{@link xtext.cool.cool.Guard#getOnEntryIfStatements <em>On Entry If Statements</em>}</li>
 *   <li>{@link xtext.cool.cool.Guard#getOnEntryAssignStatements <em>On Entry Assign Statements</em>}</li>
 *   <li>{@link xtext.cool.cool.Guard#getOnExitIfStatements <em>On Exit If Statements</em>}</li>
 *   <li>{@link xtext.cool.cool.Guard#getOnExitAssignStatements <em>On Exit Assign Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @see xtext.cool.cool.CoolPackage#getGuard()
 * @model
 * @generated
 */
public interface Guard extends EObject
{
  /**
   * Returns the value of the '<em><b>Methods</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Methods</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Methods</em>' attribute list.
   * @see xtext.cool.cool.CoolPackage#getGuard_Methods()
   * @model unique="false"
   * @generated
   */
  EList<String> getMethods();

  /**
   * Returns the value of the '<em><b>Requires</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requires</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requires</em>' containment reference.
   * @see #setRequires(Requires)
   * @see xtext.cool.cool.CoolPackage#getGuard_Requires()
   * @model containment="true"
   * @generated
   */
  Requires getRequires();

  /**
   * Sets the value of the '{@link xtext.cool.cool.Guard#getRequires <em>Requires</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Requires</em>' containment reference.
   * @see #getRequires()
   * @generated
   */
  void setRequires(Requires value);

  /**
   * Returns the value of the '<em><b>On Entry If Statements</b></em>' containment reference list.
   * The list contents are of type {@link xtext.cool.cool.IfStatement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>On Entry If Statements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>On Entry If Statements</em>' containment reference list.
   * @see xtext.cool.cool.CoolPackage#getGuard_OnEntryIfStatements()
   * @model containment="true"
   * @generated
   */
  EList<IfStatement> getOnEntryIfStatements();

  /**
   * Returns the value of the '<em><b>On Entry Assign Statements</b></em>' containment reference list.
   * The list contents are of type {@link xtext.cool.cool.AssignStatement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>On Entry Assign Statements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>On Entry Assign Statements</em>' containment reference list.
   * @see xtext.cool.cool.CoolPackage#getGuard_OnEntryAssignStatements()
   * @model containment="true"
   * @generated
   */
  EList<AssignStatement> getOnEntryAssignStatements();

  /**
   * Returns the value of the '<em><b>On Exit If Statements</b></em>' containment reference list.
   * The list contents are of type {@link xtext.cool.cool.IfStatement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>On Exit If Statements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>On Exit If Statements</em>' containment reference list.
   * @see xtext.cool.cool.CoolPackage#getGuard_OnExitIfStatements()
   * @model containment="true"
   * @generated
   */
  EList<IfStatement> getOnExitIfStatements();

  /**
   * Returns the value of the '<em><b>On Exit Assign Statements</b></em>' containment reference list.
   * The list contents are of type {@link xtext.cool.cool.AssignStatement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>On Exit Assign Statements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>On Exit Assign Statements</em>' containment reference list.
   * @see xtext.cool.cool.CoolPackage#getGuard_OnExitAssignStatements()
   * @model containment="true"
   * @generated
   */
  EList<AssignStatement> getOnExitAssignStatements();

} // Guard
