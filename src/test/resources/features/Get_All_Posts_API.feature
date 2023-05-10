Feature: Test GET all Posts API

  Scenario: Get all posts returns valid response
    When user requests get all posts api
    Then api returns status code as 200
    And get all posts api returns all fields in response body


    Scenario: Verify response time of get all posts api
      When user requests get all posts api
      Then api returns status code as 200
      And api response is returned within 3000 ms

      Scenario: Get all posts api schema validation
        When user requests get all posts api
        Then api returns status code as 200
        And get all posts api schema is validated successfully