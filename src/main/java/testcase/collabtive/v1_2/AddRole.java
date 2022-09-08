package testcase.collabtive.v1_2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;
public class AddRole {
	
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


		driver.findElement(By.xpath(".//*[@id='contentwrapper']/div[1]/ul/li[2]/a")).click();


		driver.findElement(By.id("add_butn_myprojects")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='name'])[2]")).sendKeys("newrole");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[6]/div[1]/div/form/fieldset/div[3]/div[2]/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[6]/div[1]/div/form/fieldset/div[3]/div[4]/input")).click();


		driver.findElement(By.cssSelector("div.row-butn-bottom > button[type='submit']")).click();
		Thread.sleep(2000);

		assertEquals("newrole", driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[6]/table/tbody[1]/tr[1]/td[2]/div/a")).getText());

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
