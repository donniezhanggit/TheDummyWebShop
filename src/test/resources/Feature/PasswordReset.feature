Feature: Forgot Password 
This feature is used to reset the password for a user who forgot his / her password.

Background: User Login
Given User opens Application in Browser
And User clicks on Login Button
When User clicks on /Did you forget your password?/

@ResetPassword
Scenario: Verify whether user is able to reset the password using the Reset Password Link
And User enters registered email "akshat55narang@gmail.com"
And User clicks Reset Password Button
Then User should receive a message "Check your e-mails for details on how to reset your password." for Password Reset

@ResetPassword
Scenario: Verify whether Reset Password Button is disabled by default
Then The Reset Password button should be disabled.

@ResetPassword
Scenario: Verify whether user receives a message when email is more than 50 characters
When User enters registered email "adminaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadminaaaaaaaaaaaaaaaaaaaaaaaaaaa@test.com"
Then User should receive a message "Your e-mail cannot be longer than 50 characters." for Password Reset
@ResetPassword
Scenario: Verify whether user receives a message when email is less than 5 characters
When User enters registered email "a@c"
Then User should receive a message "Your e-mail is required to be at least 5 characters." for Password Reset
@ResetPassword
Scenario: Verify whether user receives a message when email is invalid
When User enters registered email "a"
Then User should receive a message "Your e-mail is invalid." for Password Reset
@ResetPassword
Scenario: Verify whether user receives a message when email is not provided
When User enters registered email "akshat55narang@gmail.com"
And User deletes the email text
Then User should receive a message "Your e-mail is required." for Password Reset
