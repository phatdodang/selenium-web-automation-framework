Feature: As a user, I want to login Traveloka app URL.

  @login
  Scenario Outline: Login Traveloka with invalid username
    Given Launch Traveloka web application
    When User click button Login
    And User enter username as "<username>"
    And User enter password as "<password>"
    And User click button Login in Form
    Then Login fail with notice
    Examples:
      | username               | password |
      | toidicodedao@gmail.com | 123456   |