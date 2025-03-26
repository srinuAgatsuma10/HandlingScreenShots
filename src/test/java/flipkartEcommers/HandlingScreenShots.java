package flipkartEcommers;

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
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void captureFullPage() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File full_page = ts.getScreenshotAs(OutputType.FILE);
		File folder = new File(System.getProperty("user.dir")+"\\CapturedScreeShots\\E-comFullPage.png");
		full_page.renameTo(folder);
	}
	
	@Test(priority = 2)
	public void captureSpecificPlace() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		WebElement spe_place = driver.findElement(By.xpath("//body/div[@id='container']/div/div[@class='q8WwEU']/div[@class='_3zsGrb']/div[@class='_2-LWwB']/div/div[@class='css-175oi2r']/div[@class='css-175oi2r']/div[@class='css-175oi2r r-13awgt0 r-1iqfa7g r-60vfwk']/div[@class='css-175oi2r r-13awgt0 r-1iqfa7g r-60vfwk']/div[@class='_1ui5b4']/div[@class='yAlKeh']/div[@class='_2L0uxW']/div[@class='_3116_u']/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
		File source_file = spe_place.getScreenshotAs(OutputType.FILE);
		File target_file = new File(System.getProperty("user.dir")+"\\CapturedScreeShots\\E-comSpePage.png");
		source_file.renameTo(target_file);
	}
	
	@Test(priority = 3)
	public void captureWebElement() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		WebElement logo = driver.findElement(By.xpath("//img[@title='Flipkart']"));
		File source_file = logo.getScreenshotAs(OutputType.FILE);
		File target_file = new File(System.getProperty("user.dir")+"\\CapturedScreeShots\\E-comLogo.png");
		source_file.renameTo(target_file);
	
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
