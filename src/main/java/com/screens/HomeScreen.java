package com.screens;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;

import com.qa.util.Constants;
import com.qa.util.ElementUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class HomeScreen {
	private AndroidDriver driver;

	private By homeXPATH = By.xpath(Constants.HOME_XPATH);
	private By promptView = By.id(Constants.PROMPTVIEW_ID);
	private By bottomNavigation = By.xpath(Constants.BOTTOMNAVIGATION_XPATH);

	public HomeScreen(AndroidDriver driver) {
		this.driver = driver;
	}

	public String homeScreen() {

		ElementUtil.waitForElement(promptView, "ID");
		while (driver.findElements(promptView).size() == 1) {
			driver.findElement(promptView).click();
		}
		String homeText = driver.findElement(homeXPATH).getText();
		return homeText;

	}

	public List<String> bottomNavigation() {
		List<String> x = new LinkedList<String>();

		int count = driver.findElements(bottomNavigation).size();
		List<AndroidElement> y = driver.findElements(bottomNavigation);
		if(driver.findElements(bottomNavigation).size()>0) {
			for(int i=0; i<y.size(); i++) {
				x.add(y.get(i).getText());
			}
		}else {
			System.out.println("Elemnts found Zero");

		}

		return x;
	}
}