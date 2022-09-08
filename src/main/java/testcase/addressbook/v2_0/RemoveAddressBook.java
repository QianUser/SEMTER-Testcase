package testcase.addressbook.v2_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertTrue;

public class RemoveAddressBook {

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
		driver.get("http://localhost/addressbook/addressbook-2.0/?lang=en");
		driver.findElement(By.linkText("edit")).click();

		driver.findElement(By.xpath("(//input[@name='update'])[2]")).click();

		assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]")).getText().contains("Record deleted."));
	}

	public WebDriver getDriver() {
		return driver;
	}

}
