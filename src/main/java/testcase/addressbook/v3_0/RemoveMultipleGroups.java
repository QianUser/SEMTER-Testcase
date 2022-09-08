package testcase.addressbook.v3_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertFalse;

public class RemoveMultipleGroups {
	
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
		driver.findElement(By.linkText("manage groups")).click();

		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form[2]/input[1]")).click();
		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form[2]/input[2]")).click();
		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form[2]/input[3]")).click();
		driver.findElement(By.name("delete")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("group page")).click();
		Thread.sleep(1000);

		assertFalse(driver.findElement(By.tagName("body")).getText().contains("Group1"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("Group2"));
		assertFalse(driver.findElement(By.tagName("body")).getText().contains("Group3"));
	}

	public WebDriver getDriver() {
		return driver;
	}

}
