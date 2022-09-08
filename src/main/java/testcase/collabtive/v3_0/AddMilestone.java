package testcase.collabtive.v3_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class AddMilestone {

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

		driver.findElement(By.xpath(".//*[@id='contentwrapper']/div[1]/ul/li[2]/a")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("add_butn_current")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Milestone001");
//		driver.switchTo().frame("desc_ifr");
		driver.findElement(By.id("desc_ifr")).sendKeys("Description of Milestone001");
//		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);

		assertEquals("Milestone001", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[5]/div[2]/div/table/tbody/tr[1]/td[2]/div/span/a")).getText());

		driver.findElement(By.linkText("Milestone001")).click();
		Thread.sleep(1000);

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("Description of Milestone001"));

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
