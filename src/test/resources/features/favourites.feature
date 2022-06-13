Feature: add item to favourites
  Add any item to the favourites(ex. "JavaScript с нуля") and then remove it from favourites.

  Scenario: Add found item to favourites
    Given User is logged in. Home Page is opened.
    And "JavaScript с нуля" is found correctly.
    When Add "JavaScript с нуля" to favourites.
    Then "JavaScript с нуля" should be in the favourites.

  Scenario: Remove previously added item from favourites
    Given "JavaScript с нуля" is in the favourites.
    When Remove "JavaScript с нуля" from favourites.
    Then "JavaScript с нуля" should no longer be in the favourites.