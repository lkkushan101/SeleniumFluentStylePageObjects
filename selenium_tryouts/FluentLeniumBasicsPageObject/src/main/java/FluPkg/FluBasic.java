package FluPkg;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import PageObject.LoginPage;
import PageObject.MainPage;

public class FluBasic extends FluentTest {
	
	@Page
	LoginPage loginPage;
	@Page
	MainPage mainPage;
	
	 @Test
	    public void google_search() throws FileNotFoundException, IOException, ParseException {
		    loginPage.goTo(this.loginPage);
	        loginPage.loginUI();
	        assertThat(window().title()).contains("Guru99 Bank Manager HomePage");
	        assertThat(this.mainPage.getHeadingText().contains("Guru99 Bank") );
	     
	        
	    }
}
