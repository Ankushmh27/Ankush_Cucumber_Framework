Feature: Super Admin Login Feature

Background:
    Given Super admin open the hotel crm application

  @SuperAdmin_Login_Positive
  Scenario Outline: Validate the Super admin login with valid credentials
    When Super admin enters the "<username>" and "<password>"
    And Super admin click on the login button
    Then Super admin Verify Page Title and logout from the application

    Examples: 
      | username | password      |
      | root     | Patelhms@2023 |

  @SuperAdmin_Login_Negative
  Scenario Outline: Validate the Super admin login with invalid credentials
    When Super admin enters the "<username>" and "<password>"
    And Super admin click on the login button
    Then Verify the error message on screen

    Examples: 
      | username | password      |
      | Root     | patelhms@2023 |
