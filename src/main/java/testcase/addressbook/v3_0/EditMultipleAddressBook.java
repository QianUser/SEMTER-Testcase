package testcase.addressbook.v3_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class EditMultipleAddressBook {

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
		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[7]/a/img")).click();

		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys("new address1");
		driver.findElement(By.name("home")).clear();
		driver.findElement(By.name("home")).sendKeys("111111");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("newmail1@mail.it");
		driver.findElement(By.name("update")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("home")).click();

		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[2]/td[7]/a/img")).click();

		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys("new address2");
		driver.findElement(By.name("home")).clear();
		driver.findElement(By.name("home")).sendKeys("222222");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("newmail2@mail.it");
		driver.findElement(By.name("update")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("home")).click();

		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[3]/td[7]/a/img")).click();

		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys("new address3");
		driver.findElement(By.name("home")).clear();
		driver.findElement(By.name("home")).sendKeys("333333");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("newmail3@mail.it");
		driver.findElement(By.name("update")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("home")).click();

		assertEquals("newmail1@mail.it", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[4]")).getText());
		assertEquals("111111", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[5]")).getText());
		assertEquals("newmail2@mail.it", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[2]/td[4]")).getText());
		assertEquals("222222", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[2]/td[5]")).getText());
		assertEquals("newmail3@mail.it", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[3]/td[4]")).getText());
		assertEquals("333333", driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[3]/td[5]")).getText());

	}

	public WebDriver getDriver() {
		return driver;
	}

}
