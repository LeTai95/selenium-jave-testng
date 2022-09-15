package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac OS")) 
		{
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} 
		else 
		{	
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://demo.nopcommerce.com/register");
	}

	@Test
	public void TC_01_ID() {
		driver.findElement(By.id("FirstName")).sendKeys("Automation");
	}

	@Test
	public void TC_02_Class() {
		driver.get("https://demo.nopcommerce.com/search");
		driver.findElement(By.className("search-text")).sendKeys("Iphone14");
	}

	@Test
	public void TC_03_Name() {
		driver.findElement(By.name("advs")).click();
	}

	@Test
	public void TC_04_TagName() {
	
		System.out.println(driver.findElements(By.tagName("input")).size());
	}
	
	@Test
	public void TC_05_LinkText() {
	
		driver.findElement(By.linkText("New products")).click();
	}
	
	@Test
	public void TC_06_PartialLinkText() {
	
		driver.findElement(By.partialLinkText("viewed products")).click();
	}
	
	@Test
	public void TC_07_Css() {
		driver.get("https://demo.nopcommerce.com/register");
		
		//1
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Le Duc");
		//2
		driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys("Tai");
		//3
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("ldtai1205@gmail.com");
	}
	 
	@Test 
	public void TC_08_XPath() {
		driver.get("https://demo.nopcommerce.com/register");
		//1
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Hello");
		//2
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Hi");
		//3
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("ldtai1205@gmail.com");
	}

	
	
	

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}