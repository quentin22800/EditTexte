package v2.commands;
/***********************************************************************
 * Module:  Rejouer.java
 * Author:  17009495
 * Purpose: Defines the Class Rejouer
 ***********************************************************************/

import java.util.*;

import v1.IHMInput;
import v1.commands.Command;
import v2.EnregistreurImpl;

/**
 * Classe Rejouer, implémentation de la commande concrète "Arreter"
 * @author Eono Quentin, Rebours Gaël
 */
public class Rejouer implements Command {
	
	private EnregistreurImpl enregistreurImpl;
	
	/**
	 * Constructeur de la classe Rejouer
	 * @param enregistreurImpl gestionnaire d'enregistrement des commandes et des mementos
	 */
	public Rejouer(EnregistreurImpl enregistreurImpl) {
		this.enregistreurImpl = enregistreurImpl;
	}

	/**
	 * Méthode execute, fait appel à la méthode "arreter" de l'enregistreur
	 */
	public void execute() {
		enregistreurImpl.rejouer();
	}

}