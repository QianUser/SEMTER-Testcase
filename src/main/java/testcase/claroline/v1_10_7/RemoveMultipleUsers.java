package testcase.claroline.v1_10_7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class RemoveMultipleUsers {
	
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
		driver.get("http://localhost/claroline/claroline-1.10.7/");
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.name("submitAuth")).click();

		driver.findElement(By.linkText("Platform administration")).click();

		driver.findElement(By.id("search_user")).sendKeys("testuser");
		driver.findElement(By.cssSelector("form[name='searchUser'] > input[type='submit']")).click();

		driver.findElement(By.cssSelector("img[alt='Delete']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);

		driver.navigate().refresh();

		driver.findElement(By.cssSelector("img[alt='Delete']")).click();
		alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);

		driver.navigate().refresh();

		driver.findElement(By.cssSelector("img[alt='Delete']")).click();
		alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
	
		assertEquals("Deletion of the user was done sucessfully", driver.findElement(By.xpath(".//*[@id='claroBody']/div[1]/div[1]")).getText());
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("testuser1"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("testuser2"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("testuser3"));

		driver.findElement(By.linkText("Logout")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
