package v2;
/***********************************************************************
 * Module:  Rejouer.java
 * Author:  17009495
 * Purpose: Defines the Class Rejouer
 ***********************************************************************/

import java.util.*;

import v1.Command;
import v1.IHMInput;

/**
 * Classe Rejouer, implémentation de la commande concrète "Arreter"
 * @author Eono Quentin, Rebours Gaël
 */
public class Rejouer implements Command {
	
	private EnregistreurImpl enregistreurImpl;
	
	/**
	 * Constructeur de la classe Rejouer
	 * @param enregistreurImpl 
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