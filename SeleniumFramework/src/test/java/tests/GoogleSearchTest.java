package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class GoogleSearchTest {
	private static WebDriver driver = null;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test1;
	ExtentTest test2;
	@BeforeSuite(alwaysRun=true)
	public void SetUp()
	{
		htmlReporter = new ExtentSparkReporter("rep.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		
	}
	@BeforeTest(alwaysRun=true)
	public void driversetUp()
	{
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\shrik\\eclipse-workspace\\SeleniumFramework\\drivers\\chromedriver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
	}
	//@Test(dependsOnGroups= {"smoke"})
	@Test
	public void Search() throws InterruptedException {
		test1=extent.createTest("My test","sample");
		 
		GoogleSearchPage.Url_page(driver);
		GoogleSearchPage.Search_Box(driver).sendKeys("qwertyu");
		test1.pass("Keys sent to textbox");
		GoogleSearchPage.Enter_Box(driver).sendKeys(Keys.RETURN);
		test1.pass("Searching is returned");
		
	}
	//@Test(groups= {"smoke"})
	@Test(retryAnalyzer=listeners.RetryAnalyzer.class)
	
	public void Search2() throws InterruptedException {
		int i = 1/0;
		test2=extent.createTest("My test","sample");
		
		GoogleSearchPage.Url_page(driver);
		GoogleSearchPage.Search_Box(driver).sendKeys("zxcvbn");
		test2.pass("Keys sent to textbox2");
		GoogleSearchPage.Enter_Box(driver).sendKeys(Keys.RETURN);
		test2.pass("Searching is returned2");
		
	}
	@AfterTest(alwaysRun=true)
	public void Finish()
	{
		
		driver.close();
		test1.pass("browser closed");
		test2.pass("browser closed");
		
		extent.flush();
	}

}
