package testcase.collabtive.v1_2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.Executor;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
public class EditUserRole {

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


		new Actions(driver).moveToElement(driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/div[2]/div/div/ul/li[1]/div/table/tbody/tr[1]/td[2]/a/img"))).perform();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(("a.edit"))));
		driver.findElement(By.cssSelector("a.edit")).click();

		new Select(driver.findElement(By.name("role"))).selectByVisibleText("NewRole");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);

		new Actions(driver).moveToElement(driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/div[2]/div/div/ul/li[1]/div/table/tbody/tr[1]/td[2]/a/img"))).perform();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(("a.edit"))));
		driver.findElement(By.cssSelector("a.edit")).click();

		assertEquals("NewRole", driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[1]/form/fieldset/table/tbody/tr/td[2]/div/div/table/tbody[23]/tr/td[2]/select/option[1]")).getText());

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
