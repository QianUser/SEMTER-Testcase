package testcase.claroline.v1_9_5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class AddEmptyCourse {

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

		driver.findElement(By.linkText("Platform administration")).click();

		driver.findElement(By.linkText("Create course")).click();
		Thread.sleep(1000);

		driver.findElement(By.name("changeProperties")).click();
		Thread.sleep(2000);

		assertEquals("Course title needed", driver.findElement(By.xpath(".//*[@id='claroBody']/div[1]/div/span[1]")).getText());
		assertEquals("Course code needed", driver.findElement(By.xpath(".//*[@id='claroBody']/div[1]/div/span[2]")).getText());

		driver.findElement(By.linkText("Logout")).click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
