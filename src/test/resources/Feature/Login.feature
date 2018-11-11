Feature: Login 
This feature is used to allow only the valid users to log into the application.

@Login
Scenario Outline: Verify whether user is able to login with Valid Username and Password
When I navigate to facebook page

Examples:
          | username  | password  |
          | admin     | admin     |



