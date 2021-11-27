Feature: Checking out gift card feature 

Scenario Outline: gifting a gift card worth Rs.40,000 
	Given browser has started 
	And it navigates to "<url>" 
	When clicks on gift card icon and navigates to gift card page 
	Then it adds four gift card worth 10k and adds it to cart 
	
	
	Examples: 
		|url	|
		|https://www.bigsmall.in/	|