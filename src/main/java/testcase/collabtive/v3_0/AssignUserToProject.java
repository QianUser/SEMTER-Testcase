package testcase.collabtive.v3_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import runner.Executor;

import static org.junit.Assert.assertEquals;
public class AssignUserToProject {
	
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

		driver.findElement(By.linkText("Project001")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='contentwrapper']/div[1]/ul/li[6]/a")).click();

		driver.findElement(By.id("add_butn_member")).click();
		Thread.sleep(2000);
		new Select(driver.findElement(By.id("addtheuser"))).selectByVisibleText("username001");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);

		assertEquals("username001", driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/div[2]/div/div/ul/li[2]/div/table/tbody/tr[2]/td/span/a")).getText());

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
