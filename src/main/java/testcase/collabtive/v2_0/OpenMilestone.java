package testcase.collabtive.v2_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;
public class OpenMilestone {
	
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


		driver.findElement(By.linkText("Project001")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='contentwrapper']/div[1]/ul/li[2]/a")).click();


		driver.findElement(By.id("donebutn")).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("a.butn_checked")).click();
		Thread.sleep(2000);

		assertEquals("Close", driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[1]/table/tbody/tr[1]/td[1]/a")).getAttribute("title"));
		assertEquals("Milestone001", driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[1]/table/tbody/tr[1]/td[2]/div/a")).getText());

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
