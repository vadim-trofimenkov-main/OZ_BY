Feature: add item to basket
  Exact search item names should be used.

  Scenario: Add found item to basket
    Given User is logged. "Ручка шариковая синяя для левшей \"Angular\" (0,6 мм)" is found.
    When Add found item to basket.
    Then Item should be in the basket.

  Scenario: Remove previously added item from basket
    Given "Ручка шариковая синяя для левшей \"Angular\" (0,6 мм)" is in the basket.
    When Remove found item from basket.
    Then Item is no longer in the basket.