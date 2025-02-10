 @CRUD
  Feature: create user for user api
  Background:
   Given Create a user with valid all endpoint 
   
  Scenario: create user   
    When user send http request
    Then user gets valid response body for all