package testcase.ppma.v9_10;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;
public class SignUp {
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
        driver.findElement(By.cssSelector(".btn:nth-child(10)")).click();

        driver.findElement(By.id("user")).sendKeys("admin");
        driver.findElement(By.id("pwd")).sendKeys("1234567");
        driver.findElement(By.id("pwd1")).sendKeys("1234567");
        driver.findElement(By.id("email")).sendKeys("admin@qq.com");
        driver.findElement(By.id("chk")).click();
        Thread.sleep(3000);

        assertEquals(driver.switchTo().alert().getText(), "Successfully signup, now please sign in!");

	}

	public WebDriver getDriver() {
		return driver;
	}

}
