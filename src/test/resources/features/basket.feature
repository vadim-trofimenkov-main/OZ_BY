Feature: Add and remove item to/from basket
  Add any item to the basket(ex. "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)") and then remove it from basket.

  Scenario: Add found item to basket
    Given User is logged in. Home Page is opened
    And "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)" is found
    When Add "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)" to basket.
    Then "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)" should be in the basket.

  Scenario: Remove previously added item from basket
    Given "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)" is in the basket.
    When Remove "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)" from basket.
    Then "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)" should no longer be in the basket.