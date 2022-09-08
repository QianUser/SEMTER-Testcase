package testcase.addressbook.v3_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class SearchMultipleAddressBookName {

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
		driver.get("http://localhost/addressbook/addressbook-3.0/?lang=en");
		driver.findElement(By.name("searchstring")).clear();
		driver.findElement(By.name("searchstring")).sendKeys("lastname");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);

		assertEquals("Number of results: 3", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/table/tbody/tr/td[1]/strong")).getText());
		assertEquals("lastname1",driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[2]")).getText());
		assertEquals("firstname1",driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[3]")).getText());
		assertEquals("mail1@mail.it", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[4]")).getText());
		assertEquals("01056321", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[5]")).getText());
		assertEquals("lastname2",driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[2]/td[2]")).getText());
		assertEquals("firstname2",driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[2]/td[3]")).getText());
		assertEquals("mail2@mail.it", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[2]/td[4]")).getText());
		assertEquals("01056322", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[2]/td[5]")).getText());
		assertEquals("lastname3",driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[3]/td[2]")).getText());
		assertEquals("firstname3",driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[3]/td[3]")).getText());
		assertEquals("mail3@mail.it", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[3]/td[4]")).getText());
		assertEquals("01056323", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[3]/td[5]")).getText());

		driver.findElement(By.name("searchstring")).clear();
		driver.findElement(By.name("searchstring")).sendKeys("lastname1");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);

		assertEquals("Number of results: 1", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/table/tbody/tr/td[1]/strong")).getText());
		assertEquals("lastname1",driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[2]")).getText());
		assertEquals("firstname1", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[3]")).getText());
		assertEquals("mail1@mail.it",  driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[4]")).getText());
		assertEquals("01056321",  driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[5]")).getText());

		driver.findElement(By.name("searchstring")).clear();
		driver.findElement(By.name("searchstring")).sendKeys("lastname2");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);

		assertEquals("Number of results: 1", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/table/tbody/tr/td[1]/strong")).getText());
		assertEquals("lastname2",driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[2]")).getText());
		assertEquals("firstname2", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[3]")).getText());
		assertEquals("mail2@mail.it",  driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[4]")).getText());
		assertEquals("01056322",  driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[5]")).getText());

		driver.findElement(By.name("searchstring")).clear();
		driver.findElement(By.name("searchstring")).sendKeys("lastname3");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);

		assertEquals("Number of results: 1", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/table/tbody/tr/td[1]/strong")).getText());
		assertEquals("lastname3",driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[2]")).getText());
		assertEquals("firstname3", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[3]")).getText());
		assertEquals("mail3@mail.it",  driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[4]")).getText());
		assertEquals("01056323",  driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[5]")).getText());
	}

	public WebDriver getDriver() {
		return driver;
	}

}
