package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class PaymentScreen extends AbstractComponent{
	WebDriver driver;

	public PaymentScreen(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".form-group input")
	WebElement country;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement countryList;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(css=".hero-primary")
	WebElement textMsg;
	
	By ele = By.cssSelector(".ta-results");
	
	public String selectCountry(String cnt)
	{
		Actions a = new Actions(driver);
		a.sendKeys(country, cnt).build().perform();
		waitForElementToappear(ele);
		
		countryList.click();
		submit.click();
		waitForElementToappear(By.cssSelector(".hero-primary"));
		return textMsg.getText();	
		
	}
	
	
}
