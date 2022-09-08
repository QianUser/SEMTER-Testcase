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

public class UnassignFromMultipleGroups {

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
		new Select(driver.findElement(By.name("group"))).selectByVisibleText("New Group1");
		driver.findElement(By.xpath("html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[1]/input")).click();
		driver.findElement(By.name("remove")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("home")).click();

		new Select(driver.findElement(By.name("group"))).selectByVisibleText("New Group2");
		driver.findElement(By.xpath("html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[1]/input")).click();
		driver.findElement(By.name("remove")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("home")).click();

		new Select(driver.findElement(By.name("group"))).selectByVisibleText("New Group3");
		driver.findElement(By.xpath("html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[1]/input")).click();
		driver.findElement(By.name("remove")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("home")).click();

		new Select(driver.findElement(By.name("group"))).selectByVisibleText("New Group1");
		Thread.sleep(2000);

		assertEquals("Number of results: 0", driver.findElement(By.xpath(".//*[@id='content']/label/strong")).getText());

		new Select(driver.findElement(By.name("group"))).selectByVisibleText("New Group2");
		Thread.sleep(2000);

		assertEquals("Number of results: 0", driver.findElement(By.xpath(".//*[@id='content']/label/strong")).getText());

		new Select(driver.findElement(By.name("group"))).selectByVisibleText("New Group3");
		Thread.sleep(2000);

		assertEquals("Number of results: 0", driver.findElement(By.xpath(".//*[@id='content']/label/strong")).getText());
	}

	public WebDriver getDriver() {
		return driver;
	}

}
