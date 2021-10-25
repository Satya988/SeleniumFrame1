package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.FlightBookingPage;

@Listeners(listeners.TestNGlisteners.class)
public class FlightBooking {

	public static WebDriver driver;
	 ExtentSparkReporter htmlReporter;
	 ExtentReports extent;
	 ExtentTest test1;
	@BeforeSuite
	public void Setup()
	{
		htmlReporter = new ExtentSparkReporter("flight.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void driversetup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void book() throws InterruptedException
	{
		
		test1=extent.createTest("Flight Page Test","Make my trip");
		FlightBookingPage.trip_url(driver);
		test1.pass("Navigated to website");
		FlightBookingPage.JustClick(driver).click();
		
		FlightBookingPage.from(driver).click();
		
		
		driver.findElement(By.xpath("//p[text()='Chennai, India']")).click();
		test1.pass("FROM success");
		FlightBookingPage.to(driver).click();
		
		driver.findElement(By.xpath("//p[text()='Delhi, India']")).click();
		test1.pass("TO success");
		FlightBookingPage.srch(driver).click();
		test1.pass("Search Success");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(60, TimeUnit.SECONDS)
			       .pollingEvery(3, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

			   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			    	 String a;
			    	
			     WebElement j=  FlightBookingPage.checkbox(driver);
			     
			     
			     j.click();
			     test1.pass("Checkbox click Success");
			     
			     JavascriptExecutor js = (JavascriptExecutor) driver;
			     js.executeScript("window.scrollBy(0,80000)");
			     
			    
			   
			     if(j.isEnabled())
			     {
			    	 
			    	 List<WebElement> k=driver.findElements(By.xpath("//div[@class='listingCard']/div/div/div/span"));
			    	 int count=0;
			 		for(WebElement k1:k)
			 			count++;
			 		System.out.println("Number of Refundable flights:"+count);
			 		
			 		System.out.println("List of Refundable Flights:");
			 		for(int i=1;i<=count;i++)
			 		{
			 			a= driver.findElement(By.xpath("(//div[@class='listingCard']/div/div/div/span)["+i+"]")).getText();
			 			
			 			
			 			System.out.println(a);
			 		}
			     }
			     return j;
			     }
			   });
			   
			 

	}
	
	 
	
	@AfterTest
	public void Finish()
	{
		driver.close();
		 test1.pass("Close success");
		 extent.flush();
		
	}
}
