Feature: Login into the application with valid users

  Background:
    Given the user "pluto" exists on the database
    When I click on the "Login" link
    Then I should be on the "Login" Page

  Scenario Outline: Verify whether valid users are able to access the application
    When I enter valid "<email>" and "<password>"
    Then I should be logged in with the user "pluto"
    Examples:
      | email                 | password |
      | pluto@domain.com | Password123 |

