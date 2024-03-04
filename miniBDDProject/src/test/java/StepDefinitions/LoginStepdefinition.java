package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.AccountCreation;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SearchResultPage;
import Pages.indexPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdefinition {
	
	public WebDriver driver;
	public LoginPage loginPage;
	public indexPage indexpage;
	public HomePage homepage;
	public AccountCreation accountcreation;
	public SearchResultPage searchresult;
	
	@Before
	public void setup()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown()
	{
		if(driver!=null) {
			driver.quit();
		}
	}
	//index
	

   @Given("User is on Index page")
    public void user_is_on_index_page() {
	   driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       indexpage= new indexPage(driver);
   }

    @When("User searches for product in search box")
    public void user_searches_for_product_in_search_box() throws InterruptedException {
    	indexpage.SearchProducts("mac");
    	indexpage.ClickSearchbutton();
    	Thread.sleep(2000);
        }

    @Then("User should see product")
    public void user_should_see_product() {
    	Assert.assertEquals(indexpage.productdisplayed(), true);
         }

     @Then("User should be able to see Logo")
    public void user_should_be_able_to_see_logo() {
     Assert.assertEquals(indexpage.validateLogo(), true);
     }

     @When("User click on My Account")
     public void user_click_on_my_account() {
    	 indexpage.clickOnMyAccount();
     }

     @When("User click on Login")
     public void user_click_on_login() throws InterruptedException {
     indexpage.clickLogin();
     Thread.sleep(3000);
    }

     @Then("Login Page should be displayed")
     public void login_page_should_be_displayed() {
      Assert.assertEquals("Account Login", indexpage.getTitle());
         }



	//login
	@Given("I am on the OpenCart login page")
	public void i_am_on_the_open_cart_login_page() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				 loginPage= new LoginPage(driver);
	}

	@Given("I have entered a valid username and password")
	public void i_have_entered_a_valid_username_and_password() throws InterruptedException {
	  
		loginPage.enterEmail("zaishasarang3@gmail.com");
		loginPage.enterPassword("Hello12");
	    	}
	
	@Given("I have entered invalid {string} and {string}")
	public void i_have_entered_invalid_and(String username, String password) throws InterruptedException {
		loginPage.enterEmail(username);
		loginPage.enterPassword(password);
	    	}
	
	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		loginPage.clickLoginButton();
	 	}

	
	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
	   Assert.assertEquals(loginPage.checkLogoutLink(),true);
	}


	@Then("I should see an error message indicating {string}")
	public void i_should_see_an_error_message_indicating(String errorMessage) {
		Assert.assertEquals(driver.findElement(By.cssSelector(".alert.alert-danger")).isDisplayed(), true);
	}
	
	@When("I click on the \"Forgotten Password\" link")
	public void i_click_on_the_forgotten_password_link()
	{
		loginPage.clickForgottenPasswordLink();
	}

   
	@Then("I should be redirected to the password reset page")
	public void i_should_be_redirected_to_the_password_reset_page() throws InterruptedException {
	    Assert.assertTrue(loginPage.getForgotPwdPageUrl().contains("account/forgotten"));
	    Thread.sleep(3000);
	}
	//homepage
	
	@Given("User is on Homepage")
	public void user_is_on_homepage() {
    homepage= new HomePage(driver);
	Assert.assertEquals("My Account", homepage.getPageTitle());
   	}

	@When("User clicks on Edit Account")
	public void user_clicks_on_edit_account() {
	   homepage.clickEditAccount();
	}

	@Then("User should be redirected to edit account page")
	public void user_should_be_redirected_to_edit_account_page() {
		 Assert.assertEquals("My Account Information", homepage.getPageTitle());
	}

	@When("User makes changes in field")
	public void user_makes_changes_in_field() {
		homepage.changeTeleno("8396014367");
	}

	@When("click on continue")
	public void click_on_continue() {
		homepage.clickContinue();
	}
	@Then("User should see a success msg")
	public void user_should_see_a_success_msg() {
	 Assert.assertEquals(homepage.msgDisplayed(), true);
	   	}
	
	@Then("User should be able to see Wish List in section menu")
	public void user_should_be_able_to_see_wish_list_in_section_menu() {
	Assert.assertEquals(homepage.validateMyWIshlist(), true);	
	}

	@Then("User should be able to see Order History in section menu")
	public void user_should_be_able_to_see_order_history_in_section_menu() {
	   Assert.assertEquals(homepage.validateOrderHistory(), true);
	}

	@When("User click on password")
	public void user_click_on_password() {
		homepage.clickOnPassword();
	}

	@Then("User should be redirected to change password page")
	public void user_should_be_redirected_to_change_password_page() {
      Assert.assertEquals("Change Password", homepage.getPageTitle());
	}

	@When("click on Home icon")
	public void click_on_home_icon() {
	   homepage.clickHomeButton();
	}

	@Then("User should be back to index page")
	public void user_should_be_back_to_index_page() throws InterruptedException {
	   Assert.assertEquals("Your Store", homepage.getPageTitle());
	   
	}

	@When("User click on continue")
	public void user_click_on_continue() {
		accountcreation = new AccountCreation(driver);
		accountcreation.RegisterNewAccount();
	}

	@Then("User should be redirected to Register account page")
	public void user_should_be_redirected_to_register_account_page() {
	   Assert.assertEquals("Register Account", accountcreation.getPageTitle());
	}


    @When("User enters Personal details")
     public void user_enters_personal_details() {
    	accountcreation.setFirstname("alisha");
    	accountcreation.setLstname("shiekh");
    	accountcreation.setEmail("alisha12@gmail.com");
    	accountcreation.setPhoneno("8495074368");
    	accountcreation.setPassword("Newworld10");
    	accountcreation.setConfirmPass("Newworld10");
    	accountcreation.clickOncheckbox();
    	
    }

     @And("User click on continue button")
     public void user_click_on_continue_button() {
    	 accountcreation.clickOncontinue();
    }

     @Then("User should get account creation msg")
     public void user_should_get_account_creation_msg() {
    	Assert.assertEquals(accountcreation.AccountCreatedmsg(), true);
     }
  // add product
     @When("User click on the product")
     public void user_click_on_the_product() {
    	 searchresult= new SearchResultPage(driver);
    	 searchresult.ProductFromList();
     }

     @Then("User should be redirected to product specification page")
     public void user_should_be_redirected_to_product_specification_page() {
    	Assert.assertEquals("MacBook Air", searchresult.getPageTitle());
     }

     @Then("User selects the quantity")
     public void user_selects_the_quantity() {
    	 searchresult.SelectQuantity("2");
     }

     @When("User click on Add to cart")
     public void user_click_on_add_to_cart() {
         searchresult.addToCart();
     }
     
     @Then("User should see a product added msg")
     public void user_should_see_a_product_added_msg() {
         Assert.assertEquals(searchresult.SuccessMsg(), true);
     }








}
