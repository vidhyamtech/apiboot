 @POST
  Feature: create user for user api
  Scenario: create user
    Given Create a user with valid endpoint 
    When user send http post request
    Then user gets valid response body for post