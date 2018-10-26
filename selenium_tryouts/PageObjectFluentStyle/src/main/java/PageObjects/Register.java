package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {
	  private final WebDriver driver;

	    @FindBy(name = "firstName")
	    private WebElement firstName;

	    @FindBy(name = "lastName")
	    private WebElement lastName;

	    @FindBy(name = "email")
	    private WebElement userName;

	    @FindBy(name = "password")
	    private WebElement password;

	    @FindBy(name = "confirmPassword")
	    private WebElement confirmPassword;

	    @FindBy(name = "register")
	    private WebElement submit;

	    public Register(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public static Register using(WebDriver driver) {
	        return new Register(driver);
	    }

	    public Register launch() {
	        driver.get("http://newtours.demoaut.com/mercuryregister.php");
	        return this;
	    }

	    public Register setFirstName(String firstName) {
	        this.firstName.sendKeys(firstName);
	        return this;
	    }

	    public Register setLastName(String lastName) {
	        this.lastName.sendKeys(lastName);
	        return this;
	    }

	    public Register setUserName(String userName) {
	        this.userName.sendKeys(userName);
	        return this;
	    }

	    public Register setPassword(String password) {
	        this.password.sendKeys(password);
	        return this;
	    }

	    public Register setConfirmPassword(String confirmPassword) {
	        this.confirmPassword.sendKeys(confirmPassword);
	        return this;
	    }

	    public void submit() {
	        this.submit.click();
	    }
}
