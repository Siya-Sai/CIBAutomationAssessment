@dogAPI
Feature: Dog API tests

  Scenario: Retrieve all dog breeds
    Given I send a request to the Dog API to list all breeds

  Scenario: Validate retriever breed exists
    Given I send a request to the Dog API to list all breeds
    Then I should see the retriever breed in the list

  Scenario: Retrieve retriever sub-breeds
    Given I send a request to the Dog API to list sub-breeds of retriever

  Scenario: Retrieve a random image for the golden sub-breed
    Given I send a request to the Dog API to get a random image for the golden sub-breed