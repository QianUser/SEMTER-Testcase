package testcase.addressbook.v3_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertTrue;

public class EditGroup {

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

		driver.findElement(By.name("selected[]")).click();
		driver.findElement(By.name("edit")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("group_name")).clear();
		driver.findElement(By.name("group_name")).sendKeys("New Group");
		driver.findElement(By.name("group_header")).clear();
		driver.findElement(By.name("group_header")).sendKeys("New Header");


		driver.findElement(By.name("update")).click();
		Thread.sleep(2000);

		assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]")).getText().contains("Address book updated."));
	}

	public WebDriver getDriver() {
		return driver;
	}

}
