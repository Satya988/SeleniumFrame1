package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchPage {
	private static WebElement element = null;
	
public static void Url_page(WebDriver driver) {
		
	driver.get("https://google.com");
	}
	public static WebElement Search_Box(WebDriver driver) {
		
		element=driver.findElement(By.name("q"));
		return element;
	}
	public static WebElement Enter_Box(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		element=driver.findElement(By.name("btnK"));
		return element;
	}

}
