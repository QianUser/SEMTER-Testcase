package testcase.collabtive.v1_2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import runner.Executor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class AddAndRemoveMultipleTasks {

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
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys("mytask1");
		new Select(driver.findElement(By.name("assigned[]"))).selectByVisibleText("admin");
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[5]/div[1]/div/form/fieldset/div[6]/button[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[5]/div[3]/div/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys("mytask2");
		new Select(driver.findElement(By.name("assigned[]"))).selectByVisibleText("admin");
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[5]/div[1]/div/form/fieldset/div[6]/button[1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[5]/div[3]/div/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys("mytask3");
		new Select(driver.findElement(By.name("assigned[]"))).selectByVisibleText("admin");
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[5]/div[1]/div/form/fieldset/div[6]/button[1]")).click();
		Thread.sleep(2000);

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("mytask1"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("mytask2"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("mytask3"));

		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[5]/div[2]/table/tbody[1]/tr[1]/td[5]/a[2]")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();


		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[5]/div[2]/table/tbody[2]/tr[1]/td[5]/a[2]")).click();
		alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();


		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[5]/div[2]/table/tbody[3]/tr[1]/td[5]/a[2]")).click();
		alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		driver.navigate().refresh();

		assertFalse(driver.findElement(By.tagName("body")).getText().contains("mytask1"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("mytask2"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("mytask3"));

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
