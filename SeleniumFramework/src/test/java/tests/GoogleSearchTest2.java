package tests;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import config.propertiesdemo;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class GoogleSearchTest2 {
	public static WebDriver driver = null;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test1;
	ExtentTest test2;
	public static String BrowserName=null;
	
	@BeforeSuite
	public void SetUp()
	{
		htmlReporter = new ExtentSparkReporter("rep.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		
	}
	@Parameters("BrowserName")
	@BeforeTest
	public void driversetUp(String BrowserName) throws IOException
	{
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\shrik\\eclipse-workspace\\SeleniumFramework\\drivers\\chromedriver\\chromedriver.exe");
		//propertiesdemo.getProperties();
		
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			try
			{
				
			System.out.println("Chorme browser");
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 
			}
			catch(Exception e)
			{
			  e.printStackTrace();
			}
		}
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			try {
			System.out.println("firefox browser");
			System.setProperty("webdriver.gecko.driver","C:\\Users\\shrik\\eclipse-workspace\\SeleniumFramework\\drivers\\geckodriver\\geckodriver.exe");
		 driver=new FirefoxDriver();
		 driver.manage().window().maximize();
			}
		 catch(Exception e)
			{
			  e.printStackTrace();
			}
		}
		
	}
	@Test
	public void Search() throws InterruptedException {
		test1=extent.createTest("My test","sample");
		
		GoogleSearchPage.Url_page(driver);
		GoogleSearchPage.Search_Box(driver).sendKeys("qwerty");
		test1.pass("Keys sent to textbox");
		GoogleSearchPage.Enter_Box(driver).sendKeys(Keys.RETURN);
		test1.pass("Searching is returned");
		
	}
	
	@AfterTest
	public void Finish()
	{
		
		driver.close();
		test1.pass("browser closed");
		//test2.pass("browser closed");
		
		extent.flush();
	}

}
