package stepdefs;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import ExtentReport.ExtentReport;
import PageObject.*;
import JSONRead.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import org.apache.log4j.Logger;
import org.arquillian.spacelift.Spacelift;
import org.arquillian.spacelift.task.archive.UnzipTool;
import org.arquillian.spacelift.task.net.DownloadTool;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginScenario {
	     WebDriver driver;

	    Login objLogin;

	    HomePage objHomePage;
	    private final static String CHROMEDRIVER_URL = "https://chromedriver.storage.googleapis.com/2.42/chromedriver_win32.zip";
	    public static final String USER_DIR = "user.dir";
	    public static final String DOWNLOADED_FILES_FOLDER = "downloadFiles";
	    private ScreenRecorder screenRecorder;
	    ExtentReport extRpt = new ExtentReport();
	      
	    JSONReader jsonRead = new JSONReader();
	    Logger log = Logger.getLogger("devpinoyLogger");

	    
	    @Given("^I have user name and password$")
	public void i_have_user_name_and_password() throws Throwable {
		
	    	  WebDriverManager.chromedriver().setup();
			  //  System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		        driver = new ChromeDriver();

		
	        driver = new ChromeDriver();

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
	        
	        driver.get(jsonRead.jsonRead(".\\Data\\sel.json", "URL"));
	        startRecording();
	        log.debug("Navigating to Login Page");
	        extRpt.setUpReport();
	  
	}

	@When("^I successfully login$")
	public void i_successfully_login() throws Throwable {
	  
		   extRpt.startTestCase("User Login");
	
		    objLogin = new Login(driver);

		    //Verify login page title

		   
		    
		    String loginPageTitle = objLogin.getLoginTitle();

		    Assert.assertTrue(loginPageTitle.toLowerCase().contains(jsonRead.jsonRead(".\\Data\\sel.json", "TITLE")));

		    //login to application

		    objLogin.loginToGuru99(jsonRead.jsonRead(".\\Data\\sel.json", "USER_NAME"), jsonRead.jsonRead(".\\Data\\sel.json", "PASSWORD"));
		    log.debug("Entered the user name and password");
		   
		   
		    extRpt.logEvents("Logged Successfully");

	   
	}
	
	@Then("^I should navigate to the home page$")
	public void i_should_navigate_to_the_home_page() throws Throwable {
		 objHomePage = new HomePage(driver);

		    //Verify home page

		 objHomePage = new HomePage(driver);

		    //Verify home page

		    assertThat(objHomePage.getHomePageDashboardUserName().toLowerCase()).isEqualTo("manger id : mgr123");
		   
		    driver.close();
		    extRpt.createFinalReport();
		    log.debug("Creating final report");
		    stopRecording();
		   
	
	}
	
	  public void startRecording() throws Exception
      {    
             File file = new File(".\\Videos\\");
                           
             Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
             int width = screenSize.width;
             int height = screenSize.height;
                            
             Rectangle captureSize = new Rectangle(0,0, width, height);
                            
           GraphicsConfiguration gc = GraphicsEnvironment
              .getLocalGraphicsEnvironment()
              .getDefaultScreenDevice()
              .getDefaultConfiguration();

          this.screenRecorder = new SpecializedScreenRecorder(gc, captureSize,
              new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
              new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                   CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                   DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                   QualityKey, 1.0f,
                   KeyFrameIntervalKey, 15 * 60),
              new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
                   FrameRateKey, Rational.valueOf(30)),
              null, file, "MyVideo");
         this.screenRecorder.start();
      
      }
	 public void stopRecording() throws Exception
     {
       this.screenRecorder.stop();
     }

}
