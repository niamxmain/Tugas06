Feature: AddProduct

  @Regression @Positive
  Scenario: user add product to cart
    Given user login with standard user
    When user in product page
    And user click button add to cart
    And user click icon cart
    Then displays product descriptions

  @Regression @Negative
  Scenario: remove product in cart using error user
    Given user login with error user
    When user in product page
    And user click button add to cart
    And user click remove button in product page
    Then the remove button cant click

