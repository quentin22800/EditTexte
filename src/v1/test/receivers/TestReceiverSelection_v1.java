package v1.test.receivers;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import v1.Selection;


/**
 * Classe de test pour la sélection
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class TestReceiverSelection_v1 {
	private Selection selection;
	
	/**
	 * Initialisation de la sélection
	 */
	@Before
	public void init(){
		this.selection = new Selection(0,0);		
	}
	
	@Test 
	public void testUpdateSelection(){
		try {
			selection.selectionUpdate(2, 10);
			if(selection.getPositionDebut() == 2 && selection.getLongueur() == 10){
				System.out.println("testUpdateSelection is successful");
				assertTrue(true);
			}
			else{
				System.out.println("testUpdateSelection went wrong /!\\");
				fail("testUpdateSelection");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	@Test
	public void testPositionDebut(){
		try {
			selection.selectionUpdate(10, 100);
			if(selection.getPositionDebut() == 10){
				System.out.println("testPositionDebut is successful");
				assertTrue(true);
			}
			else{
				System.out.println("testPositionDebut went wrong /!\\");
				fail("testPositionDebut");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testLongueur(){
		try {
			selection.selectionUpdate(10, 12);
			if(selection.getLongueur() == 12){
				System.out.println("testLongueur is successful");
				assertTrue(true);
			}
			else{
				System.out.println("testLongueur went wrong /!\\");
				fail("testLongueur");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPositionFin(){
		try{
			int positionFin = 30;
			selection.selectionUpdate(10, 20);
			if(selection.getPositionDebut()+selection.getLongueur() == positionFin){
				System.out.println("testPositionFin is successful");
				assertTrue(true);
			} else {
				System.out.println("testPositionFin went wrong /!\\");
				fail("testPositionFin");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
