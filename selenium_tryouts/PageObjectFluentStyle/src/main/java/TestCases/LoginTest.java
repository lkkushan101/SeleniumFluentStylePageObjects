package TestCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObjects.Login;
import PageObjects.Register;
public class LoginTest {
	
@Test
public void TestLogin()
{
	WebDriver driver = new ChromeDriver();
	Register registrationPage = new Register(driver);
	registrationPage.using(driver)
	.launch()
	.setFirstName("Kushan")
	.setLastName("Amarasiri")
	.setPassword("1234")
	.setUserName("kushanlk")
	.setConfirmPassword("1234")
	.submit();
	
	Login loginpage = new Login(driver);
	loginpage.using(driver)
	.launch()
	.setUsername("kushanlk")
	.setPassword("1234")
	.login();
}
	
	
	
}
