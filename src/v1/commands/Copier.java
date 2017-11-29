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
	private Ihm iHMInput;

	/**
	 * Constructeur de la classe Copier
	 * @param iHMInput TO DOOOOOOOOOOOOOOOOOOOOOOOO
	 * @param moteurEdImpl TO DOOOOOOOOOOOOOOOOOOOOOO
	 */
	public Copier (Ihm iHMInput, MoteurEdImpl moteurEdImpl){
		this.iHMInput = iHMInput;
		this.moteurEdImpl = moteurEdImpl;
	}

	/**
	 * Méthode execute, fait appel à la méthode "copier" du moteur
	 */
	public void execute() {
		moteurEdImpl.copier();
	}

}