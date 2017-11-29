package v2;
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
import java.util.*;

import javax.swing.JButton;
import javax.swing.JTextArea;

import v1.Buffer;
import v1.Coller;
import v1.Command;
import v1.Copier;
import v1.Couper;
import v1.InserTexte;
import v1.MoteurEdImpl;
import v1.PressePapier;
import v1.Selection;
import v1.Selectionner;

/**
 * Classe MonAppli v2, classe principale
 * @author Eono Quentin, Rebours Gaël
 */
public class MonAppli {

	public static IHMInput iHMInput;
	public static MoteurEdImpl moteurEdImpl;
	public static EnregistreurImpl enregistreurImpl;

	/**
	 * Main de la classe MonAppli, initialisation du buffer, de la selection, 
	 * du presse papier, des commandes, des éléments de l'IHM et
	 * implémentation des listeners sur les boutons et du listener sur la souris
	 * pour la séléction
	 * @param args
	 */
	public static void main(String args[]) {
		iHMInput = new IHMInput();
		moteurEdImpl = new MoteurEdImpl();
		enregistreurImpl = new EnregistreurImpl(iHMInput,moteurEdImpl);

		Buffer buffer = new Buffer();
		Selection selection = new Selection(0,0);
		PressePapier pressePapier = new PressePapier();

		InserTexte insererTexte = new InserTexte(iHMInput,moteurEdImpl);
		InsertTexteEnregistrable insertTexteEnregistrable = new InsertTexteEnregistrable(iHMInput, moteurEdImpl, enregistreurImpl);
		Couper couper = new Couper(iHMInput,moteurEdImpl);
		CouperEnregistrable couperEnregistrable = new CouperEnregistrable(iHMInput, moteurEdImpl, enregistreurImpl);
		Coller coller = new Coller(iHMInput,moteurEdImpl);
		CollerEnregistrable collerEnregistrable = new CollerEnregistrable(iHMInput, moteurEdImpl, enregistreurImpl);
		Copier copier = new Copier(iHMInput,moteurEdImpl);
		CopierEnregistrable copierEnregistrable = new CopierEnregistrable(iHMInput, moteurEdImpl, enregistreurImpl);
		Selectionner selectionner = new Selectionner(iHMInput, moteurEdImpl);
		SelectionnerEnregistrable selectionnerEnregistrable = new SelectionnerEnregistrable(iHMInput, moteurEdImpl, enregistreurImpl);
		Demarrer demarrer = new Demarrer(enregistreurImpl);
		Arreter arreter = new Arreter(enregistreurImpl);
		Rejouer rejouer = new Rejouer(enregistreurImpl);

		moteurEdImpl.setMaSelection(selection);
		moteurEdImpl.setMonBuffer(buffer);
		moteurEdImpl.setMonPressePapier(pressePapier);
		moteurEdImpl.addObserver(iHMInput);

		JButton btnArreter = iHMInput.getButtonArreter();
		JButton btnDemarrer = iHMInput.getButtonDemarrer();
		JButton btnRejouer = iHMInput.getButtonRejouer();
		JButton btnCouper = iHMInput.getButtonCouper();
		JButton btnColler = iHMInput.getButtonColler();
		JButton btnCopier = iHMInput.getButtonCopier();
		JTextArea zoneTxt = iHMInput.getTextArea();

		btnCouper.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				//couper.execute();
				executerCommand(couper, couperEnregistrable);
			}

		});

		btnCopier.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				//copier.execute();
				executerCommand(copier, copierEnregistrable);
			}

		});

		btnColler.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				//coller.execute();
				executerCommand(coller, collerEnregistrable);
				iHMInput.getTextArea().setText(moteurEdImpl.getMonBuffer().getZoneTexte().toString());
			}

		});

		btnArreter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(enregistreurImpl.EN_ENREGISTREMENT()){
					arreter.execute();
				}
			}
		});

		btnDemarrer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!enregistreurImpl.EN_ENREGISTREMENT()){
					demarrer.execute();
				}
			}
		});

		btnRejouer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!enregistreurImpl.EN_ENREGISTREMENT()){
					rejouer.execute();
				}
			}
		});
		zoneTxt.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {	
				executerCommand(selectionner, selectionnerEnregistrable);
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
					executerCommand(insererTexte, insertTexteEnregistrable);
				}
			}
		});
	}

	/**
	 * Méthode executerCommand qui execute une commande simple et une commande enregistrable si on est 
	 * en mode enregistrement
	 * @param c, command à executer
	 * @param cEnregistrable, command enregistrable
	 */
	public static void executerCommand(Command c, Command cEnregistrable){
		if(enregistreurImpl.EN_ENREGISTREMENT()){
			cEnregistrable.execute();
		}
		c.execute();
	}

}