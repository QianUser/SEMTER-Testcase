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

public class EditRole {

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

		driver.findElement(By.xpath(".//*[@id='contentwrapper']/div[1]/ul/li[3]/a")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[3]/div[2]/table/tbody[1]/tr[1]/td[2]/div")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("rolename")).clear();
		driver.findElement(By.id("rolename")).sendKeys("NewRole");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[3]/div[2]/table/tbody[1]/tr[2]/td[2]/div/form/fieldset/div[3]/div[3]/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[3]/div[2]/table/tbody[1]/tr[2]/td[2]/div/form/fieldset/div[3]/div[5]/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[3]/div[2]/table/tbody[1]/tr[2]/td[2]/div/form/fieldset/div[5]/button[1]")).click();
		Thread.sleep(2000);

		assertEquals("NewRole", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[3]/div[2]/table/tbody[1]/tr[1]/td[2]/div")).getText());

		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[3]/div[2]/table/tbody[1]/tr[1]/td[2]/div")).click();

		assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[3]/div[2]/table/tbody[1]/tr[2]/td[2]/div/form/fieldset/div[3]/div[3]/input")).isSelected());
		assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[3]/div[2]/table/tbody[1]/tr[2]/td[2]/div/form/fieldset/div[3]/div[5]/input")).isSelected());

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
