package testcase.ppma.v10_00;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertFalse;
public class SearchEntryNegative {
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

		driver.findElement(By.xpath("//*[@id=\"pwdlist_filter\"]/label/input")).sendKeys("NotAnEntry");

		Thread.sleep(2000);

		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myaccount@google.it"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("www.google.it/mail"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("Email, Google"));

		driver.findElement(By.xpath("//*[@id=\"pwdlist_filter\"]/label/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"pwdlist_filter\"]/label/input")).sendKeys("NotAnEntry@google.it");

		Thread.sleep(2000);

		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myaccount@google.it"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("www.google.it/mail"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("Email, Google"));

		driver.findElement(By.xpath("//*[@id=\"pwdlist_filter\"]/label/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"pwdlist_filter\"]/label/input")).sendKeys("www.NotAnEntry.it/mail");

		Thread.sleep(2000);

		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myaccount@google.it"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("www.google.it/mail"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("Email, Google"));

		driver.findElement(By.linkText("Log Out")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
