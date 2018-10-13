package FluPkg;
import static org.assertj.core.api.Assertions.assertThat;


import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

import PageObject.LoginPage;
import PageObject.MainPage;

public class FluBasic extends FluentTest {
	
	@Page
	LoginPage loginPage;
	@Page
	MainPage mainPage;
	
	 @Test
	    public void google_search() {
		    loginPage.goTo(this.loginPage);
	        loginPage.loginUI();
	        assertThat(window().title()).contains("Guru99 Bank Manager HomePage");
	        assertThat(this.mainPage.getHeadingText().contains("Guru99 Bank") );
	     
	        
	    }
}
