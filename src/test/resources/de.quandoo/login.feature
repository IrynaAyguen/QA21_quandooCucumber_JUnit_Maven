@regression
Feature: Quandoo Login Feature
  In order to see the user area
  I log in to the website

  Background:
    Given I am on the Homepage page
    When I click on the Login icon
    Then I see Login page

  @validDataLogin @positive
  Scenario: Successful Login and Logout
  I log in to the system and then I log out successfully. (for example JIRA-123)

    When I insert valid user credentials
    And I click on Login button
    Then I should see Homepage

    When I hover on the User icon
    Then I see Log out item menu

    When I click on Log out item menu
    Then I should see Homepage

  @invalidDataLogin
  Scenario Outline: Login with invalid data
    When I insert invalid data
      | email   | password   |
      | <email> | <password> |

    And I click on Login button
    Then I see that message appeared
    """
<errorMessage>
    """
    Examples:
      | email               | password   | errorMessage                     |
      | iryna.ayguen@web.de | Ira123456_ | Enter valid username or password |
      | iryna.ayguen@web.de |            | Enter valid username or password |
      |                     |            | Enter valid username or password |


  @invalidFakerEmailLogin
  Scenario: Login with an invalid email from faker
    When I insert invalid Faker-email
    And I click on Login button
    Then I see, message appeared