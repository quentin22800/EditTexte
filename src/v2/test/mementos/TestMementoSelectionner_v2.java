package v2.test.mementos;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import v1.Buffer;
import v1.MoteurEdImpl;
import v1.PressePapier;
import v1.Selection;
import v1.commands.Selectionner;
import v2.EnregistreurImpl;
import v2.IHMInput;
import v2.commands.enregistrable.SelectionnerEnregistrable;
import v2.mementos.MementoSelectionner;


/**
 * Classe de test du memento selectionner de la v2
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class TestMementoSelectionner_v2 {
	private Buffer buffer;
	private Selection selection;
	private PressePapier pressepapier;
	private MoteurEdImpl moteur;
	private EnregistreurImpl enregistreur;
	private SelectionnerEnregistrable selectionnerEnr;
	private IHMInput ihm;

	/**
	 * Initialisation des receivers, de la commande et de l'enregistreur
	 */
	@Before
	public void init(){
		this.ihm = new IHMInput();
		this.buffer = new Buffer();
		this.pressepapier = new PressePapier();
		this.pressepapier.setContenu("");
		this.selection = new Selection(0, 0);
		this.moteur = new MoteurEdImpl();
		this.moteur.setMaSelection(this.selection);
		this.moteur.setMonBuffer(this.buffer);
		this.moteur.setMonPressePapier(this.pressepapier);
		this.enregistreur = new EnregistreurImpl(ihm,this.moteur);
		this.selectionnerEnr = new SelectionnerEnregistrable(ihm, moteur, enregistreur);
	}
	
	@Test
	public void testInstanceMementoSelectionnerGet(){
		if(selectionnerEnr.getMemento() instanceof MementoSelectionner){
			System.out.println("testInstanceMementoSelectionnerGet is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testInstanceMementoSelectionnerGet n'est pas pass� /!\\ ");
			fail("testInstanceMementoSelectionnerGet");
		}

	}

	@Test
	public void testInstanceMementoSelectionnerSet(){
		selectionnerEnr.setMemento();

		if(selectionnerEnr.getMemento() instanceof MementoSelectionner){
			System.out.println("testInstanceMementoCopierSet is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testInstanceMementoCopierSet went wrong /!\\ ");
			fail("testInstanceMementoCopierSet");
		}
	}
	
}
