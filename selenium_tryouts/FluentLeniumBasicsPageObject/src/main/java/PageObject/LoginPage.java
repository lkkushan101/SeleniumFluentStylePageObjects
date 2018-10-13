package PageObject;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.FindBy;
import JSON.*;
@PageUrl("https://demo.guru99.com/v4/")

public class LoginPage extends FluentPage  {
    JSONReader jsonRead = new JSONReader();
	@FindBy(name="uid")
    private FluentWebElement userNameInput;
	
	@FindBy(name="password")
    private FluentWebElement passwordInput;
	
	@FindBy(name="btnLogin")
    private FluentWebElement loginButton;
	
	public void loginUI() throws FileNotFoundException, IOException, ParseException
	{
		goTo(jsonRead.readJSON("./Data/sel.json", "URL"));
		userNameInput.fill().with(jsonRead.readJSON("./Data/sel.json", "USER"));
		passwordInput.fill().with(jsonRead.readJSON("./Data/sel.json", "PASSWORD"));
		loginButton.click();
	}
}
