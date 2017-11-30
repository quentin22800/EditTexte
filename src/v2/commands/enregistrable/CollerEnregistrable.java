package v2.commands.enregistrable;
/***********************************************************************
 * Module:  CollerEnregistrable.java
 * Author:  17009495
 * Purpose: Defines the Class CollerEnregistrable
 ***********************************************************************/

import java.util.*;

import v1.IHMInput;
import v1.Ihm;
import v1.MoteurEdImpl;
import v1.commands.Coller;
import v2.EnregistreurImpl;
import v2.mementos.Memento;
import v2.mementos.MementoColler;

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
	public CollerEnregistrable(MoteurEdImpl moteurEdImpl, EnregistreurImpl enregistreurImpl) {
		super(moteurEdImpl);
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