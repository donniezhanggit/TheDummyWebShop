Feature: Entities Overview 

Background: User is Logged in with valid credentials
Given User opens Application in Browser
And User clicks on Login Button
And User enters valid credentials
		| username  | password  |
         | admin     | admin     | 
And User is able to login to the Application 

@EntityOverview
Scenario: Verify whether user is able to view Branch and Staff in the Entities Menu
When User clicks on Entities Menu 
Then User should be able to view Branch and Staff values in the Entity list

@EntityOverview
Scenario Outline: Verify whether user is able to create new Entity  
And User opens Entities Menu
And User selects "<entity>" Menu
When User creates a new "<entity>" entry with name "<name>"
Then User should be able to see the created entry in the "<entity>" list with name "<name>"
When User clicks on View Button for "<entity>"
Then User should be able to see the specific "<entity>" with name "<name>"
When User clicks on Edit Button for "<entity>"
Then User should be able to edit the specific "<entity>" having "<name>" with name "<editedname>"
When User clicks on Delete Button for "<entity>"
Then User should be able to Delete the specific "<entity>" with name "<editedname>"
Examples:
	|entity|name|editedname|
	|Branch|Computer Science|Electronics|
	|Staff|Akshat Narang|TestStaff|


@EntityOverview
Scenario Outline: Verify whether a Branch or Staff entry is not created when Cancel Button is pressed 
And User opens Entities Menu
And User selects "<entity>" Menu
When User clicks on create "<entity>" entry with name "<name>"
And Clicks on Cancel Button for "<entity>"
Then User should not see the cancelled entry for respective "<entity>"
Examples:
	|entity|name|
	|Branch|Computer Science|
	|Staff|Akshat Narang|

@EntityOverview
Scenario Outline: Verify whether a user receives an error message when the Branch or Staff name is not in expected format 
And User opens Entities Menu
And User selects "<entity>" Menu
When User clicks on create "<entity>" entry with name "<name>"
Then User should receive an error message "<errormessage>" for the incorrect name format for the respective "<entity>"
Examples:
	|entity|name|errormessage|
	|Staff|Akshat Narang|This field is required.|
	|Staff|aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa|This field cannot be longer than 50 characters.|
	|Staff|Akshat1Narang|This field should follow pattern ^[a-zA-Z\\s]*$.|
	#|Staff|Akshat Narang|This field should follow pattern ^[a-zA-Z\\s]*$.|

@EntityOverview
Scenario Outline: Verify whether a user receives an error message when the Branch or Staff name is not in expected format 
And User opens Entities Menu
And User selects "<entity>" Menu
When User searches for a "<entity>" using "<name>"
Then User should be able to view a list of all the matching results
Examples:
	|entity|name|
	|Branch|Computer Science|
	|Staff|Akshat Narang|

@EntityOverview
Scenario Outline: Verify whether a user receives an error message when the Branch or Staff name is not in expected format 
And User opens Entities Menu
And User selects "<entity>" Menu
When User searches for a "<entity>" using "<id>"
Then User should be able to view a list of all the matching results
Examples:
	|entity|name|
	|Branch|1|
	|Staff|1|
	
@EntityOverview
Scenario Outline: Verify whether a user receives an error message when the Branch or Staff name is not in expected format 
And User opens Entities Menu
And User selects "<entity>" Menu
When User searches for a "<entity>" using "<code>"
Then User should be able to view a list of all the matching results
Examples:
	|entity|code|
	|Branch|CSE|
	|Staff||

