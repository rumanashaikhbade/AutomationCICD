package rahulshettyacademy.Tests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.PaymentScreen;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{
	String productName = "ZARA COAT 3";
	@Test(dataProvider = "getData", groups = {"Purchase"})
	public void SubmitTest(HashMap<String, String> input) throws IOException, InterruptedException
	{
			
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));		
		List<WebElement> products = productCatalogue.getProductList();
		
		WebElement prod = productCatalogue.getProductName(input.get("productName"));
		
		productCatalogue.addToCart(input.get("productName"));		
		
		CartPage cartPage = landingPage.goToCart();

		boolean match = cartPage.cartPageProducts(input.get("productName"));
				
		Assert.assertTrue(match);	
		
		PaymentScreen paymentScreen = cartPage.checkOutCart();
	
		String msg = paymentScreen.selectCountry("india");
		Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));		
	}

	
	@Test(dependsOnMethods= {"SubmitTest"})
	public void OrderHistoryTest()
	{
		ProductCatalogue productCatalogue = landingPage.loginApplication("rumanas@gmail.com", "Abc@1234");	
		OrderPage orderPage = productCatalogue.goToOrders();
		Assert.assertTrue(orderPage.VerifyOrderPageProducts(productName));
	}
	
//	@DataProvider
//	@Test
//	public Object[][] getData()
//	{
//		 return new Object[][] {{"rumanas@gmail.com","Abc@1234","ZARA COAT 3" },{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
//	}
	
	@DataProvider
	@Test
	public Object[][] getData() throws IOException
	{
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "rumanas@gmail.com");
//		map.put("password", "Abc@1234");
//		map.put("productName", "ZARA COAT 3");
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "shetty@gmail.com");
//		map1.put("password", "Iamking@000");
//		map1.put("productName", "ADIDAS ORIGINAL");
		
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	
	
}

