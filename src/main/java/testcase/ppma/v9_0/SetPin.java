package testcase.ppma.v9_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;
public class SetPin {
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
        driver.get("http://localhost/ppma/ppma-9.0/");
        driver.findElement(By.id("user")).sendKeys("admin");
        driver.findElement(By.id("pwd")).sendKeys("12345678");
        driver.findElement(By.id("chk")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("Set PIN")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("pinxx")).sendKeys("abcdefg");
        driver.findElement(By.id("pinlogin")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        driver.findElement(By.linkText("Log Out")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("pin")).sendKeys("abcdefg");
        driver.findElement(By.id("pinlogin")).click();
        Thread.sleep(3000);

        assertEquals("Log Out", driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/p/a[1]")).getText());
        assertEquals("Untrust", driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/p/a[2]")).getText());

        driver.findElement(By.linkText("Log Out")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
