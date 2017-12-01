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
import v2.commands.Arreter;

/**
 * Classe de test pour la command arreter de la v2
 * @author quentineono
 *
 */
public class TestCommandArreter_v2 {

	private MoteurEdImpl moteur;

	private Buffer buffer;

	private Selection selection;

	private PressePapier pressepapier;

	private EnregistreurImpl enregistreur;

	private Arreter arreter;
	
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
		this.arreter = new Arreter(enregistreur);
	}
	
	@Test
	public void testCommandArreter(){
		arreter.execute();
		
		if(enregistreur.EN_ENREGISTREMENT() == false){
			System.out.println("testCommandArreter is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testCommandArreter went wrong /!\\ ");
			fail("testCommandArreter");
		}
	}
}
