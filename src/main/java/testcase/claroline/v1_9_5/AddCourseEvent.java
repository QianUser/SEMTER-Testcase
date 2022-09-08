package testcase.claroline.v1_9_5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class AddCourseEvent {

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

		driver.findElement(By.id("CLCAL")).click();
		Thread.sleep(1000);

		driver.findElement(By.linkText("Add an event")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("title")).sendKeys("Exam 1");
		new Select(driver.findElement(By.id("fday"))).selectByVisibleText("31");
		new Select(driver.findElement(By.id("fmonth"))).selectByVisibleText("May");
		new Select(driver.findElement(By.id("fyear"))).selectByVisibleText("2021");
		driver.findElement(By.id("location")).sendKeys("Genoa");
		driver.findElement(By.name("submitEvent")).click();
		Thread.sleep(2000);

		assertEquals("Event added to the agenda.", driver.findElement(By.xpath(".//*[@id='claroBody']/div[1]/div[1]")).getText());

		driver.findElement(By.linkText("Logout")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
