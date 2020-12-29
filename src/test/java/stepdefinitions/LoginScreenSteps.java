package stepdefinitions;



import org.testng.Assert;


import com.screens.GetStarted;
import com.screens.HomeScreen;
import com.screens.LoginScreen;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import testrunners.MyTestRunner;

public class LoginScreenSteps {
	
	GetStarted gs = new GetStarted(MyTestRunner.getDriver());
	LoginScreen loginScreen;
	HomeScreen homeScreen;
	
	@Given("user is on {string} Get Started Screen")
	public void user_is_on_Get_Started_Screen(String getStartedText) {
		System.out.println("in bg******");
		String actualText = gs.weAreFamilyScreen();
		System.out.println("Text 3 : loginScreenSteps :" +actualText);
	    Assert.assertEquals(getStartedText,actualText);
	}
	
	@Then("user selects Get started button")
	public void user_selects_get_started_button() {
	   loginScreen=gs.clickGetStarted();
	}
	
	@Given("user is on {string} Login Screen")
	public void user_is_on_login_screen(String loginScreenText) {
		String actualText = loginScreen.loginScreenText();
		System.out.println("Text 4 : loginScreenSteps :" +actualText);
	    Assert.assertEquals(loginScreenText,actualText);
	}

	@When("user clicks on Sign in with Google and selects Google account")
	public void user_clicks_on_sign_in_with_google() {
		homeScreen=loginScreen.signInWithGoogle();
	}

	@Then("user is on Home Screen {string}")
	public void user_is_on_Home_screen(String myPlanText) {
		String actualText = homeScreen.homeScreen();
		System.out.println("Text 5 : loginScreenSteps :" +actualText);
	    Assert.assertEquals(myPlanText,actualText);
	}


}
