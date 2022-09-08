package testcase.claroline.v1_7_9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class ViewProfileStatisticsUser {

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

		driver.findElement(By.linkText("My User Account")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='claroBody']/p/a")).click();

		driver.findElement(By.xpath("//*[@id='claroBody']/ul/li/a")).click();
		Thread.sleep(3000);

		driver.findElement(By.linkText("Show all")).click();  

		assertEquals("Exercise 1", driver.findElement(By.xpath("//*[@id='claroBody']/table[2]/tbody[2]/tr/td[1]/a")).getText());  
		assertEquals("9", driver.findElement(By.xpath("//*[@id='claroBody']/table[2]/tbody[2]/tr/td[3]")).getText());  

		driver.findElement(By.linkText("Logout")).click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
