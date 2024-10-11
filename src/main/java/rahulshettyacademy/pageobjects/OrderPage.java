package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class OrderPage extends AbstractComponent{
	WebDriver driver;

	public OrderPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ProductNames;
	
//	@FindBy(css=".totalRow button")
//	WebElement checkOut;
	

	
	public boolean VerifyOrderPageProducts(String productName)
	{
		boolean match = ProductNames.stream()
				.anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		//checkOut.click();
		return match;
	}
	
	
	
}
