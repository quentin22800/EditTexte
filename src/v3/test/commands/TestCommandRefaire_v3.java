package v3.test.commands;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import v1.Buffer;
import v1.MoteurEdImpl;
import v1.PressePapier;
import v1.Selection;
import v3.GestionnaireDRImpl;
import v3.commands.Defaire;
import v3.commands.Refaire;

/**
 * Classe de test de la commande Refaire de la v3
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class TestCommandRefaire_v3 {

	private MoteurEdImpl moteur;

	private Refaire refaire;
	
	private Defaire defaire;

	private Buffer buffer;

	private Selection selection;

	private PressePapier pressepapier;

	private GestionnaireDRImpl gst;

	/**
	 * Initialisation des variable avant chaque test
	 */
	@Before
	public void init() {
		this.buffer = new Buffer();
		this.pressepapier = new PressePapier();
		this.pressepapier.setContenu("");
		this.selection = new Selection(0, 0);
		this.moteur = new MoteurEdImpl();
		this.moteur.setMaSelection(this.selection);
		this.moteur.setMonBuffer(this.buffer);
		this.moteur.setMonPressePapier(this.pressepapier);
		this.gst = new GestionnaireDRImpl(moteur);
		this.refaire = new Refaire(gst);
		this.defaire = new Defaire(gst);
	}

	/**
	 * Test la taille de la pile de refaire avant et après l'éxécution de la commande defaire
	 */
	@Test
	public void testSimpleAfterDefaire(){
		int taillePileBefore = gst.getEtatsRedo().size();
		gst.enregistrerEtat();
		gst.defaire();
		int taillePileAfter = gst.getEtatsRedo().size();

		if(taillePileBefore == 0 && taillePileAfter == 1){
			System.out.println("testSimpleAfterDefaire is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testSimpleAfterDefaire went wrong /!\\ ");
			System.out.println("Taille pile before : " + taillePileBefore);
			System.out.println("Taille pile after : " + taillePileAfter);
			fail("testSimpleAfterDefaire");
		}
	}

	/**
	 * Test du contenu de la pile après l'insertion de texte, l'enregistrement des états puis l'éxuction
	 * de la commande refaire
	 */
	@Test
	public void testContenuPile(){
		moteur.inserTexte("t");
		gst.enregistrerEtat();
		moteur.inserTexte("e");
		gst.enregistrerEtat();
		gst.defaire();
		gst.defaire();
		gst.refaire();
		gst.refaire();

		if(moteur.getMonBuffer().getZoneTexte().toString().equals("te")){
			System.out.println("testContenuPile is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testContenuPile went wrong /!\\ ");
			System.out.println("Contenu buffer : " + moteur.getMonBuffer().getZoneTexte().toString());
			fail("testContenuPile");
		}
	}
}
