package yess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractreusable.reused;

public class CheckoutPage extends reused {
WebDriver driver;
public CheckoutPage(WebDriver driver) {
	super(driver);
	this.driver = driver;
	PageFactory.initElements(driver,this); 
	
}
@FindBy(css="[placeholder*='Select']")
WebElement country;

By results = By.cssSelector(".ta-results");

@FindBy(css="[.action__submit]")
WebElement submit;

@FindBy(xpath="[//button[contains(@class,'ta-item')][2]]")
WebElement selectindia;

public void selectCountry(String countryName)
{
	driver.findElement(By.xpath("//div/div[2]/input")).sendKeys("123");
	Actions a = new Actions(driver);
	a.sendKeys(country,countryName).build().perform();
	waitforelementtoappear(results);
	selectindia.click();
	}

public confirmationpage submitorder()
{
	submit.click();
	return new confirmationpage(driver);
}
}
