package JUnitRunner;
import ExcelRead.*;

import java.io.IOException;

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
	ReadExcel excel = new ReadExcel();
	@Step("Go to google page")
	
	public void GotoGoogle() throws IOException {
	 
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		driver.get(excel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1"));
		
		
	}
	@Step("Type search Keyword")
	public void TypeSearchWord() throws IOException {
		driver.findElement(By.id("lst-ib")).sendKeys(excel.readExcel(1,0, ".\\Data\\data.xlsx","Sheet1"));
		driver.findElement(By.xpath("//input[@value='Google Search']")).click();
		
	}
	@Step("Verify search page")
	public void VerifySearch() throws IOException {
		driver.findElement(By.linkText(excel.readExcel(1,1, ".\\Data\\data.xlsx","Sheet1"))).click();
		 Assert.assertEquals(driver.getTitle(),excel.readExcel(1,1, ".\\Data\\data.xlsx","Sheet1"));
		 driver.close();
		 driver.quit();
	}

}
