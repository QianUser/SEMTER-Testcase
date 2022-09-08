package testcase.collabtive.v2_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertTrue;
public class LoginUser {

	private WebDriver driver;
	
	@Before
	public void setUp(){
		System.setProperty(Executor.driverProperty, Executor.driverPath);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void runTest() throws InterruptedException {
		driver.get("http://localhost/collabtive/collabtive-2.1/");
		driver.findElement(By.id("username")).sendKeys("username001");
		driver.findElement(By.id("pass")).sendKeys("password001");
		driver.findElement(By.cssSelector("button.loginbutn")).click();

		Thread.sleep(3000);

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("username001"));

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[3]/a")).click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
