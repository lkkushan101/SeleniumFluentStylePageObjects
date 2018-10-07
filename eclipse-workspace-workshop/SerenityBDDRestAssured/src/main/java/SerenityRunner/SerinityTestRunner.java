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
	private WebServiceUser RESTUser;
	
	
		 @Test
		 @Title("REST Assured Test - US")
		 public void LoginIntoTheWebServiceSendsRequestUS() throws Exception {
		 // GIVEN
		 RESTUser.LoginIntoTheWebServiceSendsRequest("US");

		 // WHEN
		 RESTUser.GetStatusCode200();
		 // THEN
		 RESTUser.ValidateReturned("United States of America");
		
		 }
		 
		 @Test
		 @Title("REST Assured Test - India")
		 public void LoginIntoTheWebServiceSendsRequestIN() throws Exception {
		 // GIVEN
		 RESTUser.LoginIntoTheWebServiceSendsRequest("IN");

		 // WHEN
		 RESTUser.GetStatusCode200();
		 // THEN
		 RESTUser.ValidateReturned("India");
		
		 }


		
}
