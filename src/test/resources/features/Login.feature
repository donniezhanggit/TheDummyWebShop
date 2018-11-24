Feature: Login into the application with valid users

  Background: I should be to login into the application with valid credentials
    Given I'm on the home page
    When I click on My Account link
    And I click on admin menu link "Login"
    Then I should be on the "Login" Page

  Scenario Outline: Verify whether valid users are able to access the application
    When I enter valid "<email>" and "<password>"
    Then I should be logged in with the user "pluto"
    Examples:
      | email                 | password |
      | pluto@domain.com | Password123 |

