package StepDefs;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.BDDMockito.Then;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.hamcrest.Matchers.*;
import org.hamcrest.core.Is;

//import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class WebServiceUser {
	
	
	String url ="http://services.groupkt.com/country/get/iso2code/";
	HttpResponse<JsonNode> jsonResponse1 ;
	@Test
	@Step
	public void LoginIntoTheWebServiceSendsRequest(String country) throws UnirestException {
		jsonResponse1 
	      = Unirest.get(url+country)
	      .header("accept", "application/json")
	      .asJson();
	}
	@Step
	public void GetStatusCode200() {
		 assertEquals(200, jsonResponse1.getStatus());
		
	}
	@Step 
	public void ValidateReturned(String country) {
		
		
		 Assert.assertTrue(jsonResponse1.getBody().toString().contains(country));
	}

}
