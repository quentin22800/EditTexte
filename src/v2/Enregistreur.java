package v2;
/***********************************************************************
 * Module:  Enregistreur.java
 * Author:  17009495
 * Purpose: Defines the Interface Enregistreur
 ***********************************************************************/

import java.util.*;

import v1.Command;

/**
 * Interface Enregistreur
 * @author Eono Quentin, Rebours Gaël
 */
public interface Enregistreur {

	/**
	 * Méthode demarrer, à implémenter
	 */
	void demarrer();

	/**
	 * Méthode arreter, à implémenter
	 */
	void arreter();

	/**
	 * Méthode rejouer, à implémenter
	 */
	void rejouer();

	/**
	 * Méthode enregistrer, à implémenter 
	 * @param c, objet Enregistrable (commande) à enregistrer
	 */
	void enregistrer(Enregistrable c);
	
}