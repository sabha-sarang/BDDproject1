package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCart {

	public WebDriver driver;
	 
	 public AddToCart(WebDriver driver) 
	 {
		 this.driver= driver;
		 }
	 By quantity = By.id("input-quantity");
	 By AddToCart = By.xpath("//button[text()='Add to Cart']");
	 By msg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	 By checkOut = By.xpath("//span[text()='Checkout']");
	 
	 public void addQuantity()
	 {
	WebElement Productquan =driver.findElement(quantity);
	Productquan.clear();
	Productquan.sendKeys("2");
	 }
	 
	 public void addToCartButton()
	 {
		 driver.findElement(AddToCart).click();
	 }
     
	 public boolean SuccessMsg()
	 {
		return driver.findElement(msg).isDisplayed();
	 }
	 
	 public void ClickCheckout()
	 {
		 driver.findElement(checkOut).click();
	 }
}
