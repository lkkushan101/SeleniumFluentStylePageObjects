package JUnitRunner;

import org.junit.Test;
import org.junit.runner.RunWith;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.TestsRequirement;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.TestAnnotations;
@RunWith(SerenityRunner.class)
public class JUnitRunner {


	 @Steps
	private GoogleUser googleUser;    
     @Test
     @Title("Google")
     public void searchSerinityInGoogle() {
    	// GIVEN
    	 googleUser.GotoGoogle();
    	
    	 // WHEN 
    	 googleUser.TypeSearchWord();
    	 // THEN
         googleUser.VerifySearch();
    	
     }
     
}