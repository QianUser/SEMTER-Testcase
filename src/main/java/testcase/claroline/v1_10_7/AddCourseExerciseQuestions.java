package testcase.claroline.v1_10_7;

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
		driver.get("http://localhost/claroline/claroline-1.10.7/");
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.name("submitAuth")).click();

		driver.findElement(By.linkText("1 - Math")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("CLQWZ")).click();

		driver.findElement(By.xpath("(//img[@alt='Modify'])[2]")).click();

		driver.findElement(By.linkText("New question")).click();
	
		driver.findElement(By.id("title")).sendKeys("Question 1");
		driver.findElement(By.id("MCUA")).click();
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("correct_1")).click();
		driver.findElement(By.id("answer_1_ifr")).click();
		driver.findElement(By.id("answer_1_ifr")).sendKeys("answer 1");
		driver.findElement(By.name("grade_1")).clear();
		driver.findElement(By.name("grade_1")).sendKeys("3");
		driver.findElement(By.id("answer_2_ifr")).click();
		driver.findElement(By.id("answer_2_ifr")).sendKeys("answer 2");
		driver.findElement(By.name("grade_2")).clear();
		driver.findElement(By.name("grade_2")).sendKeys("-3");
		driver.findElement(By.name("cmdOk")).click();
		Thread.sleep(2000);





		driver.findElement(By.linkText("New question")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("title")).sendKeys("Question 2");
		driver.findElement(By.id("TF")).click();
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("trueCorrect")).click();
		driver.findElement(By.name("trueGrade")).clear();
		driver.findElement(By.name("trueGrade")).sendKeys("3");
		driver.findElement(By.name("falseGrade")).clear();
		driver.findElement(By.name("falseGrade")).sendKeys("-3");
		driver.findElement(By.name("cmdOk")).click();
		Thread.sleep(2000);



		Thread.sleep(1000);

		driver.findElement(By.linkText("New question")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("title")).sendKeys("Question 3");
		driver.findElement(By.id("MCMA")).click();
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);

		driver.findElement(By.name("cmdAddAnsw")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("correct_1")).click();
		driver.findElement(By.id("answer_1_ifr")).click();
		driver.findElement(By.id("answer_1_ifr")).sendKeys("answer 3");
		driver.findElement(By.name("grade_1")).clear();
		driver.findElement(By.name("grade_1")).sendKeys("3");
		driver.findElement(By.id("answer_2_ifr")).click();
		driver.findElement(By.id("answer_2_ifr")).sendKeys("answer 4");
		driver.findElement(By.name("grade_2")).clear();
		driver.findElement(By.name("grade_2")).sendKeys("0");
		driver.findElement(By.id("answer_3_ifr")).click();
		driver.findElement(By.id("answer_3_ifr")).sendKeys("answer 5");
		driver.findElement(By.name("grade_3")).clear();
		driver.findElement(By.name("grade_3")).sendKeys("-3");
		driver.findElement(By.name("cmdOk")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Exercise 1")).click();

		assertEquals("Question 1", driver.findElement(By.xpath(".//*[@id='claroBody']/table/tbody/tr[1]/td[2]")).getText());
		assertEquals("Question 2", driver.findElement(By.xpath(".//*[@id='claroBody']/table/tbody/tr[2]/td[2]")).getText());
		assertEquals("Question 3", driver.findElement(By.xpath(".//*[@id='claroBody']/table/tbody/tr[3]/td[2]")).getText());
		assertEquals("Multiple choice (Unique answer)", driver.findElement(By.xpath(".//*[@id='claroBody']/table/tbody/tr[1]/td[4]")).getText());
		assertEquals("True/False", driver.findElement(By.xpath(".//*[@id='claroBody']/table/tbody/tr[2]/td[4]")).getText());
		assertEquals("Multiple choice (Multiple answers)", driver.findElement(By.xpath(".//*[@id='claroBody']/table/tbody/tr[3]/td[4]")).getText());

		driver.findElement(By.linkText("Logout")).click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
