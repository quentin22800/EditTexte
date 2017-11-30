package v1.test.commands;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import v1.Buffer;
import v1.MoteurEdImpl;
import v1.PressePapier;
import v1.Selection;
import v1.commands.Coller;

/**
 * 
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class TestCommandColler_v1 {
	
	Buffer buffer;
	Selection selection;
	PressePapier pressepapier;
	MoteurEdImpl moteur;
	Coller coller;
	
	/**
	 * Initialisation du moteur et des receivers
	 */
	@Before
	public void setup(){
		this.buffer = new Buffer();
		this.pressepapier = new PressePapier();
		this.pressepapier.setContenu("test contenu command coller");
		this.selection = new Selection(0, 27);
		
		this.moteur = new MoteurEdImpl();
		this.moteur.setMaSelection(this.selection);
		this.moteur.setMonBuffer(this.buffer);
		this.moteur.setMonPressePapier(this.pressepapier);
		this.coller = new Coller(this.moteur);
		
		}
	
	/**
	 * Teste l'execute de la command coller et verifie le résultat
	 */
	@Test
	public void testCollerExecuteContenu(){
		coller.execute();
		if(buffer.getZoneTexte().toString().equals("test contenu command coller")){
			System.out.println("testCollerExecuteContenu is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testCollerExecuteContenu went wrong /!\\ ");
			fail("testCollerExecuteContenu");
		}
	}
}
