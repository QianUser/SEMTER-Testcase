package testcase.collabtive.v1_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
public class AddAndRemoveLateMilestone {

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


		driver.findElement(By.linkText("Project001")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='contentwrapper']/div[1]/ul/li[2]/a")).click();


		driver.findElement(By.id("add_butn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Milestone002");
		driver.findElement(By.id("end")).clear();
		driver.findElement(By.id("end")).sendKeys("20.03.2020");
		driver.findElement(By.xpath("//*[@id='datepicker_miles']/table/tbody/tr[8]/td/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);






		assertEquals("Milestone002", driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/table/tbody/tr[1]/td[2]/div/a")).getText());
		assertEquals("20.03.2020", driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/table/tbody/tr[1]/td[3]")).getText());

		driver.findElement(By.cssSelector("tr.marker-late > td.tools > a.tool_del")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
		driver.navigate().refresh();

		assertFalse(driver.findElement(By.tagName("body")).getText().contains("Milestone002"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("20.03.2020"));

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
