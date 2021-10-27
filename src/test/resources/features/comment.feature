Feature: leave comment
  Exact search item names should be used.

  Scenario: Comment item
    Given Login as registered user. "Ручка шариковая синяя \"Jotter Royal Blue CT\" (М)" is found.
    When User add "Огромное спасибо за товар! Всем спасибо!" comment to the item.
    Then User can see the comment in Comments section.
