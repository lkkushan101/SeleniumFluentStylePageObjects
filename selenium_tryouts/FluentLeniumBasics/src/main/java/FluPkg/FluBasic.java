package FluPkg;
import static org.assertj.core.api.Assertions.assertThat;


import org.fluentlenium.adapter.junit.FluentTest;
import org.junit.Test;

public class FluBasic extends FluentTest {
	 @Test
	    public void google_search() {
	        goTo("https://www.google.lk");
	        $("#lst-ib").fill().with("Selenium");
	        $("#tsf > div.tsf-p > div.jsb > center > input[type=\"submit\"]:nth-child(1)").submit();
	        $("#rso > div:nth-child(1) > div > div:nth-child(1) > div > div > div.r > a").click();
	        assertThat(window().title()).contains("Selenium - Web Browser Automation");
	    }
}
