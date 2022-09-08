package testcase.ppma.v9_10;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
public class CustomizeFields {
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

        assertFalse(driver.findElement(By.tagName("body")).getText().contains("www.google.it/mail"));
        assertFalse(driver.findElement(By.tagName("body")).getText().contains("My third personal email"));

        driver.findElement(By.linkText("Settings")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Customize Fields")).click();
        Thread.sleep(1000);
        assertEquals("{\"url\":{\"colname\":\"URL\",\"hint\":\"\",\"cls\":\" hidden\",\"count\":1},\"user\":{\"colname\":\"Username\",\"hint\":\"\",\"cls\":\" hidden-xs\",\"position\":1,\"count\":1},\"comment\":{\"colname\":\"Comment\",\"hint\":\"\",\"cls\":\" hidden\",\"type\":\"textarea\",\"count\":1},\"tags\":{\"colname\":\"Tags\",\"hint\":\"Comma separated values\",\"cls\":\" hidden-xs\",\"count\":1}}", driver.findElement(By.id("fieldsz")).getAttribute("value"));
        driver.findElement(By.id("fieldsz")).clear();
        driver.findElement(By.id("fieldsz")).sendKeys("{\"url\":{\"colname\":\"URL\",\"hint\":\"\",\"cls\":\" hidden-xs\",\"count\":1},\"user\":{\"colname\":\"Username\",\"hint\":\"\",\"cls\":\" hidden-xs\",\"position\":1,\"count\":1},\"comment\":{\"colname\":\"Comment\",\"hint\":\"\",\"cls\":\" hidden-xs\",\"type\":\"textarea\",\"count\":1},\"tags\":{\"colname\":\"Tags\",\"hint\":\"Comma separated values\",\"cls\":\" hidden-xs\",\"count\":1}}");
        driver.findElement(By.id("changefieldsbtn")).click();


        Thread.sleep(3000);

        assertEquals("www.google.it/mail", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[4]")).getText());
        assertEquals("My personal email", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[5]")).getText());

        driver.findElement(By.linkText("Settings")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Customize Fields")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("fieldsz")).clear();
        driver.findElement(By.id("fieldsz")).sendKeys("{\"url\":{\"colname\":\"URL\",\"hint\":\"\",\"cls\":\" hidden-xs\",\"count\":1},\"user\":{\"colname\":\"Username\",\"hint\":\"\",\"cls\":\" hidden-xs\",\"position\":1,\"count\":1},\"comment\":{\"colname\":\"Comment\",\"hint\":\"\",\"cls\":\" hidden\",\"type\":\"textarea\",\"count\":1},\"tags\":{\"colname\":\"Tags\",\"hint\":\"Comma separated values\",\"cls\":\" hidden-xs\",\"count\":1}}");
        driver.findElement(By.id("changefieldsbtn")).click();


        Thread.sleep(3000);

        assertEquals("www.google.it/mail", driver.findElement(By.xpath("//*[@id=\"pwdlist\"]/tbody/tr/td[4]")).getText());
        assertFalse(driver.findElement(By.tagName("body")).getText().contains("My personal email"));

        driver.findElement(By.linkText("Log Out")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
