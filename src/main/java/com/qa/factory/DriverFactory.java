//package com.qa.factory;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.qa.util.ConfigReader;
//
//import bsh.This;
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
//import testrunners.MyTestRunner;
//
//public class DriverFactory {
//
//	public static AndroidDriver driver;
//	public static DesiredCapabilities caps = new DesiredCapabilities();
//	public static ConfigReader configReader = new ConfigReader();
//	public static String firstDeviceName = "86S7N18530001837";
//	public static String SecondDeviceName = "90329051";
//		
////	public static ThreadLocal<AndroidDriver> tlDriver=new ThreadLocal<AndroidDriver>();
////	
////	@Parameters({"port","deviceID"})
////	public AndroidDriver init_driver(String platform) {
////		
////		System.out.println("Platform value is :" + platform);
////		
////		if(platform.equals("Android")) {
////			
////			try {
////				//@Parameters({"port","deviceID"})
////				loadCapabilities(port1, device_id);
////				System.out.println("Capabilities Loaded");
////				tlDriver.set(new AndroidDriver(new URL("http://localhost:4444/wd/hub"),caps));
////				System.out.println("Driver is set");
////			} catch (MalformedURLException e) {
////				e.printStackTrace();
////			}
////			
////		}else if(platform.equals("IOS")) {
////			
////		}else {
////			System.out.println("please provide correct platform : " + platform);
////		}
////		return getDriver();
////		
////	}
//
////	@Parameters({"port","deviceID"})
////	public void getValue(Object[] port, String deviceID) {
////		
////		this.port=port;
////		System.out.println("am here port" + port);
////		
////		this.device_id=device_id;
////		System.out.println("am here device_id" + device_id);
////	}
//	
////	@BeforeClass
//	
////	@DataProvider(name="inputdata")
////	@Parameters({"port","deviceID"})
////	public Object[][] dataProvider(Object port1 , Object device_id) {
////		
////		this.port1=port1;
////		System.out.println("am here port" + port1);
////		
////		this.device_id=device_id;
////		System.out.println("am here device_id" + device_id);
////		
////		return (Object[][]) new Object[]{port1,device_id};
////	}
////	
//
//
//	@Parameters({"port","deviceID"})
//	public static void loadCapabilities(String port12, String device_id2) {
//	System.out.println(4);
//	System.out.println("port : "+port1);
//	System.out.println("deviceID: "+device_id2);
//	if((device_id2).equalsIgnoreCase(firstDeviceName))
//	{
//		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
//		caps.setCapability(MobileCapabilityType.DEVICE_NAME, firstDeviceName);
//		caps.setCapability(MobileCapabilityType.UDID, firstDeviceName);
//		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, configReader.init_prop().get("platformName"));
//		caps.setCapability("appPackage", configReader.init_prop().get("appPackage"));
//		caps.setCapability("appActivity", configReader.init_prop().get("appActivity"));
//
//	}else if((device_id2).equalsIgnoreCase(SecondDeviceName)){
//		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
//		caps.setCapability(MobileCapabilityType.DEVICE_NAME, SecondDeviceName);
//		caps.setCapability(MobileCapabilityType.UDID, SecondDeviceName);
//		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, configReader.init_prop().get("platformName"));
//		caps.setCapability("appPackage", configReader.init_prop().get("appPackage"));
//		caps.setCapability("appActivity", configReader.init_prop().get("appActivity"));
//	}
//
//}
//
//
//
//
//public static AndroidDriver getDriver() {
//	
//		try {
//			
//			System.out.println(5);
//			driver = new AndroidDriver(new URL("http://localhost:4444/wd/hub"),caps);
//			System.out.println(6);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return driver;
//	}
//
//}
