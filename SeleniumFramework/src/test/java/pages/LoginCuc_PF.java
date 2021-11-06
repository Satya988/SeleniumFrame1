package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class LoginCuc_PF {
	WebDriver driver;
	
	@FindBy(id="name")
	WebElement txt_username;
	
	@FindBy(id="password")
	WebElement txt_password;

	@FindBy(id="login")
	WebElement btn_login;
	
	public LoginCuc_PF(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void Url_navigation()
	{
		driver.navigate().to("https://example.testproject.io/web/");
	}
	
	public void enterUsername(String username)
	{
		txt_username.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		txt_password.sendKeys(password);
	}
	
	public void ClickLogin()
	{
		btn_login.click();
	}
	
	
}
