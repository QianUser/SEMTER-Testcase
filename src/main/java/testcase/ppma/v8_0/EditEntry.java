package testcase.ppma.v8_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;
public class EditEntry {
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
		driver.get("http://localhost/ppma/ppma-8.0/");
		driver.findElement(By.id("user")).sendKeys("admin");
		driver.findElement(By.id("pwd")).sendKeys("12345678");
		driver.findElement(By.id("chk")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr[2]/td[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("edititeminputuser")).clear();
		driver.findElement(By.id("edititeminputuser")).sendKeys("myaccount1@gmail.com");
		driver.findElement(By.id("edititeminputurl")).clear();
		driver.findElement(By.id("edititeminputurl")).sendKeys("www.gmail.com/mail1");
		driver.findElement(By.id("editbtn")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		assertEquals("myaccount1@gmail.com", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr[2]/td[2]")).getText());


		driver.findElement(By.linkText("Log Out")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
