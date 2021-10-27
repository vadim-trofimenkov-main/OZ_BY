Feature: add item to favourites
  Exact search item names should be used.

  Scenario: Add found item to favourites
    Given Login as user. "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)" is found.
    When Add found item to favourites.
    Then Item should be in the favourites.

  Scenario: Remove previously added item from favourites
    Given "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)" is in the favourites.
    When Remove found item from favourites.
    Then Item is no longer in the favourites.