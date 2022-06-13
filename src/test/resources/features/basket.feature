Feature: Add and remove item to/from basket
  Add any item to the basket(ex. "JavaScript с нуля") and then remove it from basket.

  #TODO ни один из тестов не запускается через Cucumber. Нужно переработать подход с @BeforeTest java.lang.IllegalStateException: No webdriver is bound to current thread: 1. You need to call open(url) first.
  Scenario: Add found item to basket
    Given User is logged in. Home Page is opened
    And "JavaScript с нуля" is found
    When Add "JavaScript с нуля" to basket.
    Then "JavaScript с нуля" should be in the basket.

  Scenario: Remove previously added item from basket
    Given "JavaScript с нуля" is in the basket.
    When Remove "JavaScript с нуля" from basket.
    Then "JavaScript с нуля" should no longer be in the basket.