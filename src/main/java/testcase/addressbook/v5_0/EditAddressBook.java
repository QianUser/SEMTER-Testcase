package testcase.addressbook.v5_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertTrue;

public class EditAddressBook {
	
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
		driver.findElement(By.cssSelector("img[alt='Edit']")).click();

		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys("new address");
		driver.findElement(By.name("home")).clear();
		driver.findElement(By.name("home")).sendKeys("333333");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("newmail@mail.it");
		driver.findElement(By.name("update")).click();
		Thread.sleep(2000);

		assertTrue(driver.findElement(By.xpath(".//*[@id='content']/div")).getText().contains("Address book UPDATED"));
	}

	public WebDriver getDriver() {
		return driver;
	}

}
