Feature: oz.by search
  Scenario: Search any item through search bar.
    Given User is logged and is on the Home page.
    When User does search for "Тетрадь полуобщая в клетку \"OZ\" (48 листов)".
    Then Item is found. Item has "Тетрадь полуобщая в клетку \"OZ\" (48 листов)" text.