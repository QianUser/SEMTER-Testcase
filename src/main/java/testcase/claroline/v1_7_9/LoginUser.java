package testcase.claroline.v1_7_9;

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
	public void runTest() throws InterruptedException{
		driver.get("http://localhost/claroline/claroline-1.7.9/");
		driver.findElement(By.id("login")).sendKeys("UserU");
		driver.findElement(By.id("password")).sendKeys("passwordU");
		driver.findElement(By.name("submitAuth")).click();

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("Logout"));

		driver.findElement(By.linkText("Logout")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
