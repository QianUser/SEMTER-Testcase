package testcase.claroline.v1_10_7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertFalse;

public class RemoveCourseExerciseQuestions {

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

		driver.findElement(By.xpath("(//img[@alt='Modify'])[2]")).click();

		driver.findElement(By.xpath(".//*[@id='claroBody']/table/tbody/tr[1]/td[6]/a/img")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='claroBody']/table/tbody/tr[1]/td[6]/a/img")).click();
		alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='claroBody']/table/tbody/tr[1]/td[6]/a/img")).click();
		alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);

		driver.navigate().refresh();

		assertFalse(driver.findElement(By.tagName("body")).getText().contains("Question 1"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("Question 2"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("Question 3"));

		driver.findElement(By.linkText("Logout")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
