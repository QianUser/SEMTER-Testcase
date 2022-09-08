package testcase.ppma.v6_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;
public class AddMultipleEntries {
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
		driver.get("http://localhost/ppma/ppma-6.0/");
		driver.findElement(By.id("user")).sendKeys("admin");
		driver.findElement(By.id("pwd")).sendKeys("12345678");
		driver.findElement(By.id("chk")).click();
		Thread.sleep(3000);

		driver.findElement(By.linkText("Add Entry")).click();

		driver.findElement(By.id("newiteminput")).sendKeys("Google");

		driver.findElement(By.id("newiteminputpw")).sendKeys("mypassword1");



		driver.findElement(By.id("newbtn")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

		driver.findElement(By.linkText("Add Entry")).click();

		driver.findElement(By.id("newiteminput")).sendKeys("Google");

		driver.findElement(By.id("newiteminputpw")).sendKeys("mypassword2");



		driver.findElement(By.id("newbtn")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

		driver.findElement(By.linkText("Add Entry")).click();

		driver.findElement(By.id("newiteminput")).sendKeys("Google");

		driver.findElement(By.id("newiteminputpw")).sendKeys("mypassword3");



		driver.findElement(By.id("newbtn")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

		assertEquals("Google", driver.findElement(By.xpath("//*[@id=\"pwdtable\"]/table/tbody/tr[2]/td[1]")).getText());




		assertEquals("Google", driver.findElement(By.xpath("//*[@id=\"pwdtable\"]/table/tbody/tr[3]/td[1]")).getText());




		assertEquals("Google", driver.findElement(By.xpath("//*[@id=\"pwdtable\"]/table/tbody/tr[4]/td[1]")).getText());




		driver.findElement(By.linkText("Log Out")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
