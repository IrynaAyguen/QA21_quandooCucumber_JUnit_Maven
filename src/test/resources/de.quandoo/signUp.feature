Feature: Quandoo SignUp Feature
  In order to see the user area
  I sign up to the website

  @validDataSignUp @regression
  Scenario: Successful SignUp
    Given I am on the Homepage page
    When I click on the SignUp icon
    Then I see CreateAccount page

    When I insert valid user data
    And I click checkbox
    And I click on Create account button
    Then I should see Homepage