package testcase.collabtive.v2_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;
public class EditProject {

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
		driver.get("http://localhost/collabtive/collabtive-2.0/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("pass")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.loginbutn")).click();

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[3]/a")).click();


		driver.findElement(By.cssSelector("a.tool_edit")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("end")).clear();
		driver.findElement(By.id("end")).sendKeys("20.03.2024");
		driver.findElement(By.xpath("//*[@id='datepicker_project']/table/tbody/tr[9]/td/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("edit_butn")).click();
		Thread.sleep(2000);

		assertEquals("20.03.2024", driver.findElement(By.id("end")).getAttribute("value"));

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
