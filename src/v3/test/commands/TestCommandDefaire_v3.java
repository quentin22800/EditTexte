package v3.test.commands;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import v1.Buffer;
import v1.MoteurEdImpl;
import v1.PressePapier;
import v1.Selection;
import v1.commands.InserTexte;
import v3.GestionnaireDRImpl;
import v3.commands.Defaire;

/**
 * Classe de test pour la commande defaire de la v3
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class TestCommandDefaire_v3 {

	private MoteurEdImpl moteur;
	
	private Defaire defaire;

	private Buffer buffer;

	private Selection selection;

	private PressePapier pressepapier;
	
	private GestionnaireDRImpl gst;
	
	
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
		this.defaire = new Defaire(gst);
	}
	
	/**
	 * Test de la taille de la pile avant et après l'éxecution d'un enregistrement
	 */
	@Test
	public void testSimpleEnregistrementDefaire(){
		int taillePileBefore = gst.getEtatsUndo().size();
		gst.enregistrerEtat();
		int taillePileAfter = gst.getEtatsUndo().size();
		
		if(taillePileBefore == 0 && taillePileAfter == 1){
			System.out.println("testSimpleEnregistrementDefaire is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testSimpleEnregistrementDefaire went wrong /!\\ ");
			System.out.println("Taille pile before : " + taillePileBefore);
			System.out.println("Taille pile after : " + taillePileAfter);
			fail("testSimpleEnregistrementDefaire");
		}
	}
	
	/**
	 * Test du contenu de la pile après l'insertion de texte, l'enregistrement des états puis l'éxuction
	 * de la commande defaire
	 */
	@Test
	public void testContenuPileAfterInsererTexte(){
		moteur.inserTexte("t");
		gst.enregistrerEtat();
		moteur.inserTexte("e");
		gst.enregistrerEtat();
		gst.defaire();
		gst.defaire();
		
		if(moteur.getMonBuffer().getZoneTexte().toString().equals("t")){
			System.out.println("testContenuPileAfterInsererTexte is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testContenuPileAfterInsererTexte went wrong /!\\ ");
			System.out.println("Contenu buffer : " + moteur.getMonBuffer().getZoneTexte().toString());
			fail("testContenuPileAfterInsererTexte");
		}
	}
}
