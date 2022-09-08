package testcase.claroline.v1_7_9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class AddDeniedCourse {

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
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.name("submitAuth")).click();

		driver.findElement(By.linkText("Platform Administration")).click();  

		driver.findElement(By.linkText("Create course")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("title")).sendKeys("Music");
		driver.findElement(By.id("officialCode")).sendKeys("3");
		new Select(driver.findElement(By.id("category"))).selectByVisibleText("(HUMA) Humanities");

		driver.findElement(By.id("courseEnrollAllowed_false")).click();
		driver.findElement(By.name("submitFromCoursProperties")).click();
		Thread.sleep(5000);

		assertEquals("You have just created the course website : 3", driver.findElement(By.xpath("//*[@id='claroBody']/table[1]/tbody/tr/td")).getText());

		driver.findElement(By.linkText("Back to my course list")).click();

		driver.findElement(By.linkText("Logout")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
