package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.WaitHelper;

public class HomePage {
 public WebDriver driver;
 WaitHelper waithelper;

 public HomePage(WebDriver driver) 
 {
	 this.driver= driver;
	 waithelper= new WaitHelper(driver);

	 }
        //locators
 
       By wishList= By.xpath("//div[@class='list-group']//a[text()='Wish List']");
       By EditAccount = By.xpath("//div[@class='list-group']//a[text()='Edit Account']");
 	   By BackToHome = By.xpath("//ul[@class='breadcrumb']//i");
       By OrderHistory = By.xpath("//div[@class='list-group']//a[text()='Order History']");
       By telephoneno = By.name("telephone");
       By continueButton = By.xpath("//input[@value='Continue']");
       By msg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
       By password = By.xpath("//a[text()='Password']");
       By logo= By.xpath("//img[@title='naveenopencart']");
       
       public boolean validateMyWIshlist()
       {
    	   waithelper.waitForElementtoAppear(wishList);
    	return driver.findElement(wishList).isDisplayed();
       }
       
       public boolean validateOrderHistory()
       {
    	return driver.findElement(OrderHistory).isDisplayed();
       }
       
       public void clickHomeButton()
       {
    	   driver.findElement(BackToHome).click();
    	  waithelper.waitForElementtoAppear(logo);
       }
       
       public void clickEditAccount()
       {
    	
    	   driver.findElement(EditAccount).click();
    	  waithelper.waitForElementtoAppear(telephoneno);
       }
       
       public void changeTeleno(CharSequence phoneno)
       {
    	WebElement telNo =  driver.findElement(telephoneno);
    	telNo.clear();
    	telNo.sendKeys(phoneno);
       }
       public void clickContinue()
       {
    	 driver.findElement(continueButton).click();
       }
       
       public boolean msgDisplayed()
       {
    	   waithelper.waitForElementtoAppear(BackToHome);
    	 return driver.findElement(msg).isDisplayed();
       }
       public String getPageTitle()
       {
    	return driver.getTitle();
       }
       
       public void clickOnPassword()
       {
    	   driver.findElement(password).click();
       }
       
}
