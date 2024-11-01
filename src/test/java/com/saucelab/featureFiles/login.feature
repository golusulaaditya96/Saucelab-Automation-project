Feature: User Authentication
  As a Valid User
  I want to login to Saucelabs with a valid user name and password

  Background:
    Given I navigate to Sauce lab login page
#####################################################
  
####################################################
  Scenario Outline: Login with valid credentials to Sauce lab
    When I enter a valid user "<user_name>"
    And  I enter a valid password "<password>"
    And  I click on Login
    Then product page is displayed

    Examples:
      | user_name               | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
######################################################
  Scenario Outline: Login with invalid credentials to Sauce lab
    When I enter user name "<user_name>"
    And  I enter password "<password>"
    And  I click on Login
    Then User not able to login

    Examples:
      |     user_name          | password   |
      |standard_user           |secretsauce |
      |problem_user3           |secret_sauce|
      |performance_glitch_user1|secret_sauce|