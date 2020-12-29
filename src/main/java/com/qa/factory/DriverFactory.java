package com.qa.factory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.qa.util.ConfigReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class DriverFactory {

	public static AndroidDriver driver;
	public static DesiredCapabilities caps = new DesiredCapabilities();
	public ConfigReader configReader = new ConfigReader();
	public static String firstDeviceName="86S7N18530001837";
	public static String SecondDeviceName="90329051";
	
//	public static ThreadLocal<AndroidDriver> tlDriver=new ThreadLocal<AndroidDriver>();
//	
//	@Parameters({"port","deviceID"})
//	public AndroidDriver init_driver(String platform) {
//		
//		System.out.println("Platform value is :" + platform);
//		
//		if(platform.equals("Android")) {
//			
//			try {
//				//@Parameters({"port","deviceID"})
//				loadCapabilities(port1, device_id);
//				System.out.println("Capabilities Loaded");
//				tlDriver.set(new AndroidDriver(new URL("http://localhost:4444/wd/hub"),caps));
//				System.out.println("Driver is set");
//			} catch (MalformedURLException e) {
//				e.printStackTrace();
//			}
//			
//		}else if(platform.equals("IOS")) {
//			
//		}else {
//			System.out.println("please provide correct platform : " + platform);
//		}
//		return getDriver();
//		
//	}
	
	@Parameters({"port","deviceID"})
	public void loadCapabilities(String port1,String device_id) {
		System.out.println(4);
		System.out.println("port : " + port1);
		System.out.println("deviceID: " + device_id);
		if(device_id.equalsIgnoreCase(firstDeviceName)){
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, firstDeviceName);
		caps.setCapability(MobileCapabilityType.UDID, firstDeviceName);
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, configReader.init_prop().get("platformName"));
		caps.setCapability("appPackage", configReader.init_prop().get("appPackage"));
		caps.setCapability("appActivity", configReader.init_prop().get("appActivity"));
		
	}else if(device_id.equalsIgnoreCase(SecondDeviceName)) {
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, SecondDeviceName);
		caps.setCapability(MobileCapabilityType.UDID, SecondDeviceName);
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, configReader.init_prop().get("platformName"));
		caps.setCapability("appPackage", configReader.init_prop().get("appPackage"));
		caps.setCapability("appActivity", configReader.init_prop().get("appActivity"));
	}

		
	}
	
public static AndroidDriver getDriver() {
		try {
			System.out.println(5);
			driver = new AndroidDriver(new URL("http://localhost:4444/wd/hub"),caps);
			System.out.println(6);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return driver;
	}
	
}
