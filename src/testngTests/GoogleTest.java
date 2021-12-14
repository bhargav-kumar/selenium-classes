package testngTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import testNGListeners.TestNGISuiteListenerTest;

@Listeners(TestNGISuiteListenerTest.class)
public class GoogleTest {

	WebDriver driver;
	
	@BeforeTest
	public void intialization() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/chbha/Downloads/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(priority=1)
	public void yahooTest() {
		driver.get("https://in.search.yahoo.com/?fr2=inr");
		driver.findElement(By.id("yschsp")).sendKeys("Selenium");
	}
	
	@Test(priority=2)
	public void facebookTest() {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("Selenium");
	}
	
	@Test(priority=3)
	public void googleTest() {
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.linkText("Gmail")).click();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
