package v1.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import v1.test.commands.*;
import v1.test.receivers.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   TestCommandColler_v1.class,
   TestCommandCopier_v1.class,
   TestCommandCouper_v1.class,
   TestReceiverBuffer_v1.class,
   TestReceiverMoteurEdImpl_v1.class,
   TestReceiverPressePapier_v1.class,
   TestReceiverSelection_v1.class
   
})

/**
 * 
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class Tests {  
	
}  