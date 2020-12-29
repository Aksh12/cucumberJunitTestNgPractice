package com.screens;

import org.openqa.selenium.By;

import com.qa.util.Constants;
import com.qa.util.ElementUtil;

import io.appium.java_client.android.AndroidDriver;

public class GetStarted {
	
	private AndroidDriver driver;

	private By weAreFamilyID=By.id(Constants.WEAREFAMILY_ID);
	private By getstartedID=By.id(Constants.GETSTARTED_ID);
	
	public GetStarted(AndroidDriver driver) {
		this.driver=driver;
	}
	
	public String weAreFamilyScreen() {
		ElementUtil.waitForElement(weAreFamilyID,"ID");
		System.out.println("Text 1 GetStarted : " +driver.findElement(weAreFamilyID).getText());
		return driver.findElement(weAreFamilyID).getText();
	}
	
	public LoginScreen clickGetStarted() {
		driver.findElement(getstartedID).click();
		return new LoginScreen(driver);
	}

}
