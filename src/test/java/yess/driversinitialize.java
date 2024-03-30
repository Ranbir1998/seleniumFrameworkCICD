package yess;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driversinitialize {
	public static WebDriver driver;
	public static pom poms;
	public   WebDriver ini() throws IOException {
		// TODO Auto-generated method stub

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\JAVAProjects\\framew\\src\\test\\java\\yess\\globaldata.properties");
		prop.load(fis);
		String browserName= prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
             //Firefox browser
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}
	@BeforeMethod(alwaysRun = true)
	public pom launchapplication() throws IOException
	{
		driver =ini();
		poms = new pom(driver);
		poms.go();
		return poms;

	}
	@AfterMethod(alwaysRun = true)
	public void close() {
		driver.close();
	}
}

