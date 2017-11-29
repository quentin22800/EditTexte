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
	private Ihm iHMInput;

	/**
	 * Constructeur de la classe Couper
	 * @param iHMInput TO DOOOOOOOOOOOOOOOOOOOOOOOO
	 * @param moteurEdImpl TO DOOOOOOOOOOOOOOOOOOOOOO
	 */
	public Couper (Ihm iHMInput, MoteurEdImpl moteurEdImpl){
		this.iHMInput = iHMInput;
		this.moteurEdImpl = moteurEdImpl;
	}

	/**
	 * Méthode execute, fait appel à la méthode "couper" du moteur
	 */
	public void execute() {
		moteurEdImpl.couper();
	}

}