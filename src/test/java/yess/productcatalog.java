package yess;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractreusable.reused;

public class productcatalog extends reused {
	WebDriver driver;
	public productcatalog (WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this); 
	}

	@FindBy(css="..ng-animating")
	WebElement spinner;

	@FindBy(css=".mb-3")
	List<WebElement> techs;
	By techs1 = By.cssSelector(".mb-3");
	By addTocart =  By.cssSelector(".card-body button:last-of-type");
	By toastMessage =  By.cssSelector("#toast-container");

	@FindBy(css="[routerlink='/dashboard/cart']")
	WebElement cartHeader;

	public List<WebElement>getProductlist()
	{
		waitforelementtoappear(techs1);
		return techs;
	}

	public WebElement getProductByName(String productName)
	{

		WebElement prod =getProductlist().stream().filter(product->product.findElement(By.cssSelector("b")).getText()
				.equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		return prod;
	}
	public void addProductToCart(String productName) throws InterruptedException
	{

		WebElement prod =getProductByName(productName);
		
		waitforelementtoappear(toastMessage);
		waitforelementtoDisappear(spinner);

	}

	public void gotocartpage() {
		cartHeader.click();




	}
}

