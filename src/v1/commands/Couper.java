package v1.commands;
/***********************************************************************
 * Module:  Couper.java
 * Author:  17009495
 * Purpose: Defines the Class Couper
 ***********************************************************************/

import java.util.*;

import v1.Ihm;
import v1.MoteurEdImpl;

/**
 * Classe couper, implémentation de la command concrète "Couper"
 * @author Eono Quentin, Rebours Gaël
 */
public class Couper implements Command {

	private MoteurEdImpl moteurEdImpl;

	/**
	 * Constructeur de la classe Couper
	 * @param moteurEdImpl moteur de notre application (gère les commandes)
	 */
	public Couper (MoteurEdImpl moteurEdImpl){
		this.moteurEdImpl = moteurEdImpl;
	}

	/**
	 * Méthode execute, fait appel à la méthode "couper" du moteur
	 */
	public void execute() {
		moteurEdImpl.couper();
	}

}