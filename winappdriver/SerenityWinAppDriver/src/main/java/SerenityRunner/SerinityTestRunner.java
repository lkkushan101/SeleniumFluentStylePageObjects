package SerenityRunner;
import StepDefs.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.TestsRequirement;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.TestAnnotations; 
@RunWith(SerenityRunner.class) 

public class SerinityTestRunner {

	@Steps 
	private WindowsCalc CalcUser;
	
	
		 @Test
		 @Title("REST Assured Test")
		 public void LoginIntoTheWebServiceSendsRequestUS() throws Exception {
		 // GIVEN
			 CalcUser.UserOpenedCalculatorApplication();

		 // WHEN
			 CalcUser.WhenUserAddANumberInCalculator();
		 // THEN
			 CalcUser.UserShouldGetValidResult();
		
		 }
		 
		
		
		


		
}
