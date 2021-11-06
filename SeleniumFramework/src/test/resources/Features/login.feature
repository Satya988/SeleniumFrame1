@regression
Feature: Login page

Scenario Outline: Check login functionality

Given is on login page
When user enters <username> and <password>
And clicks on login button
Then Lands on the home page

Examples:

|username|password|
|user1|12345|
|user2|12345|
