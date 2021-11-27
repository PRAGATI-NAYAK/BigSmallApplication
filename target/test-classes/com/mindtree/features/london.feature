Feature: Checking for an official merchandise 

Scenario Outline: checking out the luckies of london products 

	Given browser starts again 
	And has navigated to "<url>" 
	And hovers on official merchandise and clicks on luckies of london 
	When it navigates to that page it clicks on chalkboard map diy and gets its information 
	Then it should check the old price and new price and the difference of them 
	
	
	Examples: 
		|url	|
		|https://www.bigsmall.in/	|