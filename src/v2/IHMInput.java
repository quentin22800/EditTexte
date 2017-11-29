package v2;
/***********************************************************************
 * Module:  IHMInput.java
 * Author:  17009495
 * Purpose: Defines the Class IHMInput
 ***********************************************************************/

import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import v1.Ihm;
import v1.MoteurEdImpl;
import v1.commands.Coller;
import v1.commands.Copier;
import v1.commands.Couper;
import v1.commands.InserTexte;
import v1.commands.Selectionner;

/**
 * Classe IHMInput (v2), implémentation de l'interface Ihm v1 et de l'interface Observer
 * @author Eono Quentin, Rebours Gaël
 */
public class IHMInput implements Ihm, Observer{
	private JFrame maFenetre;
	private JTextArea textArea;
	private JButton buttonCouper;
	private JButton buttonCopier;
	private JButton buttonColler;
	private JButton buttonDemarrer;
	private JButton buttonArreter;
	private JButton buttonRejouer;
	private boolean updateInsertion;
	private boolean updateSuppression;
	private String texte;
	private JPanel pan = new JPanel();
	public Couper couper;
	public Copier copier;
	public Coller coller;
	public InserTexte inserTexte;
	public Selectionner selectionner;

	/**
	 * Constructeur de la classe IHMInput, initialisation des variables concernant les éléments de l'interface graphique
	 */
	public IHMInput() {
		super();
		updateInsertion = false;
		updateSuppression = false;
		maFenetre = new JFrame();
		maFenetre.setSize(600,400);
		maFenetre.setLocationRelativeTo(null);

		buttonCouper = new JButton("couper");
		pan.add(buttonCouper);

		buttonCopier = new JButton("copier");
		pan.add(buttonCopier);

		buttonColler = new JButton("coller");
		pan.add(buttonColler);

		buttonDemarrer = new JButton("demarrer");
		pan.add(buttonDemarrer);

		buttonArreter = new JButton("arreter");
		pan.add(buttonArreter);

		buttonRejouer = new JButton("rejouer");
		pan.add(buttonRejouer);

		textArea = new JTextArea(20, 30);
		pan.add(textArea);
		textArea.setEditable(true);

		maFenetre.setContentPane(pan);
		maFenetre.setVisible(true);
	}

	/**
	 * Getter de l'objet texte inséré
	 * @return texte, texte inséré
	 */
	@Override
	public String getTextInserer() {
		return texte;
	}

	/**
	 * Setteur de l'objet texte à insérer
	 * @param texte, texte à inserer
	 */
	@Override
	public void setTextInserer(String texte) {
		this.texte = texte;

	}

	/**
	 * Méthode update de l'interface Observable, met à jour la zone de texte
	 * @param arg0, objet Oberservable, observateur correspondant au moteur
	 * @param arg1, objet String à inserer
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof MoteurEdImpl)
		{
			textArea.setText(arg1.toString());
		}
	}

	/**
	 * Getter de l'objet textArea
	 * @return textArea, objet JFrame, zone de texte de notre IHM
	 */
	@Override
	public JTextArea getTextArea() {
		return textArea;
	}

	/**
	 * Getter du bouton Couper
	 * @return buttonCouper, objet JButton correspondant à la commande Couper
	 */
	public JButton getButtonCouper() {
		return buttonCouper;
	}

	/**
	 * Setter du bouton Couper
	 * @param buttonCouper, objet JButton correspondant à la commande Couper
	 */
	public void setButtonCouper(JButton buttonCouper) {
		this.buttonCouper = buttonCouper;
	}

	/**
	 * Getter du bouton Copier
	 * @return buttonCopier, objet JButton correspondant à la commande Copier
	 */
	public JButton getButtonCopier() {
		return buttonCopier;
	}

	/**
	 * Setter du bouton Copier
	 * @param buttonCopier, objet JButton correspondant à la commande Copier
	 */
	public void setButtonCopier(JButton buttonCopier) {
		this.buttonCopier = buttonCopier;
	}

	/**
	 * Getter du bouton Coller
	 * @return buttonColler, objet JButton correspondant à la commande Coller
	 */
	public JButton getButtonColler() {
		return buttonColler;
	}

	/**
	 * Setter du bouton Coller
	 * @param buttonColler, objet JButton correspondant à la commande Coller
	 */
	public void setButtonColler(JButton buttonColler) {
		this.buttonColler = buttonColler;
	}

	/**
	 * Getter du bouton Demarrer
	 * @return buttonDemarrer, objet JButton correspondant à la commande Demarrer
	 */
	public JButton getButtonDemarrer() {
		return buttonDemarrer;
	}

	/**
	 * Setter du bouton Demarrer
	 * @param buttonDemarrer, objet JButton correspondant à la commande Demarrer
	 */
	public void setButtonDemarrer(JButton buttonDemarrer) {
		this.buttonDemarrer = buttonDemarrer;
	}

	/**
	 * Getter du bouton Arreter
	 * @return buttonArreter, objet JButton correspondant à la commande Arreter
	 */
	public JButton getButtonArreter() {
		return buttonArreter;
	}

	/**
	 * Setter du bouton Arreter
	 * @param buttonArreter, objet JButton correspondant à la commande Arreter
	 */
	public void setButtonArreter(JButton buttonArreter) {
		this.buttonArreter = buttonArreter;
	}

	/**
	 * Getter du bouton Rejouer
	 * @return buttonRejouer, objet JButton correspondant à la commande Rejouer
	 */
	public JButton getButtonRejouer() {
		return buttonRejouer;
	}

	/**
	 * Setter du bouton Rejouer
	 * @param buttonRejouer, objet JButton correspondant à la commande Rejouer
	 */
	public void setButtonRejouer(JButton buttonRejouer) {
		this.buttonRejouer = buttonRejouer;
	}

}