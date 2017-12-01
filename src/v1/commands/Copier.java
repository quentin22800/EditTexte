package v1.commands;
/***********************************************************************
 * Module:  Copier.java
 * Author:  17009495
 * Purpose: Defines the Class Copier
 ***********************************************************************/

import java.util.*;

import v1.Ihm;
import v1.MoteurEdImpl;

/**
 * Classe copier, implémentation de la command concrète "Copier"
 * @author Eono Quentin, Rebours Gaël
 */
public class Copier implements Command {

	private MoteurEdImpl moteurEdImpl;

	/**
	 * Constructeur de la classe Copier
	 * @param moteurEdImpl moteur de notre application (gère les commandes)
	 */
	public Copier (MoteurEdImpl moteurEdImpl){
		this.moteurEdImpl = moteurEdImpl;
	}

	/**
	 * Méthode execute, fait appel à la méthode "copier" du moteur
	 */
	public void execute() {
		moteurEdImpl.copier();
	}

}