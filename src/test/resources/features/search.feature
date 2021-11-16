Feature: oz.by search
  Scenario: Search any item through search bar.
    Given User is logged and is on the Home page.
    When User does search for "Тетрадь полуобщая в клетку \"OZ\" (48 листов)".
    Then "Тетрадь полуобщая в клетку \"OZ\" (48 листов)" is found.