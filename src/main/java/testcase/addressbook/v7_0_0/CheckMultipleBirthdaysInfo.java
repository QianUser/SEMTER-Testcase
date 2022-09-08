package testcase.addressbook.v7_0_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class CheckMultipleBirthdaysInfo {

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
		driver.findElement(By.linkText("next birthdays")).click();

		assertEquals("11.",driver.findElement(By.xpath(".//*[@id='birthdays']/tbody/tr[2]/td[1]")).getText());
		assertEquals("lastname1",driver.findElement(By.xpath(".//*[@id='birthdays']/tbody/tr[2]/td[2]")).getText());
		assertEquals("firstname1",driver.findElement(By.xpath(".//*[@id='birthdays']/tbody/tr[2]/td[3]")).getText());
		assertEquals("mail1@mail.it",driver.findElement(By.xpath(".//*[@id='birthdays']/tbody/tr[2]/td[5]")).getText());
		assertEquals("01056321",driver.findElement(By.xpath(".//*[@id='birthdays']/tbody/tr[2]/td[6]")).getText());
		assertEquals("June 2023",driver.findElement(By.xpath(".//*[@id='birthdays']/tbody/tr[1]/th")).getText());
		assertEquals("12.",driver.findElement(By.xpath(".//*[@id='birthdays']/tbody/tr[3]/td[1]")).getText());
		assertEquals("lastname2",driver.findElement(By.xpath(".//*[@id='birthdays']/tbody/tr[3]/td[2]")).getText());
		assertEquals("firstname2",driver.findElement(By.xpath(".//*[@id='birthdays']/tbody/tr[3]/td[3]")).getText());
		assertEquals("mail2@mail.it",driver.findElement(By.xpath(".//*[@id='birthdays']/tbody/tr[3]/td[5]")).getText());
		assertEquals("01056322",driver.findElement(By.xpath(".//*[@id='birthdays']/tbody/tr[3]/td[6]")).getText());
//		assertEquals("June",driver.findElement(By.xpath(".//*[@id='birthdays']/tbody/tr[1]/th")).getText());
		assertEquals("13.",driver.findElement(By.xpath(".//*[@id='birthdays']/tbody/tr[4]/td[1]")).getText());
		assertEquals("lastname3",driver.findElement(By.xpath(".//*[@id='birthdays']/tbody/tr[4]/td[2]")).getText());
		assertEquals("firstname3",driver.findElement(By.xpath(".//*[@id='birthdays']/tbody/tr[4]/td[3]")).getText());
		assertEquals("mail3@mail.it",driver.findElement(By.xpath(".//*[@id='birthdays']/tbody/tr[4]/td[5]")).getText());
		assertEquals("01056323",driver.findElement(By.xpath(".//*[@id='birthdays']/tbody/tr[4]/td[6]")).getText());
//		assertEquals("June",driver.findElement(By.xpath(".//*[@id='birthdays']/tbody/tr[1]/th")).getText());
	}

	public WebDriver getDriver() {
		return driver;
	}

}
