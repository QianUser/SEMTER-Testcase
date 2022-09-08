package testcase.addressbook.v7_0_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class SearchByMultipleGroups {
	
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
		new Select(driver.findElement(By.name("group"))).selectByVisibleText("Group1");
		Thread.sleep(2000);

		assertEquals("Number of results: 1", driver.findElement(By.xpath(".//*[@id='content']/label/strong")).getText());
		assertEquals("lastname1",driver.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[2]")).getText());
		assertEquals("firstname1",driver.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[3]")).getText());
		assertEquals("mail1@mail.it", driver.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[4]")).getText());
		assertEquals("01056321", driver.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[5]")).getText());

		new Select(driver.findElement(By.name("group"))).selectByVisibleText("Group2");
		Thread.sleep(2000);

		assertEquals("Number of results: 1", driver.findElement(By.xpath(".//*[@id='content']/label/strong")).getText());
		assertEquals("lastname2",driver.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[2]")).getText());
		assertEquals("firstname2",driver.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[3]")).getText());
		assertEquals("mail2@mail.it", driver.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[4]")).getText());
		assertEquals("01056322", driver.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[5]")).getText());

		new Select(driver.findElement(By.name("group"))).selectByVisibleText("Group3");
		Thread.sleep(2000);

		assertEquals("Number of results: 1", driver.findElement(By.xpath(".//*[@id='content']/label/strong")).getText());
		assertEquals("lastname3",driver.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[2]")).getText());
		assertEquals("firstname3",driver.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[3]")).getText());
		assertEquals("mail3@mail.it", driver.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[4]")).getText());
		assertEquals("01056323", driver.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[5]")).getText());
	}

	public WebDriver getDriver() {
		return driver;
	}

}
