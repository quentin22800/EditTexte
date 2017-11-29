package v2;
/***********************************************************************
 * Module:  Arreter.java
 * Author:  17009495
 * Purpose: Defines the Class Arreter
 ***********************************************************************/


import java.util.*;

import v1.Command;
import v1.IHMInput;

/**
 * Classe Arreter, implémentation de la commande concrète "Arreter"
 * @author Eono Quentin, Rebours Gaël
 */
public class Arreter implements Command {

	private EnregistreurImpl enregistreurImpl;

	/**
	 * Constructeur de la classe Arreter
	 * @param enregistreurImpl 
	 */
	public Arreter(EnregistreurImpl enregistreurImpl) {
		this.enregistreurImpl = enregistreurImpl;
	}

	/**
	 * Méthode execute, fait appel à la méthode "arreter" de l'enregistreur
	 */
	public void execute() {
		enregistreurImpl.arreter();
	}

}