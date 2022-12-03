package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Default_Dropdown_Redo {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Random rand;
	Select select;
	String emailAddress;

	@BeforeClass
	public void beforeClass(){ 
		if (osName.contains("Mac OS")) 
		{
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} 
		else 
		{	
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}
		driver = new FirefoxDriver();
		rand = new Random();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Dropdown1() {
		
		driver.get("https://demo.nopcommerce.com");
		driver.findElement(By.cssSelector("a.ico-register")).click();
		
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Tester");
		
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
		select.selectByVisibleText("30");
		
		select = new Select(driver.findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]")));
		select.selectByVisibleText("September");
		
		select = new Select(driver.findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]")));
		select.selectByVisibleText("1997");
		
		emailAddress = "automationtester" + rand.nextInt(9999) + "@gmail.com";
		
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("input#Company")).sendKeys("HCM");
		
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
		
		
		driver.findElement(By.cssSelector("button#register-button")).click();
		
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
		
		
		
		driver.findElement(By.cssSelector("a.ico-account")).click();
		
		
		Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), "Automation");
		Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), "Tester");
		
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "30");
		
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "September");
		
		
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "1997");
		
		Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), emailAddress);
		Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"), "HCM");
		
		
		
		
		
		
		
	}

	@Test
	public void TC_02_() {
		sleepInSecond(5);
	}



	@AfterClass
	public void afterClass() {

 	}
 	public void sleepInSecond(long timeInSecond) {
 		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}