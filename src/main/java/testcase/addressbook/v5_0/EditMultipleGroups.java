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

public class EditMultipleGroups {

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
		driver.findElement(By.linkText("groups")).click();

		driver.findElement(By.xpath(".//*[@id='content']/form[2]/input[1]")).click();
		driver.findElement(By.name("edit")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("group_name")).clear();
		driver.findElement(By.name("group_name")).sendKeys("New Group1");
		driver.findElement(By.name("group_header")).clear();
		driver.findElement(By.name("group_header")).sendKeys("New Header1");
		driver.findElement(By.name("group_footer")).clear();
		driver.findElement(By.name("group_footer")).sendKeys("New Footer1");
		driver.findElement(By.name("update")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("group page")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(".//*[@id='content']/form[2]/input[1]")).click();
		driver.findElement(By.name("edit")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("group_name")).clear();
		driver.findElement(By.name("group_name")).sendKeys("New Group2");
		driver.findElement(By.name("group_header")).clear();
		driver.findElement(By.name("group_header")).sendKeys("New Header2");
		driver.findElement(By.name("group_footer")).clear();
		driver.findElement(By.name("group_footer")).sendKeys("New Footer2");
		driver.findElement(By.name("update")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("group page")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(".//*[@id='content']/form[2]/input[1]")).click();
		driver.findElement(By.name("edit")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("group_name")).clear();
		driver.findElement(By.name("group_name")).sendKeys("New Group3");
		driver.findElement(By.name("group_header")).clear();
		driver.findElement(By.name("group_header")).sendKeys("New Header3");
		driver.findElement(By.name("group_footer")).clear();
		driver.findElement(By.name("group_footer")).sendKeys("New Footer3");
		driver.findElement(By.name("update")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("group page")).click();
		Thread.sleep(1000);

		assertTrue(driver.findElement(By.xpath(".//*[@id='content']/form[2]")).getText().contains("New Group1"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='content']/form[2]")).getText().contains("New Group2"));
		assertTrue(driver.findElement(By.xpath(".//*[@id='content']/form[2]")).getText().contains("New Group3"));

		driver.findElement(By.linkText("home")).click();

		new Select(driver.findElement(By.name("group"))).selectByVisibleText("New Group1");
		Thread.sleep(2000);

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("New Header1"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("New Footer1"));

		new Select(driver.findElement(By.name("group"))).selectByVisibleText("New Group2");
		Thread.sleep(2000);

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("New Header2"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("New Footer2"));

		new Select(driver.findElement(By.name("group"))).selectByVisibleText("New Group3");
		Thread.sleep(2000);

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("New Header3"));
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("New Footer3"));
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
