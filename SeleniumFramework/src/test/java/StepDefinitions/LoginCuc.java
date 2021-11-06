package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginCuc_PF;
import pages.LogoutCuc_PF;

public class LoginCuc {
	
	WebDriver driver=null;
	LoginCuc_PF login;
	LogoutCuc_PF logout;
	
	@Before
	public void DriverSetup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Given("is on login page")
	public void is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		
	    login=new LoginCuc_PF(driver);
	    
	    login.Url_navigation();
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username,String password) {
	    // Write code here that turns the phrase above into concrete actions
		
		login.enterUsername(username);
		login.enterPassword(password);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		login.ClickLogin();
	}

	@Then("Lands on the home page")
	public void lands_on_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		logout=new LogoutCuc_PF(driver);
		logout.DisplayLogout();
		
		
	}
	
	@After
	public void DriverClose()
	{
		driver.close();
		
	}
}
