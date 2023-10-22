Feature: Detail Product

  @Regression
  Scenario: Display detail product with click image product
    Given user login with standard user
    When user in product page
    And user click image product
    Then display product information