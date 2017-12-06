package v3;
/***********************************************************************
 * Module:  MonAppli.java
 * Author:  17009495
 * Purpose: Defines the Class MonAppli
 ***********************************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import v1.Buffer;
import v1.MoteurEdImpl;
import v1.PressePapier;
import v1.Selection;
import v1.commands.Coller;
import v1.commands.Command;
import v1.commands.Copier;
import v1.commands.Couper;
import v1.commands.InserTexte;
import v1.commands.Selectionner;
import v3.commands.Defaire;
import v3.commands.Refaire;

/**
 * Classe MonAppli v2, classe principale
 * @author Eono Quentin, Rebours Gaël
 */
public class MonAppli {

	public static IHMInput iHMInput;
	public static MoteurEdImpl moteurEdImpl;
	public static GestionnaireDRImpl gestionnaireDRImpl;

	/**
	 * Main de la classe MonAppli, initialisation du buffer, de la selection, 
	 * du presse papier, des commandes, des éléments de l'IHM et
	 * implémentation des listeners sur les boutons et du listener sur la souris
	 * pour la séléction
	 * @param args, argument pour le main
	 */
	public static void main(String args[]) {
		iHMInput = new IHMInput();
		moteurEdImpl = new MoteurEdImpl();
		gestionnaireDRImpl = new GestionnaireDRImpl(moteurEdImpl);

		Buffer buffer = new Buffer();
		Selection selection = new Selection(0,0);
		PressePapier pressePapier = new PressePapier();

		InserTexte insererTexte = new InserTexte(iHMInput,moteurEdImpl);
		Couper couper = new Couper(moteurEdImpl);
		Coller coller = new Coller(moteurEdImpl);
		Copier copier = new Copier(moteurEdImpl);
		Selectionner selectionner = new Selectionner(iHMInput, moteurEdImpl);
		Defaire defaire = new Defaire(gestionnaireDRImpl);
		Refaire refaire = new Refaire(gestionnaireDRImpl);

		moteurEdImpl.setMaSelection(selection);
		moteurEdImpl.setMonBuffer(buffer);
		moteurEdImpl.setMonPressePapier(pressePapier);
		moteurEdImpl.addObserver(iHMInput);

		JButton btnRefaire = iHMInput.getButtonRefaire();
		JButton btnDefaire = iHMInput.getButtonDefaire();
		JButton btnCouper = iHMInput.getButtonCouper();
		JButton btnColler = iHMInput.getButtonColler();
		JButton btnCopier = iHMInput.getButtonCopier();
		JTextArea zoneTxt = iHMInput.getTextArea();

		btnCouper.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				//couper.execute();
				executerCommand(couper);
			}

		});

		btnCopier.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				//copier.execute();
				executerCommand(copier);
			}

		});

		btnColler.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				//coller.execute();
				executerCommand(coller);
				iHMInput.getTextArea().setText(moteurEdImpl.getMonBuffer().getZoneTexte().toString());
			}

		});

		btnDefaire.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				executerCommand(defaire);
			}
		});

		btnRefaire.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				executerCommand(refaire);
			}
		});

		
		zoneTxt.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {	
				executerCommand(selectionner);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		zoneTxt.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				char car = e.getKeyChar();
				int ascii = (int) car;
				if(ascii != 8 && ascii != 65535){
					iHMInput.setTextInserer((String.valueOf(car)));
					executerCommand(insererTexte);
				}
			}
		});
	}

	/**
	 * Méthode executerCommand qui execute une commande simple 
	 * @param c, command à executer
	 * 
	 */
	public static void executerCommand(Command c){
		c.execute();
		if(!(c instanceof Defaire) && !(c instanceof Refaire)){
			gestionnaireDRImpl.enregistrerEtat();
		}
		
	}

}