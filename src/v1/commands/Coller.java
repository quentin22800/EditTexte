package v1.commands;
/***********************************************************************
 * Module:  Coller.java
 * Author:  17009495
 * Purpose: Defines the Class Coller
 ***********************************************************************/

import java.util.*;

import v1.Ihm;
import v1.MoteurEdImpl;

/**
 * Classe coller, implémentation de la command concrète "Coller"
 * @author Eono Quentin, Rebours Gaël
 */
public class Coller implements Command {

	private MoteurEdImpl moteurEdImpl;

	/**
	 * Constructeur de la classe Coller
	 * @param iHMInput TO DOOOOOOOOOOOOOOOOOOOOOOOO
	 * @param moteurEdImpl TO DOOOOOOOOOOOOOOOOOOOOOO
	 */
	public Coller (MoteurEdImpl moteurEdImpl){
		this.moteurEdImpl = moteurEdImpl;
	}

	/**
	 * Méthode execute, fait appel à la méthode "coller" du moteur
	 */
	public void execute() {
		moteurEdImpl.coller();
	}

}