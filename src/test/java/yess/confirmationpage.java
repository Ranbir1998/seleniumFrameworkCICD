package yess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractreusable.reused;

public class confirmationpage extends reused {
WebDriver driver;
	public confirmationpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver,this); 

	}
	@FindBy(css="[.hero-primary]")
	WebElement confirmation;
	public String getConfirmationMessage()
	{
		return confirmation.getText();
	}
}
