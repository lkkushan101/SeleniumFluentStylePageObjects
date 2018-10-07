package Runner;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.TestsRequirement;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.TestAnnotations;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.WebDriverRunner;

import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
@RunWith(SerenityRunner.class)
public class JUnitRunner {

     WebDriver driver;
	 @Steps
     LoginPage loginUser = new LoginPage(driver);   
	 HomePage homePage = new HomePage(driver);
     @Test
     @Title("Login")
     public void searchSerinityInGoogle() throws IOException {
    	// GIVEN
    	 
    	 WebDriverManager.chromedriver().setup();
		 
		driver = new ChromeDriver();
		WebDriverRunner.setWebDriver(driver);
		
    	//Given
		loginUser.goToPage(driver);
       // WHEN 
    	 loginUser.login();
    	 // THEN
    	 homePage.verifyHomePage();
    	 driver.close();
     }
     
}