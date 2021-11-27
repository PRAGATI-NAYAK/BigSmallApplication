Feature: Checking for a new product 

Scenario Outline: checking the new product and adding to cart 

	Given browser starts 
	And navigates to "<url>" 
	And clicks on whats new it navigates to new page 
	When clicks on Star and Moon Curtain LED Lights it displays the information about it 
	Then it should check the price and add to cart with gift wrap 
	And give shipping details 
	
	Examples: 
		|url	|
		|https://www.bigsmall.in/	|