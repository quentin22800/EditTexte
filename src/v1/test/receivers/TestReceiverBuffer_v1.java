package v1.test.receivers;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import v1.Buffer;

/**
 * Classe de test pour le buffer
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class TestReceiverBuffer_v1 {

	private Buffer buffer;
	
	/**
	 * Initialisation du buffer
	 */
	@Before
	public void init(){
		this.buffer = new Buffer();
	}
	
	/**
	 * Test du contenu du buffer après l'insertion de texte
	 */
	@Test
	public void testContenuBuffer(){
		buffer.inserer("Test contenu buffer", 0, 0);
		if(buffer.getZoneTexte().toString().equals("Test contenu buffer")){
			System.out.println("testContenuBuffer is successful !");
			assertTrue(true);
		}
		else{
			System.out.println("testContenuBuffer went wrong /!\\ ");
			fail("testContenuBuffer");
		}
	}
	
	/**
	 * Test du contenu du buffer après deux commande inserer texte consécutives 
	 */
	@Test
	public void testAppendBuffer(){
		buffer.inserer("testAppendBuffer", 0, 0);
		buffer.inserer("append", 16, 22);
		if(buffer.getZoneTexte().toString().equals("testAppendBufferappend")){
			System.out.println("testAppendBuffer is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testAppendBuffer went wrong /!\\ ");
			fail("testAppendBuffer");
		}
	}
	
	/**
	 * Test du contenu du buffer après l'insertion d'un texte "par dessus" un autre texte
	 */
	@Test
	public void testAppendBufferOverPrevious(){
		buffer.inserer("testAppendBuffer", 0, 0);
		buffer.inserer("append", 16, 22);
		buffer.inserer("insertion", 2,10);
		if(buffer.getZoneTexte().toString().equals("teinsertionBufferappend")){
			System.out.println("testAppendBufferOverPrevious is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testAppendBufferOverPrevious went wrong /!\\ ");
			fail("testAppendBufferOverPrevious");
		}
	}
}
