package testcase.collabtive.v1_2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;
public class AddProject {

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
		driver.get("http://localhost/collabtive/collabtive-1.2/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("pass")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.loginbutn")).click();

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[3]/a")).click();


		driver.findElement(By.id("add_butn_myprojects")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Project001");
//		driver.switchTo().frame("desc_ifr");
		driver.findElement(By.id("desc_ifr")).sendKeys("Description for Project001");
//		driver.switchTo().defaultContent();
		driver.findElement(By.id("budget")).sendKeys("10000");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);



		assertEquals("Project001", driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/div/a")).getText());

		driver.findElement(By.linkText("Project001")).click();
		Thread.sleep(2000);

		assertEquals("Budget: 10000", driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[1]/div[2]/ul/li[4]/a")).getText());
		driver.findElement(By.id("desctoggle")).click();
		Thread.sleep(2000);
		assertEquals("Description for Project001", driver.findElement(By.id("descript")).getText());

		driver.findElement(By.xpath(".//*[@id='mainmenue']/li[4]/a")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
