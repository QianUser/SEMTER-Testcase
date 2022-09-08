package testcase.collabtive.v1_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;
public class CloseProject {

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


		driver.findElement(By.cssSelector("a.butn_check")).click();
		Thread.sleep(5000);

		driver.navigate().refresh();
		driver.findElement(By.id("donebutn")).click();
		Thread.sleep(5000);

		assertEquals("Project001", driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]/td[2]/div/a")).getText());
		assertEquals("Open", driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/div/div/table/tbody/tr[1]/td[1]/a")).getAttribute("title"));

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
