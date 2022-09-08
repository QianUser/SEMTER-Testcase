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

public class AssignToMultipleGroups {

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
		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[1]/td[1]/input")).click();
		new Select(driver.findElement(By.name("to_group"))).selectByVisibleText("Group1");
		driver.findElement(By.name("add")).click();
		Thread.sleep(2000);

		assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]")).getText().contains("Users added."));

		driver.findElement(By.linkText("home")).click();

		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[2]/td[1]/input")).click();
		new Select(driver.findElement(By.name("to_group"))).selectByVisibleText("Group2");
		driver.findElement(By.name("add")).click();
		Thread.sleep(2000);

		assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]")).getText().contains("Users added."));

		driver.findElement(By.linkText("home")).click();

		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form/table[1]/tbody/tr[3]/td[1]/input")).click();
		new Select(driver.findElement(By.name("to_group"))).selectByVisibleText("Group3");
		driver.findElement(By.name("add")).click();
		Thread.sleep(2000);

		assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]")).getText().contains("Users added."));
	}

	public WebDriver getDriver() {
		return driver;
	}

}
