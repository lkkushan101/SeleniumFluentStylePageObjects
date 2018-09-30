package SeleniumBasics;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;

import com.deque.axe.AXE;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.testng.Assert.assertTrue;

import java.net.URL;
import static org.junit.Assert.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.rules.TestName;


public class SearchGoogle {
	@Rule
	public TestName testName = new TestName();
	//WebDriver driver;
	private static final URL scriptUrl = SearchGoogle.class.getResource("/axe.min.js");


@Test

	public void bankTest()
	{
	    WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/v4/");
		
		JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();

		JSONArray violations = responseJSON.getJSONArray("violations");

		if (violations.length() == 0) {
			assertTrue("No violations found", true);
		} else {
			AXE.writeResults(testName.getMethodName(), responseJSON);
			assertTrue(AXE.report(violations), false);
		}
		
		
	}


}
