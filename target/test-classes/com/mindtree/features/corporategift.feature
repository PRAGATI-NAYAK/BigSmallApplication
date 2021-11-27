Feature: Checking for a corporate gift 

Scenario Outline: checking out a useful corporate gift 

	Given starting browser 
	And navigating to "<url>" 
	And clicks on corporate gifts it navigates to corporate page 
	When clicks on Astro Stationery And Phone Holder it displays the information about it 
	Then it should check the reviews and add to wishlist 
	
	Examples: 
		|url	|
		|https://www.bigsmall.in/	|