package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	 private final WebDriver driver;
    @FindBy(name = "email")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "login")
    private WebElement loginBtn;

    public Login(WebDriver driver) {
    	this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Login launch()
    {
    	  driver.get("http://newtours.demoaut.com/");
    	return this;
    }
    public static Login using(WebDriver driver) {
        return new Login(driver);
    }

    public Login setUsername(String username) {
        this.userName.sendKeys(username);
        return this;
    }

    public Login setPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public void login() {
        this.loginBtn.click();
    }
}
