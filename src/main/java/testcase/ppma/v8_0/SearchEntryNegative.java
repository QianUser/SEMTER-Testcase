package testcase.ppma.v8_0;

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
		driver.get("http://localhost/ppma/ppma-8.0/");
		driver.findElement(By.id("user")).sendKeys("admin");
		driver.findElement(By.id("pwd")).sendKeys("12345678");
		driver.findElement(By.id("chk")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("srch-term")).sendKeys("NotAnEntry");
		driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/button[2]")).click();
		Thread.sleep(2000);

		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myaccount@google.it"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("www.google.it/mail"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("Email, Google"));

		driver.findElement(By.id("srch-term")).clear();
		driver.findElement(By.id("srch-term")).sendKeys("NotAnEntry@google.it");
		driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/button[2]")).click();
		Thread.sleep(2000);

		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myaccount@google.it"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("www.google.it/mail"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("Email, Google"));

		driver.findElement(By.id("srch-term")).clear();
		driver.findElement(By.id("srch-term")).sendKeys("www.NotAnEntry.it/mail");
		driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div/button[2]")).click();
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
