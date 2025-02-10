 @PUT
  Feature: update user for user api
  Scenario: update user
    Given update a user with valid endpoint 
    When user send http put request
    Then user gets valid response body for put