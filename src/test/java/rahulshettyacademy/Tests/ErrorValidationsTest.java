package rahulshettyacademy.Tests;
import rahulshettyacademy.TestComponents.Retry;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.PaymentScreen;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest{

	@Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
	public void LoginValidationTest() throws IOException, InterruptedException
	{
		String productName = "ZARA COAT 3";	
		landingPage.loginApplication("rumanas@gmail.com", "Abc@134");	
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
		
	
	}

	@Test
	public void ProductValidationsTest() throws IOException, InterruptedException
	{
		String productName = "ZARA COAT 3";	
		ProductCatalogue productCatalogue = landingPage.loginApplication("rumanas@gmail.com", "Abc@1234");		
		List<WebElement> products = productCatalogue.getProductList();
		
		productCatalogue.getProductName(productName);
		
		productCatalogue.addToCart(productName);		
		
		CartPage cartPage = landingPage.goToCart();

		boolean match = cartPage.cartPageProducts("ZARA COAT 33");
				
		Assert.assertFalse(match);
		
	
	}
}

