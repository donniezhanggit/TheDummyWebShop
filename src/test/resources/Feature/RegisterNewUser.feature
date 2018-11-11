Feature: Register a New User

Background: User Login
Given User opens Application in Browser
And User clicks on Register in Accounts Menu

@RegisterNewUser
Scenario: Verify whether a new user is able to Register for gurukula
When User enters the Registration details
And clicks on Register
Then User should register his/her account successfully

@RegisterNewUser
Scenario: Verify whether the Register is deactivated by default
Then Register button should be disabled

Scenario: Verify whether the Register is deactivated until all the mandatory checks on fields are met
When User doesnot enter all the mandatory fields
Then Register button should be disabled


@RegisterNewUser
Scenario Outline: Verify whether user receives a message when login contains special characters or Uppercase characters
When User enters login name "<loginname>"
Then User should receive an error message for login name "Your login can only contain lower-case letters and digits."
Examples:
|loginname|
|AkshatNarang|
|akshatnarang@|

@RegisterNewUser
Scenario Outline: Verify whether user receives a message when details entered are incorrect
When User enters "<attribute>" as "<value>"
Then User should receive an error message "<errormessage>" for Registering a New User
Examples:
|attribute|value|errormessage|
|login|aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa|Your login cannot be longer than 50 characters.|
|email|aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@aa.com|Your e-mail cannot be longer than 50 characters.|
|email|a@c|Your e-mail is required to be at least 5 characters.|
|email|a|Your e-mail is invalid.|
|password|aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa|Your password cannot be longer than 50 characters.|
|password|aa|Your password is required to be at least 5 characters.|
|confirmpassword|aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa|Your confirmation password cannot be longer than 50 characters.|
|confirmpassword|aaa|Your confirmation password is required to be at least 5 characters.|

@RegisterNewUser
Scenario: Verify whether user receives a message when password and confirm password donot match
And User enters login as "testlogin"
And USer enters email as "test@test.com"
When User enters password as "testpassword"
And User enters confirm password as "testconfirmpassword"
Then User should receive an error message "The password and its confirmation do not match!" for Registering a New User


