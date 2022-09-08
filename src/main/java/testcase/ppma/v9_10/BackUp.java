package testcase.ppma.v9_10;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;
public class BackUp {
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
        driver.get("http://localhost/ppma/ppma-9.10/");
        driver.findElement(By.id("user")).sendKeys("admin");
        driver.findElement(By.id("pwd")).sendKeys("12345678");
        driver.findElement(By.id("chk")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("Settings")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Back Up")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("backuppwdbtn")).click();
        Thread.sleep(15000);
        driver.findElement(By.xpath("//*[@id=\"backuppw\"]/div/div/div[1]/button")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Log Out")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
