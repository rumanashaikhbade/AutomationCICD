package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;

	public CartPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkOut;
	

	
	public boolean cartPageProducts(String productName)
	{
		boolean match = cartProducts.stream()
				.anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		//checkOut.click();
		return match;
	}
	
	public PaymentScreen checkOutCart()
	{
		waitForElementToappear(By.cssSelector(".totalRow button"));
		checkOut.click();
		PaymentScreen paymentScreen = new PaymentScreen(driver);
		return paymentScreen;
	}
	
	
}
