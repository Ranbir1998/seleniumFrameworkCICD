package runb;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import yess.pom;

import java.util.List;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.bouncycastle.util.Exceptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ecommercebeforepom {
	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String pro= "ZARA COAT 3";
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		pom poms = new pom(driver);



		driver.findElement(By.cssSelector("input[id='userEmail']")).sendKeys("ranbirsingh4321@gmail.com");
		driver.findElement(By.cssSelector("input#userPassword")).sendKeys("Abcd123$");
		driver.findElement(By.id("login")).click();
		List<WebElement> techs = driver.findElements(By.cssSelector(".mb-3"));
		//through streams
		//		int count = driver.findElements(By.cssSelector(".mb-3")).size();
		//		for(int i=0;i<count;i++)
		//		{
		//			String text=driver.findElements(By.cssSelector(".mb-3")).get(i).getText();
		//			if(text.equalsIgnoreCase("ZARA COAT 3"));
		//			{
		//				driver.findElements(By.cssSelector(".card-body button:last-of-type")).get(i).click();
		//			}
		//		}


		WebElement prod =techs.stream().filter(product->product.findElement(By.cssSelector("b")).getText()
				.equals(pro)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();


		//to hover elements in Cart
		List<WebElement> items = driver.findElements(By.cssSelector(".cartSection h3"));
		//anyMtach same as filter but returns boolean value
		boolean item= items.stream().anyMatch(s->s.getText().equalsIgnoreCase(pro));	
		Assert.assertTrue(item);
		driver.findElement(By.xpath("//div/ul/li[3]/button")).click();

		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder*='Select']")),"india").build().perform();
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		driver.findElement(By.xpath("//div/div[2]/input")).sendKeys("123");
		driver.findElement(By.cssSelector(".action__submit")).click();

		driver.findElement(By.xpath("//div/div[2]/input")).sendKeys("123");
		String name=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(name.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();



	}

}
