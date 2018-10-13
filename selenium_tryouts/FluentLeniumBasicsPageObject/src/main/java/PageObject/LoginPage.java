package PageObject;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("https://demo.guru99.com/v4/")

public class LoginPage extends FluentPage  {

	@FindBy(name="uid")
    private FluentWebElement userNameInput;
	
	@FindBy(name="password")
    private FluentWebElement passwordInput;
	
	@FindBy(name="btnLogin")
    private FluentWebElement loginButton;
	
	public void loginUI()
	{
		userNameInput.fill().with("mngr155951");
		passwordInput.fill().with("rUgYpEz");
		loginButton.click();
	}
}
