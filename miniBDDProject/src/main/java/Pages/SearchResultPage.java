package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.WaitHelper;

public class SearchResultPage {
	
	public WebDriver driver;
	WaitHelper waithelper;

	 public SearchResultPage(WebDriver driver) 
	 {
		 this.driver= driver;
		 waithelper= new WaitHelper(driver);

		 }
	

   By productList = By.xpath("//h4//a");
   By Quantity = By.name("quantity");
   By cartButton = By.xpath("//button[@id='button-cart']");
   By Message = By.xpath("//div[@class='alert alert-success alert-dismissible']");
  
  
  public void ProductFromList()
  {
	  List<WebElement> products=driver.findElements(productList);
	  for(WebElement product:products)
	  {
	 	if(product.getText().equalsIgnoreCase("MacBook Air"))
	 	{
	 	product.click();
	 	break;
	 	}
	 }
  }
 
  public void SelectQuantity(String quanti)
  {
	  waithelper.waitForElementtoAppear(cartButton);
	  WebElement quantity= driver.findElement(Quantity);
  	   quantity.clear();
  	   quantity.sendKeys(quanti);
  }     
  
  public void addToCart()
  {
	  driver.findElement(cartButton).click();
	  
  }

  public boolean SuccessMsg()
  {
	  waithelper.waitForElementtoAppear(Message);
	  return driver.findElement(Message).isDisplayed();
  }
  
  public String getPageTitle()
  {
	return driver.getTitle();
  }
  
}