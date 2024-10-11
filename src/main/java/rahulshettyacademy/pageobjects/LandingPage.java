package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{
	WebDriver driver;

	public LandingPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement email = driver.findElement(By.id("userEmail"));
	
	//PageFactory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMsg;
	
	public ProductCatalogue loginApplication(String email, String pwd)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(pwd);
		loginBtn.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToappear(errorMsg);
		return errorMsg.getText();
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
		//driver.manage().window().maximize();
	}
}
