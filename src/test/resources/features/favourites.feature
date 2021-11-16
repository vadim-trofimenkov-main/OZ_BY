Feature: add item to favourites
  Add any item to the favourites(ex. "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)") and then remove it from favourites.

  Scenario: Add found item to favourites
    Given User is logged in. Home Page is opened.
    And "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)" is found correctly.
    When Add "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)" to favourites.
    Then "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)" should be in the favourites.

  Scenario: Remove previously added item from favourites
    Given "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)" is in the favourites.
    When Remove "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)" from favourites.
    Then "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)" should no longer be in the favourites.