Feature: Add to Cart
  As a Valid User
  I want to be able to add products to cart

  Scenario: Verify item is displayed
    Given I log in as standard user using "standard_user" and "secret_sauce"
    And I add item to cart
    And I click on Shopping cart badge
    Then I should see the items in my cart