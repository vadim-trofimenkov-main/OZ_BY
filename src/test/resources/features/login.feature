Feature: Login to oz.by

  Scenario: Login to oz.by using valid credentials
    Given Credentials for logging are "vadimtrofimenkov97@gmail.com" and "Pi34Ag".
    When User does login.
    Then User is logged. Home page is opened.