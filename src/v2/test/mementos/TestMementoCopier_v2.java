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
import v2.commands.enregistrable.CopierEnregistrable;
import v2.mementos.MementoCopier;


/**
 * Classe de test pour le memento copier de la v2
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class TestMementoCopier_v2 {
	private Buffer buffer;
	private Selection selection;
	private PressePapier pressepapier;
	private MoteurEdImpl moteur;
	private EnregistreurImpl enregistreur;
	private CopierEnregistrable copier;

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
		this.copier = new CopierEnregistrable(this.moteur,this.enregistreur);
	}

	/**
	 * Test l'instance du memento
	 */
	@Test
	public void testInstanceMementoCopierGet(){
		if(copier.getMemento() instanceof MementoCopier){
			System.out.println("testInstanceMementoCopierGet is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testInstanceMementoCopierGet n'est pas pass� /!\\ ");
			fail("testInstanceMementoCopierGet");
		}

	}

	/**
	 * Test l'instance du memento après un setMemento
	 */
	@Test
	public void testInstanceMementoCopierSet(){
		copier.setMemento();

		if(copier.getMemento() instanceof MementoCopier){
			System.out.println("testInstanceMementoCopierSet is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testInstanceMementoCopierSet went wrong /!\\ ");
			fail("testInstanceMementoCopierSet");
		}
	}
}
