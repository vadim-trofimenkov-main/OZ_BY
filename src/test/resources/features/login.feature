Feature: Login to oz.by
  Scenario: Login to oz.by using valid credentials
    Given Credentials for logging are "vadimtrofimenkov97test@gmail.com" and "546hF3".
    When User does login.
    Then User is logged. Home page is opened.