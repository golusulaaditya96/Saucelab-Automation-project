Feature: Remove Item from Cart
  As a Valid User
  I want to be able to remove from cart

  Scenario: Removing one item from cart
    Given I log in as standard user using "standard_user" and "secret_sauce"
    And   I add item to cart
    And   I click on Shopping cart badge
    Then   I remove an item
