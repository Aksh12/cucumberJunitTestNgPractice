package com.screens;

import org.openqa.selenium.By;

import com.qa.util.Constants;
import com.qa.util.ElementUtil;

import io.appium.java_client.android.AndroidDriver;

public class LoginScreen {
	
	private AndroidDriver driver;

	private By onLoginScreenXPATH=By.xpath(Constants.ONLOGINSCREEN_XPATH);
	private By signWithGoogleXPATH=By.xpath(Constants.SIGNINWITHGOOGLE_XPATH);
	private By chooseAccountXPATH=By.xpath(Constants.CHOOSEACCOUNT_XPATH);
	private By selectAccountID=By.id(Constants.SELECTACCOUNT_ID);
	
	public LoginScreen(AndroidDriver driver) {
		this.driver=driver;
	}
	
	public String loginScreenText() {
		System.out.println("Text 2 LoginScreen : "+driver.findElement(onLoginScreenXPATH).getText());
		return driver.findElement(onLoginScreenXPATH).getText();
	}
	
	public HomeScreen signInWithGoogle() {
		ElementUtil.waitForElement(signWithGoogleXPATH, "XPATH");
		driver.findElement(signWithGoogleXPATH).click();
		ElementUtil.waitForElement(selectAccountID, "ID");
		driver.findElement(selectAccountID).click();
		return new HomeScreen(driver);
	}
	
	

}
