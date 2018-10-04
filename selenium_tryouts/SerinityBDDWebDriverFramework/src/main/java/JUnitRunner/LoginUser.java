package JUnitRunner;
import ExcelRead.*;
import PageObject.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.assertEquals;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import ExtentReport.ExtentReport;
import net.serenitybdd.core.webdriver.driverproviders.ChromeDriverCapabilities;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
public class LoginUser {
	WebDriver driver = new ChromeDriver();
	ReadExcel excel = new ReadExcel();
	Login loginPage;
	HomePage homePage ;
	ExtentReport extRpt = new ExtentReport();
	 private File getScreenShotAshot = new File (
	            ".\\Screenshots\\loginAshot.png");
	@Step("Go to Login Page")
	
	public void GoToLoginPage() throws IOException {
	 
		   WebDriverManager.chromedriver().setup();
		 
	        driver = new ChromeDriver();

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get(excel.readExcel(1,0, ".\\Data\\data.xlsx","Sheet1"));
	        loginPage = new Login(driver);
	        extRpt.setUpReport();
	}
	@Step("Type User Name and Password")
	public void TypeUserNamePassword() throws IOException {
		extRpt.startTestCase("User Login");
		 
		loginPage.loginToGuru99(excel.readExcel(1,1, ".\\Data\\data.xlsx","Sheet1"), excel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1"));
		
	}
	@Step("Verify home page")
	public void VerifyHomePage() throws IOException {
		 homePage = new HomePage(driver);
		 assertEquals(excel.readExcel(1,3, ".\\Data\\data.xlsx","Sheet1"), homePage.getHomePageDashboardUserName());
		
	      
	    
	        //Take Screenshot of entire page by AShot
	        Screenshot entirePageScreenShot = new AShot().
	                shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
	        //Write Screenshot to a file
	        ImageIO.write(entirePageScreenShot.getImage(),"PNG", getScreenShotAshot);
		 
		 extRpt.logEvents("Logged Successfully");
		 extRpt.createFinalReport();
		 driver.close();
		 driver.quit();
	}

}
