package v2;
/***********************************************************************
 * Module:  CouperEnregistrable.java
 * Author:  17009495
 * Purpose: Defines the Class CouperEnregistrable
 ***********************************************************************/

import java.util.*;

import v1.Couper;
import v1.IHMInput;
import v1.Ihm;
import v1.MoteurEdImpl;

/**
 * Classe CouperEnregistrable, étends la commande Couper et implétemente l'interface Enregistrable
 * @author Eono Quentin, Rebours Gaël
 */
public class CouperEnregistrable extends Couper implements Enregistrable {

	private EnregistreurImpl enregistreurImpl;
	private MementoCouper memento;

	/**
	 * Constructeur de la classe CouperEnregistrable
	 * @param iHMInput
	 * @param moteurEdImpl
	 * @param enregistreurImpl
	 */
	public CouperEnregistrable(Ihm iHMInput, MoteurEdImpl moteurEdImpl, EnregistreurImpl enregistreurImpl) {
		super(iHMInput, moteurEdImpl);
		this.enregistreurImpl = enregistreurImpl;
		this.memento = new MementoCouper();
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
	 * @return un nouvel objet MementoCouper
	 */
	public Memento getMemento() {
		// TODO: implement
		return new MementoCouper();
	}

	/**
	 * Setter du memento
	 */
	public void setMemento() {

	}

}