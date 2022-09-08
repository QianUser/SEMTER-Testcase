package testcase.collabtive.v1_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertFalse;
public class AddUserEmptyValues {

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
		driver.get("http://localhost/collabtive/collabtive-1.0/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("pass")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.loginbutn")).click();

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[3]/a")).click();


		driver.findElement(By.xpath(".//*[@id='contentwrapper']/div[1]/ul/li[2]/a")).click();


		driver.findElement(By.id("add_butn_member")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("username002");
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/div/form/fieldset/div[11]/div/button")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		driver.navigate().refresh();

		assertFalse(driver.findElement(By.tagName("body")).getText().contains("username002"));

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
