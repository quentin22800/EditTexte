package v1.test.commands;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import v1.Buffer;
import v1.MoteurEdImpl;
import v1.PressePapier;
import v1.Selection;
import v1.commands.Couper;

/**
 * 
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class TestCommandCouper_v1 {
	Buffer buffer;
	Selection selection;
	PressePapier pressepapier;
	MoteurEdImpl moteur;
	Couper couper;
	

	/**
	 * Initialisation du moteur et des receivers
	 */
	@Before
	public void setup(){
		this.buffer = new Buffer();
		buffer.inserer("test contenu command couper", 0, 0);
		this.pressepapier = new PressePapier();
		this.pressepapier.setContenu("");
		this.selection = new Selection(0, 27);
		this.moteur = new MoteurEdImpl();
		this.moteur.setMaSelection(this.selection);
		this.moteur.setMonBuffer(this.buffer);
		this.moteur.setMonPressePapier(this.pressepapier);
		this.couper = new Couper(this.moteur);
		}
	
	
	/**
	 * Teste l'execute de la command couper et verifie le résultat
	 */
	@Test
	public void testExecuteCouper(){
		couper.execute();
		if(pressepapier.getContenu().equals("test contenu command couper") && !buffer.getZoneTexte().toString().equals("test contenu command couper")){
			System.out.println("testCollerExecuteContenu is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testCollerExecuteContenu went wrong /!\\ ");
			fail("testCollerExecuteContenu");
		}
	}
}
