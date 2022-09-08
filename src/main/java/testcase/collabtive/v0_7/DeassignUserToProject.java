package testcase.collabtive.v0_7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import runner.Executor;

import static org.junit.Assert.assertFalse;
public class DeassignUserToProject {

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
		driver.get("http://localhost/collabtive/collabtive-0.7/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("pass")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.loginbutn")).click();

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[3]/a")).click();


		driver.findElement(By.linkText("Project001")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='contentwrapper']/div[1]/ul/li[6]/a")).click();


		new Actions(driver).moveToElement(driver.findElement(By.xpath("html/body/div[2]/div[2]/div[2]/div/div/div[3]/div[2]/div[2]/div/div/ul/li[2]/div/table/tbody/tr[1]/td[2]/a/img"))).perform();
//		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(("a.del"))));
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div[2]/div/div/div[3]/div[2]/div[2]/div/div/ul/li[2]/div/table/tbody/tr[1]/td[3]/div/a[1]")).click();
		Thread.sleep(3000);

		new Select(driver.findElement(By.id("assignto"))).selectByVisibleText("admin");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);

		assertFalse(driver.findElement(By.tagName("body")).getText().contains("username001"));

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
