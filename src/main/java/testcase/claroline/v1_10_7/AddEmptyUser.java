package testcase.claroline.v1_10_7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class AddEmptyUser {

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

		driver.findElement(By.linkText("Create user")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("lastname")).sendKeys("");
		driver.findElement(By.id("firstname")).sendKeys("");
		driver.findElement(By.id("username")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.id("password_conf")).sendKeys("");
		driver.findElement(By.id("student")).click();
		driver.findElement(By.id("applyChange")).click();
		Thread.sleep(2000);

		assertEquals("You left some required fields empty",driver.findElement(By.xpath(".//*[@id='claroBody']/div[1]/div[1]")).getText());

		driver.findElement(By.linkText("Logout")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
