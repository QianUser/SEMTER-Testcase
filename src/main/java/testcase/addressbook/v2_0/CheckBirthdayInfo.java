package testcase.addressbook.v2_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class CheckBirthdayInfo {

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
		driver.findElement(By.linkText("next birthdays")).click();

		assertEquals("19.",driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/table[2]/tbody/tr[2]/td[1]")).getText());
		assertEquals("lastname",driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/table[2]/tbody/tr[2]/td[2]")).getText());
		assertEquals("firstname",driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/table[2]/tbody/tr[2]/td[3]")).getText());
		assertEquals("mail@mail.it",driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/table[2]/tbody/tr[2]/td[4]")).getText());
		assertEquals("01056321",driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/table[2]/tbody/tr[2]/td[5]")).getText());
		assertEquals("June 2023",driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/table[2]/tbody/tr[1]/td/h2")).getText());
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
