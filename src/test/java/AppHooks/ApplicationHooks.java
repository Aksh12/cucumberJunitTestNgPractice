package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;


import com.qa.util.ConfigReader;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testrunners.MyTestRunner;


public class ApplicationHooks {

	private ConfigReader configReader;
	private AndroidDriver driver;
	Properties prop;

	public MyTestRunner runner = new MyTestRunner();
	//public String deviceID,port;
	
	@Before(order=0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop=configReader.init_prop();
		
	}
	
	
	
	@Before(order=2)
	//@Parameters({"port","deviceID"})
	public void launchApplication() {
		//this.port = port;
		//this.deviceID=deviceID;
		String Device = prop.getProperty("Device");
		driver=runner.getDriver();
		System.out.println(1);
//		driverFactory=new DriverFactory();
//		driver=driverFactory;
//		//driverFactory.loadCapabilities(port, deviceID);
//		System.out.println(2);
//		
//		System.out.println(3);
	}
	
//	@Before(order=1)
//	public void launchApplication() {
//		String Device = prop.getProperty("Device");
//		driverFactory=new DriverFactory();
//		driver=driverFactory.init_driver(Device);
//	}
	

	
	@After(order=1)
	public void quitApp() {
		driver.quit();
	}
	
	@After(order=0)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES); 
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
}
