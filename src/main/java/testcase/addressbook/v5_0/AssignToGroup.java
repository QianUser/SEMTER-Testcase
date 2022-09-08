package testcase.addressbook.v5_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import runner.Executor;

import static org.junit.Assert.assertTrue;

public class AssignToGroup {
	
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
		driver.findElement(By.xpath("html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[1]/input")).click();
		new Select(driver.findElement(By.name("to_group"))).selectByVisibleText("Group");
		driver.findElement(By.name("add")).click();
		Thread.sleep(2000);

		assertTrue(driver.findElement(By.xpath(".//*[@id='content']/div")).getText().contains("Users added."));
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
