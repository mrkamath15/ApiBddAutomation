Feature: Test Get all Todos API

  Scenario: Get all todos returns valid response
    When user requests get all todos api
    Then api returns status code as 200
    And get all todos api returns all fields in response body

    Scenario: Verify response time of get all ToDos api
      When user requests get all todos api
      Then api returns status code as 200
      And api response is returned within 5000 ms

      Scenario: Get all ToDos api schema validation
        When user requests get all todos api
        Then api returns status code as 200
        And get all todos api schema is validated successfully