package testcase.ppma.v8_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertFalse;
public class RemoveEntry {
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

		driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr[2]/td[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("delbtn")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);

		assertFalse(driver.findElement(By.tagName("body")).getText().contains("Google"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("www.gmail.com/mail1"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myaccount1@gmail.com"));

		driver.findElement(By.linkText("Log Out")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
