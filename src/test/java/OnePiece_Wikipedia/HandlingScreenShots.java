package OnePiece_Wikipedia;

import java.time.Duration;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingScreenShots {
	WebDriver driver;
	TakesScreenshot ts;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://en.wikipedia.org/wiki/One_Piece");
		driver.manage().window().maximize();
		// Initiate ScreeShot interface
		ts = (TakesScreenshot)driver;
	}
	
	@Test(priority = 1)	
	public void captureFullPage() {
		
	}
	
	@Test(priority = 2)
	public void captureSpecificPlace() {
		
	}
	
	@Test(priority = 3)
	public void captureElement() {
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
