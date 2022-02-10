Feature: Searching products on the website
  As a customer
  I want to be able to launch a search on the website
  So that I can find a specific product

  Scenario: Searching for paprika
    Given the search page is up and running
    When the customer searches for paprika
#    Then paprika appears in the search results
    Then Gherkin - Paprika appears in the search results

  Scenario Outline: Searching for existing products
    Given the search page is up and running
    When the customer searches for <product>
    Then <result> appears in the search results

    Examples:
      | product     | result                  |
      | mustard     | Gherkin - mustard seeds |
      | paprika     | Gherkin - Paprika       |
      | pepper      | Gherkin - Pepper        |
      | snacks      | Gherkin - snacks        |
      | traditional | Gherkin - traditional   |


  Scenario: Searching for non-existing items
    Given the search page is up and running
    When the customer searches for foobar
    Then a message is displayed that foobar did not deliver any results