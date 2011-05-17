/**
 * <copyright>
 * </copyright>
 *

 */
package xtext.comprendo.comprendo;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DSAL</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link xtext.comprendo.comprendo.ComprendoDSAL#getComprendo <em>Comprendo</em>}</li>
 * </ul>
 * </p>
 *
 * @see xtext.comprendo.comprendo.ComprendoPackage#getComprendoDSAL()
 * @model
 * @generated
 */
public interface ComprendoDSAL extends EObject
{
  /**
   * Returns the value of the '<em><b>Comprendo</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Comprendo</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comprendo</em>' containment reference.
   * @see #setComprendo(Comprendo)
   * @see xtext.comprendo.comprendo.ComprendoPackage#getComprendoDSAL_Comprendo()
   * @model containment="true"
   * @generated
   */
  Comprendo getComprendo();

  /**
   * Sets the value of the '{@link xtext.comprendo.comprendo.ComprendoDSAL#getComprendo <em>Comprendo</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Comprendo</em>' containment reference.
   * @see #getComprendo()
   * @generated
   */
  void setComprendo(Comprendo value);

} // ComprendoDSAL
