Feature: leave comment
  Leave comment in review section to any item(ex."Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)")

  Scenario: Comment item
    Given User is logged in. Home page is opened.
    And "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)" is found through search.
    When User add "Невероятно!" comment to the item.
    Then User can see "Невероятно!" comment in Comments section.
