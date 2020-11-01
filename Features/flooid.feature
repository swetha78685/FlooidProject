@flooid

Feature: Validate Flooid Website

Scenario: Testing that you can enter a search into google and Google will return results
Given launch the google application 
When Search text as flooid coventry phone number
Then Validate the search results

Scenario: List 10 top websites that contains the phone number of Flooid Coventry and validate any website has details other than Flooid
Given launch the google application 
When Search text as flooid coventry phone number
Then Enter Coventry Phone Number in search box
Then Validate the top 10 websites
Then Click on any website other than Flooid
Then Validate the website details other than Flooid from search results