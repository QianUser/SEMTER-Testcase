package testcase.claroline.v1_8_7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class AddCourse {

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

		driver.findElement(By.linkText("Create course")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("course_title")).sendKeys("Math");
		driver.findElement(By.id("course_officialCode")).sendKeys("1");
		new Select(driver.findElement(By.id("course_category"))).selectByVisibleText("(SC) Sciences");



		driver.findElement(By.id("enrolment_true")).click();   
		driver.findElement(By.id("access_true")).click();   
		driver.findElement(By.name("changeProperties")).click();
		Thread.sleep(5000);

		assertEquals("You have just created the course website : 1", driver.findElement(By.xpath("//*[@id='claroBody']/table[1]/tbody/tr/td")).getText());

		driver.findElement(By.linkText("Continue")).click();

		driver.findElement(By.linkText("Logout")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
