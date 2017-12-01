package v2.commands.enregistrable;
/***********************************************************************
 * Module:  CouperEnregistrable.java
 * Author:  17009495
 * Purpose: Defines the Class CouperEnregistrable
 ***********************************************************************/

import java.util.*;

import v1.IHMInput;
import v1.Ihm;
import v1.MoteurEdImpl;
import v1.commands.Couper;
import v2.EnregistreurImpl;
import v2.mementos.Memento;
import v2.mementos.MementoCouper;

/**
 * Classe CouperEnregistrable, étends la commande Couper et implétemente l'interface Enregistrable
 * @author Eono Quentin, Rebours Gaël
 */
public class CouperEnregistrable extends Couper implements Enregistrable {

	private EnregistreurImpl enregistreurImpl;
	private MementoCouper memento;

	/**
	 * Constructeur de la classe CouperEnregistrable
	 * @param moteurEdImpl moteur de notre application (gère les commandes)
	 * @param enregistreurImpl gestionnaire d'enregistrement des commandes et des mementos
	 */
	public CouperEnregistrable(MoteurEdImpl moteurEdImpl, EnregistreurImpl enregistreurImpl) {
		super(moteurEdImpl);
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