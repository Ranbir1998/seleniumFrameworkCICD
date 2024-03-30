package yess;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import junit.framework.Assert;
public class Errorvalidations extends driversinitialize {
        @Test
		public void Errorvalidation()
		{
			//for wrong password
			poms.loginApplication("ranbirsingh4321@gmail.com","Abceeffd123$");
			poms.getErrormessage();
			Assert.assertEquals("Incorrect email or password.", poms.getErrormessage());
		}
        @Test
    	public void productvalidation() throws IOException, InterruptedException
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
    		Boolean match=car.VerifyProductDisplay("ZARA COAT 33");
    		Assert.assertFalse(match);
    		
    		


    	}
	}

