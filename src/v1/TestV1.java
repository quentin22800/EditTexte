package v1;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestV1 {
	
	public Buffer buffer;
	public static MoteurEdImpl moteurEdImpl;
	public Selection selection;
	public PressePapier pressePapier;
	
	public TestV1()
	{
		moteurEdImpl = new MoteurEdImpl();
		buffer = new Buffer();
		selection = new Selection(0,0);
		pressePapier = new PressePapier();
		moteurEdImpl.setMaSelection(selection);
		moteurEdImpl.setMonBuffer(buffer);
		moteurEdImpl.setMonPressePapier(pressePapier);
	}
	
	@Test
	public final void testInsererDebut() {
		
		String texte = "Bonjour les enfants";
		moteurEdImpl.inserTexte(texte);
		
		String res = moteurEdImpl.getMonBuffer().getZoneTexte().toString();
		
		assertTrue(texte.equals(res));
	}
	
	@Test
	public final void testCopier() {
		String texte = "Bonjour les enfants";
		moteurEdImpl.inserTexte(texte);
		moteurEdImpl.selectionner(0, 7);
		moteurEdImpl.copier();
		
		String test = "Bonjour";
		String res = moteurEdImpl.getMonPressePapier().getContenu().toString();
		
		assertTrue(test.equals(res));
	}
	
	@Test
	public final void testColler1() {
		String texte = "Bonjour les enfants";
		moteurEdImpl.inserTexte(texte);
		moteurEdImpl.selectionner(0, 7);
		moteurEdImpl.copier();
		moteurEdImpl.selectionner(8,0);
		moteurEdImpl.coller();
		
		String test = "Bonjour Bonjourles enfants";
		String res = moteurEdImpl.getMonBuffer().getZoneTexte().toString();
		
		assertTrue(test.equals(res));
	}
	
	@Test
	public final void testCouper() {
		String texte = "Bonjour les enfants";
		moteurEdImpl.inserTexte(texte);
		moteurEdImpl.selectionner(0, 7);
		moteurEdImpl.copier();
		moteurEdImpl.selectionner(8,0);
		moteurEdImpl.coller();
		moteurEdImpl.selectionner(8, 7);
		moteurEdImpl.couper();
		
		String test = "Bonjour les enfants";
		String res = moteurEdImpl.getMonBuffer().getZoneTexte().toString();
		
		assertTrue(test.equals(res));
	}
	
	@Test
	public final void testColler2() {
		String texte = "Bonjour les enfants";
		moteurEdImpl.inserTexte(texte);
		moteurEdImpl.selectionner(0, 7);
		moteurEdImpl.copier();
		moteurEdImpl.selectionner(8,0);
		moteurEdImpl.coller();
		moteurEdImpl.selectionner(8, 7);
		moteurEdImpl.couper();
		moteurEdImpl.selectionner(12,0);
		moteurEdImpl.coller();
		
		String test = "Bonjour les Bonjourenfants";
		String res = moteurEdImpl.getMonBuffer().getZoneTexte().toString();
		
		assertTrue(test.equals(res));
	}

}
