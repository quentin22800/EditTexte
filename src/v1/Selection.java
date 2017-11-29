package v1;
/***********************************************************************
 * Module:  Selection.java
 * Author:  17009495
 * Purpose: Defines the Class Selection
 ***********************************************************************/

import java.util.*;

/**
 * Classe Selection
 * @author Eono Quentin, Rebours Gaël
 */
public class Selection {

	private int positionDebut;
	private int longueur;
	public MoteurEdImpl moteurEdImpl;

	/**
	 * Constructeur de la classe Selection
	 * @param iHMInput TO DOOOOOOOOOOOOOOOOOOOOOOOO
	 * @param moteurEdImpl TO DOOOOOOOOOOOOOOOOOOOOOO
	 */
	public Selection (int positionDebut, int longueur){
		this.positionDebut = positionDebut;
		this.longueur = longueur;
	}

	/**
	 * Méthode selecitonUpdate, met à jour la sélection
	 * @param positionDebut, position de début de la sélection
	 * @param longueur, longueur de la sélecion
	 */
	public void selectionUpdate(int positionDebut, int longueur){
		this.positionDebut = positionDebut;
		this.longueur = longueur;
	}

	/**
	 * Getter de la position de debut
	 * @return positionDebut, position de début de la sélection
	 */
	public int getPositionDebut() {
		return positionDebut;
	}

	/**
	 * Getter de la longueur
	 * @return longueur, longueur de la sélection
	 */
	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int i) {
		this.longueur = i;
		
	}

}