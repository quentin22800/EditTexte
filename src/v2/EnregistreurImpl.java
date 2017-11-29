package v2;
/***********************************************************************
 * Module:  EnregistreurImpl.java
 * Author:  17009495
 * Purpose: Defines the Class EnregistreurImpl
 ***********************************************************************/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import v1.Ihm;
import v1.MoteurEdImpl;
import v1.commands.Coller;
import v1.commands.Command;
import v1.commands.Copier;
import v1.commands.Couper;
import v1.commands.InserTexte;
import v1.commands.Selectionner;
import v2.commands.enregistrable.CollerEnregistrable;
import v2.commands.enregistrable.CopierEnregistrable;
import v2.commands.enregistrable.CouperEnregistrable;
import v2.commands.enregistrable.Enregistrable;
import v2.commands.enregistrable.InsertTexteEnregistrable;
import v2.commands.enregistrable.SelectionnerEnregistrable;
import v2.mementos.Memento;
import v2.mementos.MementoInsertTexte;
import v2.mementos.MementoSelectionner;

/**
 * Classe EnregistreurImpl, implémentation de Enregistreur
 * @author Eono Quentin, Rebours Gaël
 */
public class EnregistreurImpl implements Enregistreur {

	public ArrayList<Memento> mementos;
	public ArrayList<Command> commands;
	private Coller coller;
	private Couper couper;
	private Copier copier;
	private Selectionner selectionner;
	private InserTexte inserTexte;
	private boolean EN_ENREGISTREMENT;
	private Ihm IHMInput;
	private MoteurEdImpl moteurEdImpl;

	/**
	 * Constructeur de la classe EnregistreurImpl,
	 * initialisation des variables
	 */
	public EnregistreurImpl(Ihm IHMInput, MoteurEdImpl moteurEdImpl){
		this.EN_ENREGISTREMENT = false;
		this.commands = new ArrayList<Command>();
		this.mementos = new ArrayList<Memento>();
		this.IHMInput = IHMInput;
		this.moteurEdImpl = moteurEdImpl;
		this.coller = new Coller(IHMInput,moteurEdImpl);
		this.couper = new Couper(IHMInput,moteurEdImpl);
		this.copier = new Copier(IHMInput,moteurEdImpl);
		this.selectionner = new Selectionner(IHMInput,moteurEdImpl);
		this.inserTexte = new InserTexte(IHMInput,moteurEdImpl);
	}

	/**
	 * Méthode demarrer, "lance" le mode enregistrement en passant
	 * le booléen EN_ENREGISTREMENT à true
	 */
	public void demarrer() {
		this.EN_ENREGISTREMENT = true;
		mementos.clear();
		commands.clear();
	}

	/**
	 * Méthode demarrer, "éteint" le mode enregistrement en passant
	 * le booléen EN_ENREGISTREMENT à false
	 */
	public void arreter() {
		this.EN_ENREGISTREMENT = false;
	}

	/**
	 * Méthode rejouer, rejoue toutes les commandes qui ont été enregistrées
	 */
	public void rejouer() {
		for (int i = 0; i < commands.size(); i++){
			Command c = commands.get(i);
			if(c instanceof CollerEnregistrable){
				coller.execute();
			} else if (c instanceof CopierEnregistrable){
				copier.execute();
			} else if (c instanceof CouperEnregistrable){
				couper.execute();
			} else if (c instanceof InsertTexteEnregistrable){
				MementoInsertTexte m = (MementoInsertTexte) mementos.get(i);
				IHMInput.setTextInserer(m.getTexte());
				inserTexte.execute();
				moteurEdImpl.setChange(moteurEdImpl.getMonBuffer().getZoneTexte().toString());
				
			} else if (c instanceof SelectionnerEnregistrable){
				MementoSelectionner m = (MementoSelectionner) mementos.get(i);
				
				int bufferSize = IHMInput.getTextArea().getText().length();
				int longueur = m.getLongueur();
				int positionDebut = m.getDebut();
				
				if(positionDebut > bufferSize){
					IHMInput.getTextArea().setSelectionStart(bufferSize);
					IHMInput.getTextArea().setSelectionEnd(bufferSize);
				} else if ((positionDebut + longueur) > bufferSize){
					IHMInput.getTextArea().setSelectionStart(positionDebut);
					IHMInput.getTextArea().setSelectionEnd(bufferSize);
				} else {
					IHMInput.getTextArea().setSelectionStart(positionDebut);
					IHMInput.getTextArea().setSelectionEnd(positionDebut + longueur);
				}
				selectionner.execute();
			}
			
		}
		
	}

	/**
	 * Méthode enregistrer, 
	 * enregistrer les commandes effectuées en mode "enregistrement" en ajoutant
	 * les commandes dans la collection "commands" et les mementos dans la collection
	 * "mementos"
	 */
	public void enregistrer(Enregistrable c) {
		this.commands.add((Command)c);
		
		this.mementos.add(c.getMemento());
	}

	/**
	 * Getter du booléen EN_ENREGISTREMENT
	 * @return EN_ENREGISTREMENT, booléen qui dit si l'on est en mode "enregistrement"
	 * s'il est true
	 */
	public boolean EN_ENREGISTREMENT() {
		return EN_ENREGISTREMENT;
	}

	/**
	 * Setter du booléen EN_ENREGISTREMENT
	 * @param EN_ENREGISTREMENT, booléen
	 */
	public void setEN_ENREGISTREMENT(boolean EN_ENREGISTREMENT) {
		this.EN_ENREGISTREMENT = EN_ENREGISTREMENT;
	}

}