package com.qa.factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.qa.util.ConfigReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	public AndroidDriver driver;
	public DesiredCapabilities caps = new DesiredCapabilities();
	public ConfigReader configReader = new ConfigReader();
	
	public static ThreadLocal<AndroidDriver> tlDriver=new ThreadLocal<AndroidDriver>();
	
	public AndroidDriver init_driver(String platform) {
		
		System.out.println("Platform value is :" + platform);
		
		if(platform.equals("Android")) {
			
			try {
				loadCapabilities();
				System.out.println("Capabilities Loaded");
				tlDriver.set(new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps));
				System.out.println("Driver is set");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
		}else if(platform.equals("IOS")) {
			
		}else {
			System.out.println("please provide correct platform : " + platform);
		}
		
		//getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return getDriver();
		
	}
	
	public void loadCapabilities() {
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, configReader.init_prop().get("platformVersion"));
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, configReader.init_prop().get("deviceName"));
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, configReader.init_prop().get("platformName"));
		caps.setCapability("appPackage", configReader.init_prop().get("appPackage"));
		caps.setCapability("appActivity", configReader.init_prop().get("appActivity"));
		
	}
	
	public static synchronized AndroidDriver getDriver() {
		return tlDriver.get();

	}
	
}
