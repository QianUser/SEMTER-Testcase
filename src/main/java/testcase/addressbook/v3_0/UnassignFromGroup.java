package testcase.addressbook.v3_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import runner.Executor;

import static org.junit.Assert.assertTrue;

public class UnassignFromGroup {

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
		new Select(driver.findElement(By.name("group"))).selectByVisibleText("New Group");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[1]/input")).click();
		driver.findElement(By.name("remove")).click();
		Thread.sleep(2000);

		assertTrue(driver.findElement(By.xpath("./html/body/table/tbody/tr[2]/td[3]")).getText().contains("Users removed."));
	}

	public WebDriver getDriver() {
		return driver;
	}

}
