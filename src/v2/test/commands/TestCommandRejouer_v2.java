package v2.test.commands;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import v1.Buffer;
import v1.Ihm;
import v1.MoteurEdImpl;
import v1.PressePapier;
import v1.Selection;
import v1.commands.InserTexte;
import v2.EnregistreurImpl;
import v2.IHMInput;
import v2.commands.Arreter;
import v2.commands.Demarrer;
import v2.commands.Rejouer;
import v2.commands.enregistrable.InsertTexteEnregistrable;


/**
 * Classe de test pour la command rejouer de la v2
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class TestCommandRejouer_v2 {
	
	private MoteurEdImpl moteur;

	private Buffer buffer;

	private Selection selection;

	private PressePapier pressepapier;

	private EnregistreurImpl enregistreur;

	private Arreter arreter;
	
	private Demarrer demarrer;
	
	private Rejouer rejouer;
	
	private InserTexte inserTexte;
	
	private InsertTexteEnregistrable inserTexteEnr;
	
	private IHMInput ihm;
	
	/**
	 * Initialisation des variables avant chaque test
	 */
	@Before
	public void init() {
		ihm = new IHMInput();
		this.buffer = new Buffer();
		this.pressepapier = new PressePapier();
		this.pressepapier.setContenu("");
		this.selection = new Selection(0, 0);
		this.moteur = new MoteurEdImpl();
		this.moteur.setMaSelection(this.selection);
		this.moteur.setMonBuffer(this.buffer);
		this.moteur.setMonPressePapier(this.pressepapier);
		this.enregistreur = new EnregistreurImpl(new IHMInput(),this.moteur);
		this.arreter = new Arreter(enregistreur);
		this.demarrer = new Demarrer(enregistreur);
		this.inserTexteEnr = new InsertTexteEnregistrable(ihm,moteur, enregistreur);
		this.rejouer= new Rejouer(enregistreur);
		this.inserTexte = new InserTexte(ihm, moteur);
	}
	
	/**
	 * Test le contenu du buffer après l'insertion d'un texte et l'exécution de la commande rejouer
	 */
	@Test
	public void testCommandRejouer() {
		
		ihm.setTextInserer("1");
		inserTexte.execute();
		ihm.setTextInserer("2");
		inserTexte.execute();
		ihm.setTextInserer("3");
		inserTexte.execute();
		demarrer.execute();
		ihm.setTextInserer("1");
		inserTexte.execute();
		inserTexteEnr.execute();
		ihm.setTextInserer("2");
		inserTexte.execute();
		inserTexteEnr.execute();
		arreter.execute();
		rejouer.execute();
		
		if(buffer.getZoneTexte().toString().equals("1231212")){
			System.out.println("testCommandRejouer is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testCommandRejouer went wrong /!\\ ");
			fail("testCommandRejouer");
		}
	}
}
