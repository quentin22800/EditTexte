package v2;
/***********************************************************************
 * Module:  MementoInsertTexte.java
 * Author:  17009495
 * Purpose: Defines the Class MementoInsertTexte
 ***********************************************************************/

import java.util.*;

/**
 * Classe MementoInsertTexte, implémentation de l'interface Memento
 * @author Eono Quentin, Rebours Gaël
 */
public class MementoInsertTexte implements Memento {
	private String s;

	/**
	 * Constructeur du MementoInsertTexte
	 * @param s, contenu string du memento
	 */
	public MementoInsertTexte(String s){
		this.s = s;
	}

	/**
	 * Getter du contenu du MementoInsertTexte
	 * @param s, contenu string du memento
	 */
	public String getTexte(){
		return this.s;
	}

	/**
	 * Setter du MementoInsertTexte
	 * @param s, contenu string à inserer
	 */
	public void setTexte(String s){
		this.s = s;
	}
}