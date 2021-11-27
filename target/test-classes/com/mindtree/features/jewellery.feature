Feature: Checking out shop by category 

Scenario Outline: checking out the jewellery category 

	Given starting the browser 
	And navigating to the "<url>" 
	When hovers on shop by category and goes to and clicks on it navigates to jewellery page 
	Then it finds exclusive products it should display the title of it 
	
	
	Examples: 
		|url	|
		|https://www.bigsmall.in/	|