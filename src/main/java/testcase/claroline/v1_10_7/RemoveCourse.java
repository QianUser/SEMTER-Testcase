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

public class RemoveCourse {

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

		Thread.sleep(1000);
		driver.findElement(By.id("search_course")).sendKeys("Math");
		driver.findElement(By.cssSelector("form[name='searchCourse'] > input[type='submit']")).click();

		driver.findElement(By.cssSelector("#Math__1 > img")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);

		assertEquals("The course has been successfully deleted", driver.findElement(By.xpath(".//*[@id='claroBody']/div[1]/div[1]")).getText());

		driver.findElement(By.linkText("Logout")).click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
