package v2;
/***********************************************************************
 * Module:  MementoSelectionner.java
 * Author:  17009495
 * Purpose: Defines the Class MementoSelectionner
 ***********************************************************************/

import java.util.*;

/**
 * Classe MementoSelectionner, implémentation de l'interface Memento
 * @author Eono Quentin, Rebours Gaël
 */
public class MementoSelectionner implements Memento {

	private int debut;
	private int longueur;

	/**
	 * Constructeur du MementoSelectionner
	 * @param debut, position de début de la sélection à conserver
	 * @param longueur, longueur de la sélection à conserver
	 */
	public MementoSelectionner(int debut, int longueur) {
		this.debut = debut;
		this.longueur = longueur;
	}

	/**
	 * Getter du debut
	 * @return debut, position de début de la sélection
	 */
	public int getDebut() {
		return debut;
	}

	/**
	 * Setter du debut
	 * @param debut, debut de la selection
	 */
	public void setDebut(int debut) {
		this.debut = debut;
	}

	/**
	 * Getter de la longueur
	 * @return longueur, longueur de la sélection
	 */
	public int getLongueur() {
		return longueur;
	}

	/**
	 * Setter de la longueur
	 * @param longueur, longueur de la sélection
	 */
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

}