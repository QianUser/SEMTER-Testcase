package testcase.collabtive.v3_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertFalse;
public class RemoveMultipleProjects {

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
		driver.get("http://localhost/collabtive/collabtive-3.0/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("pass")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.loginbutn")).click();

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[3]/a")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody[1]/tr[1]/td[5]/a[2]")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(1000);

		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody[1]/tr[1]/td[5]/a[2]")).click();
		alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(1000);

		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody[1]/tr[1]/td[5]/a[2]")).click();
		alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		driver.navigate().refresh();

		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myProject1"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myProject2"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myProject3"));

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
