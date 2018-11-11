# new feature
# Tags: optional
    
Feature:Serve coffee
Scenario: test

Scenario: Buy last coffee
Given there are 1 coffees left in the machine
When I press the coffee button
Then I should be served a coffee
