package rahulshettyacademy.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.PaymentScreen;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest{
	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public CartPage cartPage;
	public PaymentScreen paymentScreen;
	public String msg;
	
	@Given("I landed on Ecommerce page")
	public void i_landed_on_ecommerce_page() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		landingPage = launchApplication();
	}
	
	@Given ("^Logged in with username (.+) and pwd (.+)$")
	public void logged_in_with_username_and_pwd(String username, String password)
	{
		productCatalogue = landingPage.loginApplication(username,password);
	}
	
	@When ("^I add product (.+) from cart$")
	public void i_add_product_from_cart(String productName) throws InterruptedException
	{
		WebElement prod = productCatalogue.getProductName(productName);		
		productCatalogue.addToCart(productName);
	}
	
	@And("^CheckOut (.+) and submit the order$")
	public void checkOut_and_Submit_the_order(String productName)
	{
	    cartPage = landingPage.goToCart();

		boolean match = cartPage.cartPageProducts(productName);				
		//Assert.assertTrue(match);			
		paymentScreen = cartPage.checkOutCart();
	    msg = paymentScreen.selectCountry("india");
	}
	
	@Then("{string} msg is displayed")
	public void msg_is_displayed(String string)
	{
		Assert.assertTrue(msg.equalsIgnoreCase(string));	
		driver.close();
	}
	
	@Then("{string} Incorrect msg is displayed")
	public void incorrect_msg_is_displayed(String string)
	{
		Assert.assertEquals(string,landingPage.getErrorMessage());
		driver.close();
	}
	
	
}
