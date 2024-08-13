Feature: Checking user balance after login

  Scenario: Clients balance after registration should be ZERO
    Given client logs in with username: testuser@qa.com u and password: Parole123
    And client balance is 0.00 from "2024-01-01" to "2024-07-01"
