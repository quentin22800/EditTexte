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
import v2.commands.enregistrable.CouperEnregistrable;
import v2.mementos.MementoCouper;

/**
 * Classe de test pour le memento couper de la v2
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class TestMementoCouper_v2 {
	private Buffer buffer;
	private Selection selection;
	private PressePapier pressepapier;
	private MoteurEdImpl moteur;
	private EnregistreurImpl enregistreur;
	private CouperEnregistrable couper;

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
		this.couper = new CouperEnregistrable(this.moteur,this.enregistreur);
	}

	/**
	 * Test l'instance du memento
	 */
	@Test
	public void testInstanceMementoCouperGet(){
		if(couper.getMemento() instanceof MementoCouper){
			System.out.println("testInstanceMementoCouperGet is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testInstanceMementoCouperGet n'est pas pass� /!\\ ");
			fail("testInstanceMementoCouperGet");
		}

	}

	/**
	 * Test l'instance du memento après un setMemento
	 */
	@Test
	public void testInstanceMementoCouperSet(){
		couper.setMemento();

		if(couper.getMemento() instanceof MementoCouper){
			System.out.println("testInstanceMementoCouperSet is successful");
			assertTrue(true);
		}
		else{
			System.out.println("testInstanceMementoCouperSet went wrong /!\\ ");
			fail("testInstanceMementoCouperSet");
		}
	}
}
