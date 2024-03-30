package yess;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractreusable.reused;


public class CART extends reused {
	WebDriver driver;
	public CART(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this); //trigger to initaialize below elements 
	}
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;
	
	public Boolean VerifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return match;
	}
	public CheckoutPage goToCheckout() {
		checkoutEle.click();
		return null;
		
	}
}
		
	
