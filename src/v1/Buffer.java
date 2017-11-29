package v1;
/***********************************************************************
 * Module:  Buffer.java
 * Author:  17009495
 * Purpose: Defines the Class Buffer
 ***********************************************************************/

import java.time.ZonedDateTime;
import java.util.*;

/**
 * Classe Buffer, gère les actions liés au buffer (inserer du texte et enlever du texte)
 * @author Eono Quentin, Rebours Gaël
 */
public class Buffer {

	private java.lang.StringBuffer zoneTexte;

	/**
	 * Constructeur de la classe Buffer
	 */
	public Buffer(){
		this.zoneTexte = new StringBuffer();
	}

	/**
	 * Méthode inserer, insère le texte dans le buffer en fonction des paramètres
	 * @param texte, le texte à insérer
	 * @param debut, le début de la selection où inserer le texte
	 * @param fin, la fin de la selection où inserer le texte
	 */
	public void inserer(String texte, int debut, int fin) {
		zoneTexte.delete(debut, fin);
		zoneTexte.insert(debut, texte);
		System.out.println(zoneTexte);
	}

	/**
	 * Méthode oter, supprime le texte du buffer en fonction d'une selection
	 * @param position, début de la sélection du texte à supprimer
	 * @param longueur, longueur de la sélection du texte à supprimer
	 */
	public void oter(int position, int longueur) {
		zoneTexte.delete(position, position+longueur);
	}

	/**
	 * Méthode getZoneTexte, permet d'obtenir l'objet zone de texte
	 * @return zoneTexte, objet string buffer représentant le contenu de l'éditeur
	 */
	public java.lang.StringBuffer getZoneTexte() {
		return zoneTexte;
	}

}