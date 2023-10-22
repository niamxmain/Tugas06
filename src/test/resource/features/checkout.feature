Feature: Checkout

  @Regression
  Scenario: Checkout Product
    Given user login with standard user
    When user click button add to cart
    And user click icon cart
    And user click checkout button
    Then user completes information data
    And user click continue button
    And display checkout information
    And click finish button
    Then display popup success