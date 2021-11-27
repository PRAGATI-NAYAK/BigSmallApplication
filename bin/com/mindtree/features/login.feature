Feature: Checking log in feature 

Scenario Outline: checking if a person can log in to their account 

	Given browser start 
	And navigate to the"<url>" 
	And clicks on sign in on home page 
	When navigates to that page enter "<email>" and "<password>" 
	Then it should click on login 
	
	Examples: 
		|url	|email	|password	|
		|https://www.bigsmall.in/	|pragatiaravind1999@gmail.com	|pragati@aravind	|