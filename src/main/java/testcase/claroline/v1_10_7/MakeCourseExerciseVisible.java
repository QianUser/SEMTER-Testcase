package testcase.claroline.v1_10_7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class MakeCourseExerciseVisible {
	
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

		driver.findElement(By.linkText("1 - Math")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("CLQWZ")).click();

		assertEquals("Make visible",  driver.findElement(By.xpath(".//*[@id='claroBody']/table/tbody/tr[2]/td[4]/a/img")).getAttribute("alt"));

		driver.findElement(By.xpath("(//img[@alt='Make visible'])[2]")).click();
		Thread.sleep(1000);

		assertEquals("Make invisible", driver.findElement(By.xpath(".//*[@id='claroBody']/table/tbody/tr[2]/td[4]/a/img")).getAttribute("alt"));

		driver.findElement(By.linkText("Logout")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
