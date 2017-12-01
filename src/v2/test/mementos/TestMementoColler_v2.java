package v2.test.mementos;

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
import v2.commands.enregistrable.CollerEnregistrable;
import v2.mementos.MementoColler;

/**
 * Classe de test pour le memento coller de la v2
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class TestMementoColler_v2 {

	private Buffer buffer;
	private Selection selection;
	private PressePapier pressepapier;
	private MoteurEdImpl moteur;
	private EnregistreurImpl enregistreur;
	private CollerEnregistrable coller;

	/**
	 * Initialisation des receivers, de la commande et de l'enregistreur
	 */
	@Before
	public void init(){
		this.buffer = new Buffer();
		this.pressepapier = new PressePapier();
		this.pressepapier.setContenu("");
		this.selection = new Selection(0, 0);
		this.moteur = new MoteurEdImpl();
		this.moteur.setMaSelection(this.selection);
		this.moteur.setMonBuffer(this.buffer);
		this.moteur.setMonPressePapier(this.pressepapier);
		this.enregistreur = new EnregistreurImpl(new IHMInput(),this.moteur);
		this.coller = new CollerEnregistrable(this.moteur,this.enregistreur);
	}


	@Test
	public void testInstanceMementoCollerGet(){
		if(coller.getMemento() instanceof MementoColler){
			System.out.println("testInstanceMementoCollerGet is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testInstanceMementoCollerGet n'est pas pass� /!\\ ");
			fail("testInstanceMementoCollerGet");
		}

	}

	@Test
	public void testInstanceMementoCollerSet(){
		coller.setMemento();

		if(coller.getMemento() instanceof MementoColler){
			System.out.println("testInstanceMementoCollerSet is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testInstanceMementoCollerSet went wrong /!\\ ");
			fail("testInstanceMementoCollerSet");
		}
	}

}
