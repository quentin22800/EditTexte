package v1;
/***********************************************************************
 * Module:  IHMInput.java
 * Author:  17009495
 * Purpose: Defines the Class IHMInput
 ***********************************************************************/

import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.html.HTMLEditorKit.InsertHTMLTextAction;

import v1.commands.Coller;
import v1.commands.Copier;
import v1.commands.Couper;
import v1.commands.Selectionner;

/**
 * Classe IHMInput, implémentation de l'interface Ihm et de l'interface Observer
 * @author Eono Quentin, Rebours Gaël
 */
public class IHMInput implements Ihm, Observer {

	private JFrame maFenetre;
	private JTextArea textArea;
	private JButton buttonCouper;
	private JButton buttonCopier;
	private JButton buttonColler;
	private boolean updateInsertion;
	private boolean updateSuppression;
	private String texte;
	private JPanel pan = new JPanel();
	private Couper couper;
	private Copier copier;
	private Coller coller;
	private Selectionner selectionner;

	/**
	 * Constructeur de la classe IHMInput, initialisation des variables concernant les éléments de l'interface graphique
	 */
	public IHMInput() {
		super();
		updateInsertion = false;
		updateSuppression = false;
		maFenetre = new JFrame();
		maFenetre.setSize(400,300);
		maFenetre.setLocationRelativeTo(null);

		buttonCouper = new JButton("couper");
		pan.add(buttonCouper);

		buttonCopier = new JButton("copier");
		pan.add(buttonCopier);

		buttonColler = new JButton("coller");
		pan.add(buttonColler);

		textArea = new JTextArea(5, 20);
		pan.add(textArea);
		textArea.setEditable(true);

		maFenetre.setContentPane(pan);
		maFenetre.setVisible(true);
	}


	/**
	 * Getter de l'objet texte inséré
	 * @return texte, texte inséré
	 */
	public String getTextInserer()
	{ 
		return texte;
	}

	/**
	 * Setteur de l'objet texte à insérer
	 * @param texte, texte à inserer
	 */
	public void setTextInserer(String texte)
	{
		this.texte = texte;
	}

	/**
	 * Getter de la JFrame maFenetre
	 * @return maFenetre, objet JFrame de notre IHM
	 */
	public JFrame getMaFenetre() {
		return maFenetre;
	}

	/**
	 * Getter de l'objet textArea
	 * @return textArea, objet JFrame, zone de texte de notre IHM
	 */
	public JTextArea getTextArea() {
		return textArea;
	}

	/**
	 * Getter de la commande Couper
	 * @return couper, commande Couper
	 */
	public Couper getCouper() {
		return couper;
	}

	/**
	 * Setter de la commande Couper
	 * @param couper, commande Couper
	 */
	public void setCouper(Couper couper) {
		this.couper = couper;
	}

	/**
	 * Getter de la commande Copier
	 * @return copier, commande Copier
	 */
	public Copier getCopier() {
		return copier;
	}

	/**
	 * Setter de la commande Copier
	 * @param copier, commande Copier
	 */
	public void setCopier(Copier copier) {
		this.copier = copier;
	}

	/**
	 * Getter de la commande Coller
	 * @return coller, commande Coller
	 */
	public Coller getColler() {
		return coller;
	}

	/**
	 * Setter de la command Coller
	 * @param coller, command Coller
	 */
	public void setColler(Coller coller) {
		this.coller = coller;
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
	 * Getter du booléen updateInsertion
	 * @return updateInsertion, objet booléen
	 */
	public boolean isUpdateInsertion() {
		return updateInsertion;
	}

	/**
	 * Setter du booléen updateInsertion
	 * @param updateInsertion, objet booléen
	 */
	public void setUpdateInsertion(boolean updateInsertion) {
		this.updateInsertion = updateInsertion;
	}

	/**
	 * Getter du booléen updateSuppression
	 * @return updateSuppression, objet booléen
	 */
	public boolean isUpdateSuppression() {
		return updateSuppression;
	}

	/**
	 * Setter du booléen updateSuppression
	 * @param updateSuppression, objet booléen
	 */
	public void setUpdateSuppression(boolean updateSuppression) {
		this.updateSuppression = updateSuppression;
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

}