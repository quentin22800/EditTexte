package v1.commands;
/***********************************************************************
 * Module:  InserTexte.java
 * Author:  17009495
 * Purpose: Defines the Class InserTexte
 ***********************************************************************/

import java.util.*;

import v1.Ihm;
import v1.MoteurEdImpl;

/**
 * Classe InserTexte, implémentation de la commande concrète "InserTexte"
 * @author Eono Quentin, Rebours Gaël
 */
public class InserTexte implements Command {

	private MoteurEdImpl moteurEdImpl;
	protected Ihm iHMInput;
	private String texte;

	/**
	 * Constructeur de la classe InserTexte
	 * @param iHMInput TO DOOOOOOOOOOOOOOOOOOOOOOOO
	 * @param moteurEdImpl TO DOOOOOOOOOOOOOOOOOOOOOO
	 */
	public InserTexte(Ihm iHMInput, MoteurEdImpl moteurEdImpl){
		this.iHMInput = iHMInput;
		this.moteurEdImpl = moteurEdImpl;
		this.texte = "";
	}

	/**
	 * Méthode execute, fait appel à la méthode "inserTexte" du moteur
	 */
	public void execute() {
		
		moteurEdImpl.inserTexte(iHMInput.getTextInserer());
		//moteurEdImpl.inserTexte(texte);
	}
	
	public void setTexte(String texte){
		this.texte = texte;
	}

}