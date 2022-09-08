package testcase.addressbook.v7_0_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertTrue;

public class PrintAddressBook {

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
		driver.findElement(By.linkText("print all")).click();

		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[1]")).getText().contains("firstname"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[1]")).getText().contains("lastname"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[1]")).getText().contains("address"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[1]")).getText().contains("01056321"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[1]")).getText().contains("mail@mail.it"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[1]")).getText().contains("19"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[1]")).getText().contains("June"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[1]")).getText().contains("1985"));
	}

	public WebDriver getDriver() {
		return driver;
	}

}
