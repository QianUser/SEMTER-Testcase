package testcase.ppma.v6_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;
public class Login {
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
        driver.findElement(By.id("pwd")).sendKeys("1234567");
        driver.findElement(By.id("chk")).click();
        Thread.sleep(3000);

        assertEquals("Log Out", driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/p/a[1]")).getText());


        driver.findElement(By.linkText("Log Out")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
