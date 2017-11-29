package v2.commands.enregistrable;
/***********************************************************************
 * Module:  CopierEnregistrable.java
 * Author:  17009495
 * Purpose: Defines the Class CopierEnregistrable
 ***********************************************************************/

import java.util.*;

import v1.IHMInput;
import v1.Ihm;
import v1.MoteurEdImpl;
import v1.commands.Copier;
import v2.EnregistreurImpl;
import v2.mementos.Memento;
import v2.mementos.MementoCopier;

/**
 * Classe CopierEnregistrable, étends la commande Copier et implétemente l'interface Enregistrable
 * @author Eono Quentin, Rebours Gaël
 */
public class CopierEnregistrable extends Copier implements Enregistrable {

	private EnregistreurImpl enregistreurImpl;
	private MementoCopier memento;

	/**
	 * Constructeur de la classe CopierEnregistrable
	 * @param iHMInput
	 * @param moteurEdImpl
	 * @param enregistreurImpl
	 */
	public CopierEnregistrable(Ihm iHMInput, MoteurEdImpl moteurEdImpl, EnregistreurImpl enregistreurImpl) {
		super(iHMInput, moteurEdImpl);
		this.enregistreurImpl = enregistreurImpl;
		this.memento = new MementoCopier();
	}

	/**
	 * Getter du memento
	 * @return un nouvel objet MementoCopier
	 */
	public Memento getMemento() {

		return new MementoCopier();
	}

	/**
	 * Setter du memento
	 */
	public void setMemento() {

	}

	/**
	 * Méthode execute, fait appel à la méthode setMemento puis "enregistrer" de l'enregistreur
	 */
	public void execute() {
		setMemento();
		enregistreurImpl.enregistrer(this);
	}

}