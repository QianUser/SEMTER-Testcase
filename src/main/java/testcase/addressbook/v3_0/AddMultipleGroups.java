package testcase.addressbook.v3_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertTrue;

public class AddMultipleGroups {

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

		driver.findElement(By.name("new")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("group_name")).sendKeys("Group1");
		driver.findElement(By.name("group_header")).sendKeys("Header1");

		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("group page")).click();
		Thread.sleep(1000);

		driver.findElement(By.name("new")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("group_name")).sendKeys("Group2");
		driver.findElement(By.name("group_header")).sendKeys("Header2");

		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("group page")).click();
		Thread.sleep(1000);

		driver.findElement(By.name("new")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("group_name")).sendKeys("Group3");
		driver.findElement(By.name("group_header")).sendKeys("Header3");

		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("group page")).click();
		Thread.sleep(1000);

		assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form[2]")).getText().contains("Group1"));
		assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form[2]")).getText().contains("Group2"));
		assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]/form[2]")).getText().contains("Group3"));
	}

	public WebDriver getDriver() {
		return driver;
	}

}
