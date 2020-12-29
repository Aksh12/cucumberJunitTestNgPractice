package testrunners;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = { "src\\test\\resources\\com\\features" }, 
                glue = { "stepdefinitions","AppHooks", "com.qa.factory"}, 
                plugin = { "pretty" })
public class MyTestRunner extends AbstractTestNGCucumberTests {
	
	public static AndroidDriver driver;
	public static DesiredCapabilities caps = new DesiredCapabilities();
	public static ConfigReader configReader = new ConfigReader();
	public static String firstDeviceName = "86S7N18530001837";
	public static String SecondDeviceName = "90329051";
	
	public static ThreadLocal<AndroidDriver> tlDriver=new ThreadLocal<AndroidDriver>();

	private io.cucumber.testng.TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() {

		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	@BeforeMethod(alwaysRun = true)
	@Parameters({"port","deviceID"})
	public AndroidDriver setUpMethod(String port, String device_id) {
		//testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		System.out.println("*********in before method*********");
		System.out.println("port : " + port);
		System.out.println("device: " +  device_id);
		
		if((device_id).equalsIgnoreCase(firstDeviceName))
		{
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, firstDeviceName);
			caps.setCapability(MobileCapabilityType.UDID, firstDeviceName);
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, configReader.init_prop().get("platformName"));
			caps.setCapability("appPackage", configReader.init_prop().get("appPackage"));
			caps.setCapability("appActivity", configReader.init_prop().get("appActivity"));

		}else if((device_id).equalsIgnoreCase(SecondDeviceName)){
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, SecondDeviceName);
			caps.setCapability(MobileCapabilityType.UDID, SecondDeviceName);
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, configReader.init_prop().get("platformName"));
			caps.setCapability("appPackage", configReader.init_prop().get("appPackage"));
			caps.setCapability("appActivity", configReader.init_prop().get("appActivity"));
		}
		
		try {
			System.out.println("setting tl");
			tlDriver.set(new AndroidDriver(new URL("http://localhost:4444/wd/hub"),caps));
			System.out.println("tl is set");
			
			System.out.println("out of element");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return getDriver();
		//return getDriver();
		

	}
	
	public static AndroidDriver getDriver() {
		new ElementUtil(tlDriver.get());
//		try {
//			
//			System.out.println(5);
//			driver = new AndroidDriver(new URL("http://localhost:4444/wd/hub"),caps);
//			System.out.println(6);
//			new ElementUtil(driver);
//			System.out.println("my test runner after eu***********");
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("get driver returned");
		return  tlDriver.get();
	}


	@Override
	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
	public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
		testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
	}

	@DataProvider
	public Object[][] scenarios() {
		if (testNGCucumberRunner == null) {
			testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		}
		return testNGCucumberRunner.provideScenarios();

	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		testNGCucumberRunner.finish();
	}

}
