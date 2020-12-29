package stepdefinitions;

import java.util.List;

import org.testng.Assert;


import com.screens.HomeScreen;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import testrunners.MyTestRunner;

public class HomeScreenSteps {
	
	HomeScreen homeScreen = new HomeScreen(MyTestRunner.getDriver());
	
	@Then("verify below mentioned tabs are present")
	public void verify_below_mentioned_tabs_are_present(DataTable homeScreenTabs) {
		List<String> Expected = homeScreenTabs.asList();
		System.out.println("Expected  from homeScreensteps : " + Expected);
		List<String> Actual = homeScreen.bottomNavigation();
		System.out.println("Actual from homeScreensteps : " + Actual);
		Assert.assertEquals(Expected, Actual);
		
	}

}
