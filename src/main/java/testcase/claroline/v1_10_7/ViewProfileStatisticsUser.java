package testcase.claroline.v1_10_7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class ViewProfileStatisticsUser {

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
	public void runTest() throws InterruptedException{
		driver.get("http://localhost/claroline/claroline-1.10.7/");
		driver.findElement(By.id("login")).sendKeys("UserU");
		driver.findElement(By.id("password")).sendKeys("passwordU");
		driver.findElement(By.name("submitAuth")).click();

		driver.findElement(By.linkText("My User Account")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='claroBody']/p[1]/span/a")).click();

		new Select(driver.findElement(By.id("cidReq"))).selectByVisibleText("Math");
		Thread.sleep(3000);



		assertEquals("Exercise 1", driver.findElement(By.xpath(".//*[@id='leftContent']/div[3]/div[2]/table/tbody/tr[1]/td[1]/a")).getText());
		assertEquals("9", driver.findElement(By.xpath(".//*[@id='leftContent']/div[3]/div[2]/table/tbody/tr[1]/td[3]")).getText());

		driver.findElement(By.linkText("Logout")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
