package v2.commands;
/***********************************************************************
 * Module:  Demarrer.java
 * Author:  17009495
 * Purpose: Defines the Class Demarrer
 ***********************************************************************/

import java.util.*;

import v1.IHMInput;
import v1.MoteurEdImpl;
import v1.commands.Command;
import v2.EnregistreurImpl;

/**
 * Classe Demarrer, implémentation de la commande concrète "Demarrer"
 * @author Eono Quentin, Rebours Gaël
 */
public class Demarrer implements Command {

	private EnregistreurImpl enregistreurImpl;

	/**
	 * Constructeur de la classe Demarrer
	 * @param enregistreurImpl gestionnaire d'enregistrement des commandes et des mementos
	 */
	public Demarrer(EnregistreurImpl enregistreurImpl) {
		this.enregistreurImpl = enregistreurImpl;
	}


	/**
	 * Méthode execute, fait appel à la méthode "demarrer" de l'enregistreur
	 */
	public void execute() {
		enregistreurImpl.demarrer();
	}

}