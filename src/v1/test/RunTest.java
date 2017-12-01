package v1.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * 
 * @author Eono Quentin, Rebours Gaël
 *
 */
public class RunTest {
	
	/**
	 * Main qui lance tous les test
	 * @param args arguments pour le main
	 */
	public static void main(String[] args) {
		   
	      Result result = JUnitCore.runClasses(Tests.class);
	      
	      System.out.println("\nNumber of successful tests : "+result.getRunCount()+"/"+result.getRunCount());
			
	      if(result.getFailureCount() == 0)
	    	  System.out.println("\nEvery test is successful");
	      else
	    	  if(result.getFailureCount() == 1)
	    		  System.out.println("\nThere is/are "+result.getFailureCount()+" test that went wrong out of "+result.getRunCount());
	    	  
	   }

}
