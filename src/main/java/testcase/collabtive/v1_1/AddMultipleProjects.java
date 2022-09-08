package testcase.collabtive.v1_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertTrue;
public class AddMultipleProjects {

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
		driver.get("http://localhost/collabtive/collabtive-1.1/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("pass")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.loginbutn")).click();

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[3]/a")).click();


		driver.findElement(By.id("add_butn_myprojects")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("myProject1");
//		driver.switchTo().frame("desc_ifr");
		driver.findElement(By.id("desc_ifr")).sendKeys("");
//		driver.switchTo().defaultContent();
		driver.findElement(By.id("budget")).sendKeys("");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);




		driver.findElement(By.id("add_butn_myprojects")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("myProject2");
//		driver.switchTo().frame("desc_ifr");
		driver.findElement(By.id("desc_ifr")).sendKeys("");
//		driver.switchTo().defaultContent();
		driver.findElement(By.id("budget")).sendKeys("");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);




		driver.findElement(By.id("add_butn_myprojects")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("myProject3");
//		driver.switchTo().frame("desc_ifr");
		driver.findElement(By.id("desc_ifr")).sendKeys("");
//		driver.switchTo().defaultContent();
		driver.findElement(By.id("budget")).sendKeys("");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);




		assertTrue(driver.findElement(By.tagName("body")).getText().contains("myProject1"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("myProject2"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("myProject3"));

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
