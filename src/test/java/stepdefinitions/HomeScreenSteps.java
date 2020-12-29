package stepdefinitions;

import java.util.List;

import org.junit.Assert;

import com.qa.factory.DriverFactory;
import com.screens.HomeScreen;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class HomeScreenSteps {
	
	HomeScreen homeScreen = new HomeScreen(DriverFactory.getDriver());
	
	@Then("verify below mentioned tabs are present")
	public void verify_below_mentioned_tabs_are_present(DataTable homeScreenTabs) {
		List<String> Expected = homeScreenTabs.asList();
		System.out.println("Expected  from homeScreensteps : " + Expected);
		List<String> Actual = homeScreen.bottomNavigation();
		System.out.println("Actual from homeScreensteps : " + Actual);
		Assert.assertEquals(Expected, Actual);
		
	}

}
