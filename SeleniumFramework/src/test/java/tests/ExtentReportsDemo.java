package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;


public class ExtentReportsDemo {
	private static WebDriver driver = null;


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("rep.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test1=extent.createTest("My test","sample");
		
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 test1.log(Status.PASS, "starting test");
		 driver.get("https://google.com");
		 test1.pass("navigate to google");
			GoogleSearchPage.Search_Box(driver).sendKeys("qwerty");
			test1.pass("textbox success");
			GoogleSearchPage.Enter_Box(driver).sendKeys(Keys.RETURN);
			test1.pass("search success");
			
			driver.close();
			test1.pass("browser closed");
			extent.flush();

	}

}
