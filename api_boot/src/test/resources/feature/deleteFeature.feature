@DELETE
Feature: Delete by ID user from user api

  Background: 
    Given user sets the baseurl and endpoint for delete "DELETE"

  Scenario: Delete by id user
    When user send http delete request
    Then user gets valid response body for delete
