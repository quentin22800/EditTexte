package v1.test.receivers;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import v1.Buffer;
import v1.MoteurEdImpl;
import v1.PressePapier;
import v1.Selection;


/**
 * Classe de test du moteur edition implémentation
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class TestReceiverMoteurEdImpl_v1 {

	MoteurEdImpl moteur;

	Buffer buffer;

	Selection selection;

	PressePapier pressepapier;

	/**
	 * Initialisation du buffer et des receivers
	 */
	@Before
	public void setUp(){
		this.selection = new Selection(0,0);
		this.buffer = new Buffer();
		this.pressepapier = new PressePapier();
		this.pressepapier.setContenu("");
		this.moteur = new MoteurEdImpl();
		this.moteur.setMaSelection(this.selection);
		this.moteur.setMonBuffer(this.buffer);
		this.moteur.setMonPressePapier(this.pressepapier);
	}

	/**
	 * Test le contenu du presse papier après l'exécution de la commande Copier
	 */
	@Test
	public void testCommandCopierMoteur() {
		buffer.inserer("testCommandCopierMoteur", 0,0);

		try {
			selection.selectionUpdate(0, 23);
			moteur.copier();
			if(!pressepapier.getContenu().isEmpty() && pressepapier.getContenu().equals("testCommandCopierMoteur")){
				System.out.println("testCommandCopierMoteur is successful");
				assertTrue(true);
			}
			else{
				System.out.println("testCommandCopierMoteur went wrong /!\\");
				fail("testCommandCopierMoteur");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Test le contenu du buffer après l'exécution de la commande Coller
	 */
	@Test
	public void testCommandCollerMoteur() {
		buffer.inserer("", 0,0);
		pressepapier.setContenu("testCommandCollerMoteur");
		moteur.coller();

		if(!buffer.getZoneTexte().toString().isEmpty() && buffer.getZoneTexte().toString().equals("testCommandCollerMoteur")){
			System.out.println("testCommandCollerMoteur is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testCommandCollerMoteur went wrong /!\\");
			fail("testCommandCollerMoteur");
		}
	}

	/**
	 * Test le contenu du presse papier après l'eécution de la commande couper
	 */
	@Test
	public void testCommandCouperMoteur() {
		buffer.inserer("testCommandCouperMoteur", 0,0);
		try {
			selection.selectionUpdate(2, 10);
			moteur.couper();

			if(!pressepapier.getContenu().isEmpty() && pressepapier.getContenu().equals("stCommandC")
					&& buffer.getZoneTexte().toString().equals("teouperMoteur")){
				System.out.println("testCommandCouperMoteur is successful");
				assertTrue(true);
			}
			else{
				System.out.println("testCommandCouperMoteur went wrong /!\\");
				fail("testCommandCouperMoteur");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test le contenu du buffer apès l'exécution de la commande inserer texte
	 */
	@Test
	public void testCommandInsererMoteur(){
		moteur.inserTexte("testCommandInsererMoteur");

		if(buffer.getZoneTexte().toString().equals("testCommandInsererMoteur")){
			System.out.println("testCommandInsererMoteur is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testCommandInsererMoteur went wrong /!\\");
			fail("testCommandInsererMoteur");
		}
	}

	/**
	 * Test le contenu de la selection après l'exécution de la commande selectionner
	 */
	@Test
	public void testCommandSelectionnerMoteur(){
		moteur.selectionner(1, 9);
		
		if(selection.getPositionDebut() == 1 && selection.getLongueur() == 9){
			System.out.println("testCommandSelectionnerMoteur is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testCommandSelectionnerMoteur went wrong /!\\");
			fail("testCommandSelectionnerMoteur");
		}
	}

	/**
	 * Test de le référence de l'objet buffer
	 */
	@Test
	public void testBufferMoteur(){
		if(moteur.getMonBuffer() == this.buffer){
			System.out.println("testBufferMoteur is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testBufferMoteur went wrong /!\\");
			fail("testBufferMoteur");
		}
	}

	/**
	 * Test de la référence de l'objet presse papier
	 */
	@Test
	public void testPressePapierMoteur(){
		if(moteur.getMonPressePapier() == pressepapier){
			System.out.println("testPressePapierMoteur is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testPressePapierMoteur went wrong /!\\");
			fail("testPressePapierMoteur");
		}
	}

	/**
	 * Test de la référence de l'objet selection
	 */
	@Test
	public void testSelectionMoteur(){
		if(moteur.getMaSelection() == selection){
			System.out.println("testSelectionMoteur is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testSelectionMoteur went wrong /!\\");
			fail("testSelectionMoteur");
		}
	}
}
