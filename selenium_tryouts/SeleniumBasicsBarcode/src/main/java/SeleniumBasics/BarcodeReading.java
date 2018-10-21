package SeleniumBasics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;



public class BarcodeReading {
	
	//WebDriver driver;
	


@Test

	public void Barcode_Selenium() throws NotFoundException, ChecksumException, FormatException, IOException
	{
	    WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://cdn.barcodesinc.com/themes/barcodesinc/images/upc.gif");
		
	
		URL url = new URL("https://cdn.barcodesinc.com/themes/barcodesinc/images/upc.gif");
		BufferedImage barCodeBufferedImage = ImageIO.read(url);

		LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Reader reader = new MultiFormatReader();
		Result result = reader.decode(bitmap);

		System.out.println("Barcode text is " + result.getText());
		
		Assert.assertEquals(result.getText(), "671860013624");
	
		driver.close();
		driver.quit();
	}


}
