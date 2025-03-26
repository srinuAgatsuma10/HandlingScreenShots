package flipkartEcommers;

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
	
	public HandlingScreenShots() {
		this.ts = (TakesScreenshot)driver;
	}
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void captureFullPage() {
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
