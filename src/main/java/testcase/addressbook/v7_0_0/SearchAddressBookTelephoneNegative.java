package testcase.addressbook.v7_0_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class SearchAddressBookTelephoneNegative {

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
		driver.get("http://localhost/addressbook/addressbook-7.0.0/?lang=en");
		driver.findElement(By.name("searchstring")).clear();
		driver.findElement(By.name("searchstring")).sendKeys("01056321");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);

		assertEquals("Number of results: 1", driver.findElement(By.xpath(".//*[@id='content']/label/strong")).getText());
	}

	public WebDriver getDriver() {
		return driver;
	}

}
