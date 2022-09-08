package testcase.ppma.v9_10;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
public class SearchMultipleEntries {
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
	public void runTest() throws InterruptedException{
		driver.get("http://localhost/ppma/ppma-9.10/");
		driver.findElement(By.id("user")).sendKeys("admin");
		driver.findElement(By.id("pwd")).sendKeys("12345678");
		driver.findElement(By.id("chk")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"pwdlist_filter\"]/label/input")).sendKeys("Google");

		Thread.sleep(2000);

		assertEquals("Google", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[1]")).getText());
		assertEquals("myaccount1@google.it", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[2]")).getText());
		assertEquals("www.google.it/mail", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[4]")).getText());
		assertEquals("Email, Google1", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[6]")).getText());
		assertEquals("Google", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr[2]/td[1]")).getText());
		assertEquals("myaccount2@google.it", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr[2]/td[2]")).getText());
		assertEquals("www.google.it/mail", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr[2]/td[4]")).getText());
		assertEquals("Email, Google2", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr[2]/td[6]")).getText());
		assertEquals("Google", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr[3]/td[1]")).getText());
		assertEquals("myaccount3@google.it", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr[3]/td[2]")).getText());
		assertEquals("www.google.it/mail", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr[3]/td[4]")).getText());
		assertEquals("Email, Google3", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr[3]/td[6]")).getText());

		driver.findElement(By.xpath("//*[@id=\"pwdlist_filter\"]/label/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"pwdlist_filter\"]/label/input")).sendKeys("myaccount1@google.it");

		Thread.sleep(2000);

		assertEquals("Google", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[1]")).getText());
		assertEquals("myaccount1@google.it", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[2]")).getText());
		assertEquals("www.google.it/mail", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[4]")).getText());
		assertEquals("Email, Google1", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[6]")).getText());
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myaccount2@google.it"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myaccount3@google.it"));

		driver.findElement(By.xpath("//*[@id=\"pwdlist_filter\"]/label/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"pwdlist_filter\"]/label/input")).sendKeys("myaccount2@google.it");

		Thread.sleep(2000);

		assertEquals("Google", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[1]")).getText());
		assertEquals("myaccount2@google.it", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[2]")).getText());
		assertEquals("www.google.it/mail", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[4]")).getText());
		assertEquals("Email, Google2", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[6]")).getText());
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myaccount1@google.it"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myaccount3@google.it"));

		driver.findElement(By.xpath("//*[@id=\"pwdlist_filter\"]/label/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"pwdlist_filter\"]/label/input")).sendKeys("myaccount3@google.it");

		Thread.sleep(2000);

		assertEquals("Google", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[1]")).getText());
		assertEquals("myaccount3@google.it", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[2]")).getText());
		assertEquals("www.google.it/mail", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[4]")).getText());
		assertEquals("Email, Google3", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[6]")).getText());
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myaccount1@google.it"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("myaccount2@google.it"));

		driver.findElement(By.linkText("Log Out")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
