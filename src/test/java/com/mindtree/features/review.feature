Feature: checking the review writing 

Scenario Outline: write review for a product in home decor 

	Given browser will be started 
	And navigated to "<url>" 
	When hovers on home and lifestyle then selects home decor to navigate to it 
	Then it clicks on bonsai led lights and gets information 
	And writes a review about the product by giving "<name>" "<email>" "<title>" "<body>" 
	
	Examples: 
		|url	|name	|email	|title	|body	|
		|https://www.bigsmall.in/	|abcd	|abcd@gmail.com	|Good Product	|Very beautiful when kept on top of the table	|