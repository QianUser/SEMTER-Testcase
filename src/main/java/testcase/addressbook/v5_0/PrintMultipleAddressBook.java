package testcase.addressbook.v5_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertTrue;

public class PrintMultipleAddressBook {

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
		driver.get("http://localhost/addressbook/addressbook-5.0/?lang=en");
		driver.findElement(By.linkText("print all")).click();

		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[1]")).getText().contains("firstname1"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[1]")).getText().contains("lastname1"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[1]")).getText().contains("address1"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[1]")).getText().contains("01056321"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[1]")).getText().contains("mail1@mail.it"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[1]")).getText().contains("11"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[1]")).getText().contains("June"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[1]")).getText().contains("1981"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[2]")).getText().contains("firstname2"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[2]")).getText().contains("lastname2"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[2]")).getText().contains("address2"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[2]")).getText().contains("01056322"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[2]")).getText().contains("mail2@mail.it"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[2]")).getText().contains("12"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[2]")).getText().contains("June"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[2]")).getText().contains("1982"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[3]")).getText().contains("firstname3"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[3]")).getText().contains("lastname3"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[3]")).getText().contains("address3"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[3]")).getText().contains("01056323"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[3]")).getText().contains("mail3@mail.it"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[3]")).getText().contains("13"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[3]")).getText().contains("June"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='view']/tbody/tr/td[3]")).getText().contains("1983"));
	}

	public WebDriver getDriver() {
		return driver;
	}

}
