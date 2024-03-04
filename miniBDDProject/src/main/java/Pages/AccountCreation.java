package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.WaitHelper;

public class AccountCreation {

	public WebDriver driver;
	WaitHelper waithelper;

	 
	 public AccountCreation(WebDriver driver) 
	 {
		 this.driver= driver;
		 waithelper= new WaitHelper(driver);

		 }
	        //locators
	 
	 // By formTitle = By.xpath("//h1[contains(text(),'Register Account')]");
	  By registerAccount = By.xpath("//a[@class='btn btn-primary']");
	  By FirstName= By.name("firstname");
	  By LastName = By.name("lastname");
	  By EmailId = By.name("email");
	  By Telephone = By.name("telephone");
	  By Password = By.name("password");
	  By ConfirmPass = By.name("confirm");
	  By Checkbox = By.name("agree");
	  By ContinueButton = By.xpath("//input[@value='Continue']");
	  By AccCreationMsg = By.xpath("//div[@id='content']/h1");
	  

	// public boolean validateAccountCreation()
	// {
	//	return driver.findElement(formTitle).isDisplayed();
	// }
	 
	 public void RegisterNewAccount()
	   {
		   driver.findElement(registerAccount).click();
		   waithelper.waitForElementtoAppear(FirstName);
	   }
	 
	 public String getPageTitle()
	   {
		return driver.getTitle();
	   }
	 
	 public void setFirstname(String fname)
	 {
		 driver.findElement(FirstName).sendKeys(fname);
	 }
	 
	 public void setLstname(String lname)
	 {
		 driver.findElement(LastName).sendKeys(lname);
	 }
	 
	 public void setEmail(String email)
	 {
		 driver.findElement(EmailId).sendKeys(email);
	 }
	 
	 public void setPhoneno(String phno)
	 {
		 driver.findElement(Telephone).sendKeys(phno);
	 }
	 
	 public void setPassword(String pass)
	 {
		 driver.findElement(Password).sendKeys(pass);
	 }
	 
	 public void setConfirmPass(String conpass)
	 {
		 driver.findElement(ConfirmPass).sendKeys(conpass);
	 }
	 
	 public void clickOncheckbox()
	 {
		 driver.findElement(Checkbox).click();
		 waithelper.waitForElementtoAppear(ContinueButton);
		}
	 
	 public void clickOncontinue()
	 {
		 driver.findElement(ContinueButton).click();
	 }
	 
	 public boolean AccountCreatedmsg()
	 {
		 waithelper.waitForElementtoAppear(AccCreationMsg);
		return driver.findElement(AccCreationMsg).isDisplayed();
	 }
}

