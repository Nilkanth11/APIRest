@get
Feature: Verify dummy rest APIs request for GET
  I want to use this template for my feature file

  Scenario: User verify GET request
    And user hit get api '/api/v1/employees'
    When response should have status code 200
    And response should have value 'Tiger Nixon' at 'data[0].employee_name'

  Scenario: User verify GET request with ID
    And user hit get api '/api/v1/employee/1'
    When response should have status code 200
    And response should have value 'Tiger Nixon' at 'data.employee_name'
    And response should have value '61' at 'data.employee_age'
    And response should have value 'success' at 'status'