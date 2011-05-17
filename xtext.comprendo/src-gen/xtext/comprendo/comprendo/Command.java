/**
 * <copyright>
 * </copyright>
 *

 */
package xtext.comprendo.comprendo;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xtext.comprendo.comprendo.Command#getId <em>Id</em>}</li>
 *   <li>{@link xtext.comprendo.comprendo.Command#isSummary <em>Summary</em>}</li>
 * </ul>
 * </p>
 *
 * @see xtext.comprendo.comprendo.ComprendoPackage#getCommand()
 * @model
 * @generated
 */
public interface Command extends EObject
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see xtext.comprendo.comprendo.ComprendoPackage#getCommand_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link xtext.comprendo.comprendo.Command#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Summary</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Summary</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Summary</em>' attribute.
   * @see #setSummary(boolean)
   * @see xtext.comprendo.comprendo.ComprendoPackage#getCommand_Summary()
   * @model
   * @generated
   */
  boolean isSummary();

  /**
   * Sets the value of the '{@link xtext.comprendo.comprendo.Command#isSummary <em>Summary</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Summary</em>' attribute.
   * @see #isSummary()
   * @generated
   */
  void setSummary(boolean value);

} // Command
