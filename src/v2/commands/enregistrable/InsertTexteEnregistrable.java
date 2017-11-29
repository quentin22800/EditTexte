package v2.commands.enregistrable;
/***********************************************************************
 * Module:  InsertTexteEnregistrable.java
 * Author:  17009495
 * Purpose: Defines the Class InsertTexteEnregistrable
 ***********************************************************************/

import java.util.*;

import v1.IHMInput;
import v1.Ihm;
import v1.MoteurEdImpl;
import v1.commands.InserTexte;
import v2.EnregistreurImpl;
import v2.mementos.Memento;
import v2.mementos.MementoInsertTexte;

/**
 * Classe InsertTexteEnregistrable, étends la commande InserTexte et implétemente l'interface Enregistrable
 * @author Eono Quentin, Rebours Gaël
 */
public class InsertTexteEnregistrable extends InserTexte implements Enregistrable {

	private EnregistreurImpl enregistreurImpl;
	private MementoInsertTexte memento;

	/**
	 * Constructeur de la classe InsertTexteEnregistrable
	 * @param iHMInput
	 * @param moteurEdImpl
	 * @param enregistreurImpl
	 */
	public InsertTexteEnregistrable(Ihm iHMInput, MoteurEdImpl moteurEdImpl, EnregistreurImpl enregistreurImpl) {
		super(iHMInput, moteurEdImpl);
		this.enregistreurImpl = enregistreurImpl;
		this.memento = new MementoInsertTexte("");
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
	 * @return un nouvel objet MementoInserTexte
	 */
	public Memento getMemento() {
		// TODO: implement
		return new MementoInsertTexte(memento.getTexte());
	}

	/**
	 * Setter du memento, met à jour le texte du memento
	 */
	public void setMemento() {
		memento.setTexte(iHMInput.getTextInserer());
	}

}