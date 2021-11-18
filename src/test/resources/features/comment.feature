Feature: leave comment
  Leave comment in review section to any item(ex."Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)")

  Scenario: Comment item
    Given User is logged in. Home page is opened.
    And "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)" is found through search.
    When User add "Всем товарам товар!" comment to the item.
    Then User can see "Всем товарам товар!" comment in Comments section.
