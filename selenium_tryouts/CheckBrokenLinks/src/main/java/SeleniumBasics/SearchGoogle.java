package SeleniumBasics;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.arquillian.extension.recorder.screenshooter.Screenshooter;
import org.arquillian.extension.recorder.screenshooter.ScreenshotType;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.json.simple.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.openqa.selenium.chrome.ChromeOptions;

public class SearchGoogle {
	
	WebDriver driver;
	


@Test

	public void testSearch() throws FileNotFoundException, IOException, ParseException
	{
	    JSONParser parser = new JSONParser();
	    WebDriver driver;
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
	  
	    
	    Object obj = parser.parse(new FileReader(".\\Data\\sel.json"));

	      JSONObject jsonObject = (JSONObject) obj;
	     String url = (String) jsonObject.get("URL");
	     driver.get(url);

	     Map<Boolean, List<String>> map= driver.findElements(By.xpath("//*[@href]"))  // find all elements which has href attribute
                 .stream()
                 .map(ele -> ele.getAttribute("href"))   // get the value of href
                 .map(String::trim)                      // trim the text
                 .distinct()                             // there could be duplicate links , so find unique
                 .collect(Collectors.partitioningBy(link -> CheckBrokenLinks.getResponseCode(link) == 200));
	 
	     System.out.println("Successfull Links" );
	    map.get(true)
	    .stream()
	    .forEach(System.out::println);
	    
	    System.out.println("Broken Links" );
	    map.get(false)
	    .stream()
	    .forEach(System.out::println); 
	    driver.close();
		driver.quit();
	}


}
