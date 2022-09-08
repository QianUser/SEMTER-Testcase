package testcase.collabtive.v0_7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import runner.Executor;

import static org.junit.Assert.assertTrue;
public class AddUserAlreadyPresent {

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
		driver.get("http://localhost/collabtive/collabtive-0.7/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("pass")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.loginbutn")).click();

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[3]/a")).click();


		driver.findElement(By.xpath(".//*[@id='contentwrapper']/div[1]/ul/li[2]/a")).click();


		driver.findElement(By.id("add_butn_member")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("username001");
		driver.findElement(By.id("email")).sendKeys("username001@username.it");
		driver.findElement(By.id("pass")).sendKeys("password001");
		new Select(driver.findElement(By.id("roleselect"))).selectByVisibleText("Client");
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div[2]/div/div/div[3]/div[1]/div/form/fieldset/div[11]/div/button")).click();
		Thread.sleep(2000);

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("username.it or the username username001 already exists in the user database."));

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
