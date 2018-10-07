package Pages;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ExcelRead.*;
public class HomePage {
	WebDriver driver;
	ReadExcel excel = new ReadExcel ();
	public HomePage(WebDriver driver )
	{
		this.driver = driver;
	}
	
	  By homePageUserName = By.xpath("//table//tr[@class='heading3']");
	    

	  //Get the User name from Home Page

      public String getHomePageDashboardUserName(){

       return 	$(homePageUserName).getText();    

       

      }
      
      public void verifyHomePage () throws IOException
      {
    		 assertEquals(excel.readExcel(1,3, ".\\Data\\data.xlsx","Sheet1"), getHomePageDashboardUserName());
    			
   	      
    		  
      }

}
