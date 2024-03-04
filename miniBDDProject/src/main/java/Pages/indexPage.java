package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.WaitHelper;

public class indexPage {
 
	
	public WebDriver driver;
	WaitHelper waithelper;

	public indexPage(WebDriver driver)
	{
		this.driver= driver;
		waithelper= new WaitHelper(driver);

		}
	//locators
	 By myAccount = By.xpath("//span[text()='My Account']");
	 By login = By.xpath("//a[text()='Login']");
	 By Register = By.xpath("//a[text()='Register']");
	 By logo= By.xpath("//img[@title='naveenopencart']");
	 By Searchbox = By.name(("search"));
	 By SearchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
	 By productList = By.xpath("//h4//a");
	 
	 public void clickOnMyAccount()
	 {
		 driver.findElement(myAccount).click();
	 }
    
	 public boolean validateLogo()
	 {
	return driver.findElement(logo).isDisplayed();
	 }
	 
	 public String getTitle()
	 {
		String title= driver.getTitle();
		return title;
	 }
	 
	 public void SearchProducts(String item)
	 {
	 WebElement searchprodbox = driver.findElement(Searchbox);
	 searchprodbox.sendKeys(item);
     }

	 public void ClickSearchbutton()
	 {
		
		 driver.findElement(SearchButton).click();
		 waithelper.waitForElementtoAppear(productList);
	 }
	 
	 public boolean productdisplayed()
	 {
	 return driver.findElement(productList).isDisplayed();
	 }
	 
	 public void clickLogin()
	 {
		 
		 driver.findElement(login).click();
		
	 }
}
