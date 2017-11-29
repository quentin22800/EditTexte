package v1;
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
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * Classe MonAppli, classe principale
 * @author Eono Quentin, Rebours Gaël
 */
public class MonAppli {

	public static IHMInput iHMInput;
	public static MoteurEdImpl moteurEdImpl;


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

		Buffer buffer = new Buffer();
		Selection selection = new Selection(0,0);
		PressePapier pressePapier = new PressePapier();

		InserTexte insererTexte = new InserTexte(iHMInput,moteurEdImpl);
		Couper couper = new Couper(iHMInput,moteurEdImpl);
		Coller coller = new Coller(iHMInput,moteurEdImpl);
		Copier copier = new Copier(iHMInput,moteurEdImpl);
		Selectionner selectionner = new Selectionner(iHMInput, moteurEdImpl);

		moteurEdImpl.setMaSelection(selection);
		moteurEdImpl.setMonBuffer(buffer);
		moteurEdImpl.setMonPressePapier(pressePapier);
		moteurEdImpl.addObserver(iHMInput);
		// iHMInput.showMaFenetre();

		// JFrame fenetre = iHMInput.getMaFenetre();
		JTextArea zoneTxt = iHMInput.getTextArea();
		JButton btnCouper = iHMInput.getButtonCouper();
		JButton btnColler = iHMInput.getButtonColler();
		JButton btnCopier = iHMInput.getButtonCopier();

		btnColler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				coller.execute();
				iHMInput.getTextArea().setText(moteurEdImpl.getMonBuffer().getZoneTexte().toString());
			}
		});
		btnCopier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				copier.execute();
			}
		});
		btnCouper.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				couper.execute();
			}
		});
		zoneTxt.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				selectionner.execute();

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
				selectionner.execute();

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
				if(ascii != 8 && ascii != 65535 ){
					iHMInput.setTextInserer((String.valueOf(car)));
					insererTexte.execute();
					
				}
			}
		});
	}

}