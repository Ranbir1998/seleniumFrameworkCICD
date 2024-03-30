package abstractreusable;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class reused {
	WebDriver driver;
	
	public reused(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this); 
	}
	

	public void waitforelementtoappear(By findBy) {
		 WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(4));
			wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	
	public void waitforWebelementtoappear(WebElement findBy) {
		 WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(4));
			wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	public void  waitforelementtoDisappear(WebElement ele) throws InterruptedException {
		Thread.sleep(5000);
//		 WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
//		 wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	 {
		 TakesScreenshot ts = (TakesScreenshot)driver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 File file = new File(System.getProperty("user.dir")+"//reports//" + testCaseName +".png");
	     FileUtils.copyFile(source, file);
	     return System.getProperty("user.dir") +"//reports//" + testCaseName + ".png";
	 }
	 
	}

//<listeners>
//<listener class-name="abstractreusable.listeners" />
//</listeners>
//	
	

