package testcase.claroline.v1_9_5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertFalse;

public class RemoveEnrolMultipleUsers {

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
		driver.get("http://localhost/claroline/claroline-1.9.5/");
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.name("submitAuth")).click();

		driver.findElement(By.linkText("1 - Math")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("CLUSR")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='Unregister'])[2]")).click();
		Alert al = driver.switchTo().alert();
		Thread.sleep(1000);
		al.accept();
		Thread.sleep(1000);
		driver.navigate().refresh();

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='Unregister'])[2]")).click();
		al = driver.switchTo().alert();
		Thread.sleep(1000);
		al.accept();
		Thread.sleep(1000);
		driver.navigate().refresh();









		assertFalse(driver.findElement(By.tagName("body")).getText().contains("testuser1"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("testuser2"));


		driver.findElement(By.linkText("Logout")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
