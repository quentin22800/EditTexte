package v3.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import v3.test.commands.TestCommandDefaire_v3;
import v3.test.commands.TestCommandRefaire_v3;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   TestCommandDefaire_v3.class,
   TestCommandRefaire_v3.class
   
})

/**
 * 
 * @author Eono Quentin, Rebours Gaël
 */
public class Tests {  
	
}  