package v2.commands.enregistrable;
/***********************************************************************
 * Module:  SelectionnerEnregistrable.java
 * Author:  17009495
 * Purpose: Defines the Class SelectionnerEnregistrable
 ***********************************************************************/

import java.util.*;

import v1.IHMInput;
import v1.Ihm;
import v1.MoteurEdImpl;
import v1.commands.Selectionner;
import v2.EnregistreurImpl;
import v2.mementos.Memento;
import v2.mementos.MementoSelectionner;

/**
 * Classe SelectionnerEnregistrable, étends la commande Selectionner et implétemente l'interface Enregistrable
 * @author Eono Quentin, Rebours Gaël
 */
public class SelectionnerEnregistrable extends Selectionner implements Enregistrable {

	private EnregistreurImpl enregistreurImpl;
	private MementoSelectionner memento;

	/**
	 * Constructeur de la classe SelectionnerEnregistrable
	 * @param iHMInput
	 * @param moteurEdImpl
	 * @param enregistreurImpl
	 */
	public SelectionnerEnregistrable(Ihm iHMInput, MoteurEdImpl moteurEdImpl, EnregistreurImpl enregistreurImpl) {
		super(iHMInput, moteurEdImpl);
		this.enregistreurImpl = enregistreurImpl;
		this.memento = new MementoSelectionner(0,0);

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
	 * @return un nouvel objet MementoSelectionner
	 */
	public Memento getMemento() {
		return new MementoSelectionner(memento.getDebut(), memento.getLongueur());
	}

	/**
	 * Setter du memento, met à jour le début et la longueur du memento
	 */
	public void setMemento() {
		memento.setDebut(iHMInput.getTextArea().getSelectionStart());
		memento.setLongueur(iHMInput.getTextArea().getSelectionEnd()- iHMInput.getTextArea().getSelectionStart());
	}

}