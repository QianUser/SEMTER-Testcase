package testcase.claroline.v1_7_9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class SearchUser {

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
		driver.get("http://localhost/claroline/claroline-1.7.9/");
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.name("submitAuth")).click();

		driver.findElement(By.linkText("Platform Administration")).click();  

		driver.findElement(By.id("search_user")).sendKeys("Smith");
		driver.findElement(By.cssSelector("form[name='searchUser'] > input[type='submit']")).click();

		assertEquals("Smith", driver.findElement(By.xpath("//*[@id='claroBody']/table[3]/tbody/tr/td[2]")).getText());
		assertEquals("Bert", driver.findElement(By.xpath("//*[@id='claroBody']/table[3]/tbody/tr/td[3]")).getText());  
		assertEquals("Normal", driver.findElement(By.xpath("//*[@id='claroBody']/table[3]/tbody/tr/td[6]")).getText());  

		driver.findElement(By.linkText("Logout")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
