package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LogoutCuc_PF {
WebDriver driver;
	
	@FindBy(id="logout")
	WebElement dis_logout;
	
	
	
	public LogoutCuc_PF(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void DisplayLogout()
	{
		dis_logout.isDisplayed();
		
	}
}
