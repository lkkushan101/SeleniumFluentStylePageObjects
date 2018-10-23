package SeleniumBasics;
import java.awt.image.BufferedImage;
import java.io.File;
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

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;



public class BarcodeReading {
	
	//WebDriver driver;
	


@Test

	public void Barcode_Selenium() throws NotFoundException, ChecksumException, FormatException, IOException
	{
	    WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://4.bp.blogspot.com/-DQclrukGwvM/WKfIFcdOBOI/AAAAAAAAATI/H4j5VQvTfHE4reL56Zm5EYNX5LfvIt5AgCLcB/s1600/testImage.PNG");
		
	
		
		URL url = new URL("https://4.bp.blogspot.com/-DQclrukGwvM/WKfIFcdOBOI/AAAAAAAAATI/H4j5VQvTfHE4reL56Zm5EYNX5LfvIt5AgCLcB/s1600/testImage.PNG");
		
  
		 BufferedImage barCodeBufferedImage = ImageIO.read(url);
		 ITesseract instance = new Tesseract();  
		 instance.setDatapath("C:\\Users\\kam\\selenium_tryouts\\SeleniumBasicsOCR\\Image\\");
		
		  try {  
		      String  result = instance.doOCR(barCodeBufferedImage);  
		       System.out.println(result);
		       Assert.assertEquals(result.trim(), "Create a Youtube metadata crawler using Java");
		    } catch (TesseractException e) {  
		        System.err.println(e.getMessage());  
		        System.out.println("Error while reading image");  
		    }  
		
		 
	
		driver.close();
		driver.quit();
	}


}
