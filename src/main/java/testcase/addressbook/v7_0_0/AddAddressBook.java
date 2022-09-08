package testcase.addressbook.v7_0_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import runner.Executor;

import static org.junit.Assert.assertTrue;

public class AddAddressBook {

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
		driver.findElement(By.linkText("add new")).click();

		driver.findElement(By.cssSelector("input[name='quickadd']")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("firstname")).sendKeys("firstname");
		driver.findElement(By.name("lastname")).sendKeys("lastname");
		driver.findElement(By.name("address")).sendKeys("address");
		driver.findElement(By.name("home")).sendKeys("01056321");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("mail@mail.it");
		new Select(driver.findElement(By.name("bday"))).selectByVisibleText("19");
		new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("June");
		driver.findElement(By.name("byear")).sendKeys("1985");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(1000);

		assertTrue(driver.findElement(By.xpath(".//*[@id='content']/div")).getText().contains("Information entered into address book."));
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
