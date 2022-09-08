package testcase.collabtive.v1_2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import runner.Executor;

import static org.junit.Assert.assertTrue;
public class AddTaskDesktopPresent {

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
		driver.get("http://localhost/collabtive/collabtive-1.2/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("pass")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.loginbutn")).click();

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[3]/a")).click();


		driver.findElement(By.linkText("Project001")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='contentwrapper']/div[1]/ul/li[3]/a")).click();


		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[5]/div[3]/div/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("title")).sendKeys("desktopTask");
		new Select(driver.findElement(By.name("assigned[]"))).selectByVisibleText("admin");
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[5]/div[1]/div/form/fieldset/div[6]/button[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[1]/a")).click();




		assertTrue(driver.findElement(By.tagName("body")).getText().contains("desktopTask"));

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
