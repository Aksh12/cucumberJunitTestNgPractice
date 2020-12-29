package com.qa.util;



import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;


public class ElementUtil  {
	
	private static AndroidDriver driver;
	
	public ElementUtil(AndroidDriver driver) {
		System.out.println("in elemnt util driver********");
		this.driver=driver;
	}
	
	public static void waitForElement(By locator, String elementType) {
		WebDriverWait wait ;

		switch (elementType) {

		case "XPATH":
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			break;

		case "ID":
			System.out.println("in case ID**********");
			wait = new WebDriverWait(driver, 20);
			System.out.println("in case id step2***********");
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			break;

		case "CLASSNAME":
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			break;
			
		case "UIAUTOMATOR":
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			break;
			
		
		default:
			System.out.println("Element type mentioned is wrong");

		}
	}
}
