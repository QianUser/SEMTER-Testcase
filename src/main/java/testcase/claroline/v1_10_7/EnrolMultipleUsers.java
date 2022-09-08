package testcase.claroline.v1_10_7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertTrue;

public class EnrolMultipleUsers {

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
		driver.findElement(By.id("login")).sendKeys("testuser1");
		driver.findElement(By.id("password")).sendKeys("testuser1");
		driver.findElement(By.name("submitAuth")).click();

		driver.findElement(By.linkText("Enrol on a new course")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("keyword")).sendKeys("Math");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("img[alt='Enrolment']")).click();
		Thread.sleep(1000);

		driver.findElement(By.linkText("Logout")).click();

		driver.findElement(By.id("login")).sendKeys("testuser2");
		driver.findElement(By.id("password")).sendKeys("testuser2");
		driver.findElement(By.name("submitAuth")).click();

		driver.findElement(By.linkText("Enrol on a new course")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("keyword")).sendKeys("Math");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("img[alt='Enrolment']")).click();
		Thread.sleep(1000);

		driver.findElement(By.linkText("Logout")).click();

		driver.findElement(By.id("login")).sendKeys("testuser3");
		driver.findElement(By.id("password")).sendKeys("testuser3");
		driver.findElement(By.name("submitAuth")).click();

		driver.findElement(By.linkText("Enrol on a new course")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("keyword")).sendKeys("Math");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("img[alt='Enrolment']")).click();
		Thread.sleep(1000);

		driver.findElement(By.linkText("Logout")).click();

		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.name("submitAuth")).click();

		driver.findElement(By.linkText("1 - Math")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("CLUSR")).click();

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("testuser1"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("testuser2"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("testuser3"));

		driver.findElement(By.linkText("Logout")).click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
