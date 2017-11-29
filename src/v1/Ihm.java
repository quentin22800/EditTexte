package v1;
/***********************************************************************
 * Module:  Ihm.java
 * Author:  17009495
 * Purpose: Defines the Interface Ihm
 ***********************************************************************/

import java.awt.TextArea;
import java.util.*;

import javax.swing.JTextArea;

/**
 * Interface Ihm
 * @author quentineono
 */
public interface Ihm {

	/**
	 * Méthode getTextInserer, à implementer
	 * @return un objet String, qui est le texte inseré
	 */
	public String getTextInserer();

	/**
	 * Méthode setTextInserer, à implementer
	 * @param texte, qui est le texte à inserer
	 */
	public void setTextInserer(String texte);

	/**
	 * Méthode getTextArea, à implementer
	 * @return l'objet JTexteArea qui est notre zone de texte
	 */
	public JTextArea getTextArea();

}