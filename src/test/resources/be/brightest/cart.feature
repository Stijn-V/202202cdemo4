Feature: Using the shopping cart
  As a customer
  I want to be able to add and remove items to my shopping cart and checkout
  So that I can buy the products of my selection

  Scenario: Adding paprika to the shopping cart for the first time
    Given the customer's cart is empty
    And the customer is on the paprika product detail page
    When the customer chooses to add the product to the cart
    Then the cart overview is displayed
    And the paprika product counter equals 1

