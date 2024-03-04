package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utilities.WaitHelper;

public class LoginPage {
	
	public WebDriver driver;
	
	WaitHelper waithelper;
	//locators
	 By emailInputLocator = By.name("email");
	 By passwordInputLocator = By.name("password");
     By loginButtonLocator = By.xpath("//input[@type='submit']");
	 By forgottenPasswordLinkLocator = By.linkText("Forgotten Password");
     By logoutLinkLocator = By.linkText("Logout");
         
	//constructor
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		waithelper= new WaitHelper(driver);
	}
	
	//methods
	public void enterEmail(String email)
	{
	WebElement emailInput =driver.findElement(emailInputLocator);
	emailInput.sendKeys(email);
	waithelper.waitForElementtoAppear(emailInputLocator);
    }
	
	public void enterPassword(String password)
	{
	    WebElement passwordInput =driver.findElement(passwordInputLocator);
		passwordInput.sendKeys(password);
		waithelper.waitForElementtoAppear(passwordInputLocator);

	}
	
	public void clickLoginButton()
	{
	WebElement loginButton=driver.findElement(loginButtonLocator);	
	loginButton.click();
	}
	
	
	public void clickForgottenPasswordLink()
	{
		WebElement ForgottenPasswordLink = driver.findElement(forgottenPasswordLinkLocator);
		ForgottenPasswordLink.click();
	}
	public boolean checkForgotPwdLink()
	{
	return	driver.findElement(forgottenPasswordLinkLocator).isDisplayed();
	}
	
	public boolean checkLogoutLink()
	{
	return driver.findElement(logoutLinkLocator).isDisplayed();
	}
	
    public void login( String email, String password)
    {
    	enterEmail(email);
    	enterPassword(password);
    	clickLoginButton();
    	 }
    public String getForgotPwdPageUrl()
    {
    String forgotPwdPageUrl =driver.getCurrentUrl();
    return forgotPwdPageUrl;
    }
    
  
}
