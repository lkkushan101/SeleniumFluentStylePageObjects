package SeleniumBasics;
import java.nio.file.Paths;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;
import com.testautomationguru.ocular.snapshot.Snap;

@Snap("snapshot.PNG")
public class SearchGoogle {
	
	WebDriver driver;
	OcularResult result;

@Test

	public void testSearch()
	{
	    //Configuring ocular
		Ocular.config()
	    .resultPath(Paths.get(".\\Result\\"))
	    .snapshotPath(Paths.get(".\\Snapshot\\"))
	    .globalSimilarity(95)
	    .saveSnapshot(false);
	
	   
		System.setProperty("webdriver.gecko.driver","C:\\gekhodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.google.lk");
		
		result = compare();
		driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
		
		String webTitle = driver.getTitle();
		System.out.println(result.isEqualsImages());
		System.out.println(result.getSimilarity());
		System.out.println(result.getEqualPixels());
		
		Assert.assertEquals(webTitle, "Selenium - Web Browser Automation");
		driver.close();
		driver.quit();
	}


	public OcularResult compare() {
	    return Ocular.snapshot().from(this)     
	                 .sample().using(driver)   
	                 .compare();     
	}
}
