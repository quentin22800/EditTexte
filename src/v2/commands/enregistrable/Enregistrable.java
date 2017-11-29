package v2.commands.enregistrable;
/***********************************************************************
 * Module:  Enregistrable.java
 * Author:  17009495
 * Purpose: Defines the Interface Enregistrable
 ***********************************************************************/

import java.util.*;

import v2.mementos.Memento;

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