package yess;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractreusable.reused;

public class pom extends reused {
	WebDriver driver;
	//here driver is having no life
	//create a local object for constructor
	public pom(WebDriver driver)
	//always gets initailised first in the class
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this); //trigger to initaialize below elements 
		//this above refers to current class driver
	}


	//WebElement email=driver.findElement(By.cssSelector("input[id='userEmail']"));
	//Alternate to above step using pagefactory method

	@FindBy(id="userEmail")
	WebElement userEmail;

	@FindBy(id="userPassword")
	WebElement passwordEle;

	@FindBy(id="login")
	WebElement login;
	
	//error mail ones
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;

	public void loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		login.click();
	}

	public void go()
	{
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	public String getErrormessage()
	{
		waitforWebelementtoappear(errorMessage);
		return errorMessage.getText();
	}
	
	
		
		

}

