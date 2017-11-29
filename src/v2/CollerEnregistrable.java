package v2;
/***********************************************************************
 * Module:  CollerEnregistrable.java
 * Author:  17009495
 * Purpose: Defines the Class CollerEnregistrable
 ***********************************************************************/

import java.util.*;

import v1.Coller;
import v1.IHMInput;
import v1.Ihm;
import v1.MoteurEdImpl;

/**
 * Classe CollerEnregistrable, étends la commande Coller et implétemente l'interface Enregistrable
 * @author Eono Quentin, Rebours Gaël
 */
public class CollerEnregistrable extends Coller implements Enregistrable {

	private EnregistreurImpl enregistreurImpl;
	private MementoColler memento;

	/**
	 * Constructeur de la classe CollerEnregistrable
	 * @param iHMInput
	 * @param moteurEdImpl
	 * @param enregistreurImpl
	 */
	public CollerEnregistrable(Ihm iHMInput, MoteurEdImpl moteurEdImpl, EnregistreurImpl enregistreurImpl) {
		super(iHMInput, moteurEdImpl);
		this.enregistreurImpl = enregistreurImpl;
		this.memento = new MementoColler();
	}

	/**
	 * Méthode execute, fait appel à la méthode setMemento puis "enregistrer" de l'enregistreur
	 */
	public void execute() {
		setMemento();
		enregistreurImpl.enregistrer(this);
	}

	/**
	 * Getter du memento
	 * @return un nouvel objet MementoColler
	 */
	public Memento getMemento() {

		return new MementoColler();
	}

	/**
	 * Setter du memento
	 */
	public void setMemento() {

	}

}