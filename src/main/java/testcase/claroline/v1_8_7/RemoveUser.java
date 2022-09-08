package testcase.claroline.v1_8_7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertFalse;

public class RemoveUser {

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
		driver.get("http://localhost/claroline/claroline-1.8.7/");
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.name("submitAuth")).click();

		driver.findElement(By.linkText("Platform Administration")).click();  

		driver.findElement(By.id("search_user")).sendKeys("Smith");
		driver.findElement(By.cssSelector("form[name='searchUser'] > input[type='submit']")).click();

		driver.findElement(By.cssSelector("img[alt='Delete']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);


		assertFalse(driver.findElement(By.tagName("body")).getText().contains("Bert"));

		driver.findElement(By.linkText("Logout")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
