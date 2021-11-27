Feature: Checking out search text box 

Scenario Outline: finding some unique characters figures 
	Given browser will start 
	And will navigate to "<url>" 
	When clicks on search box and enters "<search-item>" and navigates to search results page 
	Then it selects item in results and clicks on it to navigate to that page 
	And it selects particular requirements and checks if cod is available on code "<postalcode>" 
	
	
	Examples: 
		|url	|search-item	|postalcode	|
		|https://www.bigsmall.in/	|BTS Action Figure - Set of 7	|560057	|