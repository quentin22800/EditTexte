package v1;
/***********************************************************************
 * Module:  MoteurEd.java
 * Author:  17009495
 * Purpose: Defines the Interface MoteurEd
 ***********************************************************************/

import java.util.*;

/**
 * Interface MoteurEd
 * @author Eono Quentin, Rebours Gaël
 */
public interface MoteurEd {

	/**
	 * Méthode couper, à implémenter
	 */
	void couper();

	/**
	 * Méthode copier, à implémenter
	 */
	void copier();

	/**
	 * Méthode coller, à implémenter
	 */
	void coller();

	/**
	 * Méthode inserTexte, à implémenter
	 * @param texte, texte à inserer
	 */
	void inserTexte(String texte);

	/**
	 * Méthode selectionner, à implémenter
	 * @param positionDebut, début de la sélection
	 * @param longueur, longueur de la sélection
	 */
	void selectionner(int positionDebut, int longueur);

}