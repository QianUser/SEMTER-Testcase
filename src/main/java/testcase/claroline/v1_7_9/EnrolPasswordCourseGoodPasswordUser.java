package testcase.claroline.v1_7_9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class EnrolPasswordCourseGoodPasswordUser {

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

		driver.findElement(By.linkText("Enrol on a new course")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("keyword")).sendKeys("Society");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("a > img")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("enrollmentKey")).sendKeys("password");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);

		assertEquals("You've been enrolled on the course", driver.findElement(By.xpath("//*[@id='claroBody']/blockquote/table/tbody/tr/td/p[1]")).getText());

		driver.findElement(By.linkText("Logout")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
