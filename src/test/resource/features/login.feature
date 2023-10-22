Feature: Login

  @Regression @Positive
  Scenario: user login with standart user
    Given user already open login page
    When user input username
    And user input password
    And user click login button
    Then user redirect to dashboard

  @Regression @Negative
  Scenario: user login with invalid username
    Given user already open login page
    When user input invalid username
    And user input password
    And user click login button
    Then error message invalid username