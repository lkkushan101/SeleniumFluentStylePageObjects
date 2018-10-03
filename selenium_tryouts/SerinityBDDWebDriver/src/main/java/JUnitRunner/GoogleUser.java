package JUnitRunner;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

import net.serenitybdd.core.webdriver.driverproviders.ChromeDriverCapabilities;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
public class GoogleUser {
	WebDriver driver = new ChromeDriver();
	
	@Step("Go to google page")
	
	public void GotoGoogle() {
	 
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver.get("http://www.google.com");
		
		
	}
	@Step("Type search Keyword")
	public void TypeSearchWord() {
		driver.findElement(By.id("lst-ib")).sendKeys("Serinity Test tool");
		driver.findElement(By.xpath("//input[@value='Google Search']")).click();
		
	}
	@Step("Verify search page")
	public void VerifySearch() {
		driver.findElement(By.linkText("Serenity BDD - Automated Acceptance Testing with Style")).click();
		 Assert.assertEquals(driver.getTitle(), "Serenity BDD - Automated Acceptance Testing with Style");
		 driver.close();
		 driver.quit();
	}

}
