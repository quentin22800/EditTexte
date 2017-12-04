package v1;
/***********************************************************************
 * Module:  MoteurEdImpl.java
 * Author:  17009495
 * Purpose: Defines the Class MoteurEdImpl
 ***********************************************************************/

import java.util.*;

/**
 * Classe MoteurEdImpl, implémentation de MoteurEd et hérite de Observable
 * @author Eono Quentin, Rebours Gaël
 */
public class MoteurEdImpl extends Observable implements MoteurEd {

	private Buffer monBuffer;
	private Selection maSelection;
	private PressePapier monPressePapier;

	/**
	 * Méthode couper, récupère la selection, copier le texte sélectionner dans
	 * le presse papier et supprimer la sélection, enfin notifie l'observeur du changement
	 */
	public void couper() {

		int positionDebut = maSelection.getPositionDebut();
		int positionFin = positionDebut + maSelection.getLongueur();
		copier();
		monBuffer.oter(positionDebut, maSelection.getLongueur());
		maSelection.setLongueur(0);
		setChanged();
		notifyObservers(monBuffer.getZoneTexte());
	}

	/**
	 * Méthode copier, récupère la selection, copier le texte sélectionner dans
	 * le presse papier
	 */
	public void copier() {

		int positionDebut = maSelection.getPositionDebut();
		int positionFin = positionDebut + maSelection.getLongueur();
		String coupe = monBuffer.getZoneTexte().substring(positionDebut,positionFin);
		monPressePapier.setContenu(coupe);

	}

	/**
	 * Méthode coller, récupère la selection, insere le contenu du presse papier dans le buffer,
	 * notifie l'observeur du changement
	 */
	public void coller() {
		int debut = maSelection.getPositionDebut();
		int fin = debut + maSelection.getLongueur();
		monBuffer.inserer(monPressePapier.getContenu(), debut, fin);
		setChanged();
		notifyObservers(monBuffer.getZoneTexte());
	}

	/**
	 * Méthode inserTexte, récupère la selection, insere le texte dans le buffer
	 * @param texte, texte à inserer
	 */
	public void inserTexte(String texte) {
		int debut = maSelection.getPositionDebut();
		int fin = debut + maSelection.getLongueur();
		monBuffer.inserer(texte, debut, fin);
		maSelection.selectionUpdate(maSelection.getPositionDebut()+1, 0);
	}

	/**
	 * Méthode selectionner, permet de faire une selection
	 * @param positionDebut, position du début de la sélection
	 * @param longueur, longueur de la sélection
	 */
	public void selectionner(int positionDebut, int longueur) {
		maSelection.selectionUpdate(positionDebut, longueur);
	}

	/**
	 * Getter du buffer
	 * @return buffer, l'objet Buffer correspondant au buffer
	 */
	public Buffer getMonBuffer() {
		return monBuffer;
	}

	/**
	 * Setter du buffer
	 * @param monBuffer, l'objet buffer
	 */
	public void setMonBuffer(Buffer monBuffer) {
		this.monBuffer = monBuffer;
	}

	/**
	 * Getter du presse papier
	 * @return monPressePapier, objet PressPapier
	 */
	public PressePapier getMonPressePapier() {
		return monPressePapier;
	}

	/**
	 * Setter du presse papier
	 * @param monPressePapier, objet PressePapier
	 */
	public void setMonPressePapier(PressePapier monPressePapier) {
		this.monPressePapier = monPressePapier;
	}

	/**
	 * Getter de la selection
	 * @return maSelection, objet Selection
	 */
	public Selection getMaSelection() {
		
		return maSelection;
	}

	/**
	 * Setter de la selection
	 * @param maSelection, objet Selection
	 */
	public void setMaSelection(Selection maSelection) {
		this.maSelection = maSelection;
	}
	
	/**
	 * Méthode setChange, notifie les observateur des changements
	 * 
	 * @param o, contenu du buffer à afficher 
	 */
	public void setChange(Object o) {
		setChanged();
		notifyObservers(o);
	}

	public MoteurEdImpl getCopie(){
		MoteurEdImpl m = new MoteurEdImpl();
		m.setMaSelection(new Selection(maSelection.getPositionDebut(),maSelection.getLongueur()));
		Buffer b = new Buffer();
		b.inserer(monBuffer.getZoneTexte().toString(), 0, 0);
		m.setMonBuffer(b);
		PressePapier p = new PressePapier();
		p.setContenu(monPressePapier.getContenu());
		m.setMonPressePapier(p);
		return m;
	}
}