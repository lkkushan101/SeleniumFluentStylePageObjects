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

import java.io.IOException;
import java.io.PrintWriter;
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
    ExcelRead read = new ExcelRead();

@Test

	public void bankTest() throws IOException
	{
	 
	
	    WebDriver driver;
		System.setProperty("webdriver.chrome.driver",".\\Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		
		for (int i = 1; i <= read.getRowCount(".\\Data\\Book1.xlsx", "Sheet1");i++)
		{
			
			driver.get(read.readExcel(i, 0, ".\\Data\\Book1.xlsx", "Sheet1"));
			
			JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();

			JSONArray violations = responseJSON.getJSONArray("violations");
			if (violations.length() == 0) {
				assertTrue("No violations found", true);
			} else {
				AXE.writeResults(testName.getMethodName(), responseJSON);
				
				PrintWriter writer = new PrintWriter(".\\Report\\Rep_" +i+ ".txt", "UTF-8");
				writer.println(AXE.report(violations));
			
				writer.close();
			}
		
			
		}
		
	}


}
