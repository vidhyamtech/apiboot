@GET
Feature: get all user from user api

  Background: 
    Given user sets the baseurl and endpoint for get "GET"

  Scenario: Get all user
    When user send http get request
    Then user gets valid response body for get
