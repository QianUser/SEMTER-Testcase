package testcase.claroline.v1_7_9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class AddCourseExerciseQuestions {

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

		driver.findElement(By.linkText("1 - Math")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Exercises")).click();

		driver.findElement(By.xpath("(//img[@alt='Modify'])[2]")).click();

		driver.findElement(By.linkText("New question")).click();

		driver.findElement(By.id("questionName")).sendKeys("Question 1");
		driver.findElement(By.id("answerType1")).click();
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='claroBody']/form/table/tbody/tr[1]/td[2]/input")).click();
		driver.findElement(By.name("reponse[1]")).click();
		driver.findElement(By.name("reponse[1]")).sendKeys("answer 1");
		driver.findElement(By.name("weighting[1]")).clear();
		driver.findElement(By.name("weighting[1]")).sendKeys("3");
		driver.findElement(By.name("reponse[2]")).click();
		driver.findElement(By.name("reponse[2]")).sendKeys("answer 2");
		driver.findElement(By.name("weighting[2]")).clear();
		driver.findElement(By.name("weighting[2]")).sendKeys("-3");
		driver.findElement(By.name("submitAnswers")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Exercise 1")).click();  

		Thread.sleep(1000);

		driver.findElement(By.linkText("New question")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("questionName")).sendKeys("Question 2");
		driver.findElement(By.id("answerType5")).click();
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='claroBody']/form/table/tbody/tr[1]/td[2]/input")).click();
		driver.findElement(By.name("weighting[1]")).clear();
		driver.findElement(By.name("weighting[1]")).sendKeys("3");
		driver.findElement(By.name("weighting[2]")).clear();
		driver.findElement(By.name("weighting[2]")).sendKeys("-3");
		driver.findElement(By.name("submitAnswers")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Exercise 1")).click();

		Thread.sleep(1000);

		driver.findElement(By.linkText("New question")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("questionName")).sendKeys("Question 3");
		driver.findElement(By.id("answerType2")).click();
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);

		driver.findElement(By.name("moreAnswers")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("correct[1]")).click();
		driver.findElement(By.name("reponse[1]")).click();
		driver.findElement(By.name("reponse[1]")).sendKeys("answer 3");
		driver.findElement(By.name("weighting[1]")).clear();
		driver.findElement(By.name("weighting[1]")).sendKeys("3");
		driver.findElement(By.name("reponse[2]")).click();
		driver.findElement(By.name("reponse[2]")).sendKeys("answer 4");
		driver.findElement(By.name("weighting[2]")).clear();
		driver.findElement(By.name("weighting[2]")).sendKeys("0");
		driver.findElement(By.name("reponse[3]")).click();
		driver.findElement(By.name("reponse[3]")).sendKeys("answer 5");
		driver.findElement(By.name("weighting[3]")).clear();
		driver.findElement(By.name("weighting[3]")).sendKeys("-3");
		driver.findElement(By.name("submitAnswers")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Exercise 1")).click();  

		assertEquals("1. Question 1\nMultiple choice (Unique answer)", driver.findElement(By.xpath(".//*[@id='claroBody']/table/tbody/tr[1]/td[1]")).getText());
		assertEquals("2. Question 2\nTrue/False", driver.findElement(By.xpath(".//*[@id='claroBody']/table/tbody/tr[3]/td[1]")).getText());
		assertEquals("3. Question 3\nMultiple choice (Multiple answers)", driver.findElement(By.xpath(".//*[@id='claroBody']/table/tbody/tr[5]/td[1]")).getText());




		driver.findElement(By.linkText("Logout")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
