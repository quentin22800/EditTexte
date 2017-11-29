package v2;
/***********************************************************************
 * Module:  Enregistrable.java
 * Author:  17009495
 * Purpose: Defines the Interface Enregistrable
 ***********************************************************************/

import java.util.*;

/**
 * Interface Enregistrable
 * @author Eono Quentin, Rebours Gaël
 */
public interface Enregistrable {

	/**
	 * Méthode getMemento, à implémenter
	 * @return un objet Memento
	 */
	Memento getMemento();

	/**
	 * Méthode setMemento, à implémenter
	 */
	void setMemento();

}