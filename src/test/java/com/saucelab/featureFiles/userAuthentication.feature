Feature: User Authentication
  As a Valid User
  I want to login to Saucelabs with a valid user name and password

#  Background:
#    Given I navigate to Sauce lab login page
####################################################
# Test 1: Validate Sauce lab user
#####################################################
  Scenario: Login with valid credentials to Sauce lab
  Given I navigate to Sauce lab login page


#    When I enter a valid "<user_name>"
#    And  I enter a valid "<password>"
#    And  I click on Login
#    Then Sauce lab user logged in successfully
#
#    Examples:
#      |     user_name          | password    |
#      |standard_user           |secret_sauce |
#      |problem_user            |secret_sauce |
#      |performance_glitch_user |secret_sauce |
#####################################################
## Test 2: Invalid Sauce lab user
######################################################
#  Scenario Outline: Login with invalid credentials to Sauce lab
#    When I enter a "<user_name>"
#    And  I enter a "<password>"
#    And  I click on Login
#    Then User not able to login
#
#    Examples:
#      |     user_name          | password   |
#      |standard_user           |secretsauce |
#      |problem_user3           |secret_sauce|
#      |performance_glitch_user1|secret_sauce|