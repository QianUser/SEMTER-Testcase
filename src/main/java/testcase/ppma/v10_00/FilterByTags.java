package testcase.ppma.v10_00;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class FilterByTags {
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
		driver.get("http://localhost/ppma/ppma-10.00/");
		driver.findElement(By.id("user")).sendKeys("admin");
		driver.findElement(By.id("pwd")).sendKeys("12345678");
		driver.findElement(By.id("chk")).click();
		Thread.sleep(3000);

		driver.findElement(By.linkText("Email")).click();
		Thread.sleep(1000);

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("myaccount1@google.it"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("myaccount2@google.it"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("myaccount3@google.it"));

		driver.findElement(By.linkText("reset filter")).click();
		driver.findElement(By.linkText("Google1")).click();
		Thread.sleep(1000);

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("myaccount1@google.it"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myaccount2@google.it"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myaccount3@google.it"));

		driver.findElement(By.linkText("reset filter")).click();
		driver.findElement(By.linkText("Google2")).click();
		Thread.sleep(1000);

		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myaccount1@google.it"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("myaccount2@google.it"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myaccount3@google.it"));

		driver.findElement(By.linkText("reset filter")).click();
		driver.findElement(By.linkText("Google3")).click();
		Thread.sleep(1000);

		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myaccount1@google.it"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myaccount2@google.it"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("myaccount3@google.it"));

		driver.findElement(By.linkText("reset filter")).click();
		Thread.sleep(1000);

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("myaccount1@google.it"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("myaccount2@google.it"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("myaccount3@google.it"));

		driver.findElement(By.linkText("Log Out")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
