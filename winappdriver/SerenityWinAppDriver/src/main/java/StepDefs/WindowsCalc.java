package StepDefs;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.BDDMockito.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.windows.WindowsDriver;



//import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class WindowsCalc {
	
	
	  private static WindowsDriver CalculatorSession = null;
	  private static WebElement CalculatorResult = null;
	  
	  protected String _GetCalculatorResultText()
	    {
	        // trim extra text and whitespace off of the display value
	        return CalculatorResult.getText().replace("Display is", "").trim();
	    }
	@Test
	@Step
	public void UserOpenedCalculatorApplication() throws MalformedURLException   {
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        CalculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults");
        Assert.assertNotNull(CalculatorResult);
	}
	@Step
	public void WhenUserAddANumberInCalculator() {
		 CalculatorSession.findElementByName("Two").click();
	      CalculatorSession.findElementByName("Plus").click();
	      CalculatorSession.findElementByName("Three").click();
	      CalculatorSession.findElementByName("Equals").click();
		
	}
	@Step 
	public void UserShouldGetValidResult() {
		
		
		Assert.assertEquals("5", _GetCalculatorResultText());
	}

}
