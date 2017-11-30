package v1.test.receivers;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import v1.PressePapier;

/**
 * Classe de test pour le presse papier
 * @author quentineono
 *
 */
public class TestReceiverPressePapier_v1 {

	
	private PressePapier pressepapier;
	
	/**
	 * Initialisation du PressePapier
	 */
	@Before
	public void init(){
		this.pressepapier = new PressePapier();
		this.pressepapier.setContenu("");
	}
	
	@Test
	public void testContenuPressePapier(){
		pressepapier.setContenu("test contenu presse papier");
		
		if(pressepapier.getContenu().equals("test contenu presse papier")){
			System.out.println("testContenuPressePapier is successfuls");
			assertTrue(true);
		}
		else{
			System.out.println("testContenuPressePapier went wrong /!\\");
			fail("testContenuPressePapier");
		}
	}
	
}
