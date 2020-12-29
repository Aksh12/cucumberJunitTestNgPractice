package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.factory.DriverFactory;

import io.appium.java_client.MobileBy;

public class ElementUtil {
	
	public static void waitForElement(By locator, String elementType) {
		WebDriverWait wait ;

		switch (elementType) {

		case "XPATH":
			wait = new WebDriverWait(DriverFactory.getDriver(), 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			break;

		case "ID":
			wait = new WebDriverWait(DriverFactory.getDriver(), 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			break;

		case "CLASSNAME":
			wait = new WebDriverWait(DriverFactory.getDriver(), 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			break;
			
		case "UIAUTOMATOR":
			wait = new WebDriverWait(DriverFactory.getDriver(), 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			break;
			
		
		default:
			System.out.println("Element type mentioned is wrong");

		}
	}
}
