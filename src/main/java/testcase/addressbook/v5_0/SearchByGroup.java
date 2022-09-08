package testcase.addressbook.v5_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class SearchByGroup {

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
		new Select(driver.findElement(By.name("group"))).selectByVisibleText("Group");
		Thread.sleep(2000);

		assertEquals("Number of results: 1", driver.findElement(By.xpath(".//*[@id='content']/label/strong")).getText());
		assertEquals("lastname",driver.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[2]")).getText());
		assertEquals("firstname",driver.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[3]")).getText());
		assertEquals("mail@mail.it", driver.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[4]")).getText());
		assertEquals("01056321", driver.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[5]")).getText());
	}

	public WebDriver getDriver() {
		return driver;
	}

}
