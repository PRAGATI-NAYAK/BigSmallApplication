Feature: Checking Rakhi gifts 

Scenario Outline: to gift rakhi along with addons 

	Given that browser would start 
	And it would navigate to "<url>" 
	And clicks on rakhi gifts link and goes to rakhi gifts page 
	When it selects the bhaiya ciao rakhi in rakhi gifts results it goes to that page 
	Then it should add some given add ons to cart along with rakhi 
	
	Examples: 
		|url	|
		|https://www.bigsmall.in/	|