package runb;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import yess.CART;
import yess.CheckoutPage;
import yess.confirmationpage;
import yess.driversinitialize;
import yess.pom;
import yess.productcatalog;

import java.util.List;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.bouncycastle.util.Exceptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ecommerce extends driversinitialize {

	@Test
	public void submitOrder() throws IOException, InterruptedException
	{
		String productName= "ZARA COAT 3";
		pom poms = new pom(driver);
		poms.loginApplication("ranbirsingh4321@gmail.com","Abcd123$");
		//product catalog
		productcatalog po = new productcatalog(driver);
		List<WebElement>products=po.getProductlist();
		po.addProductToCart(productName);
		po.gotocartpage();
		//CART
		CART car = new CART(driver);
		Boolean match=car.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		car.goToCheckout();
		//CheckoutPage
		CheckoutPage cp = new CheckoutPage(driver);
		cp.selectCountry("india");
		cp.submitorder();
		//confirmation page
		confirmationpage pa = new confirmationpage(driver);
		pa.getConfirmationMessage();
		Assert.assertTrue( pa.getConfirmationMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		//


	}
}


