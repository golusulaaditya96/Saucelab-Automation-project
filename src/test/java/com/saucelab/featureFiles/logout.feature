Feature: logout
  As a Valid User
  I want to login and then logout

  Scenario: Login with valid credentials to Sauce lab
    Given I log in as standard user using "standard_user" and "secret_sauce"
    Then  I logout