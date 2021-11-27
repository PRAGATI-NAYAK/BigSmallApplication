Feature: Adding more than one product to cart 

Scenario Outline: adding two cute lapel pins to the cart 

	Given that browser will start 
	And it will navigate to "<url>" 
	And hovers on shop by category and clicks on lapel pins and brooches and navigates to that page 
	When it selects the harry potter pins navigates to the page and adds pin to cart 
	Then it will come back to pins page selects minions pins and adds it to cart 
	
	Examples: 
		|url	|
		|https://www.bigsmall.in/	|