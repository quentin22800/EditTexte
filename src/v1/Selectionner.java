package v1;
/***********************************************************************
 * Module:  Selectionner.java
 * Author:  17009495
 * Purpose: Defines the Class Selectionner
 ***********************************************************************/

import java.util.*;

/**
 * Classe Selectionner, implémentation de la commande concrète "Selectionner"
 * @author Eono Quentin, Rebours Gaël
 */
public class Selectionner implements Command {

	private MoteurEdImpl moteurEdImpl;
	protected Ihm iHMInput;

	/**
	 * Constructeur de la classe Selectionner
	 * @param iHMInput TO DOOOOOOOOOOOOOOOOOOOOOOOO
	 * @param moteurEdImpl TO DOOOOOOOOOOOOOOOOOOOOOO
	 */
	public Selectionner (Ihm iHMInput, MoteurEdImpl moteurEdImpl){
		this.iHMInput = iHMInput;
		this.moteurEdImpl = moteurEdImpl;
	}

	/**
	 * Méthode execute, fait appel à la méthode "selectionner" du moteur
	 */
	public void execute() {
		moteurEdImpl.selectionner(iHMInput.getTextArea().getSelectionStart(), iHMInput.getTextArea().getSelectionEnd()- iHMInput.getTextArea().getSelectionStart());
	}

}