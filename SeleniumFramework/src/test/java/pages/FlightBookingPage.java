package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightBookingPage {

	public static WebElement element=null;
	
	public static void trip_url(WebDriver driver)
	{
		driver.get("https://www.makemytrip.com/flights/");
	}
	
	public static WebElement from(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//span[text()='From']"));
		return element;
	}
	
	public static WebElement JustClick(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//div[@data-cy='outsideModal']"));
		return element;
	}
	
	public static WebElement to(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//span[text()='To']"));
		return element;
	}
	
	public static WebElement srch(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//a[text()='Search']"));
		return element;
	}
	
	public static WebElement checkbox(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//span[text()='Refundable Fares']"));
		return element;
	}
	
	
	
	
	
	

}
