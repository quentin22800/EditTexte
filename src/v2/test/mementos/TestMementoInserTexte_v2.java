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
import v2.commands.enregistrable.InsertTexteEnregistrable;
import v2.mementos.MementoInsertTexte;

/**
 * Classe de test du memento inserTexte de la v2
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class TestMementoInserTexte_v2 {
	private Buffer buffer;
	private Selection selection;
	private PressePapier pressepapier;
	private MoteurEdImpl moteur;
	private EnregistreurImpl enregistreur;
	private InsertTexteEnregistrable insertTexte;
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
		this.insertTexte = new InsertTexteEnregistrable(ihm, moteur, enregistreur);
	}
	
	/**
	 * Test l'instance du memento
	 */
	@Test
	public void testInstanceMementoInserTexteGet(){
		if(insertTexte.getMemento() instanceof MementoInsertTexte){
			System.out.println("testInstanceMementoInserTexteGet is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testInstanceMementoInserTexteGet n'est pas pass� /!\\ ");
			fail("testInstanceMementoInserTexteGet");
		}

	}

	/**
	 * Test l'instance du memento après un setMemento
	 */
	@Test
	public void testInstanceMementoInserTexteSet(){
		insertTexte.setMemento();

		if(insertTexte.getMemento() instanceof MementoInsertTexte){
			System.out.println("testInstanceMementoInserTexteSet is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testInstanceMementoInserTexteSet went wrong /!\\ ");
			fail("testInstanceMementoInserTexteSet");
		}
	}
}
