package testcase.collabtive.v1_2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class SearchMultipleProjects {

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
	public void runTest() throws InterruptedException {
		driver.get("http://localhost/collabtive/collabtive-1.2/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("pass")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.loginbutn")).click();


		driver.findElement(By.id("query")).sendKeys("myProject");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("fieldset > button[type='submit']")).click();
		Thread.sleep(5000);

		assertEquals("Results (3)", driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[1]/h2")).getText());
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("myProject1"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("myProject2"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("myProject3"));

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
