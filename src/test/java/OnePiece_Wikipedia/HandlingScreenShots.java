package OnePiece_Wikipedia;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
//	@Test(priority = 1)	
	public void captureFullPage() {
		File wiki_page = ts.getScreenshotAs(OutputType.FILE);
		File storeFolder = new File(System.getProperty("user.dir")+"\\CapturedScreeShots\\WikiPage.png");
		wiki_page.renameTo(storeFolder);
	}
	
//	@Test(priority = 2)
	public void captureElement() {
		WebElement onePiece_Poster = driver.findElement(By.xpath("//span[@class='mw-default-size']//img[@class='mw-file-element']"));
		File poster = onePiece_Poster.getScreenshotAs(OutputType.FILE);
		File storeFolder = new File(System.getProperty("user.dir")+"\\CaptureScreenShots\\OnePiecePoster.png");
		poster.renameTo(storeFolder);
	}
	
	@Test(priority = 3)
	public void captureSpecificPlace() {
		//table[@class='infobox']
		WebElement infoPlace = driver.findElement(By.xpath("//span[@class='mw-default-size']//img[@class='mw-file-element']"));
		File info = infoPlace.getScreenshotAs(OutputType.FILE);
		File storeFolder = new File(System.getProperty("user.dir")+"\\CaptureScreenShots\\onePice_Info.png");
		info.renameTo(storeFolder);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
