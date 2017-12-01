package v2.test.commands;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import v1.Buffer;
import v1.MoteurEdImpl;
import v1.PressePapier;
import v1.Selection;
import v2.EnregistreurImpl;
import v2.IHMInput;
import v2.commands.Demarrer;

/**
 * Classe de test pour la commande demarrer de la v2
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class TestCommandDemarrer_v2 {
	
	private MoteurEdImpl moteur;
	
	private Buffer buffer;

	private Selection selection;

	private PressePapier pressepapier;

	private EnregistreurImpl enregistreur;

	private Demarrer demarrer;

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
		this.enregistreur = new EnregistreurImpl(new IHMInput(),this.moteur);
		this.demarrer = new Demarrer(enregistreur);
	}
	
	@Test
	public void testCommandDemarrer(){
		demarrer.execute();
		
		if(enregistreur.EN_ENREGISTREMENT() == true){
			System.out.println("testCommandDemarrer is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testCommandDemarrer went wrong /!\\ ");
			fail("testCommandDemarrer");
		}
	}
}
