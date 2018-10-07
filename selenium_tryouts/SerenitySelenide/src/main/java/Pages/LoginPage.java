package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Selenide.*;

import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import ExcelRead.*;
public class LoginPage {
	
	WebDriver driver;
	ReadExcel excel = new ReadExcel();
	public LoginPage(WebDriver driver )
	{
		this.driver = driver;
	}
	
	  By user99GuruName = By.name("uid");

	  By password99Guru = By.name("password");

	  By titleText = By.className("barone");

	  By login = By.name("btnLogin");
	  
	   //Set user name in textbox

	    public void setUserName(String strUserName){

	     	$(user99GuruName).setValue(strUserName);      

	    }
	    
	    public void setPassword(String strUserName){

	     	$(password99Guru).setValue(strUserName);      

	    }
	    
	    public void clickLogin(){

	     	$(login).click();

	    }
	    
	    public  void goToPage (WebDriver driver)
	    {
	    	
			open("https://demo.guru99.com/v4/");
	    }
	    
	    public void login() throws IOException
	    {
	    	this.setUserName(excel.readExcel(1,1, ".\\Data\\data.xlsx","Sheet1"));
	    	this.setPassword(excel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1"));
	    	this.clickLogin();
	    }

}
