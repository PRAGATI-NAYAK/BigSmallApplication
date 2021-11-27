Feature: Creating an Account 

Scenario Outline: checking out account creation when someone is new to the website

	Given start the browser 
	And navigate to website "<url>" 
	And clicks on sign in on home page navigates to the page clicks on create account
	When it navigates to create account it should give "<firstname>" "<lastname>" "<email>" and "<password>" 
	Then it should click on create account and logged in 
	And when clicked on my account it should go to that page and click on log out
	
	Examples: 
		|url	|firstname	|lastname	|email	|password	|
		|https://www.bigsmall.in/	|first	|last	|firstlast@gmail.com	|firstlast	|