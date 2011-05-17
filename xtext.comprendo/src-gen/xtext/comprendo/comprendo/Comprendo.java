/**
 * <copyright>
 * </copyright>
 *

 */
package xtext.comprendo.comprendo;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Comprendo</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xtext.comprendo.comprendo.Comprendo#getName <em>Name</em>}</li>
 *   <li>{@link xtext.comprendo.comprendo.Comprendo#getScope <em>Scope</em>}</li>
 *   <li>{@link xtext.comprendo.comprendo.Comprendo#getOutdir <em>Outdir</em>}</li>
 *   <li>{@link xtext.comprendo.comprendo.Comprendo#getCommands <em>Commands</em>}</li>
 * </ul>
 * </p>
 *
 * @see xtext.comprendo.comprendo.ComprendoPackage#getComprendo()
 * @model
 * @generated
 */
public interface Comprendo extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see xtext.comprendo.comprendo.ComprendoPackage#getComprendo_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link xtext.comprendo.comprendo.Comprendo#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Scope</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scope</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scope</em>' containment reference.
   * @see #setScope(Scope)
   * @see xtext.comprendo.comprendo.ComprendoPackage#getComprendo_Scope()
   * @model containment="true"
   * @generated
   */
  Scope getScope();

  /**
   * Sets the value of the '{@link xtext.comprendo.comprendo.Comprendo#getScope <em>Scope</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Scope</em>' containment reference.
   * @see #getScope()
   * @generated
   */
  void setScope(Scope value);

  /**
   * Returns the value of the '<em><b>Outdir</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outdir</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outdir</em>' containment reference.
   * @see #setOutdir(Outdir)
   * @see xtext.comprendo.comprendo.ComprendoPackage#getComprendo_Outdir()
   * @model containment="true"
   * @generated
   */
  Outdir getOutdir();

  /**
   * Sets the value of the '{@link xtext.comprendo.comprendo.Comprendo#getOutdir <em>Outdir</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Outdir</em>' containment reference.
   * @see #getOutdir()
   * @generated
   */
  void setOutdir(Outdir value);

  /**
   * Returns the value of the '<em><b>Commands</b></em>' containment reference list.
   * The list contents are of type {@link xtext.comprendo.comprendo.Command}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Commands</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Commands</em>' containment reference list.
   * @see xtext.comprendo.comprendo.ComprendoPackage#getComprendo_Commands()
   * @model containment="true"
   * @generated
   */
  EList<Command> getCommands();

} // Comprendo
