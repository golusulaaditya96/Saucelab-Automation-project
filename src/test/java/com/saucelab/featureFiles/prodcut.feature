Feature: product
  As a Valid User
  I want to be able to interact with product page functionalities

Background:
  Given I log in as standard user using "standard_user" and "secret_sauce"
################################################################
  Scenario: Verify product page is displayed
    Then  product page is displayed
####################################################################
Scenario: Verify inventory item names are in descending order
  When I click on filter icon
  And product name is ordered in descending
  Then Item should be in descending order
################################################################



