package StepDefs;
import static org.hamcrest.Matchers.hasSize;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.BDDMockito.Then;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import org.hamcrest.Matchers.*;
import org.hamcrest.core.Is;

//import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class WebServiceUser {
	private Response response; 
	@Test
	@Step
	public void LoginIntoTheWebServiceSendsRequest(String countryCode) {
		response = RestAssured.get("http://services.groupkt.com/country/get/iso2code/"+countryCode); 
		
	}
	@Step
	public void GetStatusCode200() {
		response.then().statusCode(200); 
		
	}
	@Step 
	public void ValidateReturned(String country) {
		//response.then().body("RestResponse.result.name",  );

		 Assert.assertTrue(response.asString().contains(country));
	}

}
