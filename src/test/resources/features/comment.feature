Feature: leave comment
  Leave comment in review section to any item(ex."JavaScript с нуля")

  Scenario: Comment item
    Given User is logged in. Home page is opened.
    And "JavaScript с нуля" is found through search.
    When User add "Замечательный товар!" comment to the item.
    Then User can see "Замечательный товар!" comment in Comments section.
