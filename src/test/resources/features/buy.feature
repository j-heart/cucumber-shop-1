Feature: Buy products
    As a customer
    I want to buy products

Background:
    Given a product "Bread" with price 20.50 and 15 quantity exists
    And a product "Jam" with price 80.00 and 20 quantity exists
    And a product "Peanut Butter" with price 100.00 exists

Scenario: Buy one product
    When I buy "Bread" with quantity 4
    Then total should be 82.00
    And "Bread" quantity should be 11

Scenario: Buy multiple products
    When I buy "Bread" with quantity 2
    And I buy "Jam" with quantity 3
    And I buy "Peanut Butter" with quantity 4
    Then total should be 681.00
    And "Bread" quantity should be 13
    And "Jam" quantity should be 17
    And "Peanut Butter" quantity should be 6

Scenario: Buy more than stock
    When I buy "Bread" with quantity 32
    And I buy "Peanut Butter" with quantity 20
    Then total should be 0.00
    And "Bread" quantity should be 15
    And "Peanut Butter" quantity should be 10

