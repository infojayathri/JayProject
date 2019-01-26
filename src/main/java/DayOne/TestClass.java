package DayOne;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {
	
	WebDriver driver;
	
	@BeforeTest
		public void setup()
		{
			
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.google.lk");
		}

	@Test

		public void testSearch()
		{
			driver.findElement(By.name("q")).sendKeys("Selenium");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div/div[1]/a/h3")).click();
			
			String webTitle = driver.getTitle();
			
			Assert.assertEquals(webTitle, "Selenium - Web Browser Automation");
		}

	@AfterTest
		public void tearDown()
		{
			driver.close();
			driver.quit();
		}

}
