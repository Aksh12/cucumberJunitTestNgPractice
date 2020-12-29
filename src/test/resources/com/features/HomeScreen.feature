Feature: Verify HomeScreen Tab

  Background: 
  Given user is on "WE’RE A FAMILY" Get Started Screen
  Then user selects Get started button

  Scenario: Verify different tabs are present in front Home Screen
    Given user is on "To proceed further, please login" Login Screen
    When user clicks on Sign in with Google and selects Google account
    Then user is on Home Screen "Home"
    Then verify below mentioned tabs are present
      | Home     |
      | Discover |
      | Post     |
      | Tools    |
      | more     |
