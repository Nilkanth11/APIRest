@post
Feature: Verify dummy rest APIs request for POST
  I want to use this template for my feature file

  Scenario: User verify POST request
    Given set the base url as 'baseuri'
    And user hit post api '/api/v1/create'
    When response should have status code 200
