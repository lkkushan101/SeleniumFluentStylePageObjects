package PageObject;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends FluentPage  {

	@FindBy(xpath="//h2[@class='barone']")
    private FluentWebElement heading;

	
	public String  getHeadingText()
	{
		
		return heading.text();
		
	}

}
