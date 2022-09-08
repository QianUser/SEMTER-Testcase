package testcase.claroline.v1_8_7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class DoCourseExerciseQuestionsMultipleUsers {

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
		driver.findElement(By.id("login")).sendKeys("testuser1");
		driver.findElement(By.id("password")).sendKeys("testuser1");
		driver.findElement(By.name("submitAuth")).click();

		driver.findElement(By.linkText("1 - Math")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Exercises")).click();

		Thread.sleep(2000);
		driver.findElement(By.linkText("Exercise 1")).click();

		driver.findElement(By.xpath("html/body/div[3]/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]/input")).click();
		driver.findElement(By.xpath("html/body/div[3]/form/table/tbody/tr[5]/td/table/tbody/tr[2]/td[1]/input")).click();
		driver.findElement(By.xpath("html/body/div[3]/form/table/tbody/tr[8]/td/table/tbody/tr[3]/td[1]/input")).click();
		driver.findElement(By.name("cmdOk")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Logout")).click();

		driver.findElement(By.id("login")).sendKeys("testuser2");
		driver.findElement(By.id("password")).sendKeys("testuser2");
		driver.findElement(By.name("submitAuth")).click();

		driver.findElement(By.linkText("1 - Math")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Exercises")).click();

		Thread.sleep(2000);
		driver.findElement(By.linkText("Exercise 1")).click();

		driver.findElement(By.xpath("html/body/div[3]/form/table/tbody/tr[2]/td/table/tbody/tr[1]/td[1]/input")).click();
		driver.findElement(By.xpath("html/body/div[3]/form/table/tbody/tr[5]/td/table/tbody/tr[2]/td[1]/input")).click();
		driver.findElement(By.xpath("html/body/div[3]/form/table/tbody/tr[8]/td/table/tbody/tr[3]/td[1]/input")).click();
		driver.findElement(By.name("cmdOk")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Logout")).click();





















		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.name("submitAuth")).click();

		driver.findElement(By.linkText("1 - Math")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Exercises")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='Statistics'])[2]")).click();

		assertEquals("testuser1 testuser1", driver.findElement(By.xpath(".//*[@id='claroBody']/table[1]/tbody/tr[3]/td[1]/a")).getText());
		assertEquals("-9", driver.findElement(By.xpath(".//*[@id='claroBody']/table[1]/tbody/tr[3]/td[2]")).getText());
		assertEquals("testuser2 testuser2", driver.findElement(By.xpath(".//*[@id='claroBody']/table[1]/tbody/tr[4]/td[1]/a")).getText());
		assertEquals("-3", driver.findElement(By.xpath(".//*[@id='claroBody']/table[1]/tbody/tr[4]/td[2]")).getText());


	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
