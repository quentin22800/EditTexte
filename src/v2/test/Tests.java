package v2.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import v2.test.commands.*;
import v2.test.mementos.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   TestCommandArreter_v2.class,
   TestCommandDemarrer_v2.class,
   TestCommandRejouer_v2.class,
   TestMementoColler_v2.class,
   TestMementoCopier_v2.class,
   TestMementoCouper_v2.class,
   TestMementoInserTexte_v2.class,
   TestMementoSelectionner_v2.class
   
})

/**
 * 
 * @author Eono Quentin, Rebours Gaël
 */
public class Tests {  
	
}  